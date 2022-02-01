package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.lang.reflect.Field;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils;", "", "()V", "TAG", "", "initSwitchTime", "", "context", "Landroid/content/Context;", "viewPager", "Landroid/support/v4/view/ViewPager;", "time", "", "ViewPagerScroller", "plugin-finder_release"})
public final class s
{
  public static final s sNd;
  
  static
  {
    AppMethodBeat.i(204584);
    sNd = new s();
    AppMethodBeat.o(204584);
  }
  
  public static void a(Context paramContext, ViewPager paramViewPager, int paramInt)
  {
    AppMethodBeat.i(204583);
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      p.g(localField, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
      localField.setAccessible(true);
      localField.set(paramViewPager, new a(paramContext, paramInt));
      AppMethodBeat.o(204583);
      return;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("ViewPageUtils", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(204583);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils$ViewPagerScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "time", "", "(Landroid/content/Context;I)V", "getTime", "()I", "setTime", "(I)V", "startScroll", "", "startX", "startY", "dx", "dy", "duration", "plugin-finder_release"})
  public static final class a
    extends Scroller
  {
    private int hbR;
    
    public a(Context paramContext, int paramInt)
    {
      super();
      this.hbR = paramInt;
    }
    
    public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(204582);
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.hbR);
      AppMethodBeat.o(204582);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.s
 * JD-Core Version:    0.7.0.1
 */