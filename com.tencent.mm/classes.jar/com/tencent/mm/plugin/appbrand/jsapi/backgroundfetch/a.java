package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 654;
  public static final String NAME = "getBackgroundFetchToken";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46123);
    paramJSONObject = paramf.getAppId();
    XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(paramJSONObject), a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(46123);
  }
  
  static class a
    implements b<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a
 * JD-Core Version:    0.7.0.1
 */