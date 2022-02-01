package com.tencent.mm.plugin.freewifi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class a
{
  public String bssid;
  public String ssid;
  public String txm;
  public String txn;
  public long txo;
  public String txp;
  public long txq;
  public String type;
  public long uin;
  
  public static a akM(String paramString)
  {
    AppMethodBeat.i(24759);
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[] { paramString });
    if (m.ef(paramString))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[] { paramString });
    paramString = bx.M(paramString, "sysmsg");
    if ((paramString == null) || (paramString.size() == 0))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
      AppMethodBeat.o(24759);
      return null;
    }
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + paramString.toString());
    if (!"freewifi".equalsIgnoreCase((String)paramString.get(".sysmsg.$type")))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    a locala = new a();
    locala.type = ((String)paramString.get(".sysmsg.type"));
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + locala.type);
    if (!"schemamsg".equals(locala.type))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    boolean bool = m.k(paramString, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(bool)));
    if (!bool)
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.uin = bu.getLong((String)paramString.get(".sysmsg.uin"), 0L);
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + locala.uin);
    locala.ssid = ((String)paramString.get(".sysmsg.schemamsg.ssid"));
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + locala.ssid);
    if (m.ef(locala.ssid))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.bssid = m.akH((String)paramString.get(".sysmsg.schemamsg.bssid"));
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + locala.bssid);
    locala.txm = ((String)paramString.get(".sysmsg.schemamsg.mobilemac"));
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + locala.txm);
    if (m.ef(locala.txm))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.txn = ((String)paramString.get(".sysmsg.schemamsg.mpappid"));
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + locala.txn);
    locala.txo = bu.getLong((String)paramString.get(".sysmsg.schemamsg.mpshopid"), 0L);
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + locala.txo);
    locala.txp = ((String)paramString.get(".sysmsg.schemamsg.schemaurl"));
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + locala.txp);
    if (m.ef(locala.txp))
    {
      ae.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
      AppMethodBeat.o(24759);
      return null;
    }
    locala.txq = bu.getLong((String)paramString.get(".sysmsg.schemamsg.expiredseconds"), 0L);
    ae.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + locala.txq);
    AppMethodBeat.o(24759);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.a
 * JD-Core Version:    0.7.0.1
 */