package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final int iAg;
  public final String oYi;
  public final int oYj;
  public final int oYk;
  public final int oYl;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.oYi = paramString;
    this.oYj = paramInt1;
    this.iAg = paramInt2;
    this.oYk = paramInt3;
    this.oYl = paramInt4;
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
      if ((this.oYj == paramObject.oYj) && (this.iAg == paramObject.iAg) && (this.oYk == paramObject.oYk) && (this.oYl == paramObject.oYl) && (this.oYi.equals(paramObject.oYi)))
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
    String str = "GetChatRoomMsgInfo chatroomId[" + this.oYi + "], filterSeq[" + this.oYj + "], msgSeq[" + this.iAg + "], needCount[" + this.oYk + "], upDownFlag[" + this.oYl + "], hash[" + hashCode() + "]";
    AppMethodBeat.o(116464);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */