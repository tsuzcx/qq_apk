package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.convert.p;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "index", "", "getDataIndex", "feed", "getFeedList", "Ljava/util/ArrayList;", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "", "plugin-finder_release"})
public abstract class r$a
  extends b.a
{
  private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
  BaseFinderFeedLoader rgh;
  
  public r$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final BaseFinderFeed DD(int paramInt)
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null) {
      return (BaseFinderFeed)localBaseFinderFeedLoader.safeGet(paramInt);
    }
    return null;
  }
  
  public void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, r.b paramb)
  {
    k.h(paramBaseFinderFeedLoader, "model");
    k.h(paramb, "callback");
    this.rgh = paramBaseFinderFeedLoader;
    super.a((b.b)paramb);
  }
  
  public ArrayList<BaseFinderFeed> cuP()
  {
    Object localObject = this.rgh;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null) {
      return (ArrayList)localObject;
    }
  }
  
  public abstract com.tencent.mm.plugin.finder.feed.model.internal.g cup();
  
  public final void cur()
  {
    Object localObject = this.rfN;
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((r.b)localObject).cuQ();
    if (localObject != null)
    {
      localBaseFinderFeedLoader = this.rgh;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.register((d)localObject, this.iMV);
      }
    }
    localObject = this.rfN;
    if (localObject == null) {
      k.fOy();
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader == null) {
      k.fOy();
    }
    ((b.b)localObject).U((ArrayList)localBaseFinderFeedLoader.getDataListJustForAdapter());
  }
  
  public final DataBuffer<BaseFinderFeed> cus()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader == null) {
      k.fOy();
    }
    return localBaseFinderFeedLoader.getDataListJustForAdapter();
  }
  
  public c cut()
  {
    return (c)new a(this);
  }
  
  public final int f(BaseFinderFeed paramBaseFinderFeed)
  {
    k.h(paramBaseFinderFeed, "feed");
    Object localObject = this.rgh;
    if (localObject != null)
    {
      localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();
      if (localObject != null) {
        return ((DataBuffer)localObject).indexOf(paramBaseFinderFeed);
      }
    }
    return -1;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public void onDetach()
  {
    Object localObject = this.rfN;
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((r.b)localObject).cuQ();
    if (localObject != null)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.unregister((d)localObject, this.iMV);
      }
    }
    super.onDetach();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements c
  {
    public final b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(165721);
      switch (paramInt)
      {
      default: 
        localb = (b)new j((g)this.ril, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 4: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.v(this.ril.rbo, (g)this.ril, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 2: 
        localb = (b)new j((g)this.ril, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 7: 
        localb = (b)new t((g)this.ril, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 8: 
        localb = (b)new m(this.ril.rbo, (g)this.ril, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 1: 
        localb = (b)new p((g)this.ril, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      }
      b localb = (b)new af();
      AppMethodBeat.o(165721);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r.a
 * JD-Core Version:    0.7.0.1
 */