package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ah;

final class ContactsSyncUI$a$3
  implements DialogInterface.OnClickListener
{
  ContactsSyncUI$a$3(ContactsSyncUI.a parama, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124746);
    l.dx(false);
    this.gCD.gCA.getSharedPreferences(ah.dsP(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
    if ((this.val$context instanceof Activity)) {
      ((Activity)this.val$context).finish();
    }
    AppMethodBeat.o(124746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI.a.3
 * JD-Core Version:    0.7.0.1
 */