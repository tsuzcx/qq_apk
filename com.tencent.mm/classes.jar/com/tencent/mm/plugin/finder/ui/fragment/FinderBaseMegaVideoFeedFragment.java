package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "V", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "getActivity", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "activity$delegate", "Lkotlin/Lazy;", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "", "onBackPressed", "", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateTitle", "count", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderBaseMegaVideoFeedFragment<M extends BaseFeedLoader<cc>, V extends a.b, P extends a.a>
  extends FinderHomeTabFragment
{
  private final j FXy = k.cm((a)new a(this));
  
  public void Og(int paramInt)
  {
    if (((bw)h.ax(bw.class)).aBu()) {
      fcO().setMMSubTitle(fcO().getResources().getString(e.h.finder_teen_mode_sub_tip));
    }
  }
  
  public abstract P eIr();
  
  public abstract V eIs();
  
  public final MMFinderUI fcO()
  {
    return (MMFinderUI)this.FXy.getValue();
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return null;
  }
  
  public abstract void initOnCreate();
  
  public final boolean onBackPressed()
  {
    eIr();
    return a.a.onBackPressed();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    eIr().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    eIr();
  }
  
  public void onResume()
  {
    super.onResume();
    eIr();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    initOnCreate();
    eIr().a(eIs());
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "V", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MMFinderUI>
  {
    a(FinderBaseMegaVideoFeedFragment<M, V, P> paramFinderBaseMegaVideoFeedFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
 * JD-Core Version:    0.7.0.1
 */