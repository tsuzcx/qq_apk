package com.tencent.mm.plugin.finder.nearby;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.if;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.person.NearbyPersonFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFragment;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isOpenNearbyLiveFriends", "lastIndex", "", "getActiveFragment", "getCurrentTabType", "getIndex", "type", "getLayoutId", "hasExtStatusFlag", "flag", "", "hasPluginFlag", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder_release"})
public final class NearbyHomeUIC
  extends UIComponent
{
  public static final a uQg;
  private boolean dbG;
  final ArrayList<AbsNearByFragment> fragments;
  private int lastIndex;
  private final IListener<if> tOh;
  private boolean uQe;
  private final c uQf;
  
  static
  {
    AppMethodBeat.i(249009);
    uQg = new a((byte)0);
    AppMethodBeat.o(249009);
  }
  
  public NearbyHomeUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(249008);
    boolean bool;
    if ((z.aUl() & 0x200) == 0L)
    {
      bool = true;
      this.uQe = bool;
      if (!this.uQe) {
        break label150;
      }
    }
    label150:
    for (ArrayList localArrayList = j.ac(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveSquareFragment(), (AbsNearByFragment)new NearbyPersonFragment() });; localArrayList = j.ac(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveSquareFragment() }))
    {
      this.fragments = localArrayList;
      this.lastIndex = -1;
      this.uQf = new c(this, paramAppCompatActivity, (MMActivity)paramAppCompatActivity, (List)this.fragments);
      this.tOh = ((IListener)new b(this));
      AppMethodBeat.o(249008);
      return;
      bool = false;
      break;
    }
  }
  
  private final int getIndex(int paramInt)
  {
    AppMethodBeat.i(249004);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((AbsNearByFragment)localIterator.next()).dLS == paramInt)
      {
        j = 1;
        label50:
        if (j == 0) {
          break label96;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label108;
      }
      Log.e("Finder.HomeUIC", "[getIndex] type=" + paramInt + " is invalid.");
      AppMethodBeat.o(249004);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(249004);
    return i;
  }
  
  public final void Jz(int paramInt)
  {
    AppMethodBeat.i(249003);
    paramInt = getIndex(paramInt);
    Log.i("NearbyHomeUIC", "setCurrentTabIndex size:" + this.fragments.size() + " index:" + paramInt + " args:" + null);
    int i = this.fragments.size();
    if (paramInt < 0)
    {
      AppMethodBeat.o(249003);
      return;
    }
    if (i > paramInt)
    {
      FinderViewPager localFinderViewPager = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856);
      p.g(localFinderViewPager, "activity.viewPager");
      localFinderViewPager.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(249003);
  }
  
  public final AbsNearByFragment dlj()
  {
    AppMethodBeat.i(249005);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856);
    if (localObject == null) {
      Log.e("NearbyHomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem(); (i < 0) || (i >= this.fragments.size()) || (this.fragments.size() == 0); i = this.lastIndex)
    {
      AppMethodBeat.o(249005);
      return null;
    }
    localObject = (AbsNearByFragment)this.fragments.get(i);
    AppMethodBeat.o(249005);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return 2131495821;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249001);
    paramBundle = a.uQd;
    final int i = a.dlh();
    Log.i("NearbyHomeUIC", "[onCreate] targetTabType=".concat(String.valueOf(i)));
    this.tOh.alive();
    paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856);
    paramBundle.setEnableViewPagerScroll(true);
    p.g(paramBundle, "this");
    Object localObject = getActivity().getSupportFragmentManager();
    p.g(localObject, "activity.supportFragmentManager");
    paramBundle.setAdapter((q)new com.tencent.mm.plugin.finder.nearby.base.c((android.support.v4.app.g)localObject, (List)this.fragments));
    paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.uQf);
    paramBundle.setOffscreenPageLimit(3);
    paramBundle.post((Runnable)new d(this, i));
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    int j = ((Number)com.tencent.mm.plugin.finder.storage.c.dtL().value()).intValue();
    if (j > 0)
    {
      localObject = an.waE;
      an.a(paramBundle.getContext(), (FinderViewPager)((FragmentActivity)getActivity()).findViewById(2131309856), j);
    }
    this.dbG = true;
    Jz(i);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderReporterUIC.class)).sGQ;
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiv();
      p.g(localObject, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
      if (((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject).ctM() > 0) {}
      for (localObject = "1001-" + cl.aWA();; localObject = "1003-" + cl.aWA())
      {
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).checkLastLiveObject();
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(paramBundle);
        com.tencent.mm.plugin.expt.hellhound.core.b.aoV((String)localObject);
        d locald = d.uTq;
        d.gO(paramBundle, (String)localObject);
        paramBundle = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        paramBundle = ((PluginFinder)paramBundle).getRedDotManager();
        localObject = paramBundle.asX("NearbyEntrance");
        if ((localObject != null) && (((com.tencent.mm.plugin.finder.extension.reddot.k)localObject).atl("NearbyEntrance") != null) && (((com.tencent.mm.plugin.finder.extension.reddot.k)localObject).field_ctrInfo.type == 16)) {
          paramBundle.b((com.tencent.mm.plugin.finder.extension.reddot.k)localObject);
        }
        paramBundle.asV("NearbyEntrance");
        AppMethodBeat.o(249001);
        return;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249002);
    super.onDestroy();
    this.tOh.dead();
    Object localObject = a.uQd;
    int i;
    if (this.dbG)
    {
      localObject = dlj();
      if (localObject != null) {
        i = ((AbsNearByFragment)localObject).dLS;
      }
    }
    for (;;)
    {
      a.Jy(i);
      localObject = com.tencent.mm.plugin.finder.extension.reddot.l.tLu;
      com.tencent.mm.plugin.finder.extension.reddot.l.dbR();
      Log.i("NearbyHomeUIC", "onDestroy fragments:" + this.fragments);
      AppMethodBeat.o(249002);
      return;
      i = 1001;
      continue;
      localObject = a.uQd;
      i = a.dlh();
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249006);
    super.onPause();
    Log.i("NearbyHomeUIC", "onPause()");
    AbsNearByFragment localAbsNearByFragment = dlj();
    if (!(localAbsNearByFragment instanceof NearbyLiveSquareFragment))
    {
      d locald = d.uTq;
      d.c(localAbsNearByFragment);
    }
    AppMethodBeat.o(249006);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249007);
    super.onResume();
    Log.i("NearbyHomeUIC", "onResume()");
    Object localObject = d.uTq;
    d.dlB();
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)getContext());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      i.a locala = i.tLi;
      i.a.b(1, (bbn)localObject);
      locala = i.tLi;
      i.a.a(1, (bbn)localObject, 0);
      locala = i.tLi;
      i.a.c(1, (bbn)localObject);
      AppMethodBeat.o(249007);
      return;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<if>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.nearby.base.b
  {
    c(AppCompatActivity paramAppCompatActivity, MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(248999);
      Log.i("Finder.FragmentChangeObserver", "onFragmentChange from:" + paramInt1 + " to:" + paramInt2);
      Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.a(null, s.p.voA, "94", com.tencent.mm.plugin.finder.report.live.c.vjf, paramInt3, paramInt4);
      NearbyHomeUIC.b(this.uQh, paramInt2);
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(NearbyActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((NearbyActionBarUIC)localObject).Jx(paramInt2);
      AppMethodBeat.o(248999);
    }
    
    public final void a(AbsNearByFragment paramAbsNearByFragment)
    {
      AppMethodBeat.i(248998);
      p.h(paramAbsNearByFragment, "fragment");
      AppMethodBeat.o(248998);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$onCreate$1$1"})
  static final class d
    implements Runnable
  {
    d(NearbyHomeUIC paramNearbyHomeUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(249000);
      Object localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = com.tencent.mm.ui.component.a.b(this.uQh.getActivity()).get(NearbyActionBarUIC.class);
      p.g(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((NearbyActionBarUIC)localObject).Jx(NearbyHomeUIC.a(this.uQh, i));
      NearbyHomeUIC.a(this.uQh).onPageSelected(NearbyHomeUIC.a(this.uQh, i));
      AppMethodBeat.o(249000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.NearbyHomeUIC
 * JD-Core Version:    0.7.0.1
 */