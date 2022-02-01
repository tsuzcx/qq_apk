package com.tencent.magicbrush.utils;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/ScreenCanvasZIndex;", "", "()V", "array", "Ljava/util/HashMap;", "Landroid/view/View;", "", "Lkotlin/collections/HashMap;", "insertView", "viewGroup", "Landroid/view/ViewGroup;", "view", "zIndex", "removeIndex", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class e
{
  private final HashMap<View, Integer> eLq;
  
  public e()
  {
    AppMethodBeat.i(228770);
    this.eLq = new HashMap();
    AppMethodBeat.o(228770);
  }
  
  public final int a(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(228776);
    s.t(paramViewGroup, "viewGroup");
    s.t(paramView, "view");
    Integer localInteger = (Integer)this.eLq.get(paramView);
    int i;
    int j;
    int k;
    if (localInteger == null)
    {
      ((Map)this.eLq).put(paramView, Integer.valueOf(paramInt));
      int m = paramViewGroup.getChildCount();
      i = 0;
      j = 0;
      k = 0;
      label68:
      if (i >= m) {
        break label148;
      }
      paramView = paramViewGroup.getChildAt(i);
      paramView = this.eLq.get(paramView);
      if (paramView == null) {
        s.klw();
      }
      s.r(paramView, "array[itView]!!");
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
      AppMethodBeat.o(228776);
      return -2;
      if (k != 0)
      {
        AppMethodBeat.o(228776);
        return j;
      }
      AppMethodBeat.o(228776);
      return -1;
    }
  }
  
  public final void cT(View paramView)
  {
    AppMethodBeat.i(228781);
    s.t(paramView, "view");
    this.eLq.remove(paramView);
    AppMethodBeat.o(228781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.utils.e
 * JD-Core Version:    0.7.0.1
 */