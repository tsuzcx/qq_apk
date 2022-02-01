package com.tencent.mm.plugin.chatroom.a;

import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract List<String> Il(String paramString);
  
  public abstract boolean Iq(String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, zg paramzg, String paramString3, com.tencent.mm.h.a.a.a parama, IEvent paramIEvent);
  
  public abstract boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2);
  
  public abstract String f(List<String> paramList, String paramString);
  
  public abstract int getMembersCountByChatRoomName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */