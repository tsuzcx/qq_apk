package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class NearbyRecommendTroop
  extends Entity
{
  public String intro;
  public boolean isRead;
  public int memberNum;
  public String name;
  public int troopType;
  @unique
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.NearbyRecommendTroop
 * JD-Core Version:    0.7.0.1
 */