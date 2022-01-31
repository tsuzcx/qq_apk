package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class FaceDetectCameraView$c$1
  implements Runnable
{
  FaceDetectCameraView$c$1(FaceDetectCameraView.c paramc, long paramLong) {}
  
  public final void run()
  {
    int i = 1;
    AppMethodBeat.i(579);
    synchronized (FaceDetectCameraView.e(this.moB.mot))
    {
      ab.i("MicroMsg.FaceDetectCameraView", "hy: enter worker thread. using %d ms", new Object[] { Long.valueOf(bo.av(this.moA)) });
      long l1 = bo.yB();
      if (this.moB.mox == null)
      {
        ab.e("MicroMsg.FaceDetectCameraView", "hy: already released");
        if (FaceDetectCameraView.i(this.moB.mot) != null) {
          al.d(new FaceDetectCameraView.c.1.1(this));
        }
        AppMethodBeat.o(579);
        return;
      }
      try
      {
        this.moB.mox.miU = new Point(FaceDetectCameraView.j(this.moB.mot), FaceDetectCameraView.k(this.moB.mot));
        Object localObject2 = this.moB.mox;
        if ((((n)localObject2).eoH != null) && (((n)localObject2).miZ)) {}
        for (;;)
        {
          if (i == 0) {
            this.moB.mox.h(FaceDetectCameraView.l(this.moB.mot));
          }
          localObject2 = this.moB.mox.miT;
          FaceDetectCameraView.a(this.moB.mot, (Point)localObject2);
          localObject2 = this.moB.mox;
          SurfaceTexture localSurfaceTexture = FaceDetectCameraView.l(this.moB.mot);
          long l2 = bo.yB();
          if ((((n)localObject2).eoH != null) && (!((n)localObject2).miS))
          {
            if (localSurfaceTexture != null)
            {
              ab.i("MicroMsg.FaceScanCamera", "hy: SurfaceTexture is not null");
              ((n)localObject2).eoH.setPreviewTexture(localSurfaceTexture);
            }
            c.ek(((n)localObject2).getPreviewWidth(), ((n)localObject2).getPreviewHeight());
            ((n)localObject2).eoH.startPreview();
            ((n)localObject2).miS = true;
            ab.d("MicroMsg.FaceScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(bo.av(l2)) });
          }
          this.moB.mox.setPreviewCallback(this.moB.moy);
          if (FaceDetectCameraView.i(this.moB.mot) != null) {
            al.d(new FaceDetectCameraView.c.1.2(this));
          }
          ab.i("MicroMsg.FaceDetectCameraView", "hy: opened and start preview. use: %d ms", new Object[] { Long.valueOf(bo.av(l1)) });
          FaceDetectCameraView.f(this.moB.mot);
          AppMethodBeat.o(579);
          return;
          i = 0;
        }
        localObject3 = finally;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.FaceDetectCameraView", localException, "hy: exception caused", new Object[0]);
        if (FaceDetectCameraView.i(this.moB.mot) != null) {
          al.d(new FaceDetectCameraView.c.1.3(this));
        }
        AppMethodBeat.o(579);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.1
 * JD-Core Version:    0.7.0.1
 */