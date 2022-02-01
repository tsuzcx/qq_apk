package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "V", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "getActivity", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "activity$delegate", "Lkotlin/Lazy;", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "", "onBackPressed", "", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public abstract class FinderBaseMegaVideoFeedFragment<M extends BaseFeedLoader<bo>, V extends a.b, P extends a.a>
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  private final f vQp = g.ah((a)new a(this));
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public final MMFinderUI dAq()
  {
    return (MMFinderUI)this.vQp.getValue();
  }
  
  public abstract P dkn();
  
  public abstract V dma();
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return null;
  }
  
  public abstract void initOnCreate();
  
  public final boolean onBackPressed()
  {
    dkn();
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    dkn().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    dkn();
  }
  
  public void onResume()
  {
    super.onResume();
    dkn();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    p.h(paramView, "view");
    initOnCreate();
    dkn().a(dma());
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "V", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "invoke"})
  static final class a
    extends q
    implements a<MMFinderUI>
  {
    a(FinderBaseMegaVideoFeedFragment paramFinderBaseMegaVideoFeedFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
 * JD-Core Version:    0.7.0.1
 */