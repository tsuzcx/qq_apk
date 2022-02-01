package com.tencent.mm.plugin.festival.ui.bak;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FestivalSecondBakUI$b
  implements View.OnClickListener
{
  FestivalSecondBakUI$b(FestivalSecondBakUI paramFestivalSecondBakUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(258629);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI$showLiveEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = FestivalSecondBakUI.a(this.wUE);
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finder_username", paramView);
      ((Intent)localObject).putExtra("key_enter_profile_type", 11);
      ((ak)h.ag(ak.class)).enterFinderProfileUI((Context)this.wUE.getContext(), (Intent)localObject);
    }
    a.a(this, "com/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI$showLiveEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(258629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.ui.bak.FestivalSecondBakUI.b
 * JD-Core Version:    0.7.0.1
 */