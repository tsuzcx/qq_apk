package com.tencent.mm.plugin.finder.nearby.live.square;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.if;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFragment;", "getFragments", "()Ljava/util/LinkedList;", "isCreated", "", "lastIndex", "", "livePostHelper", "Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "liveTabLists", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "targetTabInfo", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "addFragments", "", "", "fragmentList", "getActiveFragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "getCurrentTabType", "getIndex", "tabId", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClick", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setCurrentTabId", "args", "withAnim", "setCurrentTabIndex", "index", "Companion", "plugin-finder_release"})
public final class NearbyLiveSquareUIC
  extends UIComponent
{
  public static final a uRK;
  private boolean dbG;
  private int lastIndex;
  private final IListener<if> tOh;
  private final FinderHomeTabStateVM tlCache;
  private axj uRG;
  private final LinkedList<NearbyLiveSquareTabFragment> uRH;
  private final LinkedList<axj> uRI;
  private final d uRJ;
  f uRi;
  
  static
  {
    AppMethodBeat.i(249203);
    uRK = new a((byte)0);
    AppMethodBeat.o(249203);
  }
  
  public NearbyLiveSquareUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(249202);
    paramFragment = a.PRN;
    paramFragment = a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramFragment, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((FinderHomeTabStateVM)paramFragment);
    this.lastIndex = -1;
    this.uRH = new LinkedList();
    this.uRI = new LinkedList();
    paramFragment = getActivity();
    if (paramFragment == null)
    {
      paramFragment = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(249202);
      throw paramFragment;
    }
    this.uRJ = new d(this, (MMActivity)paramFragment, (List)this.uRH);
    this.tOh = ((IListener)new c(this));
    AppMethodBeat.o(249202);
  }
  
  public NearbyLiveSquareUIC(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(249201);
    paramMMFragmentActivity = a.PRN;
    paramMMFragmentActivity = a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    p.g(paramMMFragmentActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.tlCache = ((FinderHomeTabStateVM)paramMMFragmentActivity);
    this.lastIndex = -1;
    this.uRH = new LinkedList();
    this.uRI = new LinkedList();
    paramMMFragmentActivity = getActivity();
    if (paramMMFragmentActivity == null)
    {
      paramMMFragmentActivity = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(249201);
      throw paramMMFragmentActivity;
    }
    this.uRJ = new d(this, (MMActivity)paramMMFragmentActivity, (List)this.uRH);
    this.tOh = ((IListener)new c(this));
    AppMethodBeat.o(249201);
  }
  
  private final int getIndex(int paramInt)
  {
    AppMethodBeat.i(249199);
    Iterator localIterator = ((List)this.uRI).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((axj)localIterator.next()).LHQ == paramInt)
      {
        j = 1;
        label51:
        if (j == 0) {
          break label100;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label112;
      }
      Log.e("NearbyLiveSquareUIC", "[getIndex] tabId=" + paramInt + " is invalid.");
      AppMethodBeat.o(249199);
      return 0;
      j = 0;
      break label51;
      label100:
      i += 1;
      break;
      i = -1;
    }
    label112:
    AppMethodBeat.o(249199);
    return i;
  }
  
  public final void JB(int paramInt)
  {
    AppMethodBeat.i(249197);
    paramInt = getIndex(paramInt);
    int i = this.uRH.size();
    if (paramInt < 0)
    {
      AppMethodBeat.o(249197);
      return;
    }
    if (i > paramInt)
    {
      Object localObject = getFragment();
      if (localObject == null) {
        p.hyc();
      }
      localObject = (FinderViewPager)((Fragment)localObject).getView().findViewById(2131309856);
      p.g(localObject, "fragment!!.viewPager");
      ((FinderViewPager)localObject).setCurrentItem(paramInt);
    }
    AppMethodBeat.o(249197);
  }
  
  public final AbsNearByFragment dlj()
  {
    AppMethodBeat.i(249200);
    Object localObject = getFragment();
    if (localObject == null) {
      p.hyc();
    }
    if (((Fragment)localObject).getView() == null)
    {
      Log.e("NearbyLiveSquareUIC", "[getActiveFragment] view is null");
      AppMethodBeat.o(249200);
      return null;
    }
    localObject = getFragment();
    if (localObject == null) {
      p.hyc();
    }
    localObject = (FinderViewPager)((Fragment)localObject).getView().findViewById(2131309856);
    if (localObject == null) {
      Log.e("NearbyLiveSquareUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem(); (i < 0) || (i >= this.uRH.size()) || (this.uRH.size() == 0); i = this.lastIndex)
    {
      AppMethodBeat.o(249200);
      return null;
    }
    localObject = (AbsNearByFragment)this.uRH.get(i);
    AppMethodBeat.o(249200);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return 2131495830;
  }
  
  public final void m(List<? extends axj> paramList, List<NearbyLiveSquareTabFragment> paramList1)
  {
    AppMethodBeat.i(249196);
    p.h(paramList, "liveTabLists");
    p.h(paramList1, "fragmentList");
    this.uRI.addAll((Collection)paramList);
    this.uRH.addAll((Collection)paramList1);
    paramList = getFragment();
    if (paramList == null) {
      p.hyc();
    }
    paramList = (FinderViewPager)paramList.getView().findViewById(2131309856);
    p.g(paramList, "this");
    paramList1 = getFragment();
    if (paramList1 == null) {
      p.hyc();
    }
    paramList1 = paramList1.getChildFragmentManager();
    p.g(paramList1, "fragment!!.childFragmentManager");
    paramList.setAdapter((q)new com.tencent.mm.plugin.finder.nearby.base.c(paramList1, (List)this.uRH));
    paramList.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.uRJ);
    paramList.setOffscreenPageLimit(2);
    paramList.post((Runnable)new b(paramList, this));
    paramList1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.c.dtL().value()).intValue();
    if (i > 0)
    {
      paramList1 = an.waE;
      paramList = paramList.getContext();
      paramList1 = getFragment();
      if (paramList1 == null) {
        p.hyc();
      }
      an.a(paramList, (FinderViewPager)paramList1.getView().findViewById(2131309856), i);
    }
    paramList = getFragment();
    if (paramList == null) {
      p.hyc();
    }
    paramList = (FinderViewPager)paramList.getView().findViewById(2131309856);
    p.g(paramList, "fragment!!.viewPager");
    paramList = paramList.getAdapter();
    if (paramList != null)
    {
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(249196);
      return;
    }
    AppMethodBeat.o(249196);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(249194);
    f localf = this.uRi;
    if (localf == null) {
      p.btv("livePostHelper");
    }
    localf.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(249194);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(249192);
    paramBundle = getArguments();
    Object localObject2;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getByteArray("nearby_live_go_to_square_pge_params_key");
      if (paramBundle != null)
      {
        paramBundle = new axj().parseFrom(paramBundle);
        if (paramBundle == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
          AppMethodBeat.o(249192);
          throw paramBundle;
        }
        paramBundle = (axj)paramBundle;
        this.uRG = paramBundle;
        localObject2 = new StringBuilder("onCreate targetTabInfo=");
        paramBundle = this.uRG;
        if (paramBundle == null) {
          break label334;
        }
        paramBundle = Integer.valueOf(paramBundle.LHQ);
        label102:
        localObject2 = ((StringBuilder)localObject2).append(paramBundle).append('-');
        axj localaxj = this.uRG;
        paramBundle = (Bundle)localObject1;
        if (localaxj != null) {
          paramBundle = localaxj.LHR;
        }
        Log.i("NearbyLiveSquareUIC", paramBundle);
        this.tOh.alive();
        this.uRi = new f((Activity)getActivity());
        paramBundle = getFragment();
        if (paramBundle == null) {
          p.hyc();
        }
        ((FinderViewPager)paramBundle.getView().findViewById(2131309856)).setEnableViewPagerScroll(true);
        this.dbG = true;
        paramBundle = a.PRN;
        paramBundle = getFragment();
        if (paramBundle == null) {
          p.hyc();
        }
        paramBundle = ((FinderReporterUIC)a.of(paramBundle).get(FinderReporterUIC.class)).sGQ;
        if (paramBundle != null) {
          break label362;
        }
        paramBundle = "";
      }
    }
    label334:
    label362:
    for (;;)
    {
      localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).eiv();
      p.g(localObject1, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
      if (((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject1).ctM() > 0) {}
      for (localObject1 = "1001-" + cl.aWA();; localObject1 = "1003-" + cl.aWA())
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(paramBundle);
        com.tencent.mm.plugin.expt.hellhound.core.b.aoV((String)localObject1);
        localObject2 = d.uTq;
        d.gO(paramBundle, (String)localObject1);
        AppMethodBeat.o(249192);
        return;
        paramBundle = null;
        break;
        paramBundle = null;
        break label102;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249193);
    super.onDestroy();
    this.tOh.dead();
    AppMethodBeat.o(249193);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(249195);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    f localf = this.uRi;
    if (localf == null) {
      p.btv("livePostHelper");
    }
    localf.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(249195);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$addFragments$1$1"})
  static final class b
    implements Runnable
  {
    b(FinderViewPager paramFinderViewPager, NearbyLiveSquareUIC paramNearbyLiveSquareUIC) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(249188);
      Object localObject1 = jdField_this.getFragment();
      if (localObject1 == null) {
        p.hyc();
      }
      if (((Fragment)localObject1).getView() == null)
      {
        Log.i("NearbyLiveSquareUIC", "addFragments after post view is null");
        AppMethodBeat.o(249188);
        return;
      }
      localObject1 = jdField_this.getFragment();
      if (localObject1 == null) {
        p.hyc();
      }
      if (((Fragment)localObject1).isDetached())
      {
        Log.i("NearbyLiveSquareUIC", "addFragments after fragment detached");
        AppMethodBeat.o(249188);
        return;
      }
      axj localaxj1 = NearbyLiveSquareUIC.a(jdField_this);
      if (localaxj1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("addFragments go to target page:targetTabInfo=");
        localObject1 = NearbyLiveSquareUIC.a(jdField_this);
        if (localObject1 != null) {}
        for (localObject1 = Integer.valueOf(((axj)localObject1).LHQ);; localObject1 = null)
        {
          localStringBuilder = localStringBuilder.append(localObject1).append('-');
          axj localaxj2 = NearbyLiveSquareUIC.a(jdField_this);
          localObject1 = localObject2;
          if (localaxj2 != null) {
            localObject1 = localaxj2.LHR;
          }
          Log.i("NearbyLiveSquareUIC", (String)localObject1);
          jdField_this.JB(localaxj1.LHQ);
          NearbyLiveSquareUIC.b(jdField_this).onPageSelected(NearbyLiveSquareUIC.b(jdField_this, localaxj1.LHQ));
          AppMethodBeat.o(249188);
          return;
        }
      }
      localObject1 = a.PRN;
      localObject1 = jdField_this.getFragment();
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = a.of((Fragment)localObject1).get(NearbyLiveSquareTabLayoutUIC.class);
      p.g(localObject1, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
      ((NearbyLiveSquareTabLayoutUIC)localObject1).Jx(0);
      NearbyLiveSquareUIC.b(jdField_this).onPageSelected(0);
      AppMethodBeat.o(249188);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<if>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.nearby.base.b
  {
    d(MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(249191);
      Log.i("Finder.FragmentChangeObserver", "onFragmentChange from:" + paramInt1 + " to:" + paramInt2);
      Object localObject = k.vkd;
      k.a(null, s.p.voA, "94", com.tencent.mm.plugin.finder.report.live.c.vjf, paramInt3, paramInt4);
      NearbyLiveSquareUIC.c(this.uRM, paramInt2);
      localObject = a.PRN;
      localObject = this.uRM.getFragment();
      if (localObject == null) {
        p.hyc();
      }
      localObject = a.of((Fragment)localObject).get(NearbyLiveSquareTabLayoutUIC.class);
      p.g(localObject, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
      ((NearbyLiveSquareTabLayoutUIC)localObject).Jx(paramInt2);
      AppMethodBeat.o(249191);
    }
    
    public final void a(AbsNearByFragment paramAbsNearByFragment)
    {
      AppMethodBeat.i(249190);
      p.h(paramAbsNearByFragment, "fragment");
      AppMethodBeat.o(249190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareUIC
 * JD-Core Version:    0.7.0.1
 */