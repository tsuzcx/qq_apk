package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class s$4
  extends s.a
{
  s$4(s params, CountDownLatch paramCountDownLatch)
  {
    super(params, (byte)0);
  }
  
  final long aGX()
  {
    AppMethodBeat.i(131852);
    long l = this.val$latch.getCount();
    AppMethodBeat.o(131852);
    return l;
  }
  
  final String aGY()
  {
    AppMethodBeat.i(131853);
    String str = "appId=" + this.ilz.appId + " module=__WITHOUT_CODELIB__";
    AppMethodBeat.o(131853);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.s.4
 * JD-Core Version:    0.7.0.1
 */