package com.tencent.mobileqq.app;

import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;

public class HotChatRecentUserMgr
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    RecentUser localRecentUser = paramQQAppInterface.a(AppConstants.aq, 1);
    if (localRecentUser != null) {
      paramQQAppInterface.b(localRecentUser);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, HotChatInfo paramHotChatInfo)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1);
    if (paramString == null)
    {
      paramQQAppInterface.a(HotChatInfo.createRecentUser(paramHotChatInfo, false));
      return;
    }
    paramString.troopUin = paramHotChatInfo.troopUin;
    paramString.uin = paramHotChatInfo.troopUin;
    paramQQAppInterface.a(paramString);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(1009));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatRecentUserMgr
 * JD-Core Version:    0.7.0.1
 */