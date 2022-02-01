package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "encryptedObjectId", "", "getEncryptedObjectId", "()Ljava/lang/String;", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "()Z", "needRelatedList", "getNeedRelatedList", "setNeedRelatedList", "(Z)V", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isFinderSelfScene", "loadFirstFeed", "next", "Lkotlin/Function0;", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "index", "requestRefresh", "plugin-finder_release"})
public class i$a
  extends u.a
{
  private final boolean drv;
  public String objectNonceId;
  public long rIZ;
  public final boolean rMJ;
  public BaseFinderFeed rQZ;
  public boolean rVA;
  public m<? super Integer, ? super String, z> rVB;
  public d.g.a.b<? super FinderObject, z> rVC;
  public String rVz;
  private final int scene;
  
  private i$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201785);
    this.scene = paramInt;
    this.rMJ = paramBoolean;
    this.drv = false;
    this.objectNonceId = "";
    this.rVz = "";
    this.rVA = true;
    AppMethodBeat.o(201785);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(201782);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(201782);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(201780);
    if (this.rVA)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(201780);
        return;
      }
    }
    AppMethodBeat.o(201780);
  }
  
  public c cAE()
  {
    AppMethodBeat.i(201778);
    c localc = (c)new a(this);
    AppMethodBeat.o(201778);
    return localc;
  }
  
  public final boolean cAz()
  {
    return this.drv;
  }
  
  public final ArrayList<al> cBg()
  {
    AppMethodBeat.i(201781);
    Object localObject = this.rTS;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null)
    {
      localObject = (ArrayList)localObject;
      AppMethodBeat.o(201781);
      return localObject;
    }
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(201784);
    super.onDetach();
    AppMethodBeat.o(201784);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201779);
    final d.g.a.a locala = (d.g.a.a)new c(this);
    p.h(locala, "next");
    long l = this.rIZ;
    String str1 = this.objectNonceId;
    int i = this.rTD;
    int j = this.scene;
    String str2 = this.rVz;
    Object localObject = FinderReporterUIC.tcM;
    localObject = FinderReporterUIC.a.eY((Context)this.fLP);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
    {
      new com.tencent.mm.plugin.finder.cgi.q(l, str1, i, j, "", true, null, null, 0L, null, false, false, str2, (aqy)localObject, 0, 20416).aED().b((com.tencent.mm.vending.c.a)new b(this, locala));
      AppMethodBeat.o(201779);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(201775);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new k((h)this.rVD, this.rVD.rMJ, 0, 4);
        AppMethodBeat.o(201775);
        return localb;
      case 4: 
      case 3002: 
        localb = (com.tencent.mm.view.recyclerview.b)new w(this.rVD.rOe, (h)this.rVD, this.rVD.rMJ, 0, 8);
        AppMethodBeat.o(201775);
        return localb;
      case 2: 
      case 3001: 
        localb = (com.tencent.mm.view.recyclerview.b)new k((h)this.rVD, this.rVD.rMJ, 0, 4);
        AppMethodBeat.o(201775);
        return localb;
      case 7: 
        localb = (com.tencent.mm.view.recyclerview.b)new u((h)this.rVD, this.rVD.rMJ, 0, 4);
        AppMethodBeat.o(201775);
        return localb;
      case 8: 
        localb = (com.tencent.mm.view.recyclerview.b)new n(this.rVD.rOe, (h)this.rVD, this.rVD.rMJ, 0, 8);
        AppMethodBeat.o(201775);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.q((h)this.rVD, this.rVD.rMJ, 0, 4);
      AppMethodBeat.o(201775);
      return localb;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(i.a parama, d.g.a.a parama1) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(i.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i.a
 * JD-Core Version:    0.7.0.1
 */