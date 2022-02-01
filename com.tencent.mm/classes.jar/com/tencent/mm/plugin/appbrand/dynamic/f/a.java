package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.aa.c.g loB;
  private static volatile com.tencent.mm.aa.c.g loC;
  
  private static com.tencent.mm.aa.c.g bCf()
  {
    AppMethodBeat.i(121390);
    if (loB == null) {}
    try
    {
      if (loB == null)
      {
        localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        loB = localg;
      }
      com.tencent.mm.aa.c.g localg = loB;
      AppMethodBeat.o(121390);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121390);
    }
  }
  
  private static com.tencent.mm.aa.c.g bCg()
  {
    AppMethodBeat.i(121391);
    if (loC == null) {}
    try
    {
      if (loC == null)
      {
        localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        loC = localg;
      }
      com.tencent.mm.aa.c.g localg = loC;
      AppMethodBeat.o(121391);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121391);
    }
  }
  
  public static com.tencent.mm.aa.c.g wp(int paramInt)
  {
    AppMethodBeat.i(121389);
    if (paramInt == 1)
    {
      localg = bCg();
      AppMethodBeat.o(121389);
      return localg;
    }
    com.tencent.mm.aa.c.g localg = bCf();
    AppMethodBeat.o(121389);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */