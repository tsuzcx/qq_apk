package com.tencent.mm.media.widget.a;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
final class f$a
  implements Runnable
{
  f$a(f paramf, long paramLong1, long paramLong2, Context paramContext, int paramInt, Looper paramLooper) {}
  
  public final void run()
  {
    AppMethodBeat.i(13225);
    ??? = this.faM.TAG;
    long l = this.faN;
    Object localObject2 = Thread.currentThread();
    j.p(localObject2, "Thread.currentThread()");
    ab.i((String)???, "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[] { Long.valueOf(l), Long.valueOf(((Thread)localObject2).getId()), Long.valueOf(bo.aoy() - this.faO) });
    synchronized (this.faM.lock)
    {
      try
      {
        this.faM.faL = d.a(this.faP, this.faQ, this.faR);
        if ((this.faM.faK) && (this.faM.faL != null)) {
          ab.e(this.faM.TAG, "thread time out now, release camera :%d ", new Object[] { Long.valueOf(bo.aoy() - this.faO) });
        }
        try
        {
          localObject2 = this.faM.faL;
          if (localObject2 == null) {
            j.ebi();
          }
          localObject2 = ((d.a.a)localObject2).eoH;
          ((u)localObject2).setPreviewCallback(null);
          ((u)localObject2).stopPreview();
          ((u)localObject2).release();
          this.faM.faL = null;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.e(this.faM.TAG, "realease Camera failed e:%s", new Object[] { localException2.getMessage() });
          }
        }
        this.faM.lock.notify();
        localObject2 = y.BMg;
        AppMethodBeat.o(13225);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.e(this.faM.TAG, "openCamera failed e:%s", new Object[] { localException1.getMessage() });
          this.faM.faL = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.f.a
 * JD-Core Version:    0.7.0.1
 */