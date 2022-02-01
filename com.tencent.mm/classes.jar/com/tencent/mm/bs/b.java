package com.tencent.mm.bs;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class b
{
  public static void run()
  {
    AppMethodBeat.i(32072);
    if ((!az.agM()) || (az.afS()))
    {
      AppMethodBeat.o(32072);
      return;
    }
    long l3 = bs.aNx();
    az.ayM();
    long l2 = bs.a((Long)c.agA().get(331797, null), 0L);
    long l1 = l2;
    if (10013 == ab.ivG)
    {
      l1 = l2;
      if (ab.ivH != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      az.ayM();
      c.agA().set(331797, Long.valueOf(432000L + l3));
      try
      {
        bid localbid = new bid();
        localbid.EXu = "";
        Account[] arrayOfAccount = AccountManager.get(ai.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!bs.isNullOrNil(localbid.EXu)) {
            break;
          }
          ac.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localbid.EXu = localAccount.name;
          i += 1;
        }
        if ((10013 == ab.ivG) && (ab.ivH != 0)) {
          localbid.EXu = "rssjbbk@gmail.com";
        }
        if (!bs.isNullOrNil(localbid.EXu))
        {
          az.ayM();
          c.awA().c(new j.a(57, localbid));
          AppMethodBeat.o(32072);
          return;
        }
        ac.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
        AppMethodBeat.o(32072);
        return;
      }
      catch (Exception localException)
      {
        ac.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(32072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bs.b
 * JD-Core Version:    0.7.0.1
 */