package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Object> gxT;
  
  static
  {
    AppMethodBeat.i(48006);
    gxT = new HashMap();
    AppMethodBeat.o(48006);
  }
  
  public static void bwX()
  {
    AppMethodBeat.i(48004);
    gxT.clear();
    AppMethodBeat.o(48004);
  }
  
  public static void bwY()
  {
    AppMethodBeat.i(48005);
    com.tencent.mm.plugin.appbrand.jsapi.r.b.leC = new b.a()
    {
      public final void tm(int paramAnonymousInt)
      {
        AppMethodBeat.i(48002);
        a.vf(paramAnonymousInt);
        AppMethodBeat.o(48002);
      }
    };
    AppMethodBeat.o(48005);
  }
  
  public static void vf(int paramInt)
  {
    AppMethodBeat.i(48003);
    if (!gxT.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(48003);
      return;
    }
    gxT.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(48003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a
 * JD-Core Version:    0.7.0.1
 */