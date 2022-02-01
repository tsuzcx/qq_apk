package com.tencent.mobileqq.subaccount;

import QQService.BindUin;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SubAccountBaseActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import jxx;
import jxz;
import jya;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;

public class SubAccountControll
  implements Manager
{
  public static final int a = 20;
  public static final long a = 9223372036854775804L;
  public static final String a = "com.tencent.intent.action.QZONE_GOTO_ABOUT_ME";
  public static final boolean a = true;
  public static final int b = 0;
  private static final long jdField_b_of_type_Long = 300L;
  public static final String b = "sub.uin.default";
  public static final int c = 1;
  public static final String c = "sub.uin.all";
  public static final int d = 1;
  public static String d = "yyyy-MM-dd";
  public static final int e = 0;
  public static final String e = "param_FailCode";
  public static final int f = 0;
  public static final String f = "fail_step";
  public static final int g = 1;
  public static final String g = "fail_location";
  public static final int h = 2;
  public static final String h = "com.tencent.minihd.qq:qzone";
  public static final int i = 3;
  public static final String i = "2005060620050606";
  public static final int j = 4;
  public static final int k = 5;
  public static final int l = 6;
  public static final int m = 7;
  public static final int n = 2;
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 3;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private long c = 300L;
  
  public SubAccountControll(QQAppInterface paramQQAppInterface)
  {
    try
    {
      String str = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "date_format");
      if (!TextUtils.isEmpty(str)) {
        d = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "subaccountMsgFreq");
          if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface)))
          {
            this.c = Long.parseLong(paramQQAppInterface);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "init msgDelayTime = " + this.c);
            }
          }
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.a().getSharedPreferences("acc_info" + paramString, 0).getLong("getProfileStatusNew", 11L);
  }
  
  public static Pair a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool4 = false;
    Object localObject;
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("checkSubAccountLoginStatus() app is null?=>");
        if (paramQQAppInterface != null) {
          break label94;
        }
        bool1 = true;
        paramQQAppInterface = ((StringBuilder)localObject).append(bool1).append(" subUin is null?=>");
        if (paramString != null) {
          break label99;
        }
      }
      label94:
      label99:
      for (bool1 = bool2;; bool1 = false)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        bool1 = false;
        break;
      }
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getAllAccounts();
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("checkSubAccountLoginStatus() app.getAllAccounts() is null? =>");
        if (paramQQAppInterface != null) {
          break label178;
        }
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, bool1);
        return new Pair(Boolean.valueOf(false), Boolean.valueOf(false));
        label178:
        bool1 = false;
      }
    }
    int i1 = 0;
    if (i1 < paramQQAppInterface.size())
    {
      localObject = (SimpleAccount)paramQQAppInterface.get(i1);
      if (localObject == null) {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount == null");
        }
      }
      label258:
      do
      {
        for (;;)
        {
          i1 += 1;
          break;
          if (((SimpleAccount)localObject).getUin() != null) {
            break label258;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount.getUin() == null");
          }
        }
      } while (!((SimpleAccount)localObject).getUin().equalsIgnoreCase(paramString));
      bool1 = bool3;
      bool2 = bool4;
      if (((SimpleAccount)localObject).isLogined())
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() hasAccount=" + bool1 + " isLogin=" + bool2);
      }
      return new Pair(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      bool1 = false;
      bool2 = bool4;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = "";
    Object localObject2;
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() return. app=" + String.valueOf(paramQQAppInterface) + " subUin=" + paramString);
        localObject2 = localObject1;
      }
      return localObject2;
    }
    Object localObject3;
    if (AppConstants.W.equals(paramString))
    {
      localObject3 = paramQQAppInterface.getApplication().getAllNotSynAccountList();
      if ((localObject3 != null) && (((List)localObject3).size() > 1))
      {
        localObject1 = (SimpleAccount)((List)localObject3).get(0);
        if ((localObject1 == null) || (((SimpleAccount)localObject1).getUin() == null)) {
          break label1167;
        }
        localObject2 = ((SimpleAccount)localObject1).getUin();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equalsIgnoreCase(paramQQAppInterface.getAccount())) {}
        }
      }
    }
    label1167:
    for (localObject1 = ((SimpleAccount)((List)localObject3).get(1)).getUin();; localObject1 = null)
    {
      if ((localObject1 == null) || (((String)localObject1).length() < 5))
      {
        paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131368721);
        label191:
        localObject2 = paramQQAppInterface;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
        return paramQQAppInterface;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject3 = ContactUtils.g(paramQQAppInterface, (String)localObject1);; localObject3 = null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = localObject3;
          if (!((String)localObject3).equals(localObject1)) {}
        }
        else
        {
          localObject2 = ContactUtils.c(paramQQAppInterface, (String)localObject1, true);
        }
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = localObject1;
        }
        paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131368728, new Object[] { localObject3 });
        break label191;
        paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131368721);
        break label191;
        localObject1 = ContactUtils.c(paramQQAppInterface, paramString, true);
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          localObject1 = paramString;
        }
        for (;;)
        {
          SubAccountManager localSubAccountManager = (SubAccountManager)paramQQAppInterface.getManager(59);
          int i1 = localSubAccountManager.a(paramString);
          if (i1 == 1)
          {
            localObject2 = localSubAccountManager.a(paramString);
            localObject3 = new SpannableStringBuilder();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramQQAppInterface = localSubAccountManager.b(paramString);
              if ((!TextUtils.isEmpty(paramQQAppInterface)) && ("2005060620050606".equals(paramQQAppInterface))) {}
              for (;;)
              {
                ((SpannableStringBuilder)localObject3).append((CharSequence)localObject2);
                if (QLog.isColorLevel()) {
                  QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + ((CharSequence)localObject3).charAt(0) + "|" + ((CharSequence)localObject3).length());
                }
                return localObject3;
                localObject1 = localSubAccountManager.c(paramString);
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
                ((SpannableStringBuilder)localObject3).append(":");
              }
              if (paramQQAppInterface == null) {
                paramQQAppInterface = "";
              }
              for (;;)
              {
                ((SpannableStringBuilder)localObject3).append(paramQQAppInterface);
                ((SpannableStringBuilder)localObject3).append(":");
                break;
              }
            }
            if (localSubAccountManager.c(paramString)) {}
            for (paramQQAppInterface = paramQQAppInterface.a().getString(2131368682, new Object[] { localObject1 });; paramQQAppInterface = paramQQAppInterface.a().getString(2131368692))
            {
              localObject2 = paramQQAppInterface;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
              return paramQQAppInterface;
            }
          }
          if (i1 == 2)
          {
            if (localSubAccountManager.c(paramString)) {}
            for (paramQQAppInterface = paramQQAppInterface.a().getString(2131368682, new Object[] { localObject1 });; paramQQAppInterface = paramQQAppInterface.a().getResources().getString(2131368724))
            {
              localObject2 = paramQQAppInterface;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
              return paramQQAppInterface;
            }
          }
          if (i1 == 3)
          {
            localObject1 = localSubAccountManager.a(paramString);
            if (localObject1 == null) {
              break label1150;
            }
            i1 = ((Integer)((Pair)localObject1).first).intValue();
            localObject2 = (String)((Pair)localObject1).second;
          }
          for (;;)
          {
            if (i1 != 0) {
              switch (i1)
              {
              default: 
                localObject1 = paramQQAppInterface.a().getString(2131368695);
              }
            }
            for (;;)
            {
              localObject2 = localObject1;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + localObject1);
              return localObject1;
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject2).trim().length() != 0) {}
              }
              else
              {
                localObject1 = paramQQAppInterface.a().getString(2131368695);
                continue;
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).trim().length() != 0) {}
                }
                else
                {
                  localObject1 = paramQQAppInterface.a().getString(2131368696);
                  continue;
                  if (localObject2 != null)
                  {
                    localObject1 = localObject2;
                    if (((String)localObject2).trim().length() != 0) {}
                  }
                  else
                  {
                    localObject1 = paramQQAppInterface.a().getString(2131368712);
                    continue;
                    if (localObject2 != null)
                    {
                      localObject1 = localObject2;
                      if (((String)localObject2).trim().length() != 0) {}
                    }
                    else
                    {
                      localObject1 = paramQQAppInterface.a().getString(2131368695);
                      continue;
                      if (localObject2 != null)
                      {
                        localObject1 = localObject2;
                        if (((String)localObject2).trim().length() != 0) {}
                      }
                      else
                      {
                        localObject1 = paramQQAppInterface.a().getString(2131368695);
                        continue;
                        localObject1 = paramQQAppInterface.a().getResources().getString(2131368724);
                      }
                    }
                  }
                }
              }
            }
            paramQQAppInterface = paramQQAppInterface.a().getString(2131368722, new Object[] { localObject1 });
            localObject2 = paramQQAppInterface;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountLastMsg() subUin=" + paramString + " lastMsg=" + paramQQAppInterface);
            return paramQQAppInterface;
            label1150:
            localObject2 = null;
            i1 = 0;
          }
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = null;
    Object localObject = null;
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    if (SystemMsg.isSystemMessage(paramInt)) {
      switch (paramInt)
      {
      default: 
        paramString1 = localObject;
      }
    }
    for (;;)
    {
      paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramString2, true);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramString2))) {
        break;
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramQQAppInterface).append(paramString1);
      paramString1 = paramString2.toString();
      return paramString1;
      paramString1 = localBaseApplication.getString(2131367193);
      continue;
      paramString1 = localBaseApplication.getString(2131367194);
      continue;
      paramString1 = localBaseApplication.getString(2131367195);
      continue;
      paramString1 = localBaseApplication.getString(2131367202);
      continue;
      paramString1 = localBaseApplication.getString(2131367203);
    }
    return paramString2 + paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new Intent("Common_BroadcastReceiver");
    paramQQAppInterface.putExtra("com.tencent.intent.action.QZONE_GOTO_ABOUT_ME", true);
    BaseApplication.getContext().sendBroadcast(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() subUin=" + paramString + " cmd=" + paramByte);
    }
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramQQAppInterface, paramByte, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte paramByte, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("setBindUinStatus() return, listSubUin:");
        if (paramArrayList != null) {
          break label56;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label56:
    do
    {
      return;
      paramQQAppInterface = "size=0";
      break;
      if ((paramByte == 0) || (paramByte == 1)) {
        break label105;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, cmd=" + paramByte);
    return;
    label105:
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    label120:
    if (localIterator.hasNext()) {
      paramArrayList = (String)localIterator.next();
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramArrayList);
        if ((l1 == 0L) || (l1 <= 10000L)) {
          break label120;
        }
        if (paramByte != 1) {
          break label429;
        }
        l2 = paramQQAppInterface.a().getSharedPreferences("acc_info" + paramArrayList, 0).getLong("getProfileStatusNew", 11L);
        Object localObject2 = (SubAccountManager)paramQQAppInterface.getManager(59);
        if (localObject2 == null) {
          break label424;
        }
        paramArrayList = ((SubAccountManager)localObject2).a(paramArrayList);
        if (paramArrayList == null)
        {
          paramArrayList = new byte[0];
          localObject2 = new BindUin();
          ((BindUin)localObject2).lUin = l1;
          ((BindUin)localObject2).iStatus = ((int)l2);
          ((BindUin)localObject2).sKey = paramArrayList;
          ((ArrayList)localObject1).add(localObject2);
          if (!QLog.isColorLevel()) {
            break label120;
          }
          localObject2 = new StringBuilder().append("setBindUinStatus() add<QQService.BindUin>:lUin=").append(l1).append(" cmd=").append(paramByte).append(" status=").append(l2).append(" sKey=");
          if (paramArrayList != null) {
            continue;
          }
          paramArrayList = "null";
          QLog.d("SUB_ACCOUNT", 2, paramArrayList);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        long l1 = 0L;
        continue;
        paramArrayList = HexUtil.a(paramArrayList);
        continue;
        paramArrayList = Integer.valueOf(paramArrayList.length);
        continue;
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.a(paramByte, (ArrayList)localObject1);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, ArrayList<QQService.BindUin> list.size=0");
      return;
      label424:
      paramArrayList = null;
      continue;
      label429:
      long l2 = 21L;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindAllRecentitem() defAct=" + paramInt);
    }
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    Object localObject = localRecentUserProxy.b();
    int i1 = paramInt;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        i1 = paramInt;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        if ((localRecentUser != null) && (localRecentUser.type == 7000) && (!AppConstants.W.equals(localRecentUser.uin)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "RecentUserProxy.deleteRecentUserByType, uin=" + localRecentUser.uin + " type=" + localRecentUser.type);
          }
          paramQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
          localRecentUserProxy.b(localRecentUser);
          paramInt = 7;
        }
      }
    }
    a(paramQQAppInterface, localRecentUserProxy, AppConstants.W, i1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("showMaxHintDialog() actCaller=");
      if (paramBaseActivity != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject1 = "null";; localObject1 = paramBaseActivity.getClass().getSimpleName())
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      if (paramBaseActivity != null) {
        break;
      }
      return;
    }
    localObject1 = paramBaseActivity.getString(2131368681);
    Object localObject2 = paramBaseActivity.getString(2131368698, new Object[] { Integer.valueOf(2) });
    localObject1 = DialogUtil.a(paramBaseActivity, 230).setTitle((String)localObject1).setMessage((CharSequence)localObject2);
    ((QQCustomDialog)localObject1).setOwnerActivity(paramBaseActivity);
    ((QQCustomDialog)localObject1).setPositiveButton(paramBaseActivity.getString(2131368661), new jxz(paramQQAppInterface, paramBaseActivity));
    ((QQCustomDialog)localObject1).setCancelable(false);
    ((QQCustomDialog)localObject1).show();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramInt == 0)) {
      if (QLog.isColorLevel())
      {
        paramRecentUserProxy = new StringBuilder().append("updateRecentUser() return,");
        if (paramString != null) {
          break label100;
        }
        paramQQAppInterface = "subUin==null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    label100:
    do
    {
      do
      {
        return;
        paramQQAppInterface = "subUin.len=0 action=" + paramInt;
        break;
        if (paramRecentUserProxy != null) {
          break label144;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() return, ruProxy==null");
      return;
      localRecentUser = paramRecentUserProxy.b(paramString, 7000);
      if (localRecentUser != null) {
        break label378;
      }
    } while ((paramInt == 5) || (paramInt == 0));
    label144:
    RecentUser localRecentUser = new RecentUser();
    localRecentUser.type = 7000;
    label378:
    for (;;)
    {
      localRecentUser.uin = paramString;
      if (AppConstants.W.equals(paramString))
      {
        localRecentUser.lastmsgtime = (System.currentTimeMillis() / 1000L);
        paramInt = 1;
      }
      while (paramInt != 0)
      {
        paramRecentUserProxy.a(localRecentUser);
        return;
        paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(59);
        long l2 = paramQQAppInterface.a(paramString);
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = System.currentTimeMillis() / 1000L;
        }
        switch (paramInt)
        {
        case 3: 
        default: 
          paramInt = 0;
          break;
        case 1: 
        case 2: 
        case 6: 
        case 7: 
          l1 = System.currentTimeMillis() / 1000L;
          paramQQAppInterface.a(paramString, l1);
          if (localRecentUser.lastmsgtime != 9223372036854775804L) {
            localRecentUser.lastmsgtime = l1;
          }
          paramInt = 1;
          break;
        case 5: 
          localRecentUser.lastmsgtime = l1;
          paramInt = 1;
          break;
        case 4: 
          localRecentUser.lastmsgtime = 9223372036854775804L;
          paramInt = 1;
        }
      }
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearAllData() subUin=" + paramString);
    }
    if ("sub.uin.all".equals(paramString))
    {
      paramString = (SubAccountManager)paramQQAppInterface.getManager(59);
      if (paramString == null) {
        break label181;
      }
    }
    label181:
    for (paramString = paramString.a();; paramString = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "clearAllData() clear all_sub_uin. list=" + paramString);
      }
      if (paramString != null)
      {
        paramString = paramString.iterator();
        int i1 = 0;
        while (paramString.hasNext())
        {
          Object localObject = (String)paramString.next();
          if (!"sub.uin.all".equals(localObject))
          {
            i1 += 1;
            a(paramQQAppInterface, (String)localObject);
            continue;
            if (paramQQAppInterface != null)
            {
              localObject = (SubAccountManager)paramQQAppInterface.getManager(59);
              if (localObject != null)
              {
                ((SubAccountManager)localObject).a(paramString);
                ((SubAccountManager)localObject).c(paramString);
                if (ContactUtils.c(paramQQAppInterface, paramString, false) != null) {
                  break;
                }
              }
            }
          }
        }
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() subUin=" + paramString + " actionType=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() < 5)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() return, subUin==null || subUin.length()<5");
      }
    }
    do
    {
      return;
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.W, 7000);
      if (localRecentUser != null)
      {
        paramQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
        localRecentUserProxy.b(localRecentUser);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
        }
      }
      a(paramQQAppInterface, localRecentUserProxy, paramString, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("setSBTopInRecentList() return, ");
        if (paramQQAppInterface != null) {
          break label51;
        }
      }
      label51:
      for (paramQQAppInterface = "app==null";; paramQQAppInterface = "subUin==null")
      {
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
        return;
      }
    }
    if (AppConstants.W.equals(paramString)) {
      if (paramBoolean) {
        a(paramQQAppInterface, paramQQAppInterface.a().a(), AppConstants.W, 7);
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface.sendEmptyMessage(1009);
      return;
      ((SubAccountManager)paramQQAppInterface.getManager(59)).a(paramString, paramBoolean);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      if (paramBoolean) {
        a(paramQQAppInterface, localRecentUserProxy, paramString, 4);
      } else {
        a(paramQQAppInterface, localRecentUserProxy, paramString, 5);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() list=" + String.valueOf(paramArrayList) + " actionType=" + paramInt);
    }
    Object localObject1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("bindRecentItem() return, list=");
        if (paramArrayList != null) {
          break label99;
        }
        paramQQAppInterface = "null";
        QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      }
    }
    for (;;)
    {
      return;
      label99:
      paramQQAppInterface = Integer.valueOf(paramArrayList.size());
      break;
      localObject1 = paramQQAppInterface.a().a();
      Object localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.W, 7000);
      if (localObject2 != null)
      {
        paramQQAppInterface.a().c(((RecentUser)localObject2).uin, ((RecentUser)localObject2).type);
        ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
        }
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (String)paramArrayList.next();
        a(paramQQAppInterface, (RecentUserProxy)localObject1, (String)localObject2, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, add RU:" + (String)localObject2);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(59);
    if (paramQQAppInterface != null) {}
    for (int i1 = paramQQAppInterface.a();; i1 = 0)
    {
      if (i1 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "checkAccountBind, bindedNum=" + i1 + " ret=" + bool);
        }
        return bool;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramString == null)
    {
      bool2 = bool1;
      return bool2;
    }
    bool1 = bool2;
    Object localObject;
    if (paramQQAppInterface != null)
    {
      localObject = (SubAccountManager)paramQQAppInterface.getManager(59);
      if (localObject == null) {
        break label343;
      }
      localObject = ((SubAccountManager)localObject).a();
      label45:
      paramQQAppInterface = (SubAccountControll)paramQQAppInterface.getManager(60);
      bool1 = bool2;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        if ((paramQQAppInterface.b == null) || (paramQQAppInterface.b.size() <= 0)) {
          break label338;
        }
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          i1 = paramQQAppInterface.b.size() - 1;
          if (i1 >= 0)
          {
            Pair localPair = (Pair)paramQQAppInterface.b.get(i1);
            if (((ArrayList)localObject).contains(localPair.first))
            {
              if (((Integer)localPair.second).intValue() == 1) {
                paramQQAppInterface.b.remove(i1);
              }
            }
            else if (((Integer)localPair.second).intValue() == 0) {
              paramQQAppInterface.b.remove(i1);
            }
          }
        }
      }
      finally
      {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if ((paramQQAppInterface.b != null) && (paramQQAppInterface.b.size() > 0))
      {
        bool1 = "sub.uin.all".equals(paramString);
        if (bool1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        paramQQAppInterface.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "needShowHintDialog() subUin=" + paramString + " bool=" + bool1);
        return bool1;
        localObject = paramQQAppInterface.b.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            bool1 = paramString.equals(((Pair)((Iterator)localObject).next()).first);
            if (bool1)
            {
              bool1 = true;
              break;
            }
          }
        }
        label338:
        bool1 = false;
      }
      label343:
      localObject = null;
      break label45;
      i1 -= 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() subUin=" + paramString + " isFromPush=" + paramBoolean);
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning()))
    {
      localObject = (SubAccountManager)paramQQAppInterface.getManager(59);
      if (localObject == null) {
        break label404;
      }
    }
    label404:
    for (Object localObject = ((SubAccountManager)localObject).a(paramString);; localObject = null)
    {
      SubAccountProtocManager localSubAccountProtocManager = (SubAccountProtocManager)paramQQAppInterface.getManager(27);
      if (localSubAccountProtocManager != null)
      {
        boolean bool = localSubAccountProtocManager.a();
        if (!bool)
        {
          localObject = new SubAccountBackProtocData();
          ((SubAccountBackProtocData)localObject).a = "";
          ((SubAccountBackProtocData)localObject).b = paramQQAppInterface.getAccount();
          ((SubAccountBackProtocData)localObject).c = paramString;
          ((SubAccountBackProtocData)localObject).p = 1009;
          paramQQAppInterface.a().a(8003, false, localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, get bind subaccount isFinish = " + bool);
          }
          return false;
        }
      }
      if ((paramString == null) || (paramString.length() == 0) || (localObject == null) || (((String)localObject).length() == 0) || (((String)localObject).trim().equals("")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() return, subUin=" + paramString + " a2=" + (String)localObject);
        }
        localObject = new SubAccountBackProtocData();
        ((SubAccountBackProtocData)localObject).a = "";
        ((SubAccountBackProtocData)localObject).b = paramQQAppInterface.getAccount();
        ((SubAccountBackProtocData)localObject).c = paramString;
        ((SubAccountBackProtocData)localObject).p = 1010;
        paramQQAppInterface.a().a(8003, false, localObject);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getSubAccountMessage() lockMsg later really start get subaccount message account = " + paramQQAppInterface.getAccount() + "; sAccount = " + paramString);
      }
      paramQQAppInterface = (MessageHandler)paramQQAppInterface.a(0);
      paramQQAppInterface.a().a((byte)3, 0, paramString, (String)localObject, null);
      if (!paramBoolean) {
        paramQQAppInterface.a().a(paramString);
      }
      return true;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() return, app == null");
      }
    }
    label419:
    label465:
    do
    {
      return;
      SubAccountManager localSubAccountManager = (SubAccountManager)paramQQAppInterface.getManager(59);
      long l1 = DBUtils.a().a(paramQQAppInterface.a());
      long l2 = ApkUtils.a(paramQQAppInterface.a());
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData()..start, historyVersion=" + l1 + " thisApkVersion=" + l2);
      }
      boolean bool;
      Object localObject;
      int i1;
      RecentUser localRecentUser;
      SubAccountInfo localSubAccountInfo;
      if (l1 < l2)
      {
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() need to update (v5.0 or lower) data");
          }
          bool = DBUtils.a().a(paramQQAppInterface.a(), paramQQAppInterface.getAccount());
          localObject = localSubAccountManager.a("sub.uin.default");
          if ((localObject != null) && (((SubAccountInfo)localObject).subuin != null))
          {
            localSubAccountManager.h(((SubAccountInfo)localObject).subuin);
            i1 = localSubAccountManager.d(((SubAccountInfo)localObject).subuin) - paramQQAppInterface.a().a(((SubAccountInfo)localObject).subuin, 7000);
            if (i1 != 0)
            {
              paramQQAppInterface.a().b(((SubAccountInfo)localObject).subuin, 7000, i1);
              paramQQAppInterface.a().a(new String[] { AppConstants.W, ((SubAccountInfo)localObject).subuin });
            }
            if (bool)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "initAllData(), setTopInRecentList, isTop=" + bool);
              }
              a(paramQQAppInterface, ((SubAccountInfo)localObject).subuin, true);
            }
          }
          DBUtils.a().a(paramQQAppInterface.a());
        }
      }
      else
      {
        if (!DBUtils.a().b(paramQQAppInterface.a(), paramQQAppInterface.getAccount()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() showedBefore:false, isFirstTime to user SubAccount.");
          }
          DBUtils.a().a(paramQQAppInterface.a(), paramQQAppInterface.getAccount(), true);
          a(paramQQAppInterface, 7);
        }
        localObject = paramQQAppInterface.a().a();
        localRecentUser = ((RecentUserProxy)localObject).b(AppConstants.W, 7000);
        if (localSubAccountManager.a() <= 0) {
          break label806;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "initAllData() getBindedNumber > 0, go to initAllData");
        }
        ArrayList localArrayList = localSubAccountManager.b();
        int i3 = localArrayList.size();
        i1 = 0;
        if (i1 >= i3) {
          break label806;
        }
        localSubAccountInfo = (SubAccountInfo)localArrayList.get(i1);
        if (localSubAccountInfo != null) {
          break label465;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label419;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SUB_ACCOUNT", 2, "initAllData() (v5.1 or later) update..");
        break;
        if (localRecentUser != null)
        {
          paramQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
          ((RecentUserProxy)localObject).b(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() delete defaultRU:" + localRecentUser.uin + " type=" + localRecentUser.type);
          }
        }
        if ((localRecentUser != null) && (l1 == 0L))
        {
          a(paramQQAppInterface, localSubAccountInfo.subuin, 7);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() add RU:" + localSubAccountInfo.subuin);
          }
          int i4 = paramQQAppInterface.a().a(localSubAccountInfo.subuin, 7000);
          int i2 = 0;
          if (localSubAccountManager != null) {
            i2 = localSubAccountManager.d(localSubAccountInfo.subuin);
          }
          int i5 = i2 - i4;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "initAllData() onGetKeyBack() setReaded subaccount,old:" + i4 + " target:" + i2 + " increase:" + i5);
          }
          if (i5 != 0)
          {
            paramQQAppInterface.a().b(localSubAccountInfo.subuin, 7000, i5);
            paramQQAppInterface.a().a(new String[] { AppConstants.W, localSubAccountInfo.subuin });
          }
        }
        bool = false;
        Pair localPair = a(paramQQAppInterface, localSubAccountInfo.subuin);
        if (localPair != null) {
          bool = ((Boolean)localPair.second).booleanValue();
        }
        if (bool) {
          paramQQAppInterface.getSubAccountKey(paramQQAppInterface.getAccount(), localSubAccountInfo.subuin, new jxx(paramQQAppInterface));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() end");
      }
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    } while (paramQQAppInterface == null);
    label806:
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      d = paramString;
      paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(59);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.d(d);
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (SubAccountManager)paramQQAppInterface.getManager(59);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)paramQQAppInterface.next();
          if ((localSubAccountInfo != null) && (localSubAccountInfo.isTop)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() < 4)) {}
    do
    {
      RecentUserProxy localRecentUserProxy;
      do
      {
        return;
        paramQQAppInterface.a().c(paramString, 7000);
        localRecentUserProxy = paramQQAppInterface.a().a();
        paramString = localRecentUserProxy.b(paramString, 7000);
        if (paramString != null)
        {
          localRecentUserProxy.b(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "unbindRecentItem() unbind,delete subUin:" + paramString.uin + " type=" + paramString.type);
          }
        }
      } while (((SubAccountManager)paramQQAppInterface.getManager(59)).a() != 0);
      a(paramQQAppInterface, localRecentUserProxy, AppConstants.W, 7);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() unbind, add default RecentUser");
  }
  
  public Pair a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "addHintPair() subUin=" + paramString + " type=" + paramInt);
    }
    if ((paramString == null) || (paramString.length() < 5) || ((paramInt != 0) && (paramInt != 1))) {
      return null;
    }
    Pair localPair1 = new Pair(paramString, Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          paramInt = this.b.size() - 1;
          if (paramInt >= 0)
          {
            Pair localPair2 = (Pair)this.b.get(paramInt);
            if (!paramString.equals(localPair2.first)) {
              break label248;
            }
            this.b.remove(paramInt);
            if (!QLog.isColorLevel()) {
              break label248;
            }
            QLog.d("SUB_ACCOUNT", 2, "addHintPair() remove old, subUin=" + (String)localPair2.first + " type=" + localPair2.second);
            break label248;
          }
        }
        if (this.b == null) {
          this.b = new ArrayList();
        }
        this.b.add(localPair1);
        return localPair1;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label248:
      paramInt -= 1;
    }
  }
  
  /* Error */
  public ArrayList a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 133
    //   8: iconst_2
    //   9: new 135	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 843
    //   19: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: new 401	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 402	java/util/ArrayList:<init>	()V
    //   39: astore_3
    //   40: aload_1
    //   41: ifnonnull +5 -> 46
    //   44: aload_3
    //   45: areturn
    //   46: aload_0
    //   47: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   50: invokeinterface 661 1 0
    //   55: aload_0
    //   56: getfield 663	com/tencent/mobileqq/subaccount/SubAccountControll:b	Ljava/util/ArrayList;
    //   59: ifnull +28 -> 87
    //   62: ldc 26
    //   64: aload_1
    //   65: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +30 -> 98
    //   71: aload_3
    //   72: aload_0
    //   73: getfield 663	com/tencent/mobileqq/subaccount/SubAccountControll:b	Ljava/util/ArrayList;
    //   76: invokevirtual 847	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   79: pop
    //   80: aload_0
    //   81: getfield 663	com/tencent/mobileqq/subaccount/SubAccountControll:b	Ljava/util/ArrayList;
    //   84: invokevirtual 850	java/util/ArrayList:clear	()V
    //   87: aload_0
    //   88: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   91: invokeinterface 673 1 0
    //   96: aload_3
    //   97: areturn
    //   98: aload_0
    //   99: getfield 663	com/tencent/mobileqq/subaccount/SubAccountControll:b	Ljava/util/ArrayList;
    //   102: invokevirtual 409	java/util/ArrayList:size	()I
    //   105: iconst_1
    //   106: isub
    //   107: istore_2
    //   108: iload_2
    //   109: iflt -22 -> 87
    //   112: aload_0
    //   113: getfield 663	com/tencent/mobileqq/subaccount/SubAccountControll:b	Ljava/util/ArrayList;
    //   116: iload_2
    //   117: invokevirtual 664	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   120: checkcast 185	com/tencent/util/Pair
    //   123: astore 4
    //   125: aload_1
    //   126: aload 4
    //   128: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   131: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +19 -> 153
    //   137: aload_3
    //   138: aload 4
    //   140: invokevirtual 405	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: aload_0
    //   145: getfield 663	com/tencent/mobileqq/subaccount/SubAccountControll:b	Ljava/util/ArrayList;
    //   148: iload_2
    //   149: invokevirtual 670	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   152: pop
    //   153: iload_2
    //   154: iconst_1
    //   155: isub
    //   156: istore_2
    //   157: goto -49 -> 108
    //   160: astore_1
    //   161: aload_0
    //   162: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   165: invokeinterface 673 1 0
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	SubAccountControll
    //   0	172	1	paramString	String
    //   107	50	2	i1	int
    //   39	99	3	localArrayList	ArrayList
    //   123	16	4	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   55	87	160	finally
    //   98	108	160	finally
    //   112	153	160	finally
  }
  
  public void a(SubAccountBaseActivity paramSubAccountBaseActivity)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("cancelUnbindDialog() act=");
      if (paramSubAccountBaseActivity == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, (String)localObject);
      }
    }
    else
    {
      if (paramSubAccountBaseActivity != null) {
        break label60;
      }
    }
    label60:
    while (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      return;
      localObject = paramSubAccountBaseActivity.getClass().getSimpleName();
      break;
    }
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      localObject = (QQCustomDialog)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localObject == null) || (((QQCustomDialog)localObject).getOwnerActivity() != paramSubAccountBaseActivity) || (((QQCustomDialog)localObject).isShowing())) {}
      try
      {
        ((QQCustomDialog)localObject).dismiss();
        label116:
        this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
        for (;;)
        {
          i1 -= 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
        }
      }
      catch (Exception localException)
      {
        break label116;
      }
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Pair paramPair, android.content.DialogInterface.OnClickListener paramOnClickListener)
  {
    // Byte code:
    //   0: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +116 -> 119
    //   6: new 135	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 868
    //   16: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 9
    //   21: aload_3
    //   22: ifnonnull +115 -> 137
    //   25: ldc_w 413
    //   28: astore 8
    //   30: aload 9
    //   32: aload 8
    //   34: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 870
    //   40: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 9
    //   45: aload_2
    //   46: ifnonnull +129 -> 175
    //   49: ldc_w 413
    //   52: astore 8
    //   54: aload 9
    //   56: aload 8
    //   58: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 872
    //   64: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: astore 9
    //   69: aload_1
    //   70: ifnonnull +117 -> 187
    //   73: ldc_w 413
    //   76: astore 8
    //   78: aload 9
    //   80: aload 8
    //   82: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 874
    //   88: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore 9
    //   93: aload 4
    //   95: ifnonnull +100 -> 195
    //   98: ldc_w 413
    //   101: astore 8
    //   103: ldc 133
    //   105: iconst_2
    //   106: aload 9
    //   108: aload 8
    //   110: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_1
    //   120: ifnull +16 -> 136
    //   123: aload_2
    //   124: ifnull +12 -> 136
    //   127: aload_3
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: ifnonnull +70 -> 203
    //   136: return
    //   137: new 135	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   144: aload_3
    //   145: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   148: checkcast 227	java/lang/String
    //   151: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 876
    //   157: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_3
    //   161: getfield 357	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   164: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 8
    //   172: goto -142 -> 30
    //   175: aload_2
    //   176: invokevirtual 522	java/lang/Object:getClass	()Ljava/lang/Class;
    //   179: invokevirtual 527	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   182: astore 8
    //   184: goto -130 -> 54
    //   187: ldc_w 878
    //   190: astore 8
    //   192: goto -114 -> 78
    //   195: ldc_w 878
    //   198: astore 8
    //   200: goto -97 -> 103
    //   203: aload_3
    //   204: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   207: checkcast 227	java/lang/String
    //   210: astore 8
    //   212: aload_3
    //   213: getfield 357	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   216: checkcast 351	java/lang/Integer
    //   219: invokevirtual 354	java/lang/Integer:intValue	()I
    //   222: istore 6
    //   224: aload_0
    //   225: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   228: invokeinterface 661 1 0
    //   233: aload_0
    //   234: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   237: ifnull +141 -> 378
    //   240: aload_0
    //   241: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   244: invokevirtual 409	java/util/ArrayList:size	()I
    //   247: iconst_1
    //   248: isub
    //   249: istore 5
    //   251: iload 5
    //   253: iflt +125 -> 378
    //   256: aload_0
    //   257: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   260: iload 5
    //   262: invokevirtual 664	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   265: checkcast 540	com/tencent/mobileqq/utils/QQCustomDialog
    //   268: astore 10
    //   270: aload 10
    //   272: ifnull +298 -> 570
    //   275: aload 10
    //   277: invokevirtual 881	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   280: instanceof 185
    //   283: ifeq +287 -> 570
    //   286: aload 10
    //   288: invokevirtual 881	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   291: checkcast 185	com/tencent/util/Pair
    //   294: astore 9
    //   296: aload 8
    //   298: aload 9
    //   300: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   303: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq +264 -> 570
    //   309: aload 10
    //   311: invokevirtual 862	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   314: istore 7
    //   316: iload 7
    //   318: ifeq +8 -> 326
    //   321: aload 10
    //   323: invokevirtual 865	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   326: aload_0
    //   327: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   330: iload 5
    //   332: invokevirtual 670	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   335: pop
    //   336: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +231 -> 570
    //   342: ldc 133
    //   344: iconst_2
    //   345: new 135	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 883
    //   355: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 9
    //   360: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   363: checkcast 227	java/lang/String
    //   366: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto +195 -> 570
    //   378: aload_2
    //   379: ldc_w 528
    //   382: invokevirtual 531	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   385: astore 10
    //   387: aload_1
    //   388: aload 8
    //   390: iconst_0
    //   391: invokestatic 291	com/tencent/mobileqq/utils/ContactUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   394: astore 9
    //   396: aload 9
    //   398: ifnull +181 -> 579
    //   401: aload 9
    //   403: astore_1
    //   404: aload 9
    //   406: invokevirtual 266	java/lang/String:length	()I
    //   409: ifne +6 -> 415
    //   412: goto +167 -> 579
    //   415: iload 6
    //   417: ifne +117 -> 534
    //   420: aload_2
    //   421: ldc_w 338
    //   424: iconst_1
    //   425: anewarray 4	java/lang/Object
    //   428: dup
    //   429: iconst_0
    //   430: aload_1
    //   431: aastore
    //   432: invokevirtual 533	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   435: astore_1
    //   436: aload_2
    //   437: sipush 230
    //   440: invokestatic 538	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   443: aload 10
    //   445: invokevirtual 544	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   448: aload_1
    //   449: invokevirtual 548	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   452: astore_1
    //   453: aload_1
    //   454: aload_3
    //   455: invokevirtual 886	com/tencent/mobileqq/utils/QQCustomDialog:setTag	(Ljava/lang/Object;)V
    //   458: aload_1
    //   459: aload_2
    //   460: invokevirtual 552	com/tencent/mobileqq/utils/QQCustomDialog:setOwnerActivity	(Landroid/app/Activity;)V
    //   463: aload_1
    //   464: aload_2
    //   465: ldc_w 553
    //   468: invokevirtual 531	com/tencent/mobileqq/app/BaseActivity:getString	(I)Ljava/lang/String;
    //   471: aload 4
    //   473: invokevirtual 561	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   476: pop
    //   477: aload_1
    //   478: new 888	jxy
    //   481: dup
    //   482: aload_0
    //   483: aload 8
    //   485: iload 6
    //   487: invokespecial 891	jxy:<init>	(Lcom/tencent/mobileqq/subaccount/SubAccountControll;Ljava/lang/String;I)V
    //   490: invokevirtual 895	com/tencent/mobileqq/utils/QQCustomDialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   493: aload_1
    //   494: invokevirtual 568	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   497: aload_0
    //   498: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   501: ifnonnull +14 -> 515
    //   504: aload_0
    //   505: new 401	java/util/ArrayList
    //   508: dup
    //   509: invokespecial 402	java/util/ArrayList:<init>	()V
    //   512: putfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   515: aload_0
    //   516: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   519: aload_1
    //   520: invokevirtual 405	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   523: pop
    //   524: aload_0
    //   525: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   528: invokeinterface 673 1 0
    //   533: return
    //   534: aload_2
    //   535: ldc_w 896
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload_1
    //   545: aastore
    //   546: invokevirtual 533	com/tencent/mobileqq/app/BaseActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   549: astore_1
    //   550: goto -114 -> 436
    //   553: astore_1
    //   554: aload_0
    //   555: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   558: invokeinterface 673 1 0
    //   563: aload_1
    //   564: athrow
    //   565: astore 10
    //   567: goto -241 -> 326
    //   570: iload 5
    //   572: iconst_1
    //   573: isub
    //   574: istore 5
    //   576: goto -325 -> 251
    //   579: aload 8
    //   581: astore_1
    //   582: goto -167 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	SubAccountControll
    //   0	585	1	paramQQAppInterface	QQAppInterface
    //   0	585	2	paramBaseActivity	BaseActivity
    //   0	585	3	paramPair	Pair
    //   0	585	4	paramOnClickListener	android.content.DialogInterface.OnClickListener
    //   249	326	5	i1	int
    //   222	264	6	i2	int
    //   314	3	7	bool	boolean
    //   28	552	8	str	String
    //   19	386	9	localObject1	Object
    //   268	176	10	localObject2	Object
    //   565	1	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   233	251	553	finally
    //   256	270	553	finally
    //   275	316	553	finally
    //   321	326	553	finally
    //   326	375	553	finally
    //   378	396	553	finally
    //   404	412	553	finally
    //   420	436	553	finally
    //   436	515	553	finally
    //   515	524	553	finally
    //   534	550	553	finally
    //   321	326	565	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 133
    //   8: iconst_2
    //   9: new 135	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 899
    //   19: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 501
    //   29: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_1
    //   43: ifnull +11 -> 54
    //   46: aload_1
    //   47: invokevirtual 266	java/lang/String:length	()I
    //   50: iconst_5
    //   51: if_icmpge +4 -> 55
    //   54: return
    //   55: aload_0
    //   56: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   59: invokeinterface 661 1 0
    //   64: aload_0
    //   65: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: ifnull +253 -> 321
    //   71: aload_0
    //   72: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   75: invokevirtual 409	java/util/ArrayList:size	()I
    //   78: iconst_1
    //   79: isub
    //   80: istore 5
    //   82: iload 5
    //   84: iflt +237 -> 321
    //   87: aload_0
    //   88: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   91: iload 5
    //   93: invokevirtual 664	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   96: checkcast 540	com/tencent/mobileqq/utils/QQCustomDialog
    //   99: astore 7
    //   101: aload 7
    //   103: ifnull +162 -> 265
    //   106: aload 7
    //   108: invokevirtual 881	com/tencent/mobileqq/utils/QQCustomDialog:getTag	()Ljava/lang/Object;
    //   111: astore 8
    //   113: aload 8
    //   115: ifnull +193 -> 308
    //   118: aload 8
    //   120: instanceof 185
    //   123: ifeq +185 -> 308
    //   126: aload 8
    //   128: checkcast 185	com/tencent/util/Pair
    //   131: astore 8
    //   133: iload_3
    //   134: ifeq +156 -> 290
    //   137: aload_1
    //   138: aload 8
    //   140: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   143: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +190 -> 336
    //   149: iload_2
    //   150: aload 8
    //   152: getfield 357	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   155: checkcast 351	java/lang/Integer
    //   158: invokevirtual 354	java/lang/Integer:intValue	()I
    //   161: if_icmpne +175 -> 336
    //   164: iconst_1
    //   165: istore 4
    //   167: iload 4
    //   169: ifeq +173 -> 342
    //   172: aload 7
    //   174: invokevirtual 862	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   177: istore 6
    //   179: iload 6
    //   181: ifeq +8 -> 189
    //   184: aload 7
    //   186: invokevirtual 865	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   189: aload_0
    //   190: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   193: iload 5
    //   195: invokevirtual 670	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   198: pop
    //   199: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +140 -> 342
    //   205: ldc 133
    //   207: iconst_2
    //   208: new 135	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 901
    //   218: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 8
    //   223: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   226: checkcast 227	java/lang/String
    //   229: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 501
    //   235: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 8
    //   240: getfield 357	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   243: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: ldc_w 903
    //   249: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_3
    //   253: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto +80 -> 342
    //   265: aload_0
    //   266: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   269: iload 5
    //   271: invokevirtual 670	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   274: pop
    //   275: goto +67 -> 342
    //   278: astore_1
    //   279: aload_0
    //   280: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   283: invokeinterface 673 1 0
    //   288: aload_1
    //   289: athrow
    //   290: aload_1
    //   291: aload 8
    //   293: getfield 349	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   296: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +37 -> 336
    //   302: iconst_1
    //   303: istore 4
    //   305: goto -138 -> 167
    //   308: aload_0
    //   309: getfield 855	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   312: iload 5
    //   314: invokevirtual 670	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   317: pop
    //   318: goto +24 -> 342
    //   321: aload_0
    //   322: getfield 78	com/tencent/mobileqq/subaccount/SubAccountControll:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   325: invokeinterface 673 1 0
    //   330: return
    //   331: astore 7
    //   333: goto -144 -> 189
    //   336: iconst_0
    //   337: istore 4
    //   339: goto -172 -> 167
    //   342: iload 5
    //   344: iconst_1
    //   345: isub
    //   346: istore 5
    //   348: goto -266 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	SubAccountControll
    //   0	351	1	paramString	String
    //   0	351	2	paramInt	int
    //   0	351	3	paramBoolean	boolean
    //   165	173	4	i1	int
    //   80	267	5	i2	int
    //   177	3	6	bool	boolean
    //   99	86	7	localQQCustomDialog	QQCustomDialog
    //   331	1	7	localException	Exception
    //   111	181	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   64	82	278	finally
    //   87	101	278	finally
    //   106	113	278	finally
    //   118	133	278	finally
    //   137	164	278	finally
    //   172	179	278	finally
    //   184	189	278	finally
    //   189	262	278	finally
    //   265	275	278	finally
    //   290	302	278	finally
    //   308	318	278	finally
    //   184	189	331	java/lang/Exception
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("launchTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject);
      }
    }
    else
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break label65;
      }
    }
    label65:
    do
    {
      return;
      localObject = Boolean.valueOf(paramQQAppInterface.isRunning());
      break;
      d(paramQQAppInterface);
      if (this.jdField_a_of_type_JavaUtilTimerTask == null) {
        this.jdField_a_of_type_JavaUtilTimerTask = new jya(this, paramQQAppInterface);
      }
      ThreadManager.a().schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.c * 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "launchTimedMsgTask() schedule msgTimer after " + this.c + "*1000 ms.");
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("cancelTimedMsgTask() app.isRunning=");
      if (paramQQAppInterface == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject);
      }
    }
    else
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.isRunning())) {
        break label65;
      }
    }
    label65:
    while (this.jdField_a_of_type_JavaUtilTimerTask == null)
    {
      return;
      localObject = Boolean.valueOf(paramQQAppInterface.isRunning());
      break;
    }
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    ThreadManager.a().purge();
    this.jdField_a_of_type_JavaUtilTimerTask = null;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          QQCustomDialog localQQCustomDialog = (QQCustomDialog)localIterator.next();
          try
          {
            if (localQQCustomDialog.isShowing()) {
              localQQCustomDialog.dismiss();
            }
          }
          catch (Exception localException) {}
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      this.jdField_a_of_type_JavaUtilArrayList = null;
      if (this.b != null) {
        this.b.clear();
      }
      this.b = null;
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      if (this.jdField_a_of_type_JavaUtilTimerTask != null)
      {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
        ThreadManager.a().purge();
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControll
 * JD-Core Version:    0.7.0.1
 */