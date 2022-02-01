package com.tencent.mm.media.widget.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class f
{
  final String TAG;
  boolean lbD;
  d.a.a lbE;
  final Object lock;
  
  public f()
  {
    AppMethodBeat.i(94063);
    this.TAG = "MicroMsg.SightCamera.OpenCameraThread";
    this.lock = new Object();
    AppMethodBeat.o(94063);
  }
  
  public final d.a.a M(final Context paramContext, int paramInt)
  {
    AppMethodBeat.i(259238);
    if (paramContext == null)
    {
      AppMethodBeat.o(259238);
      return null;
    }
    long l1 = Util.nowMilliSecond();
    ??? = Thread.currentThread();
    p.j(???, "Thread.currentThread()");
    final long l2 = ((Thread)???).getId();
    synchronized (this.lock)
    {
      this.lbD = false;
      this.lbE = null;
      ThreadPool.post((Runnable)new a(this, l2, l1, paramContext, paramInt), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.lbE != null)
        {
          paramContext = this.lbE;
          if (paramContext == null) {
            p.iCn();
          }
          if (paramContext.jqD != null)
          {
            paramContext = this.TAG;
            long l3 = Util.nowMilliSecond();
            d.a.a locala = this.lbE;
            if (locala == null) {
              p.iCn();
            }
            Log.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), locala.jqD });
            paramContext = this.lbE;
            AppMethodBeat.o(259238);
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
    this.lbD = true;
    Log.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(Util.nowMilliSecond() - l1) });
    AppMethodBeat.o(259238);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
  static final class a
    implements Runnable
  {
    a(f paramf, long paramLong1, long paramLong2, Context paramContext, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(94061);
      ??? = this.lbF.TAG;
      long l = l2;
      Object localObject2 = Thread.currentThread();
      p.j(localObject2, "Thread.currentThread()");
      Log.i((String)???, "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[] { Long.valueOf(l), Long.valueOf(((Thread)localObject2).getId()), Long.valueOf(Util.nowMilliSecond() - paramContext) });
      synchronized (this.lbF.lock)
      {
        try
        {
          this.lbF.lbE = d.a(this.$context$inlined, this.lbI, this.lbJ);
          if ((this.lbF.lbD) && (this.lbF.lbE != null)) {
            Log.e(this.lbF.TAG, "thread time out now, release camera :%d ", new Object[] { Long.valueOf(Util.nowMilliSecond() - paramContext) });
          }
          try
          {
            localObject2 = this.lbF.lbE;
            if (localObject2 == null) {
              p.iCn();
            }
            localObject2 = ((d.a.a)localObject2).jqD;
            ((w)localObject2).a(null);
            ((w)localObject2).TL();
            ((w)localObject2).release();
            this.lbF.lbE = null;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.e(this.lbF.TAG, "realease Camera failed e:%s", new Object[] { localException2.getMessage() });
            }
          }
          this.lbF.lock.notify();
          localObject2 = x.aazN;
          AppMethodBeat.o(94061);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e(this.lbF.TAG, "openCamera failed e:%s", new Object[] { localException1.getMessage() });
            this.lbF.lbE = null;
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