package com.tencent.mm.plugin.game.chatroom.b;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.List;
import java.util.Map;

public abstract interface b
  extends a
{
  public abstract void a(ChatroomUserData paramChatroomUserData);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(List<String> paramList, a parama);
  
  public abstract c aIN(String paramString);
  
  public abstract void l(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public abstract void m(MStorage.IOnStorageChange paramIOnStorageChange);
  
  public static abstract interface a
  {
    public abstract void ac(Map<String, c> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.b.b
 * JD-Core Version:    0.7.0.1
 */