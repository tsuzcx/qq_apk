package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(24954);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )" };
    AppMethodBeat.o(24954);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "FreeWifiInfo", null);
  }
  
  public final c axZ(String paramString)
  {
    AppMethodBeat.i(24950);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      AppMethodBeat.o(24950);
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + MD5Util.getMD5String(paramString) + "' and wifiType = 1";
    Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
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
  
  public final c aya(String paramString)
  {
    AppMethodBeat.i(24951);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
      AppMethodBeat.o(24951);
      return null;
    }
    paramString = "select * from FreeWifiInfo where ssidmd5 = '" + MD5Util.getMD5String(paramString) + "'";
    Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[] { paramString });
    paramString = rawQuery(paramString, new String[0]);
    if (paramString == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
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
  
  public final void ayb(String paramString)
  {
    AppMethodBeat.i(24953);
    paramString = "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + MD5Util.getMD5String(paramString) + "'";
    Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", new Object[] { paramString });
    Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", new Object[] { Boolean.valueOf(execSQL("FreeWifiInfo", paramString)) });
    AppMethodBeat.o(24953);
  }
  
  public final c dNN()
  {
    AppMethodBeat.i(24952);
    Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", new Object[] { "select * from FreeWifiInfo where connectState = 2" });
    Cursor localCursor = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
    if (localCursor == null)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.d
 * JD-Core Version:    0.7.0.1
 */