package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Object> gej;
  
  static
  {
    AppMethodBeat.i(48006);
    gej = new HashMap();
    AppMethodBeat.o(48006);
  }
  
  public static void bsT()
  {
    AppMethodBeat.i(48004);
    gej.clear();
    AppMethodBeat.o(48004);
  }
  
  public static void bsU()
  {
    AppMethodBeat.i(48005);
    com.tencent.mm.plugin.appbrand.jsapi.o.b.kIj = new b.a()
    {
      public final void sJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(48002);
        a.uB(paramAnonymousInt);
        AppMethodBeat.o(48002);
      }
    };
    AppMethodBeat.o(48005);
  }
  
  public static void uB(int paramInt)
  {
    AppMethodBeat.i(48003);
    if (!gej.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(48003);
      return;
    }
    gej.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(48003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a
 * JD-Core Version:    0.7.0.1
 */