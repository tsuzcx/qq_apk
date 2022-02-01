package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneOperateWxDataHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final a tmV;
  
  static
  {
    AppMethodBeat.i(319822);
    tmV = new a((byte)0);
    AppMethodBeat.o(319822);
  }
  
  public static final c.a kf(boolean paramBoolean)
  {
    AppMethodBeat.i(319814);
    c.a locala = new c.a();
    locala.otE = ((a)new deg());
    locala.otF = ((a)new deh());
    locala.otD = paramBoolean;
    String str;
    if (paramBoolean)
    {
      str = "/cgi-bin/mmbiz-bin/js-operatewxdata-keepalive";
      locala.uri = str;
      if (!paramBoolean) {
        break label94;
      }
    }
    label94:
    for (int i = 4602;; i = 1133)
    {
      locala.funcId = i;
      locala.otG = 0;
      locala.respCmdId = 0;
      AppMethodBeat.o(319814);
      return locala;
      str = "/cgi-bin/mmbiz-bin/js-operatewxdata";
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/netscene/NetSceneOperateWxDataHelper$Companion;", "", "()V", "getReqRespBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "keepAlive", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.f
 * JD-Core Version:    0.7.0.1
 */