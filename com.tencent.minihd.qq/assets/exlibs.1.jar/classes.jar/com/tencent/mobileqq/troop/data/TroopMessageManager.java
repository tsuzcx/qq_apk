package com.tencent.mobileqq.troop.data;

import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.BaseMessageManager.AddMessageContext;
import com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kkw;

public class TroopMessageManager
  extends BaseMessageManagerForTroopAndDisc
{
  public TroopMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    if (paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0).contains("special_sound_type" + paramQQAppInterface.a() + paramString)) {
      bool = true;
    }
    return bool;
  }
  
  private void d(String paramString, int paramInt, long paramLong)
  {
    if ((paramString == null) || (paramLong < 0L)) {}
    RecentUser localRecentUser;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          localRecentUser = ((RecentUserProxy)localObject).a(paramString, paramInt);
        } while ((localRecentUser == null) || (!localRecentUser.shouldShowInRecentList()) || (((!(localRecentUser.msg instanceof TroopAtMeMsg)) || (((TroopAtMeMsg)localRecentUser.msg).a.a > paramLong)) && ((!(localRecentUser.msg instanceof TroopSpecialAttentionMsg)) || (((TroopSpecialAttentionMsg)localRecentUser.msg).a.a > paramLong)) && ((!(localRecentUser.msg instanceof TroopAtAllMsg)) || (((TroopAtAllMsg)localRecentUser.msg).a.a > paramLong))));
        localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
        ((RecentUserProxy)localObject).a(localRecentUser);
        Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        ((TroopInfoManager)localObject).a(paramString, 5);
        ((TroopInfoManager)localObject).a(paramString, 2);
        ((TroopInfoManager)localObject).a(paramString, 3);
        ((TroopInfoManager)localObject).a(paramString, 4);
      } while (paramInt != 1);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
    } while ((paramInt == 1) || (paramInt == 4));
    RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo.unreadCount > 0)
    {
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type)) && (!localHotChatManager.d(paramConversationInfo.uin))) {
          return paramConversationInfo.unreadCount;
        }
        return 0;
      }
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramString1)) {}
    for (paramString2 = "我"; paramString2 == null; paramString2 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1)) {
      return paramString1;
    }
    return paramString2;
  }
  
  public List a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
    return super.a(paramString, paramInt, paramBoolean);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, TroopTipsEntity paramTroopTipsEntity)
  {
    if ((paramString == null) || (paramTroopTipsEntity == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addTroopTipsMessage parm null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "addTroopTipsMessage troopTipsEntity.optShowLatest:" + paramTroopTipsEntity.optShowLatest);
        }
        if (((paramQQAppInterface.a().a() != 1) || (!paramString.equals(paramQQAppInterface.a().a()))) && (!paramTroopTipsEntity.need2InsertIntoMsgListRightNow())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "insert TroopTips into messageList right now");
        }
        paramTroopTipsEntity.read = true;
        paramQQAppInterface = (TroopTipsMsgMgr)paramQQAppInterface.getManager(76);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.a(paramTroopTipsEntity);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "insert TroopTips into messageList right now");
      }
      paramString = (TroopTipsMsgMgr)paramQQAppInterface.getManager(76);
    } while (paramString == null);
    paramString.a(paramQQAppInterface, paramTroopTipsEntity);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "addTroopNotificationMessage");
    }
    paramString1 = paramQQAppInterface.a(1).e(String.valueOf(paramString2), 1);
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if (paramInt1 == 23)
      {
        paramString1 = paramQQAppInterface.a().createEntityManager();
        paramString2 = paramArrayList.iterator();
        while (paramString2.hasNext())
        {
          paramArrayList = (TroopNotificationCache)paramString2.next();
          paramArrayList.read = true;
          paramArrayList.currentUin = paramQQAppInterface.a();
          paramString1.a(paramArrayList);
        }
        paramString1.a();
        return;
      }
      TroopNotificationHelper.a(paramQQAppInterface, paramString2, paramArrayList, paramInt2);
      return;
    }
    TroopNotificationHelper.a(paramQQAppInterface, paramString2, paramArrayList, paramInt2);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap1 = paramAddMessageContext.jdField_a_of_type_JavaUtilMap;
    Map localMap2 = paramAddMessageContext.b;
    TroopInfoManager localTroopInfoManager = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager;
    Object localObject1 = paramAddMessageContext.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int j = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    RecentUser localRecentUser = ((RecentUserProxy)localObject1).a(str1, paramMessageRecord.istroop);
    localObject1 = null;
    Object localObject2;
    if (localTroopInfoManager != null)
    {
      localObject2 = localTroopInfoManager.a(str1);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        if (((MessageInfo)localObject2).a() == paramMessageRecord.shmsgseq) {
          break label662;
        }
        localObject1 = null;
      }
    }
    int i;
    if (j == 1)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str1);
      if ((localRecentUser.msgType != 4) && (localObject1 != null) && (((MessageInfo)localObject1).a() == 4)) {
        if ((i == 1) || (i == 4)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_norm", 0, 0, localRecentUser.uin, "", "", "");
        }
      }
    }
    for (;;)
    {
      label237:
      if ((localObject1 != null) && (((MessageInfo)localObject1).b()))
      {
        int k = ((MessageInfo)localObject1).a();
        if (k >= localRecentUser.msgType)
        {
          localRecentUser.msgType = k;
          localRecentUser.msg = MessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, (MessageInfo)localObject1, localRecentUser.msg);
        }
      }
      MessageNavInfo localMessageNavInfo;
      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin))
      {
        localMessageNavInfo = new MessageNavInfo();
        localMessageNavInfo.a = paramMessageRecord.shmsgseq;
        localMessageNavInfo.b = paramMessageRecord.uniseq;
        if (localObject1 != null) {
          break label1170;
        }
      }
      label1170:
      for (localObject2 = new MessageInfo();; localObject2 = localObject1)
      {
        if (((MessageInfo)localObject2).d.a(localMessageNavInfo)) {
          localTroopInfoManager.a(str1, 4, ((MessageInfo)localObject2).d.b, "");
        }
        if (localMap1.containsKey(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type))) {}
        for (localObject2 = (RecentUser)localMap1.get(MsgProxyUtils.a(localRecentUser.uin, localRecentUser.type));; localObject2 = localRecentUser)
        {
          if (!MsgProxyUtils.g(paramMessageRecord.msgtype))
          {
            if ((j != 1) || (i == 1) || (i == 4)) {
              break label1111;
            }
            if ((localObject1 != null) && ((((MessageInfo)localObject1).a() == 3) || (((MessageInfo)localObject1).a() == 4) || (((MessageInfo)localObject1).a() == 2)))
            {
              ((RecentUser)localObject2).uin = str1;
              if ((j == 1000) || (j == 1020) || (j == 1004)) {
                ((RecentUser)localObject2).troopUin = str2;
              }
              ((RecentUser)localObject2).type = j;
              if (l > ((RecentUser)localObject2).lastmsgtime) {
                ((RecentUser)localObject2).lastmsgtime = l;
              }
              localMap1.put(MsgProxyUtils.a(str1, j), localObject2);
            }
            if ((TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1)) && ((!localMap2.containsKey(MsgProxyUtils.a(str1, j))) || (((MessageRecord)localMap2.get(MsgProxyUtils.a(str1, j))).time <= paramMessageRecord.time))) {
              localMap2.put(MsgProxyUtils.a(str1, j), paramMessageRecord);
            }
          }
          for (;;)
          {
            super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramAddMessageContext);
            return;
            label662:
            localObject1 = localObject2;
            if (!paramMessageRecord.isread) {
              break;
            }
            localTroopInfoManager.b(str1);
            localObject1 = null;
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localRecentUser.uin) == 2)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
              break label237;
              if ((localRecentUser.msgType != 3) && (localRecentUser.msgType != 4) && (localObject1 != null) && (((MessageInfo)localObject1).a() == 3))
              {
                if ((i == 3) || (i == 4))
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_allscreen", 0, 0, localRecentUser.uin, "", "", "");
                  break label237;
                }
                if (i == 2)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
                  break label237;
                }
                if (i != 1) {
                  break label1108;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_norm", 0, 0, localRecentUser.uin, "", "", "");
                break label237;
              }
              if ((localRecentUser.msgType != 3) && (localRecentUser.msgType != 4) && (localRecentUser.msgType != 2) && (localObject1 != null) && (((MessageInfo)localObject1).a() == 2))
              {
                if ((i == 3) || (i == 4))
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_allscreen", 0, 0, localRecentUser.uin, "", "", "");
                  break label237;
                }
                if (i == 2)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_grphelper", 0, 0, localRecentUser.uin, "", "", "");
                  break label237;
                }
                if (i == 1) {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_norm", 0, 0, localRecentUser.uin, "", "", "");
                }
              }
            }
            label1108:
            break label237;
            label1111:
            ((RecentUser)localObject2).uin = str1;
            ((RecentUser)localObject2).type = j;
            if (l > ((RecentUser)localObject2).lastmsgtime) {
              ((RecentUser)localObject2).lastmsgtime = l;
            }
            localMap1.put(MsgProxyUtils.a(str1, j), localObject2);
          }
        }
      }
      i = -9999;
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    d(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.f = false;
    paramRefreshMessageContext.d = true;
    paramRefreshMessageContext.a = paramString;
    paramRefreshMessageContext.c = paramInt;
    if ((!paramRefreshMessageContext.h) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt))))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString, paramInt), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new kkw(this, paramRefreshMessageContext, paramString, paramInt, paramLong2, paramBoolean));
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString1);
    if ((paramInt == 1) && (i != 1) && (i != 4))
    {
      if (i == 2) {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      }
      try
      {
        TroopAssistantManager.a().a(paramString1, paramLong, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramString2.a();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(null);
        return;
      }
      finally
      {
        paramString2.a();
      }
    }
    super.a(paramString1, paramInt, paramString2, paramString3, paramLong);
  }
  
  public void a(String paramString, long paramLong, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label327:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (MsgProxyUtils.n(((ChatMessage)localObject2).msgtype));
      }
      for (long l1 = ((ChatMessage)localObject2).shmsgseq;; l1 = 0L)
      {
        if ((l1 > paramLong) || (paramLong == 0L) || (l1 == 0L)) {
          break label327;
        }
        long l2 = MessageCache.a();
        localObject1 = paramList.iterator();
        do
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (((ChatMessage)localObject2).shmsgseq != paramLong);
        l1 = ((ChatMessage)localObject2).time;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = (MessageForTroopUnreadTips)MessageRecordFactory.a(-4009);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, paramString, (String)localObject2, "", l1, -4009, 1, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = paramLong;
        paramString = new ArrayList();
        paramString.add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, (String)localObject2, false, false);
        paramString = new ArrayList();
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add((ChatMessage)((Iterator)localObject2).next());
        }
        MsgProxyUtils.a(paramString, (MessageRecord)localObject1, true);
        paramList.clear();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          paramList.add((ChatMessage)paramString.next());
        }
        break;
      }
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt));
  }
  
  public void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RecentUser localRecentUser = localProxyManager.a().a(paramString, paramInt);
    if ((localRecentUser.shouldShowInRecentList()) || (localRecentUser.msgType == 1))
    {
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localProxyManager.a().a(localRecentUser);
    }
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
      if ((paramInt != 1) && (paramInt != 4))
      {
        RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
      }
    }
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0) {
      d(paramString, paramInt, paramLong);
    }
    super.c(paramString, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageManager
 * JD-Core Version:    0.7.0.1
 */