package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class f
{
  final String TAG;
  boolean hsX;
  d.a.a hsY;
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
    long l1 = bu.fpO();
    ??? = Thread.currentThread();
    p.g(???, "Thread.currentThread()");
    final long l2 = ((Thread)???).getId();
    synchronized (this.lock)
    {
      this.hsX = false;
      this.hsY = null;
      b.c((Runnable)new a(this, l2, l1, paramContext, paramInt, paramLooper), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.hsY != null)
        {
          paramContext = this.hsY;
          if (paramContext == null) {
            p.gkB();
          }
          if (paramContext.gaZ != null)
          {
            paramContext = this.TAG;
            long l3 = bu.fpO();
            paramLooper = this.hsY;
            if (paramLooper == null) {
              p.gkB();
            }
            ae.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), paramLooper.gaZ });
            paramContext = this.hsY;
            AppMethodBeat.o(94062);
            return paramContext;
          }
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;)
        {
          ae.e(this.TAG, "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    this.hsX = true;
    ae.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(bu.fpO() - l1) });
    AppMethodBeat.o(94062);
    return null;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
  static final class a
    implements Runnable
  {
    a(f paramf, long paramLong1, long paramLong2, Context paramContext, int paramInt, Looper paramLooper) {}
    
    public final void run()
    {
      AppMethodBeat.i(94061);
      ??? = this.hsZ.TAG;
      long l = l2;
      Object localObject2 = Thread.currentThread();
      p.g(localObject2, "Thread.currentThread()");
      ae.i((String)???, "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[] { Long.valueOf(l), Long.valueOf(((Thread)localObject2).getId()), Long.valueOf(bu.fpO() - paramContext) });
      synchronized (this.hsZ.lock)
      {
        try
        {
          this.hsZ.hsY = d.a(paramLooper, this.htd, this.hte);
          if ((this.hsZ.hsX) && (this.hsZ.hsY != null)) {
            ae.e(this.hsZ.TAG, "thread time out now, release camera :%d ", new Object[] { Long.valueOf(bu.fpO() - paramContext) });
          }
          try
          {
            localObject2 = this.hsZ.hsY;
            if (localObject2 == null) {
              p.gkB();
            }
            localObject2 = ((d.a.a)localObject2).gaZ;
            ((v)localObject2).setPreviewCallback(null);
            ((v)localObject2).stopPreview();
            ((v)localObject2).release();
            this.hsZ.hsY = null;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ae.e(this.hsZ.TAG, "realease Camera failed e:%s", new Object[] { localException2.getMessage() });
            }
          }
          this.hsZ.lock.notify();
          localObject2 = z.Nhr;
          AppMethodBeat.o(94061);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ae.e(this.hsZ.TAG, "openCamera failed e:%s", new Object[] { localException1.getMessage() });
            this.hsZ.hsY = null;
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