package com.tencent.mm.plugin.hp.tinker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;

public final class b
{
  private final String uIU;
  private final String uIV;
  
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
    this.uIU = paramString1;
    this.uIV = paramString2;
    AppMethodBeat.o(117456);
  }
  
  private static int anm(String paramString)
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
      ad.e("MicroMsg.TinkerDeployStatistic", "[-] Fail to parse hex string: %s", new Object[] { localObject });
      AppMethodBeat.o(117459);
    }
  }
  
  @SuppressLint({"ApplySharedPref"})
  private static void ann(String paramString)
  {
    AppMethodBeat.i(117462);
    SharedPreferences localSharedPreferences = dcv();
    if (!localSharedPreferences.contains(paramString))
    {
      long l = System.currentTimeMillis();
      localSharedPreferences.edit().putLong(paramString, l).commit();
    }
    AppMethodBeat.o(117462);
  }
  
  public static SharedPreferences dcv()
  {
    AppMethodBeat.i(117458);
    try
    {
      ax localax = ax.aQB("tinker_deploy_stats_ts");
      AppMethodBeat.o(117458);
      return localax;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.TinkerDeployStatistic", localThrowable, "[-] Fail to init mmkv storage, fallback to system sp.", new Object[0]);
      SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("tinker_deploy_stats_ts", 4);
      AppMethodBeat.o(117458);
      return localSharedPreferences;
    }
  }
  
  public static b ht(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117457);
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(117457);
    return paramString1;
  }
  
  public final String Iv(int paramInt)
  {
    AppMethodBeat.i(117460);
    String str = "mmkv_key_" + anm(this.uIU) + "_" + anm(this.uIV) + "_" + paramInt;
    AppMethodBeat.o(117460);
    return str;
  }
  
  public final void ak(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184835);
    String str = String.valueOf(paramInt) + ',' + anm(this.uIU) + ',' + anm(this.uIV) + ',' + paramLong;
    g.yhR.a(17676, str, true, true);
    AppMethodBeat.o(184835);
  }
  
  public final void dcw()
  {
    AppMethodBeat.i(117463);
    ann(Iv(1));
    AppMethodBeat.o(117463);
  }
  
  public final void dcx()
  {
    AppMethodBeat.i(218918);
    ann(Iv(2));
    AppMethodBeat.o(218918);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void dcy()
  {
    AppMethodBeat.i(218919);
    SharedPreferences localSharedPreferences = dcv();
    String str = Iv(1);
    if (localSharedPreferences.contains(str))
    {
      long l = localSharedPreferences.getLong(str, 0L);
      ak(1, System.currentTimeMillis() - l);
      localSharedPreferences.edit().remove(str).commit();
    }
    AppMethodBeat.o(218919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.b
 * JD-Core Version:    0.7.0.1
 */