package com.tencent.mobileqq.app.message;

import ActionMsg.MsgBody;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hsi;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public abstract class BaseMessageManager
  implements IMessageManager
{
  protected static final long a = 35000L;
  public static final String a = "Q.msg.BaseMessageManager";
  protected static final long b = 40000L;
  public QQAppInterface a;
  public QQMessageFacade a;
  private Object a;
  
  public BaseMessageManager(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQMessageFacade;
  }
  
  private long a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject = null;
    if (MsgProxyUtils.a(paramInt) == 1009) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.V, 1009);
    }
    while ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      MessageRecord localMessageRecord;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      } while (!paramString.equals(localMessageRecord.senderuin));
      return localMessageRecord.uniseq;
      if (MsgProxyUtils.a(paramInt) == 1001) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.af, 1001);
      } else if (MsgProxyUtils.a(paramInt) == 1010) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(AppConstants.au, 1010);
      }
    }
    return 0L;
  }
  
  private boolean a(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (paramConversationInfo.unreadCount > 0) {
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 6)
      {
        if ((paramConversationInfo.type == 1001) && (AppConstants.af.equals(paramConversationInfo.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(AppConstants.V)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(AppConstants.au)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type))) {
          return paramConversationInfo.unreadCount;
        }
      }
      else {
        return paramConversationInfo.unreadCount;
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + paramString + ", type = " + paramInt + ", needDeleteDB = " + paramBoolean1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, paramBoolean1);
    Object localObject;
    switch (paramInt)
    {
    default: 
      if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString);
      }
      if (i > 0) {
        localMessage.cleanMessageRecordBaseField();
      }
      if ((paramInt != 3000) && (paramInt != 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, MsgProxyUtils.a(paramInt))))
      {
        if (MsgProxyUtils.a(paramInt) != 1009) {
          break label328;
        }
        a(AppConstants.V, 1009, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.V, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, localMessage.istroop);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((RecentUser)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.remove(MsgProxyUtils.a(paramString, paramInt));
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessage);
      return i;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 0);
      break;
      label328:
      if (MsgProxyUtils.a(paramInt) == 1001)
      {
        a(AppConstants.af, 1001, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.af, 1001);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (MsgProxyUtils.a(paramInt) == 1010)
      {
        a(AppConstants.au, 1010, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.au, 1010);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
    }
  }
  
  public abstract long a(MessageRecord paramMessageRecord);
  
  public QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramString == null)
    {
      paramString = (String)localObject2;
      return paramString;
    }
    String str = MsgProxyUtils.a(paramString, paramInt);
    localObject2 = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    if ((localObject2 == null) || (!((QQMessageFacade.Message)localObject2).isCacheValid))
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(AppConstants.Y))) {
        localObject1 = DataLineMsgRecord.tableName();
      }
      QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject1, paramEntityManager);
      Object localObject3 = localObject1;
      localObject2 = localMessage;
      if (localMessage == null) {
        if ((!MsgProxyUtils.c(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject1;
          localObject2 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a((String)localObject3, paramEntityManager);
        }
      }
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" message:" + localObject2);
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).b(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject2).istroop).a((String)localObject3, paramEntityManager);
          localObject1 = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject1 = paramEntityManager;
          }
        }
      }
      if (localObject1 != null)
      {
        if (paramString.equals(String.valueOf(AppConstants.Y)))
        {
          paramString = new DataLineMsgRecord();
          DataLineMsgRecord.unpackMsgData(paramString, ((QQMessageFacade.Message)localObject1).msgData, ((QQMessageFacade.Message)localObject1).versionCode);
          ((QQMessageFacade.Message)localObject1).msg = paramString.msg;
        }
        if ((AppConstants.af.equals(((QQMessageFacade.Message)localObject1).frienduin)) || (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) != 1001))
        {
          paramString = (String)localObject1;
          if (!AppConstants.au.equals(((QQMessageFacade.Message)localObject1).frienduin))
          {
            paramString = (String)localObject1;
            if (MsgProxyUtils.a(((QQMessageFacade.Message)localObject1).istroop) != 1010) {}
          }
        }
        else
        {
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((QQMessageFacade.Message)localObject1).istroop).b(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          paramString = (String)localObject1;
          if (paramEntityManager != null)
          {
            paramString = (String)localObject1;
            if (paramEntityManager.size() > 0)
            {
              paramEntityManager = paramEntityManager.iterator();
              do
              {
                paramString = (String)localObject1;
                if (!paramEntityManager.hasNext()) {
                  break;
                }
                paramString = (MessageRecord)paramEntityManager.next();
              } while ((paramString.senderuin == null) || (!paramString.senderuin.equals(paramString.frienduin)));
              ((QQMessageFacade.Message)localObject1).hasReply = true;
              paramString = (String)localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
                paramString = (String)localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramEntityManager = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str);
        if (paramEntityManager != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
        paramEntityManager = paramString;
      }
      catch (Throwable localThrowable)
      {
        paramEntityManager = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramEntityManager = paramString;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramString = paramEntityManager;
      if (paramEntityManager == null) {
        break;
      }
      paramString = paramEntityManager;
      if (!MsgProxyUtils.a(paramEntityManager.frienduin, paramEntityManager.istroop)) {
        break;
      }
      paramEntityManager.istroop = MsgProxyUtils.a(paramEntityManager.istroop);
      return paramEntityManager;
      paramEntityManager = new QQMessageFacade.Message();
      paramEntityManager.frienduin = paramString;
      paramEntityManager.istroop = paramInt;
      paramString = paramEntityManager;
      continue;
      if (a(paramEntityManager) < a(paramString))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else if ((!paramEntityManager.isCacheValid) && (paramString.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramEntityManager.isCacheValid = true;
        paramString = paramEntityManager;
        continue;
        paramEntityManager = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localObject2);
          paramEntityManager = localThrowable;
        }
      }
    }
  }
  
  public List a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt, true, true);
    if (localObject1 == null) {
      return new ArrayList();
    }
    Object localObject2 = (List)((ArrayList)localObject1).clone();
    MsgProxyUtils.a((List)localObject2);
    MsgProxyUtils.a(paramString, paramInt, (List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((!((List)localObject2).isEmpty()) && ((((List)localObject2).get(((List)localObject2).size() - 1) instanceof MessageForLongMsg)) && (MsgProxyUtils.a((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1), this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt))))
    {
      localObject1 = (MessageForLongMsg)((List)localObject2).get(((List)localObject2).size() - 1);
      if ((((MessageForLongMsg)localObject1).longMsgFragmentList != null) && (!((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty()) && (((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0)).longMsgIndex < this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt).longMsgIndex))
      {
        a((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), true, 2);
        b(paramString, paramInt, (MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), 2);
        a((MessageRecord)localObject1, true, 3);
        b(paramString, paramInt, (MessageRecord)localObject1, 3);
      }
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("newAIOCursor clone ");
      if (localObject2 == null) {
        break label407;
      }
    }
    Object localObject4;
    label407:
    for (localObject1 = Integer.valueOf(((List)localObject2).size());; localObject1 = "clone is null")
    {
      QLog.d("Q.msg.BaseMessageManager", 2, localObject1);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label566;
        }
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        ((List)localObject1).add((ChatMessage)localObject3);
        localObject4 = ((MessageRecord)localObject3).getExtInfoFromExtStr("sens_msg_ctrl_info");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          if (!((MessageRecord)localObject3).isSend()) {
            break;
          }
          ((MessageRecord)localObject3).saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
        }
      }
    }
    bankcode_info.BankcodeCtrlInfo localBankcodeCtrlInfo = new bankcode_info.BankcodeCtrlInfo();
    for (;;)
    {
      try
      {
        localBankcodeCtrlInfo.mergeFrom(HexUtil.hexStr2Bytes((String)localObject4));
        if (!localBankcodeCtrlInfo.msgtail_id.has()) {
          break label569;
        }
        paramInt = localBankcodeCtrlInfo.msgtail_id.get();
        if (paramInt != 1) {
          break;
        }
        ((ChatMessage)localObject3).parse();
        localObject4 = MessageRecordFactory.a(-1014);
        ((MessageRecord)localObject4).msgtype = -1046;
        ((MessageRecord)localObject4).senderuin = ((MessageRecord)localObject4).selfuin;
        ((MessageRecord)localObject4).frienduin = paramString;
        ((MessageRecord)localObject4).istroop = ((MessageRecord)localObject3).istroop;
        ((MessageRecord)localObject4).msg = "";
        ((MessageRecord)localObject4).isread = true;
        ((MessageRecord)localObject4).saveExtInfoToExtStr("sens_msg_uniseq", Long.toString(((MessageRecord)localObject3).uniseq));
        ((List)localObject1).add((ChatMessage)localObject4);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      label566:
      return localObject1;
      label569:
      paramInt = 0;
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (((paramMessage.msgtype == -1003) || (paramMessage.msgtype == -1032) || (paramMessage.msgtype == 201)) && (paramMessage.istroop == 1001)) {}
    label779:
    label1944:
    for (;;)
    {
      Object localObject3;
      try
      {
        paramMessage.msg = ActionMsgUtil.a(paramMessage.msg).msg;
        if (paramMessage.msgtype != -2018) {
          break label683;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131367193);
      }
      catch (Exception paramMessage)
      {
        try
        {
          localObject3 = new structmsg.StructMsg();
          ((structmsg.StructMsg)localObject3).mergeFrom(paramMessage.msgData);
          if (((structmsg.StructMsg)localObject3).msg_type.get() == 1) {
            switch (((structmsg.StructMsg)localObject3).msg.sub_type.get())
            {
            case 2: 
            case 3: 
              localObject1 = ((structmsg.StructMsg)localObject3).msg.msg_describe.get();
              localObject1 = ((structmsg.StructMsg)localObject3).msg.req_uin_nick.get() + (String)localObject1;
              paramMessage.msg = ((String)localObject1);
              if ((!ActionMsgUtil.a(paramMessage.msgtype)) && (paramMessage.msgtype != -3001) && (paramMessage.msgtype != -30002)) {
                if (paramMessage.msgtype != -30003) {
                  continue;
                }
              }
              break;
            }
          }
        }
        catch (Exception paramMessage)
        {
          throw paramMessage;
        }
        try
        {
          localObject1 = ActionMsgUtil.a(paramMessage.msg);
          paramMessage.msg = ((MsgBody)localObject1).msg;
          paramMessage.action = ((MsgBody)localObject1).action;
          paramMessage.shareAppID = ((MsgBody)localObject1).shareAppID;
          paramMessage.actMsgContentValue = ((MsgBody)localObject1).actMsgContentValue;
          localObject1 = null;
          if ((!AppConstants.ag.equals(paramMessage.senderuin)) || (paramMessage.msgtype != -2011)) {
            localObject1 = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.msg, paramMessage.senderuin, paramMessage.msgtype);
          }
          b(paramMessage);
          if (localObject1 == null) {
            break label779;
          }
          paramMessage.msg = ((SystemMsg)localObject1).message;
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 4, "addFrindSystemMsg decode end" + paramMessage.msg);
          }
          return;
        }
        catch (Exception paramMessage)
        {
          throw paramMessage;
        }
        paramMessage = paramMessage;
        throw paramMessage;
      }
      continue;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131367194);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131367195);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131367202);
      continue;
      localObject1 = "";
      int i = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "groupMsgType:" + i + "|req_uin_nick:" + ((structmsg.StructMsg)localObject3).msg.req_uin_nick.get() + "|actor_uin_nick:" + ((structmsg.StructMsg)localObject3).msg.actor_uin_nick.get() + "|action_uin_nick:" + ((structmsg.StructMsg)localObject3).msg.action_uin_nick.get() + "|msg_describe:" + ((structmsg.StructMsg)localObject3).msg.msg_describe.get());
      }
      i = TroopUtils.a(i);
      if (i == 1) {
        localObject1 = ((structmsg.StructMsg)localObject3).msg.action_uin_nick.get();
      }
      for (;;)
      {
        localObject1 = TroopUtils.a((structmsg.StructMsg)localObject3, (String)localObject1 + ((structmsg.StructMsg)localObject3).msg.msg_describe.get());
        break;
        if (i == 2) {
          localObject1 = ((structmsg.StructMsg)localObject3).msg.req_uin_nick.get();
        }
      }
      label683:
      if (paramMessage.msgtype == -2011)
      {
        localObject3 = StructMsgFactory.a(paramMessage.msgData);
        localObject1 = "";
        if (localObject3 != null) {
          localObject1 = ((AbsStructMsg)localObject3).mMsgBrief;
        }
        paramMessage.msg = ((String)localObject1);
      }
      else if (paramMessage.msgtype == -5003)
      {
        localObject1 = new SubMsgType0x76.MsgBody();
        ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramMessage.msgData);
        paramMessage.msg = ActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (SubMsgType0x76.MsgBody)localObject1);
        continue;
        if (paramMessage.msgtype == -2007)
        {
          paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368619);
          return;
        }
        if (paramMessage.msgtype == -1035)
        {
          localObject1 = new MessageForMixedMsg();
          ((MessageForMixedMsg)localObject1).msgData = paramMessage.msgData;
          ((MessageForMixedMsg)localObject1).parse();
          paramMessage.msg = ((MessageForMixedMsg)localObject1).msg;
          if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg))) {
            paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
          }
        }
        else if ((paramMessage.msgtype == -5000) || (paramMessage.msgtype == -5001))
        {
          localObject1 = new MessageForNewGrayTips();
          ((MessageForNewGrayTips)localObject1).msgData = paramMessage.msgData;
          ((MessageForNewGrayTips)localObject1).parse();
          paramMessage.msg = ((MessageForNewGrayTips)localObject1).msg;
          if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg))) {
            paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
          }
        }
        else if ((paramMessage.msgtype == -4500) || (paramMessage.msgtype == -4502) || (paramMessage.msgtype == -4503) || (paramMessage.msgtype == -4501))
        {
          if (paramMessage.msgData != null)
          {
            localObject1 = null;
            switch (paramMessage.msgtype)
            {
            }
            while (localObject1 != null)
            {
              ((ChatMessage)localObject1).msgData = paramMessage.msgData;
              ((ChatMessage)localObject1).parse();
              paramMessage.msg = ((ChatMessage)localObject1).msg;
              if (paramMessage.msgtype != -4501) {
                break label1195;
              }
              paramMessage.msg = ((MessageForDevPtt)localObject1).getSummary();
              return;
              localObject1 = new MessageForDeviceFile();
              continue;
              localObject1 = new MessageForDeviceSingleStruct();
              continue;
              localObject1 = new MessageForDevPtt();
              continue;
              localObject1 = new MessageForDevShortVideo();
              continue;
              localObject1 = new MessageForNewGrayTips();
            }
            continue;
            label1195:
            if (paramMessage.msgtype == -4503) {
              paramMessage.msg = ((MessageForDevShortVideo)localObject1).getSummary();
            }
          }
        }
        else if ((paramMessage.msgtype == -3006) || (paramMessage.msgtype == -5004))
        {
          if (paramMessage.msgtype == -3006)
          {
            localObject1 = XMLMessageUtils.a(paramMessage);
            if ((localObject1 == null) || (((PAMessage)localObject1).items == null) || (((PAMessage)localObject1).items.size() == 0))
            {
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368503);
              return;
            }
            localObject3 = ((PAMessage.Item)((PAMessage)localObject1).items.get(0)).title;
            if ((((PAMessage.Item)((PAMessage)localObject1).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject1).items.get(0)).digestList != null)) {}
            for (paramMessage.msg = ((String)localObject3 + "：" + (String)((PAMessage.Item)((PAMessage)localObject1).items.get(0)).digestList.get(0)); TextUtils.isEmpty(paramMessage.msg); paramMessage.msg = ((String)localObject3))
            {
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368503);
              return;
            }
          }
          else
          {
            paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368503);
          }
        }
        else
        {
          Object localObject2;
          if (paramMessage.msgtype == -2010)
          {
            localObject1 = new FunnyFaceMessage();
            try
            {
              ((FunnyFaceMessage)localObject1).readExternal(new ObjectInputStream(new ByteArrayInputStream(paramMessage.msgData)));
              if (localObject1 == null) {
                continue;
              }
              if (((FunnyFaceMessage)localObject1).faceId == 1)
              {
                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366119);
                return;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.BaseMessageManager", 2, localException1.toString());
                }
                localObject2 = null;
              }
            }
            if (((FunnyFaceMessage)localObject2).faceId == 2) {
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366120);
            }
          }
          else
          {
            if (paramMessage.msgtype == -2000)
            {
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131365739);
              return;
            }
            if (paramMessage.msgtype == -2005)
            {
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367594);
              return;
            }
            if (paramMessage.msgtype == -2020)
            {
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366056);
              if (MsgUtils.a(paramMessage.issend))
              {
                localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, "", 0, 0);
                paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366057, new Object[] { localObject2 });
                return;
              }
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366056);
              return;
            }
            if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
            {
              paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368067);
              try
              {
                paramMessage.pttUrl = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq)).url;
                return;
              }
              catch (Exception paramMessage)
              {
                paramMessage.printStackTrace();
                return;
              }
            }
            if (paramMessage.msgtype == -2025)
            {
              if (paramMessage.msgData != null)
              {
                try
                {
                  localObject2 = new MessageForQQWalletMsg();
                  ((MessageForQQWalletMsg)localObject2).msgData = paramMessage.msgData;
                  ((MessageForQQWalletMsg)localObject2).parse();
                  paramMessage.msg = ((MessageForQQWalletMsg)localObject2).getMsgSummary();
                  return;
                }
                catch (Exception paramMessage) {}
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.BaseMessageManager", 2, paramMessage.toString());
                }
              }
            }
            else if ((paramMessage.msg != null) && (!"".equals(paramMessage.msg)))
            {
              localObject2 = paramMessage.msg;
              if (a((String)localObject2))
              {
                localObject2 = localObject2.split("\026")[1].split("\\|");
                if (localObject2 != null)
                {
                  if (localObject2.length < 2)
                  {
                    i = 1;
                    paramMessage.fileType = i;
                  }
                  for (;;)
                  {
                    try
                    {
                      if (localObject2.length < 2)
                      {
                        l = -1L;
                        paramMessage.fileSize = l;
                      }
                    }
                    catch (Exception localException2)
                    {
                      long l;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", localException2);
                      paramMessage.fileSize = -1L;
                      continue;
                      if (paramMessage.msgtype != -3001) {
                        continue;
                      }
                      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368620);
                      return;
                      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131365739);
                      return;
                    }
                    switch (i)
                    {
                    case 3: 
                    default: 
                      return;
                    case 0: 
                      paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367594);
                      return;
                      i = Integer.valueOf(localObject2[2]).intValue();
                      break label1944;
                      l = Long.valueOf(localObject2[1]).longValue();
                    }
                  }
                  paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368067);
                  paramMessage.pttUrl = localObject2[0];
                }
              }
              else
              {
                if (paramMessage.msgtype == -2006)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
                  }
                  paramMessage.msg = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368067) + "(0x7f)");
                  return;
                }
                if (paramMessage.msgtype == -2008)
                {
                  paramMessage.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368539);
                  return;
                }
                if (paramMessage.msg.indexOf("http://maps.google.com/maps?q=") != -1)
                {
                  String[] arrayOfString = MessageUtils.a(paramMessage.msg);
                  String str = "";
                  localObject2 = str;
                  if (arrayOfString != null)
                  {
                    localObject2 = str;
                    if (arrayOfString[2] != null) {
                      localObject2 = arrayOfString[2];
                    }
                  }
                  paramMessage.fileType = 65536;
                  paramMessage.msg = ("[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366488) + "] " + (String)localObject2);
                  return;
                }
                paramMessage.emoRecentMsg = new QQText(paramMessage.msg, 3, 16);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramRefreshMessageContext.h)
      {
        paramRefreshMessageContext.h = false;
        this.jdField_a_of_type_JavaLangObject.notify();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
        }
      }
      return;
    }
  }
  
  protected void a(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, int paramInt)
  {
    int j;
    if ((paramRefreshMessageContext.jdField_a_of_type_JavaUtilList != null) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      j = 1;
      MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaUtilList);
      i = j;
      if (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.size() > 0) {
        MsgProxyUtils.a(paramRefreshMessageContext.jdField_a_of_type_JavaLangString, paramRefreshMessageContext.c, paramRefreshMessageContext.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (int i = j;; i = 0)
    {
      String str = paramRefreshMessageContext.jdField_a_of_type_JavaLangString;
      j = paramRefreshMessageContext.jdField_d_of_type_Int;
      if ((paramRefreshMessageContext.jdField_d_of_type_Boolean) && (i != 0) && (paramRefreshMessageContext.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramRefreshMessageContext.jdField_a_of_type_Int < 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + paramRefreshMessageContext.jdField_a_of_type_Int + " ]");
        }
        paramRefreshMessageContext.jdField_a_of_type_Int += 1;
        b(str, paramInt, j, paramRefreshMessageContext);
      }
      do
      {
        return;
        paramRefreshMessageContext.jdField_a_of_type_Int = 0;
        paramRefreshMessageContext.b = 0;
      } while (!paramRefreshMessageContext.f);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject != null) {
      b(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, (MessageRecord)localObject, 4);
    }
    for (;;)
    {
      return;
      localObject = null;
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1001)
      {
        a(AppConstants.af, 1001, paramMessageRecord.frienduin, str);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.af, 1001);
      }
      while ((localObject != null) && (((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramMessageRecord.frienduin)))
      {
        ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        return;
        if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1009)
        {
          a(AppConstants.V, 1009, paramMessageRecord.frienduin, str);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.V, 1009);
        }
        else if (MsgProxyUtils.a(paramMessageRecord.istroop) == 1010)
        {
          a(AppConstants.au, 1010, paramMessageRecord.frienduin, str);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.au, 1010);
        }
      }
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, true);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {}
    int i;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return;
        paramEntityManager = paramAddMessageContext.c;
        if (paramMessageRecord.time == 0L) {
          paramMessageRecord.time = MessageCache.a();
        }
        if (paramMessageRecord.msgseq == 0L) {
          paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
        }
        paramAddMessageContext = paramMessageRecord.frienduin;
        i = paramMessageRecord.istroop;
        if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + paramMessageRecord.getBaseInfoString());
          }
          paramMessageRecord.extraflag = 32772;
          paramMessageRecord.sendFailCode = 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, null, paramBoolean1, paramBoolean2, paramBoolean4);
        if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 0)) {
          break;
        }
      } while (!a(paramMessageRecord, false, 1));
      if ((!paramEntityManager.containsKey(MsgProxyUtils.a(paramAddMessageContext, i))) || (paramMessageRecord.isSendFromLocal()))
      {
        paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
        return;
      }
      localMessageRecord = (MessageRecord)paramEntityManager.get(MsgProxyUtils.a(paramAddMessageContext, i));
    } while (a(paramMessageRecord) < a(localMessageRecord));
    paramEntityManager.put(MsgProxyUtils.a(paramAddMessageContext, i), paramMessageRecord);
    return;
    a(paramMessageRecord, true, 1);
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      localArrayList.addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      if (!MsgProxyUtils.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label359;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord : uniseq:" + paramMessageRecord.uniseq + " _id:" + paramMessageRecord.getId() + " isTroop:" + paramMessageRecord.istroop);
      }
      Object localObject = MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        localObject = (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(localObject);
        if ((!paramMessageRecord.isread) && (localObject != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((QQMessageFacade.Message)localObject).frienduin, ((QQMessageFacade.Message)localObject).istroop, -1);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      int k = localArrayList.size();
      for (;;)
      {
        if (j < k)
        {
          localObject = (MessageRecord)localArrayList.get(j);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((MessageRecord)localObject).istroop).a((MessageRecord)localObject, paramBoolean2);
          j += 1;
          continue;
          localArrayList.add(paramMessageRecord);
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord)) {
            break;
          }
          i = 0;
          break;
        }
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord);
      }
      if (i != 0)
      {
        if (!MsgProxyUtils.p(paramMessageRecord.istroop)) {
          break label351;
        }
        a(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessageRecord.istroop).f();
        }
        return;
        label351:
        b(paramMessageRecord);
      }
      label359:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReaded uin=" + paramString + ",type=" + paramInt);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
    return;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
    ConversationFacade localConversationFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localMessageRecord != null) {}
    for (long l = a(localMessageRecord);; l = 0L)
    {
      localConversationFacade.a(paramString, paramInt, l);
      b(paramString, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    paramRefreshMessageContext.jdField_d_of_type_Boolean = true;
    paramRefreshMessageContext.jdField_a_of_type_JavaLangString = paramString;
    paramRefreshMessageContext.c = paramInt1;
    paramRefreshMessageContext.jdField_d_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(MsgProxyUtils.a(paramString, paramInt1)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead UNFINISHED ERROR uin = " + paramString + ", type = " + paramInt1);
      }
      if ((paramRefreshMessageContext.h) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.BaseMessageManager", 2, "numTroopRefresh = " + paramRefreshMessageContext.h + ", refreshActionMap[" + MsgProxyUtils.a(paramString, paramInt1) + "] = " + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.get(MsgProxyUtils.a(paramString, paramInt1)));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramRefreshMessageContext);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.put(MsgProxyUtils.a(paramString, paramInt1), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hsi(this, paramString, paramInt1, paramInt2, paramRefreshMessageContext));
  }
  
  public void a(String paramString, int paramInt, long paramLong) {}
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).b(paramString, paramInt1);
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg())) {
      if ((MsgProxyUtils.a(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
      {
        a(paramMessageRecord, true, paramInt2);
        b(paramString, paramInt1, paramMessageRecord, paramInt2);
      }
    }
    while ((paramMessageRecord == null) || (localList == null) || (localList.isEmpty()) || (paramMessageRecord.uniseq != ((MessageRecord)localList.get(localList.size() - 1)).uniseq)) {
      return;
    }
    a(paramMessageRecord, true, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString1, paramInt, paramString2, paramString3);
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1, paramInt);
    if ((paramString3.senderuin != null) && (paramString3.senderuin.equals(paramString2)))
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).b(paramString1, paramInt);
      if ((paramString2 == null) || (paramString2.isEmpty())) {
        break label133;
      }
      MessageRecord.copyMessageRecordBaseField(paramString3, (MessageRecord)paramString2.get(paramString2.size() - 1));
      paramString3.frienduin = paramString1;
      paramString3.emoRecentMsg = null;
    }
    label133:
    do
    {
      try
      {
        a(paramString3);
        return;
      }
      catch (Throwable paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgFromMsgBox ERROR", paramString1);
        return;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramInt);
    } while (paramString1 == null);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((paramInt == 1008) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1))) {}
    while (((paramInt == 1008) && (((EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(83)).a(paramString1))) || (((paramInt == 1008) || (paramInt == 1024)) && (PubAccountAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString1, paramInt)) || (!MsgProxyUtils.p(paramInt)))
    {
      paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (0L == paramLong)
      {
        paramString1 = paramString3.b(paramString1, paramInt);
        paramString2 = paramString1;
        if (paramString1 != null)
        {
          paramString1.lastmsgdrafttime = paramLong;
          if ((0L != paramLong) || (paramString1.lastmsgtime != 0L)) {
            break label186;
          }
          paramString3.b(paramString1);
          paramString2 = paramString1;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString2);
      return;
      paramString1 = paramString3.a(paramString1, paramInt);
      paramString1.troopUin = paramString2;
      break;
      label186:
      paramString3.a(paramString1);
      paramString2 = paramString1;
      continue;
      paramString2 = null;
    }
  }
  
  public abstract void a(String paramString, int paramInt, List paramList1, List paramList2, Bundle paramBundle);
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab " + paramMessageRecord.getBaseInfoString() + ",reason " + paramInt);
    }
    boolean bool1;
    if (paramMessageRecord == null) {
      bool1 = bool2;
    }
    MessageRecord localMessageRecord;
    label160:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                localMessageRecord = paramMessageRecord;
                if (!paramMessageRecord.isLongMsg()) {
                  break label160;
                }
                if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord)) {
                  break;
                }
                bool1 = bool2;
              } while (paramInt != 1);
              bool1 = bool2;
            } while (paramMessageRecord.isSendFromLocal());
            bool1 = bool2;
          } while (paramMessageRecord.isread);
          bool1 = bool2;
        } while (String.valueOf(AppConstants.ab).equals(paramMessageRecord.frienduin));
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
        return false;
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
        bool1 = bool2;
      } while (!localMessageRecord.isValid);
      bool1 = bool2;
    } while (MsgProxyUtils.g(localMessageRecord.msgtype));
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord.frienduin, localMessageRecord.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + paramMessageRecord.getBaseInfoString());
    }
    if (paramInt == 1) {
      if ((localMessageRecord.istroop == 3000) || (localMessageRecord.istroop == 1)) {
        if ((localMessageRecord.isSendFromLocal()) || (localMessageRecord.shmsgseq >= paramMessageRecord.shmsgseq)) {
          break label1049;
        }
      }
    }
    label1049:
    for (paramInt = 1;; paramInt = 0)
    {
      if (MsgProxyUtils.a(localMessageRecord, paramMessageRecord))
      {
        bool1 = bool2;
        if (localMessageRecord.longMsgIndex >= paramMessageRecord.longMsgIndex) {
          break;
        }
        paramInt = 0;
      }
      bool1 = bool3;
      if (paramInt == 0)
      {
        MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localMessageRecord);
        paramMessageRecord.emoRecentMsg = null;
        paramMessageRecord.fileType = -1;
        if (!paramBoolean) {}
      }
      do
      {
        for (;;)
        {
          try
          {
            a(paramMessageRecord);
            bool1 = true;
            if (!localMessageRecord.isSend())
            {
              paramMessageRecord.hasReply = true;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab = " + paramMessageRecord + ",hasReply=" + paramMessageRecord.hasReply);
              }
            }
            if (((localMessageRecord.isSendFromLocal()) || (localMessageRecord.isread)) && (localMessageRecord.msgtype != -1013) && (localMessageRecord.msgtype != -1019))
            {
              paramBoolean = bool1;
              if (localMessageRecord.msgtype != -1018) {}
            }
            else
            {
              if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018)) {
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramMessageRecord);
              }
              if ((!String.valueOf(AppConstants.ab).equals(paramMessageRecord.frienduin)) && ((!MsgProxyUtils.b(paramMessageRecord)) || (MsgProxyUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) && (paramMessageRecord.istroop != 7100)) {
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(paramMessageRecord);
              }
              if (((paramMessageRecord.msgtype == -2009) || (paramMessageRecord.msgtype == -2016)) && (paramInt != 0))
              {
                QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
                MessageRecord.copyMessageRecordBaseField(localMessage, localMessageRecord);
                localMessage.emoRecentMsg = null;
                localMessage.fileType = -1;
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(localMessage);
              }
              if (AppConstants.ae.equals(paramMessageRecord.frienduin))
              {
                paramInt = SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if (paramInt <= 0) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
              }
              if (AppConstants.aj.equals(paramMessageRecord.frienduin))
              {
                paramInt = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if (paramInt <= 0) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
              }
              paramBoolean = bool1;
              if (AppConstants.ak.equals(paramMessageRecord.frienduin))
              {
                paramInt = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if (paramInt <= 0) {
                  continue;
                }
                this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().unReadNum = paramInt;
                paramBoolean = bool1;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + paramMessageRecord.getBaseInfoString() + " , result = " + paramBoolean);
            }
            bool1 = paramBoolean;
            if (!MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop)) {
              break;
            }
            paramMessageRecord.istroop = MsgProxyUtils.a(paramMessageRecord.istroop);
            return paramBoolean;
            if ((!MsgProxyUtils.c(localMessageRecord.istroop)) || (localMessageRecord.isSendFromLocal()) || (localMessageRecord.time >= paramMessageRecord.time)) {
              break label1049;
            }
            paramInt = 1;
          }
          catch (Throwable localThrowable3)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable3);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(null);
            paramBoolean = bool1;
            continue;
          }
          if ((paramInt == 4) || (paramInt == 2))
          {
            MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localMessageRecord);
            paramMessageRecord.emoRecentMsg = null;
            paramMessageRecord.fileType = -1;
            if (paramBoolean) {}
            try
            {
              a(paramMessageRecord);
              paramBoolean = true;
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable1);
                }
              }
            }
          }
        }
        paramBoolean = bool4;
      } while (paramInt != 3);
      if (paramMessageRecord.uniseq == localThrowable1.uniseq) {
        MessageRecord.copyMessageRecordStatusField(paramMessageRecord, localThrowable1);
      }
      for (;;)
      {
        paramBoolean = true;
        break;
        MessageRecord.copyMessageRecordBaseField(paramMessageRecord, localThrowable1);
        paramMessageRecord.emoRecentMsg = null;
        paramMessageRecord.fileType = -1;
        try
        {
          a(paramMessageRecord);
        }
        catch (Throwable localThrowable2) {}
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable2);
        }
      }
    }
  }
  
  protected void b(QQMessageFacade.Message paramMessage) {}
  
  protected void b(QQMessageFacade.RefreshMessageContext paramRefreshMessageContext)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = paramRefreshMessageContext.h;
      if (bool) {}
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(40000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage wait over");
        }
        return;
      }
      catch (InterruptedException paramRefreshMessageContext)
      {
        for (;;)
        {
          paramRefreshMessageContext.printStackTrace();
        }
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    paramMessageRecord = MsgProxyUtils.a((String)localObject, i);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilMap.containsKey(paramMessageRecord))
    {
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((String)localObject, i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((String)localObject, i);
      if (localObject == null) {
        break label155;
      }
      a((MessageRecord)localObject, true, 4);
      if (paramMessageRecord != null)
      {
        if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
          paramMessageRecord.troopUin = ((MessageRecord)localObject).senderuin;
        }
        paramMessageRecord.type = ((MessageRecord)localObject).istroop;
        paramMessageRecord.lastmsgtime = ((MessageRecord)localObject).time;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord);
      }
    }
    for (;;)
    {
      if (paramMessageRecord != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      }
      return;
      label155:
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessageRecord);
      }
    }
  }
  
  public void b(String paramString, int paramInt) {}
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext);
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    a(paramString, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt));
  }
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    long l;
    QQMessageFacade.Message localMessage;
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      l = a(paramString, paramInt1);
      if (l != 0L)
      {
        if (MsgProxyUtils.a(paramInt1) != 1009) {
          break label272;
        }
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.V, 1009);
        if ((localMessage.senderuin != null) && (localMessage.senderuin.equals(paramString)))
        {
          paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = AppConstants.V;
          if (paramInt2 != 3) {
            break label181;
          }
          a(paramString, true, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, 1009, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
      }
    }
    label181:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt2 == 2)
                {
                  a(paramString, true, paramInt2);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, 1009, l, paramMessageRecord.msg);
                  return;
                }
              } while (paramInt2 != 4);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.V, 1009, paramString.senderuin, paramString.selfuin);
              a(paramString, null, false, true, paramInt2);
              a(paramMessageRecord, true, paramInt2);
              return;
              if (MsgProxyUtils.a(paramInt1) != 1001) {
                break;
              }
              localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.af, 1001);
            } while ((localMessage.senderuin == null) || (!localMessage.senderuin.equals(paramString)));
            paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
            MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
            paramString.selfuin = paramMessageRecord.selfuin;
            paramString.senderuin = paramMessageRecord.frienduin;
            paramString.frienduin = AppConstants.af;
            if (paramInt2 == 3)
            {
              a(paramString, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1001, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1001, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              return;
            }
            if (paramInt2 == 2)
            {
              a(paramString, true, paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1001, l, paramMessageRecord.msg);
              return;
            }
          } while (paramInt2 != 4);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.af, 1001, paramString.senderuin, paramString.selfuin);
          a(paramString, null, false, true, paramInt2);
          a(paramMessageRecord, true, paramInt2);
          return;
        } while (MsgProxyUtils.a(paramInt1) != 1010);
        localMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(AppConstants.au, 1010);
      } while ((localMessage.senderuin == null) || (!localMessage.senderuin.equals(paramString)));
      paramString = MessageRecordFactory.a(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = AppConstants.au;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.au, 1010, l, paramMessageRecord.extraflag, localMessage.sendFailCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.au, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.au, 1010, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    label272:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(AppConstants.au, 1010, paramString.senderuin, paramString.selfuin);
    a(paramString, null, false, true, paramInt2);
    a(paramMessageRecord, true, paramInt2);
  }
  
  public void c(String paramString, int paramInt)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "removeNotification uin" + paramString + ",type:" + paramInt);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject = null;
    label89:
    QQMessageFacade.Message localMessage;
    if (localIterator.hasNext())
    {
      localMessage = (QQMessageFacade.Message)localIterator.next();
      if (((paramInt == localMessage.istroop) || ((MsgProxyUtils.c(paramInt)) && (MsgProxyUtils.c(localMessage.istroop)))) && (localMessage.frienduin.equals(paramString)))
      {
        localMessage.counter = 0;
        localIterator.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("removeNotification remove:").append(bool1).append(",preMsg is null");
        if (localObject != null) {
          break label284;
        }
      }
      for (;;)
      {
        QLog.d("notification", 2, bool2 + ",iterator.hasNext():" + localIterator.hasNext());
        if (!bool1) {
          break;
        }
        paramString = localObject;
        if (localObject == null)
        {
          paramString = localObject;
          if (localIterator.hasNext()) {
            paramString = (QQMessageFacade.Message)localIterator.next();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
        return;
        localObject = localMessage;
        break label89;
        label284:
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManager
 * JD-Core Version:    0.7.0.1
 */