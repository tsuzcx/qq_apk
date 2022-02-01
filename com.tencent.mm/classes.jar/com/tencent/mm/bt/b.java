package com.tencent.mm.bt;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class b
{
  public static void run()
  {
    AppMethodBeat.i(32072);
    if ((!ba.ajx()) || (ba.aiE()))
    {
      AppMethodBeat.o(32072);
      return;
    }
    long l3 = bt.aQJ();
    ba.aBQ();
    long l2 = bt.a((Long)c.ajl().get(331797, null), 0L);
    long l1 = l2;
    if (10013 == ac.iON)
    {
      l1 = l2;
      if (ac.iOO != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      ba.aBQ();
      c.ajl().set(331797, Long.valueOf(432000L + l3));
      try
      {
        bml localbml = new bml();
        localbml.GGQ = "";
        Account[] arrayOfAccount = AccountManager.get(aj.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!bt.isNullOrNil(localbml.GGQ)) {
            break;
          }
          ad.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localbml.GGQ = localAccount.name;
          i += 1;
        }
        if ((10013 == ac.iON) && (ac.iOO != 0)) {
          localbml.GGQ = "rssjbbk@gmail.com";
        }
        if (!bt.isNullOrNil(localbml.GGQ))
        {
          ba.aBQ();
          c.azo().c(new k.a(57, localbml));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bt.b
 * JD-Core Version:    0.7.0.1
 */