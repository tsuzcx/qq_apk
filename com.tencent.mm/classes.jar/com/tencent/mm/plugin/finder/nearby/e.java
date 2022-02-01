package com.tencent.mm.plugin.finder.nearby;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.extension.reddot.m;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.localcity.NearbyLiveLocalCityFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.nearbylivefriends.NearbyLiveFriendsSquareFragment;
import com.tencent.mm.plugin.finder.nearby.person.NearbyPersonFragment;
import com.tencent.mm.plugin.finder.nearby.video.NearbyVideoFragment;
import com.tencent.mm.plugin.finder.utils.ay;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "getFragments", "()Ljava/util/ArrayList;", "isCreated", "", "isOpenNearbyLiveFriends", "lastIndex", "", "backToLiveTab", "", "getActiveFragment", "getCurrentTabType", "getFragmentsInternal", "getIndex", "type", "getLayoutId", "hasExtStatusFlag", "flag", "", "hasPluginFlag", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "prepareLiveSquare", "setCurrentTabType", "args", "withAnim", "Companion", "plugin-finder-nearby_release"})
public final class e
  extends UIComponent
{
  public static final a zCN;
  private boolean dfI;
  final ArrayList<AbsNearByFragment> fragments;
  private int lastIndex;
  private final IListener<iu> xyI;
  private boolean zCL;
  private final c zCM;
  
  static
  {
    AppMethodBeat.i(201315);
    zCN = new a((byte)0);
    AppMethodBeat.o(201315);
  }
  
  public e(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(201312);
    boolean bool;
    Object localObject;
    if ((z.bdn() & 0x200) == 0L)
    {
      bool = true;
      this.zCL = bool;
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
        break label197;
      }
      if (!this.zCL) {
        break label160;
      }
      localObject = j.ag(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveLocalCityFragment(), (AbsNearByFragment)new NearbyPersonFragment() });
    }
    for (;;)
    {
      this.fragments = ((ArrayList)localObject);
      this.lastIndex = 1;
      this.zCM = new c(this, paramAppCompatActivity, (MMActivity)paramAppCompatActivity, (List)this.fragments);
      this.xyI = ((IListener)new b(this));
      AppMethodBeat.o(201312);
      return;
      bool = false;
      break;
      label160:
      localObject = j.ag(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveLocalCityFragment() });
      continue;
      label197:
      if (this.zCL) {
        localObject = j.ag(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveFriendsSquareFragment(), (AbsNearByFragment)new NearbyPersonFragment() });
      } else {
        localObject = j.ag(new AbsNearByFragment[] { (AbsNearByFragment)new NearbyVideoFragment(), (AbsNearByFragment)new NearbyLiveFriendsSquareFragment() });
      }
    }
  }
  
  private final int Me(int paramInt)
  {
    AppMethodBeat.i(201284);
    Iterator localIterator = ((List)this.fragments).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((AbsNearByFragment)localIterator.next()).fEH == paramInt)
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
      AppMethodBeat.o(201284);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(201284);
    return i;
  }
  
  public final void On(int paramInt)
  {
    AppMethodBeat.i(201277);
    paramInt = Me(paramInt);
    Log.i("NearbyHomeUIC", "setCurrentTabIndex size:" + this.fragments.size() + " index:" + paramInt + " args:" + null);
    int i = this.fragments.size();
    if (paramInt < 0)
    {
      AppMethodBeat.o(201277);
      return;
    }
    if (i > paramInt)
    {
      FinderViewPager localFinderViewPager = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(f.d.viewPager);
      p.j(localFinderViewPager, "activity.viewPager");
      localFinderViewPager.setCurrentItem(paramInt);
    }
    AppMethodBeat.o(201277);
  }
  
  public final void dLm()
  {
    AppMethodBeat.i(201269);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      On(1006);
      AppMethodBeat.o(201269);
      return;
    }
    On(1001);
    AppMethodBeat.o(201269);
  }
  
  public final AbsNearByFragment dLn()
  {
    AppMethodBeat.i(201290);
    Object localObject = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(f.d.viewPager);
    if (localObject == null) {
      Log.e("NearbyHomeUIC", "[getActiveFragment] viewPager==null lastIndex=" + this.lastIndex);
    }
    if (localObject != null) {}
    for (int i = ((FinderViewPager)localObject).getCurrentItem(); (i < 0) || (i >= this.fragments.size()) || (this.fragments.size() == 0); i = this.lastIndex)
    {
      AppMethodBeat.o(201290);
      return null;
    }
    localObject = (AbsNearByFragment)this.fragments.get(i);
    AppMethodBeat.o(201290);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return f.e.zDf;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201265);
    paramBundle = d.zCK;
    final int i = d.dLk();
    Log.i("NearbyHomeUIC", "[onCreate] targetTabType=".concat(String.valueOf(i)));
    paramBundle = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
    com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("nearbyHomeOnCreate");
    paramBundle = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
    com.tencent.mm.plugin.finder.nearby.trace.c.dMD().fuR = getActivity().hashCode();
    this.xyI.alive();
    paramBundle = (FinderViewPager)((FragmentActivity)getActivity()).findViewById(f.d.viewPager);
    paramBundle.setEnableViewPagerScroll(true);
    p.j(paramBundle, "this");
    Object localObject = getActivity().getSupportFragmentManager();
    p.j(localObject, "activity.supportFragmentManager");
    paramBundle.setAdapter((androidx.viewpager.widget.a)new com.tencent.mm.plugin.finder.nearby.base.c((androidx.fragment.app.e)localObject, (List)this.fragments));
    paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.zCM);
    paramBundle.setOffscreenPageLimit(3);
    paramBundle.post((Runnable)new d(this, i));
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    int j = ((Number)com.tencent.mm.plugin.finder.storage.d.dUU().aSr()).intValue();
    if (j > 0)
    {
      localObject = ay.AJC;
      ay.a(paramBundle.getContext(), (FinderViewPager)((FragmentActivity)getActivity()).findViewById(f.d.viewPager), j);
    }
    paramBundle = g.Xox;
    paramBundle = ((aj)g.b(getActivity()).i(aj.class)).wmL;
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      localObject = d.zCK;
      localObject = d.dLl();
      ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).checkLastLiveObject((Context)getActivity(), null);
      com.tencent.mm.plugin.expt.hellhound.core.b.awV(paramBundle);
      com.tencent.mm.plugin.expt.hellhound.core.b.awU((String)localObject);
      com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
      com.tencent.mm.plugin.finder.nearby.report.e.hf(paramBundle, (String)localObject);
      this.dfI = true;
      On(i);
      paramBundle = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
        Log.w("NearbyHomeUIC", "prepareLiveSquare not NearbyLiveSquareFragment");
      }
      for (;;)
      {
        paramBundle = h.ag(PluginFinder.class);
        p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramBundle).getRedDotManager().aBd("NearbyEntrance");
        AppMethodBeat.o(201265);
        return;
        if (!(this.fragments.get(1) instanceof NearbyLiveSquareFragment))
        {
          Log.w("NearbyHomeUIC", "prepareLiveSquare return for !is NearbyLiveSquareFragment");
        }
        else
        {
          paramBundle = this.fragments.get(1);
          if (paramBundle == null)
          {
            paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment");
            AppMethodBeat.o(201265);
            throw paramBundle;
          }
          ((NearbyLiveSquareFragment)paramBundle).ar((Activity)getActivity());
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201266);
    super.onDestroy();
    this.xyI.dead();
    Object localObject = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
    com.tencent.mm.plugin.finder.nearby.preload.a.release();
    localObject = d.zCK;
    int i;
    if (this.dfI)
    {
      localObject = dLn();
      if (localObject != null) {
        i = ((AbsNearByFragment)localObject).fEH;
      }
    }
    for (;;)
    {
      d.Ol(i);
      localObject = m.xuU;
      m.dsd();
      localObject = com.tencent.mm.plugin.finder.nearby.live.base.b.zET;
      com.tencent.mm.plugin.finder.nearby.live.base.b.reset();
      Log.i("NearbyHomeUIC", "onDestroy fragments:" + this.fragments);
      AppMethodBeat.o(201266);
      return;
      i = 1001;
      continue;
      localObject = d.zCK;
      i = d.dLk();
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(201294);
    super.onPause();
    Log.i("NearbyHomeUIC", "onPause()");
    AbsNearByFragment localAbsNearByFragment = dLn();
    if (!(localAbsNearByFragment instanceof NearbyLiveSquareFragment))
    {
      com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
      com.tencent.mm.plugin.finder.nearby.report.e.e(localAbsNearByFragment);
    }
    AppMethodBeat.o(201294);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201301);
    super.onResume();
    Log.i("NearbyHomeUIC", "onResume()");
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.dMA();
    localObject1 = com.tencent.mm.plugin.finder.nearby.trace.c.zJD;
    com.tencent.mm.plugin.finder.nearby.trace.c.dMD().aGV("nearbyHomeOnResume");
    localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)getContext());
    if (localObject1 != null) {}
    for (localObject1 = ((aj)localObject1).ekY();; localObject1 = null)
    {
      Object localObject2 = i.xuG;
      i.a.b(1, (bid)localObject1);
      localObject2 = i.xuG;
      localObject2 = dLn();
      if (localObject2 != null)
      {
        String str = ((AbsNearByFragment)localObject2).dLv();
        localObject2 = str;
        if (str != null) {}
      }
      else
      {
        localObject2 = "";
      }
      i.a.a(1, (bid)localObject1, 0, (String)localObject2);
      localObject2 = i.xuG;
      i.a.c(1, (bid)localObject1);
      AppMethodBeat.o(201301);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder-nearby_release"})
  public static final class b
    extends IListener<iu>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder-nearby_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.nearby.base.b
  {
    c(AppCompatActivity paramAppCompatActivity, MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(202892);
      Log.i("Finder.FragmentChangeObserver", "onFragmentChange from:" + paramInt1 + " to:" + paramInt2);
      Object localObject = k.yBj;
      k.a(null, s.t.yGN, "94", com.tencent.mm.plugin.finder.live.report.c.yAi, paramInt3, paramInt4);
      e.b(this.zCO, paramInt2);
      localObject = g.Xox;
      localObject = g.b(paramAppCompatActivity).i(c.class);
      p.j(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((c)localObject).Ok(paramInt2);
      AppMethodBeat.o(202892);
    }
    
    public final void a(AbsNearByFragment paramAbsNearByFragment)
    {
      AppMethodBeat.i(202887);
      p.k(paramAbsNearByFragment, "fragment");
      AppMethodBeat.o(202887);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/nearby/NearbyHomeUIC$onCreate$1$1"})
  static final class d
    implements Runnable
  {
    d(e parame, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(202075);
      Object localObject = g.Xox;
      localObject = g.b(this.zCO.getActivity()).i(c.class);
      p.j(localObject, "UICProvider.of(activity)…ActionBarUIC::class.java)");
      ((c)localObject).Ok(e.a(this.zCO, i));
      e.a(this.zCO).onPageSelected(e.a(this.zCO, i));
      AppMethodBeat.o(202075);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.e
 * JD-Core Version:    0.7.0.1
 */