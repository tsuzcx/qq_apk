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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.plugin.finder.extension.reddot.c.a;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.HardTouchableLayout.b;
import d.g.b.k;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "isCurrentResume", "", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "buildTab", "", "checkPersonCenterRedDotReport", "action", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerRedDot", "setTabIndex", "index", "findByTag", "Landroid/support/design/widget/TabLayout$Tab;", "Landroid/support/design/widget/TabLayout;", "any", "", "Companion", "FinderTab", "plugin-finder_release"})
public final class FinderHomeActionBarUIC
  extends UIComponent
{
  public static final FinderHomeActionBarUIC.a sdJ;
  private String sdD;
  private boolean sdE;
  private String sdF;
  private String sdG;
  private String sdH;
  private String sdI;
  
  static
  {
    AppMethodBeat.i(204533);
    sdJ = new FinderHomeActionBarUIC.a((byte)0);
    AppMethodBeat.o(204533);
  }
  
  public FinderHomeActionBarUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204532);
    this.sdD = "";
    this.sdF = "";
    this.sdG = "";
    this.sdH = "";
    this.sdI = "";
    AppMethodBeat.o(204532);
  }
  
  private final void EZ(int paramInt)
  {
    AppMethodBeat.i(204528);
    Object localObject = FinderReporterUIC.seQ;
    localObject = FinderReporterUIC.a.eV((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cGb();; localObject = null)
    {
      c.a locala = c.rem;
      this.sdD = c.a.a(paramInt, (anm)localObject, this.sdD);
      AppMethodBeat.o(204528);
      return;
    }
  }
  
  public final void Fa(int paramInt)
  {
    AppMethodBeat.i(204529);
    TabLayout.f localf = ((TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596)).ad(paramInt);
    if (localf != null)
    {
      k.g(localf, "this");
      if (!localf.isSelected()) {
        localf.select();
      }
      AppMethodBeat.o(204529);
      return;
    }
    AppMethodBeat.o(204529);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(204527);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307276)).setOnClickListener((View.OnClickListener)new d(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131307486)).setOnClickListener((View.OnClickListener)new e(this));
    ((LinearLayout)((FragmentActivity)getActivity()).findViewById(2131307387)).setOnClickListener((View.OnClickListener)FinderHomeActionBarUIC.f.sdN);
    ((HardTouchableLayout)((FragmentActivity)getActivity()).findViewById(2131308021)).setOnDoubleClickListener((HardTouchableLayout.b)new g(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131307909)).setOnClickListener((View.OnClickListener)new h(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    Object localObject1 = com.tencent.mm.ui.component.a.IrY;
    localObject1 = ((Iterable)((FinderHomeUIC)com.tencent.mm.ui.component.a.q(getActivity()).get(FinderHomeUIC.class)).fragments).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.fOc();
      }
      Object localObject3 = (FinderHomeTabFragment)localObject2;
      localObject2 = paramBundle.cE();
      k.g(localObject2, "tabLayout.newTab()");
      localObject2 = new b((TabLayout.f)localObject2, ((FinderHomeTabFragment)localObject3).diw);
      int j = ((FinderHomeTabFragment)localObject3).title;
      localObject3 = ((b)localObject2).titleTv;
      if (localObject3 != null)
      {
        Object localObject4 = b.rCU;
        int k = ((b)localObject2).diw;
        localObject4 = ((b)localObject2).tq.getCustomView();
        if (localObject4 == null) {
          k.fOy();
        }
        k.g(localObject4, "tab.customView!!");
        localObject4 = ((View)localObject4).getContext();
        k.g(localObject4, "tab.customView!!.context");
        localObject4 = ((Context)localObject4).getResources().getString(j);
        k.g(localObject4, "tab.customView!!.context.resources.getString(id)");
        ((TextView)localObject3).setText((CharSequence)b.aX(k, (String)localObject4));
      }
      ((b)localObject2).index = i;
      paramBundle.a(((b)localObject2).tq, false);
      i += 1;
    }
    paramBundle.a((TabLayout.b)new c(this));
    paramBundle = (TabLayout)((FragmentActivity)getActivity()).findViewById(2131305596);
    localObject1 = f.rfl;
    localObject1 = f.rfl;
    f.a(f.ctO(), (LifecycleOwner)getActivity(), (Observer)new i(this));
    localObject1 = f.rfl;
    localObject1 = f.rfl;
    f.a(f.ctQ(), (LifecycleOwner)getActivity(), (Observer)new j(this, paramBundle));
    localObject1 = f.rfl;
    localObject1 = f.rfl;
    f.a(f.ctR(), (LifecycleOwner)getActivity(), (Observer)new k(this, paramBundle));
    localObject1 = f.rfl;
    localObject1 = f.rfl;
    f.a(f.ctT(), (LifecycleOwner)getActivity(), (Observer)new l(this, paramBundle));
    paramBundle = f.rfl;
    paramBundle = f.rfl;
    f.a(f.ctU(), (LifecycleOwner)getActivity(), (Observer)new m(this));
    EZ(1);
    AppMethodBeat.o(204527);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204531);
    super.onPause();
    this.sdE = false;
    AppMethodBeat.o(204531);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204530);
    super.onResume();
    this.sdE = true;
    AppMethodBeat.o(204530);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$FinderTab;", "", "tab", "Landroid/support/design/widget/TabLayout$Tab;", "tabType", "", "(Landroid/support/design/widget/TabLayout$Tab;I)V", "index", "getIndex", "()I", "setIndex", "(I)V", "getTab", "()Landroid/support/design/widget/TabLayout$Tab;", "setTab", "(Landroid/support/design/widget/TabLayout$Tab;)V", "tabRedIv", "Landroid/widget/ImageView;", "getTabRedIv", "()Landroid/widget/ImageView;", "setTabRedIv", "(Landroid/widget/ImageView;)V", "getTabType", "setTabType", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "setTextBold", "", "isBold", "", "setTextColor", "id", "setTitle", "plugin-finder_release"})
  public static final class b
  {
    int diw;
    int index;
    WeImageView sdK;
    ImageView sdL;
    TextView titleTv;
    TabLayout.f tq;
    
    @SuppressLint({"ResourceType"})
    public b(TabLayout.f paramf, int paramInt)
    {
      AppMethodBeat.i(204512);
      this.tq = paramf;
      this.diw = paramInt;
      this.tq.f(this);
      if (this.diw == 1)
      {
        this.tq.ak(2131496215);
        paramf = this.tq.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308023);
          if (paramf == null) {
            k.fOy();
          }
          this.titleTv = paramf;
          paramf = this.titleTv;
          if (paramf != null) {
            paramf.setTextSize(1, 15.0F);
          }
          paramf = this.tq.getCustomView();
          if (paramf == null) {
            break label230;
          }
          paramf = (WeImageView)paramf.findViewById(2131308024);
          label124:
          if (paramf == null) {
            k.fOy();
          }
          this.sdK = paramf;
          paramf = this.tq.getCustomView();
          if (paramf == null) {
            break label235;
          }
        }
        label230:
        label235:
        for (paramf = (ImageView)paramf.findViewById(2131308025);; paramf = null)
        {
          if (paramf == null) {
            k.fOy();
          }
          this.sdL = paramf;
          paramf = this.sdK;
          if (paramf != null) {
            paramf.setImageResource(2131691517);
          }
          paramf = this.sdK;
          if (paramf == null) {
            break label240;
          }
          WeImageView localWeImageView = this.sdK;
          if (localWeImageView == null) {
            k.fOy();
          }
          paramf.setIconColor(localWeImageView.getResources().getColor(2131100212));
          AppMethodBeat.o(204512);
          return;
          paramf = null;
          break;
          paramf = null;
          break label124;
        }
        label240:
        AppMethodBeat.o(204512);
        return;
      }
      if ((this.diw == 3) || (this.diw == 4))
      {
        this.tq.ak(2131496214);
        paramf = this.tq.getCustomView();
        if (paramf != null)
        {
          paramf = (TextView)paramf.findViewById(2131308023);
          if (paramf == null) {
            k.fOy();
          }
          this.titleTv = paramf;
          paramf = this.titleTv;
          if (paramf != null) {
            paramf.setTextSize(1, 15.0F);
          }
          paramf = this.tq.getCustomView();
          if (paramf == null) {
            break label367;
          }
        }
        label367:
        for (paramf = (ImageView)paramf.findViewById(2131308022);; paramf = null)
        {
          if (paramf == null) {
            k.fOy();
          }
          this.sdL = paramf;
          AppMethodBeat.o(204512);
          return;
          paramf = null;
          break;
        }
      }
      k.g(this.tq.ak(2131496212), "tab.setCustomView(R.layo…finder_home_ui_tab_empty)");
      AppMethodBeat.o(204512);
    }
    
    public final void me(boolean paramBoolean)
    {
      AppMethodBeat.i(204511);
      Object localObject = this.titleTv;
      if (localObject != null)
      {
        if (paramBoolean)
        {
          aj.a((Paint)((TextView)localObject).getPaint(), 0.8F);
          AppMethodBeat.o(204511);
          return;
        }
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        k.g(localTextPaint, "it.paint");
        localTextPaint.setFakeBoldText(false);
        localObject = ((TextView)localObject).getPaint();
        k.g(localObject, "it.paint");
        ((TextPaint)localObject).setStrokeWidth(0.0F);
        AppMethodBeat.o(204511);
        return;
      }
      AppMethodBeat.o(204511);
    }
    
    public final void setTextColor(int paramInt)
    {
      AppMethodBeat.i(204510);
      TextView localTextView = this.titleTv;
      if (localTextView != null)
      {
        Object localObject = this.tq.getCustomView();
        if (localObject == null) {
          k.fOy();
        }
        k.g(localObject, "tab.customView!!");
        localObject = ((View)localObject).getContext();
        k.g(localObject, "tab.customView!!.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(paramInt));
        AppMethodBeat.o(204510);
        return;
      }
      AppMethodBeat.o(204510);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$buildTab$2", "Landroid/support/design/widget/TabLayout$BaseOnTabSelectedListener;", "Landroid/support/design/widget/TabLayout$Tab;", "onTabReselected", "", "t", "onTabSelected", "onTabUnselected", "plugin-finder_release"})
  public static final class c
    implements TabLayout.b<TabLayout.f>
  {
    @SuppressLint({"ResourceType"})
    public final void f(TabLayout.f paramf)
    {
      AppMethodBeat.i(204515);
      k.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100711);
        ((FinderHomeActionBarUIC.b)paramf).me(true);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.q(this.sdM.getActivity()).get(FinderHomeUIC.class)).Fb(((FinderHomeActionBarUIC.b)paramf).diw);
        switch (((FinderHomeActionBarUIC.b)paramf).diw)
        {
        }
      }
      do
      {
        AppMethodBeat.o(204515);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).sdK;
        if (paramf != null)
        {
          paramf.setImageResource(2131690422);
          AppMethodBeat.o(204515);
          return;
        }
        AppMethodBeat.o(204515);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).sdK;
      } while (paramf == null);
      paramf.setImageResource(2131691517);
      paramf.setIconColor(paramf.getResources().getColor(2131100711));
      AppMethodBeat.o(204515);
    }
    
    @SuppressLint({"ResourceType"})
    public final void g(TabLayout.f paramf)
    {
      AppMethodBeat.i(204514);
      k.h(paramf, "t");
      paramf = paramf.getTag();
      if ((paramf instanceof FinderHomeActionBarUIC.b))
      {
        ((FinderHomeActionBarUIC.b)paramf).setTextColor(2131100212);
        ((FinderHomeActionBarUIC.b)paramf).me(false);
        switch (((FinderHomeActionBarUIC.b)paramf).diw)
        {
        }
      }
      do
      {
        AppMethodBeat.o(204514);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).sdK;
        if (paramf != null)
        {
          paramf.setImageResource(2131690589);
          AppMethodBeat.o(204514);
          return;
        }
        AppMethodBeat.o(204514);
        return;
        paramf = ((FinderHomeActionBarUIC.b)paramf).sdK;
      } while (paramf == null);
      paramf.setImageResource(2131691536);
      paramf.setIconColor(paramf.getResources().getColor(2131100212));
      AppMethodBeat.o(204514);
    }
    
    @SuppressLint({"ResourceType"})
    public final void h(TabLayout.f paramf)
    {
      AppMethodBeat.i(204513);
      k.h(paramf, "t");
      AppMethodBeat.o(204513);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204516);
      this.sdM.getActivity().finish();
      AppMethodBeat.o(204516);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204517);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this.sdM.getActivity(), paramView, 0L, 0, true, 60);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.b(this.sdM.getActivity(), paramView);
      AppMethodBeat.o(204517);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeActionBarUIC$onCreate$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "plugin-finder_release"})
  public static final class g
    implements HardTouchableLayout.b
  {
    public final void dU(View paramView)
    {
      AppMethodBeat.i(204520);
      k.h(paramView, "view");
      ac.i("Finder.HomeActionBarUIC", "onDoubleClick ...");
      h.JZN.aQ((Runnable)new a(this));
      AppMethodBeat.o(204520);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FinderHomeActionBarUIC.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(204519);
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
        ((FinderHomeUIC)com.tencent.mm.ui.component.a.q(this.sdO.sdM.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().cCp();
        AppMethodBeat.o(204519);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204521);
      FinderHomeActionBarUIC.a(this.sdM, 2);
      paramView = new Intent();
      Object localObject = FinderReporterUIC.seQ;
      FinderReporterUIC.a.a((Context)this.sdM.getActivity(), paramView, 0L, 0, false, 124);
      localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      com.tencent.mm.plugin.finder.utils.a.x((Context)this.sdM.getActivity(), paramView);
      paramView = g.ad(com.tencent.mm.plugin.i.a.l.class);
      k.g(paramView, "MMKernel.plugin(IPluginFinder::class.java)");
      ((com.tencent.mm.plugin.i.a.l)paramView).getRedDotManager().adv("TLPersonalCenter");
      AppMethodBeat.o(204521);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class i<T>
    implements Observer<f.a>
  {
    i(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class j<T>
    implements Observer<f.a>
  {
    j(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class k<T>
    implements Observer<f.a>
  {
    k(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class l<T>
    implements Observer<f.a>
  {
    l(FinderHomeActionBarUIC paramFinderHomeActionBarUIC, TabLayout paramTabLayout) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class m<T>
    implements Observer<f.a>
  {
    m(FinderHomeActionBarUIC paramFinderHomeActionBarUIC) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC
 * JD-Core Version:    0.7.0.1
 */