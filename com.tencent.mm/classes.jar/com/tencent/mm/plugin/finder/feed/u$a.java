package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "index", "", "getDataIndex", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "Ljava/util/ArrayList;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "", "plugin-finder_release"})
public abstract class u$a
  extends a.a
{
  private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
  protected BaseFinderFeedLoader scw;
  
  public u$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final am EJ(int paramInt)
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader != null) {
      return (am)localBaseFinderFeedLoader.safeGet(paramInt);
    }
    return null;
  }
  
  public void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    this.scw = paramBaseFinderFeedLoader;
    super.a((a.b)paramb);
  }
  
  public ArrayList<am> cCS()
  {
    Object localObject = this.scw;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null) {
      return (ArrayList)localObject;
    }
  }
  
  public final void cCm()
  {
    Object localObject = this.scd;
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((u.b)localObject).cCT();
    if (localObject != null)
    {
      localBaseFinderFeedLoader = this.scw;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.register((d)localObject);
      }
    }
    localObject = this.scd;
    if (localObject == null) {
      p.gkB();
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader == null) {
      p.gkB();
    }
    ((a.b)localObject).U((ArrayList)localBaseFinderFeedLoader.getDataListJustForAdapter());
  }
  
  public final DataBuffer<am> cCn()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader == null) {
      p.gkB();
    }
    return localBaseFinderFeedLoader.getDataListJustForAdapter();
  }
  
  public c cCq()
  {
    return (c)new a(this);
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    p.h(paramBaseFinderFeed, "feed");
    Object localObject = this.scw;
    if (localObject != null)
    {
      localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();
      if (localObject != null) {
        return ((DataBuffer)localObject).indexOf(paramBaseFinderFeed);
      }
    }
    return -1;
  }
  
  public void onDetach()
  {
    Object localObject = this.scd;
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((u.b)localObject).cCT();
    if (localObject != null)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.unregister((d)localObject);
      }
    }
    super.onDetach();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final b<?> AX(int paramInt)
    {
      AppMethodBeat.i(165721);
      switch (paramInt)
      {
      default: 
        localb = (b)new k((h)this.sfc, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 4: 
      case 3002: 
        localb = (b)new w(this.sfc.rWB, (h)this.sfc, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 2: 
      case 3001: 
        localb = (b)new k((h)this.sfc, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 7: 
        localb = (b)new u((h)this.sfc, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 8: 
        localb = (b)new n(this.sfc.rWB, (h)this.sfc, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 1: 
        localb = (b)new q((h)this.sfc, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      }
      b localb = (b)new ai();
      AppMethodBeat.o(165721);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.a
 * JD-Core Version:    0.7.0.1
 */