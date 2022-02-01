package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderPostQualificationUIC
  extends UIComponent
{
  public static final FinderPostQualificationUIC.a tmZ;
  Runnable tmY;
  
  static
  {
    AppMethodBeat.i(206253);
    tmZ = new FinderPostQualificationUIC.a((byte)0);
    AppMethodBeat.o(206253);
  }
  
  public FinderPostQualificationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206252);
    AppMethodBeat.o(206252);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(206250);
    super.onCreate(paramBundle);
    paramBundle = new y.a();
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.Jdn, Boolean.FALSE);
    if (localObject == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(206250);
      throw paramBundle;
    }
    paramBundle.NiT = ((Boolean)localObject).booleanValue();
    if (!paramBundle.NiT)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.g.sbw;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.cBz(), (LifecycleOwner)getActivity(), (Observer)new b(this, paramBundle));
    }
    AppMethodBeat.o(206250);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206251);
    super.onResume();
    if (this.tmY != null)
    {
      ae.i("Finder.PostQualityUIC", "showBottomSheet onResume");
      Runnable localRunnable = this.tmY;
      if (localRunnable == null) {
        p.gkB();
      }
      c.a(0L, localRunnable);
    }
    AppMethodBeat.o(206251);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<g.a>
  {
    b(FinderPostQualificationUIC paramFinderPostQualificationUIC, y.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC
 * JD-Core Version:    0.7.0.1
 */