package com.tencent.mm.chatroom.ui;

import android.os.Build.VERSION;
import android.widget.GridView;

final class SeeRoomMemberUI$1
  implements Runnable
{
  SeeRoomMemberUI$1(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final void run()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      SeeRoomMemberUI.b(this.drs).scrollListBy(SeeRoomMemberUI.a(this.drs));
      return;
    }
    GridView localGridView = SeeRoomMemberUI.b(this.drs);
    int i = -SeeRoomMemberUI.a(this.drs);
    int j = -SeeRoomMemberUI.a(this.drs);
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Integer.TYPE;
    SeeRoomMemberUI.a(localGridView, "trackMotionScroll", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }, new Class[] { localClass1, localClass2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.1
 * JD-Core Version:    0.7.0.1
 */