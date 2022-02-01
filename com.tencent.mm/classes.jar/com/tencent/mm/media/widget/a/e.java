package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class e
{
  final String TAG;
  boolean imC;
  d.a.a imD;
  final Object lock;
  
  public e()
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
    long l1 = Util.nowMilliSecond();
    ??? = Thread.currentThread();
    p.g(???, "Thread.currentThread()");
    final long l2 = ((Thread)???).getId();
    synchronized (this.lock)
    {
      this.imC = false;
      this.imD = null;
      ThreadPool.post((Runnable)new a(this, l2, l1, paramContext, paramInt, paramLooper), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.imD != null)
        {
          paramContext = this.imD;
          if (paramContext == null) {
            p.hyc();
          }
          if (paramContext.gGr != null)
          {
            paramContext = this.TAG;
            long l3 = Util.nowMilliSecond();
            paramLooper = this.imD;
            if (paramLooper == null) {
              p.hyc();
            }
            Log.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), paramLooper.gGr });
            paramContext = this.imD;
            AppMethodBeat.o(94062);
            return paramContext;
          }
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;)
        {
          Log.e(this.TAG, "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    this.imC = true;
    Log.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(Util.nowMilliSecond() - l1) });
    AppMethodBeat.o(94062);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
  static final class a
    implements Runnable
  {
    a(e parame, long paramLong1, long paramLong2, Context paramContext, int paramInt, Looper paramLooper) {}
    
    public final void run()
    {
      AppMethodBeat.i(94061);
      ??? = this.imE.TAG;
      long l = l2;
      Object localObject2 = Thread.currentThread();
      p.g(localObject2, "Thread.currentThread()");
      Log.i((String)???, "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[] { Long.valueOf(l), Long.valueOf(((Thread)localObject2).getId()), Long.valueOf(Util.nowMilliSecond() - paramContext) });
      synchronized (this.imE.lock)
      {
        try
        {
          this.imE.imD = d.a(paramLooper, this.imH, this.imI);
          if ((this.imE.imC) && (this.imE.imD != null)) {
            Log.e(this.imE.TAG, "thread time out now, release camera :%d ", new Object[] { Long.valueOf(Util.nowMilliSecond() - paramContext) });
          }
          try
          {
            localObject2 = this.imE.imD;
            if (localObject2 == null) {
              p.hyc();
            }
            localObject2 = ((d.a.a)localObject2).gGr;
            ((v)localObject2).setPreviewCallback(null);
            ((v)localObject2).stopPreview();
            ((v)localObject2).release();
            this.imE.imD = null;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.e(this.imE.TAG, "realease Camera failed e:%s", new Object[] { localException2.getMessage() });
            }
          }
          this.imE.lock.notify();
          localObject2 = x.SXb;
          AppMethodBeat.o(94061);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e(this.imE.TAG, "openCamera failed e:%s", new Object[] { localException1.getMessage() });
            this.imE.imD = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.e
 * JD-Core Version:    0.7.0.1
 */