package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandStickyBannerLogic$b
{
  static final Set<f> bLQ;
  
  static
  {
    AppMethodBeat.i(133298);
    bLQ = new HashSet();
    AppMethodBeat.o(133298);
  }
  
  public static void M(Intent paramIntent)
  {
    AppMethodBeat.i(133289);
    if ((paramIntent == null) || (!g.RG()))
    {
      AppMethodBeat.o(133289);
      return;
    }
    g.RO().ac(new AppBrandStickyBannerLogic.b.1(paramIntent));
    AppMethodBeat.o(133289);
  }
  
  static void aMH()
  {
    AppMethodBeat.i(133291);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(133291);
  }
  
  public static boolean aMM()
  {
    AppMethodBeat.i(133295);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(133295);
    return false;
  }
  
  private static void aMN()
  {
    AppMethodBeat.i(133292);
    ??? = BannerModel.aMP();
    String str1;
    if (??? == null)
    {
      str1 = null;
      if (??? != null) {
        break label82;
      }
    }
    label82:
    for (int i = -1;; i = ((BannerModel)???).hcr)
    {
      synchronized (bLQ)
      {
        Iterator localIterator = bLQ.iterator();
        if (!localIterator.hasNext()) {
          break label90;
        }
        ((f)localIterator.next()).bf(str1, i);
      }
      String str2 = ((BannerModel)???).appId;
      break;
    }
    label90:
    AppMethodBeat.o(133292);
  }
  
  public static void aMO()
  {
    AppMethodBeat.i(133296);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(133296);
  }
  
  static void b(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
  {
    AppMethodBeat.i(133290);
    if (b.a(paramOperateTask)) {
      aMN();
    }
    AppMethodBeat.o(133290);
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(133294);
    if (paramf != null) {
      synchronized (bLQ)
      {
        bLQ.remove(paramf);
        AppMethodBeat.o(133294);
        return;
      }
    }
    AppMethodBeat.o(133294);
  }
  
  public static void d(f paramf)
  {
    AppMethodBeat.i(133293);
    if (paramf != null) {
      synchronized (bLQ)
      {
        bLQ.add(paramf);
        AppMethodBeat.o(133293);
        return;
      }
    }
    AppMethodBeat.o(133293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b
 * JD-Core Version:    0.7.0.1
 */