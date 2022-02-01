package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.aa.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$k
  implements View.OnClickListener
{
  c$k(aa.f paramf1, aa.f paramf2, c.e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(263527);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addSingleVoiceTmpMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = (WeImageView)this.msS.aaBC;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = (WeImageView)this.msR.aaBC;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.msT.msJ = true;
    this.msT.msB = true;
    a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addSingleVoiceTmpMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(263527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.k
 * JD-Core Version:    0.7.0.1
 */