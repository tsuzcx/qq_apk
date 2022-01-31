package com.tencent.mm.plugin.appbrand.dynamic.f;

public class a
{
  private static volatile com.tencent.mm.aa.c.g fWt;
  private static volatile com.tencent.mm.aa.c.g fWu;
  
  private static com.tencent.mm.aa.c.g afq()
  {
    if (fWt == null) {}
    try
    {
      if (fWt == null)
      {
        com.tencent.mm.aa.c.g localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(302));
        localg.a(new c(303));
        localg.a(new d(308));
        localg.a(new f());
        localg.a(new g());
        fWt = localg;
      }
      return fWt;
    }
    finally {}
  }
  
  private static com.tencent.mm.aa.c.g afr()
  {
    if (fWu == null) {}
    try
    {
      if (fWu == null)
      {
        com.tencent.mm.aa.c.g localg = new com.tencent.mm.aa.c.g();
        localg.a(new b(262));
        localg.a(new c(263));
        localg.a(new d(268));
        localg.a(new f());
        localg.a(new g());
        localg.a(new e((byte)0));
        fWu = localg;
      }
      return fWu;
    }
    finally {}
  }
  
  public static com.tencent.mm.aa.c.g kJ(int paramInt)
  {
    if (paramInt == 1) {
      return afr();
    }
    return afq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.a
 * JD-Core Version:    0.7.0.1
 */