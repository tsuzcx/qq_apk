package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FuncSeeker
{
  static
  {
    AppMethodBeat.i(193506);
    System.loadLibrary("openglapihook");
    AppMethodBeat.o(193506);
  }
  
  public static int getFuncIndex(String paramString)
  {
    AppMethodBeat.i(193505);
    int i;
    if (paramString.equals("glGetError"))
    {
      i = getGlGetErrorIndex();
      AppMethodBeat.o(193505);
      return i;
    }
    if ((paramString.startsWith("glGen")) || (paramString.startsWith("glDelete")))
    {
      i = getTargetFuncIndex(paramString);
      AppMethodBeat.o(193505);
      return i;
    }
    AppMethodBeat.o(193505);
    return -100;
  }
  
  private static native int getGlGetErrorIndex();
  
  private static native int getTargetFuncIndex(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openglapihook.FuncSeeker
 * JD-Core Version:    0.7.0.1
 */