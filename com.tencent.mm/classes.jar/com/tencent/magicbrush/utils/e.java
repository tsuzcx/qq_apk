package com.tencent.magicbrush.utils;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/utils/ScreenCanvasZIndex;", "", "()V", "array", "Ljava/util/HashMap;", "Landroid/view/View;", "", "Lkotlin/collections/HashMap;", "insertView", "viewGroup", "Landroid/view/ViewGroup;", "view", "zIndex", "removeIndex", "", "lib-magicbrush-nano_release"})
public final class e
{
  private final HashMap<View, Integer> cQm;
  
  public e()
  {
    AppMethodBeat.i(206193);
    this.cQm = new HashMap();
    AppMethodBeat.o(206193);
  }
  
  public final int a(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(206191);
    p.k(paramViewGroup, "viewGroup");
    p.k(paramView, "view");
    Integer localInteger = (Integer)this.cQm.get(paramView);
    int i;
    int j;
    int k;
    if (localInteger == null)
    {
      ((Map)this.cQm).put(paramView, Integer.valueOf(paramInt));
      int m = paramViewGroup.getChildCount();
      i = 0;
      j = 0;
      k = 0;
      label68:
      if (i >= m) {
        break label148;
      }
      paramView = paramViewGroup.getChildAt(i);
      paramView = this.cQm.get(paramView);
      if (paramView == null) {
        p.iCn();
      }
      p.j(paramView, "array[itView]!!");
      if (paramInt >= ((Number)paramView).intValue()) {
        break label168;
      }
      j = i;
      k = 1;
    }
    label148:
    label168:
    for (;;)
    {
      i += 1;
      break label68;
      if (localInteger.intValue() != paramInt) {
        break;
      }
      AppMethodBeat.o(206191);
      return -2;
      if (k != 0)
      {
        AppMethodBeat.o(206191);
        return j;
      }
      AppMethodBeat.o(206191);
      return -1;
    }
  }
  
  public final void cz(View paramView)
  {
    AppMethodBeat.i(206192);
    p.k(paramView, "view");
    this.cQm.remove(paramView);
    AppMethodBeat.o(206192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.utils.e
 * JD-Core Version:    0.7.0.1
 */