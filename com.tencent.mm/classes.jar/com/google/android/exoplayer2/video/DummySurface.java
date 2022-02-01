package com.google.android.exoplayer2.video;

import android.content.Context;
import android.content.pm.PackageManager;
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
import android.view.Surface;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DummySurface
  extends Surface
{
  private static boolean dkZ;
  private static boolean dla;
  public final boolean cWw;
  private final a dlb;
  private boolean dlc;
  
  private DummySurface(a parama, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.dlb = parama;
    this.cWw = paramBoolean;
  }
  
  public static boolean aN(Context paramContext)
  {
    boolean bool1 = true;
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(93263);
        if (!dla)
        {
          if (x.SDK_INT < 24) {
            continue;
          }
          String str = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
          if (str == null) {
            break label143;
          }
          if (!str.contains("EGL_EXT_protected_content"))
          {
            break label143;
            dkZ = bool1;
            dla = true;
          }
        }
        else
        {
          bool1 = dkZ;
          AppMethodBeat.o(93263);
          return bool1;
        }
        if ((x.SDK_INT == 24) && ("samsung".equals(x.MANUFACTURER)))
        {
          i = 0;
        }
        else
        {
          if (x.SDK_INT < 26)
          {
            boolean bool2 = paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
            if (!bool2)
            {
              i = 0;
              break label145;
            }
          }
          i = 1;
          break label145;
          bool1 = false;
          continue;
          i = 0;
        }
      }
      finally {}
      label143:
      label145:
      if (i == 0) {}
    }
  }
  
  public static DummySurface i(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(93264);
    if (x.SDK_INT < 17)
    {
      paramContext = new UnsupportedOperationException("Unsupported prior to API level 17");
      AppMethodBeat.o(93264);
      throw paramContext;
    }
    if ((!paramBoolean) || (aN(paramContext))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      paramContext = new a().bD(paramBoolean);
      AppMethodBeat.o(93264);
      return paramContext;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(93265);
    super.release();
    synchronized (this.dlb)
    {
      if (!this.dlc)
      {
        this.dlb.handler.sendEmptyMessage(3);
        this.dlc = true;
      }
      AppMethodBeat.o(93265);
      return;
    }
  }
  
  static final class a
    extends HandlerThread
    implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback
  {
    private final int[] dld;
    private EGLDisplay dle;
    private EGLContext dlf;
    private EGLSurface dlg;
    private Error dlh;
    private RuntimeException dli;
    private DummySurface dlj;
    Handler handler;
    private SurfaceTexture surfaceTexture;
    
    public a()
    {
      super();
      AppMethodBeat.i(93259);
      this.dld = new int[1];
      AppMethodBeat.o(93259);
    }
    
    public final DummySurface bD(boolean paramBoolean)
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
          while ((this.dlj == null) && (this.dli == null))
          {
            localObject1 = this.dlh;
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
        if (this.dli != null)
        {
          RuntimeException localRuntimeException = this.dli;
          AppMethodBeat.o(93260);
          throw localRuntimeException;
        }
      }
      finally
      {
        AppMethodBeat.o(93260);
      }
      if (this.dlh != null)
      {
        localObject3 = this.dlh;
        AppMethodBeat.o(93260);
        throw ((Throwable)localObject3);
      }
      Object localObject3 = this.dlj;
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
            this.dle = EGL14.eglGetDisplay(0);
            if (this.dle == null) {
              continue;
            }
            bool2 = true;
            a.checkState(bool2, "eglGetDisplay failed");
            paramMessage = new int[2];
            a.checkState(EGL14.eglInitialize(this.dle, paramMessage, 0, paramMessage, 1), "eglInitialize failed");
            paramMessage = new EGLConfig[1];
            int[] arrayOfInt = new int[1];
            if ((!EGL14.eglChooseConfig(this.dle, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 }, 0, paramMessage, 0, 1, arrayOfInt, 0)) || (arrayOfInt[0] <= 0) || (paramMessage[0] == null)) {
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
            this.dlf = EGL14.eglCreateContext(this.dle, arrayOfInt, EGL14.EGL_NO_CONTEXT, paramMessage, 0);
            if (this.dlf == null) {
              break label855;
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
            this.dlg = EGL14.eglCreatePbufferSurface(this.dle, arrayOfInt, paramMessage, 0);
            if (this.dlg == null) {
              continue;
            }
            bool2 = true;
            a.checkState(bool2, "eglCreatePbufferSurface failed");
            a.checkState(EGL14.eglMakeCurrent(this.dle, this.dlg, this.dlg, this.dlf), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.dld, 0);
            this.surfaceTexture = new SurfaceTexture(this.dld[0]);
            this.surfaceTexture.setOnFrameAvailableListener(this);
            this.dlj = new DummySurface(this, this.surfaceTexture, bool1, (byte)0);
          }
        }
        catch (RuntimeException paramMessage)
        {
          try
          {
            boolean bool1;
            notify();
            continue;
          }
          finally
          {
            paramMessage = finally;
            AppMethodBeat.o(93262);
            throw paramMessage;
          }
        }
        catch (Error paramMessage)
        {
          this.dlh = paramMessage;
          try
          {
            notify();
            continue;
          }
          finally
          {
            paramMessage = finally;
            AppMethodBeat.o(93262);
            throw paramMessage;
          }
        }
        finally
        {
          try
          {
            notify();
            AppMethodBeat.o(93262);
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
            GLES20.glDeleteTextures(1, this.dld, 0);
          }
        }
        finally
        {
          label768:
          if (this.dlg != null) {
            EGL14.eglDestroySurface(this.dle, this.dlg);
          }
          if (this.dlf != null) {
            EGL14.eglDestroyContext(this.dle, this.dlf);
          }
          this.dlg = null;
          this.dlf = null;
          this.dle = null;
          this.dlj = null;
          this.surfaceTexture = null;
          AppMethodBeat.o(93262);
        }
        try
        {
          if (this.dlg != null) {
            EGL14.eglDestroySurface(this.dle, this.dlg);
          }
          if (this.dlf != null) {
            EGL14.eglDestroyContext(this.dle, this.dlf);
          }
          this.dlg = null;
          this.dlf = null;
          this.dle = null;
          this.dlj = null;
          this.surfaceTexture = null;
          quit();
        }
        finally
        {
          quit();
          break label768;
        }
        AppMethodBeat.o(93262);
        return true;
        label855:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface
 * JD-Core Version:    0.7.0.1
 */