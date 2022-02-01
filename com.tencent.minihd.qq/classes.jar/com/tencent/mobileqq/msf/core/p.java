package com.tencent.mobileqq.msf.core;

import LBS.LBSInfo;
import LBS.Wifi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.push.f;
import com.tencent.msf.service.protocol.QQWiFi.WiFiService;
import com.tencent.msf.service.protocol.QQWiFi.a;
import com.tencent.msf.service.protocol.QQWiFi.b;
import com.tencent.msf.service.protocol.QQWiFi.d;
import com.tencent.msf.service.protocol.QQWiFi.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class p
{
  public static final int A = 4;
  public static final int B = 5;
  public static final int C = 1;
  public static final int D = 2;
  private static final String E = "QQWiFiScanManager";
  private static p F;
  public static final String a = "mobileqq.service";
  public static final String b = "MQQ.QQWiFiMgrServer.QQWiFiMgrObj";
  public static final String c = "AvailQQWiFiForMSF";
  public static final String d = "QQWifiSvc.AvailQQWiFiForMSF";
  public static final String e = "MQQ.WiFiMapServer.WiFiMapObj";
  public static final String f = "getNearbyAvailWiFiInfo";
  public static final String g = "QQWifiSvc.getNearbyAvailWiFiInfo";
  public static final long h = 25000L;
  public static final int i = 4097;
  public static final int j = 4098;
  public static final int k = 4099;
  public static final int l = 4100;
  public static final int m = 4101;
  public static final int n = 4102;
  public static final int o = 4103;
  public static final int p = -80;
  public static final int q = 20000;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 4;
  public static final int u = 1;
  public static final int v = -1;
  public static final int w = 0;
  public static final int x = 1;
  public static final int y = 2;
  public static final int z = 3;
  private MsfCore G;
  private Context H = BaseApplication.getContext();
  private a I = new a(null);
  private Notification J;
  private int K = 0;
  private String L = "";
  private RemoteViews M;
  private LBSInfo N;
  private long O = 0L;
  private long P = 0L;
  private long Q = 0L;
  private long R = 0L;
  private List S = Collections.synchronizedList(new ArrayList());
  private List T = Collections.synchronizedList(new ArrayList());
  private List U = Collections.synchronizedList(new ArrayList());
  private List V = Collections.synchronizedList(new ArrayList());
  private boolean W;
  private boolean X = false;
  private boolean Y = false;
  private boolean Z = true;
  private boolean aa = false;
  private final BroadcastReceiver ab = new q(this);
  
  private p()
  {
    f();
  }
  
  public static p a()
  {
    if (F == null) {
      F = new p();
    }
    return F;
  }
  
  private Map a(Context paramContext)
  {
    try
    {
      paramContext = a(new File(paramContext.getDir("qqwifi_dir", 0), "params_file"));
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
      paramContext = new JSONObject(paramContext);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramContext.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramContext.getString(str));
      }
      return localHashMap;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
  }
  
  private void a(int paramInt)
  {
    int i1 = 0;
    Object localObject2;
    switch (paramInt)
    {
    default: 
    case 0: 
    case 2: 
    case 1: 
      do
      {
        do
        {
          for (;;)
          {
            return;
            Object localObject1 = new File(this.H.getDir("qqwifi_dir", 0), "enable_file");
            if (((File)localObject1).exists()) {
              try
              {
                localObject1 = new JSONObject(a((File)localObject1));
                if (((JSONObject)localObject1).has("mIsQQWiFiEnable_" + this.I.c)) {
                  this.I.b = ((JSONObject)localObject1).getBoolean("mIsQQWiFiEnable_" + this.I.c);
                }
                if (QLog.isColorLevel())
                {
                  QLog.d("QQWiFiScanManager", 2, "updateConfig, mIsQQWiFiEnable_" + this.I.c + "=" + this.I.b);
                  return;
                }
              }
              catch (Exception localException1) {}
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQWiFiScanManager", 2, "updateConfig, enable_file exception");
        return;
        localObject2 = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (paramInt = 4;; paramInt = 0)
        {
          localObject2 = ((Context)localObject2).getSharedPreferences("mobileQQ", paramInt);
          if (localObject2 == null) {
            break;
          }
          this.I.d = ((SharedPreferences)localObject2).getInt("bar_switch_operation" + this.I.c, 0);
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "updateConfig, BarSwitch=" + this.I.d);
          }
          if (this.I.d != 1) {
            break;
          }
          this.X = false;
          this.K = 0;
          return;
        }
        localObject2 = new File(this.H.getDir("qqwifi_dir", 0), "ssids_file");
      } while (!((File)localObject2).exists());
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(a((File)localObject2)).getJSONArray("ssidList");
        localObject2 = "";
        int i2 = localJSONArray.length();
        paramInt = i1;
        if (paramInt < localJSONArray.length())
        {
          String str = (String)localObject2 + localJSONArray.get(paramInt).toString();
          localObject2 = str;
          if (paramInt >= i2 - 1) {
            break label581;
          }
          localObject2 = str + "|";
          break label581;
        }
        this.I.a = ((String)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQWiFiScanManager", 2, "updateConfig, pattern - " + (String)localObject2);
        return;
      }
      catch (Exception localException2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, "updateConfig, ssids_file exception");
      return;
      v();
      return;
      b(null);
      return;
      a(null);
      return;
      label581:
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = BaseApplication.getContext();
    String str = this.I.c;
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences(str, i1);
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    paramInt = ((SharedPreferences)localObject).getInt("showQQWiFiNotifyCount", 0);
    ((SharedPreferences)localObject).edit().putInt("showQQWiFiNotifyCount", paramInt + 1).commit();
    return;
    ((SharedPreferences)localObject).edit().putInt("QQWiFiShowRedTouch", paramBundle.getInt("id")).commit();
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt != 4097) && (!this.X)) {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "pushNotification," + paramInt + ", first push must be available qqwifi notification");
      }
    }
    do
    {
      boolean bool;
      do
      {
        return;
        bool = b(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "pushNotification, " + bool);
        }
      } while ((!bool) && (!paramBoolean2));
      a(paramInt, paramString, paramBoolean1);
      this.K = paramInt;
      this.L = paramString;
    } while (paramInt != 4097);
    this.X = true;
  }
  
  private void a(Intent paramIntent, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
    if (this.M == null) {
      this.M = new RemoteViews(BaseApplication.getContext().getPackageName(), BaseApplication.qqWifiLayout);
    }
    Object localObject;
    int i1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.M.setImageViewResource(BaseApplication.qqWifiSettingViewId, BaseApplication.qqWifiSettings);
      this.M.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 8);
      localObject = new Intent("com.tencent.mobileqq.msf.qqwifi.settings");
      ((Intent)localObject).putExtras(new Bundle());
      ((Intent)localObject).addFlags(603979776);
      localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, (Intent)localObject, 134217728);
      this.M.setOnClickPendingIntent(BaseApplication.qqWifiSettingViewId, (PendingIntent)localObject);
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label627;
      }
      i1 = 4;
      localObject = ((Context)localObject).getSharedPreferences("qqwifi", i1);
      i1 = ((SharedPreferences)localObject).getInt("BarOperation_id", 0);
      if (i1 != 0)
      {
        boolean bool = ((SharedPreferences)localObject).getBoolean(this.I.c + "hasClicked" + i1, false);
        long l1 = ((SharedPreferences)localObject).getLong("BarOperation_expiry", 0L);
        if ((!bool) && (System.currentTimeMillis() < l1 * 1000L))
        {
          int i2 = ((SharedPreferences)localObject).getInt("BarOperation_type", 0);
          localObject = ((SharedPreferences)localObject).getString("BarOperation_url", "");
          Intent localIntent = new Intent("com.tencent.mobileqq.msf.qqwifi.redtouch");
          localIntent.putExtra("type", i2);
          localIntent.putExtra("url", (String)localObject);
          localIntent.putExtra("id", i1);
          localIntent.addFlags(603979776);
          localObject = PendingIntent.getActivity(BaseApplication.getContext(), 0, localIntent, 134217728);
          this.M.setOnClickPendingIntent(BaseApplication.qqWifiRedTouchViewId, (PendingIntent)localObject);
          this.M.setImageViewResource(BaseApplication.qqWifiRedTouchViewId, BaseApplication.qqWifiOperation);
          this.M.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 0);
          localObject = new Bundle();
          ((Bundle)localObject).putInt("id", i1);
          a(2, (Bundle)localObject);
        }
      }
    }
    this.M.setImageViewResource(BaseApplication.qqWifiStateIconViewId, paramInt);
    this.M.setTextViewText(BaseApplication.qqWifiStateTextViewId, paramString1);
    this.M.setTextViewText(BaseApplication.qqWifiOperationTextViewId, paramString2);
    if (this.J == null)
    {
      this.J = new Notification();
      if (Build.VERSION.SDK_INT >= 16) {
        this.J.priority = 2;
      }
      localObject = this.J;
      ((Notification)localObject).flags |= 0x20;
      this.J.contentView = this.M;
    }
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), f.B, paramIntent, 0);
    if (BaseApplication.qqWifiNoSignal == paramInt)
    {
      this.J.icon = BaseApplication.qqwifinotifynoneicon;
      label536:
      if (paramString3 == null) {
        break label684;
      }
      this.J.defaults = 1;
    }
    for (this.J.tickerText = paramString3;; this.J.tickerText = "")
    {
      this.J.contentIntent = paramIntent;
      localNotificationManager.notify(f.B, this.J);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, paramString1 + ", " + paramString2 + "," + paramString3);
      }
      return;
      label627:
      i1 = 0;
      break;
      if (BaseApplication.qqWifiUserful == paramInt)
      {
        this.J.icon = BaseApplication.qqwifinotifyusefulicon;
        break label536;
      }
      if (BaseApplication.qqWifiConnecticon3 == paramInt)
      {
        this.J.icon = BaseApplication.qqwifinotifyconnectedicon;
        break label536;
      }
      this.J.icon = paramInt;
      break label536;
      label684:
      this.J.defaults = 0;
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    int i2 = 0;
    Object localObject1 = paramSharedPreferences;
    int i1;
    if (paramSharedPreferences == null)
    {
      paramSharedPreferences = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10)
      {
        i1 = 4;
        localObject1 = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
      }
    }
    else if (localObject1 != null)
    {
      paramSharedPreferences = ((SharedPreferences)localObject1).getString("autoconnect_bssids", "");
      if (!TextUtils.isEmpty(paramSharedPreferences))
      {
        localObject1 = paramSharedPreferences.split("\\|");
        if ((localObject1 != null) && (localObject1.length != 0)) {
          break label143;
        }
        this.V.add(paramSharedPreferences);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "updateConfig, bssidsString=" + paramSharedPreferences + " ssid list=" + this.V.toString());
      }
      return;
      i1 = 0;
      break;
      label143:
      int i3 = localObject1.length;
      i1 = i2;
      while (i1 < i3)
      {
        Object localObject2 = localObject1[i1];
        this.V.add(localObject2);
        i1 += 1;
      }
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "checkAvailForOperation");
    }
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasIntersection=" + bool);
    }
    if (bool) {
      d(paramArrayList);
    }
    Object localObject = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.c < -80) {
        localIterator.remove();
      } else {
        ((List)localObject).add(locald.b);
      }
    }
    if (!a(this.T, (List)localObject))
    {
      e(paramArrayList);
      this.T.clear();
      paramArrayList = ((List)localObject).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        this.T.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForOperation, isSubset=true");
    }
  }
  
  private void a(List paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.isEmpty()) {
          return;
        }
        paramList = new ArrayList(paramList);
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "startAutoConnect services all avail:" + paramList.toString());
        }
        if (!r())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isEnableAutoconnect false,return");
        }
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel())
        {
          paramList.printStackTrace();
          return;
          paramList = d(paramList);
          if ((paramList == null) || (paramList.isEmpty()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect services empty after filtered,return");
            }
          }
          else if (b(paramList))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in time protected,return");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQWiFiScanManager", 2, "startAutoConnect services:" + paramList.toString());
            }
            this.R = System.currentTimeMillis();
            Intent localIntent = new Intent("com.tencent.mobileqq.msf.qqwifi.autoconnect");
            localIntent.putExtra("services", new ArrayList(paramList));
            BaseApplication.getContext().sendBroadcast(localIntent);
          }
        }
      }
    }
  }
  
  private boolean a(LBSInfo paramLBSInfo1, LBSInfo paramLBSInfo2)
  {
    if ((paramLBSInfo1 != null) && (paramLBSInfo2 != null) && (paramLBSInfo1.vWifis != null) && (paramLBSInfo2.vWifis != null))
    {
      HashSet localHashSet = new HashSet();
      paramLBSInfo1 = paramLBSInfo1.vWifis.iterator();
      while (paramLBSInfo1.hasNext())
      {
        Wifi localWifi = (Wifi)paramLBSInfo1.next();
        localHashSet.add("" + localWifi.lMac);
      }
      paramLBSInfo1 = paramLBSInfo2.vWifis.iterator();
      while (paramLBSInfo1.hasNext())
      {
        paramLBSInfo2 = (Wifi)paramLBSInfo1.next();
        if (localHashSet.contains("" + paramLBSInfo2.lMac))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQWiFiScanManager", 2, "isThesameAddr, assumed yesx");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace("\"", "");
      Pattern localPattern = Pattern.compile(this.I.a);
      boolean bool2 = localPattern.matcher(paramString).matches();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQWiFiScanManager", 2, "isQQWiFi, " + localPattern + ", " + paramString + ", " + bool2);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  private boolean a(List paramList1, List paramList2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList1 != null)
    {
      bool1 = bool2;
      if (paramList2 != null)
      {
        Iterator localIterator = paramList2.iterator();
        int i1 = 0;
        while ((localIterator.hasNext()) && (paramList1.contains(localIterator.next()))) {
          i1 += 1;
        }
        bool1 = bool2;
        if (i1 == paramList2.size()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(SharedPreferences paramSharedPreferences)
  {
    SharedPreferences localSharedPreferences = paramSharedPreferences;
    if (paramSharedPreferences == null)
    {
      paramSharedPreferences = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label112;
      }
    }
    label112:
    for (int i1 = 4;; i1 = 0)
    {
      localSharedPreferences = paramSharedPreferences.getSharedPreferences("mobileQQ", i1);
      if (localSharedPreferences != null)
      {
        this.I.l = localSharedPreferences.getInt("autoconnect_switch_operation" + this.I.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "updateConfig, AutoSwitch=" + this.I.l);
        }
      }
      return;
    }
  }
  
  private void b(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "checkAvailForBar");
    }
    boolean bool = c(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasIntersection=" + bool);
    }
    if (bool)
    {
      a(4097, "", false, false);
      d(paramArrayList);
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Object localObject2;
      d locald;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist before filter:" + ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if (((d)localObject2).c < -80) {
          ((Iterator)localObject1).remove();
        } else {
          localArrayList.add(((d)localObject2).b);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locald = (d)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(locald.a + "," + locald.b + "," + locald.c + "|");
        }
        QLog.d("QQWiFiScanManager", 2, "scanlist after filter:" + ((StringBuilder)localObject1).toString());
        QLog.d("QQWiFiScanManager", 2, "bssidSet:" + localArrayList.toString());
      }
      bool = a(this.S, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, isSubset=" + bool);
      }
    } while (bool);
    e(paramArrayList);
    this.S.clear();
    this.S.addAll(localArrayList);
  }
  
  private boolean b(int paramInt)
  {
    if (!this.W)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, not registered.");
      }
      return false;
    }
    if (m())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, bar switch off");
      }
      return false;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.H.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1) && ((paramInt == 4102) || (paramInt == 4097) || (paramInt == 4098)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "canPushNotification, dont push qqwifi info while wifi is connected");
      }
      return false;
    }
    return true;
  }
  
  private boolean b(List paramList)
  {
    boolean bool2 = false;
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences("mobileQQ", i1);
      boolean bool1 = bool2;
      if (localObject != null)
      {
        long l1 = ((SharedPreferences)localObject).getLong("autoconnect_reference_time", 0L);
        long l2 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "isInAutoconnectIntervalProtected lasttime=" + l1 + " interval=" + l2 + " autoConnectProtectedInterval=" + this.I.m);
        }
        bool1 = bool2;
        if (l2 < this.I.m)
        {
          bool1 = bool2;
          if (c(paramList)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
  
  private boolean c(ArrayList paramArrayList)
  {
    if (this.U != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.U.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(((WiFiService)localIterator.next()).wifi.b);
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (localHashSet.contains(((d)paramArrayList.next()).b)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean c(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((WiFiService)paramList.next()).wifi.b);
    }
    int i2 = Math.min(Math.min(localArrayList.size(), this.V.size()), this.I.n);
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "lastAutoBssids=" + this.V.toString() + " curSet:" + localArrayList.toString() + " isSubSet= maxAutoConnecttimes=" + this.I.n + " min=" + i2);
    }
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = (String)localArrayList.get(i1);
      if (this.V.contains(paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, "return true:" + paramList + "has already tryed i=" + i1);
        }
        return true;
      }
      i1 += 1;
    }
    i();
    return false;
  }
  
  private List d(List paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      WiFiService localWiFiService = (WiFiService)paramList.next();
      if ((localWiFiService.autoConnFlag == 1) && (localArrayList.size() < this.I.n)) {
        localArrayList.add(localWiFiService);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "after filtered:" + localArrayList.toString());
    }
    return localArrayList;
  }
  
  private void d(ArrayList paramArrayList)
  {
    if (r())
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.U.iterator();
      while (localIterator.hasNext())
      {
        WiFiService localWiFiService = (WiFiService)localIterator.next();
        if (localWiFiService.autoConnFlag == 1) {
          localHashSet.add(localWiFiService.wifi.b);
        }
      }
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
      } while (!localHashSet.contains(((d)paramArrayList.next()).b));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "processWiFiScanResultForBar, hasAutoIntersection=" + bool);
      }
      if (bool) {
        a(this.U);
      }
      return;
    }
  }
  
  private void e(ArrayList paramArrayList)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        this.Q = System.currentTimeMillis();
        int i1 = l();
        if ((i1 | 0x2) > 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "getAvailableQQWifi size:" + paramArrayList.size() + " scanType=" + i1 + " needcallback=" + bool);
          }
          Object localObject = new UniPacket(true);
          ((UniPacket)localObject).setEncodeName("UTF-8");
          a locala = new a();
          locala.a = paramArrayList;
          locala.b = c.f(this.H);
          locala.c = "Android";
          locala.d = i1;
          ((UniPacket)localObject).setServantName("MQQ.QQWiFiMgrServer.QQWiFiMgrObj");
          ((UniPacket)localObject).setFuncName("AvailQQWiFiForMSF");
          ((UniPacket)localObject).put("req", locala);
          paramArrayList = ((UniPacket)localObject).encode();
          localObject = new ToServiceMsg("mobileqq.service", this.I.c, "QQWifiSvc.AvailQQWiFiForMSF");
          ((ToServiceMsg)localObject).setAppId(this.G.sender.i());
          ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
          ((ToServiceMsg)localObject).setTimeout(20000L);
          ((ToServiceMsg)localObject).setNeedCallback(bool);
          ((ToServiceMsg)localObject).putWupBuffer(paramArrayList);
          ((ToServiceMsg)localObject).addAttribute("isformsf", Boolean.valueOf(true));
          this.G.sendSsoMsg((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQWiFiScanManager", 2, "getAvailableQQWifi exp:" + paramArrayList);
      }
    }
  }
  
  private void f()
  {
    h();
    g();
    v();
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 162	com/tencent/mobileqq/msf/core/p:H	Landroid/content/Context;
    //   4: ldc 181
    //   6: iconst_0
    //   7: invokevirtual 187	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   10: astore_3
    //   11: new 179	java/io/File
    //   14: dup
    //   15: aload_3
    //   16: ldc 241
    //   18: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 244	java/io/File:exists	()Z
    //   28: ifeq +142 -> 170
    //   31: new 203	org/json/JSONObject
    //   34: dup
    //   35: aload_0
    //   36: aload 4
    //   38: invokevirtual 195	com/tencent/mobileqq/msf/core/p:a	(Ljava/io/File;)Ljava/lang/String;
    //   41: invokespecial 206	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload 4
    //   48: new 246	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   55: ldc 249
    //   57: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   64: getfield 255	com/tencent/mobileqq/msf/core/p$a:c	Ljava/lang/String;
    //   67: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 263	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   76: ifeq +94 -> 170
    //   79: aload_0
    //   80: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   83: aload 4
    //   85: new 246	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   92: ldc 249
    //   94: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   101: getfield 255	com/tencent/mobileqq/msf/core/p$a:c	Ljava/lang/String;
    //   104: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokevirtual 266	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   113: putfield 268	com/tencent/mobileqq/msf/core/p$a:b	Z
    //   116: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +51 -> 170
    //   122: ldc 20
    //   124: iconst_2
    //   125: new 246	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 929
    //   135: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_0
    //   139: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   142: getfield 255	com/tencent/mobileqq/msf/core/p$a:c	Ljava/lang/String;
    //   145: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 277
    //   151: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   158: getfield 268	com/tencent/mobileqq/msf/core/p$a:b	Z
    //   161: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: new 179	java/io/File
    //   173: dup
    //   174: aload_3
    //   175: ldc_w 315
    //   178: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   181: astore_3
    //   182: aload_3
    //   183: invokevirtual 244	java/io/File:exists	()Z
    //   186: ifeq +170 -> 356
    //   189: new 203	org/json/JSONObject
    //   192: dup
    //   193: aload_0
    //   194: aload_3
    //   195: invokevirtual 195	com/tencent/mobileqq/msf/core/p:a	(Ljava/io/File;)Ljava/lang/String;
    //   198: invokespecial 206	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   201: ldc_w 317
    //   204: invokevirtual 321	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   207: astore 5
    //   209: aload 5
    //   211: invokevirtual 327	org/json/JSONArray:length	()I
    //   214: istore_2
    //   215: ldc 112
    //   217: astore_3
    //   218: iconst_0
    //   219: istore_1
    //   220: iload_1
    //   221: aload 5
    //   223: invokevirtual 327	org/json/JSONArray:length	()I
    //   226: if_icmpge +90 -> 316
    //   229: new 246	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   236: aload_3
    //   237: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 5
    //   242: iload_1
    //   243: invokevirtual 331	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   246: invokevirtual 332	java/lang/Object:toString	()Ljava/lang/String;
    //   249: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: astore 4
    //   257: aload 4
    //   259: astore_3
    //   260: iload_1
    //   261: iload_2
    //   262: iconst_1
    //   263: isub
    //   264: if_icmpge +25 -> 289
    //   267: new 246	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   274: aload 4
    //   276: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 334
    //   282: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_3
    //   289: iload_1
    //   290: iconst_1
    //   291: iadd
    //   292: istore_1
    //   293: goto -73 -> 220
    //   296: astore 4
    //   298: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -131 -> 170
    //   304: ldc 20
    //   306: iconst_2
    //   307: ldc_w 931
    //   310: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: goto -143 -> 170
    //   316: aload_0
    //   317: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   320: aload_3
    //   321: putfield 336	com/tencent/mobileqq/msf/core/p$a:a	Ljava/lang/String;
    //   324: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +29 -> 356
    //   330: ldc 20
    //   332: iconst_2
    //   333: new 246	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 933
    //   343: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_3
    //   347: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: return
    //   357: astore_3
    //   358: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq -5 -> 356
    //   364: ldc 20
    //   366: iconst_2
    //   367: ldc_w 935
    //   370: invokestatic 287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	p
    //   219	74	1	i1	int
    //   214	50	2	i2	int
    //   10	337	3	localObject1	Object
    //   357	1	3	localException1	Exception
    //   21	254	4	localObject2	Object
    //   296	1	4	localException2	Exception
    //   207	34	5	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   31	170	296	java/lang/Exception
    //   189	215	357	java/lang/Exception
    //   220	257	357	java/lang/Exception
    //   267	289	357	java/lang/Exception
    //   316	356	357	java/lang/Exception
  }
  
  private void h()
  {
    int i2 = 4;
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localObject = ((Context)localObject).getSharedPreferences("Last_Login", i1);
      if (localObject != null)
      {
        this.I.c = ((SharedPreferences)localObject).getString("uin", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "lastLoginUin = " + this.I.c);
        }
      }
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label227;
      }
    }
    label227:
    for (int i1 = i2;; i1 = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences("mobileQQ", i1);
      if (localObject != null)
      {
        this.I.d = ((SharedPreferences)localObject).getInt("bar_switch_operation" + this.I.c, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "initConfig, barOperation=" + this.I.d);
        }
        a((SharedPreferences)localObject);
        b((SharedPreferences)localObject);
      }
      ((SharedPreferences)localObject).edit().putBoolean("hasPushedAvailNotification", false).commit();
      return;
      i1 = 0;
      break;
    }
  }
  
  private void i()
  {
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences("mobileQQ", i1);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().remove("autoconnect_bssids").commit();
      }
      return;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onAccountChange");
    }
    a(0);
    a(2);
    a(4);
    a(3);
    if ((this.W) && (this.X) && (m()))
    {
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(f.B);
      this.X = false;
      this.K = 0;
    }
  }
  
  private boolean k()
  {
    if (this.aa) {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "shouldProcessScanResult isCurUinQuited true, return false");
      }
    }
    label119:
    do
    {
      int i1;
      do
      {
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
                  return false;
                  localObject = BaseApplication.getContext();
                  if (Build.VERSION.SDK_INT > 10) {}
                  for (i1 = 4;; i1 = 0)
                  {
                    localObject = ((Context)localObject).getSharedPreferences("Last_Login", i1).getString("uin", "");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      break label119;
                    }
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("QQWiFiScanManager", 2, "shouldProcessScanResult, uin=" + (String)localObject + ", " + this.I.c);
                    return false;
                  }
                  if (!((String)localObject).equals(this.I.c))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("QQWiFiScanManager", 2, "onAccountChange, " + this.I.c + ", " + (String)localObject);
                    }
                    this.I.c = ((String)localObject);
                    j();
                  }
                  if (this.Z) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("QQWiFiScanManager", 2, "shouldProcessScanResult, isScreenOn = false");
                return false;
                if (this.W) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("QQWiFiScanManager", 2, "shouldProcessScanResult, isRegistered = false");
              return false;
              if (this.I.b) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("QQWiFiScanManager", 2, "shouldProcessScanResult, isQQWifiEnable = false");
            return false;
            localObject = ((ConnectivityManager)this.H.getSystemService("connectivity")).getActiveNetworkInfo();
            if ((localObject == null) || (((NetworkInfo)localObject).getType() != 1)) {
              break;
            }
            WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
            String str = "";
            localObject = str;
            if (localWifiInfo != null)
            {
              localObject = str;
              if (!TextUtils.isEmpty(localWifiInfo.getSSID())) {
                localObject = localWifiInfo.getSSID().replace("\"", "");
              }
            }
          } while (a((String)localObject));
          a(4103, (String)localObject, false, false);
          return false;
          if ((localObject != null) && (((NetworkInfo)localObject).isAvailable())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQWiFiScanManager", 2, "network not active.");
        return false;
        i1 = l();
      } while (i1 <= 0);
      if ((i1 != 2) || (System.currentTimeMillis() - this.Q >= this.I.j)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQWiFiScanManager", 2, "shouldProcessScanResult, operation scan time limit.");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "shouldProcessScanResult, true");
    }
    return true;
  }
  
  private int l()
  {
    int i2 = 0;
    if (!m()) {
      i2 = 1;
    }
    int i1 = i2;
    if (this.I.f) {
      i1 = i2 | 0x2;
    }
    i2 = i1;
    if (n()) {
      i2 = i1 | 0x4;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, "scantype=" + i2);
    }
    return i2;
  }
  
  private boolean m()
  {
    if (this.I.d == 1) {}
    do
    {
      return false;
      if (this.I.d == -1) {
        return true;
      }
    } while (this.I.e);
    return true;
  }
  
  private boolean n()
  {
    if (this.I.l == 1) {}
    do
    {
      return true;
      if (this.I.l == -1) {
        return false;
      }
    } while (this.I.k);
    return false;
  }
  
  private void o()
  {
    boolean bool = k();
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "checkWiFiScanResult, shouldProcessScanResult=" + bool);
    }
    ArrayList localArrayList;
    int i1;
    if (bool)
    {
      this.O = System.currentTimeMillis();
      localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(this.I.a))
      {
        Pattern localPattern = Pattern.compile(this.I.a);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "pattern: " + this.I.a);
        }
        List localList = ((WifiManager)this.H.getSystemService("wifi")).getScanResults();
        if (localList != null)
        {
          i1 = 0;
          while (i1 < localList.size())
          {
            ScanResult localScanResult = (ScanResult)localList.get(i1);
            String str = localScanResult.SSID.replace("\"", "");
            if (localPattern.matcher(str).matches())
            {
              d locald = new d();
              locald.a = str;
              locald.b = localScanResult.BSSID;
              locald.c = ((short)localScanResult.level);
              localArrayList.add(locald);
            }
            i1 += 1;
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        break label263;
      }
      q();
      i();
    }
    label263:
    do
    {
      return;
      i1 = l();
      if ((i1 & 0x1) > 0)
      {
        b(localArrayList);
        return;
      }
    } while (((i1 & 0x2) <= 0) && ((i1 & 0x4) <= 0));
    a(localArrayList);
  }
  
  private boolean p()
  {
    if (!this.X)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "shouldGetNearbyQQWifi, hasPushedAvailQQWifi=false");
      }
      return false;
    }
    if (((ConnectivityManager)this.H.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "shouldGetNearbyQQWifi, wifi connected.");
      }
      WifiInfo localWifiInfo = ((WifiManager)BaseApplication.getContext().getSystemService("wifi")).getConnectionInfo();
      String str2 = "";
      String str1 = str2;
      if (localWifiInfo != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(localWifiInfo.getSSID())) {
          str1 = localWifiInfo.getSSID().replace("\"", "");
        }
      }
      a(4103, str1, false, false);
      return false;
    }
    if ((a(com.tencent.qphone.base.util.c.a(this.H), this.N)) && ((this.K == 4098) || (this.K == 4102)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "shouldGetNearbyQQWifi, isTheSameAddr");
      }
      return false;
    }
    if (System.currentTimeMillis() - this.P > this.I.i) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "shouldGetNearbyQQWifi, frequency limit");
    }
    return true;
  }
  
  private void q()
  {
    boolean bool = p();
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "shouldGetNearbyQQWifi, " + bool);
    }
    if (bool)
    {
      Object localObject1 = com.tencent.qphone.base.util.c.a(this.H);
      this.N = ((LBSInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "getNearbyQQWifi");
      }
      if ((((LBSInfo)localObject1).vWifis != null) && (((LBSInfo)localObject1).vWifis.size() > 3))
      {
        this.N.vWifis = ((ArrayList)((LBSInfo)localObject1).vWifis.clone());
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(((LBSInfo)localObject1).vWifis.subList(0, 3));
        ((LBSInfo)localObject1).vWifis = ((ArrayList)localObject2);
      }
      Object localObject2 = new UniPacket(true);
      e locale = new e();
      locale.a = ((LBSInfo)localObject1);
      locale.b = 0L;
      ((UniPacket)localObject2).setServantName("MQQ.WiFiMapServer.WiFiMapObj");
      ((UniPacket)localObject2).setFuncName("getNearbyAvailWiFiInfo");
      ((UniPacket)localObject2).put("req", locale);
      localObject1 = ((UniPacket)localObject2).encode();
      localObject2 = new ToServiceMsg("mobileqq.service", this.I.c, "QQWifiSvc.getNearbyAvailWiFiInfo");
      ((ToServiceMsg)localObject2).setAppId(this.G.sender.i());
      ((ToServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject2).setTimeout(20000L);
      ((ToServiceMsg)localObject2).setNeedCallback(true);
      ((ToServiceMsg)localObject2).putWupBuffer((byte[])localObject1);
      ((ToServiceMsg)localObject2).addAttribute("isformsf", Boolean.valueOf(true));
      this.G.sendSsoMsg((ToServiceMsg)localObject2);
      this.P = System.currentTimeMillis();
    }
  }
  
  private boolean r()
  {
    if (this.aa) {
      if (QLog.isColorLevel()) {
        QLog.i("QQWiFiScanManager", 2, "CurUinQuited,return");
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
            return false;
            if (System.currentTimeMillis() - this.R >= 60000L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect in frequency limit,return");
          return false;
          if (n()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isOpened false,return");
        return false;
        if (s()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isDeviceSituationOk false,return");
      return false;
      if (t()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QQWiFiScanManager", 2, "shouldAutoConnect isCurNetstatuAvailForAutoconnect false,return");
    return false;
    return true;
  }
  
  private boolean s()
  {
    return this.Z;
  }
  
  private boolean t()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.H.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
    {
      if (localNetworkInfo.getType() == 1) {
        return false;
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private boolean u()
  {
    if (!this.Y)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "startAccScan");
      }
      new r(this).start();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "startAccScan, already running.");
    }
    return false;
  }
  
  /* Error */
  private void v()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 162	com/tencent/mobileqq/msf/core/p:H	Landroid/content/Context;
    //   7: invokespecial 1109	com/tencent/mobileqq/msf/core/p:a	(Landroid/content/Context;)Ljava/util/Map;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +750 -> 762
    //   15: aload_3
    //   16: ldc_w 1111
    //   19: invokeinterface 1114 2 0
    //   24: checkcast 225	java/lang/String
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +53 -> 84
    //   34: aload_0
    //   35: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   38: aload 4
    //   40: invokestatic 1119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   43: putfield 1121	com/tencent/mobileqq/msf/core/p$a:g	I
    //   46: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +35 -> 84
    //   52: ldc 20
    //   54: iconst_2
    //   55: new 246	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 1123
    //   65: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   72: getfield 1121	com/tencent/mobileqq/msf/core/p$a:g	I
    //   75: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_3
    //   85: ldc_w 1125
    //   88: invokeinterface 1114 2 0
    //   93: checkcast 225	java/lang/String
    //   96: astore 4
    //   98: aload 4
    //   100: ifnull +58 -> 158
    //   103: aload_0
    //   104: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   107: aload 4
    //   109: invokestatic 1119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   112: sipush 1000
    //   115: imul
    //   116: i2l
    //   117: putfield 1127	com/tencent/mobileqq/msf/core/p$a:h	J
    //   120: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +35 -> 158
    //   126: ldc 20
    //   128: iconst_2
    //   129: new 246	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 1123
    //   139: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_0
    //   143: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   146: getfield 1127	com/tencent/mobileqq/msf/core/p$a:h	J
    //   149: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_3
    //   159: ldc_w 1129
    //   162: invokeinterface 1114 2 0
    //   167: checkcast 225	java/lang/String
    //   170: astore 4
    //   172: aload 4
    //   174: ifnull +58 -> 232
    //   177: aload_0
    //   178: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   181: aload 4
    //   183: invokestatic 1119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   186: sipush 1000
    //   189: imul
    //   190: i2l
    //   191: putfield 1056	com/tencent/mobileqq/msf/core/p$a:i	J
    //   194: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +35 -> 232
    //   200: ldc 20
    //   202: iconst_2
    //   203: new 246	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 1131
    //   213: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   220: getfield 1056	com/tencent/mobileqq/msf/core/p$a:i	J
    //   223: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   226: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_3
    //   233: ldc_w 1133
    //   236: invokeinterface 1114 2 0
    //   241: checkcast 225	java/lang/String
    //   244: astore 4
    //   246: aload_0
    //   247: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   250: astore 5
    //   252: ldc_w 1135
    //   255: aload 4
    //   257: invokevirtual 966	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   260: ifeq +503 -> 763
    //   263: iconst_1
    //   264: istore_1
    //   265: aload 5
    //   267: iload_1
    //   268: putfield 1009	com/tencent/mobileqq/msf/core/p$a:e	Z
    //   271: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +46 -> 320
    //   277: ldc 20
    //   279: iconst_2
    //   280: new 246	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 1137
    //   290: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   297: getfield 1009	com/tencent/mobileqq/msf/core/p$a:e	Z
    //   300: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   303: ldc_w 556
    //   306: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 4
    //   311: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload_3
    //   321: ldc_w 1139
    //   324: invokeinterface 1114 2 0
    //   329: checkcast 225	java/lang/String
    //   332: astore 4
    //   334: aload_0
    //   335: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   338: astore 5
    //   340: ldc_w 1135
    //   343: aload 4
    //   345: invokevirtual 966	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: ifeq +420 -> 768
    //   351: iconst_1
    //   352: istore_1
    //   353: aload 5
    //   355: iload_1
    //   356: putfield 1003	com/tencent/mobileqq/msf/core/p$a:f	Z
    //   359: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +46 -> 408
    //   365: ldc 20
    //   367: iconst_2
    //   368: new 246	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 1141
    //   378: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   385: getfield 1003	com/tencent/mobileqq/msf/core/p$a:f	Z
    //   388: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   391: ldc_w 558
    //   394: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 4
    //   399: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_3
    //   409: ldc_w 1143
    //   412: invokeinterface 1114 2 0
    //   417: checkcast 225	java/lang/String
    //   420: astore 4
    //   422: aload_0
    //   423: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   426: astore 5
    //   428: ldc_w 1135
    //   431: aload 4
    //   433: invokevirtual 966	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   436: ifeq +337 -> 773
    //   439: iload_2
    //   440: istore_1
    //   441: aload 5
    //   443: iload_1
    //   444: putfield 1011	com/tencent/mobileqq/msf/core/p$a:k	Z
    //   447: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +46 -> 496
    //   453: ldc 20
    //   455: iconst_2
    //   456: new 246	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 1145
    //   466: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_0
    //   470: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   473: getfield 1011	com/tencent/mobileqq/msf/core/p$a:k	Z
    //   476: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   479: ldc_w 558
    //   482: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 4
    //   487: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload_3
    //   497: ldc_w 1147
    //   500: invokeinterface 1114 2 0
    //   505: checkcast 225	java/lang/String
    //   508: astore 4
    //   510: aload 4
    //   512: ifnull +57 -> 569
    //   515: aload_0
    //   516: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   519: aload 4
    //   521: invokestatic 1153	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   524: ldc2_w 471
    //   527: lmul
    //   528: putfield 773	com/tencent/mobileqq/msf/core/p$a:m	J
    //   531: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq +35 -> 569
    //   537: ldc 20
    //   539: iconst_2
    //   540: new 246	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 1155
    //   550: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload_0
    //   554: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   557: getfield 773	com/tencent/mobileqq/msf/core/p$a:m	J
    //   560: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   563: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: aload_3
    //   570: ldc_w 1157
    //   573: invokeinterface 1114 2 0
    //   578: checkcast 225	java/lang/String
    //   581: astore_3
    //   582: aload_3
    //   583: ifnull +179 -> 762
    //   586: aload_0
    //   587: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   590: aload_3
    //   591: invokestatic 1119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   594: putfield 792	com/tencent/mobileqq/msf/core/p$a:n	I
    //   597: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   600: ifeq +162 -> 762
    //   603: ldc 20
    //   605: iconst_2
    //   606: new 246	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   613: ldc_w 1159
    //   616: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_0
    //   620: getfield 167	com/tencent/mobileqq/msf/core/p:I	Lcom/tencent/mobileqq/msf/core/p$a;
    //   623: getfield 792	com/tencent/mobileqq/msf/core/p$a:n	I
    //   626: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   629: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: return
    //   636: astore 4
    //   638: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq -595 -> 46
    //   644: ldc 20
    //   646: iconst_2
    //   647: ldc_w 1161
    //   650: aload 4
    //   652: invokestatic 1164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   655: goto -609 -> 46
    //   658: astore_3
    //   659: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   662: ifeq +100 -> 762
    //   665: ldc 20
    //   667: iconst_2
    //   668: aload_3
    //   669: invokevirtual 1165	java/lang/Exception:toString	()Ljava/lang/String;
    //   672: invokestatic 1167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: return
    //   676: astore 4
    //   678: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   681: ifeq -561 -> 120
    //   684: ldc 20
    //   686: iconst_2
    //   687: ldc_w 1169
    //   690: aload 4
    //   692: invokestatic 1164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   695: goto -575 -> 120
    //   698: astore 4
    //   700: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq -471 -> 232
    //   706: ldc 20
    //   708: iconst_2
    //   709: ldc_w 1171
    //   712: aload 4
    //   714: invokestatic 1164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   717: goto -485 -> 232
    //   720: astore 4
    //   722: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq -194 -> 531
    //   728: ldc 20
    //   730: iconst_2
    //   731: ldc_w 1173
    //   734: aload 4
    //   736: invokestatic 1164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   739: goto -208 -> 531
    //   742: astore_3
    //   743: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   746: ifeq -149 -> 597
    //   749: ldc 20
    //   751: iconst_2
    //   752: ldc_w 1175
    //   755: aload_3
    //   756: invokestatic 1164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   759: goto -162 -> 597
    //   762: return
    //   763: iconst_0
    //   764: istore_1
    //   765: goto -500 -> 265
    //   768: iconst_0
    //   769: istore_1
    //   770: goto -417 -> 353
    //   773: iconst_0
    //   774: istore_1
    //   775: goto -334 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	778	0	this	p
    //   264	511	1	bool1	boolean
    //   1	439	2	bool2	boolean
    //   10	581	3	localObject	Object
    //   658	11	3	localException1	Exception
    //   742	14	3	localException2	Exception
    //   27	493	4	str	String
    //   636	15	4	localNumberFormatException1	java.lang.NumberFormatException
    //   676	15	4	localNumberFormatException2	java.lang.NumberFormatException
    //   698	15	4	localNumberFormatException3	java.lang.NumberFormatException
    //   720	15	4	localNumberFormatException4	java.lang.NumberFormatException
    //   250	192	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   34	46	636	java/lang/NumberFormatException
    //   2	11	658	java/lang/Exception
    //   15	29	658	java/lang/Exception
    //   34	46	658	java/lang/Exception
    //   46	84	658	java/lang/Exception
    //   84	98	658	java/lang/Exception
    //   103	120	658	java/lang/Exception
    //   120	158	658	java/lang/Exception
    //   158	172	658	java/lang/Exception
    //   177	232	658	java/lang/Exception
    //   232	263	658	java/lang/Exception
    //   265	320	658	java/lang/Exception
    //   320	351	658	java/lang/Exception
    //   353	408	658	java/lang/Exception
    //   408	439	658	java/lang/Exception
    //   441	496	658	java/lang/Exception
    //   496	510	658	java/lang/Exception
    //   515	531	658	java/lang/Exception
    //   531	569	658	java/lang/Exception
    //   569	582	658	java/lang/Exception
    //   597	635	658	java/lang/Exception
    //   638	655	658	java/lang/Exception
    //   678	695	658	java/lang/Exception
    //   700	717	658	java/lang/Exception
    //   722	739	658	java/lang/Exception
    //   743	759	658	java/lang/Exception
    //   103	120	676	java/lang/NumberFormatException
    //   177	232	698	java/lang/NumberFormatException
    //   515	531	720	java/lang/NumberFormatException
    //   586	597	742	java/lang/Exception
  }
  
  /* Error */
  public String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokevirtual 244	java/io/File:exists	()Z
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 246	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: new 1181	java/io/BufferedReader
    //   31: dup
    //   32: new 1183	java/io/FileReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 1186	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   40: invokespecial 1189	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: invokevirtual 1192	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +46 -> 98
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: aload_1
    //   60: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: goto -20 -> 44
    //   67: astore 4
    //   69: ldc 112
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 1193	java/io/FileNotFoundException:printStackTrace	()V
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: ifnull -65 -> 17
    //   85: aload_3
    //   86: invokevirtual 1196	java/io/BufferedReader:close	()V
    //   89: aload_1
    //   90: areturn
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 1197	java/io/IOException:printStackTrace	()V
    //   96: aload_1
    //   97: areturn
    //   98: aload_3
    //   99: astore_2
    //   100: aload 4
    //   102: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore_1
    //   106: aload_3
    //   107: astore_2
    //   108: aload_3
    //   109: invokevirtual 1196	java/io/BufferedReader:close	()V
    //   112: aload_1
    //   113: astore_2
    //   114: aload_3
    //   115: ifnull -98 -> 17
    //   118: aload_3
    //   119: invokevirtual 1196	java/io/BufferedReader:close	()V
    //   122: aload_1
    //   123: areturn
    //   124: astore_2
    //   125: goto -33 -> 92
    //   128: astore 4
    //   130: aconst_null
    //   131: astore_3
    //   132: ldc 112
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: aload 4
    //   139: invokevirtual 1197	java/io/IOException:printStackTrace	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: ifnull -128 -> 17
    //   148: aload_3
    //   149: invokevirtual 1196	java/io/BufferedReader:close	()V
    //   152: aload_1
    //   153: areturn
    //   154: astore_2
    //   155: goto -63 -> 92
    //   158: astore_1
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 1196	java/io/BufferedReader:close	()V
    //   169: aload_1
    //   170: athrow
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 1197	java/io/IOException:printStackTrace	()V
    //   176: goto -7 -> 169
    //   179: astore_1
    //   180: goto -19 -> 161
    //   183: astore 4
    //   185: ldc 112
    //   187: astore_1
    //   188: goto -53 -> 135
    //   191: astore 4
    //   193: goto -58 -> 135
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_3
    //   200: ldc 112
    //   202: astore_1
    //   203: goto -131 -> 72
    //   206: astore 4
    //   208: goto -136 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	p
    //   0	211	1	paramFile	File
    //   3	78	2	localObject1	Object
    //   91	2	2	localIOException1	java.io.IOException
    //   99	15	2	localObject2	Object
    //   124	1	2	localIOException2	java.io.IOException
    //   136	8	2	localObject3	Object
    //   154	1	2	localIOException3	java.io.IOException
    //   160	6	2	localObject4	Object
    //   171	2	2	localIOException4	java.io.IOException
    //   1	199	3	localBufferedReader	java.io.BufferedReader
    //   26	32	4	localStringBuilder	StringBuilder
    //   67	34	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   128	10	4	localIOException5	java.io.IOException
    //   183	1	4	localIOException6	java.io.IOException
    //   191	1	4	localIOException7	java.io.IOException
    //   196	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   206	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   46	51	67	java/io/FileNotFoundException
    //   57	64	67	java/io/FileNotFoundException
    //   100	106	67	java/io/FileNotFoundException
    //   85	89	91	java/io/IOException
    //   118	122	124	java/io/IOException
    //   19	44	128	java/io/IOException
    //   148	152	154	java/io/IOException
    //   19	44	158	finally
    //   165	169	171	java/io/IOException
    //   46	51	179	finally
    //   57	64	179	finally
    //   74	79	179	finally
    //   100	106	179	finally
    //   108	112	179	finally
    //   137	142	179	finally
    //   46	51	183	java/io/IOException
    //   57	64	183	java/io/IOException
    //   100	106	183	java/io/IOException
    //   108	112	191	java/io/IOException
    //   19	44	196	java/io/FileNotFoundException
    //   108	112	206	java/io/FileNotFoundException
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4097: 
      paramString = new Intent("com.tencent.mobileqq.action.QQWiFi");
      paramString.putExtra("hasvailable", true);
      if (paramBoolean) {
        a(paramString, BaseApplication.qqWifiUserful, "发现免费QQ WiFi信号", "试试一键连接", "当前有可用的 QQ WiFi,点击进入连接");
      }
      for (;;)
      {
        a(1, null);
        return;
        a(paramString, BaseApplication.qqWifiUserful, "发现免费QQ WiFi信号", "试试一键连接", null);
      }
    case 4098: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), BaseApplication.qqWifiNoSignal, "附近有免费QQ WiFi", "点击查看地图", null);
      return;
    case 4102: 
      a(new Intent("com.tencent.mobileqq.msf.qqwifi.map"), BaseApplication.qqWifiNoSignal, paramString, "点击查看地图", null);
      return;
    case 4099: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), BaseApplication.qqWifiNoSignal, "网络连接不可用", "网络恢复后查看", null);
      return;
    case 4100: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), BaseApplication.qqWifiNoSignal, "系统WiFi已关闭", "打开后查看", null);
      return;
    case 4101: 
      a(new Intent("com.tencent.mobileqq.action.QQWiFi"), BaseApplication.qqWifiNoSignal, paramString, "点击查看", null);
      return;
    }
    a(new Intent("com.tencent.mobileqq.action.QQWiFi"), BaseApplication.qqWifiConnecticon3, "已连接 " + paramString, "快来赚取免费QQ WiFi时长", null);
  }
  
  public void a(Intent paramIntent)
  {
    int i1 = 4;
    if (paramIntent != null)
    {
      if (!paramIntent.hasExtra("isNeedScanRunning")) {
        break label143;
      }
      boolean bool = paramIntent.getBooleanExtra("isNeedScanRunning", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onReceiveScanStateChange, isNeedScanRunning = " + bool);
      }
      paramIntent = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label109;
      }
      paramIntent = paramIntent.getSharedPreferences("mobileQQ", i1);
      if (!bool) {
        break label114;
      }
      NetConnInfoCenterImpl localNetConnInfoCenterImpl = NetConnInfoCenter.impl;
      a(NetConnInfoCenterImpl.msfCore);
      this.X = paramIntent.getBoolean("hasPushedAvailNotification", false);
    }
    label109:
    label114:
    do
    {
      do
      {
        do
        {
          return;
          i1 = 0;
          break;
          b();
          paramIntent.edit().putBoolean("hasPushedAvailNotification", this.X).commit();
          return;
          if (paramIntent.hasExtra("enableChange"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQWiFiScanManager", 2, "onReceiveScanStateChange, enableChange");
            }
            a(0);
            a(1);
            a(3);
            return;
          }
          if (!paramIntent.hasExtra("barswitch")) {
            break label239;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "onReceiveScanStateChange, barswitch");
          }
          a(2);
        } while (m());
        ((WifiManager)this.H.getSystemService("wifi")).startScan();
        return;
        if (!paramIntent.hasExtra("redTouch")) {
          break label275;
        }
      } while (!paramIntent.getBooleanExtra("redTouch", false));
      a(this.K, this.L, false, true);
      return;
      if (paramIntent.hasExtra("autoswitch"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "onReceiveScanStateChange, autoswitch");
        }
        a(4);
        return;
      }
    } while (!paramIntent.hasExtra("autoConnectArrived"));
    label143:
    label239:
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onReceiveScanStateChange, autoConnectArrived");
    }
    label275:
    a(5);
  }
  
  public void a(MsfCore paramMsfCore)
  {
    if (this.W)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "register, already registered");
      }
      return;
    }
    this.G = paramMsfCore;
    paramMsfCore = new IntentFilter();
    paramMsfCore.addAction("android.intent.action.SCREEN_ON");
    paramMsfCore.addAction("android.intent.action.SCREEN_OFF");
    paramMsfCore.addAction("android.net.wifi.SCAN_RESULTS");
    BaseApplication.getContext().registerReceiver(this.ab, paramMsfCore);
    this.W = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "register");
    }
    e();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onRecvAvailResponse :");
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = "null";
        QLog.d("QQWiFiScanManager", 2, paramToServiceMsg);
      }
    }
    else if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramToServiceMsg = new UniPacket(true);
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (b)paramToServiceMsg.getByClass("rsp", new b());
      if ((paramToServiceMsg != null) && (paramToServiceMsg.a == 0) && (!paramToServiceMsg.b.isEmpty()))
      {
        a(4097, "", false, false);
        if (!a(this.U, paramToServiceMsg.b)) {
          break label189;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "onRecvAvailResponse, isSubset=true");
        }
      }
    }
    for (;;)
    {
      this.U.clear();
      this.U.addAll(paramToServiceMsg.b);
      return;
      paramToServiceMsg = paramFromServiceMsg.toString();
      break;
      label189:
      u();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QQWiFiScanManager", 2, "setQuited = " + paramBoolean);
    }
    this.aa = paramBoolean;
  }
  
  public void b()
  {
    if (this.W) {
      BaseApplication.getContext().unregisterReceiver(this.ab);
    }
    this.W = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "unregister");
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (this.aa)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onResponseWifiStatechange isCurUinQuited true, return");
      }
      return;
    }
    int i1 = paramIntent.getIntExtra("wifi_state", 0);
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiScanManager", 2, " onResponseWifiStatechange, wifiState=" + i1);
    }
    switch (i1)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a(4100, "", false, false);
      return;
    }
    paramIntent = (ConnectivityManager)this.H.getSystemService("connectivity");
    for (;;)
    {
      try
      {
        paramIntent = paramIntent.getAllNetworkInfo();
        if ((paramIntent == null) || (paramIntent.length >= 0) || (paramIntent[0].getState() != NetworkInfo.State.CONNECTED)) {
          break label181;
        }
        i1 = 1;
        if (i1 != 0) {
          break;
        }
        a(4099, "", false, false);
        return;
      }
      catch (Throwable paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("QQWiFiScanManager", 2, QLog.getStackTraceString(paramIntent));
      return;
      label181:
      i1 = 0;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiScanManager", 2, "onRecvNearbyInfo");
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramToServiceMsg = new UniPacket(true);
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (com.tencent.msf.service.protocol.QQWiFi.c)paramToServiceMsg.getByClass("rsp", new com.tencent.msf.service.protocol.QQWiFi.c());
      if ((paramToServiceMsg != null) && (paramToServiceMsg.b == 1) && (!TextUtils.isEmpty(paramToServiceMsg.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQWiFiScanManager", 2, " onRecvNearbyInfo, msg=" + paramToServiceMsg.a);
        }
        a(4102, paramToServiceMsg.a, false, false);
      }
    }
  }
  
  public void c()
  {
    try
    {
      if (k()) {
        ((WifiManager)this.H.getSystemService("wifi")).startScan();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQWiFiScanManager", 2, "scan", localThrowable);
    }
  }
  
  public void d()
  {
    Object localObject2;
    int i1;
    try
    {
      if (this.aa)
      {
        if (!QLog.isColorLevel()) {
          break label410;
        }
        QLog.d("QQWiFiScanManager", 2, "onResponseNetChange isCurUinQuited true, return");
        return;
      }
      localObject2 = ((ConnectivityManager)this.H.getSystemService("connectivity")).getActiveNetworkInfo();
      WifiManager localWifiManager = (WifiManager)this.H.getSystemService("wifi");
      i1 = localWifiManager.getWifiState();
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "onResponseNetChange, wifiState=" + i1);
      }
      if (localObject2 != null) {
        break label172;
      }
      if (3 != i1) {
        break label145;
      }
      a(4099, "", false, false);
      if (!QLog.isColorLevel()) {
        break label410;
      }
      QLog.d("QQWiFiScanManager", 2, "no network access");
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label410;
      }
    }
    QLog.e("QQWiFiScanManager", 2, localException.getMessage());
    return;
    label145:
    a(4100, "", false, false);
    if (QLog.isColorLevel())
    {
      QLog.d("QQWiFiScanManager", 2, "wifi disabled");
      return;
      label172:
      if (3 != i1)
      {
        a(4100, "", false, false);
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "onResponseNetChange, wifi disabled");
        }
      }
      else if ((((NetworkInfo)localObject2).getType() == 1) || (((NetworkInfo)localObject2).getType() == 9))
      {
        localObject2 = ((WifiManager)this.H.getSystemService("wifi")).getScanResults();
        if (localObject2 == null) {
          break label405;
        }
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 < ((List)localObject2).size())
      {
        if (!a(((ScanResult)((List)localObject2).get(i1)).SSID)) {}
      }
      else
      {
        label405:
        for (i1 = 1;; i1 = 0)
        {
          Object localObject1;
          if (i1 == 0)
          {
            WifiInfo localWifiInfo = localException.getConnectionInfo();
            localObject2 = "";
            localObject1 = localObject2;
            if (localWifiInfo != null)
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(localWifiInfo.getSSID())) {
                localObject1 = localWifiInfo.getSSID().replace("\"", "");
              }
            }
            a(4103, (String)localObject1, false, false);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("QQWiFiScanManager", 2, "onResponseNetChange, push ssid");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQWiFiScanManager", 2, "onResponseNetChange, qqwifi available, don't push ssid");
          }
          if (!k()) {
            break;
          }
          ((WifiManager)localObject1).startScan();
          return;
          if (k()) {
            ((WifiManager)localObject1).startScan();
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQWiFiScanManager", 2, "onResponseNetChange, startScan");
          return;
        }
        label410:
        return;
      }
      i1 += 1;
    }
  }
  
  public void e()
  {
    Object localObject3;
    int i1;
    try
    {
      Object localObject1 = ((ConnectivityManager)this.H.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject1 != null)
      {
        if (((NetworkInfo)localObject1).getType() != 1) {
          return;
        }
        localObject1 = ((ActivityManager)this.H.getSystemService("activity")).getRunningAppProcesses();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            if ("com.tencent.minihd.qq:qqwifi".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next()).processName)) {
              return;
            }
          }
        }
        localObject1 = NetConnInfoCenter.impl;
        a(NetConnInfoCenterImpl.msfCore);
        localObject3 = "";
        localObject1 = "";
        Object localObject4 = ((WifiManager)this.H.getSystemService("wifi")).getConnectionInfo();
        if (localObject4 != null)
        {
          localObject3 = ((WifiInfo)localObject4).getBSSID();
          i1 = ((WifiInfo)localObject4).getIpAddress();
          localObject1 = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(i1 & 0xFF), Integer.valueOf(i1 >> 8 & 0xFF), Integer.valueOf(i1 >> 16 & 0xFF), Integer.valueOf(i1 >> 24 & 0xFF) });
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject4 = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            break label632;
          }
          i1 = 4;
          localObject4 = ((Context)localObject4).getSharedPreferences("mobileQQ", i1);
          if (localObject4 != null)
          {
            localObject4 = ((SharedPreferences)localObject4).getString("qqwifiConnInfo", "");
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              Object localObject6 = new JSONObject((String)localObject4);
              localObject4 = ((JSONObject)localObject6).optString("ssid");
              Object localObject5 = ((JSONObject)localObject6).optString("bssid");
              localObject6 = ((JSONObject)localObject6).optString("IPAdress");
              if ((((String)localObject3).equals(localObject5)) && (((String)localObject1).equals(localObject6)))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("QQWiFiScanManager", 2, "checkConnection:remove netWork！ssid=" + (String)localObject4 + " bssid=" + (String)localObject5 + " IPAdress=" + (String)localObject6);
                }
                localObject5 = (WifiManager)this.H.getSystemService("wifi");
                localObject6 = ((WifiManager)localObject5).getConfiguredNetworks();
                if (localObject6 != null)
                {
                  i1 = 0;
                  localObject1 = localObject4;
                  label418:
                  if (i1 < ((List)localObject6).size())
                  {
                    localObject4 = (WifiConfiguration)((List)localObject6).get(i1);
                    localObject3 = localObject1;
                    if (localObject4 == null) {
                      break label637;
                    }
                    if (TextUtils.isEmpty(((WifiConfiguration)localObject4).SSID)) {
                      break label625;
                    }
                    String str = ((WifiConfiguration)localObject4).SSID.replace("\"", "");
                    localObject1 = ((String)localObject1).replace("\"", "");
                    localObject3 = localObject1;
                    if (!str.equals(localObject1)) {
                      break label637;
                    }
                    ((WifiManager)localObject5).removeNetwork(((WifiConfiguration)localObject4).networkId);
                    localObject3 = localObject1;
                    if (!QLog.isColorLevel()) {
                      break label637;
                    }
                    QLog.i("QQWiFiScanManager", 2, "checkConnection：已经删除了" + ((WifiConfiguration)localObject4).SSID + "网络 networkId:" + ((WifiConfiguration)localObject4).networkId + " bssid:" + ((WifiConfiguration)localObject4).BSSID);
                    localObject3 = localObject1;
                    break label637;
                  }
                  ((WifiManager)localObject5).saveConfiguration();
                  return;
                }
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiScanManager", 2, "checkConnection:Exception:" + localThrowable.getMessage());
      }
    }
    return;
    for (;;)
    {
      label625:
      i1 += 1;
      break label418;
      label632:
      i1 = 0;
      break;
      label637:
      Object localObject2 = localObject3;
    }
  }
  
  private class a
  {
    public String a = "";
    public boolean b = false;
    public String c = "";
    public int d = 0;
    public boolean e = false;
    public boolean f = false;
    public int g = 10;
    public long h = 30000L;
    public long i = 60000L;
    public long j = 86400000L;
    public boolean k = false;
    public int l = 0;
    public long m = 21600000L;
    public int n = 1;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.p
 * JD-Core Version:    0.7.0.1
 */