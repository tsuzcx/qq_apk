package com.tencent.mm.plugin.freewifi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class a
{
  public String bssid;
  public String spR;
  public String spS;
  public long spT;
  public String spU;
  public long spV;
  public String ssid;
  public String type;
  public long uin;
  
  public static a afq(String paramString)
  {
    AppMethodBeat.i(24759);
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[] { paramString });
    if (m.cX(paramString))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[] { paramString });
    paramString = bv.L(paramString, "sysmsg");
    if ((paramString == null) || (paramString.size() == 0))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
      AppMethodBeat.o(24759);
      return null;
    }
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + paramString.toString());
    if (!"freewifi".equalsIgnoreCase((String)paramString.get(".sysmsg.$type")))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    a locala = new a();
    locala.type = ((String)paramString.get(".sysmsg.type"));
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + locala.type);
    if (!"schemamsg".equals(locala.type))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    boolean bool = m.j(paramString, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(bool)));
    if (!bool)
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.uin = bs.getLong((String)paramString.get(".sysmsg.uin"), 0L);
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + locala.uin);
    locala.ssid = ((String)paramString.get(".sysmsg.schemamsg.ssid"));
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + locala.ssid);
    if (m.cX(locala.ssid))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.bssid = m.afl((String)paramString.get(".sysmsg.schemamsg.bssid"));
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + locala.bssid);
    locala.spR = ((String)paramString.get(".sysmsg.schemamsg.mobilemac"));
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + locala.spR);
    if (m.cX(locala.spR))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.spS = ((String)paramString.get(".sysmsg.schemamsg.mpappid"));
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + locala.spS);
    locala.spT = bs.getLong((String)paramString.get(".sysmsg.schemamsg.mpshopid"), 0L);
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + locala.spT);
    locala.spU = ((String)paramString.get(".sysmsg.schemamsg.schemaurl"));
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + locala.spU);
    if (m.cX(locala.spU))
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.spV = bs.getLong((String)paramString.get(".sysmsg.schemamsg.expiredseconds"), 0L);
    ac.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + locala.spV);
    AppMethodBeat.o(24759);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.a
 * JD-Core Version:    0.7.0.1
 */