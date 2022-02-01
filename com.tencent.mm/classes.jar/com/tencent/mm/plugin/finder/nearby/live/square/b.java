package com.tencent.mm.plugin.finder.nearby.live.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.iu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.utils.au;
import com.tencent.mm.plugin.finder.utils.ay;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "(Lcom/tencent/mm/ui/MMFragmentActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "fragmentChangeObserver", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1;", "fragments", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/page/NearbyLiveSquareTabFragment;", "getFragments", "()Ljava/util/LinkedList;", "isCreated", "", "isForceNightMode", "lastIndex", "", "livePostHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby;", "liveSearchHelper", "Lcom/tencent/mm/plugin/finder/nearby/live/search/FinderLiveSearchHelper;", "liveTabLists", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "targetObjectId", "", "targetObjectNonceId", "", "targetTabInfo", "viewPager", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "adapteNightMode", "", "addFragments", "", "fragmentList", "getActiveFragment", "getCurrentTabId", "getIndex", "tabId", "getLayoutId", "handleSearchItemClick", "initSearchItem", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMenuClick", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setCurrentTabId", "args", "withAnim", "setCurrentTabIndex", "index", "Companion", "plugin-finder-nearby_release"})
public final class b
  extends UIComponent
{
  public static final a zGn;
  private boolean dfI;
  private int lastIndex;
  private FinderViewPager xTD;
  private boolean xnL;
  private final IListener<iu> xyI;
  private com.tencent.mm.plugin.finder.nearby.live.search.a zGf;
  com.tencent.mm.plugin.finder.live.ui.livepost.b zGg;
  private bcz zGh;
  private long zGi;
  private String zGj;
  private final LinkedList<NearbyLiveSquareTabFragment> zGk;
  private final LinkedList<bcz> zGl;
  private final d zGm;
  
  static
  {
    AppMethodBeat.i(200532);
    zGn = new a((byte)0);
    AppMethodBeat.o(200532);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200530);
    this.zGi = -1L;
    this.zGj = "";
    this.lastIndex = -1;
    this.zGk = new LinkedList();
    this.zGl = new LinkedList();
    paramFragment = getActivity();
    if (paramFragment == null)
    {
      paramFragment = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(200530);
      throw paramFragment;
    }
    this.zGm = new d(this, (MMActivity)paramFragment, (List)this.zGk);
    this.xyI = ((IListener)new c(this));
    AppMethodBeat.o(200530);
  }
  
  public b(MMFragmentActivity paramMMFragmentActivity)
  {
    super((AppCompatActivity)paramMMFragmentActivity);
    AppMethodBeat.i(200528);
    this.zGi = -1L;
    this.zGj = "";
    this.lastIndex = -1;
    this.zGk = new LinkedList();
    this.zGl = new LinkedList();
    paramMMFragmentActivity = getActivity();
    if (paramMMFragmentActivity == null)
    {
      paramMMFragmentActivity = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(200528);
      throw paramMMFragmentActivity;
    }
    this.zGm = new d(this, (MMActivity)paramMMFragmentActivity, (List)this.zGk);
    this.xyI = ((IListener)new c(this));
    AppMethodBeat.o(200528);
  }
  
  private final int Me(int paramInt)
  {
    AppMethodBeat.i(200521);
    Iterator localIterator = ((List)this.zGl).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((bcz)localIterator.next()).SOa == paramInt)
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
      AppMethodBeat.o(200521);
      return 0;
      j = 0;
      break label50;
      label96:
      i += 1;
      break;
      i = -1;
    }
    label108:
    AppMethodBeat.o(200521);
    return i;
  }
  
  public final void Ot(int paramInt)
  {
    AppMethodBeat.i(200513);
    paramInt = Me(paramInt);
    int i = this.zGk.size();
    if (paramInt < 0)
    {
      AppMethodBeat.o(200513);
      return;
    }
    if (i > paramInt)
    {
      FinderViewPager localFinderViewPager = this.xTD;
      if (localFinderViewPager != null)
      {
        localFinderViewPager.setCurrentItem(paramInt);
        AppMethodBeat.o(200513);
        return;
      }
    }
    AppMethodBeat.o(200513);
  }
  
  public final NearbyLiveSquareTabFragment dMe()
  {
    AppMethodBeat.i(200525);
    Object localObject = getFragment();
    if (localObject == null) {
      p.iCn();
    }
    if ((((Fragment)localObject).getView() != null) && (this.xTD != null))
    {
      localObject = this.xTD;
      if (localObject == null) {}
    }
    for (int i = ((FinderViewPager)localObject).getCurrentItem(); (i < 0) || (i >= this.zGk.size()) || (this.zGk.size() == 0); i = this.lastIndex)
    {
      AppMethodBeat.o(200525);
      return null;
    }
    localObject = (NearbyLiveSquareTabFragment)this.zGk.get(i);
    AppMethodBeat.o(200525);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return f.e.zDl;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200500);
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb = this.zGg;
    if (localb == null) {
      p.bGy("livePostHelper");
    }
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    if (paramIntent != null) {}
    for (Object localObject1 = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", precheckResult:");
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = Integer.valueOf(paramIntent.getIntExtra("PRECHECK_RESULT", 0));
      }
      Log.i("Finder.FinderLivePostForNearby", localObject1);
      if (paramInt1 != 10000) {
        break label180;
      }
      if (paramInt2 != -1) {
        break label213;
      }
      if (paramIntent == null) {
        break;
      }
      if (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) != 1) {
        break label213;
      }
      localb.dvx();
      AppMethodBeat.o(200500);
      return;
    }
    AppMethodBeat.o(200500);
    return;
    label180:
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      if (paramIntent == null) {
        break label220;
      }
      if (paramIntent.getIntExtra("PRECHECK_RESULT", 0) == 1) {
        localb.dvx();
      }
    }
    label213:
    AppMethodBeat.o(200500);
    return;
    label220:
    AppMethodBeat.o(200500);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(200480);
    paramBundle = getArguments();
    boolean bool;
    label66:
    label97:
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("key_use_dark_style", 1) == 1))
    {
      bool = true;
      this.xnL = bool;
      paramBundle = getFragment();
      if (paramBundle == null) {
        break label243;
      }
      paramBundle = paramBundle.getView();
      if (paramBundle == null) {
        break label243;
      }
      paramBundle = (FinderViewPager)paramBundle.findViewById(f.d.viewPager);
      this.xTD = paramBundle;
      paramBundle = getFragment();
      if (paramBundle == null) {
        break label248;
      }
      paramBundle = paramBundle.getView();
      if (paramBundle == null) {
        break label248;
      }
      paramBundle = paramBundle.findViewById(f.d.zCU);
      if (!this.xnL) {
        break label253;
      }
      localObject2 = this.xTD;
      if (localObject2 != null) {
        ((FinderViewPager)localObject2).setBackgroundColor(getResources().getColor(f.a.Dark_0));
      }
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(f.a.Dark_0));
      }
      label148:
      paramBundle = getFragment();
      if (paramBundle == null) {
        break label297;
      }
      paramBundle = paramBundle.getView();
      if (paramBundle == null) {
        break label297;
      }
    }
    label297:
    for (paramBundle = (FinderViewPager)paramBundle.findViewById(f.d.viewPager);; paramBundle = null)
    {
      this.xTD = paramBundle;
      paramBundle = getArguments();
      if (paramBundle == null) {
        break label798;
      }
      paramBundle = paramBundle.getByteArray("nearby_live_target_square_page_params_key");
      if (paramBundle == null) {
        break label798;
      }
      paramBundle = new bcz().parseFrom(paramBundle);
      if (paramBundle != null) {
        break label302;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
      AppMethodBeat.o(200480);
      throw paramBundle;
      bool = false;
      break;
      label243:
      paramBundle = null;
      break label66;
      label248:
      paramBundle = null;
      break label97;
      label253:
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(f.a.BW_93));
      }
      paramBundle = this.xTD;
      if (paramBundle == null) {
        break label148;
      }
      paramBundle.setBackgroundColor(getResources().getColor(f.a.BW_100));
      break label148;
    }
    label302:
    paramBundle = (bcz)paramBundle;
    this.zGh = paramBundle;
    paramBundle = getArguments();
    long l;
    label332:
    Object localObject3;
    if (paramBundle != null)
    {
      l = paramBundle.getLong("nearby_live_target_object_id_params_key", -1L);
      this.zGi = l;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        localObject2 = paramBundle.getString("nearby_live_target_nonce_id_params_key", "");
        paramBundle = (Bundle)localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        paramBundle = "";
      }
      this.zGj = paramBundle;
      localObject2 = new StringBuilder("onCreate targetTabInfo=");
      paramBundle = this.zGh;
      if (paramBundle == null) {
        break label810;
      }
      paramBundle = Integer.valueOf(paramBundle.SOa);
      label402:
      localObject2 = ((StringBuilder)localObject2).append(paramBundle).append('-');
      localObject3 = this.zGh;
      paramBundle = (Bundle)localObject1;
      if (localObject3 != null) {
        paramBundle = ((bcz)localObject3).SOb;
      }
      Log.i("NearbyLiveSquareUIC", paramBundle + ' ' + "targetObjectId:" + this.zGi + " targetObjectNonceId:" + this.zGj);
      this.xyI.alive();
      this.zGg = new com.tencent.mm.plugin.finder.live.ui.livepost.b((Activity)getActivity());
      this.zGf = new com.tencent.mm.plugin.finder.nearby.live.search.a((Context)getActivity());
      paramBundle = this.xTD;
      if (paramBundle != null) {
        paramBundle.setEnableViewPagerScroll(true);
      }
      this.dfI = true;
      paramBundle = com.tencent.mm.ui.component.g.Xox;
      paramBundle = getFragment();
      if (paramBundle == null) {
        p.iCn();
      }
      paramBundle = ((aj)com.tencent.mm.ui.component.g.h(paramBundle).i(aj.class)).wmL;
      if (paramBundle != null) {
        break label942;
      }
      paramBundle = "";
    }
    label650:
    label798:
    label810:
    label942:
    for (;;)
    {
      localObject1 = h.ae(n.class);
      p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((n)localObject1).eSb();
      p.j(localObject1, "MMKernel.service(IMessen…ass.java).lbsVerifyMsgStg");
      if (((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject1).cHo() > 0)
      {
        localObject1 = "1001-" + cm.bfE();
        localObject2 = getActivity().findViewById(f.d.search_item_root);
        if (localObject2 != null)
        {
          localObject3 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
          if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
            break label839;
          }
          ((View)localObject2).setVisibility(0);
          ((View)localObject2).setOnClickListener((View.OnClickListener)new e(this));
        }
      }
      for (;;)
      {
        localObject2 = getActivity().findViewById(f.d.searchEntrance);
        if (localObject2 != null) {
          ((View)localObject2).setOnClickListener((View.OnClickListener)new f(this));
        }
        com.tencent.mm.plugin.expt.hellhound.core.b.awV(paramBundle);
        com.tencent.mm.plugin.expt.hellhound.core.b.awU((String)localObject1);
        localObject2 = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
        com.tencent.mm.plugin.finder.nearby.report.e.hf(paramBundle, (String)localObject1);
        if (!(getFragment() instanceof NearbyLiveSquareFragment)) {
          break label932;
        }
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        localObject1 = getFragment();
        if (localObject1 != null) {
          break label849;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment");
        AppMethodBeat.o(200480);
        throw paramBundle;
        paramBundle = null;
        break;
        l = -1L;
        break label332;
        paramBundle = null;
        break label402;
        localObject1 = "1003-" + cm.bfE();
        break label650;
        label839:
        ((View)localObject2).setVisibility(8);
      }
      label849:
      localObject1 = ((aj)com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(aj.class)).wmz;
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
        localObject2 = getFragment();
        if (localObject2 == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment");
          AppMethodBeat.o(200480);
          throw paramBundle;
        }
        com.tencent.mm.plugin.finder.nearby.live.report.a.a(paramBundle, (AbsNearByFragment)localObject2, (String)localObject1);
        AppMethodBeat.o(200480);
        return;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200490);
    super.onDestroy();
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.base.b.zET;
    com.tencent.mm.plugin.finder.nearby.live.base.b.reset();
    localObject = com.tencent.mm.plugin.finder.nearby.d.zCK;
    if (this.dfI)
    {
      localObject = dMe();
      if (localObject != null)
      {
        localObject = ((NearbyLiveSquareTabFragment)localObject).zDU;
        if (localObject == null) {}
      }
    }
    for (int i = ((bcz)localObject).SOa;; i = 0)
    {
      com.tencent.mm.plugin.finder.nearby.d.Om(i);
      localObject = com.tencent.mm.plugin.finder.nearby.live.report.a.zGc;
      com.tencent.mm.plugin.finder.nearby.live.report.a.reset();
      this.xyI.dead();
      AppMethodBeat.o(200490);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200486);
    super.onPause();
    com.tencent.mm.plugin.finder.live.ui.livepost.b localb = this.zGg;
    if (localb == null) {
      p.bGy("livePostHelper");
    }
    if (localb != null)
    {
      Log.i("Finder.FinderLivePostForNearby", "reset()");
      localb.xPE = false;
      au localau = localb.xPA;
      if (localau != null) {
        localau.AJi = 0;
      }
      if (localb.yOo != null)
      {
        Log.i("CreateFinderNoticeHelper", "reset()");
        AppMethodBeat.o(200486);
        throw null;
      }
      AppMethodBeat.o(200486);
      return;
    }
    AppMethodBeat.o(200486);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(200503);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    Object localObject = this.zGg;
    if (localObject == null) {
      p.bGy("livePostHelper");
    }
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    int i;
    if ((paramInt == 16) || (paramInt == 80))
    {
      if (paramArrayOfInt.length != 0) {
        break label125;
      }
      i = 1;
      if (i != 0) {
        break label131;
      }
      i = j;
      label83:
      if ((i == 0) || (paramArrayOfInt[0] != 0)) {
        break label137;
      }
      ((com.tencent.mm.plugin.finder.live.ui.livepost.b)localObject).dvx();
    }
    for (;;)
    {
      localObject = dMe();
      if (localObject == null) {
        break label169;
      }
      ((NearbyLiveSquareTabFragment)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(200503);
      return;
      label125:
      i = 0;
      break;
      label131:
      i = 0;
      break label83;
      label137:
      Log.i("Finder.FinderLivePostForNearby", "FinderLive request permission " + paramInt + " failed");
    }
    label169:
    AppMethodBeat.o(200503);
  }
  
  public final void p(List<? extends bcz> paramList, final List<NearbyLiveSquareTabFragment> paramList1)
  {
    AppMethodBeat.i(200511);
    p.k(paramList, "liveTabLists");
    p.k(paramList1, "fragmentList");
    this.zGl.addAll((Collection)paramList);
    this.zGk.addAll((Collection)paramList1);
    paramList1 = new aa.f();
    paramList = getFragment();
    if (paramList != null)
    {
      paramList = paramList.getView();
      if (paramList == null) {}
    }
    for (paramList = (ViewPager)paramList.findViewById(f.d.viewPager);; paramList = null)
    {
      paramList1.aaBC = paramList;
      paramList = (ViewPager)paramList1.aaBC;
      if (paramList != null)
      {
        Object localObject = getFragment();
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((Fragment)localObject).getChildFragmentManager();
        p.j(localObject, "fragment!!.childFragmentManager");
        paramList.setAdapter((androidx.viewpager.widget.a)new com.tencent.mm.plugin.finder.nearby.base.c((androidx.fragment.app.e)localObject, (List)this.zGk));
        paramList.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.zGm);
        paramList.setOffscreenPageLimit(2);
        paramList.post((Runnable)new b(paramList, this, paramList1));
        localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
        int i = ((Number)com.tencent.mm.plugin.finder.storage.d.dUU().aSr()).intValue();
        if (i > 0)
        {
          localObject = ay.AJC;
          ay.a(paramList.getContext(), (ViewPager)paramList1.aaBC, i);
        }
      }
      paramList = (ViewPager)paramList1.aaBC;
      if (paramList == null) {
        break;
      }
      paramList = paramList.getAdapter();
      if (paramList == null) {
        break;
      }
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(200511);
      return;
    }
    AppMethodBeat.o(200511);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$addFragments$1$1"})
  static final class b
    implements Runnable
  {
    b(ViewPager paramViewPager, b paramb, aa.f paramf) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(203521);
      Object localObject1 = jdField_this.getFragment();
      if (localObject1 == null) {
        p.iCn();
      }
      if (((Fragment)localObject1).getView() == null)
      {
        Log.i("NearbyLiveSquareUIC", "addFragments after post view is null");
        AppMethodBeat.o(203521);
        return;
      }
      localObject1 = jdField_this.getFragment();
      if (localObject1 == null) {
        p.iCn();
      }
      if (((Fragment)localObject1).isDetached())
      {
        Log.i("NearbyLiveSquareUIC", "addFragments after fragment detached");
        AppMethodBeat.o(203521);
        return;
      }
      bcz localbcz1 = b.b(jdField_this);
      if (localbcz1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("addFragments go to target page:targetTabInfo=");
        localObject1 = b.b(jdField_this);
        if (localObject1 != null) {}
        for (localObject1 = Integer.valueOf(((bcz)localObject1).SOa);; localObject1 = null)
        {
          localStringBuilder = localStringBuilder.append(localObject1).append('-');
          bcz localbcz2 = b.b(jdField_this);
          localObject1 = localObject2;
          if (localbcz2 != null) {
            localObject1 = localbcz2.SOb;
          }
          Log.i("NearbyLiveSquareUIC", (String)localObject1);
          jdField_this.Ot(localbcz1.SOa);
          b.c(jdField_this).onPageSelected(b.b(jdField_this, localbcz1.SOa));
          AppMethodBeat.o(203521);
          return;
        }
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = jdField_this.getFragment();
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = com.tencent.mm.ui.component.g.h((Fragment)localObject1).i(com.tencent.mm.plugin.finder.nearby.live.square.tab.c.class);
      p.j(localObject1, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
      ((com.tencent.mm.plugin.finder.nearby.live.square.tab.c)localObject1).Ok(0);
      b.c(jdField_this).onPageSelected(0);
      AppMethodBeat.o(203521);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$eventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTabSelectedEvent;", "callback", "", "event", "plugin-finder-nearby_release"})
  public static final class c
    extends IListener<iu>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$fragmentChangeObserver$1", "Lcom/tencent/mm/plugin/finder/nearby/base/FragmentChangeObserver;", "onFragmentChange", "", "from", "", "to", "fromType", "toType", "onUserVisibleFragmentChange", "isUserVisibleFocused", "", "index", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "plugin-finder-nearby_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.nearby.base.b
  {
    d(MMActivity paramMMActivity, List paramList)
    {
      super(localList);
    }
    
    public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(199938);
      Log.i("Finder.FragmentChangeObserver", "onFragmentChange from:" + paramInt1 + " to:" + paramInt2);
      Object localObject = k.yBj;
      k.a(null, s.t.yGN, "94", com.tencent.mm.plugin.finder.live.report.c.yAi, paramInt3, paramInt4);
      b.c(this.zGp, paramInt2);
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = this.zGp.getFragment();
      if (localObject == null) {
        p.iCn();
      }
      localObject = com.tencent.mm.ui.component.g.h((Fragment)localObject).i(com.tencent.mm.plugin.finder.nearby.live.square.tab.c.class);
      p.j(localObject, "UICProvider.of(fragment!…TabLayoutUIC::class.java)");
      ((com.tencent.mm.plugin.finder.nearby.live.square.tab.c)localObject).Ok(paramInt2);
      AppMethodBeat.o(199938);
    }
    
    public final void a(AbsNearByFragment paramAbsNearByFragment)
    {
      AppMethodBeat.i(199928);
      p.k(paramAbsNearByFragment, "fragment");
      AppMethodBeat.o(199928);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$initSearchItem$1$1"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200587);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$initSearchItem$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.a(this.zGp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$initSearchItem$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200587);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201083);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$initSearchItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      b.a(this.zGp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareUIC$initSearchItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201083);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.b
 * JD-Core Version:    0.7.0.1
 */