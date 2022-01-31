package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ContactsSyncUI$1
  implements Runnable
{
  ContactsSyncUI$1(ContactsSyncUI paramContactsSyncUI, String paramString) {}
  
  public final void run()
  {
    ContactsSyncUI localContactsSyncUI = this.flj;
    if (this.fli.equals("android.permission.READ_CONTACTS")) {}
    for (String str = "android.permission.WRITE_CONTACTS";; str = "android.permission.READ_CONTACTS")
    {
      boolean bool = a.a(localContactsSyncUI, str, 48, null, null);
      y.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", new Object[] { Boolean.valueOf(bool), this.fli, bk.csb() });
      if (bool) {
        this.flj.initView();
      }
      return;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|checkContacts";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ContactsSyncUI.1
 * JD-Core Version:    0.7.0.1
 */