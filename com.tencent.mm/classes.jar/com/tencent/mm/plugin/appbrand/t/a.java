package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Object> gAA;
  
  static
  {
    AppMethodBeat.i(48006);
    gAA = new HashMap();
    AppMethodBeat.o(48006);
  }
  
  public static void bxQ()
  {
    AppMethodBeat.i(48004);
    gAA.clear();
    AppMethodBeat.o(48004);
  }
  
  public static void bxR()
  {
    AppMethodBeat.i(48005);
    com.tencent.mm.plugin.appbrand.jsapi.r.b.lin = new b.a()
    {
      public final void tp(int paramAnonymousInt)
      {
        AppMethodBeat.i(48002);
        a.vk(paramAnonymousInt);
        AppMethodBeat.o(48002);
      }
    };
    AppMethodBeat.o(48005);
  }
  
  public static void vk(int paramInt)
  {
    AppMethodBeat.i(48003);
    if (!gAA.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(48003);
      return;
    }
    gAA.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(48003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a
 * JD-Core Version:    0.7.0.1
 */