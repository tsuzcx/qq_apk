package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public final class o
  extends p
{
  public static final int CTRL_INDEX = 781;
  public static final String NAME = "onVoIPVideoMembersChanged";
  
  public o()
  {
    AppMethodBeat.i(180262);
    c.TP("onVoIPVideoMembersChanged");
    AppMethodBeat.o(180262);
  }
  
  final void H(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(188486);
    ad.i("MicroMsg.OpenVoice.onVoIPVideoMembersChanged", "hy: video member changed.");
    A(paramMap).bir();
    AppMethodBeat.o(188486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.o
 * JD-Core Version:    0.7.0.1
 */