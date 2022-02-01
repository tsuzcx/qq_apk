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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.k.a;

public final class c
{
  final ab meM;
  final e meN;
  public final k.a meZ;
  public aa mfa;
  int mfb;
  boolean mfc;
  
  c(ab paramab, e parame)
  {
    AppMethodBeat.i(136641);
    this.meZ = new k.a()
    {
      public final void btj()
      {
        AppMethodBeat.i(136637);
        c.this.mfb = -2147483648;
        c.this.vf(3);
        AppMethodBeat.o(136637);
      }
      
      public final void btk()
      {
        AppMethodBeat.i(136638);
        c.this.mfb = -2147483648;
        c.this.vf(3);
        AppMethodBeat.o(136638);
      }
    };
    this.mfb = -2147483648;
    this.mfc = false;
    this.meM = paramab;
    this.meN = parame;
    AppMethodBeat.o(136641);
  }
  
  final void vf(final int paramInt)
  {
    AppMethodBeat.i(136642);
    final AutoFillListPopupWindowBase.a locala = this.meN.mfg;
    if (locala == null)
    {
      AppMethodBeat.o(136642);
      return;
    }
    if (!this.meN.aoA.isShowing())
    {
      AppMethodBeat.o(136642);
      return;
    }
    if ((1 == paramInt) && (this.mfc))
    {
      this.mfb = -2147483648;
      this.mfc = false;
    }
    locala.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(136640);
        locala.getViewTreeObserver().removeOnPreDrawListener(this);
        c localc = c.this;
        if ((!localc.meN.aoA.isShowing()) || (localc.meN.mfg == null) || (localc.meN.mfg.getAdapter() == null) || (localc.meN.mfg.getAdapter().getCount() <= 0)) {}
        Object localObject;
        do
        {
          AppMethodBeat.o(136640);
          return true;
          localObject = localc.meM.getInputPanel();
        } while (localObject == null);
        int m = a.fromDPToPix(localc.meM.getContext(), 8);
        int n = localc.meN.mfg.getChildAt(0).getHeight();
        int i = localc.meN.mfg.getAdapter().getCount() * n;
        int k = i + m * 2;
        int j = n * 3 + m * 2;
        if (k > j) {
          i = j - m * 2;
        }
        for (;;)
        {
          localc.meN.aoe = j;
          int[] arrayOfInt = new int[2];
          localc.meM.getView().getLocationInWindow(arrayOfInt);
          j = arrayOfInt[1];
          j = localc.meM.getView().getHeight() + j;
          ((View)localObject).getLocationInWindow(arrayOfInt);
          k = arrayOfInt[1];
          label249:
          if (((localc.mfb == -2147483648) || (localc.mfb >= 0 - m)) && (k - j >= i + m))
          {
            localc.meN.aoq = localc.meM.getView();
            localc.meN.aoe = (m * 2 + i);
            localc.meN.setVerticalOffset(0 - m);
            localc.meN.show();
            localObject = localc.meN;
            if (((AutoFillListPopupWindowBase)localObject).aoi) {
              break label539;
            }
          }
          label325:
          for (i = 0;; i = ((AutoFillListPopupWindowBase)localObject).aog)
          {
            localc.mfb = i;
            break;
            if (j - localc.meM.getView().getHeight() >= i)
            {
              localc.meN.aoq = localc.meM.getView();
              localc.meN.aoe = (m * 2 + i);
              localc.meN.setVerticalOffset(-(i + m) - localc.meM.getView().getHeight());
              break label325;
            }
            if (i <= n)
            {
              localc.meN.aoe = n;
              localc.meN.aoq = localc.meM.getView();
              if (localc.mfb < 0 - m)
              {
                localc.meN.setVerticalOffset(-(i + m) - localc.meM.getView().getHeight());
                break label325;
              }
              localc.meN.setVerticalOffset(0 - m);
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