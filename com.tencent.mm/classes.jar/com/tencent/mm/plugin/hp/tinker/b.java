package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b
{
  private final String JEy;
  private final String JEz;
  
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
    this.JEy = paramString1;
    this.JEz = paramString2;
    AppMethodBeat.o(117456);
  }
  
  private static int aII(String paramString)
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
    finally
    {
      Log.e("MicroMsg.TinkerDeployStatistic", "[-] Fail to parse hex string: %s", new Object[] { localObject });
      AppMethodBeat.o(117459);
    }
  }
  
  private static void aIJ(String paramString)
  {
    AppMethodBeat.i(117462);
    SharedPreferences localSharedPreferences = fPX();
    if (!localSharedPreferences.contains(paramString))
    {
      long l = System.currentTimeMillis();
      localSharedPreferences.edit().putLong(paramString, l).commit();
    }
    AppMethodBeat.o(117462);
  }
  
  public static SharedPreferences fPX()
  {
    AppMethodBeat.i(117458);
    try
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKVWithTransportByName("tinker_deploy_stats_ts");
      AppMethodBeat.o(117458);
      return localMultiProcessMMKV;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.TinkerDeployStatistic", localThrowable, "[-] Fail to init mmkv storage, fallback to system sp.", new Object[0]);
      SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_deploy_stats_ts", 4);
      AppMethodBeat.o(117458);
      return localSharedPreferences;
    }
  }
  
  public static b jF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(117457);
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(117457);
    return paramString1;
  }
  
  public final String YZ(int paramInt)
  {
    AppMethodBeat.i(117460);
    String str = "mmkv_key_" + aII(this.JEy) + "_" + aII(this.JEz) + "_" + paramInt;
    AppMethodBeat.o(117460);
    return str;
  }
  
  public final void aF(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184835);
    String str = String.valueOf(paramInt) + ',' + aII(this.JEy) + ',' + aII(this.JEz) + ',' + paramLong;
    h.OAn.b(17676, str, true, true);
    AppMethodBeat.o(184835);
  }
  
  public final void fPY()
  {
    AppMethodBeat.i(117463);
    aIJ(YZ(1));
    AppMethodBeat.o(117463);
  }
  
  public final void fPZ()
  {
    AppMethodBeat.i(261854);
    aIJ(YZ(2));
    AppMethodBeat.o(261854);
  }
  
  public final void fQa()
  {
    AppMethodBeat.i(261855);
    SharedPreferences localSharedPreferences = fPX();
    String str = YZ(1);
    if (localSharedPreferences.contains(str))
    {
      long l = localSharedPreferences.getLong(str, 0L);
      aF(1, System.currentTimeMillis() - l);
      localSharedPreferences.edit().remove(str).commit();
    }
    AppMethodBeat.o(261855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.b
 * JD-Core Version:    0.7.0.1
 */