package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class LargeTouchableAreasItemView$1
  implements View.OnClickListener
{
  LargeTouchableAreasItemView$1(LargeTouchableAreasItemView paramLargeTouchableAreasItemView) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.dpg;
    if (!LargeTouchableAreasItemView.a(this.dpg)) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setItemViewSelected(bool);
      if (LargeTouchableAreasItemView.b(this.dpg) != null)
      {
        LargeTouchableAreasItemView.b(this.dpg);
        LargeTouchableAreasItemView.a(this.dpg);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView.1
 * JD-Core Version:    0.7.0.1
 */