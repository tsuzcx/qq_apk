package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.f;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.adapter.a.a;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "dynamicPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getDynamicPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "setDynamicPagerAdapter", "(Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;)V", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragments", "", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "isDynamic", "", "lastIndex", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "getTabContainer", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "setTabContainer", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;)V", "tabLayout", "Landroid/support/design/widget/TabLayout;", "getTabLayout", "()Landroid/support/design/widget/TabLayout;", "setTabLayout", "(Landroid/support/design/widget/TabLayout;)V", "tabProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "getTabProvider", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "setTabProvider", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;)V", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "getTabViewAction", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "setTabViewAction", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;)V", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "getTabs", "setTabs", "viewPager", "Landroid/support/v4/view/ViewPager;", "getViewPager", "()Landroid/support/v4/view/ViewPager;", "setViewPager", "(Landroid/support/v4/view/ViewPager;)V", "viewPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "getViewPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "setViewPagerAdapter", "(Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;)V", "addTab", "", "finderTab", "position", "index", "addTabAndFragment", "tab", "fragment", "scrollToAfterAdd", "adjustTabIndicator", "ajustIndicator", "buildTab", "checkFragmentExistByTabType", "tabType", "checkTabLayoutVisibility", "convertIndexToTabType", "ensureTabInjections", "ensureTabUIC", "generateProvider", "getActiveFragment", "getActiveIndex", "getActiveTabType", "getFragment", "getFragmentByTabType", "getIndicatorView", "Landroid/view/ViewGroup;", "getLayoutId", "getTab", "getTabByType", "getTabIndex", "initNormalRefs", "initTabContainer", "initViewPager", "initViewRefs", "injectProvider", "isTabProviderInitialized", "isTabsInitialized", "onActionbarClick", "onActionbarDoubleClick", "onBtnBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "removeTabAndFragment", "selectPos", "removeTabAndFragmentByTabType", "selectTab", "isForceSelect", "setCurrentPage", "setMargins", "tabIndicator", "leftMargin", "rightMargin", "Companion", "plugin-finder_release"})
public abstract class FinderTabUIC
  extends UIComponent
{
  public static final a wAy = new a((byte)0);
  private boolean bex;
  public List<? extends FinderHomeTabFragment> fragments;
  private int lastIndex = -1;
  public com.tencent.mm.plugin.finder.view.tabcomp.g tabContainer;
  public IFinderTabProvider tabProvider;
  public f tabViewAction;
  public List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> tabs;
  protected ViewPager uO;
  TabLayout wAv;
  private com.tencent.mm.plugin.finder.view.adapter.c wAw;
  private com.tencent.mm.plugin.finder.view.adapter.a<FinderHomeTabFragment> wAx;
  final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.h> wxj = new CopyOnWriteArraySet();
  
  public FinderTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.finder.view.tabcomp.a parama, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    p.h(parama, "tab");
    p.h(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (this.bex)
    {
      localObject = this.tabs;
      if (localObject == null) {
        p.btv("tabs");
      }
      if (af.eX(localObject)) {}
    }
    else
    {
      Log.e("Finder.FinderTabUIC", "addTabAndFragment param error");
      return;
    }
    if (paramInt >= 0)
    {
      localObject = this.tabs;
      if (localObject == null) {
        p.btv("tabs");
      }
      if (paramInt <= ((List)localObject).size())
      {
        parama.index = paramInt;
        localObject = this.tabs;
        if (localObject == null) {
          p.btv("tabs");
        }
        if (localObject == null) {
          throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab>");
        }
        af.eY(localObject).add(paramInt, parama);
        localObject = this.wAv;
        if (localObject != null) {
          a((TabLayout)localObject, parama, paramInt);
        }
        parama = this.wAx;
        if (parama != null) {
          parama.a(new a.a(true, paramInt), paramFinderHomeTabFragment);
        }
      }
    }
    dnx();
  }
  
  private static void a(TabLayout paramTabLayout, com.tencent.mm.plugin.finder.view.tabcomp.a parama, int paramInt)
  {
    TabLayout.f localf = paramTabLayout.cW();
    p.g(localf, "tabLayout.newTab()");
    if (parama != null)
    {
      localf.aj(parama.getLayoutId());
      parama.u((ViewGroup)localf.getCustomView());
      parama.pd(false);
    }
    localf.g(parama);
    if (paramInt >= 0)
    {
      paramTabLayout.a(localf, paramInt);
      return;
    }
    paramTabLayout.a(localf);
  }
  
  private final void dIK()
  {
    if (!dIL())
    {
      this.tabProvider = cXB();
      dIO();
    }
  }
  
  private boolean dIL()
  {
    return ((FinderTabUIC)this).tabProvider != null;
  }
  
  private final void dIO()
  {
    if (((FinderTabUIC)this).tabProvider != null)
    {
      IFinderTabProvider localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.btv("tabProvider");
      }
      this.fragments = localIFinderTabProvider.fragments();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.btv("tabProvider");
      }
      this.tabs = localIFinderTabProvider.tabs();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.btv("tabProvider");
      }
      this.tabViewAction = localIFinderTabProvider.tabViewAction();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.btv("tabProvider");
      }
      this.tabContainer = localIFinderTabProvider.tabContainer();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.btv("tabProvider");
      }
      this.bex = localIFinderTabProvider.isDynamic();
    }
  }
  
  private final void dId()
  {
    TabLayout localTabLayout = this.wAv;
    if (localTabLayout != null)
    {
      localTabLayout.a((TabLayout.b)new c(localTabLayout, this));
      Object localObject1 = this.tabs;
      if (localObject1 == null) {
        p.btv("tabs");
      }
      localObject1 = (Iterable)localObject1;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject2 = (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2;
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2).index = i;
        a(localTabLayout, (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2, -1);
        i += 1;
      }
      localTabLayout = this.wAv;
      if (localTabLayout != null)
      {
        Log.i("Finder.FinderTabUIC", "ajustIndicator:" + localTabLayout.getTabCount());
        if (localTabLayout.getTabCount() > 1) {
          localTabLayout.post((Runnable)new b(this));
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.view.tabcomp.a MI(int paramInt)
  {
    com.tencent.mm.plugin.finder.view.tabcomp.a locala = null;
    List localList = this.tabs;
    if (localList == null) {
      p.btv("tabs");
    }
    int i;
    if ((paramInt >= 0) && (paramInt < localList.size()))
    {
      i = 1;
      if (i == 0) {
        break label75;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        localList = this.tabs;
        if (localList == null) {
          p.btv("tabs");
        }
        locala = (com.tencent.mm.plugin.finder.view.tabcomp.a)localList.get(paramInt);
      }
      return locala;
      i = 0;
      break;
      label75:
      localList = null;
    }
  }
  
  public final boolean MJ(int paramInt)
  {
    Object localObject = this.fragments;
    if (localObject == null) {
      p.btv("fragments");
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((FinderHomeTabFragment)((Iterator)localObject).next()).dLS == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public final void aw(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.wAv;
    int i;
    if (localObject != null)
    {
      if ((paramInt < 0) || (paramInt >= ((TabLayout)localObject).getTabCount())) {
        break label81;
      }
      i = 1;
      if (i == 0) {
        break label86;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((TabLayout)localObject).ab(paramInt);
        if ((localObject != null) && ((paramBoolean) || (!((TabLayout.f)localObject).isSelected())))
        {
          Log.i("Finder.FinderTabUIC", "select :".concat(String.valueOf(paramInt)));
          ((TabLayout.f)localObject).select();
        }
      }
      return;
      label81:
      i = 0;
      break;
      label86:
      localObject = null;
    }
  }
  
  public abstract IFinderTabProvider cXB();
  
  public final int dIM()
  {
    ViewPager localViewPager = this.uO;
    if (localViewPager != null) {
      return localViewPager.getCurrentItem();
    }
    return this.lastIndex;
  }
  
  public final void dIN()
  {
    List localList = this.tabs;
    if (localList == null) {
      p.btv("tabs");
    }
    gx(localList.size() - 1, -1);
  }
  
  public void dIp() {}
  
  public void dnx()
  {
    Object localObject = this.tabs;
    if (localObject == null) {
      p.btv("tabs");
    }
    if (((List)localObject).size() <= 1)
    {
      localObject = this.tabContainer;
      if (localObject == null) {
        p.btv("tabContainer");
      }
      localObject = ((com.tencent.mm.plugin.finder.view.tabcomp.g)localObject).dHK();
      if (localObject != null) {
        ((HardTouchableLayout)localObject).setVisibility(8);
      }
    }
    do
    {
      return;
      localObject = this.tabContainer;
      if (localObject == null) {
        p.btv("tabContainer");
      }
      localObject = ((com.tencent.mm.plugin.finder.view.tabcomp.g)localObject).dHK();
    } while (localObject == null);
    ((HardTouchableLayout)localObject).setVisibility(0);
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    Object localObject = this.uO;
    if (localObject != null) {}
    for (int i = ((ViewPager)localObject).getCurrentItem();; i = this.lastIndex)
    {
      int j;
      if (i >= 0)
      {
        localObject = this.fragments;
        if (localObject == null) {
          p.btv("fragments");
        }
        j = i;
        if (i < ((List)localObject).size()) {}
      }
      else
      {
        j = 0;
      }
      localObject = this.fragments;
      if (localObject == null) {
        p.btv("fragments");
      }
      return (FinderHomeTabFragment)((List)localObject).get(j);
    }
  }
  
  public final List<FinderHomeTabFragment> getFragments()
  {
    List localList = this.fragments;
    if (localList == null) {
      p.btv("fragments");
    }
    return localList;
  }
  
  public int getLayoutId()
  {
    dIK();
    com.tencent.mm.plugin.finder.view.tabcomp.g localg = this.tabContainer;
    if (localg == null) {
      p.btv("tabContainer");
    }
    return localg.getLayoutId();
  }
  
  public final com.tencent.mm.plugin.finder.view.tabcomp.g getTabContainer()
  {
    com.tencent.mm.plugin.finder.view.tabcomp.g localg = this.tabContainer;
    if (localg == null) {
      p.btv("tabContainer");
    }
    return localg;
  }
  
  public final f getTabViewAction()
  {
    f localf = this.tabViewAction;
    if (localf == null) {
      p.btv("tabViewAction");
    }
    return localf;
  }
  
  public final void gw(int paramInt1, int paramInt2)
  {
    Object localObject = this.fragments;
    if (localObject == null) {
      p.btv("fragments");
    }
    localObject = ((List)localObject).iterator();
    int i = -1;
    if (((Iterator)localObject).hasNext())
    {
      FinderHomeTabFragment localFinderHomeTabFragment = (FinderHomeTabFragment)((Iterator)localObject).next();
      if (localFinderHomeTabFragment.dLS != paramInt1) {
        break label104;
      }
      List localList = this.fragments;
      if (localList == null) {
        p.btv("fragments");
      }
      i = localList.indexOf(localFinderHomeTabFragment);
    }
    label104:
    for (;;)
    {
      break;
      if (i >= 0) {
        gx(i, paramInt2);
      }
      dnx();
      return;
    }
  }
  
  public final void gx(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.bex)
    {
      localObject = this.tabs;
      if (localObject == null) {
        p.btv("tabs");
      }
      if (af.eX(localObject)) {}
    }
    else
    {
      Log.e("Finder.FinderTabUIC", "removeTabAndFragment param error");
      return;
    }
    if ((this.bex) && (paramInt1 >= 0))
    {
      localObject = this.tabs;
      if (localObject == null) {
        p.btv("tabs");
      }
      if (paramInt1 < ((List)localObject).size())
      {
        localObject = this.tabs;
        if (localObject == null) {
          p.btv("tabs");
        }
        if (localObject == null) {
          throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab>");
        }
        af.eY(localObject).remove(paramInt1);
        localObject = this.wAv;
        if (localObject != null) {
          ((TabLayout)localObject).removeTabAt(paramInt1);
        }
        localObject = this.wAx;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.view.adapter.a)localObject).a(new a.a(false, paramInt1), null);
        }
        if (paramInt2 < 0) {
          break label187;
        }
        localObject = this.tabs;
        if (localObject == null) {
          p.btv("tabs");
        }
        if (paramInt2 >= ((List)localObject).size()) {
          break label187;
        }
      }
    }
    for (;;)
    {
      aw(paramInt2, false);
      dnx();
      return;
      label187:
      if (paramInt1 - 1 < 0) {
        paramInt2 = 0;
      } else {
        paramInt2 = paramInt1 - 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    dIK();
    super.onCreate(paramBundle);
    paramBundle = this.fragments;
    if (paramBundle == null) {
      p.btv("fragments");
    }
    int i = paramBundle.size();
    paramBundle = this.tabs;
    if (paramBundle == null) {
      p.btv("tabs");
    }
    if (i != paramBundle.size())
    {
      Log.e("Finder.FinderTabUIC", "fragments size must not be equal to tabs");
      throw ((Throwable)new IllegalArgumentException("FinderTabUIC: fragments size must not be equal to tabs"));
    }
    paramBundle = this.tabContainer;
    if (paramBundle == null) {
      p.btv("tabContainer");
    }
    Object localObject1 = getActivity().getWindow();
    p.g(localObject1, "activity.window");
    paramBundle.c((Window)localObject1);
    if (((FinderTabUIC)this).tabProvider != null)
    {
      paramBundle = this.tabContainer;
      if (paramBundle == null) {
        p.btv("tabContainer");
      }
      this.wAv = paramBundle.dHJ();
      paramBundle = this.tabContainer;
      if (paramBundle == null) {
        p.btv("tabContainer");
      }
      this.uO = paramBundle.dHL();
    }
    paramBundle = getActivity();
    if (paramBundle == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
    }
    ((MMActivity)paramBundle).setTitleBarClickListener((Runnable)new f(this), (Runnable)new g(this));
    paramBundle = this.tabContainer;
    if (paramBundle == null) {
      p.btv("tabContainer");
    }
    paramBundle = paramBundle.getBackBtn();
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
    }
    paramBundle = getActivity();
    if (paramBundle == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
    }
    paramBundle = (MMActivity)paramBundle;
    localObject1 = this.fragments;
    if (localObject1 == null) {
      p.btv("fragments");
    }
    localObject1 = (FinderFragmentChangeObserver)new e(this, paramBundle, (List)localObject1);
    paramBundle = this.uO;
    Object localObject2;
    List localList;
    if (paramBundle != null)
    {
      if (!this.bex) {
        break label541;
      }
      localObject2 = getActivity().getSupportFragmentManager();
      p.g(localObject2, "activity.supportFragmentManager");
      localList = this.fragments;
      if (localList == null) {
        p.btv("fragments");
      }
      if (localList == null) {
        throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment>");
      }
      this.wAx = new com.tencent.mm.plugin.finder.view.adapter.a(paramBundle, (android.support.v4.app.g)localObject2, af.eY(localList));
      paramBundle.setAdapter((q)this.wAx);
      localObject2 = this.tabs;
      if (localObject2 == null) {
        p.btv("tabs");
      }
      paramBundle.setOffscreenPageLimit(kotlin.k.j.na(((List)localObject2).size() + 3, 5));
    }
    for (;;)
    {
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      i = ((Number)com.tencent.mm.plugin.finder.storage.c.dtL().value()).intValue();
      if (i > 0)
      {
        localObject1 = an.waE;
        an.a(paramBundle.getContext(), paramBundle, i);
      }
      dId();
      paramBundle = this.tabContainer;
      if (paramBundle == null) {
        p.btv("tabContainer");
      }
      paramBundle = paramBundle.dHK();
      if (paramBundle != null) {
        paramBundle.setOnDoubleClickListener((HardTouchableLayout.b)new d(this));
      }
      aw(0, false);
      return;
      label541:
      localObject2 = getActivity().getSupportFragmentManager();
      p.g(localObject2, "activity.supportFragmentManager");
      localList = this.fragments;
      if (localList == null) {
        p.btv("fragments");
      }
      this.wAw = new com.tencent.mm.plugin.finder.view.adapter.c((android.support.v4.app.g)localObject2, localList);
      paramBundle.setAdapter((q)this.wAw);
      localObject2 = this.tabs;
      if (localObject2 == null) {
        p.btv("tabs");
      }
      paramBundle.setOffscreenPageLimit(((List)localObject2).size() + 1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("Finder.FinderTabUIC", "onDestroy");
    com.tencent.mm.plugin.finder.view.adapter.a locala = this.wAx;
    if (locala != null)
    {
      Log.i("Finder.DynamicAdapter", "removePendingActions");
      if (locala.wrc != null) {
        locala.uO.removeCallbacks(locala.wrc);
      }
      locala.wra.clear();
      locala.wrb.clear();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$Companion;", "", "()V", "MAX_OFFSCREEN_PAGE_LIMIT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$ajustIndicator$1$1"})
  static final class b
    implements Runnable
  {
    b(FinderTabUIC paramFinderTabUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255971);
      FinderTabUIC.d(this.wAz);
      AppMethodBeat.o(255971);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$buildTab$1$1", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "tab", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    c(TabLayout paramTabLayout, FinderTabUIC paramFinderTabUIC) {}
    
    public final void i(TabLayout.f paramf)
    {
      AppMethodBeat.i(255973);
      if (paramf != null)
      {
        Object localObject1 = jdField_this.getTabViewAction();
        Object localObject2 = this.wAA.getContext();
        p.g(localObject2, "context");
        Object localObject3 = paramf.getTag();
        if (localObject3 == null)
        {
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(255973);
          throw paramf;
        }
        ((f)localObject1).a((Context)localObject2, (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject3);
        localObject1 = paramf.getTag();
        if (localObject1 == null)
        {
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(255973);
          throw paramf;
        }
        localObject1 = (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1;
        localObject2 = paramf.getCustomView();
        if (localObject2 == null)
        {
          paramf = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(255973);
          throw paramf;
        }
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1).a(true, (ViewGroup)localObject2);
        localObject1 = jdField_this;
        paramf = paramf.getTag();
        if (paramf == null)
        {
          paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(255973);
          throw paramf;
        }
        int j = FinderTabUIC.a((FinderTabUIC)localObject1, (com.tencent.mm.plugin.finder.view.tabcomp.a)paramf);
        Log.i("Finder.FinderTabUIC", "setCurrentPage:".concat(String.valueOf(j)));
        int i = j;
        if (j == -1) {
          i = 0;
        }
        FinderTabUIC.d(jdField_this, i);
        AppMethodBeat.o(255973);
        return;
      }
      AppMethodBeat.o(255973);
    }
    
    public final void j(TabLayout.f paramf)
    {
      AppMethodBeat.i(255972);
      if (paramf != null)
      {
        if ((paramf.getTag() instanceof com.tencent.mm.plugin.finder.view.tabcomp.a))
        {
          Object localObject1 = jdField_this.getTabViewAction();
          Context localContext = this.wAA.getContext();
          p.g(localContext, "context");
          Object localObject2 = paramf.getTag();
          if (localObject2 == null)
          {
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(255972);
            throw paramf;
          }
          ((f)localObject1).b(localContext, (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2);
          localObject1 = paramf.getTag();
          if (localObject1 == null)
          {
            paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(255972);
            throw paramf;
          }
          localObject1 = (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1;
          paramf = paramf.getCustomView();
          if (paramf == null)
          {
            paramf = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(255972);
            throw paramf;
          }
          ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1).a(false, (ViewGroup)paramf);
        }
        AppMethodBeat.o(255972);
        return;
      }
      AppMethodBeat.o(255972);
    }
    
    public final void k(TabLayout.f paramf) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$initTabContainer$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class d
    implements HardTouchableLayout.b
  {
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(255975);
      p.h(paramView, "view");
      p.h(paramMotionEvent, "e");
      Log.i("Finder.FinderTabUIC", "onDoubleClick");
      com.tencent.f.h.RTc.aV((Runnable)new a(this));
      paramView = this.wAz;
      paramMotionEvent = this.wAz.wAv;
      if (paramMotionEvent != null) {}
      for (int i = paramMotionEvent.getSelectedTabPosition();; i = FinderTabUIC.c(this.wAz))
      {
        paramView = paramView.MI(i);
        if (paramView == null) {
          break;
        }
        this.wAz.getTabViewAction().d((Context)this.wAz.getActivity(), paramView);
        AppMethodBeat.o(255975);
        return;
      }
      AppMethodBeat.o(255975);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderTabUIC.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(255974);
        this.wAB.wAz.getActiveFragment().dlm();
        AppMethodBeat.o(255974);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$initViewPager$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class e
    extends FinderFragmentChangeObserver
  {
    e(MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(255977);
      Log.i("Finder.FragmentChangeObserver", "to :" + paramInt2 + " lastIndex:" + FinderTabUIC.c(this.wAz));
      FinderTabUIC.e(this.wAz, paramInt2);
      FinderTabUIC.a(this.wAz, paramInt2);
      Iterator localIterator = ((Iterable)this.wAz.wxj).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)localIterator.next()).D(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(255977);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(255976);
      p.h(paramFinderHomeTabFragment, "fragment");
      Iterator localIterator = ((Iterable)this.wAz.wxj).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.h)localIterator.next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      AppMethodBeat.o(255976);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderTabUIC paramFinderTabUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255978);
      FinderTabUIC.a(this.wAz);
      AppMethodBeat.o(255978);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTabUIC paramFinderTabUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255979);
      FinderTabUIC.b(this.wAz);
      AppMethodBeat.o(255979);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderTabUIC paramFinderTabUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255980);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wAz.dIp();
      if (!this.wAz.getActivity().isFinishing()) {
        this.wAz.getActivity().finish();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
 * JD-Core Version:    0.7.0.1
 */