package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class MobileFriendUI$5
  implements DialogInterface.OnClickListener
{
  MobileFriendUI$5(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(11438, new Object[] { Integer.valueOf(6) });
    y.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(6) });
    g.DP().Dz().o(12322, Boolean.valueOf(true));
    ((a)g.t(a.class)).syncUploadMContactStatus(true, true);
    MobileFriendUI.h(this.fes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.5
 * JD-Core Version:    0.7.0.1
 */