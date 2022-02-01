package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Monitor
{
  public static void a()
  {
    AppMethodBeat.i(14413);
    nativeUnInit();
    AppMethodBeat.o(14413);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(14412);
    nativeOnlineLog(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(14412);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(14411);
    nativeInit(paramString1, paramInt, paramString2);
    AppMethodBeat.o(14411);
  }
  
  private static native void nativeInit(String paramString1, int paramInt, String paramString2);
  
  private static native void nativeOnlineLog(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  private static native void nativeUnInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.module.Monitor
 * JD-Core Version:    0.7.0.1
 */