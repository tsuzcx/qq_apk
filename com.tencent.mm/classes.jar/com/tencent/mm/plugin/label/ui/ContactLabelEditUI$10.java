package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ContactLabelEditUI$10
  implements ContactListExpandPreference.a
{
  ContactLabelEditUI$10(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void gh(int paramInt)
  {
    String str = ContactLabelEditUI.c(this.lBl).Ed(paramInt);
    y.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramInt), str });
    ContactLabelEditUI.a(this.lBl, str);
  }
  
  public final void gi(int paramInt)
  {
    String str1;
    String str2;
    if (ContactLabelEditUI.c(this.lBl).Ec(paramInt))
    {
      str1 = ContactLabelEditUI.c(this.lBl).Ed(paramInt);
      str2 = ContactLabelEditUI.c(this.lBl).Ee(paramInt);
      if (!bk.bl(str1)) {}
    }
    else
    {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", str1);
    localIntent.putExtra("Contact_RoomNickname", str2);
    a.eUR.d(localIntent, this.lBl);
  }
  
  public final void gj(int paramInt)
  {
    ContactLabelEditUI.d(this.lBl);
  }
  
  public final void xy()
  {
    if (ContactLabelEditUI.c(this.lBl) != null) {
      ContactLabelEditUI.c(this.lBl).cmP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.10
 * JD-Core Version:    0.7.0.1
 */