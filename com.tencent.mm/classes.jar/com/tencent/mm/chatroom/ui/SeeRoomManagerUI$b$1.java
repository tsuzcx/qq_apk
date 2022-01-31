package com.tencent.mm.chatroom.ui;

import android.content.res.Resources;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SeeRoomManagerUI$b$1
  implements Runnable
{
  SeeRoomManagerUI$b$1(SeeRoomManagerUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(104287);
    int j = (int)(this.eiR.eiP.getResources().getDimension(2131427500) + this.eiR.eiP.getResources().getDimension(2131427800) + this.eiR.eiP.getResources().getDimension(2131427860));
    int i = j;
    if (SeeRoomManagerUI.a(this.eiR.eiP).getCount() / 4 > 0) {
      i = j * (SeeRoomManagerUI.a(this.eiR.eiP).getCount() / 4 + 1);
    }
    SeeRoomManagerUI.b(this.eiR.eiP).setLayoutParams(new LinearLayout.LayoutParams(SeeRoomManagerUI.b(this.eiR.eiP).getWidth(), i));
    AppMethodBeat.o(104287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.b.1
 * JD-Core Version:    0.7.0.1
 */