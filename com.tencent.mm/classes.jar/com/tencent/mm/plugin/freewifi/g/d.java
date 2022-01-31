package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )" };
  
  public d(e parame)
  {
    super(parame, c.buS, "FreeWifiInfo", null);
  }
  
  public final c DB(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + ad.bB(paramString) + "' and wifiType = 1";
    y.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
      return null;
    }
    if (paramString.moveToFirst())
    {
      c localc = new c();
      localc.d(paramString);
      paramString.close();
      return localc;
    }
    paramString.close();
    return null;
  }
  
  public final c DC(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + ad.bB(paramString) + "'";
    y.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
      return null;
    }
    if (paramString.moveToFirst())
    {
      c localc = new c();
      localc.d(paramString);
      paramString.close();
      return localc;
    }
    paramString.close();
    return null;
  }
  
  public final void DD(String paramString)
  {
    paramString = "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + ad.bB(paramString) + "'";
    y.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", new Object[] { paramString });
    y.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", new Object[] { Boolean.valueOf(gk("FreeWifiInfo", paramString)) });
  }
  
  public final c aUL()
  {
    y.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", new Object[] { "select * from FreeWifiInfo where connectState = 2" });
    Cursor localCursor = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
    if (localCursor == null)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
      return null;
    }
    if (localCursor.moveToFirst())
    {
      c localc = new c();
      localc.d(localCursor);
      localCursor.close();
      return localc;
    }
    localCursor.close();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.d
 * JD-Core Version:    0.7.0.1
 */