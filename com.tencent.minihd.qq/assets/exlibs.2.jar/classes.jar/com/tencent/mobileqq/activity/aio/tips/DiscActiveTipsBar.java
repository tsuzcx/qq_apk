package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gdg;
import java.util.HashSet;
import java.util.List;

public class DiscActiveTipsBar
  implements TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = DiscActiveTipsBar.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public DiscActiveTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903833, null);
    ((TextView)paramVarArgs.findViewById(2131299778)).setText(2131365756);
    ((ImageView)paramVarArgs.findViewById(2131299776)).setImageResource(2130841725);
    paramVarArgs.findViewById(2131299777).setOnClickListener(new gdg(this));
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV =====>");
    }
    Object localObject1 = "";
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 3000)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "curType != disscusion");
          return;
        }
        Object localObject3 = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (((QQOperateManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "hasNetTipShow today");
          return;
        }
        List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
        if (localList == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "aioMsgList == null");
          return;
        }
        if (localList.size() < 10)
        {
          paramVarArgs = "msgList size < 10, size = " + localList.size();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
          return;
        }
        paramVarArgs = "voice_disc_chat_freq_bar_show_count" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        int k = localSharedPreferences.getInt(paramVarArgs, 0);
        if (k >= 3)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "show times >= 3,just return");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "discChatFreqBarShowCount : " + k);
        }
        long l1 = MessageCache.a() * 1000L;
        if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
          this.jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
        paramInt = this.jdField_a_of_type_AndroidTextFormatTime.year;
        i = this.jdField_a_of_type_AndroidTextFormatTime.month;
        j = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, j, i, paramInt);
        long l2 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, j, i, paramInt);
        long l3 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        if ((l1 < l2) || (l1 > l3))
        {
          paramVarArgs = "current time not in " + 20 + "-" + 23;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
          return;
        }
        String str = "voice_disc_chat_freq_bar_show_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        Object localObject4 = localSharedPreferences.getString(str, null);
        Object localObject5;
        if (QLog.isColorLevel())
        {
          localObject5 = paramInt + "-" + i + "-" + j;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "currDate is:" + (String)localObject5 + ",curr hour is:" + this.jdField_a_of_type_AndroidTextFormatTime.hour + ",discPttFreqTipMsgInsertTime is:" + (String)localObject4);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject4));
          int m = this.jdField_a_of_type_AndroidTextFormatTime.year;
          int n = this.jdField_a_of_type_AndroidTextFormatTime.month;
          int i1 = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == m) && (i == n) && (j == i1))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "already show discuss ppt frequent bar this day");
            return;
          }
        }
        localObject4 = localSharedPreferences.getString("start_group_audio_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (l1 - Long.parseLong((String)localObject4) <= 600000L))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "has startGroupAudio in less 10 mins, just return");
          return;
        }
        l2 = (l1 - 600000L) / 1000L;
        i = localList.size();
        paramInt = 0;
        localObject4 = new HashSet();
        j = i - 1;
        if (j >= 0)
        {
          localObject5 = (ChatMessage)localList.get(j);
          i = paramInt;
          if (((ChatMessage)localObject5).time < l2) {
            break label1270;
          }
          i = paramInt;
          if (!MsgProxyUtils.j(((ChatMessage)localObject5).msgtype)) {
            break label1270;
          }
          i = paramInt;
          if (((ChatMessage)localObject5).extraflag != 0) {
            break label1270;
          }
          i = paramInt + 1;
          ((HashSet)localObject4).add(((ChatMessage)localObject5).senderuin);
          break label1270;
        }
        i = ((HashSet)localObject4).size();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "basicMsgNum : " + paramInt + ", msgUinNum : " + i);
        }
        if ((paramInt >= 10) && (i >= 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0])))
        {
          ((QQOperateManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1);
          paramInt = k + 1;
          localObject3 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject3).putString(str, String.valueOf(l1)).putInt(paramVarArgs, paramInt);
          ((SharedPreferences.Editor)localObject3).commit();
          paramVarArgs = "show discuss chat frequent bar success, discChatFreqBarShowCount=" + paramInt;
        }
      }
      finally
      {
        try
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003EFF", "0X8003EFF", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
          return;
        }
        finally
        {
          localObject1 = paramVarArgs;
          paramVarArgs = localObject2;
        }
        paramVarArgs = finally;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + (String)localObject1);
        }
      }
      paramVarArgs = "";
      continue;
      label1270:
      j -= 1;
      paramInt = i;
    }
  }
  
  public int[] a()
  {
    return new int[] { 2000 };
  }
  
  public int b()
  {
    return 40;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar
 * JD-Core Version:    0.7.0.1
 */