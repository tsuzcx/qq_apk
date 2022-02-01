package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.lang.reflect.Field;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils;", "", "()V", "TAG", "", "initSwitchTime", "", "context", "Landroid/content/Context;", "viewPager", "Landroid/support/v4/view/ViewPager;", "time", "", "ViewPagerScroller", "plugin-finder_release"})
public final class s
{
  public static final s sYo;
  
  static
  {
    AppMethodBeat.i(205208);
    sYo = new s();
    AppMethodBeat.o(205208);
  }
  
  public static void a(Context paramContext, ViewPager paramViewPager, int paramInt)
  {
    AppMethodBeat.i(205207);
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      p.g(localField, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
      localField.setAccessible(true);
      localField.set(paramViewPager, new a(paramContext, paramInt));
      AppMethodBeat.o(205207);
      return;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("ViewPageUtils", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(205207);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils$ViewPagerScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "time", "", "(Landroid/content/Context;I)V", "getTime", "()I", "setTime", "(I)V", "startScroll", "", "startX", "startY", "dx", "dy", "duration", "plugin-finder_release"})
  public static final class a
    extends Scroller
  {
    private int heF;
    
    public a(Context paramContext, int paramInt)
    {
      super();
      this.heF = paramInt;
    }
    
    public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(205206);
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.heF);
      AppMethodBeat.o(205206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.s
 * JD-Core Version:    0.7.0.1
 */