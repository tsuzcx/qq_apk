package com.google.android.exoplayer2.video;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DummySurface$a
  extends HandlerThread
  implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback
{
  private final int[] bHB;
  private EGLDisplay bHC;
  private EGLContext bHD;
  private EGLSurface bHE;
  private Error bHF;
  private RuntimeException bHG;
  private DummySurface bHH;
  Handler handler;
  private SurfaceTexture surfaceTexture;
  
  public DummySurface$a()
  {
    super("dummySurface");
    AppMethodBeat.i(93259);
    this.bHB = new int[1];
    AppMethodBeat.o(93259);
  }
  
  public final DummySurface aY(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(93260);
    start();
    this.handler = new Handler(getLooper(), this);
    try
    {
      Object localObject1 = this.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject1).obtainMessage(1, i, 0).sendToTarget();
        i = j;
        while ((this.bHH == null) && (this.bHG == null))
        {
          localObject1 = this.bHF;
          if (localObject1 != null) {
            break;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 1;
          }
        }
      }
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      if (this.bHG != null)
      {
        RuntimeException localRuntimeException = this.bHG;
        AppMethodBeat.o(93260);
        throw localRuntimeException;
      }
    }
    finally
    {
      AppMethodBeat.o(93260);
    }
    if (this.bHF != null)
    {
      localObject3 = this.bHF;
      AppMethodBeat.o(93260);
      throw ((Throwable)localObject3);
    }
    Object localObject3 = this.bHH;
    AppMethodBeat.o(93260);
    return localObject3;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(93262);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(93262);
      return true;
    }
    for (;;)
    {
      try
      {
        if (paramMessage.arg1 != 0)
        {
          bool1 = true;
          this.bHC = EGL14.eglGetDisplay(0);
          if (this.bHC == null) {
            continue;
          }
          bool2 = true;
          a.checkState(bool2, "eglGetDisplay failed");
          paramMessage = new int[2];
          a.checkState(EGL14.eglInitialize(this.bHC, paramMessage, 0, paramMessage, 1), "eglInitialize failed");
          paramMessage = new EGLConfig[1];
          int[] arrayOfInt = new int[1];
          if ((!EGL14.eglChooseConfig(this.bHC, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 }, 0, paramMessage, 0, 1, arrayOfInt, 0)) || (arrayOfInt[0] <= 0) || (paramMessage[0] == null)) {
            continue;
          }
          bool2 = true;
          a.checkState(bool2, "eglChooseConfig failed");
          arrayOfInt = paramMessage[0];
          if (!bool1) {
            continue;
          }
          paramMessage = new int[5];
          Message tmp264_263 = paramMessage;
          tmp264_263[0] = 12440;
          Message tmp270_264 = tmp264_263;
          tmp270_264[1] = 2;
          Message tmp274_270 = tmp270_264;
          tmp274_270[2] = 12992;
          Message tmp280_274 = tmp274_270;
          tmp280_274[3] = 1;
          Message tmp284_280 = tmp280_274;
          tmp284_280[4] = 12344;
          tmp284_280;
          this.bHD = EGL14.eglCreateContext(this.bHC, arrayOfInt, EGL14.EGL_NO_CONTEXT, paramMessage, 0);
          if (this.bHD == null) {
            break label868;
          }
          bool2 = true;
          a.checkState(bool2, "eglCreateContext failed");
          if (!bool1) {
            continue;
          }
          paramMessage = new int[7];
          Message tmp334_333 = paramMessage;
          tmp334_333[0] = 12375;
          Message tmp340_334 = tmp334_333;
          tmp340_334[1] = 1;
          Message tmp344_340 = tmp340_334;
          tmp344_340[2] = 12374;
          Message tmp350_344 = tmp344_340;
          tmp350_344[3] = 1;
          Message tmp354_350 = tmp350_344;
          tmp354_350[4] = 12992;
          Message tmp360_354 = tmp354_350;
          tmp360_354[5] = 1;
          Message tmp364_360 = tmp360_354;
          tmp364_360[6] = 12344;
          tmp364_360;
          this.bHE = EGL14.eglCreatePbufferSurface(this.bHC, arrayOfInt, paramMessage, 0);
          if (this.bHE == null) {
            continue;
          }
          bool2 = true;
          a.checkState(bool2, "eglCreatePbufferSurface failed");
          a.checkState(EGL14.eglMakeCurrent(this.bHC, this.bHE, this.bHE, this.bHD), "eglMakeCurrent failed");
          GLES20.glGenTextures(1, this.bHB, 0);
          this.surfaceTexture = new SurfaceTexture(this.bHB[0]);
          this.surfaceTexture.setOnFrameAvailableListener(this);
          this.bHH = new DummySurface(this, this.surfaceTexture, bool1, (byte)0);
        }
      }
      catch (RuntimeException paramMessage)
      {
        boolean bool1;
        this.bHG = paramMessage;
        try
        {
          notify();
          continue;
        }
        finally
        {
          AppMethodBeat.o(93262);
        }
      }
      catch (Error paramMessage)
      {
        this.bHF = paramMessage;
        try
        {
          notify();
          continue;
        }
        finally
        {
          AppMethodBeat.o(93262);
        }
      }
      finally
      {
        try
        {
          notify();
          throw paramMessage;
        }
        finally
        {
          AppMethodBeat.o(93262);
        }
      }
      try
      {
        notify();
        return true;
      }
      finally
      {
        AppMethodBeat.o(93262);
      }
      bool1 = false;
      continue;
      boolean bool2 = false;
      continue;
      bool2 = false;
      continue;
      paramMessage = new int[3];
      Message tmp513_512 = paramMessage;
      tmp513_512[0] = 12440;
      Message tmp519_513 = tmp513_512;
      tmp519_513[1] = 2;
      Message tmp523_519 = tmp519_513;
      tmp523_519[2] = 12344;
      tmp523_519;
      continue;
      paramMessage = new int[5];
      Message tmp538_537 = paramMessage;
      tmp538_537[0] = 12375;
      Message tmp544_538 = tmp538_537;
      tmp544_538[1] = 1;
      Message tmp548_544 = tmp544_538;
      tmp548_544[2] = 12374;
      Message tmp554_548 = tmp548_544;
      tmp554_548[3] = 1;
      Message tmp558_554 = tmp554_548;
      tmp558_554[4] = 12344;
      tmp558_554;
      continue;
      bool2 = false;
      continue;
      this.surfaceTexture.updateTexImage();
      AppMethodBeat.o(93262);
      return true;
      try
      {
        if (this.surfaceTexture != null)
        {
          this.surfaceTexture.release();
          GLES20.glDeleteTextures(1, this.bHB, 0);
        }
      }
      finally
      {
        label768:
        if (this.bHE != null) {
          EGL14.eglDestroySurface(this.bHC, this.bHE);
        }
        if (this.bHD != null) {
          EGL14.eglDestroyContext(this.bHC, this.bHD);
        }
        this.bHE = null;
        this.bHD = null;
        this.bHC = null;
        this.bHH = null;
        this.surfaceTexture = null;
        AppMethodBeat.o(93262);
      }
      try
      {
        if (this.bHE != null) {
          EGL14.eglDestroySurface(this.bHC, this.bHE);
        }
        if (this.bHD != null) {
          EGL14.eglDestroyContext(this.bHC, this.bHD);
        }
        this.bHE = null;
        this.bHD = null;
        this.bHC = null;
        this.bHH = null;
        this.surfaceTexture = null;
        quit();
      }
      catch (Throwable paramMessage)
      {
        quit();
        break label768;
      }
      finally
      {
        quit();
        AppMethodBeat.o(93262);
      }
      AppMethodBeat.o(93262);
      return true;
      label868:
      bool2 = false;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(93261);
    this.handler.sendEmptyMessage(2);
    AppMethodBeat.o(93261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface.a
 * JD-Core Version:    0.7.0.1
 */