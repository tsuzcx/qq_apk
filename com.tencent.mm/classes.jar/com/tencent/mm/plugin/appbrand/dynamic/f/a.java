package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.ab.c.g khA;
  private static volatile com.tencent.mm.ab.c.g khB;
  
  private static com.tencent.mm.ab.c.g bge()
  {
    AppMethodBeat.i(121390);
    if (khA == null) {}
    try
    {
      if (khA == null)
      {
        localg = new com.tencent.mm.ab.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        khA = localg;
      }
      com.tencent.mm.ab.c.g localg = khA;
      AppMethodBeat.o(121390);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121390);
    }
  }
  
  private static com.tencent.mm.ab.c.g bgf()
  {
    AppMethodBeat.i(121391);
    if (khB == null) {}
    try
    {
      if (khB == null)
      {
        localg = new com.tencent.mm.ab.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        khB = localg;
      }
      com.tencent.mm.ab.c.g localg = khB;
      AppMethodBeat.o(121391);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121391);
    }
  }
  
  public static com.tencent.mm.ab.c.g sq(int paramInt)
  {
    AppMethodBeat.i(121389);
    if (paramInt == 1)
    {
      localg = bgf();
      AppMethodBeat.o(121389);
      return localg;
    }
    com.tencent.mm.ab.c.g localg = bge();
    AppMethodBeat.o(121389);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */