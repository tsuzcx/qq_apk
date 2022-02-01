package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gdl;
import java.util.List;

public class HongbaoKeywordGrayTips
  implements GrayTipsTask
{
  private static final int jdField_a_of_type_Int = 2015;
  private static final long jdField_a_of_type_Long = 86400000L;
  private static final String jdField_a_of_type_JavaLangString = "HongbaoKeywordGrayTips";
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "key_hongbao_keyword_gray_tips";
  private static final int c = 18;
  private static final int d = 21;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "红包", "压岁钱", "拜年" };
  private volatile long jdField_b_of_type_Long;
  
  public HongbaoKeywordGrayTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    this.b = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    boolean bool = a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoKeywordGrayTips", 2, "detect : matchKeywords=" + bool);
    }
    SharedPreferences localSharedPreferences;
    long l1;
    if (bool)
    {
      paramChatMessage = "key_hongbao_keyword_gray_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      String str = localSharedPreferences.getString(paramChatMessage, "");
      l1 = MessageCache.a() * 1000L;
      if (TextUtils.isEmpty(str)) {
        break label303;
      }
      long l2 = Long.parseLong(str);
      this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
      int i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      int j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      int k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      int m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "lastShowDate :" + i + " - " + (j + 1) + " - " + k + " - " + m);
      }
      if (l1 - l2 > 86400000L) {
        break label249;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "has show in a day, just return;");
      }
    }
    label249:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips show time interval > 1day, can show.");
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]));
      localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips has never been shown, can show.");
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]));
    label303:
    localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!(paramChatMessage instanceof MessageForText))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("HongbaoKeywordGrayTips", 2, "match : not MessageForText");
        bool2 = bool1;
      }
      return bool2;
    }
    bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(paramChatMessage.msg))
    {
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (paramChatMessage.msg.contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HongbaoKeywordGrayTips", 2, "match : ret=" + bool1);
        return bool1;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return 1004;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1045);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", l, -1045, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {}
    label103:
    long l;
    int i;
    Object localObject;
    label203:
    label354:
    label383:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
              break;
            }
            paramVarArgs = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
          } while ((paramVarArgs != null) && (paramVarArgs.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
        } while ((paramInt != 1000) && (paramInt != 1001));
        if (paramInt == 1000)
        {
          paramInt = 1;
          l = MessageCache.a();
          if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
            this.jdField_a_of_type_AndroidTextFormatTime = new Time();
          }
          this.jdField_a_of_type_AndroidTextFormatTime.set(l * 1000L);
          i = this.jdField_a_of_type_AndroidTextFormatTime.year;
          int k = this.jdField_a_of_type_AndroidTextFormatTime.month + 1;
          int m = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          int n = this.jdField_a_of_type_AndroidTextFormatTime.hour;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("onAIOEvent() :");
            if (paramInt == 0) {
              break label310;
            }
            paramVarArgs = " TYPE_ON_SHOW ";
            QLog.d("HongbaoKeywordGrayTips", 2, paramVarArgs + ", curDate :" + i + " - " + k + " - " + m + " - " + n);
          }
          if ((i != 2015) || (k != 2) || (m > 21) || (m < 18)) {
            break label316;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label321;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HongbaoKeywordGrayTips", 2, "time not match, just return");
          return;
          paramInt = 0;
          break label103;
          paramVarArgs = " TYPE_ON_MSG_SENT_RECV";
          break label203;
        }
        if (paramInt != 0)
        {
          ThreadManager.b().post(new gdl(this));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
          break;
        }
        paramInt = j;
        l = this.b;
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
        i = paramVarArgs.size();
      } while (i <= 0);
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject = (ChatMessage)paramVarArgs.get(i);
      if (paramInt == 0) {
        break label503;
      }
    } while (((ChatMessage)localObject).time <= l);
    label310:
    label316:
    label321:
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
    }
    if ((((ChatMessage)localObject).isSendFromLocal()) && (((ChatMessage)localObject).extraflag != 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : msg send not success");
      }
    }
    for (;;)
    {
      i -= 1;
      break label383;
      break;
      paramInt = 0;
      break label354;
      a((ChatMessage)localObject);
      if (((ChatMessage)localObject).time > this.b)
      {
        this.b = ((ChatMessage)localObject).time;
        continue;
        label503:
        if (((ChatMessage)localObject).shmsgseq <= l) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
        }
        a((ChatMessage)localObject);
        if (((ChatMessage)localObject).shmsgseq > this.b) {
          this.b = ((ChatMessage)localObject).shmsgseq;
        }
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips
 * JD-Core Version:    0.7.0.1
 */