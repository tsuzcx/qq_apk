package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public final class m
  extends p
{
  public static final int CTRL_INDEX = 518;
  public static final String NAME = "onVoIPChatMembersChanged";
  
  public m()
  {
    AppMethodBeat.i(180260);
    c.TP("onVoIPChatMembersChanged");
    AppMethodBeat.o(180260);
  }
  
  final void H(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(188484);
    ad.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: dispatch member change");
    A(paramMap).bir();
    AppMethodBeat.o(188484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.m
 * JD-Core Version:    0.7.0.1
 */