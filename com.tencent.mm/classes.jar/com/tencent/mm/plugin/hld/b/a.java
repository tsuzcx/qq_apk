package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.hld.model.j;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDict;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetImeDictResp;", "dictInfos", "Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;", "recommendationType", "", "lng", "", "lat", "(Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;IDD)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<cll>
{
  public static final a.a JoE;
  
  static
  {
    AppMethodBeat.i(312094);
    JoE = new a.a((byte)0);
    AppMethodBeat.o(312094);
  }
  
  private a(dbo paramdbo, int paramInt)
  {
    AppMethodBeat.i(312081);
    c.a locala = new c.a();
    clk localclk = new clk();
    localclk.type = paramInt;
    if (paramInt == j.JvE.value)
    {
      enu localenu = new enu();
      Object localObject = aj.dch();
      if (localObject != null)
      {
        localenu.longitude = ((dhb)localObject).ZaG;
        localenu.latitude = ((dhb)localObject).ZaH;
      }
      Log.i("WxIme.CgiImeGetImeDict", " loc:[" + localenu.longitude + ", " + localenu.latitude + ']');
      localObject = ah.aiuX;
      localclk.aatx = localenu;
    }
    if (paramdbo != null)
    {
      paramdbo = paramdbo.aatr;
      if (paramdbo != null) {
        localclk.aatr = paramdbo;
      }
    }
    paramdbo = new cll();
    paramdbo.setBaseResponse(new kd());
    paramdbo.getBaseResponse().akjO = new etl();
    locala.otE = ((com.tencent.mm.bx.a)localclk);
    locala.otF = ((com.tencent.mm.bx.a)paramdbo);
    locala.uri = "/cgi-bin/mmsprime/getimedict";
    locala.funcId = 4994;
    c(locala.bEF());
    Log.i("WxIme.CgiImeGetImeDict", "recommendationType:" + paramInt + " lng:-1000.0 lat:-85.0");
    AppMethodBeat.o(312081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.a
 * JD-Core Version:    0.7.0.1
 */