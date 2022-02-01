package com.tencent.biz.pubaccount.troopbarassit;

import com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem;
import com.tencent.mobileqq.data.PubAccountAssistantData;

public class RecentItemTroopBar
  extends RecentPubAccountAssistantItem
{
  public RecentItemTroopBar(TroopBarData paramTroopBarData)
  {
    super(a(paramTroopBarData));
  }
  
  protected static PubAccountAssistantData a(TroopBarData paramTroopBarData)
  {
    PubAccountAssistantData localPubAccountAssistantData = new PubAccountAssistantData();
    localPubAccountAssistantData.mUin = paramTroopBarData.mUin;
    localPubAccountAssistantData.mLastDraftTime = paramTroopBarData.mLastDraftTime;
    localPubAccountAssistantData.mLastMsgTime = paramTroopBarData.mLastMsgTime;
    return localPubAccountAssistantData;
  }
  
  public int a()
  {
    return 1008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.RecentItemTroopBar
 * JD-Core Version:    0.7.0.1
 */