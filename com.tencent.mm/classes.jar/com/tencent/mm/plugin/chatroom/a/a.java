package com.tencent.mm.plugin.chatroom.a;

public final class a
{
  public final int eKX;
  public final String iBe;
  public final int iBf;
  public final int iBg;
  public final int iBh;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iBe = paramString;
    this.iBf = paramInt1;
    this.eKX = paramInt2;
    this.iBg = paramInt3;
    this.iBh = paramInt4;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (hashCode() == paramObject.hashCode()) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        break;
      }
      paramObject = (a)paramObject;
    } while ((this.iBf == paramObject.iBf) && (this.eKX == paramObject.eKX) && (this.iBg == paramObject.iBg) && (this.iBh == paramObject.iBh) && (this.iBe.equals(paramObject.iBe)));
    return false;
    return false;
  }
  
  public final String toString()
  {
    return "GetChatRoomMsgInfo chatroomId[" + this.iBe + "], filterSeq[" + this.iBf + "], msgSeq[" + this.eKX + "], needCount[" + this.iBg + "], upDownFlag[" + this.iBh + "], hash[" + hashCode() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.a.a
 * JD-Core Version:    0.7.0.1
 */