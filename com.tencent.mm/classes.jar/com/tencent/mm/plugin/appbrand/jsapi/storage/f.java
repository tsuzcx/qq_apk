package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;

public class f
  extends a<h>
{
  public static final int CTRL_INDEX = 17;
  public static final String NAME = "getStorage";
  
  protected String w(c paramc)
  {
    AppMethodBeat.i(102036);
    paramc = paramc.getAppId();
    AppMethodBeat.o(102036);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.f
 * JD-Core Version:    0.7.0.1
 */