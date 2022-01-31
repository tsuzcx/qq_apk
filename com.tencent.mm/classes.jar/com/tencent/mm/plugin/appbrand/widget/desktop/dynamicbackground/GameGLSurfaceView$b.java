package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GameGLSurfaceView$b
  extends GameGLSurfaceView.a
{
  protected int mAlphaSize;
  protected int mBlueSize;
  protected int mDepthSize;
  protected int mGreenSize;
  protected int mRedSize;
  protected int mStencilSize;
  private int[] mValue;
  
  public GameGLSurfaceView$b(GameGLSurfaceView paramGameGLSurfaceView)
  {
    super(paramGameGLSurfaceView, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344 });
    AppMethodBeat.i(134018);
    this.mValue = new int[1];
    this.mRedSize = 8;
    this.mGreenSize = 8;
    this.mBlueSize = 8;
    this.mAlphaSize = 8;
    this.mDepthSize = 16;
    this.mStencilSize = 8;
    AppMethodBeat.o(134018);
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(134020);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mValue))
    {
      paramInt = this.mValue[0];
      AppMethodBeat.o(134020);
      return paramInt;
    }
    AppMethodBeat.o(134020);
    return 0;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(134019);
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
      int k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
      int m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
      if ((k >= this.mDepthSize) && (m >= this.mStencilSize))
      {
        k = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
        m = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
        int n = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
        int i1 = a(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
        if ((k == this.mRedSize) && (m == this.mGreenSize) && (n == this.mBlueSize) && (i1 == this.mAlphaSize))
        {
          AppMethodBeat.o(134019);
          return localEGLConfig;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(134019);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.b
 * JD-Core Version:    0.7.0.1
 */