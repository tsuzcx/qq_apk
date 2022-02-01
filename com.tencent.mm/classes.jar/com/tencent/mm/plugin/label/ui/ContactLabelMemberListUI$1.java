package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class ContactLabelMemberListUI$1
  extends MMHandler
{
  ContactLabelMemberListUI$1(ContactLabelMemberListUI paramContactLabelMemberListUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(26261);
    int i = paramMessage.what;
    Log.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      Log.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
      AppMethodBeat.o(26261);
      return;
    }
    ContactLabelMemberListUI.a(this.yCX);
    AppMethodBeat.o(26261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI.1
 * JD-Core Version:    0.7.0.1
 */