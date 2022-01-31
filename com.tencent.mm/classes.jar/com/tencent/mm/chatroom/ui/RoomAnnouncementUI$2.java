package com.tencent.mm.chatroom.ui;

import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class RoomAnnouncementUI$2
  extends p
{
  RoomAnnouncementUI$2(RoomAnnouncementUI paramRoomAnnouncementUI) {}
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    if (paramString.equals("weixin://chatroom/upgradeagree"))
    {
      b.a(this.dpv, RoomAnnouncementUI.b(this.dpv), RoomAnnouncementUI.c(this.dpv));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAnnouncementUI.2
 * JD-Core Version:    0.7.0.1
 */