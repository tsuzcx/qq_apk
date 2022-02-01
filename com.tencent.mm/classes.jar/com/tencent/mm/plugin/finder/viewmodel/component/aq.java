package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  extends UIComponent
{
  public static final a GSJ;
  private Runnable GSK;
  
  static
  {
    AppMethodBeat.i(338135);
    GSJ = new a((byte)0);
    AppMethodBeat.o(338135);
  }
  
  public aq(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338087);
    AppMethodBeat.o(338087);
  }
  
  private static final void a(aq paramaq)
  {
    AppMethodBeat.i(338100);
    s.u(paramaq, "this$0");
    Log.i("Finder.PostQualityUIC", "showBottomSheet");
    Object localObject = (CharSequence)z.bAW();
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        Log.i("Finder.PostQualityUIC", "showBottomSheet return ,finder account exit");
      }
      localObject = new com.tencent.mm.plugin.finder.view.d((Context)paramaq.getActivity());
      ((com.tencent.mm.plugin.finder.view.d)localObject).UD(e.f.finder_first_get_post_quality_bottom_sheet_layout);
      ((com.tencent.mm.plugin.finder.view.d)localObject).rootView.findViewById(e.e.get_post_quality_bottom_sheet_cancel).setOnClickListener(new aq..ExternalSyntheticLambda0((com.tencent.mm.plugin.finder.view.d)localObject));
      i = e.d.finder_camera_icon;
      if (!aw.isDarkMode()) {
        break label146;
      }
      i = e.d.finder_camera_icon_dark;
    }
    label146:
    for (;;)
    {
      ((ImageView)((com.tencent.mm.plugin.finder.view.d)localObject).rootView.findViewById(e.e.get_post_quality_bottom_sheet_icon)).setImageResource(i);
      ((com.tencent.mm.plugin.finder.view.d)localObject).dDn();
      paramaq.GSK = null;
      AppMethodBeat.o(338100);
      return;
      i = 0;
      break;
    }
  }
  
  private static final void a(ah.a parama, aq paramaq, l.a parama1)
  {
    int j = 0;
    AppMethodBeat.i(338111);
    s.u(parama, "$hasShowQualityBottomSheet");
    s.u(paramaq, "this$0");
    StringBuilder localStringBuilder = new StringBuilder("[MENU_ID_POST] red=");
    boolean bool;
    if ((parama1 != null) && (parama1.hBY == true))
    {
      bool = true;
      Log.i("Finder.PostQualityUIC", bool + "，hasShowQualityBottomSheet = " + parama.aiwY);
      int i = j;
      if (parama1 != null)
      {
        i = j;
        if (parama1.hBY == true) {
          i = 1;
        }
      }
      if (i != 0)
      {
        parama1 = parama1.ASg;
        if (parama1 != null) {
          break label168;
        }
      }
    }
    label168:
    for (parama1 = null;; parama1 = parama1.title)
    {
      if ((!s.p(parama1, "temp")) && (!parama.aiwY))
      {
        parama.aiwY = true;
        h.baE().ban().set(at.a.addX, Boolean.TRUE);
        paramaq.GSK = new aq..ExternalSyntheticLambda2(paramaq);
      }
      AppMethodBeat.o(338111);
      return;
      bool = false;
      break;
    }
  }
  
  private static final void n(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(338126);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "$bottomSheet");
    paramd.cyW();
    a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338126);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338169);
    super.onCreate(paramBundle);
    paramBundle = new ah.a();
    Object localObject = h.baE().ban().get(at.a.addX, Boolean.FALSE);
    if (localObject == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(338169);
      throw paramBundle;
    }
    paramBundle.aiwY = ((Boolean)localObject).booleanValue();
    if (!paramBundle.aiwY)
    {
      localObject = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZD(), (q)getActivity(), new aq..ExternalSyntheticLambda1(paramBundle, this));
    }
    AppMethodBeat.o(338169);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338179);
    super.onResume();
    if (this.GSK != null)
    {
      Log.i("Finder.PostQualityUIC", "showBottomSheet onResume");
      Runnable localRunnable = this.GSK;
      s.checkNotNull(localRunnable);
      com.tencent.mm.ae.d.a(0L, localRunnable);
    }
    AppMethodBeat.o(338179);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.aq
 * JD-Core Version:    0.7.0.1
 */