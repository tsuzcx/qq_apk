package com.tencent.matrix.resource.c;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.tencent.matrix.e.c;
import com.tencent.matrix.resource.analyzer.model.f;
import com.tencent.matrix.resource.b.b;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
  private final b fbr;
  final Context mContext;
  private final Handler mMainHandler;
  
  public a(Context paramContext, b paramb)
  {
    this(paramContext, paramb, new Handler(Looper.getMainLooper()));
  }
  
  private a(Context paramContext, b paramb, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.fbr = paramb;
    this.mMainHandler = paramHandler;
  }
  
  public final File dK(boolean paramBoolean)
  {
    File localFile = this.fbr.azo();
    if (localFile == null)
    {
      c.w("Matrix.AndroidHeapDumper", "hprof file is null.", new Object[0]);
      return null;
    }
    Object localObject = localFile.getParentFile();
    if (localObject == null)
    {
      c.w("Matrix.AndroidHeapDumper", "hprof file path: %s does not indicate a full path.", new Object[] { localFile.getAbsolutePath() });
      return null;
    }
    if (!((File)localObject).canWrite())
    {
      c.w("Matrix.AndroidHeapDumper", "hprof file path: %s cannot be written.", new Object[] { localFile.getAbsolutePath() });
      return null;
    }
    if (((File)localObject).getFreeSpace() < 1610612736.0D)
    {
      c.w("Matrix.AndroidHeapDumper", "hprof file path: %s free space not enough", new Object[] { ((File)localObject).getAbsolutePath() });
      return null;
    }
    if (paramBoolean)
    {
      localObject = new com.tencent.matrix.resource.e.a.a();
      this.mMainHandler.post(new Runnable()
      {
        public final void run()
        {
          final Toast localToast = new Toast(a.this.mContext);
          localToast.setDuration(1);
          localToast.setGravity(16, 0, 0);
          localToast.setView(LayoutInflater.from(a.this.mContext).inflate(b.b.resource_canary_toast_wait_for_heapdump, null));
          localToast.show();
          Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
          {
            public final boolean queueIdle()
            {
              com.tencent.matrix.resource.e.a.a locala = a.1.this.fbs;
              Toast localToast = localToast;
              locala.fcn.set(localToast);
              locala.fco.countDown();
              return false;
            }
          });
        }
      });
      if (!((com.tencent.matrix.resource.e.a.a)localObject).a(TimeUnit.SECONDS))
      {
        c.w("Matrix.AndroidHeapDumper", "give up dumping heap, waiting for toast too long.", new Object[0]);
        return null;
      }
      try
      {
        Debug.dumpHprofData(localFile.getAbsolutePath());
        if (((com.tencent.matrix.resource.e.a.a)localObject).fco.getCount() > 0L) {
          throw new IllegalStateException("Call wait() and check its result");
        }
      }
      catch (Exception localException1)
      {
        c.printErrStackTrace("Matrix.AndroidHeapDumper", localException1, "failed to dump heap into file: %s.", new Object[] { localFile.getAbsolutePath() });
        return null;
      }
      final Toast localToast = (Toast)localException1.fcn.get();
      this.mMainHandler.post(new Runnable()
      {
        public final void run()
        {
          localToast.cancel();
        }
      });
      return localFile;
    }
    try
    {
      Debug.dumpHprofData(localFile.getAbsolutePath());
      return localFile;
    }
    catch (Exception localException2)
    {
      c.printErrStackTrace("Matrix.AndroidHeapDumper", localException2, "failed to dump heap into file: %s.", new Object[] { localFile.getAbsolutePath() });
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a
 * JD-Core Version:    0.7.0.1
 */