package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.ArrayList;
import java.util.List;

public class RecentItemChatMsgData
  extends RecentUserBaseData
{
  private static MessageForRichState a;
  private boolean b;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private boolean a(FriendManager paramFriendManager, String paramString)
  {
    if ((paramFriendManager == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramFriendManager = paramFriendManager.a(paramString);
      } while ((paramFriendManager == null) || (!paramFriendManager.isFriend()));
      bool1 = paramFriendManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramFriendManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    QQMessageFacade.Message localMessage = null;
    Object localObject3 = paramQQAppInterface.a();
    if (localObject3 != null) {
      localMessage = ((QQMessageFacade)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    }
    ConversationFacade localConversationFacade = paramQQAppInterface.a();
    MsgSummary localMsgSummary;
    if ((localConversationFacade != null) && (localMessage != null))
    {
      this.B = localConversationFacade.a(localMessage.frienduin, localMessage.istroop);
      localMsgSummary = a();
    }
    label343:
    int i;
    label362:
    label375:
    int j;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
    {
    default: 
    case 9501: 
      for (;;)
      {
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        if ((localMsgSummary.a) && (this.jdField_b_of_type_Boolean))
        {
          localMsgSummary.b = "";
          this.jdField_c_of_type_JavaLangCharSequence = "";
        }
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if ((this.B <= 0) || (localMessage == null) || (localMessage.msgtype != -2025)) {
          break label3362;
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label3343;
        }
        paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
        i = this.B;
        if (localMsgSummary.b == null) {
          break label3349;
        }
        paramContext = localMessage.msg;
        if (this.jdField_b_of_type_JavaLangString == null) {
          break label3355;
        }
        localObject1 = this.jdField_b_of_type_JavaLangString;
        paramQQAppInterface = String.format("%s,%d,%s,%s", new Object[] { paramQQAppInterface, Integer.valueOf(i), paramContext, localObject1 });
        this.jdField_c_of_type_JavaLangString = paramQQAppInterface;
        return;
        this.B = 0;
        break;
        localMsgSummary.b = localMessage.msg;
        this.jdField_a_of_type_Long = localMessage.time;
        this.C = 0;
        localObject1 = ((SmartDeviceProxyMgr)paramQQAppInterface.a(53)).a(Long.parseLong(localMessage.frienduin));
        if (localObject1 != null)
        {
          this.jdField_a_of_type_JavaLangString = ((DeviceInfo)localObject1).name;
          if (!TextUtils.isEmpty(((DeviceInfo)localObject1).remark)) {
            this.jdField_a_of_type_JavaLangString = ((DeviceInfo)localObject1).remark;
          }
        }
        if ((localMsgSummary.b == null) || (localMsgSummary.b.length() == 0)) {
          localMsgSummary.b = this.jdField_a_of_type_JavaLangString;
        }
        this.G = 1;
        if (localMessage.msgtype == -4500)
        {
          localObject1 = new MessageForDeviceFile();
          ((MessageForDeviceFile)localObject1).msgData = localMessage.msgData;
          ((MessageForDeviceFile)localObject1).parse();
          if (((MessageForDeviceFile)localObject1).msgStatus == 1) {
            localMsgSummary.f = 2;
          } else if (((MessageForDeviceFile)localObject1).msgStatus == 2) {
            localMsgSummary.f = 1;
          }
        }
        else if (localMessage.msgtype == -4501)
        {
          localObject1 = new MessageForDevPtt();
          ((MessageForDevPtt)localObject1).msgData = localMessage.msgData;
          ((MessageForDevPtt)localObject1).parse();
          if (((MessageForDevPtt)localObject1).fileSize == -1L) {
            localMsgSummary.f = 2;
          } else if (((MessageForDevPtt)localObject1).fileSize == -3L) {
            localMsgSummary.f = 1;
          }
        }
        else if (localMessage.msgtype == -4503)
        {
          localObject1 = new MessageForDevShortVideo();
          ((MessageForDevShortVideo)localObject1).msgData = localMessage.msgData;
          ((MessageForDevShortVideo)localObject1).parse();
          if (((MessageForDevShortVideo)localObject1).videoFileStatus == 1005)
          {
            localMsgSummary.f = 2;
          }
          else if (((MessageForDevShortVideo)localObject1).videoFileStatus == 1002)
          {
            localObject1 = ((DeviceMsgHandle)paramQQAppInterface.a(51)).a();
            if (localObject1 != null)
            {
              i = 1;
              if (((DeviceAVFileMsgObserver)localObject1).a(localMessage.uniseq)) {
                break label806;
              }
            }
            for (j = 1;; j = 0)
            {
              if ((i & j) == 0) {
                break label812;
              }
              localMsgSummary.f = 2;
              break;
              i = 0;
              break label769;
            }
            localMsgSummary.f = 1;
          }
        }
      }
    case 1008: 
      label769:
      label806:
      label812:
      if (localMessage != null)
      {
        i = localMessage.msgtype;
        if ((i != -3006) && (i != -5004)) {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        }
      }
      else
      {
        label863:
        localObject1 = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
        if (localObject1 == null) {
          break label3576;
        }
      }
      break;
    }
    label956:
    label1228:
    label1389:
    label1523:
    label2420:
    label3576:
    for (Object localObject1 = ((PublicAccountDataManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject2 = PublicAccountUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (localObject2 != null) {
          this.jdField_a_of_type_JavaLangString = ((AccountDetail)localObject2).name;
        }
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaLangString = ((PublicAccountInfo)localObject1).name;
        if (((PublicAccountInfo)localObject1).certifiedGrade > 0L)
        {
          this.C = 2130838652;
          if ((localMessage == null) || (localMessage.getMessageText() == null)) {
            break label1228;
          }
        }
      }
      for (this.jdField_a_of_type_Long = localMessage.time;; this.jdField_a_of_type_Long = 0L)
      {
        j = this.G & 0xFFFFFF0F;
        i = j;
        if (AppConstants.T.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime == 9223372036854775806L) {
            i = j | 0x30;
          }
        }
        this.G = i;
        break;
        localMsgSummary.b = "";
        localObject2 = XMLMessageUtils.a(localMessage);
        if ((localObject2 == null) || (((PAMessage)localObject2).items == null) || (((PAMessage)localObject2).items.size() == 0))
        {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          break label863;
        }
        localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null)) {
          localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
        }
        for (;;)
        {
          localMsgSummary.b = ((CharSequence)localObject1);
          break;
        }
        this.C = 0;
        break label956;
        this.C = 0;
        break label956;
      }
      Object localObject2 = ContactUtils.d(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
      if (localObject1 != null) {}
      for (localObject1 = ((PhoneContactManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
      {
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).name;
        }
        for (;;)
        {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
            break label1389;
          }
          this.jdField_a_of_type_Long = localMessage.time;
          break;
          if (localObject2 != null) {
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, (String)localObject2, true);
          } else {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
          }
        }
        this.jdField_a_of_type_Long = 0L;
        break;
        localObject1 = (CircleManager)paramQQAppInterface.getManager(34);
        localObject2 = ((CircleManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((localObject1 != null) && (localObject2 != null)) {}
        for (this.jdField_a_of_type_JavaLangString = ((CircleManager)localObject1).a((CircleBuddy)localObject2);; this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true))
        {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
            break label1523;
          }
          this.jdField_a_of_type_Long = localMessage.time;
          break;
        }
        this.jdField_a_of_type_Long = 0L;
        break;
        localObject2 = null;
        localObject1 = localObject2;
        if (localMessage != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(localMessage.senderuin)) {
            if ((!AppConstants.af.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (!AppConstants.au.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
            {
              localObject1 = localObject2;
              if (!AppConstants.V.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {}
            }
            else
            {
              if (!AppConstants.V.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                break label1834;
              }
              localObject2 = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, true);
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = localMessage.senderuin;
              }
            }
          }
        }
        if ((localMessage != null) && ((localMessage.getMessageText() != null) || (localMessage.msgData != null)))
        {
          this.jdField_a_of_type_Long = localMessage.time;
          if ((localMessage == null) || (localMessage.msgtype != -1024)) {
            break label1880;
          }
        }
        for (;;)
        {
          if (AppConstants.af.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_a_of_type_JavaLangString = paramContext.getString(2131366652);
            if (localObject3 != null)
            {
              this.A = 1;
              this.B = ((QQMessageFacade)localObject3).f();
              if ((this.B <= 0) && (localConversationFacade != null))
              {
                this.B = localConversationFacade.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
                this.A = 3;
              }
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if ((localMessage.isSendFromLocal()) || (localObject1 == null) || (!((String)localObject1).equals(localMessage.senderuin))) {
                break;
              }
              paramContext.getString(2131367183);
              break;
              localObject1 = ContactUtils.m(paramQQAppInterface, localMessage.senderuin);
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1638;
              }
              localObject2 = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, false);
              break label1638;
              this.jdField_a_of_type_Long = 0L;
              break label1687;
              bool = false;
              if (AppConstants.af.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                bool = true;
              }
              if ((localMessage != null) && (localMessage.isSend()))
              {
                MsgUtils.a(paramContext, paramQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, null, bool, false);
                continue;
              }
              MsgUtils.a(paramContext, paramQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject1, bool, false);
              continue;
            }
            localMsgSummary.b = paramContext.getString(2131366653);
            break;
          }
        }
        if (AppConstants.au.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          this.jdField_a_of_type_JavaLangString = paramContext.getString(2131369715);
          if (localObject3 != null)
          {
            this.A = 1;
            this.B = ((QQMessageFacade)localObject3).h();
            if ((this.B <= 0) && (localConversationFacade != null))
            {
              this.B = localConversationFacade.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              this.A = 3;
            }
          }
          if ((localMessage == null) || (localMessage.msg == null) || (-999 == localMessage.msgtype))
          {
            localMsgSummary.b = paramContext.getString(2131369716);
            localObject2 = localObject1;
          }
          for (;;)
          {
            DatingUtil.a("data_recent_msg", new Object[] { localObject2, localMsgSummary.b });
            break;
            localObject2 = localObject1;
            if (localMessage.msgtype == -1024)
            {
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (((String)localObject1).length() > 12) {
                  localObject2 = ((String)localObject1).substring(0, 11) + "...";
                }
              }
              if (localMessage.isSendFromLocal()) {
                localMsgSummary.b = paramContext.getString(2131369786, new Object[] { localObject2 });
              } else {
                localMsgSummary.b = paramContext.getString(2131369787, new Object[] { localObject2 });
              }
            }
          }
        }
        if (AppConstants.V.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          this.jdField_a_of_type_JavaLangString = paramContext.getString(2131366665);
          if (localObject3 != null) {
            this.B = ((QQMessageFacade)localObject3).g();
          }
          if ((localMessage != null) && (-999 != localMessage.msgtype) && (localMessage.msg != null)) {
            break;
          }
          localMsgSummary.b = paramContext.getString(2131366666);
          break;
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        break;
        boolean bool = QvipSpecialCareManager.a(paramQQAppInterface.a() + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((this.B > 0) && (bool))
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131369155);
          this.E = paramContext.getResources().getColor(2131427997);
          if (0 != 0) {
            break label3564;
          }
        }
        for (localObject1 = (FriendManager)paramQQAppInterface.getManager(8);; localObject1 = null)
        {
          if (a((FriendManager)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.A = 4;
            if ((localMessage == null) || ((localMessage.getMessageText() == null) && (localMessage.msgData == null) && ((localMessage.msgtype != -2011) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)))) {
              break label2757;
            }
            this.jdField_a_of_type_Long = localMessage.time;
            a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            if ((localMessage != null) && (localMessage.msgtype == -1034))
            {
              if (jdField_a_of_type_ComTencentMobileqqDataMessageForRichState == null) {
                jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = new MessageForRichState();
              }
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.msg = localMessage.msg;
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.mIsParsed = false;
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.parse();
              if (paramQQAppInterface.a().e(localMessage.frienduin) >= jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time) {
                break label2765;
              }
              this.jdField_c_of_type_JavaLangCharSequence = "[新签名]";
              this.E = paramContext.getResources().getColor(2131427997);
              this.jdField_b_of_type_Boolean = true;
            }
            if (!AppConstants.ae.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
              break label2789;
            }
            this.jdField_a_of_type_JavaLangString = paramContext.getString(2131367460);
            this.B = SystemMsgController.a().b(paramQQAppInterface);
            if ((localMessage == null) || (localMessage.msgtype != -2025)) {
              break;
            }
            if (this.B <= 0) {
              break label3003;
            }
            this.E = -881592;
            if (!bool) {
              break label2991;
            }
          }
          for (this.jdField_c_of_type_JavaLangCharSequence += localMessage.msg;; this.jdField_c_of_type_JavaLangCharSequence = localMessage.msg)
          {
            localMsgSummary.b = "";
            break;
            this.jdField_c_of_type_JavaLangCharSequence = "";
            break label2420;
            this.A = 1;
            break label2456;
            this.jdField_a_of_type_Long = 0L;
            break label2507;
            this.jdField_c_of_type_JavaLangCharSequence = "[签名]";
            this.E = paramContext.getResources().getColor(2131427972);
            break label2623;
            if (AppConstants.ag.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131367458);
              break label2666;
            }
            if (AppConstants.ac.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
            {
              this.jdField_a_of_type_JavaLangString = paramContext.getString(2131367499);
              if ((localMessage == null) || (localMessage.msg == null)) {
                break label2666;
              }
              localMsgSummary.b = localMessage.msg;
              break label2666;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1000)
            {
              if (localObject1 == null) {
                break label2666;
              }
              localObject1 = ((FriendManager)localObject1).g(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
              this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, true);
              break label2666;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1004)
            {
              this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              break label2666;
            }
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
            break label2666;
          }
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break;
          this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363729);
          localObject2 = "";
          localObject1 = null;
          if (localObject3 != null) {
            localObject1 = ((QQMessageFacade)localObject3).a(AppConstants.ab, 4000);
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
            if (((MessageRecord)localObject1).msg != null)
            {
              if (((MessageRecord)localObject1).msgtype == -1033)
              {
                localObject1 = ((MessageRecord)localObject1).msg;
                localObject1 = "好友推荐，" + (String)localObject1;
                localMsgSummary.b = ((CharSequence)localObject1);
                if ((localMessage == null) || (localMessage.getMessageText() == null)) {
                  break label3335;
                }
                this.jdField_a_of_type_Long = localMessage.time;
                break;
              }
              if (((MessageRecord)localObject1).msgtype == -1030)
              {
                localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
                if (localObject1 == null) {
                  break label3557;
                }
              }
            }
          }
          for (localObject1 = ((PhoneContactManager)localObject1).c();; localObject1 = "")
          {
            localObject1 = "好友推荐，" + (String)localObject1;
            break label3133;
            if (((MessageRecord)localObject1).msgtype == -1039)
            {
              localObject3 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
              localObject1 = localObject2;
              if (localObject3 == null) {
                break label3133;
              }
              localObject1 = paramContext.getResources().getString(2131363732) + ((RecommendTroopManagerImp)localObject3).a();
              break label3133;
            }
            if (((MessageRecord)localObject1).msgtype == -1040)
            {
              localObject3 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
              localObject1 = localObject2;
              if (localObject3 == null) {
                break label3133;
              }
              localObject1 = ((RecommendTroopManagerImp)localObject3).a();
              break label3133;
              this.jdField_a_of_type_Long = 0L;
              break;
              paramQQAppInterface = "";
              break label343;
              paramContext = "";
              break label362;
              localObject1 = "";
              break label375;
              if (this.B > 0)
              {
                if (this.jdField_a_of_type_JavaLangString != null)
                {
                  paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
                  i = this.B;
                  if (localMsgSummary.b == null) {
                    break label3452;
                  }
                  paramContext = localMsgSummary.b;
                  if (this.jdField_b_of_type_JavaLangString == null) {
                    break label3458;
                  }
                }
                for (localObject1 = this.jdField_b_of_type_JavaLangString;; localObject1 = "")
                {
                  paramQQAppInterface = String.format("%s,%d,%s,%s", new Object[] { paramQQAppInterface, Integer.valueOf(i), paramContext, localObject1 });
                  break;
                  paramQQAppInterface = "";
                  break label3381;
                  label3452:
                  paramContext = "";
                  break label3400;
                }
              }
              if (this.jdField_a_of_type_JavaLangString != null)
              {
                paramQQAppInterface = this.jdField_a_of_type_JavaLangString;
                if (localMsgSummary.b == null) {
                  break label3537;
                }
                paramContext = localMsgSummary.b;
                if (this.jdField_b_of_type_JavaLangString == null) {
                  break label3543;
                }
              }
              for (localObject1 = this.jdField_b_of_type_JavaLangString;; localObject1 = "")
              {
                paramQQAppInterface = String.format("%s,%s,%s", new Object[] { paramQQAppInterface, paramContext, localObject1 });
                break;
                paramQQAppInterface = "";
                break label3477;
                paramContext = "";
                break label3491;
              }
            }
            localObject1 = "";
            break label3133;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */