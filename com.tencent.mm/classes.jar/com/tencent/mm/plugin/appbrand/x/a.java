package com.tencent.mm.plugin.appbrand.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Object> hno;
  
  static
  {
    AppMethodBeat.i(48006);
    hno = new HashMap();
    AppMethodBeat.o(48006);
  }
  
  public static void bUc()
  {
    AppMethodBeat.i(48004);
    hno.clear();
    AppMethodBeat.o(48004);
  }
  
  public static void bUd()
  {
    AppMethodBeat.i(48005);
    com.tencent.mm.plugin.appbrand.jsapi.t.b.mnM = new b.a()
    {
      public final void xl(int paramAnonymousInt)
      {
        AppMethodBeat.i(48002);
        a.zc(paramAnonymousInt);
        AppMethodBeat.o(48002);
      }
    };
    AppMethodBeat.o(48005);
  }
  
  public static void zc(int paramInt)
  {
    AppMethodBeat.i(48003);
    if (!hno.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(48003);
      return;
    }
    hno.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(48003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.a
 * JD-Core Version:    0.7.0.1
 */