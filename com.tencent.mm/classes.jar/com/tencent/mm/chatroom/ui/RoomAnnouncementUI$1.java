package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.p;

final class RoomAnnouncementUI$1
  extends p
{
  RoomAnnouncementUI$1(RoomAnnouncementUI paramRoomAnnouncementUI) {}
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(104137);
    h.a(this.egR, paramString2, null, new RoomAnnouncementUI.1.1(this));
    paramj.cancel();
    AppMethodBeat.o(104137);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI.1
 * JD-Core Version:    0.7.0.1
 */