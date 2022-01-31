package com.tencent.mm.plugin.fingerprint.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.ui.MMActivity;

final class r$1
  implements DialogInterface.OnClickListener
{
  r$1(r paramr, MMActivity paramMMActivity, Bundle paramBundle) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.gGJ, WalletFaceIdAuthUI.class);
    paramDialogInterface.putExtra("pwd", this.klJ.getString("key_pwd1"));
    paramDialogInterface.putExtra("key_scene", 1);
    this.gGJ.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.r.1
 * JD-Core Version:    0.7.0.1
 */