package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.wxpay.a.e;

final class LuckyMoneyDetailUI$1
  implements AbsListView.OnScrollListener
{
  private boolean lMc = false;
  private boolean lMd;
  
  LuckyMoneyDetailUI$1(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((paramInt3 == 0) || (!this.lMc)) {
      return;
    }
    if (paramInt1 > 0) {}
    label20:
    label87:
    label90:
    for (;;)
    {
      if (this.lMd != bool)
      {
        if (bool) {
          this.lVz.getResources().getDrawable(a.e.lucky_money_actionbar_bg);
        }
        LuckyMoneyDetailUI.bgb();
        this.lMd = bool;
        return;
        paramAbsListView = paramAbsListView.getChildAt(paramInt1);
        if (paramAbsListView == null) {
          break label87;
        }
      }
      for (paramInt1 = 0 - paramAbsListView.getTop();; paramInt1 = 0)
      {
        if (paramInt1 > 100) {
          break label90;
        }
        bool = false;
        break label20;
        break;
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView.getCount() == 0) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (!this.lVz.lUq.bfI()) {
          LuckyMoneyDetailUI.a(this.lVz);
        }
        if ((LuckyMoneyDetailUI.b(this.lVz)) && (!LuckyMoneyDetailUI.c(this.lVz))) {
          LuckyMoneyDetailUI.d(this.lVz);
        }
      }
      this.lMc = false;
      return;
    }
    this.lMc = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.1
 * JD-Core Version:    0.7.0.1
 */