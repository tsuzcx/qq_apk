package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OpenGLHook
{
  private static final String TAG = "OpenGLHook";
  private static OpenGLHook mInstance;
  private a mListener;
  
  static
  {
    AppMethodBeat.i(193519);
    System.loadLibrary("openglapihook");
    mInstance = new OpenGLHook();
    AppMethodBeat.o(193519);
  }
  
  public static OpenGLHook getInstance()
  {
    return mInstance;
  }
  
  public static String getStack()
  {
    AppMethodBeat.i(193517);
    String str = stackTraceToString(new Throwable().getStackTrace());
    AppMethodBeat.o(193517);
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
    AppMethodBeat.i(193516);
    if (getInstance().mListener != null) {
      getInstance().mListener.a(new a(paramInt));
    }
    AppMethodBeat.o(193516);
  }
  
  public static void onGlDeleteBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193511);
    if (getInstance().mListener != null) {
      getInstance().mListener.e(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193511);
  }
  
  public static void onGlDeleteFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193513);
    if (getInstance().mListener != null) {
      getInstance().mListener.g(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193513);
  }
  
  public static void onGlDeleteRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193515);
    if (getInstance().mListener != null) {
      getInstance().mListener.i(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193515);
  }
  
  public static void onGlDeleteTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193509);
    if (getInstance().mListener != null) {
      getInstance().mListener.c(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193509);
  }
  
  public static void onGlGenBuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193510);
    if (getInstance().mListener != null) {
      getInstance().mListener.d(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193510);
  }
  
  public static void onGlGenFramebuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193512);
    if (getInstance().mListener != null) {
      getInstance().mListener.f(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193512);
  }
  
  public static void onGlGenRenderbuffers(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193514);
    if (getInstance().mListener != null) {
      getInstance().mListener.h(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193514);
  }
  
  public static void onGlGenTextures(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193508);
    if (getInstance().mListener != null) {
      getInstance().mListener.b(new a(paramArrayOfInt));
    }
    AppMethodBeat.o(193508);
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(193518);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(193518);
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
    AppMethodBeat.o(193518);
    return paramArrayOfStackTraceElement;
  }
  
  public boolean hook(String paramString, int paramInt)
  {
    AppMethodBeat.i(193507);
    boolean bool;
    if (paramString.equals("glGetError"))
    {
      bool = hookGlGetError(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glGenTextures"))
    {
      bool = hookGlGenTextures(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glDeleteTextures"))
    {
      bool = hookGlDeleteTextures(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glGenBuffers"))
    {
      bool = hookGlGenBuffers(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glDeleteBuffers"))
    {
      bool = hookGlDeleteBuffers(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glGenFramebuffers"))
    {
      bool = hookGlGenFramebuffers(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glDeleteFramebuffers"))
    {
      bool = hookGlDeleteFramebuffers(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glGenRenderbuffers"))
    {
      bool = hookGlGenRenderbuffers(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    if (paramString.equals("glDeleteRenderbuffers"))
    {
      bool = hookGlDeleteRenderbuffers(paramInt);
      AppMethodBeat.o(193507);
      return bool;
    }
    AppMethodBeat.o(193507);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openglapihook.OpenGLHook
 * JD-Core Version:    0.7.0.1
 */