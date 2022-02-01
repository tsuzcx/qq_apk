package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class o
  extends p
{
  public static final int CTRL_INDEX = 781;
  public static final String NAME = "onVoIPVideoMembersChanged";
  
  public o()
  {
    AppMethodBeat.i(180262);
    c.Uy("onVoIPVideoMembersChanged");
    AppMethodBeat.o(180262);
  }
  
  final void O(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(222636);
    ae.i("MicroMsg.OpenVoice.onVoIPVideoMembersChanged", "hy: video member changed.");
    H(paramMap).bja();
    AppMethodBeat.o(222636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.o
 * JD-Core Version:    0.7.0.1
 */