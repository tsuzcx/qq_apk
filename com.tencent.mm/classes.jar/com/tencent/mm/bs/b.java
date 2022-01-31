package com.tencent.mm.bs;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class b
{
  public static void run()
  {
    long l1 = 0L;
    if ((!au.DK()) || (au.CW())) {}
    for (;;)
    {
      return;
      long l3 = bk.UX();
      au.Hx();
      long l2 = bk.a((Long)c.Dz().get(331797, null), 0L);
      if ((10013 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ != 0)) {}
      while (l1 < l3)
      {
        au.Hx();
        c.Dz().o(331797, Long.valueOf(432000L + l3));
        try
        {
          anu localanu = new anu();
          localanu.tjP = "";
          Account[] arrayOfAccount = AccountManager.get(com.tencent.mm.sdk.platformtools.ae.getContext()).getAccountsByType("com.google");
          int j = arrayOfAccount.length;
          int i = 0;
          while (i < j)
          {
            Account localAccount = arrayOfAccount[i];
            if (!bk.bl(localanu.tjP)) {
              break;
            }
            y.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
            localanu.tjP = localAccount.name;
            i += 1;
          }
          if ((10013 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ != 0)) {
            localanu.tjP = "rssjbbk@gmail.com";
          }
          if (!bk.bl(localanu.tjP))
          {
            au.Hx();
            c.Fv().b(new i.a(57, localanu));
            return;
          }
        }
        catch (Exception localException)
        {
          y.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[] { localException.getMessage() });
          return;
        }
        y.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
        return;
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bs.b
 * JD-Core Version:    0.7.0.1
 */