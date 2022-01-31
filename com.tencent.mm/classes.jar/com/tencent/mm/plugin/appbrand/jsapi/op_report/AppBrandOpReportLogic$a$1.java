package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;

final class AppBrandOpReportLogic$a$1
  implements MMToClientEvent.c
{
  AppBrandOpReportLogic$a$1(h paramh) {}
  
  public final void aZ(Object paramObject)
  {
    AppMethodBeat.i(101999);
    if ((paramObject instanceof AppBrandOpReportLogic.AppBrandOnOpReportStartEvent))
    {
      paramObject = this.hDn.getRuntime();
      if (paramObject != null) {
        a.k(paramObject.ws());
      }
    }
    AppMethodBeat.o(101999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a.1
 * JD-Core Version:    0.7.0.1
 */