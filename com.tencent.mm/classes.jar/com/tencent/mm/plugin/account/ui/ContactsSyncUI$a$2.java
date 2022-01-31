package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.z;

final class ContactsSyncUI$a$2
  implements DialogInterface.OnClickListener
{
  ContactsSyncUI$a$2(ContactsSyncUI.a parama, Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.DP().Dz().o(12322, Boolean.valueOf(true));
    this.flm.flj.getSharedPreferences(ae.cqR(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
    this.flm.L(this.val$context, this.fln);
    if ((this.val$context instanceof Activity)) {
      ((Activity)this.val$context).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI.a.2
 * JD-Core Version:    0.7.0.1
 */