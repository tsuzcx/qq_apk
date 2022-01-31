package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class FaceDetectCameraView$c$1
  implements Runnable
{
  FaceDetectCameraView$c$1(FaceDetectCameraView.c paramc, long paramLong) {}
  
  public final void run()
  {
    int i = 1;
    long l1;
    synchronized (FaceDetectCameraView.e(this.jUi.jUa))
    {
      y.i("MicroMsg.FaceDetectCameraView", "hy: enter worker thread. using %d ms", new Object[] { Long.valueOf(bk.cp(this.jUh)) });
      l1 = bk.UZ();
      if (this.jUi.jUe == null)
      {
        y.e("MicroMsg.FaceDetectCameraView", "hy: already released");
        if (FaceDetectCameraView.i(this.jUi.jUa) != null) {
          ai.d(new FaceDetectCameraView.c.1.1(this));
        }
        return;
      }
    }
    try
    {
      this.jUi.jUe.jOE = new Point(FaceDetectCameraView.j(this.jUi.jUa), FaceDetectCameraView.k(this.jUi.jUa));
      Object localObject2 = this.jUi.jUe;
      if ((((m)localObject2).dwJ != null) && (((m)localObject2).jOJ)) {}
      for (;;)
      {
        if (i == 0) {
          this.jUi.jUe.h(FaceDetectCameraView.l(this.jUi.jUa));
        }
        localObject2 = this.jUi.jUe.jOD;
        FaceDetectCameraView.a(this.jUi.jUa, (Point)localObject2);
        localObject2 = this.jUi.jUe;
        SurfaceTexture localSurfaceTexture = FaceDetectCameraView.l(this.jUi.jUa);
        long l2 = bk.UZ();
        if ((((m)localObject2).dwJ != null) && (!((m)localObject2).jOC))
        {
          if (localSurfaceTexture != null)
          {
            y.i("MicroMsg.FaceScanCamera", "hy: SurfaceTexture is not null");
            ((m)localObject2).dwJ.setPreviewTexture(localSurfaceTexture);
          }
          c.cM(((m)localObject2).getPreviewWidth(), ((m)localObject2).getPreviewHeight());
          ((m)localObject2).dwJ.startPreview();
          ((m)localObject2).jOC = true;
          y.d("MicroMsg.FaceScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(bk.cp(l2)) });
        }
        this.jUi.jUe.setPreviewCallback(this.jUi.jUf);
        if (FaceDetectCameraView.i(this.jUi.jUa) != null) {
          ai.d(new FaceDetectCameraView.c.1.2(this));
        }
        y.i("MicroMsg.FaceDetectCameraView", "hy: opened and start preview. use: %d ms", new Object[] { Long.valueOf(bk.cp(l1)) });
        FaceDetectCameraView.f(this.jUi.jUa);
        return;
        localObject3 = finally;
        throw localObject3;
        i = 0;
      }
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.FaceDetectCameraView", localIOException, "hy: exception caused", new Object[0]);
      if (FaceDetectCameraView.i(this.jUi.jUa) != null) {
        ai.d(new FaceDetectCameraView.c.1.3(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.1
 * JD-Core Version:    0.7.0.1
 */