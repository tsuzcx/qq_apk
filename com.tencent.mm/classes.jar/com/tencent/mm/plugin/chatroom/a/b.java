package com.tencent.mm.plugin.chatroom.a;

import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public abstract interface b
  extends com.tencent.mm.kernel.c.a
{
  public abstract List<String> Ic(String paramString);
  
  public abstract int Ie(String paramString);
  
  public abstract boolean Ih(String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, xg paramxg, String paramString3, com.tencent.mm.k.a.a.a parama, IEvent paramIEvent);
  
  public abstract boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2);
  
  public abstract String ao(List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.b
 * JD-Core Version:    0.7.0.1
 */