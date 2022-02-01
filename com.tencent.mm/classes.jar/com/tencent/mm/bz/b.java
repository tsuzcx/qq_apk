package com.tencent.mm.bz;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class b
{
  public static void run()
  {
    AppMethodBeat.i(32072);
    if ((!bh.aHB()) || (bh.aGE()))
    {
      AppMethodBeat.o(32072);
      return;
    }
    long l3 = Util.nowSecond();
    bh.beI();
    long l2 = Util.nullAs((Long)c.aHp().b(331797, null), 0L);
    long l1 = l2;
    if (10013 == ac.mFM)
    {
      l1 = l2;
      if (ac.mFN != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      bh.beI();
      c.aHp().i(331797, Long.valueOf(432000L + l3));
      try
      {
        chp localchp = new chp();
        localchp.ToW = "";
        Account[] arrayOfAccount = AccountManager.get(MMApplicationContext.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!Util.isNullOrNil(localchp.ToW)) {
            break;
          }
          Log.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localchp.ToW = localAccount.name;
          i += 1;
        }
        if ((10013 == ac.mFM) && (ac.mFN != 0)) {
          localchp.ToW = "rssjbbk@gmail.com";
        }
        if (!Util.isNullOrNil(localchp.ToW))
        {
          bh.beI();
          c.bbK().d(new k.a(57, localchp));
          AppMethodBeat.o(32072);
          return;
        }
        Log.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
        AppMethodBeat.o(32072);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(32072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.b
 * JD-Core Version:    0.7.0.1
 */