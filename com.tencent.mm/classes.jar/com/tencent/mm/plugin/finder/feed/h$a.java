package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.convert.p;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.f.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "()Z", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getFeedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "isFinderSelfScene", "loadFirstFeed", "next", "Lkotlin/Function0;", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "index", "requestRefresh", "plugin-finder_release"})
public class h$a
  extends r.a
{
  private final boolean dfZ;
  public String objectNonceId;
  public long qXP;
  public final boolean ran;
  public BaseFinderFeed rdD;
  public d.g.a.m<? super Integer, ? super String, y> rhv;
  public d.g.a.b<? super FinderObject, y> rhw;
  private final int scene;
  
  private h$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201588);
    this.scene = paramInt;
    this.ran = paramBoolean;
    this.dfZ = false;
    this.objectNonceId = "";
    AppMethodBeat.o(201588);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(201585);
    k.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(201585);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201583);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(201583);
      return;
    }
    AppMethodBeat.o(201583);
  }
  
  public final ArrayList<BaseFinderFeed> cuP()
  {
    AppMethodBeat.i(201584);
    Object localObject = this.rgh;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null)
    {
      localObject = (ArrayList)localObject;
      AppMethodBeat.o(201584);
      return localObject;
    }
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.g cup()
  {
    AppMethodBeat.i(201580);
    Object localObject = this.rgh;
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader");
      AppMethodBeat.o(201580);
      throw ((Throwable)localObject);
    }
    localObject = (com.tencent.mm.plugin.finder.feed.model.internal.g)new f.b(((com.tencent.mm.plugin.finder.feed.model.f)localObject).dig, (com.tencent.mm.plugin.finder.feed.model.internal.f)new b());
    AppMethodBeat.o(201580);
    return localObject;
  }
  
  public final boolean cuq()
  {
    return this.dfZ;
  }
  
  public c cut()
  {
    AppMethodBeat.i(201581);
    c localc = (c)new a(this);
    AppMethodBeat.o(201581);
    return localc;
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(201587);
    super.onDetach();
    AppMethodBeat.o(201587);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201582);
    final d.g.a.a locala = (d.g.a.a)new d(this);
    k.h(locala, "next");
    long l = this.qXP;
    String str = this.objectNonceId;
    int i = this.rfR;
    int j = this.scene;
    Object localObject = FinderReporterUIC.seQ;
    localObject = FinderReporterUIC.a.eV((Context)this.iMV);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cGb();; localObject = null)
    {
      new com.tencent.mm.plugin.finder.cgi.m(l, str, i, j, "", true, null, null, 0L, null, false, false, null, (anm)localObject, 8128).aBB().b((com.tencent.mm.vending.c.a)new c(this, locala));
      AppMethodBeat.o(201582);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(201577);
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new j((g)this.rhx, this.rhx.ran, 0, 4);
        AppMethodBeat.o(201577);
        return localb;
      case 4: 
        localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.v(this.rhx.rbo, (g)this.rhx, this.rhx.ran, 0, 8);
        AppMethodBeat.o(201577);
        return localb;
      case 2: 
        localb = (com.tencent.mm.view.recyclerview.b)new j((g)this.rhx, this.rhx.ran, 0, 4);
        AppMethodBeat.o(201577);
        return localb;
      case 7: 
        localb = (com.tencent.mm.view.recyclerview.b)new t((g)this.rhx, this.rhx.ran, 0, 4);
        AppMethodBeat.o(201577);
        return localb;
      case 8: 
        localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.m(this.rhx.rbo, (g)this.rhx, this.rhx.ran, 0, 8);
        AppMethodBeat.o(201577);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new p((g)this.rhx, this.rhx.ran, 0, 4);
      AppMethodBeat.o(201577);
      return localb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.finder.feed.model.internal.f
  {
    public final void call(int paramInt) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(h.a parama, d.g.a.a parama1) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(h.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.a
 * JD-Core Version:    0.7.0.1
 */