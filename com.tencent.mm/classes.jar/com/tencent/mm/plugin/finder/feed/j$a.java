package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZZI)V", "encryptedObjectId", "", "getEncryptedObjectId", "()Ljava/lang/String;", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "isPostingScene", "()Z", "setPostingScene", "(Z)V", "needRelatedList", "getNeedRelatedList", "setNeedRelatedList", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "checkGetFeedDetail", "next", "Lkotlin/Function0;", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "ifSafeMode", "isFinderSelfScene", "loadFirstFeed", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "index", "requestRefresh", "plugin-finder_release"})
public class j$a
  extends aa.a
{
  private final boolean fCB;
  private String objectNonceId;
  public final boolean safeMode;
  private final int scene;
  public long xbk;
  public String xxK;
  public boolean xxL;
  public m<? super Integer, ? super String, x> xxM;
  public kotlin.g.a.b<? super FinderObject, x> xxN;
  public BaseFinderFeed xxO;
  public boolean xxP;
  
  private j$a(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean, int paramInt2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(280131);
    this.scene = paramInt1;
    this.safeMode = paramBoolean;
    this.fCB = false;
    this.fEH = paramInt2;
    this.objectNonceId = "";
    this.xxK = "";
    this.xxL = true;
    AppMethodBeat.o(280131);
  }
  
  private final void D(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(280123);
    long l = this.xbk;
    Object localObject2 = this.objectNonceId;
    int i = this.xkX;
    int j = this.scene;
    String str = this.xxK;
    Object localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)this.iXq);
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((aj)localObject1).ekY();
      localObject1 = new ag(l, (String)localObject2, i, j, "", true, null, null, 0L, null, false, false, str, (bid)localObject1, 0, null, 53184);
      localObject2 = j.zVy;
      i = this.fEH;
      if (this.xbk == 0L) {
        break label186;
      }
      bool1 = true;
      label116:
      if (((CharSequence)this.xxK).length() <= 0) {
        break label192;
      }
    }
    label186:
    label192:
    for (boolean bool2 = true;; bool2 = false)
    {
      j.b(i, true, bool1, bool2);
      ((ag)localObject1).bhW().a((com.tencent.mm.vending.e.b)this.iXq).b((com.tencent.mm.vending.c.a)new a(this, parama));
      AppMethodBeat.o(280123);
      return;
      localObject1 = null;
      break;
      bool1 = false;
      break label116;
    }
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(280128);
    p.k(paramb, "callback");
    super.a(paramb);
    g localg = g.Xox;
    ((s)g.b((AppCompatActivity)this.iXq).i(s.class)).u(paramb.xvJ.getRecyclerView());
    AppMethodBeat.o(280128);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(280125);
    if (this.xxL)
    {
      Object localObject = j.zVy;
      int i = this.fEH;
      localObject = g.Xox;
      j.a(i, 2, ((aj)g.b((AppCompatActivity)this.iXq).i(aj.class)).ekY(), 4L);
      j.a(j.zVy, this.fEH, true, null, 12);
      localObject = this.xnX;
      if (localObject != null)
      {
        ((BaseFinderFeedLoader)localObject).requestLoadMore();
        AppMethodBeat.o(280125);
        return;
      }
    }
    AppMethodBeat.o(280125);
  }
  
  public final boolean dsZ()
  {
    return this.safeMode;
  }
  
  public final boolean dsp()
  {
    return this.fCB;
  }
  
  public final ArrayList<bu> dta()
  {
    AppMethodBeat.i(280127);
    Object localObject = this.xnX;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null)
    {
      localObject = (ArrayList)localObject;
      AppMethodBeat.o(280127);
      return localObject;
    }
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(280130);
    super.onDetach();
    AppMethodBeat.o(280130);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(280124);
    Object localObject1 = j.zVy;
    int i = this.fEH;
    localObject1 = g.Xox;
    j.a(i, 0, ((aj)g.b((AppCompatActivity)this.iXq).i(aj.class)).ekY(), 4L);
    j.a(j.zVy, this.fEH, true, null, 12);
    Object localObject3 = (kotlin.g.a.a)new d(this);
    p.k(localObject3, "next");
    Object localObject2;
    if (this.xxP)
    {
      localObject2 = getTAG();
      localObject3 = new StringBuilder("loadFirstFeed objectId = 0, localId = ");
      localObject1 = this.xxO;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 == null) {}
      }
      for (localObject1 = Long.valueOf(((FinderItem)localObject1).getLocalId());; localObject1 = null)
      {
        Log.i((String)localObject2, localObject1);
        if (this.xxO == null) {
          d.uiThread((kotlin.g.a.a)new b(this));
        }
        AppMethodBeat.o(280124);
        return;
      }
    }
    if (this.iXq.getIntent().getIntExtra("business_type", 0) == 1)
    {
      localObject2 = this.iXq.getIntent().getStringExtra("finder_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      long l = this.xbk;
      String str = this.objectNonceId;
      localObject2 = aj.Bnu;
      localObject2 = aj.a.fZ((Context)this.iXq);
      if (localObject2 != null) {}
      for (localObject2 = ((aj)localObject2).ekY();; localObject2 = null)
      {
        new ak(l, (String)localObject1, str, 1, (bid)localObject2).bhW().a((com.tencent.mm.vending.e.b)this.iXq).b((com.tencent.mm.vending.c.a)new c(this, (kotlin.g.a.a)localObject3));
        AppMethodBeat.o(280124);
        return;
      }
    }
    D((kotlin.g.a.a)localObject3);
    AppMethodBeat.o(280124);
  }
  
  public final void setObjectNonceId(String paramString)
  {
    AppMethodBeat.i(280122);
    p.k(paramString, "<set-?>");
    this.objectNonceId = paramString;
    AppMethodBeat.o(280122);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(j.a parama, kotlin.g.a.a parama1) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(j.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(j.a parama, kotlin.g.a.a parama1) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(j.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.a
 * JD-Core Version:    0.7.0.1
 */