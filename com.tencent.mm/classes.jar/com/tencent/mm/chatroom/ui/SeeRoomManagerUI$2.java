package com.tencent.mm.chatroom.ui;

import android.content.res.Resources;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SeeRoomManagerUI$2
  implements Runnable
{
  SeeRoomManagerUI$2(SeeRoomManagerUI paramSeeRoomManagerUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104283);
    int j = (int)(this.eiP.getResources().getDimension(2131427500) + this.eiP.getResources().getDimension(2131427800) + this.eiP.getResources().getDimension(2131427860));
    int i = j;
    if (SeeRoomManagerUI.a(this.eiP).getCount() / 4 > 0) {
      i = j * (SeeRoomManagerUI.a(this.eiP).getCount() / 4 + 1);
    }
    SeeRoomManagerUI.b(this.eiP).setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.b(this.eiP).getWidth(), i));
    AppMethodBeat.o(104283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.2
 * JD-Core Version:    0.7.0.1
 */