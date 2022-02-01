package com.tencent.mobileqq.activity.flaotaio;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gle;
import glf;
import glg;
import glh;
import glj;
import gll;
import java.util.List;
import mqq.app.BasePadActivity;

public class FloatAioController
  implements ControllerCallBack
{
  private static final int jdField_a_of_type_Int = 21;
  public static final String a = "open_aio_by_red_msg";
  private float jdField_a_of_type_Float;
  private Handler jdField_a_of_type_AndroidOsHandler = new glf(this, Looper.getMainLooper());
  public WindowManager.LayoutParams a;
  private FloatAioPage jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage;
  private FloatHbCircle jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle;
  private FloatMsgBar jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private FloatAioPage jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage;
  private boolean jdField_b_of_type_Boolean = true;
  
  public FloatAioController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle = new FloatHbCircle(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle.a(new gle(this));
  }
  
  private FloatAioPage a(String paramString)
  {
    FloatAioPage localFloatAioPage1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(paramString)))
    {
      localFloatAioPage1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage = null;
    }
    for (;;)
    {
      FloatAioPage localFloatAioPage2 = localFloatAioPage1;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage != null)
      {
        localFloatAioPage2 = localFloatAioPage1;
        if (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(paramString))
        {
          localFloatAioPage2 = this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage;
          this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage = null;
        }
      }
      return localFloatAioPage2;
      localFloatAioPage1 = null;
    }
  }
  
  private FloatMsgBar a()
  {
    FloatMsgBar localFloatMsgBar = new FloatMsgBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
    ((SlipFrameLayout)localFloatMsgBar.b()).setCallBack(new glg(this));
    return localFloatMsgBar;
  }
  
  public static QQMessageFacade.Message a(QQMessageFacade.Message paramMessage)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    localMessage.uniseq = paramMessage.uniseq;
    localMessage.msgtype = paramMessage.msgtype;
    localMessage.istroop = paramMessage.istroop;
    localMessage.frienduin = paramMessage.frienduin;
    localMessage.senderuin = paramMessage.senderuin;
    localMessage.hbMsg = paramMessage.hbMsg;
    return localMessage;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if (paramContext != null)
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private String a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    String str;
    Object localObject;
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020))
    {
      str = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
      if ((!TextUtils.isEmpty(str)) && (!str.equals(paramMessage.frienduin))) {
        break label152;
      }
      localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramMessage.frienduin);
      if (localObject == null) {
        break label152;
      }
      if (TextUtils.isEmpty(((Friends)localObject).remark)) {
        break label143;
      }
      str = ((Friends)localObject).remark;
    }
    label143:
    label152:
    for (;;)
    {
      if (str != null)
      {
        localObject = str;
        if (!"".equals(str)) {}
      }
      else
      {
        localObject = paramMessage.frienduin;
      }
      return localObject;
      str = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, paramMessage.frienduin);
      break;
      str = ((Friends)localObject).name;
    }
  }
  
  private void a(Intent paramIntent, QQMessageFacade.Message paramMessage)
  {
    Object localObject1 = paramMessage.frienduin;
    Object localObject2 = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a((String)localObject1);
    if (localObject2 != null) {
      localObject1 = ((HotChatInfo)localObject2).troopCode;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        if ((paramMessage.istroop != 1000) && (paramMessage.istroop != 1020))
        {
          localObject2 = localObject1;
          if (paramMessage.istroop != 1004) {}
        }
        else
        {
          localObject2 = paramMessage.senderuin;
        }
      }
      paramIntent.putExtra("troop_uin", (String)localObject2);
      return;
      localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject2 != null) {
        if (((FriendManager)localObject2).f((String)localObject1))
        {
          localObject1 = ((FriendManager)localObject2).a((String)localObject1);
          if (localObject1 != null) {
            localObject1 = ((OpenTroopInfo)localObject1).troopUin;
          }
        }
        else
        {
          localObject1 = ((FriendManager)localObject2).a((String)localObject1 + "");
          if ((localObject1 != null) && (((TroopInfo)localObject1).troopcode != null))
          {
            localObject1 = ((TroopInfo)localObject1).troopcode;
            continue;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if (!a()) {}
    do
    {
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage == null)
      {
        b(paramMessage, paramBoolean);
        return;
      }
      if (!this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(paramMessage.frienduin))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage = this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage;
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.b();
        b(paramMessage, paramBoolean);
        return;
      }
    } while ((paramMessage.hbMsg == null) || (!paramMessage.hbMsg.jdField_a_of_type_Boolean) || (paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a == null));
    String str1 = paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
    String str2 = a(paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a);
    FloatHongbaoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.getNativeAndroid(), str1, str2, this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a);
    this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(b(paramMessage), paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.getMsgTitle());
    c(paramBoolean);
    paramMessage.hbMsg = null;
  }
  
  private void b(Intent paramIntent, QQMessageFacade.Message paramMessage)
  {
    paramIntent.putExtra("friendUin", b(paramMessage));
  }
  
  private void b(QQMessageFacade.Message paramMessage)
  {
    Object localObject3 = "";
    Object localObject5 = null;
    Object localObject1;
    if (ActionMsgUtil.d(paramMessage.msgtype)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368619);
    }
    for (;;)
    {
      Object localObject4;
      label70:
      boolean bool;
      if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020) || (paramMessage.istroop == 1004))
      {
        localObject4 = a(paramMessage, true);
        if (localObject4 != null)
        {
          localObject3 = localObject4;
          if (!"".equals(localObject4)) {}
        }
        else
        {
          localObject3 = paramMessage.frienduin;
        }
        bool = paramMessage.hbMsg.jdField_a_of_type_Boolean;
        switch (paramMessage.istroop)
        {
        default: 
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage.frienduin, true);
          localObject4 = a(paramMessage) + (String)localObject1;
        }
      }
      label171:
      label966:
      for (;;)
      {
        label206:
        Object localObject6;
        if (ActionMsgUtil.a(paramMessage.msgtype)) {
          if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue)))
          {
            localObject1 = paramMessage.actMsgContentValue;
            localObject4 = localObject1;
            localObject6 = localObject1;
          }
        }
        for (;;)
        {
          localObject1 = localObject6;
          if (paramMessage.msgtype == -2016)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramMessage, true);
            localObject4 = localObject1;
          }
          localObject6 = localObject1;
          if (bool) {
            localObject6 = ((String)localObject1).replaceAll("\\[QQ红包\\]", "");
          }
          localObject1 = "";
          int i = ((String)localObject6).indexOf((String)localObject4);
          if (i > 0) {
            localObject1 = ((String)localObject6).substring(0, i);
          }
          localObject4 = new QQText((CharSequence)localObject4, 3, 24);
          localObject6 = new QQText((CharSequence)localObject6, 3, 18);
          this.jdField_a_of_type_AndroidOsHandler.post(new glh(this, (String)localObject1, (CharSequence)localObject4, paramMessage, (String)localObject3, (QQText)localObject6, (Bitmap)localObject5));
          return;
          if (paramMessage.msgtype == -2009)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), paramMessage, true);
            break;
          }
          if (paramMessage.msgtype == -2011)
          {
            try
            {
              localObject1 = StructMsgFactory.a(paramMessage.msgData);
              if (localObject1 == null)
              {
                localObject1 = localObject3;
                if (QLog.isColorLevel())
                {
                  QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
                  localObject1 = localObject3;
                }
              }
              else
              {
                localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + localException.getMessage(), localException);
              }
              localObject2 = "";
            }
            break;
          }
          Object localObject2 = paramMessage.msg;
          break;
          localObject4 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.istroop);
          break label70;
          localObject6 = paramMessage.nickName;
          localObject4 = localObject6;
          if (TextUtils.isEmpty((CharSequence)localObject6)) {
            localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, 0);
          }
          if (bool) {
            localObject3 = (String)localObject4 + " 来自" + (String)localObject3;
          }
          for (localObject4 = localObject2;; localObject4 = a(paramMessage) + (String)localObject4 + ": " + (String)localObject2)
          {
            localObject6 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
            if (localObject6 == null) {
              break label966;
            }
            localObject5 = ((DiscussionHandler)localObject6).a(paramMessage.frienduin, true);
            break;
          }
          if (paramMessage.msgtype == -1013)
          {
            localObject4 = localObject2;
            break label171;
          }
          localObject5 = paramMessage.nickName;
          localObject4 = localObject5;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            localObject4 = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.senderuin);
          }
          if (bool) {
            localObject4 = (String)localObject4 + " 来自" + (String)localObject3;
          }
          for (localObject3 = localObject2;; localObject3 = localObject5)
          {
            localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage.frienduin, (byte)3, false, false);
            localObject5 = localObject4;
            localObject4 = localObject3;
            localObject3 = localObject5;
            localObject5 = localObject6;
            break;
            localObject5 = a(paramMessage) + (String)localObject4 + ": " + (String)localObject2;
            localObject4 = localObject3;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppShareIDUtil.a(paramMessage.shareAppID));
          if ((localObject2 == null) || (((AppShareID)localObject2).messagetail == null) || ("".equals(((AppShareID)localObject2).messagetail)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368378);
            break label206;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368376) + ((AppShareID)localObject2).messagetail + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368377);
          break label206;
          localObject6 = localObject4;
          localObject4 = localObject2;
        }
      }
    }
  }
  
  private void b(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage = new FloatAioPage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(this);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("open_aio_by_red_msg", paramMessage.hbMsg.jdField_a_of_type_Boolean);
    if ((paramMessage.hbMsg.jdField_a_of_type_Boolean) && (paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null)) {
      ((Intent)localObject1).putExtra("wish_word", paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.getMsgTitle());
    }
    ((Intent)localObject1).putExtra("msg_uni_seq", paramMessage.uniseq);
    ((Intent)localObject1).putExtra("uin", paramMessage.frienduin);
    ((Intent)localObject1).putExtra("uintype", paramMessage.istroop);
    ((Intent)localObject1).putExtra("uinname", ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.istroop));
    a((Intent)localObject1, paramMessage);
    b((Intent)localObject1, paramMessage);
    if ((paramBoolean) && (!paramMessage.hbMsg.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true; !this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a((Intent)localObject1); bool = false) {
      return;
    }
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage;
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar != null)) {}
    for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a();; localObject1 = null)
    {
      ((FloatAioPage)localObject2).a(bool, (FloatAioController.MsgBarInfo)localObject1);
      if (!bool) {
        c(paramBoolean);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a == null) {
        break;
      }
      if ((paramMessage.hbMsg.jdField_a_of_type_Boolean) && (paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null) && (paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg != null))
      {
        localObject1 = paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
        localObject2 = a(paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a);
        FloatHongbaoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.getNativeAndroid(), (String)localObject1, (String)localObject2, this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a);
        paramMessage.hbMsg = null;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {
        break label427;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800617D", "0X800617D", 0, 0, "", "", "", "");
      return;
    }
    label427:
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800617B", "0X800617B", 0, 0, "", "", "", "");
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  private boolean b(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    FloatSetting localFloatSetting;
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (((this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage != null) && (((paramMessage.hbMsg.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.b())) || ((this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(paramMessage.frienduin)) && ((!paramMessage.hbMsg.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a()))))) || (!a()) || (paramMessage.msgtype == -2018));
        localFloatSetting = FloatSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      } while ((!localFloatSetting.a(str)) && (!paramMessage.hbMsg.jdField_a_of_type_Boolean));
      if ((paramMessage.bizType == 4) || (c(paramMessage)) || (paramMessage.bizType == 2)) {
        return true;
      }
      if (((paramMessage.istroop == 0) || (paramMessage.istroop == 1004) || (paramMessage.istroop == 1000) || (paramMessage.istroop == 1006)) && ((localFloatSetting.b(str)) || (paramMessage.hbMsg.jdField_a_of_type_Boolean))) {
        return true;
      }
      if ((paramMessage.istroop == 3000) && ((localFloatSetting.c(str)) || (paramMessage.hbMsg.jdField_a_of_type_Boolean))) {
        return true;
      }
    } while ((paramMessage.istroop != 1) || ((!localFloatSetting.d(str)) && (!paramMessage.hbMsg.jdField_a_of_type_Boolean)));
    return true;
  }
  
  private void c(QQMessageFacade.Message paramMessage)
  {
    paramMessage.hbMsg = new FloatAioController.HongbaoMsg();
    if ((paramMessage.msgtype == -2025) && (paramMessage.msgData != null)) {}
    try
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = new MessageForQQWalletMsg();
      localMessageForQQWalletMsg.msgData = paramMessage.msgData;
      localMessageForQQWalletMsg.parse();
      paramMessage.hbMsg.jdField_a_of_type_Boolean = MessageForQQWalletMsg.isRedPacketMsg(localMessageForQQWalletMsg);
      if (paramMessage.hbMsg.jdField_a_of_type_Boolean) {
        paramMessage.hbMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = localMessageForQQWalletMsg;
      }
      return;
    }
    catch (Exception paramMessage)
    {
      Log.e("app2", "isRedMsg error:", paramMessage);
    }
  }
  
  private boolean c(QQMessageFacade.Message paramMessage)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1004)) {}
    for (paramMessage = paramMessage.frienduin; localSharedPreferences.contains("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + paramMessage); paramMessage = paramMessage.senderuin) {
      return true;
    }
    return false;
  }
  
  private void d(QQMessageFacade.Message paramMessage)
  {
    if (b())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a().hbMsg.jdField_a_of_type_Boolean) && (!paramMessage.hbMsg.jdField_a_of_type_Boolean)) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a().hbMsg.jdField_a_of_type_Boolean) && (paramMessage.hbMsg.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a());
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(21);
    }
    for (;;)
    {
      b(paramMessage);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(21, 4200L);
      return;
      this.jdField_a_of_type_AndroidOsHandler.post(new glj(this));
    }
  }
  
  public String a(QQMessageFacade.Message paramMessage)
  {
    Object localObject;
    if (paramMessage.hbMsg.jdField_a_of_type_Boolean) {
      localObject = "";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage);
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      localObject = str;
    } while (!c(paramMessage));
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369155);
  }
  
  public String a(MessageForQQWalletMsg paramMessageForQQWalletMsg, SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 2) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1001)) {}
    for (int i = 1;; i = 0)
    {
      paramSessionInfo = str;
      if (i != 0)
      {
        paramSessionInfo = str;
        if (!paramMessageForQQWalletMsg.isSend()) {
          paramSessionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        }
      }
      return paramSessionInfo;
    }
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage != null) && (!a())) {
      this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.b();
    }
  }
  
  public void a(Context paramContext, QQMessageFacade.Message paramMessage)
  {
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("click_msg", true);
    localIntent.putExtra("target_activity", ChatActivity.class);
    localIntent.putExtra("tab_index", 1);
    localIntent.addFlags(335544320);
    localIntent.putExtra("msg_uni_seq", paramMessage.uniseq);
    localIntent.putExtra("uin", paramMessage.frienduin);
    a(localIntent, paramMessage);
    localIntent.putExtra("uintype", paramMessage.istroop);
    paramContext.startActivity(localIntent);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    try
    {
      c(paramMessage);
      if (b(paramMessage)) {
        d(paramMessage);
      }
      return;
    }
    catch (Exception paramMessage)
    {
      Log.e("app2", "receivedMsgNotification error", paramMessage);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new gll(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle.a(paramBoolean);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) || (BasePadActivity.getContaierViewId() == 2131301978) || (BasePadActivity.getContaierViewId() == 2131297932)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          bool1 = false;
        }
      }
      bool2 = bool1;
      if (bool1) {}
      for (;;)
      {
        try
        {
          bool2 = ((PowerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("power")).isScreenOn();
          if (!bool2)
          {
            bool1 = false;
            bool2 = bool1;
            return bool2;
          }
        }
        catch (Exception localException)
        {
          return bool1;
        }
      }
    }
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    return (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a(paramMessage.frienduin));
  }
  
  public String b(QQMessageFacade.Message paramMessage)
  {
    switch (paramMessage.istroop)
    {
    default: 
      return paramMessage.frienduin;
    }
    return paramMessage.senderuin;
  }
  
  public void b()
  {
    c(false);
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.b();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.b().getParent() != null))
    {
      this.jdField_a_of_type_Boolean = false;
      WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSystemService("window");
      if ((this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams != null) && ((!paramBoolean) || ((this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a().hbMsg.jdField_a_of_type_Boolean))))
      {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131558952;
        localWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.b(), this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      }
      localWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.b());
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a().hbMsg.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatMsgBar.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatAioController
 * JD-Core Version:    0.7.0.1
 */