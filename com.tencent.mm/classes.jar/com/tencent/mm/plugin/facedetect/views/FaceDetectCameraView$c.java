package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class FaceDetectCameraView$c
  implements FaceDetectCameraView.b
{
  m jUe = null;
  Camera.PreviewCallback jUf = new FaceDetectCameraView.c.3(this);
  private d.b jUg = new FaceDetectCameraView.c.4(this);
  
  private FaceDetectCameraView$c(FaceDetectCameraView paramFaceDetectCameraView)
  {
    this.jUe = new m(paramFaceDetectCameraView.getContext());
    FaceDetectCameraView.a(paramFaceDetectCameraView, -1L);
    FaceDetectCameraView.d(paramFaceDetectCameraView);
  }
  
  public final void a(c arg1)
  {
    FaceDetectCameraView.a(this.jUa, ???);
    synchronized (FaceDetectCameraView.e(this.jUa))
    {
      if (this.jUe == null)
      {
        y.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
        return;
      }
      if (this.jUe.jOC)
      {
        y.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
        FaceDetectCameraView.f(this.jUa);
        return;
      }
    }
    FaceDetectCameraView.g(this.jUa);
    if (!FaceDetectCameraView.h(this.jUa))
    {
      if (this.jUa.isAvailable())
      {
        y.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
        this.jUa.onSurfaceTextureAvailable(this.jUa.getSurfaceTexture(), this.jUa.getWidth(), this.jUa.getHeight());
        return;
      }
      y.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
      return;
    }
    e.post(new FaceDetectCameraView.c.1(this, bk.UZ()), "FaceDetectCameraView_Camera");
  }
  
  public final void aPr()
  {
    if (!FaceDetectCameraView.m(this.jUa))
    {
      FaceDetectCameraView.b(this.jUa, true);
      e.post(new Runnable()
      {
        public final void run()
        {
          d locald;
          synchronized (FaceDetectCameraView.e(FaceDetectCameraView.c.this.jUa))
          {
            if (FaceDetectCameraView.c.this.jUe == null) {
              return;
            }
            y.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
            FaceDetectCameraView.c.this.jUe.setPreviewCallback(null);
            locald = d.aOf();
          }
          synchronized (d.mLock)
          {
            if (locald.jND != null) {
              locald.jND.clear();
            }
            if (FaceDetectCameraView.l(FaceDetectCameraView.c.this.jUa) != null) {
              FaceDetectCameraView.l(FaceDetectCameraView.c.this.jUa).release();
            }
            FaceDetectCameraView.c.this.jUe.release();
            FaceDetectCameraView.c.this.jUe = null;
            y.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
            FaceDetectCameraView.b(FaceDetectCameraView.c.this.jUa, false);
            return;
            localObject3 = finally;
            throw localObject3;
          }
        }
      }, "FaceDetectCameraView_Camera");
    }
  }
  
  public final void aPs()
  {
    synchronized (FaceDetectCameraView.e(this.jUa))
    {
      if ((this.jUe != null) && (this.jUe.jOC))
      {
        d.aOf().b(this.jUg);
        if (!FaceDetectCameraView.n(this.jUa)) {
          FaceDetectCameraView.a(this.jUa, null);
        }
      }
      return;
    }
  }
  
  public final Point aPt()
  {
    synchronized (FaceDetectCameraView.e(this.jUa))
    {
      Point localPoint = this.jUe.jOK;
      return localPoint;
    }
  }
  
  public final void em(long paramLong)
  {
    for (;;)
    {
      synchronized (FaceDetectCameraView.e(this.jUa))
      {
        if (this.jUe == null)
        {
          y.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
          return;
        }
        y.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", new Object[] { Long.valueOf(paramLong) });
        FaceDetectCameraView.b(this.jUa, paramLong);
        if (FaceDetectCameraView.q(this.jUa)) {
          break label144;
        }
        if ((this.jUe != null) && (this.jUe.jOC))
        {
          y.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
          FaceDetectCameraView.a(this.jUa, false);
          d.aOf().a(this.jUg);
          FaceDetectCameraView.r(this.jUa);
          return;
        }
      }
      y.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
      FaceDetectCameraView.a(this.jUa, true);
      continue;
      label144:
      y.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
    }
  }
  
  public final int getPreviewHeight()
  {
    synchronized (FaceDetectCameraView.e(this.jUa))
    {
      int i = this.jUe.getPreviewHeight();
      return i;
    }
  }
  
  public final int getPreviewWidth()
  {
    synchronized (FaceDetectCameraView.e(this.jUa))
    {
      int i = this.jUe.getPreviewWidth();
      return i;
    }
  }
  
  public final int getRotation()
  {
    synchronized (FaceDetectCameraView.e(this.jUa))
    {
      int i = this.jUe.jOH;
      return i;
    }
  }
  
  public final void stopPreview()
  {
    synchronized (FaceDetectCameraView.e(this.jUa))
    {
      if ((this.jUe != null) && (this.jUe.jOC))
      {
        m localm = this.jUe;
        if (localm.dwJ != null)
        {
          localm.dwJ.stopPreview();
          localm.jOC = false;
          com.tencent.mm.plugin.facedetect.model.c.jNB.ET();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c
 * JD-Core Version:    0.7.0.1
 */