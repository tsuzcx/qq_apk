package com.tencent.mm.plugin.finder.uniComments.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.uniComments.cgi.c;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeCommentAction;", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniAction;", "feedItem", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "comment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "like", "", "InteractionIdentityType", "", "uicallback", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$ILikeActionCallback;", "(Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;ZILcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$ILikeActionCallback;)V", "getInteractionIdentityType", "()I", "getComment", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "feedId", "", "getFeedId", "()J", "getFeedItem", "()Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "getLike", "()Z", "scene", "getScene", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask$ICallback;", "toString", "", "uniqueId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  final com.tencent.mm.plugin.finder.uniComments.storge.b GaA;
  final boolean GaB;
  private final int GaC;
  private final com.tencent.mm.plugin.finder.uniComments.model.b Gaz;
  final long feedId;
  final int scene;
  
  public f(com.tencent.mm.plugin.finder.uniComments.model.b paramb, com.tencent.mm.plugin.finder.uniComments.storge.b paramb1, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(341622);
    this.Gaz = paramb;
    this.GaA = paramb1;
    this.GaB = paramBoolean;
    this.GaC = paramInt;
    this.feedId = this.Gaz.field_id;
    this.scene = this.GaC;
    AppMethodBeat.o(341622);
  }
  
  private static final ah a(f paramf, e.b paramb, b.a parama)
  {
    int j = 1;
    AppMethodBeat.i(341637);
    s.u(paramf, "this$0");
    s.u(paramb, "$callback");
    boolean bool;
    int m;
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      int k = paramf.GaA.eZI().likeCount;
      if (paramf.GaA.eZI().likeFlag == 1)
      {
        bool = true;
        if (!paramf.GaB) {
          break label238;
        }
        parama = paramf.GaA;
        m = paramf.GaA.eZI().likeCount;
        if (!bool) {
          break label233;
        }
        i = 0;
        label94:
        parama.setLikeCount(i + m);
        parama = paramf.GaA;
        if (!paramf.GaB) {
          break label278;
        }
        i = j;
        label117:
        parama.eZI().likeFlag = i;
        i = paramf.GaA.eZI().likeFlag;
        Log.i("Finder.LikeCommentAction", "CgiFinderLikeFeed end likeFlag: " + i + " likeCount " + paramf.GaA.eZI().likeCount + ' ' + bool + ' ' + k);
        parama = d.Gao;
        d.fdB().a(paramf);
        paramb.a(i.nrG, false);
      }
    }
    for (;;)
    {
      paramf = ah.aiuX;
      AppMethodBeat.o(341637);
      return paramf;
      bool = false;
      break;
      label233:
      i = 1;
      break label94;
      label238:
      parama = paramf.GaA;
      m = paramf.GaA.eZI().likeCount;
      if (bool) {}
      for (i = -1;; i = 0)
      {
        parama.setLikeCount(i + m);
        break;
      }
      label278:
      i = 0;
      break label117;
      if (parama.errType == 4)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramf));
        paramb.a(i.nrH, false);
      }
      else
      {
        paramb.a(i.nrH, true);
      }
    }
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(341674);
    s.u(paramb, "callback");
    super.a(paramb);
    c localc = new c(this.Gaz);
    long l = this.GaA.eZI().commentId;
    int i;
    int j;
    c.a locala;
    bye localbye;
    if (this.GaB)
    {
      i = 3;
      j = this.GaC;
      locala = new c.a();
      localbye = new bye();
      localbye.xlJ = localc.Gah.xlJ;
      localbye.GaE = localc.Gah.GaE;
      localObject = localc.Gah.Gbe;
      if (localObject != null) {
        break label244;
      }
    }
    for (Object localObject = null;; localObject = aw.j((com.tencent.mm.bx.a)localObject))
    {
      localbye.aagU = ((com.tencent.mm.bx.b)localObject);
      localObject = bi.ABn;
      localbye.aagN = bi.dVu();
      localbye.ZFw = l;
      localbye.aagR = i;
      localbye.aagS = j;
      localbye.ZNy = System.currentTimeMillis();
      locala.otE = ((com.tencent.mm.bx.a)localbye);
      locala.otF = ((com.tencent.mm.bx.a)new byf());
      locala.uri = "/cgi-bin/micromsg-bin/finderunilike";
      locala.funcId = 6989;
      localc.c(locala.bEF());
      localc.bFJ().g(new f..ExternalSyntheticLambda0(this, paramb));
      AppMethodBeat.o(341674);
      return;
      i = 4;
      break;
      label244:
      aw localaw = aw.Gjk;
    }
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(341655);
    String str = "id_" + this.Gaz.id + '_' + this.GaA.eZI().commentId + '_' + this.GaB + '_' + this.GaC + '_' + this.Gae;
    AppMethodBeat.o(341655);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(341660);
    String str = "action_" + this.Gaz.id + '_' + this.GaA.eZI().commentId + '_' + this.GaB + '_' + this.GaC;
    AppMethodBeat.o(341660);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.action.f
 * JD-Core Version:    0.7.0.1
 */