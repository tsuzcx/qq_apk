package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandDesktopDragView$1
  implements c.a
{
  AppBrandDesktopDragView$1(AppBrandDesktopDragView paramAppBrandDesktopDragView) {}
  
  public final Object aZ(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof AppBrandDesktopView.a))
    {
      paramObject = (AppBrandDesktopView.a)paramObject;
      localObject = new AppBrandDesktopView.a(1);
      ((AppBrandDesktopView.a)localObject).hqw = paramObject.hqw;
    }
    return localObject;
  }
  
  public final void arl()
  {
    y.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
    AppBrandDesktopDragView.a(this.hpQ, true);
  }
  
  public final void arm()
  {
    y.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
    AppBrandDesktopDragView.a(this.hpQ, false);
  }
  
  public final boolean k(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    if ((paramObject2 == null) || (paramObject1 == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (((paramObject2 instanceof AppBrandDesktopView.a)) && ((paramObject1 instanceof AppBrandDesktopView.a)))
      {
        paramObject2 = (AppBrandDesktopView.a)paramObject2;
        paramObject1 = (AppBrandDesktopView.a)paramObject1;
        if ((paramObject2.hqw == null) || (paramObject1.hqw == null) || (bk.bl(paramObject2.hqw.username)) || (bk.bl(paramObject1.hqw.username)) || (!paramObject1.hqw.e(paramObject2.hqw))) {
          break label103;
        }
      }
      label103:
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.1
 * JD-Core Version:    0.7.0.1
 */