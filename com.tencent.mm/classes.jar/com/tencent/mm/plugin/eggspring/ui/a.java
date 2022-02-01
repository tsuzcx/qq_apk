package com.tencent.mm.plugin.eggspring.ui;

import com.tencent.mm.r.a.n;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"isCoupon", "", "Lcom/tencent/mm/eggspring/model/Material;", "isGoods", "isGreeting", "isMoney", "isRedPackage", "plugin-eggspring_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final boolean a(n paramn)
  {
    if (paramn == null) {}
    while ((paramn.mdP != 2) && (paramn.mdP != 1)) {
      return false;
    }
    return true;
  }
  
  public static final boolean b(n paramn)
  {
    if (paramn == null) {}
    while (paramn.mdP != 6) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.a
 * JD-Core Version:    0.7.0.1
 */