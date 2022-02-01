package com.tencent.mm.compatible.deviceinfo;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.concurrent.atomic.AtomicInteger;

public final class v
{
  private static final AtomicInteger fDT;
  private static final AtomicInteger fDU;
  public Camera fDV;
  public boolean fDW;
  
  static
  {
    AppMethodBeat.i(155758);
    fDT = new AtomicInteger(0);
    fDU = new AtomicInteger(0);
    AppMethodBeat.o(155758);
  }
  
  public v(Camera paramCamera)
  {
    AppMethodBeat.i(155744);
    this.fDW = false;
    this.fDV = paramCamera;
    if (paramCamera != null)
    {
      fDT.incrementAndGet();
      ad.m("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", new Object[] { fDT, fDU, Boolean.valueOf(this.fDW) });
      if (fDT.get() - fDU.get() > 1)
      {
        ad.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", new Object[] { aj.getProcessName() });
        paramCamera = a.fzh;
        a.lm(61L);
        if (!aj.cbv()) {
          break label148;
        }
        paramCamera = a.fzh;
        a.lm(62L);
      }
      for (;;)
      {
        fDT.set(0);
        fDU.set(0);
        this.fDW = false;
        AppMethodBeat.o(155744);
        return;
        label148:
        if (aj.eFJ())
        {
          paramCamera = a.fzh;
          a.lm(63L);
        }
        else if (aj.isAppBrandProcess())
        {
          paramCamera = a.fzh;
          a.lm(64L);
        }
      }
    }
    ad.m("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
    AppMethodBeat.o(155744);
  }
  
  public final void addCallbackBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155757);
    if (this.fDV != null) {
      this.fDV.addCallbackBuffer(paramArrayOfByte);
    }
    AppMethodBeat.o(155757);
  }
  
  public final void autoFocus(final Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(155752);
    if (this.fDV != null) {
      this.fDV.autoFocus(new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(160384);
          if (!v.this.fDW) {
            paramAutoFocusCallback.onAutoFocus(paramAnonymousBoolean, paramAnonymousCamera);
          }
          AppMethodBeat.o(160384);
        }
      });
    }
    AppMethodBeat.o(155752);
  }
  
  public final void cancelAutoFocus()
  {
    AppMethodBeat.i(155753);
    if (this.fDV != null) {
      this.fDV.cancelAutoFocus();
    }
    AppMethodBeat.o(155753);
  }
  
  public final Camera.Parameters getParameters()
  {
    AppMethodBeat.i(155745);
    if (this.fDV != null)
    {
      Camera.Parameters localParameters = this.fDV.getParameters();
      AppMethodBeat.o(155745);
      return localParameters;
    }
    AppMethodBeat.o(155745);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(155754);
    if (this.fDV != null) {
      try
      {
        this.fDW = true;
        this.fDV.release();
        return;
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.MCamera", "release camera failed cause sometimes native crash while", new Object[] { localException.fillInStackTrace() });
        return;
      }
      finally
      {
        fDU.incrementAndGet();
        ad.m("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", new Object[] { fDT, fDU, Boolean.valueOf(this.fDW) });
        AppMethodBeat.o(155754);
      }
    }
    AppMethodBeat.o(155754);
  }
  
  public final void setDisplayOrientation(int paramInt)
  {
    AppMethodBeat.i(155750);
    if (this.fDV != null) {
      this.fDV.setDisplayOrientation(paramInt);
    }
    AppMethodBeat.o(155750);
  }
  
  public final void setParameters(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(155746);
    if (this.fDV != null) {
      this.fDV.setParameters(paramParameters);
    }
    AppMethodBeat.o(155746);
  }
  
  public final void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155755);
    if (this.fDV != null) {
      this.fDV.setPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(155755);
  }
  
  public final void setPreviewCallbackWithBuffer(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155756);
    if (this.fDV != null) {
      this.fDV.setPreviewCallbackWithBuffer(paramPreviewCallback);
    }
    AppMethodBeat.o(155756);
  }
  
  public final void setPreviewDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(155747);
    if (this.fDV != null) {
      this.fDV.setPreviewDisplay(paramSurfaceHolder);
    }
    AppMethodBeat.o(155747);
  }
  
  public final void setPreviewTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(155748);
    if (this.fDV != null) {
      this.fDV.setPreviewTexture(paramSurfaceTexture);
    }
    AppMethodBeat.o(155748);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(155749);
    if (this.fDV != null) {
      this.fDV.startPreview();
    }
    AppMethodBeat.o(155749);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(155751);
    if (this.fDV != null) {
      this.fDV.stopPreview();
    }
    AppMethodBeat.o(155751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.v
 * JD-Core Version:    0.7.0.1
 */