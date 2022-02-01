package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseMessageManagerForTroopAndDisc
  extends BaseMessageManager
{
  public BaseMessageManagerForTroopAndDisc(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.shmsgseq;
  }
  
  public abstract String a(String paramString1, String paramString2);
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
    if ((MsgProxyUtils.a(str, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(str, paramInt))) && (paramRefreshMessageContext.d) && (paramRefreshMessageContext.b < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more long msg");
      }
      paramRefreshMessageContext.b += 1;
      b(str, paramInt, 15, paramRefreshMessageContext);
      return;
    }
    super.a(paramRefreshMessageContext, paramInt);
  }
  
  public void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle)
  {
    boolean bool2 = paramBundle.getBoolean("success");
    long l2 = paramBundle.getLong("beginSeq", -1L);
    long l1 = paramBundle.getLong("endSeq", -1L);
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramBundle.getInt("counter")));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
    Object localObject2 = new StringBuilder().append("refresh roam step 1 , result = ");
    int i;
    if (paramList1 == null)
    {
      i = -1;
      ((QQMessageFacade)localObject1).a(i + " , success = " + bool2 + " , beginSeq = " + l2 + " , endSeq = " + l1, " , timestamp = " + System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramBundle.getInt("counter")));
      if (localList == null) {
        return;
      }
      localObject1 = paramList2;
      if (paramList2 == null) {
        localObject1 = new ArrayList();
      }
      if ((paramList1 == null) || (paramList1.isEmpty())) {
        break label758;
      }
      paramList2 = new ArrayList();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
      if (l2 - 15L <= 0L) {
        break label649;
      }
      l1 = l2 - 15L;
      label246:
      if (l2 - 1L <= 0L) {
        break label655;
      }
      l2 -= 1L;
      label261:
      paramList2.addAll(((MsgProxy)localObject2).a(paramString, paramInt, l1, l2));
      paramList2.addAll(localList);
      paramString = paramList1.iterator();
      label297:
      if (!paramString.hasNext()) {
        break label758;
      }
      paramList1 = (MessageRecord)paramString.next();
      localObject2 = paramList2.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!MsgProxyUtils.a((MessageRecord)((Iterator)localObject2).next(), paramList1, false, true));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam msg rewrite sending msg  mr.senderuin: " + paramList1.senderuin + " mr.msgtype: " + paramList1.msgtype + " mr.frienduin: " + paramList1.frienduin + " mr.shmsgseq: " + paramList1.shmsgseq + " mr.time:" + paramList1.time + " mr.msg: " + paramList1.getLogColorContent());
        }
        if ((paramList1.senderuin != null) && (paramList1.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramList1.frienduin, paramList1.istroop, paramList1, paramList2);
          if (localObject2 != null) {
            if (((MessageRecord)localObject2).isValid) {
              break label1024;
            }
          }
        }
      }
      label1024:
      for (paramInt = 1;; paramInt = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramList1.frienduin, paramList1.istroop, ((MessageRecord)localObject2).uniseq, paramList1.shmsgseq, paramList1.time);
        if (((MessageRecord)localObject2).msgtype == -2017)
        {
          byte[] arrayOfByte = MsgProxyUtils.a((MessageRecord)localObject2, paramList1);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramList1.frienduin, 1, ((MessageRecord)localObject2).uniseq, arrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam text msg rewrite success");
        }
        if (paramInt == 0) {
          break label297;
        }
        ((MessageRecord)localObject2).shmsgseq = paramList1.shmsgseq;
        ((MessageRecord)localObject2).time = paramList1.time;
        ((MessageRecord)localObject2).extraflag = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2);
        break label297;
        i = paramList1.size();
        break;
        label649:
        l1 = 0L;
        break label246;
        label655:
        l2 = 0L;
        break label261;
        ((List)localObject1).add(paramList1);
        if (!QLog.isColorLevel()) {
          break label297;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 2 , mr.msg = " + paramList1.getLogColorContent() + " , mr.seq = " + paramList1.shmsgseq + " , mr.msgtype = " + paramList1.msgtype + ", isExist = " + bool1 + " , extra = " + paramList1.extraflag);
        break label297;
        label758:
        paramBundle.putBoolean("success", bool2);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)((List)localObject1).get(0)).istroop).a((List)localObject1, null);
        }
        paramString = ((List)localObject1).iterator();
        while (paramString.hasNext())
        {
          paramList1 = (MessageRecord)paramString.next();
          if (paramList1.getId() < 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "refresh insert db error ! , mr.msg = " + paramList1.getLogColorContent() + " , mr.seq = " + paramList1.shmsgseq + " , mr.uniseq = " + paramList1.uniseq + " , extra = " + paramList1.extraflag);
            }
          }
          else
          {
            MsgProxyUtils.c(localList, paramList1, true);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 3 , mr.msg = " + paramList1.getLogColorContent() + " , mr.seq = " + paramList1.shmsgseq + " , mr.uniseq = " + paramList1.uniseq + " , extra = " + paramList1.extraflag);
            }
          }
        }
        try
        {
          localList.notify();
          return;
        }
        finally {}
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt, List paramList, String paramString2)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString1, paramInt), Boolean.valueOf(true));
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).e(paramString1, paramInt);
    } while ((paramString1 == null) || (paramString1.isEmpty()));
    paramList = MsgProxyUtils.a(paramList, true);
    int i;
    if (((MessageRecord)paramList.get(0)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq + 1L)
    {
      i = 1;
      if (i == 0) {
        break label289;
      }
      paramInt = 0;
      label151:
      if (paramInt >= paramList.size()) {
        break label313;
      }
      if (((MessageRecord)paramList.get(paramInt)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq) {
        break label269;
      }
    }
    for (;;)
    {
      paramList = paramList.subList(paramInt, paramList.size());
      if ((!paramList.isEmpty()) && (((MessageRecord)paramString1.get(0)).shmsgseq <= ((MessageRecord)paramList.get(0)).shmsgseq)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramList, paramString2);
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        label269:
        paramInt += 1;
        break label151;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramList, paramString2);
        continue;
        label289:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).c();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramList, paramString2);
      }
      label313:
      paramInt = 0;
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = a(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).e(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
      a(paramRefreshMessageContext, paramInt1);
      return;
    }
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    long l3;
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if (((MessageRecord)localObject3).shmsgseq > 0L)
      {
        l3 = ((MessageRecord)localObject3).uniseq;
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        }
        paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
        a(paramRefreshMessageContext, paramInt1);
        return;
      }
      Object localObject4 = new HashMap();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3);
      Object localObject5;
      Object localObject6;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh find msg in cache id = " + ((MessageRecord)localObject3).getId() + ", msg = " + ((MessageRecord)localObject3).getLogColorContent() + ", uniseq = " + ((MessageRecord)localObject3).uniseq + " , msgtime = " + ((MessageRecord)localObject3).time + " , shMsgSeq = " + ((MessageRecord)localObject3).shmsgseq + " , extra = " + ((MessageRecord)localObject3).extraflag);
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject2 = ((List)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject5 = (MessageRecord)((Iterator)localObject2).next();
          } while (((MessageRecord)localObject5).shmsgseq != ((MessageRecord)localObject3).shmsgseq);
          localObject6 = new StringBuilder();
          if (((MessageRecord)localObject5).getId() > 0L) {}
          for (localObject1 = "id&" + ((MessageRecord)localObject5).getId();; localObject1 = "uniseq&" + ((MessageRecord)localObject5).uniseq)
          {
            ((HashMap)localObject4).put((String)localObject1 + "&" + ((MessageRecord)localObject5).shmsgseq, localObject5);
            break;
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh can't find msg in cache !!");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        i = 0;
        if (i < ((List)localObject1).size()) {
          if (((MessageRecord)((List)localObject1).get(i)).uniseq != l3) {}
        }
      }
      for (int k = i;; k = 0)
      {
        localObject2 = new ArrayList();
        int j;
        if (localObject3 == null) {
          j = 3;
        }
        label567:
        long l1;
        for (;;)
        {
          if ((paramRefreshMessageContext.c) || (j <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh load local msg only step 0, timestamp = " + System.currentTimeMillis());
            }
            if (localObject3 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh load local msg only step 1, timestamp = " + System.currentTimeMillis());
              }
              l1 = ((MessageRecord)localObject3).shmsgseq;
              if (j > 0) {
                ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject4));
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh load local msg only step 2 , size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)localObject3).getId(), j, l1 - 1L, paramInt2, null);
              if ((!((List)localObject1).isEmpty()) && (((MessageRecord)((List)localObject1).get(0)).versionCode > 0) && (((MessageRecord)((List)localObject1).get(0)).shmsgseq == 0L))
              {
                localObject3 = new ArrayList();
                localObject4 = ((List)localObject1).iterator();
                for (;;)
                {
                  if (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (MessageRecord)((Iterator)localObject4).next();
                    if (((MessageRecord)localObject5).shmsgseq == 0L)
                    {
                      ((List)localObject3).add(localObject5);
                      continue;
                      i += 1;
                      break;
                      j = ((MessageRecord)localObject3).versionCode;
                      break label567;
                    }
                  }
                }
                ((List)localObject1).removeAll((Collection)localObject3);
                ((List)localObject1).addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, 0L, 0L));
              }
              if (((List)localObject1).isEmpty())
              {
                paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh load local msg only step 3 , size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
                }
                paramRefreshMessageContext.c = true;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, (List)localObject2);
              }
            }
            for (;;)
            {
              paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("refresh load local msg only FIN , context = " + paramRefreshMessageContext + ", size = " + ((List)localObject2).size(), ", timestamp = " + System.currentTimeMillis());
              a(paramRefreshMessageContext, paramInt1);
              return;
              ((List)localObject2).addAll(0, (Collection)localObject1);
              break;
              paramRefreshMessageContext.c = true;
              paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
            }
          }
        }
        long l4;
        if (k == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 0, timestamp = " + System.currentTimeMillis());
          }
          if (localObject3 == null)
          {
            paramRefreshMessageContext.c = true;
            paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
            paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject2);
            a(paramRefreshMessageContext, paramInt1);
            return;
          }
          l2 = ((MessageRecord)localObject3).shmsgseq;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
          if (l2 - paramInt2 >= 0L)
          {
            l1 = l2 - paramInt2;
            if (l2 - 1L < 0L) {
              break label1435;
            }
          }
          label1435:
          for (l4 = l2 - 1L;; l4 = 0L)
          {
            ((List)localObject2).addAll(((MsgProxy)localObject1).a(paramString, paramInt1, l1, l4));
            ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, (Map)localObject4));
            l1 = l2;
            if (!QLog.isColorLevel()) {
              break label2573;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 1, timestamp = " + System.currentTimeMillis());
            l1 = l2;
            i = 0;
            if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
              break label4150;
            }
            k = ((List)localObject2).size() - 1;
            l2 = l1;
            i = 0;
            while ((k >= 0) && (l2 - ((MessageRecord)((List)localObject2).get(k)).shmsgseq <= 1L))
            {
              l2 = ((MessageRecord)((List)localObject2).get(k)).shmsgseq;
              i += 1;
              k -= 1;
            }
            l1 = 0L;
            break;
          }
        }
        long l2 = ((MessageRecord)localObject3).shmsgseq;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 0, cacheIndex = " + k + " timestamp = " + System.currentTimeMillis());
        }
        if (k >= paramInt2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 1, timestamp = " + System.currentTimeMillis());
          }
          i = k - paramInt2;
          l4 = ((MessageRecord)((List)localObject1).get(i)).shmsgseq;
        }
        for (;;)
        {
          if ((i > 0) && (((MessageRecord)((List)localObject1).get(i - 1)).shmsgseq == ((MessageRecord)((List)localObject1).get(i)).shmsgseq))
          {
            i -= 1;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i);
            }
          }
          else
          {
            if (i == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
              }
              m = k - paramInt2;
              i = m;
              while ((i < ((List)localObject1).size() - 1) && (((MessageRecord)((List)localObject1).get(i)).shmsgseq == ((MessageRecord)((List)localObject1).get(i + 1)).shmsgseq))
              {
                m += 1;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + m);
                }
                i += 1;
              }
              i = m + 1;
              if (i > k)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 3, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
                }
                ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l2, (Map)localObject4));
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 4, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
                }
              }
            }
            for (;;)
            {
              l1 = l2;
              break;
              ((List)localObject2).addAll(((List)localObject1).subList(i, k));
              i = paramInt2 - ((List)localObject2).size();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 5, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
              if (l4 - i >= 0L) {}
              for (l1 = l4 - i;; l1 = 0L)
              {
                ((List)localObject2).addAll(0, ((MsgProxy)localObject1).a(paramString, paramInt1, l1, l4));
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 6, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
                break;
              }
              ((List)localObject2).addAll(((List)localObject1).subList(i, k));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 7, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              }
            }
            l4 = ((MessageRecord)((List)localObject1).get(0)).shmsgseq;
            int m = 0;
            i = 0;
            while ((i < ((List)localObject1).size() - 1) && (((MessageRecord)((List)localObject1).get(i)).shmsgseq == ((MessageRecord)((List)localObject1).get(i + 1)).shmsgseq))
            {
              m += 1;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + m);
              }
              i += 1;
            }
            i = m + 1;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 0, sameSeq = " + l4 + ",itemListStartPoint = " + i + ", timestamp = " + System.currentTimeMillis());
            }
            if (i > k)
            {
              ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l4, (Map)localObject4));
              label2405:
              i = paramInt2 - ((List)localObject2).size();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 1, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
              if (l4 - i < 0L) {
                break label2598;
              }
            }
            label2573:
            label2598:
            for (l1 = l4 - i;; l1 = 0L)
            {
              ((List)localObject2).addAll(0, ((MsgProxy)localObject1).a(paramString, paramInt1, l1, l4));
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 2, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
                l1 = l2;
              }
              break;
              ((List)localObject2).addAll(((List)localObject1).subList(i, k));
              break label2405;
            }
            for (;;)
            {
              l4 = l2 - 1L;
              long l5;
              long l6;
              if (paramInt2 - i < 0)
              {
                i = 0;
                l5 = l4 - i + 1L;
                l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1);
                i = 1;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 0, delSeq = " + l6 + ", endSeq = " + l4 + ",beginSeq = " + l5 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
                }
                if (l4 <= 0L)
                {
                  paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
                  i = 0;
                }
                if (l4 > l6) {
                  break label2952;
                }
                paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
                i = 0;
                l1 = l5;
              }
              for (;;)
              {
                label2773:
                l2 = l1;
                if (l1 < 0L) {
                  l2 = 0L;
                }
                localObject1 = new ArrayList();
                localObject4 = ((List)localObject2).iterator();
                for (;;)
                {
                  if (!((Iterator)localObject4).hasNext()) {
                    break label3064;
                  }
                  localObject5 = (MessageRecord)((Iterator)localObject4).next();
                  if (((MessageRecord)localObject5).shmsgseq < l2)
                  {
                    ((List)localObject1).add(localObject5);
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint invalid: id = " + ((MessageRecord)localObject5).getId() + ", msg = " + ((MessageRecord)localObject5).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject5).time + " , shMsgSeq = " + ((MessageRecord)localObject5).shmsgseq + " , extra = " + ((MessageRecord)localObject5).extraflag);
                    continue;
                    i = paramInt2 - i;
                    break;
                    label2952:
                    if (l5 > l6) {
                      break label4143;
                    }
                    l1 = l6 + 1L;
                    break label2773;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint valid: id = " + ((MessageRecord)localObject5).getId() + ", msg = " + ((MessageRecord)localObject5).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject5).time + " , shMsgSeq = " + ((MessageRecord)localObject5).shmsgseq + " , extra = " + ((MessageRecord)localObject5).extraflag);
                  }
                }
                label3064:
                ((List)localObject2).removeAll((Collection)localObject1);
                ((List)localObject1).clear();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 1, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
                }
                boolean bool2 = true;
                boolean bool1 = bool2;
                if (l4 >= l2)
                {
                  bool1 = bool2;
                  if (l4 > 0L)
                  {
                    bool1 = bool2;
                    if (i != 0)
                    {
                      localObject1 = new Bundle();
                      i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
                      ((Bundle)localObject1).putInt("counter", i);
                      ((Bundle)localObject1).putBoolean("success", false);
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), localObject2);
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis());
                      }
                      if (paramInt1 == 3000) {
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(paramString).longValue(), l2, l4, true, (Bundle)localObject1);
                      }
                      for (;;)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString, paramInt1), Boolean.valueOf(false));
                        if (NetworkUtil.f(BaseApplication.getContext())) {}
                        try
                        {
                          localObject2.wait(35000L);
                          bool1 = ((Bundle)localObject1).getBoolean("success");
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 4 , size = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
                          }
                          if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt1))) && (((Boolean)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.get(MsgProxyUtils.a(paramString, paramInt1))).booleanValue()))
                          {
                            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                            paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = null;
                            a(paramRefreshMessageContext, paramInt1);
                            return;
                            if (paramInt1 != 1) {
                              continue;
                            }
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, l2, l4, true, (Bundle)localObject1, 0);
                          }
                        }
                        catch (InterruptedException localInterruptedException)
                        {
                          for (;;)
                          {
                            localInterruptedException.printStackTrace();
                          }
                        }
                        finally {}
                      }
                    }
                  }
                }
                if (((((List)localObject2).isEmpty()) && (l4 > 0L)) || ((!bool1) && (((List)localObject2).size() < paramInt2)))
                {
                  if (((List)localObject2).isEmpty()) {
                    break label4136;
                  }
                  HashMap localHashMap = new HashMap();
                  localObject5 = ((List)localObject2).iterator();
                  while (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (MessageRecord)((Iterator)localObject5).next();
                    if (((MessageRecord)localObject6).shmsgseq == ((MessageRecord)((List)localObject2).get(0)).shmsgseq)
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      if (((MessageRecord)localObject6).getId() > 0L) {}
                      for (localObject1 = "id&" + ((MessageRecord)localObject6).getId();; localObject1 = "uniseq&" + ((MessageRecord)localObject6).uniseq)
                      {
                        localHashMap.put((String)localObject1 + "&" + ((MessageRecord)localObject6).shmsgseq, localObject6);
                        break;
                      }
                    }
                  }
                  ((List)localObject2).addAll(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)((List)localObject2).get(0)).shmsgseq, localHashMap));
                }
                label4125:
                label4136:
                for (l1 = ((MessageRecord)((List)localObject2).get(0)).shmsgseq - 1L;; l1 = l4)
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1);
                  if (localObject3 == null)
                  {
                    l2 = 0L;
                    localObject1 = ((MsgProxy)localObject1).a(paramString, paramInt1, l2, j, l1, paramInt2 - ((List)localObject2).size(), null);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam fail step 0 , size = " + ((List)localObject1).size() + ",seq = " + l1 + " , timestamp = " + System.currentTimeMillis());
                    }
                    if (!((List)localObject1).isEmpty()) {
                      break label4031;
                    }
                    paramRefreshMessageContext.jdField_a_of_type_Boolean = true;
                    label3912:
                    paramRefreshMessageContext.c = true;
                    label3918:
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, (List)localObject2);
                    paramRefreshMessageContext.jdField_a_of_type_JavaUtilList = ((List)localObject2);
                    paramString = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
                    localObject1 = new StringBuilder().append("refresh finish , context = ").append(paramRefreshMessageContext).append(" , size = ");
                    if (localObject2 != null) {
                      break label4125;
                    }
                  }
                  for (paramInt2 = -1;; paramInt2 = ((List)localObject2).size())
                  {
                    paramString.a(paramInt2, ", timestamp = " + System.currentTimeMillis());
                    a(paramRefreshMessageContext, paramInt1);
                    return;
                    l2 = ((MessageRecord)localObject3).getId();
                    break;
                    label4031:
                    ((List)localObject2).addAll(0, (Collection)localObject1);
                    break label3912;
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam addRoamMsgToList uniseq = " + l3 + " , locallist = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1, l3, (List)localObject2);
                    break label3918;
                  }
                }
                label4143:
                l1 = l5;
              }
              label4150:
              l2 = l1;
            }
          }
        }
      }
      i = 0;
      l3 = 0L;
    }
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread return : uin=null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc
 * JD-Core Version:    0.7.0.1
 */