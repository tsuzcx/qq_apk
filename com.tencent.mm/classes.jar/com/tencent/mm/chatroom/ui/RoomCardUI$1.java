package com.tencent.mm.chatroom.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;

final class RoomCardUI$1
  implements g
{
  RoomCardUI$1(RoomCardUI paramRoomCardUI) {}
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(156631);
    if (paramInt > 0)
    {
      localViewGroup = (ViewGroup)this.ehp.findViewById(2131824115);
      localLayoutParams = localViewGroup.getLayoutParams();
      if (-1 == localLayoutParams.height)
      {
        localLayoutParams.width = -1;
        localLayoutParams.height = (localViewGroup.getHeight() - paramInt);
        localViewGroup.requestLayout();
      }
      AppMethodBeat.o(156631);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.ehp.findViewById(2131824115);
    ViewGroup.LayoutParams localLayoutParams = localViewGroup.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localViewGroup.requestLayout();
    AppMethodBeat.o(156631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.1
 * JD-Core Version:    0.7.0.1
 */