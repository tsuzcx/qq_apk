package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  SparseArray<Long> wOv;
  private g wOw;
  
  public a()
  {
    AppMethodBeat.i(24761);
    this.wOv = new SparseArray();
    this.wOw = new g();
    AppMethodBeat.o(24761);
  }
  
  public final void a(String paramString, g.b paramb, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(24762);
    g localg = this.wOw;
    j.dNq().dMZ().post(new g.1(localg, paramString, paramIntent, paramb, paramInt));
    AppMethodBeat.o(24762);
  }
  
  public final void a(String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(24763);
    g localg = this.wOw;
    j.dNq().dMZ().post(new g.2(localg, paramString2, paramString1, paramIntent));
    AppMethodBeat.o(24763);
  }
  
  public final void dMW()
  {
    String str2;
    try
    {
      AppMethodBeat.i(24764);
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
      str2 = d.dNf();
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", new Object[] { str2 });
      if (Util.isNullOrNil(str2)) {
        AppMethodBeat.o(24764);
      }
      for (;;)
      {
        return;
        if (j.dNn().axZ(str2) == null) {
          break;
        }
        AppMethodBeat.o(24764);
      }
      str3 = d.dNb();
    }
    finally {}
    String str3;
    if (str3 == null) {}
    for (int i = 0;; i = str3.hashCode())
    {
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d", new Object[] { str2, str3, Integer.valueOf(i) });
      if (!Util.isNullOrNil(str3)) {
        break label146;
      }
      AppMethodBeat.o(24764);
      break;
    }
    label146:
    com.tencent.mm.plugin.freewifi.g.c localc = j.dNn().aya(str2);
    String str1;
    label165:
    boolean bool;
    if (localc == null)
    {
      str1 = "null free wifiinfo";
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now mac is : %s, loacal mac is : %s", new Object[] { str3, str1 });
      if (localc == null) {
        break label469;
      }
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", new Object[] { Long.valueOf(localc.field_expiredTime) });
      if ((str3.equalsIgnoreCase(localc.field_mac)) && (localc.field_expiredTime - Util.nowSecond() >= 0L)) {
        break label564;
      }
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
      bool = true;
    }
    for (;;)
    {
      label250:
      Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", new Object[] { Boolean.valueOf(bool) });
      int k;
      if (bool)
      {
        k = d.dNc();
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", new Object[] { Integer.valueOf(k), str3, Integer.valueOf(str3.hashCode()) });
        if (System.currentTimeMillis() - i.a.dME().Fk("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") <= i.a.dME().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24 * 60 * 60 * 1000) {
          break label559;
        }
      }
      label559:
      for (int j = 1;; j = 0)
      {
        i = j;
        if (i.a.dME().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
          i = j | 0x2;
        }
        j = i;
        if (i.a.dME().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
          j = i | 0x4;
        }
        i = j;
        if (i.a.dME().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
          i = j | 0x8;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : ".concat(String.valueOf(i)));
        new b(str3, str2, k, i).c(new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(24760);
            paramAnonymousString = ((b)paramAnonymousq).mac;
            if (m.eP(paramAnonymousString))
            {
              AppMethodBeat.o(24760);
              return;
            }
            if (paramAnonymousInt2 == -30011)
            {
              a.this.wOv.put(paramAnonymousString.hashCode(), Long.valueOf(Util.nowMilliSecond()));
              AppMethodBeat.o(24760);
              return;
            }
            a.this.wOv.remove(paramAnonymousString.hashCode());
            AppMethodBeat.o(24760);
          }
        });
        AppMethodBeat.o(24764);
        break;
        str1 = localc.field_mac;
        break label165;
        label469:
        if (this.wOv.indexOfKey(str3.hashCode()) >= 0)
        {
          long l = ((Long)this.wOv.get(str3.hashCode())).longValue();
          Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
          if (Util.nowMilliSecond() - l <= 43200000L) {
            break label564;
          }
          bool = true;
          break label250;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
        bool = true;
        break label250;
      }
      label564:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.a
 * JD-Core Version:    0.7.0.1
 */