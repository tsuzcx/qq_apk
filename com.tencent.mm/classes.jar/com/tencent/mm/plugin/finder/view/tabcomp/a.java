package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.at;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/CenterSelfAlignStrategy;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabLayoutAlignStrategy;", "isAlignByTab", "", "fixMargin", "", "(ZI)V", "align", "", "finderTabLayout", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout;", "alignByTab", "tabLayout", "preIndex", "afterIndex", "alignCenter", "alignView", "Landroid/view/View;", "getAlignTab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTab;", "index", "setStartMargin", "delta", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements o
{
  public static final a.a GIZ;
  private final boolean GJa = true;
  private final int GJb = 0;
  
  static
  {
    AppMethodBeat.i(345551);
    GIZ = new a.a((byte)0);
    AppMethodBeat.o(345551);
  }
  
  private static d a(FinderTabLayout paramFinderTabLayout, int paramInt)
  {
    AppMethodBeat.i(345545);
    paramFinderTabLayout = paramFinderTabLayout.GJt.getChildAt(paramInt);
    if ((paramFinderTabLayout instanceof FinderTabLayout.g))
    {
      paramFinderTabLayout = (FinderTabLayout.g)paramFinderTabLayout;
      if (paramFinderTabLayout != null) {
        break label56;
      }
      paramFinderTabLayout = null;
    }
    for (;;)
    {
      if (!(paramFinderTabLayout instanceof d)) {
        break label78;
      }
      paramFinderTabLayout = (d)paramFinderTabLayout;
      AppMethodBeat.o(345545);
      return paramFinderTabLayout;
      paramFinderTabLayout = null;
      break;
      label56:
      paramFinderTabLayout = paramFinderTabLayout.dyK;
      if (paramFinderTabLayout == null) {
        paramFinderTabLayout = null;
      } else {
        paramFinderTabLayout = paramFinderTabLayout.getTag();
      }
    }
    label78:
    AppMethodBeat.o(345545);
    return null;
  }
  
  private static void b(FinderTabLayout paramFinderTabLayout, int paramInt)
  {
    AppMethodBeat.i(345550);
    Object localObject = paramFinderTabLayout.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      if (localObject != null) {
        break label48;
      }
    }
    for (paramFinderTabLayout = null;; paramFinderTabLayout = ah.aiuX)
    {
      if (paramFinderTabLayout == null) {
        h.hd("tabLayoutParams null!");
      }
      AppMethodBeat.o(345550);
      return;
      localObject = null;
      break;
      label48:
      new StringBuilder("marginStart: ").append(((ViewGroup.MarginLayoutParams)localObject).getMarginStart()).append(" delta:").append(paramInt).append(' ');
      h.jXD();
      ((ViewGroup.MarginLayoutParams)localObject).setMarginStart(((ViewGroup.MarginLayoutParams)localObject).getMarginStart() + paramInt);
      paramFinderTabLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public final void a(FinderTabLayout paramFinderTabLayout)
  {
    Object localObject2 = null;
    AppMethodBeat.i(345673);
    if (paramFinderTabLayout != null)
    {
      int i = paramFinderTabLayout.GJt.getChildCount();
      if ((i >= 2) && (i % 2 == 0) && (this.GJa))
      {
        i /= 2;
        localObject1 = a(paramFinderTabLayout, i - 1);
        Object localObject3 = a(paramFinderTabLayout, i);
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject3 != null) {
            break label175;
          }
        }
        for (;;)
        {
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject3 = new int[2];
            localObject3[0] = 0;
            localObject3[1] = 0;
            ((View)localObject1).getLocationOnScreen((int[])localObject3);
            int[] arrayOfInt = new int[2];
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((View)localObject2).getLocationOnScreen(arrayOfInt);
            i = (localObject3[0] + ((View)localObject1).getWidth() + arrayOfInt[0]) / 2;
            localObject1 = at.GiI;
            b(paramFinderTabLayout, at.getScreenWidth() / 2 - i);
          }
          AppMethodBeat.o(345673);
          return;
          localObject1 = ((d)localObject1).fmq();
          break;
          label175:
          localObject2 = ((d)localObject3).fmp();
        }
      }
      Object localObject1 = (View)paramFinderTabLayout;
      i = this.GJb;
      localObject2 = at.GiI;
      int j = at.getScreenWidth();
      localObject2 = new int[2];
      localObject2[0] = 0;
      localObject2[1] = 0;
      ((View)localObject1).getLocationOnScreen((int[])localObject2);
      int k = localObject2[0];
      int m = ((View)localObject1).getWidth() / 2;
      b(paramFinderTabLayout, j / 2 - (m + k) + i);
    }
    AppMethodBeat.o(345673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.a
 * JD-Core Version:    0.7.0.1
 */