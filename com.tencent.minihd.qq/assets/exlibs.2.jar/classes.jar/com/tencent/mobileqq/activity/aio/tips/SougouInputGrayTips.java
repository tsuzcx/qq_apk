package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class SougouInputGrayTips
  implements GrayTipsTask, Runnable
{
  private static final int jdField_a_of_type_Int = 10;
  private static final String jdField_a_of_type_JavaLangString = SougouInputGrayTips.class.getSimpleName();
  private static final String jdField_b_of_type_JavaLangString = "key_sougou_input_gray_tips_";
  private final long jdField_a_of_type_Long = 604800000L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("");
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean;
  
  public SougouInputGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private String a(Context paramContext)
  {
    int j = 0;
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    List localList = ((InputMethodManager)paramContext.getSystemService("input_method")).getInputMethodList();
    int i;
    if (localList == null) {
      i = 0;
    }
    while (j < i)
    {
      InputMethodInfo localInputMethodInfo = (InputMethodInfo)localList.get(j);
      this.jdField_a_of_type_JavaLangStringBuilder.append(localInputMethodInfo.loadLabel(paramContext.getPackageManager()));
      this.jdField_a_of_type_JavaLangStringBuilder.append(" ");
      j += 1;
      continue;
      i = localList.size();
    }
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  private boolean a(Context paramContext)
  {
    long l1 = System.currentTimeMillis();
    paramContext = a(paramContext);
    if ((paramContext.contains("搜狗输入法")) || (paramContext.contains("QQ输入法"))) {}
    for (boolean bool = true;; bool = false)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "hasInstallSougouOrQQInput ret = " + bool + ", cost:" + (l2 - l1) + " ms");
      }
      return bool;
    }
  }
  
  public int a()
  {
    return 1002;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1014);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, -1043, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1002) {}
    do
    {
      return;
      paramVarArgs = (String)paramVarArgs[0];
      paramInt = paramVarArgs.length();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendContent: " + paramVarArgs + ",size = " + paramInt);
      }
    } while (paramInt < 10);
    ThreadManager.b().postDelayed(this, 1000L);
  }
  
  public int[] a()
  {
    return TipsConstants.a;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, ".....run......");
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.b = a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.b) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "installSougouOrQQInput, just return");
      }
    }
    long l1;
    Object localObject1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getAIOList cost:" + (l2 - l1) + " ms");
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "aioMsgList == null");
    return;
    int j = ((List)localObject1).size();
    int i = j - 1;
    label173:
    boolean bool;
    if (i >= 0) {
      if (i < j - 11) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "findExcludeMsg :" + bool);
      }
      if (bool) {
        break;
      }
      localObject1 = "key_sougou_input_gray_tips_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      Object localObject2 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      String str = ((SharedPreferences)localObject2).getString((String)localObject1, "");
      l1 = MessageCache.a() * 1000L;
      if (!TextUtils.isEmpty(str))
      {
        if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
          this.jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
        i = this.jdField_a_of_type_AndroidTextFormatTime.year;
        j = this.jdField_a_of_type_AndroidTextFormatTime.month;
        int k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        int m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "curDate :" + i + " - " + j + " - " + k + " - " + m);
        }
        l2 = Long.parseLong(str);
        this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
        i = this.jdField_a_of_type_AndroidTextFormatTime.year;
        j = this.jdField_a_of_type_AndroidTextFormatTime.month;
        k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "lastShowDate :" + i + " - " + j + " - " + k + " - " + m);
        }
        if (l1 - l2 > 604800000L) {
          break label676;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "has show in a week, just return;");
        return;
        localObject2 = (ChatMessage)((List)localObject1).get(i);
        if ((((ChatMessage)localObject2).msgtype == -1014) || (((ChatMessage)localObject2).msgtype == -1017) || (((ChatMessage)localObject2).msgtype == -1016) || (((ChatMessage)localObject2).msgtype == -1041) || (((ChatMessage)localObject2).msgtype == -1043) || ((((ChatMessage)localObject2).msgtype == -1013) && (((ChatMessage)localObject2).istroop == 0)))
        {
          bool = true;
          continue;
        }
        i -= 1;
        break label173;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "has never shown sougouInput Gray Tips");
      }
      label676:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])) {
        break;
      }
      ((SharedPreferences)localObject2).edit().putString((String)localObject1, String.valueOf(l1)).commit();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047CE", "0X80047CE", 0, 0, "", "", "", "");
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips
 * JD-Core Version:    0.7.0.1
 */