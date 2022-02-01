package com.tencent.mm.plugin.finder.nearby.live.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.nearby.live.square.page.b;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/base/FinderLiveUtils;", "", "()V", "canLoadNearbyCityFeeds", "", "invokeSource", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "commentScene", "", "getGridDividerWidth", "", "isVisibleRectLessThanXPercent", "orientation", "view", "Landroid/view/View;", "percent", "isVisibleRectMoreThanXPercent", "parseEnterTypeFromContextId", "contextId", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EJF;
  
  static
  {
    AppMethodBeat.i(340714);
    EJF = new a();
    AppMethodBeat.o(340714);
  }
  
  public static boolean a(String paramString, bnn parambnn, int paramInt)
  {
    AppMethodBeat.i(340677);
    s.u(paramString, "invokeSource");
    Object localObject = v.GgU;
    if (v.eot())
    {
      AppMethodBeat.o(340677);
      return true;
    }
    if (paramInt != -1)
    {
      localObject = b.ELW;
      if (b.QN(paramInt))
      {
        AppMethodBeat.o(340677);
        return true;
      }
    }
    if ((parambnn != null) && (parambnn.ZVZ == 88889)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      Log.w(paramString, "canLoadNearbyCityFeeds FINDER_LIVE_SQUARE_TAB_NEARBY_CITY");
      AppMethodBeat.o(340677);
      return false;
    }
    AppMethodBeat.o(340677);
    return true;
  }
  
  public static String ayZ(String paramString)
  {
    AppMethodBeat.i(340695);
    s.u(paramString, "contextId");
    paramString = (String)n.a((CharSequence)paramString, new String[] { "-" }).get(0);
    AppMethodBeat.o(340695);
    return paramString;
  }
  
  public static float eEP()
  {
    AppMethodBeat.i(340690);
    float f = MMApplicationContext.getContext().getResources().getDimensionPixelSize(f.b.Edge_1_5_A);
    AppMethodBeat.o(340690);
    return f;
  }
  
  public static boolean gx(View paramView)
  {
    AppMethodBeat.i(340709);
    s.u(paramView, "view");
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    int i = localRect.width();
    int j = paramView.getWidth();
    if (i * 1.0F / j >= 0.5F)
    {
      AppMethodBeat.o(340709);
      return true;
    }
    AppMethodBeat.o(340709);
    return false;
  }
  
  public static boolean l(int paramInt, View paramView)
  {
    AppMethodBeat.i(340703);
    s.u(paramView, "view");
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    int i;
    if (paramInt == 0)
    {
      i = localRect.width();
      if (paramInt != 0) {
        break label71;
      }
    }
    label71:
    for (paramInt = paramView.getWidth();; paramInt = paramView.getHeight())
    {
      if (i * 1.0F / paramInt >= 0.5F) {
        break label79;
      }
      AppMethodBeat.o(340703);
      return true;
      i = localRect.height();
      break;
    }
    label79:
    AppMethodBeat.o(340703);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.base.a
 * JD-Core Version:    0.7.0.1
 */