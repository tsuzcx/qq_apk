package com.tencent.mm.plugin.appbrand.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Object> jZc;
  
  static
  {
    AppMethodBeat.i(48006);
    jZc = new HashMap();
    AppMethodBeat.o(48006);
  }
  
  public static void CH(int paramInt)
  {
    AppMethodBeat.i(48003);
    if (!jZc.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(48003);
      return;
    }
    jZc.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(48003);
  }
  
  public static void chi()
  {
    AppMethodBeat.i(48004);
    jZc.clear();
    AppMethodBeat.o(48004);
  }
  
  public static void chj()
  {
    AppMethodBeat.i(48005);
    com.tencent.mm.plugin.appbrand.jsapi.u.b.plS = new b.a()
    {
      public final void AH(int paramAnonymousInt)
      {
        AppMethodBeat.i(48002);
        a.CH(paramAnonymousInt);
        AppMethodBeat.o(48002);
      }
    };
    AppMethodBeat.o(48005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.a
 * JD-Core Version:    0.7.0.1
 */