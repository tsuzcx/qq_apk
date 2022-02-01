package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class o
  extends s
{
  public static final int CTRL_INDEX = 994;
  public static final String NAME = "onVoIPChatStateChanged";
  
  public o()
  {
    AppMethodBeat.i(326324);
    c.afo("onVoIPChatStateChanged");
    AppMethodBeat.o(326324);
  }
  
  final void R(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(326327);
    Log.i("MicroMsg.OpenVoice.onVoIPChatStateChangedJsEvent", "hy: event callback");
    K(paramMap).cpV();
    AppMethodBeat.o(326327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.o
 * JD-Core Version:    0.7.0.1
 */