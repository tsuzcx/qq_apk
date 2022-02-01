package com.tencent.mm.performance.jni.fd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.b;

public class FDDumpBridge
{
  static
  {
    AppMethodBeat.i(73330);
    b.hQi.init();
    AppMethodBeat.o(73330);
  }
  
  public static String Bn(String paramString)
  {
    AppMethodBeat.i(73329);
    if (!b.hQi.hQj)
    {
      AppMethodBeat.o(73329);
      return null;
    }
    paramString = getFdPathNameNative(paramString);
    AppMethodBeat.o(73329);
    return paramString;
  }
  
  private static native String getFdPathNameNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.jni.fd.FDDumpBridge
 * JD-Core Version:    0.7.0.1
 */