package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class r$4
  extends r.a
{
  r$4(r paramr, CountDownLatch paramCountDownLatch, String paramString)
  {
    super(paramr, (byte)0);
  }
  
  final long aGX()
  {
    AppMethodBeat.i(131834);
    long l = this.fuC.getCount();
    AppMethodBeat.o(131834);
    return l;
  }
  
  final String aGY()
  {
    AppMethodBeat.i(131835);
    String str = "appId=" + this.ils.appId + " module=" + this.ilu;
    AppMethodBeat.o(131835);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r.4
 * JD-Core Version:    0.7.0.1
 */