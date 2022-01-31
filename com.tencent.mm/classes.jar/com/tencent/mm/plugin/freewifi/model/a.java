package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  SparseArray<Long> kol = new SparseArray();
  private g kom = new g();
  
  public final void a(String paramString, g.b paramb, int paramInt, Intent paramIntent)
  {
    g localg = this.kom;
    j.aUl().aTT().post(new g.1(localg, paramString, paramIntent, paramb, paramInt));
  }
  
  public final void a(String paramString1, String paramString2, Intent paramIntent)
  {
    g localg = this.kom;
    j.aUl().aTT().post(new g.2(localg, paramString2, paramString1, paramIntent));
  }
  
  public final void aTQ()
  {
    for (;;)
    {
      String str4;
      com.tencent.mm.plugin.freewifi.g.c localc;
      int j;
      try
      {
        y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String str3 = d.aTX();
        y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", new Object[] { str3 });
        bool = bk.bl(str3);
        if (bool) {
          return;
        }
        if (j.aUi().DB(str3) != null) {
          continue;
        }
        str4 = d.aTV();
        if (str4 == null)
        {
          i = 0;
          y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d", new Object[] { str3, str4, Integer.valueOf(i) });
          if (bk.bl(str4)) {
            continue;
          }
          localc = j.aUi().DC(str3);
          if (localc != null) {
            break label434;
          }
          String str1 = "null free wifiinfo";
          y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now mac is : %s, loacal mac is : %s", new Object[] { str4, str1 });
          if (localc == null) {
            break label444;
          }
          y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", new Object[] { Long.valueOf(localc.field_expiredTime) });
          if ((str4.equalsIgnoreCase(localc.field_mac)) && (localc.field_expiredTime - bk.UX() >= 0L)) {
            break label539;
          }
          y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
          bool = true;
          y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            continue;
          }
          int k = d.aTW();
          y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", new Object[] { Integer.valueOf(k), str4, Integer.valueOf(str4.hashCode()) });
          if (System.currentTimeMillis() - i.a.aTw().pn("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") <= i.a.aTw().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24 * 60 * 60 * 1000) {
            break label534;
          }
          j = 1;
          i = j;
          if (i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
            i = j | 0x2;
          }
          j = i;
          if (i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
            j = i | 0x4;
          }
          i = j;
          if (i.a.aTw().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
            i = j | 0x8;
          }
          y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : " + i);
          new b(str4, str3, k, i).b(new a.1(this));
          continue;
        }
        int i = str4.hashCode();
      }
      finally {}
      continue;
      label434:
      String str2 = localc.field_mac;
      continue;
      label444:
      if (this.kol.indexOfKey(str4.hashCode()) >= 0)
      {
        long l = ((Long)this.kol.get(str4.hashCode())).longValue();
        y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", new Object[] { Long.valueOf(bk.UY() - l) });
        if (bk.UY() - l > 43200000L) {
          bool = true;
        }
      }
      else
      {
        y.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
        bool = true;
        continue;
        j = 0;
        continue;
      }
      label534:
      label539:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.a
 * JD-Core Version:    0.7.0.1
 */