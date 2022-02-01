package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import fqo;
import fqp;
import fqq;
import fqr;
import fqs;
import fqt;
import fqu;
import fqv;
import fqw;
import fqx;
import fqy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AioAnimationDetector
{
  public static final int a = 800;
  private static volatile AioAnimationDetector jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector;
  public static final String a;
  private static final int jdField_b_of_type_Int = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  public volatile long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public volatile boolean a;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = AioAnimationDetector.class.getSimpleName();
  }
  
  private AioAnimationDetector()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static AioAnimationDetector a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector = new AioAnimationDetector();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt)
  {
    String str2 = "";
    String str1;
    if (paramInt == 0) {
      str1 = "0X8004A27";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        VipUtils.a(paramQQAppInterface, "Vip_StructuredEgg", str1, str1, 0, 0, new String[0]);
      }
      return;
      str1 = str2;
      if (paramInt == 1) {
        if (paramChatMessage.istroop == 1)
        {
          str1 = "0X8004A28";
        }
        else
        {
          str1 = str2;
          if (paramChatMessage.istroop == 3000) {
            str1 = "0X8004A29";
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, int paramInt2, AioAnimationRule paramAioAnimationRule)
  {
    int j = -1;
    int i;
    if (paramInt1 == 0)
    {
      i = 0;
      if (paramInt2 != 2) {
        break label134;
      }
      if (paramChatMessage.isSendFromLocal()) {
        break label100;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_rec", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
    }
    label100:
    while (paramInt2 != 3)
    {
      return;
      i = j;
      if (paramInt1 != 1) {
        break;
      }
      if (paramChatMessage.istroop == 1)
      {
        i = 1;
        break;
      }
      i = j;
      if (paramChatMessage.istroop != 3000) {
        break;
      }
      i = 2;
      break;
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_launch", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
      return;
    }
    label134:
    if (!paramChatMessage.isSendFromLocal())
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_rec", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_launch", 0, 0, String.valueOf(i), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AioAnimationRule paramAioAnimationRule)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "detect combo =======> isLastStackMessageFromOthers ? " + this.jdField_b_of_type_Boolean + "  lastStackMessageSeq=" + this.jdField_b_of_type_Long + "thisMessageSeq=" + paramChatMessage.shmsgseq);
    }
    if ((paramChatMessage.isSendFromLocal()) && (this.jdField_b_of_type_Boolean) && (paramChatMessage.shmsgseq == this.jdField_b_of_type_Long + 1L)) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Eggs_stack_new", 0, 0, String.valueOf(0), String.valueOf(paramAioAnimationRule.jdField_a_of_type_Int), "", "");
    }
    if (!paramChatMessage.isSendFromLocal()) {
      bool = true;
    }
    this.jdField_b_of_type_Boolean = bool;
    this.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
  }
  
  public String a(AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg != null) && (paramAbsShareMsg.getItemCount() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramAbsShareMsg = paramAbsShareMsg.iterator();
      while (paramAbsShareMsg.hasNext())
      {
        Object localObject = (AbsStructMsgElement)paramAbsShareMsg.next();
        if ((localObject instanceof AbsStructMsgItem))
        {
          localObject = ((AbsStructMsgItem)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
            String str = localAbsStructMsgElement.jdField_a_of_type_JavaLangString;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localAbsStructMsgElement).b());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((StructMsgItemSummary)localAbsStructMsgElement).b());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public ArrayList a(ChatMessage paramChatMessage)
  {
    AioAnimationRule localAioAnimationRule = null;
    Object localObject1 = null;
    Iterator localIterator = null;
    Object localObject2 = localIterator;
    if (paramChatMessage != null)
    {
      if (a(paramChatMessage)) {
        break label32;
      }
      localObject2 = localIterator;
    }
    label32:
    Object localObject3;
    do
    {
      return localObject2;
      localObject3 = AioAnimationConfigHelper.a().a();
      if (localObject3 != null) {
        break;
      }
      localObject2 = localIterator;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "match : rules == null, just return;");
    return null;
    paramChatMessage.parse();
    long l1 = System.currentTimeMillis();
    if (b(paramChatMessage))
    {
      localObject2 = a((AbsShareMsg)((MessageForStructing)paramChatMessage).structingMsg);
      label98:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label272;
      }
      localIterator = ((ArrayList)localObject3).iterator();
      paramChatMessage = localAioAnimationRule;
      label116:
      localObject1 = paramChatMessage;
      if (!localIterator.hasNext()) {
        break label272;
      }
      localAioAnimationRule = (AioAnimationRule)localIterator.next();
      if (localAioAnimationRule.jdField_a_of_type_JavaUtilArrayList == null) {
        break label327;
      }
      localObject1 = localAioAnimationRule.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((String)localObject2).contains((CharSequence)localObject3))) {
            if (paramChatMessage == null)
            {
              paramChatMessage = new ArrayList();
              label208:
              paramChatMessage.add(localAioAnimationRule);
              localObject1 = paramChatMessage;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "matched ===> rule: id=" + localAioAnimationRule.jdField_a_of_type_Int);
              }
            }
          }
        }
      }
    }
    label272:
    label327:
    for (localObject1 = paramChatMessage;; localObject1 = paramChatMessage)
    {
      paramChatMessage = (ChatMessage)localObject1;
      break label116;
      localObject2 = paramChatMessage.msg;
      break label98;
      long l2 = System.currentTimeMillis();
      localObject2 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "match duration: " + (l2 - l1) + " ms");
      return localObject1;
      break label208;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramAIOAnimationConatiner == null)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleUnreadMsgList, hasUnRead=" + this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_Boolean) && (paramSessionInfo.jdField_a_of_type_Int != 1008))
      {
        int j = 0;
        int i;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
          i = 1;
        }
        while ((i != 0) || (j != 0))
        {
          paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, false);
          long l = this.jdField_a_of_type_Long;
          j = 0;
          int n = paramSessionInfo.size();
          int m = 0;
          label137:
          ChatMessage localChatMessage;
          int k;
          ArrayList localArrayList;
          if (m < n)
          {
            localChatMessage = (ChatMessage)paramSessionInfo.get(m);
            if (i != 0)
            {
              k = j;
              if (localChatMessage.shmsgseq >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "handleUnreadMsgList, troop&discussion message ===> (" + localChatMessage.shmsgseq + ")");
                  }
                  boolean bool = false;
                  if (m == n - 1) {
                    bool = true;
                  }
                  localArrayList = a(localChatMessage);
                  this.jdField_a_of_type_Long = localChatMessage.shmsgseq;
                  if (localArrayList == null) {
                    break label459;
                  }
                  a(paramQQAppInterface, localArrayList, true, localChatMessage, bool, paramAIOAnimationConatiner, j * 800);
                  j += 1;
                }
              }
            }
          }
          label459:
          for (;;)
          {
            k = j;
            for (;;)
            {
              m += 1;
              j = k;
              break label137;
              if (!MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int)) {
                break label462;
              }
              j = 1;
              i = 0;
              break;
              k = j;
              if (localChatMessage.time >= l)
              {
                k = j;
                if (!localChatMessage.isAioAnimChecked)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "handleUnreadMsgList, c2c message ===> (" + localChatMessage.time + ")");
                  }
                  localArrayList = a(localChatMessage);
                  this.jdField_a_of_type_Long = localChatMessage.time;
                  k = j;
                  if (localArrayList != null)
                  {
                    a(paramQQAppInterface, localArrayList, false, localChatMessage, false, paramAIOAnimationConatiner, j * 800);
                    k = j + 1;
                  }
                }
              }
            }
            this.jdField_a_of_type_Boolean = false;
            return;
          }
          label462:
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if (this.jdField_a_of_type_Boolean) {
      break label7;
    }
    label7:
    label42:
    label379:
    label383:
    for (;;)
    {
      return;
      if (paramSessionInfo.jdField_a_of_type_Int != 1008)
      {
        int j = 0;
        int i;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
          i = 1;
        }
        for (;;)
        {
          if (((i == 0) && (j == 0)) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) || ((paramSessionInfo.jdField_a_of_type_Int != paramMessageRecord.istroop) && ((j == 0) || (!MsgProxyUtils.c(paramMessageRecord.istroop))))) {
            break label383;
          }
          paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, false);
          paramMessageRecord = a();
          long l = paramMessageRecord.jdField_a_of_type_Long;
          j = paramSessionInfo.size() - 1;
          ChatMessage localChatMessage;
          ArrayList localArrayList;
          if (j >= 0)
          {
            localChatMessage = (ChatMessage)paramSessionInfo.get(j);
            if (i == 0) {
              break label278;
            }
            if (localChatMessage.shmsgseq <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "handle troop&discussion new message ===> (" + localChatMessage.shmsgseq + ")");
              }
              localArrayList = paramMessageRecord.a(localChatMessage);
              if (localArrayList != null) {
                paramMessageRecord.a(paramQQAppInterface, localArrayList, true, localChatMessage, true, paramAIOAnimationConatiner, 0);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.shmsgseq;
            }
          }
          for (;;)
          {
            j -= 1;
            break label129;
            break label7;
            if (!MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int)) {
              break label379;
            }
            j = 1;
            i = 0;
            break label42;
            if (localChatMessage.time <= l) {
              break;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "handle c2c new message ===> (" + localChatMessage.time + ")");
              }
              localArrayList = paramMessageRecord.a(localChatMessage);
              if (localArrayList != null) {
                paramMessageRecord.a(paramQQAppInterface, localArrayList, false, localChatMessage, true, paramAIOAnimationConatiner, 0);
              }
              paramMessageRecord.jdField_a_of_type_Long = localChatMessage.time;
            }
          }
          i = 0;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList, boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramAIOAnimationConatiner == null) || (paramArrayList == null) || (!a(paramChatMessage))) {}
    do
    {
      return;
      if (!paramChatMessage.isAioAnimChecked) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "detect : message is checked, just return;");
    return;
    paramChatMessage.isAioAnimChecked = true;
    paramArrayList = paramArrayList.iterator();
    label64:
    Object localObject1;
    int i;
    int m;
    Object localObject2;
    int k;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localObject1 = (AioAnimationRule)paramArrayList.next();
        i = paramChatMessage.getRepeatCount();
        j = ((AioAnimationRule)localObject1).jdField_b_of_type_Int;
        m = ((AioAnimationRule)localObject1).c;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "detect : troopOrDiscussion=" + paramBoolean1 + " matched (" + paramChatMessage.uniseq + "), rule: id=" + ((AioAnimationRule)localObject1).jdField_a_of_type_Int + ",M=" + i + ",X=" + j + ",Y=" + m + ",crazyMode=" + ((AioAnimationRule)localObject1).jdField_a_of_type_Boolean);
        }
        if (!paramBoolean1)
        {
          if ((j == 0) && (m == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "detect c2c =======>  egg_jumper animation, crazyModeEnable=" + ((AioAnimationRule)localObject1).jdField_a_of_type_Boolean);
            }
            a(paramQQAppInterface, paramChatMessage, 0, 3, (AioAnimationRule)localObject1);
            if ((paramChatMessage instanceof MessageForStructing)) {
              a(paramQQAppInterface, paramChatMessage, 0);
            }
            if (((AioAnimationRule)localObject1).jdField_a_of_type_Boolean)
            {
              j = ((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.size();
              i = 0;
              while (i < j)
              {
                localObject2 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(i);
                localObject2 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject2);
                k = i * 800;
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqo(this, paramAIOAnimationConatiner, (Drawable)localObject2, k), paramInt + k);
                i += 1;
              }
            }
            else
            {
              localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(0);
              localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqr(this, paramAIOAnimationConatiner, (Drawable)localObject1), paramInt);
            }
          }
        }
        else if ((j == 0) && (m == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "detect =======>  egg_jumper animation ,crazyModeEnable=" + ((AioAnimationRule)localObject1).jdField_a_of_type_Boolean);
          }
          a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject1);
          if ((paramChatMessage instanceof MessageForStructing)) {
            a(paramQQAppInterface, paramChatMessage, 1);
          }
          if (((AioAnimationRule)localObject1).jdField_a_of_type_Boolean)
          {
            j = ((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.size();
            i = 0;
            while (i < j)
            {
              localObject2 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(i);
              localObject2 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject2);
              k = i * 800;
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqs(this, paramAIOAnimationConatiner, (Drawable)localObject2, k), paramInt + k);
              i += 1;
            }
          }
          else
          {
            localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(0);
            localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqt(this, paramAIOAnimationConatiner, (Drawable)localObject1), paramInt);
          }
        }
        else if ((j < m) && (i >= j))
        {
          if (i == m)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "detect (M == Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
            }
            if (paramBoolean2)
            {
              a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject1);
              a(paramQQAppInterface, paramChatMessage, (AioAnimationRule)localObject1);
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqu(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "detect (M == Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + ((AioAnimationRule)localObject1).jdField_a_of_type_Boolean);
            }
            a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject1);
            i = 0;
            label834:
            if (i < m) {
              if (!paramBoolean2) {
                break label1442;
              }
            }
          }
        }
      }
    }
    label1436:
    label1442:
    for (int j = 1000;; j = 0)
    {
      if (((AioAnimationRule)localObject1).jdField_a_of_type_Boolean)
      {
        int n = ((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.size();
        k = 0;
        while (k < n)
        {
          localObject2 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(k);
          localObject2 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject2);
          int i1 = (k + i) * 800;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqv(this, paramAIOAnimationConatiner, (Drawable)localObject2, i1), paramInt + j + i1);
          k += 1;
        }
      }
      localObject2 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(0);
      localObject2 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject2);
      k = i * 800;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqw(this, paramAIOAnimationConatiner, (Drawable)localObject2, k), paramInt + j + k);
      i += 1;
      break label834;
      break label64;
      if (i > m)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "detect (M > Y) =======>  egg_combo animation, checkCombo= " + paramBoolean2);
        }
        if (paramBoolean2)
        {
          a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject1);
          a(paramQQAppInterface, paramChatMessage, (AioAnimationRule)localObject1);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqx(this, paramAIOAnimationConatiner, i, paramChatMessage), paramInt + 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "detect (M > Y) =======>  egg_jumper animation ,Y=" + m + ",crazyModeEnable=" + ((AioAnimationRule)localObject1).jdField_a_of_type_Boolean);
        }
        a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject1);
        if (!paramBoolean2) {
          break label1436;
        }
      }
      for (i = 1000;; i = 0)
      {
        if (((AioAnimationRule)localObject1).jdField_a_of_type_Boolean)
        {
          k = ((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.size();
          j = 0;
          while (j < k)
          {
            localObject2 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(j);
            localObject2 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject2);
            m = j * 800;
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqy(this, paramAIOAnimationConatiner, (Drawable)localObject2, m), paramInt + i + m);
            j += 1;
          }
          break label64;
        }
        localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject1).jdField_b_of_type_JavaUtilArrayList.get(0);
        localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqp(this, paramAIOAnimationConatiner, (Drawable)localObject1), paramInt + i);
        break label64;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "detect (X <= M < Y) ======>  egg_combo animation, checkCombo= " + paramBoolean2);
        }
        if (!paramBoolean2) {
          break label64;
        }
        a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject1);
        a(paramQQAppInterface, paramChatMessage, (AioAnimationRule)localObject1);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fqq(this, paramAIOAnimationConatiner, i, paramChatMessage), 0 + paramInt);
        break label64;
        break;
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((!(paramChatMessage instanceof MessageForText)) && (!(paramChatMessage instanceof MessageForLongMsg)) && (!(paramChatMessage instanceof MessageForStructing)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkMsgType : not MessageForText and MessageForLongMsg, return false;");
      }
      return false;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkMsgType : messageForText");
      }
    }
    for (;;)
    {
      return true;
      if ((paramChatMessage instanceof MessageForLongMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkMsgType : MessageForLongMsg");
        }
      }
      else if (((paramChatMessage instanceof MessageForStructing)) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkMsgType : MessageForStructing");
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage != null) {
        break label37;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "msg type is MessageForStructing, strctMsg is null");
      }
    }
    return false;
    label37:
    return paramChatMessage instanceof AbsShareMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector
 * JD-Core Version:    0.7.0.1
 */