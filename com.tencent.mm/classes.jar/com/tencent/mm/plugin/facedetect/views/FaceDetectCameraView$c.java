package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class FaceDetectCameraView$c
  implements FaceDetectCameraView.b
{
  n mox;
  Camera.PreviewCallback moy;
  private d.b moz;
  
  private FaceDetectCameraView$c(FaceDetectCameraView paramFaceDetectCameraView)
  {
    AppMethodBeat.i(584);
    this.mox = null;
    this.moy = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(581);
        ab.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
        com.tencent.mm.plugin.facedetect.model.d.bui().aT(paramAnonymousArrayOfByte);
        AppMethodBeat.o(581);
      }
    };
    this.moz = new FaceDetectCameraView.c.4(this);
    this.mox = new n(paramFaceDetectCameraView.getContext());
    FaceDetectCameraView.a(paramFaceDetectCameraView, -1L);
    FaceDetectCameraView.d(paramFaceDetectCameraView);
    AppMethodBeat.o(584);
  }
  
  public final void a(c arg1)
  {
    AppMethodBeat.i(585);
    FaceDetectCameraView.a(this.mot, ???);
    synchronized (FaceDetectCameraView.e(this.mot))
    {
      if (this.mox == null)
      {
        ab.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
        AppMethodBeat.o(585);
        return;
      }
      if (this.mox.miS)
      {
        ab.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
        FaceDetectCameraView.f(this.mot);
        AppMethodBeat.o(585);
        return;
      }
      FaceDetectCameraView.g(this.mot);
      if (FaceDetectCameraView.h(this.mot)) {
        break label178;
      }
      if (this.mot.isAvailable())
      {
        ab.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
        this.mot.onSurfaceTextureAvailable(this.mot.getSurfaceTexture(), this.mot.getWidth(), this.mot.getHeight());
        AppMethodBeat.o(585);
        return;
      }
    }
    ab.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
    AppMethodBeat.o(585);
    return;
    label178:
    com.tencent.mm.sdk.g.d.post(new FaceDetectCameraView.c.1(this, bo.yB()), "FaceDetectCameraView_Camera");
    AppMethodBeat.o(585);
  }
  
  public final void bvj()
  {
    AppMethodBeat.i(592);
    synchronized (FaceDetectCameraView.e(this.mot))
    {
      if ((this.mox != null) && (this.mox.miS))
      {
        com.tencent.mm.plugin.facedetect.model.d.bui().b(this.moz);
        if (!FaceDetectCameraView.n(this.mot)) {
          FaceDetectCameraView.a(this.mot, null);
        }
      }
      AppMethodBeat.o(592);
      return;
    }
  }
  
  public final void bvx()
  {
    AppMethodBeat.i(587);
    if (!FaceDetectCameraView.m(this.mot))
    {
      FaceDetectCameraView.b(this.mot, true);
      com.tencent.mm.sdk.g.d.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(580);
          synchronized (FaceDetectCameraView.e(FaceDetectCameraView.c.this.mot))
          {
            if (FaceDetectCameraView.c.this.mox == null)
            {
              AppMethodBeat.o(580);
              return;
            }
            ab.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
            FaceDetectCameraView.c.this.mox.setPreviewCallback(null);
            com.tencent.mm.plugin.facedetect.model.d locald = com.tencent.mm.plugin.facedetect.model.d.bui();
            synchronized (com.tencent.mm.plugin.facedetect.model.d.mLock)
            {
              if (locald.mhP != null) {
                locald.mhP.clear();
              }
              if (FaceDetectCameraView.l(FaceDetectCameraView.c.this.mot) != null) {
                FaceDetectCameraView.l(FaceDetectCameraView.c.this.mot).release();
              }
              FaceDetectCameraView.c.this.mox.release();
              FaceDetectCameraView.c.this.mox = null;
              ab.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
              FaceDetectCameraView.b(FaceDetectCameraView.c.this.mot, false);
              AppMethodBeat.o(580);
              return;
            }
          }
        }
      }, "FaceDetectCameraView_Camera");
    }
    AppMethodBeat.o(587);
  }
  
  public final Point bvy()
  {
    AppMethodBeat.i(593);
    synchronized (FaceDetectCameraView.e(this.mot))
    {
      Point localPoint = this.mox.mja;
      AppMethodBeat.o(593);
      return localPoint;
    }
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(589);
    synchronized (FaceDetectCameraView.e(this.mot))
    {
      int i = this.mox.getPreviewHeight();
      AppMethodBeat.o(589);
      return i;
    }
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(588);
    synchronized (FaceDetectCameraView.e(this.mot))
    {
      int i = this.mox.getPreviewWidth();
      AppMethodBeat.o(588);
      return i;
    }
  }
  
  public final int getRotation()
  {
    AppMethodBeat.i(590);
    synchronized (FaceDetectCameraView.e(this.mot))
    {
      int i = this.mox.miX;
      AppMethodBeat.o(590);
      return i;
    }
  }
  
  public final void jJ(long paramLong)
  {
    AppMethodBeat.i(591);
    for (;;)
    {
      synchronized (FaceDetectCameraView.e(this.mot))
      {
        if (this.mox == null)
        {
          ab.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
          AppMethodBeat.o(591);
          return;
        }
        ab.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", new Object[] { Long.valueOf(paramLong) });
        FaceDetectCameraView.b(this.mot, paramLong);
        if (!FaceDetectCameraView.q(this.mot))
        {
          if ((this.mox != null) && (this.mox.miS))
          {
            ab.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
            FaceDetectCameraView.a(this.mot, false);
            com.tencent.mm.plugin.facedetect.model.d.bui().a(this.moz);
            FaceDetectCameraView.r(this.mot);
            AppMethodBeat.o(591);
            return;
          }
          ab.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
          FaceDetectCameraView.a(this.mot, true);
        }
      }
      ab.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
    }
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(586);
    synchronized (FaceDetectCameraView.e(this.mot))
    {
      if ((this.mox != null) && (this.mox.miS))
      {
        n localn = this.mox;
        if (localn.eoH != null)
        {
          localn.eoH.stopPreview();
          localn.miS = false;
          com.tencent.mm.plugin.facedetect.model.c.mhN.XJ();
        }
      }
      AppMethodBeat.o(586);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c
 * JD-Core Version:    0.7.0.1
 */