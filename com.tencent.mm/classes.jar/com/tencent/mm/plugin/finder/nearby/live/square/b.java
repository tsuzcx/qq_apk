package com.tencent.mm.plugin.finder.nearby.live.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.base.c;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.utils.bp;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabFragment;", "getFragments", "()Ljava/util/LinkedList;", "isCreated", "", "isForceNightMode", "lastIndex", "", "livePostHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby;", "liveSearchHelper", "Lcom/tencent/mm/plugin/finder/nearby/live/search/FinderLiveSearchHelper;", "liveTabLists", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "targetObjectId", "", "targetObjectNonceId", "", "targetTabInfo", "viewPager", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "adapteNightMode", "", "addFragments", "", "fragmentList", "getActiveFragment", "getCurrentTabId", "getCurrentTabIndex", "getFragmentByIndex", "index", "getIndex", "tabId", "getLayoutId", "getNextFragment", "handleSearchItemClick", "initSearchItem", "jumpToNextFragment", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMenuClick", "onPause", "onPreDestroyed", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setCurrentTabId", "args", "withAnim", "setCurrentTabIndex", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public static final a ELD;
  private boolean ALp;
  private FinderViewPager BsX;
  private com.tencent.mm.plugin.finder.nearby.live.search.a ELE;
  com.tencent.mm.plugin.finder.live.ui.livepost.b ELF;
  private bnn ELG;
  private long ELH;
  private String ELI;
  public final LinkedList<NearbyLiveSquareTabFragment> ELJ;
  private final LinkedList<bnn> ELK;
  private final b ELL;
  private boolean feX;
  private int lastIndex;
  private final IListener<jr> qmO;
  
  static
  {
    AppMethodBeat.i(341291);
    ELD = new a((byte)0);
    AppMethodBeat.o(341291);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(341200);
    this.ELH = -1L;
    this.ELI = "";
    this.lastIndex = -1;
    this.ELJ = new LinkedList();
    this.ELK = new LinkedList();
    this.ELL = new b(this, getActivity(), this.ELJ);
    this.qmO = ((IListener)new NearbyLiveSquareUIC.eventListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(341200);
  }
  
  public b(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(341188);
    this.ELH = -1L;
    this.ELI = "";
    this.lastIndex = -1;
    this.ELJ = new LinkedList();
    this.ELK = new LinkedList();
    this.ELL = new b(this, getActivity(), this.ELJ);
    this.qmO = ((IListener)new NearbyLiveSquareUIC.eventListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(341188);
  }
  
  private final int Ni(int paramInt)
  {
    AppMethodBeat.i(341240);
    Iterator localIterator = ((List)this.ELK).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((bnn)localIterator.next()).ZVZ == paramInt)
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
      Log.e("NearbyLiveSquareUIC", "[getIndex] tabId=" + paramInt + " is invalid.");
      AppMethodBeat.o(341240);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(341240);
    return i;
  }
  
  private final NearbyLiveSquareTabFragment QM(int paramInt)
  {
    AppMethodBeat.i(341249);
    if ((paramInt < 0) || (paramInt >= this.ELJ.size()) || (this.ELJ.size() == 0))
    {
      AppMethodBeat.o(341249);
      return null;
    }
    NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = (NearbyLiveSquareTabFragment)this.ELJ.get(paramInt);
    AppMethodBeat.o(341249);
    return localNearbyLiveSquareTabFragment;
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(341255);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.eFB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341255);
  }
  
  private static final void a(b paramb, ViewPager paramViewPager)
  {
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    AppMethodBeat.i(341279);
    s.u(paramb, "this$0");
    s.u(paramViewPager, "$this_apply");
    paramViewPager = paramb.getFragment();
    s.checkNotNull(paramViewPager);
    if (paramViewPager.getView() == null)
    {
      Log.i("NearbyLiveSquareUIC", "addFragments after post view is null");
      AppMethodBeat.o(341279);
      return;
    }
    paramViewPager = paramb.getFragment();
    s.checkNotNull(paramViewPager);
    if (paramViewPager.isDetached())
    {
      Log.i("NearbyLiveSquareUIC", "addFragments after fragment detached");
      AppMethodBeat.o(341279);
      return;
    }
    bnn localbnn = paramb.ELG;
    if (localbnn == null)
    {
      paramViewPager = localStringBuilder;
      if (paramViewPager == null)
      {
        paramViewPager = k.aeZF;
        paramViewPager = paramb.getFragment();
        s.checkNotNull(paramViewPager);
        paramViewPager = k.y(paramViewPager).q(com.tencent.mm.plugin.finder.nearby.live.square.tab.b.class);
        s.s(paramViewPager, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
        ((com.tencent.mm.plugin.finder.nearby.live.square.tab.b)paramViewPager).Qw(0);
        paramb.ELL.onPageSelected(0);
      }
      AppMethodBeat.o(341279);
      return;
    }
    localStringBuilder = new StringBuilder("addFragments go to target page:targetTabInfo=");
    paramViewPager = paramb.ELG;
    if (paramViewPager == null)
    {
      paramViewPager = null;
      label179:
      localStringBuilder = localStringBuilder.append(paramViewPager).append('-');
      paramViewPager = paramb.ELG;
      if (paramViewPager != null) {
        break label257;
      }
    }
    label257:
    for (paramViewPager = localObject;; paramViewPager = paramViewPager.ZWa)
    {
      Log.i("NearbyLiveSquareUIC", paramViewPager);
      paramb.QL(localbnn.ZVZ);
      paramb.ELL.onPageSelected(paramb.Ni(localbnn.ZVZ));
      paramViewPager = ah.aiuX;
      break;
      paramViewPager = Integer.valueOf(paramViewPager.ZVZ);
      break label179;
    }
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(341266);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.eFB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(341266);
  }
  
  private final void eFB()
  {
    AppMethodBeat.i(341215);
    Object localObject1 = k.aeZF;
    localObject1 = getFragment();
    s.checkNotNull(localObject1);
    Object localObject2 = ((as)k.y((Fragment)localObject1).q(as.class)).zIO;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_context_id", (String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    localIntent.putExtra("key_click_tab_context_id", com.tencent.mm.plugin.finder.nearby.live.report.a.eFv());
    localObject1 = eFC();
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localIntent.putExtra("key_click_sub_tab_context_id", (String)localObject1);
      localObject2 = this.ELE;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("liveSearchHelper");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.finder.nearby.live.search.a)localObject1).az(localIntent);
      AppMethodBeat.o(341215);
      return;
      localObject2 = ((NearbyLiveSquareTabFragment)localObject1).eEv();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public final void QL(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(341401);
    int j = Ni(paramInt);
    paramInt = i;
    if (j >= 0)
    {
      paramInt = i;
      if (j < this.ELJ.size()) {
        paramInt = 1;
      }
    }
    if (paramInt != 0)
    {
      FinderViewPager localFinderViewPager = this.BsX;
      if (localFinderViewPager != null) {
        localFinderViewPager.setCurrentItem(j);
      }
    }
    AppMethodBeat.o(341401);
  }
  
  public final NearbyLiveSquareTabFragment b(NearbyLiveSquareTabFragment paramNearbyLiveSquareTabFragment)
  {
    AppMethodBeat.i(341421);
    s.u(paramNearbyLiveSquareTabFragment, "fragment");
    Iterator localIterator = ((List)this.ELJ).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = (NearbyLiveSquareTabFragment)localIterator.next();
      if (paramNearbyLiveSquareTabFragment.EIq.ZVZ == localNearbyLiveSquareTabFragment.EIq.ZVZ)
      {
        j = 1;
        label70:
        if (j == 0) {
          break label95;
        }
      }
    }
    for (;;)
    {
      paramNearbyLiveSquareTabFragment = QM(i + 1);
      AppMethodBeat.o(341421);
      return paramNearbyLiveSquareTabFragment;
      j = 0;
      break label70;
      label95:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final NearbyLiveSquareTabFragment eFC()
  {
    AppMethodBeat.i(341413);
    Object localObject = getFragment();
    s.checkNotNull(localObject);
    if ((((Fragment)localObject).getView() != null) && (this.BsX != null))
    {
      localObject = this.BsX;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label74;
        }
      }
    }
    label74:
    for (int i = ((Integer)localObject).intValue();; i = this.lastIndex)
    {
      localObject = QM(i);
      AppMethodBeat.o(341413);
      return localObject;
      localObject = Integer.valueOf(((FinderViewPager)localObject).getCurrentItem());
      break;
    }
  }
  
  public final int getCurrentTabIndex()
  {
    int i = 0;
    AppMethodBeat.i(341406);
    Object localObject = eFC();
    if (localObject == null) {}
    for (;;)
    {
      i = Ni(i);
      AppMethodBeat.o(341406);
      return i;
      localObject = ((NearbyLiveSquareTabFragment)localObject).EIq;
      if (localObject != null) {
        i = ((bnn)localObject).ZVZ;
      }
    }
  }
  
  public final int getLayoutId()
  {
    return f.e.EHe;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(341374);
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb2 = this.ELF;
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("livePostHelper");
      localb1 = null;
    }
    localb1.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(341374);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    String str = null;
    AppMethodBeat.i(341346);
    paramBundle = getArguments();
    boolean bool;
    label48:
    label64:
    label115:
    label126:
    long l;
    label142:
    label160:
    label177:
    label205:
    label230:
    label372:
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("key_use_dark_style", 1) == 1))
    {
      bool = true;
      this.ALp = bool;
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label529;
      }
      paramBundle = null;
      this.BsX = paramBundle;
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label557;
      }
      paramBundle = null;
      if (!this.ALp) {
        break label582;
      }
      localObject1 = this.BsX;
      if (localObject1 != null) {
        ((FinderViewPager)localObject1).setBackgroundColor(getResources().getColor(f.a.Dark_0));
      }
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(f.a.Dark_0));
      }
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label626;
      }
      paramBundle = null;
      this.BsX = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label654;
      }
      paramBundle = null;
      this.ELG = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label714;
      }
      l = -1L;
      this.ELH = l;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label728;
      }
      paramBundle = "";
      this.ELI = paramBundle;
      localObject1 = new StringBuilder("onCreate targetTabInfo=");
      paramBundle = this.ELG;
      if (paramBundle != null) {
        break label753;
      }
      paramBundle = null;
      localObject1 = ((StringBuilder)localObject1).append(paramBundle).append('-');
      paramBundle = this.ELG;
      if (paramBundle != null) {
        break label764;
      }
      paramBundle = str;
      Log.i("NearbyLiveSquareUIC", paramBundle + " targetObjectId:" + this.ELH + " targetObjectNonceId:" + this.ELI);
      this.qmO.alive();
      this.ELF = new com.tencent.mm.plugin.finder.live.ui.livepost.b((Activity)getActivity());
      this.ELE = new com.tencent.mm.plugin.finder.nearby.live.search.a((Context)getActivity());
      paramBundle = this.BsX;
      if (paramBundle != null) {
        paramBundle.setEnableViewPagerScroll(true);
      }
      this.feX = true;
      paramBundle = k.aeZF;
      paramBundle = getFragment();
      s.checkNotNull(paramBundle);
      str = ((as)k.y(paramBundle).q(as.class)).zIO;
      if (str != null) {
        break label772;
      }
      str = "";
      paramBundle = s.X("1001-", Long.valueOf(cn.bDw()));
      localObject1 = getActivity().findViewById(f.d.search_item_root);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
          break label775;
        }
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener(new b..ExternalSyntheticLambda0(this));
      }
    }
    for (;;)
    {
      localObject1 = getActivity().findViewById(f.d.searchEntrance);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new b..ExternalSyntheticLambda1(this));
      }
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ(str);
      com.tencent.mm.plugin.expt.hellhound.core.b.aqY(paramBundle);
      localObject1 = g.ERj;
      g.hW(str, paramBundle);
      if (!(getFragment() instanceof NearbyLiveSquareFragment)) {
        break label905;
      }
      paramBundle = k.aeZF;
      paramBundle = getFragment();
      if (paramBundle != null) {
        break label785;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment");
      AppMethodBeat.o(341346);
      throw paramBundle;
      bool = false;
      break;
      label529:
      paramBundle = paramBundle.getView();
      if (paramBundle == null)
      {
        paramBundle = null;
        break label48;
      }
      paramBundle = (FinderViewPager)paramBundle.findViewById(f.d.viewPager);
      break label48;
      label557:
      paramBundle = paramBundle.getView();
      if (paramBundle == null)
      {
        paramBundle = null;
        break label64;
      }
      paramBundle = paramBundle.findViewById(f.d.EFH);
      break label64;
      label582:
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(f.a.BW_93));
      }
      paramBundle = this.BsX;
      if (paramBundle == null) {
        break label115;
      }
      paramBundle.setBackgroundColor(getResources().getColor(f.a.BW_100));
      break label115;
      label626:
      paramBundle = paramBundle.getView();
      if (paramBundle == null)
      {
        paramBundle = null;
        break label126;
      }
      paramBundle = (FinderViewPager)paramBundle.findViewById(f.d.viewPager);
      break label126;
      label654:
      paramBundle = paramBundle.getByteArray("nearby_live_target_square_page_params_key");
      if (paramBundle == null)
      {
        paramBundle = null;
        break label142;
      }
      paramBundle = new bnn().parseFrom(paramBundle);
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
        AppMethodBeat.o(341346);
        throw paramBundle;
      }
      paramBundle = (bnn)paramBundle;
      break label142;
      label714:
      l = paramBundle.getLong("nearby_live_target_object_id_params_key", -1L);
      break label160;
      label728:
      localObject1 = paramBundle.getString("nearby_live_target_nonce_id_params_key", "");
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {
        break label177;
      }
      paramBundle = "";
      break label177;
      label753:
      paramBundle = Integer.valueOf(paramBundle.ZVZ);
      break label205;
      label764:
      paramBundle = paramBundle.ZWa;
      break label230;
      label772:
      break label372;
      label775:
      ((View)localObject1).setVisibility(8);
    }
    label785:
    Object localObject1 = ((as)k.y((Fragment)paramBundle).q(as.class)).zIB;
    if (localObject1 == null)
    {
      localObject1 = "";
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label868;
      }
      paramBundle = "";
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
      localObject2 = getFragment();
      if (localObject2 != null) {
        break label889;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment");
      AppMethodBeat.o(341346);
      throw paramBundle;
      break;
      label868:
      paramBundle = paramBundle.getString("key_by_pass");
      if (paramBundle == null) {
        paramBundle = "";
      }
    }
    label889:
    com.tencent.mm.plugin.finder.nearby.live.report.a.a(str, (AbsNearByFragment)localObject2, (String)localObject1, paramBundle);
    label905:
    AppMethodBeat.o(341346);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(341356);
    super.onPause();
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb2 = this.ELF;
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("livePostHelper");
      localb1 = null;
    }
    localb1.reset();
    AppMethodBeat.o(341356);
  }
  
  public final void onPreDestroyed()
  {
    int j = 0;
    AppMethodBeat.i(341368);
    super.onPreDestroyed();
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.base.b.EJG;
    com.tencent.mm.plugin.finder.nearby.live.base.b.reset();
    localObject = com.tencent.mm.plugin.finder.nearby.d.EFs;
    int i;
    if (this.feX)
    {
      localObject = eFC();
      if (localObject != null)
      {
        localObject = ((NearbyLiveSquareTabFragment)localObject).EIq;
        if (localObject != null)
        {
          i = ((bnn)localObject).ZVZ;
          localObject = getFragment();
          if (localObject != null) {
            break label93;
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.nearby.d.hU(i, j);
      localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
      com.tencent.mm.plugin.finder.nearby.live.report.a.reset();
      this.qmO.dead();
      AppMethodBeat.o(341368);
      return;
      i = 0;
      break;
      label93:
      k localk = k.aeZF;
      j = ((as)k.y((Fragment)localObject).q(as.class)).AJo;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(341382);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb = this.ELF;
    Object localObject = localb;
    if (localb == null)
    {
      s.bIx("livePostHelper");
      localObject = null;
    }
    ((com.tencent.mm.plugin.finder.live.ui.livepost.b)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    localObject = eFC();
    if (localObject != null) {
      ((NearbyLiveSquareTabFragment)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(341382);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(341429);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
    if (com.tencent.mm.plugin.finder.live.fluent.a.ejm())
    {
      localObject = this.BsX;
      if (localObject != null) {
        ((FinderViewPager)localObject).setNeedInterceptFitWindow(true);
      }
    }
    AppMethodBeat.o(341429);
  }
  
  public final void x(List<? extends bnn> paramList, List<NearbyLiveSquareTabFragment> paramList1)
  {
    AppMethodBeat.i(341397);
    s.u(paramList, "liveTabLists");
    s.u(paramList1, "fragmentList");
    this.ELK.addAll((Collection)paramList);
    this.ELJ.addAll((Collection)paramList1);
    paramList = getFragment();
    if (paramList == null) {
      paramList = null;
    }
    for (;;)
    {
      if (paramList != null)
      {
        paramList1 = getFragment();
        s.checkNotNull(paramList1);
        paramList1 = paramList1.getChildFragmentManager();
        s.s(paramList1, "fragment!!.childFragmentManager");
        paramList.setAdapter((androidx.viewpager.widget.a)new c(paramList1, (List)this.ELJ));
        paramList.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.ELL);
        paramList.setOffscreenPageLimit(2);
        paramList.post(new b..ExternalSyntheticLambda2(this, paramList));
        paramList1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eTt().bmg()).intValue();
        if (i > 0)
        {
          paramList1 = bp.Gmq;
          bp.a(paramList.getContext(), paramList, i);
        }
      }
      if (paramList != null)
      {
        paramList = paramList.getAdapter();
        if (paramList != null) {
          paramList.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(341397);
      return;
      paramList = paramList.getView();
      if (paramList == null) {
        paramList = null;
      } else {
        paramList = (ViewPager)paramList.findViewById(f.d.viewPager);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.mm.plugin.finder.nearby.base.b
  {
    b(b paramb, AppCompatActivity paramAppCompatActivity, LinkedList<NearbyLiveSquareTabFragment> paramLinkedList)
    {
      super((List)paramLinkedList);
      AppMethodBeat.i(341099);
      AppMethodBeat.o(341099);
    }
    
    public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(341124);
      Log.i("Finder.FragmentChangeObserver", "onFragmentChange from:" + paramInt1 + " to:" + paramInt2);
      if ((paramInt1 != -1) && (paramInt1 != paramInt2))
      {
        Log.i("Finder.FragmentChangeObserver", "onFragmentChange hit onPageScrolled scroll change.");
        localObject = k.aeZF;
        localObject = this.ELM.getFragment();
        s.checkNotNull(localObject);
        ((com.tencent.mm.plugin.finder.nearby.live.square.page.a)k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.page.a.class)).ELU.cancel();
        h.baE().ban().set(at.a.adep, Boolean.FALSE);
        localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
        com.tencent.mm.plugin.finder.nearby.live.report.a.QK(3);
      }
      Object localObject = j.Dob;
      j.a(null, q.w.DwP, "94", com.tencent.mm.plugin.finder.live.report.d.Dnf, paramInt3, paramInt4);
      b.b(this.ELM, paramInt2);
      localObject = k.aeZF;
      localObject = this.ELM.getFragment();
      s.checkNotNull(localObject);
      localObject = k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.tab.b.class);
      s.s(localObject, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
      ((com.tencent.mm.plugin.finder.nearby.live.square.tab.b)localObject).Qw(paramInt2);
      AppMethodBeat.o(341124);
    }
    
    public final void a(AbsNearByFragment paramAbsNearByFragment)
    {
      AppMethodBeat.i(341115);
      s.u(paramAbsNearByFragment, "fragment");
      AppMethodBeat.o(341115);
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.b
 * JD-Core Version:    0.7.0.1
 */