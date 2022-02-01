package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ContactLabelManagerUI$7
  implements View.OnClickListener
{
  ContactLabelManagerUI$7(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26213);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ContactLabelManagerUI.b(this.EdX);
    a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.7
 * JD-Core Version:    0.7.0.1
 */