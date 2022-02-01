package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class o
  extends s
{
  public static final int CTRL_INDEX = 781;
  public static final String NAME = "onVoIPVideoMembersChanged";
  
  public o()
  {
    AppMethodBeat.i(180262);
    c.aem("onVoIPVideoMembersChanged");
    AppMethodBeat.o(180262);
  }
  
  final void R(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(226945);
    Log.i("MicroMsg.OpenVoice.onVoIPVideoMembersChanged", "hy: video member changed.");
    K(paramMap).bEo();
    AppMethodBeat.o(226945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.o
 * JD-Core Version:    0.7.0.1
 */