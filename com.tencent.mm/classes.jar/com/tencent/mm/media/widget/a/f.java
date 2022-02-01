package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class f
{
  final String TAG;
  boolean gYd;
  d.a.a gYe;
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
    long l1 = bs.eWj();
    ??? = Thread.currentThread();
    k.g(???, "Thread.currentThread()");
    final long l2 = ((Thread)???).getId();
    synchronized (this.lock)
    {
      this.gYd = false;
      this.gYe = null;
      b.c((Runnable)new a(this, l2, l1, paramContext, paramInt, paramLooper), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.gYe != null)
        {
          paramContext = this.gYe;
          if (paramContext == null) {
            k.fOy();
          }
          if (paramContext.fFt != null)
          {
            paramContext = this.TAG;
            long l3 = bs.eWj();
            paramLooper = this.gYe;
            if (paramLooper == null) {
              k.fOy();
            }
            ac.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), paramLooper.fFt });
            paramContext = this.gYe;
            AppMethodBeat.o(94062);
            return paramContext;
          }
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;)
        {
          ac.e(this.TAG, "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    this.gYd = true;
    ac.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(bs.eWj() - l1) });
    AppMethodBeat.o(94062);
    return null;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
  static final class a
    implements Runnable
  {
    a(f paramf, long paramLong1, long paramLong2, Context paramContext, int paramInt, Looper paramLooper) {}
    
    public final void run()
    {
      AppMethodBeat.i(94061);
      ??? = this.gYf.TAG;
      long l = l2;
      Object localObject2 = Thread.currentThread();
      k.g(localObject2, "Thread.currentThread()");
      ac.i((String)???, "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[] { Long.valueOf(l), Long.valueOf(((Thread)localObject2).getId()), Long.valueOf(bs.eWj() - paramContext) });
      synchronized (this.gYf.lock)
      {
        try
        {
          this.gYf.gYe = d.a(paramLooper, this.gYj, this.gYk);
          if ((this.gYf.gYd) && (this.gYf.gYe != null)) {
            ac.e(this.gYf.TAG, "thread time out now, release camera :%d ", new Object[] { Long.valueOf(bs.eWj() - paramContext) });
          }
          try
          {
            localObject2 = this.gYf.gYe;
            if (localObject2 == null) {
              k.fOy();
            }
            localObject2 = ((d.a.a)localObject2).fFt;
            ((v)localObject2).setPreviewCallback(null);
            ((v)localObject2).stopPreview();
            ((v)localObject2).release();
            this.gYf.gYe = null;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ac.e(this.gYf.TAG, "realease Camera failed e:%s", new Object[] { localException2.getMessage() });
            }
          }
          this.gYf.lock.notify();
          localObject2 = y.KTp;
          AppMethodBeat.o(94061);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.e(this.gYf.TAG, "openCamera failed e:%s", new Object[] { localException1.getMessage() });
            this.gYf.gYe = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.f
 * JD-Core Version:    0.7.0.1
 */