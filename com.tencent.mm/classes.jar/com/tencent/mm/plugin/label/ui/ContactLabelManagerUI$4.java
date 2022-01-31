package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.HashMap;

final class ContactLabelManagerUI$4
  implements Runnable
{
  ContactLabelManagerUI$4(ContactLabelManagerUI paramContactLabelManagerUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(22588);
    ContactLabelManagerUI.a(this.nYI, e.bKU().dwH());
    if ((ContactLabelManagerUI.g(this.nYI) == null) || (ContactLabelManagerUI.g(this.nYI).size() <= 0))
    {
      ab.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
      if (ContactLabelManagerUI.h(this.nYI))
      {
        h.qsU.e(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
        ContactLabelManagerUI.i(this.nYI);
      }
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22586);
          ContactLabelManagerUI.a(ContactLabelManagerUI.4.this.nYI, ContactLabelManagerUI.b.nYO);
          if ((ContactLabelManagerUI.4.this.nYK) && (ContactLabelManagerUI.c(ContactLabelManagerUI.4.this.nYI) != null))
          {
            ContactLabelManagerUI.c(ContactLabelManagerUI.4.this.nYI).removeMessages(5002);
            ContactLabelManagerUI.c(ContactLabelManagerUI.4.this.nYI).sendEmptyMessageDelayed(5003, 0L);
          }
          AppMethodBeat.o(22586);
        }
      });
      AppMethodBeat.o(22588);
      return;
    }
    ab.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
    if (ContactLabelManagerUI.h(this.nYI))
    {
      h.qsU.e(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      ContactLabelManagerUI.i(this.nYI);
    }
    if ((ContactLabelManagerUI.g(this.nYI) != null) && (ContactLabelManagerUI.g(this.nYI).size() > 0))
    {
      int j = ContactLabelManagerUI.g(this.nYI).size();
      e.bKU().ahN();
      int i = 0;
      if (i < j)
      {
        int k = ((af)ContactLabelManagerUI.g(this.nYI).get(i)).field_labelID;
        ArrayList localArrayList = e.bKU().arl(String.valueOf(k));
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          ContactLabelManagerUI.j(this.nYI).put(Integer.valueOf(k), Integer.valueOf(localArrayList.size()));
        }
        for (;;)
        {
          i += 1;
          break;
          ContactLabelManagerUI.j(this.nYI).put(Integer.valueOf(k), Integer.valueOf(0));
        }
      }
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22587);
        ContactLabelManagerUI.a(ContactLabelManagerUI.4.this.nYI, ContactLabelManagerUI.b.nYN);
        ContactLabelManagerUI.a locala = ContactLabelManagerUI.k(ContactLabelManagerUI.4.this.nYI);
        locala.mData = ContactLabelManagerUI.g(ContactLabelManagerUI.4.this.nYI);
        locala.notifyDataSetChanged();
        ContactLabelManagerUI.k(ContactLabelManagerUI.4.this.nYI).notifyDataSetInvalidated();
        if ((ContactLabelManagerUI.4.this.nYK) && (ContactLabelManagerUI.c(ContactLabelManagerUI.4.this.nYI) != null))
        {
          ContactLabelManagerUI.c(ContactLabelManagerUI.4.this.nYI).removeMessages(5002);
          ContactLabelManagerUI.c(ContactLabelManagerUI.4.this.nYI).sendEmptyMessageDelayed(5003, 400L);
        }
        AppMethodBeat.o(22587);
      }
    });
    AppMethodBeat.o(22588);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(22589);
    String str = super.toString() + "|updateData";
    AppMethodBeat.o(22589);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.4
 * JD-Core Version:    0.7.0.1
 */