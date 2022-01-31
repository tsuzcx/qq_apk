package com.tencent.mm.plugin.label.ui;

import android.os.Message;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class ContactLabelManagerUI$1
  extends ah
{
  ContactLabelManagerUI$1(ContactLabelManagerUI paramContactLabelManagerUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    y.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      return;
    case 5001: 
      ContactLabelManagerUI.a(this.lBw);
      return;
    case 5002: 
      this.lBw.Gp(this.lBw.getString(R.l.app_waiting));
      return;
    }
    this.lBw.bdC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI.1
 * JD-Core Version:    0.7.0.1
 */