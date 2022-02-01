package com.tencent.mm.plugin.finder.live.view.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansConfig;", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpanConfig;", "", "spanMode", "sizeMode", "(II)V", "getBgColor", "userLevel", "getBgDrawableId", "getBgHeight", "getIconResourceId", "getIconSize", "", "getLevelTextSize", "getRightIconResourceId", "getRightIconSize", "getTextBold", "params", "getTextColor", "getTextSize", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements l<Integer>
{
  final int CId;
  private final int DWg;
  
  public b(int paramInt1, int paramInt2)
  {
    this.DWg = paramInt1;
    this.CId = paramInt2;
  }
  
  public static int PJ(int paramInt)
  {
    int k = 1;
    int j = 0;
    int i;
    if (paramInt > 0) {
      if (paramInt <= 6) {
        i = 1;
      }
    }
    while (i != 0)
    {
      i = p.d.BzY;
      return i;
      i = 0;
      continue;
      i = 0;
    }
    if (7 <= paramInt) {
      if (paramInt <= 12) {
        i = 1;
      }
    }
    while (i != 0)
    {
      return p.d.BzZ;
      i = 0;
      continue;
      i = 0;
    }
    if (13 <= paramInt) {
      if (paramInt <= 17) {
        i = 1;
      }
    }
    while (i != 0)
    {
      return p.d.BAa;
      i = 0;
      continue;
      i = 0;
    }
    if (18 <= paramInt) {
      if (paramInt <= 2147483647) {
        paramInt = k;
      }
    }
    for (;;)
    {
      i = j;
      if (paramInt == 0) {
        break;
      }
      return p.d.BAa;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  public static int PK(int paramInt)
  {
    int k = 1;
    int j = 0;
    int i;
    if (13 <= paramInt) {
      if (paramInt <= 17) {
        i = 1;
      }
    }
    while (i != 0)
    {
      i = p.d.BAb;
      return i;
      i = 0;
      continue;
      i = 0;
    }
    if (18 <= paramInt) {
      if (paramInt <= 2147483647) {
        paramInt = k;
      }
    }
    for (;;)
    {
      i = j;
      if (paramInt == 0) {
        break;
      }
      return p.d.BAb;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  public static int ewk()
  {
    AppMethodBeat.i(358441);
    int i = Color.parseColor("#FFFFFF");
    AppMethodBeat.o(358441);
    return i;
  }
  
  public final int ewj()
  {
    AppMethodBeat.i(358463);
    if (this.DWg == 0)
    {
      i = MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3);
      AppMethodBeat.o(358463);
      return i;
    }
    int i = MMApplicationContext.getContext().getResources().getColor(p.b.BW_0_Alpha_0_1_5);
    AppMethodBeat.o(358463);
    return i;
  }
  
  public final int ewl()
  {
    AppMethodBeat.i(358471);
    switch (this.CId)
    {
    default: 
      localh = h.DWP;
      i = h.ewE();
      AppMethodBeat.o(358471);
      return i;
    case 1: 
      localh = h.DWP;
      i = h.ewG();
      AppMethodBeat.o(358471);
      return i;
    }
    h localh = h.DWP;
    int i = h.ewB();
    AppMethodBeat.o(358471);
    return i;
  }
  
  public final int[] ewm()
  {
    AppMethodBeat.i(358484);
    h localh = h.DWP;
    int i = h.ewJ();
    localh = h.DWP;
    int j = h.ewK();
    localh = h.DWP;
    int k = h.ewG();
    switch (this.CId)
    {
    case 1: 
    default: 
      AppMethodBeat.o(358484);
      return new int[] { j, j };
    case 0: 
      AppMethodBeat.o(358484);
      return new int[] { i, i };
    }
    AppMethodBeat.o(358484);
    return new int[] { k, k };
  }
  
  public final int ewn()
  {
    AppMethodBeat.i(358493);
    switch (this.CId)
    {
    default: 
      localh = h.DWP;
      i = h.ewI();
      AppMethodBeat.o(358493);
      return i;
    case 1: 
      i = d.e(MMApplicationContext.getContext(), 24.0F);
      AppMethodBeat.o(358493);
      return i;
    }
    h localh = h.DWP;
    int i = h.ewE();
    AppMethodBeat.o(358493);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.b
 * JD-Core Version:    0.7.0.1
 */