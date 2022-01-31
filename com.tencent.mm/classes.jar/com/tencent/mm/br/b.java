package com.tencent.mm.br;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class b
{
  public static void run()
  {
    AppMethodBeat.i(28268);
    if ((!aw.RG()) || (aw.QP()))
    {
      AppMethodBeat.o(28268);
      return;
    }
    long l3 = bo.aox();
    aw.aaz();
    long l2 = bo.a((Long)c.Ru().get(331797, null), 0L);
    long l1 = l2;
    if (10013 == ae.gkK)
    {
      l1 = l2;
      if (ae.gkL != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      aw.aaz();
      c.Ru().set(331797, Long.valueOf(432000L + l3));
      try
      {
        atk localatk = new atk();
        localatk.xiG = "";
        Account[] arrayOfAccount = AccountManager.get(ah.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!bo.isNullOrNil(localatk.xiG)) {
            break;
          }
          ab.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localatk.xiG = localAccount.name;
          i += 1;
        }
        if ((10013 == ae.gkK) && (ae.gkL != 0)) {
          localatk.xiG = "rssjbbk@gmail.com";
        }
        if (!bo.isNullOrNil(localatk.xiG))
        {
          aw.aaz();
          c.Yz().c(new j.a(57, localatk));
          AppMethodBeat.o(28268);
          return;
        }
        ab.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
        AppMethodBeat.o(28268);
        return;
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(28268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.br.b
 * JD-Core Version:    0.7.0.1
 */