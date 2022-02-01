package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.phonenumber.u;

public final class i
{
  static boolean isInit = false;
  
  public static void init()
  {
    AppMethodBeat.i(46120);
    if (isInit)
    {
      AppMethodBeat.o(46120);
      return;
    }
    isInit = true;
    u localu = u.nAe;
    u.a(new i.1());
    AppMethodBeat.o(46120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.i
 * JD-Core Version:    0.7.0.1
 */