package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.aa.c.g kkQ;
  private static volatile com.tencent.mm.aa.c.g kkR;
  
  private static com.tencent.mm.aa.c.g bgM()
  {
    AppMethodBeat.i(121390);
    if (kkQ == null) {}
    try
    {
      if (kkQ == null)
      {
        localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        kkQ = localg;
      }
      com.tencent.mm.aa.c.g localg = kkQ;
      AppMethodBeat.o(121390);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121390);
    }
  }
  
  private static com.tencent.mm.aa.c.g bgN()
  {
    AppMethodBeat.i(121391);
    if (kkR == null) {}
    try
    {
      if (kkR == null)
      {
        localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        kkR = localg;
      }
      com.tencent.mm.aa.c.g localg = kkR;
      AppMethodBeat.o(121391);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121391);
    }
  }
  
  public static com.tencent.mm.aa.c.g st(int paramInt)
  {
    AppMethodBeat.i(121389);
    if (paramInt == 1)
    {
      localg = bgN();
      AppMethodBeat.o(121389);
      return localg;
    }
    com.tencent.mm.aa.c.g localg = bgM();
    AppMethodBeat.o(121389);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */