package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;

final class AppBrandOpReportLogic$a$1
  implements MMToClientEvent.c
{
  public final void aG(Object paramObject)
  {
    if ((paramObject instanceof AppBrandOpReportLogic.AppBrandOnOpReportStartEvent))
    {
      paramObject = com.tencent.mm.plugin.appbrand.a.qn(((AppBrandOpReportLogic.AppBrandOnOpReportStartEvent)paramObject).appId);
      if (paramObject != null) {
        a.f(paramObject.Zy());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a.1
 * JD-Core Version:    0.7.0.1
 */