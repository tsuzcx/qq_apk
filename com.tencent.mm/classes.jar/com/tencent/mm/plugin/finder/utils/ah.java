package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderUIToolHelper;", "", "()V", "getScreenHeight", "", "getScreenWidth", "getTenDpUnreadCount", "context", "Landroid/content/Context;", "count", "plugin-finder_release"})
public final class ah
{
  public static final ah AFI;
  
  static
  {
    AppMethodBeat.i(263277);
    AFI = new ah();
    AppMethodBeat.o(263277);
  }
  
  public static int aq(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(263273);
    p.k(paramContext, "context");
    if (Float.compare(a.ez(paramContext), a.kd(paramContext)) > 0)
    {
      if (paramInt < 10)
      {
        paramInt = b.e.ten_large_unread_dot_count_bg;
        AppMethodBeat.o(263273);
        return paramInt;
      }
      paramInt = b.e.ten_unread_large_shape;
      AppMethodBeat.o(263273);
      return paramInt;
    }
    if (paramInt < 10)
    {
      paramInt = b.e.ten_small_unread_dot_count_bg;
      AppMethodBeat.o(263273);
      return paramInt;
    }
    paramInt = b.e.ten_unread_count_shape;
    AppMethodBeat.o(263273);
    return paramInt;
  }
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(263269);
    Object localObject = ax.au(MMApplicationContext.getContext());
    int i = ((Point)localObject).x;
    int j = ((Point)localObject).y;
    localObject = aj.AGc;
    if (aj.eeq())
    {
      AppMethodBeat.o(263269);
      return j;
    }
    i = i.ov(j, i);
    AppMethodBeat.o(263269);
    return i;
  }
  
  public static int getScreenWidth()
  {
    AppMethodBeat.i(263267);
    Object localObject = ax.au(MMApplicationContext.getContext());
    int i = ((Point)localObject).x;
    int j = ((Point)localObject).y;
    localObject = aj.AGc;
    if (aj.eeq())
    {
      AppMethodBeat.o(263267);
      return i;
    }
    i = i.ow(i, j);
    AppMethodBeat.o(263267);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ah
 * JD-Core Version:    0.7.0.1
 */