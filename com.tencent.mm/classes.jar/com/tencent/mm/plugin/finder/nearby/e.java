package com.tencent.mm.plugin.finder.nearby;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.jr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.m;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.extension.reddot.q;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.localcity.NearbyLiveLocalCityFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.nearbylivefriends.NearbyLiveFriendsSquareFragment;
import com.tencent.mm.plugin.finder.nearby.person.NearbyPersonFragment;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFragment;
import com.tencent.mm.plugin.finder.utils.bp;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isOpenNearbyLiveFriends", "lastIndex", "", "backToLiveTab", "", "checkShowTeensTip", "from", "to", "getActiveFragment", "getCurrentTabType", "getFragmentsInternal", "getIndex", "type", "getLayoutId", "hasExtStatusFlag", "flag", "", "hasPluginFlag", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "prepareLiveSquare", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  public static final a EFx;
  private boolean EFy;
  private final b EFz;
  private boolean feX;
  final ArrayList<AbsNearByFragment> fragments;
  private int lastIndex;
  private final IListener<jr> qmO;
  
  static
  {
    AppMethodBeat.i(339642);
    EFx = new a((byte)0);
    AppMethodBeat.o(339642);
  }
  
  public e(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(339607);
    boolean bool;
    Object localObject;
    if ((z.bBf() & 0x200) == 0L)
    {
      bool = true;
      this.EFy = bool;
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
        break label193;
      }
      if (!this.EFy) {
        break label156;
      }
      localObject = p.al(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveLocalCityFragment(), (AbsNearByFragment)new NearbyPersonFragment() });
    }
    for (;;)
    {
      this.fragments = ((ArrayList)localObject);
      this.lastIndex = 1;
      this.EFz = new b(this, paramAppCompatActivity, this.fragments);
      this.qmO = ((IListener)new NearbyHomeUIC.eventListener.1(this, f.hfK));
      AppMethodBeat.o(339607);
      return;
      bool = false;
      break;
      label156:
      localObject = p.al(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveLocalCityFragment() });
      continue;
      label193:
      if (this.EFy) {
        localObject = p.al(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveFriendsSquareFragment(), (AbsNearByFragment)new NearbyPersonFragment() });
      } else {
        localObject = p.al(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveFriendsSquareFragment() });
      }
    }
  }
  
  private final int Ni(int paramInt)
  {
    AppMethodBeat.i(339617);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((AbsNearByFragment)localIterator.next()).hJx == paramInt)
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
      AppMethodBeat.o(339617);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(339617);
    return i;
  }
  
  private static final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(339623);
    s.u(parame, "this$0");
    Object localObject = k.aeZF;
    localObject = k.d(parame.getActivity()).q(c.class);
    s.s(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
    ((c)localObject).Qw(parame.Ni(paramInt));
    parame.EFz.onPageSelected(parame.Ni(paramInt));
    AppMethodBeat.o(339623);
  }
  
  public final void Qz(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(339703);
    int j = Ni(paramInt);
    Log.i("NearbyHomeUIC", "setCurrentTabIndex size:" + this.fragments.size() + " index:" + j + " args:" + null);
    paramInt = i;
    if (j >= 0)
    {
      paramInt = i;
      if (j < this.fragments.size()) {
        paramInt = 1;
      }
    }
    if (paramInt != 0) {
      ((FinderViewPager)getActivity().findViewById(f.d.viewPager)).setCurrentItem(j);
    }
    AppMethodBeat.o(339703);
  }
  
  public final void eEf()
  {
    AppMethodBeat.i(339695);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      Qz(1006);
      AppMethodBeat.o(339695);
      return;
    }
    Qz(1001);
    AppMethodBeat.o(339695);
  }
  
  public final AbsNearByFragment eEg()
  {
    AppMethodBeat.i(339709);
    Object localObject = (FinderViewPager)getActivity().findViewById(f.d.viewPager);
    if (localObject == null) {
      Log.e("NearbyHomeUIC", s.X("[getActiveFragment] viewPager==null lastIndex=", Integer.valueOf(this.lastIndex)));
    }
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label102;
      }
    }
    label102:
    for (int i = this.lastIndex;; i = ((Integer)localObject).intValue())
    {
      if ((i >= 0) && (i < this.fragments.size()) && (this.fragments.size() != 0)) {
        break label110;
      }
      AppMethodBeat.o(339709);
      return null;
      localObject = Integer.valueOf(((FinderViewPager)localObject).getCurrentItem());
      break;
    }
    label110:
    localObject = (AbsNearByFragment)this.fragments.get(i);
    AppMethodBeat.o(339709);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return f.e.EGM;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(339685);
    paramBundle = d.EFs;
    int i = d.eEc();
    Log.i("NearbyHomeUIC", s.X("[onCreate] targetTabType=", Integer.valueOf(i)));
    paramBundle = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
    com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("nearbyHomeOnCreate");
    paramBundle = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
    com.tencent.mm.plugin.finder.nearby.trace.c.eGR().hzl = getActivity().hashCode();
    this.qmO.alive();
    paramBundle = (FinderViewPager)getActivity().findViewById(f.d.viewPager);
    paramBundle.setEnableViewPagerScroll(true);
    Object localObject = getActivity().getSupportFragmentManager();
    s.s(localObject, "activity.supportFragmentManager");
    paramBundle.setAdapter((androidx.viewpager.widget.a)new com.tencent.mm.plugin.finder.nearby.base.c((FragmentManager)localObject, (List)this.fragments));
    paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.EFz);
    paramBundle.setOffscreenPageLimit(3);
    paramBundle.post(new e..ExternalSyntheticLambda0(this, i));
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int j = ((Number)com.tencent.mm.plugin.finder.storage.d.eTt().bmg()).intValue();
    if (j > 0)
    {
      localObject = bp.Gmq;
      bp.a(paramBundle.getContext(), (ViewPager)getActivity().findViewById(f.d.viewPager), j);
    }
    paramBundle = k.aeZF;
    paramBundle = ((as)k.d(getActivity()).q(as.class)).zIO;
    if (paramBundle == null)
    {
      paramBundle = "";
      localObject = d.EFs;
      localObject = d.eEd();
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).checkLastLiveObject((Context)getActivity(), null);
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(paramBundle);
      com.tencent.mm.plugin.expt.hellhound.core.b.aqY((String)localObject);
      g localg = g.ERj;
      g.hW(paramBundle, (String)localObject);
      this.feX = true;
      Qz(i);
      paramBundle = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
        break label355;
      }
      Log.w("NearbyHomeUIC", "prepareLiveSquare not NearbyLiveSquareFragment");
    }
    for (;;)
    {
      paramBundle = q.ASF;
      q.eaX();
      ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("NearbyEntrance");
      AppMethodBeat.o(339685);
      return;
      break;
      label355:
      if (!(this.fragments.get(1) instanceof NearbyLiveSquareFragment))
      {
        Log.w("NearbyHomeUIC", "prepareLiveSquare return for !is NearbyLiveSquareFragment");
      }
      else
      {
        ((NearbyLiveSquareFragment)this.fragments.get(1)).aG((Activity)getActivity());
        paramBundle = k.aeZF;
        ((b)k.d(getActivity()).q(b.class)).eEa();
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(339691);
    super.onDestroy();
    this.qmO.dead();
    Object localObject = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
    com.tencent.mm.plugin.finder.nearby.preload.a.release();
    localObject = d.EFs;
    int i;
    if (this.feX)
    {
      localObject = eEg();
      if (localObject == null) {
        i = 1001;
      }
    }
    for (;;)
    {
      d.Qy(i);
      localObject = q.ASF;
      q.eaW();
      localObject = com.tencent.mm.plugin.finder.nearby.live.base.b.EJG;
      com.tencent.mm.plugin.finder.nearby.live.base.b.reset();
      Log.i("NearbyHomeUIC", s.X("onDestroy fragments:", this.fragments));
      AppMethodBeat.o(339691);
      return;
      i = ((AbsNearByFragment)localObject).hJx;
      continue;
      localObject = d.EFs;
      i = d.eEc();
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(339716);
    super.onPause();
    Log.i("NearbyHomeUIC", "onPause()");
    AbsNearByFragment localAbsNearByFragment = eEg();
    if (!(localAbsNearByFragment instanceof NearbyLiveSquareFragment))
    {
      g localg = g.ERj;
      g.e(localAbsNearByFragment);
    }
    AppMethodBeat.o(339716);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(339727);
    super.onResume();
    Log.i("NearbyHomeUIC", "onResume()");
    Object localObject = g.ERj;
    g.eGN();
    localObject = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
    com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("nearbyHomeOnResume");
    localObject = as.GSQ;
    localObject = as.a.hu((Context)getContext());
    bui localbui;
    if (localObject == null)
    {
      localbui = null;
      localObject = m.ASi;
      m.a.b(1, localbui);
      localObject = m.ASi;
      localObject = eEg();
      if (localObject != null) {
        break label117;
      }
      localObject = "";
    }
    for (;;)
    {
      m.a.a(1, localbui, 0, (String)localObject);
      localObject = m.ASi;
      m.a.c(1, localbui);
      AppMethodBeat.o(339727);
      return;
      localbui = ((as)localObject).fou();
      break;
      label117:
      String str = ((AbsNearByFragment)localObject).eEt();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.finder.nearby.base.b
  {
    b(e parame, AppCompatActivity paramAppCompatActivity, ArrayList<AbsNearByFragment> paramArrayList)
    {
      super((List)paramArrayList);
      AppMethodBeat.i(339659);
      AppMethodBeat.o(339659);
    }
    
    public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(339671);
      Log.i("Finder.FragmentChangeObserver", "onFragmentChange from:" + paramInt1 + " to:" + paramInt2);
      Object localObject = j.Dob;
      j.a(null, q.w.DwP, "94", com.tencent.mm.plugin.finder.live.report.d.Dnf, paramInt3, paramInt4);
      e.b(this.EFA, paramInt2);
      localObject = k.aeZF;
      localObject = k.d(paramAppCompatActivity).q(c.class);
      s.s(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((c)localObject).Qw(paramInt2);
      e.a(this.EFA, paramInt1, paramInt2);
      AppMethodBeat.o(339671);
    }
    
    public final void a(AbsNearByFragment paramAbsNearByFragment)
    {
      AppMethodBeat.i(339664);
      s.u(paramAbsNearByFragment, "fragment");
      AppMethodBeat.o(339664);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.e
 * JD-Core Version:    0.7.0.1
 */