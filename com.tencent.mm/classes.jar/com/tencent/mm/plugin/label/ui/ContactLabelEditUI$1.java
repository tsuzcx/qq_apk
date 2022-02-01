package com.tencent.mm.plugin.label.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class ContactLabelEditUI$1
  extends MMHandler
{
  ContactLabelEditUI$1(ContactLabelEditUI paramContactLabelEditUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(26162);
    int i = paramMessage.what;
    switch (i)
    {
    default: 
      Log.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(26162);
      return;
    case 6001: 
      ContactLabelEditUI.a(this.yCt);
      AppMethodBeat.o(26162);
      return;
    }
    a.jRu.WZ();
    AppMethodBeat.o(26162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.1
 * JD-Core Version:    0.7.0.1
 */