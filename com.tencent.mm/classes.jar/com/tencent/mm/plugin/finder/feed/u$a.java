package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ah;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.n;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "index", "", "getDataIndex", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "Ljava/util/ArrayList;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "", "plugin-finder_release"})
public abstract class u$a
  extends a.a
{
  private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
  protected BaseFinderFeedLoader rTS;
  
  public u$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final al Ew(int paramInt)
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader != null) {
      return (al)localBaseFinderFeedLoader.safeGet(paramInt);
    }
    return null;
  }
  
  public void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    this.rTS = paramBaseFinderFeedLoader;
    super.a((a.b)paramb);
  }
  
  public final void cAA()
  {
    Object localObject = this.rTz;
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((u.b)localObject).cBh();
    if (localObject != null)
    {
      localBaseFinderFeedLoader = this.rTS;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.register((d)localObject);
      }
    }
    localObject = this.rTz;
    if (localObject == null) {
      p.gfZ();
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader == null) {
      p.gfZ();
    }
    ((a.b)localObject).U((ArrayList)localBaseFinderFeedLoader.getDataListJustForAdapter());
  }
  
  public final DataBuffer<al> cAB()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader == null) {
      p.gfZ();
    }
    return localBaseFinderFeedLoader.getDataListJustForAdapter();
  }
  
  public c cAE()
  {
    return (c)new a(this);
  }
  
  public ArrayList<al> cBg()
  {
    Object localObject = this.rTS;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null) {
      return (ArrayList)localObject;
    }
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    p.h(paramBaseFinderFeed, "feed");
    Object localObject = this.rTS;
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
    Object localObject = this.rTz;
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((u.b)localObject).cBh();
    if (localObject != null)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.unregister((d)localObject);
      }
    }
    super.onDetach();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final b<?> AL(int paramInt)
    {
      AppMethodBeat.i(165721);
      switch (paramInt)
      {
      default: 
        localb = (b)new k((h)this.rWr, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 4: 
      case 3002: 
        localb = (b)new w(this.rWr.rOe, (h)this.rWr, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 2: 
      case 3001: 
        localb = (b)new k((h)this.rWr, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 7: 
        localb = (b)new u((h)this.rWr, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 8: 
        localb = (b)new n(this.rWr.rOe, (h)this.rWr, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 1: 
        localb = (b)new q((h)this.rWr, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      }
      b localb = (b)new ah();
      AppMethodBeat.o(165721);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.a
 * JD-Core Version:    0.7.0.1
 */