package com.tencent.matrix;

import com.tencent.b.a.a;
import com.tencent.b.a.a.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.concurrent.TimeUnit;

public final class f
  implements a
{
  private final MultiProcessMMKV cQO = MultiProcessMMKV.getMultiDefault();
  
  public final int D(String paramString, int paramInt)
  {
    int i;
    if (paramString.equals(a.a.Zbt.name()))
    {
      i = this.cQO.getInt(a.a.Zbt.name(), -1);
      if (i != -1) {
        Log.i("MicroMsg.XDynamicConfig", "[get] local! key=%s value=%s", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
    do
    {
      return i;
      paramString = L(paramString, "");
      i = paramInt;
    } while (Util.isNullOrNil(paramString));
    return Util.getInt(paramString, paramInt);
  }
  
  public final String L(String paramString1, String paramString2)
  {
    if ((a.a.ZbY.name().equals(paramString1)) || (a.a.ZbZ.name().equals(paramString1)))
    {
      if (BuildInfo.DEBUG)
      {
        Log.d("MicroMsg.XDynamicConfig", "Matrix.ActivityRefWatcher: clicfg_matrix_resource_detect_interval_millis 30s");
        return String.valueOf(TimeUnit.SECONDS.toMillis(30L));
      }
      if (WeChatEnvironment.hasDebugger())
      {
        Log.d("MicroMsg.XDynamicConfig", "Matrix.ActivityRefWatcher: clicfg_matrix_resource_detect_interval_millis 60s");
        return String.valueOf(TimeUnit.SECONDS.toMillis(60L));
      }
    }
    if (((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())) && (a.a.Zca.name().equals(paramString1)))
    {
      Log.d("MicroMsg.XDynamicConfig", "Matrix.ActivityRefWatcher: clicfg_matrix_resource_max_detect_times 5");
      return "10";
    }
    return d.dgX().a(paramString1, paramString2, false, false);
  }
  
  public final boolean eJ(String paramString)
  {
    paramString = L(paramString, "");
    if (Util.isNullOrNil(paramString)) {}
    while (Util.getInt(paramString, 1) != 0) {
      return true;
    }
    return false;
  }
  
  public final long m(String paramString, long paramLong)
  {
    paramString = L(paramString, "");
    if (Util.isNullOrNil(paramString)) {
      return paramLong;
    }
    return Util.getLong(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.f
 * JD-Core Version:    0.7.0.1
 */