package com.tencent.mm.plugin.appbrand.u;

import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class l
{
  public static <T extends a> boolean a(T paramT1, T paramT2)
  {
    if ((paramT1 == null) && (paramT2 == null)) {
      throw new IllegalArgumentException("both null!!!");
    }
    if (paramT1 == null) {}
    while (paramT2 == null) {
      return false;
    }
    try
    {
      boolean bool = bk.isEqual(paramT1.toByteArray(), paramT2.toByteArray());
      return bool;
    }
    catch (Exception paramT1) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.l
 * JD-Core Version:    0.7.0.1
 */