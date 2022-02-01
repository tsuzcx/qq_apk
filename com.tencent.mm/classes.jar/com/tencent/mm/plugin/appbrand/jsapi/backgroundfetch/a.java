package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 654;
  public static final String NAME = "getBackgroundFetchToken";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46123);
    XIPCInvoker.a("com.tencent.mm", new IPCString(paramc.getAppId()), a.a.class, new d() {});
    AppMethodBeat.o(46123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a
 * JD-Core Version:    0.7.0.1
 */