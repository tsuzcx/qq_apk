package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.ag.a;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/report/LaunchGetWxaAttrsIDKeyConstants;", "", "()V", "ID", "", "KEY_APP_VERSION_LESS_THAN_SYNC_VERSION", "KEY_SYNC_GET_BY_ATTRS_NOT_FOUND", "KEY_SYNC_GET_BY_CMD_UPDATE_VERSION", "KEY_SYNC_GET_BY_INVALID_FIELDS", "KEY_SYNC_GET_BY_MISSING_PKG", "KEY_SYNC_GET_BY_NO_USE_RECENT", "KEY_SYNC_GET_BY_PATH_NOT_FOUND", "KEY_SYNC_GET_BY_VERSION_NOT_FOUND", "KEY_SYNC_GET_TOTAL", "KEY_USERNAME_INVALID", "reportSyncGet", "", "reason", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchStepCostReporter$GetAttrsReason;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a pZR;
  
  static
  {
    AppMethodBeat.i(282758);
    pZR = new a();
    AppMethodBeat.o(282758);
  }
  
  public static final void a(ag.a parama)
  {
    AppMethodBeat.i(282757);
    p.k(parama, "reason");
    h.IzE.el(648, 10);
    int i;
    switch (b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    default: 
      parama = new m();
      AppMethodBeat.o(282757);
      throw parama;
    case 1: 
      AppMethodBeat.o(282757);
      return;
    case 2: 
      i = 11;
    }
    for (;;)
    {
      h.IzE.el(648, i);
      AppMethodBeat.o(282757);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.a
 * JD-Core Version:    0.7.0.1
 */