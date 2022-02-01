package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.c;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.g;
import com.tencent.mm.plugin.finder.nearby.guide.a.b;
import com.tencent.mm.plugin.finder.nearby.guide.a.c;
import com.tencent.mm.plugin.finder.nearby.live.square.b;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "allPageForceRefreshFlag", "", "byPass", "", "encryptedObjectId", "fetchTabListScene", "", "hasBuildTab", "isCurrentResume", "isForceNightMode", "isHideTabs", "liveTabLists", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "objectNonceId", "onUserVisibleFocused", "pageTitle", "squareTabFetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher;", "targetPageForceRefreshFlag", "targetTabId", "targetTabPageLastBuffer", "", "adapteViewBackGroundColor", "", "buildTab", "liveTabList", "", "checkIfHideTabs", "getActiveFragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onUserVisibleUnFocused", "registerRedDot", "setPageTitle", "title", "setTabIndex", "index", "findByTabId", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lcom/google/android/material/tabs/TabLayout;", "any", "", "findByTag", "Companion", "NearbyTab", "plugin-finder-nearby_release"})
public final class c
  extends UIComponent
{
  public static final a zHb;
  private String objectNonceId;
  private String qbv;
  private boolean xnL;
  private String xxK;
  private a zCt;
  private boolean zCu;
  private boolean zEj;
  private String zGJ;
  private boolean zGT;
  private List<bcz> zGU;
  private int zGV;
  private boolean zGW;
  private byte[] zGX;
  private int zGY;
  private boolean zGZ;
  private boolean zHa;
  
  static
  {
    AppMethodBeat.i(202175);
    zHb = new a((byte)0);
    AppMethodBeat.o(202175);
  }
  
  public c(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(202172);
    this.zGU = ((List)new LinkedList());
    this.zGJ = "";
    this.xxK = "";
    this.objectNonceId = "";
    this.qbv = "";
    AppMethodBeat.o(202172);
  }
  
  public static TabLayout.e b(TabLayout paramTabLayout, Object paramObject)
  {
    AppMethodBeat.i(202167);
    p.k(paramTabLayout, "$this$findByTabId");
    p.k(paramObject, "any");
    int j = paramTabLayout.getTabCount();
    int i = 0;
    if (i < j)
    {
      TabLayout.e locale = paramTabLayout.gd(i);
      Object localObject;
      if (locale != null) {
        localObject = locale.getTag();
      }
      int k;
      while ((localObject instanceof b))
      {
        localObject = locale.getTag();
        if (localObject == null)
        {
          paramTabLayout = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabLayoutUIC.NearbyTab");
          AppMethodBeat.o(202167);
          throw paramTabLayout;
          localObject = null;
        }
        else
        {
          k = ((b)localObject).fXY;
          if ((paramObject instanceof Integer)) {
            break label120;
          }
        }
      }
      label120:
      while (k != ((Integer)paramObject).intValue())
      {
        i += 1;
        break;
      }
      AppMethodBeat.o(202167);
      return locale;
    }
    AppMethodBeat.o(202167);
    return null;
  }
  
  private final void eB(List<? extends bcz> paramList)
  {
    int i = 8;
    AppMethodBeat.i(202157);
    if (this.zHa)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab hasBuildTab:" + this.zHa);
      AppMethodBeat.o(202157);
      return;
    }
    if (!this.zGZ)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab onUserVisibleFocused:" + this.zGZ);
      AppMethodBeat.o(202157);
      return;
    }
    Object localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    if (((Fragment)localObject1).isDetached())
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab after fragment detached");
      AppMethodBeat.o(202157);
      return;
    }
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    if (((Fragment)localObject1).getView() == null)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab view is null");
      AppMethodBeat.o(202157);
      return;
    }
    if (paramList.isEmpty())
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab liveTabList:".concat(String.valueOf(paramList)));
      paramList = getFragment();
      if (paramList == null) {
        p.iCn();
      }
      paramList = (FinderViewPager)paramList.getView().findViewById(f.d.viewPager);
      p.j(paramList, "fragment!!.viewPager");
      paramList.setVisibility(8);
      paramList = getFragment();
      if (paramList == null) {
        p.iCn();
      }
      paramList = (HardTouchableLayout)paramList.getView().findViewById(f.d.zDb);
      p.j(paramList, "fragment!!.tab_container_htl");
      paramList.setVisibility(8);
      AppMethodBeat.o(202157);
      return;
    }
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = (HardTouchableLayout)((Fragment)localObject1).getView().findViewById(f.d.zDb);
    p.j(localObject1, "fragment!!.tab_container_htl");
    ((HardTouchableLayout)localObject1).setVisibility(0);
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = (FinderViewPager)((Fragment)localObject1).getView().findViewById(f.d.viewPager);
    p.j(localObject1, "fragment!!.viewPager");
    ((FinderViewPager)localObject1).setVisibility(0);
    pS(this.zGT);
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = (TextView)((Fragment)localObject1).getView().findViewById(f.d.empty_tip_tv);
    p.j(localObject1, "fragment!!.empty_tip_tv");
    if (this.zGU.size() == 0) {
      i = 0;
    }
    ((TextView)localObject1).setVisibility(i);
    localObject1 = g.Xox;
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((aj)g.h((Fragment)localObject1).i(aj.class)).ekY();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = ((Iterable)paramList).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        j.iBO();
      }
      localObject3 = (bcz)localObject3;
      localObject4 = new Bundle();
      ((Bundle)localObject4).putByteArray("nearby_live_square_tab_info_key", ((bcz)localObject3).toByteArray());
      ((Bundle)localObject4).putInt("key_comment_scene", ((bid)localObject1).xkX);
      ((Bundle)localObject4).putString("key_click_tab_context_id", ((bid)localObject1).wmz);
      Object localObject5 = getFragment();
      if (localObject5 == null)
      {
        paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
        AppMethodBeat.o(202157);
        throw paramList;
      }
      ((Bundle)localObject4).putString("key_click_tab_id", ((AbsNearByFragment)localObject5).dLv());
      if (this.xnL) {}
      for (int j = 1;; j = 0)
      {
        ((Bundle)localObject4).putInt("key_use_dark_style", j);
        ((Bundle)localObject4).putString("key_by_pass", this.zGJ);
        ((Bundle)localObject4).putBoolean("nearby_live_target_auto_refresh_params_key", this.zGW);
        if (((this.zGV == 0) && (i == 0)) || (this.zGV == ((bcz)localObject3).SOa))
        {
          ((Bundle)localObject4).putBoolean("nearby_live_target_auto_refresh_params_key", this.zEj);
          ((Bundle)localObject4).putByteArray("nearby_live_target_last_buffer_params_key", this.zGX);
        }
        localObject5 = new NearbyLiveSquareTabFragment((bcz)localObject3);
        ((NearbyLiveSquareTabFragment)localObject5).setTitle(String.valueOf(((bcz)localObject3).SOb));
        ((NearbyLiveSquareTabFragment)localObject5).setArguments((Bundle)localObject4);
        localLinkedList.add(localObject5);
        i += 1;
        break;
      }
    }
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    localObject2 = (TabLayout)((Fragment)localObject1).getView().findViewById(f.d.zDc);
    Object localObject3 = ((Iterable)localLinkedList).iterator();
    i = 0;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (NearbyLiveSquareTabFragment)localObject1;
      localObject4 = ((TabLayout)localObject2).xz();
      p.j(localObject4, "tabLayout.newTab()");
      localObject4 = new b((TabLayout.e)localObject4, ((AbsNearByFragment)localObject1).fEH, this.xnL);
      ((b)localObject4).setTitle(((AbsNearByFragment)localObject1).title);
      ((b)localObject4).index = i;
      localObject1 = ((NearbyLiveSquareTabFragment)localObject1).zDU;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((bcz)localObject1).SOa);; localObject1 = null)
      {
        ((b)localObject4).fXY = ((Integer)localObject1).intValue();
        ((TabLayout)localObject2).a(((b)localObject4).bFQ, false);
        i += 1;
        break;
      }
    }
    ((TabLayout)localObject2).a((TabLayout.b)new c(this));
    localObject1 = g.Xox;
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.iCn();
    }
    ((b)g.h((Fragment)localObject1).i(b.class)).p(paramList, (List)localLinkedList);
    this.zHa = true;
    AppMethodBeat.o(202157);
  }
  
  private final void pS(boolean paramBoolean)
  {
    AppMethodBeat.i(202140);
    Log.i("NearbyLiveSquareTabLayoutUIC", "checkIfHideTabs isHideTabs:".concat(String.valueOf(paramBoolean)));
    Object localObject = getFragment();
    if (localObject == null) {
      p.iCn();
    }
    localObject = (HardTouchableLayout)((Fragment)localObject).getView().findViewById(f.d.zDb);
    p.j(localObject, "fragment!!.tab_container_htl");
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      ((HardTouchableLayout)localObject).setVisibility(i);
      AppMethodBeat.o(202140);
      return;
    }
  }
  
  public final void Ok(int paramInt)
  {
    AppMethodBeat.i(202146);
    Object localObject = getFragment();
    if (localObject == null) {
      p.iCn();
    }
    localObject = (TabLayout)((Fragment)localObject).getView().findViewById(f.d.zDc);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).gd(paramInt);
      if (localObject != null)
      {
        p.j(localObject, "this");
        if (!((TabLayout.e)localObject).isSelected()) {
          ((TabLayout.e)localObject).xI();
        }
        AppMethodBeat.o(202146);
        return;
      }
    }
    AppMethodBeat.o(202146);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(202136);
    Fragment localFragment = getFragment();
    if (localFragment == null) {
      p.iCn();
    }
    paramBundle = getArguments();
    if ((paramBundle != null) && (paramBundle.getInt("key_use_dark_style", 1) == 1))
    {
      bool1 = true;
      this.xnL = bool1;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("key_by_pass");
        paramBundle = (Bundle)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramBundle = "";
      }
      this.zGJ = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("key_feed_export_id");
        paramBundle = (Bundle)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramBundle = "";
      }
      this.xxK = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("key_feed_nonce_id");
        paramBundle = (Bundle)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramBundle = "";
      }
      this.objectNonceId = paramBundle;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("key_page_title");
        paramBundle = (Bundle)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramBundle = "";
      }
      this.qbv = paramBundle;
      paramBundle = getArguments();
      if (paramBundle == null) {
        break label369;
      }
      i = paramBundle.getInt("key_request_scene");
      label204:
      this.zGY = i;
      Log.i("NearbyLiveSquareTabLayoutUIC", "onCreate isForceNightMode:" + this.xnL + " fetchTabListScene:" + this.zGY + " byPass:" + this.zGJ);
      if (!this.xnL) {
        break label374;
      }
      paramBundle = getFragment();
      if (paramBundle != null)
      {
        paramBundle = (ConstraintLayout)paramBundle.getView().findViewById(f.d.zCW);
        if (paramBundle != null) {
          paramBundle.setBackgroundColor(getResources().getColor(f.a.Dark_0));
        }
      }
    }
    for (;;)
    {
      paramBundle = getArguments();
      if (paramBundle == null) {
        break label1100;
      }
      paramBundle = paramBundle.getByteArray("nearby_live_target_square_page_params_key");
      if (paramBundle == null) {
        break label1100;
      }
      paramBundle = new bcz().parseFrom(paramBundle);
      if (paramBundle != null) {
        break label418;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveTabInfo");
      AppMethodBeat.o(202136);
      throw paramBundle;
      bool1 = false;
      break;
      label369:
      i = 0;
      break label204;
      label374:
      paramBundle = getFragment();
      if (paramBundle != null)
      {
        paramBundle = (ConstraintLayout)paramBundle.getView().findViewById(f.d.zCW);
        if (paramBundle != null) {
          paramBundle.setBackgroundDrawable(getResources().getDrawable(f.c.nearby_live_corner_bg));
        }
      }
    }
    label418:
    int i = ((bcz)paramBundle).SOa;
    this.zGV = i;
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      bool1 = paramBundle.getBoolean("nearby_live_all_auto_refresh_params_key", false);
      label449:
      this.zGW = bool1;
      paramBundle = getArguments();
      if (paramBundle == null) {
        break label1110;
      }
      bool1 = paramBundle.getBoolean("nearby_live_target_auto_refresh_params_key", false);
      label472:
      this.zEj = bool1;
      paramBundle = getArguments();
      if (paramBundle == null) {
        break label1115;
      }
      paramBundle = paramBundle.getByteArray("nearby_live_target_last_buffer_params_key");
      label494:
      this.zGX = paramBundle;
      ((HardTouchableLayout)localFragment.getView().findViewById(f.d.zDb)).setOnSingleClickListener((HardTouchableLayout.g)new d(this));
      ((HardTouchableLayout)localFragment.getView().findViewById(f.d.zDb)).setOnDoubleClickListener((HardTouchableLayout.b)new e(this));
      paramBundle = g.Xox;
      if (localFragment == null) {
        p.iCn();
      }
      paramBundle = ((d)g.h(localFragment).i(d.class)).zHi;
      localObject = (TabLayout)localFragment.getView().findViewById(f.d.zDc);
      p.j(localObject, "fragment.tab_layout");
      localObject = (View)localObject;
      p.k(localObject, "targetView");
      paramBundle.kJL = ((View)localObject);
      ((View)localObject).getLocationOnScreen(paramBundle.zDG);
      Log.i("TabLayoutScrollGuideHelper", "setTargetView pos[" + paramBundle.zDG[0] + ", " + paramBundle.zDG[1] + "] targetView:" + localObject);
      paramBundle.zDK = ValueAnimator.ofFloat(new float[] { 0.0F, com.tencent.mm.live.core.view.c.dip2px(((View)localObject).getContext(), -52.0F) });
      ValueAnimator localValueAnimator = paramBundle.zDK;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.b(paramBundle));
      }
      localValueAnimator = paramBundle.zDK;
      if (localValueAnimator != null) {
        localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localValueAnimator = paramBundle.zDK;
      if (localValueAnimator != null) {
        localValueAnimator.setDuration(1000L);
      }
      paramBundle.zDL = ValueAnimator.ofFloat(new float[] { com.tencent.mm.live.core.view.c.dip2px(((View)localObject).getContext(), -52.0F), 0.0F });
      localObject = paramBundle.zDL;
      if (localObject != null) {
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.c(paramBundle));
      }
      localObject = paramBundle.zDL;
      if (localObject != null) {
        ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObject = paramBundle.zDL;
      if (localObject != null) {
        ((ValueAnimator)localObject).setDuration(500L);
      }
      paramBundle.zDJ = new AnimatorSet();
      localObject = paramBundle.zDJ;
      if (localObject != null) {
        ((AnimatorSet)localObject).playSequentially(new Animator[] { (Animator)paramBundle.zDK, (Animator)paramBundle.zDL });
      }
      localObject = paramBundle.zDJ;
      if (localObject != null) {
        ((AnimatorSet)localObject).addListener((Animator.AnimatorListener)paramBundle);
      }
      paramBundle = g.Xox;
      paramBundle = ((aj)g.h(localFragment).i(aj.class)).ekY();
      if (this.zCt == null) {
        this.zCt = new a((Context)getContext(), this.zGY, this.zGJ, this.xxK, this.objectNonceId, this.qbv);
      }
      if (this.zGY != 0) {
        break label1120;
      }
    }
    label1100:
    label1110:
    label1115:
    label1120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = this.zCt;
      if (localObject != null) {
        ((a)localObject).a(paramBundle, false, bool1, (kotlin.g.a.s)new f(this));
      }
      paramBundle = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
        break label1125;
      }
      Log.w("NearbyLiveSquareTabLayoutUIC", "registerRedDot return for no hit finder live.");
      AppMethodBeat.o(202136);
      return;
      i = 0;
      break;
      bool1 = false;
      break label449;
      bool1 = false;
      break label472;
      paramBundle = null;
      break label494;
    }
    label1125:
    paramBundle = g.Xox;
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle = ((aj)g.h(paramBundle).i(aj.class)).ekY();
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    if (com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ov(paramBundle.xkX))
    {
      Log.w("NearbyLiveSquareTabLayoutUIC", "registerRedDot return for in operation game page.");
      AppMethodBeat.o(202136);
      return;
    }
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle = (TabLayout)paramBundle.getView().findViewById(f.d.zDc);
    localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.drh(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new g(this, paramBundle));
    AppMethodBeat.o(202136);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202143);
    super.onDestroy();
    a locala = this.zCt;
    if (locala != null) {
      locala.detach();
    }
    Log.i("NearbyLiveSquareTabLayoutUIC", "onDestroy");
    AppMethodBeat.o(202143);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(202161);
    super.onPause();
    this.zCu = false;
    AppMethodBeat.o(202161);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202160);
    super.onResume();
    this.zCu = true;
    AppMethodBeat.o(202160);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(202141);
    super.onUserVisibleFocused();
    this.zGZ = true;
    eB(this.zGU);
    Log.i("NearbyLiveSquareTabLayoutUIC", "onUserVisibleFocused");
    AppMethodBeat.o(202141);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(202142);
    super.onUserVisibleUnFocused();
    this.zGZ = false;
    AppMethodBeat.o(202142);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$NearbyTab;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabType", "", "isForceNightMode", "", "(Lcom/google/android/material/tabs/TabLayout$Tab;IZ)V", "index", "getIndex", "()I", "setIndex", "(I)V", "()Z", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabId", "getTabId", "setTabId", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "getDescTextColor", "setTextBold", "", "isBold", "setTextColor", "id", "setTitle", "title", "", "plugin-finder-nearby_release"})
  public static final class b
  {
    TabLayout.e bFQ;
    private int fEH;
    int fXY;
    int index;
    private TextView titleTv;
    private final boolean xnL;
    ImageView zCx;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.e parame, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(201806);
      this.bFQ = parame;
      this.fEH = paramInt;
      this.xnL = paramBoolean;
      this.bFQ.ac(this);
      this.bFQ.gk(f.e.zDj);
      parame = this.bFQ.getCustomView();
      if (parame != null)
      {
        parame = (TextView)parame.findViewById(f.d.tabTitle);
        if (parame == null) {
          p.iCn();
        }
        this.titleTv = parame;
        parame = this.titleTv;
        if (parame != null) {
          parame.setTextSize(1, 14.0F);
        }
        parame = this.titleTv;
        if (parame != null)
        {
          Object localObject = this.bFQ.getCustomView();
          if (localObject == null) {
            p.iCn();
          }
          p.j(localObject, "tab.customView!!");
          localObject = ((View)localObject).getContext();
          p.j(localObject, "tab.customView!!.context");
          localObject = ((Context)localObject).getResources();
          if (!this.xnL) {
            break label238;
          }
          paramInt = f.a.BW_0_Alpha_0_5_Night_Mode;
          label166:
          parame.setTextColor(((Resources)localObject).getColor(paramInt));
        }
        parame = this.bFQ.getCustomView();
        if (parame == null) {
          break label245;
        }
      }
      label238:
      label245:
      for (parame = (ImageView)parame.findViewById(f.d.tabRed);; parame = null)
      {
        if (parame == null) {
          p.iCn();
        }
        this.zCx = parame;
        parame = this.zCx;
        if (parame == null) {
          break label250;
        }
        parame.setImageResource(f.g.finder_live_icon);
        AppMethodBeat.o(201806);
        return;
        parame = null;
        break;
        paramInt = f.a.desc_text_color;
        break label166;
      }
      label250:
      AppMethodBeat.o(201806);
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(201803);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(201803);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        p.j(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        p.j(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(201803);
        return;
      }
      AppMethodBeat.o(201803);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(201800);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        Object localObject = this.bFQ.getCustomView();
        if (localObject == null) {
          p.iCn();
        }
        p.j(localObject, "tab.customView!!");
        localObject = ((View)localObject).getContext();
        p.j(localObject, "tab.customView!!.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(paramInt));
        AppMethodBeat.o(201800);
        return;
      }
      AppMethodBeat.o(201800);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(201794);
      p.k(paramString, "title");
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)paramString);
        AppMethodBeat.o(201794);
        return;
      }
      AppMethodBeat.o(201794);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$buildTab$3", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "getDescTextColor", "", "getNormalTextColor", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder-nearby_release"})
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    @SuppressLint({"ResourceType"})
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(203643);
      p.k(parame, "t");
      parame = parame.getTag();
      Object localObject;
      if ((parame instanceof c.b))
      {
        localObject = (c.b)parame;
        if (!c.c(this.zHc)) {
          break label102;
        }
      }
      label102:
      for (int i = f.a.BW_0_Alpha_0_9_Night_Mode;; i = f.a.normal_text_color)
      {
        ((c.b)localObject).setTextColor(i);
        ((c.b)parame).setTextBold(true);
        localObject = g.Xox;
        localObject = this.zHc.getFragment();
        if (localObject == null) {
          p.iCn();
        }
        b.a((b)g.h((Fragment)localObject).i(b.class), ((c.b)parame).index);
        AppMethodBeat.o(203643);
        return;
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(203641);
      p.k(parame, "t");
      parame = parame.getTag();
      c.b localb;
      if ((parame instanceof c.b))
      {
        localb = (c.b)parame;
        if (!c.c(this.zHc)) {
          break label61;
        }
      }
      label61:
      for (int i = f.a.BW_0_Alpha_0_5_Night_Mode;; i = f.a.desc_text_color)
      {
        localb.setTextColor(i);
        ((c.b)parame).setTextBold(false);
        AppMethodBeat.o(203641);
        return;
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(203640);
      p.k(parame, "t");
      AppMethodBeat.o(203640);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$onCreate$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"})
  public static final class d
    implements HardTouchableLayout.g
  {
    public final void et(View paramView)
    {
      AppMethodBeat.i(201529);
      p.k(paramView, "view");
      Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(201529);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(200192);
        AbsNearByFragment localAbsNearByFragment = c.a(this.zHd.zHc);
        if (localAbsNearByFragment != null)
        {
          localAbsNearByFragment.dLt();
          AppMethodBeat.o(200192);
          return;
        }
        AppMethodBeat.o(200192);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$onCreate$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"})
  public static final class e
    implements HardTouchableLayout.b
  {
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200115);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "e");
      Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(200115);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(200597);
        AbsNearByFragment localAbsNearByFragment = c.a(this.zHe.zHc);
        if (localAbsNearByFragment != null)
        {
          localAbsNearByFragment.dLu();
          AppMethodBeat.o(200597);
          return;
        }
        AppMethodBeat.o(200597);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "title", "", "videoTabName", "liveTabName", "tabList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "isHideTabs", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.s<String, String, String, LinkedList<bcz>, Boolean, x>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class g<T>
    implements androidx.lifecycle.s<h.a>
  {
    g(c paramc, TabLayout paramTabLayout) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.c
 * JD-Core Version:    0.7.0.1
 */