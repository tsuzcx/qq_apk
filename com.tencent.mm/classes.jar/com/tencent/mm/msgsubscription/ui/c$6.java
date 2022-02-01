package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.Iterator;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$6
  implements View.OnClickListener
{
  c$6(c paramc, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149740);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = c.k(this.msv);
    if (!c.k(this.msv).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      paramView = ((Iterable)this.mpK).iterator();
      while (paramView.hasNext()) {
        ((c.c)paramView.next()).msA = c.k(this.msv).isChecked();
      }
    }
    a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(149740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c.6
 * JD-Core Version:    0.7.0.1
 */