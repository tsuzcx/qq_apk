package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

public final class m
  extends p
{
  public static final int CTRL_INDEX = 519;
  public static final String NAME = "onVoIPChatSpeakersChanged";
  
  public m()
  {
    AppMethodBeat.i(180261);
    c.Qk("onVoIPChatSpeakersChanged");
    AppMethodBeat.o(180261);
  }
  
  final void H(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(186739);
    ac.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: speaker changed.");
    A(paramMap).beN();
    AppMethodBeat.o(186739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.m
 * JD-Core Version:    0.7.0.1
 */