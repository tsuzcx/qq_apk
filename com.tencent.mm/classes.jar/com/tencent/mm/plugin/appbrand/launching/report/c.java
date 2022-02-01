package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.ah.a;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/report/LaunchGetWxaAttrsIDKeyConstants;", "", "()V", "ID", "", "KEY_APP_VERSION_LESS_THAN_SYNC_VERSION", "KEY_SYNC_GET_BY_ATTRS_NOT_FOUND", "KEY_SYNC_GET_BY_CMD_UPDATE_VERSION", "KEY_SYNC_GET_BY_INVALID_FIELDS", "KEY_SYNC_GET_BY_MISSING_PKG", "KEY_SYNC_GET_BY_NO_USE_RECENT", "KEY_SYNC_GET_BY_PATH_NOT_FOUND", "KEY_SYNC_GET_BY_VERSION_NOT_FOUND", "KEY_SYNC_GET_TOTAL", "KEY_USERNAME_INVALID", "reportSyncGet", "", "reason", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchStepCostReporter$GetAttrsReason;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c tfb;
  
  static
  {
    AppMethodBeat.i(321204);
    tfb = new c();
    AppMethodBeat.o(321204);
  }
  
  public static final void a(ah.a parama)
  {
    AppMethodBeat.i(321197);
    s.u(parama, "reason");
    h.OAn.kJ(648, 10);
    int i;
    switch (a.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
      parama = new p();
      AppMethodBeat.o(321197);
      throw parama;
    case 1: 
      AppMethodBeat.o(321197);
      return;
    case 2: 
      i = 11;
    }
    for (;;)
    {
      h.OAn.kJ(648, i);
      AppMethodBeat.o(321197);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.c
 * JD-Core Version:    0.7.0.1
 */