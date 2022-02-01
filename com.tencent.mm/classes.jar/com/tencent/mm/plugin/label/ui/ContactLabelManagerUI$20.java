package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ContactLabelManagerUI$20
  implements View.OnClickListener
{
  ContactLabelManagerUI$20(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(268744);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ContactLabelManagerUI.h(this.JVF);
    a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(268744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.20
 * JD-Core Version:    0.7.0.1
 */