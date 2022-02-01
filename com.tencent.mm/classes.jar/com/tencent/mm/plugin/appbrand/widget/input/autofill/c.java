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
  final ab mGL;
  final e mGM;
  public final k.a mGY;
  public aa mGZ;
  int mHa;
  boolean mHb;
  
  c(ab paramab, e parame)
  {
    AppMethodBeat.i(136641);
    this.mGY = new k.a()
    {
      public final void bAj()
      {
        AppMethodBeat.i(136637);
        c.this.mHa = -2147483648;
        c.this.vW(3);
        AppMethodBeat.o(136637);
      }
      
      public final void bAk()
      {
        AppMethodBeat.i(136638);
        c.this.mHa = -2147483648;
        c.this.vW(3);
        AppMethodBeat.o(136638);
      }
    };
    this.mHa = -2147483648;
    this.mHb = false;
    this.mGL = paramab;
    this.mGM = parame;
    AppMethodBeat.o(136641);
  }
  
  final void vW(final int paramInt)
  {
    AppMethodBeat.i(136642);
    final AutoFillListPopupWindowBase.a locala = this.mGM.mHf;
    if (locala == null)
    {
      AppMethodBeat.o(136642);
      return;
    }
    if (!this.mGM.apw.isShowing())
    {
      AppMethodBeat.o(136642);
      return;
    }
    if ((1 == paramInt) && (this.mHb))
    {
      this.mHa = -2147483648;
      this.mHb = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(136640);
        locala.getViewTreeObserver().removeOnPreDrawListener(this);
        c localc = c.this;
        if ((!localc.mGM.apw.isShowing()) || (localc.mGM.mHf == null) || (localc.mGM.mHf.getAdapter() == null) || (localc.mGM.mHf.getAdapter().getCount() <= 0)) {}
        Object localObject;
        do
        {
          AppMethodBeat.o(136640);
          return true;
          localObject = localc.mGL.getInputPanel();
        } while (localObject == null);
        int m = a.fromDPToPix(localc.mGL.getContext(), 8);
        int n = localc.mGM.mHf.getChildAt(0).getHeight();
        int i = localc.mGM.mHf.getAdapter().getCount() * n;
        int k = i + m * 2;
        int j = n * 3 + m * 2;
        if (k > j) {
          i = j - m * 2;
        }
        for (;;)
        {
          localc.mGM.aoZ = j;
          int[] arrayOfInt = new int[2];
          localc.mGL.getView().getLocationInWindow(arrayOfInt);
          j = arrayOfInt[1];
          j = localc.mGL.getView().getHeight() + j;
          ((View)localObject).getLocationInWindow(arrayOfInt);
          k = arrayOfInt[1];
          label249:
          if (((localc.mHa == -2147483648) || (localc.mHa >= 0 - m)) && (k - j >= i + m))
          {
            localc.mGM.apl = localc.mGL.getView();
            localc.mGM.aoZ = (m * 2 + i);
            localc.mGM.setVerticalOffset(0 - m);
            localc.mGM.show();
            localObject = localc.mGM;
            if (((AutoFillListPopupWindowBase)localObject).apd) {
              break label539;
            }
          }
          label325:
          for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).apb)
          {
            localc.mHa = i;
            break;
            if (j - localc.mGL.getView().getHeight() >= i)
            {
              localc.mGM.apl = localc.mGL.getView();
              localc.mGM.aoZ = (m * 2 + i);
              localc.mGM.setVerticalOffset(-(i + m) - localc.mGL.getView().getHeight());
              break label325;
            }
            if (i <= n)
            {
              localc.mGM.aoZ = n;
              localc.mGM.apl = localc.mGL.getView();
              if (localc.mHa < 0 - m)
              {
                localc.mGM.setVerticalOffset(-(i + m) - localc.mGL.getView().getHeight());
                break label325;
              }
              localc.mGM.setVerticalOffset(0 - m);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c
 * JD-Core Version:    0.7.0.1
 */