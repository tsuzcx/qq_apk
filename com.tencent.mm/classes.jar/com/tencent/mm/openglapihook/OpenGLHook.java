package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

public class OpenGLHook
{
  private static final String TAG = "MicroMsg.OpenGLHook";
  private static OpenGLHook mInstance;
  private a mListener;
  
  static
  {
    AppMethodBeat.i(204083);
    System.loadLibrary("openglapihook");
    mInstance = new OpenGLHook();
    AppMethodBeat.o(204083);
  }
  
  public static OpenGLHook getInstance()
  {
    return mInstance;
  }
  
  public static String getStack()
  {
    AppMethodBeat.i(204079);
    String str = stackTraceToString(new Throwable().getStackTrace());
    AppMethodBeat.o(204079);
    return str;
  }
  
  private static native boolean hookGlDeleteBuffers(int paramInt);
  
  private static native boolean hookGlDeleteFramebuffers(int paramInt);
  
  private static native boolean hookGlDeleteRenderbuffers(int paramInt);
  
  private static native boolean hookGlDeleteTextures(int paramInt);
  
  private static native boolean hookGlGenBuffers(int paramInt);
  
  private static native boolean hookGlGenFramebuffers(int paramInt);
  
  private static native boolean hookGlGenRenderbuffers(int paramInt);
  
  private static native boolean hookGlGenTextures(int paramInt);
  
  private static native boolean hookGlGetError(int paramInt);
  
  public static void onGetError(int paramInt)
  {
    AppMethodBeat.i(204077);
    if (getInstance().mListener != null)
    {
      getInstance();
      new OpenGLInfo(paramInt);
    }
    AppMethodBeat.o(204077);
  }
  
  public static void onGlDeleteBuffers(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(204071);
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxF, k, paramString);
        b.bun().l(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.f(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204071);
  }
  
  public static void onGlDeleteFramebuffers(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(204073);
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxG, k, paramString);
        b.bun().l(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.h(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204073);
  }
  
  public static void onGlDeleteRenderbuffers(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(204076);
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxH, k, paramString);
        b.bun().l(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.j(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204076);
  }
  
  public static void onGlDeleteTextures(int[] paramArrayOfInt, String paramString)
  {
    AppMethodBeat.i(204069);
    if (paramArrayOfInt.length > 0)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxE, k, paramString);
        b.bun().l(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.d(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204069);
  }
  
  public static void onGlGenBuffers(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(204070);
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxF, k, paramString1, paramString2, paramLong, a.bul().mxn, localAtomicInteger);
        b.bun().k(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.e(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204070);
  }
  
  public static void onGlGenFramebuffers(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(204072);
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxG, k, paramString1, paramString2, paramLong, a.bul().mxn, localAtomicInteger);
        b.bun().k(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.g(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204072);
  }
  
  public static void onGlGenRenderbuffers(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(204075);
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxH, k, paramString1, paramString2, paramLong, a.bul().mxn, localAtomicInteger);
        b.bun().k(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.i(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204075);
  }
  
  public static void onGlGenTextures(int[] paramArrayOfInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(204068);
    if (paramArrayOfInt.length > 0)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(paramArrayOfInt.length);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        OpenGLInfo localOpenGLInfo = new OpenGLInfo(OpenGLInfo.a.mxE, k, paramString1, paramString2, paramLong, a.bul().mxn, localAtomicInteger);
        b.bun().k(localOpenGLInfo);
        if (getInstance().mListener != null) {
          getInstance().mListener.c(localOpenGLInfo);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(204068);
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(204081);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(204081);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfStackTraceElement.length)
    {
      if (i != 0)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        if (!localStackTraceElement.getClassName().contains("java.lang.Thread")) {
          localStringBuilder.append("\t").append(localStackTraceElement).append('\n');
        }
      }
      i += 1;
    }
    paramArrayOfStackTraceElement = localStringBuilder.toString();
    AppMethodBeat.o(204081);
    return paramArrayOfStackTraceElement;
  }
  
  public boolean hook(String paramString, int paramInt)
  {
    AppMethodBeat.i(204066);
    boolean bool;
    if (paramString.equals("glGetError"))
    {
      bool = hookGlGetError(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glGenTextures"))
    {
      bool = hookGlGenTextures(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glDeleteTextures"))
    {
      bool = hookGlDeleteTextures(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glGenBuffers"))
    {
      bool = hookGlGenBuffers(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glDeleteBuffers"))
    {
      bool = hookGlDeleteBuffers(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glGenFramebuffers"))
    {
      bool = hookGlGenFramebuffers(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glDeleteFramebuffers"))
    {
      bool = hookGlDeleteFramebuffers(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glGenRenderbuffers"))
    {
      bool = hookGlGenRenderbuffers(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    if (paramString.equals("glDeleteRenderbuffers"))
    {
      bool = hookGlDeleteRenderbuffers(paramInt);
      AppMethodBeat.o(204066);
      return bool;
    }
    AppMethodBeat.o(204066);
    return false;
  }
  
  public native boolean init();
  
  public void setListener(a parama)
  {
    this.mListener = parama;
  }
  
  public static abstract interface a
  {
    public abstract void c(OpenGLInfo paramOpenGLInfo);
    
    public abstract void d(OpenGLInfo paramOpenGLInfo);
    
    public abstract void e(OpenGLInfo paramOpenGLInfo);
    
    public abstract void f(OpenGLInfo paramOpenGLInfo);
    
    public abstract void g(OpenGLInfo paramOpenGLInfo);
    
    public abstract void h(OpenGLInfo paramOpenGLInfo);
    
    public abstract void i(OpenGLInfo paramOpenGLInfo);
    
    public abstract void j(OpenGLInfo paramOpenGLInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openglapihook.OpenGLHook
 * JD-Core Version:    0.7.0.1
 */