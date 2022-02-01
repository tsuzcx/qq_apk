package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.hld.model.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDict;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetImeDictResp;", "dictInfos", "Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;", "recommendationType", "", "lng", "", "lat", "(Lcom/tencent/mm/protocal/protobuf/ImeLocalClientStaticDictInfos;IDD)V", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-hld_release"})
public final class a
  extends c<bwi>
{
  public static final a Dvk;
  
  static
  {
    AppMethodBeat.i(210981);
    Dvk = new a((byte)0);
    AppMethodBeat.o(210981);
  }
  
  private a(clg paramclg, int paramInt)
  {
    AppMethodBeat.i(210980);
    d.a locala = new d.a();
    bwh localbwh = new bwh();
    localbwh.type = paramInt;
    if (paramInt == j.DCV.value)
    {
      duw localduw = new duw();
      cqh localcqh = ai.czn();
      if (localcqh != null)
      {
        localduw.longitude = localcqh.ScO;
        localduw.latitude = localcqh.ScP;
      }
      Log.i("WxIme.CgiImeGetImeDict", " loc:[" + localduw.longitude + ", " + localduw.latitude + ']');
      localbwh.Tgd = localduw;
    }
    if (paramclg != null)
    {
      paramclg = paramclg.TfX;
      if (paramclg != null) {
        localbwh.TfX = paramclg;
      }
    }
    paramclg = new bwi();
    paramclg.setBaseResponse(new jh());
    paramclg.getBaseResponse().Tef = new eaf();
    locala.c((com.tencent.mm.cd.a)localbwh);
    locala.d((com.tencent.mm.cd.a)paramclg);
    locala.TW("/cgi-bin/mmsprime/getimedict");
    locala.vD(4994);
    c(locala.bgN());
    Log.i("WxIme.CgiImeGetImeDict", "recommendationType:" + paramInt + " lng:-1000.0 lat:-85.0");
    AppMethodBeat.o(210980);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDict$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.a
 * JD-Core Version:    0.7.0.1
 */