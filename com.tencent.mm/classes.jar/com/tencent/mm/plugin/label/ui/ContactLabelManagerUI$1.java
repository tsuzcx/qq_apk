package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class ContactLabelManagerUI$1
  extends ak
{
  ContactLabelManagerUI$1(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(22584);
    int i = paramMessage.what;
    ab.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22584);
      return;
      ContactLabelManagerUI.a(this.nYI);
      AppMethodBeat.o(22584);
      return;
      this.nYI.RS(this.nYI.getString(2131297112));
      AppMethodBeat.o(22584);
      return;
      this.nYI.hideLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.1
 * JD-Core Version:    0.7.0.1
 */