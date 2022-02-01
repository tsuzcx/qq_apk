package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.au.a;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;
import d.m;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/report/LaunchGetWxaAttrsIDKeyConstants;", "", "()V", "ID", "", "KEY_APP_VERSION_LESS_THAN_SYNC_VERSION", "KEY_SYNC_GET_BY_ATTRS_NOT_FOUND", "KEY_SYNC_GET_BY_CMD_UPDATE_VERSION", "KEY_SYNC_GET_BY_INVALID_FIELDS", "KEY_SYNC_GET_BY_MISSING_PKG", "KEY_SYNC_GET_BY_NO_USE_RECENT", "KEY_SYNC_GET_BY_PATH_NOT_FOUND", "KEY_SYNC_GET_BY_VERSION_NOT_FOUND", "KEY_SYNC_GET_TOTAL", "KEY_USERNAME_INVALID", "reportSyncGet", "", "reason", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchStepCostReporter$GetAttrsReason;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a lSh;
  
  static
  {
    AppMethodBeat.i(223603);
    lSh = new a();
    AppMethodBeat.o(223603);
  }
  
  public static final void a(au.a parama)
  {
    AppMethodBeat.i(223602);
    p.h(parama, "reason");
    g.yxI.dD(648, 10);
    int i;
    switch (b.cqt[parama.ordinal()])
    {
    default: 
      parama = new m();
      AppMethodBeat.o(223602);
      throw parama;
    case 1: 
      AppMethodBeat.o(223602);
      return;
    case 2: 
      i = 11;
    }
    for (;;)
    {
      g.yxI.dD(648, i);
      AppMethodBeat.o(223602);
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