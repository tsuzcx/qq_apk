package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTagPanel.a;

final class ContactLabelUI$8
  implements MMTagPanel.a
{
  ContactLabelUI$8(ContactLabelUI paramContactLabelUI) {}
  
  public final void Le(String paramString)
  {
    AppMethodBeat.i(22671);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramString) });
    if (ContactLabelUI.b(this.nZv) != null) {
      ContactLabelUI.b(this.nZv).removeTag(paramString);
    }
    ContactLabelUI.a(this.nZv, paramString);
    AppMethodBeat.o(22671);
  }
  
  public final void Lf(String paramString)
  {
    AppMethodBeat.i(22672);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramString) });
    if (ContactLabelUI.b(this.nZv) != null) {
      ContactLabelUI.b(this.nZv).cj(paramString, true);
    }
    ContactLabelUI.a(this.nZv, paramString, ContactLabelUI.d(this.nZv));
    AppMethodBeat.o(22672);
  }
  
  public final void Lg(String paramString) {}
  
  public final void Lh(String paramString) {}
  
  public final void Li(String paramString) {}
  
  public final void bnq() {}
  
  public final void t(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.8
 * JD-Core Version:    0.7.0.1
 */