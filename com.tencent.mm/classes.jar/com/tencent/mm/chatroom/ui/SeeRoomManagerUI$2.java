package com.tencent.mm.chatroom.ui;

import android.content.res.Resources;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;

final class SeeRoomManagerUI$2
  implements Runnable
{
  SeeRoomManagerUI$2(SeeRoomManagerUI paramSeeRoomManagerUI) {}
  
  public final void run()
  {
    int j = (int)(this.drh.getResources().getDimension(a.c.BigPadding) + this.drh.getResources().getDimension(a.c.NormalAvatarSize) + this.drh.getResources().getDimension(a.c.SmallerTextSize));
    int i = j;
    if (SeeRoomManagerUI.a(this.drh).getCount() / 4 > 0) {
      i = j * (SeeRoomManagerUI.a(this.drh).getCount() / 4 + 1);
    }
    SeeRoomManagerUI.b(this.drh).setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.b(this.drh).getWidth(), i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.2
 * JD-Core Version:    0.7.0.1
 */