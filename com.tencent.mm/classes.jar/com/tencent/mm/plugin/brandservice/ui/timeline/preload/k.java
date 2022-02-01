package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "toast", "", "", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final MultiProcessMMKV cTb()
  {
    AppMethodBeat.i(6634);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_tmpl_command");
    s.s(localMultiProcessMMKV, "getMMKV(ConstantsPreload…MKV_WEBVIEW_TMPL_COMMAND)");
    AppMethodBeat.o(6634);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.k
 * JD-Core Version:    0.7.0.1
 */