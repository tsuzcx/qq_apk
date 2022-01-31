package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.tencent.matrix.d.b;
import com.tencent.matrix.resource.b.a;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class c
{
  private final d bpT;
  final Context mContext;
  private final Handler mMainHandler;
  
  public c(Context paramContext, d paramd)
  {
    this(paramContext, paramd, new Handler(Looper.getMainLooper()));
  }
  
  private c(Context paramContext, d paramd, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.bpT = paramd;
    this.mMainHandler = paramHandler;
  }
  
  public final File rk()
  {
    File localFile = this.bpT.rl();
    if (localFile == null) {}
    for (localFile = null; localFile == null; localFile = new File(localFile, "dump_" + Long.toHexString(((UUID)localObject).getMostSignificantBits()) + Long.toHexString(((UUID)localObject).getLeastSignificantBits()) + ".hprof"))
    {
      b.w("Matrix.AndroidHeapDumper", "hprof file is null.", new Object[0]);
      return null;
      localObject = UUID.randomUUID();
    }
    if (!localFile.getParentFile().canWrite())
    {
      b.w("Matrix.AndroidHeapDumper", "hprof file path: %s cannot be written.", new Object[] { localFile.getAbsolutePath() });
      return null;
    }
    Object localObject = new com.tencent.matrix.resource.d.a.a();
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        final Toast localToast = new Toast(c.this.mContext);
        localToast.setDuration(1);
        localToast.setGravity(16, 0, 0);
        localToast.setView(LayoutInflater.from(c.this.mContext).inflate(b.a.resource_canary_toast_wait_for_heapdump, null));
        localToast.show();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            com.tencent.matrix.resource.d.a.a locala = c.1.this.bqd;
            Toast localToast = localToast;
            locala.bpP.set(localToast);
            locala.bpQ.countDown();
            return false;
          }
        });
      }
    });
    if (!((com.tencent.matrix.resource.d.a.a)localObject).a(TimeUnit.SECONDS))
    {
      b.w("Matrix.AndroidHeapDumper", "give up dumping heap, waiting for toast too long.", new Object[0]);
      return null;
    }
    try
    {
      Debug.dumpHprofData(localFile.getAbsolutePath());
      if (((com.tencent.matrix.resource.d.a.a)localObject).bpQ.getCount() > 0L) {
        throw new IllegalStateException("Call wait() and check its result");
      }
    }
    catch (IOException localIOException)
    {
      b.printErrStackTrace("Matrix.AndroidHeapDumper", localIOException, "failed to dump heap into file: %s.", new Object[] { localFile.getAbsolutePath() });
      return null;
    }
    final Toast localToast = (Toast)localIOException.bpP.get();
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
    public abstract void a(com.tencent.matrix.resource.analyzer.model.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.e.c
 * JD-Core Version:    0.7.0.1
 */