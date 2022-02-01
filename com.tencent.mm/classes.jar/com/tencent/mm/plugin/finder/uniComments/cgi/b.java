package com.tencent.mm.plugin.finder.uniComments.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.uniComments.model.a.b;
import com.tencent.mm.plugin.finder.uniComments.storge.d;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.byd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/cgi/CgiFinderUniGetLevel2Comment;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUniGetCommentResponse;", "app_name", "", "entity_id", "rootCommentId", "", "rootComment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "down", "", "(Ljava/lang/String;Ljava/lang/String;JLcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;Z)V", "getApp_name", "()Ljava/lang/String;", "setApp_name", "(Ljava/lang/String;)V", "getDown", "()Z", "setDown", "(Z)V", "getEntity_id", "setEntity_id", "getRootComment", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "setRootComment", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;)V", "getRootCommentId", "()J", "setRootCommentId", "(J)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<byd>
{
  private long ABa;
  private String GaE;
  private d GaF;
  private boolean aLv;
  private String xlJ;
  
  public b(String paramString1, String paramString2, long paramLong, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(341568);
    this.xlJ = paramString1;
    this.GaE = paramString2;
    this.ABa = paramLong;
    this.GaF = paramd;
    this.aLv = paramBoolean;
    paramString1 = new c.a();
    paramString2 = new byc();
    paramString2.xlJ = this.xlJ;
    paramString2.GaE = this.GaE;
    paramd = bi.ABn;
    paramString2.aagN = bi.dVu();
    paramString2.aagP = this.ABa;
    paramString2.ZEQ = this.GaF.Gbp.eZI().lastBuffer;
    if (this.aLv) {
      paramd = a.b.GaT;
    }
    for (int i = a.b.fdF();; i = a.b.fdE())
    {
      paramString2.direction = i;
      paramString1.otE = ((a)paramString2);
      paramString1.otF = ((a)new byd());
      paramString1.uri = "/cgi-bin/micromsg-bin/finderunigetcomment";
      paramString1.funcId = 6953;
      c(paramString1.bEF());
      AppMethodBeat.o(341568);
      return;
      paramd = a.b.GaT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.cgi.b
 * JD-Core Version:    0.7.0.1
 */