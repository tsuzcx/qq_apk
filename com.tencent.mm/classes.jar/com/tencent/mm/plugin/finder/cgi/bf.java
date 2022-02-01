package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiPrivateMsgContactExtInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetPrivateMsgContactExtInfoListResponse;", "userList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "(Ljava/util/LinkedList;)V", "getUserList", "()Ljava/util/LinkedList;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
  extends b<bar>
{
  public static final bf.a ABj;
  private final LinkedList<avo> ABk;
  
  static
  {
    AppMethodBeat.i(336486);
    ABj = new bf.a((byte)0);
    AppMethodBeat.o(336486);
  }
  
  public bf(LinkedList<avo> paramLinkedList)
  {
    AppMethodBeat.i(336483);
    this.ABk = paramLinkedList;
    paramLinkedList = new baq();
    Object localObject = bi.ABn;
    paramLinkedList.YIY = bi.dVu();
    paramLinkedList.ZLx = this.ABk;
    localObject = new c.a();
    ((c.a)localObject).otE = ((a)paramLinkedList);
    paramLinkedList = new bar();
    paramLinkedList.setBaseResponse(new kd());
    ((c.a)localObject).otF = ((a)paramLinkedList);
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/findergetprivatemsgcontactextinfolist";
    ((c.a)localObject).funcId = 6688;
    c(((c.a)localObject).bEF());
    Log.i("Cgi.CgiPrivateMsgContactExtInfo", s.X("CgiPrivateMsgContactExtInfo init userNameList.size = ", Integer.valueOf(this.ABk.size())));
    AppMethodBeat.o(336483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bf
 * JD-Core Version:    0.7.0.1
 */