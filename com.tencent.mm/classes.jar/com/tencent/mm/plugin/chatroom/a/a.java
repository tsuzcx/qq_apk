package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public final int gaE;
  public final String kEm;
  public final int kEn;
  public final int kEo;
  public final int kEp;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.kEm = paramString;
    this.kEn = paramInt1;
    this.gaE = paramInt2;
    this.kEo = paramInt3;
    this.kEp = paramInt4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(128346);
    if (hashCode() == paramObject.hashCode())
    {
      AppMethodBeat.o(128346);
      return true;
    }
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((this.kEn == paramObject.kEn) && (this.gaE == paramObject.gaE) && (this.kEo == paramObject.kEo) && (this.kEp == paramObject.kEp) && (this.kEm.equals(paramObject.kEm)))
      {
        AppMethodBeat.o(128346);
        return true;
      }
      AppMethodBeat.o(128346);
      return false;
    }
    AppMethodBeat.o(128346);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128347);
    String str = "GetChatRoomMsgInfo chatroomId[" + this.kEm + "], filterSeq[" + this.kEn + "], msgSeq[" + this.gaE + "], needCount[" + this.kEo + "], upDownFlag[" + this.kEp + "], hash[" + hashCode() + "]";
    AppMethodBeat.o(128347);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */