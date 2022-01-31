package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.storage.z;

final class MobileFriendUI$6
  implements DialogInterface.OnClickListener
{
  MobileFriendUI$6(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.DP().Dz().o(12322, Boolean.valueOf(false));
    ((a)g.t(a.class)).syncUploadMContactStatus(false, true);
    this.fes.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.6
 * JD-Core Version:    0.7.0.1
 */