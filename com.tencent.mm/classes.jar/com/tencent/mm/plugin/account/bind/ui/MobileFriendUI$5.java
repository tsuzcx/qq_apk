package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.sdk.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class MobileFriendUI$5
  implements DialogInterface.OnClickListener
{
  MobileFriendUI$5(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110149);
    com.tencent.mm.plugin.report.service.h.IzE.a(11438, new Object[] { Integer.valueOf(6) });
    Log.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(6) });
    l.gX(true);
    ((a)com.tencent.mm.kernel.h.ag(a.class)).syncUploadMContactStatus(true, true);
    MobileFriendUI.h(this.mUK);
    AppMethodBeat.o(110149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.5
 * JD-Core Version:    0.7.0.1
 */