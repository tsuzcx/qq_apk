package com.tencent.kinda;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConstructProxy
{
  public static void proxyDefaultConstructor(Class paramClass, String paramString)
  {
    AppMethodBeat.i(135629);
    if ((paramClass != null) && (paramString != null)) {
      proxyDefaultConstructor(paramClass.getName(), paramString);
    }
    AppMethodBeat.o(135629);
  }
  
  private static native void proxyDefaultConstructor(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.ConstructProxy
 * JD-Core Version:    0.7.0.1
 */