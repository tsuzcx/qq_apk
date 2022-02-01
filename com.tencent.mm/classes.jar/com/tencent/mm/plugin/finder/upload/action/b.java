package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.cp.f;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "fav", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "source", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ZI)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFav", "()Z", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "getSource", "doFavFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doFavLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  private final bui Auc;
  public final FinderItem GcF;
  public final boolean GcG;
  public final long feedId;
  private final boolean isLongVideo;
  public final String objectNonceId;
  private final int scene;
  public final int source;
  
  public b(FinderItem paramFinderItem, long paramLong, String paramString, boolean paramBoolean, int paramInt1, bui parambui, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(343320);
    this.GcF = paramFinderItem;
    this.feedId = paramLong;
    this.objectNonceId = paramString;
    this.GcG = paramBoolean;
    this.scene = paramInt1;
    this.Auc = parambui;
    this.isLongVideo = false;
    this.source = paramInt2;
    AppMethodBeat.o(343320);
  }
  
  private static final Object a(b paramb, m.b paramb1, b.a parama)
  {
    AppMethodBeat.i(343330);
    s.u(paramb, "this$0");
    s.u(paramb1, "$callback");
    Log.i("Finder.FavActionTask", "doFavLongVideo: isFav" + paramb.GcG + ", it.errType = " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = c.GcH;
      c.fee().b(paramb);
      paramb1.a(i.nrG, false);
      paramb1 = new if();
      paramb1.hJB.id = paramb.feedId;
      parama = paramb1.hJB;
      if (paramb.GcG) {}
      for (int i = 1;; i = 2)
      {
        parama.hJC = i;
        paramb1.hJB.hJD = 1;
        paramb1.hJB.type = 5;
        paramb1.hJB.hJp = 1;
        boolean bool = paramb1.publish();
        AppMethodBeat.o(343330);
        return Boolean.valueOf(bool);
      }
    }
    if (parama.errType == 4)
    {
      parama = c.GcH;
      c.fee().b(paramb);
      parama = new if();
      parama.hJB.id = paramb.feedId;
      parama.hJB.hJp = 1;
      parama.publish();
      paramb1.a(i.nrH, false);
    }
    for (;;)
    {
      paramb = ah.aiuX;
      AppMethodBeat.o(343330);
      return paramb;
      paramb1.a(i.nrH, true);
    }
  }
  
  private static final Object b(b paramb, m.b paramb1, b.a parama)
  {
    AppMethodBeat.i(343344);
    s.u(paramb, "this$0");
    s.u(paramb1, "$callback");
    Log.i("Finder.FavActionTask", "FavActionTask callback " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      int j = paramb.GcF.getFavCount();
      int k = paramb.GcF.getFavFlag();
      int m;
      if (paramb.GcG)
      {
        parama = paramb.GcF;
        m = paramb.GcF.getFavCount();
        if (paramb.GcF.getFavFlag() == 1)
        {
          i = 0;
          parama.setFavCount(i + m);
          parama = paramb.GcF;
          if (!paramb.GcG) {
            break label360;
          }
          i = 1;
          label153:
          parama.setFavFlag(i);
          Log.i("Finder.FavAction", "CgiFinderFavFeed end favFlag:" + paramb.GcF.getFavFlag() + " favCount " + paramb.GcF.getFavCount() + ' ' + k + ' ' + j);
          parama = c.GcH;
          c.fee().a(paramb);
          paramb1.a(i.nrG, false);
          paramb1 = new if();
          paramb1.hJB.id = paramb.feedId;
          parama = paramb1.hJB;
          if (!paramb.GcG) {
            break label365;
          }
        }
      }
      label360:
      label365:
      for (int i = 1;; i = 2)
      {
        parama.hJC = i;
        paramb1.hJB.hJD = 1;
        paramb1.hJB.type = 5;
        boolean bool = paramb1.publish();
        AppMethodBeat.o(343344);
        return Boolean.valueOf(bool);
        i = 1;
        break;
        parama = paramb.GcF;
        m = paramb.GcF.getFavCount();
        if (paramb.GcF.getFavFlag() == 1) {}
        for (i = -1;; i = 0)
        {
          parama.setFavCount(i + m);
          break;
        }
        i = 0;
        break label153;
      }
    }
    if (parama.errType == 4)
    {
      parama = c.GcH;
      c.fee().a(paramb);
      parama = new if();
      parama.hJB.id = paramb.feedId;
      parama.publish();
      paramb1.a(i.nrH, false);
    }
    for (;;)
    {
      paramb = ah.aiuX;
      AppMethodBeat.o(343344);
      return paramb;
      paramb1.a(i.nrH, true);
    }
  }
  
  public final void a(m.b paramb)
  {
    AppMethodBeat.i(343390);
    s.u(paramb, "callback");
    super.a(paramb);
    if (this.isLongVideo)
    {
      new com.tencent.mm.plugin.finder.cgi.e(this, this.Auc).bFJ().g(new b..ExternalSyntheticLambda0(this, paramb));
      AppMethodBeat.o(343390);
      return;
    }
    new m(this, this.Auc).bFJ().g(new b..ExternalSyntheticLambda1(this, paramb));
    AppMethodBeat.o(343390);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343382);
    String str = "id_" + this.feedId + '_' + this.GcG;
    AppMethodBeat.o(343382);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(343373);
    String str = "action_" + this.feedId + '_' + this.GcG + '_' + this.scene + '_' + this.Gae;
    AppMethodBeat.o(343373);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.b
 * JD-Core Version:    0.7.0.1
 */