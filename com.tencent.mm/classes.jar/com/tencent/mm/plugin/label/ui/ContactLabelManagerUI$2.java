package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ContactLabelManagerUI$2
  implements View.OnClickListener
{
  ContactLabelManagerUI$2(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(268729);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ContactLabelManagerUI.i(this.JVF);
    a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(268729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.2
 * JD-Core Version:    0.7.0.1
 */