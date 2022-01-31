package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.task.h;
import java.util.List;

class e
  implements com.tencent.mm.plugin.appbrand.service.e
{
  public final int auy()
  {
    AppMethodBeat.i(129247);
    int i = WxaCommLibRuntimeReader.avI().gXf;
    AppMethodBeat.o(129247);
    return i;
  }
  
  public void av(List<String> paramList)
  {
    AppMethodBeat.i(129246);
    s.a(paramList, k.a.hjj);
    AppMethodBeat.o(129246);
  }
  
  public void bt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129248);
    com.tencent.mm.cm.g.dTg().h(new e.2(this, paramString1, paramString2)).dQo();
    AppMethodBeat.o(129248);
  }
  
  public void k(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(129245);
    SendDataToMiniProgramFromH5Event localSendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
    localSendDataToMiniProgramFromH5Event.hMk = paramString1;
    localSendDataToMiniProgramFromH5Event.data = paramString2;
    localSendDataToMiniProgramFromH5Event.hMl = paramInt;
    d.a(paramString1, localSendDataToMiniProgramFromH5Event);
    AppMethodBeat.o(129245);
  }
  
  public com.tencent.mm.vending.g.e<Integer> yj(String paramString)
  {
    AppMethodBeat.i(129243);
    paramString = com.tencent.mm.cm.g.dTg().b(new e.1(this, paramString));
    AppMethodBeat.o(129243);
    return paramString;
  }
  
  public void yk(String paramString)
  {
    AppMethodBeat.i(129244);
    v.avD();
    h.b(com.tencent.mm.plugin.appbrand.task.g.iKS);
    AppMethodBeat.o(129244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e
 * JD-Core Version:    0.7.0.1
 */