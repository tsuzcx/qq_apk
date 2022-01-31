package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLuckyMoneyDetailUI$1
  implements AbsListView.OnScrollListener
{
  private boolean ojw = false;
  private boolean ojx;
  
  WxaLuckyMoneyDetailUI$1(WxaLuckyMoneyDetailUI paramWxaLuckyMoneyDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    AppMethodBeat.i(42024);
    if ((paramInt3 == 0) || (!this.ojw))
    {
      AppMethodBeat.o(42024);
      return;
    }
    if (paramInt1 > 0) {}
    label63:
    label114:
    label117:
    for (;;)
    {
      if (this.ojx != bool)
      {
        if (bool)
        {
          WxaLuckyMoneyDetailUI.a(this.ojy, this.ojy.getResources().getDrawable(2130839340));
          this.ojx = bool;
        }
      }
      else
      {
        AppMethodBeat.o(42024);
        return;
        paramAbsListView = paramAbsListView.getChildAt(paramInt1);
        if (paramAbsListView == null) {
          break label114;
        }
      }
      for (paramInt1 = 0 - paramAbsListView.getTop();; paramInt1 = 0)
      {
        if (paramInt1 > 100) {
          break label117;
        }
        bool = false;
        break;
        WxaLuckyMoneyDetailUI.b(this.ojy);
        break label63;
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(42023);
    if (paramAbsListView.getCount() == 0)
    {
      AppMethodBeat.o(42023);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42023);
      return;
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) {
        WxaLuckyMoneyDetailUI.a(this.ojy).yg(paramAbsListView.getCount());
      }
      this.ojw = false;
      AppMethodBeat.o(42023);
      return;
      this.ojw = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI.1
 * JD-Core Version:    0.7.0.1
 */