package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LifeOnlineAccountInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import mqq.manager.Manager;

public class ConversationFacade
  extends Observable
  implements Manager
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "Q.unread.Facade";
  
  public ConversationFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ConversationProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  private MsgProxy a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt);
  }
  
  private QQMessageFacade a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  }
  
  private FriendManager a()
  {
    return (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3000) || (paramInt == 1);
  }
  
  private boolean a(MessageRecord paramMessageRecord, Set paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (MsgProxyUtils.a(paramMessageRecord, (MessageRecord)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    c(AppConstants.af, 1001);
    c(AppConstants.V, 1009);
    c(AppConstants.au, 1010);
  }
  
  private void c(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    label39:
    if (((Iterator)localObject).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if (MsgProxyUtils.b(localMessageRecord)) {
        break label150;
      }
      i = a(localMessageRecord.senderuin, localMessageRecord.istroop) + i;
    }
    label150:
    for (;;)
    {
      break label39;
      if (a(paramString, paramInt) != i) {
        a().a(paramString, paramInt, i);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.unread.Facade", 2, "calculateMsgBoxUnreadCount boxUin=" + paramString + ", unread=" + i);
      return;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public long a(String paramString, int paramInt)
  {
    return a().a(paramString, paramInt);
  }
  
  public Set a()
  {
    return a().a();
  }
  
  public void a()
  {
    a().c();
    Object localObject2 = a().a();
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject2).next();
      if (b(localConversationInfo.uin, localConversationInfo.type))
      {
        if (MsgProxyUtils.a(localConversationInfo.uin, localConversationInfo.type)) {
          c(localConversationInfo.uin, localConversationInfo.type);
        }
        if ((QLog.isColorLevel()) && (localConversationInfo.unreadCount != 0)) {
          QLog.d("Q.unread.Facade", 2, "initCache info=" + localConversationInfo.toString());
        }
      }
      else
      {
        if ((MsgProxyUtils.p(localConversationInfo.type)) && (!MsgProxyUtils.a(localConversationInfo.uin, localConversationInfo.type)) && (!a(localConversationInfo.uin, MsgProxyUtils.a(localConversationInfo.type)))) {
          ((Set)localObject1).add(localConversationInfo);
        }
        if ((QLog.isColorLevel()) && (localConversationInfo.unreadCount != 0)) {
          QLog.d("Q.unread.Facade", 2, "initCache [not in recent] info=" + localConversationInfo.toString());
        }
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ConversationInfo)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "initCache remove info=" + ((ConversationInfo)localObject2).toString());
        }
        a().a(((ConversationInfo)localObject2).uin, ((ConversationInfo)localObject2).type);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, a().a(paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "rewriteUnreadCount uin=" + paramString + ",type" + paramInt1 + ",unread" + paramInt2);
    }
    a().a(paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    long l = a().a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnread uin=" + paramString + ",type" + paramInt + ",unread" + l + " ,lastread" + paramLong);
    }
    if ((MsgProxyUtils.b(paramInt)) && (paramInt == 1008)) {
      ((LifeOnlineAccountInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82)).a(paramString);
    }
    a().a(paramString, paramInt, paramLong, 0);
    if (l > 0L)
    {
      if (MsgProxyUtils.c(paramInt)) {
        b();
      }
      QQMessageFacade.Message localMessage = a().a(paramString, paramInt);
      if (localMessage != null) {
        a(paramInt).a(paramString, paramInt, localMessage);
      }
    }
  }
  
  @Deprecated
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramInt2 = a().a(paramString2, paramInt2);
    int i = a().a(paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "moveBoxToMessageTab innerItemUnread=" + paramInt2 + ", convsItemUnread=" + i);
    }
    c(paramString1, paramInt1);
  }
  
  public void a(List paramList)
  {
    Object localObject1 = null;
    int i;
    MessageRecord localMessageRecord;
    Object localObject2;
    String str;
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "addUnread msg size=" + paramList.size());
      }
      Iterator localIterator = paramList.iterator();
      i = 0;
      paramList = (List)localObject1;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localMessageRecord = (MessageRecord)localIterator.next();
          localObject2 = paramList;
          if (localMessageRecord.isSendFromLocal()) {
            break label357;
          }
          localObject2 = paramList;
          if (localMessageRecord.isread) {
            break label357;
          }
          localObject1 = paramList;
          if (localMessageRecord.isLongMsg())
          {
            str = MsgProxyUtils.a(localMessageRecord);
            localObject2 = paramList;
            if (paramList == null) {
              localObject2 = new HashSet();
            }
            if (MsgProxyUtils.a(localMessageRecord))
            {
              paramList = (List)localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord)) {
                continue;
              }
              paramList = (List)localObject2;
              if (((Set)localObject2).contains(str)) {
                continue;
              }
              ((Set)localObject2).add(str);
              localObject1 = localObject2;
            }
          }
          else
          {
            label185:
            if (1001 != localMessageRecord.istroop) {
              break label297;
            }
            if (!AppConstants.af.equals(localMessageRecord.frienduin)) {
              break label278;
            }
            a().b(localMessageRecord.senderuin, 1001, 1);
            label226:
            localObject2 = localObject1;
            if (!MsgProxyUtils.c(localMessageRecord.istroop)) {
              break label357;
            }
            i = 1;
          }
        }
      }
    }
    label278:
    label297:
    label357:
    for (paramList = (List)localObject1;; paramList = (List)localObject2)
    {
      break;
      localObject1 = localObject2;
      if (!((Set)localObject2).contains(str)) {
        break label185;
      }
      ((Set)localObject2).remove(str);
      localObject1 = localObject2;
      break label185;
      a().b(localMessageRecord.frienduin, 1001, 1);
      break label226;
      if (1009 == localMessageRecord.istroop)
      {
        a().b(localMessageRecord.frienduin, 1009, 1);
        break label226;
      }
      a().b(localMessageRecord.frienduin, localMessageRecord.istroop, 1);
      break label226;
      if (i != 0) {
        b();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanAllUnread needUpdateMsgtable=" + paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = a().a().iterator();
      while (localIterator.hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)localIterator.next();
        if (localConversationInfo.unreadCount > 0) {
          a(localConversationInfo.uin, localConversationInfo.type);
        }
      }
    }
    a().d();
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    if (paramInt == 1009) {
      localObject = a(paramInt).a(AppConstants.V, 1009);
    }
    while ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((MessageRecord)((Iterator)localObject).next()).senderuin));
      return true;
      if (paramInt == 1001) {
        localObject = a(paramInt).a(AppConstants.af, 1001);
      } else if (paramInt == 1010) {
        localObject = a(paramInt).a(AppConstants.au, 1010);
      }
    }
    return false;
  }
  
  public int b(String paramString, int paramInt)
  {
    paramString = a(paramInt).a(paramString, paramInt);
    int i;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "list is null or list is empty");
      }
      i = 0;
      return i;
    }
    paramString = paramString.iterator();
    paramInt = 0;
    label52:
    if (paramString.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramString.next();
      if (!MsgProxyUtils.b(localMessageRecord)) {
        break label136;
      }
      paramInt = a(localMessageRecord.senderuin, localMessageRecord.istroop) + paramInt;
    }
    label136:
    for (;;)
    {
      break label52;
      i = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.unread.Facade", 2, "nUnreadCount=" + paramInt);
      return paramInt;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    a(paramString, paramInt);
    a().a(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "increaseUnread uin=" + paramString + ",type" + paramInt1 + ",count" + paramInt2);
    }
    a().b(paramString, paramInt1, paramInt2);
    if (MsgProxyUtils.c(paramInt1)) {
      b();
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "cleanUnreadFrom uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
    }
    c(paramString, paramInt, paramLong);
    a(paramInt).a(paramString, paramInt, paramLong);
    if (BadgeUtils.a())
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramString != null)
      {
        QCallFacade localQCallFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramInt = 0;
        if (localQCallFacade != null) {
          paramInt = localQCallFacade.a();
        }
        int i = paramString.e();
        BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt + i);
      }
    }
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramString);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(paramString, paramInt) != null) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (7000 == paramInt);
      bool1 = bool2;
    } while (a(paramInt));
    return b(paramString);
  }
  
  protected void c(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = a(paramInt).b(paramString, paramInt);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (a().a(paramString, paramInt) > 0) {
        a(paramString, paramInt, paramLong);
      }
      return;
    }
    ConversationInfo localConversationInfo;
    long l;
    label215:
    int j;
    if (((a(paramInt)) && (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq <= paramLong)) || ((a(paramInt)) || (((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time > paramLong) || (MsgProxyUtils.a(paramInt)) || (MsgProxyUtils.b(paramInt))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.unread.Facade", 2, "updateLastReadSeq uin=" + paramString + ",type=" + paramInt + ",lastread=" + paramLong);
      }
      localConversationInfo = a().a(paramString, paramInt);
      if (localConversationInfo == null) {
        break label976;
      }
      if (!a(paramInt)) {
        break label970;
      }
      l = Math.max(paramLong, localConversationInfo.lastread);
      j = localConversationInfo.unreadCount;
    }
    for (;;)
    {
      label255:
      int i;
      Object localObject2;
      label307:
      MessageRecord localMessageRecord;
      if (a(paramInt))
      {
        paramLong = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq - l;
        i = (int)paramLong;
        if (QLog.isColorLevel()) {
          QLog.d("Q.unread.Facade", 2, "updateLastReadSeq unread =" + i);
        }
        localObject2 = null;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label770;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        if (!a(paramInt)) {
          break label510;
        }
        paramLong = localMessageRecord.shmsgseq;
        label342:
        if (paramLong > l) {
          break label964;
        }
        if (!localMessageRecord.isLongMsg()) {
          break label553;
        }
        if (localObject1 != null) {
          break label967;
        }
        localObject1 = new HashMap();
      }
      label553:
      label955:
      label961:
      label964:
      label967:
      for (;;)
      {
        Object localObject3 = MsgProxyUtils.a(localMessageRecord);
        if (((Map)localObject1).containsKey(MsgProxyUtils.a(localMessageRecord)))
        {
          localObject3 = (Set)((Map)localObject1).get(localObject3);
          if ((localObject3 != null) && (!((Set)localObject3).isEmpty()) && (!a(localMessageRecord, (Set)localObject3))) {
            ((Set)localObject3).add(localMessageRecord);
          }
        }
        for (;;)
        {
          localObject3 = localObject2;
          if (paramLong > l)
          {
            if (MsgProxyUtils.m(localMessageRecord.msgtype))
            {
              i -= 1;
              break label307;
              if (a().a(paramString, paramInt) <= 0) {
                break;
              }
              a(paramString, paramInt, paramLong);
              return;
              paramLong = a(paramInt).b(paramString, paramInt, paramLong);
              break label255;
              label510:
              paramLong = localMessageRecord.time;
              break label342;
              HashSet localHashSet = new HashSet();
              localHashSet.add(localMessageRecord);
              ((Map)localObject1).put(localObject3, localHashSet);
              continue;
              if ((!MsgProxyUtils.h(localMessageRecord.msgtype)) || (localMessageRecord.isread)) {
                break label964;
              }
              i += 1;
              continue;
            }
            localObject3 = localObject2;
            if (localMessageRecord.isLongMsg())
            {
              if ((localObject1 != null) && (((Map)localObject1).containsKey(MsgProxyUtils.a(localMessageRecord))) && (a(localMessageRecord, (Set)((Map)localObject1).get(MsgProxyUtils.a(localMessageRecord)))))
              {
                i -= 1;
                break label307;
              }
              if (localObject2 != null) {
                break label961;
              }
              localObject2 = new HashSet();
            }
          }
          for (;;)
          {
            localObject3 = MsgProxyUtils.a(localMessageRecord);
            if (MsgProxyUtils.a(localMessageRecord))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord))
              {
                i -= 1;
                break label307;
              }
              if (((Set)localObject2).contains(localObject3))
              {
                i -= 1;
                break label307;
              }
              ((Set)localObject2).add(localObject3);
            }
            for (localObject3 = localObject2;; localObject3 = localObject2)
            {
              localObject2 = localObject3;
              break;
              if (((Set)localObject2).contains(localObject3)) {
                ((Set)localObject2).remove(localObject3);
              }
            }
            int k = i;
            if (MsgProxyUtils.b(paramInt))
            {
              k = i;
              if (paramInt == 1008)
              {
                k = ((LifeOnlineAccountInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82)).a(paramString, l);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.unread.Facade", 2, "updateLastReadSeq PreSendMsgCount=" + k);
                }
                k = i + k;
              }
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("updateLastReadSeq before=");
              if (localConversationInfo == null) {
                break label955;
              }
            }
            for (localObject1 = localConversationInfo.toString();; localObject1 = null)
            {
              QLog.d("Q.unread.Facade", 2, (String)localObject1 + " , end unread=" + k + ", lastread=" + l);
              a().a(paramString, paramInt, l, k);
              if ((k == j) || (!MsgProxyUtils.c(paramInt))) {
                break;
              }
              b();
              return;
            }
          }
        }
      }
      label770:
      label970:
      l = paramLong;
      break label215;
      label976:
      j = 0;
      l = paramLong;
    }
  }
  
  public boolean c(String paramString, int paramInt)
  {
    Object localObject = a(paramInt).a(paramString, paramInt);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!MsgProxyUtils.b((MessageRecord)((Iterator)localObject).next())) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.unread.Facade", 2, "isAllOneWayConversation boxUin=" + paramString + ", rtn true");
    }
    return true;
  }
  
  public void onDestroy()
  {
    deleteObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ConversationFacade
 * JD-Core Version:    0.7.0.1
 */