package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;", "opType", "", "objectId", "", "userName", "", "mentionList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModMentionedInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IJLjava/lang/String;Ljava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getObjectId", "()J", "getOpType", "()I", "getUserName", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class x
  extends c<bex>
{
  public static final a xbl;
  private final int opType;
  private final String userName;
  private final long xbk;
  
  static
  {
    AppMethodBeat.i(282996);
    xbl = new a((byte)0);
    AppMethodBeat.o(282996);
  }
  
  private x(int paramInt, long paramLong, String paramString, LinkedList<cyn> paramLinkedList, bid parambid)
  {
    AppMethodBeat.i(282994);
    this.opType = paramInt;
    this.xbk = paramLong;
    this.userName = paramString;
    d.a locala = new d.a();
    bew localbew = new bew();
    locala.c((a)localbew);
    localbew.fSo = this.opType;
    String str = this.userName;
    paramString = str;
    if (str == null) {
      paramString = z.bdh();
    }
    localbew.finderUsername = paramString;
    localbew.SPJ.add(Long.valueOf(this.xbk));
    paramString = ao.xcj;
    localbew.RLM = ao.a(parambid);
    if (paramLinkedList != null) {
      localbew.SPK = paramLinkedList;
    }
    paramString = new bex();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    locala.d((a)paramString);
    locala.TW("/cgi-bin/micromsg-bin/findermodmentioned");
    locala.vD(6205);
    c(locala.bgN());
    AppMethodBeat.o(282994);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned$Companion;", "", "()V", "OP_TYPE_ADD", "", "OP_TYPE_DELETE", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.x
 * JD-Core Version:    0.7.0.1
 */