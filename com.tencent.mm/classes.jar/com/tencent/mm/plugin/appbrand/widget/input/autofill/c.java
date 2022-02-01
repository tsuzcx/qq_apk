package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.k.a;

public final class c
{
  final af ryS;
  final e ryT;
  public final k.a rzf;
  public ad rzg;
  int rzh;
  boolean rzi;
  
  c(af paramaf, e parame)
  {
    AppMethodBeat.i(136641);
    this.rzf = new k.a()
    {
      public final void coC()
      {
        AppMethodBeat.i(136637);
        c.this.rzh = -2147483648;
        c.this.DV(3);
        AppMethodBeat.o(136637);
      }
      
      public final void coD()
      {
        AppMethodBeat.i(136638);
        c.this.rzh = -2147483648;
        c.this.DV(3);
        AppMethodBeat.o(136638);
      }
    };
    this.rzh = -2147483648;
    this.rzi = false;
    this.ryS = paramaf;
    this.ryT = parame;
    AppMethodBeat.o(136641);
  }
  
  final void DV(final int paramInt)
  {
    AppMethodBeat.i(136642);
    final AutoFillListPopupWindowBase.a locala = this.ryT.rzm;
    if (locala == null)
    {
      AppMethodBeat.o(136642);
      return;
    }
    if (!this.ryT.ty.isShowing())
    {
      AppMethodBeat.o(136642);
      return;
    }
    if ((1 == paramInt) && (this.rzi))
    {
      this.rzh = -2147483648;
      this.rzi = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(136640);
        locala.getViewTreeObserver().removeOnPreDrawListener(this);
        c localc = c.this;
        if ((!localc.ryT.ty.isShowing()) || (localc.ryT.rzm == null) || (localc.ryT.rzm.getAdapter() == null) || (localc.ryT.rzm.getAdapter().getCount() <= 0)) {}
        Object localObject;
        do
        {
          AppMethodBeat.o(136640);
          return true;
          localObject = localc.ryS.getInputPanel();
        } while (localObject == null);
        int m = a.fromDPToPix(localc.ryS.getContext(), 8);
        int n = localc.ryT.rzm.getChildAt(0).getHeight();
        int i = localc.ryT.rzm.getAdapter().getCount() * n;
        int k = i + m * 2;
        int j = n * 3 + m * 2;
        if (k > j) {
          i = j - m * 2;
        }
        for (;;)
        {
          localc.ryT.sZ = j;
          int[] arrayOfInt = new int[2];
          localc.ryS.getView().getLocationInWindow(arrayOfInt);
          j = arrayOfInt[1];
          j = localc.ryS.getView().getHeight() + j;
          ((View)localObject).getLocationInWindow(arrayOfInt);
          k = arrayOfInt[1];
          label249:
          if (((localc.rzh == -2147483648) || (localc.rzh >= 0 - m)) && (k - j >= i + m))
          {
            localc.ryT.tl = localc.ryS.getView();
            localc.ryT.sZ = (m * 2 + i);
            localc.ryT.ah(0 - m);
            localc.ryT.show();
            localObject = localc.ryT;
            if (((AutoFillListPopupWindowBase)localObject).td) {
              break label539;
            }
          }
          label325:
          for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).tb)
          {
            localc.rzh = i;
            break;
            if (j - localc.ryS.getView().getHeight() >= i)
            {
              localc.ryT.tl = localc.ryS.getView();
              localc.ryT.sZ = (m * 2 + i);
              localc.ryT.ah(-(i + m) - localc.ryS.getView().getHeight());
              break label325;
            }
            if (i <= n)
            {
              localc.ryT.sZ = n;
              localc.ryT.tl = localc.ryS.getView();
              if (localc.rzh < 0 - m)
              {
                localc.ryT.ah(-(i + m) - localc.ryS.getView().getHeight());
                break label325;
              }
              localc.ryT.ah(0 - m);
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