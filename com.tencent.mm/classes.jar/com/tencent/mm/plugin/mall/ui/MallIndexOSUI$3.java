package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.aj;

final class MallIndexOSUI$3
  implements AbsListView.OnScrollListener
{
  boolean cGx;
  int color;
  final int maxHeight;
  final int minHeight;
  int ozX;
  
  MallIndexOSUI$3(MallIndexOSUI paramMallIndexOSUI)
  {
    AppMethodBeat.i(43182);
    this.minHeight = a.fromDPToPix(this.ozV.getContext(), 50);
    this.maxHeight = a.fromDPToPix(this.ozV.getContext(), 200);
    this.cGx = ah.getContext().getSharedPreferences(ah.dsP() + "_redesign", h.Mp()).getBoolean("dark_actionbar", false);
    if (this.cGx) {}
    for (int i = 2131689915;; i = 2131690316)
    {
      this.ozX = i;
      this.color = this.ozV.getContext().getResources().getColor(this.ozX);
      AppMethodBeat.o(43182);
      return;
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    AppMethodBeat.i(43183);
    if (paramAbsListView.getChildCount() == 0)
    {
      AppMethodBeat.o(43183);
      return;
    }
    if (paramInt1 == 0)
    {
      paramInt1 = Math.abs(paramAbsListView.getChildAt(0).getTop());
      if (paramInt1 <= this.minHeight)
      {
        paramInt1 = paramInt2;
        if (MallIndexOSUI.e(this.ozV) != paramInt1)
        {
          if (paramInt1 > 0) {
            break label135;
          }
          this.ozV.setActionbarColor(this.ozV.getContext().getResources().getColor(2131690605));
        }
      }
    }
    for (;;)
    {
      MallIndexOSUI.a(this.ozV, paramInt1);
      AppMethodBeat.o(43183);
      return;
      if (paramInt1 < this.maxHeight)
      {
        paramInt1 = (paramInt1 - this.minHeight) * 100 / (this.maxHeight - this.minHeight);
        break;
      }
      paramInt1 = 100;
      break;
      label135:
      this.ozV.setActionbarColor(aj.dS(this.color, paramInt1));
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.3
 * JD-Core Version:    0.7.0.1
 */