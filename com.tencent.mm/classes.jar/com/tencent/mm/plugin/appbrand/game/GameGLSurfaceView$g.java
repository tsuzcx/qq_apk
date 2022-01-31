package com.tencent.mm.plugin.appbrand.game;

import android.opengl.GLException;
import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class GameGLSurfaceView$g
  implements EGL11
{
  private EGL10 fYV;
  Writer fYW;
  boolean fYX;
  boolean fYY;
  private int fYZ;
  
  private void a(String paramString, EGLContext paramEGLContext)
  {
    if (paramEGLContext == EGL10.EGL_NO_CONTEXT)
    {
      bs(paramString, "EGL10.EGL_NO_CONTEXT");
      return;
    }
    bs(paramString, toString(paramEGLContext));
  }
  
  private void a(String paramString, EGLDisplay paramEGLDisplay)
  {
    if (paramEGLDisplay == EGL10.EGL_DEFAULT_DISPLAY)
    {
      bs(paramString, "EGL10.EGL_DEFAULT_DISPLAY");
      return;
    }
    if (paramEGLDisplay == EGL_NO_DISPLAY)
    {
      bs(paramString, "EGL10.EGL_NO_DISPLAY");
      return;
    }
    bs(paramString, toString(paramEGLDisplay));
  }
  
  private void a(String paramString, EGLSurface paramEGLSurface)
  {
    if (paramEGLSurface == EGL10.EGL_NO_SURFACE)
    {
      bs(paramString, "EGL10.EGL_NO_SURFACE");
      return;
    }
    bs(paramString, toString(paramEGLSurface));
  }
  
  private void a(String paramString, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
    {
      bs(paramString, "null");
      return;
    }
    int j = paramArrayOfInt.length;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int k = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int m = i + 0;
      localStringBuilder.append(" [" + m + "] = ");
      if ((m < 0) || (m >= k)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfInt[m]);
      }
    }
    localStringBuilder.append("}");
    bs(paramString, localStringBuilder.toString());
  }
  
  private void aL(String paramString, int paramInt)
  {
    bs(paramString, Integer.toString(paramInt));
  }
  
  private void aO(Object paramObject)
  {
    to(toString(paramObject));
  }
  
  private void bs(String paramString1, String paramString2)
  {
    int i = this.fYZ;
    this.fYZ = (i + 1);
    if (i > 0) {
      tn(", ");
    }
    if (this.fYX) {
      tn(paramString1 + "=");
    }
    tn(paramString2);
  }
  
  private void cQ(boolean paramBoolean)
  {
    to(Boolean.toString(paramBoolean));
  }
  
  private void checkError()
  {
    int i = this.fYV.eglGetError();
    if (i != 12288)
    {
      String str = "eglError: " + getErrorString(i);
      tn(str + '\n');
      if (this.fYY) {
        throw new GLException(i, str);
      }
    }
  }
  
  private void end()
  {
    tn(");\n");
    flush();
  }
  
  private void flush()
  {
    try
    {
      this.fYW.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.fYW = null;
    }
  }
  
  public static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0x" + Integer.toHexString(paramInt);
    case 12288: 
      return "EGL_SUCCESS";
    case 12289: 
      return "EGL_NOT_INITIALIZED";
    case 12290: 
      return "EGL_BAD_ACCESS";
    case 12291: 
      return "EGL_BAD_ALLOC";
    case 12292: 
      return "EGL_BAD_ATTRIBUTE";
    case 12293: 
      return "EGL_BAD_CONFIG";
    case 12294: 
      return "EGL_BAD_CONTEXT";
    case 12295: 
      return "EGL_BAD_CURRENT_SURFACE";
    case 12296: 
      return "EGL_BAD_DISPLAY";
    case 12297: 
      return "EGL_BAD_MATCH";
    case 12298: 
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12299: 
      return "EGL_BAD_NATIVE_WINDOW";
    case 12300: 
      return "EGL_BAD_PARAMETER";
    case 12301: 
      return "EGL_BAD_SURFACE";
    }
    return "EGL_CONTEXT_LOST";
  }
  
  private void k(String paramString, Object paramObject)
  {
    bs(paramString, toString(paramObject));
  }
  
  private void kP(int paramInt)
  {
    to(Integer.toString(paramInt));
  }
  
  private void l(String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      bs(paramString, "null");
      return;
    }
    int j = paramArrayOfObject.length;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int k = paramArrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      int m = i + 0;
      localStringBuilder.append(" [" + m + "] = ");
      if ((m < 0) || (m >= k)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfObject[m]);
      }
    }
    localStringBuilder.append("}");
    bs(paramString, localStringBuilder.toString());
  }
  
  private void rR(String paramString)
  {
    tn(paramString + '(');
    this.fYZ = 0;
  }
  
  private void tn(String paramString)
  {
    try
    {
      this.fYW.write(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  private void to(String paramString)
  {
    tn(" returns " + paramString + ";\n");
    flush();
  }
  
  private static String toString(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.toString();
  }
  
  public final boolean eglChooseConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt1, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt2)
  {
    rR("eglChooseConfig");
    a("display", paramEGLDisplay);
    a("attrib_list", paramArrayOfInt1);
    aL("config_size", paramInt);
    end();
    boolean bool = this.fYV.eglChooseConfig(paramEGLDisplay, paramArrayOfInt1, paramArrayOfEGLConfig, paramInt, paramArrayOfInt2);
    l("configs", paramArrayOfEGLConfig);
    a("num_config", paramArrayOfInt2);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglCopyBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, Object paramObject)
  {
    rR("eglCopyBuffers");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    k("native_pixmap", paramObject);
    end();
    boolean bool = this.fYV.eglCopyBuffers(paramEGLDisplay, paramEGLSurface, paramObject);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final EGLContext eglCreateContext(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, int[] paramArrayOfInt)
  {
    rR("eglCreateContext");
    a("display", paramEGLDisplay);
    k("config", paramEGLConfig);
    a("share_context", paramEGLContext);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.fYV.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, paramArrayOfInt);
    aO(paramEGLDisplay);
    checkError();
    return paramEGLDisplay;
  }
  
  public final EGLSurface eglCreatePbufferSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int[] paramArrayOfInt)
  {
    rR("eglCreatePbufferSurface");
    a("display", paramEGLDisplay);
    k("config", paramEGLConfig);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.fYV.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, paramArrayOfInt);
    aO(paramEGLDisplay);
    checkError();
    return paramEGLDisplay;
  }
  
  public final EGLSurface eglCreatePixmapSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
  {
    rR("eglCreatePixmapSurface");
    a("display", paramEGLDisplay);
    k("config", paramEGLConfig);
    k("native_pixmap", paramObject);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.fYV.eglCreatePixmapSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
    aO(paramEGLDisplay);
    checkError();
    return paramEGLDisplay;
  }
  
  public final EGLSurface eglCreateWindowSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
  {
    rR("eglCreateWindowSurface");
    a("display", paramEGLDisplay);
    k("config", paramEGLConfig);
    k("native_window", paramObject);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.fYV.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
    aO(paramEGLDisplay);
    checkError();
    return paramEGLDisplay;
  }
  
  public final boolean eglDestroyContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    rR("eglDestroyContext");
    a("display", paramEGLDisplay);
    a("context", paramEGLContext);
    end();
    boolean bool = this.fYV.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglDestroySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    rR("eglDestroySurface");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    end();
    boolean bool = this.fYV.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglGetConfigAttrib(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, int[] paramArrayOfInt)
  {
    rR("eglGetConfigAttrib");
    a("display", paramEGLDisplay);
    k("config", paramEGLConfig);
    aL("attribute", paramInt);
    end();
    boolean bool = this.fYV.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, paramArrayOfInt);
    a("value", paramArrayOfInt);
    cQ(bool);
    checkError();
    return false;
  }
  
  public final boolean eglGetConfigs(EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt)
  {
    rR("eglGetConfigs");
    a("display", paramEGLDisplay);
    aL("config_size", paramInt);
    end();
    boolean bool = this.fYV.eglGetConfigs(paramEGLDisplay, paramArrayOfEGLConfig, paramInt, paramArrayOfInt);
    l("configs", paramArrayOfEGLConfig);
    a("num_config", paramArrayOfInt);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final EGLContext eglGetCurrentContext()
  {
    rR("eglGetCurrentContext");
    end();
    EGLContext localEGLContext = this.fYV.eglGetCurrentContext();
    aO(localEGLContext);
    checkError();
    return localEGLContext;
  }
  
  public final EGLDisplay eglGetCurrentDisplay()
  {
    rR("eglGetCurrentDisplay");
    end();
    EGLDisplay localEGLDisplay = this.fYV.eglGetCurrentDisplay();
    aO(localEGLDisplay);
    checkError();
    return localEGLDisplay;
  }
  
  public final EGLSurface eglGetCurrentSurface(int paramInt)
  {
    rR("eglGetCurrentSurface");
    aL("readdraw", paramInt);
    end();
    EGLSurface localEGLSurface = this.fYV.eglGetCurrentSurface(paramInt);
    aO(localEGLSurface);
    checkError();
    return localEGLSurface;
  }
  
  public final EGLDisplay eglGetDisplay(Object paramObject)
  {
    rR("eglGetDisplay");
    k("native_display", paramObject);
    end();
    paramObject = this.fYV.eglGetDisplay(paramObject);
    aO(paramObject);
    checkError();
    return paramObject;
  }
  
  public final int eglGetError()
  {
    rR("eglGetError");
    end();
    int i = this.fYV.eglGetError();
    to(getErrorString(i));
    return i;
  }
  
  public final boolean eglInitialize(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    rR("eglInitialize");
    a("display", paramEGLDisplay);
    end();
    boolean bool = this.fYV.eglInitialize(paramEGLDisplay, paramArrayOfInt);
    cQ(bool);
    a("major_minor", paramArrayOfInt);
    checkError();
    return bool;
  }
  
  public final boolean eglMakeCurrent(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2, EGLContext paramEGLContext)
  {
    rR("eglMakeCurrent");
    a("display", paramEGLDisplay);
    a("draw", paramEGLSurface1);
    a("read", paramEGLSurface2);
    a("context", paramEGLContext);
    end();
    boolean bool = this.fYV.eglMakeCurrent(paramEGLDisplay, paramEGLSurface1, paramEGLSurface2, paramEGLContext);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglQueryContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext, int paramInt, int[] paramArrayOfInt)
  {
    rR("eglQueryContext");
    a("display", paramEGLDisplay);
    a("context", paramEGLContext);
    aL("attribute", paramInt);
    end();
    boolean bool = this.fYV.eglQueryContext(paramEGLDisplay, paramEGLContext, paramInt, paramArrayOfInt);
    kP(paramArrayOfInt[0]);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final String eglQueryString(EGLDisplay paramEGLDisplay, int paramInt)
  {
    rR("eglQueryString");
    a("display", paramEGLDisplay);
    aL("name", paramInt);
    end();
    paramEGLDisplay = this.fYV.eglQueryString(paramEGLDisplay, paramInt);
    to(paramEGLDisplay);
    checkError();
    return paramEGLDisplay;
  }
  
  public final boolean eglQuerySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, int paramInt, int[] paramArrayOfInt)
  {
    rR("eglQuerySurface");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    aL("attribute", paramInt);
    end();
    boolean bool = this.fYV.eglQuerySurface(paramEGLDisplay, paramEGLSurface, paramInt, paramArrayOfInt);
    kP(paramArrayOfInt[0]);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglSwapBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    rR("eglSwapBuffers");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    end();
    boolean bool = this.fYV.eglSwapBuffers(paramEGLDisplay, paramEGLSurface);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglTerminate(EGLDisplay paramEGLDisplay)
  {
    rR("eglTerminate");
    a("display", paramEGLDisplay);
    end();
    boolean bool = this.fYV.eglTerminate(paramEGLDisplay);
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglWaitGL()
  {
    rR("eglWaitGL");
    end();
    boolean bool = this.fYV.eglWaitGL();
    cQ(bool);
    checkError();
    return bool;
  }
  
  public final boolean eglWaitNative(int paramInt, Object paramObject)
  {
    rR("eglWaitNative");
    aL("engine", paramInt);
    k("bindTarget", paramObject);
    end();
    boolean bool = this.fYV.eglWaitNative(paramInt, paramObject);
    cQ(bool);
    checkError();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g
 * JD-Core Version:    0.7.0.1
 */