package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentItemTroopMsgData
  extends RecentUserBaseData
{
  public RecentItemTroopMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    if (HotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
    {
      c(paramQQAppInterface, paramContext);
      return;
    }
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localMessage = null)
    {
      if (localMessage != null)
      {
        this.jdField_a_of_type_Long = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null) {
          this.B = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
        }
      }
      MsgSummary localMsgSummary;
      Object localObject2;
      for (;;)
      {
        localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
        HotChatInfo localHotChatInfo = ((HotChatManager)paramQQAppInterface.getManager(58)).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (localHotChatInfo == null) {
          break;
        }
        this.A = 3;
        this.jdField_a_of_type_JavaLangString = localHotChatInfo.name;
        localObject1 = null;
        localMsgSummary = a();
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((localHotChatInfo == null) && (TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (this.B <= 0) {
          break label725;
        }
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label704;
        }
        localObject1 = this.jdField_a_of_type_JavaLangString;
        i = this.B;
        if (localMsgSummary.jdField_b_of_type_JavaLangCharSequence == null) {
          break label711;
        }
        localObject2 = localMsgSummary.jdField_b_of_type_JavaLangCharSequence;
        label292:
        if (this.jdField_b_of_type_JavaLangString == null) {
          break label718;
        }
        str = this.jdField_b_of_type_JavaLangString;
        label305:
        localObject1 = String.format("%s,%d,%s,%s", new Object[] { localObject1, Integer.valueOf(i), localObject2, str });
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        if (!localMsgSummary.a) {
          b(paramQQAppInterface, paramContext);
        }
        if ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (localMessage != null) && (localMsgSummary != null) && (AnonymousChatHelper.a(localMessage))) {
          this.jdField_b_of_type_JavaLangCharSequence = localMsgSummary.a(paramContext, paramContext.getResources().getString(2131363837), -1);
        }
        paramQQAppInterface = a();
        if ((paramQQAppInterface != null) && (paramQQAppInterface.msg == null)) {
          paramQQAppInterface.reParse();
        }
        TimeManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_Long);
        return;
        this.B = 0;
        continue;
        this.jdField_a_of_type_Long = 0L;
        this.B = 0;
      }
      int i = this.G & 0xFFFFF0FF;
      if ((localObject1 != null) && (((FriendManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
      {
        localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (localObject1 != null) {}
        for (localObject1 = ((OpenTroopInfo)localObject1).troopName;; localObject1 = null)
        {
          str = "";
          localObject2 = localObject1;
          localObject1 = str;
          label537:
          this.G = i;
          i = paramQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if (i != 1) {
            break label672;
          }
          this.A = 1;
          label564:
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label695;
          }
          this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          label588:
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          break;
        }
      }
      if (localObject1 != null) {}
      for (localObject1 = ((FriendManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
      {
        if (localObject1 != null) {
          localObject2 = ((TroopInfo)localObject1).troopname;
        }
        for (localObject1 = ((TroopInfo)localObject1).troopmemo;; localObject1 = str)
        {
          i |= 0x100;
          break label537;
          label672:
          if ((i != 2) && (i != 3) && (i != 4)) {
            break label564;
          }
          this.A = 3;
          break label564;
          label695:
          this.jdField_a_of_type_JavaLangString = ((String)localObject2);
          break label588;
          label704:
          localObject1 = "";
          break;
          label711:
          localObject2 = "";
          break label292;
          label718:
          str = "";
          break label305;
          label725:
          if (this.jdField_a_of_type_JavaLangString != null)
          {
            localObject1 = this.jdField_a_of_type_JavaLangString;
            label738:
            if (localMsgSummary.jdField_b_of_type_JavaLangCharSequence == null) {
              break label802;
            }
            localObject2 = localMsgSummary.jdField_b_of_type_JavaLangCharSequence;
            label753:
            if (this.jdField_b_of_type_JavaLangString == null) {
              break label809;
            }
          }
          label802:
          label809:
          for (str = this.jdField_b_of_type_JavaLangString;; str = "")
          {
            localObject1 = String.format("%s,%s,%s", new Object[] { localObject1, localObject2, str });
            break;
            localObject1 = "";
            break label738;
            localObject2 = "";
            break label753;
          }
          localObject2 = null;
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = 2131427997;
    if ((a().msg instanceof TroopSpecialAttentionMsg))
    {
      paramQQAppInterface = (TroopSpecialAttentionMsg)a().msg;
      if (paramQQAppInterface != null)
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_c_of_type_JavaLangString;
        i = 2131427997;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) && (i > 0)) {
        this.E = paramContext.getResources().getColor(i);
      }
      return;
      this.jdField_c_of_type_JavaLangCharSequence = "";
      i = 0;
      continue;
      if (!(a().msg instanceof TroopAtMeMsg)) {
        break label130;
      }
      paramQQAppInterface = (TroopAtMeMsg)a().msg;
      if (paramQQAppInterface == null) {
        break;
      }
      this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_a_of_type_JavaLangString;
    }
    this.jdField_c_of_type_JavaLangCharSequence = "";
    for (;;)
    {
      i = 0;
      break;
      label130:
      if ((a().msg instanceof TroopAtAllMsg))
      {
        paramQQAppInterface = (TroopAtAllMsg)a().msg;
        if (paramQQAppInterface != null)
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_a_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = String.format("与%s群的会话，有全体消息", new Object[] { this.jdField_a_of_type_JavaLangString });
          break;
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
        continue;
      }
      if ((a().msg instanceof TroopNotificationMsg))
      {
        paramQQAppInterface = (TroopNotificationMsg)a().msg;
        if ((paramQQAppInterface != null) && ((TroopNotificationHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) || (TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))))
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.jdField_a_of_type_JavaLangString;
          break;
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
        continue;
      }
      this.jdField_c_of_type_JavaLangCharSequence = "";
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject = ((HotChatManager)paramQQAppInterface.getManager(58)).a();
    MsgSummary localMsgSummary = new MsgSummary();
    if (localObject != null)
    {
      this.B = 0;
      this.jdField_a_of_type_JavaLangString = ((HotChatInfo)localObject).name;
      if (((HotChatInfo)localObject).memberCount >= 2) {
        localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ("" + ((HotChatInfo)localObject).memberCount + "人正在热聊，点击加入吧！");
      }
    }
    for (this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;; this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime)
    {
      a(paramQQAppInterface, paramContext, localMsgSummary);
      return;
      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ("欢迎加入" + this.jdField_a_of_type_JavaLangString + "热聊！");
      break;
      localObject = paramQQAppInterface.a().a();
      if (localObject != null) {
        ((RecentUserProxy)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
      }
      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "正在加载热聊信息。。。";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData
 * JD-Core Version:    0.7.0.1
 */