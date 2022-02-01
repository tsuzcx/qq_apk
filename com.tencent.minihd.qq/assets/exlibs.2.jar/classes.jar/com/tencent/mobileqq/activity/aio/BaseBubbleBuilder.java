package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.component.network.utils.Base64;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import fos;
import fot;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class BaseBubbleBuilder
  implements View.OnClickListener, ChatItemBuilder
{
  public static int a = 0;
  private static final Handler jdField_a_of_type_AndroidOsHandler;
  public static boolean a = false;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new fot(this);
  @Deprecated
  public BaseAdapter a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  public QQAppInterface a;
  private boolean d = false;
  
  static
  {
    jdField_a_of_type_Int = 255;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {
      bool1 = false;
    }
    int j = a(paramChatMessage);
    paramViewHolder.jdField_a_of_type_Int = j;
    if (j != 0) {
      if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000))
      {
        Object localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        paramContext = null;
        TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localTransDiskCache != null) {
          paramContext = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
        }
        if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
        {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_c_of_type_AndroidViewView, null);
          }
          if (paramViewHolder.jdField_c_of_type_AndroidViewView != null)
          {
            paramViewHolder.jdField_c_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            paramViewHolder.jdField_c_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          }
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
          {
            paramContext = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            boolean bool2 = paramChatMessage.isSend();
            boolean bool3 = paramChatMessage.needVipBubble();
            if (j != 2) {
              break label467;
            }
            bool1 = true;
            label262:
            paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramViewHolder.jdField_c_of_type_AndroidViewView);
          }
          if (paramViewHolder.jdField_c_of_type_AndroidViewView != null)
          {
            paramContext = paramViewHolder.jdField_c_of_type_AndroidViewView.getBackground();
            if (paramContext != null) {
              paramContext.setAlpha(jdField_a_of_type_Int);
            }
          }
          a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
          a(paramViewHolder, paramChatMessage);
          if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag))
          {
            jdField_a_of_type_AndroidOsHandler.post(new fos(this, paramViewHolder, paramChatMessage));
            paramChatMessage.mAnimFlag = false;
          }
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a(paramViewHolder.jdField_c_of_type_AndroidViewView);
      a(paramViewHolder.jdField_c_of_type_AndroidViewView, paramChatMessage);
      return;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
      break;
      int i = (int)paramChatMessage.vipBubbleID;
      if ((j == 3) || (!paramChatMessage.needVipBubble())) {
        i = 0;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
      break;
      label467:
      bool1 = false;
      break label262;
      paramViewHolder.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (AnonymousChatHelper.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    String str;
    ExtensionInfo localExtensionInfo;
    AvatarPendantManager localAvatarPendantManager;
    if (paramChatMessage.isSend())
    {
      str = paramChatMessage.selfuin;
      FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localFriendsManagerImp == null) {
        break label299;
      }
      localExtensionInfo = localFriendsManagerImp.a(str);
      localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      if ((localExtensionInfo == null) || (!localExtensionInfo.isPendantValid())) {
        break label262;
      }
      AvatarPendantManager.b = true;
      if (!AvatarPendantUtil.a(localExtensionInfo.pendantId)) {
        break label240;
      }
      localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq);
      label136:
      if ((!localFriendsManagerImp.b(str)) && (localExtensionInfo.isPendantExpired())) {
        AvatarPendantUtil.a(str);
      }
      if ((!localAvatarPendantManager.a(paramChatMessage.uniseq)) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)) {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      }
    }
    for (;;)
    {
      paramChatMessage.mPendantAnimatable = false;
      return;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        str = paramChatMessage.frienduin;
        break;
      }
      str = paramChatMessage.senderuin;
      break;
      label240:
      localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 1, paramChatMessage.uniseq);
      break label136;
      label262:
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      if (localExtensionInfo == null)
      {
        AvatarPendantUtil.a(str);
        continue;
        label299:
        if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int j = 1;
    int k = 0;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    label122:
    boolean bool2;
    int i;
    if (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
    {
      localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
      if (localObject1 != null)
      {
        paramViewHolder = (BaseBubbleBuilder.ViewHolder)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        paramViewHolder = paramChatMessage.senderuin;
      }
      localObject1 = MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      localObject2 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramChatMessage.frienduin);
      if (((OpenTroopInfo)localObject2).troopAdminList == null)
      {
        bool1 = false;
        if (localObject1 != null) {
          break label263;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "handleNickname, TroopMemberInfo is null ");
        }
        bool2 = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).d(paramChatMessage.frienduin);
        if (localObject1 != null) {
          break label341;
        }
        i = 0;
        label151:
        j = i;
        if (bool2) {
          j = -1;
        }
        if (localObject1 != null) {
          break label351;
        }
        i = 0;
        label171:
        if (bool2) {
          i = 0;
        }
        if ((paramViewHolder == null) || (paramChatMessage.isSend())) {
          break label361;
        }
        bool2 = true;
        label193:
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
        if (localObject1 != null) {
          break label367;
        }
      }
      for (;;)
      {
        paramBaseChatItemLayout.a(bool2, paramViewHolder, paramChatMessage, true, i, j, k, bool1);
        return;
        bool1 = ((OpenTroopInfo)localObject2).troopAdminList.contains(paramChatMessage.senderuin + "|");
        break;
        label263:
        if (!QLog.isColorLevel()) {
          break label122;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "handleNickname, info.age = " + ((TroopMemberInfo)localObject1).age + " info.sex = " + ((TroopMemberInfo)localObject1).sex + " nickname = " + paramViewHolder + " info.memberuin = " + ((TroopMemberInfo)localObject1).memberuin);
        break label122;
        label341:
        i = ((TroopMemberInfo)localObject1).sex;
        break label151;
        label351:
        i = ((TroopMemberInfo)localObject1).age;
        break label171;
        label361:
        bool2 = false;
        break label193;
        label367:
        k = ((TroopMemberInfo)localObject1).distance;
      }
    }
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
      if (paramChatMessage.isMultiMsg) {
        localObject1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      label422:
      if ((localObject1 == null) || (((String)localObject1).length() == 0))
      {
        localObject1 = paramChatMessage.senderuin;
        label441:
        if (!AnonymousChatHelper.a(paramChatMessage)) {
          break label986;
        }
        localObject2 = AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_JavaLangString;
        i = 1;
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          localObject1 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
        }
        for (;;)
        {
          if (((localObject2 != null) && (!paramChatMessage.isSend())) || (i != 0))
          {
            bool1 = true;
            label527:
            if ((i == 0) || (!AnonymousChatHelper.b(paramChatMessage))) {
              break label800;
            }
            bool2 = true;
            label542:
            paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, (ColorStateList)localObject1, bool2);
            label554:
            if ((this.d) && (paramBaseChatItemLayout.e != null))
            {
              paramBaseChatItemLayout.e.setOnClickListener(this);
              paramBaseChatItemLayout.e.setTag(Integer.valueOf(2131296317));
            }
            if ((AnonymousChatHelper.a(paramChatMessage)) && (paramBaseChatItemLayout.e != null)) {
              paramBaseChatItemLayout.e.setOnClickListener(null);
            }
            if (paramChatMessage.istroop != 1) {
              break label826;
            }
            i = 1;
            label622:
            if (paramChatMessage.istroop != 3000) {
              break label832;
            }
            label632:
            bool1 = paramChatMessage.isSend();
            if ((i != 0) || (j != 0))
            {
              if (i == 0) {
                break label870;
              }
              if (!bool1) {
                break label838;
              }
              localObject1 = "进入我的群名片";
            }
          }
          for (;;)
          {
            paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
            if (paramViewHolder.jdField_a_of_type_JavaLangStringBuilder == null) {
              break;
            }
            if (paramChatMessage.isSend())
            {
              paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append("我");
              return;
              if (paramChatMessage.istroop == 1)
              {
                localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, paramChatMessage.frienduin, 1, 0);
                break label422;
              }
              if (3000 != paramChatMessage.istroop) {
                break label996;
              }
              localObject1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramChatMessage.frienduin, paramChatMessage.senderuin);
              break label422;
              localObject1 = (String)localObject1 + ":";
              break label441;
              bool1 = false;
              break label527;
              label800:
              bool2 = false;
              break label542;
              paramBaseChatItemLayout.a(false, null, null, false);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
              break label554;
              label826:
              i = 0;
              break label622;
              label832:
              j = 0;
              break label632;
              label838:
              localObject1 = "进入" + (String)localObject2 + "的群名片";
              continue;
              label870:
              if (j == 0) {
                break label975;
              }
              if (bool1)
              {
                localObject1 = "进入我的资料卡";
                continue;
              }
              localObject1 = "进入" + (String)localObject2 + "的资料卡";
              continue;
            }
            paramBaseChatItemLayout = (BaseChatItemLayout)localObject2;
            if (localObject2 == null) {
              paramBaseChatItemLayout = "";
            }
            if (AnonymousChatHelper.a(paramChatMessage))
            {
              paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364041)).append(paramBaseChatItemLayout);
              return;
            }
            paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(paramBaseChatItemLayout);
            return;
            label975:
            localObject1 = "";
          }
        }
        label986:
        i = 0;
        localObject2 = localObject1;
      }
      label996:
      localObject1 = null;
    }
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131302479, paramContext.getString(2131366320));
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        StatisticCollector.a(BaseApplication.getContext()).a(localQQAppInterface, localQQAppInterface.a(), "Bubble", paramString1, 0, 1, null, String.valueOf(paramInt), null, paramString2, null);
      }
      return;
    }
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool = true;
    if ((paramChatMessage.istroop == 1) && (!AnonymousChatHelper.a(paramChatMessage)))
    {
      if (TroopMemberLbsHelper.a(paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue())
      {
        paramViewHolder = TroopMemberLbsHelper.a(paramChatMessage.frienduin, paramChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
        ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
        if (!paramChatMessage.isSend()) {}
        for (;;)
        {
          paramBaseChatItemLayout.a(bool, paramViewHolder, localColorStateList);
          return;
          bool = false;
        }
      }
      paramBaseChatItemLayout.a(false, "", null);
      return;
    }
    paramBaseChatItemLayout.a(false, "", null);
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setCheckBox(paramChatMessage, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject1;
    if (AnonymousChatHelper.a(paramChatMessage))
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839451);
      paramBaseChatItemLayout.setHeaderIcon(URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_Int), (Drawable)localObject1, (Drawable)localObject1));
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(null);
      return;
    }
    int j = paramChatMessage.istroop;
    Object localObject3;
    if (paramChatMessage.isSend())
    {
      localObject1 = paramChatMessage.selfuin;
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      if (((j != 1010) && (j != 1001) && ((j != 1022) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3019) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2019)))) || (localObject2 == null) || (((FriendsManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label522;
      }
      localObject3 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, (String)localObject1, true);
      localObject2 = localObject3;
      if (QLog.isColorLevel()) {
        QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + (String)localObject1);
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.a().a((String)localObject1)))
    {
      paramBaseChatItemLayout.setHeaderIcon((Drawable)localObject2);
      if ((paramChatMessage.isSendFromLocal()) || ((j != 1) && (j != 3000))) {
        break label669;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramChatMessage.senderuin))
      {
        if (j != 1) {
          break label631;
        }
        localObject1 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
        label313:
        if ((localObject1 == null) || (((String)localObject1).getBytes().length <= 3)) {
          break label666;
        }
        localObject2 = ((String)localObject1).getBytes();
        if ((localObject2[0] != -17) || (localObject2[1] != -69) || (localObject2[2] != -65)) {
          break label666;
        }
        localObject3 = new byte[localObject2.length - 3];
        System.arraycopy(localObject2, 3, localObject3, 0, localObject3.length);
      }
      try
      {
        localObject2 = new String((byte[])localObject3, "UTF-8");
        localObject1 = localObject2;
        label401:
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setTag(2131296315, localObject1);
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        label424:
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setTag(paramChatMessage);
        localObject1 = "";
        if (paramChatMessage.istroop == 0)
        {
          if (!paramChatMessage.isSend()) {
            break label680;
          }
          localObject1 = "进入我的资料卡";
        }
        label464:
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label522:
        localUnsupportedEncodingException.printStackTrace();
      }
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        localObject1 = paramChatMessage.frienduin;
        break;
      }
      localObject1 = paramChatMessage.senderuin;
      break;
      if ((j != 9501) || (paramChatMessage.isSend())) {
        break label563;
      }
    }
    label563:
    if (j == 1006) {}
    for (int i = 11;; i = 1)
    {
      localObject3 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject1);
      localObject2 = localObject3;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + (String)localObject1);
      localObject2 = localObject3;
      break;
      label631:
      if (j == 3000)
      {
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
        break label313;
        break label401;
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(null);
        break label424;
        localObject1 = "进入" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString + "的资料卡";
        break label464;
      }
      label666:
      label669:
      label680:
      localObject1 = null;
      break label313;
    }
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = 2130842109;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      bool = true;
      if (!AnonymousChatHelper.a(paramChatMessage)) {
        break label86;
      }
      if (bool) {
        break label386;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a(true, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364043), bool, AnonymousChatHelper.b(paramChatMessage), i);
      paramBaseChatItemLayout.c.setOnClickListener(null);
      return;
      bool = false;
      break;
      label86:
      Object localObject;
      if (paramChatMessage.istroop == 1)
      {
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (localTroopManager != null)
        {
          localObject = localTroopManager.a(paramChatMessage.frienduin);
          if ((localObject != null) && (((TroopInfo)localObject).cGroupRankSysFlag == 1) && (((TroopInfo)localObject).cGroupRankUserFlag == 1))
          {
            String str = paramChatMessage.getExtInfoFromExtStr("uniqueTitle");
            localObject = localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, this.jdField_a_of_type_AndroidContentContext);
            i = localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, str, bool);
            paramChatMessage = str;
          }
        }
      }
      for (;;)
      {
        if (!android.text.TextUtils.isEmpty(paramChatMessage))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
          for (bool = true;; bool = false)
          {
            paramBaseChatItemLayout.a(true, paramChatMessage, bool, false, i);
            this.d = true;
            paramBaseChatItemLayout.c.setOnClickListener(this);
            paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131296316));
            return;
          }
        }
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
          for (bool = true;; bool = false)
          {
            paramBaseChatItemLayout.a(true, (CharSequence)localObject, bool, false, i);
            this.d = true;
            paramBaseChatItemLayout.c.setOnClickListener(this);
            paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131296316));
            return;
          }
        }
        this.d = false;
        paramBaseChatItemLayout.a(false, null, false, false, -1);
        return;
        paramChatMessage = null;
        localObject = null;
      }
      label386:
      i = 2130839462;
    }
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1);
    }
    Context localContext = paramViewGroup.getContext();
    paramView = (BaseChatItemLayout)paramView;
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      paramView = new BaseChatItemLayout(localContext);
      paramView.setId(2131296391);
      paramView.setFocusableInTouchMode(true);
      paramView.setPadding(BaseChatItemLayout.u, BaseChatItemLayout.w, BaseChatItemLayout.v, 0);
      paramViewGroup = a();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
      paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      paramViewGroup.jdField_b_of_type_Int = paramInt1;
      paramViewGroup.jdField_c_of_type_Int = paramInt2;
      localObject2 = null;
      paramView.setContentDescription(null);
      paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.length(), "");
      localObject1 = localObject2;
      if (paramChatMessage.mNeedTimeStamp)
      {
        localObject1 = localObject2;
        if (paramChatMessage.time > 0L)
        {
          localObject1 = TimeFormatterUtils.a(localContext, 3, paramChatMessage.time * 1000L);
          paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.append((CharSequence)localObject1).append(" ");
        }
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.isSend()) {
        break label499;
      }
    }
    label499:
    for (int i = 1;; i = 0)
    {
      paramView.setHearIconPosition(i);
      ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a;
      localObject2 = localColorStateList;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        localObject2 = localColorStateList;
        if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          localObject2 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
        }
      }
      paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage.time, (ColorStateList)localObject2, (CharSequence)localObject1);
      paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427365));
      c(paramChatMessage, paramView);
      d(paramChatMessage, paramView);
      a(paramChatMessage, paramView, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        e(paramChatMessage, paramView);
      }
      a(paramChatMessage, paramView, paramViewGroup);
      b(paramChatMessage, paramView, paramViewGroup);
      b(paramChatMessage, paramView);
      a(paramChatMessage, paramView);
      paramViewGroup.jdField_c_of_type_AndroidViewView = a(paramChatMessage, paramViewGroup, paramViewGroup.jdField_c_of_type_AndroidViewView, paramView, paramOnLongClickAndTouchListener);
      a(paramChatMessage, localContext, paramView, paramViewGroup, paramInt1, paramInt2);
      paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
      paramView.setContentDescription(paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.toString());
      paramView.requestLayout();
      return paramView;
      paramViewGroup = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
      break;
    }
  }
  
  public abstract View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public abstract BaseBubbleBuilder.ViewHolder a();
  
  public abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.l, BaseChatItemLayout.i, BaseChatItemLayout.k, BaseChatItemLayout.j);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.i, BaseChatItemLayout.l, BaseChatItemLayout.j);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    int j = 0;
    int k = 0;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    int i;
    if (com.tencent.mobileqq.text.TextUtils.a(paramChatMessage.msg))
    {
      localObject1 = com.tencent.mobileqq.text.TextUtils.a(paramChatMessage.msg);
      localObject2 = localObject4;
      i = j;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject5 = paramBubbleInfo.a((String)localObject1);
        localObject2 = localObject4;
        localObject3 = localObject5;
        i = j;
        if (localObject5 != null)
        {
          localObject4 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          localObject2 = localObject4;
          localObject3 = localObject5;
          i = j;
          if (localObject4 != null)
          {
            localObject2 = localObject4;
            localObject3 = localObject5;
            i = j;
            if (((Pair)localObject4).first != null)
            {
              i = 1;
              localObject3 = localObject5;
              localObject2 = localObject4;
            }
          }
        }
      }
      j = k;
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
      {
        j = k;
        if ((paramChatMessage instanceof MessageForText))
        {
          j = k;
          if (VersionUtils.e())
          {
            localObject1 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
            j = k;
            if (localObject1 != null)
            {
              j = k;
              if (((Pair)localObject1).first != null)
              {
                j = k;
                if (paramView.getWidth() > ((BubbleInfo.CommonAttrs)((Pair)localObject1).first).a.s) {
                  j = 1;
                }
              }
            }
          }
        }
      }
      localObject1 = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      localObject4 = ((BubbleManager)localObject1).a(paramBubbleInfo.jdField_c_of_type_Int, false);
      if ((localObject1 == null) || (!(paramChatMessage instanceof MessageForText)) || (localObject4 == null) || (((BubbleConfig)localObject4).d == null) || (((BubbleConfig)localObject4).d.t == 0) || (!VersionUtils.e())) {
        break label652;
      }
      if (!paramChatMessage.isSend()) {
        break label598;
      }
      localObject1 = paramChatMessage.selfuin;
      label304:
      Object localObject5 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      if (localObject5 == null) {
        break label652;
      }
      localObject1 = ((FriendsManager)localObject5).a((String)localObject1);
      if ((((BubbleConfig)localObject4).d.t != -1) && (((ExtensionInfo)localObject1).pendantId != ((BubbleConfig)localObject4).d.t)) {
        break label652;
      }
    }
    label646:
    label652:
    for (k = 1;; k = 0)
    {
      if ((i != 0) || (j != 0) || (k != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
      }
      if (i != 0)
      {
        a("keyword_trigger", paramBubbleInfo.jdField_c_of_type_Int, localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject2 });
      }
      if ((j != 0) || (k != 0)) {
        if (j == 0) {
          break label646;
        }
      }
      for (i = 3;; i = 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramBubbleInfo.jdField_c_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
        if (paramBubbleInfo.a(paramView.getHeight()))
        {
          paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
          if ((paramView != null) && (paramView.first != null))
          {
            a("wordnum_trigger", paramBubbleInfo.jdField_c_of_type_Int, null);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
          }
        }
        return;
        localObject1 = paramChatMessage.msg;
        break;
        label598:
        if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
        {
          localObject1 = paramChatMessage.frienduin;
          break label304;
        }
        localObject1 = paramChatMessage.senderuin;
        break label304;
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, int paramInt)
  {
    paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if ((paramView != null) && (paramView.first != null))
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
    }
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  protected void a(ChatMessage paramChatMessage)
  {
    BaseChatPie localBaseChatPie = ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a();
    localBaseChatPie.b(paramChatMessage);
    localBaseChatPie.e(true);
    if (paramChatMessage == null) {
      return;
    }
    int i;
    if (paramChatMessage.istroop == 0) {
      i = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + i, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000) {
        i = 2;
      } else if (paramChatMessage.istroop == 1) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramBaseChatItemLayout))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    if ((b()) && (MultiMsgManager.a().a())) {
      paramQQCustomMenu.a(2131302486, this.jdField_a_of_type_AndroidContentContext.getString(2131366430));
    }
  }
  
  protected boolean a()
  {
    return BaseChatItemLayout.b;
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  public boolean a_(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
  }
  
  public void b(View paramView)
  {
    Object localObject2 = AIOUtils.a(paramView);
    if (localObject2 == null) {}
    label145:
    for (;;)
    {
      return;
      localObject3 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if ((((MessageRecord)localObject2).issend == 1) || (((MessageRecord)localObject2).issend == 2)) {}
      for (i = 1;; i = 0)
      {
        if (("1000000".equals(((MessageRecord)localObject2).senderuin)) || ("10000".equals(((MessageRecord)localObject2).senderuin)) || ((i == 0) && (((MessageRecord)localObject2).istroop == 7100))) {
          break label145;
        }
        if (!AnonymousChatHelper.a((MessageRecord)localObject2)) {
          break label706;
        }
        localObject1 = AnonymousChatHelper.a((MessageRecord)localObject2);
        if ((paramView != null) && ((((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_JavaLangString != null) || (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int == 2))) {
          break label147;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onHeadIconClick : an_id is null");
        return;
      }
    }
    label147:
    Object localObject3 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(((MessageRecord)localObject2).frienduin);
    Object localObject4 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if (localObject3 != null) {
      ((TroopHandler)localObject4).a(((TroopInfo)localObject3).troopuin, (byte)0, ((TroopInfo)localObject3).dwTimeStamp, 0);
    }
    int j = 0;
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i = j;
    if (localObject3 != null)
    {
      i = j;
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject4))
      {
        if ((((TroopInfo)localObject3).Administrator == null) || (!((TroopInfo)localObject3).Administrator.contains((CharSequence)localObject4))) {
          break label524;
        }
        i = 3;
      }
    }
    localObject3 = ((AnonymousChatHelper.AnonymousExtInfo)localObject1).a();
    if ((localObject3 != null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int != 2))
    {
      localObject3 = URLEncoder.encode(Base64.a((byte[])localObject3, 2));
      localObject4 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localStringBuilder = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject3).append("&gcode=").append(((MessageRecord)localObject2).frienduin).append("&avatar=").append(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_Int)).append("&nick=");
      if (android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString))
      {
        paramView = "";
        ((Intent)localObject4).putExtra("url", paramView + "&role=" + String.valueOf(i) + "&self=0");
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
        if (((MessageRecord)localObject2).msgData != null)
        {
          AnonymousChatHelper.a().a(((MessageRecord)localObject2).frienduin, (String)localObject3, (MessageRecord)localObject2);
          if (QLog.isDevelopLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 4, "report:" + ((MessageRecord)localObject2).msgData.toString());
          }
        }
      }
    }
    label524:
    while (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int != 2) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, ((MessageRecord)localObject2).frienduin, "", "", "");
        return;
        if (((String)localObject4).equals(((TroopInfo)localObject3).troopowneruin))
        {
          i = 2;
          break;
        }
        i = 1;
        break;
        paramView = URLEncoder.encode(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString);
      }
    }
    localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localObject4 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(((MessageRecord)localObject2).frienduin).append("&avatar=").append(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_Int)).append("&nick=");
    if (android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString)) {}
    for (paramView = "";; paramView = URLEncoder.encode(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString))
    {
      ((Intent)localObject3).putExtra("url", paramView + "&role=" + String.valueOf(i) + "&self=1");
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      break;
    }
    label706:
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    localObject4 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
    if (((localObject1 != null) && (((FriendManager)localObject1).f(((MessageRecord)localObject2).frienduin))) || ((localObject4 != null) && (((HotChatManager)localObject4).d(((MessageRecord)localObject2).frienduin)))) {}
    for (j = 1; (j == 0) && (((MessageRecord)localObject2).istroop == 1); j = 0)
    {
      paramView = new Intent(paramView.getContext(), TroopMemberCardActivity.class);
      paramView.putExtra("troopUin", ((MessageRecord)localObject2).frienduin);
      paramView.putExtra("memberUin", ((MessageRecord)localObject2).senderuin);
      paramView.putExtra("fromFlag", 0);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 2000);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 0, 0, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).senderuin, "", "");
      return;
    }
    boolean bool;
    if ((((MessageRecord)localObject2).istroop != 1000) && (((MessageRecord)localObject2).istroop != 1020) && (((MessageRecord)localObject2).istroop != 1004))
    {
      bool = ((FriendManager)localObject3).b(((MessageRecord)localObject2).senderuin);
      localObject1 = ((MessageRecord)localObject2).senderuin;
      label951:
      if (localObject1 == null) {
        break label1193;
      }
      if (((FriendManager)localObject3).b((String)localObject1)) {
        bool = true;
      }
      if (i == 0) {
        break label1195;
      }
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      paramView.h = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      label1002:
      if (((String)localObject1).equals(paramView.h)) {
        paramView.h = null;
      }
      paramView.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      paramView.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if ((((MessageRecord)localObject2).istroop != 1000) && (((MessageRecord)localObject2).istroop != 1020)) {
        break label2208;
      }
      paramView.jdField_d_of_type_JavaLangString = ((MessageRecord)localObject2).senderuin;
      label1072:
      paramView.jdField_f_of_type_Int = 2;
      paramView.g = 1;
      if ((((MessageRecord)localObject2).istroop != 1001) && (((MessageRecord)localObject2).istroop != 1010)) {
        break label2298;
      }
      if (((MessageRecord)localObject2).istroop != 1001) {
        break label2265;
      }
      paramView.g = 10;
      label1121:
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      ((Intent)localObject2).putExtra("AllInOne", paramView);
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localObject1)) {
        break label2285;
      }
      ((Intent)localObject2).putExtra("param_mode", 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      return;
      localObject1 = ((MessageRecord)localObject2).frienduin;
      bool = false;
      break label951;
      label1193:
      break;
      label1195:
      if (((MessageRecord)localObject2).istroop == 1008)
      {
        paramView = new Intent(paramView.getContext(), AccountDetailActivity.class);
        paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
        paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 2000);
        return;
      }
      if (((MessageRecord)localObject2).istroop == 1024)
      {
        paramView = new Intent(paramView.getContext(), EnterpriseDetailActivity.class);
        paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.putExtra("need_finish", true);
        ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 2000);
        return;
      }
      if (bool)
      {
        if (((MessageRecord)localObject2).istroop == 1) {}
        for (paramView = new ProfileActivity.AllInOne((String)localObject1, 20);; paramView = new ProfileActivity.AllInOne((String)localObject1, 1))
        {
          paramView.h = ((FriendManager)localObject3).a((String)localObject1);
          break;
        }
      }
      if (((MessageRecord)localObject2).istroop == 1010)
      {
        paramView = new ProfileActivity.AllInOne((String)localObject1, 76);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1001)
      {
        paramView = new ProfileActivity.AllInOne((String)localObject1, 42);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        paramView = new ProfileActivity.AllInOne((String)localObject1, 70);
        paramView.h = ((FriendManager)localObject3).a((String)localObject1);
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1000)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).frienduin, 22);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1020)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).frienduin, 58);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1)
      {
        if (j != 0) {}
        for (paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 58);; paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 21))
        {
          paramView.h = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ((MessageRecord)localObject2).senderuin);
          break;
        }
      }
      if (3000 == ((MessageRecord)localObject2).istroop)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 46);
        paramView.h = ((FriendManager)localObject3).c(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).senderuin);
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1001)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 42);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1004)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).frienduin, 47);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        paramView.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1005)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 2);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1023)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 74);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1009)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 57);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1006)
      {
        paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).frienduin, 34);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1009)
      {
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 57);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1021)
      {
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 72);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1022)
      {
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 27);
        paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1002;
      }
      if (((MessageRecord)localObject2).istroop == 1025)
      {
        if (this.jdField_a_of_type_AndroidContentContext == null) {
          break;
        }
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
        paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
        paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        return;
      }
      paramView = new ProfileActivity.AllInOne(((MessageRecord)localObject2).senderuin, 19);
      paramView.h = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
      break label1002;
      label2208:
      if (((MessageRecord)localObject2).istroop == 1)
      {
        paramView.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        paramView.c = ((MessageRecord)localObject2).frienduin;
        break label1072;
      }
      if (3000 != ((MessageRecord)localObject2).istroop) {
        break label1072;
      }
      paramView.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break label1072;
      label2265:
      if (((MessageRecord)localObject2).istroop != 1010) {
        break label1121;
      }
      paramView.g = 11;
      break label1121;
      label2285:
      ((Intent)localObject2).putExtra("param_mode", 3);
    }
    label2298:
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, paramView);
  }
  
  public void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage));
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localObject != null) && (((FriendManager)localObject).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          return false;
        }
        localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
        if ((localObject != null) && (((HotChatManager)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localChatMessage != null) && (localChatMessage.istroop == 1))
    {
      paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", "https://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=" + localChatMessage.frienduin + "&target=" + localChatMessage.senderuin);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("hide_more_button", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    if (a()) {}
    while ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {
      return;
    }
    AIOUtils.h = true;
    switch (paramView.getId())
    {
    case 2131296318: 
    case 2131296320: 
    default: 
      return;
    case 2131296315: 
      b(paramView);
      return;
    case 2131296321: 
      a(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */