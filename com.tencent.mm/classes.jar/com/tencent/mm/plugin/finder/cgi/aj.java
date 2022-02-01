package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;", "opType", "", "objectId", "", "userName", "", "mentionList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModMentionedInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IJLjava/lang/String;Ljava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getObjectId", "()J", "getOpType", "()I", "getUserName", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
  extends c<bpy>
{
  public static final a AzU;
  private final long hKN;
  private final int opType;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(336256);
    AzU = new a((byte)0);
    AppMethodBeat.o(336256);
  }
  
  private aj(int paramInt, long paramLong, String paramString, LinkedList<dpt> paramLinkedList, bui parambui)
  {
    AppMethodBeat.i(336232);
    this.opType = paramInt;
    this.hKN = paramLong;
    this.userName = paramString;
    c.a locala = new c.a();
    bpx localbpx = new bpx();
    locala.otE = ((a)localbpx);
    localbpx.hYl = this.opType;
    String str = this.userName;
    paramString = str;
    if (str == null) {
      paramString = z.bAW();
    }
    localbpx.finderUsername = paramString;
    localbpx.ZYb.add(Long.valueOf(this.hKN));
    paramString = bi.ABn;
    localbpx.YIY = bi.a(parambui);
    if (paramLinkedList != null) {
      localbpx.ZYc = paramLinkedList;
    }
    paramString = new bpy();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    locala.otF = ((a)paramString);
    locala.uri = "/cgi-bin/micromsg-bin/findermodmentioned";
    locala.funcId = 6205;
    c(locala.bEF());
    AppMethodBeat.o(336232);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderModMentioned$Companion;", "", "()V", "OP_TYPE_ADD", "", "OP_TYPE_DELETE", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aj
 * JD-Core Version:    0.7.0.1
 */