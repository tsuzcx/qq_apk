package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "()V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class af
  extends c<atv>
{
  public static final a xbO;
  
  static
  {
    AppMethodBeat.i(273572);
    xbO = new a((byte)0);
    AppMethodBeat.o(273572);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact$Companion;", "", "()V", "CONTACT_TYPE_COMMENT", "", "CONTACT_TYPE_COMMENT_AD", "CONTACT_TYPE_FANS", "CONTACT_TYPE_FINDER_USERNAME", "CONTACT_TYPE_PERSONAL_MSG", "CONTACT_TYPE_SELF_ALIAS", "TAG", "", "create", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact;", "usernameList", "", "create2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "create3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "create4", "create5", "plugin-finder_release"})
  public static final class a
  {
    public static af dW(List<? extends arg> paramList)
    {
      AppMethodBeat.i(281012);
      p.k(paramList, "usernameList");
      af localaf = new af();
      d.a locala = new d.a();
      atu localatu = new atu();
      ao localao = ao.xcj;
      localatu.SDi = ao.dnO();
      localatu.SGE = 1;
      localatu.RLN = z.bdh();
      localatu.SGF.addAll((Collection)paramList);
      locala.c((a)localatu);
      paramList = new atv();
      paramList.setBaseResponse(new jh());
      paramList.getBaseResponse().Tef = new eaf();
      locala.d((a)paramList);
      locala.TW("/cgi-bin/micromsg-bin/findergetcontactlist");
      locala.vD(3953);
      localaf.c(locala.bgN());
      AppMethodBeat.o(281012);
      return localaf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.af
 * JD-Core Version:    0.7.0.1
 */