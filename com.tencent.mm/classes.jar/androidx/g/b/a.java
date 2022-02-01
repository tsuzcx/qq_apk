package androidx.g.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.f.h;
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
    this(paramContext, c.abg);
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
      paramPrintWriter.println(this.mTask.abc);
    }
    if (this.mCancellingTask != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.mCancellingTask);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.mCancellingTask.abc);
    }
    if (this.mUpdateThrottle != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      h.b(this.mUpdateThrottle, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      h.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }
  
  void executePendingTask()
  {
    if ((this.mCancellingTask == null) && (this.mTask != null))
    {
      if (this.mTask.abc)
      {
        this.mTask.abc = false;
        this.mHandler.removeCallbacks(this.mTask);
      }
      if ((this.mUpdateThrottle > 0L) && (SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle))
      {
        this.mTask.abc = true;
        this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
      }
    }
    else
    {
      return;
    }
    a locala = this.mTask;
    Executor localExecutor = this.mExecutor;
    if (locala.abl != c.c.abt)
    {
      switch (c.4.abq[locala.abl.ordinal()])
      {
      default: 
        throw new IllegalStateException("We should never reach this state");
      case 1: 
        throw new IllegalStateException("Cannot execute task: the task is already running.");
      }
      throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }
    locala.abl = c.c.abu;
    locala.abj.abx = null;
    localExecutor.execute(locala.abk);
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
        if (this.mTask.abc)
        {
          this.mTask.abc = false;
          this.mHandler.removeCallbacks(this.mTask);
        }
        this.mTask = null;
      }
    }
    else
    {
      return false;
    }
    if (this.mTask.abc)
    {
      this.mTask.abc = false;
      this.mHandler.removeCallbacks(this.mTask);
      this.mTask = null;
      return false;
    }
    a locala = this.mTask;
    locala.abm.set(true);
    boolean bool = locala.abk.cancel(false);
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
      locala.abb.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  final class a
    extends c<Void, Void, D>
    implements Runnable
  {
    final CountDownLatch abb;
    boolean abc;
    
    a()
    {
      AppMethodBeat.i(188299);
      this.abb = new CountDownLatch(1);
      AppMethodBeat.o(188299);
    }
    
    private D jp()
    {
      AppMethodBeat.i(188300);
      try
      {
        Object localObject = a.this.onLoadInBackground();
        AppMethodBeat.o(188300);
        return localObject;
      }
      catch (androidx.core.c.a locala)
      {
        if (!this.abm.get())
        {
          AppMethodBeat.o(188300);
          throw locala;
        }
        AppMethodBeat.o(188300);
      }
      return null;
    }
    
    protected final void onCancelled(D paramD)
    {
      AppMethodBeat.i(188305);
      try
      {
        a.this.dispatchOnCancelled(this, paramD);
        return;
      }
      finally
      {
        this.abb.countDown();
        AppMethodBeat.o(188305);
      }
    }
    
    protected final void onPostExecute(D paramD)
    {
      AppMethodBeat.i(188303);
      try
      {
        a.this.dispatchOnLoadComplete(this, paramD);
        return;
      }
      finally
      {
        this.abb.countDown();
        AppMethodBeat.o(188303);
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(188308);
      this.abc = false;
      a.this.executePendingTask();
      AppMethodBeat.o(188308);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.g.b.a
 * JD-Core Version:    0.7.0.1
 */