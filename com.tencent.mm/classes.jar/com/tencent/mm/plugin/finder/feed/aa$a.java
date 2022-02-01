package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ab;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.bg;
import com.tencent.mm.plugin.finder.convert.cp;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.convert.y;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getDataAt", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "index", "", "getDataIndex", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "Ljava/util/ArrayList;", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "ifSafeMode", "", "initViewCallback", "", "loadInitData", "onAttach", "model", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "plugin-finder_release"})
public abstract class aa$a
  extends b.a
{
  private final String TAG = "Finder.FinderLoaderFeedUIContract.Presenter";
  public BaseFinderFeedLoader xnX;
  
  public aa$a(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final bu Mv(int paramInt)
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null) {
      return (bu)localBaseFinderFeedLoader.safeGet(paramInt);
    }
    return null;
  }
  
  public void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    p.k(paramBaseFinderFeedLoader, "model");
    p.k(paramb, "callback");
    this.xnX = paramBaseFinderFeedLoader;
    super.a((b.b)paramb);
    paramBaseFinderFeedLoader = g.Xox;
    ((com.tencent.mm.plugin.finder.viewmodel.component.s)g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.s.class)).u(paramb.xvJ.getRecyclerView());
  }
  
  public final void dsF()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestInit$default(localBaseFinderFeedLoader, false, 1, null);
    }
  }
  
  public boolean dsZ()
  {
    return false;
  }
  
  public final void dsr()
  {
    Object localObject = this.xvC;
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((aa.b)localObject).dtb();
    if (localObject != null)
    {
      localBaseFinderFeedLoader = this.xnX;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.register((j)localObject);
      }
    }
    localObject = this.xvC;
    if (localObject == null) {
      p.iCn();
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader == null) {
      p.iCn();
    }
    ((b.b)localObject).ab((ArrayList)localBaseFinderFeedLoader.getDataListJustForAdapter());
  }
  
  public final DataBuffer<bu> dss()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader == null) {
      p.iCn();
    }
    return localBaseFinderFeedLoader.getDataListJustForAdapter();
  }
  
  public com.tencent.mm.view.recyclerview.f dsu()
  {
    return (com.tencent.mm.view.recyclerview.f)new a(this);
  }
  
  public ArrayList<bu> dta()
  {
    Object localObject = this.xnX;
    if (localObject != null) {}
    for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null) {
      return (ArrayList)localObject;
    }
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final int m(BaseFinderFeed paramBaseFinderFeed)
  {
    p.k(paramBaseFinderFeed, "feed");
    Object localObject = this.xnX;
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
    Object localObject = this.xvC;
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.ViewCallback");
    }
    localObject = ((aa.b)localObject).dtb();
    if (localObject != null)
    {
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
      if (localBaseFinderFeedLoader != null) {
        localBaseFinderFeedLoader.unregister((j)localObject);
      }
    }
    super.onDetach();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(165721);
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.em(this.xzv.getTAG(), paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(165721);
        return localObject;
      case 3002: 
        localObject = (e)new am(this.xzv.xkW, (i)this.xzv, this.xzv.dsZ(), 0, 8);
        AppMethodBeat.o(165721);
        return localObject;
      case 3001: 
        localObject = (e)new v((i)this.xzv, this.xzv.dsZ(), 0, 4);
        AppMethodBeat.o(165721);
        return localObject;
      case 7: 
        localObject = (e)new ak((i)this.xzv, this.xzv.dsZ(), 0, 4);
        AppMethodBeat.o(165721);
        return localObject;
      case 8: 
        localObject = (e)new ab(this.xzv.xkW, (i)this.xzv, this.xzv.dsZ(), 0, 8);
        AppMethodBeat.o(165721);
        return localObject;
      case 2014: 
        localObject = (e)new cp(this.xzv.xnX);
        AppMethodBeat.o(165721);
        return localObject;
      case 1: 
        localObject = (e)new af((i)this.xzv, this.xzv.dsZ(), 0, 4);
        AppMethodBeat.o(165721);
        return localObject;
      case 2001: 
        localObject = (e)new bg();
        AppMethodBeat.o(165721);
        return localObject;
      case 9: 
        if (this.xzv.dsq())
        {
          localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject = aj.a.fZ((Context)this.xzv.iXq);
          if (localObject != null) {}
          for (paramInt = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).xkX;; paramInt = 0)
          {
            localObject = (e)new com.tencent.mm.plugin.finder.convert.s(this.xzv.xkW, (i)this.xzv, this.xzv.dsZ(), this.xzv.fEH, paramInt);
            AppMethodBeat.o(165721);
            return localObject;
          }
        }
        localObject = (e)new y(this.xzv.xkW, (i)this.xzv, this.xzv.dsZ());
        AppMethodBeat.o(165721);
        return localObject;
      case 4: 
        if (this.xzv.dsq())
        {
          localObject = (e)new u(this.xzv.xkW, (i)this.xzv, this.xzv.dsZ(), this.xzv.fEH);
          AppMethodBeat.o(165721);
          return localObject;
        }
        localObject = (e)new am(this.xzv.xkW, (i)this.xzv, this.xzv.dsZ(), this.xzv.fEH);
        AppMethodBeat.o(165721);
        return localObject;
      case 2: 
        if (this.xzv.dsq())
        {
          localObject = (e)new r((i)this.xzv, this.xzv.dsZ(), this.xzv.fEH);
          AppMethodBeat.o(165721);
          return localObject;
        }
        localObject = (e)new v((i)this.xzv, this.xzv.dsZ(), this.xzv.fEH);
        AppMethodBeat.o(165721);
        return localObject;
      }
      Object localObject = (i)this.xzv;
      g localg = g.Xox;
      localObject = (e)new z((i)localObject, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.xzv.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), 0);
      AppMethodBeat.o(165721);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.a
 * JD-Core Version:    0.7.0.1
 */