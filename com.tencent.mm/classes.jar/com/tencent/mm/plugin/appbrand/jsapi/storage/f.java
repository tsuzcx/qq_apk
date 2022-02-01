package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p.a;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;

public class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 17;
  public static final String NAME = "getStorage";
  
  protected String B(c paramc)
  {
    AppMethodBeat.i(147242);
    paramc = paramc.getAppId();
    AppMethodBeat.o(147242);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.f
 * JD-Core Version:    0.7.0.1
 */