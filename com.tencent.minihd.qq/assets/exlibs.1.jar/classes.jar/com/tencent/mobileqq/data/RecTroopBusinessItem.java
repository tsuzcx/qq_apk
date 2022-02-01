package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RecTroopBusinessItem
  extends Entity
{
  public String btnText;
  public String des;
  public long endTime;
  public String iconUrl;
  @unique
  public String id;
  public String jumpParam;
  public int jumpType;
  public String jumpUrl;
  public long startTime;
  public long timeStamp;
  public String title;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecTroopBusinessItem
 * JD-Core Version:    0.7.0.1
 */