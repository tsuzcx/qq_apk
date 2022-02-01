package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.activity.flaotaio.FloatAioController.HongbaoMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.notColumn;

public class QQMessageFacade$Message
  extends MessageRecord
{
  public String actMsgContentValue;
  public String action = null;
  public int bizType = -1;
  public int counter = 0;
  public CharSequence emoRecentMsg;
  public long fileSize = -1L;
  public int fileType = -1;
  public boolean hasReply;
  @notColumn
  public FloatAioController.HongbaoMsg hbMsg;
  @notColumn
  public boolean isCacheValid = true;
  public Boolean isInWhisper = Boolean.valueOf(false);
  public String latestNormalMsgString;
  public String nickName = null;
  public String pttUrl;
  public long shareAppID;
  @Deprecated
  public int unReadNum;
  
  public void cleanMessageRecordBaseField()
  {
    this.msg = null;
    this.emoRecentMsg = null;
    this.fileType = -1;
  }
  
  protected Class getClassForTable()
  {
    return Message.class;
  }
  
  public CharSequence getMessageText()
  {
    if (this.emoRecentMsg == null) {
      return this.msg;
    }
    return this.emoRecentMsg;
  }
  
  public boolean needNotification()
  {
    return (this.bizType == 4) || (this.bizType == 3) || (this.bizType == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade.Message
 * JD-Core Version:    0.7.0.1
 */