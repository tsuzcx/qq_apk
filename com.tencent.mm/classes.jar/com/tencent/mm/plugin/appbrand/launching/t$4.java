package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class t$4
  extends t.a
{
  t$4(t paramt, CountDownLatch paramCountDownLatch)
  {
    super(paramt, (byte)0);
  }
  
  final long aGX()
  {
    AppMethodBeat.i(131874);
    long l = this.val$latch.getCount();
    AppMethodBeat.o(131874);
    return l;
  }
  
  final String aGY()
  {
    AppMethodBeat.i(131875);
    String str = "appId=" + this.ilC.appId + " modulename= __APP__ module=__WITHOUT_CODELIB__";
    AppMethodBeat.o(131875);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t.4
 * JD-Core Version:    0.7.0.1
 */