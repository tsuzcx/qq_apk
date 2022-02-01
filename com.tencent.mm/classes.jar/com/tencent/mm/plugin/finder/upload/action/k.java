package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.cp.f;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.cgi.ad;
import com.tencent.mm.plugin.finder.cgi.bc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "like", "", "isPrivate", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doLikeFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doLikeLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends e
{
  private final bui Auc;
  public final boolean GaB;
  public final FinderItem GcF;
  public final boolean Gdb;
  public final long feedId;
  private final boolean isLongVideo;
  public final String objectNonceId;
  public final int scene;
  
  public k(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, bui parambui)
  {
    super(null);
    AppMethodBeat.i(343365);
    this.GcF = paramFinderItem;
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.GaB = paramBoolean1;
    this.Gdb = paramBoolean2;
    this.scene = paramInt;
    this.Auc = parambui;
    this.isLongVideo = false;
    AppMethodBeat.o(343365);
  }
  
  private static final Object a(k paramk, m.b paramb, b.a parama)
  {
    int i = 0;
    AppMethodBeat.i(343383);
    s.u(paramk, "this$0");
    s.u(paramb, "$callback");
    Log.i("Finder.LikeActionTask", "doLikeLongVideo: isLike" + paramk.GaB + ", it.errType = " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = l.Gdj;
      l.fek().b(paramk);
      paramb.a(i.nrG, false);
      paramb = new if();
      paramb.hJB.id = paramk.feedId;
      parama = paramb.hJB;
      if (paramk.GaB) {
        i = 1;
      }
      parama.hJE = i;
      paramb.hJB.likeCount = paramk.GcF.getLikeCount();
      paramb.hJB.hJD = 1;
      paramb.hJB.hJp = 1;
      paramb.hJB.type = 4;
      boolean bool = paramb.publish();
      AppMethodBeat.o(343383);
      return Boolean.valueOf(bool);
    }
    if (parama.errType == 4)
    {
      parama = l.Gdj;
      l.fek().b(paramk);
      parama = new if();
      parama.hJB.id = paramk.feedId;
      parama.hJB.type = 4;
      parama.hJB.hJp = 1;
      parama.publish();
      paramb.a(i.nrH, false);
    }
    for (;;)
    {
      paramk = ah.aiuX;
      AppMethodBeat.o(343383);
      return paramk;
      paramb.a(i.nrH, true);
    }
  }
  
  private static final Object b(k paramk, m.b paramb, b.a parama)
  {
    int j = 0;
    AppMethodBeat.i(343398);
    s.u(paramk, "this$0");
    s.u(paramb, "$callback");
    Log.i("Finder.LikeActionTask", "LikeActionTask callback " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      int k = paramk.GcF.getLikeCount();
      int m = paramk.GcF.getLikeFlag();
      int n = paramk.GcF.getFriendLikeCount();
      int i1;
      int i;
      if (paramk.GaB)
      {
        parama = paramk.GcF;
        i1 = paramk.GcF.getLikeCount();
        if (paramk.GcF.getLikeFlag() != 0)
        {
          i = 0;
          parama.setLikeCount(i + i1);
          if ((m != 1) || ((paramk.GaB) && (!paramk.Gdb))) {
            break label496;
          }
          parama = paramk.GcF;
          parama.setFriendLikeCount(parama.getFriendLikeCount() - 1);
          label185:
          if ((!paramk.GaB) || (paramk.Gdb)) {
            break label534;
          }
          parama = l.Gdj;
          l.fek();
          l.bd(paramk.GcF.getLikeList());
          label217:
          parama = paramk.GcF;
          if ((!paramk.GaB) || (!paramk.Gdb)) {
            break label555;
          }
          i = 2;
          label238:
          parama.setLikeFlag(i);
          Log.i("Finder.LikeAction", "CgiFinderLikeFeed end likeFlag:" + paramk.GcF.getLikeFlag() + " likeCount " + paramk.GcF.getLikeCount() + " friendLikeCount:" + paramk.GcF.getFriendLikeCount() + ",  " + m + ' ' + k + ", oldFriendLikeCount:" + n);
          parama = l.Gdj;
          l.fek().a(paramk);
          paramb.a(i.nrG, false);
          paramb = new if();
          paramb.hJB.id = paramk.feedId;
          parama = paramb.hJB;
          if ((!paramk.GaB) || (!paramk.Gdb)) {
            break label572;
          }
          i = 2;
        }
      }
      for (;;)
      {
        parama.hJE = i;
        paramb.hJB.likeCount = paramk.GcF.getLikeCount();
        paramb.hJB.hJD = 1;
        paramb.hJB.type = 4;
        boolean bool = paramb.publish();
        AppMethodBeat.o(343398);
        return Boolean.valueOf(bool);
        i = 1;
        break;
        parama = paramk.GcF;
        i1 = paramk.GcF.getLikeCount();
        if (paramk.GcF.getLikeFlag() != 0) {}
        for (i = -1;; i = 0)
        {
          parama.setLikeCount(i + i1);
          break;
        }
        label496:
        if ((m == 1) || (!paramk.GaB) || (paramk.Gdb)) {
          break label185;
        }
        parama = paramk.GcF;
        parama.setFriendLikeCount(parama.getFriendLikeCount() + 1);
        break label185;
        label534:
        parama = l.Gdj;
        l.fek();
        l.bf(paramk.GcF.getLikeList());
        break label217;
        label555:
        if (paramk.GaB)
        {
          i = 1;
          break label238;
        }
        i = 0;
        break label238;
        label572:
        i = j;
        if (paramk.GaB) {
          i = 1;
        }
      }
    }
    if (parama.errType == 4)
    {
      parama = l.Gdj;
      l.fek().a(paramk);
      parama = new if();
      parama.hJB.id = paramk.feedId;
      parama.hJB.type = 4;
      parama.publish();
      paramb.a(i.nrH, false);
    }
    for (;;)
    {
      paramk = ah.aiuX;
      AppMethodBeat.o(343398);
      return paramk;
      paramb.a(i.nrH, true);
    }
  }
  
  public final void a(m.b paramb)
  {
    AppMethodBeat.i(167807);
    s.u(paramb, "callback");
    super.a(paramb);
    if (this.isLongVideo)
    {
      new bc(this, this.Auc).bFJ().g(new k..ExternalSyntheticLambda1(this, paramb));
      AppMethodBeat.o(167807);
      return;
    }
    new ad(this, this.Auc).bFJ().g(new k..ExternalSyntheticLambda0(this, paramb));
    AppMethodBeat.o(167807);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(167806);
    String str = "id_" + this.feedId + '_' + this.GaB;
    AppMethodBeat.o(167806);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(167805);
    String str = "action_" + this.feedId + '_' + this.GaB + '_' + this.scene + '_' + this.Gae;
    AppMethodBeat.o(167805);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.k
 * JD-Core Version:    0.7.0.1
 */