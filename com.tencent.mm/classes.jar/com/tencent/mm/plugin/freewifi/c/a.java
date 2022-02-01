package com.tencent.mm.plugin.freewifi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a
{
  public String bssid;
  public String ssid;
  public String type;
  public long uin;
  public String wOq;
  public String wOr;
  public long wOs;
  public String wOt;
  public long wOu;
  
  public static a axQ(String paramString)
  {
    AppMethodBeat.i(24759);
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[] { paramString });
    if (m.eP(paramString))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[] { paramString });
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if ((paramString == null) || (paramString.size() == 0))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
      AppMethodBeat.o(24759);
      return null;
    }
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + paramString.toString());
    if (!"freewifi".equalsIgnoreCase((String)paramString.get(".sysmsg.$type")))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    a locala = new a();
    locala.type = ((String)paramString.get(".sysmsg.type"));
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + locala.type);
    if (!"schemamsg".equals(locala.type))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    boolean bool = m.l(paramString, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(bool)));
    if (!bool)
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.uin = Util.getLong((String)paramString.get(".sysmsg.uin"), 0L);
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + locala.uin);
    locala.ssid = ((String)paramString.get(".sysmsg.schemamsg.ssid"));
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + locala.ssid);
    if (m.eP(locala.ssid))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.bssid = m.axL((String)paramString.get(".sysmsg.schemamsg.bssid"));
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + locala.bssid);
    locala.wOq = ((String)paramString.get(".sysmsg.schemamsg.mobilemac"));
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + locala.wOq);
    if (m.eP(locala.wOq))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.wOr = ((String)paramString.get(".sysmsg.schemamsg.mpappid"));
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + locala.wOr);
    locala.wOs = Util.getLong((String)paramString.get(".sysmsg.schemamsg.mpshopid"), 0L);
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + locala.wOs);
    locala.wOt = ((String)paramString.get(".sysmsg.schemamsg.schemaurl"));
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + locala.wOt);
    if (m.eP(locala.wOt))
    {
      Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.wOu = Util.getLong((String)paramString.get(".sysmsg.schemamsg.expiredseconds"), 0L);
    Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + locala.wOu);
    AppMethodBeat.o(24759);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.a
 * JD-Core Version:    0.7.0.1
 */