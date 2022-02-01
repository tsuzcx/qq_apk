package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class n
  extends r
{
  public static final int CTRL_INDEX = 519;
  public static final String NAME = "onVoIPChatSpeakersChanged";
  
  public n()
  {
    AppMethodBeat.i(180261);
    c.amg("onVoIPChatSpeakersChanged");
    AppMethodBeat.o(180261);
  }
  
  final void K(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(279976);
    Log.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: speaker changed.");
    D(paramMap).bPO();
    AppMethodBeat.o(279976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.n
 * JD-Core Version:    0.7.0.1
 */