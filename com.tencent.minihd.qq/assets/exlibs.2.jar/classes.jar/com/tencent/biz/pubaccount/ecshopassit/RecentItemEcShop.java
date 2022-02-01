package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem;
import com.tencent.mobileqq.data.PubAccountAssistantData;

public class RecentItemEcShop
  extends RecentPubAccountAssistantItem
{
  public RecentItemEcShop(EcShopData paramEcShopData)
  {
    super(a(paramEcShopData));
  }
  
  protected static PubAccountAssistantData a(EcShopData paramEcShopData)
  {
    PubAccountAssistantData localPubAccountAssistantData = new PubAccountAssistantData();
    localPubAccountAssistantData.mUin = paramEcShopData.mUin;
    localPubAccountAssistantData.mLastDraftTime = paramEcShopData.mLastDraftTime;
    localPubAccountAssistantData.mLastMsgTime = paramEcShopData.mLastMsgTime;
    return localPubAccountAssistantData;
  }
  
  public int a()
  {
    return 1008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop
 * JD-Core Version:    0.7.0.1
 */