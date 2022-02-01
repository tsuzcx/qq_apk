package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$3
  implements View.OnClickListener
{
  b$3(b paramb, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149737);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    b.a(this.iDz, (b.b)this.iDA.get(0));
    a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(149737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.3
 * JD-Core Version:    0.7.0.1
 */