package com.tencent.mobileqq.activity.widget.qqmusic;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqmusicplayerprocess.netspeed.VkeyManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;

public class QQMusicHelper
{
  private static int jdField_a_of_type_Int = 103;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString = "QQMusicHelper";
  private static String b;
  private static String c;
  private static String d;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    b = null;
    c = null;
    d = null;
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static long a()
  {
    if (jdField_a_of_type_Long == 0L) {
      a();
    }
    return jdField_a_of_type_Long;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(b)) {
      a();
    }
    return b;
  }
  
  public static void a()
  {
    MLog.b(jdField_a_of_type_JavaLangString, "refreshAuth");
    if (BaseActivity.sTopActivity != null) {
      jdField_a_of_type_Long = BaseActivity.sTopActivity.app.getLongAccountUin();
    }
    if (jdField_a_of_type_Long != 0L)
    {
      Object localObject = new WtloginHelper(BaseApplicationImpl.getContext(), true).GetLocalSig(jdField_a_of_type_Long + "", 16L);
      Ticket localTicket = WtloginHelper.GetUserSigInfoTicket((WUserSigInfo)localObject, 128);
      if ((localTicket != null) && (localTicket._sig != null) && (localTicket._sig.length > 0))
      {
        b = MusicUtil.a(localTicket._sig);
        MLog.b(jdField_a_of_type_JavaLangString, "ticket WLOGIN_ST : " + b);
      }
      localObject = WtloginHelper.GetUserSigInfoTicket((WUserSigInfo)localObject, 64);
      if ((localObject != null) && (((Ticket)localObject)._sig != null) && (((Ticket)localObject)._sig.length > 0))
      {
        d = MusicUtil.a(((Ticket)localObject)._sig);
        MLog.b(jdField_a_of_type_JavaLangString, "ticket WLOGIN_sA2 : " + d);
      }
    }
    MLog.b(jdField_a_of_type_JavaLangString, "refreshAuth end");
  }
  
  public static void a(int paramInt)
  {
    MusicPreferences.a().c(paramInt);
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(Context paramContext)
  {
    MusicPreferences.a().d(0);
    MusicPreferences.a().e(0);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
    a();
    SessionManager.a().a(-1);
    VkeyManager.getInstance().init();
    MyFavSongManager.a().c(paramContext);
    MyFavSongManager.a().a(true);
    FolderListManager.a().a(true);
    ApnManager.a();
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(d)) {
      a();
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper
 * JD-Core Version:    0.7.0.1
 */