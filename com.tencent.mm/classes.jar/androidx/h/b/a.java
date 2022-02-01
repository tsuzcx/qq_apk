package androidx.h.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.c.d;
import androidx.core.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a<D>
  extends b<D>
{
  static final boolean DEBUG = false;
  static final String TAG = "AsyncTaskLoader";
  volatile a<D>.a mCancellingTask;
  private final Executor mExecutor;
  Handler mHandler;
  long mLastLoadCompleteTime = -10000L;
  volatile a<D>.a mTask;
  long mUpdateThrottle;
  
  public a(Context paramContext)
  {
    this(paramContext, c.bIO);
  }
  
  private a(Context paramContext, Executor paramExecutor)
  {
    super(paramContext);
    this.mExecutor = paramExecutor;
  }
  
  public void cancelLoadInBackground() {}
  
  void dispatchOnCancelled(a<D>.a parama, D paramD)
  {
    onCanceled(paramD);
    if (this.mCancellingTask == parama)
    {
      rollbackContentChanged();
      this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
      this.mCancellingTask = null;
      deliverCancellation();
      executePendingTask();
    }
  }
  
  void dispatchOnLoadComplete(a<D>.a parama, D paramD)
  {
    if (this.mTask != parama)
    {
      dispatchOnCancelled(parama, paramD);
      return;
    }
    if (isAbandoned())
    {
      onCanceled(paramD);
      return;
    }
    commitContentChanged();
    this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
    this.mTask = null;
    deliverResult(paramD);
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.mTask != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(this.mTask);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.mTask.bIK);
    }
    if (this.mCancellingTask != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.mCancellingTask);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.mCancellingTask.bIK);
    }
    if (this.mUpdateThrottle != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      g.b(this.mUpdateThrottle, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      g.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }
  
  void executePendingTask()
  {
    if ((this.mCancellingTask == null) && (this.mTask != null))
    {
      if (this.mTask.bIK)
      {
        this.mTask.bIK = false;
        this.mHandler.removeCallbacks(this.mTask);
      }
      if ((this.mUpdateThrottle > 0L) && (SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle))
      {
        this.mTask.bIK = true;
        this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
      }
    }
    else
    {
      return;
    }
    a locala = this.mTask;
    Executor localExecutor = this.mExecutor;
    if (locala.bIT != c.c.bJb)
    {
      switch (c.4.bIY[locala.bIT.ordinal()])
      {
      default: 
        throw new IllegalStateException("We should never reach this state");
      case 1: 
        throw new IllegalStateException("Cannot execute task: the task is already running.");
      }
      throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }
    locala.bIT = c.c.bJc;
    locala.bIR.bJf = null;
    localExecutor.execute(locala.bIS);
  }
  
  public boolean isLoadInBackgroundCanceled()
  {
    return this.mCancellingTask != null;
  }
  
  public abstract D loadInBackground();
  
  protected boolean onCancelLoad()
  {
    if (this.mTask != null)
    {
      if (!this.mStarted) {
        this.mContentChanged = true;
      }
      if (this.mCancellingTask != null)
      {
        if (this.mTask.bIK)
        {
          this.mTask.bIK = false;
          this.mHandler.removeCallbacks(this.mTask);
        }
        this.mTask = null;
      }
    }
    else
    {
      return false;
    }
    if (this.mTask.bIK)
    {
      this.mTask.bIK = false;
      this.mHandler.removeCallbacks(this.mTask);
      this.mTask = null;
      return false;
    }
    a locala = this.mTask;
    locala.bIU.set(true);
    boolean bool = locala.bIS.cancel(false);
    if (bool)
    {
      this.mCancellingTask = this.mTask;
      cancelLoadInBackground();
    }
    this.mTask = null;
    return bool;
  }
  
  public void onCanceled(D paramD) {}
  
  protected void onForceLoad()
  {
    super.onForceLoad();
    cancelLoad();
    this.mTask = new a();
    executePendingTask();
  }
  
  protected D onLoadInBackground()
  {
    return loadInBackground();
  }
  
  public void setUpdateThrottle(long paramLong)
  {
    this.mUpdateThrottle = paramLong;
    if (paramLong != 0L) {
      this.mHandler = new Handler();
    }
  }
  
  public void waitForLoader()
  {
    a locala = this.mTask;
    if (locala != null) {}
    try
    {
      locala.bIJ.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  final class a
    extends c<Void, Void, D>
    implements Runnable
  {
    final CountDownLatch bIJ;
    boolean bIK;
    
    a()
    {
      AppMethodBeat.i(193163);
      this.bIJ = new CountDownLatch(1);
      AppMethodBeat.o(193163);
    }
    
    private D Ht()
    {
      AppMethodBeat.i(193167);
      try
      {
        Object localObject = a.this.onLoadInBackground();
        AppMethodBeat.o(193167);
        return localObject;
      }
      catch (d locald)
      {
        if (!this.bIU.get())
        {
          AppMethodBeat.o(193167);
          throw locald;
        }
        AppMethodBeat.o(193167);
      }
      return null;
    }
    
    protected final void onCancelled(D paramD)
    {
      AppMethodBeat.i(193180);
      try
      {
        a.this.dispatchOnCancelled(this, paramD);
        return;
      }
      finally
      {
        this.bIJ.countDown();
        AppMethodBeat.o(193180);
      }
    }
    
    protected final void onPostExecute(D paramD)
    {
      AppMethodBeat.i(193175);
      try
      {
        a.this.dispatchOnLoadComplete(this, paramD);
        return;
      }
      finally
      {
        this.bIJ.countDown();
        AppMethodBeat.o(193175);
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(193186);
      this.bIK = false;
      a.this.executePendingTask();
      AppMethodBeat.o(193186);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.h.b.a
 * JD-Core Version:    0.7.0.1
 */