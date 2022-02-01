package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class ContactLabelEditUI$10
  implements ContactListExpandPreference.a
{
  ContactLabelEditUI$10(ContactLabelEditUI paramContactLabelEditUI) {}
  
  public final void amF()
  {
    AppMethodBeat.i(26169);
    if (ContactLabelEditUI.c(this.yCt) != null) {
      ContactLabelEditUI.c(this.yCt).gpE();
    }
    AppMethodBeat.o(26169);
  }
  
  public final void e(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(231724);
    Intent localIntent;
    if (ContactLabelEditUI.c(this.yCt).ain(paramInt))
    {
      paramViewGroup = ContactLabelEditUI.c(this.yCt).aio(paramInt);
      String str = ContactLabelEditUI.c(this.yCt).aip(paramInt);
      if (Util.isNullOrNil(paramViewGroup))
      {
        AppMethodBeat.o(231724);
        return;
      }
      localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramViewGroup);
      localIntent.putExtra("Contact_RoomNickname", str);
      if (!ContactLabelEditUI.d(this.yCt)) {
        break label125;
      }
    }
    label125:
    for (paramInt = 17;; paramInt = 15)
    {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", paramInt);
      a.jRt.c(localIntent, this.yCt);
      AppMethodBeat.o(231724);
      return;
    }
  }
  
  public final void og(int paramInt)
  {
    AppMethodBeat.i(26171);
    String str = ContactLabelEditUI.c(this.yCt).aio(paramInt);
    Log.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramInt), str });
    ContactLabelEditUI.a(this.yCt, str);
    AppMethodBeat.o(26171);
  }
  
  public final void oh(int paramInt)
  {
    AppMethodBeat.i(26170);
    ContactLabelEditUI.e(this.yCt);
    AppMethodBeat.o(26170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI.10
 * JD-Core Version:    0.7.0.1
 */