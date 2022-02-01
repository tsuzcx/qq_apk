package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final int jvu;
  public final String qnh;
  public final int qni;
  public final int qnj;
  public final int qnk;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.qnh = paramString;
    this.qni = paramInt1;
    this.jvu = paramInt2;
    this.qnj = paramInt3;
    this.qnk = paramInt4;
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
      if ((this.qni == paramObject.qni) && (this.jvu == paramObject.jvu) && (this.qnj == paramObject.qnj) && (this.qnk == paramObject.qnk) && (this.qnh.equals(paramObject.qnh)))
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
    String str = "GetChatRoomMsgInfo chatroomId[" + this.qnh + "], filterSeq[" + this.qni + "], msgSeq[" + this.jvu + "], needCount[" + this.qnj + "], upDownFlag[" + this.qnk + "], hash[" + hashCode() + "]";
    AppMethodBeat.o(116464);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */