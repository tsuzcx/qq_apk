package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.e.b;

final class d$1$2
  implements a.b
{
  d$1$2(d.1 param1, a parama) {}
  
  public final boolean wU(String paramString)
  {
    AppMethodBeat.i(13707);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.gvG.getUsername());
    localIntent.putExtra("Contact_Nick", this.gvG.aqc());
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
    localIntent.putExtra("sayhi_with_jump_to_profile", true);
    localIntent.putExtra(e.b.yUZ, paramString);
    com.tencent.mm.bq.d.b(d.b(this.gvO.gvN), "profile", ".ui.SayHiWithSnsPermissionUI", localIntent, 1);
    AppMethodBeat.o(13707);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d.1.2
 * JD-Core Version:    0.7.0.1
 */