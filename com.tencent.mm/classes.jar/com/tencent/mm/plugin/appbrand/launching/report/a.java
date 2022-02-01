package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.am.a;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/report/LaunchGetWxaAttrsIDKeyConstants;", "", "()V", "ID", "", "KEY_APP_VERSION_LESS_THAN_SYNC_VERSION", "KEY_SYNC_GET_BY_ATTRS_NOT_FOUND", "KEY_SYNC_GET_BY_CMD_UPDATE_VERSION", "KEY_SYNC_GET_BY_INVALID_FIELDS", "KEY_SYNC_GET_BY_MISSING_PKG", "KEY_SYNC_GET_BY_NO_USE_RECENT", "KEY_SYNC_GET_BY_PATH_NOT_FOUND", "KEY_SYNC_GET_BY_VERSION_NOT_FOUND", "KEY_SYNC_GET_TOTAL", "KEY_USERNAME_INVALID", "reportSyncGet", "", "reason", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchStepCostReporter$GetAttrsReason;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a mZt;
  
  static
  {
    AppMethodBeat.i(228764);
    mZt = new a();
    AppMethodBeat.o(228764);
  }
  
  public static final void a(am.a parama)
  {
    AppMethodBeat.i(228763);
    p.h(parama, "reason");
    h.CyF.dN(648, 10);
    int i;
    switch (b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
      parama = new m();
      AppMethodBeat.o(228763);
      throw parama;
    case 1: 
      AppMethodBeat.o(228763);
      return;
    case 2: 
      i = 11;
    }
    for (;;)
    {
      h.CyF.dN(648, i);
      AppMethodBeat.o(228763);
      return;
      i = 12;
      continue;
      i = 13;
      continue;
      i = 14;
      continue;
      i = 15;
      continue;
      i = 16;
      continue;
      i = 17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.a
 * JD-Core Version:    0.7.0.1
 */