package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.widget.input.aa;

final class c$3
  implements ViewTreeObserver.OnPreDrawListener
{
  c$3(c paramc, ListView paramListView, int paramInt) {}
  
  public final boolean onPreDraw()
  {
    this.hxc.getViewTreeObserver().removeOnPreDrawListener(this);
    c localc = this.hxb;
    if ((!localc.hwL.afe.isShowing()) || (localc.hwL.hxe == null) || (localc.hwL.hxe.getAdapter() == null) || (localc.hwL.hxe.getAdapter().getCount() <= 0)) {}
    Object localObject;
    do
    {
      return true;
      localObject = localc.hwK.getInputPanel();
    } while (localObject == null);
    int m = a.fromDPToPix(localc.hwK.getContext(), 8);
    int n = localc.hwL.hxe.getChildAt(0).getHeight();
    int i = localc.hwL.hxe.getAdapter().getCount() * n;
    int k = i + m * 2;
    int j = n * 3 + m * 2;
    if (k > j) {
      i = j - m * 2;
    }
    for (;;)
    {
      localc.hwL.aeI = j;
      int[] arrayOfInt = new int[2];
      localc.hwK.getView().getLocationInWindow(arrayOfInt);
      j = arrayOfInt[1];
      j = localc.hwK.getView().getHeight() + j;
      ((View)localObject).getLocationInWindow(arrayOfInt);
      k = arrayOfInt[1];
      if (((localc.hwZ == -2147483648) || (localc.hwZ >= 0 - m)) && (k - j >= i + m))
      {
        localc.hwL.aeU = localc.hwK.getView();
        localc.hwL.aeI = (m * 2 + i);
        localc.hwL.setVerticalOffset(0 - m);
        label315:
        localc.hwL.show();
        localObject = localc.hwL;
        if (((AutoFillListPopupWindowBase)localObject).aeM) {
          break label528;
        }
      }
      label528:
      for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).aeK)
      {
        localc.hwZ = i;
        return true;
        if (j - localc.hwK.getView().getHeight() >= i)
        {
          localc.hwL.aeU = localc.hwK.getView();
          localc.hwL.aeI = (m * 2 + i);
          localc.hwL.setVerticalOffset(-(i + m) - localc.hwK.getView().getHeight());
          break label315;
        }
        if (i <= n)
        {
          localc.hwL.aeI = n;
          localc.hwL.aeU = localc.hwK.getView();
          if (localc.hwZ < 0 - m)
          {
            localc.hwL.setVerticalOffset(-(i + m) - localc.hwK.getView().getHeight());
            break label315;
          }
          localc.hwL.setVerticalOffset(0 - m);
          break label315;
        }
        i -= n;
        break;
      }
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c.3
 * JD-Core Version:    0.7.0.1
 */