package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class n
  extends p
{
  public static final int CTRL_INDEX = 519;
  public static final String NAME = "onVoIPChatSpeakersChanged";
  
  public n()
  {
    AppMethodBeat.i(180261);
    c.Uy("onVoIPChatSpeakersChanged");
    AppMethodBeat.o(180261);
  }
  
  final void O(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(222635);
    ae.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: speaker changed.");
    H(paramMap).bja();
    AppMethodBeat.o(222635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.n
 * JD-Core Version:    0.7.0.1
 */