package com.tencent.mm.plugin.appbrand.appusage;

import a.d.b.g;
import com.tencent.mm.protocal.c.bvi;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.sdk.platformtools.d;

public final class z$a
{
  private static bvj a(int paramInt, bvi parambvi1, bvi parambvi2, bvi parambvi3)
  {
    bvj localbvj = new bvj();
    localbvj.tMc = parambvi1;
    localbvj.tMf = paramInt;
    localbvj.tMd = parambvi2;
    localbvj.tMe = parambvi3;
    return localbvj;
  }
  
  public static bvj a(bvi parambvi1, bvi parambvi2, bvi parambvi3)
  {
    g.k(parambvi1, "self");
    return a(1, parambvi1, parambvi2, parambvi3);
  }
  
  static boolean adx()
  {
    return d.IS_FLAVOR_RED;
  }
  
  public static bvj b(bvi parambvi)
  {
    g.k(parambvi, "self");
    return a(2, parambvi, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z.a
 * JD-Core Version:    0.7.0.1
 */