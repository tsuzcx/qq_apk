package com.tencent.mobileqq.data;

import com.tencent.biz.pubaccount.util.PAMessageUtil;

public class MessageForPubAccount
  extends ChatMessage
{
  public static String lolaExtra_FriendUin = "LOLAINFO_FRIENDUIN";
  public static String lolaExtra_SelfUin = "LOLAINFO_SELFUIN";
  public static String lolaExtra_ShowTime = "LOLAEXTRA_SHOWTIME";
  public static String lolaExtra_Uuid = "LOLAINFO_UUID";
  public PAMessage mPAMessage = null;
  public int pa_op;
  public long pa_time;
  public long pa_uuid;
  
  protected void doParse()
  {
    try
    {
      this.mPAMessage = PAMessageUtil.a(this.msgData);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void prewrite()
  {
    if (this.mPAMessage != null) {}
    try
    {
      this.msgData = PAMessageUtil.a(this.mPAMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPubAccount
 * JD-Core Version:    0.7.0.1
 */