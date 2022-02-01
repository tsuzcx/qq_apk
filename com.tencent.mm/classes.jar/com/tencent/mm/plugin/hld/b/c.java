package com.tencent.mm.plugin.hld.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.dby;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDictRaw;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetImeDictRawResp;", "rawDictType", "", "id", "", "(ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b<clj>
{
  public static final a JoG;
  
  static
  {
    AppMethodBeat.i(312087);
    JoG = new a((byte)0);
    AppMethodBeat.o(312087);
  }
  
  private c(int paramInt)
  {
    AppMethodBeat.i(312071);
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    cli localcli = new cli();
    Object localObject = new dby();
    ((dby)localObject).type = paramInt;
    ((dby)localObject).aaHk = "";
    ah localah = ah.aiuX;
    localcli.aatv = ((dby)localObject);
    localObject = new clj();
    ((clj)localObject).setBaseResponse(new kd());
    ((clj)localObject).getBaseResponse().akjO = new etl();
    locala.otE = ((a)localcli);
    locala.otF = ((a)localObject);
    locala.uri = "/cgi-bin/mmsprime/getimedictraw";
    locala.funcId = 5058;
    c(locala.bEF());
    Log.i("WxIme.CgiImeGetImeDictRaw", "rawDictType:" + paramInt + " rawDictId:" + null);
    AppMethodBeat.o(312071);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/cgi/CgiImeGetImeDictRaw$Companion;", "", "()V", "TAG", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.b.c
 * JD-Core Version:    0.7.0.1
 */