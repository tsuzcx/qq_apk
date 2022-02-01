package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class a
  extends c
{
  public static final int CTRL_INDEX = 654;
  public static final String NAME = "getBackgroundFetchToken";
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46123);
    paramJSONObject = parame.getAppId();
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramJSONObject), a.class, new f() {});
    AppMethodBeat.o(46123);
  }
  
  static class a
    implements d<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a
 * JD-Core Version:    0.7.0.1
 */