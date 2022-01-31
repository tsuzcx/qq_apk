package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;

final class RoomAnnouncementUI$2
  extends w
{
  RoomAnnouncementUI$2(RoomAnnouncementUI paramRoomAnnouncementUI) {}
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(104138);
    if (paramString.equals("weixin://chatroom/upgradeagree"))
    {
      b.a(this.egR, RoomAnnouncementUI.b(this.egR), RoomAnnouncementUI.c(this.egR));
      AppMethodBeat.o(104138);
      return true;
    }
    AppMethodBeat.o(104138);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI.2
 * JD-Core Version:    0.7.0.1
 */