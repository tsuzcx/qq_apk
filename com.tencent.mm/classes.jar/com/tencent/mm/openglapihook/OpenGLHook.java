package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OpenGLHook
{
  private static final String TAG = "OpenGLHook";
  private static OpenGLHook mInstance;
  private a mListener;
  
  static
  {
    AppMethodBeat.i(187621);
    System.loadLibrary("openglapihook");
    mInstance = new OpenGLHook();
    AppMethodBeat.o(187621);
  }
  
  public static OpenGLHook getInstance()
  {
    return mInstance;
  }
  
  public static String getStack()
  {
    AppMethodBeat.i(187619);
    String str = stackTraceToString(new Throwable().getStackTrace());
    AppMethodBeat.o(187619);
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
    AppMethodBeat.i(187618);
    if (getInstance().mListener != null) {
      getInstance().mListener.a(new a(paramInt));
    }
    AppMethodBeat.o(187618);
  }
  
  public static void onGlDeleteBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187613);
    if (getInstance().mListener != null) {
      getInstance().mListener.e(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187613);
  }
  
  public static void onGlDeleteFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187615);
    if (getInstance().mListener != null) {
      getInstance().mListener.g(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187615);
  }
  
  public static void onGlDeleteRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187617);
    if (getInstance().mListener != null) {
      getInstance().mListener.i(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187617);
  }
  
  public static void onGlDeleteTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187611);
    if (getInstance().mListener != null) {
      getInstance().mListener.c(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187611);
  }
  
  public static void onGlGenBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187612);
    if (getInstance().mListener != null) {
      getInstance().mListener.d(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187612);
  }
  
  public static void onGlGenFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187614);
    if (getInstance().mListener != null) {
      getInstance().mListener.f(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187614);
  }
  
  public static void onGlGenRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187616);
    if (getInstance().mListener != null) {
      getInstance().mListener.h(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187616);
  }
  
  public static void onGlGenTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187610);
    if (getInstance().mListener != null) {
      getInstance().mListener.b(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(187610);
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(187620);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(187620);
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
    AppMethodBeat.o(187620);
    return paramArrayOfStackTraceElement;
  }
  
  public boolean hook(String paramString, int paramInt)
  {
    AppMethodBeat.i(187609);
    boolean bool;
    if (paramString.equals("glGetError"))
    {
      bool = hookGlGetError(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glGenTextures"))
    {
      bool = hookGlGenTextures(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glDeleteTextures"))
    {
      bool = hookGlDeleteTextures(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glGenBuffers"))
    {
      bool = hookGlGenBuffers(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glDeleteBuffers"))
    {
      bool = hookGlDeleteBuffers(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glGenFramebuffers"))
    {
      bool = hookGlGenFramebuffers(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glDeleteFramebuffers"))
    {
      bool = hookGlDeleteFramebuffers(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glGenRenderbuffers"))
    {
      bool = hookGlGenRenderbuffers(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    if (paramString.equals("glDeleteRenderbuffers"))
    {
      bool = hookGlDeleteRenderbuffers(paramInt);
      AppMethodBeat.o(187609);
      return bool;
    }
    AppMethodBeat.o(187609);
    return false;
  }
  
  public native boolean init();
  
  public void setListener(a parama)
  {
    this.mListener = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void b(a parama);
    
    public abstract void c(a parama);
    
    public abstract void d(a parama);
    
    public abstract void e(a parama);
    
    public abstract void f(a parama);
    
    public abstract void g(a parama);
    
    public abstract void h(a parama);
    
    public abstract void i(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openglapihook.OpenGLHook
 * JD-Core Version:    0.7.0.1
 */