package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC.c;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.bp;
import com.tencent.mm.plugin.finder.view.FinderFragmentChangeObserver;
import com.tencent.mm.plugin.finder.view.adapter.a.a;
import com.tencent.mm.plugin.finder.view.adapter.c;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.view.tabcomp.g;
import com.tencent.mm.plugin.finder.view.tabcomp.m;
import com.tencent.mm.plugin.finder.view.tabcomp.n;
import com.tencent.mm.plugin.finder.view.tabcomp.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "dynamicPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "getDynamicPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;", "setDynamicPagerAdapter", "(Lcom/tencent/mm/plugin/finder/view/adapter/DynamicPagerAdapter;)V", "enableSortTab", "", "fragmentChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "getFragmentChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "fragmentChangeObserver", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeObserver;", "fragments", "", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "isDynamic", "lastIndex", "", "getLastIndex", "()I", "setLastIndex", "(I)V", "tabAlignStrategy", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabLayoutAlignStrategy;", "getTabAlignStrategy", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabLayoutAlignStrategy;", "setTabAlignStrategy", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabLayoutAlignStrategy;)V", "tabContainer", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "getTabContainer", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;", "setTabContainer", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabContainer;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "tabProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "getTabProvider", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "setTabProvider", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;)V", "tabViewAction", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "getTabViewAction", "()Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "setTabViewAction", "(Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;)V", "tabs", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "getTabs", "setTabs", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "viewPagerAdapter", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "getViewPagerAdapter", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;", "setViewPagerAdapter", "(Lcom/tencent/mm/plugin/finder/view/adapter/FinderFragmentPagerAdapter;)V", "addTab", "", "finderTab", "position", "index", "addTabAndFragment", "tab", "fragment", "scrollToAfterAdd", "adjustIndicator", "adjustTabIndicator", "buildTab", "checkFragmentExistByTabType", "tabType", "checkTabLayoutVisibility", "convertIndexToTabType", "ensureTabInjections", "ensureTabUIC", "generateProvider", "getActiveFragment", "getActiveIndex", "getActiveTabType", "getFragment", "getFragmentByTabType", "getFragmentIndex", "getIndicatorView", "Landroid/view/ViewGroup;", "getLayoutId", "getSelectedTabPosition", "getTab", "getTabByType", "getTabIndex", "initNormalRefs", "initOtherNormalRefs", "initOtherViewRefs", "initTabContainer", "initViewPager", "initViewRefs", "injectProvider", "isTabProviderInitialized", "isTabsInitialized", "onActionbarClick", "onActionbarDoubleClick", "onBtnBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "removeTabAndFragment", "selectPos", "removeTabAndFragmentByTabType", "removeTabAt", "reoderTabPos", "selectFirstPage", "selectTab", "isForceSelect", "setCurrentPage", "setMargins", "tabIndicator", "leftMargin", "rightMargin", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderTabUIC
  extends UIComponent
{
  public static final FinderTabUIC.a GVl = new FinderTabUIC.a((byte)0);
  private c Buz;
  final CopyOnWriteArraySet<com.tencent.mm.plugin.finder.view.h> GRB = new CopyOnWriteArraySet();
  private com.tencent.mm.plugin.finder.view.adapter.a<FinderHomeTabFragment> GVm;
  private o GVn;
  private FinderFragmentChangeObserver GVo;
  private boolean GVp;
  private boolean cHU;
  protected ViewPager dyl;
  public List<? extends FinderHomeTabFragment> fragments;
  protected int lastIndex = -1;
  public n tabContainer;
  public IFinderTabProvider tabProvider;
  public m tabViewAction;
  public List<? extends g> tabs;
  private TabLayout yaj;
  
  public FinderTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    paramAppCompatActivity = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.GVp = com.tencent.mm.plugin.finder.storage.d.eWB();
  }
  
  private int a(int paramInt, g paramg)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    s.u(paramg, "tab");
    int i;
    if (paramInt <= getTabs().size())
    {
      i = paramInt;
      if (this.GVp)
      {
        i = paramInt;
        if (paramg.priority >= 0)
        {
          i = paramInt;
          if (paramg.priority < 2147483647)
          {
            localObject1 = (Iterable)getTabs();
            i = 0;
            localObject1 = ((Iterable)localObject1).iterator();
          }
        }
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label325;
      }
      Object localObject4 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      if (((g)localObject4).priority > paramg.priority)
      {
        localObject1 = new StringBuilder("reoderTabPos ");
        if ((paramg instanceof FinderProfileTabUIC.c))
        {
          paramg = (FinderProfileTabUIC.c)paramg;
          label139:
          if (paramg != null) {
            break label307;
          }
        }
        label289:
        label307:
        for (paramg = localObject2;; paramg = Integer.valueOf(paramg.EHx))
        {
          Log.i("Finder.FinderTabUIC", paramg + " pos from:" + paramInt + " to:" + i + '!');
          return i;
          localObject4 = new StringBuilder("reoderTabPos ");
          if ((paramg instanceof FinderProfileTabUIC.c))
          {
            localObject1 = (FinderProfileTabUIC.c)paramg;
            label213:
            if (localObject1 != null) {
              break label289;
            }
          }
          for (localObject1 = null;; localObject1 = Integer.valueOf(((FinderProfileTabUIC.c)localObject1).EHx))
          {
            Log.e("Finder.FinderTabUIC", localObject1 + " pos from:" + paramInt + " to:" + getTabs().size() + '!');
            paramInt = getTabs().size();
            break;
            localObject1 = null;
            break label213;
          }
          paramg = null;
          break label139;
        }
      }
      i += 1;
    }
    label325:
    Object localObject1 = new StringBuilder("reoderTabPos  ");
    if ((paramg instanceof FinderProfileTabUIC.c))
    {
      paramg = (FinderProfileTabUIC.c)paramg;
      if (paramg != null) {
        break label419;
      }
    }
    label419:
    for (paramg = localObject3;; paramg = Integer.valueOf(paramg.EHx))
    {
      Log.i("Finder.FinderTabUIC", paramg + " priority is max, pos from:" + paramInt + " to:" + getTabs().size() + '!');
      return getTabs().size();
      paramg = null;
      break;
    }
  }
  
  private void a(int paramInt, g paramg, FinderHomeTabFragment paramFinderHomeTabFragment, boolean paramBoolean)
  {
    s.u(paramg, "tab");
    s.u(paramFinderHomeTabFragment, "fragment");
    if ((!this.cHU) || (!an.hC(getTabs())))
    {
      Log.e("Finder.FinderTabUIC", "addTabAndFragment param error");
      return;
    }
    int i = a(paramInt, paramg);
    Log.i("Finder.FinderTabUIC", "after reoderTabPos position from:" + paramInt + " to " + i);
    if ((i >= 0) && (i <= getTabs().size()))
    {
      paramInt = fpi();
      paramg.index = i;
      an.hD(getTabs()).add(i, paramg);
      if (this.yaj != null) {
        a(paramg, i);
      }
      paramg = this.GVm;
      if (paramg != null) {
        paramg.a(new a.a(true, i), paramFinderHomeTabFragment);
      }
      if (paramInt >= i) {
        aV(paramInt + 1, true);
      }
    }
    eKo();
  }
  
  private void a(IFinderTabProvider paramIFinderTabProvider)
  {
    s.u(paramIFinderTabProvider, "<set-?>");
    this.tabProvider = paramIFinderTabProvider;
  }
  
  private static final void a(FinderTabUIC paramFinderTabUIC)
  {
    s.u(paramFinderTabUIC, "this$0");
    Log.i("Finder.FinderTabUIC", "onActionbarDoubleClick");
    g localg = paramFinderTabUIC.Vu(paramFinderTabUIC.getSelectedTabPosition());
    if (localg != null) {
      paramFinderTabUIC.getTabViewAction().d((Context)paramFinderTabUIC.getActivity(), localg);
    }
  }
  
  private static final void a(FinderTabUIC paramFinderTabUIC, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderTabUIC);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderTabUIC, "this$0");
    paramFinderTabUIC.foe();
    if (!paramFinderTabUIC.getActivity().isFinishing()) {
      paramFinderTabUIC.getActivity().finish();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  protected static void b(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = null;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return;
    }
    int i;
    if (paramViewGroup != null)
    {
      if ((paramViewGroup.getChildCount() <= paramInt1) || (paramInt1 < 0)) {
        break label93;
      }
      i = 1;
      if (i == 0) {
        break label99;
      }
      label36:
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.getChildAt(paramInt1);
        if (paramViewGroup != null) {
          break label104;
        }
      }
    }
    label93:
    label99:
    label104:
    for (paramViewGroup = localObject;; paramViewGroup = paramViewGroup.getLayoutParams())
    {
      if ((paramViewGroup instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)paramViewGroup).leftMargin = paramInt2;
        ((LinearLayout.LayoutParams)paramViewGroup).rightMargin = paramInt3;
      }
      Log.i("Finder.FinderTabUIC", s.X("setMargins : invalidate", Integer.valueOf(paramInt1)));
      return;
      i = 0;
      break;
      paramViewGroup = null;
      break label36;
    }
  }
  
  private static final void b(FinderTabUIC paramFinderTabUIC)
  {
    s.u(paramFinderTabUIC, "this$0");
    Log.i("Finder.FinderTabUIC", "onActionbarClick");
    g localg = paramFinderTabUIC.Vu(paramFinderTabUIC.getSelectedTabPosition());
    if (localg != null) {
      paramFinderTabUIC.getTabViewAction().c((Context)paramFinderTabUIC.getActivity(), localg);
    }
  }
  
  private static final void c(FinderTabUIC paramFinderTabUIC)
  {
    s.u(paramFinderTabUIC, "this$0");
    paramFinderTabUIC.fmx();
  }
  
  private final void fpg()
  {
    if (!fph())
    {
      a(dTN());
      fpk();
    }
  }
  
  private boolean fph()
  {
    return this.tabProvider != null;
  }
  
  private final void fpk()
  {
    if (this.tabProvider != null)
    {
      setFragments(fpe().fragments());
      setTabs(fpe().tabs());
      setTabViewAction(fpe().tabViewAction());
      setTabContainer(fpe().tabContainer());
      this.cHU = fpe().isDynamic();
      fmu();
    }
  }
  
  private void iK(int paramInt1, int paramInt2)
  {
    if ((!this.cHU) || (!an.hC(getTabs())))
    {
      Log.e("Finder.FinderTabUIC", "removeTabAndFragment param error");
      return;
    }
    if ((this.cHU) && (paramInt1 >= 0) && (paramInt1 < getTabs().size()))
    {
      an.hD(getTabs()).remove(paramInt1);
      UQ(paramInt1);
      com.tencent.mm.plugin.finder.view.adapter.a locala = this.GVm;
      if (locala != null) {
        locala.a(new a.a(false, paramInt1), null);
      }
      if ((paramInt2 < 0) || (paramInt2 >= getTabs().size())) {
        break label121;
      }
    }
    for (;;)
    {
      aV(paramInt2, false);
      eKo();
      return;
      label121:
      if (paramInt1 - 1 < 0) {
        paramInt2 = 0;
      } else {
        paramInt2 = paramInt1 - 1;
      }
    }
  }
  
  private void setFragments(List<? extends FinderHomeTabFragment> paramList)
  {
    s.u(paramList, "<set-?>");
    this.fragments = paramList;
  }
  
  private void setTabContainer(n paramn)
  {
    s.u(paramn, "<set-?>");
    this.tabContainer = paramn;
  }
  
  private void setTabViewAction(m paramm)
  {
    s.u(paramm, "<set-?>");
    this.tabViewAction = paramm;
  }
  
  private void setTabs(List<? extends g> paramList)
  {
    s.u(paramList, "<set-?>");
    this.tabs = paramList;
  }
  
  public void UQ(int paramInt)
  {
    TabLayout localTabLayout = this.yaj;
    if (localTabLayout != null)
    {
      if (localTabLayout.dxQ != null) {}
      for (int i = localTabLayout.dxQ.position;; i = 0)
      {
        localTabLayout.ju(paramInt);
        locale = (TabLayout.e)localTabLayout.dxP.remove(paramInt);
        if (locale != null)
        {
          locale.reset();
          TabLayout.b(locale);
        }
        int k = localTabLayout.dxP.size();
        int j = paramInt;
        while (j < k)
        {
          ((TabLayout.e)localTabLayout.dxP.get(j)).position = j;
          j += 1;
        }
      }
      if (i == paramInt) {
        if (!localTabLayout.dxP.isEmpty()) {
          break label138;
        }
      }
    }
    label138:
    for (TabLayout.e locale = null;; locale = (TabLayout.e)localTabLayout.dxP.get(Math.max(0, paramInt - 1)))
    {
      localTabLayout.b(locale, true);
      return;
    }
  }
  
  public final g Vu(int paramInt)
  {
    List localList = getTabs();
    int i;
    if ((paramInt >= 0) && (paramInt < localList.size()))
    {
      i = 1;
      if (i == 0) {
        break label36;
      }
    }
    for (;;)
    {
      if (localList != null) {
        break label41;
      }
      return null;
      i = 0;
      break;
      label36:
      localList = null;
    }
    label41:
    return (g)getTabs().get(paramInt);
  }
  
  public final boolean Vv(int paramInt)
  {
    Iterator localIterator = getFragments().iterator();
    while (localIterator.hasNext()) {
      if (((FinderHomeTabFragment)localIterator.next()).hJx == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public final void Vw(int paramInt)
  {
    if (paramInt >= 0)
    {
      ViewPager localViewPager = this.dyl;
      if (localViewPager != null) {
        localViewPager.setCurrentItem(paramInt);
      }
    }
    Log.i("Finder.FinderTabUIC", s.X("setCurrentPage :", Integer.valueOf(paramInt)));
  }
  
  public final int a(g paramg)
  {
    s.u(paramg, "tab");
    return getTabs().indexOf(paramg);
  }
  
  public void a(g paramg, int paramInt)
  {
    TabLayout localTabLayout = this.yaj;
    TabLayout.e locale;
    if (localTabLayout != null)
    {
      locale = localTabLayout.WW();
      s.s(locale, "tabLayout.newTab()");
      if (paramg != null)
      {
        locale.jw(paramg.getLayoutId());
        paramg.H((ViewGroup)locale.dyK);
        paramg.vg(false);
        if ((paramg instanceof com.tencent.mm.plugin.finder.view.tabcomp.i)) {
          locale.E((CharSequence)((com.tencent.mm.plugin.finder.view.tabcomp.i)paramg).ht((Context)getContext()));
        }
      }
      locale.tag = paramg;
      if (paramInt >= 0) {
        localTabLayout.a(locale, paramInt, localTabLayout.dxP.isEmpty());
      }
    }
    else
    {
      return;
    }
    localTabLayout.a(locale);
  }
  
  public final void a(o paramo)
  {
    this.GVn = paramo;
  }
  
  public void aV(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.yaj;
    int i;
    if (localObject != null)
    {
      if ((paramInt < 0) || (paramInt >= ((TabLayout)localObject).getTabCount())) {
        break label82;
      }
      i = 1;
      if (i == 0) {
        break label87;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((TabLayout)localObject).js(paramInt);
        if ((localObject != null) && ((paramBoolean) || (!((TabLayout.e)localObject).isSelected())))
        {
          Log.i("Finder.FinderTabUIC", s.X("select :", Integer.valueOf(paramInt)));
          ((TabLayout.e)localObject).Xf();
        }
      }
      return;
      label82:
      i = 0;
      break;
      label87:
      localObject = null;
    }
  }
  
  public abstract IFinderTabProvider dTN();
  
  public void eKo()
  {
    HardTouchableLayout localHardTouchableLayout;
    if (getTabs().size() <= 1)
    {
      localHardTouchableLayout = getTabContainer().fmB();
      if (localHardTouchableLayout != null) {
        localHardTouchableLayout.setVisibility(8);
      }
    }
    do
    {
      return;
      localHardTouchableLayout = getTabContainer().fmB();
    } while (localHardTouchableLayout == null);
    localHardTouchableLayout.setVisibility(0);
  }
  
  protected void fmt() {}
  
  protected void fmu() {}
  
  protected void fmv()
  {
    Object localObject1 = this.yaj;
    if (localObject1 != null)
    {
      ((TabLayout)localObject1).a((TabLayout.b)new b(this, (TabLayout)localObject1));
      localObject1 = (Iterable)getTabs();
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (g)localObject2;
        ((g)localObject2).index = i;
        a((g)localObject2, -1);
        i += 1;
      }
      fmw();
    }
  }
  
  protected void fmw()
  {
    TabLayout localTabLayout = this.yaj;
    if (localTabLayout != null)
    {
      Log.i("Finder.FinderTabUIC", s.X("ajustIndicator:", Integer.valueOf(localTabLayout.getTabCount())));
      if (localTabLayout.getTabCount() > 1) {}
    }
    else
    {
      return;
    }
    localTabLayout.post(new FinderTabUIC..ExternalSyntheticLambda1(this));
  }
  
  protected void fmx()
  {
    Object localObject = this.yaj;
    ViewGroup localViewGroup;
    int j;
    int i;
    int k;
    if (localObject != null)
    {
      int m = ((TabLayout)localObject).getTabCount();
      localViewGroup = fmy();
      if (localViewGroup != null)
      {
        if (m <= 0) {
          break label181;
        }
        j = 0;
        i = 0;
        k = j + 1;
        localObject = this.yaj;
        if (localObject == null) {
          localObject = null;
        }
        while (localObject == null)
        {
          throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          localObject = ((TabLayout)localObject).js(j);
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = ((TabLayout.e)localObject).tag;
          }
        }
        localObject = ((g)localObject).dTO();
        if ((localObject[0] <= 0) && (localObject[1] <= 0)) {
          break label178;
        }
        b(localViewGroup, j, com.tencent.mm.cd.a.fromDPToPix(localViewGroup.getContext(), localObject[0]), com.tencent.mm.cd.a.fromDPToPix(localViewGroup.getContext(), localObject[1]));
        i = 1;
        label157:
        if (k < m) {
          break label173;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        localViewGroup.requestLayout();
      }
      return;
      label173:
      j = k;
      break;
      label178:
      break label157;
      label181:
      i = 0;
    }
  }
  
  protected ViewGroup fmy()
  {
    Object localObject = this.yaj;
    if (localObject == null) {
      return null;
    }
    localObject = ((TabLayout)localObject).getChildAt(0);
    if (localObject == null) {
      return null;
    }
    return (ViewGroup)localObject;
  }
  
  public final TabLayout fmz()
  {
    return this.yaj;
  }
  
  public void foe() {}
  
  public final o fpd()
  {
    return this.GVn;
  }
  
  public final IFinderTabProvider fpe()
  {
    IFinderTabProvider localIFinderTabProvider = this.tabProvider;
    if (localIFinderTabProvider != null) {
      return localIFinderTabProvider;
    }
    s.bIx("tabProvider");
    return null;
  }
  
  public final void fpf()
  {
    com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new e(this));
  }
  
  public final int fpi()
  {
    Object localObject = this.dyl;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((ViewPager)localObject).getCurrentItem())) {
      return this.lastIndex;
    }
    return ((Integer)localObject).intValue();
  }
  
  public final void fpj()
  {
    iK(getTabs().size() - 1, -1);
  }
  
  public final FinderHomeTabFragment getActiveFragment()
  {
    Object localObject = this.dyl;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label66;
      }
    }
    label66:
    for (int i = this.lastIndex;; i = ((Integer)localObject).intValue())
    {
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < getFragments().size()) {}
      }
      else
      {
        j = 0;
      }
      return (FinderHomeTabFragment)getFragments().get(j);
      localObject = Integer.valueOf(((ViewPager)localObject).getCurrentItem());
      break;
    }
  }
  
  public final List<FinderHomeTabFragment> getFragments()
  {
    List localList = this.fragments;
    if (localList != null) {
      return localList;
    }
    s.bIx("fragments");
    return null;
  }
  
  public int getLayoutId()
  {
    fpg();
    return getTabContainer().getLayoutId();
  }
  
  public int getSelectedTabPosition()
  {
    Object localObject = this.yaj;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((TabLayout)localObject).getSelectedTabPosition())) {
      return this.lastIndex;
    }
    return ((Integer)localObject).intValue();
  }
  
  public final n getTabContainer()
  {
    n localn = this.tabContainer;
    if (localn != null) {
      return localn;
    }
    s.bIx("tabContainer");
    return null;
  }
  
  public final m getTabViewAction()
  {
    m localm = this.tabViewAction;
    if (localm != null) {
      return localm;
    }
    s.bIx("tabViewAction");
    return null;
  }
  
  public final List<g> getTabs()
  {
    List localList = this.tabs;
    if (localList != null) {
      return localList;
    }
    s.bIx("tabs");
    return null;
  }
  
  public final void iJ(int paramInt1, int paramInt2)
  {
    Iterator localIterator = getFragments().iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      FinderHomeTabFragment localFinderHomeTabFragment = (FinderHomeTabFragment)localIterator.next();
      if (localFinderHomeTabFragment.hJx == paramInt1) {
        i = getFragments().indexOf(localFinderHomeTabFragment);
      }
    }
    if (i >= 0) {
      iK(i, paramInt2);
    }
    eKo();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    fpg();
    super.onCreate(paramBundle);
    if (getFragments().size() != getTabs().size())
    {
      Log.e("Finder.FinderTabUIC", "fragments size must not be equal to tabs");
      throw new IllegalArgumentException("FinderTabUIC: fragments size must not be equal to tabs");
    }
    paramBundle = getTabContainer();
    Object localObject = getActivity().getWindow();
    s.s(localObject, "activity.window");
    paramBundle.e((Window)localObject);
    if (this.tabProvider != null)
    {
      this.yaj = getTabContainer().fmz();
      this.dyl = getTabContainer().fmC();
      fmt();
    }
    ((MMActivity)getActivity()).setTitleBarClickListener(new FinderTabUIC..ExternalSyntheticLambda2(this), new FinderTabUIC..ExternalSyntheticLambda3(this));
    paramBundle = getTabContainer().getBackBtn();
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new FinderTabUIC..ExternalSyntheticLambda0(this));
    }
    this.GVo = ((FinderFragmentChangeObserver)new FinderTabUIC.d(this, getActivity(), getFragments()));
    ViewPager localViewPager = this.dyl;
    if (localViewPager != null)
    {
      if (!this.cHU) {
        break label383;
      }
      paramBundle = getActivity().getSupportFragmentManager();
      s.s(paramBundle, "activity.supportFragmentManager");
      this.GVm = new com.tencent.mm.plugin.finder.view.adapter.a(localViewPager, paramBundle, an.hD(getFragments()));
      localViewPager.setAdapter((androidx.viewpager.widget.a)this.GVm);
      localViewPager.setOffscreenPageLimit(k.qv(getTabs().size() + 3, 5));
    }
    for (;;)
    {
      localObject = this.GVo;
      paramBundle = (Bundle)localObject;
      if (localObject == null)
      {
        s.bIx("fragmentChangeObserver");
        paramBundle = null;
      }
      localViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eTt().bmg()).intValue();
      if (i > 0)
      {
        paramBundle = bp.Gmq;
        bp.a(localViewPager.getContext(), localViewPager, i);
      }
      fmv();
      paramBundle = getTabContainer().fmB();
      if (paramBundle != null) {
        paramBundle.setOnDoubleClickListener((HardTouchableLayout.b)new c(this));
      }
      aV(0, false);
      fpf();
      return;
      label383:
      paramBundle = getActivity().getSupportFragmentManager();
      s.s(paramBundle, "activity.supportFragmentManager");
      this.Buz = new c(paramBundle, getFragments());
      localViewPager.setAdapter((androidx.viewpager.widget.a)this.Buz);
      localViewPager.setOffscreenPageLimit(getTabs().size() + 1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("Finder.FinderTabUIC", "onDestroy");
    com.tencent.mm.plugin.finder.view.adapter.a locala = this.GVm;
    if (locala != null)
    {
      Log.i("Finder.DynamicAdapter", "removePendingActions");
      if (locala.GFX != null) {
        locala.dyl.removeCallbacks(locala.GFX);
      }
      locala.GFV.clear();
      locala.GFW.clear();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$buildTab$1$1", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "tab", "onTabSelected", "onTabUnselected", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TabLayout.b<TabLayout.e>
  {
    b(FinderTabUIC paramFinderTabUIC, TabLayout paramTabLayout) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(337774);
      if (parame != null)
      {
        FinderTabUIC localFinderTabUIC = this.GVq;
        Object localObject2 = this.CSU;
        Object localObject1 = localFinderTabUIC.getTabViewAction();
        localObject2 = ((TabLayout)localObject2).getContext();
        s.s(localObject2, "context");
        Object localObject3 = parame.tag;
        if (localObject3 == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(337774);
          throw parame;
        }
        ((m)localObject1).a((Context)localObject2, (g)localObject3);
        localObject1 = parame.tag;
        if (localObject1 == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(337774);
          throw parame;
        }
        localObject1 = (g)localObject1;
        localObject2 = parame.dyK;
        if (localObject2 == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(337774);
          throw parame;
        }
        ((g)localObject1).a(true, (ViewGroup)localObject2);
        parame = parame.tag;
        if (parame == null)
        {
          parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
          AppMethodBeat.o(337774);
          throw parame;
        }
        int j = localFinderTabUIC.a((g)parame);
        Log.i("Finder.FinderTabUIC", s.X("setCurrentPage:", Integer.valueOf(j)));
        int i = j;
        if (j == -1) {
          i = 0;
        }
        localFinderTabUIC.Vw(i);
      }
      AppMethodBeat.o(337774);
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(337767);
      if (parame != null)
      {
        Object localObject1 = this.GVq;
        Object localObject2 = this.CSU;
        if ((parame.tag instanceof g))
        {
          localObject1 = ((FinderTabUIC)localObject1).getTabViewAction();
          localObject2 = ((TabLayout)localObject2).getContext();
          s.s(localObject2, "context");
          Object localObject3 = parame.tag;
          if (localObject3 == null)
          {
            parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(337767);
            throw parame;
          }
          ((m)localObject1).b((Context)localObject2, (g)localObject3);
          localObject1 = parame.tag;
          if (localObject1 == null)
          {
            parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.tabcomp.FinderBaseTab");
            AppMethodBeat.o(337767);
            throw parame;
          }
          localObject1 = (g)localObject1;
          parame = parame.dyK;
          if (parame == null)
          {
            parame = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(337767);
            throw parame;
          }
          ((g)localObject1).a(false, (ViewGroup)parame);
        }
      }
      AppMethodBeat.o(337767);
    }
    
    public final void k(TabLayout.e parame) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC$initTabContainer$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements HardTouchableLayout.b
  {
    c(FinderTabUIC paramFinderTabUIC) {}
    
    private static final void e(FinderTabUIC paramFinderTabUIC)
    {
      AppMethodBeat.i(337732);
      s.u(paramFinderTabUIC, "this$0");
      paramFinderTabUIC.getActiveFragment().eEr();
      AppMethodBeat.o(337732);
    }
    
    public final void c(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(337750);
      s.u(paramView, "view");
      s.u(paramMotionEvent, "e");
      Log.i("Finder.FinderTabUIC", "onDoubleClick");
      com.tencent.threadpool.h.ahAA.bk(new FinderTabUIC.c..ExternalSyntheticLambda0(this.GVq));
      paramView = this.GVq.Vu(this.GVq.getSelectedTabPosition());
      if (paramView != null)
      {
        paramMotionEvent = this.GVq;
        paramMotionEvent.getTabViewAction().d((Context)paramMotionEvent.getActivity(), paramView);
      }
      AppMethodBeat.o(337750);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(FinderTabUIC paramFinderTabUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
 * JD-Core Version:    0.7.0.1
 */