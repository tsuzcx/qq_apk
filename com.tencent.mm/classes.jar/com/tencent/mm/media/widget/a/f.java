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
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class f
{
  final String TAG;
  boolean gxF;
  d.a.a gxG;
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
    long l1 = bt.eGO();
    ??? = Thread.currentThread();
    k.g(???, "Thread.currentThread()");
    final long l2 = ((Thread)???).getId();
    synchronized (this.lock)
    {
      this.gxF = false;
      this.gxG = null;
      b.c((Runnable)new a(this, l2, l1, paramContext, paramInt, paramLooper), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.gxG != null)
        {
          paramContext = this.gxG;
          if (paramContext == null) {
            k.fvU();
          }
          if (paramContext.fBM != null)
          {
            paramContext = this.TAG;
            long l3 = bt.eGO();
            paramLooper = this.gxG;
            if (paramLooper == null) {
              k.fvU();
            }
            ad.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), paramLooper.fBM });
            paramContext = this.gxG;
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
    this.gxF = true;
    ad.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(bt.eGO() - l1) });
    AppMethodBeat.o(94062);
    return null;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
  static final class a
    implements Runnable
  {
    a(f paramf, long paramLong1, long paramLong2, Context paramContext, int paramInt, Looper paramLooper) {}
    
    public final void run()
    {
      AppMethodBeat.i(94061);
      ??? = this.gxH.TAG;
      long l = l2;
      Object localObject2 = Thread.currentThread();
      k.g(localObject2, "Thread.currentThread()");
      ad.i((String)???, "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[] { Long.valueOf(l), Long.valueOf(((Thread)localObject2).getId()), Long.valueOf(bt.eGO() - paramContext) });
      synchronized (this.gxH.lock)
      {
        try
        {
          this.gxH.gxG = d.a(paramLooper, this.gxL, this.gxM);
          if ((this.gxH.gxF) && (this.gxH.gxG != null)) {
            ad.e(this.gxH.TAG, "thread time out now, release camera :%d ", new Object[] { Long.valueOf(bt.eGO() - paramContext) });
          }
          try
          {
            localObject2 = this.gxH.gxG;
            if (localObject2 == null) {
              k.fvU();
            }
            localObject2 = ((d.a.a)localObject2).fBM;
            ((v)localObject2).setPreviewCallback(null);
            ((v)localObject2).stopPreview();
            ((v)localObject2).release();
            this.gxH.gxG = null;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.e(this.gxH.TAG, "realease Camera failed e:%s", new Object[] { localException2.getMessage() });
            }
          }
          this.gxH.lock.notify();
          localObject2 = y.JfV;
          AppMethodBeat.o(94061);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e(this.gxH.TAG, "openCamera failed e:%s", new Object[] { localException1.getMessage() });
            this.gxH.gxG = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.f
 * JD-Core Version:    0.7.0.1
 */