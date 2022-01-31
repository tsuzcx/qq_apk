package com.tencent.mm.modelfriend;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.tencent.mm.h.a.in;
import com.tencent.mm.m.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public class AddrBookObserver$AddrBookService
  extends Service
{
  public static boolean aSd = false;
  public static boolean ekO = false;
  public static String ekQ = "key_sync_session";
  private b ekR = new AddrBookObserver.AddrBookService.1(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.AddrBookObserver", "service start intent:%b", new Object[] { Boolean.valueOf(bool) });
      if (paramIntent != null) {
        break;
      }
      y.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
      stopSelf();
      return 2;
    }
    float f1 = paramIntent.getFloatExtra(ekQ, -1.0F);
    if (f1 == -1.0F)
    {
      y.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
      stopSelf();
      return 2;
    }
    paramIntent = ae.getContext().getSharedPreferences(ae.cqR(), 0);
    float f2 = paramIntent.getFloat(ekQ, 0.0F);
    if (f2 == f1)
    {
      y.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[] { Float.valueOf(f2) });
      stopSelf();
      return 2;
    }
    paramIntent.edit().putFloat(ekQ, f1).commit();
    y.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[] { Float.valueOf(f1) });
    if (aSd)
    {
      y.i("MicroMsg.AddrBookObserver", "service canceled");
      aSd = false;
      stopSelf();
      return 2;
    }
    try
    {
      if (!com.tencent.mm.kernel.g.DK())
      {
        y.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
        stopSelf();
        return 2;
      }
    }
    catch (Exception paramIntent)
    {
      y.printErrStackTrace("MicroMsg.AddrBookObserver", paramIntent, "", new Object[0]);
      y.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[] { paramIntent.getMessage() });
      stopSelf();
      return 2;
    }
    if (com.tencent.mm.m.g.AA().getInt("WCOEntranceSwitch", 0) > 0)
    {
      paramIntent = new in();
      com.tencent.mm.sdk.b.a.udP.m(paramIntent);
    }
    if ((l.WS()) && (!l.WO()))
    {
      y.i("MicroMsg.AddrBookObserver", "start sync");
      if (!w.bP(this))
      {
        ekO = true;
        com.tencent.mm.platformtools.a.syncAddrBook(this.ekR);
        return 2;
      }
      y.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
      stopSelf();
      return 2;
    }
    y.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
    stopSelf();
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService
 * JD-Core Version:    0.7.0.1
 */