package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.tencent.matrix.resource.analyzer.model.f;
import com.tencent.matrix.resource.d.a.a;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class c
{
  private final d cIC;
  final Context mContext;
  private final Handler mMainHandler;
  
  public c(Context paramContext, d paramd)
  {
    this(paramContext, paramd, new Handler(Looper.getMainLooper()));
  }
  
  private c(Context paramContext, d paramd, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.cIC = paramd;
    this.mMainHandler = paramHandler;
  }
  
  public final File IM()
  {
    File localFile = this.cIC.IN();
    if (localFile == null)
    {
      com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "hprof file is null.", new Object[0]);
      return null;
    }
    Object localObject = localFile.getParentFile();
    if (localObject == null)
    {
      com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "hprof file path: %s does not indicate a full path.", new Object[] { localFile.getAbsolutePath() });
      return null;
    }
    if (!((File)localObject).canWrite())
    {
      com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "hprof file path: %s cannot be written.", new Object[] { localFile.getAbsolutePath() });
      return null;
    }
    localObject = new a();
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        final Toast localToast = new Toast(c.this.mContext);
        localToast.setDuration(1);
        localToast.setGravity(16, 0, 0);
        localToast.setView(LayoutInflater.from(c.this.mContext).inflate(2131495267, null));
        localToast.show();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            a locala = c.1.this.cIL;
            Toast localToast = localToast;
            locala.cIv.set(localToast);
            locala.cIw.countDown();
            return false;
          }
        });
      }
    });
    if (!((a)localObject).a(TimeUnit.SECONDS))
    {
      com.tencent.matrix.g.c.w("Matrix.AndroidHeapDumper", "give up dumping heap, waiting for toast too long.", new Object[0]);
      return null;
    }
    try
    {
      Debug.dumpHprofData(localFile.getAbsolutePath());
      if (((a)localObject).cIw.getCount() > 0L) {
        throw new IllegalStateException("Call wait() and check its result");
      }
    }
    catch (Exception localException)
    {
      com.tencent.matrix.g.c.printErrStackTrace("Matrix.AndroidHeapDumper", localException, "failed to dump heap into file: %s.", new Object[] { localFile.getAbsolutePath() });
      return null;
    }
    final Toast localToast = (Toast)localException.cIv.get();
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        localToast.cancel();
      }
    });
    return localFile;
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.e.c
 * JD-Core Version:    0.7.0.1
 */