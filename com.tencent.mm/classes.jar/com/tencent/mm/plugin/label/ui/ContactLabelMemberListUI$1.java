package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class ContactLabelMemberListUI$1
  extends ah
{
  ContactLabelMemberListUI$1(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    y.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      y.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
      return;
    }
    ContactLabelMemberListUI.a(this.lBO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.1
 * JD-Core Version:    0.7.0.1
 */