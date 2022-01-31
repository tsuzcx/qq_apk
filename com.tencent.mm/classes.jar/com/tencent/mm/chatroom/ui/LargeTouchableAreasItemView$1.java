package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LargeTouchableAreasItemView$1
  implements View.OnClickListener
{
  LargeTouchableAreasItemView$1(LargeTouchableAreasItemView paramLargeTouchableAreasItemView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104104);
    paramView = this.egC;
    if (!LargeTouchableAreasItemView.a(this.egC)) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setItemViewSelected(bool);
      if (LargeTouchableAreasItemView.b(this.egC) != null)
      {
        LargeTouchableAreasItemView.b(this.egC);
        LargeTouchableAreasItemView.a(this.egC);
      }
      AppMethodBeat.o(104104);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView.1
 * JD-Core Version:    0.7.0.1
 */