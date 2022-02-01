package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.cp;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.m;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.c;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.g;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "allPageForceRefreshFlag", "", "byPass", "", "encryptedObjectId", "fetchTabListScene", "", "hasBuildTab", "isCurrentResume", "isForceNightMode", "isHideTabs", "liveTabLists", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "objectNonceId", "onUserVisibleFocused", "pageTitle", "squareTabFetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher;", "targetPageForceRefreshFlag", "targetTabId", "targetTabPageLastBuffer", "", "adapteViewBackGroundColor", "", "buildTab", "liveTabList", "", "checkIfHideTabs", "getActiveFragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "handleClickReport", "handleSearchItemClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleUnFocused", "registerRedDot", "setPageTitle", "title", "setTabIndex", "index", "findByTabId", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lcom/google/android/material/tabs/TabLayout;", "any", "", "findByTag", "Companion", "NearbyTab", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  public static final a EMj;
  private boolean ALp;
  private String AUV;
  private a EFl;
  private boolean EFm;
  private boolean EIU;
  private String ELy;
  private boolean EMk;
  private List<bnn> EMl;
  private int EMm;
  private boolean EMn;
  private byte[] EMo;
  private int EMp;
  private boolean EMq;
  private boolean EMr;
  private String objectNonceId;
  private String tgw;
  
  static
  {
    AppMethodBeat.i(341396);
    EMj = new a((byte)0);
    AppMethodBeat.o(341396);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(341294);
    this.EMl = ((List)new LinkedList());
    this.ELy = "";
    this.AUV = "";
    this.objectNonceId = "";
    this.tgw = "";
    AppMethodBeat.o(341294);
  }
  
  private static final void a(b paramb, View paramView)
  {
    int j = 0;
    AppMethodBeat.i(341339);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramView = k.aeZF;
    paramView = paramb.getFragment();
    kotlin.g.b.s.checkNotNull(paramView);
    localObject1 = ((as)k.y(paramView).q(as.class)).zIO;
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("key_context_id", paramView);
    paramView = com.tencent.mm.plugin.finder.nearby.live.report.a.ELu;
    ((Intent)localObject2).putExtra("key_click_tab_context_id", com.tencent.mm.plugin.finder.nearby.live.report.a.eFv());
    paramView = paramb.eEg();
    label195:
    int i;
    label215:
    label221:
    label233:
    label239:
    bui localbui;
    if (paramView == null)
    {
      paramView = "";
      ((Intent)localObject2).putExtra("key_click_sub_tab_context_id", paramView);
      new com.tencent.mm.plugin.finder.nearby.live.search.a((Context)paramb.getActivity()).az((Intent)localObject2);
      paramView = paramb.getFragment();
      if (paramView != null)
      {
        paramb = paramView.getView();
        if (paramb != null) {
          break label474;
        }
        paramb = null;
        paramb = (TabLayout)paramb;
        localObject1 = new com.tencent.mm.ad.i();
        if (paramb != null) {
          break label485;
        }
        i = 0;
        if (paramb != null) {
          break label493;
        }
        paramb = null;
        if (!(paramb instanceof b)) {
          break label516;
        }
        paramb = (b)paramb;
        if (paramb != null) {
          break label521;
        }
        i = j;
        ((com.tencent.mm.ad.i)localObject1).n("tab_id", Integer.valueOf(i));
        paramb = k.aeZF;
        localbui = ((as)k.y(paramView).q(as.class)).fou();
        localObject2 = new cp();
        ((cp)localObject2).ixo = Util.nowMilliSecond();
        ((cp)localObject2).lV("");
        ((cp)localObject2).lW("");
        ((cp)localObject2).lX("");
        ((cp)localObject2).lY("");
        paramView = c.dLD().dHN();
        paramb = paramView;
        if (paramView == null) {
          paramb = "";
        }
        ((cp)localObject2).lZ(paramb);
        if (localbui != null) {
          break label529;
        }
        paramb = "";
      }
    }
    for (;;)
    {
      ((cp)localObject2).ma(paramb);
      paramView = com.tencent.mm.plugin.expt.hellhound.a.dIJ();
      paramb = paramView;
      if (paramView == null) {
        paramb = "";
      }
      ((cp)localObject2).mb(paramb);
      ((cp)localObject2).mc("");
      ((cp)localObject2).md("");
      ((cp)localObject2).me("");
      ((cp)localObject2).mf("more_page_search");
      ((cp)localObject2).mg(((com.tencent.mm.ad.i)localObject1).toString());
      ((cp)localObject2).bMH();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(341339);
      return;
      localObject1 = paramView.eEv();
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramView = "";
      break;
      label474:
      paramb = paramb.findViewById(f.d.EGE);
      break label195;
      label485:
      i = paramb.getSelectedTabPosition();
      break label215;
      label493:
      paramb = paramb.js(i);
      if (paramb == null)
      {
        paramb = null;
        break label221;
      }
      paramb = paramb.tag;
      break label221;
      label516:
      paramb = null;
      break label233;
      label521:
      i = paramb.idY;
      break label239;
      label529:
      paramView = localbui.zIO;
      paramb = paramView;
      if (paramView == null) {
        paramb = "";
      }
    }
  }
  
  private static final void a(b paramb, TabLayout paramTabLayout, l.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(370462);
    kotlin.g.b.s.u(paramb, "this$0");
    Object localObject1 = parama.ASh;
    Object localObject4;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject4 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo.aabz;
      if (localObject4 != null)
      {
        localObject1 = new btx();
        localObject3 = (com.tencent.mm.bx.a)localObject1;
        localObject4 = ((com.tencent.mm.bx.b)localObject4).Op;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject4);
        k = ((btx)localObject1).aabK;
        kotlin.g.b.s.s(paramTabLayout, "tabLayout");
        localObject4 = Integer.valueOf(k);
        kotlin.g.b.s.u(paramTabLayout, "<this>");
        kotlin.g.b.s.u(localObject4, "any");
        m = paramTabLayout.getTabCount();
        if (m > 0)
        {
          i = 0;
          j = i + 1;
          localObject3 = paramTabLayout.js(i);
          if (localObject3 == null)
          {
            localObject1 = null;
            if (!(localObject1 instanceof b)) {
              continue;
            }
            localObject1 = ((TabLayout.e)localObject3).tag;
            if (localObject1 != null) {
              continue;
            }
            paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabLayoutUIC.NearbyTab");
            AppMethodBeat.o(370462);
            throw paramb;
          }
        }
      }
      catch (Exception localException)
      {
        int k;
        int m;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        continue;
        localObject1 = localException.tag;
        continue;
        i = ((b)localObject1).idY;
        StringBuilder localStringBuilder;
        if (!(localObject4 instanceof Integer))
        {
          if (j < m) {
            break label514;
          }
          paramTabLayout = null;
          if (paramTabLayout == null) {
            break label507;
          }
          localObject1 = paramTabLayout.tag;
          if (localObject1 == null) {
            break label507;
          }
          localStringBuilder = new StringBuilder("registerRedDot tabId:").append(k).append(" isShow=");
          if (parama == null)
          {
            paramTabLayout = null;
            localStringBuilder = localStringBuilder.append(paramTabLayout).append(" show_type=");
            if (parama != null) {
              continue;
            }
            paramTabLayout = localObject2;
            Log.i("NearbyLiveSquareTabLayoutUIC", paramTabLayout);
            if ((parama == null) || (parama.hBY != true)) {
              continue;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            paramTabLayout = ((b)localObject1).EFo;
            if (paramTabLayout != null) {
              paramTabLayout.setVisibility(0);
            }
            paramTabLayout = paramb.eEg();
            if (paramTabLayout != null) {
              continue;
            }
            paramTabLayout = "";
            parama = m.ASi;
            parama = k.aeZF;
            paramb = paramb.getFragment();
            kotlin.g.b.s.checkNotNull(paramb);
            m.a.a(1, ((as)k.y(paramb).q(as.class)).fou(), 0, paramTabLayout);
            AppMethodBeat.o(370462);
          }
        }
        else
        {
          if (i != ((Number)localObject4).intValue()) {
            continue;
          }
          paramTabLayout = localStringBuilder;
          continue;
        }
        paramTabLayout = Boolean.valueOf(parama.hBY);
        continue;
        localObject4 = parama.ASg;
        paramTabLayout = localObject2;
        if (localObject4 == null) {
          continue;
        }
        paramTabLayout = Integer.valueOf(((bxq)localObject4).show_type);
        continue;
        i = 0;
        continue;
        paramTabLayout = paramTabLayout.eEv();
        if (paramTabLayout == null)
        {
          paramTabLayout = "";
          continue;
        }
        continue;
        paramb = ((b)localObject1).EFo;
        if (paramb != null) {
          paramb.setVisibility(4);
        }
      }
      label507:
      AppMethodBeat.o(370462);
      return;
      label514:
      int i = j;
    }
  }
  
  private final AbsNearByFragment eEg()
  {
    AppMethodBeat.i(341308);
    if (getFragment() == null)
    {
      Log.w("NearbyLiveSquareTabLayoutUIC", "getActivityFragment return for fragment is null.");
      AppMethodBeat.o(341308);
      return null;
    }
    Object localObject = getFragment();
    kotlin.g.b.s.checkNotNull(localObject);
    if (((Fragment)localObject).getActivity() == null)
    {
      Log.w("NearbyLiveSquareTabLayoutUIC", "getActivityFragment return for activity is null.");
      AppMethodBeat.o(341308);
      return null;
    }
    localObject = k.aeZF;
    localObject = getFragment();
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = (AbsNearByFragment)((com.tencent.mm.plugin.finder.nearby.live.square.b)k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).eFC();
    AppMethodBeat.o(341308);
    return localObject;
  }
  
  private final void he(List<? extends bnn> paramList)
  {
    int i = 8;
    AppMethodBeat.i(341327);
    if (this.EMr)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", kotlin.g.b.s.X("buildTab hasBuildTab:", Boolean.valueOf(this.EMr)));
      AppMethodBeat.o(341327);
      return;
    }
    if (!this.EMq)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", kotlin.g.b.s.X("buildTab onUserVisibleFocused:", Boolean.valueOf(this.EMq)));
      AppMethodBeat.o(341327);
      return;
    }
    Object localObject1 = getFragment();
    kotlin.g.b.s.checkNotNull(localObject1);
    if (((Fragment)localObject1).isDetached())
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab after fragment detached");
      AppMethodBeat.o(341327);
      return;
    }
    localObject1 = getFragment();
    kotlin.g.b.s.checkNotNull(localObject1);
    if (((Fragment)localObject1).getView() == null)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab view is null");
      AppMethodBeat.o(341327);
      return;
    }
    if (paramList.isEmpty())
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", kotlin.g.b.s.X("buildTab liveTabList:", paramList));
      paramList = getFragment();
      kotlin.g.b.s.checkNotNull(paramList);
      paramList = paramList.getView();
      if (paramList == null)
      {
        paramList = null;
        ((FinderViewPager)paramList).setVisibility(8);
        paramList = getFragment();
        kotlin.g.b.s.checkNotNull(paramList);
        paramList = paramList.getView();
        if (paramList != null) {
          break label243;
        }
      }
      label243:
      for (paramList = null;; paramList = paramList.findViewById(f.d.EGD))
      {
        ((HardTouchableLayout)paramList).setVisibility(8);
        AppMethodBeat.o(341327);
        return;
        paramList = paramList.findViewById(f.d.viewPager);
        break;
      }
    }
    localObject1 = getFragment();
    kotlin.g.b.s.checkNotNull(localObject1);
    localObject1 = ((Fragment)localObject1).getView();
    if (localObject1 == null)
    {
      localObject1 = null;
      ((HardTouchableLayout)localObject1).setVisibility(0);
      localObject1 = getFragment();
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject1 = ((Fragment)localObject1).getView();
      if (localObject1 != null) {
        break label564;
      }
      localObject1 = null;
      label315:
      ((FinderViewPager)localObject1).setVisibility(0);
      sQ(this.EMk);
      localObject1 = getFragment();
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject1 = ((Fragment)localObject1).getView();
      if (localObject1 != null) {
        break label577;
      }
    }
    LinkedList localLinkedList;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label564:
    label577:
    for (localObject1 = null;; localObject1 = ((View)localObject1).findViewById(f.d.empty_tip_tv))
    {
      localObject1 = (TextView)localObject1;
      if (this.EMl.size() == 0) {
        i = 0;
      }
      ((TextView)localObject1).setVisibility(i);
      localObject1 = k.aeZF;
      localObject1 = getFragment();
      kotlin.g.b.s.checkNotNull(localObject1);
      localObject1 = ((as)k.y((Fragment)localObject1).q(as.class)).fou();
      localLinkedList = new LinkedList();
      localIterator = ((Iterable)paramList).iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label747;
      }
      localObject2 = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (bnn)localObject2;
      localObject3 = new Bundle();
      ((Bundle)localObject3).putByteArray("nearby_live_square_tab_info_key", ((bnn)localObject2).toByteArray());
      ((Bundle)localObject3).putInt("key_from_comment_scene", ((bui)localObject1).AJo);
      ((Bundle)localObject3).putString("key_click_tab_context_id", ((bui)localObject1).zIB);
      localObject4 = getFragment();
      if (localObject4 != null) {
        break label590;
      }
      paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
      AppMethodBeat.o(341327);
      throw paramList;
      localObject1 = ((View)localObject1).findViewById(f.d.EGD);
      break;
      localObject1 = ((View)localObject1).findViewById(f.d.viewPager);
      break label315;
    }
    label590:
    ((Bundle)localObject3).putString("key_click_tab_id", ((AbsNearByFragment)localObject4).eEt());
    if (this.ALp) {}
    for (int j = 1;; j = 0)
    {
      ((Bundle)localObject3).putInt("key_use_dark_style", j);
      ((Bundle)localObject3).putString("key_by_pass", this.ELy);
      ((Bundle)localObject3).putBoolean("nearby_live_target_auto_refresh_params_key", this.EMn);
      if (((this.EMm == 0) && (i == 0)) || (this.EMm == ((bnn)localObject2).ZVZ))
      {
        ((Bundle)localObject3).putBoolean("nearby_live_target_auto_refresh_params_key", this.EIU);
        ((Bundle)localObject3).putByteArray("nearby_live_target_last_buffer_params_key", this.EMo);
      }
      localObject4 = new NearbyLiveSquareTabFragment((bnn)localObject2, (byte)0);
      ((NearbyLiveSquareTabFragment)localObject4).setTitle(String.valueOf(((bnn)localObject2).ZWa));
      ((NearbyLiveSquareTabFragment)localObject4).setArguments((Bundle)localObject3);
      localLinkedList.add(localObject4);
      i += 1;
      break;
    }
    label747:
    localObject1 = getFragment();
    kotlin.g.b.s.checkNotNull(localObject1);
    localObject1 = ((Fragment)localObject1).getView();
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (TabLayout)localObject1;
      localIterator = ((Iterable)localLinkedList).iterator();
      i = 0;
      label794:
      if (!localIterator.hasNext()) {
        break label938;
      }
      localObject2 = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (NearbyLiveSquareTabFragment)localObject2;
      localObject3 = ((TabLayout)localObject1).WW();
      kotlin.g.b.s.s(localObject3, "tabLayout.newTab()");
      localObject3 = new b((TabLayout.e)localObject3, ((AbsNearByFragment)localObject2).hJx, this.ALp);
      ((b)localObject3).setTitle(((AbsNearByFragment)localObject2).title);
      ((b)localObject3).index = i;
      localObject2 = ((NearbyLiveSquareTabFragment)localObject2).EIq;
      if (localObject2 != null) {
        break label929;
      }
    }
    label929:
    for (j = 0;; j = ((bnn)localObject2).ZVZ)
    {
      ((b)localObject3).idY = j;
      ((TabLayout)localObject1).a(((b)localObject3).dyQ, false);
      i += 1;
      break label794;
      localObject1 = ((View)localObject1).findViewById(f.d.EGE);
      break;
    }
    label938:
    ((TabLayout)localObject1).a((TabLayout.b)new c(this));
    localObject1 = k.aeZF;
    localObject1 = getFragment();
    kotlin.g.b.s.checkNotNull(localObject1);
    ((com.tencent.mm.plugin.finder.nearby.live.square.b)k.y((Fragment)localObject1).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).x(paramList, (List)localLinkedList);
    this.EMr = true;
    AppMethodBeat.o(341327);
  }
  
  private final void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(341304);
    Log.i("NearbyLiveSquareTabLayoutUIC", kotlin.g.b.s.X("checkIfHideTabs isHideTabs:", Boolean.valueOf(paramBoolean)));
    Object localObject = getFragment();
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = ((Fragment)localObject).getView();
    if (localObject == null)
    {
      localObject = null;
      localObject = (HardTouchableLayout)localObject;
      if (!paramBoolean) {
        break label77;
      }
    }
    label77:
    for (int i = 8;; i = 0)
    {
      ((HardTouchableLayout)localObject).setVisibility(i);
      AppMethodBeat.o(341304);
      return;
      localObject = ((View)localObject).findViewById(f.d.EGD);
      break;
    }
  }
  
  public final void Qw(int paramInt)
  {
    AppMethodBeat.i(341441);
    Object localObject = getFragment();
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = ((Fragment)localObject).getView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(f.d.EGE))
    {
      localObject = (TabLayout)localObject;
      if (localObject != null)
      {
        localObject = ((TabLayout)localObject).js(paramInt);
        if ((localObject != null) && (!((TabLayout.e)localObject).isSelected())) {
          ((TabLayout.e)localObject).Xf();
        }
      }
      AppMethodBeat.o(341441);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    AppMethodBeat.i(341420);
    Fragment localFragment = getFragment();
    kotlin.g.b.s.checkNotNull(localFragment);
    paramBundle = getArguments();
    label63:
    label80:
    label97:
    label114:
    int i;
    label130:
    label214:
    label237:
    label249:
    Object localObject2;
    label289:
    label337:
    label348:
    label363:
    label379:
    View localView;
    if ((paramBundle != null) && (paramBundle.getInt("key_use_dark_style", 1) == 1))
    {
      bool1 = true;
      this.ALp = bool1;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label737;
      }
      paramBundle = "";
      this.ELy = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label760;
      }
      paramBundle = "";
      this.AUV = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label783;
      }
      paramBundle = "";
      this.objectNonceId = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label806;
      }
      paramBundle = "";
      this.tgw = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label829;
      }
      i = 0;
      this.EMp = i;
      Log.i("NearbyLiveSquareTabLayoutUIC", "onCreate isForceNightMode:" + this.ALp + " fetchTabListScene:" + this.EMp + " byPass:" + this.ELy);
      if (!this.ALp) {
        break label851;
      }
      paramBundle = getFragment();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getView();
        if (paramBundle != null) {
          break label840;
        }
        paramBundle = null;
        paramBundle = (ConstraintLayout)paramBundle;
        if (paramBundle != null) {
          paramBundle.setBackgroundColor(getResources().getColor(f.a.Dark_0));
        }
      }
      paramBundle = localFragment.getView();
      if (paramBundle != null) {
        break label908;
      }
      paramBundle = null;
      localObject2 = (WeImageView)paramBundle;
      if (localObject2 != null)
      {
        if (!((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isNewLiveEntranceEnable()) {
          break label930;
        }
        paramBundle = localFragment.getView();
        if (paramBundle != null) {
          break label919;
        }
        paramBundle = null;
        paramBundle = (TabLayout)paramBundle;
        if (paramBundle != null) {
          paramBundle.setPadding(0, 0, d.e((Context)getContext(), 36.0F), 0);
        }
        ((WeImageView)localObject2).setVisibility(0);
        ((WeImageView)localObject2).setOnClickListener(new b..ExternalSyntheticLambda0(this));
      }
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label940;
      }
      paramBundle = null;
      if (paramBundle != null) {
        break label1006;
      }
      i = ((Number)Integer.valueOf(0)).intValue();
      this.EMm = i;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label1014;
      }
      bool1 = false;
      this.EMn = bool1;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label1026;
      }
      bool1 = false;
      label395:
      this.EIU = bool1;
      paramBundle = getArguments();
      if (paramBundle != null) {
        break label1038;
      }
      paramBundle = null;
      label411:
      this.EMo = paramBundle;
      paramBundle = localFragment.getView();
      if (paramBundle != null) {
        break label1049;
      }
      paramBundle = null;
      label428:
      ((HardTouchableLayout)paramBundle).setOnSingleClickListener((HardTouchableLayout.g)new d(this));
      paramBundle = localFragment.getView();
      if (paramBundle != null) {
        break label1060;
      }
      paramBundle = null;
      label458:
      ((HardTouchableLayout)paramBundle).setOnDoubleClickListener((HardTouchableLayout.b)new b.e(this));
      if (localFragment != null) {
        break label1071;
      }
      paramBundle = null;
      label483:
      localObject2 = k.aeZF;
      kotlin.g.b.s.checkNotNull(localFragment);
      localObject2 = ((com.tencent.mm.plugin.finder.nearby.live.square.page.a)k.y(localFragment).q(com.tencent.mm.plugin.finder.nearby.live.square.page.a.class)).ELU;
      localView = localFragment.getView();
      if (localView != null) {
        break label1097;
      }
      label524:
      kotlin.g.b.s.s(localObject1, "fragment!!.viewPager");
      kotlin.g.b.s.u(localObject1, "targetView");
      ((com.tencent.mm.plugin.finder.nearby.guide.b)localObject2).rootView = paramBundle;
      ((com.tencent.mm.plugin.finder.nearby.guide.b)localObject2).nmf = ((View)localObject1);
      ((View)localObject1).getLocationOnScreen(((com.tencent.mm.plugin.finder.nearby.guide.b)localObject2).EHO);
      Log.i("FinderLivePageScrollGuideHelper", "setTargetView pos[" + localObject2.EHO[0] + ", " + localObject2.EHO[1] + "] targetView:" + localObject1);
      paramBundle = k.aeZF;
      paramBundle = ((as)k.y(localFragment).q(as.class)).fou();
      if (this.EFl == null) {
        this.EFl = new a((Context)getContext(), this.EMp, this.ELy, this.AUV, this.objectNonceId, this.tgw);
      }
      if (this.EMp != 0) {
        break label1110;
      }
    }
    label783:
    label806:
    label829:
    label840:
    label851:
    label1110:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject1 = this.EFl;
      if (localObject1 != null) {
        ((a)localObject1).a(paramBundle, false, bool1, (kotlin.g.a.s)new f(this));
      }
      AppMethodBeat.o(341420);
      return;
      bool1 = false;
      break;
      label737:
      localObject2 = paramBundle.getString("key_by_pass");
      paramBundle = (Bundle)localObject2;
      if (localObject2 != null) {
        break label63;
      }
      paramBundle = "";
      break label63;
      label760:
      localObject2 = paramBundle.getString("key_feed_export_id");
      paramBundle = (Bundle)localObject2;
      if (localObject2 != null) {
        break label80;
      }
      paramBundle = "";
      break label80;
      localObject2 = paramBundle.getString("key_feed_nonce_id");
      paramBundle = (Bundle)localObject2;
      if (localObject2 != null) {
        break label97;
      }
      paramBundle = "";
      break label97;
      localObject2 = paramBundle.getString("key_page_title");
      paramBundle = (Bundle)localObject2;
      if (localObject2 != null) {
        break label114;
      }
      paramBundle = "";
      break label114;
      i = paramBundle.getInt("key_request_scene");
      break label130;
      paramBundle = paramBundle.findViewById(f.d.EFQ);
      break label214;
      paramBundle = getFragment();
      if (paramBundle == null) {
        break label237;
      }
      paramBundle = paramBundle.getView();
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = paramBundle.findViewById(f.d.EFQ))
      {
        paramBundle = (ConstraintLayout)paramBundle;
        if (paramBundle == null) {
          break;
        }
        paramBundle.setBackgroundDrawable(getResources().getDrawable(f.c.nearby_live_corner_bg));
        break;
      }
      paramBundle = paramBundle.findViewById(f.d.EFO);
      break label249;
      paramBundle = paramBundle.findViewById(f.d.EGE);
      break label289;
      ((WeImageView)localObject2).setVisibility(8);
      break label337;
      paramBundle = paramBundle.getByteArray("nearby_live_target_square_page_params_key");
      if (paramBundle == null)
      {
        paramBundle = null;
        break label348;
      }
      paramBundle = new bnn().parseFrom(paramBundle);
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
        AppMethodBeat.o(341420);
        throw paramBundle;
      }
      paramBundle = Integer.valueOf(((bnn)paramBundle).ZVZ);
      break label348;
      label1006:
      i = paramBundle.intValue();
      break label363;
      label1014:
      bool1 = paramBundle.getBoolean("nearby_live_all_auto_refresh_params_key", false);
      break label379;
      bool1 = paramBundle.getBoolean("nearby_live_target_auto_refresh_params_key", false);
      break label395;
      paramBundle = paramBundle.getByteArray("nearby_live_target_last_buffer_params_key");
      break label411;
      paramBundle = paramBundle.findViewById(f.d.EGD);
      break label428;
      paramBundle = paramBundle.findViewById(f.d.EGD);
      break label458;
      paramBundle = localFragment.getView();
      if (paramBundle == null)
      {
        paramBundle = null;
        break label483;
      }
      paramBundle = paramBundle.findViewById(f.d.EFH);
      break label483;
      localObject1 = localView.findViewById(f.d.viewPager);
      break label524;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(341437);
    super.onDestroy();
    a locala = this.EFl;
    if (locala != null) {
      locala.detach();
    }
    Log.i("NearbyLiveSquareTabLayoutUIC", "onDestroy");
    AppMethodBeat.o(341437);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(341456);
    super.onPause();
    this.EFm = false;
    AppMethodBeat.o(341456);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(341449);
    super.onResume();
    this.EFm = true;
    AppMethodBeat.o(341449);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(341426);
    super.onUserVisibleFocused();
    this.EMq = true;
    he(this.EMl);
    Log.i("NearbyLiveSquareTabLayoutUIC", "onUserVisibleFocused");
    AppMethodBeat.o(341426);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(341433);
    super.onUserVisibleUnFocused();
    this.EMq = false;
    AppMethodBeat.o(341433);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$NearbyTab;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabType", "", "isForceNightMode", "", "(Lcom/google/android/material/tabs/TabLayout$Tab;IZ)V", "index", "getIndex", "()I", "setIndex", "(I)V", "()Z", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabId", "getTabId", "setTabId", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "getDescTextColor", "setTextBold", "", "isBold", "setTextColor", "id", "setTitle", "title", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private final boolean ALp;
    ImageView EFo;
    TabLayout.e dyQ;
    private int hJx;
    public int idY;
    int index;
    private TextView titleTv;
    
    public b(TabLayout.e parame, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(341268);
      this.dyQ = parame;
      this.hJx = paramInt;
      this.ALp = paramBoolean;
      this.dyQ.tag = this;
      this.dyQ.jw(f.e.EHb);
      parame = this.dyQ.dyK;
      if (parame == null)
      {
        parame = null;
        kotlin.g.b.s.checkNotNull(parame);
        this.titleTv = parame;
        parame = this.titleTv;
        if (parame != null)
        {
          Object localObject2 = this.dyQ.dyK;
          kotlin.g.b.s.checkNotNull(localObject2);
          localObject2 = ((View)localObject2).getContext().getResources();
          if (!this.ALp) {
            break label189;
          }
          paramInt = f.a.BW_0_Alpha_0_5_Night_Mode;
          label119:
          parame.setTextColor(((Resources)localObject2).getColor(paramInt));
        }
        parame = this.dyQ.dyK;
        if (parame != null) {
          break label196;
        }
      }
      label189:
      label196:
      for (parame = localObject1;; parame = (ImageView)parame.findViewById(f.d.tabRed))
      {
        kotlin.g.b.s.checkNotNull(parame);
        this.EFo = parame;
        parame = this.EFo;
        if (parame != null) {
          parame.setImageResource(f.g.finder_live_icon);
        }
        AppMethodBeat.o(341268);
        return;
        parame = (TextView)parame.findViewById(f.d.tabTitle);
        break;
        paramInt = f.a.desc_text_color;
        break label119;
      }
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(341288);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        if (paramBoolean)
        {
          aw.a((Paint)localTextView.getPaint(), 0.8F);
          AppMethodBeat.o(341288);
          return;
        }
        localTextView.getPaint().setFakeBoldText(false);
        localTextView.getPaint().setStrokeWidth(0.0F);
      }
      AppMethodBeat.o(341288);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(341281);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        View localView = this.dyQ.dyK;
        kotlin.g.b.s.checkNotNull(localView);
        localTextView.setTextColor(localView.getContext().getResources().getColor(paramInt));
      }
      AppMethodBeat.o(341281);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(341276);
      kotlin.g.b.s.u(paramString, "title");
      TextView localTextView = this.titleTv;
      if (localTextView != null) {
        localTextView.setText((CharSequence)paramString);
      }
      AppMethodBeat.o(341276);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$buildTab$3", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "getDescTextColor", "", "getNormalTextColor", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    c(b paramb) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(341280);
      kotlin.g.b.s.u(parame, "t");
      parame = parame.tag;
      Object localObject;
      if ((parame instanceof b.b))
      {
        localObject = (b.b)parame;
        if (!b.c(this.EMs)) {
          break label107;
        }
      }
      label107:
      for (int i = f.a.BW_0_Alpha_0_9_Night_Mode;; i = f.a.normal_text_color)
      {
        ((b.b)localObject).setTextColor(i);
        ((b.b)parame).setTextBold(true);
        localObject = k.aeZF;
        localObject = this.EMs.getFragment();
        kotlin.g.b.s.checkNotNull(localObject);
        localObject = k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class);
        kotlin.g.b.s.s(localObject, "UICProvider.of(fragment!…iveSquareUIC::class.java)");
        com.tencent.mm.plugin.finder.nearby.live.square.b.a((com.tencent.mm.plugin.finder.nearby.live.square.b)localObject, ((b.b)parame).index);
        AppMethodBeat.o(341280);
        return;
      }
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(341269);
      kotlin.g.b.s.u(parame, "t");
      parame = parame.tag;
      b.b localb;
      if ((parame instanceof b.b))
      {
        localb = (b.b)parame;
        if (!b.c(this.EMs)) {
          break label61;
        }
      }
      label61:
      for (int i = f.a.BW_0_Alpha_0_5_Night_Mode;; i = f.a.desc_text_color)
      {
        localb.setTextColor(i);
        ((b.b)parame).setTextBold(false);
        AppMethodBeat.o(341269);
        return;
      }
    }
    
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(341262);
      kotlin.g.b.s.u(parame, "t");
      AppMethodBeat.o(341262);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$onCreate$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements HardTouchableLayout.g
  {
    d(b paramb) {}
    
    private static final void d(b paramb)
    {
      AppMethodBeat.i(341257);
      kotlin.g.b.s.u(paramb, "this$0");
      paramb = b.a(paramb);
      if (paramb != null) {
        paramb.eEq();
      }
      AppMethodBeat.o(341257);
    }
    
    public final void fu(View paramView)
    {
      AppMethodBeat.i(341273);
      kotlin.g.b.s.u(paramView, "view");
      Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
      com.tencent.threadpool.h.ahAA.bk(new b.d..ExternalSyntheticLambda0(this.EMs));
      AppMethodBeat.o(341273);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "title", "", "videoTabName", "liveTabName", "tabList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "isHideTabs", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.s<String, String, String, LinkedList<bnn>, Boolean, ah>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.b
 * JD-Core Version:    0.7.0.1
 */