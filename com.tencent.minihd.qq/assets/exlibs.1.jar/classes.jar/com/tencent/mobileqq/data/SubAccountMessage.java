package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.util.Utils;
import java.io.UnsupportedEncodingException;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="subUin,senderuin,time")
public class SubAccountMessage
  extends Entity
  implements Comparable
{
  public int extInt;
  public int extLong;
  public String extStr;
  public int extraflag;
  public String frienduin;
  public boolean isValid = true;
  public boolean isread;
  public int issend;
  public int istroop;
  public int longMsgCount;
  public int longMsgId;
  public int longMsgIndex;
  @notColumn
  public CharSequence mEmoRecentMsg;
  @notColumn
  public String mTimeString;
  @notColumn
  public String msg;
  public byte[] msgData;
  public long msgUid;
  public long msgseq;
  public int msgtype;
  @notColumn
  public boolean needNotify;
  public String selfuin;
  public String sendername;
  public String senderuin;
  public long shmsgseq;
  public String subUin;
  public long time;
  public long uniseq;
  public int unreadNum = 0;
  public long vipBubbleID;
  
  public static SubAccountMessage clone(SubAccountMessage paramSubAccountMessage)
  {
    SubAccountMessage localSubAccountMessage = new SubAccountMessage();
    localSubAccountMessage.subUin = paramSubAccountMessage.subUin;
    localSubAccountMessage.selfuin = paramSubAccountMessage.selfuin;
    localSubAccountMessage.frienduin = paramSubAccountMessage.frienduin;
    localSubAccountMessage.sendername = paramSubAccountMessage.sendername;
    localSubAccountMessage.senderuin = paramSubAccountMessage.senderuin;
    localSubAccountMessage.time = paramSubAccountMessage.time;
    localSubAccountMessage.msgtype = paramSubAccountMessage.msgtype;
    localSubAccountMessage.msg = paramSubAccountMessage.msg;
    localSubAccountMessage.isread = paramSubAccountMessage.isread;
    localSubAccountMessage.isValid = paramSubAccountMessage.isValid;
    localSubAccountMessage.msgData = paramSubAccountMessage.msgData;
    localSubAccountMessage.extInt = paramSubAccountMessage.extInt;
    localSubAccountMessage.extLong = paramSubAccountMessage.extInt;
    localSubAccountMessage.extraflag = paramSubAccountMessage.extraflag;
    localSubAccountMessage.extStr = paramSubAccountMessage.extStr;
    localSubAccountMessage.longMsgCount = paramSubAccountMessage.longMsgCount;
    localSubAccountMessage.longMsgId = paramSubAccountMessage.longMsgId;
    localSubAccountMessage.longMsgIndex = paramSubAccountMessage.longMsgIndex;
    localSubAccountMessage.msgseq = paramSubAccountMessage.msgseq;
    localSubAccountMessage.shmsgseq = paramSubAccountMessage.shmsgseq;
    localSubAccountMessage.uniseq = paramSubAccountMessage.uniseq;
    localSubAccountMessage.unreadNum = paramSubAccountMessage.unreadNum;
    localSubAccountMessage.vipBubbleID = paramSubAccountMessage.vipBubbleID;
    localSubAccountMessage.istroop = paramSubAccountMessage.istroop;
    return localSubAccountMessage;
  }
  
  public int compareTo(SubAccountMessage paramSubAccountMessage)
  {
    if (paramSubAccountMessage == null) {
      return 0;
    }
    return (int)(paramSubAccountMessage.time - this.time);
  }
  
  public String getTableName()
  {
    return super.getTableName();
  }
  
  protected void postRead()
  {
    try
    {
      this.msg = new String(this.msgData, "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  protected void prewrite()
  {
    if (this.msg != null) {}
    try
    {
      this.msgData = this.msg.getBytes("UTF-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubAccountMessage");
    localStringBuilder.append(",subUin:").append(this.subUin).append(",selfUin:").append(this.selfuin).append(",friendUin:").append(this.frienduin).append(",senderUin:").append(this.senderuin).append(",senderName:").append(this.sendername).append(",time:").append(this.time).append(",isRead:").append(this.isread).append(",msgType:").append(this.msgtype).append(",msg:").append(Utils.a(this.msg));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SubAccountMessage
 * JD-Core Version:    0.7.0.1
 */