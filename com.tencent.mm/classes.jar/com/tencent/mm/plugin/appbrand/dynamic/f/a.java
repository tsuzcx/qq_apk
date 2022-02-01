package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.ac.c.g rmN;
  private static volatile com.tencent.mm.ac.c.g rmO;
  
  private static com.tencent.mm.ac.c.g cnQ()
  {
    AppMethodBeat.i(121390);
    if (rmN == null) {}
    try
    {
      if (rmN == null)
      {
        localg = new com.tencent.mm.ac.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        rmN = localg;
      }
      com.tencent.mm.ac.c.g localg = rmN;
      AppMethodBeat.o(121390);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121390);
    }
  }
  
  private static com.tencent.mm.ac.c.g cnR()
  {
    AppMethodBeat.i(121391);
    if (rmO == null) {}
    try
    {
      if (rmO == null)
      {
        localg = new com.tencent.mm.ac.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        rmO = localg;
      }
      com.tencent.mm.ac.c.g localg = rmO;
      AppMethodBeat.o(121391);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121391);
    }
  }
  
  public static com.tencent.mm.ac.c.g zS(int paramInt)
  {
    AppMethodBeat.i(121389);
    if (paramInt == 1)
    {
      localg = cnR();
      AppMethodBeat.o(121389);
      return localg;
    }
    com.tencent.mm.ac.c.g localg = cnQ();
    AppMethodBeat.o(121389);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */