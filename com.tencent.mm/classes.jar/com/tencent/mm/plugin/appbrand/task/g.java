package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public enum g
{
  public int code;
  public int iKV;
  
  static
  {
    AppMethodBeat.i(132847);
    iKS = new g("WASERVICE", 0, 1, 2147483647);
    iKT = new g("WAGAME", 1, 2, 2);
    iKU = new g("NIL", 2, 0, 0);
    iKW = new g[] { iKS, iKT, iKU };
    AppMethodBeat.o(132847);
  }
  
  private g(int paramInt1, int paramInt2)
  {
    this.code = paramInt1;
    this.iKV = paramInt2;
  }
  
  public static g H(Intent paramIntent)
  {
    AppMethodBeat.i(132845);
    int j = paramIntent.getIntExtra("AppBrandServiceType", iKU.code);
    paramIntent = values();
    int k = paramIntent.length;
    int i = 0;
    while (i < k)
    {
      g localg = paramIntent[i];
      if (localg.code == j)
      {
        AppMethodBeat.o(132845);
        return localg;
      }
      i += 1;
    }
    paramIntent = new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
    AppMethodBeat.o(132845);
    throw paramIntent;
  }
  
  public static g c(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(132846);
    if (paramAppBrandInitConfigWC.vY())
    {
      paramAppBrandInitConfigWC = iKT;
      AppMethodBeat.o(132846);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = iKS;
    AppMethodBeat.o(132846);
    return paramAppBrandInitConfigWC;
  }
  
  public static g eM(boolean paramBoolean)
  {
    if (paramBoolean) {
      return iKT;
    }
    return iKS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.g
 * JD-Core Version:    0.7.0.1
 */