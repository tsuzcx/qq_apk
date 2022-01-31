package com.tencent.mm.chatroom.ui;

import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

final class RoomAnnouncementUI$1
  extends j
{
  RoomAnnouncementUI$1(RoomAnnouncementUI paramRoomAnnouncementUI) {}
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    h.a(this.dpv, paramString2, null, new RoomAnnouncementUI.1.1(this));
    paramf.cancel();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI.1
 * JD-Core Version:    0.7.0.1
 */