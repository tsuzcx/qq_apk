package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.lang.ref.WeakReference;
import java.util.List;

public class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 113;
  public static final String NAME = "getStorageInfo";
  
  protected String B(c paramc)
  {
    AppMethodBeat.i(147248);
    paramc = paramc.getAppId();
    AppMethodBeat.o(147248);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.g
 * JD-Core Version:    0.7.0.1
 */