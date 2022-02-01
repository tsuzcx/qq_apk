package com.tencent.mm.plugin.eggspring.ui;

import com.tencent.mm.t.a.n;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isCoupon", "", "Lcom/tencent/mm/eggspring/model/Material;", "isGoods", "isGreeting", "isMoney", "isRedPackage", "plugin-eggspring_release"})
public final class a
{
  public static final boolean a(n paramn)
  {
    if (paramn == null) {}
    while ((paramn.jDT != 2) && (paramn.jDT != 1)) {
      return false;
    }
    return true;
  }
  
  public static final boolean b(n paramn)
  {
    if (paramn == null) {}
    while (paramn.jDT != 6) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.a
 * JD-Core Version:    0.7.0.1
 */