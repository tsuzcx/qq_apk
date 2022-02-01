package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.aa.c.g jNp;
  private static volatile com.tencent.mm.aa.c.g jNq;
  
  private static com.tencent.mm.aa.c.g bcA()
  {
    AppMethodBeat.i(121390);
    if (jNp == null) {}
    try
    {
      if (jNp == null)
      {
        localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        jNp = localg;
      }
      com.tencent.mm.aa.c.g localg = jNp;
      AppMethodBeat.o(121390);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121390);
    }
  }
  
  private static com.tencent.mm.aa.c.g bcB()
  {
    AppMethodBeat.i(121391);
    if (jNq == null) {}
    try
    {
      if (jNq == null)
      {
        localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        jNq = localg;
      }
      com.tencent.mm.aa.c.g localg = jNq;
      AppMethodBeat.o(121391);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121391);
    }
  }
  
  public static com.tencent.mm.aa.c.g rO(int paramInt)
  {
    AppMethodBeat.i(121389);
    if (paramInt == 1)
    {
      localg = bcB();
      AppMethodBeat.o(121389);
      return localg;
    }
    com.tencent.mm.aa.c.g localg = bcA();
    AppMethodBeat.o(121389);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */