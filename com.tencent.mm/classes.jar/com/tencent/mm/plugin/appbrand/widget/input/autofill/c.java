package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.k.a;

public final class c
{
  final af uJV;
  final e uJW;
  public final k.a uKi;
  public ad uKj;
  int uKk;
  boolean uKl;
  
  c(af paramaf, e parame)
  {
    AppMethodBeat.i(136641);
    this.uKi = new k.a()
    {
      public final void cRe()
      {
        AppMethodBeat.i(136637);
        c.this.uKk = -2147483648;
        c.this.Ev(3);
        AppMethodBeat.o(136637);
      }
      
      public final void cRf()
      {
        AppMethodBeat.i(136638);
        c.this.uKk = -2147483648;
        c.this.Ev(3);
        AppMethodBeat.o(136638);
      }
    };
    this.uKk = -2147483648;
    this.uKl = false;
    this.uJV = paramaf;
    this.uJW = parame;
    AppMethodBeat.o(136641);
  }
  
  final void Ev(final int paramInt)
  {
    AppMethodBeat.i(136642);
    final AutoFillListPopupWindowBase.a locala = this.uJW.uKp;
    if (locala == null)
    {
      AppMethodBeat.o(136642);
      return;
    }
    if (!this.uJW.ux.isShowing())
    {
      AppMethodBeat.o(136642);
      return;
    }
    if ((1 == paramInt) && (this.uKl))
    {
      this.uKk = -2147483648;
      this.uKl = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(136640);
        locala.getViewTreeObserver().removeOnPreDrawListener(this);
        c localc = c.this;
        if ((!localc.uJW.ux.isShowing()) || (localc.uJW.uKp == null) || (localc.uJW.uKp.getAdapter() == null) || (localc.uJW.uKp.getAdapter().getCount() <= 0)) {}
        Object localObject;
        do
        {
          AppMethodBeat.o(136640);
          return true;
          localObject = localc.uJV.getInputPanel();
        } while (localObject == null);
        int m = a.fromDPToPix(localc.uJV.getContext(), 8);
        int n = localc.uJW.uKp.getChildAt(0).getHeight();
        int i = localc.uJW.uKp.getAdapter().getCount() * n;
        int k = i + m * 2;
        int j = n * 3 + m * 2;
        if (k > j) {
          i = j - m * 2;
        }
        for (;;)
        {
          localc.uJW.tY = j;
          int[] arrayOfInt = new int[2];
          localc.uJV.getView().getLocationInWindow(arrayOfInt);
          j = arrayOfInt[1];
          j = localc.uJV.getView().getHeight() + j;
          ((View)localObject).getLocationInWindow(arrayOfInt);
          k = arrayOfInt[1];
          label249:
          if (((localc.uKk == -2147483648) || (localc.uKk >= 0 - m)) && (k - j >= i + m))
          {
            localc.uJW.ul = localc.uJV.getView();
            localc.uJW.tY = (m * 2 + i);
            localc.uJW.ad(0 - m);
            localc.uJW.show();
            localObject = localc.uJW;
            if (((AutoFillListPopupWindowBase)localObject).uc) {
              break label539;
            }
          }
          label325:
          for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).ua)
          {
            localc.uKk = i;
            break;
            if (j - localc.uJV.getView().getHeight() >= i)
            {
              localc.uJW.ul = localc.uJV.getView();
              localc.uJW.tY = (m * 2 + i);
              localc.uJW.ad(-(i + m) - localc.uJV.getView().getHeight());
              break label325;
            }
            if (i <= n)
            {
              localc.uJW.tY = n;
              localc.uJW.ul = localc.uJV.getView();
              if (localc.uKk < 0 - m)
              {
                localc.uJW.ad(-(i + m) - localc.uJV.getView().getHeight());
                break label325;
              }
              localc.uJW.ad(0 - m);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c
 * JD-Core Version:    0.7.0.1
 */