package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GLSurfaceView$b
  extends GLSurfaceView.a
{
  protected int mAlphaSize;
  protected int mBlueSize;
  protected int mDepthSize;
  protected int mGreenSize;
  protected int mRedSize;
  protected int mStencilSize;
  private int[] mValue;
  
  public GLSurfaceView$b(GLSurfaceView paramGLSurfaceView, int paramInt)
  {
    super(paramGLSurfaceView, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, paramInt, 12326, 0, 12344 });
    AppMethodBeat.i(133974);
    this.mValue = new int[1];
    this.mRedSize = 8;
    this.mGreenSize = 8;
    this.mBlueSize = 8;
    this.mAlphaSize = 0;
    this.mDepthSize = paramInt;
    this.mStencilSize = 0;
    AppMethodBeat.o(133974);
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    AppMethodBeat.i(133976);
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.mValue))
    {
      paramInt = this.mValue[0];
      AppMethodBeat.o(133976);
      return paramInt;
    }
    AppMethodBeat.o(133976);
    return 0;
  }
  
  public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    AppMethodBeat.i(133975);
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
          AppMethodBeat.o(133975);
          return localEGLConfig;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(133975);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.b
 * JD-Core Version:    0.7.0.1
 */