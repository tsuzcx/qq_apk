package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
{
  private static volatile com.tencent.mm.z.c.d hpd;
  private static volatile com.tencent.mm.z.c.d hpe;
  
  private static com.tencent.mm.z.c.d azQ()
  {
    AppMethodBeat.i(10866);
    if (hpd == null) {}
    try
    {
      if (hpd == null)
      {
        locald = new com.tencent.mm.z.c.d();
        locald.a(new l(312));
        locald.a(new d(306));
        locald.a(new e(306));
        locald.a(new b(305));
        locald.a(new c(307));
        locald.a(new k(309));
        locald.a(new j(310));
        locald.a(new f(311));
        locald.a(new o());
        hpd = locald;
      }
      com.tencent.mm.z.c.d locald = hpd;
      AppMethodBeat.o(10866);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(10866);
    }
  }
  
  private static com.tencent.mm.z.c.d azR()
  {
    AppMethodBeat.i(10867);
    if (hpe == null) {}
    try
    {
      if (hpe == null)
      {
        locald = new com.tencent.mm.z.c.d();
        locald.a(new l(289));
        locald.a(new d(266));
        locald.a(new e(266));
        locald.a(new b(265));
        locald.a(new c(267));
        locald.a(new k(281));
        locald.a(new j(282));
        locald.a(new f(287));
        locald.a(new h());
        locald.a(new i());
        locald.a(new n());
        locald.a(new m());
        locald.a(new o());
        locald.a(new h());
        locald.a(new g());
        locald.a(new a());
        hpe = locald;
      }
      com.tencent.mm.z.c.d locald = hpe;
      AppMethodBeat.o(10867);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(10867);
    }
  }
  
  public static com.tencent.mm.z.c.d nG(int paramInt)
  {
    AppMethodBeat.i(10865);
    if (paramInt == 1)
    {
      locald = azR();
      AppMethodBeat.o(10865);
      return locald;
    }
    com.tencent.mm.z.c.d locald = azQ();
    AppMethodBeat.o(10865);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.p
 * JD-Core Version:    0.7.0.1
 */