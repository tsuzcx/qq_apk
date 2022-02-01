package com.tencent.mm.plugin.appbrand.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Object> fZD;
  
  static
  {
    AppMethodBeat.i(48006);
    fZD = new HashMap();
    AppMethodBeat.o(48006);
  }
  
  public static void blX()
  {
    AppMethodBeat.i(48004);
    fZD.clear();
    AppMethodBeat.o(48004);
  }
  
  public static void blY()
  {
    AppMethodBeat.i(48005);
    com.tencent.mm.plugin.appbrand.jsapi.p.b.khr = new b.a()
    {
      public final void rT(int paramAnonymousInt)
      {
        AppMethodBeat.i(48002);
        a.tJ(paramAnonymousInt);
        AppMethodBeat.o(48002);
      }
    };
    AppMethodBeat.o(48005);
  }
  
  public static void tJ(int paramInt)
  {
    AppMethodBeat.i(48003);
    if (!fZD.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(48003);
      return;
    }
    fZD.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(48003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a
 * JD-Core Version:    0.7.0.1
 */