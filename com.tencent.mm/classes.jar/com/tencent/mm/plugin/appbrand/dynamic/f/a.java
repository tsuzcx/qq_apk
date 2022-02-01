package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.ac.c.g ojl;
  private static volatile com.tencent.mm.ac.c.g ojm;
  
  private static com.tencent.mm.ac.c.g bNB()
  {
    AppMethodBeat.i(121390);
    if (ojl == null) {}
    try
    {
      if (ojl == null)
      {
        localg = new com.tencent.mm.ac.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        ojl = localg;
      }
      com.tencent.mm.ac.c.g localg = ojl;
      AppMethodBeat.o(121390);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121390);
    }
  }
  
  private static com.tencent.mm.ac.c.g bNC()
  {
    AppMethodBeat.i(121391);
    if (ojm == null) {}
    try
    {
      if (ojm == null)
      {
        localg = new com.tencent.mm.ac.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        ojm = localg;
      }
      com.tencent.mm.ac.c.g localg = ojm;
      AppMethodBeat.o(121391);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121391);
    }
  }
  
  public static com.tencent.mm.ac.c.g zC(int paramInt)
  {
    AppMethodBeat.i(121389);
    if (paramInt == 1)
    {
      localg = bNC();
      AppMethodBeat.o(121389);
      return localg;
    }
    com.tencent.mm.ac.c.g localg = bNB();
    AppMethodBeat.o(121389);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */