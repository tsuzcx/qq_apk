package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderPostQualificationUIC
  extends UIComponent
{
  public static final a tcf;
  Runnable tce;
  
  static
  {
    AppMethodBeat.i(205626);
    tcf = new a((byte)0);
    AppMethodBeat.o(205626);
  }
  
  public FinderPostQualificationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205625);
    AppMethodBeat.o(205625);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(205623);
    super.onCreate(paramBundle);
    paramBundle = new y.a();
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajl().get(al.a.III, Boolean.FALSE);
    if (localObject == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(205623);
      throw paramBundle;
    }
    paramBundle.MLQ = ((Boolean)localObject).booleanValue();
    if (!paramBundle.MLQ)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czV(), (LifecycleOwner)getActivity(), (Observer)new b(this, paramBundle));
    }
    AppMethodBeat.o(205623);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205624);
    super.onResume();
    if (this.tce != null)
    {
      ad.i("Finder.PostQualityUIC", "showBottomSheet onResume");
      Runnable localRunnable = this.tce;
      if (localRunnable == null) {
        p.gfZ();
      }
      c.a(0L, localRunnable);
    }
    AppMethodBeat.o(205624);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<g.a>
  {
    b(FinderPostQualificationUIC paramFinderPostQualificationUIC, y.a parama) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205622);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.rVZ.bpT();
      a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(205622);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC
 * JD-Core Version:    0.7.0.1
 */