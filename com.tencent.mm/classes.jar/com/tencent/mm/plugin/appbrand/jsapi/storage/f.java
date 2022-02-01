package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.p.a;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;

public class f
  extends d<k>
{
  public static final int CTRL_INDEX = 17;
  public static final String NAME = "getStorage";
  
  protected String C(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(147242);
    paramf = paramf.getAppId();
    AppMethodBeat.o(147242);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.f
 * JD-Core Version:    0.7.0.1
 */