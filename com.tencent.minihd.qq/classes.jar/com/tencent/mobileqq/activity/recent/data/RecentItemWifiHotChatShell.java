package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemWifiHotChatShell
  extends RecentUserBaseData
{
  public RecentItemWifiHotChatShell(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)paramQQAppInterface.getManager(58)).a();
    MsgSummary localMsgSummary = new MsgSummary();
    if (localHotChatInfo != null)
    {
      this.B = 0;
      this.jdField_a_of_type_JavaLangString = localHotChatInfo.name;
      if (localHotChatInfo.memberCount >= 2)
      {
        localMsgSummary.b = ("" + localHotChatInfo.memberCount + "人正在热聊，点击加入吧！");
        this.jdField_a_of_type_JavaLangCharSequence = "热聊";
      }
    }
    for (this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;; this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime)
    {
      a(paramQQAppInterface, paramContext, localMsgSummary);
      return;
      localMsgSummary.b = "速度抢沙发，马上开始热聊！";
      break;
      localMsgSummary.b = "正在加载热聊信息。。。";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemWifiHotChatShell
 * JD-Core Version:    0.7.0.1
 */