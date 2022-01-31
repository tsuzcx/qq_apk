package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.m.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.service.MMService;

public class AddrBookObserver$AddrBookService
  extends MMService
{
  public static boolean fBf = false;
  public static String fBh = "key_sync_session";
  public static boolean isCanceled = false;
  private b fBi;
  
  public AddrBookObserver$AddrBookService()
  {
    AppMethodBeat.i(124499);
    this.fBi = new AddrBookObserver.AddrBookService.1(this);
    AppMethodBeat.o(124499);
  }
  
  public final IBinder It()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.AddrBookObserver";
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124500);
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AddrBookObserver", "service start intent:%b", new Object[] { Boolean.valueOf(bool) });
      if (paramIntent != null) {
        break;
      }
      ab.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
      stopSelf();
      AppMethodBeat.o(124500);
      return 2;
    }
    float f1 = paramIntent.getFloatExtra(fBh, -1.0F);
    if (f1 == -1.0F)
    {
      ab.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
      stopSelf();
      AppMethodBeat.o(124500);
      return 2;
    }
    paramIntent = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    float f2 = paramIntent.getFloat(fBh, 0.0F);
    if (f2 == f1)
    {
      ab.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
      stopSelf();
      AppMethodBeat.o(124500);
      return 2;
    }
    paramIntent.edit().putFloat(fBh, f1).commit();
    ab.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
    if (isCanceled)
    {
      ab.i("MicroMsg.AddrBookObserver", "service canceled");
      isCanceled = false;
      stopSelf();
      AppMethodBeat.o(124500);
      return 2;
    }
    for (;;)
    {
      try
      {
        if (!com.tencent.mm.kernel.g.RG())
        {
          ab.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
          stopSelf();
          AppMethodBeat.o(124500);
          return 2;
        }
        if (com.tencent.mm.m.g.Nq().getInt("WCOEntranceSwitch", 0) > 0)
        {
          paramIntent = new iu();
          com.tencent.mm.sdk.b.a.ymk.l(paramIntent);
        }
        if ((!l.aqt()) || (l.aqp())) {
          continue;
        }
        ab.i("MicroMsg.AddrBookObserver", "start sync");
        if (w.cw(ah.getContext())) {
          continue;
        }
        fBf = true;
        com.tencent.mm.platformtools.a.syncAddrBook(this.fBi);
      }
      catch (Exception paramIntent)
      {
        ab.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
        ab.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
        stopSelf();
        continue;
      }
      AppMethodBeat.o(124500);
      return 2;
      ab.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
      stopSelf();
      AppMethodBeat.o(124500);
      return 2;
      ab.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
      stopSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService
 * JD-Core Version:    0.7.0.1
 */