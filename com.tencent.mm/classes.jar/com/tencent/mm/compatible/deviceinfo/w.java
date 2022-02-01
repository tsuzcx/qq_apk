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
  private static final AtomicInteger lWq;
  private static final AtomicInteger lWr;
  public Camera lWs;
  public volatile boolean lWt;
  public int zS;
  
  static
  {
    AppMethodBeat.i(155758);
    lWq = new AtomicInteger(0);
    lWr = new AtomicInteger(0);
    AppMethodBeat.o(155758);
  }
  
  public w(Camera paramCamera)
  {
    AppMethodBeat.i(155744);
    this.zS = 1;
    this.lWt = false;
    this.lWs = paramCamera;
    if (paramCamera != null)
    {
      lWq.incrementAndGet();
      Log.printInfoStack("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", new Object[] { lWq, lWr, Boolean.valueOf(this.lWt) });
      if (lWq.get() - lWr.get() > 1)
      {
        Log.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", new Object[] { MMApplicationContext.getProcessName() });
        paramCamera = a.lQN;
        a.T(650L, 61L);
        if (!MMApplicationContext.isMMProcess()) {
          break label159;
        }
        paramCamera = a.lQN;
        a.T(650L, 62L);
      }
      for (;;)
      {
        lWq.set(0);
        lWr.set(0);
        this.lWt = false;
        AppMethodBeat.o(155744);
        return;
        label159:
        if (MMApplicationContext.isToolsProcess())
        {
          paramCamera = a.lQN;
          a.T(650L, 63L);
        }
        else if (MMApplicationContext.isAppBrandProcess())
        {
          paramCamera = a.lQN;
          a.T(650L, 64L);
        }
      }
    }
    Log.printInfoStack("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
    AppMethodBeat.o(155744);
  }
  
  public final void a(final Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(155752);
    if (this.lWs != null) {
      this.lWs.autoFocus(new Camera.AutoFocusCallback()
      {
        public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(160384);
          if (!w.this.lWt) {
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
    if (this.lWs != null) {
      this.lWs.setPreviewCallback(paramPreviewCallback);
    }
    AppMethodBeat.o(155755);
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(155747);
    if (this.lWs != null) {
      this.lWs.setPreviewDisplay(paramSurfaceHolder);
    }
    AppMethodBeat.o(155747);
  }
  
  public final void aPA()
  {
    AppMethodBeat.i(155753);
    if (this.lWs != null) {
      this.lWs.cancelAutoFocus();
    }
    AppMethodBeat.o(155753);
  }
  
  public final Camera.Parameters aPy()
  {
    AppMethodBeat.i(155745);
    if (this.lWs != null)
    {
      Camera.Parameters localParameters = this.lWs.getParameters();
      AppMethodBeat.o(155745);
      return localParameters;
    }
    AppMethodBeat.o(155745);
    return null;
  }
  
  public final void aPz()
  {
    AppMethodBeat.i(155749);
    if (this.lWs != null) {
      this.lWs.startPreview();
    }
    AppMethodBeat.o(155749);
  }
  
  public final void aj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155757);
    if (this.lWs != null) {
      this.lWs.addCallbackBuffer(paramArrayOfByte);
    }
    AppMethodBeat.o(155757);
  }
  
  public final void auq()
  {
    AppMethodBeat.i(155751);
    if (this.lWs != null) {
      this.lWs.stopPreview();
    }
    AppMethodBeat.o(155751);
  }
  
  public final void b(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(155756);
    if (this.lWs != null) {
      this.lWs.setPreviewCallbackWithBuffer(paramPreviewCallback);
    }
    AppMethodBeat.o(155756);
  }
  
  public final void c(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(155746);
    if (this.lWs != null) {
      this.lWs.setParameters(paramParameters);
    }
    AppMethodBeat.o(155746);
  }
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(155748);
    if (this.lWs != null) {
      this.lWs.setPreviewTexture(paramSurfaceTexture);
    }
    AppMethodBeat.o(155748);
  }
  
  public final void qV(int paramInt)
  {
    AppMethodBeat.i(155750);
    if (this.lWs != null) {
      this.lWs.setDisplayOrientation(paramInt);
    }
    AppMethodBeat.o(155750);
  }
  
  public final void release()
  {
    AppMethodBeat.i(155754);
    if (this.lWs != null) {
      try
      {
        this.lWt = true;
        this.lWs.release();
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.MCamera", "release camera failed cause sometimes native crash while", new Object[] { localException.fillInStackTrace() });
        return;
      }
      finally
      {
        lWr.incrementAndGet();
        Log.printInfoStack("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", new Object[] { lWq, lWr, Boolean.valueOf(this.lWt) });
        AppMethodBeat.o(155754);
      }
    }
    AppMethodBeat.o(155754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.w
 * JD-Core Version:    0.7.0.1
 */