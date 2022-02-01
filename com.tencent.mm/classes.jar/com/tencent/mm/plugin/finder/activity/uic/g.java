package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.view.tabcomp.FinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.a;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.view.tabcomp.d;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCoveredStyle", "setNormalStyle", "setTabViews", "isCovered", "", "Provider", "Tab", "TabContainer", "plugin-finder_release"})
public final class g
  extends FinderTabUIC
{
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(237598);
    AppMethodBeat.o(237598);
  }
  
  private final void oc(boolean paramBoolean)
  {
    AppMethodBeat.i(237595);
    int j = elu();
    Iterator localIterator = ((Iterable)getTabs()).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (a)localIterator.next();
      if ((localObject instanceof b))
      {
        if (!paramBoolean) {
          break label95;
        }
        localObject = (b)localObject;
        if (i != j) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        ((b)localObject).oe(bool);
        i += 1;
        break;
      }
      label95:
      localObject = (b)localObject;
      if (i == j) {}
      for (bool = true;; bool = false)
      {
        ((b)localObject).of(bool);
        break;
      }
    }
    AppMethodBeat.o(237595);
  }
  
  public final IFinderTabProvider dmS()
  {
    AppMethodBeat.i(237582);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new a();
    AppMethodBeat.o(237582);
    return localIFinderTabProvider;
  }
  
  public final void dmT()
  {
    AppMethodBeat.i(237589);
    TabLayout localTabLayout = this.BoG;
    if (localTabLayout != null) {
      localTabLayout.setSelectedTabIndicatorColor(getResources().getColor(b.c.finder_activity_covered_white));
    }
    oc(true);
    AppMethodBeat.o(237589);
  }
  
  public final void dmy()
  {
    AppMethodBeat.i(237592);
    TabLayout localTabLayout = this.BoG;
    if (localTabLayout != null) {
      localTabLayout.setSelectedTabIndicatorColor(getResources().getColor(b.c.FG_0));
    }
    oc(false);
    AppMethodBeat.o(237592);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(237586);
    super.onCreate(paramBundle);
    paramBundle = ejW();
    if ((paramBundle instanceof FinderViewPager)) {
      ((FinderViewPager)paramBundle).setEnableViewPagerScroll(true);
    }
    AppMethodBeat.o(237586);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Provider;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabProvider;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC;)V", "plugin-finder_release"})
  public final class a
    extends FinderTabProvider
  {
    public a()
    {
      AppMethodBeat.i(270664);
      setTabContainer((com.tencent.mm.plugin.finder.view.tabcomp.g)new g.c());
      setTabViewAction((f)new e());
      this$1 = new LinkedList();
      this$1.add(new g.b(b.j.finder_activity_hotest));
      this$1.add(new g.b(b.j.finder_activity_newest));
      setTabs((List)this$1);
      this$1 = new LinkedList();
      FinderActivityFragment localFinderActivityFragment = new FinderActivityFragment();
      localFinderActivityFragment.fEH = 0;
      this$1.add(localFinderActivityFragment);
      localFinderActivityFragment = new FinderActivityFragment();
      localFinderActivityFragment.fEH = 1;
      this$1.add(localFinderActivityFragment);
      setFragments((List)this$1);
      AppMethodBeat.o(270664);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$Tab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "isCovered", "", "getLayoutId", "getTabMargin", "", "setCoveredStyle", "", "isSelected", "setNormalStyle", "setTextColor", "isTabSelected", "plugin-finder_release"})
  public static final class b
    extends c
  {
    private boolean wZb;
    
    public b(int paramInt)
    {
      super();
    }
    
    public final int[] dmU()
    {
      return new int[] { 0, 6 };
    }
    
    public final int getLayoutId()
    {
      return b.g.finder_profile_normal_tab_text;
    }
    
    public final void od(boolean paramBoolean)
    {
      AppMethodBeat.i(275939);
      TextView localTextView = getTitleTv();
      if (localTextView != null)
      {
        if (this.wZb)
        {
          if (paramBoolean)
          {
            localContext = localTextView.getContext();
            p.j(localContext, "context");
            localTextView.setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_9));
            AppMethodBeat.o(275939);
            return;
          }
          localContext = localTextView.getContext();
          p.j(localContext, "context");
          localTextView.setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_5));
          AppMethodBeat.o(275939);
          return;
        }
        if (paramBoolean)
        {
          localContext = localTextView.getContext();
          p.j(localContext, "context");
          localTextView.setTextColor(localContext.getResources().getColor(b.c.FG_0));
          AppMethodBeat.o(275939);
          return;
        }
        Context localContext = localTextView.getContext();
        p.j(localContext, "context");
        localTextView.setTextColor(localContext.getResources().getColor(b.c.FG_1));
        AppMethodBeat.o(275939);
        return;
      }
      AppMethodBeat.o(275939);
    }
    
    public final void oe(boolean paramBoolean)
    {
      AppMethodBeat.i(275940);
      this.wZb = true;
      od(paramBoolean);
      AppMethodBeat.o(275940);
    }
    
    public final void of(boolean paramBoolean)
    {
      AppMethodBeat.i(275941);
      this.wZb = false;
      od(paramBoolean);
      AppMethodBeat.o(275941);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityTabUIC$TabContainer;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabContainer;", "()V", "getLayoutId", "", "plugin-finder_release"})
  public static final class c
    extends d
  {
    public final int getLayoutId()
    {
      return b.g.finder_activity_profile_ui;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.g
 * JD-Core Version:    0.7.0.1
 */