package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "getActivity", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "activity$delegate", "Lkotlin/Lazy;", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "", "initOnCreate", "onBackPressed", "", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public abstract class FinderBaseGridFeedFragment<V extends c.b, P extends c.a>
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
  
  public abstract P dcq();
  
  public abstract V ddS();
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return null;
  }
  
  public abstract void initOnCreate();
  
  public final boolean onBackPressed()
  {
    return dcq().onBackPressed();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    dcq().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    dcq();
  }
  
  public void onResume()
  {
    super.onResume();
    dcq();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    p.h(paramView, "view");
    initOnCreate();
    dcq().a(ddS());
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "invoke"})
  static final class a
    extends q
    implements a<MMFinderUI>
  {
    a(FinderBaseGridFeedFragment paramFinderBaseGridFeedFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
 * JD-Core Version:    0.7.0.1
 */