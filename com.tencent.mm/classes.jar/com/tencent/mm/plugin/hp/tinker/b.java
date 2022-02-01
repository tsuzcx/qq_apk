package com.tencent.mm.plugin.hp.tinker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;

public final class b
{
  private final String tGi;
  private final String tGj;
  
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
    this.tGi = paramString1;
    this.tGj = paramString2;
    AppMethodBeat.o(117456);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void aiA(String paramString)
  {
    AppMethodBeat.i(117462);
    SharedPreferences localSharedPreferences = cTn();
    if (!localSharedPreferences.contains(paramString))
    {
      long l = System.currentTimeMillis();
      localSharedPreferences.edit().putLong(paramString, l).commit();
    }
    AppMethodBeat.o(117462);
  }
  
  private static int aiz(String paramString)
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
      ac.e("MicroMsg.TinkerDeployStatistic", "[-] Fail to parse hex string: %s", new Object[] { localObject });
      AppMethodBeat.o(117459);
    }
  }
  
  public static SharedPreferences cTn()
  {
    AppMethodBeat.i(117458);
    try
    {
      aw localaw = aw.aKV("tinker_deploy_stats_ts");
      AppMethodBeat.o(117458);
      return localaw;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.TinkerDeployStatistic", localThrowable, "[-] Fail to init mmkv storage, fallback to system sp.", new Object[0]);
      SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("tinker_deploy_stats_ts", 4);
      AppMethodBeat.o(117458);
      return localSharedPreferences;
    }
  }
  
  public static b hh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117457);
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(117457);
    return paramString1;
  }
  
  public final String GZ(int paramInt)
  {
    AppMethodBeat.i(117460);
    String str = "mmkv_key_" + aiz(this.tGi) + "_" + aiz(this.tGj) + "_" + paramInt;
    AppMethodBeat.o(117460);
    return str;
  }
  
  public final void ag(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184835);
    String str = String.valueOf(paramInt) + ',' + aiz(this.tGi) + ',' + aiz(this.tGj) + ',' + paramLong;
    h.wUl.a(17676, str, true, true);
    AppMethodBeat.o(184835);
  }
  
  public final void cTo()
  {
    AppMethodBeat.i(117463);
    aiA(GZ(1));
    AppMethodBeat.o(117463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.b
 * JD-Core Version:    0.7.0.1
 */