package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class SystemMsgOldData
  extends Entity
{
  public long msgtime;
  @unique
  public long uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SystemMsgOldData
 * JD-Core Version:    0.7.0.1
 */