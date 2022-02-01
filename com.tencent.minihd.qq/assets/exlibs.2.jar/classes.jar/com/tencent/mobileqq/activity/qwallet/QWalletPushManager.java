package com.tencent.mobileqq.activity.qwallet;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import gto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66.MsgBody;

public class QWalletPushManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 6;
  
  static
  {
    a = new ArrayList();
  }
  
  public static int a()
  {
    if (a == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < a.size(); j = k)
    {
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
      k = j;
      if (localPCPayData != null)
      {
        k = j;
        if (localPCPayData.f == 0) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 9;
    case 2: 
      return 4;
    case 3: 
      return 11;
    case 4: 
      return 8;
    case 5: 
      return 7;
    }
    return 6;
  }
  
  private static QWalletPushManager.PCPayData a()
  {
    Object localObject;
    if (a == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= a.size()) {
        break label54;
      }
      QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.f == 1) {
          break;
        }
      }
      i += 1;
    }
    label54:
    return null;
  }
  
  public static QWalletPushManager.PCPayData a(boolean paramBoolean)
  {
    Object localObject;
    if (a == null)
    {
      localObject = null;
      return localObject;
    }
    QWalletPushManager.PCPayData localPCPayData;
    if (paramBoolean)
    {
      i = a.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label101;
        }
        localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
        if (localPCPayData != null)
        {
          localObject = localPCPayData;
          if (localPCPayData.f == 0) {
            break;
          }
        }
        i -= 1;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i >= a.size()) {
        break label101;
      }
      localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
      if (localPCPayData != null)
      {
        localObject = localPCPayData;
        if (localPCPayData.f == 0) {
          break;
        }
      }
      i += 1;
    }
    label101:
    return null;
  }
  
  public static void a()
  {
    if (a == null) {}
    for (;;)
    {
      return;
      int i = a.size() - 1;
      while (i >= 0)
      {
        QWalletPushManager.PCPayData localPCPayData = (QWalletPushManager.PCPayData)a.get(i);
        if ((localPCPayData == null) || (localPCPayData.f == 1)) {
          a.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, QWalletPushManager.PCPayData paramPCPayData)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null) || (paramPCPayData == null)) {}
    Object localObject1;
    do
    {
      return;
      String str = String.format(BaseApplication.getContext().getString(2131365067), new Object[] { Integer.valueOf(a()) });
      localObject1 = paramPCPayData.jdField_c_of_type_JavaLangString;
      paramPCPayData = (QWalletPushManager.PCPayData)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramPCPayData = BaseApplication.getContext().getString(2131365068);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("callbackSn", "0");
      ((Bundle)localObject1).putBoolean("payparmas_from_pcpush", true);
      ((Bundle)localObject1).putInt("pay_requestcode", 12);
      Object localObject2 = new Intent(paramQQAppInterface.a(), PayBridgeActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      localObject2 = PendingIntent.getActivity(paramQQAppInterface.a(), 12, (Intent)localObject2, 1073741824);
      localObject1 = new Notification(2130838569, str, System.currentTimeMillis());
      ((Notification)localObject1).flags = 16;
      ((Notification)localObject1).setLatestEventInfo(paramQQAppInterface.a(), str, paramPCPayData, (PendingIntent)localObject2);
      paramQQAppInterface = (NotificationManager)paramQQAppInterface.a().getSystemService("notification");
    } while (paramQQAppInterface == null);
    paramQQAppInterface.cancel(128);
    paramQQAppInterface.notify(128, (Notification)localObject1);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String arg1)
  {
    if (TextUtils.isEmpty(???)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "PCPayData is empty.");
      }
    }
    while ((paramQQAppInterface == null) || (a == null)) {
      return;
    }
    for (;;)
    {
      QWalletPushManager.PCPayData localPCPayData;
      try
      {
        localPCPayData = new QWalletPushManager.PCPayData();
        localPCPayData.jdField_b_of_type_Long = System.currentTimeMillis();
        ??? = new JSONObject(???);
        localPCPayData.a = ???.optLong("tradeTime", 0L);
        localPCPayData.d = ???.optInt("expTime", 0);
        localPCPayData.e = ???.optInt("payType", 0);
        localPCPayData.jdField_c_of_type_JavaLangString = ???.optString("notifyText");
        ??? = ???.optJSONObject("payData");
        if (??? != null) {
          localPCPayData.jdField_b_of_type_JavaLangString = ???.toString();
        }
        if ((localPCPayData.e < 1) || (localPCPayData.e > 6) || (TextUtils.isEmpty(localPCPayData.jdField_b_of_type_JavaLangString))) {
          break;
        }
        synchronized (a)
        {
          a.add(localPCPayData);
          if (!b(paramQQAppInterface)) {
            break label198;
          }
          b(paramQQAppInterface);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      QLog.d("Q.qwallet.push", 2, "Parsing PCPAYDATA throws JSONException.");
      return;
      label198:
      a(paramQQAppInterface, localPCPayData);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      break label4;
    }
    label4:
    while (a(false) == null) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 5;; i = 1000)
    {
      Handler localHandler = ThreadManager.b();
      if (localHandler == null) {
        break;
      }
      localHandler.postDelayed(new gto(paramBoolean, paramQQAppInterface), i);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = null;
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfByte = (submsgtype0x66.MsgBody)new submsgtype0x66.MsgBody().mergeFrom(paramArrayOfByte);
        if (!paramArrayOfByte.uint32_type.has()) {
          break label197;
        }
        i = paramArrayOfByte.uint32_type.get();
      }
      catch (Exception paramArrayOfByte)
      {
        i = -1;
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = localObject;
        int j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qwallet.push", 2, "Parsing Msg0x210Sub0x66 data throws Exception.");
        paramArrayOfByte = localObject;
        j = i;
        continue;
        try
        {
          a(paramQQAppInterface, new String(paramArrayOfByte, "UTF-8"));
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
      }
      try
      {
        if (!paramArrayOfByte.bytes_push_data.has()) {
          break label192;
        }
        paramArrayOfByte = paramArrayOfByte.bytes_push_data.get();
        if (paramArrayOfByte == null) {
          break label192;
        }
        paramArrayOfByte = paramArrayOfByte.toByteArray();
      }
      catch (Exception paramArrayOfByte)
      {
        continue;
        label192:
        paramArrayOfByte = null;
        continue;
      }
      j = i;
      if ((j == -1) || (paramArrayOfByte == null)) {
        break;
      }
      switch (j)
      {
      default: 
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qwallet.push", 2, "Unknow pushType.");
        return;
      case 1: 
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qwallet.push", 2, "Coverting pushData to String throws Exception.");
        return;
        label197:
        i = -1;
      }
    }
  }
  
  public static void b()
  {
    if (a == null) {
      return;
    }
    a.clear();
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    if ((paramQQAppInterface == null) || (a == null)) {}
    label320:
    label323:
    for (;;)
    {
      return;
      QWalletPushManager.PCPayData localPCPayData = a();
      int i;
      boolean bool2;
      if (localPCPayData == null)
      {
        if (a.size() <= 0) {
          continue;
        }
        localPCPayData = (QWalletPushManager.PCPayData)a.get(0);
        if (localPCPayData == null)
        {
          a.remove(0);
          b(paramQQAppInterface);
          return;
        }
        i = a(localPCPayData.e);
        if (i == 0)
        {
          a.remove(0);
          b(paramQQAppInterface);
          return;
        }
        bool2 = PayBridgeActivity.a();
        if ((!bool2) || (QWalletHelper.a(paramQQAppInterface.getApplication().getApplicationContext()))) {
          break label320;
        }
      }
      for (;;)
      {
        if (bool1) {
          break label323;
        }
        try
        {
          localPCPayData.f = 1;
          paramQQAppInterface = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
          paramQQAppInterface.addFlags(268435456);
          Bundle localBundle = new Bundle();
          localBundle.putString("json", localPCPayData.jdField_b_of_type_JavaLangString);
          localBundle.putString("callbackSn", "0");
          localBundle.putBoolean("payparmas_from_pcpush", true);
          paramQQAppInterface.addFlags(67108864);
          paramQQAppInterface.addFlags(536870912);
          paramQQAppInterface.putExtras(localBundle);
          paramQQAppInterface.putExtra("pay_requestcode", i);
          BaseApplication.getContext().startActivity(paramQQAppInterface);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          localPCPayData.f = 2;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qwallet.push", 2, "Starting pay throws Exception.");
        return;
        bool2 = PayBridgeActivity.a();
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!QWalletHelper.a(paramQQAppInterface.getApplication().getApplicationContext())) {
            bool1 = false;
          }
        }
        bool2 = bool1;
        if (bool1)
        {
          long l = System.currentTimeMillis();
          bool2 = bool1;
          if (43200L * 1000L + localPCPayData.jdField_c_of_type_Long > l) {
            bool2 = false;
          }
        }
        if (bool2) {
          break;
        }
        localPCPayData.f = 2;
        b(paramQQAppInterface);
        return;
        bool1 = bool2;
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!paramQQAppInterface.isBackground_Pause) {
      return true;
    }
    try
    {
      paramQQAppInterface = BaseApplicationImpl.a();
      if (paramQQAppInterface == null) {
        return false;
      }
      Object localObject = (ActivityManager)paramQQAppInterface.getApplicationContext().getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      paramQQAppInterface = paramQQAppInterface.getApplicationContext().getPackageName();
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName != null))
        {
          if (localRunningAppProcessInfo.processName.equals(paramQQAppInterface + ":video")) {
            return false;
          }
          if (!localRunningAppProcessInfo.processName.equals(paramQQAppInterface))
          {
            boolean bool = localRunningAppProcessInfo.processName.startsWith(paramQQAppInterface + ":");
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletPushManager
 * JD-Core Version:    0.7.0.1
 */