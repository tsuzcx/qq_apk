package com.tencent.mm.plugin.chatroom.a;

import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract List<String> Ps(String paramString);
  
  public abstract int Pu(String paramString);
  
  public abstract boolean Px(String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, xm paramxm, String paramString3, com.tencent.mm.k.a.a.a parama, IEvent paramIEvent);
  
  public abstract boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2);
  
  public abstract String am(List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */