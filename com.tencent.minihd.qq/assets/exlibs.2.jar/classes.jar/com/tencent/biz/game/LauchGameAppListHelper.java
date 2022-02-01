package com.tencent.biz.game;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class LauchGameAppListHelper
{
  public static final int a = -1;
  public static final String a = "https://youxi.vip.qq.com/imoj/applist.html";
  public static final int b = 100548090;
  public static final String b = "sessionInfo";
  public static final int c = 100548087;
  public static final String c = "indexOfFunnyFaceClickedInWebview";
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
    String str = paramSessionInfo.b;
    Object localObject2 = (GameCenterManagerImp)paramQQAppInterface.getManager(11);
    int i;
    int n;
    label90:
    int j;
    label98:
    int k;
    int m;
    if (localObject2 != null)
    {
      if (((GameCenterManagerImp)localObject2).a("999999.100004") != -1)
      {
        i = 1;
        n = i;
        switch (paramSessionInfo.jdField_a_of_type_Int)
        {
        default: 
          i = 1;
          if (i == 3) {
            j = 2;
          }
          break;
        }
      }
      for (;;)
      {
        if (paramSessionInfo.jdField_a_of_type_Int == 1) {}
        try
        {
          localObject2 = paramQQAppInterface.a();
          if (localObject2 == null) {
            break label599;
          }
          localObject2 = ((EntityManagerFactory)localObject2).createEntityManager().a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { localObject1 }, null, null, null, null);
          if (localObject2 == null) {
            break label289;
          }
          localObject2 = ((List)localObject2).iterator();
          k = 0;
          for (;;)
          {
            m = k;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            boolean bool = ChatActivityUtils.a((TroopMemberInfo)((Iterator)localObject2).next());
            if (!bool) {
              break label596;
            }
            k += 1;
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("LauchGameAppListHelper", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
            }
          }
        }
        catch (IllegalStateException paramQQAppInterface)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("LauchGameAppListHelper", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
              continue;
              k = 0;
              continue;
              continue;
              k = 0;
            }
          }
          j = 0;
        }
        i = 0;
        break;
        i = 1;
        break label90;
        i = 2;
        break label90;
        i = 3;
        break label90;
        if (i == 1)
        {
          localObject2 = ((FriendManager)paramQQAppInterface.getManager(8)).a((String)localObject1);
          if (localObject2 == null) {
            break label611;
          }
          j = ((TroopInfo)localObject2).wMemberNum;
        }
        else
        {
          label260:
          if (i != 2) {
            break label605;
          }
          j = ((FriendManager)paramQQAppInterface.getManager(8)).c((String)localObject1);
          continue;
          label289:
          m = 0;
          if ((j <= 1) || (m >= 6) || (m >= j)) {
            break label623;
          }
          paramQQAppInterface = (TroopHandler)paramQQAppInterface.a(19);
          if (paramQQAppInterface == null) {
            break label623;
          }
          paramQQAppInterface.a(Long.parseLong((String)localObject1));
          break label623;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LauchGameAppListHelper", 2, "localNum=" + k);
      }
      if (n != 0)
      {
        k = 1;
        paramQQAppInterface = "https://youxi.vip.qq.com/imoj/applist.html?sessionType=" + i + "&sessionId=" + (String)localObject1 + "&adtag=" + "client_entry" + "&personNum=" + j + "&gcode=" + str + "&isNew=" + k;
        localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramQQAppInterface);
        ((Intent)localObject1).putExtra("sessionInfo", paramSessionInfo);
        ((Intent)localObject1).putExtra("needSkey", "true");
        ((Intent)localObject1).putExtra("hide_more_button", true);
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject1).putExtra("hide_left_button", true);
        ((Intent)localObject1).putExtra("show_right_close_button", true);
        ((Intent)localObject1).putExtra("finish_animation_up_down", true);
        paramActivity.startActivity((Intent)localObject1);
        paramActivity.overridePendingTransition(2130968586, 0);
        return;
      }
      label596:
      label599:
      label605:
      break label98;
      label611:
      j = 0;
      break label260;
      n = 0;
      break;
      label623:
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.game.LauchGameAppListHelper
 * JD-Core Version:    0.7.0.1
 */