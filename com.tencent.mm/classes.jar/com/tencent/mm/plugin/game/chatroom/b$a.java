package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  static
  {
    AppMethodBeat.i(210948);
    CrL = new a("KEEP_ALIVE_TYPE_RECEIVE_CHATROOM_MSG", 0);
    CrM = new a("KEEP_ALIVE_TYPE_GET_CHATROOM_REALTIME_INFO", 1);
    CrN = new a("KEEP_ALIVE_TYPE_GET_MY_CHAT_ROOM", 2);
    CrO = new a[] { CrL, CrM, CrN };
    AppMethodBeat.o(210948);
  }
  
  private b$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.b.a
 * JD-Core Version:    0.7.0.1
 */