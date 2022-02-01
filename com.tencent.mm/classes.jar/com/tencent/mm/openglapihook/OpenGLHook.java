package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OpenGLHook
{
  private static final String TAG = "OpenGLHook";
  private static OpenGLHook mInstance;
  private a mListener;
  
  static
  {
    AppMethodBeat.i(186983);
    System.loadLibrary("openglapihook");
    mInstance = new OpenGLHook();
    AppMethodBeat.o(186983);
  }
  
  public static OpenGLHook getInstance()
  {
    return mInstance;
  }
  
  public static String getStack()
  {
    AppMethodBeat.i(186981);
    String str = stackTraceToString(new Throwable().getStackTrace());
    AppMethodBeat.o(186981);
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
    AppMethodBeat.i(186980);
    if (getInstance().mListener != null) {
      getInstance().mListener.a(new a(paramInt));
    }
    AppMethodBeat.o(186980);
  }
  
  public static void onGlDeleteBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186975);
    if (getInstance().mListener != null) {
      getInstance().mListener.e(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186975);
  }
  
  public static void onGlDeleteFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186977);
    if (getInstance().mListener != null) {
      getInstance().mListener.g(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186977);
  }
  
  public static void onGlDeleteRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186979);
    if (getInstance().mListener != null) {
      getInstance().mListener.i(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186979);
  }
  
  public static void onGlDeleteTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186973);
    if (getInstance().mListener != null) {
      getInstance().mListener.c(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186973);
  }
  
  public static void onGlGenBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186974);
    if (getInstance().mListener != null) {
      getInstance().mListener.d(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186974);
  }
  
  public static void onGlGenFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186976);
    if (getInstance().mListener != null) {
      getInstance().mListener.f(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186976);
  }
  
  public static void onGlGenRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186978);
    if (getInstance().mListener != null) {
      getInstance().mListener.h(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186978);
  }
  
  public static void onGlGenTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186972);
    if (getInstance().mListener != null) {
      getInstance().mListener.b(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(186972);
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(186982);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(186982);
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
    AppMethodBeat.o(186982);
    return paramArrayOfStackTraceElement;
  }
  
  public boolean hook(String paramString, int paramInt)
  {
    AppMethodBeat.i(186971);
    boolean bool;
    if (paramString.equals("glGetError"))
    {
      bool = hookGlGetError(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glGenTextures"))
    {
      bool = hookGlGenTextures(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glDeleteTextures"))
    {
      bool = hookGlDeleteTextures(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glGenBuffers"))
    {
      bool = hookGlGenBuffers(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glDeleteBuffers"))
    {
      bool = hookGlDeleteBuffers(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glGenFramebuffers"))
    {
      bool = hookGlGenFramebuffers(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glDeleteFramebuffers"))
    {
      bool = hookGlDeleteFramebuffers(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glGenRenderbuffers"))
    {
      bool = hookGlGenRenderbuffers(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    if (paramString.equals("glDeleteRenderbuffers"))
    {
      bool = hookGlDeleteRenderbuffers(paramInt);
      AppMethodBeat.o(186971);
      return bool;
    }
    AppMethodBeat.o(186971);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openglapihook.OpenGLHook
 * JD-Core Version:    0.7.0.1
 */