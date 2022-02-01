package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class p
  extends r
{
  public static final int CTRL_INDEX = 781;
  public static final String NAME = "onVoIPVideoMembersChanged";
  
  public p()
  {
    AppMethodBeat.i(180262);
    c.amg("onVoIPVideoMembersChanged");
    AppMethodBeat.o(180262);
  }
  
  final void K(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(280665);
    Log.i("MicroMsg.OpenVoice.onVoIPVideoMembersChanged", "hy: video member changed.");
    D(paramMap).bPO();
    AppMethodBeat.o(280665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.p
 * JD-Core Version:    0.7.0.1
 */