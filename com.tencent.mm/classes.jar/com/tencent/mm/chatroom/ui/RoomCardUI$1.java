package com.tencent.mm.chatroom.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;

final class RoomCardUI$1
  implements g
{
  RoomCardUI$1(RoomCardUI paramRoomCardUI) {}
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(12691);
    if (paramInt > 0)
    {
      localViewGroup = (ViewGroup)this.gyl.findViewById(2131307339);
      localLayoutParams = localViewGroup.getLayoutParams();
      if (-1 == localLayoutParams.height)
      {
        localLayoutParams.width = -1;
        localLayoutParams.height = (localViewGroup.getHeight() - paramInt);
        localViewGroup.requestLayout();
      }
      AppMethodBeat.o(12691);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.gyl.findViewById(2131307339);
    ViewGroup.LayoutParams localLayoutParams = localViewGroup.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localViewGroup.requestLayout();
    AppMethodBeat.o(12691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.1
 * JD-Core Version:    0.7.0.1
 */