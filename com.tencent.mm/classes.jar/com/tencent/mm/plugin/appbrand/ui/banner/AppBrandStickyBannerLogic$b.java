package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandStickyBannerLogic$b
{
  static final Set<f> cAT;
  
  static
  {
    AppMethodBeat.i(49017);
    cAT = new HashSet();
    AppMethodBeat.o(49017);
  }
  
  public static void S(Intent paramIntent)
  {
    AppMethodBeat.i(49008);
    if ((paramIntent == null) || (!g.ajx()))
    {
      AppMethodBeat.o(49008);
      return;
    }
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49007);
        if (b.R(this.val$intent)) {
          AppBrandStickyBannerLogic.b.access$100();
        }
        AppMethodBeat.o(49007);
      }
    });
    AppMethodBeat.o(49008);
  }
  
  static void b(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
  {
    AppMethodBeat.i(49009);
    if (b.a(paramOperateTask)) {
      bAd();
    }
    AppMethodBeat.o(49009);
  }
  
  public static boolean bAc()
  {
    AppMethodBeat.i(49014);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(49014);
    return false;
  }
  
  private static void bAd()
  {
    AppMethodBeat.i(49011);
    ??? = BannerModel.bAf();
    String str1;
    if (??? == null)
    {
      str1 = null;
      if (??? != null) {
        break label82;
      }
    }
    label82:
    for (int i = -1;; i = ((BannerModel)???).hQh)
    {
      synchronized (cAT)
      {
        Iterator localIterator = cAT.iterator();
        if (!localIterator.hasNext()) {
          break label90;
        }
        ((f)localIterator.next()).bB(str1, i);
      }
      String str2 = ((BannerModel)???).appId;
      break;
    }
    label90:
    AppMethodBeat.o(49011);
  }
  
  public static void bAe()
  {
    AppMethodBeat.i(49015);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(49015);
  }
  
  static void bzX()
  {
    AppMethodBeat.i(49010);
    AppBrandStickyBannerLogic.access$200();
    AppMethodBeat.o(49010);
  }
  
  public static void c(f paramf)
  {
    AppMethodBeat.i(49013);
    if (paramf != null) {
      synchronized (cAT)
      {
        cAT.remove(paramf);
        AppMethodBeat.o(49013);
        return;
      }
    }
    AppMethodBeat.o(49013);
  }
  
  public static void d(f paramf)
  {
    AppMethodBeat.i(49012);
    if (paramf != null) {
      synchronized (cAT)
      {
        cAT.add(paramf);
        AppMethodBeat.o(49012);
        return;
      }
    }
    AppMethodBeat.o(49012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b
 * JD-Core Version:    0.7.0.1
 */