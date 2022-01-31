package com.tencent.mm.plugin.label.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class ContactLabelEditUI$1
  extends ah
{
  ContactLabelEditUI$1(ContactLabelEditUI paramContactLabelEditUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    switch (i)
    {
    default: 
      y.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
      return;
    case 6001: 
      ContactLabelEditUI.a(this.lBl);
      return;
    }
    a.eUS.tk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.1
 * JD-Core Version:    0.7.0.1
 */