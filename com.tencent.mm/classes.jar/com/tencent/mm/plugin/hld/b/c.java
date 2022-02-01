package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDictRaw;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetImeDictRawResp;", "rawDictType", "", "id", "", "(ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-hld_release"})
public final class c
  extends com.tencent.mm.an.c<bwg>
{
  public static final a Dvm;
  
  static
  {
    AppMethodBeat.i(211642);
    Dvm = new a((byte)0);
    AppMethodBeat.o(211642);
  }
  
  private c(int paramInt)
  {
    AppMethodBeat.i(211640);
    d.a locala = new d.a();
    bwf localbwf = new bwf();
    Object localObject = new clq();
    ((clq)localObject).type = paramInt;
    ((clq)localObject).TsZ = "";
    localbwf.Tgb = ((clq)localObject);
    localObject = new bwg();
    ((bwg)localObject).setBaseResponse(new jh());
    ((bwg)localObject).getBaseResponse().Tef = new eaf();
    locala.c((a)localbwf);
    locala.d((a)localObject);
    locala.TW("/cgi-bin/mmsprime/getimedictraw");
    locala.vD(5058);
    c(locala.bgN());
    Log.i("WxIme.CgiImeGetImeDictRaw", "rawDictType:" + paramInt + " rawDictId:" + null);
    AppMethodBeat.o(211640);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDictRaw$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.c
 * JD-Core Version:    0.7.0.1
 */