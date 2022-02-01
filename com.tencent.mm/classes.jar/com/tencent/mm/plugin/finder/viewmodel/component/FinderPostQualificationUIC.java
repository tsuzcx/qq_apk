package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.d;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.k;
import d.g.b.v.a;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderPostQualificationUIC
  extends UIComponent
{
  public static final a LiF;
  Runnable LiE;
  
  static
  {
    AppMethodBeat.i(200453);
    LiF = new a((byte)0);
    AppMethodBeat.o(200453);
  }
  
  public FinderPostQualificationUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200452);
    AppMethodBeat.o(200452);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(200450);
    super.onCreate(paramBundle);
    paramBundle = new v.a();
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).afk().get(ae.a.LBu, Boolean.FALSE);
    if (localObject == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(200450);
      throw paramBundle;
    }
    paramBundle.Jhs = ((Boolean)localObject).booleanValue();
    if (!paramBundle.Jhs)
    {
      localObject = d.qtG;
      localObject = d.qtG;
      d.a(d.clr(), (LifecycleOwner)getActivity(), (Observer)new b(this, paramBundle));
    }
    AppMethodBeat.o(200450);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200451);
    super.onResume();
    if (this.LiE != null)
    {
      ad.i("Finder.PostQualityUIC", "showBottomSheet onResume");
      Runnable localRunnable = this.LiE;
      if (localRunnable == null) {
        k.fvU();
      }
      com.tencent.mm.ad.c.c(0L, localRunnable);
    }
    AppMethodBeat.o(200451);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class b<T>
    implements Observer<d.a>
  {
    b(FinderPostQualificationUIC paramFinderPostQualificationUIC, v.a parama) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.plugin.finder.view.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200449);
      this.KNB.bfo();
      AppMethodBeat.o(200449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC
 * JD-Core Version:    0.7.0.1
 */