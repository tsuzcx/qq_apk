package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.hometab.c;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isCurrentResume", "", "lastExposeFollowTipsId", "", "lastExposeFriendTipsId", "lastExposeLbsTipsId", "lastExposeMachineTipsId", "lastExposePersonalCenterTipsId", "checkPersonCenterRedDotReport", "", "action", "", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "getCurrentTabType", "getPersonalCenterRect", "outRect", "Landroid/graphics/Rect;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerRedDot", "plugin-finder_release"})
public final class FinderHomeTabUIC
  extends FinderTabUIC
{
  private boolean uPU;
  private String wwA;
  private String www;
  private String wwx;
  private String wwy;
  private String wwz;
  
  public FinderHomeTabUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255626);
    this.www = "";
    this.wwx = "";
    this.wwy = "";
    this.wwz = "";
    this.wwA = "";
    AppMethodBeat.o(255626);
  }
  
  private final void Mu(int paramInt)
  {
    AppMethodBeat.i(255625);
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      i.a locala = i.tLi;
      this.www = i.a.a(paramInt, (bbn)localObject, this.www);
      AppMethodBeat.o(255625);
      return;
    }
  }
  
  public final IFinderTabProvider cXB()
  {
    AppMethodBeat.i(255621);
    IFinderTabProvider localIFinderTabProvider = (IFinderTabProvider)new c();
    AppMethodBeat.o(255621);
    return localIFinderTabProvider;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(255622);
    super.onCreateAfter(paramBundle);
    paramBundle = getActivity().getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131303116)).setOnClickListener((View.OnClickListener)new a(this));
    ((WeImageView)((FragmentActivity)getActivity()).findViewById(2131305872)).setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daN(), (LifecycleOwner)getActivity(), (Observer)new c(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daQ(), (LifecycleOwner)getActivity(), (Observer)new d(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daR(), (LifecycleOwner)getActivity(), (Observer)new e(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daT(), (LifecycleOwner)getActivity(), (Observer)new f(this));
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    paramBundle = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
    com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daU(), (LifecycleOwner)getActivity(), (Observer)new g(this));
    Mu(1);
    AppMethodBeat.o(255622);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255624);
    super.onPause();
    this.uPU = false;
    AppMethodBeat.o(255624);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255623);
    super.onResume();
    this.uPU = true;
    AppMethodBeat.o(255623);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderHomeTabUIC paramFinderHomeTabUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255614);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.dnS();
      paramView = new Intent();
      localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.wxi.getActivity(), paramView, 0L, 0, true, 60);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject = this.wxi.getActivity();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255614);
        throw paramView;
      }
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255614);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderHomeTabUIC paramFinderHomeTabUIC) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(255615);
      Object localObject2 = new b();
      ((b)localObject2).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).axR());
      paramView = FinderReporterUIC.wzC;
      paramView = FinderReporterUIC.a.fH((Context)this.wxi.getActivity());
      if (paramView != null)
      {
        paramView = FinderReporterUIC.c(paramView);
        if ((paramView instanceof o))
        {
          paramView = (o)paramView;
          localObject2 = e.vdS;
          paramView.auL(e.a.ah(ae.b(s.U("feedActionType", Integer.valueOf(3)))));
        }
        FinderHomeTabUIC.a(this.wxi, 2);
        localObject2 = new Intent();
        paramView = g.ah(PluginFinder.class);
        p.g(paramView, "MMKernel.plugin(PluginFinder::class.java)");
        k localk = ((PluginFinder)paramView).getRedDotManager().asX("TLPersonalCenter");
        paramView = localObject1;
        if (localk != null) {
          paramView = localk.atl("TLPersonalCenter");
        }
        if (paramView == null) {
          break label246;
        }
      }
      label246:
      for (boolean bool = true;; bool = false)
      {
        paramView = FinderSelfUI.vOh;
        ((Intent)localObject2).putExtra(FinderSelfUI.dAd(), bool);
        paramView = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)this.wxi.getActivity(), (Intent)localObject2, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.z((Context)this.wxi.getActivity(), (Intent)localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderHomeTabUIC$onCreateAfter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255615);
        return;
        paramView = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class c<T>
    implements Observer<h.a>
  {
    c(FinderHomeTabUIC paramFinderHomeTabUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class d<T>
    implements Observer<h.a>
  {
    d(FinderHomeTabUIC paramFinderHomeTabUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class e<T>
    implements Observer<h.a>
  {
    e(FinderHomeTabUIC paramFinderHomeTabUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class f<T>
    implements Observer<h.a>
  {
    f(FinderHomeTabUIC paramFinderHomeTabUIC) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class g<T>
    implements Observer<h.a>
  {
    g(FinderHomeTabUIC paramFinderHomeTabUIC) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeTabUIC
 * JD-Core Version:    0.7.0.1
 */