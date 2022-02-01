package com.tencent.mm.bs;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class b
{
  public static void run()
  {
    AppMethodBeat.i(32072);
    if ((!bg.aAc()) || (bg.azj()))
    {
      AppMethodBeat.o(32072);
      return;
    }
    long l3 = Util.nowSecond();
    bg.aVF();
    long l2 = Util.nullAs((Long)c.azQ().get(331797, null), 0L);
    long l1 = l2;
    if (10013 == ac.jOC)
    {
      l1 = l2;
      if (ac.jOD != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      bg.aVF();
      c.azQ().set(331797, Long.valueOf(432000L + l3));
      try
      {
        bzu localbzu = new bzu();
        localbzu.Mfs = "";
        Account[] arrayOfAccount = AccountManager.get(MMApplicationContext.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!Util.isNullOrNil(localbzu.Mfs)) {
            break;
          }
          Log.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localbzu.Mfs = localAccount.name;
          i += 1;
        }
        if ((10013 == ac.jOC) && (ac.jOD != 0)) {
          localbzu.Mfs = "rssjbbk@gmail.com";
        }
        if (!Util.isNullOrNil(localbzu.Mfs))
        {
          bg.aVF();
          c.aSM().d(new k.a(57, localbzu));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bs.b
 * JD-Core Version:    0.7.0.1
 */