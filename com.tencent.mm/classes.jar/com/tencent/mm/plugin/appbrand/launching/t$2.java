package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class t$2
  extends t.a
{
  t$2(t paramt, CountDownLatch paramCountDownLatch, String paramString)
  {
    super(paramt, (byte)0);
  }
  
  final long aGX()
  {
    AppMethodBeat.i(131869);
    long l = this.val$latch.getCount();
    AppMethodBeat.o(131869);
    return l;
  }
  
  final String aGY()
  {
    AppMethodBeat.i(131870);
    String str = "appId=" + this.ilC.appId + " provider=" + this.ily;
    AppMethodBeat.o(131870);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t.2
 * JD-Core Version:    0.7.0.1
 */