package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class o
  extends r
{
  public static final int CTRL_INDEX = 994;
  public static final String NAME = "onVoIPChatStateChanged";
  
  public o()
  {
    AppMethodBeat.i(272968);
    c.amg("onVoIPChatStateChanged");
    AppMethodBeat.o(272968);
  }
  
  final void K(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(272969);
    Log.i("MicroMsg.OpenVoice.onVoIPChatStateChangedJsEvent", "hy: event callback");
    D(paramMap).bPO();
    AppMethodBeat.o(272969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.o
 * JD-Core Version:    0.7.0.1
 */