package com.tencent.mobileqq.emosm.web;

import ConfigPush.FileStorageServerListInfo;
import VIP.BaseInfo;
import VIP.ReqGetApiList;
import VIP.ReqGetOpenId;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletOpenHandler;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyCodeManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MessengerService$IncomingHandler
  extends Handler
{
  MessengerService$IncomingHandler(MessengerService paramMessengerService) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (!(MessengerService.access$100(this.this$0) instanceof QQAppInterface))) {}
    Object localObject8;
    Object localObject4;
    Object localObject7;
    long l1;
    Object localObject5;
    int j;
    int i;
    Object localObject6;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject8 = (QQAppInterface)MessengerService.access$200(this.this$0);
            if ((paramMessage != null) && (paramMessage.replyTo != null)) {
              this.this$0.mClient = paramMessage.replyTo;
            }
            localObject4 = (EmojiManager)MessengerService.access$300(this.this$0).getManager(42);
            switch (paramMessage.what)
            {
            default: 
              super.handleMessage(paramMessage);
              return;
            case 1: 
              this.this$0.mClient = paramMessage.replyTo;
              if ((localObject8 != null) && (localObject4 != null)) {
                ((EmojiManager)localObject4).a.a(this.this$0.mListener);
              }
              EquipLockWebImpl.a().a((QQAppInterface)localObject8, this.this$0.mClient);
              return;
            case 2: 
              if ((localObject8 != null) && (localObject4 != null)) {
                ((EmojiManager)localObject4).a.b(this.this$0.mListener);
              }
              EquipLockWebImpl.a().a();
              this.this$0.mClient = null;
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.emoji.web.MessengerService", 2, "Received server req: ");
            }
            localObject7 = paramMessage.getData();
          } while (localObject7 == null);
          localObject1 = ((Bundle)localObject7).getString("cmd");
          paramMessage = ((Bundle)localObject7).getBundle("request");
          if (((String)localObject1).equals("queryEmojiInfo"))
          {
            paramMessage = ((EmojiManager)localObject4).b(paramMessage);
            if ((QLog.isColorLevel()) && (paramMessage != null)) {
              QLog.i("Q.emoji.web.MessengerService", 2, "qq queryEmojiInfo: result:" + paramMessage.getInt("result") + ";id:" + paramMessage.getInt("id") + ";status:" + paramMessage.getInt("status") + ";progress:" + paramMessage.getInt("progress") + ";pluginStatus:" + paramMessage.getInt("pluginStatus") + ";pluginSize:" + paramMessage.getLong("pluginSize"));
            }
            if (paramMessage != null) {
              ((Bundle)localObject7).putBundle("response", paramMessage);
            }
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if (((String)localObject1).equals("queryEmojiInfos"))
          {
            paramMessage = ((EmojiManager)localObject4).a();
            if (paramMessage != null) {
              ((Bundle)localObject7).putBundle("response", paramMessage);
            }
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if (((String)localObject1).equals("startDownloadEmoji"))
          {
            paramMessage = ((EmojiManager)MessengerService.access$400(this.this$0).getManager(42)).a(paramMessage);
            if (QLog.isColorLevel()) {
              QLog.i("Q.emoji.web.MessengerService", 2, "qq startDownloadEmoji: result:" + paramMessage.getInt("result") + ";messge:" + paramMessage.getString("message"));
            }
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if (((String)localObject1).equals("stopDownloadEmoji"))
          {
            paramMessage = ((EmojiManager)MessengerService.access$500(this.this$0).getManager(42)).a(String.valueOf(paramMessage.getInt("id")));
            if (QLog.isColorLevel()) {
              QLog.i("Q.emoji.web.MessengerService", 2, "qq stopDownloadEmoji: result:" + paramMessage.getInt("result") + ";messge:" + paramMessage.getString("messge"));
            }
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
        } while ("writeQFaceResult".equals(localObject1));
        if ("getFaceFilePath".equals(localObject1))
        {
          paramMessage = ((QQAppInterface)localObject8).a(1, ((Bundle)localObject7).getBundle("request").getString("uin"), 0);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("faceFilePath", paramMessage);
          ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("changeAvatar".equals(localObject1))
        {
          bool = ProfileCardUtil.a((QQAppInterface)localObject8, ((Bundle)localObject7).getBundle("request").getString("path"));
          paramMessage = new Bundle();
          paramMessage.putBoolean("updateResult", bool);
          ((Bundle)localObject7).putBundle("response", paramMessage);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("updatePendantId".equals(localObject1))
        {
          paramMessage = ((Bundle)localObject7).getBundle("request");
          localObject4 = paramMessage.getString("uin");
          l1 = paramMessage.getLong("pendantId");
          localObject5 = (FriendsManagerImp)((QQAppInterface)localObject8).getManager(8);
          localObject1 = ((FriendsManagerImp)localObject5).a((String)localObject4);
          paramMessage = (Message)localObject1;
          if (localObject1 == null)
          {
            paramMessage = new ExtensionInfo();
            paramMessage.uin = ((String)localObject4);
          }
          paramMessage.pendantId = l1;
          paramMessage.timestamp = System.currentTimeMillis();
          ((FriendsManagerImp)localObject5).a(paramMessage);
          paramMessage = new Bundle();
          paramMessage.putBoolean("updateResult", true);
          ((Bundle)localObject7).putBundle("response", paramMessage);
          this.this$0.onRespToClient((Bundle)localObject7);
          ReportController.b((QQAppInterface)localObject8, "CliStatus", "", "", "AvatarPendant", "ChangeHead", 0, 0, "", "", "", "");
          return;
        }
        if ("reportActionCount".equals(localObject1))
        {
          j = ((SVIPHandler)((QQAppInterface)localObject8).a(12)).f();
          localObject1 = StatisticCollector.a(((QQAppInterface)localObject8).getApplication());
          i = 0;
          if (j == 3) {
            i = 2;
          }
          ((StatisticCollector)localObject1).a((AppRuntime)localObject8, ((QQAppInterface)localObject8).a(), paramMessage.getString("optype"), paramMessage.getString("opname"), 0, 1, null, String.valueOf(i), null, null, null);
          return;
        }
        if ("setup".equals(localObject1)) {
          try
          {
            i = paramMessage.getInt("id");
            ((SVIPHandler)((QQAppInterface)localObject8).a(12)).a(i);
            paramMessage = new Bundle();
            paramMessage.putInt("id", i);
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          catch (Exception paramMessage)
          {
            paramMessage.printStackTrace();
            return;
          }
        }
        if ("queryLocal".equals(localObject1))
        {
          i = ((SVIPHandler)((QQAppInterface)localObject8).a(12)).e();
          paramMessage = new Bundle();
          paramMessage.putInt("id", i);
          ((Bundle)localObject7).putBundle("response", paramMessage);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("getFaceFilePath".equals(localObject1))
        {
          paramMessage = ((QQAppInterface)localObject8).a(1, ((Bundle)localObject7).getBundle("request").getString("uin"), 0);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("faceFilePath", paramMessage);
          ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("changeAvatar".equals(localObject1))
        {
          bool = ProfileCardUtil.a((QQAppInterface)localObject8, ((Bundle)localObject7).getBundle("request").getString("path"));
          paramMessage = new Bundle();
          paramMessage.putBoolean("updateResult", bool);
          ((Bundle)localObject7).putBundle("response", paramMessage);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("startDownloadTheme".equals(localObject1))
        {
          localObject1 = paramMessage.getString("url");
          localObject4 = paramMessage.getString("themeZipPath");
          l1 = paramMessage.getLong("size");
          localObject5 = paramMessage.getString("id");
          localObject6 = paramMessage.getString("version");
          paramMessage = new Bundle();
          paramMessage.putString("id", (String)localObject5);
          paramMessage.putString("version", (String)localObject6);
          paramMessage.putLong("size", l1);
          paramMessage.putInt("srcType", 4);
          paramMessage.putString("callbackId", ((Bundle)localObject7).getString("callbackid"));
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject4));
          ((DownloadTask)localObject1).b = true;
          i = (int)(l1 / 50L);
          if (i > 2048) {
            ((DownloadTask)localObject1).b(i);
          }
          ((DownloadTask)localObject1).b(false);
          ((DownloaderFactory)MessengerService.access$600(this.this$0).getManager(46)).a(1).a((DownloadTask)localObject1, this.this$0.mThemeDownloadListener, paramMessage);
          paramMessage = new Bundle();
          paramMessage.putBoolean("StartDownloadResult", true);
          ((Bundle)localObject7).putBundle("response", paramMessage);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if (!"stopdownload".equals(localObject1)) {
          break;
        }
      } while (paramMessage == null);
      localObject1 = new Bundle();
      paramMessage = paramMessage.getString("url");
      if (((DownloaderFactory)MessengerService.access$700(this.this$0).getManager(46)).a(1).a(false, paramMessage) == 0) {}
      for (bool = true;; bool = false)
      {
        ((Bundle)localObject1).putBoolean("processor", bool);
        ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
        this.this$0.onRespToClient((Bundle)localObject7);
        return;
      }
      if (!"pausedownload".equals(localObject1)) {
        break;
      }
    } while (paramMessage == null);
    paramMessage = new Bundle();
    Object localObject1 = ((Bundle)localObject7).getString("url");
    if (((DownloaderFactory)MessengerService.access$800(this.this$0).getManager(46)).a(1).a(false, (String)localObject1) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramMessage.putBoolean("processor", bool);
      ((Bundle)localObject7).putBundle("response", paramMessage);
      this.this$0.onRespToClient((Bundle)localObject7);
      return;
    }
    if ("reportTheme".equals(localObject1))
    {
      localObject1 = paramMessage.getString("subAction");
      localObject4 = paramMessage.getString("actionName");
      j = paramMessage.getInt("result");
      localObject5 = paramMessage.getString("r2");
      localObject6 = paramMessage.getString("r4");
      l1 = paramMessage.getLong("downloadTime");
      i = ((SVIPHandler)((QQAppInterface)localObject8).a(12)).f();
      if (i == 2) {
        i = 0;
      }
    }
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject8, "CliOper", "", "", (String)localObject1, (String)localObject4, 0, j, (String)localObject5, "" + i, (String)localObject6, String.valueOf(l1));
      return;
      if (i == 3)
      {
        i = 2;
        continue;
        if ("authTheme".equals(localObject1))
        {
          localObject1 = paramMessage.getString("themeId");
          paramMessage = paramMessage.getString("version");
          ((ThemeHandler)((QQAppInterface)MessengerService.access$900(this.this$0)).a(13)).a((String)localObject1, paramMessage);
          return;
        }
        if ("themeSwitchSucess".equals(localObject1))
        {
          ((ChatBackgroundManager)((QQAppInterface)localObject8).getManager(61)).a(((QQAppInterface)localObject8).getAccount(), null, "null");
          return;
        }
        if ("getUserVipType".equals(localObject1))
        {
          localObject1 = new Bundle();
          localObject4 = (SVIPHandler)((QQAppInterface)localObject8).a(12);
          paramMessage = paramMessage.getString("uin");
          i = ((SVIPHandler)localObject4).f();
          ((Bundle)localObject1).putString("uin", paramMessage);
          ((Bundle)localObject1).putInt("type", i);
          ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("notifyTroopUpgradeSuccess".equals(localObject1))
        {
          ((TroopHandler)((QQAppInterface)localObject8).a(19)).b(paramMessage.getString("groupId"), paramMessage.getInt("type"));
          return;
        }
        if ("chatbackground_setbg".equals(localObject1))
        {
          localObject1 = paramMessage.getString("path");
          localObject4 = paramMessage.getString("friendUin");
          localObject5 = paramMessage.getString("from");
          paramMessage = (Intent)paramMessage.getParcelable("intent");
          localObject6 = (ChatBackgroundManager)((QQAppInterface)localObject8).getManager(61);
          ((ChatBackgroundManager)localObject6).a(((QQAppInterface)localObject8).getAccount(), (String)localObject4, (String)localObject1);
          ((ChatBackgroundManager)localObject6).a(paramMessage);
          ((ChatBackgroundManager)localObject6).a(((QQAppInterface)localObject8).getApplication().getApplicationContext(), ((QQAppInterface)localObject8).getAccount());
          if ((localObject5 == null) || (!((String)localObject5).equals("chatbgJs"))) {
            break;
          }
          paramMessage = new Bundle();
          paramMessage.putInt("result", 0);
          ((Bundle)localObject7).putBundle("response", paramMessage);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("chatbackground_startDownload".equals(localObject1))
        {
          localObject1 = new ChatBackgroundInfo();
          ((ChatBackgroundInfo)localObject1).id = paramMessage.getString("id");
          ((ChatBackgroundInfo)localObject1).url = paramMessage.getString("url");
          ((ChatBackgroundInfo)localObject1).name = paramMessage.getString("name");
          ((ChatBackgroundInfo)localObject1).thumbUrl = paramMessage.getString("thumbUrl");
          paramMessage = ((Bundle)localObject7).getString("callbackid");
          localObject4 = (ChatBackgroundManager)((QQAppInterface)localObject8).getManager(61);
          ((ChatBackgroundManager)localObject4).a(this.this$0.mVipIPCDownloadListener);
          ((ChatBackgroundManager)localObject4).a((ChatBackgroundInfo)localObject1, paramMessage);
          return;
        }
        if ("chatbackground_stopdownload".equals(localObject1))
        {
          localObject1 = paramMessage.getString("id");
          paramMessage = paramMessage.getString("url");
          ((ChatBackgroundManager)((QQAppInterface)localObject8).getManager(61)).a((String)localObject1, paramMessage);
          paramMessage = new Bundle();
          paramMessage.putString("id", (String)localObject1);
          ((Bundle)localObject7).putBundle("response", paramMessage);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("chatbackground_querinfo".equals(localObject1))
        {
          localObject1 = paramMessage.getString("id");
          paramMessage = paramMessage.getString("url");
          paramMessage = ((ChatBackgroundManager)((QQAppInterface)localObject8).getManager(61)).a(((QQAppInterface)localObject8).getApplication().getApplicationContext(), (String)localObject1, paramMessage);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("status", paramMessage.getInt("status"));
          ((Bundle)localObject1).putString("id", paramMessage.getString("id"));
          ((Bundle)localObject1).putString("message", paramMessage.getString("message"));
          ((Bundle)localObject1).putInt("result", paramMessage.getInt("result"));
          ((Bundle)localObject1).putInt("progress", paramMessage.getInt("progress"));
          ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
          this.this$0.onRespToClient((Bundle)localObject7);
          return;
        }
        if ("chatbackground_getCurrentId".equals(localObject1))
        {
          localObject6 = paramMessage.getString("friendUin");
          ChatBackgroundManager localChatBackgroundManager;
          if ("none".equals(localObject6))
          {
            paramMessage = null;
            localChatBackgroundManager = (ChatBackgroundManager)((QQAppInterface)localObject8).getManager(61);
            localObject1 = localChatBackgroundManager.c(paramMessage);
            paramMessage = (Message)localObject1;
            if (localObject1 != null)
            {
              paramMessage = (Message)localObject1;
              if (!((String)localObject1).equals("null"))
              {
                paramMessage = (Message)localObject1;
                if (!((String)localObject1).equals("custom"))
                {
                  paramMessage = (Message)localObject1;
                  if (!new File(AppConstants.bD + (String)localObject1 + ".jpg").exists()) {
                    paramMessage = "none";
                  }
                }
              }
            }
            localObject4 = "0";
            localObject5 = ThemeUtil.getUserCurrentThemeId((AppInterface)localObject8);
            localObject1 = localObject5;
            if (((String)localObject5).equals("999"))
            {
              localObject1 = "1000";
              localObject4 = "1";
            }
            if (!paramMessage.equals("null")) {
              break label2817;
            }
            paramMessage = "none";
          }
          label2817:
          for (localObject5 = "none";; localObject5 = localChatBackgroundManager.a(((QQAppInterface)localObject8).getApplication().getApplicationContext(), paramMessage))
          {
            localObject8 = new Bundle();
            ((Bundle)localObject8).putString("result", "0");
            ((Bundle)localObject8).putString("friendUin", (String)localObject6);
            ((Bundle)localObject8).putString("id", paramMessage);
            ((Bundle)localObject8).putString("themeId", (String)localObject1);
            ((Bundle)localObject8).putString("url", (String)localObject5);
            ((Bundle)localObject8).putString("isDIYTheme", (String)localObject4);
            ((Bundle)localObject7).putBundle("response", (Bundle)localObject8);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
            paramMessage = (Message)localObject6;
            break;
          }
        }
        if ("myIndividuationRedInfo".equals(localObject1))
        {
          paramMessage = paramMessage.getString("path");
          if (paramMessage == null) {
            break;
          }
          ((RedTouchManager)((QQAppInterface)localObject8).getManager(35)).b(paramMessage);
          return;
        }
        if (IPCConstants.IPC_CMD_MAP.containsKey(localObject1))
        {
          switch (((Integer)IPCConstants.IPC_CMD_MAP.get(localObject1)).intValue())
          {
          default: 
            return;
          case 1: 
            i = paramMessage.getInt("id");
            ((SVIPHandler)((QQAppInterface)localObject8).a(12)).b(i);
            paramMessage = new Bundle();
            paramMessage.putInt("id", i);
            paramMessage.putInt("result", 0);
            paramMessage.putString("message", "success");
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          case 3: 
            i = paramMessage.getInt("id");
            paramMessage = ((Bundle)localObject7).getString("callbackid");
            localObject1 = (FontManager)MessengerService.access$1000(this.this$0).getManager(41);
            ((FontManager)localObject1).a(this.this$0.mVipIPCDownloadListener);
            ((FontManager)localObject1).a(i, paramMessage);
            return;
          case 2: 
            i = paramMessage.getInt("id");
            paramMessage = ((FontManager)MessengerService.access$1100(this.this$0).getManager(41)).a(i);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("id", i);
            ((Bundle)localObject1).putString("result", paramMessage.toString());
            ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          case 4: 
            i = paramMessage.getInt("id");
            ((FontManager)MessengerService.access$1200(this.this$0).getManager(41)).a(i);
            paramMessage = new Bundle();
            paramMessage.putInt("id", i);
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          case 5: 
            i = paramMessage.getInt("id");
            paramMessage = ((Bundle)localObject7).getString("callbackid");
            localObject1 = (BubbleManager)MessengerService.access$1300(this.this$0).getManager(43);
            ((BubbleManager)localObject1).a(this.this$0.mVipIPCDownloadListener);
            ((BubbleManager)localObject1).c(i, paramMessage);
            return;
          case 7: 
            i = paramMessage.getInt("id");
            paramMessage = ((BubbleManager)MessengerService.access$1400(this.this$0).getManager(43)).c(i);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("id", i);
            ((Bundle)localObject1).putString("result", paramMessage.toString());
            ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          case 6: 
            i = paramMessage.getInt("id");
            paramMessage = ((BubbleManager)MessengerService.access$1500(this.this$0).getManager(43)).a(i);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("id", i);
            ((Bundle)localObject1).putString("result", paramMessage.toString());
            ((Bundle)localObject7).putBundle("response", (Bundle)localObject1);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          i = paramMessage.getInt("action");
          paramMessage = (FontManager)MessengerService.access$1600(this.this$0).getManager(41);
          if (i == 1) {}
          for (bool = true;; bool = false)
          {
            paramMessage.a(bool);
            ((Bundle)localObject7).putBundle("response", new Bundle());
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
        }
        if ("qwalletOpenToken".equals(localObject1))
        {
          paramMessage = ((Bundle)localObject7).getString("appId");
          localObject1 = ((Bundle)localObject7).getString("nonce");
          l1 = ((Bundle)localObject7).getLong("timeStamp");
          localObject4 = ((Bundle)localObject7).getString("sig");
          localObject5 = ((Bundle)localObject7).getString("sigType");
          localObject6 = ((Bundle)localObject7).getString("domain");
          localObject7 = new BaseInfo();
          ((BaseInfo)localObject7).appId = paramMessage;
          ((BaseInfo)localObject7).nonce = ((String)localObject1);
          ((BaseInfo)localObject7).timeStamp = l1;
          ((BaseInfo)localObject7).sig = ((String)localObject4);
          ((BaseInfo)localObject7).sigType = ((String)localObject5);
          ((BaseInfo)localObject7).qVersion = "5.9.3";
          ((BaseInfo)localObject7).phoneModel = Build.MODEL;
          ((BaseInfo)localObject7).phoneOS = "android";
          paramMessage = new ReqGetApiList();
          paramMessage.baseInfo = ((BaseInfo)localObject7);
          paramMessage.domain = ((String)localObject6);
          ((QQAppInterface)localObject8).a(MessengerService.access$1700(this.this$0));
          ((QWalletOpenHandler)((QQAppInterface)localObject8).a(32)).a(paramMessage);
          return;
        }
        if ("qwalletOpenOpenid".equals(localObject1))
        {
          paramMessage = ((Bundle)localObject7).getString("appId");
          localObject1 = ((Bundle)localObject7).getString("nonce");
          l1 = ((Bundle)localObject7).getLong("timeStamp");
          localObject4 = ((Bundle)localObject7).getString("sig");
          localObject6 = ((Bundle)localObject7).getString("sigType");
          localObject5 = new BaseInfo();
          ((BaseInfo)localObject5).appId = paramMessage;
          ((BaseInfo)localObject5).nonce = ((String)localObject1);
          ((BaseInfo)localObject5).timeStamp = l1;
          ((BaseInfo)localObject5).sig = ((String)localObject4);
          ((BaseInfo)localObject5).sigType = ((String)localObject6);
          ((BaseInfo)localObject5).qVersion = "5.9.3";
          ((BaseInfo)localObject5).phoneModel = Build.MODEL;
          ((BaseInfo)localObject5).phoneOS = "android";
          paramMessage = new ReqGetOpenId();
          paramMessage.baseInfo = ((BaseInfo)localObject5);
          ((QQAppInterface)localObject8).a(MessengerService.access$1700(this.this$0));
          ((QWalletOpenHandler)((QQAppInterface)localObject8).a(32)).a(paramMessage);
          return;
        }
        if ("openEquipmentLock".equals(localObject1))
        {
          paramMessage = paramMessage.getByteArray("sppkey");
          EquipLockWebImpl.a().a(paramMessage);
          return;
        }
        if ("createShortcut".equals(localObject1))
        {
          paramMessage = ((Bundle)localObject7).getBundle("request");
          localObject1 = paramMessage.getString("nickname");
          localObject4 = paramMessage.getString("iconurl");
          localObject5 = paramMessage.getString("starhomeurl");
          ThreadManager.a(new MessengerService.IncomingHandler.1(this, (String)localObject4, paramMessage.getString("sid"), (QQAppInterface)localObject8, (String)localObject5, (String)localObject1, (Bundle)localObject7));
          return;
        }
        if ("setHasSetPwd".equals(localObject1))
        {
          PhoneNumLoginImpl.a().a((QQAppInterface)localObject8, ((QQAppInterface)localObject8).a(), true);
          return;
        }
        if ("getA2".equals(localObject1))
        {
          paramMessage = paramMessage.getString("uin");
          localObject1 = (WtloginManager)((QQAppInterface)localObject8).getManager(1);
          if (localObject1 == null) {
            break label7210;
          }
        }
        for (;;)
        {
          try
          {
            paramMessage = HexUtil.a(WtloginHelper.GetTicketSig(((WtloginManager)localObject1).GetLocalSig(paramMessage, 16L), 64));
            localObject1 = paramMessage;
            localException1.printStackTrace();
          }
          catch (Exception localException1)
          {
            try
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.emoji.web.MessengerService", 2, "a2 = " + paramMessage);
                localObject1 = paramMessage;
              }
              paramMessage = new Bundle();
              paramMessage.putString("A2", (String)localObject1);
              ((Bundle)localObject7).putBundle("response", paramMessage);
              this.this$0.onRespToClient((Bundle)localObject7);
              return;
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                Object localObject2;
                long l2;
                int m;
                int n;
                int k;
                Object localObject3;
                continue;
                continue;
                continue;
                i = 1;
              }
            }
            localException1 = localException1;
            paramMessage = "";
          }
          localObject2 = paramMessage;
          continue;
          if ("card_getinfo".equals(localObject2))
          {
            paramMessage = (QQAppInterface)MessengerService.access$1800(this.this$0);
            l1 = 0L;
            l2 = 0L;
            localObject2 = ((FriendsManager)paramMessage.getManager(49)).a(paramMessage.a());
            if (localObject2 != null) {
              if (((Card)localObject2).templateRet != 0)
              {
                l1 = 0L;
                i = -1;
              }
            }
            while (i == -1)
            {
              ((QQAppInterface)localObject8).a(MessengerService.access$1900(this.this$0));
              this.this$0.mOnCardDownloadBundle = ((Bundle)localObject7);
              localObject2 = (CardHandler)paramMessage.a(2);
              l1 = ProfileActivity.a(new ProfileActivity.AllInOne(paramMessage.a(), 0));
              ((CardHandler)localObject2).a(paramMessage.a(), paramMessage.a(), 0, 0L, (byte)1, 0L, 0L, null, "", l1, 10004, null);
              return;
              if ((((Card)localObject2).lCurrentBgId == -1L) || (((Card)localObject2).lCurrentStyleId == -1L))
              {
                i = -1;
              }
              else
              {
                l1 = ((Card)localObject2).lCurrentBgId;
                l2 = ((Card)localObject2).lCurrentStyleId;
                i = 0;
                continue;
                i = -1;
              }
            }
            paramMessage = new Bundle();
            paramMessage.putLong("currentId", l1);
            paramMessage.putLong("styleId", l2);
            paramMessage.putInt("result", i);
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if ("card_setSummaryCard".equals(localObject2))
          {
            ((QQAppInterface)localObject8).a(MessengerService.access$1900(this.this$0));
            MessengerService.access$2002(this.this$0, (Bundle)localObject7);
            i = ((Bundle)localObject7).getInt("styleId");
            j = ((Bundle)localObject7).getInt("bgId");
            ProfileCardUtil.a((QQAppInterface)localObject8, i, j);
            return;
          }
          if ("getRoam".equals(localObject2))
          {
            i = 0;
            localObject2 = "success";
            localObject4 = ((QQAppInterface)localObject8).getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
            m = ((SharedPreferences)localObject4).getInt("message_roam_flag" + ((QQAppInterface)localObject8).a(), -1);
            paramMessage = (Message)localObject2;
            j = i;
            if (m != 1)
            {
              paramMessage = (Message)localObject2;
              j = i;
              if (m != 2)
              {
                paramMessage = (Message)localObject2;
                j = i;
                if (m != 3)
                {
                  paramMessage = (Message)localObject2;
                  j = i;
                  if (m != 4)
                  {
                    j = -1;
                    paramMessage = "messageRoamType is error , = " + m;
                    MessengerService.access$2100(this.this$0, paramMessage);
                  }
                }
              }
            }
            n = ((SharedPreferences)localObject4).getInt("message_roam_is_set_password" + ((QQAppInterface)localObject8).a(), -1);
            localObject2 = paramMessage;
            i = j;
            if (n != 1)
            {
              localObject2 = paramMessage;
              i = j;
              if (n != 0)
              {
                i = -1;
                localObject2 = "isSetPassWord is error , = " + n;
                MessengerService.access$2100(this.this$0, (String)localObject2);
              }
            }
            k = VipUtils.a((QQAppInterface)localObject8, null);
            j = k;
            if (k == -1)
            {
              j = -1;
              i = -1;
              localObject2 = "user type is error , = " + -1;
              MessengerService.access$2100(this.this$0, (String)localObject2);
            }
            paramMessage = new Bundle();
            paramMessage.putInt("type", m);
            paramMessage.putInt("userType", j);
            paramMessage.putInt("isSetPassword", n);
            paramMessage.putInt("result", i);
            paramMessage.putString("errorMessage", (String)localObject2);
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if ("notifyGetMsgRoam".equals(localObject2))
          {
            paramMessage = paramMessage.getString("pwd");
            ((MessageRoamManager)MessengerService.access$2200(this.this$0).getManager(86)).c(paramMessage);
            return;
          }
          if ("card_getVipInfo".equals(localObject2))
          {
            paramMessage = new Bundle();
            paramMessage.putString("vip_info", VipUtils.a((AppInterface)localObject8, ((QQAppInterface)localObject8).a()));
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if ("openEmojiMall".equals(localObject2))
          {
            paramMessage = new Bundle();
            i = ((QQAppInterface)MessengerService.access$2300(this.this$0)).a().a();
            localObject2 = ((QQAppInterface)MessengerService.access$2400(this.this$0)).a().a();
            paramMessage.putInt("curChatType", i);
            paramMessage.putString("curChatUin", (String)localObject2);
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if ("openEmojiDetail".equals(localObject2))
          {
            paramMessage = new Bundle();
            i = ((QQAppInterface)MessengerService.access$2500(this.this$0)).a().a();
            localObject2 = ((QQAppInterface)MessengerService.access$2600(this.this$0)).a().a();
            paramMessage.putInt("curChatType", i);
            paramMessage.putString("curChatUin", (String)localObject2);
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if ("openProfileCard".equals(localObject2))
          {
            paramMessage = new Bundle();
            j = 1;
            localObject2 = (RedTouchManager)MessengerService.access$2700(this.this$0).getManager(35);
            i = j;
            if (localObject2 != null) {}
            try
            {
              localObject2 = ((RedTouchManager)localObject2).a("100005.100012");
              if (localObject2 == null) {
                break label7205;
              }
              i = ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get();
              if (1 != i) {
                break label7205;
              }
              i = 0;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                localException2.printStackTrace();
                i = j;
              }
            }
            paramMessage.putInt("isCache", i);
            ((Bundle)localObject7).putBundle("response", paramMessage);
            this.this$0.onRespToClient((Bundle)localObject7);
          }
          else
          {
            if ("openFontSetting".equals(localException2))
            {
              bool = ((FontManager)MessengerService.access$2800(this.this$0).getManager(41)).a();
              paramMessage = new Bundle();
              paramMessage.putBoolean("feature", bool);
              ((Bundle)localObject7).putBundle("response", paramMessage);
              this.this$0.onRespToClient((Bundle)localObject7);
              return;
            }
            if ("startDownloadColorRing".equals(localException2))
            {
              l1 = paramMessage.getLong("id");
              i = paramMessage.getInt("resourceType");
              paramMessage = paramMessage.getString("colorType");
              localObject3 = (ColorRingManager)MessengerService.access$2900(this.this$0).getManager(44);
              ((ColorRingManager)localObject3).a(Long.valueOf(l1).longValue(), i, true, 5, paramMessage);
              ((ColorRingManager)localObject3).a(this.this$0.mVipIPCDownloadListener);
              return;
            }
            if ("colorRingSetup".equals(localObject3))
            {
              localObject4 = Long.valueOf(paramMessage.getLong("id"));
              localObject5 = paramMessage.getString("colorType");
              localObject6 = ((QQAppInterface)localObject8).getAccount();
              localObject7 = (FriendsManagerImp)((QQAppInterface)localObject8).getManager(8);
              localObject3 = ((FriendsManagerImp)localObject7).a((String)localObject6);
              paramMessage = (Message)localObject3;
              if (localObject3 == null)
              {
                paramMessage = new ExtensionInfo();
                paramMessage.uin = ((String)localObject6);
              }
              if (((String)localObject5).equals("colorring")) {
                paramMessage.colorRingId = ((Long)localObject4).longValue();
              }
              for (;;)
              {
                ((FriendsManagerImp)localObject7).a(paramMessage);
                return;
                if (((String)localObject5).equals("comering")) {
                  paramMessage.commingRingId = ((Long)localObject4).longValue();
                }
              }
            }
            if ("stopDownloadColorRing".equals(localObject3))
            {
              l1 = paramMessage.getLong("id");
              i = paramMessage.getInt("resourceType");
              paramMessage = (ColorRingManager)MessengerService.access$3000(this.this$0).getManager(44);
              paramMessage.a(Long.valueOf(l1).longValue(), i);
              paramMessage.a(this.this$0.mVipIPCDownloadListener);
              return;
            }
            if ("reportColorRing".equals(localObject3))
            {
              localObject3 = paramMessage.getString("subAction");
              localObject4 = paramMessage.getString("actionName");
              j = paramMessage.getInt("result");
              i = ((SVIPHandler)((QQAppInterface)localObject8).a(12)).f();
              if (i == 2) {}
              for (i = 0;; i = 2)
              {
                ReportController.b((QQAppInterface)localObject8, "CliOper", "", "", (String)localObject3, (String)localObject4, 0, j, "" + i, "", "", "");
                return;
                if (i != 3) {
                  break;
                }
              }
            }
            if ("puzzle_verify_code_setTicket".equals(localObject3))
            {
              i = paramMessage.getInt("seq");
              paramMessage = paramMessage.getString("ticket");
              localObject3 = (VerifyCodeManager)((QQAppInterface)localObject8).getManager(6);
              if (localObject3 == null) {
                break;
              }
              ((VerifyCodeManager)localObject3).submitPuzzleVerifyCodeTicket(i, paramMessage);
              return;
            }
            if ("puzzle_verify_code_clearProgressDialog".equals(localObject3))
            {
              paramMessage = ((QQAppInterface)localObject8).a(LoginActivity.class);
              if (paramMessage != null) {
                paramMessage.sendEmptyMessage(20140107);
              }
              paramMessage = ((QQAppInterface)localObject8).a(SubLoginActivity.class);
              if (paramMessage != null) {
                paramMessage.sendEmptyMessage(20140107);
              }
              paramMessage = ((QQAppInterface)localObject8).a(Login.class);
              if (paramMessage == null) {
                break;
              }
              paramMessage.sendEmptyMessage(7);
              return;
            }
            if ("close_version".equals(localObject3))
            {
              i = -1;
              paramMessage = ((Bundle)localObject7).getBundle("request");
              if (paramMessage != null)
              {
                l1 = paramMessage.getLong("version", 0L);
                paramMessage = (VipGiftManager)MessengerService.access$3100(this.this$0).getManager(72);
                if ((paramMessage == null) || (!paramMessage.a(l1))) {
                  break label5847;
                }
                paramMessage.a("0X8004B41", "3", "0", null);
              }
              label5847:
              for (i = 0;; i = -1)
              {
                paramMessage = new Bundle();
                paramMessage.putInt("result", i);
                ((Bundle)localObject7).putBundle("response", paramMessage);
                this.this$0.onRespToClient((Bundle)localObject7);
                return;
              }
            }
            if ("close_annimate".equals(localObject3))
            {
              paramMessage = ((Bundle)localObject7).getBundle("request");
              if (paramMessage == null) {
                break;
              }
              l1 = paramMessage.getLong("Gif_msg_uniseq_key", 0L);
              if (l1 == 0L) {
                break;
              }
              paramMessage = (VipGiftManager)MessengerService.access$3200(this.this$0).getManager(72);
              localObject3 = paramMessage.a();
              if ((localObject3 == null) || (((VipGiftDownloadInfo)localObject3).d != 3L)) {
                break;
              }
              paramMessage.a(4L, l1);
              return;
            }
            if ("special_care_set_ring".equals(localObject3))
            {
              paramMessage = ((Bundle)localObject7).getBundle("request");
              localObject4 = new Bundle();
              if (paramMessage == null) {
                break;
              }
              MessengerService.access$3400(this.this$0).sendRequest((QQAppInterface)MessengerService.access$3300(this.this$0), (String)localObject3, (Bundle)localObject7, (Bundle)localObject4);
              return;
            }
            if ("special_care_get_ring".equals(localObject3))
            {
              paramMessage = ((Bundle)localObject7).getBundle("request");
              if (paramMessage == null) {
                break;
              }
              i = QvipSpecialCareManager.a(paramMessage.getString("uin"), (QQAppInterface)MessengerService.access$3500(this.this$0));
              paramMessage = new Bundle();
              paramMessage.putInt("id", i);
              ((Bundle)localObject7).putBundle("response", paramMessage);
              this.this$0.onRespToClient((Bundle)localObject7);
              return;
            }
            if ("special_care_get_friend_count".equals(localObject3))
            {
              paramMessage = new Bundle();
              paramMessage.putInt("count", QvipSpecialCareManager.c((QQAppInterface)MessengerService.access$3600(this.this$0)));
              ((Bundle)localObject7).putBundle("response", paramMessage);
              this.this$0.onRespToClient((Bundle)localObject7);
              return;
            }
            if ("sepcial_care_delete_ring".equals(localObject3))
            {
              paramMessage = new Bundle();
              MessengerService.access$3400(this.this$0).sendRequest((QQAppInterface)MessengerService.access$3700(this.this$0), (String)localObject3, (Bundle)localObject7, paramMessage);
              return;
            }
            if ("special_care_get_switch_state".equals(localObject3))
            {
              paramMessage = new Bundle();
              j = RoamSettingController.a((QQAppInterface)MessengerService.access$3800(this.this$0));
              i = j;
              if (j == 0)
              {
                i = ((QQAppInterface)MessengerService.access$3900(this.this$0)).d();
                MessengerService.access$2100(this.this$0, "-->state follow,all sound switch state:" + i);
                if (i != 0) {
                  break label6291;
                }
              }
              label6291:
              for (i = 0;; i = 1)
              {
                paramMessage.putInt("state", i);
                ((Bundle)localObject7).putBundle("response", paramMessage);
                this.this$0.onRespToClient((Bundle)localObject7);
                return;
              }
            }
            if ("is_special_friend".equals(localObject3))
            {
              localObject3 = new Bundle();
              paramMessage = ((Bundle)localObject7).getBundle("request");
              if (paramMessage == null) {
                break;
              }
              paramMessage = paramMessage.getString("friendUin");
              if (paramMessage != null) {
                break label7199;
              }
              paramMessage = "";
              if (QvipSpecialCareManager.a(((QQAppInterface)MessengerService.access$4000(this.this$0)).a() + paramMessage)) {
                ((Bundle)localObject3).putInt("isSpecialFriend", 1);
              }
              for (;;)
              {
                ((Bundle)localObject7).putBundle("response", (Bundle)localObject3);
                this.this$0.onRespToClient((Bundle)localObject7);
                return;
                ((Bundle)localObject3).putInt("isSpecialFriend", 0);
              }
            }
            if ("getDomainIpList".equals(localObject3))
            {
              localObject3 = FMTSrvAddrProvider.a().a(15);
              paramMessage = new JSONArray();
              if (localObject3 == null) {}
            }
          }
          try
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              paramMessage.put(((FileStorageServerListInfo)((Iterator)localObject3).next()).sIP);
            }
            localObject3 = new Bundle();
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("result", 0);
            ((JSONObject)localObject4).put("message", "ok");
            ((JSONObject)localObject4).put("ips", paramMessage);
            ((Bundle)localObject3).putString("result", ((JSONObject)localObject4).toString());
            ((Bundle)localObject7).putBundle("response", (Bundle)localObject3);
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          catch (JSONException paramMessage) {}
          if (("selectPhoto".equals(localObject3)) || ("takePhoto".equals(localObject3)))
          {
            MessengerService.access$4100(this.this$0, (String)localObject3);
            ((Bundle)localObject7).putBundle("response", new Bundle());
            this.this$0.onRespToClient((Bundle)localObject7);
            return;
          }
          if ("funcall_download".equals(localObject3))
          {
            i = paramMessage.getInt("id");
            j = VipFunCallManager.a();
            paramMessage = (VipFunCallManager)MessengerService.access$4200(this.this$0).getManager(79);
            paramMessage.a(i, j, true, 6);
            paramMessage.a(this.this$0.mVipIPCDownloadListener);
            return;
          }
          if ("funcall_set".equals(localObject3))
          {
            i = paramMessage.getInt("id");
            ((Bundle)localObject7).getString("callbackid");
            j = ((VipFunCallManager)MessengerService.access$4300(this.this$0).getManager(79)).a(i);
            if (j != 0)
            {
              paramMessage = new Bundle();
              paramMessage.putInt("isSuccess", j);
              paramMessage.putInt("srcType", 7);
              if (this.this$0.mClient == null) {
                break;
              }
              localObject3 = Message.obtain(null, 5);
              ((Message)localObject3).setData(paramMessage);
              try
              {
                this.this$0.mClient.send((Message)localObject3);
                return;
              }
              catch (RemoteException paramMessage) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.emoji.web.MessengerService", 2, paramMessage.getMessage());
              return;
            }
            paramMessage = (VipSetFunCallHandler)((QQAppInterface)localObject8).a(48);
            ((QQAppInterface)localObject8).a(this.this$0.fcObserver);
            paramMessage.a(i, ((QQAppInterface)localObject8).a());
            return;
          }
          if ("QQVIPFunction".equals(localObject3))
          {
            VipUtils.a((QQAppInterface)localObject8, paramMessage.getString("businessFlag"), paramMessage.getString("actionType"), paramMessage.getString("actionName"), paramMessage.getInt("entry"), paramMessage.getInt("result"), paramMessage.getStringArray("reserves"));
            return;
          }
          if ("leba_item_set".equals(localObject3))
          {
            i = paramMessage.getInt("path");
            if (paramMessage.getInt("type") == 1) {}
            for (bool = true;; bool = false)
            {
              l1 = NetConnInfoCenter.getServerTimeMillis();
              LebaShowListManager.a().a((QQAppInterface)localObject8, i, bool, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
              paramMessage = (RedTouchHandler)((QQAppInterface)localObject8).a(33);
              if (paramMessage != null)
              {
                paramMessage.a(String.valueOf(i), bool, l1);
                paramMessage.a(1, true, null);
              }
              LebaShowListManager.d |= 0x4;
              paramMessage = new Bundle();
              paramMessage.putInt("ret", 0);
              ((Bundle)localObject7).putBundle("response", paramMessage);
              this.this$0.onRespToClient((Bundle)localObject7);
              return;
            }
          }
          if ("leba_item_get".equals(localObject3))
          {
            ThreadManager.b(new MessengerService.IncomingHandler.2(this, (QQAppInterface)localObject8, paramMessage.getInt("path"), (Bundle)localObject7));
            return;
          }
          if (!"QQVIPFunctionReport643".equals(localObject3)) {
            break;
          }
          paramMessage.getString("tag");
          localObject3 = paramMessage.getString("mainAction");
          localObject4 = paramMessage.getString("toUin");
          localObject5 = paramMessage.getString("subAction");
          localObject6 = paramMessage.getString("actionName");
          i = paramMessage.getInt("fromeType");
          j = paramMessage.getInt("result");
          paramMessage = paramMessage.getStringArray("reserves");
          ReportController.b((QQAppInterface)MessengerService.access$4400(this.this$0), "CliOper", (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, i, j, paramMessage[0], paramMessage[1], paramMessage[2], paramMessage[3]);
          return;
          label7199:
          label7205:
          label7210:
          String str = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */