package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;

final class LuckyMoneyDetailUI$1
  implements AbsListView.OnScrollListener
{
  private boolean ojw = false;
  private boolean ojx;
  
  LuckyMoneyDetailUI$1(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    AppMethodBeat.i(42646);
    if ((paramInt3 == 0) || (!this.ojw))
    {
      AppMethodBeat.o(42646);
      return;
    }
    if (paramInt1 > 0) {}
    label101:
    for (;;)
    {
      if (this.ojx != bool)
      {
        if (bool) {
          this.otz.getResources().getDrawable(2130839340);
        }
        this.ojx = bool;
      }
      AppMethodBeat.o(42646);
      return;
      paramAbsListView = paramAbsListView.getChildAt(paramInt1);
      if (paramAbsListView != null) {}
      for (paramInt1 = 0 - paramAbsListView.getTop();; paramInt1 = 0)
      {
        if (paramInt1 > 100) {
          break label101;
        }
        bool = false;
        break;
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(42645);
    if (paramAbsListView.getCount() == 0)
    {
      AppMethodBeat.o(42645);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(42645);
      return;
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (!this.otz.orz.isProcessing()) {
          LuckyMoneyDetailUI.a(this.otz);
        }
        if ((LuckyMoneyDetailUI.b(this.otz)) && (!LuckyMoneyDetailUI.c(this.otz))) {
          LuckyMoneyDetailUI.d(this.otz);
        }
      }
      this.ojw = false;
      AppMethodBeat.o(42645);
      return;
      this.ojw = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.1
 * JD-Core Version:    0.7.0.1
 */