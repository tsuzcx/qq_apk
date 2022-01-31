package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;

final class ContactLabelEditUI$11
  implements InputClearablePreference.a
{
  ContactLabelEditUI$11(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void RV(String paramString)
  {
    AppMethodBeat.i(22550);
    ContactLabelEditUI.b(this.nYx, paramString);
    ContactLabelEditUI.c(this.nYx, paramString);
    ContactLabelEditUI.f(this.nYx).iQ(false);
    AppMethodBeat.o(22550);
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(22551);
    if ((!ContactLabelEditUI.g(this.nYx)) && (ContactLabelEditUI.h(this.nYx)))
    {
      this.nYx.enableOptionMenu(false);
      ContactLabelEditUI.i(this.nYx);
      AppMethodBeat.o(22551);
      return;
    }
    this.nYx.enableOptionMenu(paramBoolean);
    AppMethodBeat.o(22551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.11
 * JD-Core Version:    0.7.0.1
 */