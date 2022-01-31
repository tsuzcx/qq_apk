package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a.e;

final class WxaLuckyMoneyDetailUI$1
  implements AbsListView.OnScrollListener
{
  private boolean lMc = false;
  private boolean lMd;
  
  WxaLuckyMoneyDetailUI$1(WxaLuckyMoneyDetailUI paramWxaLuckyMoneyDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((paramInt3 == 0) || (!this.lMc)) {
      return;
    }
    if (paramInt1 > 0) {}
    label20:
    label54:
    label90:
    label100:
    label103:
    for (;;)
    {
      if (this.lMd != bool)
      {
        if (!bool) {
          break label90;
        }
        WxaLuckyMoneyDetailUI.a(this.lMe, this.lMe.getResources().getDrawable(a.e.lucky_money_actionbar_bg));
        this.lMd = bool;
        return;
        paramAbsListView = paramAbsListView.getChildAt(paramInt1);
        if (paramAbsListView == null) {
          break label100;
        }
      }
      for (paramInt1 = 0 - paramAbsListView.getTop();; paramInt1 = 0)
      {
        if (paramInt1 > 100) {
          break label103;
        }
        bool = false;
        break label20;
        break;
        WxaLuckyMoneyDetailUI.b(this.lMe);
        break label54;
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
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) {
        WxaLuckyMoneyDetailUI.a(this.lMe).te(paramAbsListView.getCount());
      }
      this.lMc = false;
      return;
    }
    this.lMc = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI.1
 * JD-Core Version:    0.7.0.1
 */