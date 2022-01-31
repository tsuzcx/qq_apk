package com.tencent.mm.av;

import com.tencent.mm.h.a.jx;
import com.tencent.mm.h.a.jx.b;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
{
  public static final void Ps()
  {
    ai.d(new a.3());
  }
  
  public static final void Pt()
  {
    ai.d(new a.4());
  }
  
  public static boolean Pu()
  {
    jx localjx = new jx();
    localjx.bSs.action = -3;
    com.tencent.mm.sdk.b.a.udP.m(localjx);
    return localjx.bSt.bFQ;
  }
  
  public static boolean Pv()
  {
    jx localjx = new jx();
    localjx.bSs.action = 9;
    com.tencent.mm.sdk.b.a.udP.m(localjx);
    return localjx.bSt.bFQ;
  }
  
  public static e Pw()
  {
    jx localjx = new jx();
    localjx.bSs.action = -2;
    com.tencent.mm.sdk.b.a.udP.m(localjx);
    return localjx.bSt.bSu;
  }
  
  public static c Px()
  {
    jx localjx = new jx();
    localjx.bSs.action = 8;
    com.tencent.mm.sdk.b.a.udP.m(localjx);
    return localjx.bSt.bSy;
  }
  
  public static final void a(e parame)
  {
    ai.d(new a.5(parame));
  }
  
  public static void b(e parame)
  {
    ai.d(new a.6(parame));
  }
  
  public static void c(e parame)
  {
    ai.d(new a.8(parame));
  }
  
  public static boolean d(e parame)
  {
    if (parame == null) {
      return false;
    }
    switch (parame.euv)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean iV(int paramInt)
  {
    jx localjx = new jx();
    localjx.bSs.action = 7;
    localjx.bSs.position = paramInt;
    com.tencent.mm.sdk.b.a.udP.m(localjx);
    return localjx.bSt.bFQ;
  }
  
  public static final void yu()
  {
    ai.d(new a.1());
  }
  
  public static final void yv()
  {
    ai.d(new a.2());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.a
 * JD-Core Version:    0.7.0.1
 */