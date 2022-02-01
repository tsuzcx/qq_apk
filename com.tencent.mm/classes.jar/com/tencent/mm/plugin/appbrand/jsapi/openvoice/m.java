package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class m
  extends p
{
  public static final int CTRL_INDEX = 518;
  public static final String NAME = "onVoIPChatMembersChanged";
  
  public m()
  {
    AppMethodBeat.i(180260);
    c.Uy("onVoIPChatMembersChanged");
    AppMethodBeat.o(180260);
  }
  
  final void O(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(222634);
    ae.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: dispatch member change");
    H(paramMap).bja();
    AppMethodBeat.o(222634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.m
 * JD-Core Version:    0.7.0.1
 */