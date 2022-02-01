package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a
{
  public String appId;
  public String dCx;
  public String iBb;
  public String iBc;
  public String iconUrl;
  public String msgId;
  public String nickname;
  public int op;
  public String title;
  public int type;
  public String username;
  public int version;
  
  public static a HK(String paramString)
  {
    AppMethodBeat.i(187115);
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    a locala = new a();
    if (paramString == null)
    {
      Log.i("AppBrandNotifyMsgContent", "values map is null.");
      AppMethodBeat.o(187115);
      return locala;
    }
    locala.title = ((String)paramString.get(".sysmsg.weapp_pushmsg.title"));
    locala.nickname = ((String)paramString.get(".sysmsg.weapp_pushmsg.wxa_nickname"));
    locala.op = Util.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.op"), 0);
    locala.msgId = ((String)paramString.get(".sysmsg.weapp_pushmsg.busi_msgid"));
    locala.username = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.username"));
    locala.appId = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appid"));
    locala.type = Util.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.type"), 0);
    locala.version = Util.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.version"), 0);
    locala.iconUrl = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.weappiconurl"));
    locala.dCx = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath"));
    locala.iBb = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appservicetype"));
    locala.iBc = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pkginfo.type"));
    AppMethodBeat.o(187115);
    return locala;
  }
  
  public static String HL(String paramString)
  {
    AppMethodBeat.i(187116);
    paramString = Util.nullAsNil(paramString).replaceAll("[_a-zA-Z0-9]", "*");
    AppMethodBeat.o(187116);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.a.a
 * JD-Core Version:    0.7.0.1
 */