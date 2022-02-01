package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.f.a;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  public static boolean DOWNLOAD_OVERSEA_TBS = false;
  public static final String LOGTAG = "TbsDownload";
  public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  static boolean a;
  private static String b;
  private static Context c;
  private static Handler d;
  private static String e;
  private static Object f = new byte[0];
  private static m g;
  private static HandlerThread h;
  private static boolean i = false;
  private static String j = "";
  private static boolean k = false;
  private static boolean l = false;
  private static int m;
  private static boolean n;
  private static int o;
  private static long p;
  private static int q;
  private static JSONObject r = null;
  private static JSONObject s = null;
  private static JSONObject t = null;
  private static long u = -1L;
  
  protected static File a(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int i2 = arrayOfString.length;
    int i1 = 0;
    Object localObject2 = localObject1;
    if (i1 < i2)
    {
      localObject2 = arrayOfString[i1];
      if (!((String)localObject2).equals(c.getApplicationInfo().packageName)) {}
    }
    for (;;)
    {
      i1 += 1;
      break;
      localObject2 = FileUtil.a(c, (String)localObject2, 4, false);
      if (getOverSea(c)) {}
      for (localObject1 = "x5.oversea.tbs.org";; localObject1 = getBackupFileName(false))
      {
        localObject1 = new File((String)localObject2, (String)localObject1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label159;
        }
        if (a.a(c, (File)localObject1) != paramInt) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
        localObject2 = localObject1;
        return localObject2;
      }
      TbsLog.i("TbsDownload", "version is not match");
      continue;
      label159:
      TbsLog.i("TbsDownload", "can not find local backup core file");
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static JSONArray a(boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i3 = arrayOfString.length;
    int i1 = 0;
    Object localObject;
    label60:
    label73:
    long l1;
    if (i1 < i3)
    {
      localObject = arrayOfString[i1];
      if (paramBoolean)
      {
        String str = FileUtil.a(c, (String)localObject, 4, false);
        if (getOverSea(c))
        {
          localObject = "x5.oversea.tbs.org";
          localObject = new File(str, (String)localObject);
          if ((localObject != null) && (((File)localObject).exists()))
          {
            l1 = a.a(c, (File)localObject);
            if (l1 > 0L)
            {
              i2 = 0;
              label106:
              if (i2 >= localJSONArray.length()) {
                break label192;
              }
              if (localJSONArray.optInt(i2) != l1) {
                break label182;
              }
            }
          }
        }
      }
    }
    label182:
    label192:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0) {
        localJSONArray.put(l1);
      }
      i1 += 1;
      break;
      localObject = getBackupFileName(false);
      break label60;
      localObject = new File(FileUtil.a(c, (String)localObject, 4, false), "x5.tbs.decouple");
      break label73;
      i2 += 1;
      break label106;
      return localJSONArray;
    }
  }
  
  private static JSONObject a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    String str1 = b(c);
    String str2 = b.i(c);
    String str3 = b.h(c);
    String str4 = b.k(c);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    label127:
    int i1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)c.getSystemService("phone");
        if (localObject3 == null) {
          break label1039;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          localException2.printStackTrace();
        }
        i1 = i2;
        if (n.a(c).c("stable_32_tpatch_fail") != 1) {
          break label1518;
        }
      }
      if (localObject1 != null)
      {
        localObject3 = new JSONObject();
        i2 = 0;
        i1 = 0;
        if (!paramBoolean3) {}
      }
    }
    try
    {
      if (!q.b(c)) {
        break label1083;
      }
      ((JSONObject)localObject3).put("REQUEST_TPATCH", 1);
      if (!b.b()) {
        break label1042;
      }
      if (n.a(c).c("stable_64_tpatch_fail") != 1) {
        break label1502;
      }
      ((JSONObject)localObject3).put("REQUEST_TPATCH", 0);
      TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] stable_64_last_tpatch_fail and set REQUEST_TPATCH  0 ");
      i1 = 1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label206:
        continue;
        int i3 = 0;
        continue;
        i3 = 0;
        continue;
        i2 = 1;
      }
    }
    ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
    ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
    if (b.b()) {
      ((JSONObject)localObject3).put("REQUEST_64", 1);
    }
    ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
    if (TbsShareManager.isThirdPartyApp(c)) {
      if (QbSdk.c)
      {
        i2 = TbsShareManager.a(c, false);
        label278:
        if (!paramBoolean1) {
          break label1530;
        }
        ((JSONObject)localObject3).put("FUNCTION", 2);
        localObject1 = "A";
      }
    }
    for (;;)
    {
      label297:
      q.a("2" + (String)localObject1);
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject1 = g();
        ((JSONObject)localObject3).put("TBSVLARR", localObject1);
        j = ((JSONArray)localObject1).toString();
        q.a("3is" + ((JSONArray)localObject1).toString());
        localTbsDownloadConfig.mSyncMap.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
        localTbsDownloadConfig.commit();
        if (QbSdk.c) {
          ((JSONObject)localObject3).put("THIRDREQ", 1);
        }
        label421:
        ((JSONObject)localObject3).put("APPN", c.getPackageName());
        ((JSONObject)localObject3).put("APPVN", a(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
        ((JSONObject)localObject3).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
        ((JSONObject)localObject3).put("APPMETA", a(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
        ((JSONObject)localObject3).put("TBSSDKV", 44085);
        ((JSONObject)localObject3).put("TBSV", i2);
        q.a("4is" + i2);
        if (!paramBoolean3) {
          break label1560;
        }
        i3 = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", i3);
        localObject1 = localTbsDownloadConfig.mSyncMap;
        if (!paramBoolean3) {
          break label1566;
        }
        i3 = 1;
        ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(i3));
        localTbsDownloadConfig.commit();
        if (i2 != 0) {
          ((JSONObject)localObject3).put("TBSBACKUPV", g.c(paramBoolean3));
        }
        ((JSONObject)localObject3).put("CPU", e);
        ((JSONObject)localObject3).put("UA", str1);
        ((JSONObject)localObject3).put("IMSI", a(str2));
        ((JSONObject)localObject3).put("IMEI", a(str3));
        ((JSONObject)localObject3).put("ANDROID_ID", a(str4));
        ((JSONObject)localObject3).put("GUID", b.f(c));
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          if (i2 == 0) {
            break label1443;
          }
          if (!QbSdk.a(c, i2)) {
            break label1572;
          }
          i2 = 0;
          ((JSONObject)localObject3).put("STATUS", i2);
          label751:
          if (!q.b(c)) {
            break label1456;
          }
          i3 = TbsShareManager.getTbsStableCoreVersion(c, 0);
          i2 = i3;
          if (paramBoolean3)
          {
            i2 = i3;
            if (i3 > 0)
            {
              i2 = i3;
              if (((JSONObject)localObject3).getInt("FUNCTION") == 0)
              {
                ((JSONObject)localObject3).put("FUNCTION", 1);
                i2 = i3;
              }
            }
          }
          label815:
          ((JSONObject)localObject3).put("TBSDV", i2);
          ((JSONObject)localObject3).put("TBSBACKUPV", i2);
          if (i1 != 0)
          {
            ((JSONObject)localObject3).put("TBSDV", 0);
            ((JSONObject)localObject3).put("TBSBACKUPV", 0);
          }
        }
        paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
        if (!QbSdk.isEnableSensitiveApi()) {
          break label1480;
        }
        localObject1 = QbSdk.a(c, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label1480;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label1505;
        label923:
        if (i1 != 0) {
          ((JSONObject)localObject3).put("REQUEST_LZMA", 1);
        }
        if (getOverSea(c)) {
          ((JSONObject)localObject3).put("OVERSEA", 1);
        }
        if (paramBoolean2) {
          ((JSONObject)localObject3).put("DOWNLOAD_FOREGROUND", 1);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject3).toString());
        Log.d("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject3).toString());
        return localObject3;
        label1039:
        label1042:
        localException2.put("REQUEST_TPATCH", 0);
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] stable_32_last_tpatch_fail and set REQUEST_TPATCH  0 ");
        i1 = 1;
        break label1518;
        label1083:
        if (n.a(c).c("tpatch_num") < 5)
        {
          if (TbsShareManager.isThirdPartyApp(c))
          {
            localException2.put("REQUEST_TPATCH", 2);
            i1 = 0;
            break label206;
          }
          localException2.put("REQUEST_TPATCH", 1);
          i1 = 0;
          break label206;
        }
        localException2.put("REQUEST_TPATCH", 0);
        i1 = 0;
        break label206;
        i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        break label278;
        if (paramBoolean3) {}
        for (i3 = p.a().j(c);; i3 = p.a().n(c))
        {
          i2 = i3;
          if (i3 == 0)
          {
            i2 = i3;
            if (p.a().m(c))
            {
              i3 = -1;
              i2 = i3;
              if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName))
              {
                TbsDownloadUpload.clear();
                localObject1 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject1).a.put("tbs_local_core_version", Integer.valueOf(-1));
                ((TbsDownloadUpload)localObject1).commit();
                TbsPVConfig.releaseInstance();
                i2 = i3;
                if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                  i2 = p.a().j(c);
                }
              }
            }
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + i2 + " isDownloadForeground=" + paramBoolean2);
          if (!paramBoolean2) {
            break;
          }
          if (!p.a().m(c)) {
            break label1524;
          }
          break label1521;
        }
      }
      for (;;)
      {
        localException2.put("FUNCTION", i3);
        if (i2 != 0) {
          break label1547;
        }
        localObject1 = "C";
        break label297;
        localObject1 = a(paramBoolean3);
        if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (i2 != 0) || (!paramBoolean1)) {
          break label421;
        }
        localException2.put("TBSBACKUPARR", localObject1);
        break label421;
        label1443:
        localException2.put("STATUS", 0);
        break label751;
        label1456:
        i2 = p.a().i(c);
        break label815;
        label1480:
        label1502:
        label1505:
        do
        {
          i1 = 0;
          break label923;
          do
          {
            i1 = 0;
            break label923;
            paramBoolean1 = false;
            continue;
            break label278;
            localObject1 = "";
            break label127;
            localObject2 = "";
            break;
            break label206;
          } while (!paramBoolean1);
        } while (paramBoolean3);
        i1 = 1;
        break label923;
        label1518:
        break label206;
        for (;;)
        {
          label1521:
          break;
          label1524:
          i2 = 0;
        }
        label1530:
        if (i2 == 0) {
          i3 = 0;
        } else {
          i3 = 1;
        }
      }
      label1547:
      localObject1 = "B";
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    String[] arrayOfString = f();
    int i3 = arrayOfString.length;
    int i1 = 0;
    String str;
    int i4;
    Context localContext;
    if (i1 < i3)
    {
      str = arrayOfString[i1];
      i4 = TbsShareManager.getSharedTbsCoreVersion(c, str);
      if (i4 > 0)
      {
        localContext = TbsShareManager.getPackageContext(c, str, true);
        if ((localContext == null) || (p.a().g(localContext))) {
          break label97;
        }
        TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
      }
    }
    label145:
    label320:
    label322:
    for (;;)
    {
      i1 += 1;
      break;
      label97:
      if (a(c, i4))
      {
        TbsLog.i("TbsDownload", "add CoreVersionToJsonData,version+" + i4 + " is in black list");
      }
      else
      {
        int i2 = 0;
        if (i2 < paramJSONArray.length()) {
          if (paramJSONArray.optInt(i2) != i4) {}
        }
        for (i2 = 1;; i2 = 0)
        {
          if (i2 != 0) {
            break label409;
          }
          TbsLog.i("TbsDownload", "addCoreVersionToJsonData,pkg=" + str + ";version=" + i4);
          paramJSONArray.put(i4);
          break;
          i2 += 1;
          break label145;
          arrayOfString = f();
          i3 = arrayOfString.length;
          i1 = 0;
          if (i1 < i3)
          {
            str = arrayOfString[i1];
            i4 = TbsShareManager.getCoreShareDecoupleCoreVersion(c, str);
            if (i4 > 0)
            {
              localContext = TbsShareManager.getPackageContext(c, str, true);
              if ((localContext == null) || (p.a().g(localContext))) {
                break label320;
              }
              TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            i2 = 0;
            if (i2 < paramJSONArray.length()) {
              if (paramJSONArray.optInt(i2) != i4) {}
            }
            for (i2 = 1;; i2 = 0)
            {
              if (i2 != 0) {
                break label404;
              }
              TbsLog.i("TbsDownload", "addCoreVersionToJsonDataByDecouple,pkg=" + str + ";version=" + i4);
              paramJSONArray.put(i4);
              break;
              i2 += 1;
              break label322;
              return;
            }
          }
        }
      }
    }
  }
  
  private static void a(boolean paramBoolean1, TbsDownloaderCallback paramTbsDownloaderCallback, boolean paramBoolean2)
  {
    int i2 = 1;
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    d.removeMessages(100);
    Message localMessage = Message.obtain(d, 100);
    if (paramTbsDownloaderCallback != null) {
      localMessage.obj = paramTbsDownloaderCallback;
    }
    localMessage.arg1 = 0;
    if (paramBoolean1)
    {
      i1 = 1;
      localMessage.arg1 = i1;
      if (!paramBoolean2) {
        break label81;
      }
    }
    label81:
    for (int i1 = i2;; i1 = 0)
    {
      localMessage.arg2 = i1;
      localMessage.sendToTarget();
      return;
      i1 = 0;
      break;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsDownload", "copyFromOldBackupDone newCoreVersion is " + paramInt1 + " localStableCoreVersion is " + paramInt2 + " cpuType is " + paramInt3);
        if ((paramInt1 > 0) && (paramInt1 != paramInt2))
        {
          Object localObject1 = new File(FileUtil.a(c, 3), getBackupFileName(false, paramInt3));
          int i1 = -1;
          paramInt2 = i1;
          if (((File)localObject1).exists())
          {
            paramInt2 = i1;
            if (((File)localObject1).canRead())
            {
              i1 = a.b((File)localObject1);
              paramInt2 = i1;
              if (i1 <= 0) {
                paramInt2 = a.a(c, (File)localObject1);
              }
            }
          }
          TbsLog.i("TbsDownload", "copyFromOldBackupDone oldBackupCoreVersion is " + paramInt2);
          if (paramInt1 == paramInt2)
          {
            File localFile = new File(FileUtil.a(c, "com.tencent.mm", 4, true));
            bool = FileUtil.b((File)localObject1, new File(localFile, getBackupFileName(false, paramInt3)));
            TbsLog.i("TbsDownload", "copyFromOldBackupDone #01 result is " + bool);
            if (!bool) {
              break;
            }
            localObject1 = localFile.listFiles();
            Pattern localPattern = Pattern.compile(a.a(false, paramInt3));
            i1 = localObject1.length;
            paramInt2 = 0;
            if (paramInt2 < i1)
            {
              Object localObject2 = localObject1[paramInt2];
              if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
                break label400;
              }
              localObject2.delete();
              break label400;
            }
            localFile = new File(localFile, a.a(false, paramInt3) + "." + paramInt1);
            if ((localFile != null) && (localFile.exists())) {
              return bool;
            }
            localFile.createNewFile();
            return bool;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        TbsLog.i("TbsDownload", "stack is " + Log.getStackTraceString(localThrowable));
        TbsLog.i("TbsDownload", "copyFromOldBackupDone result is false  #10");
        return false;
      }
      label400:
      paramInt2 += 1;
    }
    return bool;
  }
  
  static boolean a(Context paramContext)
  {
    return TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return (Build.VERSION.SDK_INT > 28) && (paramContext.getApplicationInfo().targetSdkVersion > 28) && (paramInt > 0) && (paramInt < 45114);
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    if (Build.VERSION.SDK_INT < 8) {
      localTbsDownloadConfig.setDownloadInterruptCode(-102);
    }
    while ((!QbSdk.c) && (TbsShareManager.isThirdPartyApp(c)) && (!c())) {
      return false;
    }
    if (!localTbsDownloadConfig.mPreferences.contains("is_oversea"))
    {
      boolean bool = paramBoolean;
      if (paramBoolean)
      {
        bool = paramBoolean;
        if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
        {
          TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
          bool = false;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("is_oversea", Boolean.valueOf(bool));
      localTbsDownloadConfig.commit();
      k = bool;
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + bool);
    }
    if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      localTbsDownloadConfig.setDownloadInterruptCode(-103);
      return false;
    }
    e = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
    if (!TextUtils.isEmpty(e)) {}
    try
    {
      paramContext = Pattern.compile("i686|mips|x86_64").matcher(e);
      if ((paramContext != null) && (paramContext.find()))
      {
        TbsLog.e("TbsDownload", "can not support x86 devices!!");
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
        return false;
      }
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = TbsDownloadConfig.getInstance(paramContext);
    c.a().a(paramContext, Integer.valueOf(1000), new c.a()
    {
      public void a(String paramAnonymousString)
      {
        TbsLog.i("TbsDownload", "Execute command [1000](" + paramAnonymousString + "), force tbs downloader request");
        paramAnonymousString = this.a.mPreferences.edit();
        paramAnonymousString.putLong("last_check", 0L);
        paramAnonymousString.apply();
        paramAnonymousString.commit();
      }
    });
    int i1;
    String str1;
    String str2;
    int i2;
    String str3;
    long l2;
    long l3;
    long l1;
    long l4;
    long l5;
    int i3;
    int i4;
    if (!paramBoolean1)
    {
      paramContext = ((TbsDownloadConfig)localObject).mPreferences.getString("app_versionname", null);
      i1 = ((TbsDownloadConfig)localObject).mPreferences.getInt("app_versioncode", 0);
      str1 = ((TbsDownloadConfig)localObject).mPreferences.getString("app_metadata", null);
      str2 = b.d(c);
      i2 = b.e(c);
      str3 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str2 + " oldAppVersionName=" + paramContext + " appVersionCode=" + i2 + " oldAppVersionCode=" + i1 + " appMetadata=" + str3 + " oldAppVersionMetadata=" + str1);
      l2 = System.currentTimeMillis();
      l3 = ((TbsDownloadConfig)localObject).mPreferences.getLong("last_check", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + l3 + " timeNow=" + l2);
      l1 = l3;
      if (paramBoolean2)
      {
        paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.contains("last_check");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + paramBoolean1);
        l1 = l3;
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
      }
      l3 = ((TbsDownloadConfig)localObject).mPreferences.getLong("last_request_success", 0L);
      l4 = ((TbsDownloadConfig)localObject).mPreferences.getLong("count_request_fail_in_24hours", 0L);
      l5 = ((TbsDownloadConfig)localObject).getRetryInterval();
      TbsLog.i("TbsDownload", "retryInterval = " + l5 + " s");
      TbsPVConfig.releaseInstance();
      i3 = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
      i4 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      if (l2 - l1 > 1000L * l5)
      {
        TbsLog.i("TbsDownload", "needSendRequest  true  #1");
        paramBoolean1 = true;
        paramContext = null;
      }
    }
    for (;;)
    {
      if ((!paramBoolean1) && (TbsShareManager.isThirdPartyApp(c)))
      {
        localObject = TbsLogReport.getInstance(c).tbsLogInfo();
        ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(-119);
        ((TbsLogReport.TbsLogInfo)localObject).setFailDetail(paramContext);
        TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject);
      }
      return paramBoolean1;
      if ((i3 > p.a().j(c)) && (i3 > i4))
      {
        TbsLog.i("TbsDownload", "emergentCoreVersion is " + i3 + " getTbsCoreInstalledVerInNolock is " + p.a().j(c) + " responseCoreVersion is " + i4);
        paramBoolean1 = true;
        paramContext = null;
      }
      else if ((TbsShareManager.isThirdPartyApp(c)) && (l3 > 0L) && (l2 - l3 > l5 * 1000L) && (l4 < 11L))
      {
        TbsLog.i("TbsDownload", "needSendRequest  true  #3");
        paramBoolean1 = true;
        paramContext = null;
      }
      else if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!e()))
      {
        TbsLog.i("TbsDownload", "needSendRequest  true  #4");
        p.a().e(c);
        paramBoolean1 = true;
        paramContext = null;
      }
      else
      {
        if ((str2 != null) && (i2 != 0) && (str3 != null))
        {
          if ((!str2.equals(paramContext)) || (i2 != i1) || (!str3.equals(str1)))
          {
            TbsLog.i("TbsDownload", "needSendRequest  true  #5");
            paramBoolean1 = true;
            paramContext = null;
          }
        }
        else if (TbsShareManager.isThirdPartyApp(c))
        {
          paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + str2 + " appVersionCode is " + i2 + " appMetadata is " + str3 + " oldAppVersionName is " + paramContext + " oldAppVersionCode is " + i1 + " oldAppVersionMetadata is " + str1;
          paramBoolean1 = false;
          continue;
          TbsLog.i("TbsDownload", "needSendRequest  true  #6");
          paramBoolean1 = true;
          paramContext = null;
          continue;
        }
        paramContext = null;
        paramBoolean1 = false;
      }
    }
  }
  
  /* Error */
  @TargetApi(11)
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    throws Exception
  {
    // Byte code:
    //   0: ldc 25
    //   2: new 141	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 835
    //   12: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 837
    //   22: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload 4
    //   27: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   39: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: astore 29
    //   44: aload_0
    //   45: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +35 -> 83
    //   51: iload_2
    //   52: ifeq +20 -> 72
    //   55: aload 29
    //   57: bipush 148
    //   59: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   62: ldc 25
    //   64: ldc_w 839
    //   67: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload 29
    //   74: sipush -208
    //   77: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   80: goto -18 -> 62
    //   83: new 235	org/json/JSONObject
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 840	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   91: astore 30
    //   93: aload 30
    //   95: ldc_w 842
    //   98: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   101: istore 5
    //   103: iload 5
    //   105: ifeq +53 -> 158
    //   108: iload_2
    //   109: ifeq +38 -> 147
    //   112: aload 29
    //   114: bipush 147
    //   116: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   119: ldc 25
    //   121: new 141	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 844
    //   131: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload 5
    //   136: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: iconst_0
    //   146: ireturn
    //   147: aload 29
    //   149: sipush -209
    //   152: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   155: goto -36 -> 119
    //   158: aload 30
    //   160: ldc_w 846
    //   163: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 12
    //   168: iload 12
    //   170: putstatic 848	com/tencent/smtt/sdk/TbsDownloader:q	I
    //   173: aload 30
    //   175: ldc_w 850
    //   178: invokevirtual 852	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 28
    //   183: aload 28
    //   185: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +853 -> 1041
    //   191: iconst_1
    //   192: putstatic 854	com/tencent/smtt/sdk/TbsDownloader:n	Z
    //   195: aload 30
    //   197: ldc_w 856
    //   200: ldc 67
    //   202: invokevirtual 859	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: astore 31
    //   207: aload 30
    //   209: ldc_w 861
    //   212: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   215: istore 11
    //   217: iload 11
    //   219: putstatic 863	com/tencent/smtt/sdk/TbsDownloader:o	I
    //   222: aload 30
    //   224: ldc_w 865
    //   227: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   230: istore 13
    //   232: aload 30
    //   234: ldc_w 867
    //   237: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   240: istore 14
    //   242: aload 30
    //   244: ldc_w 869
    //   247: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   250: istore 15
    //   252: aload 30
    //   254: ldc_w 871
    //   257: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   260: istore 16
    //   262: aload 30
    //   264: ldc_w 873
    //   267: invokevirtual 876	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   270: lstore 21
    //   272: aload 30
    //   274: ldc_w 878
    //   277: invokevirtual 876	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   280: lstore 23
    //   282: lload 23
    //   284: putstatic 880	com/tencent/smtt/sdk/TbsDownloader:p	J
    //   287: aload 30
    //   289: ldc_w 882
    //   292: lconst_0
    //   293: invokevirtual 885	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   296: lstore 19
    //   298: aload 30
    //   300: ldc_w 887
    //   303: iconst_m1
    //   304: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   307: istore 17
    //   309: new 141	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 891
    //   319: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: iload 11
    //   324: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 289	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   333: ldc 67
    //   335: astore_0
    //   336: aload 28
    //   338: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifeq +707 -> 1048
    //   344: ldc_w 284
    //   347: astore_0
    //   348: new 141	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   355: ldc_w 893
    //   358: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_0
    //   362: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 289	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   371: iconst_0
    //   372: istore 5
    //   374: aload 30
    //   376: ldc_w 895
    //   379: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   382: istore 6
    //   384: iload 6
    //   386: istore 5
    //   388: aload 29
    //   390: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   393: ldc_w 897
    //   396: iload 5
    //   398: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: invokeinterface 308 3 0
    //   406: pop
    //   407: iload_2
    //   408: ifeq +59 -> 467
    //   411: getstatic 898	com/tencent/smtt/sdk/QbSdk:i	Z
    //   414: ifeq +53 -> 467
    //   417: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   420: invokestatic 273	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   423: ifeq +44 -> 467
    //   426: aload 30
    //   428: ldc_w 900
    //   431: iconst_0
    //   432: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   435: istore 5
    //   437: invokestatic 905	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   440: astore_0
    //   441: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   444: astore 25
    //   446: iload 5
    //   448: iconst_1
    //   449: if_icmpne +674 -> 1123
    //   452: iconst_1
    //   453: istore 18
    //   455: aload_0
    //   456: aload 25
    //   458: ldc_w 907
    //   461: iload 18
    //   463: invokevirtual 911	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   466: pop
    //   467: iload_2
    //   468: ifeq +229 -> 697
    //   471: aload 30
    //   473: ldc_w 913
    //   476: iconst_0
    //   477: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   480: istore 5
    //   482: iload 5
    //   484: iconst_1
    //   485: iand
    //   486: ifeq +676 -> 1162
    //   489: iconst_1
    //   490: istore 18
    //   492: invokestatic 905	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   495: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   498: ldc_w 915
    //   501: iload 18
    //   503: invokevirtual 911	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   506: pop
    //   507: ldc 25
    //   509: new 141	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 917
    //   519: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 18
    //   524: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 920	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: iload 5
    //   535: iconst_2
    //   536: iand
    //   537: ifeq +631 -> 1168
    //   540: iconst_1
    //   541: istore 18
    //   543: invokestatic 905	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   546: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   549: ldc_w 922
    //   552: iload 18
    //   554: invokevirtual 911	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   557: pop
    //   558: ldc 25
    //   560: new 141	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 924
    //   570: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: iload 18
    //   575: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 920	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: iload 5
    //   586: iconst_4
    //   587: iand
    //   588: ifeq +586 -> 1174
    //   591: iconst_1
    //   592: istore 18
    //   594: invokestatic 905	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   597: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   600: ldc_w 926
    //   603: iload 18
    //   605: invokevirtual 911	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   608: pop
    //   609: iload 18
    //   611: invokestatic 930	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   614: ldc 25
    //   616: new 141	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 932
    //   626: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: iload 18
    //   631: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   634: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: iload 5
    //   642: bipush 8
    //   644: iand
    //   645: ifeq +535 -> 1180
    //   648: iconst_1
    //   649: istore 18
    //   651: invokestatic 905	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   654: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   657: ldc_w 934
    //   660: iload 18
    //   662: invokevirtual 911	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   665: pop
    //   666: iload 18
    //   668: invokestatic 937	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   671: ldc 25
    //   673: new 141	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 939
    //   683: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: iload 18
    //   688: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   691: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aconst_null
    //   698: astore 25
    //   700: iconst_0
    //   701: istore 6
    //   703: iconst_0
    //   704: istore 8
    //   706: ldc 67
    //   708: astore 27
    //   710: aload 30
    //   712: ldc_w 941
    //   715: invokevirtual 852	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   718: astore_0
    //   719: aload 30
    //   721: ldc_w 943
    //   724: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   727: istore 5
    //   729: aload 30
    //   731: ldc_w 945
    //   734: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   737: istore 7
    //   739: aload 30
    //   741: ldc_w 947
    //   744: invokevirtual 950	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   747: ifeq +2602 -> 3349
    //   750: aload 30
    //   752: ldc_w 947
    //   755: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   758: istore 6
    //   760: iload 6
    //   762: ifeq +457 -> 1219
    //   765: iconst_1
    //   766: istore 6
    //   768: aload 27
    //   770: astore 25
    //   772: aload 27
    //   774: astore 26
    //   776: aload 30
    //   778: ldc_w 952
    //   781: invokevirtual 950	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   784: ifeq +17 -> 801
    //   787: aload 27
    //   789: astore 26
    //   791: aload 30
    //   793: ldc_w 952
    //   796: invokevirtual 852	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   799: astore 25
    //   801: aload 25
    //   803: astore 26
    //   805: aload 30
    //   807: ldc_w 954
    //   810: invokevirtual 950	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   813: ifeq +2530 -> 3343
    //   816: aload 25
    //   818: astore 26
    //   820: aload 30
    //   822: ldc_w 954
    //   825: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   828: istore 8
    //   830: iload 8
    //   832: ifeq +393 -> 1225
    //   835: iconst_1
    //   836: istore 18
    //   838: iload 7
    //   840: istore 8
    //   842: iload 6
    //   844: istore 9
    //   846: iload 5
    //   848: istore 7
    //   850: iload 8
    //   852: istore 6
    //   854: iload 9
    //   856: istore 5
    //   858: aload 30
    //   860: ldc_w 956
    //   863: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   866: istore 8
    //   868: iconst_0
    //   869: istore 9
    //   871: aload 30
    //   873: ldc_w 958
    //   876: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   879: istore 10
    //   881: iload 10
    //   883: istore 9
    //   885: getstatic 63	com/tencent/smtt/sdk/TbsDownloader:f	Ljava/lang/Object;
    //   888: astore 26
    //   890: aload 26
    //   892: monitorenter
    //   893: iload 5
    //   895: ifeq +19 -> 914
    //   898: aload 29
    //   900: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   903: ldc_w 960
    //   906: ldc 67
    //   908: invokeinterface 308 3 0
    //   913: pop
    //   914: aload 25
    //   916: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   919: ifne +58 -> 977
    //   922: aload 25
    //   924: invokevirtual 961	java/lang/String:length	()I
    //   927: bipush 96
    //   929: if_icmpne +48 -> 977
    //   932: new 141	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   939: aload 25
    //   941: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: ldc_w 963
    //   947: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokestatic 967	com/tencent/smtt/utils/g:c	()Ljava/lang/String;
    //   953: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: astore 25
    //   961: aload 29
    //   963: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   966: ldc_w 960
    //   969: aload 25
    //   971: invokeinterface 308 3 0
    //   976: pop
    //   977: aload 26
    //   979: monitorexit
    //   980: iload 7
    //   982: iconst_1
    //   983: if_icmpne +317 -> 1300
    //   986: iload_2
    //   987: ifeq +297 -> 1284
    //   990: aload 29
    //   992: bipush 146
    //   994: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   997: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1000: astore_0
    //   1001: iload 9
    //   1003: iconst_1
    //   1004: if_icmpne +291 -> 1295
    //   1007: iconst_1
    //   1008: istore_3
    //   1009: aload_0
    //   1010: iload_3
    //   1011: invokestatic 971	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   1014: ldc 25
    //   1016: new 141	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1023: ldc_w 973
    //   1026: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: iload_2
    //   1030: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1033: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1039: iconst_0
    //   1040: ireturn
    //   1041: iconst_0
    //   1042: putstatic 854	com/tencent/smtt/sdk/TbsDownloader:n	Z
    //   1045: goto -850 -> 195
    //   1048: aload 28
    //   1050: new 141	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1057: ldc 67
    //   1059: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: iload 11
    //   1064: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1067: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1070: invokevirtual 975	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1073: ifeq +10 -> 1083
    //   1076: ldc_w 505
    //   1079: astore_0
    //   1080: goto -732 -> 348
    //   1083: aload 28
    //   1085: astore_0
    //   1086: goto -738 -> 348
    //   1089: astore 25
    //   1091: ldc 25
    //   1093: new 141	java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1100: ldc_w 977
    //   1103: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: aload 25
    //   1108: invokestatic 644	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1111: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1120: goto -772 -> 348
    //   1123: iconst_0
    //   1124: istore 18
    //   1126: goto -671 -> 455
    //   1129: astore_0
    //   1130: ldc_w 979
    //   1133: new 141	java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1140: ldc_w 981
    //   1143: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: aload_0
    //   1147: invokevirtual 982	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1150: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1159: goto -692 -> 467
    //   1162: iconst_0
    //   1163: istore 18
    //   1165: goto -673 -> 492
    //   1168: iconst_0
    //   1169: istore 18
    //   1171: goto -628 -> 543
    //   1174: iconst_0
    //   1175: istore 18
    //   1177: goto -583 -> 594
    //   1180: iconst_0
    //   1181: istore 18
    //   1183: goto -532 -> 651
    //   1186: astore_0
    //   1187: ldc_w 979
    //   1190: new 141	java/lang/StringBuilder
    //   1193: dup
    //   1194: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1197: ldc_w 981
    //   1200: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: aload_0
    //   1204: invokevirtual 982	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1207: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1213: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1216: goto -519 -> 697
    //   1219: iconst_0
    //   1220: istore 6
    //   1222: goto -454 -> 768
    //   1225: iconst_0
    //   1226: istore 18
    //   1228: goto -390 -> 838
    //   1231: astore_0
    //   1232: iconst_0
    //   1233: istore 5
    //   1235: ldc 67
    //   1237: astore_0
    //   1238: iload 8
    //   1240: istore 7
    //   1242: iload 6
    //   1244: istore 8
    //   1246: aload 25
    //   1248: astore 26
    //   1250: iload 7
    //   1252: istore 6
    //   1254: iconst_1
    //   1255: istore 18
    //   1257: aload_0
    //   1258: astore 25
    //   1260: iload 8
    //   1262: istore 7
    //   1264: aload 26
    //   1266: astore_0
    //   1267: goto -409 -> 858
    //   1270: astore 26
    //   1272: iconst_0
    //   1273: istore 8
    //   1275: goto -407 -> 868
    //   1278: astore_0
    //   1279: aload 26
    //   1281: monitorexit
    //   1282: aload_0
    //   1283: athrow
    //   1284: aload 29
    //   1286: sipush -210
    //   1289: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1292: goto -295 -> 997
    //   1295: iconst_0
    //   1296: istore_3
    //   1297: goto -288 -> 1009
    //   1300: iload 18
    //   1302: ifne +10 -> 1312
    //   1305: aload 29
    //   1307: iload 18
    //   1309: invokevirtual 985	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1312: iload 8
    //   1314: iconst_1
    //   1315: if_icmpne +9 -> 1324
    //   1318: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1321: invokestatic 988	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1324: iload 6
    //   1326: iconst_1
    //   1327: if_icmpne +22 -> 1349
    //   1330: getstatic 544	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1333: bipush 104
    //   1335: invokevirtual 550	android/os/Handler:removeMessages	(I)V
    //   1338: getstatic 544	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1341: bipush 104
    //   1343: invokestatic 556	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1346: invokevirtual 568	android/os/Message:sendToTarget	()V
    //   1349: iload 17
    //   1351: iconst_1
    //   1352: if_icmpne +1980 -> 3332
    //   1355: lload 19
    //   1357: ldc2_w 989
    //   1360: lcmp
    //   1361: ifle +1979 -> 3340
    //   1364: ldc2_w 989
    //   1367: lstore 19
    //   1369: lload 19
    //   1371: lconst_0
    //   1372: lcmp
    //   1373: ifle +1959 -> 3332
    //   1376: invokestatic 993	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1379: lconst_0
    //   1380: lcmp
    //   1381: iflt +8 -> 1389
    //   1384: invokestatic 993	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1387: lstore 19
    //   1389: aload 29
    //   1391: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1394: ldc_w 995
    //   1397: lload 19
    //   1399: invokestatic 1000	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1402: invokeinterface 308 3 0
    //   1407: pop
    //   1408: iconst_0
    //   1409: istore 5
    //   1411: ldc 25
    //   1413: new 141	java/lang/StringBuilder
    //   1416: dup
    //   1417: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1420: ldc_w 1002
    //   1423: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: iload_2
    //   1427: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1436: iload_2
    //   1437: ifeq +312 -> 1749
    //   1440: aload 30
    //   1442: ldc_w 1004
    //   1445: invokevirtual 402	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1448: istore 6
    //   1450: iload 6
    //   1452: istore 5
    //   1454: iload 6
    //   1456: putstatic 1006	com/tencent/smtt/sdk/TbsDownloader:m	I
    //   1459: iload 6
    //   1461: istore 5
    //   1463: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1466: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1469: getfield 324	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1472: ldc_w 360
    //   1475: iconst_0
    //   1476: invokeinterface 342 3 0
    //   1481: istore 6
    //   1483: ldc 25
    //   1485: new 141	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1492: ldc_w 1008
    //   1495: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: iload 5
    //   1500: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: iload_2
    //   1510: ifeq +1819 -> 3329
    //   1513: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1516: invokestatic 273	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1519: ifne +1810 -> 3329
    //   1522: iload 5
    //   1524: ifne +1805 -> 3329
    //   1527: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1530: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1533: invokevirtual 503	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   1536: istore 5
    //   1538: ldc 25
    //   1540: new 141	java/lang/StringBuilder
    //   1543: dup
    //   1544: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1547: ldc_w 1010
    //   1550: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: iload 5
    //   1555: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1558: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1564: aload 29
    //   1566: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1569: ldc_w 1012
    //   1572: iload 5
    //   1574: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1577: invokeinterface 308 3 0
    //   1582: pop
    //   1583: aload 29
    //   1585: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1588: ldc_w 360
    //   1591: iload 6
    //   1593: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1596: invokeinterface 308 3 0
    //   1601: pop
    //   1602: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1605: invokestatic 273	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1608: ifne +46 -> 1654
    //   1611: iload 5
    //   1613: ifle +176 -> 1789
    //   1616: iload 5
    //   1618: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1621: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1624: invokevirtual 503	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   1627: if_icmpeq +162 -> 1789
    //   1630: iload 5
    //   1632: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1635: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1638: invokevirtual 456	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;)I
    //   1641: if_icmpne +148 -> 1789
    //   1644: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1647: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1650: invokevirtual 1014	com/tencent/smtt/sdk/p:o	(Landroid/content/Context;)Z
    //   1653: pop
    //   1654: aload 28
    //   1656: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1659: ifeq +155 -> 1814
    //   1662: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1665: invokestatic 273	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1668: ifeq +146 -> 1814
    //   1671: aload 29
    //   1673: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1676: ldc_w 1016
    //   1679: iconst_0
    //   1680: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1683: invokeinterface 308 3 0
    //   1688: pop
    //   1689: aload 29
    //   1691: invokevirtual 311	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1694: iload_2
    //   1695: ifeq +44 -> 1739
    //   1698: new 141	java/lang/StringBuilder
    //   1701: dup
    //   1702: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1705: ldc_w 1018
    //   1708: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: iload 11
    //   1713: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1716: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1719: astore_0
    //   1720: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1723: ldc_w 1020
    //   1726: aload_0
    //   1727: invokestatic 1023	com/tencent/smtt/utils/q:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1730: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1733: iload 11
    //   1735: iconst_0
    //   1736: invokestatic 1027	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1739: ldc 25
    //   1741: ldc_w 1029
    //   1744: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1747: iconst_0
    //   1748: ireturn
    //   1749: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1752: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1755: getfield 324	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1758: ldc_w 1012
    //   1761: iconst_0
    //   1762: invokeinterface 342 3 0
    //   1767: istore 6
    //   1769: iload 6
    //   1771: istore 5
    //   1773: goto -310 -> 1463
    //   1776: astore 25
    //   1778: goto -315 -> 1463
    //   1781: astore 25
    //   1783: iconst_0
    //   1784: istore 6
    //   1786: goto -303 -> 1483
    //   1789: iload 5
    //   1791: ifne -137 -> 1654
    //   1794: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   1797: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1800: invokevirtual 1032	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   1803: invokestatic 1035	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   1806: goto -152 -> 1654
    //   1809: astore 25
    //   1811: goto -157 -> 1654
    //   1814: ldc 25
    //   1816: new 141	java/lang/StringBuilder
    //   1819: dup
    //   1820: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1823: ldc_w 1037
    //   1826: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: iload 12
    //   1831: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1834: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1837: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1840: iload 12
    //   1842: ifne +130 -> 1972
    //   1845: aload 29
    //   1847: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1850: ldc_w 1039
    //   1853: iload 12
    //   1855: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1858: invokeinterface 308 3 0
    //   1863: pop
    //   1864: aload 29
    //   1866: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1869: ldc_w 1016
    //   1872: iconst_0
    //   1873: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1876: invokeinterface 308 3 0
    //   1881: pop
    //   1882: iload_2
    //   1883: ifeq +58 -> 1941
    //   1886: aload 29
    //   1888: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1891: ldc_w 1041
    //   1894: bipush 145
    //   1896: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1899: invokeinterface 308 3 0
    //   1904: pop
    //   1905: aload 29
    //   1907: invokevirtual 311	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1910: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1913: invokestatic 273	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1916: ifne +15 -> 1931
    //   1919: ldc 25
    //   1921: ldc_w 1043
    //   1924: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1927: invokestatic 1046	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1930: pop
    //   1931: ldc 25
    //   1933: ldc_w 1048
    //   1936: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1939: iconst_0
    //   1940: ireturn
    //   1941: aload 29
    //   1943: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1946: ldc_w 1041
    //   1949: sipush -211
    //   1952: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1955: invokeinterface 308 3 0
    //   1960: pop
    //   1961: aload 29
    //   1963: sipush -211
    //   1966: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1969: goto -64 -> 1905
    //   1972: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1975: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1978: getfield 324	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1981: ldc_w 448
    //   1984: iconst_0
    //   1985: invokeinterface 342 3 0
    //   1990: istore 8
    //   1992: iload 8
    //   1994: iload 11
    //   1996: if_icmple +18 -> 2014
    //   1999: getstatic 370	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2002: invokevirtual 1050	com/tencent/smtt/sdk/m:c	()V
    //   2005: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   2008: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2011: invokevirtual 1052	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)V
    //   2014: iconst_0
    //   2015: istore 5
    //   2017: iconst_0
    //   2018: istore 7
    //   2020: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2023: invokestatic 273	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   2026: ifne +66 -> 2092
    //   2029: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   2032: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2035: iconst_0
    //   2036: invokevirtual 1054	com/tencent/smtt/sdk/p:e	(Landroid/content/Context;I)I
    //   2039: istore 9
    //   2041: iload 7
    //   2043: istore 5
    //   2045: iload 9
    //   2047: iload 11
    //   2049: if_icmplt +6 -> 2055
    //   2052: iconst_1
    //   2053: istore 5
    //   2055: ldc 25
    //   2057: new 141	java/lang/StringBuilder
    //   2060: dup
    //   2061: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   2064: ldc_w 1056
    //   2067: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2070: iload 9
    //   2072: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2075: ldc_w 1058
    //   2078: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2081: iload 11
    //   2083: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2086: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2089: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2092: iload_1
    //   2093: iload 11
    //   2095: if_icmpge +16 -> 2111
    //   2098: aload 28
    //   2100: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2103: ifne +8 -> 2111
    //   2106: iload 5
    //   2108: ifeq +274 -> 2382
    //   2111: iload 6
    //   2113: iconst_1
    //   2114: if_icmpeq +268 -> 2382
    //   2117: aload 29
    //   2119: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2122: ldc_w 1016
    //   2125: iconst_0
    //   2126: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2129: invokeinterface 308 3 0
    //   2134: pop
    //   2135: iload_2
    //   2136: ifeq +172 -> 2308
    //   2139: aload 28
    //   2141: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2144: ifeq +87 -> 2231
    //   2147: aload 29
    //   2149: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2152: ldc_w 1041
    //   2155: bipush 132
    //   2157: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2160: invokeinterface 308 3 0
    //   2165: pop
    //   2166: aload 29
    //   2168: invokevirtual 311	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2171: ldc 25
    //   2173: new 141	java/lang/StringBuilder
    //   2176: dup
    //   2177: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   2180: ldc_w 1060
    //   2183: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: iload_1
    //   2187: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2190: ldc_w 1062
    //   2193: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: iload 11
    //   2198: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2201: ldc_w 1064
    //   2204: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2207: iload 8
    //   2209: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2212: ldc_w 1066
    //   2215: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: aload 28
    //   2220: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2226: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2229: iconst_0
    //   2230: ireturn
    //   2231: iload 11
    //   2233: ifgt +25 -> 2258
    //   2236: aload 29
    //   2238: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2241: ldc_w 1041
    //   2244: bipush 131
    //   2246: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2249: invokeinterface 308 3 0
    //   2254: pop
    //   2255: goto -89 -> 2166
    //   2258: iload_1
    //   2259: iload 11
    //   2261: if_icmplt +25 -> 2286
    //   2264: aload 29
    //   2266: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2269: ldc_w 1041
    //   2272: bipush 129
    //   2274: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2277: invokeinterface 308 3 0
    //   2282: pop
    //   2283: goto -117 -> 2166
    //   2286: aload 29
    //   2288: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2291: ldc_w 1041
    //   2294: bipush 144
    //   2296: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2299: invokeinterface 308 3 0
    //   2304: pop
    //   2305: goto -139 -> 2166
    //   2308: sipush -212
    //   2311: istore 5
    //   2313: aload 28
    //   2315: invokestatic 686	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2318: ifeq +37 -> 2355
    //   2321: sipush -217
    //   2324: istore 5
    //   2326: aload 29
    //   2328: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2331: ldc_w 1041
    //   2334: iload 5
    //   2336: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2339: invokeinterface 308 3 0
    //   2344: pop
    //   2345: aload 29
    //   2347: iload 5
    //   2349: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2352: goto -186 -> 2166
    //   2355: iload 11
    //   2357: ifgt +11 -> 2368
    //   2360: sipush -218
    //   2363: istore 5
    //   2365: goto -39 -> 2326
    //   2368: iload_1
    //   2369: iload 11
    //   2371: if_icmplt -45 -> 2326
    //   2374: sipush -219
    //   2377: istore 5
    //   2379: goto -53 -> 2326
    //   2382: aload 28
    //   2384: aload 29
    //   2386: getfield 324	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2389: ldc_w 1068
    //   2392: aconst_null
    //   2393: invokeinterface 332 3 0
    //   2398: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2401: ifne +45 -> 2446
    //   2404: getstatic 370	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2407: invokevirtual 1050	com/tencent/smtt/sdk/m:c	()V
    //   2410: aload 29
    //   2412: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2415: ldc_w 1070
    //   2418: iconst_0
    //   2419: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2422: invokeinterface 308 3 0
    //   2427: pop
    //   2428: aload 29
    //   2430: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2433: ldc_w 1072
    //   2436: iconst_0
    //   2437: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2440: invokeinterface 308 3 0
    //   2445: pop
    //   2446: aload 29
    //   2448: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2451: ldc_w 448
    //   2454: iload 11
    //   2456: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2459: invokeinterface 308 3 0
    //   2464: pop
    //   2465: ldc 25
    //   2467: new 141	java/lang/StringBuilder
    //   2470: dup
    //   2471: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   2474: ldc_w 1074
    //   2477: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2480: iload 11
    //   2482: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2485: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2488: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2491: iload 11
    //   2493: ifle +53 -> 2546
    //   2496: iload 6
    //   2498: iconst_1
    //   2499: if_icmpne +348 -> 2847
    //   2502: aload 29
    //   2504: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2507: ldc_w 1076
    //   2510: iconst_1
    //   2511: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2514: invokeinterface 308 3 0
    //   2519: pop
    //   2520: ldc 25
    //   2522: new 141	java/lang/StringBuilder
    //   2525: dup
    //   2526: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   2529: ldc_w 1078
    //   2532: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2535: iload 6
    //   2537: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2540: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2543: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2546: aload 29
    //   2548: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2551: ldc_w 1068
    //   2554: aload 28
    //   2556: invokeinterface 308 3 0
    //   2561: pop
    //   2562: aload 29
    //   2564: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2567: ldc_w 1080
    //   2570: aload 31
    //   2572: invokeinterface 308 3 0
    //   2577: pop
    //   2578: aload 29
    //   2580: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2583: ldc_w 1039
    //   2586: iload 12
    //   2588: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2591: invokeinterface 308 3 0
    //   2596: pop
    //   2597: aload 29
    //   2599: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2602: ldc_w 1082
    //   2605: iload 13
    //   2607: iconst_2
    //   2608: imul
    //   2609: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2612: invokeinterface 308 3 0
    //   2617: pop
    //   2618: aload 29
    //   2620: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2623: ldc_w 1084
    //   2626: iload 14
    //   2628: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2631: invokeinterface 308 3 0
    //   2636: pop
    //   2637: aload 29
    //   2639: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2642: ldc_w 1086
    //   2645: iload 15
    //   2647: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2650: invokeinterface 308 3 0
    //   2655: pop
    //   2656: aload 29
    //   2658: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2661: ldc_w 1088
    //   2664: iload 16
    //   2666: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2669: invokeinterface 308 3 0
    //   2674: pop
    //   2675: aload 29
    //   2677: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2680: ldc_w 1090
    //   2683: lload 21
    //   2685: invokestatic 1000	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2688: invokeinterface 308 3 0
    //   2693: pop
    //   2694: aload 29
    //   2696: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2699: ldc_w 1092
    //   2702: lload 23
    //   2704: invokestatic 1000	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2707: invokeinterface 308 3 0
    //   2712: pop
    //   2713: aload 29
    //   2715: invokevirtual 311	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2718: aload_0
    //   2719: ifnull +18 -> 2737
    //   2722: aload 29
    //   2724: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2727: ldc_w 1094
    //   2730: aload_0
    //   2731: invokeinterface 308 3 0
    //   2736: pop
    //   2737: iload_3
    //   2738: ifne +161 -> 2899
    //   2741: iload 4
    //   2743: ifeq +156 -> 2899
    //   2746: invokestatic 453	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   2749: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2752: iload 11
    //   2754: invokevirtual 1096	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;I)Z
    //   2757: ifeq +142 -> 2899
    //   2760: iload_2
    //   2761: ifeq +107 -> 2868
    //   2764: aload 29
    //   2766: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2769: ldc_w 1041
    //   2772: bipush 143
    //   2774: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2777: invokeinterface 308 3 0
    //   2782: pop
    //   2783: aload 29
    //   2785: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2788: ldc_w 1016
    //   2791: iconst_0
    //   2792: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2795: invokeinterface 308 3 0
    //   2800: pop
    //   2801: ldc 25
    //   2803: ldc_w 1098
    //   2806: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2809: aload 30
    //   2811: ldc_w 1100
    //   2814: iconst_0
    //   2815: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2818: iconst_1
    //   2819: if_icmpne +21 -> 2840
    //   2822: aload 29
    //   2824: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2827: ldc_w 1102
    //   2830: iconst_1
    //   2831: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2834: invokeinterface 308 3 0
    //   2839: pop
    //   2840: aload 29
    //   2842: invokevirtual 311	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2845: iconst_1
    //   2846: ireturn
    //   2847: aload 29
    //   2849: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2852: ldc_w 1076
    //   2855: iconst_0
    //   2856: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2859: invokeinterface 308 3 0
    //   2864: pop
    //   2865: goto -345 -> 2520
    //   2868: aload 29
    //   2870: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2873: ldc_w 1041
    //   2876: sipush -213
    //   2879: invokestatic 366	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2882: invokeinterface 308 3 0
    //   2887: pop
    //   2888: aload 29
    //   2890: sipush -213
    //   2893: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2896: goto -113 -> 2783
    //   2899: iload_3
    //   2900: ifne +155 -> 3055
    //   2903: iload 4
    //   2905: ifeq +150 -> 3055
    //   2908: getstatic 370	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2911: astore_0
    //   2912: iload 12
    //   2914: iconst_1
    //   2915: if_icmpeq +9 -> 2924
    //   2918: iload 12
    //   2920: iconst_2
    //   2921: if_icmpne +112 -> 3033
    //   2924: iconst_1
    //   2925: istore 4
    //   2927: aload_0
    //   2928: iload_3
    //   2929: iload 4
    //   2931: invokevirtual 1105	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   2934: ifeq +121 -> 3055
    //   2937: aload 29
    //   2939: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2942: ldc_w 1016
    //   2945: iconst_0
    //   2946: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2949: invokeinterface 308 3 0
    //   2954: pop
    //   2955: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2958: invokestatic 765	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2961: invokevirtual 769	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2964: astore_0
    //   2965: aload_0
    //   2966: bipush 100
    //   2968: invokevirtual 774	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2971: aload_0
    //   2972: new 141	java/lang/StringBuilder
    //   2975: dup
    //   2976: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   2979: ldc_w 1107
    //   2982: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2985: getstatic 370	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2988: getfield 1109	com/tencent/smtt/sdk/m:a	Ljava/lang/String;
    //   2991: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2994: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2997: invokevirtual 777	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3000: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3003: invokestatic 1111	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   3006: ifeq +33 -> 3039
    //   3009: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3012: invokestatic 765	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3015: getstatic 1114	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3018: aload_0
    //   3019: invokevirtual 787	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3022: ldc 25
    //   3024: ldc_w 1116
    //   3027: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3030: goto -221 -> 2809
    //   3033: iconst_0
    //   3034: istore 4
    //   3036: goto -109 -> 2927
    //   3039: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3042: invokestatic 765	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3045: getstatic 783	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3048: aload_0
    //   3049: invokevirtual 787	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3052: goto -30 -> 3022
    //   3055: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3058: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3061: getfield 324	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3064: ldc_w 1076
    //   3067: iconst_0
    //   3068: invokeinterface 342 3 0
    //   3073: iconst_1
    //   3074: if_icmpne +124 -> 3198
    //   3077: getstatic 370	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   3080: invokevirtual 1118	com/tencent/smtt/sdk/m:a	()Z
    //   3083: ifeq +115 -> 3198
    //   3086: aload 29
    //   3088: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3091: ldc_w 1016
    //   3094: iconst_0
    //   3095: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3098: invokeinterface 308 3 0
    //   3103: pop
    //   3104: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3107: invokestatic 765	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3110: invokevirtual 769	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3113: astore_0
    //   3114: aload_0
    //   3115: bipush 100
    //   3117: invokevirtual 774	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   3120: aload_0
    //   3121: new 141	java/lang/StringBuilder
    //   3124: dup
    //   3125: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   3128: ldc_w 1120
    //   3131: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3134: getstatic 370	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   3137: getfield 1109	com/tencent/smtt/sdk/m:a	Ljava/lang/String;
    //   3140: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3143: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3146: invokevirtual 777	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3149: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3152: invokestatic 1111	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   3155: ifeq +27 -> 3182
    //   3158: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3161: invokestatic 765	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3164: getstatic 1114	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3167: aload_0
    //   3168: invokevirtual 787	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3171: ldc 25
    //   3173: ldc_w 1122
    //   3176: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3179: goto -370 -> 2809
    //   3182: getstatic 90	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3185: invokestatic 765	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3188: getstatic 783	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3191: aload_0
    //   3192: invokevirtual 787	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3195: goto -24 -> 3171
    //   3198: iload_2
    //   3199: ifne +11 -> 3210
    //   3202: aload 29
    //   3204: sipush -216
    //   3207: invokevirtual 659	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3210: aload 29
    //   3212: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3215: ldc_w 1016
    //   3218: iconst_1
    //   3219: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3222: invokeinterface 308 3 0
    //   3227: pop
    //   3228: ldc 25
    //   3230: ldc_w 1124
    //   3233: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3236: goto -427 -> 2809
    //   3239: astore 26
    //   3241: goto -2356 -> 885
    //   3244: astore 25
    //   3246: aload_0
    //   3247: astore 25
    //   3249: ldc 67
    //   3251: astore_0
    //   3252: iconst_0
    //   3253: istore 5
    //   3255: iload 8
    //   3257: istore 7
    //   3259: goto -2017 -> 1242
    //   3262: astore 25
    //   3264: iload 5
    //   3266: istore 6
    //   3268: aload_0
    //   3269: astore 25
    //   3271: iconst_0
    //   3272: istore 5
    //   3274: ldc 67
    //   3276: astore_0
    //   3277: iload 8
    //   3279: istore 7
    //   3281: goto -2039 -> 1242
    //   3284: astore 25
    //   3286: iload 5
    //   3288: istore 6
    //   3290: aload_0
    //   3291: astore 25
    //   3293: ldc 67
    //   3295: astore_0
    //   3296: iconst_0
    //   3297: istore 5
    //   3299: goto -2057 -> 1242
    //   3302: astore 25
    //   3304: iload 5
    //   3306: istore 8
    //   3308: aload_0
    //   3309: astore 25
    //   3311: aload 26
    //   3313: astore_0
    //   3314: iload 6
    //   3316: istore 5
    //   3318: iload 8
    //   3320: istore 6
    //   3322: goto -2080 -> 1242
    //   3325: astore_0
    //   3326: goto -2938 -> 388
    //   3329: goto -1791 -> 1538
    //   3332: ldc2_w 1125
    //   3335: lstore 19
    //   3337: goto -1961 -> 1376
    //   3340: goto -1971 -> 1369
    //   3343: iconst_1
    //   3344: istore 18
    //   3346: goto -2508 -> 838
    //   3349: iconst_0
    //   3350: istore 6
    //   3352: goto -2584 -> 768
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3355	0	paramString	String
    //   0	3355	1	paramInt	int
    //   0	3355	2	paramBoolean1	boolean
    //   0	3355	3	paramBoolean2	boolean
    //   0	3355	4	paramBoolean3	boolean
    //   101	3216	5	i1	int
    //   382	2969	6	i2	int
    //   737	2543	7	i3	int
    //   704	2615	8	i4	int
    //   844	1227	9	i5	int
    //   879	3	10	i6	int
    //   215	2538	11	i7	int
    //   166	2756	12	i8	int
    //   230	2379	13	i9	int
    //   240	2387	14	i10	int
    //   250	2396	15	i11	int
    //   260	2405	16	i12	int
    //   307	1046	17	i13	int
    //   453	2892	18	bool	boolean
    //   296	3040	19	l1	long
    //   270	2414	21	l2	long
    //   280	2423	23	l3	long
    //   444	526	25	localObject1	Object
    //   1089	158	25	localThrowable1	Throwable
    //   1258	1	25	str1	String
    //   1776	1	25	localException1	Exception
    //   1781	1	25	localException2	Exception
    //   1809	1	25	localThrowable2	Throwable
    //   3244	1	25	localException3	Exception
    //   3247	1	25	str2	String
    //   3262	1	25	localException4	Exception
    //   3269	1	25	str3	String
    //   3284	1	25	localException5	Exception
    //   3291	1	25	str4	String
    //   3302	1	25	localException6	Exception
    //   3309	1	25	str5	String
    //   774	491	26	localObject2	Object
    //   1270	10	26	localException7	Exception
    //   3239	73	26	localException8	Exception
    //   708	80	27	str6	String
    //   181	2374	28	str7	String
    //   42	3169	29	localTbsDownloadConfig	TbsDownloadConfig
    //   91	2719	30	localJSONObject	JSONObject
    //   205	2366	31	str8	String
    // Exception table:
    //   from	to	target	type
    //   336	344	1089	java/lang/Throwable
    //   1048	1076	1089	java/lang/Throwable
    //   426	446	1129	java/lang/Throwable
    //   455	467	1129	java/lang/Throwable
    //   471	482	1186	java/lang/Throwable
    //   492	533	1186	java/lang/Throwable
    //   543	584	1186	java/lang/Throwable
    //   594	640	1186	java/lang/Throwable
    //   651	697	1186	java/lang/Throwable
    //   710	719	1231	java/lang/Exception
    //   858	868	1270	java/lang/Exception
    //   898	914	1278	finally
    //   914	977	1278	finally
    //   977	980	1278	finally
    //   1279	1282	1278	finally
    //   1440	1450	1776	java/lang/Exception
    //   1454	1459	1776	java/lang/Exception
    //   1749	1769	1776	java/lang/Exception
    //   1463	1483	1781	java/lang/Exception
    //   1794	1806	1809	java/lang/Throwable
    //   871	881	3239	java/lang/Exception
    //   719	729	3244	java/lang/Exception
    //   729	739	3262	java/lang/Exception
    //   739	760	3284	java/lang/Exception
    //   776	787	3302	java/lang/Exception
    //   791	801	3302	java/lang/Exception
    //   805	816	3302	java/lang/Exception
    //   820	830	3302	java/lang/Exception
    //   374	384	3325	java/lang/Exception
  }
  
  protected static File b(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject = null;
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      String str1;
      String str2;
      if (i1 < i2)
      {
        str1 = arrayOfString[i1];
        str2 = FileUtil.a(c, str1, 4, false);
        if (!getOverSea(c)) {
          break label110;
        }
      }
      label110:
      for (localObject = "x5.oversea.tbs.org";; localObject = getBackupFileName(false))
      {
        localObject = new File(str2, (String)localObject);
        if ((localObject == null) || (!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      localObject = new File(FileUtil.a(c, str1, 4, false), "x5.tbs.decouple");
      if ((localObject != null) && (((File)localObject).exists()) && (a.a(c, (File)localObject) == paramInt))
      {
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      i1 += 1;
    }
  }
  
  static String b(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    localObject = Build.VERSION.RELEASE;
    try
    {
      String str = new String(((String)localObject).getBytes("UTF-8"), "ISO8859-1");
      localObject = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        if (((String)localObject).length() > 0)
        {
          localStringBuffer.append((String)localObject);
        }
        else
        {
          localStringBuffer.append("1.0");
          continue;
          localStringBuffer.append("en");
        }
      }
    }
    if (localObject == null)
    {
      localStringBuffer.append("1.0");
      localStringBuffer.append("; ");
      localObject = localLocale.getLanguage();
      if (localObject == null) {
        break label256;
      }
      localStringBuffer.append(((String)localObject).toLowerCase());
      localObject = localLocale.getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(((String)localObject).toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = q.d(paramContext);
      }
    }
    try
    {
      localObject = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = (Context)localObject;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        continue;
        if (paramContext.length() > 0)
        {
          localStringBuffer.append("; ");
          localStringBuffer.append(paramContext);
          continue;
          paramContext = Build.ID;
          continue;
          if (paramContext.length() > 0)
          {
            localStringBuffer.append(" Build/");
            localStringBuffer.append(paramContext);
          }
        }
      }
    }
    if (paramContext == null)
    {
      localStringBuffer.append("; ");
      if (Build.ID != null) {
        break label295;
      }
      paramContext = "";
      paramContext = paramContext.replaceAll("[一-龥]", "");
      if (paramContext != null) {
        break label302;
      }
      localStringBuffer.append(" Build/");
      localStringBuffer.append("00");
      paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
      b = paramContext;
      return paramContext;
    }
  }
  
  private static void b(JSONArray paramJSONArray)
  {
    int i3 = 0;
    int i4;
    int i1;
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      i4 = p.a().a(TbsShareManager.getHostCorePathAppDefined());
      i1 = 0;
    }
    for (;;)
    {
      int i2 = i3;
      if (i1 < paramJSONArray.length())
      {
        if (paramJSONArray.optInt(i1) == i4) {
          i2 = 1;
        }
      }
      else
      {
        if (i2 == 0)
        {
          TbsLog.i("TbsDownload", "addAppDefinedToCoreVersions, version=" + i4);
          paramJSONArray.put(i4);
        }
        return;
      }
      i1 += 1;
    }
  }
  
  private static boolean b(final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(144));
      ((TbsDownloadUpload)localObject1).commit();
      m.b(c);
      if ((QbSdk.o == null) || (!QbSdk.o.containsKey("SET_SENDREQUEST_AND_UPLOAD")) || (!QbSdk.o.get("SET_SENDREQUEST_AND_UPLOAD").equals("false"))) {
        break label212;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      if (!paramBoolean1) {
        break label172;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(145));
      ((TbsDownloadUpload)localObject1).commit();
      label128:
      paramBoolean3 = false;
    }
    for (;;)
    {
      return paramBoolean3;
      if (paramBoolean3) {
        break;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(164));
      ((TbsDownloadUpload)localObject1).commit();
      break;
      label172:
      if (paramBoolean3) {
        break label128;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(165));
      ((TbsDownloadUpload)localObject1).commit();
      break label128;
      label212:
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
      if (p.a().d(c))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
        if (paramBoolean1)
        {
          localObject1 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(146));
          ((TbsDownloadUpload)localObject1).commit();
        }
        for (;;)
        {
          return false;
          if (!paramBoolean3)
          {
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(166));
            ((TbsDownloadUpload)localObject1).commit();
          }
        }
      }
      TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
      Object localObject5 = FileUtil.a(c, 1);
      if (getOverSea(c))
      {
        localObject1 = "x5.oversea.tbs.org";
        new File((String)localObject5, (String)localObject1);
        localObject5 = FileUtil.a(c, 2);
        if (!getOverSea(c)) {
          break label1088;
        }
        localObject1 = "x5.oversea.tbs.org";
        label409:
        new File((String)localObject5, (String)localObject1);
        localObject5 = FileUtil.a(c, 3);
        if (!getOverSea(c)) {
          break label1097;
        }
        localObject1 = "x5.oversea.tbs.org";
        label443:
        new File((String)localObject5, (String)localObject1);
        localObject5 = FileUtil.a(c, 4);
        if (!getOverSea(c)) {
          break label1106;
        }
        localObject1 = "x5.oversea.tbs.org";
        label477:
        new File((String)localObject5, (String)localObject1);
        if (e == null)
        {
          e = b.a();
          localTbsDownloadConfig.mSyncMap.put("device_cpuabi", e);
          localTbsDownloadConfig.commit();
        }
        i1 = 0;
        i2 = i1;
        if (!TextUtils.isEmpty(e)) {
          localObject1 = null;
        }
      }
      label560:
      label744:
      label1134:
      label1393:
      try
      {
        localObject5 = Pattern.compile("i686|mips|x86_64").matcher(e);
        localObject1 = localObject5;
      }
      catch (Exception localException7)
      {
        label627:
        JSONObject localJSONObject;
        int i3;
        label760:
        break label560;
      }
      int i2 = i1;
      if (localObject1 != null)
      {
        i2 = i1;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(c)) {
            break label1134;
          }
          TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
          localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
          if (!paramBoolean1) {
            break label1115;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + e);
          TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          label668:
          i2 = 1;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("app_versionname", b.d(c));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.e(c)));
      localTbsDownloadConfig.commit();
      localJSONObject = a(paramBoolean1, paramBoolean2, paramBoolean3);
      i3 = -1;
      try
      {
        i1 = localJSONObject.getInt("TBSV");
        i3 = i1;
      }
      catch (Exception localException6)
      {
        int i4;
        break label744;
      }
      i4 = -1;
      try
      {
        i1 = localJSONObject.getInt("REQUEST_TPATCH");
        i4 = i1;
      }
      catch (Exception localException5)
      {
        int i5;
        break label760;
      }
      i5 = -1;
      try
      {
        i1 = localJSONObject.getInt("TBSDV");
        i5 = i1;
      }
      catch (Exception localException4)
      {
        label777:
        int i6;
        break label777;
      }
      i6 = -1;
      try
      {
        i1 = localJSONObject.getInt("TBSBACKUPV");
        i6 = i1;
      }
      catch (Exception localException3)
      {
        label794:
        int i7;
        break label794;
      }
      int i1 = -1;
      i7 = i1;
      try
      {
        label1088:
        label1097:
        label1106:
        label1115:
        Object localObject2;
        for (;;)
        {
          if (localJSONObject.has("REQUEST_64")) {
            i7 = localJSONObject.getInt("REQUEST_64");
          }
          i1 = -1;
          try
          {
            if (localJSONObject.has("FUNCTION")) {
              i1 = localJSONObject.getInt("FUNCTION");
            }
            if ((i2 != 0) || (i3 != -1))
            {
              long l2 = System.currentTimeMillis();
              if (TbsShareManager.isThirdPartyApp(c))
              {
                l1 = localTbsDownloadConfig.mPreferences.getLong("request_fail", 0L);
                long l3 = localTbsDownloadConfig.mPreferences.getLong("count_request_fail_in_24hours", 0L);
                if (l2 - l1 < localTbsDownloadConfig.getRetryInterval() * 1000L)
                {
                  l1 = 1L + l3;
                  localTbsDownloadConfig.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(l1));
                }
              }
              else
              {
                localTbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(l2));
                localTbsDownloadConfig.mSyncMap.put("app_versionname", b.d(c));
                localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.e(c)));
                localTbsDownloadConfig.mSyncMap.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
                localTbsDownloadConfig.commit();
                if (i2 == 0) {
                  break label1213;
                }
                if (!paramBoolean1) {
                  break label1173;
                }
                localObject1 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
                ((TbsDownloadUpload)localObject1).commit();
                return false;
                localObject1 = getBackupFileName(false);
                break;
                localObject1 = getBackupFileName(false);
                break label409;
                localObject1 = getBackupFileName(false);
                break label443;
                localObject1 = getBackupFileName(false);
                break label477;
                localTbsDownloadConfig.setDownloadInterruptCode(-205);
                ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
                break label627;
                if (paramBoolean1)
                {
                  localTbsDownloadConfig.setDownloadInterruptCode(-104);
                  break label668;
                }
                localTbsDownloadConfig.setDownloadInterruptCode(-205);
              }
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              i1 = -1;
              continue;
              long l1 = 1L;
              continue;
              label1173:
              if (!paramBoolean3)
              {
                localObject2 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject2).a.put("tbs_startdownload_code", Integer.valueOf(167));
                ((TbsDownloadUpload)localObject2).commit();
              }
            }
            label1213:
            if (i3 != -1) {
              break label1223;
            }
          }
        }
        if (paramBoolean3) {}
        for (;;)
        {
          try
          {
            label1223:
            str = com.tencent.smtt.utils.n.a(c).g();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + str);
            if (paramBoolean1)
            {
              localObject2 = TbsDownloadUpload.getInstance(c);
              ((TbsDownloadUpload)localObject2).a.put("tbs_needdownload_code", Integer.valueOf(148));
              ((TbsDownloadUpload)localObject2).a.put("tbs_needdownload_sent", Integer.valueOf(1));
              ((TbsDownloadUpload)localObject2).commit();
              TbsLog.i("TbsDownload", "sendRequest query 148");
              if (!paramBoolean1) {
                continue;
              }
              r = localJSONObject;
              label1332:
              localObject5 = null;
              boolean bool = q.e(c);
              localObject2 = localObject5;
              if (!bool) {}
            }
          }
          catch (Throwable localThrowable3)
          {
            String str;
            Object localObject3;
            Object localObject4;
            paramBoolean2 = false;
            continue;
          }
          try
          {
            i2 = localJSONObject.getInt("FUNCTION");
            if ((i2 != 0) || (TextUtils.isEmpty(com.tencent.smtt.utils.n.a(c).f()))) {
              continue;
            }
            localObject2 = com.tencent.smtt.utils.n.a(c).f();
          }
          catch (Throwable localThrowable2)
          {
            localObject4 = localObject5;
          }
        }
        localObject5 = localObject2;
        if (localObject2 == null)
        {
          if (!paramBoolean1) {
            break label1992;
          }
          localObject2 = "requesttpatch=is=" + i4;
          localObject2 = (String)localObject2 + "_" + "tbsdv=is=" + i5;
          localObject2 = (String)localObject2 + "_" + "tbsbackupv=is=" + i6;
          localObject2 = (String)localObject2 + "_" + "request64=is=" + i7;
          q.b(c, "request_query", (String)localObject2);
          localObject2 = (String)localObject2 + "_" + "mTBSVLARR=is=" + j;
          q.a(c, "request_query", (String)localObject2);
        }
        for (;;)
        {
          localObject5 = f.a(str, localJSONObject.toString().getBytes("utf-8"), new f.a()
          {
            public void a(int paramAnonymousInt)
            {
              long l = System.currentTimeMillis();
              this.a.mSyncMap.put("last_check", Long.valueOf(l));
              this.a.commit();
              TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramAnonymousInt);
              if ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (paramAnonymousInt == 200))
              {
                this.a.mSyncMap.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
                this.a.mSyncMap.put("request_fail", Long.valueOf(0L));
                this.a.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(0L));
                this.a.commit();
              }
              if (paramAnonymousInt >= 300)
              {
                if (paramBoolean1) {
                  this.a.setDownloadInterruptCode(-107);
                }
              }
              else {
                return;
              }
              this.a.setDownloadInterruptCode(-207);
            }
          }, false);
          paramBoolean2 = a((String)localObject5, i3, paramBoolean1, paramBoolean2, paramBoolean4);
          try
          {
            TbsLog.i("TbsDownload", "sendrequest return false #2");
            if (!paramBoolean1) {
              break label2385;
            }
            localObject2 = "needStartDownload=is=" + paramBoolean2;
            localObject2 = (String)localObject2 + "_" + "DECOUPLECOREVERSION=is=" + m;
            localObject2 = (String)localObject2 + "_" + "DOWNLOADURLEmpty=is=" + n;
            localObject2 = (String)localObject2 + "_" + "TBSAPKSERVERVERSION=is=" + o;
            q.b(c, "response_query", (String)localObject2);
            q.a(c, "response_query", (String)localObject2);
            return paramBoolean2;
          }
          catch (Throwable localThrowable1) {}
          TbsLog.i("TbsDownload", "sendrequest return false " + Log.getStackTraceString(localThrowable1));
          localThrowable1.printStackTrace();
          if (!paramBoolean1) {
            break label2750;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-106);
          return paramBoolean2;
          if (paramBoolean3) {
            break;
          }
          localObject3 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_code", Integer.valueOf(168));
          ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_sent", Integer.valueOf(1));
          ((TbsDownloadUpload)localObject3).commit();
          TbsLog.i("TbsDownload", "sendRequest download 168");
          break;
          s = localJSONObject;
          break label1332;
          if ((i2 == 1) && (!TextUtils.isEmpty(com.tencent.smtt.utils.n.a(c).e())))
          {
            localObject3 = com.tencent.smtt.utils.n.a(c).e();
            break label1393;
          }
          localObject3 = localObject5;
          if (i2 != 2) {
            break label1393;
          }
          localObject3 = localObject5;
          if (TextUtils.isEmpty(com.tencent.smtt.utils.n.a(c).d())) {
            break label1393;
          }
          localObject3 = com.tencent.smtt.utils.n.a(c).d();
          break label1393;
          label1992:
          if (paramBoolean3)
          {
            localObject3 = "requesttpatch=is=" + i4;
            localObject3 = (String)localObject3 + "_" + "tbsdv=is=" + i5;
            localObject3 = (String)localObject3 + "_" + "tbsbackupv=is=" + i6;
            localObject3 = (String)localObject3 + "_" + "request64=is=" + i7;
            localObject3 = (String)localObject3 + "_" + "functionUpload=is=" + i1;
            q.b(c, "request_download_update", (String)localObject3);
          }
          else if (TbsShareManager.isThirdPartyApp(c))
          {
            localObject3 = "requesttpatch=is=" + i4;
            localObject3 = (String)localObject3 + "_" + "tbsdv=is=" + i5;
            localObject3 = (String)localObject3 + "_" + "tbsbackupv=is=" + i6;
            localObject3 = (String)localObject3 + "_" + "request64=is=" + i7;
            localObject3 = (String)localObject3 + "_" + "functionUpload=is=" + i1;
            localObject3 = (String)localObject3 + "_" + "tbsLocalVersion=is=" + i3;
            q.a(c, "request_download_update", (String)localObject3);
          }
        }
        label2385:
        if (paramBoolean3)
        {
          localObject3 = "needStartDownload=is=" + paramBoolean2;
          localObject3 = (String)localObject3 + "_" + "RESPONSECODE=is=" + q;
          localObject3 = (String)localObject3 + "_" + "DOWNLOADURLEmpty=is=" + n;
          localObject3 = (String)localObject3 + "_" + "TBSAPKSERVERVERSION=is=" + o;
          localObject3 = (String)localObject3 + "_" + "TBSAPKFILESIZE=is=" + p;
          q.b(c, "response_download_update", (String)localObject3);
          return paramBoolean2;
        }
        paramBoolean3 = paramBoolean2;
        if (!TbsShareManager.isThirdPartyApp(c)) {
          continue;
        }
        localObject3 = "needStartDownload=is=" + paramBoolean2;
        localObject3 = (String)localObject3 + "_" + "RESPONSECODE=is=" + q;
        localObject3 = (String)localObject3 + "_" + "DOWNLOADURLEmpty=is=" + n;
        localObject3 = (String)localObject3 + "_" + "TBSAPKSERVERVERSION=is=" + o;
        localObject3 = (String)localObject3 + "_" + "TBSAPKFILESIZE=is=" + p;
        q.a(c, "response_download_update", (String)localObject3);
        return paramBoolean2;
        label2750:
        localTbsDownloadConfig.setDownloadInterruptCode(-206);
        return paramBoolean2;
        if (paramBoolean1)
        {
          localObject3 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_code", Integer.valueOf(149));
          ((TbsDownloadUpload)localObject3).commit();
          return false;
        }
        if (!paramBoolean3)
        {
          localObject3 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_code", Integer.valueOf(169));
          ((TbsDownloadUpload)localObject3).commit();
        }
        return false;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i7 = i1;
        }
      }
    }
  }
  
  private static void c(int paramInt)
  {
    int i3 = 1;
    long l1;
    try
    {
      TbsLog.i("TbsDownload", "sendRequestForOtherStableCore cpuType is " + paramInt + " mJsonDataQuery is " + r + " mJsonDataDownloadUpdate is " + s);
      if (!q.b(c))
      {
        TbsLog.i("TbsDownload", "sendRequestForOtherStableCore isStableCoreForHostEnable is false and return ");
        return;
      }
      if (paramInt < 32) {
        break label1352;
      }
      if (r == null) {
        r = s;
      }
      if (r == null) {
        break label1352;
      }
      l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_stable_core_other_cpu", 0L);
      if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
      {
        TbsLog.i("TbsDownload", "sendRequestForOtherStableCore less than and return ");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.d("TbsDownload", "stack is " + Log.getStackTraceString(localThrowable));
      return;
    }
    if (paramInt == 64) {
      r.put("REQUEST_64", 1);
    }
    label1342:
    label1347:
    label1352:
    label1353:
    label1358:
    for (int i1 = 1;; i1 = -1)
    {
      r.put("DOWNLOADDECOUPLECORE", 1);
      if (paramInt == 64)
      {
        if (n.a(c).c("stable_64_tpatch_fail") != 1) {
          break label1347;
        }
        TbsLog.i("TbsDownload", "sendRequestForOtherStableCore stable_64_last_tpatch_fail and set REQUEST_TPATCH  0 ");
        break label1353;
      }
      for (;;)
      {
        r.put("REQUEST_TPATCH", i2);
        int i4 = TbsShareManager.getTbsStableCoreVersion(c, paramInt);
        r.put("TBSDV", i4);
        r.put("TBSBACKUPV", i4);
        if (i2 == 0)
        {
          r.put("TBSDV", 0);
          r.put("TBSBACKUPV", 0);
        }
        if (i4 > 0) {
          r.put("FUNCTION", 1);
        }
        String str1;
        String str2;
        for (;;)
        {
          r.put("TBSV", 0);
          localObject = com.tencent.smtt.utils.n.a(c).g();
          TbsLog.i("TbsDownload", "[TbsDownloader.sendRequestForOtherStableCore] postUrl=" + (String)localObject);
          TbsLog.i("TbsDownload", "[TbsDownloader.sendRequestForOtherStableCore] mJsonDataQuery=" + r.toString());
          t = r;
          str1 = "requesttpatch=is=" + i2;
          str1 = str1 + "_" + "tbsdv=is=" + i4;
          str1 = str1 + "_" + "tbsbackupv=is=" + i4;
          str1 = str1 + "_" + "request64=is=" + i1;
          str1 = str1 + "_" + "functionUpload=is=" + i3;
          q.b(c, "request_download_update_other", str1);
          localObject = f.a((String)localObject, r.toString().getBytes("utf-8"), new f.a()
          {
            public void a(int paramAnonymousInt) {}
          }, false);
          TbsLog.i("TbsDownload", "[TbsDownloader.sendRequestForOtherStableCore] response=" + (String)localObject);
          localObject = new JSONObject((String)localObject);
          TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_stable_core_other_cpu", Long.valueOf(System.currentTimeMillis()));
          TbsDownloadConfig.getInstance(c).commit();
          str2 = ((JSONObject)localObject).getString("DOWNLOADURL");
          l1 = ((JSONObject)localObject).getLong("TBSAPKFILESIZE");
          str1 = ((JSONObject)localObject).getString("PKGMD5");
          i1 = ((JSONObject)localObject).getInt("TBSAPKSERVERVERSION");
          i2 = ((JSONObject)localObject).getInt("RESPONSECODE");
          if (!q.b(c)) {
            break label1342;
          }
          i3 = TbsShareManager.getTbsStableCoreVersion(c, paramInt);
          localObject = "newcore=is=" + i1;
          localObject = (String)localObject + "_" + "oldcore=is=" + i3;
          localObject = (String)localObject + "_" + "RESPONSECODE=is=" + i2;
          localObject = (String)localObject + "_" + "DOWNLOADURLEmpty=is=" + TextUtils.isEmpty(str2);
          localObject = (String)localObject + "_" + "TBSAPKSERVERVERSION=is=" + i1;
          localObject = (String)localObject + "_" + "TBSAPKFILESIZE=is=" + l1;
          q.b(c, "response_download_update_other", (String)localObject);
          if (i3 >= i1) {
            break label1342;
          }
          if (!a(i1, i3, paramInt)) {
            break;
          }
          localObject = TbsDownloadConfig.getInstance(c);
          ((TbsDownloadConfig)localObject).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(paramInt));
          ((TbsDownloadConfig)localObject).commit();
          TbsLog.i("TbsDownload", "sendRequestForOtherStableCore stable core " + i1 + " copy from old backup and return ");
          localObject = "oldcore=is=" + i3;
          localObject = (String)localObject + "_" + "newcore=is=" + i1;
          q.b(c, "copy_other_cpu_core_ok", (String)localObject);
          return;
          if (paramInt != 32) {
            break label1358;
          }
          r.remove("REQUEST_64");
          break label1358;
          if (n.a(c).c("stable_32_tpatch_fail") != 1) {
            break label1347;
          }
          TbsLog.i("TbsDownload", "sendRequestForOtherStableCore stable_32_last_tpatch_fail and set REQUEST_TPATCH  0 ");
          break label1353;
          r.put("FUNCTION", 0);
          i3 = 0;
        }
        TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
        localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", str2);
        localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Long.valueOf(l1));
        localTbsDownloadConfig.mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(paramInt));
        Map localMap = localTbsDownloadConfig.mSyncMap;
        Object localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
        localMap.put("tbs_apk_md5", localObject);
        localTbsDownloadConfig.mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(1));
        localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(i1));
        localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(i2));
        localTbsDownloadConfig.commit();
        TbsLog.i("TbsDownload", "sendRequestForOtherStableCore downloadUrl is " + str2, true);
        if (!TextUtils.isEmpty(str2)) {
          g.b(false, true);
        }
        d(paramInt);
        return;
        int i2 = 1;
        continue;
        return;
        i2 = 0;
      }
    }
  }
  
  @TargetApi(11)
  static void c(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    m.e(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label99;
      }
    }
    label99:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  private static void c(JSONArray paramJSONArray)
  {
    String str;
    int i4;
    Context localContext;
    if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore())
    {
      String[] arrayOfString = f();
      int i3 = arrayOfString.length;
      int i1 = 0;
      if (i1 < i3)
      {
        str = arrayOfString[i1];
        i4 = TbsShareManager.getBackupCoreVersion(c, str);
        if (i4 > 0)
        {
          localContext = TbsShareManager.getPackageContext(c, str, false);
          if ((localContext != null) && (!p.a().g(localContext))) {
            TbsLog.e("TbsDownload", "addBackupVersionToJsonData,host check failed,packageName = " + str);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (!a(c, i4)) {
              break label155;
            }
            TbsLog.i("TbsDownload", "add addBackupVersionToJsonData,version+" + i4 + " is in black list");
          }
          label155:
          i2 = 0;
          label157:
          if (i2 >= paramJSONArray.length()) {
            break label389;
          }
          if (paramJSONArray.optInt(i2) != i4) {
            break label296;
          }
        }
      }
    }
    label387:
    label389:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0)
      {
        TbsLog.i("TbsDownload", "addBackupVersionToJsonData,pkg=" + str + ";version=" + i4);
        paramJSONArray.put(i4);
      }
      i4 = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
      if (i4 <= 0) {
        break;
      }
      localContext = TbsShareManager.getPackageContext(c, str, false);
      if ((localContext != null) && (!p.a().g(localContext)))
      {
        TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
        break;
        label296:
        i2 += 1;
        break label157;
      }
      i2 = 0;
      label305:
      if (i2 < paramJSONArray.length()) {
        if (paramJSONArray.optInt(i2) != i4) {}
      }
      for (i2 = 1;; i2 = 0)
      {
        if (i2 != 0) {
          break label387;
        }
        TbsLog.i("TbsDownload", "addBackupVersionToJsonDataByDecouple,pkg=" + str + ";version=" + i4);
        paramJSONArray.put(i4);
        break;
        i2 += 1;
        break label305;
        return;
      }
      break;
    }
  }
  
  private static boolean c()
  {
    boolean bool2 = false;
    try
    {
      String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
      int i2 = arrayOfString.length;
      int i1 = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i1 < i2)
        {
          String str = arrayOfString[i1];
          int i3 = TbsShareManager.getSharedTbsCoreVersion(c, str);
          if (i3 > 0) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i1 += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void d()
  {
    try
    {
      if (h == null) {
        h = o.a();
      }
      try
      {
        g = new m(c);
        d = new Handler(h.getLooper())
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            Object localObject1 = null;
            boolean bool3 = true;
            switch (paramAnonymousMessage.what)
            {
            }
            label85:
            label254:
            do
            {
              boolean bool1;
              Object localObject2;
              for (;;)
              {
                return;
                if (paramAnonymousMessage.arg1 == 1)
                {
                  i = 1;
                  if (paramAnonymousMessage.arg2 != 1) {
                    break label254;
                  }
                  bool1 = true;
                  bool1 = TbsDownloader.a(true, false, false, bool1);
                  if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
                  {
                    TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + bool1);
                    localObject2 = "";
                    localObject1 = localObject2;
                    if (TbsDownloader.a() != null)
                    {
                      localObject1 = localObject2;
                      if (TbsDownloader.a().getApplicationContext() != null)
                      {
                        localObject1 = localObject2;
                        if (TbsDownloader.a().getApplicationContext().getApplicationInfo() != null) {
                          localObject1 = TbsDownloader.a().getApplicationContext().getApplicationInfo().packageName;
                        }
                      }
                    }
                    if ((bool1) && (i == 0)) {
                      break label259;
                    }
                    ((TbsDownloader.TbsDownloaderCallback)paramAnonymousMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
                  }
                }
                for (;;)
                {
                  if ((!TbsShareManager.isThirdPartyApp(TbsDownloader.a())) || (!bool1)) {
                    break label334;
                  }
                  TbsDownloader.startDownload(TbsDownloader.a());
                  return;
                  i = 0;
                  break;
                  bool1 = false;
                  break label85;
                  if (("com.tencent.mm".equals(localObject1)) || ("com.tencent.mobileqq".equals(localObject1)))
                  {
                    TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + bool1);
                    ((TbsDownloader.TbsDownloaderCallback)paramAnonymousMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
                  }
                }
              }
              if ((Apn.getApnType(TbsDownloader.a()) != 3) && (!QbSdk.getDownloadWithoutWifi()))
              {
                TbsLog.i("TbsDownload", "not wifi,no need send request");
                return;
              }
              Object localObject3;
              if (!TbsShareManager.isThirdPartyApp(TbsDownloader.a()))
              {
                localObject2 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt";
                localObject2 = FileUtil.b(TbsDownloader.a(), false, (String)localObject2);
                if (localObject2 != null)
                {
                  localObject3 = FileUtil.a(TbsDownloader.a(), (FileOutputStream)localObject2);
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    QbSdk.n.onDownloadFinish(177);
                    TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                    TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
                    TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                  }
                }
                else if (FileUtil.a(TbsDownloader.a()))
                {
                  TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
                  TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                }
              }
              else
              {
                localObject2 = null;
              }
              boolean bool2;
              if (paramAnonymousMessage.arg1 == 1)
              {
                bool1 = true;
                localObject3 = TbsDownloadConfig.getInstance(TbsDownloader.a());
                if (108 != paramAnonymousMessage.what) {
                  break label726;
                }
                bool2 = true;
                boolean bool4 = TbsDownloader.a(false, bool1, bool2, true);
                StringBuilder localStringBuilder = new StringBuilder().append("needStartDownload is ").append(bool4).append(" forDecoupleCore is ");
                if (108 != paramAnonymousMessage.what) {
                  break label732;
                }
                bool2 = true;
                TbsLog.i("TbsDownload", bool2);
                TbsLog.i("TbsDownload", "idownloadConfig.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) is " + ((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false));
                if (!bool4) {
                  break label845;
                }
                if ((!bool1) || (!p.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
                  break label738;
                }
                TbsLog.i("TbsDownload", "in needStartDownload true #1");
                QbSdk.n.onDownloadFinish(122);
                ((TbsDownloadConfig)localObject3).setDownloadInterruptCode(-213);
              }
              for (;;)
              {
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                FileUtil.a((FileLock)localObject1, (FileOutputStream)localObject2);
                return;
                bool1 = false;
                break;
                bool2 = false;
                break label546;
                bool2 = false;
                break label592;
                if (((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false))
                {
                  TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
                  if (108 == paramAnonymousMessage.what)
                  {
                    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
                    ((TbsDownloadConfig)localObject3).commit();
                  }
                  localObject3 = TbsDownloader.b();
                  if (108 == paramAnonymousMessage.what) {}
                  for (bool2 = bool3;; bool2 = false)
                  {
                    ((m)localObject3).b(bool1, bool2);
                    break;
                  }
                }
                QbSdk.n.onDownloadFinish(110);
                continue;
                QbSdk.n.onDownloadFinish(110);
              }
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
              if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
              for (int i = TbsShareManager.a(TbsDownloader.a(), false);; i = p.a().n(TbsDownloader.a()))
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
                TbsDownloader.b().a(i);
                TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
                return;
              }
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
              TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
              return;
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
              if (paramAnonymousMessage.arg1 == 0)
              {
                p.a().a((Context)paramAnonymousMessage.obj, true);
                return;
              }
              p.a().a((Context)paramAnonymousMessage.obj, false);
              return;
            } while (TbsDownloader.b() == null);
            label259:
            label334:
            label592:
            label726:
            label732:
            label738:
            TbsDownloader.b().f();
            label546:
            label845:
            return;
          }
        };
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  private static void d(int paramInt)
  {
    int i1 = 0;
    if (t == null) {
      return;
    }
    for (;;)
    {
      try
      {
        t.put("FUNCTION", 2);
        Object localObject = com.tencent.smtt.utils.n.a(c).g();
        TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] postUrl=" + (String)localObject);
        TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] mJsonDataQueryReset=" + t.toString());
        localObject = f.a((String)localObject, t.toString().getBytes("utf-8"), new f.a()
        {
          public void a(int paramAnonymousInt) {}
        }, false);
        TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] response=" + (String)localObject);
        if (new JSONObject((String)localObject).getInt("RESETDECOUPLECORE") != 1) {
          break;
        }
        localObject = TbsShareManager.getPackageContext(c, "com.tencent.mm", false);
        if (localObject == null)
        {
          localObject = new File(FileUtil.a(c, "com.tencent.mm", 4, true));
          TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] resetDecoupleCore mFilePathStable is " + ((File)localObject).getAbsolutePath(), true);
          File[] arrayOfFile = ((File)localObject).listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, paramInt));
          int i2 = arrayOfFile.length;
          if (i1 < i2)
          {
            File localFile2 = arrayOfFile[i1];
            if ((!localPattern.matcher(localFile2.getName()).find()) || (!localFile2.isFile()) || (!localFile2.exists())) {
              break label414;
            }
            TbsLog.i("TbsDownload", "resetOtherCpuStableCore file is " + localFile2.getAbsolutePath(), true);
            localFile2.delete();
            break label414;
          }
        }
        else
        {
          localObject = new File(FileUtil.a((Context)localObject, 4));
          continue;
        }
        localFile1 = new File(localThrowable, getBackupFileName(false, paramInt));
      }
      catch (Throwable localThrowable)
      {
        Log.d("TbsDownload", "stack is " + Log.getStackTraceString(localThrowable));
        return;
      }
      File localFile1;
      TbsLog.i("TbsDownload", "resetOtherCpuStableCore file is " + localFile1.getAbsolutePath(), true);
      localFile1.delete();
      return;
      label414:
      i1 += 1;
    }
  }
  
  private static void d(JSONArray paramJSONArray)
  {
    String[] arrayOfString = f();
    int i3 = arrayOfString.length;
    int i1 = 0;
    String str;
    int i4;
    if (i1 < i3)
    {
      str = arrayOfString[i1];
      i4 = TbsShareManager.getStableCoreVersion(c, str);
      if (i4 > 0)
      {
        Context localContext = TbsShareManager.getPackageContext(c, str, false);
        if ((localContext == null) || (p.a().g(localContext))) {
          break label97;
        }
        TbsLog.e("TbsDownload", "addStableVersionToJsonData,host check failed,packageName = " + str);
      }
    }
    label181:
    for (;;)
    {
      i1 += 1;
      break;
      label97:
      int i2 = 0;
      label99:
      if (i2 < paramJSONArray.length()) {
        if (paramJSONArray.optInt(i2) != i4) {}
      }
      for (i2 = 1;; i2 = 0)
      {
        if (i2 != 0) {
          break label181;
        }
        TbsLog.i("TbsDownload", "addStableVersionToJsonData,pkg=" + str + ";version=" + i4);
        paramJSONArray.put(i4);
        break;
        i2 += 1;
        break label99;
        return;
      }
    }
  }
  
  private static boolean e()
  {
    try
    {
      JSONArray localJSONArray = g();
      boolean bool = TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static String[] f()
  {
    if (QbSdk.getOnlyDownload()) {
      return new String[] { c.getApplicationContext().getPackageName() };
    }
    String[] arrayOfString1 = TbsShareManager.getCoreProviderAppList();
    String str = c.getApplicationContext().getPackageName();
    if (str.equals(TbsShareManager.f(c)))
    {
      int i1 = arrayOfString1.length;
      String[] arrayOfString2 = new String[i1 + 1];
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i1);
      arrayOfString2[i1] = str;
      return arrayOfString2;
    }
    return arrayOfString1;
  }
  
  private static JSONArray g()
  {
    if (TbsShareManager.isThirdPartyApp(c))
    {
      JSONArray localJSONArray = new JSONArray();
      a(localJSONArray);
      TbsLog.i("TbsDownload", "getHostCoreVersions addCoreVersionToJsonData is " + localJSONArray.toString());
      c(localJSONArray);
      TbsLog.i("TbsDownload", "getHostCoreVersions addBackupVersionToJsonData is " + localJSONArray.toString());
      b(localJSONArray);
      TbsLog.i("TbsDownload", "getHostCoreVersions addAppDefinedToCoreVersions is " + localJSONArray.toString());
      d(localJSONArray);
      TbsLog.i("TbsDownload", "getHostCoreVersions addStableVersionToJsonData is " + localJSONArray.toString());
      return localJSONArray;
    }
    return null;
  }
  
  public static String getBackupFileName(boolean paramBoolean)
  {
    return getBackupFileName(paramBoolean, 0);
  }
  
  public static String getBackupFileName(boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramInt == 64) {
      bool = true;
    }
    while (paramBoolean) {
      if (bool)
      {
        return "x5.tbs.decouple.64";
        if (paramInt == 32) {
          bool = false;
        } else {
          bool = b.b();
        }
      }
      else
      {
        return "x5.tbs.decouple";
      }
    }
    if (bool) {
      return "x5.tbs.org.64";
    }
    return "x5.tbs.org";
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    return p.a().i(c);
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    return p.a().i(paramContext);
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      if (!l)
      {
        l = true;
        paramContext = TbsDownloadConfig.getInstance(paramContext);
        if (paramContext.mPreferences.contains("is_oversea"))
        {
          k = paramContext.mPreferences.getBoolean("is_oversea", false);
          TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + k);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + k);
      }
      boolean bool = k;
      return bool;
    }
    finally {}
  }
  
  public static long getRetryIntervalInSeconds()
  {
    return u;
  }
  
  public static HandlerThread getsTbsHandlerThread()
  {
    return h;
  }
  
  private static boolean h()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-115);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-116);
      return false;
    }
    if (!FileUtil.b(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-117);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l1 = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l1);
      if (l1 >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        localTbsDownloadConfig.setDownloadInterruptCode(-120);
        return false;
      }
    }
    return true;
  }
  
  public static boolean isDownloadForeground()
  {
    return (g != null) && (g.d());
  }
  
  public static boolean isDownloading()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + a);
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    return needDownload(paramContext, paramBoolean, false, true, null);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    return needDownload(paramContext, paramBoolean1, paramBoolean2, true, paramTbsDownloaderCallback);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    q.b(paramContext, "need_download", "");
    q.a(paramContext, "need_download", "");
    c = paramContext.getApplicationContext();
    q.a("1");
    TbsLog.initIfNeed(paramContext);
    TbsLog.i("TbsDownload", "needDownload,process=" + QbSdk.getCurrentProcessName(paramContext) + "stack=" + Log.getStackTraceString(new Throwable()));
    TbsDownloadUpload.clear();
    TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
    localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(140));
    localTbsDownloadUpload.commit();
    Object localObject = p.a();
    boolean bool1;
    if (g.a == 0)
    {
      bool1 = true;
      ((p)localObject).b(paramContext, bool1);
      i1 = p.a().b(paramContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],renameRet=" + i1);
      if (i1 != 0)
      {
        localObject = TbsLogReport.getInstance(paramContext).tbsLogInfo();
        ((TbsLogReport.TbsLogInfo)localObject).a = 129;
        ((TbsLogReport.TbsLogInfo)localObject).setFailDetail("code=2" + i1);
        TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, (TbsLogReport.TbsLogInfo)localObject);
      }
      if (i1 >= 0) {
        break label272;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needReNameFile=" + i1);
    }
    label272:
    do
    {
      return false;
      bool1 = false;
      break;
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
      bool1 = false;
      if (p.b)
      {
        if (paramTbsDownloaderCallback != null) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#1,return " + false);
        localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(171));
        localTbsDownloadUpload.commit();
        return false;
      }
      TbsLog.app_extra("TbsDownload", paramContext);
      c = paramContext.getApplicationContext();
      localObject = TbsDownloadConfig.getInstance(c);
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-100);
      if (a(c, paramBoolean1)) {
        break label511;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#2,return " + false);
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(141));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(172));
      localTbsDownloadUpload.commit();
    } while (paramTbsDownloaderCallback == null);
    paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
    return false;
    label511:
    d();
    if (i)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-105);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#3,return " + false);
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(142));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(173));
      localTbsDownloadUpload.commit();
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      return false;
    }
    boolean bool2 = a(c, paramBoolean2, false);
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needSendRequest=" + bool2);
    if (bool2)
    {
      a(paramBoolean2, paramTbsDownloaderCallback, paramBoolean3);
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-114);
      d.removeMessages(102);
      Message.obtain(d, 102).sendToTarget();
      paramBoolean2 = false;
      if (!QbSdk.c)
      {
        paramBoolean1 = bool1;
        if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      }
      else
      {
        paramBoolean2 = ((TbsDownloadConfig)localObject).mPreferences.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean2);
        if ((paramBoolean2) || (TbsShareManager.isThirdPartyApp(paramContext))) {
          break label940;
        }
        paramBoolean1 = true;
      }
      label776:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (!paramBoolean1) {
        break label976;
      }
      if (h()) {
        break label958;
      }
      paramBoolean1 = false;
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
      label831:
      if ((!bool2) && (paramTbsDownloaderCallback != null)) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + paramBoolean1);
      paramContext = localTbsDownloadUpload.a;
      if (!paramBoolean1) {
        break label1107;
      }
    }
    label940:
    label958:
    label976:
    label1107:
    for (int i1 = 170;; i1 = 174)
    {
      paramContext.put("tbs_needdownload_return", Integer.valueOf(i1));
      localTbsDownloadUpload.commit();
      return paramBoolean1;
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(143));
      localTbsDownloadUpload.commit();
      break;
      paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false);
      break label776;
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-118);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      break label831;
      i1 = p.a().n(c);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + i1 + ",needSendRequest=" + bool2);
      if ((bool2) || (i1 <= 0))
      {
        d.removeMessages(103);
        if ((i1 <= 0) && (!bool2)) {
          Message.obtain(d, 103, 0, 0, c).sendToTarget();
        }
        for (;;)
        {
          ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-121);
          break;
          Message.obtain(d, 103, 1, 0, c).sendToTarget();
        }
      }
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-119);
      break label831;
    }
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    if (TbsShareManager.isThirdPartyApp(c)) {}
    int i1;
    do
    {
      long l1;
      do
      {
        do
        {
          return false;
        } while (a(c));
        l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
      } while (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval());
      i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    } while ((i1 <= 0) || (i1 == p.a().i(c)) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == i1));
    return true;
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean)) {}
    int i1;
    do
    {
      return false;
      i1 = p.a().n(paramContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + i1);
    } while (i1 > 0);
    if (a(c, false, true)) {
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + paramBoolean);
    if (!paramBoolean)
    {
      paramBoolean = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + paramBoolean);
      if ((!paramBoolean) || (!h())) {
        break label207;
      }
    }
    label207:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + paramBoolean);
      return paramBoolean;
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  public static void pauseDownload()
  {
    TbsLog.i("TbsDownload", "called pauseDownload,downloader=" + g);
    if (g != null) {
      g.e();
    }
  }
  
  public static void resumeDownload()
  {
    TbsLog.i("TbsDownload", "called resumeDownload,downloader=" + g);
    if (d != null)
    {
      d.removeMessages(109);
      d.sendEmptyMessage(109);
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      c = paramContext.getApplicationContext();
    }
  }
  
  public static void setRetryIntervalInSeconds(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    if (paramContext.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
      u = paramLong;
    }
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + u);
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    int i1 = 32;
    if (!q.b(c))
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded isStableCoreForHostEnable is false and return ");
      return false;
    }
    boolean bool = startDecoupleCoreIfNeededImpl();
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded startDecoupleCoreIfNeededImpl return is " + bool);
    int i2;
    if ((!bool) && (q.b(c)))
    {
      i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded cpuTypeForOtherStableCore is " + i2);
      if (i2 != 0) {
        break label130;
      }
      if (!b.b()) {
        break label124;
      }
      c(i1);
    }
    for (;;)
    {
      return bool;
      label124:
      i1 = 64;
      break;
      label130:
      if ((i2 == 32) || (i2 == 64))
      {
        TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
        localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", "");
        localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_apk_md5", "");
        localTbsDownloadConfig.mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(0));
        localTbsDownloadConfig.commit();
      }
    }
  }
  
  public static boolean startDecoupleCoreIfNeededImpl()
  {
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c)) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
    m.a(c);
    m.b(c);
    if (a(c)) {
      return false;
    }
    if (d == null) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval()) {
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if (q.b(c)) {}
    Object localObject;
    for (int i1 = TbsShareManager.getTbsStableCoreVersion(c, 0);; i1 = p.a().i(c))
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded coreVersionForThirdApp is " + i1 + " deCoupleCoreVersion is " + i2);
      if ((i2 <= 0) || (i2 == i1)) {
        break label544;
      }
      if (!a(i2, i1, 0)) {
        break;
      }
      localObject = TbsDownloadConfig.getInstance(c);
      ((TbsDownloadConfig)localObject).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
      ((TbsDownloadConfig)localObject).commit();
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl stable core " + i2 + " copy from old backup and return ");
      localObject = "oldcore=is=" + i1;
      localObject = (String)localObject + "_" + "newcore=is=" + i2;
      q.b(c, "copy_my_cpu_core_ok", (String)localObject);
      return false;
    }
    if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != i2) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) == 1))
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
      a = true;
      d.removeMessages(108);
      localObject = Message.obtain(d, 108, QbSdk.n);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
      return true;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i2 + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
    for (;;)
    {
      return false;
      label544:
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + i1);
    }
  }
  
  public static void startDownload(Context paramContext)
  {
    startDownload(paramContext, false);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    int i1 = 1;
    for (;;)
    {
      TbsDownloadUpload localTbsDownloadUpload;
      try
      {
        TbsLog.initIfNeed(paramContext);
        localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + c);
        if (p.b)
        {
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
          return;
        }
        Object localObject = p.a();
        if (g.a == 0)
        {
          bool = true;
          ((p)localObject).b(paramContext, bool);
          int i2 = p.a().b(paramContext);
          TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],renameRet=" + i2);
          if (i2 != 0)
          {
            localObject = TbsLogReport.getInstance(paramContext).tbsLogInfo();
            ((TbsLogReport.TbsLogInfo)localObject).a = 129;
            ((TbsLogReport.TbsLogInfo)localObject).setFailDetail("code=2" + i2);
            TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, (TbsLogReport.TbsLogInfo)localObject);
          }
          if (i2 >= 0) {
            break label259;
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needReNameFile=" + i2);
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label259:
      a = true;
      c = paramContext.getApplicationContext();
      TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-200);
      if (Build.VERSION.SDK_INT < 8)
      {
        QbSdk.n.onDownloadFinish(110);
        TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(162));
        localTbsDownloadUpload.commit();
      }
      else
      {
        d();
        if (!i) {
          break;
        }
        QbSdk.n.onDownloadFinish(121);
        TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(163));
        localTbsDownloadUpload.commit();
      }
    }
    if (paramBoolean) {
      stopDownload();
    }
    d.removeMessages(101);
    d.removeMessages(100);
    paramContext = Message.obtain(d, 101, QbSdk.n);
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.arg1 = i1;
      paramContext.sendToTarget();
      break;
      i1 = 0;
    }
  }
  
  public static void stopDownload()
  {
    if (i) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (g != null) {
        g.b();
      }
    } while (d == null);
    d.removeMessages(100);
    d.removeMessages(101);
    d.removeMessages(108);
  }
  
  public static abstract interface TbsDownloaderCallback
  {
    public abstract void onNeedDownloadFinish(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */