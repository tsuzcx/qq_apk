package com.tencent.mm.ai.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class a
{
  public String appId;
  public String dki;
  public String hDZ;
  public String hEa;
  public String iconUrl;
  public String msgId;
  public String nickname;
  public int op;
  public String title;
  public int type;
  public String username;
  public int version;
  
  public static a yy(String paramString)
  {
    AppMethodBeat.i(213212);
    paramString = bw.M(paramString, "sysmsg");
    a locala = new a();
    if (paramString == null)
    {
      ad.i("AppBrandNotifyMsgContent", "values map is null.");
      AppMethodBeat.o(213212);
      return locala;
    }
    locala.title = ((String)paramString.get(".sysmsg.weapp_pushmsg.title"));
    locala.nickname = ((String)paramString.get(".sysmsg.weapp_pushmsg.wxa_nickname"));
    locala.op = bt.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.op"), 0);
    locala.msgId = ((String)paramString.get(".sysmsg.weapp_pushmsg.busi_msgid"));
    locala.username = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.username"));
    locala.appId = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appid"));
    locala.type = bt.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.type"), 0);
    locala.version = bt.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.version"), 0);
    locala.iconUrl = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.weappiconurl"));
    locala.dki = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath"));
    locala.hDZ = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appservicetype"));
    locala.hEa = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pkginfo.type"));
    AppMethodBeat.o(213212);
    return locala;
  }
  
  public static String yz(String paramString)
  {
    AppMethodBeat.i(213213);
    paramString = bt.nullAsNil(paramString).replaceAll("[_a-zA-Z0-9]", "*");
    AppMethodBeat.o(213213);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a.a
 * JD-Core Version:    0.7.0.1
 */