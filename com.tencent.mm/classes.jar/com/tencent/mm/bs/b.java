package com.tencent.mm.bs;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class b
{
  public static void run()
  {
    AppMethodBeat.i(32072);
    if ((!bc.ajM()) || (bc.aiT()))
    {
      AppMethodBeat.o(32072);
      return;
    }
    long l3 = bu.aRi();
    bc.aCg();
    long l2 = bu.a((Long)c.ajA().get(331797, null), 0L);
    long l1 = l2;
    if (10013 == ac.iRH)
    {
      l1 = l2;
      if (ac.iRI != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      bc.aCg();
      c.ajA().set(331797, Long.valueOf(432000L + l3));
      try
      {
        bnd localbnd = new bnd();
        localbnd.Has = "";
        Account[] arrayOfAccount = AccountManager.get(ak.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!bu.isNullOrNil(localbnd.Has)) {
            break;
          }
          ae.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localbnd.Has = localAccount.name;
          i += 1;
        }
        if ((10013 == ac.iRH) && (ac.iRI != 0)) {
          localbnd.Has = "rssjbbk@gmail.com";
        }
        if (!bu.isNullOrNil(localbnd.Has))
        {
          bc.aCg();
          c.azE().d(new k.a(57, localbnd));
          AppMethodBeat.o(32072);
          return;
        }
        ae.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
        AppMethodBeat.o(32072);
        return;
      }
      catch (Exception localException)
      {
        ae.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(32072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bs.b
 * JD-Core Version:    0.7.0.1
 */