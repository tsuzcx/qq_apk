package com.tencent.mm.plugin.finder.nearby.live.square;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.f;
import android.support.v4.app.Fragment;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.view.c;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.guide.a.b;
import com.tencent.mm.plugin.finder.nearby.guide.a.c;
import com.tencent.mm.plugin.finder.nearby.live.square.tab.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "hasBuildTab", "", "isCurrentResume", "isRequestingLbs", "liveTabLists", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "netSceneNearbyLiveSquareTabs", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NetSceneNearbyLiveSquareTabs;", "onUserVisibleFocused", "buildTab", "", "liveTabList", "", "fetchLiveSquareTabs", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fetchTabsInternal", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleUnFocused", "setTabIndex", "index", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "NearbyTab", "plugin-finder_release"})
public final class NearbyLiveSquareTabLayoutUIC
  extends UIComponent
  implements com.tencent.mm.ak.i
{
  public static final a uRx;
  private boolean isRequestingLbs;
  private boolean uPU;
  private a uRt;
  private List<axj> uRu;
  private boolean uRv;
  private boolean uRw;
  
  static
  {
    AppMethodBeat.i(249185);
    uRx = new a((byte)0);
    AppMethodBeat.o(249185);
  }
  
  public NearbyLiveSquareTabLayoutUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(249184);
    this.uRu = ((List)new LinkedList());
    AppMethodBeat.o(249184);
  }
  
  private final void ek(List<? extends axj> paramList)
  {
    int i = 8;
    AppMethodBeat.i(249180);
    if (this.uRw)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab hasBuildTab:" + this.uRw);
      AppMethodBeat.o(249180);
      return;
    }
    if (!this.uRv)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab onUserVisibleFocused:" + this.uRv);
      AppMethodBeat.o(249180);
      return;
    }
    Object localObject1 = getFragment();
    if (localObject1 == null) {
      p.hyc();
    }
    if (((Fragment)localObject1).isDetached())
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab after fragment detached");
      AppMethodBeat.o(249180);
      return;
    }
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.hyc();
    }
    if (((Fragment)localObject1).getView() == null)
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab view is null");
      AppMethodBeat.o(249180);
      return;
    }
    if (paramList.isEmpty())
    {
      Log.i("NearbyLiveSquareTabLayoutUIC", "buildTab liveTabList:".concat(String.valueOf(paramList)));
      paramList = getFragment();
      if (paramList == null) {
        p.hyc();
      }
      paramList = (FinderViewPager)paramList.getView().findViewById(2131309856);
      p.g(paramList, "fragment!!.viewPager");
      paramList.setVisibility(8);
      paramList = getFragment();
      if (paramList == null) {
        p.hyc();
      }
      paramList = (HardTouchableLayout)paramList.getView().findViewById(2131308833);
      p.g(paramList, "fragment!!.tab_container_htl");
      paramList.setVisibility(8);
      AppMethodBeat.o(249180);
      return;
    }
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = (HardTouchableLayout)((Fragment)localObject1).getView().findViewById(2131308833);
    p.g(localObject1, "fragment!!.tab_container_htl");
    ((HardTouchableLayout)localObject1).setVisibility(0);
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = (FinderViewPager)((Fragment)localObject1).getView().findViewById(2131309856);
    p.g(localObject1, "fragment!!.viewPager");
    ((FinderViewPager)localObject1).setVisibility(0);
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = (TextView)((Fragment)localObject1).getView().findViewById(2131300105);
    p.g(localObject1, "fragment!!.empty_tip_tv");
    if (this.uRu.size() == 0) {
      i = 0;
    }
    ((TextView)localObject1).setVisibility(i);
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = getFragment();
    if (localObject1 == null) {
      p.hyc();
    }
    Object localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.of((Fragment)localObject1).get(FinderReporterUIC.class)).dIx();
    localObject1 = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    i = 0;
    Object localObject3;
    Object localObject4;
    while (localIterator.hasNext())
    {
      localObject3 = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      localObject3 = (axj)localObject3;
      localObject4 = new Bundle();
      ((Bundle)localObject4).putByteArray("nearby_live_square_tab_info_key", ((axj)localObject3).toByteArray());
      ((Bundle)localObject4).putInt("key_comment_scene", ((bbn)localObject2).tCE);
      NearbyLiveSquareTabFragment localNearbyLiveSquareTabFragment = new NearbyLiveSquareTabFragment();
      localNearbyLiveSquareTabFragment.uQK = ((axj)localObject3);
      localNearbyLiveSquareTabFragment.setTitle(String.valueOf(((axj)localObject3).LHR));
      localNearbyLiveSquareTabFragment.setArguments((Bundle)localObject4);
      ((LinkedList)localObject1).add(localNearbyLiveSquareTabFragment);
      i += 1;
    }
    localObject2 = getFragment();
    if (localObject2 == null) {
      p.hyc();
    }
    localObject2 = (TabLayout)((Fragment)localObject2).getView().findViewById(2131308839);
    localIterator = ((Iterable)localObject1).iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject3 = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      localObject3 = (NearbyLiveSquareTabFragment)localObject3;
      localObject4 = ((TabLayout)localObject2).cW();
      p.g(localObject4, "tabLayout.newTab()");
      localObject4 = new b((TabLayout.f)localObject4, ((AbsNearByFragment)localObject3).dLS);
      ((b)localObject4).setTitle(((AbsNearByFragment)localObject3).title);
      ((b)localObject4).index = i;
      ((TabLayout)localObject2).a(((b)localObject4).vq, false);
      i += 1;
    }
    ((TabLayout)localObject2).a((TabLayout.b)new c(this));
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject2 = getFragment();
    if (localObject2 == null) {
      p.hyc();
    }
    ((NearbyLiveSquareUIC)com.tencent.mm.ui.component.a.of((Fragment)localObject2).get(NearbyLiveSquareUIC.class)).m(paramList, (List)localObject1);
    this.uRw = true;
    AppMethodBeat.o(249180);
  }
  
  public final void Jx(int paramInt)
  {
    AppMethodBeat.i(249179);
    Object localObject = getFragment();
    if (localObject == null) {
      p.hyc();
    }
    localObject = (TabLayout)((Fragment)localObject).getView().findViewById(2131308839);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).ab(paramInt);
      if (localObject != null)
      {
        p.g(localObject, "this");
        if (!((TabLayout.f)localObject).isSelected()) {
          ((TabLayout.f)localObject).select();
        }
        AppMethodBeat.o(249179);
        return;
      }
    }
    AppMethodBeat.o(249179);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(249175);
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.hyc();
    }
    Log.i("NearbyLiveSquareTabLayoutUIC", "onCreate");
    ((HardTouchableLayout)paramBundle.getView().findViewById(2131308833)).setOnSingleClickListener((HardTouchableLayout.g)new g(paramBundle));
    ((HardTouchableLayout)paramBundle.getView().findViewById(2131308833)).setOnDoubleClickListener((HardTouchableLayout.b)new h(paramBundle));
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    if (paramBundle == null) {
      p.hyc();
    }
    localObject1 = ((NearbyLiveSquareGuideUIC)com.tencent.mm.ui.component.a.of(paramBundle).get(NearbyLiveSquareGuideUIC.class)).uRs;
    Object localObject2 = (TabLayout)paramBundle.getView().findViewById(2131308839);
    p.g(localObject2, "fragment.tab_layout");
    localObject2 = (View)localObject2;
    p.h(localObject2, "targetView");
    ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).targetView = ((View)localObject2);
    ((View)localObject2).getLocationOnScreen(((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQv);
    Log.i("TabLayoutScrollGuideHelper", "setTargetView pos[" + localObject1.uQv[0] + ", " + localObject1.uQv[1] + "] targetView:" + localObject2);
    ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQz = ValueAnimator.ofFloat(new float[] { 0.0F, c.dip2px(((View)localObject2).getContext(), -52.0F) });
    ValueAnimator localValueAnimator = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQz;
    if (localValueAnimator != null) {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.b((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1));
    }
    localValueAnimator = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQz;
    if (localValueAnimator != null) {
      localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    }
    localValueAnimator = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQz;
    if (localValueAnimator != null) {
      localValueAnimator.setDuration(1000L);
    }
    ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQA = ValueAnimator.ofFloat(new float[] { c.dip2px(((View)localObject2).getContext(), -52.0F), 0.0F });
    localObject2 = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQA;
    if (localObject2 != null) {
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.c((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1));
    }
    localObject2 = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQA;
    if (localObject2 != null) {
      ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    }
    localObject2 = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQA;
    if (localObject2 != null) {
      ((ValueAnimator)localObject2).setDuration(500L);
    }
    ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQy = new AnimatorSet();
    localObject2 = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQy;
    if (localObject2 != null) {
      ((AnimatorSet)localObject2).playSequentially(new Animator[] { (Animator)((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQz, (Animator)((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQA });
    }
    localObject2 = ((com.tencent.mm.plugin.finder.nearby.guide.a)localObject1).uQy;
    if (localObject2 != null) {
      ((AnimatorSet)localObject2).addListener((Animator.AnimatorListener)localObject1);
    }
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.of(paramBundle).get(FinderReporterUIC.class)).dIx();
    Log.i("NearbyLiveSquareTabLayoutUIC", "fetchLiveSquareTabs, contextObj:".concat(String.valueOf(paramBundle)));
    localObject1 = com.tencent.mm.plugin.finder.utils.l.vVE;
    com.tencent.mm.plugin.finder.utils.l.a((kotlin.g.a.a)NearbyLiveSquareTabLayoutUIC.d.uRz, (kotlin.g.a.a)new e(this, paramBundle), (kotlin.g.a.a)new f(this, paramBundle));
    AppMethodBeat.o(249175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249178);
    super.onDestroy();
    Log.i("NearbyLiveSquareTabLayoutUIC", "onDestroy");
    AppMethodBeat.o(249178);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249182);
    super.onPause();
    this.uPU = false;
    AppMethodBeat.o(249182);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(249181);
    super.onResume();
    this.uPU = true;
    AppMethodBeat.o(249181);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(249183);
    p.h(paramq, "scene");
    Log.i("NearbyLiveSquareTabLayoutUIC", "onSceneEnd handle NetSceneNearbyLiveSquareTabs, errType:" + paramInt1 + " errCode:" + paramInt2);
    g.azz().b(4210, (com.tencent.mm.ak.i)this);
    if (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt2 == -200008))
    {
      paramString = ((a)paramq).rr;
      if (paramString == null) {
        p.hyc();
      }
      paramString = paramString.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveTabsResponse");
        AppMethodBeat.o(249183);
        throw paramString;
      }
      paramString = (atc)paramString;
      paramq = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.uRQ;
      paramq = paramString.LDY;
      p.g(paramq, "response.tab_list");
      com.tencent.mm.plugin.finder.nearby.live.square.tab.a.el((List)paramq);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new i(this, paramString));
      Log.i("NearbyLiveSquareTabLayoutUIC", "onSceneEnd list:" + paramString.LDY);
      AppMethodBeat.o(249183);
      return;
    }
    Log.e("NearbyLiveSquareTabLayoutUIC", "onSceneEnd handle NetSceneNearbyLiveSquareTabs error");
    AppMethodBeat.o(249183);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249176);
    super.onUserVisibleFocused();
    this.uRv = true;
    ek(this.uRu);
    Log.i("NearbyLiveSquareTabLayoutUIC", "onUserVisibleFocused");
    AppMethodBeat.o(249176);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249177);
    super.onUserVisibleUnFocused();
    this.uRv = false;
    AppMethodBeat.o(249177);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$NearbyTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "title", "", "plugin-finder_release"})
  public static final class b
  {
    private int dLS;
    int index;
    private TextView titleTv;
    TabLayout.f vq;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.f paramf, int paramInt)
    {
      AppMethodBeat.i(249160);
      this.vq = paramf;
      this.dLS = paramInt;
      this.vq.g(this);
      this.vq.aj(2131495827);
      paramf = this.vq.getCustomView();
      if (paramf != null) {}
      for (paramf = (TextView)paramf.findViewById(2131308826);; paramf = null)
      {
        if (paramf == null) {
          p.hyc();
        }
        this.titleTv = paramf;
        paramf = this.titleTv;
        if (paramf == null) {
          break;
        }
        paramf.setTextSize(1, 14.0F);
        AppMethodBeat.o(249160);
        return;
      }
      AppMethodBeat.o(249160);
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(249159);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(249159);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        p.g(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        p.g(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(249159);
        return;
      }
      AppMethodBeat.o(249159);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(249158);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        Object localObject = this.vq.getCustomView();
        if (localObject == null) {
          p.hyc();
        }
        p.g(localObject, "tab.customView!!");
        localObject = ((View)localObject).getContext();
        p.g(localObject, "tab.customView!!.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(paramInt));
        AppMethodBeat.o(249158);
        return;
      }
      AppMethodBeat.o(249158);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(249157);
      p.h(paramString, "title");
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)paramString);
        AppMethodBeat.o(249157);
        return;
      }
      AppMethodBeat.o(249157);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$buildTab$3", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    @SuppressLint({"ResourceType"})
    public final void i(TabLayout.f paramf)
    {
      AppMethodBeat.i(249163);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof NearbyLiveSquareTabLayoutUIC.b))
      {
        ((NearbyLiveSquareTabLayoutUIC.b)paramf).setTextColor(2131100904);
        ((NearbyLiveSquareTabLayoutUIC.b)paramf).setTextBold(true);
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = this.uRy.getFragment();
        if (localObject == null) {
          p.hyc();
        }
        NearbyLiveSquareUIC.a((NearbyLiveSquareUIC)com.tencent.mm.ui.component.a.of((Fragment)localObject).get(NearbyLiveSquareUIC.class), ((NearbyLiveSquareTabLayoutUIC.b)paramf).index);
      }
      AppMethodBeat.o(249163);
    }
    
    @SuppressLint({"ResourceType"})
    public final void j(TabLayout.f paramf)
    {
      AppMethodBeat.i(249162);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof NearbyLiveSquareTabLayoutUIC.b))
      {
        ((NearbyLiveSquareTabLayoutUIC.b)paramf).setTextColor(2131100245);
        ((NearbyLiveSquareTabLayoutUIC.b)paramf).setTextBold(false);
      }
      AppMethodBeat.o(249162);
    }
    
    @SuppressLint({"ResourceType"})
    public final void k(TabLayout.f paramf)
    {
      AppMethodBeat.i(249161);
      p.h(paramf, "t");
      AppMethodBeat.o(249161);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(NearbyLiveSquareTabLayoutUIC paramNearbyLiveSquareTabLayoutUIC, bbn parambbn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(NearbyLiveSquareTabLayoutUIC paramNearbyLiveSquareTabLayoutUIC, bbn parambbn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$onCreate$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class g
    implements HardTouchableLayout.g
  {
    g(Fragment paramFragment) {}
    
    public final void b(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(249171);
      p.h(paramView, "view");
      Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
      h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(249171);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(NearbyLiveSquareTabLayoutUIC.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(249170);
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = this.uRD.uRC;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((NearbyLiveSquareUIC)com.tencent.mm.ui.component.a.of((Fragment)localObject).get(NearbyLiveSquareUIC.class)).dlj();
        if (localObject != null)
        {
          ((AbsNearByFragment)localObject).dll();
          AppMethodBeat.o(249170);
          return;
        }
        AppMethodBeat.o(249170);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareTabLayoutUIC$onCreate$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static final class h
    implements HardTouchableLayout.b
  {
    h(Fragment paramFragment) {}
    
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(249173);
      p.h(paramView, "view");
      p.h(paramMotionEvent, "e");
      Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
      h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(249173);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(NearbyLiveSquareTabLayoutUIC.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(249172);
        Object localObject = com.tencent.mm.ui.component.a.PRN;
        localObject = this.uRE.uRC;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((NearbyLiveSquareUIC)com.tencent.mm.ui.component.a.of((Fragment)localObject).get(NearbyLiveSquareUIC.class)).dlj();
        if (localObject != null)
        {
          ((AbsNearByFragment)localObject).dlm();
          AppMethodBeat.o(249172);
          return;
        }
        AppMethodBeat.o(249172);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(NearbyLiveSquareTabLayoutUIC paramNearbyLiveSquareTabLayoutUIC, atc paramatc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareTabLayoutUIC
 * JD-Core Version:    0.7.0.1
 */