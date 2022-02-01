package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(24954);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )" };
    AppMethodBeat.o(24954);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "FreeWifiInfo", null);
  }
  
  public final c ajX(String paramString)
  {
    AppMethodBeat.i(24950);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      AppMethodBeat.o(24950);
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + ai.ee(paramString) + "' and wifiType = 1";
    ad.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
      AppMethodBeat.o(24950);
      return null;
    }
    if (paramString.moveToFirst())
    {
      c localc = new c();
      localc.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(24950);
      return localc;
    }
    paramString.close();
    AppMethodBeat.o(24950);
    return null;
  }
  
  public final c ajY(String paramString)
  {
    AppMethodBeat.i(24951);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      AppMethodBeat.o(24951);
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + ai.ee(paramString) + "'";
    ad.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
      AppMethodBeat.o(24951);
      return null;
    }
    if (paramString.moveToFirst())
    {
      c localc = new c();
      localc.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(24951);
      return localc;
    }
    paramString.close();
    AppMethodBeat.o(24951);
    return null;
  }
  
  public final void ajZ(String paramString)
  {
    AppMethodBeat.i(24953);
    paramString = "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + ai.ee(paramString) + "'";
    ad.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", new Object[] { paramString });
    ad.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", new Object[] { Boolean.valueOf(execSQL("FreeWifiInfo", paramString)) });
    AppMethodBeat.o(24953);
  }
  
  public final c cRZ()
  {
    AppMethodBeat.i(24952);
    ad.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", new Object[] { "select * from FreeWifiInfo where connectState = 2" });
    Cursor localCursor = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
    if (localCursor == null)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
      AppMethodBeat.o(24952);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      c localc = new c();
      localc.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(24952);
      return localc;
    }
    localCursor.close();
    AppMethodBeat.o(24952);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.d
 * JD-Core Version:    0.7.0.1
 */