package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  public static void asQ(String paramString)
  {
    AppMethodBeat.i(122157);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122157);
      return;
    }
    String str = dMd();
    if ((str == null) || (str.isEmpty()))
    {
      asR(System.currentTimeMillis() + "@" + paramString);
      AppMethodBeat.o(122157);
      return;
    }
    if ("-1".equals(str))
    {
      Log.e("HABBYGE-MALI.HellSessionReportCache", "storeFlow not login");
      AppMethodBeat.o(122157);
      return;
    }
    if (str.split("@").length <= 1) {}
    for (paramString = str + "@" + paramString;; paramString = str + "|" + paramString)
    {
      asR(paramString);
      AppMethodBeat.o(122157);
      return;
    }
  }
  
  public static void asR(String paramString)
  {
    AppMethodBeat.i(122158);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122158);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenubARptChe_".concat(String.valueOf(i)), str);
      AppMethodBeat.o(122158);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", paramString, "writeBackOfSessionUBA.writeBackOfFlow", new Object[0]);
      AppMethodBeat.o(122158);
    }
  }
  
  public static void asS(String paramString)
  {
    AppMethodBeat.i(122163);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122163);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellsess_dtail_RptChe_".concat(String.valueOf(i)), str);
      AppMethodBeat.o(122163);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", paramString, "HellSessionReportCache.writeBackOfFlow", new Object[0]);
      AppMethodBeat.o(122163);
    }
  }
  
  public static void asT(String paramString)
  {
    AppMethodBeat.i(122165);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122165);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellsess_merge_RptChe_".concat(String.valueOf(i)), str);
      AppMethodBeat.o(122165);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", paramString, "HellSessionReportCache.writeBackOfFlow", new Object[0]);
      AppMethodBeat.o(122165);
    }
  }
  
  public static String dMd()
  {
    AppMethodBeat.i(122159);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122159);
      return "-1";
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenubARptChe_".concat(String.valueOf(i)));
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(122159);
      return null;
    }
    AppMethodBeat.o(122159);
    return str;
  }
  
  public static String dMe()
  {
    AppMethodBeat.i(122162);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    Object localObject;
    if (i == 0) {
      localObject = "-1";
    }
    for (;;)
    {
      localObject = d.asP((String)localObject);
      AppMethodBeat.o(122162);
      return localObject;
      String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenPageMegRptChe_".concat(String.valueOf(i)));
      if (str != null)
      {
        localObject = str;
        if (!str.isEmpty()) {}
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public static String dMf()
  {
    AppMethodBeat.i(122164);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122164);
      return "-1";
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellsess_dtail_RptChe_".concat(String.valueOf(i)));
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(122164);
      return null;
    }
    AppMethodBeat.o(122164);
    return str;
  }
  
  public static String dMg()
  {
    AppMethodBeat.i(122166);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(122166);
      return "-1";
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellsess_merge_RptChe_".concat(String.valueOf(i)));
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(122166);
      return null;
    }
    AppMethodBeat.o(122166);
    return str;
  }
  
  public static void mi(long paramLong)
  {
    AppMethodBeat.i(184376);
    String str2 = String.valueOf(paramLong);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i != 0)
    {
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenPageMegRptChe_".concat(String.valueOf(i)), str1);
        AppMethodBeat.o(184376);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportCache", localException, "HellSessionReportCache.writeBackOfMerge", new Object[0]);
      }
    }
    AppMethodBeat.o(184376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.g
 * JD-Core Version:    0.7.0.1
 */