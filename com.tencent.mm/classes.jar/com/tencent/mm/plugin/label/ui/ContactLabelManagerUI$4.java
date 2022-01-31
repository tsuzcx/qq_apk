package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.af;
import java.util.ArrayList;
import java.util.HashMap;

final class ContactLabelManagerUI$4
  implements Runnable
{
  ContactLabelManagerUI$4(ContactLabelManagerUI paramContactLabelManagerUI, boolean paramBoolean) {}
  
  public final void run()
  {
    ContactLabelManagerUI.a(this.lBw, e.bdz().cui());
    if ((ContactLabelManagerUI.g(this.lBw) == null) || (ContactLabelManagerUI.g(this.lBw).size() <= 0))
    {
      y.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
      if (ContactLabelManagerUI.h(this.lBw))
      {
        h.nFQ.f(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
        ContactLabelManagerUI.i(this.lBw);
      }
      com.tencent.mm.sdk.platformtools.ai.d(new ContactLabelManagerUI.4.1(this));
      return;
    }
    y.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
    if (ContactLabelManagerUI.h(this.lBw))
    {
      h.nFQ.f(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      ContactLabelManagerUI.i(this.lBw);
    }
    if ((ContactLabelManagerUI.g(this.lBw) != null) && (ContactLabelManagerUI.g(this.lBw).size() > 0))
    {
      int j = ContactLabelManagerUI.g(this.lBw).size();
      e.bdz().bdu();
      int i = 0;
      if (i < j)
      {
        int k = ((af)ContactLabelManagerUI.g(this.lBw).get(i)).field_labelID;
        ArrayList localArrayList = e.bdz().aba(String.valueOf(k));
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          ContactLabelManagerUI.j(this.lBw).put(Integer.valueOf(k), Integer.valueOf(localArrayList.size()));
        }
        for (;;)
        {
          i += 1;
          break;
          ContactLabelManagerUI.j(this.lBw).put(Integer.valueOf(k), Integer.valueOf(0));
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ai.d(new ContactLabelManagerUI.4.2(this));
  }
  
  public final String toString()
  {
    return super.toString() + "|updateData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.4
 * JD-Core Version:    0.7.0.1
 */