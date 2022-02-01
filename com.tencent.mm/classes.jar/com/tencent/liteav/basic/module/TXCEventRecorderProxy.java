package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCEventRecorderProxy
{
  private long a;
  
  public static void a(String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(170216);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(170216);
      return;
    }
    nativeAddEventMsg(paramString1, paramInt1, paramLong1, paramLong2, paramString2, paramInt2);
    AppMethodBeat.o(170216);
  }
  
  private static native void nativeAddEventMsg(String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2);
  
  private static native void nativeRelease(long paramLong);
  
  protected void finalize()
  {
    AppMethodBeat.i(14409);
    nativeRelease(this.a);
    this.a = 0L;
    super.finalize();
    AppMethodBeat.o(14409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCEventRecorderProxy
 * JD-Core Version:    0.7.0.1
 */