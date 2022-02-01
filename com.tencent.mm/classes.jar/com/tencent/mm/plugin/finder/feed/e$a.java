package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.g;
import com.tencent.mm.plugin.finder.convert.i;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.b;
import d.g.b.k;
import d.v;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "index", "", "getDataIndex", "feed", "getFeedList", "Ljava/util/ArrayList;", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "", "plugin-finder_release"})
public abstract class e$a
  extends a.a
{
  private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
  BaseFinderFeedLoader qvo;
  
  public e$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final BaseFinderFeed CB(int paramInt)
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader != null) {
      return (BaseFinderFeed)localBaseFinderFeedLoader.safeGet(paramInt);
    }
    return null;
  }
  
  public void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, e.b paramb)
  {
    k.h(paramBaseFinderFeedLoader, "model");
    k.h(paramb, "callback");
    this.qvo = paramBaseFinderFeedLoader;
    super.a((a.b)paramb);
  }
  
  public final void clJ()
  {
    Object localObject = this.qtZ;
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((e.b)localObject).cma();
    if (localObject != null)
    {
      localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.register((d)localObject, this.imP);
      }
    }
    localObject = this.qtZ;
    if (localObject == null) {
      k.fvU();
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader == null) {
      k.fvU();
    }
    ((a.b)localObject).N((ArrayList)localBaseFinderFeedLoader.getDataListJustForAdapter());
  }
  
  public com.tencent.mm.view.recyclerview.c clL()
  {
    return (com.tencent.mm.view.recyclerview.c)new a(this);
  }
  
  public ArrayList<BaseFinderFeed> clY()
  {
    Object localObject = this.qvo;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null) {
      return (ArrayList)localObject;
    }
  }
  
  public abstract h clZ();
  
  public final int e(BaseFinderFeed paramBaseFinderFeed)
  {
    k.h(paramBaseFinderFeed, "feed");
    Object localObject = this.qvo;
    if (localObject != null)
    {
      localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();
      if (localObject != null) {
        return ((DataBuffer)localObject).indexOf(paramBaseFinderFeed);
      }
    }
    return -1;
  }
  
  public final DataBuffer<BaseFinderFeed> fSV()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader == null) {
      k.fvU();
    }
    return localBaseFinderFeedLoader.getDataListJustForAdapter();
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public void onDetach()
  {
    Object localObject = this.qtZ;
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((e.b)localObject).cma();
    if (localObject != null)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.unregister((d)localObject, this.imP);
      }
    }
    super.onDetach();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final b<?> zm(int paramInt)
    {
      AppMethodBeat.i(165721);
      switch (paramInt)
      {
      default: 
        localb = (b)new g((c)this.qvp, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 4: 
        localb = (b)new r(this.qvp.qrq, (c)this.qvp, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 2: 
        localb = (b)new g((c)this.qvp, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 7: 
        localb = (b)new o((c)this.qvp, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      case 8: 
        localb = (b)new i(this.qvp.qrq, (c)this.qvp, false, 0, 12);
        AppMethodBeat.o(165721);
        return localb;
      case 1: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.l((c)this.qvp, false, 0, 6);
        AppMethodBeat.o(165721);
        return localb;
      }
      b localb = (b)new am();
      AppMethodBeat.o(165721);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e.a
 * JD-Core Version:    0.7.0.1
 */