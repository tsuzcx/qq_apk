package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;

final class ContactLabelEditUI$11
  implements InputClearablePreference.a
{
  ContactLabelEditUI$11(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void Gs(String paramString)
  {
    ContactLabelEditUI.b(this.lBl, paramString);
    ContactLabelEditUI.c(this.lBl, paramString);
    ContactLabelEditUI.e(this.lBl).hg(false);
  }
  
  public final void he(boolean paramBoolean)
  {
    if ((!ContactLabelEditUI.f(this.lBl)) && (ContactLabelEditUI.g(this.lBl)))
    {
      this.lBl.enableOptionMenu(false);
      ContactLabelEditUI.h(this.lBl);
      return;
    }
    this.lBl.enableOptionMenu(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.11
 * JD-Core Version:    0.7.0.1
 */