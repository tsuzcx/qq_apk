package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "activity$delegate", "Lkotlin/Lazy;", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "", "initOnCreate", "onBackPressed", "", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateTitle", "count", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderBaseGridFeedFragment<V extends c.b, P extends c.a>
  extends FinderHomeTabFragment
{
  private final j FXy = k.cm((a)new a(this));
  
  public void Og(int paramInt)
  {
    if (((bw)h.ax(bw.class)).aBu()) {
      getActivity().setMMSubTitle(getActivity().getResources().getString(e.h.finder_teen_mode_sub_tip));
    }
  }
  
  public abstract P dVa();
  
  public abstract V dVb();
  
  public final MMActivity getActivity()
  {
    return (MMActivity)this.FXy.getValue();
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return null;
  }
  
  public abstract void initOnCreate();
  
  public final boolean onBackPressed()
  {
    return dVa().onBackPressed();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    dVa().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    dVa().onUIPause();
  }
  
  public void onResume()
  {
    super.onResume();
    dVa().onUIResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    initOnCreate();
    dVa().a(dVb());
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/MMActivity;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MMActivity>
  {
    a(FinderBaseGridFeedFragment<V, P> paramFinderBaseGridFeedFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
 * JD-Core Version:    0.7.0.1
 */