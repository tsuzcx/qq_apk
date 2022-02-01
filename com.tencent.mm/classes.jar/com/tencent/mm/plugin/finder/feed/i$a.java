package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "encryptedObjectId", "", "getEncryptedObjectId", "()Ljava/lang/String;", "setEncryptedObjectId", "(Ljava/lang/String;)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "()Z", "needRelatedList", "getNeedRelatedList", "setNeedRelatedList", "(Z)V", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "getObjectNonceId", "setObjectNonceId", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "isFinderSelfScene", "loadFirstFeed", "next", "Lkotlin/Function0;", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "index", "requestRefresh", "plugin-finder_release"})
public class i$a
  extends u.a
{
  private final boolean dsB;
  public String objectNonceId;
  public long rRn;
  public final boolean rUX;
  public BaseFinderFeed rZB;
  private final int scene;
  public String sef;
  public boolean seg;
  public m<? super Integer, ? super String, z> seh;
  public d.g.a.b<? super FinderObject, z> sei;
  
  private i$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramMMActivity);
    AppMethodBeat.i(202244);
    this.scene = paramInt;
    this.rUX = paramBoolean;
    this.dsB = false;
    this.objectNonceId = "";
    this.sef = "";
    this.seg = true;
    AppMethodBeat.o(202244);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(202241);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(202241);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202239);
    if (this.seg)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(202239);
        return;
      }
    }
    AppMethodBeat.o(202239);
  }
  
  public final ArrayList<am> cCS()
  {
    AppMethodBeat.i(202240);
    Object localObject = this.scw;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null)
    {
      localObject = (ArrayList)localObject;
      AppMethodBeat.o(202240);
      return localObject;
    }
  }
  
  public final boolean cCl()
  {
    return this.dsB;
  }
  
  public c cCq()
  {
    AppMethodBeat.i(202237);
    c localc = (c)new a(this);
    AppMethodBeat.o(202237);
    return localc;
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(202243);
    super.onDetach();
    AppMethodBeat.o(202243);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202238);
    final d.g.a.a locala = (d.g.a.a)new c(this);
    p.h(locala, "next");
    long l = this.rRn;
    String str1 = this.objectNonceId;
    int i = this.sch;
    int j = this.scene;
    String str2 = this.sef;
    Object localObject = FinderReporterUIC.tnG;
    localObject = FinderReporterUIC.a.fc((Context)this.fNT);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
    {
      new com.tencent.mm.plugin.finder.cgi.q(l, str1, i, j, "", true, null, null, 0L, null, false, false, str2, (arn)localObject, 0, 20416).aET().b((com.tencent.mm.vending.c.a)new b(this, locala));
      AppMethodBeat.o(202238);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(202234);
      switch (paramInt)
      {
      default: 
        localb = (com.tencent.mm.view.recyclerview.b)new k((h)this.sej, this.sej.rUX, 0, 4);
        AppMethodBeat.o(202234);
        return localb;
      case 4: 
      case 3002: 
        localb = (com.tencent.mm.view.recyclerview.b)new w(this.sej.rWB, (h)this.sej, this.sej.rUX, 0, 8);
        AppMethodBeat.o(202234);
        return localb;
      case 2: 
      case 3001: 
        localb = (com.tencent.mm.view.recyclerview.b)new k((h)this.sej, this.sej.rUX, 0, 4);
        AppMethodBeat.o(202234);
        return localb;
      case 7: 
        localb = (com.tencent.mm.view.recyclerview.b)new u((h)this.sej, this.sej.rUX, 0, 4);
        AppMethodBeat.o(202234);
        return localb;
      case 8: 
        localb = (com.tencent.mm.view.recyclerview.b)new n(this.sej.rWB, (h)this.sej, this.sej.rUX, 0, 8);
        AppMethodBeat.o(202234);
        return localb;
      }
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.q((h)this.sej, this.sej.rUX, 0, 4);
      AppMethodBeat.o(202234);
      return localb;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(i.a parama, d.g.a.a parama1) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i.a
 * JD-Core Version:    0.7.0.1
 */