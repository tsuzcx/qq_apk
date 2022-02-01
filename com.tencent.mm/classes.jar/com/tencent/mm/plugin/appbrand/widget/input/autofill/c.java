package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.k.a;

public final class c
{
  final ab ovY;
  final e ovZ;
  public final k.a owl;
  public ac owm;
  int own;
  boolean owo;
  
  c(ab paramab, e parame)
  {
    AppMethodBeat.i(136641);
    this.owl = new k.a()
    {
      public final void cbs()
      {
        AppMethodBeat.i(136637);
        c.this.own = -2147483648;
        c.this.Ao(3);
        AppMethodBeat.o(136637);
      }
      
      public final void cbt()
      {
        AppMethodBeat.i(136638);
        c.this.own = -2147483648;
        c.this.Ao(3);
        AppMethodBeat.o(136638);
      }
    };
    this.own = -2147483648;
    this.owo = false;
    this.ovY = paramab;
    this.ovZ = parame;
    AppMethodBeat.o(136641);
  }
  
  final void Ao(final int paramInt)
  {
    AppMethodBeat.i(136642);
    final AutoFillListPopupWindowBase.a locala = this.ovZ.ows;
    if (locala == null)
    {
      AppMethodBeat.o(136642);
      return;
    }
    if (!this.ovZ.arA.isShowing())
    {
      AppMethodBeat.o(136642);
      return;
    }
    if ((1 == paramInt) && (this.owo))
    {
      this.own = -2147483648;
      this.owo = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(136640);
        locala.getViewTreeObserver().removeOnPreDrawListener(this);
        c localc = c.this;
        if ((!localc.ovZ.arA.isShowing()) || (localc.ovZ.ows == null) || (localc.ovZ.ows.getAdapter() == null) || (localc.ovZ.ows.getAdapter().getCount() <= 0)) {}
        Object localObject;
        do
        {
          AppMethodBeat.o(136640);
          return true;
          localObject = localc.ovY.getInputPanel();
        } while (localObject == null);
        int m = a.fromDPToPix(localc.ovY.getContext(), 8);
        int n = localc.ovZ.ows.getChildAt(0).getHeight();
        int i = localc.ovZ.ows.getAdapter().getCount() * n;
        int k = i + m * 2;
        int j = n * 3 + m * 2;
        if (k > j) {
          i = j - m * 2;
        }
        for (;;)
        {
          localc.ovZ.ard = j;
          int[] arrayOfInt = new int[2];
          localc.ovY.getView().getLocationInWindow(arrayOfInt);
          j = arrayOfInt[1];
          j = localc.ovY.getView().getHeight() + j;
          ((View)localObject).getLocationInWindow(arrayOfInt);
          k = arrayOfInt[1];
          label249:
          if (((localc.own == -2147483648) || (localc.own >= 0 - m)) && (k - j >= i + m))
          {
            localc.ovZ.arp = localc.ovY.getView();
            localc.ovZ.ard = (m * 2 + i);
            localc.ovZ.setVerticalOffset(0 - m);
            localc.ovZ.show();
            localObject = localc.ovZ;
            if (((AutoFillListPopupWindowBase)localObject).arh) {
              break label539;
            }
          }
          label325:
          for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).arf)
          {
            localc.own = i;
            break;
            if (j - localc.ovY.getView().getHeight() >= i)
            {
              localc.ovZ.arp = localc.ovY.getView();
              localc.ovZ.ard = (m * 2 + i);
              localc.ovZ.setVerticalOffset(-(i + m) - localc.ovY.getView().getHeight());
              break label325;
            }
            if (i <= n)
            {
              localc.ovZ.ard = n;
              localc.ovZ.arp = localc.ovY.getView();
              if (localc.own < 0 - m)
              {
                localc.ovZ.setVerticalOffset(-(i + m) - localc.ovY.getView().getHeight());
                break label325;
              }
              localc.ovZ.setVerticalOffset(0 - m);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c
 * JD-Core Version:    0.7.0.1
 */