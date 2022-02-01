package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class y$1
  implements DialogInterface.OnClickListener
{
  y$1(int paramInt, Activity paramActivity, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127740);
    Log.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.iWM) });
    h.IzE.a(11438, new Object[] { Integer.valueOf(this.iWM) });
    l.gX(true);
    y.syncUploadMContactStatus(true, false);
    a.bvc();
    if (this.mEN != null) {
      this.mEN.run();
    }
    this.fgc.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
    AppMethodBeat.o(127740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.y.1
 * JD-Core Version:    0.7.0.1
 */