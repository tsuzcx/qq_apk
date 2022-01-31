package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class s$2
  extends s.a
{
  s$2(s params, CountDownLatch paramCountDownLatch, String paramString)
  {
    super(params, (byte)0);
  }
  
  final long aGX()
  {
    AppMethodBeat.i(131847);
    long l = this.val$latch.getCount();
    AppMethodBeat.o(131847);
    return l;
  }
  
  final String aGY()
  {
    AppMethodBeat.i(131848);
    String str = "appId=" + this.ilz.appId + " provider=" + this.ily;
    AppMethodBeat.o(131848);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.s.2
 * JD-Core Version:    0.7.0.1
 */