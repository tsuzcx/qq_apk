package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
{
  private static String TAG = "WeaknetUtils";
  private static String agWb = "weaknet_tag";
  
  public static void Om(boolean paramBoolean)
  {
    AppMethodBeat.i(230976);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("receive weaknet notify ");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Log.d(str, i);
      MultiProcessMMKV.getDefault().putBoolean(agWb, paramBoolean);
      AppMethodBeat.o(230976);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cn.a
 * JD-Core Version:    0.7.0.1
 */