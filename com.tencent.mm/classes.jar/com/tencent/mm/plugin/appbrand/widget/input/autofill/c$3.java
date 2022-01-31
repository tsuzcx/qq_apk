package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.widget.input.ab;

final class c$3
  implements ViewTreeObserver.OnPreDrawListener
{
  c$3(c paramc, ListView paramListView, int paramInt) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(123900);
    this.jpm.getViewTreeObserver().removeOnPreDrawListener(this);
    c localc = this.jpl;
    if ((!localc.joV.aht.isShowing()) || (localc.joV.jpo == null) || (localc.joV.jpo.getAdapter() == null) || (localc.joV.jpo.getAdapter().getCount() <= 0)) {}
    Object localObject;
    do
    {
      AppMethodBeat.o(123900);
      return true;
      localObject = localc.joU.getInputPanel();
    } while (localObject == null);
    int m = a.fromDPToPix(localc.joU.getContext(), 8);
    int n = localc.joV.jpo.getChildAt(0).getHeight();
    int i = localc.joV.jpo.getAdapter().getCount() * n;
    int k = i + m * 2;
    int j = n * 3 + m * 2;
    if (k > j) {
      i = j - m * 2;
    }
    for (;;)
    {
      localc.joV.agX = j;
      int[] arrayOfInt = new int[2];
      localc.joU.getView().getLocationInWindow(arrayOfInt);
      j = arrayOfInt[1];
      j = localc.joU.getView().getHeight() + j;
      ((View)localObject).getLocationInWindow(arrayOfInt);
      k = arrayOfInt[1];
      label249:
      if (((localc.jpj == -2147483648) || (localc.jpj >= 0 - m)) && (k - j >= i + m))
      {
        localc.joV.ahj = localc.joU.getView();
        localc.joV.agX = (m * 2 + i);
        localc.joV.setVerticalOffset(0 - m);
        localc.joV.show();
        localObject = localc.joV;
        if (((AutoFillListPopupWindowBase)localObject).ahb) {
          break label539;
        }
      }
      label325:
      for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).agZ)
      {
        localc.jpj = i;
        break;
        if (j - localc.joU.getView().getHeight() >= i)
        {
          localc.joV.ahj = localc.joU.getView();
          localc.joV.agX = (m * 2 + i);
          localc.joV.setVerticalOffset(-(i + m) - localc.joU.getView().getHeight());
          break label325;
        }
        if (i <= n)
        {
          localc.joV.agX = n;
          localc.joV.ahj = localc.joU.getView();
          if (localc.jpj < 0 - m)
          {
            localc.joV.setVerticalOffset(-(i + m) - localc.joU.getView().getHeight());
            break label325;
          }
          localc.joV.setVerticalOffset(0 - m);
          break label325;
        }
        i -= n;
        break label249;
      }
      label539:
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c.3
 * JD-Core Version:    0.7.0.1
 */