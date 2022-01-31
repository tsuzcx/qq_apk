package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class ContactLabelMemberListUI$1
  extends ak
{
  ContactLabelMemberListUI$1(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(22639);
    int i = paramMessage.what;
    ab.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      ab.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
      AppMethodBeat.o(22639);
      return;
    }
    ContactLabelMemberListUI.a(this.nZa);
    AppMethodBeat.o(22639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.1
 * JD-Core Version:    0.7.0.1
 */