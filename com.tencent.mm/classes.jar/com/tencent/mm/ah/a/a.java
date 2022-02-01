package com.tencent.mm.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class a
{
  public String appId;
  public String dlk;
  public String hGR;
  public String hGS;
  public String iconUrl;
  public String msgId;
  public String nickname;
  public int op;
  public String title;
  public int type;
  public String username;
  public int version;
  
  public static a zi(String paramString)
  {
    AppMethodBeat.i(199567);
    paramString = bx.M(paramString, "sysmsg");
    a locala = new a();
    if (paramString == null)
    {
      ae.i("AppBrandNotifyMsgContent", "values map is null.");
      AppMethodBeat.o(199567);
      return locala;
    }
    locala.title = ((String)paramString.get(".sysmsg.weapp_pushmsg.title"));
    locala.nickname = ((String)paramString.get(".sysmsg.weapp_pushmsg.wxa_nickname"));
    locala.op = bu.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.op"), 0);
    locala.msgId = ((String)paramString.get(".sysmsg.weapp_pushmsg.busi_msgid"));
    locala.username = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.username"));
    locala.appId = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appid"));
    locala.type = bu.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.type"), 0);
    locala.version = bu.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.version"), 0);
    locala.iconUrl = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.weappiconurl"));
    locala.dlk = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath"));
    locala.hGR = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appservicetype"));
    locala.hGS = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pkginfo.type"));
    AppMethodBeat.o(199567);
    return locala;
  }
  
  public static String zj(String paramString)
  {
    AppMethodBeat.i(199568);
    paramString = bu.nullAsNil(paramString).replaceAll("[_a-zA-Z0-9]", "*");
    AppMethodBeat.o(199568);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.a.a
 * JD-Core Version:    0.7.0.1
 */