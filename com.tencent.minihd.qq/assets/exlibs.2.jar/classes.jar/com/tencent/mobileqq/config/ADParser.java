package com.tencent.mobileqq.config;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.struct.ADMsg;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.utils.httputils.PkgTools;

public class ADParser
{
  public static final String A = "VOICECALL";
  public static final String B = "AUTOQQMSG";
  public static final String C = "PRELOAD";
  public static final String D = "RESET";
  public static final String E = "";
  public static final String F = "||QQNO||";
  public static final String G = "||MOBILENO||";
  public static final String H = "||LICENCE||";
  public static final String I = "||TIME||";
  public static final String J = "||QQNICK||";
  public static final int a = 8;
  public static final String a = "DESC";
  public static final int b = 0;
  public static final String b = "SUBJECT";
  public static final int c = 1;
  public static final String c = "RESPCONDITION";
  public static final int d = 2;
  public static final String d = "RESPDESC";
  public static final int e = 3;
  public static final String e = "RESPCONTENTTYPES";
  public static final String f = "RESPDEST";
  public static final String g = "RESPCONTENTS";
  public static final String h = "MANUAL";
  public static final String i = "AUTO";
  public static final String j = "SEMIAUTO";
  public static final String k = "1";
  public static final String l = "2";
  public static final String m = "3";
  public static final String n = "4";
  public static final String o = "5";
  public static final String p = "6";
  public static final String q = "7";
  public static final String r = "LOCAL";
  public static final String s = "QQMSG";
  public static final String t = "HTTP";
  public static final String u = "WAP";
  public static final String v = "TMTWAP";
  public static final String w = "WAPI";
  public static final String x = "TMTWAPI";
  public static final String y = "AUTOSMS";
  public static final String z = "USERSMS";
  
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str;
    do
    {
      return -1;
      paramString = c(paramString);
      str = PkgTools.a("RESPCONDITION", paramString);
      if (PkgTools.a("RESPCONTENTTYPES", paramString).equals("PRELOAD")) {
        return 3;
      }
      if (str.equals("MANUAL")) {
        return 0;
      }
      if (str.equals("AUTO")) {
        return 1;
      }
    } while (!str.equals("SEMIAUTO"));
    return 2;
  }
  
  public static ADMsg a(String paramString)
  {
    ADMsg localADMsg = new ADMsg();
    paramString = c(paramString);
    localADMsg.a = PkgTools.c(PkgTools.a("DESC", paramString));
    localADMsg.b = PkgTools.c(PkgTools.a("SUBJECT", paramString));
    localADMsg.c = PkgTools.a("RESPCONDITION", paramString);
    if ((!localADMsg.c.equals("MANUAL")) && (!localADMsg.c.equals("AUTO")) && (!localADMsg.c.equals("SEMIAUTO"))) {
      return null;
    }
    localADMsg.d = PkgTools.a("RESPDESC", paramString);
    localADMsg.e = PkgTools.a("RESPCONTENTTYPES", paramString);
    localADMsg.f = PkgTools.a("RESPDEST", paramString);
    localADMsg.g = PkgTools.a("RESPCONTENTS", paramString);
    localADMsg.d = PkgTools.c(localADMsg.d);
    localADMsg.f = PkgTools.c(localADMsg.f).trim();
    localADMsg.g = PkgTools.c(localADMsg.g);
    return localADMsg;
  }
  
  public static ADMsg a(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ADMsg localADMsg = new ADMsg();
      if (localADMsg != null) {
        localADMsg.a(paramString1, paramString2, paramBoolean);
      }
      return localADMsg;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public static ADMsg a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return paramString;
      if (paramString.c.equals("MANUAL"))
      {
        paramString.a(paramBoolean);
        return paramString;
      }
      if (paramString.c.equals("AUTO"))
      {
        paramString.b();
        return paramString;
      }
    } while (!paramString.c.equals("SEMIAUTO"));
    paramString.b();
    return paramString;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return PkgTools.c(PkgTools.a("DESC", c(paramString)));
  }
  
  public static void a(String paramString, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return;
      paramString = new HttpMsg(paramString.f, null, paramIHttpCommunicatorListener, true);
      paramIHttpCommunicatorListener = Config.a();
    } while (paramIHttpCommunicatorListener == null);
    paramIHttpCommunicatorListener.a(paramString);
  }
  
  public static ADMsg b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {}
    do
    {
      return paramString;
      if (paramString.c.equals("MANUAL"))
      {
        paramString.a(false);
        return paramString;
      }
      if (paramString.c.equals("AUTO"))
      {
        paramString.b();
        return paramString;
      }
    } while (!paramString.c.equals("SEMIAUTO"));
    paramString.b();
    return paramString;
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return PkgTools.a("RESPCONTENTTYPES", paramString);
  }
  
  private static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return PkgTools.a(PkgTools.a(paramString, 0, "||QQNO||", Config.a()), 0, "||LICENCE||", AppSetting.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ADParser
 * JD-Core Version:    0.7.0.1
 */