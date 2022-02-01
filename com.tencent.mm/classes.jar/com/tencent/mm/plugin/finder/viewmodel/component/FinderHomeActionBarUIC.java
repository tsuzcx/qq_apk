package com.tencent.mm.plugin.finder.viewmodel.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.f;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.extension.reddot.d;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.report.c.a;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import d.a.j;
import d.u;
import java.util.Iterator;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "isCurrentResume", "", "isPreparing", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "buildTab", "", "checkPersonCenterRedDotReport", "action", "", "checkPostEntrance", "doClickPostAction", "doPrepareUser", "status", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "registerRedDot", "setTabIndex", "index", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"})
public final class FinderHomeActionBarUIC
  extends UIComponent
  implements com.tencent.mm.ak.f
{
  public static final FinderHomeActionBarUIC.a tmw;
  private String tmp;
  private boolean tmq;
  private String tmr;
  private String tms;
  private String tmt;
  private String tmu;
  private boolean tmv;
  
  static
  {
    AppMethodBeat.i(206203);
    tmw = new FinderHomeActionBarUIC.a((byte)0);
    AppMethodBeat.o(206203);
  }
  
  public FinderHomeActionBarUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206202);
    this.tmp = "";
    this.tmr = "";
    this.tms = "";
    this.tmt = "";
    this.tmu = "";
    AppMethodBeat.o(206202);
  }
  
  private final void GL(int paramInt)
  {
    AppMethodBeat.i(206196);
    Object localObject = FinderReporterUIC.tnG;
    localObject = FinderReporterUIC.a.fc((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
    {
      d.a locala = d.sav;
      this.tmp = d.a.a(paramInt, (arn)localObject, this.tmp);
      AppMethodBeat.o(206196);
      return;
    }
  }
  
  private final void GN(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(206200);
    com.tencent.mm.sdk.platformtools.ae.i("Finder.HomeActionBarUIC", "[doPrepareUser] isPreparing=" + this.tmv + " status=" + paramInt);
    Object localObject;
    if (!this.tmv)
    {
      this.tmv = true;
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      bool1 = bool2;
      if (((PluginFinder)localObject).getRedDotManager().aii("TLPostCamera") == null)
      {
        localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
        if (((PluginFinder)localObject).getRedDotManager().aii("TLCamera") == null) {
          break label150;
        }
      }
    }
    label150:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject = new ay(3);
      ((ay)localObject).rSf = bool1;
      com.tencent.mm.kernel.g.ajj().b((n)localObject);
      AppMethodBeat.o(206200);
      return;
    }
  }
  
  public final void GM(int paramInt)
  {
    AppMethodBeat.i(206197);
    Object localObject = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).ad(paramInt);
      if (localObject != null)
      {
        d.g.b.p.g(localObject, "this");
        if (!((TabLayout.f)localObject).isSelected()) {
          ((TabLayout.f)localObject).select();
        }
        AppMethodBeat.o(206197);
        return;
      }
    }
    AppMethodBeat.o(206197);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(206194);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    com.tencent.mm.kernel.g.ajj().a(3761, (com.tencent.mm.ak.f)this);
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307276)).setOnClickListener((View.OnClickListener)new i(this));
    ((FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308496)).setOnClickListener((View.OnClickListener)new j(this));
    ((FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308508)).setOnClickListener((View.OnClickListener)new k(this));
    ((FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308515)).setOnClickListener((View.OnClickListener)new l(this));
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307387)).setOnClickListener((View.OnClickListener)FinderHomeActionBarUIC.m.tmD);
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(2131308021)).setOnDoubleClickListener((HardTouchableLayout.b)new n(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131307909)).setOnClickListener((View.OnClickListener)new o(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    Object localObject1 = com.tencent.mm.ui.component.a.KEX;
    localObject1 = (Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).fragments;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gkd();
      }
      Object localObject3 = (FinderHomeTabFragment)localObject2;
      localObject2 = paramBundle.cU();
      d.g.b.p.g(localObject2, "tabLayout.newTab()");
      localObject2 = new b((TabLayout.f)localObject2, ((FinderHomeTabFragment)localObject3).dvm);
      int j = ((FinderHomeTabFragment)localObject3).title;
      localObject3 = ((b)localObject2).titleTv;
      if (localObject3 != null)
      {
        Object localObject4 = com.tencent.mm.plugin.finder.storage.b.sHP;
        int k = ((b)localObject2).dvm;
        localObject4 = ((b)localObject2).vj.getCustomView();
        if (localObject4 == null) {
          d.g.b.p.gkB();
        }
        d.g.b.p.g(localObject4, "tab.customView!!");
        localObject4 = ((View)localObject4).getContext();
        d.g.b.p.g(localObject4, "tab.customView!!.context");
        localObject4 = ((Context)localObject4).getResources().getString(j);
        d.g.b.p.g(localObject4, "tab.customView!!.context.resources.getString(id)");
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.aZ(k, (String)localObject4));
      }
      ((b)localObject2).index = i;
      paramBundle.a(((b)localObject2).vj, false);
      i += 1;
    }
    paramBundle.a((TabLayout.b)new c(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBB(), (LifecycleOwner)getActivity(), (Observer)new p(this));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBE(), (LifecycleOwner)getActivity(), (Observer)new q(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBF(), (LifecycleOwner)getActivity(), (Observer)new r(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBH(), (LifecycleOwner)getActivity(), (Observer)new s(this, paramBundle));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBI(), (LifecycleOwner)getActivity(), (Observer)new t(this));
    GL(1);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
    i = ((Number)com.tencent.mm.plugin.finder.storage.b.cKg().value()).intValue();
    if (i == 0)
    {
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308515);
      d.g.b.p.g(paramBundle, "activity.searchEntranceLayout");
      paramBundle.setVisibility(8);
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308496);
      d.g.b.p.g(paramBundle, "activity.lbsEntranceLayout");
      paramBundle.setVisibility(0);
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308508);
      d.g.b.p.g(paramBundle, "activity.postEntranceLayout");
      paramBundle.setVisibility(8);
      AppMethodBeat.o(206194);
      return;
    }
    if (i == 1)
    {
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308515);
      d.g.b.p.g(paramBundle, "activity.searchEntranceLayout");
      paramBundle.setVisibility(8);
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308496);
      d.g.b.p.g(paramBundle, "activity.lbsEntranceLayout");
      paramBundle.setVisibility(8);
      paramBundle = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (com.tencent.mm.plugin.finder.utils.p.cOn() != 1)
      {
        paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308508);
        d.g.b.p.g(paramBundle, "activity.postEntranceLayout");
        paramBundle.setVisibility(0);
        AppMethodBeat.o(206194);
        return;
      }
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308508);
      d.g.b.p.g(paramBundle, "activity.postEntranceLayout");
      paramBundle.setVisibility(8);
      AppMethodBeat.o(206194);
      return;
    }
    if (i == 2)
    {
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308515);
      d.g.b.p.g(paramBundle, "activity.searchEntranceLayout");
      paramBundle.setVisibility(0);
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308496);
      d.g.b.p.g(paramBundle, "activity.lbsEntranceLayout");
      paramBundle.setVisibility(8);
      paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308508);
      d.g.b.p.g(paramBundle, "activity.postEntranceLayout");
      paramBundle.setVisibility(8);
      AppMethodBeat.o(206194);
      return;
    }
    paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308496);
    d.g.b.p.g(paramBundle, "activity.lbsEntranceLayout");
    paramBundle.setVisibility(8);
    paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308515);
    d.g.b.p.g(paramBundle, "activity.searchEntranceLayout");
    paramBundle.setVisibility(8);
    paramBundle = (FrameLayout)((FragmentActivity)getActivity()).findViewById(2131308508);
    d.g.b.p.g(paramBundle, "activity.postEntranceLayout");
    paramBundle.setVisibility(8);
    AppMethodBeat.o(206194);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206195);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(3761, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(206195);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206199);
    super.onPause();
    this.tmq = false;
    AppMethodBeat.o(206199);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206198);
    super.onResume();
    this.tmq = true;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cKg().value()).intValue();
    if (i == 2)
    {
      localObject = v.aAK();
      d.g.b.p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)localObject).length() > 0)
      {
        i = 1;
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        if (i == 0) {
          break label116;
        }
      }
      label116:
      for (i = 1;; i = 2)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(20971, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(1) });
        AppMethodBeat.o(206198);
        return;
        i = 0;
        break;
      }
    }
    if (i == 1)
    {
      localObject = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.G(true, 1);
    }
    AppMethodBeat.o(206198);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(206201);
    d.g.b.p.h(paramn, "scene");
    if (paramn.getType() == 3761) {
      this.tmv = false;
    }
    AppMethodBeat.o(206201);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "plugin-finder_release"})
  public static final class b
  {
    int dvm;
    int index;
    TextView titleTv;
    WeImageView tmx;
    ImageView tmy;
    TabLayout.f vj;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.f paramf, int paramInt)
    {
      AppMethodBeat.i(206168);
      this.vj = paramf;
      this.dvm = paramInt;
      this.vj.g(this);
      if (this.dvm == 1)
      {
        this.vj.ak(2131496215);
        paramf = this.vj.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308023);
          if (paramf == null) {
            d.g.b.p.gkB();
          }
          this.titleTv = paramf;
          paramf = this.titleTv;
          if (paramf != null) {
            paramf.setTextSize(1, 15.0F);
          }
          paramf = this.vj.getCustomView();
          if (paramf == null) {
            break label230;
          }
          paramf = (WeImageView)paramf.findViewById(2131308024);
          label124:
          if (paramf == null) {
            d.g.b.p.gkB();
          }
          this.tmx = paramf;
          paramf = this.vj.getCustomView();
          if (paramf == null) {
            break label235;
          }
        }
        label230:
        label235:
        for (paramf = (ImageView)paramf.findViewById(2131308025);; paramf = null)
        {
          if (paramf == null) {
            d.g.b.p.gkB();
          }
          this.tmy = paramf;
          paramf = this.tmx;
          if (paramf != null) {
            paramf.setImageResource(2131691517);
          }
          paramf = this.tmx;
          if (paramf == null) {
            break label240;
          }
          WeImageView localWeImageView = this.tmx;
          if (localWeImageView == null) {
            d.g.b.p.gkB();
          }
          paramf.setIconColor(localWeImageView.getResources().getColor(2131100212));
          AppMethodBeat.o(206168);
          return;
          paramf = null;
          break;
          paramf = null;
          break label124;
        }
        label240:
        AppMethodBeat.o(206168);
        return;
      }
      if ((this.dvm == 3) || (this.dvm == 4))
      {
        this.vj.ak(2131496214);
        paramf = this.vj.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308023);
          if (paramf == null) {
            d.g.b.p.gkB();
          }
          this.titleTv = paramf;
          paramf = this.titleTv;
          if (paramf != null) {
            paramf.setTextSize(1, 15.0F);
          }
          paramf = this.vj.getCustomView();
          if (paramf == null) {
            break label367;
          }
        }
        label367:
        for (paramf = (ImageView)paramf.findViewById(2131308022);; paramf = null)
        {
          if (paramf == null) {
            d.g.b.p.gkB();
          }
          this.tmy = paramf;
          AppMethodBeat.o(206168);
          return;
          paramf = null;
          break;
        }
      }
      d.g.b.p.g(this.vj.ak(2131496212), "tab.setCustomView(R.layo…finder_home_ui_tab_empty)");
      AppMethodBeat.o(206168);
    }
    
    public final void mB(boolean paramBoolean)
    {
      AppMethodBeat.i(206167);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          al.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(206167);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        d.g.b.p.g(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        d.g.b.p.g(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(206167);
        return;
      }
      AppMethodBeat.o(206167);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(206166);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        Object localObject = this.vj.getCustomView();
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        d.g.b.p.g(localObject, "tab.customView!!");
        localObject = ((View)localObject).getContext();
        d.g.b.p.g(localObject, "tab.customView!!.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(paramInt));
        AppMethodBeat.o(206166);
        return;
      }
      AppMethodBeat.o(206166);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    @SuppressLint({"ResourceType"})
    public final void f(TabLayout.f paramf)
    {
      AppMethodBeat.i(206171);
      d.g.b.p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100711);
        ((FinderHomeActionBarUIC.b)paramf).mB(true);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(this.tmz.getActivity()).get(FinderHomeUIC.class)).r(((FinderHomeActionBarUIC.b)paramf).dvm, null);
        switch (((FinderHomeActionBarUIC.b)paramf).dvm)
        {
        }
      }
      do
      {
        AppMethodBeat.o(206171);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tmx;
        if (paramf != null)
        {
          paramf.setImageResource(2131690422);
          AppMethodBeat.o(206171);
          return;
        }
        AppMethodBeat.o(206171);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tmx;
      } while (paramf == null);
      paramf.setImageResource(2131691517);
      paramf.setIconColor(paramf.getResources().getColor(2131100711));
      AppMethodBeat.o(206171);
    }
    
    @SuppressLint({"ResourceType"})
    public final void g(TabLayout.f paramf)
    {
      AppMethodBeat.i(206170);
      d.g.b.p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100212);
        ((FinderHomeActionBarUIC.b)paramf).mB(false);
        switch (((FinderHomeActionBarUIC.b)paramf).dvm)
        {
        }
      }
      do
      {
        AppMethodBeat.o(206170);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tmx;
        if (paramf != null)
        {
          paramf.setImageResource(2131690589);
          AppMethodBeat.o(206170);
          return;
        }
        AppMethodBeat.o(206170);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tmx;
      } while (paramf == null);
      paramf.setImageResource(2131691536);
      paramf.setIconColor(paramf.getResources().getColor(2131100212));
      AppMethodBeat.o(206170);
    }
    
    @SuppressLint({"ResourceType"})
    public final void h(TabLayout.f paramf)
    {
      AppMethodBeat.i(206169);
      d.g.b.p.h(paramf, "t");
      AppMethodBeat.o(206169);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements n.e
  {
    e(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(206174);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (com.tencent.mm.plugin.finder.utils.p.aq((Activity)this.tmz.getActivity()))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("scene", 1);
        com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.w((Context)this.tmz.getActivity(), paramMenuItem);
      }
      AppMethodBeat.o(206174);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(String paramString, MMActivity paramMMActivity) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(206177);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        localIntent.putExtra("key_finder_post_id", this.spL);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.sjk, localIntent);
        AppMethodBeat.o(206177);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    public static final h tmC;
    
    static
    {
      AppMethodBeat.i(206179);
      tmC = new h();
      AppMethodBeat.o(206179);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(206178);
      com.tencent.mm.plugin.finder.report.g localg = com.tencent.mm.plugin.finder.report.g.syJ;
      com.tencent.mm.plugin.finder.report.g.Fs(6);
      AppMethodBeat.o(206178);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206180);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = FinderReporterUIC.tnG;
      paramView = FinderReporterUIC.a.fc((Context)this.tmz.getActivity());
      if (paramView != null)
      {
        paramView = FinderReporterUIC.c(paramView);
        if ((paramView != null) && ((paramView instanceof com.tencent.mm.plugin.finder.report.l)))
        {
          paramView = (com.tencent.mm.plugin.finder.report.l)paramView;
          localObject = c.sxE;
          paramView.aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(5)))));
        }
      }
      this.tmz.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206180);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206181);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.cFn();
      paramView = new Intent();
      localObject = FinderReporterUIC.tnG;
      FinderReporterUIC.a.a((Context)this.tmz.getActivity(), paramView, 0L, 0, true, 60);
      localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.b(this.tmz.getActivity(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206181);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206182);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FinderHomeActionBarUIC.a(this.tmz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206182);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206183);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = v.aAK();
      d.g.b.p.g(paramView, "ConfigStorageLogic.getMyFinderUsername()");
      if (((CharSequence)paramView).length() > 0)
      {
        i = 1;
        paramView = com.tencent.mm.plugin.report.service.g.yxI;
        if (i == 0) {
          break label172;
        }
      }
      label172:
      for (int i = 1;; i = 2)
      {
        paramView.f(20971, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(1) });
        paramView = new Intent();
        localObject = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)this.tmz.getActivity(), paramView, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.A((Context)this.tmz.getActivity(), paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206183);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$6", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class n
    implements HardTouchableLayout.b
  {
    public final void ea(View paramView)
    {
      AppMethodBeat.i(206187);
      d.g.b.p.h(paramView, "view");
      com.tencent.mm.sdk.platformtools.ae.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
      h.MqF.aM((Runnable)new a(this));
      AppMethodBeat.o(206187);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderHomeActionBarUIC.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(206186);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(this.tmE.tmz.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().cNd();
        AppMethodBeat.o(206186);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(206188);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).ahF());
      paramView = FinderReporterUIC.tnG;
      paramView = FinderReporterUIC.a.fc((Context)this.tmz.getActivity());
      if (paramView != null)
      {
        paramView = FinderReporterUIC.c(paramView);
        if ((paramView instanceof com.tencent.mm.plugin.finder.report.l))
        {
          paramView = (com.tencent.mm.plugin.finder.report.l)paramView;
          localObject2 = c.sxE;
          paramView.aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(3)))));
        }
        FinderHomeActionBarUIC.a(this.tmz, 2);
        localObject2 = new Intent();
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().aij("TLPersonalCenter");
        paramView = localObject1;
        if (locali != null) {
          paramView = locali.aim("TLPersonalCenter");
        }
        if (paramView == null) {
          break label246;
        }
      }
      label246:
      for (boolean bool = true;; bool = false)
      {
        paramView = FinderSelfUI.sRG;
        ((Intent)localObject2).putExtra(FinderSelfUI.cMT(), bool);
        paramView = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)this.tmz.getActivity(), (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
        com.tencent.mm.plugin.finder.utils.a.y((Context)this.tmz.getActivity(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206188);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class p<T>
    implements Observer<g.a>
  {
    p(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class q<T>
    implements Observer<g.a>
  {
    q(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class r<T>
    implements Observer<g.a>
  {
    r(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class s<T>
    implements Observer<g.a>
  {
    s(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class t<T>
    implements Observer<g.a>
  {
    t(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC
 * JD-Core Version:    0.7.0.1
 */