package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.aa;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.be;
import com.tencent.mm.plugin.finder.convert.ci;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.x;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "index", "", "getDataIndex", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "Ljava/util/ArrayList;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "ifSafeMode", "", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "plugin-finder_release"})
public abstract class v$a
  extends b.a
{
  private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
  public BaseFinderFeedLoader tFM;
  
  public v$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final bo IE(int paramInt)
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null) {
      return (bo)localBaseFinderFeedLoader.safeGet(paramInt);
    }
    return null;
  }
  
  public void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
  {
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    this.tFM = paramBaseFinderFeedLoader;
    super.a((b.b)paramb);
    paramBaseFinderFeedLoader = a.PRN;
    ((FinderFeedMegaVideoBtnAnimUIC)a.b((AppCompatActivity)this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(paramb.tLS.getRecyclerView());
  }
  
  public boolean dcG()
  {
    return false;
  }
  
  public ArrayList<bo> dcH()
  {
    Object localObject = this.tFM;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null) {
      return (ArrayList)localObject;
    }
  }
  
  public final void dcb()
  {
    Object localObject = this.tLN;
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((v.b)localObject).dcI();
    if (localObject != null)
    {
      localBaseFinderFeedLoader = this.tFM;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.register((j)localObject);
      }
    }
    localObject = this.tLN;
    if (localObject == null) {
      p.hyc();
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader == null) {
      p.hyc();
    }
    ((b.b)localObject).ab((ArrayList)localBaseFinderFeedLoader.getDataListJustForAdapter());
  }
  
  public final DataBuffer<bo> dcc()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader == null) {
      p.hyc();
    }
    return localBaseFinderFeedLoader.getDataListJustForAdapter();
  }
  
  public com.tencent.mm.view.recyclerview.f dce()
  {
    return (com.tencent.mm.view.recyclerview.f)new a(this);
  }
  
  public final void dcp()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestInit$default(localBaseFinderFeedLoader, false, 1, null);
    }
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final int l(BaseFinderFeed paramBaseFinderFeed)
  {
    p.h(paramBaseFinderFeed, "feed");
    Object localObject = this.tFM;
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
    Object localObject = this.tLN;
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((v.b)localObject).dcI();
    if (localObject != null)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.unregister((j)localObject);
      }
    }
    super.onDetach();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(165721);
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.plugin.finder.utils.y.vXH;
        com.tencent.mm.plugin.finder.utils.y.dQ(this.tOJ.getTAG(), paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(165721);
        return localObject;
      case 3002: 
        localObject = (e)new ak(this.tOJ.tCD, (i)this.tOJ, this.tOJ.dcG(), 0, 8);
        AppMethodBeat.o(165721);
        return localObject;
      case 3001: 
        localObject = (e)new u((i)this.tOJ, this.tOJ.dcG(), 0, 4);
        AppMethodBeat.o(165721);
        return localObject;
      case 7: 
        localObject = (e)new ai((i)this.tOJ, this.tOJ.dcG(), 0, 4);
        AppMethodBeat.o(165721);
        return localObject;
      case 8: 
        localObject = (e)new aa(this.tOJ.tCD, (i)this.tOJ, this.tOJ.dcG(), 0, 8);
        AppMethodBeat.o(165721);
        return localObject;
      case 2014: 
        localObject = (e)new ci(this.tOJ.tFM);
        AppMethodBeat.o(165721);
        return localObject;
      case 1: 
        localObject = (e)new ad((i)this.tOJ, this.tOJ.dcG(), 0, 4);
        AppMethodBeat.o(165721);
        return localObject;
      case 2001: 
        localObject = (e)new be();
        AppMethodBeat.o(165721);
        return localObject;
      case 9: 
        if (this.tOJ.dca())
        {
          localObject = FinderReporterUIC.wzC;
          localObject = FinderReporterUIC.a.fH((Context)this.tOJ.gte);
          if (localObject != null) {}
          for (paramInt = ((FinderReporterUIC)localObject).tCE;; paramInt = 0)
          {
            localObject = (e)new r(this.tOJ.tCD, (i)this.tOJ, this.tOJ.dcG(), this.tOJ.dLS, paramInt);
            AppMethodBeat.o(165721);
            return localObject;
          }
        }
        localObject = (e)new x(this.tOJ.tCD, (i)this.tOJ, this.tOJ.dcG());
        AppMethodBeat.o(165721);
        return localObject;
      case 4: 
        if (this.tOJ.dca())
        {
          localObject = (e)new com.tencent.mm.plugin.finder.convert.t(this.tOJ.tCD, (i)this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
          AppMethodBeat.o(165721);
          return localObject;
        }
        localObject = (e)new ak(this.tOJ.tCD, (i)this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
        AppMethodBeat.o(165721);
        return localObject;
      case 2: 
        if (this.tOJ.dca())
        {
          localObject = (e)new q((i)this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
          AppMethodBeat.o(165721);
          return localObject;
        }
        localObject = (e)new u((i)this.tOJ, this.tOJ.dcG(), this.tOJ.dLS);
        AppMethodBeat.o(165721);
        return localObject;
      }
      Object localObject = a.PRN;
      localObject = (e)new com.tencent.mm.plugin.finder.convert.y(((FinderReporterUIC)a.b((AppCompatActivity)this.tOJ.gte).get(FinderReporterUIC.class)).dIx(), 0);
      AppMethodBeat.o(165721);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v.a
 * JD-Core Version:    0.7.0.1
 */