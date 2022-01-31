package com.tencent.mm.chatroom.ui;

import com.tencent.mm.storage.ad;

final class SeeRoomMemberUI$a
{
  ad contact;
  int order = 0;
  int type;
  
  public SeeRoomMemberUI$a(int paramInt)
  {
    this.type = paramInt;
    this.contact = null;
  }
  
  public SeeRoomMemberUI$a(ad paramad, int paramInt)
  {
    this.type = 1;
    this.contact = paramad;
    this.order = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.a
 * JD-Core Version:    0.7.0.1
 */