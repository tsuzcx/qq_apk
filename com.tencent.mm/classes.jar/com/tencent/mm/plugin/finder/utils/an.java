package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils;", "", "()V", "TAG", "", "initSwitchTime", "", "context", "Landroid/content/Context;", "viewPager", "Landroid/support/v4/view/ViewPager;", "time", "", "ViewPagerScroller", "plugin-finder_release"})
public final class an
{
  public static final an waE;
  
  static
  {
    AppMethodBeat.i(253824);
    waE = new an();
    AppMethodBeat.o(253824);
  }
  
  public static void a(Context paramContext, ViewPager paramViewPager, int paramInt)
  {
    AppMethodBeat.i(253823);
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      p.g(localField, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
      localField.setAccessible(true);
      localField.set(paramViewPager, new a(paramContext, paramInt));
      AppMethodBeat.o(253823);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("ViewPageUtils", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(253823);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils$ViewPagerScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "time", "", "(Landroid/content/Context;I)V", "getTime", "()I", "setTime", "(I)V", "startScroll", "", "startX", "startY", "dx", "dy", "duration", "plugin-finder_release"})
  public static final class a
    extends Scroller
  {
    private int hXs;
    
    public a(Context paramContext, int paramInt)
    {
      super();
      this.hXs = paramInt;
    }
    
    public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(253822);
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.hXs);
      AppMethodBeat.o(253822);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.an
 * JD-Core Version:    0.7.0.1
 */