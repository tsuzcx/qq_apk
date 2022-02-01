package com.tencent.mm.compatible.deviceinfo;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.concurrent.atomic.AtomicInteger;

public final class v
{
  private static final AtomicInteger fHA;
  private static final AtomicInteger fHB;
  public Camera fHC;
  public boolean fHD;
  
  static
  {
    AppMethodBeat.i(155758);
    fHA = new AtomicInteger(0);
    fHB = new AtomicInteger(0);
    AppMethodBeat.o(155758);
  }
  
  public v(Camera paramCamera)
  {
    AppMethodBeat.i(155744);
    this.fHD = false;
    this.fHC = paramCamera;
    if (paramCamera != null)
    {
      fHA.incrementAndGet();
      ac.m("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", new Object[] { fHA, fHB, Boolean.valueOf(this.fHD) });
      if (fHA.get() - fHB.get() > 1)
      {
        ac.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", new Object[] { ai.getProcessName() });
        paramCamera = a.fCO;
        a.oP(61L);
        if (!ai.ciE()) {
          break label148;
        }
        paramCamera = a.fCO;
        a.oP(62L);
      }
      for (;;)
      {
        fHA.set(0);
        fHB.set(0);
        this.fHD = false;
        AppMethodBeat.o(155744);
        return;
        label148:
        if (ai.eVd())
        {
          paramCamera = a.fCO;
          a.oP(63L);
        }
        else if (ai.isAppBrandProcess())
        {
          paramCamera = a.fCO;
          a.oP(64L);
        }
      }
    }
    ac.m("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
    AppMethodBeat.o(155744);
  }
  
  public final void addCallbackBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155757);
    if (this.fHC != null) {
      this.fHC.addCallbackBuffer(paramArrayOfByte);
    }
    AppMethodBeat.o(155757);
  }
  
  public final void autoFocus(final Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(155752);
    if (this.fHC != null) {
      this.fHC.autoFocus(new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(160384);
          if (!v.this.fHD) {
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
    if (this.fHC != null) {
      this.fHC.cancelAutoFocus();
    }
    AppMethodBeat.o(155753);
  }
  
  public final Camera.Parameters getParameters()
  {
    AppMethodBeat.i(155745);
    if (this.fHC != null)
    {
      Camera.Parameters localParameters = this.fHC.getParameters();
      AppMethodBeat.o(155745);
      return localParameters;
    }
    AppMethodBeat.o(155745);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(155754);
    if (this.fHC != null) {
      try
      {
        this.fHD = true;
        this.fHC.release();
        return;
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.MCamera", "release camera failed cause sometimes native crash while", new Object[] { localException.fillInStackTrace() });
        return;
      }
      finally
      {
        fHB.incrementAndGet();
        ac.m("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", new Object[] { fHA, fHB, Boolean.valueOf(this.fHD) });
        AppMethodBeat.o(155754);
      }
    }
    AppMethodBeat.o(155754);
  }
  
  public final void setDisplayOrientation(int paramInt)
  {
    AppMethodBeat.i(155750);
    if (this.fHC != null) {
      this.fHC.setDisplayOrientation(paramInt);
    }
    AppMethodBeat.o(155750);
  }
  
  public final void setParameters(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(155746);
    if (this.fHC != null) {
      this.fHC.setParameters(paramParameters);
    }
    AppMethodBeat.o(155746);
  }
  
  public final void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155755);
    if (this.fHC != null) {
      this.fHC.setPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(155755);
  }
  
  public final void setPreviewCallbackWithBuffer(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155756);
    if (this.fHC != null) {
      this.fHC.setPreviewCallbackWithBuffer(paramPreviewCallback);
    }
    AppMethodBeat.o(155756);
  }
  
  public final void setPreviewDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(155747);
    if (this.fHC != null) {
      this.fHC.setPreviewDisplay(paramSurfaceHolder);
    }
    AppMethodBeat.o(155747);
  }
  
  public final void setPreviewTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(155748);
    if (this.fHC != null) {
      this.fHC.setPreviewTexture(paramSurfaceTexture);
    }
    AppMethodBeat.o(155748);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(155749);
    if (this.fHC != null) {
      this.fHC.startPreview();
    }
    AppMethodBeat.o(155749);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(155751);
    if (this.fHC != null) {
      this.fHC.stopPreview();
    }
    AppMethodBeat.o(155751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.v
 * JD-Core Version:    0.7.0.1
 */