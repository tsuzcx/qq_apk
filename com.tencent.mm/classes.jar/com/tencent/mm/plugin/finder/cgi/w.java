package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;", "opType", "", "objectId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IJLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getObjectId", "()J", "getOpType", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class w
  extends an<azb>
{
  public static final a ttC;
  private final long hFK;
  private final int opType;
  
  static
  {
    AppMethodBeat.i(242250);
    ttC = new a((byte)0);
    AppMethodBeat.o(242250);
  }
  
  public w(long paramLong, bbn parambbn)
  {
    AppMethodBeat.i(242249);
    this.opType = 1;
    this.hFK = paramLong;
    d.a locala = new d.a();
    aza localaza = new aza();
    locala.c((a)localaza);
    localaza.dYx = this.opType;
    localaza.finderUsername = z.aUg();
    localaza.LIX.add(Long.valueOf(this.hFK));
    am localam = am.tuw;
    localaza.LBM = am.a(parambbn);
    parambbn = new azb();
    parambbn.setBaseResponse(new BaseResponse());
    parambbn.getBaseResponse().ErrMsg = new dqi();
    locala.d((a)parambbn);
    locala.MB("/cgi-bin/micromsg-bin/findermodmentioned");
    locala.sG(6205);
    c(locala.aXF());
    AppMethodBeat.o(242249);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned$Companion;", "", "()V", "OP_TYPE_ADD", "", "OP_TYPE_DELETE", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.w
 * JD-Core Version:    0.7.0.1
 */