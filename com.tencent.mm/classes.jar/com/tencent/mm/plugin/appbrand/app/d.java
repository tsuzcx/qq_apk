package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.config.l.a;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b;
import com.tencent.mm.plugin.appbrand.r.a;
import java.util.List;

final class d
  implements a
{
  public final void aaL() {}
  
  public final int aaM()
  {
    return WxaCommLibRuntimeReader.abQ().fEN;
  }
  
  public final void an(List<String> paramList)
  {
    s.a(paramList, l.a.fQy);
  }
  
  public final void j(String paramString1, String paramString2, int paramInt)
  {
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.gqV = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.gqW = paramInt;
    com.tencent.mm.plugin.appbrand.ipc.d.a(paramString1, localSendDataToMiniProgramFromH5Event);
  }
  
  public final int qP(String paramString)
  {
    return AppBrandOpReportLogic.b.uz(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.d
 * JD-Core Version:    0.7.0.1
 */