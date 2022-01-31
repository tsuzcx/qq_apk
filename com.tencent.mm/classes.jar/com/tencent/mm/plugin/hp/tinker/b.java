package com.tencent.mm.plugin.hp.tinker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;

public final class b
{
  private final String nKF;
  private final String nKG;
  
  private b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156035);
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new IllegalArgumentException("baseClientVersion is empty.");
      AppMethodBeat.o(156035);
      throw paramString1;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = new IllegalArgumentException("patchClientVersion is empty.");
      AppMethodBeat.o(156035);
      throw paramString1;
    }
    this.nKF = paramString1;
    this.nKG = paramString2;
    AppMethodBeat.o(156035);
  }
  
  private static int QP(String paramString)
  {
    AppMethodBeat.i(156038);
    Object localObject = paramString;
    try
    {
      String str;
      if (paramString.startsWith("0x"))
      {
        localObject = paramString;
        str = paramString.substring(2);
      }
      for (;;)
      {
        localObject = str;
        int i = Integer.parseInt(str, 16);
        AppMethodBeat.o(156038);
        return i;
        localObject = paramString;
        if (!paramString.endsWith("h"))
        {
          str = paramString;
          localObject = paramString;
          if (!paramString.endsWith("H")) {}
        }
        else
        {
          localObject = paramString;
          str = paramString.substring(0, paramString.length() - 1);
        }
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      d.e("MicroMsg.TinkerDeployStatistic", "[-] Fail to parse hex string: %s", new Object[] { localObject });
      AppMethodBeat.o(156038);
    }
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void ahe(String paramString)
  {
    AppMethodBeat.i(156787);
    SharedPreferences localSharedPreferences = bIl();
    if (!localSharedPreferences.contains(paramString))
    {
      long l = System.currentTimeMillis();
      localSharedPreferences.edit().putLong(paramString, l).commit();
    }
    AppMethodBeat.o(156787);
  }
  
  public static SharedPreferences bIl()
  {
    AppMethodBeat.i(156037);
    try
    {
      as localas = as.apr("tinker_deploy_stats_ts");
      AppMethodBeat.o(156037);
      return localas;
    }
    catch (Throwable localThrowable)
    {
      d.printErrStackTrace("MicroMsg.TinkerDeployStatistic", localThrowable, "[-] Fail to init mmkv storage, fallback to system sp.", new Object[0]);
      SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("tinker_deploy_stats_ts", 4);
      AppMethodBeat.o(156037);
      return localSharedPreferences;
    }
  }
  
  public static b eP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156036);
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(156036);
    return paramString1;
  }
  
  public final void T(int paramInt, long paramLong)
  {
    AppMethodBeat.i(156040);
    String str = String.valueOf(paramInt) + ',' + QP(this.nKF) + ',' + QP(this.nKG) + ',' + paramLong;
    h.qsU.a(17676, str, true, true);
    AppMethodBeat.o(156040);
  }
  
  public final void dbX()
  {
    AppMethodBeat.i(156788);
    ahe(xC(1));
    AppMethodBeat.o(156788);
  }
  
  public final String xC(int paramInt)
  {
    AppMethodBeat.i(156039);
    String str = "mmkv_key_" + QP(this.nKF) + "_" + QP(this.nKG) + "_" + paramInt;
    AppMethodBeat.o(156039);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.b
 * JD-Core Version:    0.7.0.1
 */