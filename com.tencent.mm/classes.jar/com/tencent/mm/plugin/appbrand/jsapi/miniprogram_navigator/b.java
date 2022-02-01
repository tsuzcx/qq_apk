package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public enum b
{
  public final int gXn;
  
  static
  {
    AppMethodBeat.i(147177);
    jYT = new b("RELEASE", 0, 0);
    jYU = new b("DEVELOP", 1, 1);
    jYV = new b("TRIAL", 2, 2);
    jYW = new b[] { jYT, jYU, jYV };
    AppMethodBeat.o(147177);
  }
  
  private b(int paramInt)
  {
    this.gXn = paramInt;
  }
  
  public static b a(String paramString, b paramb)
  {
    AppMethodBeat.i(147175);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147175);
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
        AppMethodBeat.o(147175);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(147175);
    return paramb;
  }
  
  public static b rR(int paramInt)
  {
    AppMethodBeat.i(147176);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      b localb = localObject[i];
      if (localb.gXn == paramInt)
      {
        AppMethodBeat.o(147176);
        return localb;
      }
      i += 1;
    }
    localObject = jYT;
    AppMethodBeat.o(147176);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b
 * JD-Core Version:    0.7.0.1
 */