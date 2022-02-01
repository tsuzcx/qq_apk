package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.cnp;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneOperateWxDataHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"})
public final class f
{
  public static final a qij;
  
  static
  {
    AppMethodBeat.i(272543);
    qij = new a((byte)0);
    AppMethodBeat.o(272543);
  }
  
  public static final d.a iX(boolean paramBoolean)
  {
    AppMethodBeat.i(272545);
    d.a locala = new d.a();
    locala.c((a)new cno());
    locala.d((a)new cnp());
    locala.setKeepAlive(paramBoolean);
    String str;
    if (paramBoolean)
    {
      str = "/cgi-bin/mmbiz-bin/js-operatewxdata-keepalive";
      locala.TW(str);
      if (!paramBoolean) {
        break label94;
      }
    }
    label94:
    for (int i = 4602;; i = 1133)
    {
      locala.vD(i);
      locala.vF(0);
      locala.vG(0);
      AppMethodBeat.o(272545);
      return locala;
      str = "/cgi-bin/mmbiz-bin/js-operatewxdata";
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneOperateWxDataHelper$Companion;", "", "()V", "getReqRespBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "keepAlive", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.f
 * JD-Core Version:    0.7.0.1
 */