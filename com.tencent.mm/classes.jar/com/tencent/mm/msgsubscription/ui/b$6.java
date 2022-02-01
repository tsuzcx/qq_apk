package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$6
  implements View.OnClickListener
{
  b$6(b paramb, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(149740);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = b.j(this.iDz);
    if (!b.j(this.iDz).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      paramView = ((Iterable)this.iDA).iterator();
      while (paramView.hasNext()) {
        ((b.b)paramView.next()).iDB = b.j(this.iDz).isChecked();
      }
    }
    a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(149740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.6
 * JD-Core Version:    0.7.0.1
 */