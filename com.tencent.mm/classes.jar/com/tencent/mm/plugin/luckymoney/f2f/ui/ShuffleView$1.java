package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ShuffleView$1
  implements View.OnLayoutChangeListener
{
  ShuffleView$1(ShuffleView paramShuffleView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(42224);
    ShuffleView.a(this.omN);
    paramView = this.omN;
    paramInt1 = 0;
    while (paramInt1 < paramView.omE)
    {
      paramView.aa((View)paramView.omr.get(paramInt1), paramInt1);
      paramInt1 += 1;
    }
    this.omN.removeOnLayoutChangeListener(this);
    AppMethodBeat.o(42224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.1
 * JD-Core Version:    0.7.0.1
 */