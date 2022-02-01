package com.tencent.biz.pubaccount.troopbarassit;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopBarData
  extends Entity
{
  public long mLastDraftTime;
  public long mLastMsgTime;
  @unique
  public String mUin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarData
 * JD-Core Version:    0.7.0.1
 */