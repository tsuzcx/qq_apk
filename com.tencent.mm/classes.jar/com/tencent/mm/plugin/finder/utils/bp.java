package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils;", "", "()V", "TAG", "", "initSwitchTime", "", "context", "Landroid/content/Context;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "time", "", "ViewPagerScroller", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bp
{
  public static final bp Gmq;
  
  static
  {
    AppMethodBeat.i(333131);
    Gmq = new bp();
    AppMethodBeat.o(333131);
  }
  
  public static void a(Context paramContext, ViewPager paramViewPager, int paramInt)
  {
    AppMethodBeat.i(333119);
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      s.s(localField, "ViewPager::class.java.ge…eclaredField(\"mScroller\")");
      localField.setAccessible(true);
      localField.set(paramViewPager, new a(paramContext, paramInt));
      AppMethodBeat.o(333119);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("ViewPageUtils", (Throwable)paramContext, "", new Object[0]);
      AppMethodBeat.o(333119);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/ViewPageUtils$ViewPagerScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "time", "", "(Landroid/content/Context;I)V", "getTime", "()I", "setTime", "(I)V", "startScroll", "", "startX", "startY", "dx", "dy", "duration", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends Scroller
  {
    private int time;
    
    public a(Context paramContext, int paramInt)
    {
      super();
      this.time = paramInt;
    }
    
    public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(333372);
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.time);
      AppMethodBeat.o(333372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bp
 * JD-Core Version:    0.7.0.1
 */