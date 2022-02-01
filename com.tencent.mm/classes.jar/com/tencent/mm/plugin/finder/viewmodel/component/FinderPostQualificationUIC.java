package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.k;
import d.g.b.v.a;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderPostQualificationUIC
  extends UIComponent
{
  public static final FinderPostQualificationUIC.a sei;
  Runnable seh;
  
  static
  {
    AppMethodBeat.i(204579);
    sei = new FinderPostQualificationUIC.a((byte)0);
    AppMethodBeat.o(204579);
  }
  
  public FinderPostQualificationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204578);
    AppMethodBeat.o(204578);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(204576);
    super.onCreate(paramBundle);
    paramBundle = new v.a();
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GVS, Boolean.FALSE);
    if (localObject == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(204576);
      throw paramBundle;
    }
    paramBundle.KUL = ((Boolean)localObject).booleanValue();
    if (!paramBundle.KUL)
    {
      localObject = f.rfl;
      localObject = f.rfl;
      f.a(f.ctN(), (LifecycleOwner)getActivity(), (Observer)new b(this, paramBundle));
    }
    AppMethodBeat.o(204576);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204577);
    super.onResume();
    if (this.seh != null)
    {
      ac.i("Finder.PostQualityUIC", "showBottomSheet onResume");
      Runnable localRunnable = this.seh;
      if (localRunnable == null) {
        k.fOy();
      }
      com.tencent.mm.ac.c.a(0L, localRunnable);
    }
    AppMethodBeat.o(204577);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<f.a>
  {
    b(FinderPostQualificationUIC paramFinderPostQualificationUIC, v.a parama) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.plugin.finder.view.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(204575);
      this.rhU.bmi();
      AppMethodBeat.o(204575);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC
 * JD-Core Version:    0.7.0.1
 */