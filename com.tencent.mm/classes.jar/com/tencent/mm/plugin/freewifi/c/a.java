package com.tencent.mm.plugin.freewifi.c;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class a
{
  public String bssid;
  public String kog;
  public String koh;
  public long koi;
  public String koj;
  public long kok;
  public String ssid;
  public String type;
  public long uin;
  
  public static a Ds(String paramString)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[] { paramString });
    if (m.isEmpty(paramString))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
      return null;
    }
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[] { paramString });
    paramString = bn.s(paramString, "sysmsg");
    if ((paramString == null) || (paramString.size() == 0))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
      return null;
    }
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + paramString.toString());
    if (!"freewifi".equalsIgnoreCase((String)paramString.get(".sysmsg.$type")))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
      return null;
    }
    a locala = new a();
    locala.type = ((String)paramString.get(".sysmsg.type"));
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + locala.type);
    if (!"schemamsg".equals(locala.type))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
      return null;
    }
    boolean bool = m.k(paramString, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=" + bool);
    if (!bool)
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
      return null;
    }
    locala.uin = bk.getLong((String)paramString.get(".sysmsg.uin"), 0L);
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + locala.uin);
    locala.ssid = ((String)paramString.get(".sysmsg.schemamsg.ssid"));
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + locala.ssid);
    if (m.isEmpty(locala.ssid))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
      return null;
    }
    locala.bssid = m.Dn((String)paramString.get(".sysmsg.schemamsg.bssid"));
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + locala.bssid);
    locala.kog = ((String)paramString.get(".sysmsg.schemamsg.mobilemac"));
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + locala.kog);
    if (m.isEmpty(locala.kog))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
      return null;
    }
    locala.koh = ((String)paramString.get(".sysmsg.schemamsg.mpappid"));
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + locala.koh);
    locala.koi = bk.getLong((String)paramString.get(".sysmsg.schemamsg.mpshopid"), 0L);
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + locala.koi);
    locala.koj = ((String)paramString.get(".sysmsg.schemamsg.schemaurl"));
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + locala.koj);
    if (m.isEmpty(locala.koj))
    {
      y.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
      return null;
    }
    locala.kok = bk.getLong((String)paramString.get(".sysmsg.schemamsg.expiredseconds"), 0L);
    y.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + locala.kok);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.c.a
 * JD-Core Version:    0.7.0.1
 */