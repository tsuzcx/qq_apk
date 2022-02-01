package com.tencent.mm.plugin.finder.viewmodel.component;

import android.annotation.SuppressLint;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.d;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.report.c.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import d.a.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.u;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "isCurrentResume", "", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "buildTab", "", "checkPersonCenterRedDotReport", "action", "", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerRedDot", "setTabIndex", "index", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"})
public final class FinderHomeActionBarUIC
  extends UIComponent
{
  public static final a tbF;
  private boolean tbA;
  private String tbB;
  private String tbC;
  private String tbD;
  private String tbE;
  private String tbz;
  
  static
  {
    AppMethodBeat.i(205577);
    tbF = new a((byte)0);
    AppMethodBeat.o(205577);
  }
  
  public FinderHomeActionBarUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205576);
    this.tbz = "";
    this.tbB = "";
    this.tbC = "";
    this.tbD = "";
    this.tbE = "";
    AppMethodBeat.o(205576);
  }
  
  private final void Gp(int paramInt)
  {
    AppMethodBeat.i(205572);
    Object localObject = FinderReporterUIC.tcM;
    localObject = FinderReporterUIC.a.eY((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
    {
      d.a locala = d.rRT;
      this.tbz = d.a.a(paramInt, (aqy)localObject, this.tbz);
      AppMethodBeat.o(205572);
      return;
    }
  }
  
  public final void Gq(int paramInt)
  {
    AppMethodBeat.i(205573);
    Object localObject = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    if (localObject != null)
    {
      localObject = ((TabLayout)localObject).ad(paramInt);
      if (localObject != null)
      {
        p.g(localObject, "this");
        if (!((TabLayout.f)localObject).isSelected()) {
          ((TabLayout.f)localObject).select();
        }
        AppMethodBeat.o(205573);
        return;
      }
    }
    AppMethodBeat.o(205573);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(205571);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307276)).setOnClickListener((View.OnClickListener)new d(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131307486)).setOnClickListener((View.OnClickListener)new e(this));
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307387)).setOnClickListener((View.OnClickListener)FinderHomeActionBarUIC.f.tbJ);
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(2131308021)).setOnDoubleClickListener((HardTouchableLayout.b)new g(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131307909)).setOnClickListener((View.OnClickListener)new h(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    Object localObject1 = com.tencent.mm.ui.component.a.KiD;
    localObject1 = ((Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).fragments).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gfB();
      }
      Object localObject3 = (FinderHomeTabFragment)localObject2;
      localObject2 = paramBundle.cU();
      p.g(localObject2, "tabLayout.newTab()");
      localObject2 = new b((TabLayout.f)localObject2, ((FinderHomeTabFragment)localObject3).duh);
      int j = ((FinderHomeTabFragment)localObject3).title;
      localObject3 = ((b)localObject2).titleTv;
      if (localObject3 != null)
      {
        Object localObject4 = com.tencent.mm.plugin.finder.storage.b.sxa;
        int k = ((b)localObject2).duh;
        localObject4 = ((b)localObject2).vj.getCustomView();
        if (localObject4 == null) {
          p.gfZ();
        }
        p.g(localObject4, "tab.customView!!");
        localObject4 = ((View)localObject4).getContext();
        p.g(localObject4, "tab.customView!!.context");
        localObject4 = ((Context)localObject4).getResources().getString(j);
        p.g(localObject4, "tab.customView!!.context.resources.getString(id)");
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.ba(k, (String)localObject4));
      }
      ((b)localObject2).index = i;
      paramBundle.a(((b)localObject2).vj, false);
      i += 1;
    }
    paramBundle.a((TabLayout.b)new c(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czW(), (LifecycleOwner)getActivity(), (Observer)new i(this));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czY(), (LifecycleOwner)getActivity(), (Observer)new j(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czZ(), (LifecycleOwner)getActivity(), (Observer)new k(this, paramBundle));
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    localObject1 = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cAb(), (LifecycleOwner)getActivity(), (Observer)new l(this, paramBundle));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
    com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cAc(), (LifecycleOwner)getActivity(), (Observer)new m(this));
    Gp(1);
    AppMethodBeat.o(205571);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205575);
    super.onPause();
    this.tbA = false;
    AppMethodBeat.o(205575);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205574);
    super.onResume();
    this.tbA = true;
    AppMethodBeat.o(205574);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "plugin-finder_release"})
  public static final class b
  {
    int duh;
    int index;
    WeImageView tbG;
    ImageView tbH;
    TextView titleTv;
    TabLayout.f vj;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.f paramf, int paramInt)
    {
      AppMethodBeat.i(205555);
      this.vj = paramf;
      this.duh = paramInt;
      this.vj.g(this);
      if (this.duh == 1)
      {
        this.vj.ak(2131496215);
        paramf = this.vj.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308023);
          if (paramf == null) {
            p.gfZ();
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
            p.gfZ();
          }
          this.tbG = paramf;
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
            p.gfZ();
          }
          this.tbH = paramf;
          paramf = this.tbG;
          if (paramf != null) {
            paramf.setImageResource(2131691517);
          }
          paramf = this.tbG;
          if (paramf == null) {
            break label240;
          }
          WeImageView localWeImageView = this.tbG;
          if (localWeImageView == null) {
            p.gfZ();
          }
          paramf.setIconColor(localWeImageView.getResources().getColor(2131100212));
          AppMethodBeat.o(205555);
          return;
          paramf = null;
          break;
          paramf = null;
          break label124;
        }
        label240:
        AppMethodBeat.o(205555);
        return;
      }
      if ((this.duh == 3) || (this.duh == 4))
      {
        this.vj.ak(2131496214);
        paramf = this.vj.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308023);
          if (paramf == null) {
            p.gfZ();
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
            p.gfZ();
          }
          this.tbH = paramf;
          AppMethodBeat.o(205555);
          return;
          paramf = null;
          break;
        }
      }
      p.g(this.vj.ak(2131496212), "tab.setCustomView(R.layo…finder_home_ui_tab_empty)");
      AppMethodBeat.o(205555);
    }
    
    public final void mx(boolean paramBoolean)
    {
      AppMethodBeat.i(205554);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          al.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(205554);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        p.g(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        p.g(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(205554);
        return;
      }
      AppMethodBeat.o(205554);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(205553);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        Object localObject = this.vj.getCustomView();
        if (localObject == null) {
          p.gfZ();
        }
        p.g(localObject, "tab.customView!!");
        localObject = ((View)localObject).getContext();
        p.g(localObject, "tab.customView!!.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(paramInt));
        AppMethodBeat.o(205553);
        return;
      }
      AppMethodBeat.o(205553);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    @SuppressLint({"ResourceType"})
    public final void f(TabLayout.f paramf)
    {
      AppMethodBeat.i(205558);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100711);
        ((FinderHomeActionBarUIC.b)paramf).mx(true);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(this.tbI.getActivity()).get(FinderHomeUIC.class)).r(((FinderHomeActionBarUIC.b)paramf).duh, null);
        switch (((FinderHomeActionBarUIC.b)paramf).duh)
        {
        }
      }
      do
      {
        AppMethodBeat.o(205558);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tbG;
        if (paramf != null)
        {
          paramf.setImageResource(2131690422);
          AppMethodBeat.o(205558);
          return;
        }
        AppMethodBeat.o(205558);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tbG;
      } while (paramf == null);
      paramf.setImageResource(2131691517);
      paramf.setIconColor(paramf.getResources().getColor(2131100711));
      AppMethodBeat.o(205558);
    }
    
    @SuppressLint({"ResourceType"})
    public final void g(TabLayout.f paramf)
    {
      AppMethodBeat.i(205557);
      p.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100212);
        ((FinderHomeActionBarUIC.b)paramf).mx(false);
        switch (((FinderHomeActionBarUIC.b)paramf).duh)
        {
        }
      }
      do
      {
        AppMethodBeat.o(205557);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tbG;
        if (paramf != null)
        {
          paramf.setImageResource(2131690589);
          AppMethodBeat.o(205557);
          return;
        }
        AppMethodBeat.o(205557);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).tbG;
      } while (paramf == null);
      paramf.setImageResource(2131691536);
      paramf.setIconColor(paramf.getResources().getColor(2131100212));
      AppMethodBeat.o(205557);
    }
    
    @SuppressLint({"ResourceType"})
    public final void h(TabLayout.f paramf)
    {
      AppMethodBeat.i(205556);
      p.h(paramf, "t");
      AppMethodBeat.o(205556);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205559);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = FinderReporterUIC.tcM;
      paramView = FinderReporterUIC.a.eY((Context)this.tbI.getActivity());
      if (paramView != null)
      {
        paramView = FinderReporterUIC.c(paramView);
        if ((paramView != null) && ((paramView instanceof k)))
        {
          paramView = (k)paramView;
          localObject = c.snN;
          paramView.ahO(c.a.Y(ae.c(u.S("feedActionType", Integer.valueOf(5)))));
        }
      }
      this.tbI.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205559);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205560);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.cDs();
      paramView = new Intent();
      localObject = FinderReporterUIC.tcM;
      FinderReporterUIC.a.a((Context)this.tbI.getActivity(), paramView, 0L, 0, true, 60);
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.b(this.tbI.getActivity(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205560);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class g
    implements HardTouchableLayout.b
  {
    public final void ea(View paramView)
    {
      AppMethodBeat.i(205564);
      p.h(paramView, "view");
      ad.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
      h.LTJ.aP((Runnable)new a(this));
      AppMethodBeat.o(205564);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderHomeActionBarUIC.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(205563);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(this.tbK.tbI.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().cKz();
        AppMethodBeat.o(205563);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(205565);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).ahq());
      paramView = FinderReporterUIC.tcM;
      paramView = FinderReporterUIC.a.eY((Context)this.tbI.getActivity());
      if (paramView != null)
      {
        paramView = FinderReporterUIC.c(paramView);
        if ((paramView instanceof k))
        {
          paramView = (k)paramView;
          localObject2 = c.snN;
          paramView.ahO(c.a.Y(ae.c(u.S("feedActionType", Integer.valueOf(3)))));
        }
        FinderHomeActionBarUIC.a(this.tbI, 2);
        localObject2 = new Intent();
        paramView = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)paramView).getRedDotManager().ahn("TLPersonalCenter");
        paramView = localObject1;
        if (locali != null) {
          paramView = locali.ahq("TLPersonalCenter");
        }
        if (paramView == null) {
          break label246;
        }
      }
      label246:
      for (boolean bool = true;; bool = false)
      {
        paramView = FinderSelfUI.sGL;
        ((Intent)localObject2).putExtra(FinderSelfUI.cKq(), bool);
        paramView = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a((Context)this.tbI.getActivity(), (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.y((Context)this.tbI.getActivity(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205565);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class i<T>
    implements Observer<g.a>
  {
    i(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class j<T>
    implements Observer<g.a>
  {
    j(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class k<T>
    implements Observer<g.a>
  {
    k(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class l<T>
    implements Observer<g.a>
  {
    l(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<g.a>
  {
    m(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC
 * JD-Core Version:    0.7.0.1
 */