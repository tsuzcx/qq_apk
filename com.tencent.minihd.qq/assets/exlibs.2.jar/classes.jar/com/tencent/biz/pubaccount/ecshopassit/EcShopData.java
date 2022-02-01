package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class EcShopData
  extends Entity
{
  public long mLastDraftTime;
  public long mLastMsgTime;
  @unique
  public String mUin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopData
 * JD-Core Version:    0.7.0.1
 */