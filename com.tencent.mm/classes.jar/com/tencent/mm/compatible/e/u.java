package com.tencent.mm.compatible.e;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
{
  private static final AtomicInteger eqD;
  private static final AtomicInteger eqE;
  public Camera eqF;
  public boolean eqG;
  
  static
  {
    AppMethodBeat.i(93007);
    eqD = new AtomicInteger(0);
    eqE = new AtomicInteger(0);
    AppMethodBeat.o(93007);
  }
  
  public u(Camera paramCamera)
  {
    AppMethodBeat.i(92992);
    this.eqG = false;
    this.eqF = paramCamera;
    if (paramCamera != null)
    {
      eqD.incrementAndGet();
      ab.b("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", new Object[] { eqD, eqE, Boolean.valueOf(this.eqG) });
      if (eqD.get() - eqE.get() > 1)
      {
        ab.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", new Object[] { ah.getProcessName() });
        paramCamera = a.emy;
        a.gb(61L);
        if (!ah.brt()) {
          break label148;
        }
        paramCamera = a.emy;
        a.gb(62L);
      }
      for (;;)
      {
        eqD.set(0);
        eqE.set(0);
        this.eqG = false;
        AppMethodBeat.o(92992);
        return;
        label148:
        if (ah.dsW())
        {
          paramCamera = a.emy;
          a.gb(63L);
        }
        else if (ah.isAppBrandProcess())
        {
          paramCamera = a.emy;
          a.gb(64L);
        }
      }
    }
    ab.b("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
    AppMethodBeat.o(92992);
  }
  
  public final void addCallbackBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93006);
    if (this.eqF != null) {
      this.eqF.addCallbackBuffer(paramArrayOfByte);
    }
    AppMethodBeat.o(93006);
  }
  
  public final void autoFocus(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(93000);
    if (this.eqF != null) {
      this.eqF.autoFocus(paramAutoFocusCallback);
    }
    AppMethodBeat.o(93000);
  }
  
  public final void cancelAutoFocus()
  {
    AppMethodBeat.i(93002);
    if (this.eqF != null) {
      this.eqF.cancelAutoFocus();
    }
    AppMethodBeat.o(93002);
  }
  
  public final Camera.Parameters getParameters()
  {
    AppMethodBeat.i(92993);
    if (this.eqF != null)
    {
      Camera.Parameters localParameters = this.eqF.getParameters();
      AppMethodBeat.o(92993);
      return localParameters;
    }
    AppMethodBeat.o(92993);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(93003);
    if (this.eqF != null)
    {
      this.eqF.release();
      this.eqG = true;
      eqE.incrementAndGet();
      ab.b("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", new Object[] { eqD, eqE, Boolean.valueOf(this.eqG) });
    }
    AppMethodBeat.o(93003);
  }
  
  public final void setDisplayOrientation(int paramInt)
  {
    AppMethodBeat.i(92998);
    if (this.eqF != null) {
      this.eqF.setDisplayOrientation(paramInt);
    }
    AppMethodBeat.o(92998);
  }
  
  public final void setOneShotPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(93001);
    if (this.eqF != null) {
      this.eqF.setOneShotPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(93001);
  }
  
  public final void setParameters(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(92994);
    if (this.eqF != null) {
      this.eqF.setParameters(paramParameters);
    }
    AppMethodBeat.o(92994);
  }
  
  public final void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(93004);
    if (this.eqF != null) {
      this.eqF.setPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(93004);
  }
  
  public final void setPreviewCallbackWithBuffer(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(93005);
    if (this.eqF != null) {
      this.eqF.setPreviewCallbackWithBuffer(paramPreviewCallback);
    }
    AppMethodBeat.o(93005);
  }
  
  public final void setPreviewDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(92995);
    if (this.eqF != null) {
      this.eqF.setPreviewDisplay(paramSurfaceHolder);
    }
    AppMethodBeat.o(92995);
  }
  
  public final void setPreviewTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(92996);
    if (this.eqF != null) {
      this.eqF.setPreviewTexture(paramSurfaceTexture);
    }
    AppMethodBeat.o(92996);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(92997);
    if (this.eqF != null) {
      this.eqF.startPreview();
    }
    AppMethodBeat.o(92997);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(92999);
    if (this.eqF != null) {
      this.eqF.stopPreview();
    }
    AppMethodBeat.o(92999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.e.u
 * JD-Core Version:    0.7.0.1
 */