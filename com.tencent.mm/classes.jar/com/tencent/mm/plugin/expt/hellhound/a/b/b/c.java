package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public static void MH(String paramString)
  {
    AppMethodBeat.i(152377);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(152377);
      return;
    }
    String str = bsp();
    if ((str == null) || (str.isEmpty()))
    {
      MI(System.currentTimeMillis() + "@" + paramString);
      AppMethodBeat.o(152377);
      return;
    }
    if ("-1".equals(str))
    {
      ab.e("HellSessionReportCache", "habbyge-mali, storeFlow not login");
      AppMethodBeat.o(152377);
      return;
    }
    if (str.split("@").length <= 1) {}
    for (paramString = str + "@" + paramString;; paramString = str + "|" + paramString)
    {
      MI(paramString);
      AppMethodBeat.o(152377);
      return;
    }
  }
  
  public static void MI(String paramString)
  {
    AppMethodBeat.i(152380);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(152380);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenubARptChe_".concat(String.valueOf(i)), str);
      AppMethodBeat.o(152380);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("HellSessionReportCache", paramString, "habbyge-mali, writeBackOfSessionUBA.writeBackOfFlow", new Object[0]);
      AppMethodBeat.o(152380);
    }
  }
  
  public static void MJ(String paramString)
  {
    AppMethodBeat.i(152382);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(152382);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenFlRptChe_".concat(String.valueOf(i)), str);
      AppMethodBeat.o(152382);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("HellSessionReportCache", paramString, "habbyge-mali, HellSessionReportCache.writeBackOfFlow", new Object[0]);
      AppMethodBeat.o(152382);
    }
  }
  
  public static void MK(String paramString)
  {
    AppMethodBeat.i(152384);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(152384);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.putString("mmkv_key_hellSenMegRptChe_".concat(String.valueOf(i)), str);
      AppMethodBeat.o(152384);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("HellSessionReportCache", paramString, "habbyge-mali, HellSessionReportCache.writeBackOfMerge", new Object[0]);
      AppMethodBeat.o(152384);
    }
  }
  
  public static long bso()
  {
    AppMethodBeat.i(152378);
    String str = bsp();
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(152378);
      return 0L;
    }
    if ("-1".equals(str))
    {
      AppMethodBeat.o(152378);
      return -1L;
    }
    long l = Long.valueOf(str.split("@")[0]).longValue();
    AppMethodBeat.o(152378);
    return l;
  }
  
  private static String bsp()
  {
    AppMethodBeat.i(152379);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(152379);
      return "-1";
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenubARptChe_".concat(String.valueOf(i)));
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(152379);
      return null;
    }
    AppMethodBeat.o(152379);
    return str;
  }
  
  public static String bsq()
  {
    AppMethodBeat.i(152381);
    Object localObject = bsp();
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      AppMethodBeat.o(152381);
      return null;
    }
    if ("-1".equals(localObject))
    {
      AppMethodBeat.o(152381);
      return "-1";
    }
    localObject = ((String)localObject).split("@");
    ab.i("HellSessionReportCache", "habbyge-mali, getJsonsOfFlow, args = " + localObject[0]);
    if (localObject.length <= 1)
    {
      AppMethodBeat.o(152381);
      return null;
    }
    localObject = localObject[1];
    AppMethodBeat.o(152381);
    return localObject;
  }
  
  public static String bsr()
  {
    AppMethodBeat.i(152383);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(152383);
      return "-1";
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenFlRptChe_".concat(String.valueOf(i)));
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(152383);
      return null;
    }
    AppMethodBeat.o(152383);
    return str;
  }
  
  public static String bss()
  {
    AppMethodBeat.i(152385);
    int i = com.tencent.mm.plugin.expt.hellhound.core.b.getUin();
    if (i == 0)
    {
      AppMethodBeat.o(152385);
      return "-1";
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.a.b.getString("mmkv_key_hellSenMegRptChe_".concat(String.valueOf(i)));
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(152385);
      return null;
    }
    AppMethodBeat.o(152385);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */