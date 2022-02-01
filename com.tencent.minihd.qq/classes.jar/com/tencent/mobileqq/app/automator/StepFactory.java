package com.tencent.mobileqq.app.automator;

import android.text.TextUtils;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.AfterSyncMsg;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo;
import com.tencent.mobileqq.app.automator.step.CheckMsgCount;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.mobileqq.app.automator.step.CheckUpgrade;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.app.automator.step.GetCheckUpdate;
import com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.app.automator.step.GetDatingUnreadCountStep;
import com.tencent.mobileqq.app.automator.step.GetDiscussionInfo;
import com.tencent.mobileqq.app.automator.step.GetEmosmList;
import com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListMessageStep;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.app.automator.step.GetSecMsgConfigs;
import com.tencent.mobileqq.app.automator.step.GetSecMsgNewSeq;
import com.tencent.mobileqq.app.automator.step.GetSelfInfo;
import com.tencent.mobileqq.app.automator.step.GetSelfPendantId;
import com.tencent.mobileqq.app.automator.step.GetSig;
import com.tencent.mobileqq.app.automator.step.GetSpecialCareRecommend;
import com.tencent.mobileqq.app.automator.step.GetSpecialSoundConfig;
import com.tencent.mobileqq.app.automator.step.GetSplashConfig;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg;
import com.tencent.mobileqq.app.automator.step.GetTroopRedPointInfoStep;
import com.tencent.mobileqq.app.automator.step.GetWebViewAuthorize;
import com.tencent.mobileqq.app.automator.step.MigrateDataToRecentCall;
import com.tencent.mobileqq.app.automator.step.MonitorSocketDownload;
import com.tencent.mobileqq.app.automator.step.PPCLoginAuth;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.app.automator.step.RegisterPush;
import com.tencent.mobileqq.app.automator.step.ReportQQWifiInfo;
import com.tencent.mobileqq.app.automator.step.SendThemeAuth;
import com.tencent.mobileqq.app.automator.step.SetLogOn;
import com.tencent.mobileqq.app.automator.step.SignatureScan;
import com.tencent.mobileqq.app.automator.step.StartSecurityScan;
import com.tencent.mobileqq.app.automator.step.StartSecurityUpdate;
import com.tencent.mobileqq.app.automator.step.StartSmartDevice;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateIcon;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.app.automator.step.VideoConfigUpdate;
import com.tencent.mobileqq.app.automator.step.VipCheckGift;
import com.tencent.mobileqq.app.automator.step.WeiyunCheckAlbum;

