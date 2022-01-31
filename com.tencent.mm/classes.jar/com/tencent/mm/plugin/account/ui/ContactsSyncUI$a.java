package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.w.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.model.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class ContactsSyncUI$a
  implements b.a
{
  private boolean flk;
  private w.a fll = new ContactsSyncUI.a.1(this);
  
  public ContactsSyncUI$a(ContactsSyncUI paramContactsSyncUI, boolean paramBoolean)
  {
    this.flk = paramBoolean;
  }
  
  final int L(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return 1;
    }
    int i = w.a(paramContext, paramString, this.fll);
    if (i == 2)
    {
      Toast.makeText(paramContext, this.flj.getString(q.j.contact_sync_add_account_failed), 1).show();
      return 1;
    }
    if (i == 3)
    {
      Toast.makeText(paramContext, this.flj.getString(q.j.contact_sync_add_account_already_exist), 1).show();
      return 1;
    }
    return 0;
  }
  
  public final int bY(Context paramContext)
  {
    g.DN();
    if ((!a.Db()) || (a.CW())) {
      return 4;
    }
    if (!this.flk)
    {
      y.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
      w.a(this.flj, this.fll);
      return 0;
    }
    String str = (String)g.DP().Dz().get(6, "");
    if (bk.bl(str))
    {
      y.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
      return 2;
    }
    if (l.WO())
    {
      h.a(paramContext, q.j.contact_sync_add_account_alert, q.j.app_tip, q.j.app_ok, q.j.app_cancel, new ContactsSyncUI.a.2(this, paramContext, str), new ContactsSyncUI.a.3(this, paramContext));
      return 5;
    }
    return L(paramContext, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI.a
 * JD-Core Version:    0.7.0.1
 */