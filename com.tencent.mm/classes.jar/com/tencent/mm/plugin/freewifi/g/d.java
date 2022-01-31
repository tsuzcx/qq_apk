package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(20884);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )" };
    AppMethodBeat.o(20884);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "FreeWifiInfo", null);
  }
  
  public final c OJ(String paramString)
  {
    AppMethodBeat.i(20880);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      AppMethodBeat.o(20880);
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + ag.cE(paramString) + "' and wifiType = 1";
    ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
      AppMethodBeat.o(20880);
      return null;
    }
    if (paramString.moveToFirst())
    {
      c localc = new c();
      localc.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(20880);
      return localc;
    }
    paramString.close();
    AppMethodBeat.o(20880);
    return null;
  }
  
  public final c OK(String paramString)
  {
    AppMethodBeat.i(20881);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      AppMethodBeat.o(20881);
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + ag.cE(paramString) + "'";
    ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
      AppMethodBeat.o(20881);
      return null;
    }
    if (paramString.moveToFirst())
    {
      c localc = new c();
      localc.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(20881);
      return localc;
    }
    paramString.close();
    AppMethodBeat.o(20881);
    return null;
  }
  
  public final void OL(String paramString)
  {
    AppMethodBeat.i(20883);
    paramString = "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + ag.cE(paramString) + "'";
    ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", new Object[] { paramString });
    ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", new Object[] { Boolean.valueOf(execSQL("FreeWifiInfo", paramString)) });
    AppMethodBeat.o(20883);
  }
  
  public final c bBk()
  {
    AppMethodBeat.i(20882);
    ab.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", new Object[] { "select * from FreeWifiInfo where connectState = 2" });
    Cursor localCursor = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
    if (localCursor == null)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
      AppMethodBeat.o(20882);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      c localc = new c();
      localc.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(20882);
      return localc;
    }
    localCursor.close();
    AppMethodBeat.o(20882);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.d
 * JD-Core Version:    0.7.0.1
 */