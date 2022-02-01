package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.c;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "index", "", "getDataIndex", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "Ljava/util/ArrayList;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "ifSafeMode", "", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ae$a
  extends b.a
{
  public BaseFinderFeedLoader ALH;
  private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
  
  public ae$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final cc NC(int paramInt)
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader == null) {
      return null;
    }
    return (cc)localBaseFinderFeedLoader.safeGet(paramInt);
  }
  
  public void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    s.u(paramBaseFinderFeedLoader, "model");
    s.u(paramb, "callback");
    this.ALH = paramBaseFinderFeedLoader;
    super.a((b.b)paramb);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.component.t)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.t.class)).E(paramb.ATx.getRecyclerView());
    paramb = com.tencent.mm.plugin.finder.preload.f.EUC;
    l locall;
    if (com.tencent.mm.plugin.finder.preload.f.eHI())
    {
      paramb = com.tencent.mm.ui.component.k.aeZF;
      paramb = (c)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(c.class);
      localObject = paramBaseFinderFeedLoader.getDataListJustForAdapter();
      locall = getVideoCore();
      paramBaseFinderFeedLoader = as.GSQ;
      paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
      if (paramBaseFinderFeedLoader != null) {
        break label133;
      }
    }
    label133:
    for (paramBaseFinderFeedLoader = null;; paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1))
    {
      paramb.a((DataBuffer)localObject, 0, locall, paramBaseFinderFeedLoader, -1);
      return;
    }
  }
  
  public com.tencent.mm.view.recyclerview.g dUK()
  {
    return (com.tencent.mm.view.recyclerview.g)new a(this);
  }
  
  public final void dUL()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestInit$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
  }
  
  public final void dUM()
  {
    Object localObject = this.ATo;
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((ae.b)localObject).ecd();
    if (localObject != null)
    {
      localBaseFinderFeedLoader = this.ALH;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.register((com.tencent.mm.view.k)localObject);
      }
    }
    localObject = this.ATo;
    s.checkNotNull(localObject);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    s.checkNotNull(localBaseFinderFeedLoader);
    ((b.b)localObject).ae((ArrayList)localBaseFinderFeedLoader.getDataListJustForAdapter());
  }
  
  public final DataBuffer<cc> ebx()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    s.checkNotNull(localBaseFinderFeedLoader);
    return localBaseFinderFeedLoader.getDataListJustForAdapter();
  }
  
  public boolean ecb()
  {
    return false;
  }
  
  public ArrayList<cc> ecc()
  {
    Object localObject = this.ALH;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter()) {
      return (ArrayList)localObject;
    }
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    s.u(paramBaseFinderFeed, "feed");
    Object localObject = this.ALH;
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();
    } while (localObject == null);
    return ((DataBuffer)localObject).indexOf(paramBaseFinderFeed);
  }
  
  public void onDetach()
  {
    Object localObject = this.ATo;
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((ae.b)localObject).ecd();
    if (localObject != null)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.unregister((com.tencent.mm.view.k)localObject);
      }
    }
    super.onDetach();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(ae.a parama) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(165721);
      switch (paramInt)
      {
      default: 
        localObject1 = av.GiL;
        av.eY(this.AWV.getTAG(), paramInt);
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(165721);
        return localObject1;
      case 9: 
        localObject1 = this.AWV.AJn;
        localObject2 = (i)this.AWV;
        boolean bool = this.AWV.ecb();
        int i = this.AWV.hJx;
        Object localObject3 = as.GSQ;
        localObject3 = as.a.hu((Context)this.AWV.lzt);
        if (localObject3 == null) {}
        for (paramInt = 0;; paramInt = ((as)localObject3).AJo)
        {
          localObject1 = (com.tencent.mm.view.recyclerview.f)new r((l)localObject1, (i)localObject2, bool, i, paramInt);
          AppMethodBeat.o(165721);
          return localObject1;
        }
      case 4: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.t(this.AWV.AJn, (i)this.AWV, this.AWV.ecb(), this.AWV.hJx);
        AppMethodBeat.o(165721);
        return localObject1;
      case 2: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new q((i)this.AWV, this.AWV.ecb(), this.AWV.hJx);
        AppMethodBeat.o(165721);
        return localObject1;
      }
      Object localObject1 = (i)this.AWV;
      Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = (com.tencent.mm.view.recyclerview.f)new w((i)localObject1, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.AWV.lzt).q(as.class)).fou(), 0);
      AppMethodBeat.o(165721);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae.a
 * JD-Core Version:    0.7.0.1
 */