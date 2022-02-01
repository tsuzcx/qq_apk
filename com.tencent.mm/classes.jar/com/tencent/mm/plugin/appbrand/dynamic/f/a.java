package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static volatile com.tencent.mm.ab.c.g jnc;
  private static volatile com.tencent.mm.ab.c.g jnd;
  
  private static com.tencent.mm.ab.c.g aVC()
  {
    AppMethodBeat.i(121390);
    if (jnc == null) {}
    try
    {
      if (jnc == null)
      {
        localg = new com.tencent.mm.ab.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        jnc = localg;
      }
      com.tencent.mm.ab.c.g localg = jnc;
      AppMethodBeat.o(121390);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121390);
    }
  }
  
  private static com.tencent.mm.ab.c.g aVD()
  {
    AppMethodBeat.i(121391);
    if (jnd == null) {}
    try
    {
      if (jnd == null)
      {
        localg = new com.tencent.mm.ab.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        jnd = localg;
      }
      com.tencent.mm.ab.c.g localg = jnd;
      AppMethodBeat.o(121391);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(121391);
    }
  }
  
  public static com.tencent.mm.ab.c.g rb(int paramInt)
  {
    AppMethodBeat.i(121389);
    if (paramInt == 1)
    {
      localg = aVD();
      AppMethodBeat.o(121389);
      return localg;
    }
    com.tencent.mm.ab.c.g localg = aVC();
    AppMethodBeat.o(121389);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */