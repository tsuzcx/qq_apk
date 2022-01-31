package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

final class z$2
  implements DialogInterface.OnClickListener
{
  z$2(Runnable paramRunnable, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.DP().Dz().o(12322, Boolean.valueOf(false));
    z.syncUploadMContactStatus(false, false);
    if (this.eRX != null) {
      this.eRX.run();
    }
    this.eRW.getSharedPreferences(ae.cqR(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.z.2
 * JD-Core Version:    0.7.0.1
 */