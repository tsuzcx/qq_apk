package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final int hDq;
  public final String nLl;
  public final int nLm;
  public final int nLn;
  public final int nLo;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.nLl = paramString;
    this.nLm = paramInt1;
    this.hDq = paramInt2;
    this.nLn = paramInt3;
    this.nLo = paramInt4;
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
      if ((this.nLm == paramObject.nLm) && (this.hDq == paramObject.hDq) && (this.nLn == paramObject.nLn) && (this.nLo == paramObject.nLo) && (this.nLl.equals(paramObject.nLl)))
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
    String str = "GetChatRoomMsgInfo chatroomId[" + this.nLl + "], filterSeq[" + this.nLm + "], msgSeq[" + this.hDq + "], needCount[" + this.nLn + "], upDownFlag[" + this.nLo + "], hash[" + hashCode() + "]";
    AppMethodBeat.o(116464);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */