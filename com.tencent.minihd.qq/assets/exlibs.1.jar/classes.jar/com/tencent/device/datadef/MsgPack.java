package com.tencent.device.datadef;

import java.io.Serializable;

public class MsgPack
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean bIsSelf;
  public boolean bSendResult;
  public byte[] buffer;
  public int dwMsgSequence;
  public int length;
  public String strText;
  public long uSendUin;
  
  public void initRawMsg(int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    this.dwMsgSequence = paramInt1;
    this.uSendUin = paramLong;
    this.buffer = paramArrayOfByte;
    this.length = paramInt2;
  }
  
  public void initReceivedMsg(int paramInt, long paramLong, String paramString)
  {
    this.dwMsgSequence = paramInt;
    this.uSendUin = paramLong;
    this.strText = paramString;
  }
  
  public void initSendMsgResult(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.dwMsgSequence = paramInt;
    this.uSendUin = paramLong;
    this.bSendResult = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.datadef.MsgPack
 * JD-Core Version:    0.7.0.1
 */