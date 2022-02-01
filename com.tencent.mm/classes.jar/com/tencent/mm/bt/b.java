package com.tencent.mm.bt;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static void run()
  {
    AppMethodBeat.i(32072);
    if ((!az.afw()) || (az.aeC()))
    {
      AppMethodBeat.o(32072);
      return;
    }
    long l3 = bt.aGK();
    az.arV();
    long l2 = bt.a((Long)c.afk().get(331797, null), 0L);
    long l1 = l2;
    if (10013 == com.tencent.mm.platformtools.ab.hVC)
    {
      l1 = l2;
      if (com.tencent.mm.platformtools.ab.hVD != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      az.arV();
      c.afk().set(331797, Long.valueOf(432000L + l3));
      try
      {
        bel localbel = new bel();
        localbel.DBY = "";
        Account[] arrayOfAccount = AccountManager.get(aj.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!bt.isNullOrNil(localbel.DBY)) {
            break;
          }
          ad.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localbel.DBY = localAccount.name;
          i += 1;
        }
        if ((10013 == com.tencent.mm.platformtools.ab.hVC) && (com.tencent.mm.platformtools.ab.hVD != 0)) {
          localbel.DBY = "rssjbbk@gmail.com";
        }
        if (!bt.isNullOrNil(localbel.DBY))
        {
          az.arV();
          c.apL().c(new j.a(57, localbel));
          AppMethodBeat.o(32072);
          return;
        }
        ad.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
        AppMethodBeat.o(32072);
        return;
      }
      catch (Exception localException)
      {
        ad.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(32072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bt.b
 * JD-Core Version:    0.7.0.1
 */