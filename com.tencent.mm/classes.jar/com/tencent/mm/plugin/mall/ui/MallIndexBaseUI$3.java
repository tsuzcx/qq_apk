package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.s;

final class MallIndexBaseUI$3
  implements AbsListView.OnScrollListener
{
  boolean bYw = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
  int color;
  int lZI;
  final int maxHeight = a.fromDPToPix(this.lZE.mController.uMN, 200);
  final int minHeight = a.fromDPToPix(this.lZE.mController.uMN, 50);
  
  MallIndexBaseUI$3(MallIndexBaseUI paramMallIndexBaseUI)
  {
    if (this.bYw) {}
    for (int i = a.c.dark_actionbar_color;; i = a.c.normal_actionbar_color)
    {
      this.lZI = i;
      this.color = this.lZE.mController.uMN.getResources().getColor(this.lZI);
      return;
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    if (paramAbsListView.getChildCount() == 0) {
      return;
    }
    if (paramInt1 == 0)
    {
      paramInt1 = Math.abs(paramAbsListView.getChildAt(0).getTop());
      if (paramInt1 <= this.minHeight)
      {
        paramInt1 = paramInt2;
        if (MallIndexBaseUI.a(this.lZE) != paramInt1)
        {
          if (paramInt1 > 0) {
            break label124;
          }
          this.lZE.ta(this.lZE.mController.uMN.getResources().getColor(a.c.transparent));
        }
      }
    }
    for (;;)
    {
      MallIndexBaseUI.a(this.lZE, paramInt1);
      return;
      if (paramInt1 < this.maxHeight)
      {
        paramInt1 = (paramInt1 - this.minHeight) * 100 / (this.maxHeight - this.minHeight);
        break;
      }
      paramInt1 = 100;
      break;
      label124:
      this.lZE.ta(an.fm(this.color, paramInt1));
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.3
 * JD-Core Version:    0.7.0.1
 */