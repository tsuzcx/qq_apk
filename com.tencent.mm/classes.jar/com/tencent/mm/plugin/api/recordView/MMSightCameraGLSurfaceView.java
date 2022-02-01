package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class MMSightCameraGLSurfaceView
  extends GLSurfaceView
{
  private android.opengl.EGLContext ilv;
  int iqx;
  int kxW;
  int kxX;
  a kyg;
  private int kyh;
  private c kyi;
  
  public MMSightCameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(89201);
    this.kyg = null;
    this.kyh = 0;
    init();
    AppMethodBeat.o(89201);
  }
  
  public MMSightCameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89202);
    this.kyg = null;
    this.kyh = 0;
    init();
    AppMethodBeat.o(89202);
  }
  
  private void init()
  {
    AppMethodBeat.i(89203);
    getHolder().addCallback(this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory(new b());
      setEGLConfigChooser(new a());
      this.kyg = new a();
      setRenderer(this.kyg);
      setRenderMode(0);
      AppMethodBeat.o(89203);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          getHolder().setType(1);
        }
        catch (Exception localException2)
        {
          try
          {
            getHolder().setType(0);
          }
          catch (Exception localException3) {}
        }
      }
    }
  }
  
  public android.opengl.EGLContext getEglContext()
  {
    return this.ilv;
  }
  
  public int getFrameHeight()
  {
    return this.kxX;
  }
  
  public int getFrameRotate()
  {
    return this.iqx;
  }
  
  public int getFrameWidth()
  {
    return this.kxW;
  }
  
  public void setOnEglEnableListener(c paramc)
  {
    this.kyi = paramc;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89206);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this });
    AppMethodBeat.o(89206);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(89204);
    super.surfaceCreated(paramSurfaceHolder);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", new Object[] { paramSurfaceHolder, this, Integer.valueOf(getId()) });
    this.ilv = EGL14.eglGetCurrentContext();
    if (this.kyi != null) {
      this.kyi.enable();
    }
    AppMethodBeat.o(89204);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(89205);
    super.surfaceDestroyed(paramSurfaceHolder);
    Log.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", new Object[] { paramSurfaceHolder, this });
    AppMethodBeat.o(89205);
  }
  
  final class a
    implements GLSurfaceView.EGLConfigChooser
  {
    private int EGL_OPENGL_ES2_BIT;
    private int[] gSm;
    protected int gSn;
    protected int gSo;
    protected int gSp;
    protected int gSq;
    protected int gSr;
    protected int gSs;
    private int[] ijB;
    
    public a()
    {
      AppMethodBeat.i(89194);
      this.EGL_OPENGL_ES2_BIT = 4;
      this.ijB = new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344 };
      this.gSm = new int[1];
      this.gSn = 5;
      this.gSo = 6;
      this.gSp = 5;
      this.gSq = 0;
      this.gSr = 0;
      this.gSs = 0;
      AppMethodBeat.o(89194);
    }
    
    private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      AppMethodBeat.i(89197);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.gSm))
      {
        paramInt = this.gSm[0];
        AppMethodBeat.o(89197);
        return paramInt;
      }
      AppMethodBeat.o(89197);
      return 0;
    }
    
    private EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(89196);
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((k >= this.gSr) && (m >= this.gSs))
        {
          k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((k == this.gSn) && (m == this.gSo) && (n == this.gSp) && (i1 == this.gSq))
          {
            AppMethodBeat.o(89196);
            return localEGLConfig;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(89196);
      return null;
    }
    
    private static void c(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(89198);
      int k = paramArrayOfEGLConfig.length;
      Log.i("GLConfigChooser", String.format("%d configurations", new Object[] { Integer.valueOf(k) }));
      int i = 0;
      while (i < k)
      {
        Log.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[] { Integer.valueOf(i) }));
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int[] arrayOfInt = new int[1];
        int j = 0;
        while (j < 33)
        {
          paramEGL10.eglGetConfigAttrib(paramEGLDisplay, localEGLConfig, new int[] { 12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354 }[j], arrayOfInt);
          j += 1;
        }
        i += 1;
      }
      AppMethodBeat.o(89198);
    }
    
    public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      AppMethodBeat.i(89195);
      int[] arrayOfInt = new int[1];
      paramEGL10.eglChooseConfig(paramEGLDisplay, this.ijB, null, 0, arrayOfInt);
      int i = arrayOfInt[0];
      if (i <= 0)
      {
        paramEGL10 = new IllegalArgumentException("No configs match configSpec");
        AppMethodBeat.o(89195);
        throw paramEGL10;
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      paramEGL10.eglChooseConfig(paramEGLDisplay, this.ijB, arrayOfEGLConfig, i, arrayOfInt);
      c(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      AppMethodBeat.o(89195);
      return paramEGL10;
    }
  }
  
  final class b
    implements GLSurfaceView.EGLContextFactory
  {
    private int EGL_CONTEXT_CLIENT_VERSION = 12440;
    
    b() {}
    
    public final javax.microedition.khronos.egl.EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(89199);
      Log.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
      int i = this.EGL_CONTEXT_CLIENT_VERSION;
      paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
      AppMethodBeat.o(89199);
      return paramEGL10;
    }
    
    public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, javax.microedition.khronos.egl.EGLContext paramEGLContext)
    {
      AppMethodBeat.i(89200);
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
      AppMethodBeat.o(89200);
    }
  }
  
  public static abstract interface c
  {
    public abstract void enable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightCameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */