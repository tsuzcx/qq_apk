package com.tencent.mm.chatroom.ui;

import android.os.Build.VERSION;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SeeRoomMemberUI$1
  implements Runnable
{
  SeeRoomMemberUI$1(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104308);
    if (Build.VERSION.SDK_INT >= 19)
    {
      SeeRoomMemberUI.b(this.eja).scrollListBy(SeeRoomMemberUI.a(this.eja));
      AppMethodBeat.o(104308);
      return;
    }
    GridView localGridView = SeeRoomMemberUI.b(this.eja);
    int i = -SeeRoomMemberUI.a(this.eja);
    int j = -SeeRoomMemberUI.a(this.eja);
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Integer.TYPE;
    SeeRoomMemberUI.a(localGridView, "trackMotionScroll", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }, new Class[] { localClass1, localClass2 });
    AppMethodBeat.o(104308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.1
 * JD-Core Version:    0.7.0.1
 */