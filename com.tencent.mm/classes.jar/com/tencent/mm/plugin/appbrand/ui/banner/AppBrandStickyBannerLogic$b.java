package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class AppBrandStickyBannerLogic$b
{
  static final Set<f> dup = new HashSet();
  
  static void apr()
  {
    AppBrandStickyBannerLogic.access$200();
  }
  
  public static boolean apw()
  {
    AppBrandStickyBannerLogic.access$200();
    return false;
  }
  
  private static void apx()
  {
    ??? = BannerModel.apz();
    String str1;
    if (??? == null)
    {
      str1 = null;
      if (??? != null) {
        break label72;
      }
    }
    label72:
    for (int i = -1;; i = ((BannerModel)???).fJy)
    {
      synchronized (dup)
      {
        Iterator localIterator = dup.iterator();
        if (!localIterator.hasNext()) {
          break label80;
        }
        ((f)localIterator.next()).aP(str1, i);
      }
      String str2 = ((BannerModel)???).appId;
      break;
    }
    label80:
  }
  
  public static void apy()
  {
    AppBrandStickyBannerLogic.access$200();
  }
  
  static void b(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
  {
    if (b.a(paramOperateTask)) {
      apx();
    }
  }
  
  public static void c(f paramf)
  {
    if (paramf != null) {
      synchronized (dup)
      {
        dup.remove(paramf);
        return;
      }
    }
  }
  
  public static void d(f paramf)
  {
    if (paramf != null) {
      synchronized (dup)
      {
        dup.add(paramf);
        return;
      }
    }
  }
  
  public static void u(Intent paramIntent)
  {
    if ((paramIntent == null) || (!g.DK())) {
      return;
    }
    g.DS().O(new Runnable()
    {
      public final void run()
      {
        if (b.t(this.val$intent)) {
          AppBrandStickyBannerLogic.b.access$100();
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b
 * JD-Core Version:    0.7.0.1
 */