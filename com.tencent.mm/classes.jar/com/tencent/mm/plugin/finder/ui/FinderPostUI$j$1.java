package com.tencent.mm.plugin.finder.ui;

import android.graphics.Point;
import android.text.Layout;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.FinderTopicSuggestView;
import com.tencent.mm.plugin.finder.view.manager.b;
import com.tencent.mm.plugin.finder.view.manager.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class FinderPostUI$j$1
  implements Runnable
{
  FinderPostUI$j$1(FinderPostUI.j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(199317);
    ad.i(FinderPostUI.b(this.KYY.qPg), "descTv OnLayoutChangeListener");
    Object localObject1 = FinderPostUI.d(this.KYY.qPg).fXc();
    int i = FinderPostUI.f(this.KYY.qPg);
    if (((b)localObject1).qPa.getVisibility() == 0)
    {
      int j = ((b)localObject1).qOz.getSelectionStart();
      Object localObject2 = ((b)localObject1).qOz.getLayout();
      int m = ((Layout)localObject2).getLineForOffset(j);
      int k = ((Layout)localObject2).getLineBaseline(m);
      m = ((Layout)localObject2).getLineAscent(m);
      int[] arrayOfInt = new int[2];
      ((b)localObject1).qOz.getLocationOnScreen(arrayOfInt);
      Point localPoint = new Point();
      localPoint.x = ((int)((Layout)localObject2).getPrimaryHorizontal(j));
      localPoint.y = (k + m + arrayOfInt[1] - ((b)localObject1).qOz.getScrollY());
      ad.i(b.TAG, "onSelectionChangedListener point " + localPoint + ", actionbarHeight " + i);
      localObject2 = ((b)localObject1).qPa.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(199317);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (localPoint.y - i);
      ((b)localObject1).qPa.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(199317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI.j.1
 * JD-Core Version:    0.7.0.1
 */