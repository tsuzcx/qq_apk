package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public enum b
{
  public final int iOo;
  
  static
  {
    AppMethodBeat.i(147177);
    meL = new b("RELEASE", 0, 0);
    meM = new b("DEVELOP", 1, 1);
    meN = new b("TRIAL", 2, 2);
    meO = new b[] { meL, meM, meN };
    AppMethodBeat.o(147177);
  }
  
  private b(int paramInt)
  {
    this.iOo = paramInt;
  }
  
  public static b a(String paramString, b paramb)
  {
    AppMethodBeat.i(147175);
    if (Util.isNullOrNil(paramString))
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
  
  public static b xj(int paramInt)
  {
    AppMethodBeat.i(147176);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      b localb = localObject[i];
      if (localb.iOo == paramInt)
      {
        AppMethodBeat.o(147176);
        return localb;
      }
      i += 1;
    }
    localObject = meL;
    AppMethodBeat.o(147176);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b
 * JD-Core Version:    0.7.0.1
 */