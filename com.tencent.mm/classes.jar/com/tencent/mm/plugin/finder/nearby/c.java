package com.tencent.mm.plugin.finder.nearby;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.mm.view.HardTouchableLayout.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isCurrentResume", "", "squareTabFetcher", "Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabFetcher;", "buildTab", "", "checkAddFootPrintRedDot", "fetchTabsInfo", "getNearbyTab", "Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", "index", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "registerRedDot", "setMenuType", "menuType", "setNearbyLiveTabTitle", "title", "", "setNearbyVideoTabTitle", "setTabIndex", "findByTag", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lcom/google/android/material/tabs/TabLayout;", "any", "", "Companion", "NearbyTab", "plugin-finder-nearby_release"})
public final class c
  extends UIComponent
{
  public static final a zCv;
  private com.tencent.mm.plugin.finder.nearby.live.square.tab.a zCt;
  private boolean zCu;
  
  static
  {
    AppMethodBeat.i(203315);
    zCv = new a((byte)0);
    AppMethodBeat.o(203315);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(203313);
    AppMethodBeat.o(203313);
  }
  
  public static void dLj()
  {
    AppMethodBeat.i(203309);
    if (!com.tencent.mm.bw.a.abO())
    {
      Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: add footprint red dot");
      locala = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)locala).getRedDotManager().xsL.drB();
      AppMethodBeat.o(203309);
      return;
    }
    Log.i("NearbyActionBarUIC", "checkAddFootPrintRedDot: clear footprint red dot");
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)locala).getRedDotManager().Mp(1014);
    AppMethodBeat.o(203309);
  }
  
  public final void Ok(int paramInt)
  {
    AppMethodBeat.i(203303);
    Object localObject = (TabLayout)((FragmentActivity)getActivity()).findViewById(f.d.zDc);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).gd(paramInt);
      if (localObject != null)
      {
        p.j(localObject, "this");
        if (!((TabLayout.e)localObject).isSelected()) {
          ((TabLayout.e)localObject).xI();
        }
        AppMethodBeat.o(203303);
        return;
      }
    }
    AppMethodBeat.o(203303);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(203296);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(f.d.zCT)).setOnClickListener((View.OnClickListener)new e(this));
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(f.d.zDb)).setOnSingleClickListener((HardTouchableLayout.g)new f(this));
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(f.d.zDb)).setOnDoubleClickListener((HardTouchableLayout.b)new g(this));
    ((ConstraintLayout)((FragmentActivity)getActivity()).findViewById(f.d.zCZ)).setOnClickListener((View.OnClickListener)new h(this));
    paramBundle = (TextView)((FragmentActivity)getActivity()).findViewById(f.d.nearby_menu_live);
    if (paramBundle != null) {
      paramBundle.setTextSize(1, 15.0F);
    }
    paramBundle = g.Xox;
    if (((e)g.b(getActivity()).i(e.class)).fragments.size() == 2)
    {
      paramBundle = (HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(f.d.zDb);
      p.j(paramBundle, "activity.tab_container_htl");
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(203296);
        throw paramBundle;
      }
      ((ConstraintLayout.LayoutParams)paramBundle).leftMargin = 0;
    }
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(f.d.zDc);
    Object localObject1 = g.Xox;
    localObject1 = ((Iterable)((e)g.b(getActivity()).i(e.class)).fragments).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (AbsNearByFragment)localObject2;
      Object localObject3 = paramBundle.xz();
      p.j(localObject3, "tabLayout.newTab()");
      localObject3 = new b((TabLayout.e)localObject3, ((AbsNearByFragment)localObject2).fEH);
      if (!TextUtils.isEmpty((CharSequence)((AbsNearByFragment)localObject2).title)) {
        ((b)localObject3).setTitle(((AbsNearByFragment)localObject2).title);
      }
      for (;;)
      {
        ((b)localObject3).index = i;
        paramBundle.a(((b)localObject3).bFQ, false);
        i += 1;
        break;
        localObject2 = getContext().getString(((AbsNearByFragment)localObject2).zDq);
        p.j(localObject2, "context.getString(fragment.titleId)");
        ((b)localObject3).setTitle((String)localObject2);
      }
    }
    paramBundle.a((TabLayout.b)new c(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(f.d.zDc);
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.drg(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new i(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.drh(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new j(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dri(), (androidx.lifecycle.l)getActivity(), (androidx.lifecycle.s)new k(this, paramBundle));
    paramBundle = getFragment();
    if (paramBundle != null)
    {
      localObject1 = g.Xox;
      paramBundle = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.h(paramBundle).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = g.Xox;
      paramBundle = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b(getActivity()).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    }
    for (;;)
    {
      if (this.zCt == null) {
        this.zCt = new com.tencent.mm.plugin.finder.nearby.live.square.tab.a((Context)getContext());
      }
      localObject1 = this.zCt;
      if (localObject1 != null)
      {
        com.tencent.mm.plugin.finder.nearby.live.square.tab.a.a((com.tencent.mm.plugin.finder.nearby.live.square.tab.a)localObject1, paramBundle, (kotlin.g.a.s)new d(this));
        AppMethodBeat.o(203296);
        return;
      }
      AppMethodBeat.o(203296);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203299);
    super.onDestroy();
    com.tencent.mm.plugin.finder.nearby.live.square.tab.a locala = this.zCt;
    if (locala != null)
    {
      locala.detach();
      AppMethodBeat.o(203299);
      return;
    }
    AppMethodBeat.o(203299);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203311);
    super.onPause();
    this.zCu = false;
    AppMethodBeat.o(203311);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203310);
    super.onResume();
    this.zCu = true;
    AppMethodBeat.o(203310);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$Companion;", "", "()V", "MENU_TYPE_LIVE", "", "MENU_TYPE_PERSON", "MENU_TYPE_VIDEO", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$NearbyTab;", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tabType", "", "(Lcom/google/android/material/tabs/TabLayout$Tab;I)V", "bigTabRedIv", "Landroid/widget/ImageView;", "getBigTabRedIv", "()Landroid/widget/ImageView;", "setBigTabRedIv", "(Landroid/widget/ImageView;)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Lcom/google/android/material/tabs/TabLayout$Tab;", "setTab", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "tabRedIcon", "Landroid/view/ViewGroup;", "getTabRedIcon", "()Landroid/view/ViewGroup;", "setTabRedIcon", "(Landroid/view/ViewGroup;)V", "tabRedIv", "getTabRedIv", "setTabRedIv", "tabRedTv", "Landroid/widget/TextView;", "getTabRedTv", "()Landroid/widget/TextView;", "setTabRedTv", "(Landroid/widget/TextView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "title", "", "plugin-finder-nearby_release"})
  public static final class b
  {
    TabLayout.e bFQ;
    int fEH;
    int index;
    TextView titleTv;
    WeImageView zCw;
    ImageView zCx;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.e parame, int paramInt)
    {
      AppMethodBeat.i(201777);
      this.bFQ = parame;
      this.fEH = paramInt;
      this.bFQ.ac(this);
      switch (this.fEH)
      {
      case 1004: 
      case 1005: 
      default: 
        this.bFQ.gk(f.e.finder_home_ui_tab_empty);
        AppMethodBeat.o(201777);
        return;
      case 1001: 
        this.bFQ.gk(f.e.zDg);
        parame = this.bFQ.getCustomView();
        if (parame != null)
        {
          parame = (TextView)parame.findViewById(f.d.tabTitle);
          if (parame == null) {
            p.iCn();
          }
          this.titleTv = parame;
          parame = this.bFQ.getCustomView();
          if (parame == null) {
            break label217;
          }
        }
        for (parame = (ImageView)parame.findViewById(f.d.tabRed);; parame = null)
        {
          if (parame == null) {
            p.iCn();
          }
          this.zCx = parame;
          parame = this.zCx;
          if (parame != null) {
            parame.setImageResource(f.g.finder_live_icon);
          }
          parame = this.titleTv;
          if (parame == null) {
            break label222;
          }
          parame.setTextSize(1, 15.0F);
          AppMethodBeat.o(201777);
          return;
          parame = null;
          break;
        }
        AppMethodBeat.o(201777);
        return;
      case 1002: 
      case 1006: 
        label217:
        label222:
        this.bFQ.gk(f.e.zDg);
        parame = this.bFQ.getCustomView();
        if (parame != null)
        {
          parame = (TextView)parame.findViewById(f.d.tabTitle);
          if (parame == null) {
            p.iCn();
          }
          this.titleTv = parame;
          parame = this.bFQ.getCustomView();
          if (parame == null) {
            break label336;
          }
        }
        label336:
        for (parame = (ImageView)parame.findViewById(f.d.tabRed);; parame = null)
        {
          if (parame == null) {
            p.iCn();
          }
          this.zCx = parame;
          parame = this.titleTv;
          if (parame == null) {
            break label341;
          }
          parame.setTextSize(1, 15.0F);
          AppMethodBeat.o(201777);
          return;
          parame = null;
          break;
        }
        label341:
        AppMethodBeat.o(201777);
        return;
      }
      this.bFQ.gk(f.e.zDh);
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
          parame.setTextSize(1, 15.0F);
        }
        parame = this.bFQ.getCustomView();
        if (parame == null) {
          break label510;
        }
        parame = (WeImageView)parame.findViewById(f.d.tabTitleImage);
        label432:
        if (parame == null) {
          p.iCn();
        }
        this.zCw = parame;
        parame = this.bFQ.getCustomView();
        if (parame == null) {
          break label515;
        }
      }
      label515:
      for (parame = (ImageView)parame.findViewById(f.d.tabRed);; parame = null)
      {
        if (parame == null) {
          p.iCn();
        }
        this.zCx = parame;
        if (!com.tencent.mm.bw.a.abO()) {
          break label526;
        }
        parame = this.zCw;
        if (parame == null) {
          break label520;
        }
        parame.setVisibility(4);
        AppMethodBeat.o(201777);
        return;
        parame = null;
        break;
        label510:
        parame = null;
        break label432;
      }
      label520:
      AppMethodBeat.o(201777);
      return;
      label526:
      parame = this.zCw;
      if (parame != null)
      {
        parame.setVisibility(0);
        AppMethodBeat.o(201777);
        return;
      }
      AppMethodBeat.o(201777);
    }
    
    public final void setTextBold(boolean paramBoolean)
    {
      AppMethodBeat.i(201767);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(201767);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        p.j(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        p.j(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(201767);
        return;
      }
      AppMethodBeat.o(201767);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(201764);
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
        AppMethodBeat.o(201764);
        return;
      }
      AppMethodBeat.o(201764);
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(201761);
      p.k(paramString, "title");
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)paramString);
        AppMethodBeat.o(201761);
        return;
      }
      AppMethodBeat.o(201761);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$buildTab$2", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder-nearby_release"})
  public static final class c
    implements TabLayout.b<TabLayout.e>
  {
    @SuppressLint({"ResourceType"})
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(199959);
      p.k(parame, "t");
      parame = parame.getTag();
      if ((parame instanceof c.b))
      {
        ((c.b)parame).setTextColor(f.a.normal_text_color);
        ((c.b)parame).setTextBold(true);
        g localg = g.Xox;
        ((e)g.b(this.zCy.getActivity()).i(e.class)).On(((c.b)parame).fEH);
        switch (((c.b)parame).fEH)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(199959);
        return;
        c.a(this.zCy, 3);
        c.dLj();
        AppMethodBeat.o(199959);
        return;
        c.a(this.zCy, 2);
        AppMethodBeat.o(199959);
        return;
        c.a(this.zCy, 1);
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(199957);
      p.k(parame, "t");
      parame = parame.getTag();
      if ((parame instanceof c.b))
      {
        ((c.b)parame).setTextColor(f.a.desc_text_color);
        ((c.b)parame).setTextBold(false);
        switch (((c.b)parame).fEH)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(199957);
        return;
        c.dLj();
      }
    }
    
    @SuppressLint({"ResourceType"})
    public final void k(TabLayout.e parame)
    {
      AppMethodBeat.i(199956);
      p.k(parame, "t");
      AppMethodBeat.o(199956);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "title", "", "videoTabName", "liveTabName", "tabList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "isHideTabs", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.s<String, String, String, LinkedList<bcz>, Boolean, x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199954);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zCy.getActivity().onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199954);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"})
  public static final class f
    implements HardTouchableLayout.g
  {
    public final void et(View paramView)
    {
      AppMethodBeat.i(201322);
      p.k(paramView, "view");
      Log.i("NearbyActionBarUIC", "onDoubleClick ...");
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(201322);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(202765);
        Object localObject = g.Xox;
        localObject = ((e)g.b(this.zCC.zCy.getActivity()).i(e.class)).dLn();
        if (localObject != null)
        {
          ((AbsNearByFragment)localObject).dLt();
          AppMethodBeat.o(202765);
          return;
        }
        AppMethodBeat.o(202765);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$3", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"})
  public static final class g
    implements HardTouchableLayout.b
  {
    public final void a(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202073);
      p.k(paramView, "view");
      p.k(paramMotionEvent, "e");
      Log.i("NearbyActionBarUIC", "onDoubleClick ...");
      com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      AppMethodBeat.o(202073);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(201975);
        Object localObject = g.Xox;
        localObject = ((e)g.b(this.zCD.zCy.getActivity()).i(e.class)).dLn();
        if (localObject != null)
        {
          ((AbsNearByFragment)localObject).dLu();
          AppMethodBeat.o(201975);
          return;
        }
        AppMethodBeat.o(201975);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202308);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("NearbyActionBarUIC", "onMenuClick ...");
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.isFastClick())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202308);
        return;
      }
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199842);
          Object localObject = g.Xox;
          localObject = ((e)g.b(this.zCE.zCy.getActivity()).i(e.class)).dLn();
          if (localObject != null)
          {
            ((AbsNearByFragment)localObject).dLs();
            AppMethodBeat.o(199842);
            return;
          }
          AppMethodBeat.o(199842);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/NearbyActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202308);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class i<T>
    implements androidx.lifecycle.s<h.a>
  {
    i(c paramc, TabLayout paramTabLayout) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class j<T>
    implements androidx.lifecycle.s<h.a>
  {
    j(c paramc, TabLayout paramTabLayout) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class k<T>
    implements androidx.lifecycle.s<h.a>
  {
    k(c paramc, TabLayout paramTabLayout) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(c paramc, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(c paramc, String paramString, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(200020);
      if (!TextUtils.isEmpty((CharSequence)this.xhz))
      {
        Object localObject = c.b(this.zCy, 0);
        if (localObject != null)
        {
          localObject = ((c.b)localObject).titleTv;
          if (localObject != null) {
            ((TextView)localObject).setText((CharSequence)this.xhz);
          }
        }
        if (this.xhz.length() != 2)
        {
          int i = this.xhz.length();
          int j = com.tencent.mm.live.core.view.c.dip2px((Context)this.zCy.getActivity(), 15.0F);
          if (this.zCG.getLayoutParams() != null)
          {
            localObject = this.zCG.getLayoutParams();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
              AppMethodBeat.o(200020);
              throw ((Throwable)localObject);
            }
            localObject = (ConstraintLayout.LayoutParams)localObject;
            ((ConstraintLayout.LayoutParams)localObject).leftMargin -= (i - 2) * j;
            this.zCG.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
      AppMethodBeat.o(200020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.c
 * JD-Core Version:    0.7.0.1
 */