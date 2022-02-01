package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class p
  extends s
{
  public static final int CTRL_INDEX = 781;
  public static final String NAME = "onVoIPVideoMembersChanged";
  
  public p()
  {
    AppMethodBeat.i(180262);
    c.afo("onVoIPVideoMembersChanged");
    AppMethodBeat.o(180262);
  }
  
  final void R(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(326325);
    Log.i("MicroMsg.OpenVoice.onVoIPVideoMembersChanged", "hy: video member changed.");
    K(paramMap).cpV();
    AppMethodBeat.o(326325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.p
 * JD-Core Version:    0.7.0.1
 */