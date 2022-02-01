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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.b.a;
import com.tencent.mm.plugin.finder.extension.reddot.d;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import d.g.b.k;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "isCurrentResume", "", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "buildTab", "", "checkPersonCenterRedDotReport", "action", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerRedDot", "setTabIndex", "index", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"})
public final class FinderHomeActionBarUIC
  extends UIComponent
{
  public static final a Lig;
  private String Lia;
  private boolean Lib;
  private String Lic;
  private String Lid;
  private String Lie;
  private String Lif;
  
  static
  {
    AppMethodBeat.i(200408);
    Lig = new a((byte)0);
    AppMethodBeat.o(200408);
  }
  
  public FinderHomeActionBarUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200407);
    this.Lia = "";
    this.Lic = "";
    this.Lid = "";
    this.Lie = "";
    this.Lif = "";
    AppMethodBeat.o(200407);
  }
  
  private final void ahS(int paramInt)
  {
    AppMethodBeat.i(200403);
    Object localObject = FinderReporterUIC.Ljl;
    localObject = FinderReporterUIC.a.lB((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).fXs();; localObject = null)
    {
      b.a locala = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
      this.Lia = b.a.a(paramInt, (dzp)localObject, this.Lia);
      AppMethodBeat.o(200403);
      return;
    }
  }
  
  public final void ahT(int paramInt)
  {
    AppMethodBeat.i(200404);
    TabLayout.f localf = ((TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596)).ad(paramInt);
    if (localf != null)
    {
      k.g(localf, "this");
      if (!localf.isSelected()) {
        localf.select();
      }
      AppMethodBeat.o(200404);
      return;
    }
    AppMethodBeat.o(200404);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(200402);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307263)).setOnClickListener((View.OnClickListener)new d(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131307410)).setOnClickListener((View.OnClickListener)new e(this));
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307318)).setOnClickListener((View.OnClickListener)f.Lik);
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(2131307884)).setOnDoubleClickListener((HardTouchableLayout.b)new g(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131307817)).setOnClickListener((View.OnClickListener)new h(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    Object localObject1 = com.tencent.mm.ui.component.a.LCX;
    localObject1 = ((Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).fragments).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.fvx();
      }
      Object localObject3 = (FinderHomeTabFragment)localObject2;
      localObject2 = paramBundle.cx();
      k.g(localObject2, "tabLayout.newTab()");
      localObject2 = new b((TabLayout.f)localObject2, ((FinderHomeTabFragment)localObject3).IoU);
      int j = ((FinderHomeTabFragment)localObject3).title;
      localObject3 = ((b)localObject2).titleTv;
      if (localObject3 != null)
      {
        Object localObject4 = com.tencent.mm.plugin.finder.storage.b.qJA;
        int k = ((b)localObject2).IoU;
        localObject4 = ((b)localObject2).sr.getCustomView();
        if (localObject4 == null) {
          k.fvU();
        }
        k.g(localObject4, "tab.customView!!");
        localObject4 = ((View)localObject4).getContext();
        k.g(localObject4, "tab.customView!!.context");
        localObject4 = ((Context)localObject4).getResources().getString(j);
        k.g(localObject4, "tab.customView!!.context.resources.getString(id)");
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cU(k, (String)localObject4));
      }
      ((b)localObject2).index = i;
      paramBundle.a(((b)localObject2).sr, false);
      i += 1;
    }
    paramBundle.a((TabLayout.b)new c(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    localObject1 = d.qtG;
    localObject1 = d.qtG;
    d.a(d.cls(), (LifecycleOwner)getActivity(), (Observer)new i(this));
    localObject1 = d.qtG;
    localObject1 = d.qtG;
    d.a(d.fSM(), (LifecycleOwner)getActivity(), (Observer)new j(this, paramBundle));
    localObject1 = d.qtG;
    localObject1 = d.qtG;
    d.a(d.fSN(), (LifecycleOwner)getActivity(), (Observer)new k(this, paramBundle));
    localObject1 = d.qtG;
    localObject1 = d.qtG;
    d.a(d.fSP(), (LifecycleOwner)getActivity(), (Observer)new l(this, paramBundle));
    paramBundle = d.qtG;
    paramBundle = d.qtG;
    d.a(d.fSQ(), (LifecycleOwner)getActivity(), (Observer)new m(this));
    ahS(1);
    AppMethodBeat.o(200402);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200406);
    super.onPause();
    this.Lib = false;
    AppMethodBeat.o(200406);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200405);
    super.onResume();
    this.Lib = true;
    AppMethodBeat.o(200405);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "plugin-finder_release"})
  public static final class b
  {
    int IoU;
    WeImageView Lih;
    ImageView Lii;
    int index;
    TabLayout.f sr;
    TextView titleTv;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.f paramf, int paramInt)
    {
      AppMethodBeat.i(200387);
      this.sr = paramf;
      this.IoU = paramInt;
      this.sr.gb(this);
      if (this.IoU == 1)
      {
        this.sr.ak(2131496214);
        paramf = this.sr.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131307886);
          if (paramf == null) {
            k.fvU();
          }
          this.titleTv = paramf;
          paramf = this.titleTv;
          if (paramf != null) {
            paramf.setTextSize(1, 15.0F);
          }
          paramf = this.sr.getCustomView();
          if (paramf == null) {
            break label230;
          }
          paramf = (WeImageView)paramf.findViewById(2131307887);
          label124:
          if (paramf == null) {
            k.fvU();
          }
          this.Lih = paramf;
          paramf = this.sr.getCustomView();
          if (paramf == null) {
            break label235;
          }
        }
        label230:
        label235:
        for (paramf = (ImageView)paramf.findViewById(2131307888);; paramf = null)
        {
          if (paramf == null) {
            k.fvU();
          }
          this.Lii = paramf;
          paramf = this.Lih;
          if (paramf != null) {
            paramf.setImageResource(2131691506);
          }
          paramf = this.Lih;
          if (paramf == null) {
            break label240;
          }
          WeImageView localWeImageView = this.Lih;
          if (localWeImageView == null) {
            k.fvU();
          }
          paramf.setIconColor(localWeImageView.getResources().getColor(2131100212));
          AppMethodBeat.o(200387);
          return;
          paramf = null;
          break;
          paramf = null;
          break label124;
        }
        label240:
        AppMethodBeat.o(200387);
        return;
      }
      if ((this.IoU == 3) || (this.IoU == 4))
      {
        this.sr.ak(2131496213);
        paramf = this.sr.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131307886);
          if (paramf == null) {
            k.fvU();
          }
          this.titleTv = paramf;
          paramf = this.titleTv;
          if (paramf != null) {
            paramf.setTextSize(1, 15.0F);
          }
          paramf = this.sr.getCustomView();
          if (paramf == null) {
            break label367;
          }
        }
        label367:
        for (paramf = (ImageView)paramf.findViewById(2131307885);; paramf = null)
        {
          if (paramf == null) {
            k.fvU();
          }
          this.Lii = paramf;
          AppMethodBeat.o(200387);
          return;
          paramf = null;
          break;
        }
      }
      k.g(this.sr.ak(2131496211), "tab.setCustomView(R.layo…finder_home_ui_tab_empty)");
      AppMethodBeat.o(200387);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(200385);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        Object localObject = this.sr.getCustomView();
        if (localObject == null) {
          k.fvU();
        }
        k.g(localObject, "tab.customView!!");
        localObject = ((View)localObject).getContext();
        k.g(localObject, "tab.customView!!.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(paramInt));
        AppMethodBeat.o(200385);
        return;
      }
      AppMethodBeat.o(200385);
    }
    
    public final void yS(boolean paramBoolean)
    {
      AppMethodBeat.i(200386);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ai.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(200386);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        k.g(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        k.g(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(200386);
        return;
      }
      AppMethodBeat.o(200386);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    @SuppressLint({"ResourceType"})
    public final void f(TabLayout.f paramf)
    {
      AppMethodBeat.i(200390);
      k.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100711);
        ((FinderHomeActionBarUIC.b)paramf).yS(true);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(this.Lij.getActivity()).get(FinderHomeUIC.class)).ahU(((FinderHomeActionBarUIC.b)paramf).IoU);
        switch (((FinderHomeActionBarUIC.b)paramf).IoU)
        {
        }
      }
      do
      {
        AppMethodBeat.o(200390);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).Lih;
        if (paramf != null)
        {
          paramf.setImageResource(2131690422);
          AppMethodBeat.o(200390);
          return;
        }
        AppMethodBeat.o(200390);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).Lih;
      } while (paramf == null);
      paramf.setImageResource(2131691506);
      paramf.setIconColor(paramf.getResources().getColor(2131100711));
      AppMethodBeat.o(200390);
    }
    
    @SuppressLint({"ResourceType"})
    public final void g(TabLayout.f paramf)
    {
      AppMethodBeat.i(200389);
      k.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100212);
        ((FinderHomeActionBarUIC.b)paramf).yS(false);
        switch (((FinderHomeActionBarUIC.b)paramf).IoU)
        {
        }
      }
      do
      {
        AppMethodBeat.o(200389);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).Lih;
        if (paramf != null)
        {
          paramf.setImageResource(2131690589);
          AppMethodBeat.o(200389);
          return;
        }
        AppMethodBeat.o(200389);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).Lih;
      } while (paramf == null);
      paramf.setImageResource(2131691521);
      paramf.setIconColor(paramf.getResources().getColor(2131100212));
      AppMethodBeat.o(200389);
    }
    
    @SuppressLint({"ResourceType"})
    public final void h(TabLayout.f paramf)
    {
      AppMethodBeat.i(200388);
      k.h(paramf, "t");
      AppMethodBeat.o(200388);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200391);
      this.Lij.getActivity().finish();
      AppMethodBeat.o(200391);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200392);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a((Context)this.Lij.getActivity(), paramView, 0L, 0, true, 60);
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.b(this.Lij.getActivity(), paramView);
      AppMethodBeat.o(200392);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    public static final f Lik;
    
    static
    {
      AppMethodBeat.i(200393);
      Lik = new f();
      AppMethodBeat.o(200393);
    }
    
    public final void onClick(View paramView) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class g
    implements HardTouchableLayout.b
  {
    public final void dQ(View paramView)
    {
      AppMethodBeat.i(200395);
      k.h(paramView, "view");
      ad.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
      com.tencent.e.h.Iye.aN((Runnable)new a(this));
      AppMethodBeat.o(200395);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderHomeActionBarUIC.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(200394);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(this.Lil.Lij.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().fVI();
        AppMethodBeat.o(200394);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200396);
      FinderHomeActionBarUIC.a(this.Lij, 2);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.Ljl;
      FinderReporterUIC.a.a((Context)this.Lij.getActivity(), paramView, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      com.tencent.mm.plugin.finder.utils.a.x((Context)this.Lij.getActivity(), paramView);
      paramView = g.ad(com.tencent.mm.plugin.i.a.j.class);
      k.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((com.tencent.mm.plugin.i.a.j)paramView).getRedDotManager().YU("TLPersonalCenter");
      AppMethodBeat.o(200396);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class i<T>
    implements Observer<d.a>
  {
    i(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class j<T>
    implements Observer<d.a>
  {
    j(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class k<T>
    implements Observer<d.a>
  {
    k(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class l<T>
    implements Observer<d.a>
  {
    l(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<d.a>
  {
    m(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC
 * JD-Core Version:    0.7.0.1
 */