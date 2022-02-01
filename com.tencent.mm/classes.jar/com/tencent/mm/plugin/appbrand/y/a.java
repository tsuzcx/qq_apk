package com.tencent.mm.plugin.appbrand.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.b.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final Map<Integer, Object> mza;
  
  static
  {
    AppMethodBeat.i(48006);
    mza = new HashMap();
    AppMethodBeat.o(48006);
  }
  
  public static void CY(int paramInt)
  {
    AppMethodBeat.i(48003);
    if (!mza.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(48003);
      return;
    }
    mza.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(48003);
  }
  
  public static void cIf()
  {
    AppMethodBeat.i(48004);
    mza.clear();
    AppMethodBeat.o(48004);
  }
  
  public static void cIg()
  {
    AppMethodBeat.i(48005);
    com.tencent.mm.plugin.appbrand.jsapi.x.b.sqL = new b.a()
    {
      public final void AV(int paramAnonymousInt)
      {
        AppMethodBeat.i(48002);
        a.CY(paramAnonymousInt);
        AppMethodBeat.o(48002);
      }
    };
    AppMethodBeat.o(48005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.a
 * JD-Core Version:    0.7.0.1
 */