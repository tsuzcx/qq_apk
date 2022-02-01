package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.at;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/CenterTabAlignStrategy;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/ITabLayoutAlignStrategy;", "alignIndex", "", "(I)V", "align", "", "finderTabLayout", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabLayout;", "alignCenter", "tabLayout", "alignView", "Landroid/view/View;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements o
{
  public static final b.a GJc;
  private final int GJd = 1;
  
  static
  {
    AppMethodBeat.i(345541);
    GJc = new b.a((byte)0);
    AppMethodBeat.o(345541);
  }
  
  public final void a(FinderTabLayout paramFinderTabLayout)
  {
    Object localObject2 = null;
    AppMethodBeat.i(345549);
    Object localObject1;
    label62:
    label77:
    int i;
    if ((paramFinderTabLayout != null) && (paramFinderTabLayout.GJt.getChildCount() > this.GJd))
    {
      localObject1 = paramFinderTabLayout.GJt.getChildAt(this.GJd);
      if (!(localObject1 instanceof FinderTabLayout.g)) {
        break label192;
      }
      localObject1 = (FinderTabLayout.g)localObject1;
      if (localObject1 != null) {
        break label198;
      }
      localObject1 = null;
      if (!(localObject1 instanceof d)) {
        break label226;
      }
      localObject1 = (d)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((d)localObject1).fmr();
        if (localObject1 != null)
        {
          Object localObject3 = at.GiI;
          i = at.getScreenWidth();
          localObject3 = new int[2];
          localObject3[0] = 0;
          localObject3[1] = 0;
          ((View)localObject1).getLocationOnScreen((int[])localObject3);
          int j = localObject3[0];
          int k = ((View)localObject1).getWidth() / 2;
          i = i / 2 - (k + j);
          localObject1 = paramFinderTabLayout.getLayoutParams();
          if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
            break label232;
          }
          localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
          label169:
          if (localObject1 != null) {
            break label238;
          }
        }
      }
    }
    for (paramFinderTabLayout = localObject2;; paramFinderTabLayout = ah.aiuX)
    {
      if (paramFinderTabLayout == null) {
        h.hd("tabLayoutParams null!");
      }
      AppMethodBeat.o(345549);
      return;
      label192:
      localObject1 = null;
      break;
      label198:
      localObject1 = ((FinderTabLayout.g)localObject1).dyK;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label62;
      }
      localObject1 = ((View)localObject1).getTag();
      break label62;
      label226:
      localObject1 = null;
      break label77;
      label232:
      localObject1 = null;
      break label169;
      label238:
      new StringBuilder("marginStart: ").append(((ViewGroup.MarginLayoutParams)localObject1).getMarginStart()).append(" delta:").append(i).append(' ');
      h.jXD();
      ((ViewGroup.MarginLayoutParams)localObject1).setMarginStart(((ViewGroup.MarginLayoutParams)localObject1).getMarginStart() + i);
      paramFinderTabLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.b
 * JD-Core Version:    0.7.0.1
 */