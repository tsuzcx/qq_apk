package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "tabType", "(ILcom/tencent/mm/ui/MMActivity;ZZI)V", "encryptedObjectId", "", "getEncryptedObjectId", "()Ljava/lang/String;", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "isPostingScene", "()Z", "setPostingScene", "(Z)V", "needRelatedList", "getNeedRelatedList", "setNeedRelatedList", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "ifSafeMode", "isFinderSelfScene", "loadFirstFeed", "next", "Lkotlin/Function0;", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "index", "requestRefresh", "plugin-finder_release"})
public class j$a
  extends v.a
{
  private final boolean dJM;
  public long hFK;
  public String objectNonceId;
  private final int scene;
  public final boolean tAj;
  public String tNK;
  public boolean tNL;
  public m<? super Integer, ? super String, x> tNM;
  public b<? super FinderObject, x> tNN;
  public BaseFinderFeed tNO;
  public boolean tNP;
  
  private j$a(int paramInt1, MMActivity paramMMActivity, boolean paramBoolean, int paramInt2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(243790);
    this.scene = paramInt1;
    this.tAj = paramBoolean;
    this.dJM = false;
    this.dLS = paramInt2;
    this.objectNonceId = "";
    this.tNK = "";
    this.tNL = true;
    AppMethodBeat.o(243790);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(243787);
    p.h(paramb, "callback");
    super.a(paramb);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((FinderFeedMegaVideoBtnAnimUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(paramb.tLS.getRecyclerView());
    AppMethodBeat.o(243787);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243785);
    if (this.tNL)
    {
      Object localObject = h.veu;
      int i = this.dLS;
      localObject = com.tencent.mm.ui.component.a.PRN;
      h.a(i, 2, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx(), 4L);
      h.a(h.veu, this.dLS, true, null, 12);
      localObject = this.tFM;
      if (localObject != null)
      {
        ((BaseFinderFeedLoader)localObject).requestLoadMore();
        AppMethodBeat.o(243785);
        return;
      }
    }
    AppMethodBeat.o(243785);
  }
  
  public final boolean dbZ()
  {
    return this.dJM;
  }
  
  public final boolean dcG()
  {
    return this.tAj;
  }
  
  public final ArrayList<bo> dcH()
  {
    AppMethodBeat.i(243786);
    Object localObject = this.tFM;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null)
    {
      localObject = (ArrayList)localObject;
      AppMethodBeat.o(243786);
      return localObject;
    }
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(243789);
    super.onDetach();
    AppMethodBeat.o(243789);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(243784);
    Object localObject1 = h.veu;
    int i = this.dLS;
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    h.a(i, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx(), 4L);
    h.a(h.veu, this.dLS, true, null, 12);
    Object localObject2 = (kotlin.g.a.a)new c(this);
    p.h(localObject2, "next");
    if (this.tNP)
    {
      localObject2 = getTAG();
      localObject3 = new StringBuilder("loadFirstFeed objectId = 0, localId = ");
      localObject1 = this.tNO;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject;
        if (localObject1 == null) {}
      }
      for (localObject1 = Long.valueOf(((FinderItem)localObject1).getLocalId());; localObject1 = null)
      {
        Log.i((String)localObject2, localObject1);
        if (this.tNO == null) {
          d.h((kotlin.g.a.a)new a(this));
        }
        AppMethodBeat.o(243784);
        return;
      }
    }
    long l = this.hFK;
    Object localObject3 = this.objectNonceId;
    i = this.tCE;
    int j = this.scene;
    String str = this.tNK;
    localObject1 = FinderReporterUIC.wzC;
    localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((FinderReporterUIC)localObject1).dIx();
      localObject1 = new af(l, (String)localObject3, i, j, "", true, null, null, 0L, null, false, false, str, (bbn)localObject1, 0, 20416);
      localObject3 = h.veu;
      i = this.dLS;
      if (this.hFK == 0L) {
        break label359;
      }
      bool1 = true;
      label298:
      if (((CharSequence)this.tNK).length() <= 0) {
        break label365;
      }
    }
    label359:
    label365:
    for (boolean bool2 = true;; bool2 = false)
    {
      h.b(i, true, bool1, bool2);
      ((af)localObject1).aYI().b((com.tencent.mm.vending.c.a)new b(this, (kotlin.g.a.a)localObject2));
      AppMethodBeat.o(243784);
      return;
      localObject1 = null;
      break;
      bool1 = false;
      break label298;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(j.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(j.a parama, kotlin.g.a.a parama1) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(j.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.a
 * JD-Core Version:    0.7.0.1
 */