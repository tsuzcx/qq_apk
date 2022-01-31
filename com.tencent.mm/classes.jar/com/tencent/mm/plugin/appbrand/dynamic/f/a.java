package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.z.c.g hpU;
  private static volatile com.tencent.mm.z.c.g hpV;
  
  private static com.tencent.mm.z.c.g azV()
  {
    AppMethodBeat.i(10909);
    if (hpU == null) {}
    try
    {
      if (hpU == null)
      {
        localg = new com.tencent.mm.z.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        hpU = localg;
      }
      com.tencent.mm.z.c.g localg = hpU;
      AppMethodBeat.o(10909);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(10909);
    }
  }
  
  private static com.tencent.mm.z.c.g azW()
  {
    AppMethodBeat.i(10910);
    if (hpV == null) {}
    try
    {
      if (hpV == null)
      {
        localg = new com.tencent.mm.z.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        hpV = localg;
      }
      com.tencent.mm.z.c.g localg = hpV;
      AppMethodBeat.o(10910);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(10910);
    }
  }
  
  public static com.tencent.mm.z.c.g nH(int paramInt)
  {
    AppMethodBeat.i(10908);
    if (paramInt == 1)
    {
      localg = azW();
      AppMethodBeat.o(10908);
      return localg;
    }
    com.tencent.mm.z.c.g localg = azV();
    AppMethodBeat.o(10908);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */