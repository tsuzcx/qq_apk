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

public final class w
{
  private static final AtomicInteger jsY;
  private static final AtomicInteger jsZ;
  public Camera jta;
  public volatile boolean jtb;
  
  static
  {
    AppMethodBeat.i(155758);
    jsY = new AtomicInteger(0);
    jsZ = new AtomicInteger(0);
    AppMethodBeat.o(155758);
  }
  
  public w(Camera paramCamera)
  {
    AppMethodBeat.i(155744);
    this.jtb = false;
    this.jta = paramCamera;
    if (paramCamera != null)
    {
      jsY.incrementAndGet();
      Log.printInfoStack("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", new Object[] { jsY, jsZ, Boolean.valueOf(this.jtb) });
      if (jsY.get() - jsZ.get() > 1)
      {
        Log.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", new Object[] { MMApplicationContext.getProcessName() });
        paramCamera = a.jnF;
        a.v(650L, 61L);
        if (!MMApplicationContext.isMMProcess()) {
          break label154;
        }
        paramCamera = a.jnF;
        a.v(650L, 62L);
      }
      for (;;)
      {
        jsY.set(0);
        jsZ.set(0);
        this.jtb = false;
        AppMethodBeat.o(155744);
        return;
        label154:
        if (MMApplicationContext.isToolsProcess())
        {
          paramCamera = a.jnF;
          a.v(650L, 63L);
        }
        else if (MMApplicationContext.isAppBrandProcess())
        {
          paramCamera = a.jnF;
          a.v(650L, 64L);
        }
      }
    }
    Log.printInfoStack("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
    AppMethodBeat.o(155744);
  }
  
  public final void TL()
  {
    AppMethodBeat.i(155751);
    if (this.jta != null) {
      this.jta.stopPreview();
    }
    AppMethodBeat.o(155751);
  }
  
  public final void a(final Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(155752);
    if (this.jta != null) {
      this.jta.autoFocus(new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(160384);
          if (!w.this.jtb) {
            paramAutoFocusCallback.onAutoFocus(paramAnonymousBoolean, paramAnonymousCamera);
          }
          AppMethodBeat.o(160384);
        }
      });
    }
    AppMethodBeat.o(155752);
  }
  
  public final void a(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155755);
    if (this.jta != null) {
      this.jta.setPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(155755);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(155747);
    if (this.jta != null) {
      this.jta.setPreviewDisplay(paramSurfaceHolder);
    }
    AppMethodBeat.o(155747);
  }
  
  public final void aj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155757);
    if (this.jta != null) {
      this.jta.addCallbackBuffer(paramArrayOfByte);
    }
    AppMethodBeat.o(155757);
  }
  
  public final Camera.Parameters avd()
  {
    AppMethodBeat.i(155745);
    if (this.jta != null)
    {
      Camera.Parameters localParameters = this.jta.getParameters();
      AppMethodBeat.o(155745);
      return localParameters;
    }
    AppMethodBeat.o(155745);
    return null;
  }
  
  public final void ave()
  {
    AppMethodBeat.i(155749);
    if (this.jta != null) {
      this.jta.startPreview();
    }
    AppMethodBeat.o(155749);
  }
  
  public final void avf()
  {
    AppMethodBeat.i(155753);
    if (this.jta != null) {
      this.jta.cancelAutoFocus();
    }
    AppMethodBeat.o(155753);
  }
  
  public final void b(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155756);
    if (this.jta != null) {
      this.jta.setPreviewCallbackWithBuffer(paramPreviewCallback);
    }
    AppMethodBeat.o(155756);
  }
  
  public final void c(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(155746);
    if (this.jta != null) {
      this.jta.setParameters(paramParameters);
    }
    AppMethodBeat.o(155746);
  }
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(155748);
    if (this.jta != null) {
      this.jta.setPreviewTexture(paramSurfaceTexture);
    }
    AppMethodBeat.o(155748);
  }
  
  public final void qO(int paramInt)
  {
    AppMethodBeat.i(155750);
    if (this.jta != null) {
      this.jta.setDisplayOrientation(paramInt);
    }
    AppMethodBeat.o(155750);
  }
  
  public final void release()
  {
    AppMethodBeat.i(155754);
    if (this.jta != null) {
      try
      {
        this.jtb = true;
        this.jta.release();
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.MCamera", "release camera failed cause sometimes native crash while", new Object[] { localException.fillInStackTrace() });
        return;
      }
      finally
      {
        jsZ.incrementAndGet();
        Log.printInfoStack("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", new Object[] { jsY, jsZ, Boolean.valueOf(this.jtb) });
        AppMethodBeat.o(155754);
      }
    }
    AppMethodBeat.o(155754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.w
 * JD-Core Version:    0.7.0.1
 */