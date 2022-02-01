package com.tencent.mm.dynamicbackground.view;

import android.opengl.GLException;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private EGL10 ggJ;
  Writer ggK;
  boolean ggL;
  boolean ggM;
  private int ggN;
  
  private void M(String paramString, int paramInt)
  {
    AppMethodBeat.i(103016);
    ak(paramString, Integer.toString(paramInt));
    AppMethodBeat.o(103016);
  }
  
  private void a(String paramString, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(103019);
    if (paramEGLContext == EGL10.EGL_NO_CONTEXT)
    {
      ak(paramString, "EGL10.EGL_NO_CONTEXT");
      AppMethodBeat.o(103019);
      return;
    }
    ak(paramString, toString(paramEGLContext));
    AppMethodBeat.o(103019);
  }
  
  private void a(String paramString, EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(103018);
    if (paramEGLDisplay == EGL10.EGL_DEFAULT_DISPLAY)
    {
      ak(paramString, "EGL10.EGL_DEFAULT_DISPLAY");
      AppMethodBeat.o(103018);
      return;
    }
    if (paramEGLDisplay == EGL_NO_DISPLAY)
    {
      ak(paramString, "EGL10.EGL_NO_DISPLAY");
      AppMethodBeat.o(103018);
      return;
    }
    ak(paramString, toString(paramEGLDisplay));
    AppMethodBeat.o(103018);
  }
  
  private void a(String paramString, EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(103020);
    if (paramEGLSurface == EGL10.EGL_NO_SURFACE)
    {
      ak(paramString, "EGL10.EGL_NO_SURFACE");
      AppMethodBeat.o(103020);
      return;
    }
    ak(paramString, toString(paramEGLSurface));
    AppMethodBeat.o(103020);
  }
  
  private void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(103026);
    if (paramArrayOfInt == null)
    {
      ak(paramString, "null");
      AppMethodBeat.o(103026);
      return;
    }
    ak(paramString, c(paramArrayOfInt.length, paramArrayOfInt));
    AppMethodBeat.o(103026);
  }
  
  private void aQ(Object paramObject)
  {
    AppMethodBeat.i(103024);
    vQ(toString(paramObject));
    AppMethodBeat.o(103024);
  }
  
  private void ak(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103013);
    int i = this.ggN;
    this.ggN = (i + 1);
    if (i > 0) {
      log(", ");
    }
    if (this.ggL) {
      log(paramString1 + "=");
    }
    log(paramString2);
    AppMethodBeat.o(103013);
  }
  
  private static String b(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(103029);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int j = paramArrayOfObject.length;
    int i = 0;
    if (i < paramInt)
    {
      int k = i + 0;
      localStringBuilder.append(" [" + k + "] = ");
      if ((k < 0) || (k >= j)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfObject[k]);
      }
    }
    localStringBuilder.append("}");
    paramArrayOfObject = localStringBuilder.toString();
    AppMethodBeat.o(103029);
    return paramArrayOfObject;
  }
  
  private static String c(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(103028);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\n");
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < paramInt)
    {
      int k = i + 0;
      localStringBuilder.append(" [" + k + "] = ");
      if ((k < 0) || (k >= j)) {
        localStringBuilder.append("out of bounds");
      }
      for (;;)
      {
        localStringBuilder.append('\n');
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfInt[k]);
      }
    }
    localStringBuilder.append("}");
    paramArrayOfInt = localStringBuilder.toString();
    AppMethodBeat.o(103028);
    return paramArrayOfInt;
  }
  
  private void c(String paramString, Object paramObject)
  {
    AppMethodBeat.i(103017);
    ak(paramString, toString(paramObject));
    AppMethodBeat.o(103017);
  }
  
  private void checkError()
  {
    AppMethodBeat.i(103009);
    int i = this.ggJ.eglGetError();
    if (i != 12288)
    {
      Object localObject = "eglError: " + getErrorString(i);
      vO((String)localObject);
      if (this.ggM)
      {
        localObject = new GLException(i, (String)localObject);
        AppMethodBeat.o(103009);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(103009);
  }
  
  private void da(boolean paramBoolean)
  {
    AppMethodBeat.i(103023);
    vQ(Boolean.toString(paramBoolean));
    AppMethodBeat.o(103023);
  }
  
  private void end()
  {
    AppMethodBeat.i(103014);
    log(");\n");
    flush();
    AppMethodBeat.o(103014);
  }
  
  private void flush()
  {
    AppMethodBeat.i(103015);
    try
    {
      this.ggK.flush();
      AppMethodBeat.o(103015);
      return;
    }
    catch (IOException localIOException)
    {
      this.ggK = null;
      AppMethodBeat.o(103015);
    }
  }
  
  public static String getErrorString(int paramInt)
  {
    AppMethodBeat.i(103031);
    switch (paramInt)
    {
    default: 
      String str = lT(paramInt);
      AppMethodBeat.o(103031);
      return str;
    case 12288: 
      AppMethodBeat.o(103031);
      return "EGL_SUCCESS";
    case 12289: 
      AppMethodBeat.o(103031);
      return "EGL_NOT_INITIALIZED";
    case 12290: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_ACCESS";
    case 12291: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_ALLOC";
    case 12292: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_ATTRIBUTE";
    case 12293: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_CONFIG";
    case 12294: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_CONTEXT";
    case 12295: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_CURRENT_SURFACE";
    case 12296: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_DISPLAY";
    case 12297: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_MATCH";
    case 12298: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12299: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_NATIVE_WINDOW";
    case 12300: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_PARAMETER";
    case 12301: 
      AppMethodBeat.o(103031);
      return "EGL_BAD_SURFACE";
    }
    AppMethodBeat.o(103031);
    return "EGL_CONTEXT_LOST";
  }
  
  private void j(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(103027);
    if (paramArrayOfObject == null)
    {
      ak(paramString, "null");
      AppMethodBeat.o(103027);
      return;
    }
    ak(paramString, b(paramArrayOfObject.length, paramArrayOfObject));
    AppMethodBeat.o(103027);
  }
  
  private void lS(int paramInt)
  {
    AppMethodBeat.i(103022);
    vQ(Integer.toString(paramInt));
    AppMethodBeat.o(103022);
  }
  
  private static String lT(int paramInt)
  {
    AppMethodBeat.i(103030);
    String str = "0x" + Integer.toHexString(paramInt);
    AppMethodBeat.o(103030);
    return str;
  }
  
  private void log(String paramString)
  {
    AppMethodBeat.i(103011);
    try
    {
      this.ggK.write(paramString);
      AppMethodBeat.o(103011);
      return;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(103011);
    }
  }
  
  private static String toString(Object paramObject)
  {
    AppMethodBeat.i(103025);
    if (paramObject == null)
    {
      AppMethodBeat.o(103025);
      return "null";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(103025);
    return paramObject;
  }
  
  private void vO(String paramString)
  {
    AppMethodBeat.i(103010);
    log(paramString + '\n');
    AppMethodBeat.o(103010);
  }
  
  private void vP(String paramString)
  {
    AppMethodBeat.i(103012);
    log(paramString + '(');
    this.ggN = 0;
    AppMethodBeat.o(103012);
  }
  
  private void vQ(String paramString)
  {
    AppMethodBeat.i(103021);
    log(" returns " + paramString + ";\n");
    flush();
    AppMethodBeat.o(103021);
  }
  
  public final boolean eglChooseConfig(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt1, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(102985);
    vP("eglChooseConfig");
    a("display", paramEGLDisplay);
    a("attrib_list", paramArrayOfInt1);
    M("config_size", paramInt);
    end();
    boolean bool = this.ggJ.eglChooseConfig(paramEGLDisplay, paramArrayOfInt1, paramArrayOfEGLConfig, paramInt, paramArrayOfInt2);
    j("configs", paramArrayOfEGLConfig);
    a("num_config", paramArrayOfInt2);
    da(bool);
    checkError();
    AppMethodBeat.o(102985);
    return bool;
  }
  
  public final boolean eglCopyBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, Object paramObject)
  {
    AppMethodBeat.i(102986);
    vP("eglCopyBuffers");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    c("native_pixmap", paramObject);
    end();
    boolean bool = this.ggJ.eglCopyBuffers(paramEGLDisplay, paramEGLSurface, paramObject);
    da(bool);
    checkError();
    AppMethodBeat.o(102986);
    return bool;
  }
  
  public final EGLContext eglCreateContext(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102987);
    vP("eglCreateContext");
    a("display", paramEGLDisplay);
    c("config", paramEGLConfig);
    a("share_context", paramEGLContext);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.ggJ.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, paramArrayOfInt);
    aQ(paramEGLDisplay);
    checkError();
    AppMethodBeat.o(102987);
    return paramEGLDisplay;
  }
  
  public final EGLSurface eglCreatePbufferSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102988);
    vP("eglCreatePbufferSurface");
    a("display", paramEGLDisplay);
    c("config", paramEGLConfig);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.ggJ.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, paramArrayOfInt);
    aQ(paramEGLDisplay);
    checkError();
    AppMethodBeat.o(102988);
    return paramEGLDisplay;
  }
  
  public final EGLSurface eglCreatePixmapSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102989);
    vP("eglCreatePixmapSurface");
    a("display", paramEGLDisplay);
    c("config", paramEGLConfig);
    c("native_pixmap", paramObject);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.ggJ.eglCreatePixmapSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
    aQ(paramEGLDisplay);
    checkError();
    AppMethodBeat.o(102989);
    return paramEGLDisplay;
  }
  
  public final EGLSurface eglCreateWindowSurface(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102990);
    vP("eglCreateWindowSurface");
    a("display", paramEGLDisplay);
    c("config", paramEGLConfig);
    c("native_window", paramObject);
    a("attrib_list", paramArrayOfInt);
    end();
    paramEGLDisplay = this.ggJ.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, paramArrayOfInt);
    aQ(paramEGLDisplay);
    checkError();
    AppMethodBeat.o(102990);
    return paramEGLDisplay;
  }
  
  public final boolean eglDestroyContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(102991);
    vP("eglDestroyContext");
    a("display", paramEGLDisplay);
    a("context", paramEGLContext);
    end();
    boolean bool = this.ggJ.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    da(bool);
    checkError();
    AppMethodBeat.o(102991);
    return bool;
  }
  
  public final boolean eglDestroySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(102992);
    vP("eglDestroySurface");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    end();
    boolean bool = this.ggJ.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
    da(bool);
    checkError();
    AppMethodBeat.o(102992);
    return bool;
  }
  
  public final boolean eglGetConfigAttrib(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102993);
    vP("eglGetConfigAttrib");
    a("display", paramEGLDisplay);
    c("config", paramEGLConfig);
    M("attribute", paramInt);
    end();
    boolean bool = this.ggJ.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, paramArrayOfInt);
    a("value", paramArrayOfInt);
    da(bool);
    checkError();
    AppMethodBeat.o(102993);
    return false;
  }
  
  public final boolean eglGetConfigs(EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102994);
    vP("eglGetConfigs");
    a("display", paramEGLDisplay);
    M("config_size", paramInt);
    end();
    boolean bool = this.ggJ.eglGetConfigs(paramEGLDisplay, paramArrayOfEGLConfig, paramInt, paramArrayOfInt);
    j("configs", paramArrayOfEGLConfig);
    a("num_config", paramArrayOfInt);
    da(bool);
    checkError();
    AppMethodBeat.o(102994);
    return bool;
  }
  
  public final EGLContext eglGetCurrentContext()
  {
    AppMethodBeat.i(102995);
    vP("eglGetCurrentContext");
    end();
    EGLContext localEGLContext = this.ggJ.eglGetCurrentContext();
    aQ(localEGLContext);
    checkError();
    AppMethodBeat.o(102995);
    return localEGLContext;
  }
  
  public final EGLDisplay eglGetCurrentDisplay()
  {
    AppMethodBeat.i(102996);
    vP("eglGetCurrentDisplay");
    end();
    EGLDisplay localEGLDisplay = this.ggJ.eglGetCurrentDisplay();
    aQ(localEGLDisplay);
    checkError();
    AppMethodBeat.o(102996);
    return localEGLDisplay;
  }
  
  public final EGLSurface eglGetCurrentSurface(int paramInt)
  {
    AppMethodBeat.i(102997);
    vP("eglGetCurrentSurface");
    M("readdraw", paramInt);
    end();
    EGLSurface localEGLSurface = this.ggJ.eglGetCurrentSurface(paramInt);
    aQ(localEGLSurface);
    checkError();
    AppMethodBeat.o(102997);
    return localEGLSurface;
  }
  
  public final EGLDisplay eglGetDisplay(Object paramObject)
  {
    AppMethodBeat.i(102998);
    vP("eglGetDisplay");
    c("native_display", paramObject);
    end();
    paramObject = this.ggJ.eglGetDisplay(paramObject);
    aQ(paramObject);
    checkError();
    AppMethodBeat.o(102998);
    return paramObject;
  }
  
  public final int eglGetError()
  {
    AppMethodBeat.i(102999);
    vP("eglGetError");
    end();
    int i = this.ggJ.eglGetError();
    vQ(getErrorString(i));
    AppMethodBeat.o(102999);
    return i;
  }
  
  public final boolean eglInitialize(EGLDisplay paramEGLDisplay, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(103000);
    vP("eglInitialize");
    a("display", paramEGLDisplay);
    end();
    boolean bool = this.ggJ.eglInitialize(paramEGLDisplay, paramArrayOfInt);
    da(bool);
    a("major_minor", paramArrayOfInt);
    checkError();
    AppMethodBeat.o(103000);
    return bool;
  }
  
  public final boolean eglMakeCurrent(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(103001);
    vP("eglMakeCurrent");
    a("display", paramEGLDisplay);
    a("draw", paramEGLSurface1);
    a("read", paramEGLSurface2);
    a("context", paramEGLContext);
    end();
    boolean bool = this.ggJ.eglMakeCurrent(paramEGLDisplay, paramEGLSurface1, paramEGLSurface2, paramEGLContext);
    da(bool);
    checkError();
    AppMethodBeat.o(103001);
    return bool;
  }
  
  public final boolean eglQueryContext(EGLDisplay paramEGLDisplay, EGLContext paramEGLContext, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(103002);
    vP("eglQueryContext");
    a("display", paramEGLDisplay);
    a("context", paramEGLContext);
    M("attribute", paramInt);
    end();
    boolean bool = this.ggJ.eglQueryContext(paramEGLDisplay, paramEGLContext, paramInt, paramArrayOfInt);
    lS(paramArrayOfInt[0]);
    da(bool);
    checkError();
    AppMethodBeat.o(103002);
    return bool;
  }
  
  public final String eglQueryString(EGLDisplay paramEGLDisplay, int paramInt)
  {
    AppMethodBeat.i(103003);
    vP("eglQueryString");
    a("display", paramEGLDisplay);
    M("name", paramInt);
    end();
    paramEGLDisplay = this.ggJ.eglQueryString(paramEGLDisplay, paramInt);
    vQ(paramEGLDisplay);
    checkError();
    AppMethodBeat.o(103003);
    return paramEGLDisplay;
  }
  
  public final boolean eglQuerySurface(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(103004);
    vP("eglQuerySurface");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    M("attribute", paramInt);
    end();
    boolean bool = this.ggJ.eglQuerySurface(paramEGLDisplay, paramEGLSurface, paramInt, paramArrayOfInt);
    lS(paramArrayOfInt[0]);
    da(bool);
    checkError();
    AppMethodBeat.o(103004);
    return bool;
  }
  
  public final boolean eglSwapBuffers(EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    AppMethodBeat.i(103005);
    vP("eglSwapBuffers");
    a("display", paramEGLDisplay);
    a("surface", paramEGLSurface);
    end();
    boolean bool = this.ggJ.eglSwapBuffers(paramEGLDisplay, paramEGLSurface);
    da(bool);
    checkError();
    AppMethodBeat.o(103005);
    return bool;
  }
  
  public final boolean eglTerminate(EGLDisplay paramEGLDisplay)
  {
    AppMethodBeat.i(103006);
    vP("eglTerminate");
    a("display", paramEGLDisplay);
    end();
    boolean bool = this.ggJ.eglTerminate(paramEGLDisplay);
    da(bool);
    checkError();
    AppMethodBeat.o(103006);
    return bool;
  }
  
  public final boolean eglWaitGL()
  {
    AppMethodBeat.i(103007);
    vP("eglWaitGL");
    end();
    boolean bool = this.ggJ.eglWaitGL();
    da(bool);
    checkError();
    AppMethodBeat.o(103007);
    return bool;
  }
  
  public final boolean eglWaitNative(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(103008);
    vP("eglWaitNative");
    M("engine", paramInt);
    c("bindTarget", paramObject);
    end();
    boolean bool = this.ggJ.eglWaitNative(paramInt, paramObject);
    da(bool);
    checkError();
    AppMethodBeat.o(103008);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.GameGLSurfaceView.g
 * JD-Core Version:    0.7.0.1
 */