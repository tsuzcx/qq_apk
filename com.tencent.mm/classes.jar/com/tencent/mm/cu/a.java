package com.tencent.mm.cu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
{
  private static String TAG = "WeaknetUtils";
  private static String YXW = "weaknet_tag";
  
  public static void Il(boolean paramBoolean)
  {
    AppMethodBeat.i(209317);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("receive weaknet notify ");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Log.d(str, i);
      MultiProcessMMKV.getDefault().putBoolean(YXW, paramBoolean);
      AppMethodBeat.o(209317);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cu.a
 * JD-Core Version:    0.7.0.1
 */