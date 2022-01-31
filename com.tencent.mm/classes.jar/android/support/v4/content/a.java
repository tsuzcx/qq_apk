package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.f.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a<D>
  extends c<D>
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
    this(paramContext, e.THREAD_POOL_EXECUTOR);
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
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.mTask != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(this.mTask);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.mTask.yV);
    }
    if (this.mCancellingTask != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.mCancellingTask);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.mCancellingTask.yV);
    }
    if (this.mUpdateThrottle != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      o.b(this.mUpdateThrottle, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      o.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }
  
  void executePendingTask()
  {
    if ((this.mCancellingTask == null) && (this.mTask != null))
    {
      if (this.mTask.yV)
      {
        this.mTask.yV = false;
        this.mHandler.removeCallbacks(this.mTask);
      }
      if ((this.mUpdateThrottle > 0L) && (SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle))
      {
        this.mTask.yV = true;
        this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
      }
    }
    else
    {
      return;
    }
    a.a locala = this.mTask;
    Executor localExecutor = this.mExecutor;
    if (locala.zv != e.c.zC)
    {
      switch (e.4.zz[locala.zv.ordinal()])
      {
      default: 
        throw new IllegalStateException("We should never reach this state");
      case 1: 
        throw new IllegalStateException("Cannot execute task: the task is already running.");
      }
      throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }
    locala.zv = e.c.zD;
    locala.zt.zG = null;
    localExecutor.execute(locala.zu);
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
        if (this.mTask.yV)
        {
          this.mTask.yV = false;
          this.mHandler.removeCallbacks(this.mTask);
        }
        this.mTask = null;
      }
    }
    else
    {
      return false;
    }
    if (this.mTask.yV)
    {
      this.mTask.yV = false;
      this.mHandler.removeCallbacks(this.mTask);
      this.mTask = null;
      return false;
    }
    a.a locala = this.mTask;
    locala.zw.set(true);
    boolean bool = locala.zu.cancel(false);
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
    this.mTask = new a.a(this);
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
    a.a locala = this.mTask;
    if (locala != null) {}
    try
    {
      locala.yU.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.content.a
 * JD-Core Version:    0.7.0.1
 */