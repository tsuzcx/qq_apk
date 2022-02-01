package com.tencent.mm.plugin.hp.tinker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;

public final class b
{
  private final String uUH;
  private final String uUI;
  
  private b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117456);
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new IllegalArgumentException("baseClientVersion is empty.");
      AppMethodBeat.o(117456);
      throw paramString1;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = new IllegalArgumentException("patchClientVersion is empty.");
      AppMethodBeat.o(117456);
      throw paramString1;
    }
    this.uUH = paramString1;
    this.uUI = paramString2;
    AppMethodBeat.o(117456);
  }
  
  private static int aoo(String paramString)
  {
    AppMethodBeat.i(117459);
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
        AppMethodBeat.o(117459);
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
      ae.e("MicroMsg.TinkerDeployStatistic", "[-] Fail to parse hex string: %s", new Object[] { localObject });
      AppMethodBeat.o(117459);
    }
  }
  
  @SuppressLint({"ApplySharedPref"})
  private static void aop(String paramString)
  {
    AppMethodBeat.i(117462);
    SharedPreferences localSharedPreferences = dfn();
    if (!localSharedPreferences.contains(paramString))
    {
      long l = System.currentTimeMillis();
      localSharedPreferences.edit().putLong(paramString, l).commit();
    }
    AppMethodBeat.o(117462);
  }
  
  public static SharedPreferences dfn()
  {
    AppMethodBeat.i(117458);
    try
    {
      ay localay = ay.aRY("tinker_deploy_stats_ts");
      AppMethodBeat.o(117458);
      return localay;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.TinkerDeployStatistic", localThrowable, "[-] Fail to init mmkv storage, fallback to system sp.", new Object[0]);
      SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("tinker_deploy_stats_ts", 4);
      AppMethodBeat.o(117458);
      return localSharedPreferences;
    }
  }
  
  public static b hA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117457);
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(117457);
    return paramString1;
  }
  
  public final String IT(int paramInt)
  {
    AppMethodBeat.i(117460);
    String str = "mmkv_key_" + aoo(this.uUH) + "_" + aoo(this.uUI) + "_" + paramInt;
    AppMethodBeat.o(117460);
    return str;
  }
  
  public final void ak(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184835);
    String str = String.valueOf(paramInt) + ',' + aoo(this.uUH) + ',' + aoo(this.uUI) + ',' + paramLong;
    g.yxI.a(17676, str, true, true);
    AppMethodBeat.o(184835);
  }
  
  public final void dfo()
  {
    AppMethodBeat.i(117463);
    aop(IT(1));
    AppMethodBeat.o(117463);
  }
  
  public final void dfp()
  {
    AppMethodBeat.i(196785);
    aop(IT(2));
    AppMethodBeat.o(196785);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void dfq()
  {
    AppMethodBeat.i(196786);
    SharedPreferences localSharedPreferences = dfn();
    String str = IT(1);
    if (localSharedPreferences.contains(str))
    {
      long l = localSharedPreferences.getLong(str, 0L);
      ak(1, System.currentTimeMillis() - l);
      localSharedPreferences.edit().remove(str).commit();
    }
    AppMethodBeat.o(196786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.b
 * JD-Core Version:    0.7.0.1
 */