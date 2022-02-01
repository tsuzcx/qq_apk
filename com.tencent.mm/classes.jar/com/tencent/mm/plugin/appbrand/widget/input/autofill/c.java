package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.k.a;

public final class c
{
  final ab nhj;
  final e nhk;
  public final k.a nhw;
  public aa nhx;
  int nhy;
  boolean nhz;
  
  c(ab paramab, e parame)
  {
    AppMethodBeat.i(136641);
    this.nhw = new k.a()
    {
      public final void bEl()
      {
        AppMethodBeat.i(136637);
        c.this.nhy = -2147483648;
        c.this.wB(3);
        AppMethodBeat.o(136637);
      }
      
      public final void bEm()
      {
        AppMethodBeat.i(136638);
        c.this.nhy = -2147483648;
        c.this.wB(3);
        AppMethodBeat.o(136638);
      }
    };
    this.nhy = -2147483648;
    this.nhz = false;
    this.nhj = paramab;
    this.nhk = parame;
    AppMethodBeat.o(136641);
  }
  
  final void wB(final int paramInt)
  {
    AppMethodBeat.i(136642);
    final AutoFillListPopupWindowBase.a locala = this.nhk.nhD;
    if (locala == null)
    {
      AppMethodBeat.o(136642);
      return;
    }
    if (!this.nhk.arn.isShowing())
    {
      AppMethodBeat.o(136642);
      return;
    }
    if ((1 == paramInt) && (this.nhz))
    {
      this.nhy = -2147483648;
      this.nhz = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(136640);
        locala.getViewTreeObserver().removeOnPreDrawListener(this);
        c localc = c.this;
        if ((!localc.nhk.arn.isShowing()) || (localc.nhk.nhD == null) || (localc.nhk.nhD.getAdapter() == null) || (localc.nhk.nhD.getAdapter().getCount() <= 0)) {}
        Object localObject;
        do
        {
          AppMethodBeat.o(136640);
          return true;
          localObject = localc.nhj.getInputPanel();
        } while (localObject == null);
        int m = a.fromDPToPix(localc.nhj.getContext(), 8);
        int n = localc.nhk.nhD.getChildAt(0).getHeight();
        int i = localc.nhk.nhD.getAdapter().getCount() * n;
        int k = i + m * 2;
        int j = n * 3 + m * 2;
        if (k > j) {
          i = j - m * 2;
        }
        for (;;)
        {
          localc.nhk.aqR = j;
          int[] arrayOfInt = new int[2];
          localc.nhj.getView().getLocationInWindow(arrayOfInt);
          j = arrayOfInt[1];
          j = localc.nhj.getView().getHeight() + j;
          ((View)localObject).getLocationInWindow(arrayOfInt);
          k = arrayOfInt[1];
          label249:
          if (((localc.nhy == -2147483648) || (localc.nhy >= 0 - m)) && (k - j >= i + m))
          {
            localc.nhk.ard = localc.nhj.getView();
            localc.nhk.aqR = (m * 2 + i);
            localc.nhk.setVerticalOffset(0 - m);
            localc.nhk.show();
            localObject = localc.nhk;
            if (((AutoFillListPopupWindowBase)localObject).aqV) {
              break label539;
            }
          }
          label325:
          for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).aqT)
          {
            localc.nhy = i;
            break;
            if (j - localc.nhj.getView().getHeight() >= i)
            {
              localc.nhk.ard = localc.nhj.getView();
              localc.nhk.aqR = (m * 2 + i);
              localc.nhk.setVerticalOffset(-(i + m) - localc.nhj.getView().getHeight());
              break label325;
            }
            if (i <= n)
            {
              localc.nhk.aqR = n;
              localc.nhk.ard = localc.nhj.getView();
              if (localc.nhy < 0 - m)
              {
                localc.nhk.setVerticalOffset(-(i + m) - localc.nhj.getView().getHeight());
                break label325;
              }
              localc.nhk.setVerticalOffset(0 - m);
              break label325;
            }
            i -= n;
            break label249;
          }
          label539:
          j = k;
        }
      }
    });
    AppMethodBeat.o(136642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c
 * JD-Core Version:    0.7.0.1
 */