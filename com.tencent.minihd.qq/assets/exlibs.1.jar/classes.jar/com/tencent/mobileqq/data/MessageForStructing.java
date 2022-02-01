package com.tencent.mobileqq.data;

import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;

public class MessageForStructing
  extends ChatMessage
{
  public AbsStructMsg structingMsg;
  
  public MessageForStructing() {}
  
  public MessageForStructing(MessageRecord paramMessageRecord)
  {
    this.extInt = paramMessageRecord.extInt;
    this.extLong = paramMessageRecord.extLong;
    this.extraflag = paramMessageRecord.extraflag;
    this.extStr = paramMessageRecord.extStr;
    this.frienduin = paramMessageRecord.frienduin;
    this.isread = paramMessageRecord.isread;
    this.issend = paramMessageRecord.issend;
    this.istroop = paramMessageRecord.istroop;
    this.isValid = paramMessageRecord.isValid;
    this.longMsgCount = paramMessageRecord.longMsgCount;
    this.longMsgId = paramMessageRecord.longMsgId;
    this.longMsgIndex = paramMessageRecord.longMsgIndex;
    this.msg = paramMessageRecord.msg;
    this.msgData = paramMessageRecord.msgData;
    this.msgseq = paramMessageRecord.msgseq;
    this.msgtype = paramMessageRecord.msgtype;
    this.msgUid = paramMessageRecord.msgUid;
    this.selfuin = paramMessageRecord.selfuin;
    this.senderuin = paramMessageRecord.senderuin;
    this.sendFailCode = paramMessageRecord.sendFailCode;
    this.shmsgseq = paramMessageRecord.shmsgseq;
    this.time = paramMessageRecord.time;
    this.uniseq = paramMessageRecord.uniseq;
    this.versionCode = paramMessageRecord.versionCode;
    this.vipBubbleID = paramMessageRecord.vipBubbleID;
    this.structingMsg = StructMsgFactory.a(this.msgData);
  }
  
  protected void doParse()
  {
    this.structingMsg = StructMsgFactory.a(this.msgData);
  }
  
  protected void prewrite()
  {
    if (this.structingMsg != null) {}
    try
    {
      this.msgData = this.structingMsg.getBytes();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForStructing
 * JD-Core Version:    0.7.0.1
 */