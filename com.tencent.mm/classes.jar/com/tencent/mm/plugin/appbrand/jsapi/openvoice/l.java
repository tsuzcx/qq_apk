package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

public final class l
  extends p
{
  public static final int CTRL_INDEX = 518;
  public static final String NAME = "onVoIPChatMembersChanged";
  
  public l()
  {
    AppMethodBeat.i(180260);
    c.Qk("onVoIPChatMembersChanged");
    AppMethodBeat.o(180260);
  }
  
  final void H(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(186738);
    ac.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: dispatch member change");
    A(paramMap).beN();
    AppMethodBeat.o(186738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.l
 * JD-Core Version:    0.7.0.1
 */