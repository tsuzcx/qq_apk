package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ContactLabelEditUI$10
  implements ContactListExpandPreference.a
{
  ContactLabelEditUI$10(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void JR()
  {
    AppMethodBeat.i(22547);
    if (ContactLabelEditUI.c(this.nYx) != null) {
      ContactLabelEditUI.c(this.nYx).dnF();
    }
    AppMethodBeat.o(22547);
  }
  
  public final void iw(int paramInt)
  {
    AppMethodBeat.i(22549);
    String str = ContactLabelEditUI.c(this.nYx).Mb(paramInt);
    ab.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramInt), str });
    ContactLabelEditUI.a(this.nYx, str);
    AppMethodBeat.o(22549);
  }
  
  public final void ix(int paramInt)
  {
    AppMethodBeat.i(22546);
    Intent localIntent;
    if (ContactLabelEditUI.c(this.nYx).Ma(paramInt))
    {
      String str1 = ContactLabelEditUI.c(this.nYx).Mb(paramInt);
      String str2 = ContactLabelEditUI.c(this.nYx).Mc(paramInt);
      if (bo.isNullOrNil(str1))
      {
        AppMethodBeat.o(22546);
        return;
      }
      localIntent = new Intent();
      localIntent.putExtra("Contact_User", str1);
      localIntent.putExtra("Contact_RoomNickname", str2);
      if (!ContactLabelEditUI.d(this.nYx)) {
        break label128;
      }
    }
    label128:
    for (paramInt = 17;; paramInt = 15)
    {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", paramInt);
      a.gmO.c(localIntent, this.nYx);
      AppMethodBeat.o(22546);
      return;
    }
  }
  
  public final void iy(int paramInt)
  {
    AppMethodBeat.i(22548);
    ContactLabelEditUI.e(this.nYx);
    AppMethodBeat.o(22548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.10
 * JD-Core Version:    0.7.0.1
 */