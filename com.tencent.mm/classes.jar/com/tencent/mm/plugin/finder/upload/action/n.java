package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.cgi.ac;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", "comment", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends e
{
  private final bui Auc;
  public final boolean GaB;
  public final au Gdp;
  private final boolean Gdq;
  public final long feedId;
  public final String objectNonceId;
  public final int scene;
  
  public n(long paramLong, String paramString, au paramau, boolean paramBoolean1, int paramInt, bui parambui, boolean paramBoolean2)
  {
    super(null);
    AppMethodBeat.i(343414);
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.Gdp = paramau;
    this.GaB = paramBoolean1;
    this.scene = paramInt;
    this.Auc = parambui;
    this.Gdq = paramBoolean2;
    AppMethodBeat.o(343414);
  }
  
  private static final ah a(n paramn, m.b paramb, b.a parama)
  {
    AppMethodBeat.i(343439);
    s.u(paramn, "this$0");
    s.u(paramb, "$callback");
    Log.i("Finder.LikeActionTask", "LikeActionTask callback " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    boolean bool;
    int k;
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      int j = paramn.Gdp.eZI().likeCount;
      if (paramn.Gdp.eZI().likeFlag == 1)
      {
        bool = true;
        if (!paramn.GaB) {
          break label323;
        }
        parama = paramn.Gdp;
        k = paramn.Gdp.eZI().likeCount;
        if (!bool) {
          break label318;
        }
        i = 0;
        label139:
        parama.setLikeCount(i + k);
        parama = paramn.Gdp;
        if (!paramn.GaB) {
          break label363;
        }
        i = 1;
        label161:
        parama.eZI().likeFlag = i;
        if ((paramn.Gdq) && (paramn.scene == 1))
        {
          if (!paramn.GaB) {
            break label368;
          }
          paramn.Gdp.Tu(paramn.Gdp.eZI().displayFlag | 0x1);
        }
        label210:
        i = paramn.Gdp.eZI().likeFlag;
        Log.i("Finder.LikeCommentAction", "CgiFinderLikeFeed end likeFlag: " + i + " likeCount " + paramn.Gdp.eZI().likeCount + ' ' + bool + ' ' + j);
        parama = l.Gdj;
        l.fek().a(paramn);
        paramb.a(i.nrG, false);
      }
    }
    for (;;)
    {
      paramn = ah.aiuX;
      AppMethodBeat.o(343439);
      return paramn;
      bool = false;
      break;
      label318:
      i = 1;
      break label139;
      label323:
      parama = paramn.Gdp;
      k = paramn.Gdp.eZI().likeCount;
      if (bool) {}
      for (i = -1;; i = 0)
      {
        parama.setLikeCount(i + k);
        break;
      }
      label363:
      i = 0;
      break label161;
      label368:
      paramn.Gdp.Tu(paramn.Gdp.eZI().displayFlag & 0xFFFFFFFE);
      break label210;
      if (parama.errType == 4)
      {
        d.uiThread((a)new a(paramn));
        paramb.a(i.nrH, false);
      }
      else
      {
        paramb.a(i.nrH, true);
      }
    }
  }
  
  public final void a(m.b paramb)
  {
    AppMethodBeat.i(167834);
    s.u(paramb, "callback");
    super.a(paramb);
    new ac(this, this.Auc).bFJ().g(new n..ExternalSyntheticLambda0(this, paramb));
    AppMethodBeat.o(167834);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(167832);
    String str = "id_" + this.feedId + '_' + this.Gdp.eZI().commentId + '_' + this.GaB + '_' + this.scene + '_' + this.Gae;
    AppMethodBeat.o(167832);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167833);
    String str = "action_" + this.feedId + '_' + this.Gdp.eZI().commentId + '_' + this.GaB + '_' + this.scene;
    AppMethodBeat.o(167833);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.n
 * JD-Core Version:    0.7.0.1
 */