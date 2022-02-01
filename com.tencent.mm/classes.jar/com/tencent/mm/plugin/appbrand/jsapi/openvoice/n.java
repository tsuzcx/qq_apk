package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

public final class n
  extends p
{
  public static final int CTRL_INDEX = 781;
  public static final String NAME = "onVoIPVideoMembersChanged";
  
  public n()
  {
    AppMethodBeat.i(180262);
    c.Qk("onVoIPVideoMembersChanged");
    AppMethodBeat.o(180262);
  }
  
  final void H(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(186740);
    ac.i("MicroMsg.OpenVoice.onVoIPVideoMembersChanged", "hy: video member changed.");
    A(paramMap).beN();
    AppMethodBeat.o(186740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.n
 * JD-Core Version:    0.7.0.1
 */