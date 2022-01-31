package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bc.a;

public final class d
{
  public c hrA;
  public bc.a iXx;
  
  public d()
  {
    AppMethodBeat.i(87408);
    this.iXx = new bc.a()
    {
      public final void aNW()
      {
        AppMethodBeat.i(87407);
        ab.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        s.k(d.this.hrA);
        AppMethodBeat.o(87407);
      }
    };
    AppMethodBeat.o(87408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.d
 * JD-Core Version:    0.7.0.1
 */