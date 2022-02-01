package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class f
{
  final String TAG;
  boolean hqj;
  d.a.a hqk;
  final Object lock;
  
  public f()
  {
    AppMethodBeat.i(94063);
    this.TAG = "MicroMsg.SightCamera.OpenCameraThread";
    this.lock = new Object();
    AppMethodBeat.o(94063);
  }
  
  public final d.a.a a(final Context paramContext, int paramInt, final Looper paramLooper)
  {
    AppMethodBeat.i(94062);
    if (paramContext == null)
    {
      AppMethodBeat.o(94062);
      return null;
    }
    long l1 = bt.flT();
    ??? = Thread.currentThread();
    p.g(???, "Thread.currentThread()");
    final long l2 = ((Thread)???).getId();
    synchronized (this.lock)
    {
      this.hqj = false;
      this.hqk = null;
      b.c((Runnable)new a(this, l2, l1, paramContext, paramInt, paramLooper), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.hqk != null)
        {
          paramContext = this.hqk;
          if (paramContext == null) {
            p.gfZ();
          }
          if (paramContext.fYS != null)
          {
            paramContext = this.TAG;
            long l3 = bt.flT();
            paramLooper = this.hqk;
            if (paramLooper == null) {
              p.gfZ();
            }
            ad.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), paramLooper.fYS });
            paramContext = this.hqk;
            AppMethodBeat.o(94062);
            return paramContext;
          }
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;)
        {
          ad.e(this.TAG, "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    this.hqj = true;
    ad.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(bt.flT() - l1) });
    AppMethodBeat.o(94062);
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
  static final class a
    implements Runnable
  {
    a(f paramf, long paramLong1, long paramLong2, Context paramContext, int paramInt, Looper paramLooper) {}
    
    public final void run()
    {
      AppMethodBeat.i(94061);
      ??? = this.hql.TAG;
      long l = l2;
      Object localObject2 = Thread.currentThread();
      p.g(localObject2, "Thread.currentThread()");
      ad.i((String)???, "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[] { Long.valueOf(l), Long.valueOf(((Thread)localObject2).getId()), Long.valueOf(bt.flT() - paramContext) });
      synchronized (this.hql.lock)
      {
        try
        {
          this.hql.hqk = d.a(paramLooper, this.hqp, this.hqq);
          if ((this.hql.hqj) && (this.hql.hqk != null)) {
            ad.e(this.hql.TAG, "thread time out now, release camera :%d ", new Object[] { Long.valueOf(bt.flT() - paramContext) });
          }
          try
          {
            localObject2 = this.hql.hqk;
            if (localObject2 == null) {
              p.gfZ();
            }
            localObject2 = ((d.a.a)localObject2).fYS;
            ((v)localObject2).setPreviewCallback(null);
            ((v)localObject2).stopPreview();
            ((v)localObject2).release();
            this.hql.hqk = null;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.e(this.hql.TAG, "realease Camera failed e:%s", new Object[] { localException2.getMessage() });
            }
          }
          this.hql.lock.notify();
          localObject2 = z.MKo;
          AppMethodBeat.o(94061);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e(this.hql.TAG, "openCamera failed e:%s", new Object[] { localException1.getMessage() });
            this.hql.hqk = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.f
 * JD-Core Version:    0.7.0.1
 */