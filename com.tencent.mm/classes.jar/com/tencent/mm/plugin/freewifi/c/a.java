package com.tencent.mm.plugin.freewifi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a
{
  public String bssid;
  public String mJT;
  public String mJU;
  public long mJV;
  public String mJW;
  public long mJX;
  public String ssid;
  public String type;
  public long uin;
  
  public static a OA(String paramString)
  {
    AppMethodBeat.i(20682);
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[] { paramString });
    if (m.isEmpty(paramString))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
      AppMethodBeat.o(20682);
      return null;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[] { paramString });
    paramString = br.F(paramString, "sysmsg");
    if ((paramString == null) || (paramString.size() == 0))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
      AppMethodBeat.o(20682);
      return null;
    }
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + paramString.toString());
    if (!"freewifi".equalsIgnoreCase((String)paramString.get(".sysmsg.$type")))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
      AppMethodBeat.o(20682);
      return null;
    }
    a locala = new a();
    locala.type = ((String)paramString.get(".sysmsg.type"));
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + locala.type);
    if (!"schemamsg".equals(locala.type))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
      AppMethodBeat.o(20682);
      return null;
    }
    boolean bool = m.k(paramString, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(bool)));
    if (!bool)
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
      AppMethodBeat.o(20682);
      return null;
    }
    locala.uin = bo.getLong((String)paramString.get(".sysmsg.uin"), 0L);
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + locala.uin);
    locala.ssid = ((String)paramString.get(".sysmsg.schemamsg.ssid"));
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + locala.ssid);
    if (m.isEmpty(locala.ssid))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
      AppMethodBeat.o(20682);
      return null;
    }
    locala.bssid = m.Ov((String)paramString.get(".sysmsg.schemamsg.bssid"));
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + locala.bssid);
    locala.mJT = ((String)paramString.get(".sysmsg.schemamsg.mobilemac"));
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + locala.mJT);
    if (m.isEmpty(locala.mJT))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
      AppMethodBeat.o(20682);
      return null;
    }
    locala.mJU = ((String)paramString.get(".sysmsg.schemamsg.mpappid"));
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + locala.mJU);
    locala.mJV = bo.getLong((String)paramString.get(".sysmsg.schemamsg.mpshopid"), 0L);
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + locala.mJV);
    locala.mJW = ((String)paramString.get(".sysmsg.schemamsg.schemaurl"));
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + locala.mJW);
    if (m.isEmpty(locala.mJW))
    {
      ab.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
      AppMethodBeat.o(20682);
      return null;
    }
    locala.mJX = bo.getLong((String)paramString.get(".sysmsg.schemamsg.expiredseconds"), 0L);
    ab.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + locala.mJX);
    AppMethodBeat.o(20682);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.a
 * JD-Core Version:    0.7.0.1
 */