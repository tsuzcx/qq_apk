package com.tencent.mm.plugin.freewifi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class a
{
  public String bssid;
  public String ssid;
  public String tmu;
  public String tmv;
  public long tmw;
  public String tmx;
  public long tmy;
  public String type;
  public long uin;
  
  public static a ajO(String paramString)
  {
    AppMethodBeat.i(24759);
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[] { paramString });
    if (m.ea(paramString))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[] { paramString });
    paramString = bw.M(paramString, "sysmsg");
    if ((paramString == null) || (paramString.size() == 0))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
      AppMethodBeat.o(24759);
      return null;
    }
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + paramString.toString());
    if (!"freewifi".equalsIgnoreCase((String)paramString.get(".sysmsg.$type")))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    a locala = new a();
    locala.type = ((String)paramString.get(".sysmsg.type"));
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + locala.type);
    if (!"schemamsg".equals(locala.type))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    boolean bool = m.k(paramString, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(bool)));
    if (!bool)
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.uin = bt.getLong((String)paramString.get(".sysmsg.uin"), 0L);
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + locala.uin);
    locala.ssid = ((String)paramString.get(".sysmsg.schemamsg.ssid"));
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + locala.ssid);
    if (m.ea(locala.ssid))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.bssid = m.ajJ((String)paramString.get(".sysmsg.schemamsg.bssid"));
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + locala.bssid);
    locala.tmu = ((String)paramString.get(".sysmsg.schemamsg.mobilemac"));
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + locala.tmu);
    if (m.ea(locala.tmu))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.tmv = ((String)paramString.get(".sysmsg.schemamsg.mpappid"));
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + locala.tmv);
    locala.tmw = bt.getLong((String)paramString.get(".sysmsg.schemamsg.mpshopid"), 0L);
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + locala.tmw);
    locala.tmx = ((String)paramString.get(".sysmsg.schemamsg.schemaurl"));
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + locala.tmx);
    if (m.ea(locala.tmx))
    {
      ad.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.tmy = bt.getLong((String)paramString.get(".sysmsg.schemamsg.expiredseconds"), 0L);
    ad.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + locala.tmy);
    AppMethodBeat.o(24759);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.a
 * JD-Core Version:    0.7.0.1
 */