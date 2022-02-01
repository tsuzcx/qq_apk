package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OpenGLHook
{
  private static final String TAG = "OpenGLHook";
  private static OpenGLHook mInstance;
  private a mListener;
  
  static
  {
    AppMethodBeat.i(186146);
    System.loadLibrary("openglapihook");
    mInstance = new OpenGLHook();
    AppMethodBeat.o(186146);
  }
  
  public static OpenGLHook getInstance()
  {
    return mInstance;
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
    AppMethodBeat.i(186145);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGetError(paramInt);
    }
    AppMethodBeat.o(186145);
  }
  
  public static void onGlDeleteBuffers(String paramString)
  {
    AppMethodBeat.i(210169);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlDeleteBuffers(parseString(paramString));
    }
    AppMethodBeat.o(210169);
  }
  
  public static void onGlDeleteFramebuffers(String paramString)
  {
    AppMethodBeat.i(210171);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlDeleteFramebuffers(parseString(paramString));
    }
    AppMethodBeat.o(210171);
  }
  
  public static void onGlDeleteRenderbuffers(String paramString)
  {
    AppMethodBeat.i(210173);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlDeleteRenderbuffers(parseString(paramString));
    }
    AppMethodBeat.o(210173);
  }
  
  public static void onGlDeleteTextures(String paramString)
  {
    AppMethodBeat.i(210167);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlDeleteTextures(parseString(paramString));
    }
    AppMethodBeat.o(210167);
  }
  
  public static void onGlGenBuffers(String paramString)
  {
    AppMethodBeat.i(210168);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlGenBuffers(parseString(paramString));
    }
    AppMethodBeat.o(210168);
  }
  
  public static void onGlGenFramebuffers(String paramString)
  {
    AppMethodBeat.i(210170);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlGenFramebuffers(parseString(paramString));
    }
    AppMethodBeat.o(210170);
  }
  
  public static void onGlGenRenderbuffers(String paramString)
  {
    AppMethodBeat.i(210172);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlGenRenderbuffers(parseString(paramString));
    }
    AppMethodBeat.o(210172);
  }
  
  public static void onGlGenTextures(String paramString)
  {
    AppMethodBeat.i(210166);
    if (getInstance().mListener != null) {
      getInstance().mListener.onGlGenTextures(parseString(paramString));
    }
    AppMethodBeat.o(210166);
  }
  
  private static int[] parseString(String paramString)
  {
    AppMethodBeat.i(210174);
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = new int[1];
      AppMethodBeat.o(210174);
      return paramString;
    }
    int[] arrayOfInt = new int[paramString.length()];
    int i = 0;
    while (i < paramString.length())
    {
      arrayOfInt[i] = Integer.parseInt(String.valueOf(paramString.charAt(i)));
      i += 1;
    }
    AppMethodBeat.o(210174);
    return arrayOfInt;
  }
  
  public boolean hook(String paramString, int paramInt)
  {
    AppMethodBeat.i(186136);
    boolean bool;
    if (paramString.equals("glGetError"))
    {
      bool = hookGlGetError(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glGenTextures"))
    {
      bool = hookGlGenTextures(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glDeleteTextures"))
    {
      bool = hookGlDeleteTextures(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glGenBuffers"))
    {
      bool = hookGlGenBuffers(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glDeleteBuffers"))
    {
      bool = hookGlDeleteBuffers(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glGenFramebuffers"))
    {
      bool = hookGlGenFramebuffers(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glDeleteFramebuffers"))
    {
      bool = hookGlDeleteFramebuffers(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glGenRenderbuffers"))
    {
      bool = hookGlGenRenderbuffers(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    if (paramString.equals("glDeleteRenderbuffers"))
    {
      bool = hookGlDeleteRenderbuffers(paramInt);
      AppMethodBeat.o(186136);
      return bool;
    }
    AppMethodBeat.o(186136);
    return false;
  }
  
  public native boolean init();
  
  public void setListener(a parama)
  {
    this.mListener = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onGetError(int paramInt);
    
    public abstract void onGlDeleteBuffers(int[] paramArrayOfInt);
    
    public abstract void onGlDeleteFramebuffers(int[] paramArrayOfInt);
    
    public abstract void onGlDeleteRenderbuffers(int[] paramArrayOfInt);
    
    public abstract void onGlDeleteTextures(int[] paramArrayOfInt);
    
    public abstract void onGlGenBuffers(int[] paramArrayOfInt);
    
    public abstract void onGlGenFramebuffers(int[] paramArrayOfInt);
    
    public abstract void onGlGenRenderbuffers(int[] paramArrayOfInt);
    
    public abstract void onGlGenTextures(int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openglapihook.OpenGLHook
 * JD-Core Version:    0.7.0.1
 */