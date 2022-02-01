package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

final class ContactLabelMemberListUI$1
  extends ap
{
  ContactLabelMemberListUI$1(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(26261);
    int i = paramMessage.what;
    ad.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      ad.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
      AppMethodBeat.o(26261);
      return;
    }
    ContactLabelMemberListUI.a(this.uXg);
    AppMethodBeat.o(26261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.1
 * JD-Core Version:    0.7.0.1
 */