public class StepFactory
{
  public static final int A = 28;
  public static final int B = 29;
  public static final int C = 30;
  public static final int D = 31;
  public static final int E = 32;
  public static final int F = 33;
  public static final int G = 34;
  public static final int H = 35;
  public static final int I = 36;
  public static final int J = 37;
  public static final int K = 38;
  public static final int L = 39;
  public static final int M = 40;
  public static final int N = 41;
  public static final int O = 42;
  public static final int P = 43;
  public static final int Q = 44;
  public static final int R = 45;
  public static final int S = 46;
  public static final int T = 47;
  public static final int U = 48;
  public static final int V = 49;
  public static final int W = 50;
  public static final int X = 51;
  public static final int Y = 52;
  public static final int Z = 53;
  public static final int a = 2;
  public static final String a = "[";
  public static final int[] a;
  public static final String[] a;
  public static final int aa = 54;
  public static final int ab = 55;
  public static final int ac = 56;
  public static final int ad = 57;
  public static final int ae = 58;
  public static final int af = 59;
  public static final int ag = 60;
  public static final int ah = 61;
  public static final int ai = 62;
  public static final int aj = 63;
  public static final int ak = 64;
  public static final int al = 65;
  public static final int am = 66;
  public static final int an = 67;
  public static final int ao = 68;
  public static final int ap = 69;
  public static final int aq = 70;
  private static final int ar = 1;
  public static final int b = 3;
  public static final String b = "]";
  private static final String[] b = { "", "UPGRADE_ACCOUNT", "INIT_AUTOMATOR", "INIT_FRIEND_CACHE", "INIT_TROOP_CACHE", "INIT_DISCUSS_CACHE", "INIT_PUBLIC_CACHE", "UPDATE_FRIEND_LIST", "UPDATE_FRIEND_GATH", "UPDATE_TROOP", "UPDATE_PUBLIC", "STEP_GET_SUBACCOUNT", "REGISTER_PUSH_LOGIN", "REGISTER_PUSH_RECONN", "INIT_BEFORE_SYNC_MSG_LOGIN", "INIT_BEFORE_SYNC_MSG_PULL", "INIT_BEFORE_SYNC_MSG_CONN", "REGISTER_PROXY_LOGIN", "REGISTER_PROXY_PULL", "REGISTER_PROXY_CONN", "GENERAL_SETTING", "NUMBER_TROOP_MSG", "AFTER_LOAD_LOGIN", "AFTER_LOAD_RECONN", "AFTER_LOAD_REFRESH", "RECENT_CALL_MIGRATION", "GET_EMOTICON", "GET_EMOTICON_WHEN_NO_FILE", "GET_SELF_AVATAR_PENDANT_ID", "SECUTRITY_SCAN", "GET_EMOSMLIST", "GET_SELFINFO", "GET_SECMSG_CFG", "FRIENDS_LAST_LOGIN_INFO", "GET_SIG", "SEC_SINGLE_UPDATE", "GET_WEBVIEW_AUTHORIZE", "GET_DISCUSSIONINFO", "SET_LOGON", "GET_QZONEUNREAD", "GET_CONFIG", "GET_CHECKUPDATE_LOGIN", "GET_CHECKUPDATE_RECONN", "GET_SPLASH", "SEND_THEMEAUTH", "GET_SPECIAL_CARE_CONFIG", "CHECKUPGRADE", "CLEAN_CACHE", "CHECK_MSG_COUNT", "SIGNATURE_SCAN", "GET_CLUBCONTENTUPDATESTATUS", "VIDEO_CONFIG_UPDATE", "TIMER_CHECK_UPDATE", "GET_JOINED_HOTCHAT_LIT", "STEP_FORCE_GET_JOINED_HOT_CHAT_LIST", "GET_HOTCHAT_MESSAGE", "GET_CHATBACKGROUNDYPDATESTATUS", "GET_TROOP_REDPOINT_INFO", "QQWIFI_REPORT", "STEP_CHECK_VIP_GIFT", "STEP_UPDATE_SHORTCUT_ICON", "GET_UNIPAY", "REPORT_DEVICE", "START_SMARTDEVICE_FORNEEDED", "WEIYUN_CHECKALBUM", "CHATBG_VIP_AUTH", "PPC_LOGIN_AUTH", "GET_RECOMMEND_FRIENDS", "TIMER_CHECK_MSG_COUNT", "STEP_MONITORSOCKET_CHECK", "STEP_GET_QZONE_FEEDS", "AUTOMATOR_FINISH" };
  public static final int c = 4;
  public static final String c = "{";
  public static final int d = 5;
  public static final String d = "}";
  public static final int e = 6;
  public static final String e = "{15,18,21,53,55,24}";
  public static final int f = 7;
  public static final String f = "{[13,16],19,21,53,55,23,42,32,56,57}";
  public static final int g = 8;
  public static final String g = "{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}";
  public static final int h = 9;
  public static final String h = "{[11,12,14],17,20,21,22}";
  public static final int i = 10;
  public static final String i = "{{4,3,5,6},40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52}";
  public static final int j = 11;
  private static final String j = "[]";
  public static final int k = 12;
  private static final String k = "[]";
  public static final int l = 13;
  private static final String l = "[51,35,47,61,63,58,68,67]";
  public static final int m = 14;
  private static final String m = "[]";
  public static final int n = 15;
  private static final String n = "{4,3,5,6}";
  public static final int o = 16;
  private static final String o = "[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62]";
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 20;
  public static final int t = 21;
  public static final int u = 22;
  public static final int v = 23;
  public static final int w = 24;
  public static final int x = 25;
  public static final int y = 26;
  public static final int z = 27;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 6, 12, 24, 168 };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "[]", "[]", "[51,35,47,61,63,58,68,67]", "[]" };
  }
  
  public static int a(LinearGroup paramLinearGroup)
  {
    int i2 = 0;
    int i1 = i2;
    if ("{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}".equals(paramLinearGroup.b))
    {
      i1 = i2;
      if (paramLinearGroup.j > 3) {
        i1 = 1;
      }
    }
    return i1;
  }
  
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (TextUtils.isEmpty(str)) {
      throw new RuntimeException("createStepGroup: " + str);
    }
    int i1 = -1;
    if (str.startsWith("{"))
    {
      paramString = new LinearGroup();
      paramString.c = str;
    }
    for (;;)
    {
      paramString.a = paramAutomator;
      paramString.h = i1;
      if ((i1 < 0) || (i1 >= b.length)) {
        break;
      }
      paramString.b = b[i1];
      return paramString;
      if (str.startsWith("["))
      {
        paramString = new ParallGroup();
        paramString.c = str;
      }
      else
      {
        i1 = Integer.parseInt(str);
        switch (i1)
        {
        default: 
          paramString = new AsyncStep();
          break;
        case 2: 
          paramString = new ActiveAccount();
          break;
        case 3: 
        case 7: 
        case 8: 
          paramString = new UpdateFriend();
          break;
        case 4: 
        case 9: 
          paramString = new UpdateTroop();
          break;
        case 5: 
          paramString = new UpdateDiscuss();
          break;
        case 6: 
        case 10: 
          paramString = new CheckPublicAccount();
          break;
        case 12: 
        case 13: 
          paramString = new RegisterPush();
          break;
        case 17: 
        case 18: 
        case 19: 
          paramString = new RegisterProxy();
          break;
        case 20: 
          paramString = new GetGeneralSettings();
          break;
        case 21: 
          paramString = new GetTroopAssisMsg();
          break;
        case 14: 
        case 15: 
        case 16: 
          paramString = new InitBeforeSyncMsg();
          break;
        case 11: 
          paramString = new GetSubAccount();
          break;
        case 22: 
        case 23: 
        case 24: 
          paramString = new AfterSyncMsg();
          break;
        case 25: 
          paramString = new MigrateDataToRecentCall();
          break;
        case 26: 
          paramString = new GetEmoticonWhenNoFile();
          break;
        case 27: 
          paramString = new GetSelfPendantId();
          break;
        case 28: 
          paramString = new StartSecurityScan();
          break;
        case 29: 
          paramString = new GetEmosmList();
          break;
        case 30: 
          paramString = new GetSelfInfo();
          break;
        case 31: 
          paramString = new GetSecMsgConfigs();
          break;
        case 32: 
          paramString = new GetSecMsgNewSeq();
          break;
        case 33: 
          paramString = new CheckFriendsLastLoginInfo();
          break;
        case 34: 
          paramString = new GetSig();
          break;
        case 35: 
          paramString = new StartSecurityUpdate();
          break;
        case 36: 
          paramString = new GetWebViewAuthorize();
          break;
        case 37: 
          paramString = new GetDiscussionInfo();
          break;
        case 38: 
          paramString = new SetLogOn();
          break;
        case 39: 
          paramString = new GetQZoneFeedCount();
          break;
        case 40: 
          paramString = new GetConfig();
          break;
        case 41: 
        case 42: 
          paramString = new GetCheckUpdate();
          break;
        case 43: 
          paramString = new GetSplashConfig();
          break;
        case 44: 
          paramString = new SendThemeAuth();
          break;
        case 45: 
          paramString = new GetSpecialSoundConfig();
          break;
        case 46: 
          paramString = new CheckUpgrade();
          break;
        case 47: 
          paramString = new CleanCache();
          break;
        case 48: 
          paramString = new CheckMsgCount();
          break;
        case 67: 
          paramString = new TimerCheckMsgCount();
          break;
        case 50: 
          paramString = new GetClubContentUpdateStatus();
          break;
        case 51: 
          paramString = new VideoConfigUpdate();
          break;
        case 52: 
          paramString = new TimerChecker();
          break;
        case 70: 
          paramString = new AutomatorFinish();
          break;
        case 49: 
          paramString = new SignatureScan();
          break;
        case 53: 
        case 54: 
          paramString = new GetJoinedHotChatListStep();
          break;
        case 55: 
          paramString = new GetJoinedHotChatListMessageStep();
          break;
        case 56: 
          paramString = new GetDatingUnreadCountStep();
          break;
        case 57: 
          paramString = new GetTroopRedPointInfoStep();
          break;
        case 60: 
          paramString = new UpdateIcon();
          break;
        case 58: 
          paramString = new ReportQQWifiInfo();
          break;
        case 59: 
          paramString = new VipCheckGift();
          break;
        case 61: 
          paramString = new ReportDevice();
          break;
        case 62: 
          paramString = new StartSmartDevice();
          break;
        case 63: 
          paramString = new WeiyunCheckAlbum();
          break;
        case 64: 
          paramString = new ChatBackgroundAuth();
          break;
        case 65: 
          paramString = new GetSpecialCareRecommend();
          break;
        case 66: 
          paramString = new PPCLoginAuth();
          break;
        case 68: 
          paramString = new MonitorSocketDownload();
          break;
        case 69: 
          paramString = new GetQZoneFeeds();
        }
      }
    }
    paramString.b = str;
    return paramString;
  }
  
  public static boolean a(LinearGroup paramLinearGroup)
  {
    if ("{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}".equals(paramLinearGroup.b)) {
      if (paramLinearGroup.j < 2) {}
    }
    do
    {
      do
      {
        return true;
        return false;
        if (!"{[13,16],19,21,53,55,23,42,32,56,57}".equals(paramLinearGroup.b)) {
          break;
        }
      } while (paramLinearGroup.j >= 1);
      return false;
    } while (("{15,18,21,53,55,24}".equals(paramLinearGroup.b)) || (!"{[11,12,14],17,20,21,22}".equals(paramLinearGroup.b)) || (paramLinearGroup.j >= 2));
    return false;
  }
  
  public static boolean b(LinearGroup paramLinearGroup)
  {
    return (!"{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}".equals(paramLinearGroup.b)) || (paramLinearGroup.j > 4);
  }
  
  public static boolean c(LinearGroup paramLinearGroup)
  {
    if ("{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}".equals(paramLinearGroup.b)) {
      if (paramLinearGroup.j <= 3) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (!"{[13,16],19,21,53,55,23,42,32,56,57}".equals(paramLinearGroup.b)) {
            break;
          }
        } while (paramLinearGroup.j > 2);
        return false;
        if (!"{15,18,21,53,55,24}".equals(paramLinearGroup.b)) {
          break;
        }
      } while (paramLinearGroup.j > 2);
      return false;
    } while ((!"{[11,12,14],17,20,21,22}".equals(paramLinearGroup.b)) || (paramLinearGroup.j > 2));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.StepFactory
 * JD-Core Version:    0.7.0.1
 */