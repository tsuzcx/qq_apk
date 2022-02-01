package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class ah
  extends UIComponent
{
  public static final a BmF;
  Runnable BmE;
  
  static
  {
    AppMethodBeat.i(248966);
    BmF = new a((byte)0);
    AppMethodBeat.o(248966);
  }
  
  public ah(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(248964);
    AppMethodBeat.o(248964);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(248961);
    super.onCreate(paramBundle);
    paramBundle = new aa.a();
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.VBB, Boolean.FALSE);
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(248961);
      throw paramBundle;
    }
    paramBundle.aaBx = ((Boolean)localObject).booleanValue();
    if (!paramBundle.aaBx)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.dqP(), (androidx.lifecycle.l)getActivity(), (s)new b(this, paramBundle));
    }
    AppMethodBeat.o(248961);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(248962);
    super.onResume();
    if (this.BmE != null)
    {
      Log.i("Finder.PostQualityUIC", "showBottomSheet onResume");
      Runnable localRunnable = this.BmE;
      if (localRunnable == null) {
        p.iCn();
      }
      d.a(0L, localRunnable);
    }
    AppMethodBeat.o(248962);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class b<T>
    implements s<h.a>
  {
    b(ah paramah, aa.a parama) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227559);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.wZG.bYF();
      a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227559);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ah
 * JD-Core Version:    0.7.0.1
 */