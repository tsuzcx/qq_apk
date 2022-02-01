package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import jqe;
import jqf;

public class VipBannerInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public long a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    ThreadManager.a().post(new jqe(paramContext));
  }
  
  public static void a(Conversation paramConversation)
  {
    if ((paramConversation == null) || (paramConversation.a.a(15) != 0)) {}
    SharedPreferences localSharedPreferences;
    Handler localHandler;
    RedTouchManager localRedTouchManager;
    do
    {
      do
      {
        return;
        localSharedPreferences = paramConversation.getActivity().getSharedPreferences("mobileQQ", 0);
        localHandler = paramConversation.a.a();
      } while (localHandler == null);
      localRedTouchManager = (RedTouchManager)paramConversation.app.getManager(35);
    } while (localRedTouchManager == null);
    ThreadManager.a().post(new jqf(localRedTouchManager, localSharedPreferences, paramConversation, localHandler));
  }
  
  public static void b(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.a.a(15) != 0))
    {
      paramConversation = paramConversation.a.a();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.VipBannerInfo
 * JD-Core Version:    0.7.0.1
 */