package com.tencent.mm.compatible.deviceinfo;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.atomic.AtomicInteger;

public final class v
{
  private static final AtomicInteger gdi;
  private static final AtomicInteger gdj;
  public Camera gdk;
  public volatile boolean gdl;
  
  static
  {
    AppMethodBeat.i(155758);
    gdi = new AtomicInteger(0);
    gdj = new AtomicInteger(0);
    AppMethodBeat.o(155758);
  }
  
  public v(Camera paramCamera)
  {
    AppMethodBeat.i(155744);
    this.gdl = false;
    this.gdk = paramCamera;
    if (paramCamera != null)
    {
      gdi.incrementAndGet();
      ae.m("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", new Object[] { gdi, gdj, Boolean.valueOf(this.gdl) });
      if (gdi.get() - gdj.get() > 1)
      {
        ae.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", new Object[] { ak.getProcessName() });
        paramCamera = a.fYi;
        a.rc(61L);
        if (!ak.cpe()) {
          break label148;
        }
        paramCamera = a.fYi;
        a.rc(62L);
      }
      for (;;)
      {
        gdi.set(0);
        gdj.set(0);
        this.gdl = false;
        AppMethodBeat.o(155744);
        return;
        label148:
        if (ak.foC())
        {
          paramCamera = a.fYi;
          a.rc(63L);
        }
        else if (ak.isAppBrandProcess())
        {
          paramCamera = a.fYi;
          a.rc(64L);
        }
      }
    }
    ae.m("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
    AppMethodBeat.o(155744);
  }
  
  public final void addCallbackBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155757);
    if (this.gdk != null) {
      this.gdk.addCallbackBuffer(paramArrayOfByte);
    }
    AppMethodBeat.o(155757);
  }
  
  public final void autoFocus(final Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(155752);
    if (this.gdk != null) {
      this.gdk.autoFocus(new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(160384);
          if (!v.this.gdl) {
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
    if (this.gdk != null) {
      this.gdk.cancelAutoFocus();
    }
    AppMethodBeat.o(155753);
  }
  
  public final Camera.Parameters getParameters()
  {
    AppMethodBeat.i(155745);
    if (this.gdk != null)
    {
      Camera.Parameters localParameters = this.gdk.getParameters();
      AppMethodBeat.o(155745);
      return localParameters;
    }
    AppMethodBeat.o(155745);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(155754);
    if (this.gdk != null) {
      try
      {
        this.gdl = true;
        this.gdk.release();
        return;
      }
      catch (Exception localException)
      {
        ae.i("MicroMsg.MCamera", "release camera failed cause sometimes native crash while", new Object[] { localException.fillInStackTrace() });
        return;
      }
      finally
      {
        gdj.incrementAndGet();
        ae.m("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", new Object[] { gdi, gdj, Boolean.valueOf(this.gdl) });
        AppMethodBeat.o(155754);
      }
    }
    AppMethodBeat.o(155754);
  }
  
  public final void setDisplayOrientation(int paramInt)
  {
    AppMethodBeat.i(155750);
    if (this.gdk != null) {
      this.gdk.setDisplayOrientation(paramInt);
    }
    AppMethodBeat.o(155750);
  }
  
  public final void setParameters(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(155746);
    if (this.gdk != null) {
      this.gdk.setParameters(paramParameters);
    }
    AppMethodBeat.o(155746);
  }
  
  public final void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155755);
    if (this.gdk != null) {
      this.gdk.setPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(155755);
  }
  
  public final void setPreviewCallbackWithBuffer(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155756);
    if (this.gdk != null) {
      this.gdk.setPreviewCallbackWithBuffer(paramPreviewCallback);
    }
    AppMethodBeat.o(155756);
  }
  
  public final void setPreviewDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(155747);
    if (this.gdk != null) {
      this.gdk.setPreviewDisplay(paramSurfaceHolder);
    }
    AppMethodBeat.o(155747);
  }
  
  public final void setPreviewTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(155748);
    if (this.gdk != null) {
      this.gdk.setPreviewTexture(paramSurfaceTexture);
    }
    AppMethodBeat.o(155748);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(155749);
    if (this.gdk != null) {
      this.gdk.startPreview();
    }
    AppMethodBeat.o(155749);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(155751);
    if (this.gdk != null) {
      this.gdk.stopPreview();
    }
    AppMethodBeat.o(155751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.v
 * JD-Core Version:    0.7.0.1
 */