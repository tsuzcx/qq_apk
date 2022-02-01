package com.tencent.mm.compatible.deviceinfo;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.atomic.AtomicInteger;

public final class v
{
  private static final AtomicInteger gIG;
  private static final AtomicInteger gIH;
  public Camera gII;
  public volatile boolean gIJ;
  
  static
  {
    AppMethodBeat.i(155758);
    gIG = new AtomicInteger(0);
    gIH = new AtomicInteger(0);
    AppMethodBeat.o(155758);
  }
  
  public v(Camera paramCamera)
  {
    AppMethodBeat.i(155744);
    this.gIJ = false;
    this.gII = paramCamera;
    if (paramCamera != null)
    {
      gIG.incrementAndGet();
      Log.printInfoStack("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", new Object[] { gIG, gIH, Boolean.valueOf(this.gIJ) });
      if (gIG.get() - gIH.get() > 1)
      {
        Log.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", new Object[] { MMApplicationContext.getProcessName() });
        paramCamera = a.gDv;
        a.v(650L, 61L);
        if (!MMApplicationContext.isMMProcess()) {
          break label154;
        }
        paramCamera = a.gDv;
        a.v(650L, 62L);
      }
      for (;;)
      {
        gIG.set(0);
        gIH.set(0);
        this.gIJ = false;
        AppMethodBeat.o(155744);
        return;
        label154:
        if (MMApplicationContext.isToolsProcess())
        {
          paramCamera = a.gDv;
          a.v(650L, 63L);
        }
        else if (MMApplicationContext.isAppBrandProcess())
        {
          paramCamera = a.gDv;
          a.v(650L, 64L);
        }
      }
    }
    Log.printInfoStack("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
    AppMethodBeat.o(155744);
  }
  
  public final void addCallbackBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155757);
    if (this.gII != null) {
      this.gII.addCallbackBuffer(paramArrayOfByte);
    }
    AppMethodBeat.o(155757);
  }
  
  public final void autoFocus(final Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(155752);
    if (this.gII != null) {
      this.gII.autoFocus(new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(160384);
          if (!v.this.gIJ) {
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
    if (this.gII != null) {
      this.gII.cancelAutoFocus();
    }
    AppMethodBeat.o(155753);
  }
  
  public final Camera.Parameters getParameters()
  {
    AppMethodBeat.i(155745);
    if (this.gII != null)
    {
      Camera.Parameters localParameters = this.gII.getParameters();
      AppMethodBeat.o(155745);
      return localParameters;
    }
    AppMethodBeat.o(155745);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(155754);
    if (this.gII != null) {
      try
      {
        this.gIJ = true;
        this.gII.release();
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.MCamera", "release camera failed cause sometimes native crash while", new Object[] { localException.fillInStackTrace() });
        return;
      }
      finally
      {
        gIH.incrementAndGet();
        Log.printInfoStack("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", new Object[] { gIG, gIH, Boolean.valueOf(this.gIJ) });
        AppMethodBeat.o(155754);
      }
    }
    AppMethodBeat.o(155754);
  }
  
  public final void setDisplayOrientation(int paramInt)
  {
    AppMethodBeat.i(155750);
    if (this.gII != null) {
      this.gII.setDisplayOrientation(paramInt);
    }
    AppMethodBeat.o(155750);
  }
  
  public final void setParameters(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(155746);
    if (this.gII != null) {
      this.gII.setParameters(paramParameters);
    }
    AppMethodBeat.o(155746);
  }
  
  public final void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155755);
    if (this.gII != null) {
      this.gII.setPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(155755);
  }
  
  public final void setPreviewCallbackWithBuffer(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155756);
    if (this.gII != null) {
      this.gII.setPreviewCallbackWithBuffer(paramPreviewCallback);
    }
    AppMethodBeat.o(155756);
  }
  
  public final void setPreviewDisplay(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(155747);
    if (this.gII != null) {
      this.gII.setPreviewDisplay(paramSurfaceHolder);
    }
    AppMethodBeat.o(155747);
  }
  
  public final void setPreviewTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(155748);
    if (this.gII != null) {
      this.gII.setPreviewTexture(paramSurfaceTexture);
    }
    AppMethodBeat.o(155748);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(155749);
    if (this.gII != null) {
      this.gII.startPreview();
    }
    AppMethodBeat.o(155749);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(155751);
    if (this.gII != null) {
      this.gII.stopPreview();
    }
    AppMethodBeat.o(155751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.v
 * JD-Core Version:    0.7.0.1
 */