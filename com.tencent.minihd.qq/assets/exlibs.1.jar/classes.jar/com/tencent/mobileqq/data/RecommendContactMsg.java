package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.notColumn;

public class RecommendContactMsg
{
  public static final int STATUS_EMPTY = 0;
  public static final int STATUS_FRIEND = 2;
  public static final int STATUS_REQUESTED = 1;
  public String contactName;
  public short faceid;
  @notColumn
  public int friendStatus;
  public int groupId = -1;
  public boolean isRead;
  public String mobileCode;
  public String mobileNo;
  public String nationCode;
  public String nickName;
  public long originBinder;
  public String source = "";
  public long timeStamp;
  public String uin;
  public long uniseq;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendContactMsg
 * JD-Core Version:    0.7.0.1
 */