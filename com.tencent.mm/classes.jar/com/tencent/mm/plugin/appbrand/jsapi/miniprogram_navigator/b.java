package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public enum b
{
  public final int hcr;
  
  static
  {
    AppMethodBeat.i(101978);
    hSP = new b("RELEASE", 0, 0);
    hSQ = new b("DEVELOP", 1, 1);
    hSR = new b("TRIAL", 2, 2);
    hSS = new b[] { hSP, hSQ, hSR };
    AppMethodBeat.o(101978);
  }
  
  private b(int paramInt)
  {
    this.hcr = paramInt;
  }
  
  public static b a(String paramString, b paramb)
  {
    AppMethodBeat.i(101976);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101976);
      return paramb;
    }
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.name().toLowerCase().equals(paramString))
      {
        AppMethodBeat.o(101976);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(101976);
    return paramb;
  }
  
  public static b oh(int paramInt)
  {
    AppMethodBeat.i(101977);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      b localb = localObject[i];
      if (localb.hcr == paramInt)
      {
        AppMethodBeat.o(101977);
        return localb;
      }
      i += 1;
    }
    localObject = hSP;
    AppMethodBeat.o(101977);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b
 * JD-Core Version:    0.7.0.1
 */