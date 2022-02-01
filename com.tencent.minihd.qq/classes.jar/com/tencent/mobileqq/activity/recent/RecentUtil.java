package com.tencent.mobileqq.activity.recent;

import MessageSvcPack.UinPairReadInfo;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantActivity;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.FowardIntent;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import cooperation.secmsg.SecMsgHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RecentUtil
{
  public static final int a = 0;
  public static boolean a = false;
  public static final int b = 1;
  public static boolean b = false;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean)
  {
    return a(paramActivity, paramQQAppInterface, paramRecentUser, paramString, paramBoolean, 0);
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt)
  {
    int m = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      i = k;
      if (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
        i = k;
      }
      return i;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.type + "]");
    }
    boolean bool = false;
    if (((paramRecentUser.uin != null) && (paramRecentUser.uin.length() == 4)) || (AppConstants.ag.equals(paramRecentUser.uin))) {
      bool = a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt);
    }
    paramInt = m;
    if (!bool)
    {
      if (paramRecentUser.type == 8999) {
        paramInt = m;
      }
    }
    else
    {
      label207:
      if (paramRecentUser.msgType != 3) {
        break label814;
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
      return paramInt;
    }
    if (paramRecentUser.type == 7000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentUtil.onRecentUserClick. r.uin=" + paramRecentUser.uin + " r.type=" + paramRecentUser.type);
      }
      SubAccountAssistantForward.a(paramQQAppInterface, paramActivity, paramRecentUser.uin);
      paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
      if (AppConstants.W.equals(paramRecentUser.uin)) {}
      for (paramActivity = null;; paramActivity = paramRecentUser.uin)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
        paramInt = m;
        break;
      }
    }
    if ((paramRecentUser.type == 1000) || (paramRecentUser.type == 1020) || (paramRecentUser.type == 1004)) {
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramRecentUser.type = 0;
        if (!paramBoolean) {
          break label855;
        }
      }
    }
    label814:
    label855:
    for (paramInt = 2;; paramInt = 0)
    {
      i = paramInt | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString, false);
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break label207;
      }
      QLog.i("Q.recent", 2, "from_enterchat");
      paramInt = i;
      break label207;
      if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
      {
        RecentUser localRecentUser = paramQQAppInterface.a().a().b(paramRecentUser.uin, 1);
        if (localRecentUser != null) {
          paramRecentUser.troopUin = localRecentUser.troopUin;
        }
      }
      a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.type, paramString);
      paramInt = m;
      break label207;
      if ((paramRecentUser.type == 1005) || (paramRecentUser.type == 1023))
      {
        paramInt = i;
        if (a(paramQQAppInterface, paramRecentUser.uin))
        {
          paramRecentUser.type = 0;
          paramInt = i;
          if (paramBoolean) {
            paramInt = 2;
          }
        }
        paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, false);
        break label207;
      }
      if (paramRecentUser.type == 1024)
      {
        paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, false);
        break label207;
      }
      if (paramRecentUser.type == 6002)
      {
        paramString = (SmartDeviceProxyMgr)paramQQAppInterface.a(53);
        paramString.a(paramActivity, paramString.a(Long.parseLong(paramRecentUser.uin)));
        paramInt = m;
        break label207;
      }
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramInt = j;
        if (1 != paramRecentUser.type)
        {
          paramInt = j;
          if (3000 != paramRecentUser.type)
          {
            paramInt = j;
            if (paramRecentUser.type != 0)
            {
              paramRecentUser.type = 0;
              paramInt = j;
              if (paramBoolean) {
                paramInt = 2;
              }
            }
          }
        }
        paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, false);
        break label207;
      }
      paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, false);
      break label207;
      i = paramInt;
      if (paramRecentUser.msgType != 4) {
        break;
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
      return paramInt;
    }
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    StartupTracker.a(null, "Recent_clk_enterchat");
    Object localObject1;
    int i;
    if ((paramActivity instanceof QQLSActivity))
    {
      localObject1 = new FowardIntent(paramActivity, null, ChatActivity.class);
      if (paramActivity.getParent() != null) {
        ((Intent)localObject1).addFlags(67108864);
      }
      if ((paramActivity instanceof QQLSActivity)) {
        ((Intent)localObject1).addFlags(335544320);
      }
      if (paramInt != 3000) {
        break label138;
      }
      i = 0;
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("uin", paramString1);
      ((Intent)localObject1).putExtra("uintype", paramInt);
      ((Intent)localObject1).putExtra("uinname", paramString2);
      ((Intent)localObject1).putExtra("entrance", 1);
      a((Intent)localObject1);
      paramActivity.startActivity((Intent)localObject1);
      StartupTracker.a("Recent_clk_enterchat", null);
      return i;
      localObject1 = new Intent(paramActivity, ChatActivity.class);
      break;
      label138:
      if ((paramInt == 0) || (paramInt == 1024))
      {
        if ((paramInt == 1024) || (CrmUtils.c(paramQQAppInterface, paramString1)))
        {
          StartupTracker.a(null, "Recent_clk_enterchat_cmr");
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          ((Intent)localObject1).setClass(paramActivity, ChatActivity.class);
          StartupTracker.a("Recent_clk_enterchat_cmr", null);
          i = 0;
        }
      }
      else
      {
        Object localObject2;
        if (paramInt == 1)
        {
          StartupTracker.a(null, "Recent_clk_enterchat_troop");
          localObject2 = ((HotChatManager)paramQQAppInterface.getManager(58)).a(paramString1);
          if (localObject2 != null)
          {
            ((Intent)localObject1).putExtra("troop_uin", ((HotChatInfo)localObject2).troopCode);
            i = 1;
            StartupTracker.a("Recent_clk_enterchat_troop", null);
            continue;
          }
          localObject2 = (FriendManager)paramQQAppInterface.getManager(8);
          if (localObject2 != null)
          {
            if (!((FriendManager)localObject2).f(paramString1)) {
              break label387;
            }
            localObject2 = ((FriendManager)localObject2).a(paramString1);
            if (localObject2 != null) {
              ((Intent)localObject1).putExtra("troop_uin", ((OpenTroopInfo)localObject2).troopUin);
            }
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "Open_group", "Clk_open_group", 22, 0, paramString1, "", "", "");
          }
          for (;;)
          {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
            break;
            localObject2 = ((FriendManager)localObject2).a(paramString1 + "");
            if ((localObject2 != null) && (((TroopInfo)localObject2).troopcode != null)) {
              ((Intent)localObject1).putExtra("troop_uin", ((TroopInfo)localObject2).troopcode);
            }
          }
        }
        if (paramInt == 1008)
        {
          StartupTracker.a(null, "Recent_clk_enterchat_cmr");
          localObject2 = ((PublicAccountDataManager)paramQQAppInterface.getManager(54)).b(String.valueOf(paramString1));
          if ((localObject2 != null) && (((PublicAccountInfo)localObject2).extendType == 2))
          {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
            ((Intent)localObject1).setClass(paramActivity, ChatActivity.class);
            ((Intent)localObject1).putExtra("chat_subType", 1);
          }
          for (;;)
          {
            StartupTracker.a("Recent_clk_enterchat_pub", null);
            i = 0;
            break;
            Object localObject3 = paramQQAppInterface.a().a(paramString1, 1008);
            String str = "";
            localObject2 = str;
            if (localObject3 != null)
            {
              localObject3 = XMLMessageUtils.a((MessageRecord)localObject3);
              localObject2 = str;
              if (localObject3 != null) {
                localObject2 = Long.toString(((PAMessage)localObject3).mMsgId);
              }
            }
            PublicAccountHandler.a(paramQQAppInterface, paramString1, "Pb_account_lifeservice", "mp_msg_sys_3", "msg_aio", (String)localObject2);
            ((Intent)localObject1).setClass(paramActivity, ChatActivity.class);
          }
        }
        if (paramInt == 9501)
        {
          ((Intent)localObject1).setClass(paramActivity, ChatActivity.class);
          SmartDeviceReport.a(paramQQAppInterface, "Usr_AIO_Open", 2, 0, 0);
        }
      }
      label387:
      i = 0;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, ChatActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", 7100);
    localIntent.putExtra("entrance", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(paramActivity, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString3);
      a(localIntent);
      localIntent.addFlags(67108864);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (a)
    {
      paramIntent.putExtra("aio_msg_source", 1);
      a = false;
      return;
    }
    paramIntent.putExtra("aio_msg_source", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.type == 5000) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      return;
      if ((paramRecentUser.type == 7200) || (paramRecentUser.type == 1008))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
      }
      else if (String.valueOf(9992L).equals(paramRecentUser.uin))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1001) && (AppConstants.af.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1010) && (AppConstants.au.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1009) && (AppConstants.V.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label117:
    do
    {
      Object localObject;
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
                              if (paramBoolean)
                              {
                                localObject = new SessionInfo();
                                ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramRecentUser.uin;
                                ((SessionInfo)localObject).b = paramRecentUser.uin;
                                ((SessionInfo)localObject).jdField_a_of_type_Int = paramRecentUser.type;
                                if (((SessionInfo)localObject).jdField_a_of_type_Int == 1006) {
                                  ((SessionInfo)localObject).f = ContactUtils.d(paramQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
                                }
                                ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)localObject);
                              }
                              int i;
                              if (MsgProxyUtils.a(paramRecentUser.uin, paramRecentUser.type))
                              {
                                ((MessageHandler)paramQQAppInterface.a(0)).b(paramRecentUser.uin, paramRecentUser.type);
                                if ((paramRecentUser.type == 0) && (AppConstants.ae.equals(paramRecentUser.uin))) {
                                  SystemMsgController.a().a(paramQQAppInterface, true);
                                }
                                if (paramRecentUser.type != 5000) {
                                  break label265;
                                }
                                paramRecentUser = TroopAssistantManager.a().a(paramQQAppInterface);
                                if (paramRecentUser != null) {
                                  break label220;
                                }
                                i = 0;
                                if (j >= i) {
                                  break label228;
                                }
                                localObject = (TroopAssistantData)paramRecentUser.get(j);
                                if (localObject != null) {
                                  break label230;
                                }
                              }
                              for (;;)
                              {
                                j += 1;
                                break label169;
                                paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
                                break label117;
                                i = paramRecentUser.size();
                                break label169;
                                break;
                                localObject = paramQQAppInterface.a().a(((TroopAssistantData)localObject).troopUin, 1);
                                if (localObject != null) {
                                  TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject).time);
                                }
                              }
                              if (paramRecentUser.type != 7200) {
                                break;
                              }
                              paramRecentUser = PubAccountAssistantManager.a().a(paramQQAppInterface);
                            } while ((paramRecentUser == null) || (paramRecentUser.size() <= 0));
                            paramRecentUser = (PubAccountAssistantData)paramRecentUser.get(0);
                          } while (paramRecentUser == null);
                          paramRecentUser = paramQQAppInterface.a().a(paramRecentUser.mUin, paramRecentUser.mType);
                        } while (paramRecentUser == null);
                        PubAccountAssistantManager.a().a(paramQQAppInterface, paramRecentUser.time);
                        return;
                        if (7000 != paramRecentUser.type) {
                          break;
                        }
                      } while ((paramRecentUser.uin == null) || (paramRecentUser.uin.length() < 5));
                      ((MessageHandler)paramQQAppInterface.a(0)).a().a(paramRecentUser.uin, null);
                      paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(59);
                    } while (paramQQAppInterface == null);
                    paramQQAppInterface.b(paramRecentUser.uin);
                    return;
                    if (String.valueOf(9995L).equals(paramRecentUser.uin))
                    {
                      ((NewFriendManager)paramQQAppInterface.getManager(33)).f();
                      return;
                    }
                    if (String.valueOf(9980L).equals(paramRecentUser.uin))
                    {
                      paramQQAppInterface.a().a().c();
                      GroupSystemMsgController.a().a(paramQQAppInterface, 0);
                      ((RecommendTroopManagerImp)paramQQAppInterface.getManager(21)).a();
                      return;
                    }
                    if (paramRecentUser.type != 7210) {
                      break;
                    }
                    paramRecentUser = TroopBarAssistantManager.a().a(paramQQAppInterface);
                  } while ((paramRecentUser == null) || (paramRecentUser.size() <= 0));
                  paramRecentUser = (TroopBarData)paramRecentUser.get(0);
                } while (paramRecentUser == null);
                paramRecentUser = paramQQAppInterface.a().a(paramRecentUser.mUin, 1008);
              } while (paramRecentUser == null);
              TroopBarAssistantManager.a().a(paramQQAppInterface, paramRecentUser.time);
              return;
            } while (paramRecentUser.type != 7120);
            paramRecentUser = (EcShopAssistantManager)paramQQAppInterface.getManager(83);
          } while (paramRecentUser == null);
          localObject = paramRecentUser.a();
        } while ((localObject == null) || (((List)localObject).size() <= 0));
        localObject = (EcShopData)((List)localObject).get(0);
      } while (localObject == null);
      paramQQAppInterface = paramQQAppInterface.a().a(((EcShopData)localObject).mUin, 1008);
    } while (paramQQAppInterface == null);
    label169:
    label220:
    label228:
    label230:
    paramRecentUser.a(paramQQAppInterface.time);
    label265:
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    label8:
    long l2;
    do
    {
      do
      {
        do
        {
          break label8;
          break label8;
          do
          {
            return;
          } while (paramQQAppInterface.a().a(paramString, paramInt) <= 0);
          l2 = paramQQAppInterface.a().b(paramString, paramInt);
          if (paramInt != 1) {
            break;
          }
        } while (l2 == -1L);
        if (QLog.isColorLevel()) {
          QLog.d("sendGroupMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l2);
        }
        ((TroopMessageProcessor)paramQQAppInterface.a().a("troop_processor")).a(Long.valueOf(paramString).longValue(), l2);
        if (paramInt != 3000) {
          break;
        }
      } while (l2 == -1L);
      if (QLog.isColorLevel()) {
        QLog.d("sendDisMsgReadConfirm", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l2);
      }
      ((DiscMessageProcessor)paramQQAppInterface.a().a("disc_processor")).a(Long.valueOf(paramString).longValue(), l2);
    } while ((!MsgProxyUtils.c(paramInt)) || (l2 == -1L));
    if (QLog.isColorLevel()) {
      QLog.d("sendMsgReadedReport", 2, "curFriendUin is " + paramString + ", shmsgseq  is " + l2);
    }
    ArrayList localArrayList = new ArrayList();
    long l1;
    if (paramInt == 1006)
    {
      String str = ContactUtils.d(paramQQAppInterface, paramString);
      if (TextUtils.isEmpty(str)) {
        break label382;
      }
      l1 = Long.valueOf(str).longValue();
    }
    for (;;)
    {
      if (l1 != -1L)
      {
        localArrayList.add(new UinPairReadInfo(l1, l2, 0L, null));
        ((C2CMessageProcessor)paramQQAppInterface.a().a("c2c_processor")).b(localArrayList);
      }
      if (!AppConstants.ae.equals(paramString)) {
        break;
      }
      paramQQAppInterface.a().a().a();
      return;
      l1 = Long.valueOf(paramString).longValue();
      continue;
      label382:
      l1 = -1L;
    }
  }
  
  public static void a(RecentUser paramRecentUser, QQMessageFacade paramQQMessageFacade)
  {
    long l1 = System.currentTimeMillis();
    if ((paramRecentUser == null) || (paramQQMessageFacade == null)) {}
    long l2;
    do
    {
      return;
      if ((paramRecentUser.getStatus() == 1000) && (paramRecentUser.lastmsgdrafttime == 0L))
      {
        paramQQMessageFacade = paramQQMessageFacade.a(paramRecentUser.uin, paramRecentUser.type);
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + (l2 - l1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt)
  {
    if (AppConstants.af.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, paramRecentUser.uin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0x80050f5", "0x80050f5", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.au.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, paramRecentUser.uin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004947", "0X8004947", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0x80050f6", "0x80050f6", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.az.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, AppConstants.af);
      return true;
    }
    if (AppConstants.aA.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, AppConstants.au);
      return true;
    }
    if (String.valueOf(AppConstants.V).equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1009, paramRecentUser.uin);
      return true;
    }
    if (AppConstants.ac.equals(paramRecentUser.uin))
    {
      paramQQAppInterface.a().c(AppConstants.ac, 0);
      paramRecentUser = new Intent(paramActivity, VisitorsActivity.class);
      paramRecentUser.putExtra("votersOnly", true);
      paramRecentUser.putExtra("toUin", Long.valueOf(paramQQAppInterface.a()));
      paramActivity.startActivity(paramRecentUser);
      return true;
    }
    if (AppConstants.ab.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, NewFriendActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.aa.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.ag.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (AppConstants.av.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopBarAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_tribe", "", "Msglist", "Clk_tribeHelper", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.as.equals(paramRecentUser.uin))
    {
      SecMsgHelper.a(paramActivity, paramQQAppInterface, 1, null);
      return true;
    }
    if (AppConstants.ao.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, PubAccountAssistantActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (AppConstants.ap.equals(paramRecentUser.uin))
    {
      String str1 = "1";
      Intent localIntent = new Intent();
      localIntent.putExtra("key_tab_mode", 2);
      localIntent.setClass(paramActivity, TroopActivity.class);
      paramInt = GroupSystemMsgController.a().a(paramQQAppInterface);
      String str2;
      if (paramInt > 0)
      {
        str2 = "0";
        str1 = "0";
      }
      for (;;)
      {
        paramQQAppInterface.a().b(AppConstants.ap, 9000, -paramInt);
        localIntent.putExtra("_key_mode", paramRecentUser.jumpTabMode);
        paramActivity.startActivity(localIntent);
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", str1, str2, "");
        return true;
        paramInt = RecommendTroopManagerImp.a(paramQQAppInterface);
        if (paramInt > 0)
        {
          str1 = "0";
          str2 = "1";
        }
        else
        {
          str2 = "0";
        }
      }
    }
    if (AppConstants.Y.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, LiteActivity.class);
      paramQQAppInterface.putExtra("uin", paramRecentUser.uin);
      paramQQAppInterface.putExtra("uintype", paramRecentUser.type);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (AppConstants.aw.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, ActivateFriendActivity.class);
      paramQQAppInterface.setFlags(67108864);
      if (paramInt == 0) {}
      for (paramInt = 1;; paramInt = 3)
      {
        paramQQAppInterface.putExtra("af_key_from", paramInt);
        paramActivity.startActivity(paramQQAppInterface);
        return true;
      }
    }
    if (AppConstants.ax.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, EcShopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
      return true;
    }
    if (1012 == paramRecentUser.msgType)
    {
      paramQQAppInterface = new ProfileActivity.AllInOne(paramQQAppInterface.a(), 0);
      paramRecentUser = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
      paramRecentUser.putExtra("param_mode", 2);
      paramRecentUser.putExtra("AllInOne", paramQQAppInterface);
      paramRecentUser.putExtra("frome_where", 1);
      paramRecentUser.putExtra("abp_flag", true);
      paramRecentUser.addFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
        if (paramQQAppInterface != null) {
          break label35;
        }
      }
    }
    label35:
    for (bool1 = false;; bool1 = paramQQAppInterface.b(paramString)) {
      return bool1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    int k = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    for (;;)
    {
      return;
      paramQQAppInterface.a().a().b(paramRecentUser);
      label256:
      int i;
      label258:
      label333:
      Object localObject1;
      label519:
      label801:
      label803:
      if (MsgProxyUtils.a(paramRecentUser.uin, paramRecentUser.type))
      {
        ((MessageHandler)paramQQAppInterface.a(0)).b(paramRecentUser.uin, paramRecentUser.type);
        paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
        if ((paramRecentUser.type == 0) && (AppConstants.ae.equals(paramRecentUser.uin))) {
          SystemMsgController.a().a(paramQQAppInterface, true);
        }
        if ((paramRecentUser.type == 4000) && (AppConstants.ab.equals(paramRecentUser.uin)))
        {
          NewFriendManager.a(paramQQAppInterface, true);
          ((NewFriendManager)paramQQAppInterface.getManager(33)).g();
        }
        switch (paramRecentUser.type)
        {
        default: 
          i = 0;
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, i + "", "", "", "");
          if (paramRecentUser.type != 5000) {
            break label484;
          }
          TroopAssistantManager.a().a(paramQQAppInterface, true);
          paramRecentUser = TroopAssistantManager.a().a(paramQQAppInterface);
          if (paramRecentUser == null)
          {
            i = 0;
            if (j >= i) {
              continue;
            }
            localObject1 = (TroopAssistantData)paramRecentUser.get(j);
            if (localObject1 != null) {
              break label449;
            }
          }
          break;
        }
      }
      else
      {
        for (;;)
        {
          j += 1;
          break label333;
          a(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type);
          break;
          if (!paramRecentUser.uin.equals(AppConstants.ae)) {
            break label256;
          }
          i = 7;
          break label258;
          i = 1;
          break label258;
          i = 2;
          break label258;
          i = 3;
          break label258;
          i = 4;
          break label258;
          i = 5;
          break label258;
          i = 6;
          break label258;
          i = 8;
          break label258;
          i = 9;
          break label258;
          i = paramRecentUser.size();
          break label333;
          label449:
          localObject1 = paramQQAppInterface.a().a(((TroopAssistantData)localObject1).troopUin, 1);
          if (localObject1 != null) {
            TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
          }
        }
        label484:
        if (paramRecentUser.type == 7200)
        {
          PubAccountAssistantManager.a().a(paramQQAppInterface, true);
          paramRecentUser = PubAccountAssistantManager.a().a(paramQQAppInterface);
          if (paramRecentUser == null)
          {
            i = 0;
            j = k;
            if (j >= i) {
              break label559;
            }
            localObject1 = (PubAccountAssistantData)paramRecentUser.get(j);
            if (localObject1 != null) {
              break label561;
            }
          }
          for (;;)
          {
            j += 1;
            break label519;
            i = paramRecentUser.size();
            j = k;
            break label519;
            break;
            localObject1 = paramQQAppInterface.a().a(((PubAccountAssistantData)localObject1).mUin, ((PubAccountAssistantData)localObject1).mType);
            if (localObject1 != null) {
              PubAccountAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
            }
          }
        }
        label559:
        label561:
        if (paramRecentUser.type == 7210)
        {
          TroopBarAssistantManager.a().a(paramQQAppInterface, true);
          paramRecentUser = TroopBarAssistantManager.a().a(paramQQAppInterface);
          if (paramRecentUser == null)
          {
            i = 0;
            j = m;
            label635:
            if (j >= i) {
              break label675;
            }
            localObject1 = (TroopBarData)paramRecentUser.get(j);
            if (localObject1 != null) {
              break label677;
            }
          }
          for (;;)
          {
            j += 1;
            break label635;
            i = paramRecentUser.size();
            j = m;
            break label635;
            break;
            localObject1 = paramQQAppInterface.a().a(((TroopBarData)localObject1).mUin, 1008);
            if (localObject1 != null) {
              TroopBarAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
            }
          }
        }
        label675:
        label677:
        if (paramRecentUser.type == 7120)
        {
          paramRecentUser = (EcShopAssistantManager)paramQQAppInterface.getManager(83);
          if (paramRecentUser != null)
          {
            paramRecentUser.a(true);
            localObject1 = paramRecentUser.a();
            label759:
            Object localObject2;
            if (localObject1 == null)
            {
              i = 0;
              j = n;
              if (j >= i) {
                break label801;
              }
              localObject2 = (EcShopData)((List)localObject1).get(j);
              if (localObject2 != null) {
                break label803;
              }
            }
            for (;;)
            {
              j += 1;
              break label759;
              i = ((List)localObject1).size();
              j = n;
              break label759;
              break;
              localObject2 = paramQQAppInterface.a().a(((EcShopData)localObject2).mUin, 1008);
              if (localObject2 != null) {
                paramRecentUser.a(((QQMessageFacade.Message)localObject2).time);
              }
            }
          }
        }
        else if (paramRecentUser.type == 9002)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
          paramRecentUser = paramQQAppInterface.a().a(AppConstants.aw, 0).iterator();
          while (paramRecentUser.hasNext())
          {
            localObject1 = (MessageRecord)paramRecentUser.next();
            paramQQAppInterface.a().b(AppConstants.aw, 0, ((MessageRecord)localObject1).uniseq);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil
 * JD-Core Version:    0.7.0.1
 */