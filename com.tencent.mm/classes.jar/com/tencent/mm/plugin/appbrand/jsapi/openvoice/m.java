package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class m
  extends s
{
  public static final int CTRL_INDEX = 518;
  public static final String NAME = "onVoIPChatMembersChanged";
  
  public m()
  {
    AppMethodBeat.i(180260);
    c.afo("onVoIPChatMembersChanged");
    AppMethodBeat.o(180260);
  }
  
  final void R(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(326331);
    Log.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: dispatch member change");
    K(paramMap).cpV();
    AppMethodBeat.o(326331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.m
 * JD-Core Version:    0.7.0.1
 */