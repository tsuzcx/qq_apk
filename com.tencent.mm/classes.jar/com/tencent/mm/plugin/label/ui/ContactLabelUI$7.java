package com.tencent.mm.plugin.label.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.tools.f;

final class ContactLabelUI$7
  implements MMTagPanel.a
{
  ContactLabelUI$7(ContactLabelUI paramContactLabelUI) {}
  
  public final void Le(String paramString)
  {
    AppMethodBeat.i(22664);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramString });
    ContactLabelUI.b(this.nZv).removeTag(paramString);
    if (ContactLabelUI.c(this.nZv) != null) {
      ContactLabelUI.c(this.nZv).ck(paramString, false);
    }
    ContactLabelUI.a(this.nZv, paramString);
    AppMethodBeat.o(22664);
  }
  
  public final void Lf(String paramString)
  {
    AppMethodBeat.i(22665);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramString });
    AppMethodBeat.o(22665);
  }
  
  public final void Lg(String paramString)
  {
    AppMethodBeat.i(22666);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramString });
    if (ContactLabelUI.c(this.nZv) != null) {
      ContactLabelUI.c(this.nZv).ck(paramString, false);
    }
    ContactLabelUI.a(this.nZv, paramString);
    AppMethodBeat.o(22666);
  }
  
  public final void Lh(String paramString)
  {
    AppMethodBeat.i(22668);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramString });
    ContactLabelUI.b(this.nZv, paramString);
    AppMethodBeat.o(22668);
  }
  
  public final void Li(String paramString)
  {
    AppMethodBeat.i(22669);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramString) });
    if (bo.isNullOrNil(paramString))
    {
      ab.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
      AppMethodBeat.o(22669);
      return;
    }
    ContactLabelUI.b(this.nZv).cj(paramString, true);
    if (ContactLabelUI.c(this.nZv) != null) {
      ContactLabelUI.c(this.nZv).ck(paramString, true);
    }
    ContactLabelUI.a(this.nZv, paramString, ContactLabelUI.d(this.nZv));
    AppMethodBeat.o(22669);
  }
  
  public final void bnq()
  {
    AppMethodBeat.i(22667);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
    AppMethodBeat.o(22667);
  }
  
  public final void t(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22670);
    ab.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      this.nZv.enableOptionMenu(false);
      ContactLabelUI.e(this.nZv).setVisibility(0);
      ContactLabelUI.e(this.nZv).setText(2131301013);
      ContactLabelUI.e(this.nZv).setText(String.format(this.nZv.getString(2131301013), new Object[] { Integer.valueOf(f.bO(36, "")), Integer.valueOf(paramInt) }));
      AppMethodBeat.o(22670);
      return;
    }
    this.nZv.enableOptionMenu(true);
    ContactLabelUI.e(this.nZv).setVisibility(8);
    AppMethodBeat.o(22670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.7
 * JD-Core Version:    0.7.0.1
 */