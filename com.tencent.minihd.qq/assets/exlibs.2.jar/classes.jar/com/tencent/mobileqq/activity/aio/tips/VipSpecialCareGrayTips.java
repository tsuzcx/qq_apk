package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class VipSpecialCareGrayTips
  implements GrayTipsTask, Runnable
{
  private static final String jdField_a_of_type_JavaLangString = VipSpecialCareGrayTips.class.getSimpleName();
  private static final String jdField_b_of_type_JavaLangString = "key_specialcare_gray_tips_";
  private static final String jdField_c_of_type_JavaLangString = "key_specialcare_tips_count_";
  private final int jdField_a_of_type_Int = 30;
  private final long jdField_a_of_type_Long = 604800000L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int;
  private final int jdField_c_of_type_Int;
  
  public VipSpecialCareGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    this.b = 20;
    this.c = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
  }
  
  private boolean a()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if ((QvipSpecialCareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (localSharedPreferences.getBoolean("specialcare_already_set" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    paramString = "key_specialcare_tips_count_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0) >= 2) {
      bool = true;
    }
    return bool;
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    String str = "key_specialcare_gray_tips_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(str, "");
    long l1 = MessageCache.a() * 1000L;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
        this.jdField_a_of_type_AndroidTextFormatTime = new Time();
      }
      this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
      int i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      int j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      int k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      int m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "curDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      long l2 = Long.parseLong(str);
      this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
      i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "lastShowDate :" + i + " - " + j + " - " + k + " - " + m);
      }
      bool1 = bool2;
      if (l1 - l2 <= 604800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "has show in a week, just return;");
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    if ((!b()) || (a()) || (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    long l = System.currentTimeMillis() / 1000L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "no message. shouldShowTips=false ");
      }
      return false;
    }
    localObject1 = ((List)localObject1).iterator();
    int k = 0;
    int m = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      int i2 = i;
      int i1 = k;
      int j;
      int n;
      int i4;
      if (((MessageRecord)localObject2).time >= l - 86400L)
      {
        i2 = i;
        i1 = k;
        if (((MessageRecord)localObject2).time <= l)
        {
          j = k;
          if (((MessageRecord)localObject2).isSend())
          {
            j = k;
            if (((MessageRecord)localObject2).msgtype == -1000)
            {
              j = k;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject2))
              {
                j = k;
                if (((MessageRecord)localObject2).extraflag != 32768) {
                  j = k + 1;
                }
              }
            }
          }
          if (((MessageRecord)localObject2).msgtype == -2002)
          {
            if (((MessageRecord)localObject2).isSend())
            {
              i2 = i;
              i1 = j;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject2))
              {
                i2 = i;
                i1 = j;
                if (((MessageRecord)localObject2).extraflag == 32768) {}
              }
            }
            else
            {
              m += 1;
              k = j;
              j = m;
              if (k <= 30) {
                break label642;
              }
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsgCount>30. shouldShowTips=true , count=" + k);
              }
              return true;
            }
          }
          else
          {
            i2 = i;
            i1 = j;
            if (((MessageRecord)localObject2).msgtype == -2009)
            {
              i2 = i;
              i1 = j;
              if ((localObject2 instanceof MessageForVideo))
              {
                localObject2 = (MessageForVideo)localObject2;
                ((MessageForVideo)localObject2).parse();
                i2 = i;
                i1 = j;
                if (((MessageForVideo)localObject2).text != null)
                {
                  i2 = i;
                  i1 = j;
                  if (((MessageForVideo)localObject2).text.contains(BaseApplicationImpl.a().getResources().getString(2131362857)))
                  {
                    localObject2 = ((MessageForVideo)localObject2).text;
                    localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(':') - 2, ((String)localObject2).lastIndexOf(':') + 3).split(":");
                    i1 = 0;
                    n = 0;
                    k = 0;
                    if (localObject2.length != 3) {
                      break label601;
                    }
                    i4 = Integer.valueOf(localObject2[0]).intValue();
                    n = Integer.valueOf(localObject2[1]).intValue();
                    k = Integer.valueOf(localObject2[2]).intValue();
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        int i3;
        if (i4 <= 0)
        {
          i3 = i;
          if (n < 10) {}
        }
        else
        {
          i3 = i + 1;
        }
        i2 = i3;
        i1 = j;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "video msg,hour=" + i4 + ",minute=" + n + ",second=" + k);
          i1 = j;
          i2 = i3;
        }
        i = i2;
        j = m;
        k = i1;
        break;
        label601:
        i4 = i1;
        if (localObject2.length == 2)
        {
          n = Integer.valueOf(localObject2[0]).intValue();
          k = Integer.valueOf(localObject2[1]).intValue();
          i4 = i1;
        }
      }
      label642:
      if (j > 20)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "pttMsgCount>20. shouldShowTips=true , count=" + j);
        }
        return true;
      }
      if (i > 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "longVideoMsgCount>2. shouldShowTips=true , count=" + i);
        }
        return true;
      }
      m = j;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shouldShowTips=false , sendMsgCount=" + k + ", pttMsgCount=" + m + ", longVideoMsgCount=" + i);
    }
    return false;
  }
  
  public int a()
  {
    return 2001;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-5005);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, -5005, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) || (paramInt != 1001)) {
      return;
    }
    ThreadManager.b().post(this);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, ".....run......");
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = true;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAIOList cost:" + (l2 - l1) + " ms");
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "aioMsgList == null");
      }
    }
    while ((!c()) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]))) {
      return;
    }
    String str = "key_specialcare_gray_tips_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putString(str, String.valueOf(MessageCache.a() * 1000L));
    str = "key_specialcare_tips_count_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    ((SharedPreferences.Editor)localObject).putInt(str, this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(str, 0) + 1);
    ((SharedPreferences.Editor)localObject).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Vip_SpecialRemind", "0X8005056", "0X8005056", 0, 1, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips
 * JD-Core Version:    0.7.0.1
 */