package com.tencent.matrix;

import com.tencent.b.a.a;
import com.tencent.b.a.a.a;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.concurrent.TimeUnit;

public final class g
  implements a
{
  private final MultiProcessMMKV eMf = MultiProcessMMKV.getMultiDefault();
  
  public final int L(String paramString, int paramInt)
  {
    int i;
    if (paramString.equals(a.a.ahaa.name()))
    {
      i = this.eMf.getInt(a.a.ahaa.name(), -1);
      if (i != -1) {
        Log.i("MicroMsg.XDynamicConfig", "[get] local! key=%s value=%s", new Object[] { paramString, Integer.valueOf(i) });
      }
    }
    do
    {
      return i;
      paramString = O(paramString, "");
      i = paramInt;
    } while (Util.isNullOrNil(paramString));
    return Util.getInt(paramString, paramInt);
  }
  
  public final String O(String paramString1, String paramString2)
  {
    if ((a.a.ahaF.name().equals(paramString1)) || (a.a.ahaG.name().equals(paramString1)))
    {
      if (BuildInfo.DEBUG)
      {
        Log.d("MicroMsg.XDynamicConfig", "Matrix.ActivityRefWatcher: clicfg_matrix_resource_detect_interval_millis 30s");
        return String.valueOf(TimeUnit.SECONDS.toMillis(10L));
      }
      if (WeChatEnvironment.hasDebugger())
      {
        Log.d("MicroMsg.XDynamicConfig", "Matrix.ActivityRefWatcher: clicfg_matrix_resource_detect_interval_millis 60s");
        return String.valueOf(TimeUnit.SECONDS.toMillis(10L));
      }
    }
    if (((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())) && (a.a.ahaH.name().equals(paramString1)))
    {
      Log.d("MicroMsg.XDynamicConfig", "Matrix.ActivityRefWatcher: clicfg_matrix_resource_max_detect_times 5");
      return "10";
    }
    return d.dNI().a(paramString1, paramString2, false, false);
  }
  
  public final boolean gi(String paramString)
  {
    paramString = O(paramString, "");
    if (Util.isNullOrNil(paramString)) {}
    while (Util.getInt(paramString, 1) != 0) {
      return true;
    }
    return false;
  }
  
  public final long n(String paramString, long paramLong)
  {
    paramString = O(paramString, "");
    if (Util.isNullOrNil(paramString)) {
      return paramLong;
    }
    return Util.getLong(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.g
 * JD-Core Version:    0.7.0.1
 */