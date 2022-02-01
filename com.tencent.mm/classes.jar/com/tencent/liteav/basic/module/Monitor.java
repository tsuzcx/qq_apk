package com.tencent.liteav.basic.module;

import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Monitor
{
  static
  {
    AppMethodBeat.i(230084);
    h.d();
    AppMethodBeat.o(230084);
  }
  
  public static void a()
  {
    AppMethodBeat.i(14413);
    nativeUnInit();
    AppMethodBeat.o(14413);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230058);
    nativeOnlineLogWithLimit(paramInt1, paramInt2, paramString1, paramString2, paramInt3, paramInt4);
    AppMethodBeat.o(230058);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(14412);
    nativeOnlineLog(paramInt1, paramString1, paramString2, paramInt2);
    AppMethodBeat.o(14412);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(230062);
    nativeOnlineLogWithTag(paramInt1, paramString1, paramString2, paramInt2, paramString3);
    AppMethodBeat.o(230062);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(14411);
    nativeInit(paramString1, paramInt, paramString2);
    AppMethodBeat.o(14411);
  }
  
  private static native void nativeInit(String paramString1, int paramInt, String paramString2);
  
  private static native void nativeOnlineLog(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  private static native void nativeOnlineLogWithLimit(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4);
  
  private static native void nativeOnlineLogWithTag(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3);
  
  private static native void nativeUnInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.module.Monitor
 * JD-Core Version:    0.7.0.1
 */