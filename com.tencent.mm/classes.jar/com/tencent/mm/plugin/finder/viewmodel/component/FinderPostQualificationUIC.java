package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderPostQualificationUIC
  extends UIComponent
{
  public static final a wyS;
  Runnable wyR;
  
  static
  {
    AppMethodBeat.i(255861);
    wyS = new a((byte)0);
    AppMethodBeat.o(255861);
  }
  
  public FinderPostQualificationUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255860);
    AppMethodBeat.o(255860);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(255858);
    super.onCreate(paramBundle);
    paramBundle = new z.a();
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.OmC, Boolean.FALSE);
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(255858);
      throw paramBundle;
    }
    paramBundle.SYB = ((Boolean)localObject).booleanValue();
    if (!paramBundle.SYB)
    {
      localObject = h.tKR;
      localObject = h.tKR;
      h.a(h.daL(), (LifecycleOwner)getActivity(), (Observer)new b(this, paramBundle));
    }
    AppMethodBeat.o(255858);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255859);
    super.onResume();
    if (this.wyR != null)
    {
      Log.i("Finder.PostQualityUIC", "showBottomSheet onResume");
      Runnable localRunnable = this.wyR;
      if (localRunnable == null) {
        p.hyc();
      }
      com.tencent.mm.ac.d.a(0L, localRunnable);
    }
    AppMethodBeat.o(255859);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<h.a>
  {
    b(FinderPostQualificationUIC paramFinderPostQualificationUIC, z.a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.plugin.finder.view.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255857);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tOn.bMo();
      a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC
 * JD-Core Version:    0.7.0.1
 */