package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

final class RoomAnnouncementUI$2
  extends ac
{
  RoomAnnouncementUI$2(RoomAnnouncementUI paramRoomAnnouncementUI) {}
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(12684);
    if (paramString.equals("weixin://chatroom/upgradeagree"))
    {
      b.a(this.gxN, RoomAnnouncementUI.b(this.gxN), RoomAnnouncementUI.c(this.gxN));
      AppMethodBeat.o(12684);
      return true;
    }
    AppMethodBeat.o(12684);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI.2
 * JD-Core Version:    0.7.0.1
 */