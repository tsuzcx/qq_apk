package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class r$2
  extends r.a
{
  r$2(r paramr, CountDownLatch paramCountDownLatch)
  {
    super(paramr, (byte)0);
  }
  
  final long aGX()
  {
    AppMethodBeat.i(131830);
    long l = this.fuC.getCount();
    AppMethodBeat.o(131830);
    return l;
  }
  
  final String aGY()
  {
    AppMethodBeat.i(131831);
    String str = "appId=" + this.ils.appId + " module=__APP__";
    AppMethodBeat.o(131831);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r.2
 * JD-Core Version:    0.7.0.1
 */