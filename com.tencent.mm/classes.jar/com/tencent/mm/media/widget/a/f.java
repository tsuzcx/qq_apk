package com.tencent.mm.media.widget.a;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class f
{
  final String TAG;
  boolean faK;
  d.a.a faL;
  final Object lock;
  
  public f()
  {
    AppMethodBeat.i(13227);
    this.TAG = "MicroMsg.SightCamera.OpenCameraThread";
    this.lock = new Object();
    AppMethodBeat.o(13227);
  }
  
  public final d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(13226);
    if (paramContext == null)
    {
      AppMethodBeat.o(13226);
      return null;
    }
    long l1 = bo.aoy();
    ??? = Thread.currentThread();
    j.p(???, "Thread.currentThread()");
    long l2 = ((Thread)???).getId();
    synchronized (this.lock)
    {
      this.faK = false;
      this.faL = null;
      d.post((Runnable)new f.a(this, l2, l1, paramContext, paramInt, paramLooper), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.faL != null)
        {
          paramContext = this.faL;
          if (paramContext == null) {
            j.ebi();
          }
          if (paramContext.eoH != null)
          {
            paramContext = this.TAG;
            long l3 = bo.aoy();
            paramLooper = this.faL;
            if (paramLooper == null) {
              j.ebi();
            }
            ab.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), paramLooper.eoH });
            paramContext = this.faL;
            AppMethodBeat.o(13226);
            return paramContext;
          }
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;)
        {
          ab.e(this.TAG, "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    this.faK = true;
    ab.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(bo.aoy() - l1) });
    AppMethodBeat.o(13226);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.f
 * JD-Core Version:    0.7.0.1
 */