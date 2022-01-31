package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;

final class ContactLabelEditUI$12
  implements Runnable
{
  ContactLabelEditUI$12(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(22552);
    ArrayList localArrayList = e.bKU().arl(ContactLabelEditUI.j(this.nYx));
    if (localArrayList == null)
    {
      ab.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
      AppMethodBeat.o(22552);
      return;
    }
    if (localArrayList != null)
    {
      ContactLabelEditUI.a(this.nYx, localArrayList);
      if (ContactLabelEditUI.k(this.nYx) != null) {
        break label119;
      }
      ContactLabelEditUI.b(this.nYx, new ArrayList());
    }
    for (;;)
    {
      ContactLabelEditUI.k(this.nYx).addAll(localArrayList);
      if (ContactLabelEditUI.l(this.nYx) != null) {
        ContactLabelEditUI.l(this.nYx).sendEmptyMessage(6001);
      }
      AppMethodBeat.o(22552);
      return;
      label119:
      ContactLabelEditUI.k(this.nYx).clear();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(22553);
    String str = super.toString() + "|initView";
    AppMethodBeat.o(22553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.12
 * JD-Core Version:    0.7.0.1
 */