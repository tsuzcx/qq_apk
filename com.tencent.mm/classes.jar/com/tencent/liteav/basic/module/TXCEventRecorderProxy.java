package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCEventRecorderProxy
{
  private long a;
  
  public TXCEventRecorderProxy()
  {
    AppMethodBeat.i(146479);
    this.a = 0L;
    this.a = nativeInit();
    AppMethodBeat.o(146479);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    AppMethodBeat.i(146482);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(146482);
      return;
    }
    nativeAddEventMsg(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramInt4);
    AppMethodBeat.o(146482);
  }
  
  private static native void nativeAddEventListener(long paramLong, String paramString1, String paramString2);
  
  private static native void nativeAddEventMsg(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4);
  
  private static native long nativeInit();
  
  private static native void nativeRelease(long paramLong);
  
  public void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146481);
    nativeAddEventListener(this.a, paramString1, paramString2);
    AppMethodBeat.o(146481);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(146480);
    nativeRelease(this.a);
    this.a = 0L;
    super.finalize();
    AppMethodBeat.o(146480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCEventRecorderProxy
 * JD-Core Version:    0.7.0.1
 */