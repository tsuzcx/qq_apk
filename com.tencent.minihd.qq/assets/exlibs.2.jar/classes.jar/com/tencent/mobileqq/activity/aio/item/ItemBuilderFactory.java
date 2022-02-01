package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ItemBuilderFactory
{
  private static final int A = 26;
  private static final int B = 27;
  private static final int C = 28;
  private static final int D = 29;
  private static final int E = 30;
  private static final int F = 31;
  private static final int G = 32;
  private static final int H = 33;
  private static final int I = 34;
  private static final int J = 35;
  private static final int K = 36;
  public static final int a = 37;
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  private static final int h = 6;
  private static final int i = 7;
  private static final int j = 8;
  private static final int k = 9;
  private static final int l = 10;
  private static final int m = 11;
  private static final int n = 12;
  private static final int o = 13;
  private static final int p = 15;
  private static final int q = 16;
  private static final int r = 17;
  private static final int s = 18;
  private static final int t = 19;
  private static final int u = 20;
  private static final int v = 21;
  private static final int w = 22;
  private static final int x = 23;
  private static final int y = 24;
  private static final int z = 25;
  private Context jdField_a_of_type_AndroidContentContext;
  DevShortVideoItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder;
  DevicePttItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  ActivityChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder;
  AppSharePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder;
  DevicePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder;
  DeviceSingleStructBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder;
  EnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder;
  FileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder;
  GrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder;
  LocationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder;
  LongMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder;
  MarketFaceItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder;
  MixedMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder;
  MyEnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder;
  PAGameItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPAGameItemBuilder;
  PAMultiItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder;
  PASingleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder;
  PATextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder;
  PicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder;
  PttItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder;
  QQWalletMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder;
  QzoneFeedItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder;
  RichStatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder;
  ShakeItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder;
  ShortVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder;
  StructTroopNotificationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder;
  StructingMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
  TextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder;
  TextTranslationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder;
  ThumbItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder;
  TroopFileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder;
  TroopUnreadTipsChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder;
  VideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ItemBuilderFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    int i2 = 15;
    int i1;
    if ((paramChatMessage instanceof MessageForText)) {
      if (((MessageForText)paramChatMessage).locationUrl != null) {
        i1 = 10;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i1;
            if ((paramChatMessage.vipBubbleID != 100000L) || (paramChatMessage.isSend())) {
              break;
            }
            return 9;
            i1 = i2;
          } while ((paramChatMessage instanceof MessageForGrayTips));
          i1 = i2;
        } while ((paramChatMessage instanceof MessageForNewGrayTips));
        i1 = i2;
      } while ((paramChatMessage instanceof MessageForSafeGrayTips));
      i1 = i2;
    } while ((paramChatMessage instanceof MessageForIncompatibleGrayTips));
    if ((paramChatMessage instanceof MessageForPic))
    {
      if (((MessageForPic)paramChatMessage).isMixed) {
        return 24;
      }
      return 1;
    }
    if ((paramChatMessage instanceof MessageForDevPtt)) {
      return 33;
    }
    if ((paramChatMessage instanceof MessageForPtt)) {
      return 2;
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      return 3;
    }
    if ((paramChatMessage instanceof MessageForVideo)) {
      return 11;
    }
    if ((paramChatMessage instanceof MessageForMarketFace)) {
      return 12;
    }
    if ((paramChatMessage instanceof MessageForRichState)) {
      return 13;
    }
    if ((paramChatMessage instanceof MessageForPubAccount))
    {
      paramChatMessage = ((MessageForPubAccount)paramChatMessage).mPAMessage;
      if ((paramChatMessage != null) && (paramChatMessage.items != null) && (paramChatMessage.items.size() != 0)) {
        if (((PAMessage.Item)paramChatMessage.items.get(0)).cover != null)
        {
          if (paramChatMessage.items.size() == 1) {
            return 6;
          }
          if (paramChatMessage.items.size() >= 2)
          {
            if (!TextUtils.isEmpty(((PAMessage.Item)paramChatMessage.items.get(1)).a_rankListUrl)) {
              return 30;
            }
            return 7;
          }
        }
        else
        {
          return 8;
        }
      }
    }
    else
    {
      if ((paramChatMessage instanceof MessageForTroopNotification)) {
        return 28;
      }
      if ((paramChatMessage instanceof MessageForStructing)) {
        return 5;
      }
      if ((paramChatMessage instanceof MessageForFunnyFace)) {
        return 19;
      }
      if (((paramChatMessage instanceof MessageForLongMsg)) && (paramChatMessage.msgtype != -1036)) {
        return 17;
      }
      if (((paramChatMessage instanceof MessageForMixedMsg)) || ((paramChatMessage != null) && (paramChatMessage.msgtype == -1036))) {
        return 18;
      }
      if ((paramChatMessage instanceof MessageForQzoneFeed)) {
        return 21;
      }
      if ((paramChatMessage instanceof MessageForActivity)) {
        return 16;
      }
      if ((paramChatMessage instanceof MessageForEnterTroop)) {
        return 22;
      }
      if ((paramChatMessage instanceof MessageForMyEnterTroop)) {
        return 23;
      }
      if ((paramChatMessage instanceof MessageForTroopFile)) {
        return 25;
      }
      if ((paramChatMessage instanceof MessageForShakeWindow)) {
        return 26;
      }
      if ((paramChatMessage instanceof MessageForTroopUnreadTips)) {
        return 27;
      }
      if ((paramChatMessage instanceof MessageForDevShortVideo)) {
        return 35;
      }
      if ((paramChatMessage instanceof MessageForShortVideo)) {
        return 29;
      }
      if ((paramChatMessage instanceof MessageForColorRing)) {
        return 31;
      }
      if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
        return 32;
      }
      if ((paramChatMessage instanceof MessageForDeviceFile))
      {
        if (((MessageForDeviceFile)paramChatMessage).nFileMsgType == 2) {
          return 36;
        }
      }
      else if ((paramChatMessage instanceof MessageForDeviceSingleStruct)) {
        return 34;
      }
    }
    return 0;
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    switch (a(paramChatMessage))
    {
    case 4: 
    case 14: 
    case 19: 
    case 20: 
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder = new TextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder;
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder = new FileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder = new PicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder;
    case 24: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder = new AppSharePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder = new PttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder;
    case 33: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder = new DevicePttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePttItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder;
    case 15: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder = new GrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder;
    case 6: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder = new PASingleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder;
    case 7: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder = new PAMultiItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder;
    case 8: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder = new PATextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder;
    case 30: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAGameItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAGameItemBuilder = new PAGameItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAGameItemBuilder;
    case 5: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder = new StructingMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder = new LocationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder;
    case 11: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder = new VideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder;
    case 13: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder = new RichStatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        paramChatMessage = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
        if (paramChatMessage != null) {
          paramChatMessage.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder);
        }
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder;
    case 9: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder = new TextTranslationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder;
    case 12: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder = new MarketFaceItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder;
    case 16: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder = new ActivityChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder;
    case 22: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder = new EnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder;
    case 23: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder = new MyEnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder;
    case 17: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder = new LongMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder;
    case 18: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder = new MixedMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder;
    case 21: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder = new QzoneFeedItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder;
    case 25: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder = new TroopFileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder;
    case 26: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder = new ShakeItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder;
    case 27: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder = new TroopUnreadTipsChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder;
    case 28: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder = new StructTroopNotificationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder;
    case 29: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder = new ShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder;
    case 31: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder = new ThumbItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder;
    case 32: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder = new QQWalletMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder;
    case 35: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder = new DevShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder;
    case 34: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder = new DeviceSingleStructBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceSingleItemBuilder");
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder = new DevicePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePicItemBuilder");
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */