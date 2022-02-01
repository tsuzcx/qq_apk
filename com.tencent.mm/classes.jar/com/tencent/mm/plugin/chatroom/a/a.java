package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final int idS;
  public final String ool;
  public final int oom;
  public final int oon;
  public final int ooo;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ool = paramString;
    this.oom = paramInt1;
    this.idS = paramInt2;
    this.oon = paramInt3;
    this.ooo = paramInt4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(116463);
    if (hashCode() == paramObject.hashCode())
    {
      AppMethodBeat.o(116463);
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((this.oom == paramObject.oom) && (this.idS == paramObject.idS) && (this.oon == paramObject.oon) && (this.ooo == paramObject.ooo) && (this.ool.equals(paramObject.ool)))
      {
        AppMethodBeat.o(116463);
        return true;
      }
      AppMethodBeat.o(116463);
      return false;
    }
    AppMethodBeat.o(116463);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(116464);
    String str = "GetChatRoomMsgInfo chatroomId[" + this.ool + "], filterSeq[" + this.oom + "], msgSeq[" + this.idS + "], needCount[" + this.oon + "], upDownFlag[" + this.ooo + "], hash[" + hashCode() + "]";
    AppMethodBeat.o(116464);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */