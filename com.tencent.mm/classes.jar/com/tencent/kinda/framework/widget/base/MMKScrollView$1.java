package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.kinda.gen.KScrollViewOnScrollCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.MMScrollView.a;

class MMKScrollView$1
  implements MMScrollView.a
{
  MMKScrollView$1(MMKScrollView paramMMKScrollView, KScrollViewOnScrollCallback paramKScrollViewOnScrollCallback) {}
  
  public void onScrollChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(144953);
    this.val$callback.onScroll(paramInt1, paramInt2);
    AppMethodBeat.o(144953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKScrollView.1
 * JD-Core Version:    0.7.0.1
 */