package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.e.a;

final class c$1$2
  implements a.b
{
  c$1$2(c.1 param1, a parama) {}
  
  public final boolean pE(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", this.fdW.getUsername());
    localIntent.putExtra("Contact_Nick", this.fdW.WA());
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
    localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
    localIntent.putExtra("sayhi_with_jump_to_profile", true);
    localIntent.putExtra(e.a.uHO, paramString);
    d.b(c.b(this.fdV.fdU), "profile", ".ui.SayHiWithSnsPermissionUI", localIntent, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c.1.2
 * JD-Core Version:    0.7.0.1
 */