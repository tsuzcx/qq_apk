package com.tencent.mm.ah.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class a
{
  public String appId;
  public String cYQ;
  public String dtG;
  public String hlM;
  public String hlN;
  public String iconUrl;
  public String nickname;
  public int op;
  public String title;
  public int type;
  public String username;
  public int version;
  
  public static a vH(String paramString)
  {
    AppMethodBeat.i(208997);
    paramString = bv.L(paramString, "sysmsg");
    a locala = new a();
    if (paramString == null)
    {
      ac.i("AppBrandNotifyMsgContent", "values map is null.");
      AppMethodBeat.o(208997);
      return locala;
    }
    locala.title = ((String)paramString.get(".sysmsg.weapp_pushmsg.title"));
    locala.nickname = ((String)paramString.get(".sysmsg.weapp_pushmsg.wxa_nickname"));
    locala.op = bs.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.op"), 0);
    locala.dtG = ((String)paramString.get(".sysmsg.weapp_pushmsg.busi_msgid"));
    locala.username = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.username"));
    locala.appId = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appid"));
    locala.type = bs.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.type"), 0);
    locala.version = bs.getInt((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.version"), 0);
    locala.iconUrl = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.weappiconurl"));
    locala.cYQ = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath"));
    locala.hlM = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.appservicetype"));
    locala.hlN = ((String)paramString.get(".sysmsg.weapp_pushmsg.weappinfo.pkginfo.type"));
    AppMethodBeat.o(208997);
    return locala;
  }
  
  public static String vI(String paramString)
  {
    AppMethodBeat.i(208998);
    paramString = bs.nullAsNil(paramString).replaceAll("[_a-zA-Z0-9]", "*");
    AppMethodBeat.o(208998);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.a.a
 * JD-Core Version:    0.7.0.1
 */