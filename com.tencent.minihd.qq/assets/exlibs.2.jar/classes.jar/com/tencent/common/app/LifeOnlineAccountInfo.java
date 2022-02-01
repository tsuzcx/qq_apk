package com.tencent.common.app;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.service.message.MessageCache;

public class LifeOnlineAccountInfo
  extends Entity
{
  public static final int PRE_MSG_DELETED = 2;
  public static final int PRE_MSG_EXPIRED = 3;
  public static final int PRE_MSG_NORMAL = 1;
  public static final String QUERY_TABLE_FIELDS = "msgid,frienduin,selfuin, isPullRoam, needNofityConversation,isProxyMsg,  objdata, timestamp, showtime,pstate,uniseq";
  public static final String[] QUERY_TABLE_FIELDS_ARRAY = { "msgid", "frienduin", "isPullRoam", "needNofityConversation", "isProxyMsg", "objdata", "timestamp", "showtime", "pstate", "uniseq" };
  public String frienduin;
  public boolean isProxyMsg;
  public boolean isPullRoam;
  public long msgid;
  public boolean needNofityConversation;
  public byte[] objdata;
  public int pstate;
  public String selfuin;
  public long showtime;
  public long timestamp;
  @unique
  public long uniseq;
  
  public static String getTableNewName()
  {
    return "PreSendMsg_New";
  }
  
  public String getFriendUin()
  {
    return this.frienduin;
  }
  
  public boolean getIsProxyMsg()
  {
    return this.isProxyMsg;
  }
  
  public boolean getIsPullRoam()
  {
    return this.isPullRoam;
  }
  
  public String getMsgid()
  {
    return String.valueOf(this.msgid);
  }
  
  public boolean getNeedNofityConversation()
  {
    return this.needNofityConversation;
  }
  
  public byte[] getObjData()
  {
    return this.objdata;
  }
  
  public String getSelfUin()
  {
    return this.selfuin;
  }
  
  public String getShowtime()
  {
    return String.valueOf(this.showtime);
  }
  
  public int getState()
  {
    return this.pstate;
  }
  
  public String getTableName()
  {
    return getTableNewName();
  }
  
  public String getTimeStamp()
  {
    return String.valueOf(this.timestamp);
  }
  
  public long getuniseq()
  {
    return this.uniseq;
  }
  
  public void init(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, long paramLong3, int paramInt, long paramLong4)
  {
    this.msgid = paramLong1;
    paramLong1 = paramLong2;
    if (paramLong2 <= 0L) {
      paramLong1 = (int)MessageCache.a();
    }
    this.showtime = paramLong1;
    this.selfuin = paramString1;
    this.frienduin = paramString2;
    this.isPullRoam = paramBoolean1;
    this.needNofityConversation = paramBoolean2;
    this.isProxyMsg = paramBoolean3;
    this.objdata = paramArrayOfByte;
    this.timestamp = paramLong3;
    this.pstate = paramInt;
    this.uniseq = paramLong4;
  }
  
  protected void prewrite()
  {
    super.prewrite();
  }
  
  public String toString()
  {
    new StringBuilder("-----Dump LifeOnlineAccountInfo-----").append(",classname:").append(getClass().getSimpleName()).append(",frienduin:").append(this.frienduin).append(",msgid:").append(this.msgid).append(",isProxyMsg:").append(this.isProxyMsg).append(",isPullRoam:").append(this.isPullRoam).append(",needNofityConversation:").append(this.needNofityConversation).append(",objdata:").append(this.objdata.length).append(",timestamp:").append(this.timestamp).append(",showtime:").append(this.showtime).append(",pstate:").append(this.pstate).append(",uniseq:").append(this.uniseq);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.common.app.LifeOnlineAccountInfo
 * JD-Core Version:    0.7.0.1
 */