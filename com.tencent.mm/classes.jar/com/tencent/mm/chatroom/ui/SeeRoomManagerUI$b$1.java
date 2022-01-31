package com.tencent.mm.chatroom.ui;

import android.content.res.Resources;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;

final class SeeRoomManagerUI$b$1
  implements Runnable
{
  SeeRoomManagerUI$b$1(SeeRoomManagerUI.b paramb) {}
  
  public final void run()
  {
    int j = (int)(this.drj.drh.getResources().getDimension(a.c.BigPadding) + this.drj.drh.getResources().getDimension(a.c.NormalAvatarSize) + this.drj.drh.getResources().getDimension(a.c.SmallerTextSize));
    int i = j;
    if (SeeRoomManagerUI.a(this.drj.drh).getCount() / 4 > 0) {
      i = j * (SeeRoomManagerUI.a(this.drj.drh).getCount() / 4 + 1);
    }
    SeeRoomManagerUI.b(this.drj.drh).setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.b(this.drj.drh).getWidth(), i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.b.1
 * JD-Core Version:    0.7.0.1
 */