package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.e;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.ay;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.adapter.a.a;
import com.tencent.mm.plugin.finder.view.adapter.c;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.f;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "dynamicPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getDynamicPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "setDynamicPagerAdapter", "(Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;)V", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragments", "", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "isDynamic", "", "lastIndex", "", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "getTabContainer", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "setTabContainer", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "tabProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "getTabProvider", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "setTabProvider", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;)V", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "getTabViewAction", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "setTabViewAction", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;)V", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "getTabs", "setTabs", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "viewPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "getViewPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "setViewPagerAdapter", "(Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;)V", "addTab", "", "finderTab", "position", "index", "addTabAndFragment", "tab", "fragment", "scrollToAfterAdd", "adjustTabIndicator", "ajustIndicator", "buildTab", "checkFragmentExistByTabType", "tabType", "checkTabLayoutVisibility", "convertIndexToTabType", "ensureTabInjections", "ensureTabUIC", "generateProvider", "getActiveFragment", "getActiveIndex", "getActiveTabType", "getFragment", "getFragmentByTabType", "getIndicatorView", "Landroid/view/ViewGroup;", "getLayoutId", "getTab", "getTabByType", "getTabIndex", "initNormalRefs", "initTabContainer", "initViewPager", "initViewRefs", "injectProvider", "isTabProviderInitialized", "isTabsInitialized", "onActionbarClick", "onActionbarDoubleClick", "onBtnBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "removeTabAndFragment", "selectPos", "removeTabAndFragmentByTabType", "selectTab", "isForceSelect", "setCurrentPage", "setMargins", "tabIndicator", "leftMargin", "rightMargin", "Companion", "plugin-finder_release"})
public abstract class FinderTabUIC
  extends UIComponent
{
  public static final a BoI = new a((byte)0);
  final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.i> Bls = new CopyOnWriteArraySet();
  protected TabLayout BoG;
  private com.tencent.mm.plugin.finder.view.adapter.a<FinderHomeTabFragment> BoH;
  private boolean aNY;
  private ViewPager bFl;
  public List<? extends FinderHomeTabFragment> fragments;
  private int lastIndex = -1;
  public g tabContainer;
  public IFinderTabProvider tabProvider;
  public f tabViewAction;
  public List<? extends com.tencent.mm.plugin.finder.view.tabcomp.a> tabs;
  private c xTE;
  
  public FinderTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.finder.view.tabcomp.a parama, FinderHomeTabFragment paramFinderHomeTabFragment, boolean paramBoolean)
  {
    p.k(parama, "tab");
    p.k(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (this.aNY)
    {
      localObject = this.tabs;
      if (localObject == null) {
        p.bGy("tabs");
      }
      if (ag.fe(localObject)) {}
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
        p.bGy("tabs");
      }
      if (paramInt <= ((List)localObject).size())
      {
        int i = elu();
        parama.index = paramInt;
        localObject = this.tabs;
        if (localObject == null) {
          p.bGy("tabs");
        }
        if (localObject == null) {
          throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab>");
        }
        ag.ff(localObject).add(paramInt, parama);
        localObject = this.BoG;
        if (localObject != null) {
          a((TabLayout)localObject, parama, paramInt);
        }
        parama = this.BoH;
        if (parama != null) {
          parama.a(new a.a(true, paramInt), paramFinderHomeTabFragment);
        }
        if (i >= paramInt) {
          aA(i + 1, true);
        }
      }
    }
    dOQ();
  }
  
  private static void a(TabLayout paramTabLayout, com.tencent.mm.plugin.finder.view.tabcomp.a parama, int paramInt)
  {
    TabLayout.e locale = paramTabLayout.xz();
    p.j(locale, "tabLayout.newTab()");
    if (parama != null)
    {
      locale.gk(parama.getLayoutId());
      parama.z((ViewGroup)locale.getCustomView());
      parama.rx(false);
    }
    locale.ac(parama);
    if (paramInt >= 0)
    {
      paramTabLayout.a(locale, paramInt);
      return;
    }
    paramTabLayout.a(locale);
  }
  
  private final void ekJ()
  {
    TabLayout localTabLayout = this.BoG;
    if (localTabLayout != null)
    {
      localTabLayout.a((TabLayout.b)new c(localTabLayout, this));
      Object localObject1 = this.tabs;
      if (localObject1 == null) {
        p.bGy("tabs");
      }
      localObject1 = (Iterable)localObject1;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        localObject2 = (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2;
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2).index = i;
        a(localTabLayout, (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2, -1);
        i += 1;
      }
      localTabLayout = this.BoG;
      if (localTabLayout != null)
      {
        Log.i("Finder.FinderTabUIC", "ajustIndicator:" + localTabLayout.getTabCount());
        if (localTabLayout.getTabCount() > 1) {
          localTabLayout.post((Runnable)new b(this));
        }
      }
    }
  }
  
  private final void els()
  {
    if (!elt())
    {
      this.tabProvider = dmS();
      elw();
    }
  }
  
  private boolean elt()
  {
    return ((FinderTabUIC)this).tabProvider != null;
  }
  
  private final void elw()
  {
    if (((FinderTabUIC)this).tabProvider != null)
    {
      IFinderTabProvider localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.bGy("tabProvider");
      }
      this.fragments = localIFinderTabProvider.fragments();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.bGy("tabProvider");
      }
      this.tabs = localIFinderTabProvider.tabs();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.bGy("tabProvider");
      }
      this.tabViewAction = localIFinderTabProvider.tabViewAction();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.bGy("tabProvider");
      }
      this.tabContainer = localIFinderTabProvider.tabContainer();
      localIFinderTabProvider = this.tabProvider;
      if (localIFinderTabProvider == null) {
        p.bGy("tabProvider");
      }
      this.aNY = localIFinderTabProvider.isDynamic();
    }
  }
  
  private void ho(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (this.aNY)
    {
      localObject = this.tabs;
      if (localObject == null) {
        p.bGy("tabs");
      }
      if (ag.fe(localObject)) {}
    }
    else
    {
      Log.e("Finder.FinderTabUIC", "removeTabAndFragment param error");
      return;
    }
    if ((this.aNY) && (paramInt1 >= 0))
    {
      localObject = this.tabs;
      if (localObject == null) {
        p.bGy("tabs");
      }
      if (paramInt1 < ((List)localObject).size())
      {
        localObject = this.tabs;
        if (localObject == null) {
          p.bGy("tabs");
        }
        if (localObject == null) {
          throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab>");
        }
        ag.ff(localObject).remove(paramInt1);
        localObject = this.BoG;
        if (localObject != null) {
          ((TabLayout)localObject).ge(paramInt1);
        }
        localObject = this.BoH;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.view.adapter.a)localObject).a(new a.a(false, paramInt1), null);
        }
        if (paramInt2 < 0) {
          break label187;
        }
        localObject = this.tabs;
        if (localObject == null) {
          p.bGy("tabs");
        }
        if (paramInt2 >= ((List)localObject).size()) {
          break label187;
        }
      }
    }
    for (;;)
    {
      aA(paramInt2, false);
      dOQ();
      return;
      label187:
      if (paramInt1 - 1 < 0) {
        paramInt2 = 0;
      } else {
        paramInt2 = paramInt1 - 1;
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.view.tabcomp.a Sc(int paramInt)
  {
    com.tencent.mm.plugin.finder.view.tabcomp.a locala = null;
    List localList = this.tabs;
    if (localList == null) {
      p.bGy("tabs");
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
          p.bGy("tabs");
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
  
  public final boolean Sd(int paramInt)
  {
    Object localObject = this.fragments;
    if (localObject == null) {
      p.bGy("fragments");
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((FinderHomeTabFragment)((Iterator)localObject).next()).fEH == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public final void aA(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.BoG;
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
        localObject = ((TabLayout)localObject).gd(paramInt);
        if ((localObject != null) && ((paramBoolean) || (!((TabLayout.e)localObject).isSelected())))
        {
          Log.i("Finder.FinderTabUIC", "select :".concat(String.valueOf(paramInt)));
          ((TabLayout.e)localObject).xI();
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
  
  public void dOQ()
  {
    Object localObject = this.tabs;
    if (localObject == null) {
      p.bGy("tabs");
    }
    if (((List)localObject).size() <= 1)
    {
      localObject = this.tabContainer;
      if (localObject == null) {
        p.bGy("tabContainer");
      }
      localObject = ((g)localObject).ejV();
      if (localObject != null) {
        ((HardTouchableLayout)localObject).setVisibility(8);
      }
    }
    do
    {
      return;
      localObject = this.tabContainer;
      if (localObject == null) {
        p.bGy("tabContainer");
      }
      localObject = ((g)localObject).ejV();
    } while (localObject == null);
    ((HardTouchableLayout)localObject).setVisibility(0);
  }
  
  public abstract IFinderTabProvider dmS();
  
  public final ViewPager ejW()
  {
    return this.bFl;
  }
  
  public void ekP() {}
  
  public final int elu()
  {
    ViewPager localViewPager = this.bFl;
    if (localViewPager != null) {
      return localViewPager.getCurrentItem();
    }
    return this.lastIndex;
  }
  
  public final void elv()
  {
    List localList = this.tabs;
    if (localList == null) {
      p.bGy("tabs");
    }
    ho(localList.size() - 1, -1);
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    Object localObject = this.bFl;
    if (localObject != null) {}
    for (int i = ((ViewPager)localObject).getCurrentItem();; i = this.lastIndex)
    {
      int j;
      if (i >= 0)
      {
        localObject = this.fragments;
        if (localObject == null) {
          p.bGy("fragments");
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
        p.bGy("fragments");
      }
      return (FinderHomeTabFragment)((List)localObject).get(j);
    }
  }
  
  public final List<FinderHomeTabFragment> getFragments()
  {
    List localList = this.fragments;
    if (localList == null) {
      p.bGy("fragments");
    }
    return localList;
  }
  
  public int getLayoutId()
  {
    els();
    g localg = this.tabContainer;
    if (localg == null) {
      p.bGy("tabContainer");
    }
    return localg.getLayoutId();
  }
  
  public final g getTabContainer()
  {
    g localg = this.tabContainer;
    if (localg == null) {
      p.bGy("tabContainer");
    }
    return localg;
  }
  
  public final f getTabViewAction()
  {
    f localf = this.tabViewAction;
    if (localf == null) {
      p.bGy("tabViewAction");
    }
    return localf;
  }
  
  public final List<com.tencent.mm.plugin.finder.view.tabcomp.a> getTabs()
  {
    List localList = this.tabs;
    if (localList == null) {
      p.bGy("tabs");
    }
    return localList;
  }
  
  public final void hn(int paramInt1, int paramInt2)
  {
    Object localObject = this.fragments;
    if (localObject == null) {
      p.bGy("fragments");
    }
    localObject = ((List)localObject).iterator();
    int i = -1;
    if (((Iterator)localObject).hasNext())
    {
      FinderHomeTabFragment localFinderHomeTabFragment = (FinderHomeTabFragment)((Iterator)localObject).next();
      if (localFinderHomeTabFragment.fEH != paramInt1) {
        break label104;
      }
      List localList = this.fragments;
      if (localList == null) {
        p.bGy("fragments");
      }
      i = localList.indexOf(localFinderHomeTabFragment);
    }
    label104:
    for (;;)
    {
      break;
      if (i >= 0) {
        ho(i, paramInt2);
      }
      dOQ();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    els();
    super.onCreate(paramBundle);
    paramBundle = this.fragments;
    if (paramBundle == null) {
      p.bGy("fragments");
    }
    int i = paramBundle.size();
    paramBundle = this.tabs;
    if (paramBundle == null) {
      p.bGy("tabs");
    }
    if (i != paramBundle.size())
    {
      Log.e("Finder.FinderTabUIC", "fragments size must not be equal to tabs");
      throw ((Throwable)new IllegalArgumentException("FinderTabUIC: fragments size must not be equal to tabs"));
    }
    paramBundle = this.tabContainer;
    if (paramBundle == null) {
      p.bGy("tabContainer");
    }
    Object localObject1 = getActivity().getWindow();
    p.j(localObject1, "activity.window");
    paramBundle.c((Window)localObject1);
    if (((FinderTabUIC)this).tabProvider != null)
    {
      paramBundle = this.tabContainer;
      if (paramBundle == null) {
        p.bGy("tabContainer");
      }
      this.BoG = paramBundle.ejU();
      paramBundle = this.tabContainer;
      if (paramBundle == null) {
        p.bGy("tabContainer");
      }
      this.bFl = paramBundle.ejW();
    }
    paramBundle = getActivity();
    if (paramBundle == null) {
      throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
    }
    ((MMActivity)paramBundle).setTitleBarClickListener((Runnable)new f(this), (Runnable)new g(this));
    paramBundle = this.tabContainer;
    if (paramBundle == null) {
      p.bGy("tabContainer");
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
      p.bGy("fragments");
    }
    localObject1 = (FinderFragmentChangeObserver)new e(this, paramBundle, (List)localObject1);
    paramBundle = this.bFl;
    Object localObject2;
    List localList;
    if (paramBundle != null)
    {
      if (!this.aNY) {
        break label541;
      }
      localObject2 = getActivity().getSupportFragmentManager();
      p.j(localObject2, "activity.supportFragmentManager");
      localList = this.fragments;
      if (localList == null) {
        p.bGy("fragments");
      }
      if (localList == null) {
        throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment>");
      }
      this.BoH = new com.tencent.mm.plugin.finder.view.adapter.a(paramBundle, (e)localObject2, ag.ff(localList));
      paramBundle.setAdapter((androidx.viewpager.widget.a)this.BoH);
      localObject2 = this.tabs;
      if (localObject2 == null) {
        p.bGy("tabs");
      }
      paramBundle.setOffscreenPageLimit(kotlin.k.i.ow(((List)localObject2).size() + 3, 5));
    }
    for (;;)
    {
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)localObject1);
      localObject1 = d.AjH;
      i = ((Number)d.dUU().aSr()).intValue();
      if (i > 0)
      {
        localObject1 = ay.AJC;
        ay.a(paramBundle.getContext(), paramBundle, i);
      }
      ekJ();
      paramBundle = this.tabContainer;
      if (paramBundle == null) {
        p.bGy("tabContainer");
      }
      paramBundle = paramBundle.ejV();
      if (paramBundle != null) {
        paramBundle.setOnDoubleClickListener((HardTouchableLayout.b)new d(this));
      }
      aA(0, false);
      return;
      label541:
      localObject2 = getActivity().getSupportFragmentManager();
      p.j(localObject2, "activity.supportFragmentManager");
      localList = this.fragments;
      if (localList == null) {
        p.bGy("fragments");
      }
      this.xTE = new c((e)localObject2, localList);
      paramBundle.setAdapter((androidx.viewpager.widget.a)this.xTE);
      localObject2 = this.tabs;
      if (localObject2 == null) {
        p.bGy("tabs");
      }
      paramBundle.setOffscreenPageLimit(((List)localObject2).size() + 1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("Finder.FinderTabUIC", "onDestroy");
    com.tencent.mm.plugin.finder.view.adapter.a locala = this.BoH;
    if (locala != null)
    {
      Log.i("Finder.DynamicAdapter", "removePendingActions");
      if (locala.Bdh != null) {
        locala.bFl.removeCallbacks(locala.Bdh);
      }
      locala.Bdf.clear();
      locala.Bdg.clear();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$Companion;", "", "()V", "MAX_OFFSCREEN_PAGE_LIMIT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$ajustIndicator$1$1"})
  static final class b
    implements Runnable
  {
    b(FinderTabUIC paramFinderTabUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(280590);
      FinderTabUIC.d(this.BoJ);
      AppMethodBeat.o(280590);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$buildTab$1$1", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "tab", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    c(TabLayout paramTabLayout, FinderTabUIC paramFinderTabUIC) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(285934);
      if (parame != null)
      {
        Object localObject1 = jdField_this.getTabViewAction();
        Object localObject2 = this.BoK.getContext();
        p.j(localObject2, "context");
        Object localObject3 = parame.getTag();
        if (localObject3 == null)
        {
          parame = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(285934);
          throw parame;
        }
        ((f)localObject1).a((Context)localObject2, (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject3);
        localObject1 = parame.getTag();
        if (localObject1 == null)
        {
          parame = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(285934);
          throw parame;
        }
        localObject1 = (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1;
        localObject2 = parame.getCustomView();
        if (localObject2 == null)
        {
          parame = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(285934);
          throw parame;
        }
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1).a(true, (ViewGroup)localObject2);
        localObject1 = jdField_this;
        parame = parame.getTag();
        if (parame == null)
        {
          parame = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(285934);
          throw parame;
        }
        int j = FinderTabUIC.a((FinderTabUIC)localObject1, (com.tencent.mm.plugin.finder.view.tabcomp.a)parame);
        Log.i("Finder.FinderTabUIC", "setCurrentPage:".concat(String.valueOf(j)));
        int i = j;
        if (j == -1) {
          i = 0;
        }
        FinderTabUIC.d(jdField_this, i);
        AppMethodBeat.o(285934);
        return;
      }
      AppMethodBeat.o(285934);
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(285933);
      if (parame != null)
      {
        if ((parame.getTag() instanceof com.tencent.mm.plugin.finder.view.tabcomp.a))
        {
          Object localObject1 = jdField_this.getTabViewAction();
          Context localContext = this.BoK.getContext();
          p.j(localContext, "context");
          Object localObject2 = parame.getTag();
          if (localObject2 == null)
          {
            parame = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(285933);
            throw parame;
          }
          ((f)localObject1).b(localContext, (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2);
          localObject1 = parame.getTag();
          if (localObject1 == null)
          {
            parame = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(285933);
            throw parame;
          }
          localObject1 = (com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1;
          parame = parame.getCustomView();
          if (parame == null)
          {
            parame = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(285933);
            throw parame;
          }
          ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject1).a(false, (ViewGroup)parame);
        }
        AppMethodBeat.o(285933);
        return;
      }
      AppMethodBeat.o(285933);
    }
    
    public final void k(TabLayout.e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$initTabContainer$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class d
    implements HardTouchableLayout.b
  {
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(282292);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "e");
      Log.i("Finder.FinderTabUIC", "onDoubleClick");
      h.ZvG.bc((Runnable)new a(this));
      paramView = this.BoJ;
      paramMotionEvent = this.BoJ.BoG;
      if (paramMotionEvent != null) {}
      for (int i = paramMotionEvent.getSelectedTabPosition();; i = FinderTabUIC.c(this.BoJ))
      {
        paramView = paramView.Sc(i);
        if (paramView == null) {
          break;
        }
        this.BoJ.getTabViewAction().d((Context)this.BoJ.getActivity(), paramView);
        AppMethodBeat.o(282292);
        return;
      }
      AppMethodBeat.o(282292);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderTabUIC.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(291423);
        this.BoL.BoJ.getActiveFragment().dLu();
        AppMethodBeat.o(291423);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$initViewPager$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "plugin-finder_release"})
  public static final class e
    extends FinderFragmentChangeObserver
  {
    e(MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(287511);
      Log.i("Finder.FragmentChangeObserver", "to :" + paramInt2 + " lastIndex:" + FinderTabUIC.c(this.BoJ));
      FinderTabUIC.e(this.BoJ, paramInt2);
      FinderTabUIC.a(this.BoJ, paramInt2);
      Iterator localIterator = ((Iterable)this.BoJ.Bls).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.i)localIterator.next()).H(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(287511);
    }
    
    public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
    {
      AppMethodBeat.i(287510);
      p.k(paramFinderHomeTabFragment, "fragment");
      Iterator localIterator = ((Iterable)this.BoJ.Bls).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.finder.view.i)localIterator.next()).a(paramBoolean, paramInt, paramFinderHomeTabFragment);
      }
      AppMethodBeat.o(287510);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderTabUIC paramFinderTabUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(270859);
      FinderTabUIC.a(this.BoJ);
      AppMethodBeat.o(270859);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderTabUIC paramFinderTabUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(256296);
      FinderTabUIC.b(this.BoJ);
      AppMethodBeat.o(256296);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderTabUIC paramFinderTabUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(225948);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.BoJ.ekP();
      if (!this.BoJ.getActivity().isFinishing()) {
        this.BoJ.getActivity().finish();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(225948);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
 * JD-Core Version:    0.7.0.1
 */