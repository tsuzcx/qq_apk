package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$3
  implements View.OnClickListener
{
  c$3(c paramc, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149737);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    c.a(this.msv, (c.c)this.mpK.get(0));
    a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(149737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.3
 * JD-Core Version:    0.7.0.1
 */