package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUIToolHelper;", "", "()V", "getScreenHeight", "", "getScreenWidth", "getTenDpUnreadCount", "context", "Landroid/content/Context;", "count", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
{
  public static final at GiI;
  
  static
  {
    AppMethodBeat.i(332981);
    GiI = new at();
    AppMethodBeat.o(332981);
  }
  
  public static int aE(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(332974);
    s.u(paramContext, "context");
    if (Float.compare(a.getScaleSize(paramContext), a.mf(paramContext)) > 0)
    {
      if (paramInt < 10)
      {
        paramInt = e.d.ten_large_unread_dot_count_bg;
        AppMethodBeat.o(332974);
        return paramInt;
      }
      paramInt = e.d.ten_unread_large_shape;
      AppMethodBeat.o(332974);
      return paramInt;
    }
    if (paramInt < 10)
    {
      paramInt = e.d.ten_small_unread_dot_count_bg;
      AppMethodBeat.o(332974);
      return paramInt;
    }
    paramInt = e.d.ten_unread_count_shape;
    AppMethodBeat.o(332974);
    return paramInt;
  }
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(332969);
    Object localObject = bf.bf(MMApplicationContext.getContext());
    int i = ((Point)localObject).x;
    int j = ((Point)localObject).y;
    localObject = av.GiL;
    if (av.fgj())
    {
      AppMethodBeat.o(332969);
      return j;
    }
    i = k.qu(j, i);
    AppMethodBeat.o(332969);
    return i;
  }
  
  public static int getScreenWidth()
  {
    AppMethodBeat.i(332961);
    Object localObject = bf.bf(MMApplicationContext.getContext());
    int i = ((Point)localObject).x;
    int j = ((Point)localObject).y;
    localObject = av.GiL;
    if (av.fgj())
    {
      AppMethodBeat.o(332961);
      return i;
    }
    i = k.qv(i, j);
    AppMethodBeat.o(332961);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.at
 * JD-Core Version:    0.7.0.1
 */