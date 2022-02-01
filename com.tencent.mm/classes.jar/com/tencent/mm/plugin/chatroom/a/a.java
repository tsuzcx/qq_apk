package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final int ixn;
  public final String oRG;
  public final int oRH;
  public final int oRI;
  public final int oRJ;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.oRG = paramString;
    this.oRH = paramInt1;
    this.ixn = paramInt2;
    this.oRI = paramInt3;
    this.oRJ = paramInt4;
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
      if ((this.oRH == paramObject.oRH) && (this.ixn == paramObject.ixn) && (this.oRI == paramObject.oRI) && (this.oRJ == paramObject.oRJ) && (this.oRG.equals(paramObject.oRG)))
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
    String str = "GetChatRoomMsgInfo chatroomId[" + this.oRG + "], filterSeq[" + this.oRH + "], msgSeq[" + this.ixn + "], needCount[" + this.oRI + "], upDownFlag[" + this.oRJ + "], hash[" + hashCode() + "]";
    AppMethodBeat.o(116464);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */