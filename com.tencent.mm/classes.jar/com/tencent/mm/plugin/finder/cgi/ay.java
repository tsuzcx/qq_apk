package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "()V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  extends b<ayn>
{
  public static final a AAR;
  
  static
  {
    AppMethodBeat.i(336182);
    AAR = new a((byte)0);
    AppMethodBeat.o(336182);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact$Companion;", "", "()V", "CONTACT_TYPE_COMMENT", "", "CONTACT_TYPE_COMMENT_AD", "CONTACT_TYPE_COMMENT_LIKE", "CONTACT_TYPE_FANS", "CONTACT_TYPE_FINDER_USERNAME", "CONTACT_TYPE_PERSONAL_MSG", "CONTACT_TYPE_SELF_ALIAS", "CONTACT_TYPE_STRANGER", "TAG", "", "create", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact;", "usernameList", "", "create2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "create3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "create4", "create5", "create6", "fansContactList", "Lcom/tencent/mm/protocal/protobuf/FinderContactFansInfo;", "create7", "commentLikeInfoList", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentLikeInfo;", "create8", "strangerInfoList", "Lcom/tencent/mm/protocal/protobuf/FinderContactStrangerInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static ay fT(List<? extends avo> paramList)
    {
      AppMethodBeat.i(336778);
      s.u(paramList, "usernameList");
      ay localay = new ay();
      c.a locala = new c.a();
      aym localaym = new aym();
      bi localbi = bi.ABn;
      localaym.ZEc = bi.dVu();
      localaym.ZJt = 1;
      localaym.YIZ = z.bAW();
      localaym.ZJu.addAll((Collection)paramList);
      locala.otE = ((a)localaym);
      paramList = new ayn();
      paramList.setBaseResponse(new kd());
      paramList.getBaseResponse().akjO = new etl();
      locala.otF = ((a)paramList);
      locala.uri = "/cgi-bin/micromsg-bin/findergetcontactlist";
      locala.funcId = 3953;
      localay.c(locala.bEF());
      AppMethodBeat.o(336778);
      return localay;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ay
 * JD-Core Version:    0.7.0.1
 */