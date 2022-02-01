package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.q;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class m
{
  private static int e = 5;
  private static int f = 1;
  private static final String[] g = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private boolean A;
  private Handler B;
  private Set<String> C;
  private int D = e;
  private boolean E;
  String a;
  String[] b = null;
  int c = 0;
  private boolean d = false;
  private Context h;
  private String i;
  private String j;
  private String k;
  private File l;
  private File m;
  private long n;
  private int o = 30000;
  private int p = 20000;
  private boolean q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private HttpURLConnection v;
  private String w;
  private TbsLogReport.TbsLogInfo x;
  private String y;
  private int z;
  
  public m(Context paramContext)
    throws NullPointerException
  {
    this.h = paramContext.getApplicationContext();
    this.x = TbsLogReport.getInstance(this.h).tbsLogInfo();
    this.C = new HashSet();
    this.w = ("tbs_downloading_" + this.h.getPackageName());
    p.a();
    this.l = p.t(this.h);
    if (this.l == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    for (;;)
    {
      try
      {
        localContext = TbsShareManager.getPackageContext(paramContext, "com.tencent.mm", false);
        if (localContext != null) {
          continue;
        }
        this.m = new File(FileUtil.a(paramContext, "com.tencent.mm", 4, true));
      }
      catch (Throwable paramContext)
      {
        Context localContext;
        continue;
      }
      g();
      this.y = null;
      this.z = -1;
      return;
      this.m = new File(FileUtil.a(localContext, 4));
    }
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1 = System.currentTimeMillis();
    this.x.setDownConsumeTime(l1 - paramLong1);
    this.x.setDownloadSize(paramLong2);
    return l1;
  }
  
  private static File a(Context paramContext, int paramInt)
  {
    File localFile = new File(FileUtil.a(paramContext, paramInt));
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org";; paramContext = TbsDownloader.getBackupFileName(false))
    {
      paramContext = new File(localFile, paramContext);
      if ((paramContext == null) || (!paramContext.exists())) {
        break;
      }
      return localFile;
    }
    return null;
  }
  
  private String a(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private String a(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
      return "";
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.r > this.D))
    {
      this.x.setErrorCode(paramInt);
      this.x.setFailDetail(paramString);
    }
  }
  
  private void a(long paramLong)
  {
    this.r += 1;
    long l1 = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l1 = n();
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      TbsLog.i("TbsDownload", "clearDecoupleDirOld #00");
      File localFile = paramContext.getDir("tbs_64", 0);
      localFile = p.a().a(paramContext, localFile);
      FileUtil.b(localFile);
      if (localFile != null) {
        TbsLog.i("TbsDownload", "clearDecoupleDirOld dir is " + localFile.getAbsolutePath());
      }
      localFile = paramContext.getDir("tbs", 0);
      paramContext = p.a().a(paramContext, localFile);
      FileUtil.b(paramContext);
      if (paramContext != null) {
        TbsLog.i("TbsDownload", "clearDecoupleDirOld dir is " + paramContext.getAbsolutePath());
      }
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsDownload", "clearDecoupleDirOld stack is " + Log.getStackTraceString(paramContext));
    }
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(File paramFile, Context paramContext)
  {
    i1 = 0;
    if (paramFile != null) {}
    try
    {
      if (!paramFile.exists()) {
        return;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        return;
      }
    }
    finally {}
    for (;;)
    {
      try
      {
        localFile = c(paramContext);
        if (localFile == null) {
          continue;
        }
        if (!TbsDownloader.getOverSea(paramContext)) {
          continue;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(localFile, (String)localObject1);
        ((File)localObject1).delete();
        FileUtil.b(paramFile, (File)localObject1);
        boolean bool1 = ((File)localObject1).getName().contains("tbs.org");
        bool2 = ((File)localObject1).getName().contains("x5.tbs.decouple");
        if ((!bool2) && (!bool1)) {
          continue;
        }
        paramFile = localFile.listFiles();
        localObject1 = Pattern.compile(a.a(bool2) + "(.*)");
        i2 = paramFile.length;
      }
      catch (Exception paramFile)
      {
        File localFile;
        Object localObject1;
        boolean bool2;
        int i2;
        Object localObject2;
        continue;
        i1 += 1;
        continue;
      }
      if (i1 >= i2) {
        continue;
      }
      localObject2 = paramFile[i1];
      if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
        continue;
      }
      localObject2.delete();
      continue;
      localObject1 = TbsDownloader.getBackupFileName(false);
    }
    i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
    paramFile = new File(localFile, a.a(bool2) + "." + i1);
    if ((paramFile != null) && (paramFile.exists()))
    {
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
      return;
    }
    paramFile.createNewFile();
  }
  
  private void a(String paramString)
    throws Exception
  {
    paramString = new URL(paramString);
    if (this.v != null) {}
    try
    {
      this.v.disconnect();
      this.v = ((HttpURLConnection)paramString.openConnection());
      this.v.setRequestProperty("User-Agent", TbsDownloader.b(this.h));
      this.v.setRequestProperty("Accept-Encoding", "identity");
      this.v.setRequestMethod("GET");
      this.v.setInstanceFollowRedirects(false);
      this.v.setConnectTimeout(this.p);
      this.v.setReadTimeout(this.o);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
      }
    }
  }
  
  private boolean a(File paramFile)
  {
    int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
    int i1 = i2;
    if (i2 == 0) {
      i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
    }
    return a.a(this.h, paramFile, 0L, i1);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, File paramFile)
  {
    long l2 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    if (paramFile != null) {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk]  verifyFile is " + paramFile.getAbsolutePath());
    }
    Object localObject2 = this.l;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (paramFile == null) {
        break label817;
      }
      localObject1 = paramFile;
    }
    label777:
    label811:
    label817:
    for (;;)
    {
      if (!((File)localObject1).exists()) {}
      String str;
      do
      {
        return false;
        localObject1 = "x5.tbs.temp";
        break;
        localObject2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getString("tbs_apk_md5", null);
        str = a.a((File)localObject1);
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {
          break label206;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
      } while (!paramBoolean1);
      this.x.setCheckErrorDetail("fileMd5 not match");
      return false;
      label206:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + str + ") successful!");
      long l1 = l2;
      long l3;
      if (paramBoolean1)
      {
        l3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label811;
        }
        l1 = l2;
        if (l3 > 0L)
        {
          l1 = ((File)localObject1).length();
          if (l3 == l1) {}
        }
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
        this.x.setCheckErrorDetail("fileLength:" + l1 + ",contentLength:" + l3);
        return false;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l1 + ") successful!");
        int i2 = -1;
        int i1 = i2;
        if (paramBoolean2)
        {
          i1 = i2;
          if (!paramBoolean1)
          {
            i2 = a.a(this.h, (File)localObject1);
            int i3 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
            i1 = i2;
            if (i3 != i2)
            {
              TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
              if (!paramBoolean1) {
                break;
              }
              this.x.setCheckErrorDetail("fileVersion:" + i2 + ",configVersion:" + i3);
              return false;
            }
          }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i1 + ") successful!");
        if ((paramBoolean2) && (!paramBoolean1))
        {
          str = b.a(this.h, false, (File)localObject1);
          if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
          {
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
            if (!paramBoolean1) {
              break;
            }
            localObject1 = this.x;
            localObject2 = new StringBuilder().append("signature:");
            if (str == null) {}
            for (paramFile = "null";; paramFile = Integer.valueOf(str.length()))
            {
              ((TbsLogReport.TbsLogInfo)localObject1).setCheckErrorDetail(paramFile);
              return false;
            }
          }
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
        if ((paramBoolean1) && (paramFile == null))
        {
          try
          {
            paramBoolean1 = ((File)localObject1).renameTo(new File(this.l, "x5.tbs"));
            paramFile = null;
          }
          catch (Exception paramFile)
          {
            for (;;)
            {
              paramBoolean1 = false;
            }
          }
          paramBoolean2 = paramBoolean1;
          if (paramBoolean1) {
            break label777;
          }
          a(109, a(paramFile), true);
          return false;
        }
        paramBoolean2 = false;
        TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
        return true;
        l1 = 0L;
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      boolean bool;
      do
      {
        TbsLog.i("TbsDownload", "clearOldBackup #00");
        paramContext = new File(FileUtil.a(paramContext, 3));
        FileUtil.b(paramContext);
        if (paramContext == null) {
          break;
        }
        TbsLog.i("TbsDownload", "clearOldBackup dir is " + paramContext.getAbsolutePath());
        return;
        bool = q.g(paramContext);
      } while (bool);
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsDownload", "clearOldBackup stack is " + Log.getStackTraceString(paramContext));
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    try
    {
      File localFile1 = new File(this.l, "x5.tbs");
      File localFile2 = c(this.h);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.h)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          FileUtil.b((File)localObject, localFile1);
          if (a.a(this.h, localFile1, 0L, paramInt)) {
            break;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          return false;
        }
        bool = true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      return false;
    }
    return bool;
  }
  
  @TargetApi(8)
  static File c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(FileUtil.a(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        return null;
      }
      paramContext = null;
    }
  }
  
  private boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2, null);
  }
  
  @TargetApi(8)
  static File d(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = a(paramContext, 4);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = a(paramContext, 2);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(paramContext, 1);
        }
        return localObject1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
      return null;
    }
    return null;
  }
  
  private void d(boolean paramBoolean)
  {
    q.a(this.h);
    localObject3 = TbsDownloadConfig.getInstance(this.h);
    ((TbsDownloadConfig)localObject3).mSyncMap.put("request_full_package", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject3).commit();
    Object localObject1 = QbSdk.n;
    if (paramBoolean)
    {
      i1 = 100;
      ((TbsListener)localObject1).onDownloadFinish(i1);
      i2 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_responsecode", 0);
      paramBoolean = TbsDownloader.a(this.h);
      if (!paramBoolean) {
        break label415;
      }
      localObject1 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      localObject1 = (String)localObject1 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
      q.b(this.h, "download_ok", (String)localObject1);
    }
    for (;;)
    {
      try
      {
        i3 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
        TbsLog.i("TbsDownload", "downloadSuccess #1  cpuTypeForOtherStableCore is " + i3 + " isDownloadDecoupleCore is " + paramBoolean);
        TbsLog.i("TbsDownload", "downloadSuccess #1  responseCode is " + i2);
        if ((paramBoolean) && (q.b(this.h)) && (i2 != 3))
        {
          localObject1 = this.m.listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, i3));
          int i4 = localObject1.length;
          i1 = 0;
          if (i1 < i4)
          {
            Object localObject4 = localObject1[i1];
            if ((localPattern.matcher(localObject4.getName()).find()) && (localObject4.isFile()) && (localObject4.exists())) {
              localObject4.delete();
            }
            i1 += 1;
            continue;
            i1 = 120;
            break;
            label415:
            if (!TbsShareManager.isThirdPartyApp(this.h)) {
              continue;
            }
            localObject1 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
            localObject1 = (String)localObject1 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
            q.a(this.h, "download_ok", (String)localObject1);
            continue;
          }
          localObject1 = new File(this.m, a.a(false, i3) + "." + ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_download_version", 0));
          if (localObject1 == null) {
            continue;
          }
          bool = ((File)localObject1).exists();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        boolean bool;
        TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable1));
        continue;
        String str = "stable_32_tpatch_fail";
        continue;
        if (i3 != 64) {
          continue;
        }
        str = "stable_64_tpatch_fail";
        continue;
      }
      try
      {
        bool = new File(this.m, TbsDownloader.getBackupFileName(false) + "." + "tmp").renameTo(new File(this.m, TbsDownloader.getBackupFileName(false, i3)));
        localObject1 = "none";
        if (i3 != 0) {
          break label1584;
        }
        if (!b.b()) {
          continue;
        }
        localObject1 = "stable_64_tpatch_fail";
      }
      catch (Throwable localThrowable2)
      {
        TbsLog.i("TbsDownload", "downloadSuccess stack is " + Log.getStackTraceString(localThrowable2));
        continue;
        if (!paramBoolean) {
          break label1171;
        }
        localObject3 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
        localObject3 = (String)localObject3 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
        localObject3 = (String)localObject3 + "_" + "responseCode=is=" + i2;
        q.b(this.h, "tpatch_pre_bundle_ok", (String)localObject3);
        TbsLog.i("TbsDownload", "downloadSuccess RESPONSECODE_TPATCH bundle is " + localThrowable2);
        p.a().b(this.h, localThrowable2);
        for (;;)
        {
          a(this.h);
          b(this.h);
          return;
          if (!TbsShareManager.isThirdPartyApp(this.h)) {
            break;
          }
          localObject3 = "downloadVersion=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
          localObject3 = (String)localObject3 + "_" + "apkSize=is=" + TbsDownloadConfig.getInstance(this.h).mPreferences.getLong("tbs_apkfilesize", 0L);
          localObject3 = (String)localObject3 + "_" + "responseCode=is=" + i2;
          q.a(this.h, "tpatch_pre_bundle_ok", (String)localObject3);
          break;
          if ((i2 == 3) || (i2 > 10000))
          {
            localObject2 = c(this.h);
            if (localObject2 != null)
            {
              localObject2 = a(i2, (File)localObject2, paramBoolean);
              p.a().b(this.h, (Bundle)localObject2);
            }
            else
            {
              c();
              ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
              ((TbsDownloadConfig)localObject3).commit();
            }
          }
          else
          {
            i1 = ((TbsDownloadConfig)localObject3).mPreferences.getInt("tbs_download_version", 0);
            p.a().a(this.h, new File(this.l, "x5.tbs").getAbsolutePath(), i1);
            if (!q.b(this.h))
            {
              a(new File(this.l, "x5.tbs"), this.h);
            }
            else
            {
              i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", 0);
              TbsLog.i("TbsDownload", "downloadSuccess tbsCorVer is " + i1 + " stableCoreVersionServer is " + i2);
              if (i1 == i2)
              {
                TbsLog.i("TbsDownload", "downloadSuccess backup");
                a(new File(this.l, "x5.tbs"), this.h);
              }
              else
              {
                TbsLog.i("TbsDownload", "downloadSuccess not backup");
              }
            }
          }
        }
        if (i3 != 32) {
          continue;
        }
        Object localObject2 = "stable_32_tpatch_fail";
        continue;
      }
      n.a(this.h).a((String)localObject1, 0);
      TbsLog.i("TbsDownload", "downloadSuccess setStatus " + (String)localObject1 + " is 0");
      TbsLog.i("TbsDownload", "downloadSuccess renameResult is " + bool);
      TbsLog.i("TbsDownload", "downloadSuccess getTbsStableCoreVersion is " + TbsShareManager.getTbsStableCoreVersion(this.h, i3));
      localObject1 = "cpu=is=" + i3;
      q.b(this.h, "rename_whole_file_ok", (String)localObject1);
      if ((i2 != 5) && (i2 != 3)) {
        break label1320;
      }
      localObject1 = a(i2, paramBoolean);
      if (localObject1 != null) {
        break label977;
      }
      TbsLog.i("TbsDownload", "downloadSuccess RESPONSECODE_TPATCH bundle is null ");
      a(this.h);
      b(this.h);
      return;
      ((File)localObject1).createNewFile();
    }
  }
  
  public static void e(Context paramContext)
  {
    int i2 = 0;
    for (;;)
    {
      int i1;
      try
      {
        p.a();
        Object localObject1 = p.t(paramContext);
        new File((File)localObject1, "x5.tbs").delete();
        new File((File)localObject1, "x5.tbs.temp").delete();
        paramContext = c(paramContext);
        if (paramContext != null)
        {
          new File(paramContext, TbsDownloader.getBackupFileName(false)).delete();
          new File(paramContext, "x5.oversea.tbs.org").delete();
          paramContext = paramContext.listFiles();
          localObject1 = Pattern.compile(a.a(true) + "(.*)");
          int i3 = paramContext.length;
          i1 = 0;
          Object localObject2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label262;
            }
            localObject2.delete();
            break label262;
          }
          localObject1 = Pattern.compile(a.a(false) + "(.*)");
          i3 = paramContext.length;
          i1 = i2;
          if (i1 < i3)
          {
            localObject2 = paramContext[i1];
            if ((((Pattern)localObject1).matcher(localObject2.getName()).find()) && (localObject2.isFile()) && (localObject2.exists())) {
              localObject2.delete();
            }
            i1 += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramContext) {}
      label262:
      i1 += 1;
    }
  }
  
  private boolean e(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.l, "x5.tbs");; localFile = new File(this.l, "x5.tbs.temp"))
    {
      if ((localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      return true;
    }
  }
  
  private void g()
  {
    this.r = 0;
    this.s = 0;
    this.n = -1L;
    this.k = null;
    this.q = false;
    this.t = false;
    this.u = false;
    this.A = false;
  }
  
  private void h()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.v != null) {
      if (!this.t) {
        this.x.setResolveIp(a(this.v.getURL()));
      }
    }
    try
    {
      this.v.disconnect();
      this.v = null;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest] mHttpRequest set null");
      int i1 = this.x.a;
      if ((!this.t) && (this.A))
      {
        this.x.setEventTime(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.h);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int i2 = Apn.getApnType(this.h);
        this.x.setApn(str1);
        this.x.setNetworkType(i2);
        if ((i2 != this.z) || (!str1.equals(this.y))) {
          this.x.setNetworkChange(0);
        }
        if (((this.x.a == 0) || (this.x.a == 107)) && (this.x.getDownFinalFlag() == 0))
        {
          if (!Apn.isNetworkAvailable(this.h)) {
            a(101, null, true);
          }
        }
        else
        {
          if (!TbsDownloader.a(this.h)) {
            break label316;
          }
          TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.x);
          this.x.resetArgs();
          if (i1 != 100) {
            QbSdk.n.onDownloadFinish(i1);
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label316:
      do
      {
        for (;;)
        {
          TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
          continue;
          if (!m())
          {
            a(101, null, true);
            continue;
            TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.x);
          }
        }
      } while (this.d);
      TbsDownloader.a = false;
    }
  }
  
  private File i()
  {
    String str = FileUtil.a(this.h, 4);
    if (TbsDownloader.getOverSea(this.h)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
    {
      localObject = new File(str, (String)localObject);
      if (!TbsDownloader.a(this.h)) {
        break;
      }
      return new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
    }
    return localObject;
  }
  
  private void j()
  {
    try
    {
      Object localObject = i();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        FileUtil.b((File)localObject);
        localObject = ((File)localObject).getParentFile().listFiles();
        Pattern localPattern = Pattern.compile(a.a(TbsDownloader.a(this.h)) + "(.*)");
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          File localFile = localObject[i1];
          if ((localPattern.matcher(localFile.getName()).find()) && (localFile.isFile()) && (localFile.exists())) {
            FileUtil.b(localFile);
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean k()
  {
    boolean bool2 = false;
    File localFile = new File(this.l, "x5.tbs.temp");
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long l()
  {
    long l2 = 0L;
    File localFile = new File(this.l, "x5.tbs.temp");
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
    }
    return l1;
  }
  
  /* Error */
  private boolean m()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: invokestatic 814	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: astore 5
    //   14: aload 5
    //   16: new 117	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 816
    //   26: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 818
    //   32: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 822	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 828	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore 5
    //   46: new 830	java/io/InputStreamReader
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 833	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 7
    //   57: new 835	java/io/BufferedReader
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 838	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore 6
    //   68: iconst_0
    //   69: istore_1
    //   70: aload 6
    //   72: invokevirtual 841	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: iload 4
    //   79: istore_3
    //   80: aload 8
    //   82: ifnull +29 -> 111
    //   85: aload 8
    //   87: ldc_w 843
    //   90: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifne +16 -> 109
    //   96: aload 8
    //   98: ldc_w 845
    //   101: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +25 -> 131
    //   109: iconst_1
    //   110: istore_3
    //   111: aload_0
    //   112: aload 5
    //   114: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   117: aload_0
    //   118: aload 7
    //   120: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   123: aload_0
    //   124: aload 6
    //   126: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   129: iload_3
    //   130: ireturn
    //   131: iload_1
    //   132: iconst_1
    //   133: iadd
    //   134: istore_2
    //   135: iload_2
    //   136: istore_1
    //   137: iload_2
    //   138: iconst_5
    //   139: if_icmplt -69 -> 70
    //   142: iload 4
    //   144: istore_3
    //   145: goto -34 -> 111
    //   148: astore 7
    //   150: aconst_null
    //   151: astore 5
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 9
    //   158: astore 8
    //   160: aload 7
    //   162: invokevirtual 848	java/lang/Throwable:printStackTrace	()V
    //   165: aload_0
    //   166: aload 6
    //   168: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: aload 8
    //   174: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   177: aload_0
    //   178: aload 5
    //   180: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 6
    //   187: aconst_null
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_0
    //   194: aload 5
    //   196: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 7
    //   202: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 8
    //   208: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   211: aload 6
    //   213: athrow
    //   214: astore 6
    //   216: aconst_null
    //   217: astore 7
    //   219: goto -26 -> 193
    //   222: astore 6
    //   224: goto -31 -> 193
    //   227: astore 9
    //   229: aload 6
    //   231: astore 8
    //   233: aload 9
    //   235: astore 6
    //   237: goto -44 -> 193
    //   240: astore 10
    //   242: aload 6
    //   244: astore 9
    //   246: aload 8
    //   248: astore 7
    //   250: aload 10
    //   252: astore 6
    //   254: aload 5
    //   256: astore 8
    //   258: aload 9
    //   260: astore 5
    //   262: goto -69 -> 193
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 8
    //   270: aload 5
    //   272: astore 6
    //   274: aload 8
    //   276: astore 5
    //   278: aload 9
    //   280: astore 8
    //   282: goto -122 -> 160
    //   285: astore 10
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 7
    //   292: astore 8
    //   294: aload 5
    //   296: astore 6
    //   298: aload 10
    //   300: astore 7
    //   302: aload 9
    //   304: astore 5
    //   306: goto -146 -> 160
    //   309: astore 10
    //   311: aload 7
    //   313: astore 8
    //   315: aload 5
    //   317: astore 9
    //   319: aload 10
    //   321: astore 7
    //   323: aload 6
    //   325: astore 5
    //   327: aload 9
    //   329: astore 6
    //   331: goto -171 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	m
    //   69	68	1	i1	int
    //   134	6	2	i2	int
    //   79	66	3	bool1	boolean
    //   1	142	4	bool2	boolean
    //   12	314	5	localObject1	Object
    //   66	101	6	localBufferedReader	java.io.BufferedReader
    //   185	27	6	localObject2	Object
    //   214	1	6	localObject3	Object
    //   222	8	6	localObject4	Object
    //   235	95	6	localObject5	Object
    //   55	64	7	localInputStreamReader	java.io.InputStreamReader
    //   148	13	7	localThrowable1	Throwable
    //   188	61	7	localObject6	Object
    //   265	26	7	localThrowable2	Throwable
    //   300	22	7	localObject7	Object
    //   4	310	8	localObject8	Object
    //   7	150	9	localObject9	Object
    //   227	7	9	localObject10	Object
    //   244	84	9	localObject11	Object
    //   240	11	10	localObject12	Object
    //   285	14	10	localThrowable3	Throwable
    //   309	11	10	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	46	148	java/lang/Throwable
    //   14	46	185	finally
    //   46	57	214	finally
    //   57	68	222	finally
    //   70	77	227	finally
    //   85	105	227	finally
    //   160	165	240	finally
    //   46	57	265	java/lang/Throwable
    //   57	68	285	java/lang/Throwable
    //   70	77	309	java/lang/Throwable
    //   85	105	309	java/lang/Throwable
  }
  
  private long n()
  {
    switch (this.r)
    {
    default: 
      return 20000L * 10L;
    case 1: 
    case 2: 
      return 20000L * this.r;
    }
    return 20000L * 5L;
  }
  
  /* Error */
  private boolean o()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   16: invokestatic 763	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   19: iconst_3
    //   20: if_icmpne +279 -> 299
    //   23: iconst_1
    //   24: istore_3
    //   25: ldc_w 273
    //   28: new 117	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 856
    //   38: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_3
    //   42: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iload 5
    //   53: istore_2
    //   54: iload_3
    //   55: ifeq +143 -> 198
    //   58: aload_0
    //   59: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   62: invokestatic 859	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   65: astore 6
    //   67: ldc_w 273
    //   70: new 117	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 861
    //   80: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 6
    //   85: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: new 236	java/net/URL
    //   97: dup
    //   98: ldc_w 863
    //   101: invokespecial 390	java/net/URL:<init>	(Ljava/lang/String;)V
    //   104: invokevirtual 401	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   107: checkcast 394	java/net/HttpURLConnection
    //   110: astore 7
    //   112: aload 7
    //   114: iconst_0
    //   115: invokevirtual 422	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   118: aload 7
    //   120: sipush 10000
    //   123: invokevirtual 425	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   126: aload 7
    //   128: sipush 10000
    //   131: invokevirtual 428	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   134: aload 7
    //   136: iconst_0
    //   137: invokevirtual 866	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   140: aload 7
    //   142: invokevirtual 867	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   145: pop
    //   146: aload 7
    //   148: invokevirtual 870	java/net/HttpURLConnection:getResponseCode	()I
    //   151: istore_1
    //   152: ldc_w 273
    //   155: new 117	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 872
    //   165: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload_1
    //   169: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: iload_1
    //   179: sipush 204
    //   182: if_icmpne +122 -> 304
    //   185: iload 4
    //   187: istore_2
    //   188: aload 7
    //   190: ifnull +203 -> 393
    //   193: aload 7
    //   195: invokevirtual 397	java/net/HttpURLConnection:disconnect	()V
    //   198: iload_2
    //   199: ifne +68 -> 267
    //   202: aload 6
    //   204: invokestatic 877	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +60 -> 267
    //   210: aload_0
    //   211: getfield 115	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   214: aload 6
    //   216: invokeinterface 881 2 0
    //   221: ifne +46 -> 267
    //   224: aload_0
    //   225: getfield 115	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   228: aload 6
    //   230: invokeinterface 884 2 0
    //   235: pop
    //   236: aload_0
    //   237: invokespecial 886	com/tencent/smtt/sdk/m:p	()V
    //   240: aload_0
    //   241: getfield 888	com/tencent/smtt/sdk/m:B	Landroid/os/Handler;
    //   244: sipush 150
    //   247: aload 6
    //   249: invokevirtual 894	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   252: astore 7
    //   254: aload_0
    //   255: getfield 888	com/tencent/smtt/sdk/m:B	Landroid/os/Handler;
    //   258: aload 7
    //   260: ldc2_w 895
    //   263: invokevirtual 900	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   266: pop
    //   267: iload_2
    //   268: ifeq +29 -> 297
    //   271: aload_0
    //   272: getfield 115	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   275: aload 6
    //   277: invokeinterface 881 2 0
    //   282: ifeq +15 -> 297
    //   285: aload_0
    //   286: getfield 115	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   289: aload 6
    //   291: invokeinterface 903 2 0
    //   296: pop
    //   297: iload_2
    //   298: ireturn
    //   299: iconst_0
    //   300: istore_3
    //   301: goto -276 -> 25
    //   304: iconst_0
    //   305: istore_2
    //   306: goto -118 -> 188
    //   309: astore 7
    //   311: goto -113 -> 198
    //   314: astore 8
    //   316: aconst_null
    //   317: astore 7
    //   319: aload 8
    //   321: invokevirtual 848	java/lang/Throwable:printStackTrace	()V
    //   324: aload 7
    //   326: ifnull +61 -> 387
    //   329: aload 7
    //   331: invokevirtual 397	java/net/HttpURLConnection:disconnect	()V
    //   334: iload 5
    //   336: istore_2
    //   337: goto -139 -> 198
    //   340: astore 7
    //   342: iload 5
    //   344: istore_2
    //   345: goto -147 -> 198
    //   348: astore 6
    //   350: aload 8
    //   352: astore 7
    //   354: aload 7
    //   356: ifnull +8 -> 364
    //   359: aload 7
    //   361: invokevirtual 397	java/net/HttpURLConnection:disconnect	()V
    //   364: aload 6
    //   366: athrow
    //   367: astore 7
    //   369: goto -5 -> 364
    //   372: astore 6
    //   374: goto -20 -> 354
    //   377: astore 6
    //   379: goto -25 -> 354
    //   382: astore 8
    //   384: goto -65 -> 319
    //   387: iload 5
    //   389: istore_2
    //   390: goto -192 -> 198
    //   393: goto -195 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	m
    //   151	32	1	i1	int
    //   53	337	2	bool1	boolean
    //   24	277	3	bool2	boolean
    //   7	179	4	bool3	boolean
    //   10	378	5	bool4	boolean
    //   4	286	6	str	String
    //   348	17	6	localObject1	Object
    //   372	1	6	localObject2	Object
    //   377	1	6	localObject3	Object
    //   110	149	7	localObject4	Object
    //   309	1	7	localException1	Exception
    //   317	13	7	localObject5	Object
    //   340	1	7	localException2	Exception
    //   352	8	7	localThrowable1	Throwable
    //   367	1	7	localException3	Exception
    //   1	1	8	localObject6	Object
    //   314	37	8	localThrowable2	Throwable
    //   382	1	8	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   193	198	309	java/lang/Exception
    //   94	112	314	java/lang/Throwable
    //   329	334	340	java/lang/Exception
    //   94	112	348	finally
    //   359	364	367	java/lang/Exception
    //   112	178	372	finally
    //   319	324	377	finally
    //   112	178	382	java/lang/Throwable
  }
  
  private void p()
  {
    if (this.B == null) {
      this.B = new Handler(o.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (paramAnonymousMessage.what == 150) {
            m.a(m.this);
          }
        }
      };
    }
  }
  
  public Bundle a(int paramInt, File paramFile, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      paramFile = new File(paramFile, TbsDownloader.getBackupFileName(true));
      i1 = a.a(this.h, paramFile);
      localObject = new File(this.l, "x5.tbs");
      if (!((File)localObject).exists()) {
        break label189;
      }
    }
    label189:
    for (Object localObject = ((File)localObject).getAbsolutePath();; localObject = null)
    {
      int i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i1);
      localBundle.putInt("new_core_ver", i2);
      localBundle.putString("old_apk_location", paramFile.getAbsolutePath());
      localBundle.putString("new_apk_location", (String)localObject);
      localBundle.putString("diff_file_location", (String)localObject);
      return localBundle;
      if (TbsDownloader.getOverSea(this.h)) {}
      for (localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
      {
        paramFile = new File(paramFile, (String)localObject);
        break;
      }
    }
  }
  
  public Bundle a(int paramInt, boolean paramBoolean)
  {
    Object localObject5 = null;
    String str = "not_stable";
    int i2;
    Object localObject1;
    int i1;
    Object localObject4;
    Object localObject2;
    if (paramBoolean) {
      if (q.b(this.h))
      {
        i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
        localObject1 = new File(this.m, TbsDownloader.getBackupFileName(false, i2));
        i1 = TbsShareManager.getTbsStableCoreVersion(this.h, i2);
        str = "stable_core_" + i2;
        localObject4 = new File(this.l, "x5.tbs");
        if (!((File)localObject4).exists()) {
          break label295;
        }
        localObject2 = ((File)localObject4).getAbsolutePath();
        label126:
        if ((!paramBoolean) || (!q.b(this.h))) {
          break label632;
        }
        localObject4 = new File(this.m, TbsDownloader.getBackupFileName(false) + "." + "tmp");
        if (!((File)localObject4).exists()) {
          break label301;
        }
        localObject2 = ((File)localObject4).getAbsolutePath();
      }
    }
    label197:
    label632:
    for (Object localObject3 = localObject2;; localObject3 = localObject2)
    {
      if (localObject3 == null)
      {
        TbsLog.i("TbsDownload", "gettpatchBundle tbsApkFile is " + ((File)localObject4).getAbsolutePath());
        localObject1 = localObject5;
        return localObject1;
        localObject1 = p.a().q(this.h);
        i1 = p.a().i(this.h);
        break;
        localObject1 = p.a().r(this.h);
        i1 = p.a().j(this.h);
        break;
        localObject2 = null;
        break label126;
        localObject2 = null;
        break label197;
      }
      i2 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
      if (paramBoolean) {
        if (q.b(this.h)) {
          localObject2 = new File(this.m, TbsDownloader.getBackupFileName(false) + "." + "tpatch" + "." + "tmp");
        }
      }
      for (;;)
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("operation", paramInt);
        ((Bundle)localObject4).putInt("old_core_ver", i1);
        ((Bundle)localObject4).putInt("new_core_ver", i2);
        ((Bundle)localObject4).putString("old_apk_location", ((File)localObject1).getAbsolutePath());
        ((Bundle)localObject4).putString("new_apk_location", ((File)localObject2).getAbsolutePath());
        ((Bundle)localObject4).putString("diff_file_location", localObject3);
        ((Bundle)localObject4).putString("core_type_tpatch", str);
        localObject1 = FileUtil.a(this.h, 7);
        localObject2 = new File((String)localObject1);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        ((Bundle)localObject4).putString("backup_apk", new File((String)localObject1, i2 + ".tbs").getAbsolutePath());
        if ((paramBoolean) && (q.b(this.h))) {
          ((Bundle)localObject4).putInt("for_stable_core", 1);
        }
        localObject1 = localObject4;
        if (paramBoolean) {
          break;
        }
        ((Bundle)localObject4).putInt("for_self_core", 1);
        return localObject4;
        localObject2 = p.a().f(this.h, 6);
        continue;
        localObject2 = p.a().f(this.h, 5);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (p.a().u(this.h)) {
      p.a().b();
    }
    try
    {
      File localFile = new File(this.l, "x5.tbs");
      int i1 = a.a(this.h, localFile);
      if ((-1 == i1) || ((paramInt > 0) && (paramInt == i1))) {
        FileUtil.b(localFile);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean, false);
  }
  
  public boolean a()
  {
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    for (;;)
    {
      int i2;
      try
      {
        File localFile;
        if (q.b(this.h))
        {
          localFile = new File(FileUtil.a(this.h, "com.tencent.mm", 4, true), TbsDownloader.getBackupFileName(false));
          if (localFile != null) {
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup backupFile is " + localFile.getAbsolutePath());
          }
          if ((localFile != null) && (localFile.exists()))
          {
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            if (!a.a(this.h, localFile, 0L, TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1))) {
              break label603;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
            if (!q.b(this.h)) {
              break label644;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup isStableCoreForHostEnable and return true");
            return true;
          }
        }
        else
        {
          localFile = new File(FileUtil.a(this.h, 4), TbsDownloader.getBackupFileName(true));
          continue;
        }
        Object localObject1 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if (localObject1 != null) {
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup getExistBackupCoreForDecouple is " + ((File)localObject1).getAbsolutePath());
        }
        if ((localObject1 != null) && (((File)localObject1).exists())) {
          FileUtil.b((File)localObject1, localFile);
        }
        try
        {
          localObject1 = ((File)localObject1).getName();
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup fileNameSource is " + (String)localObject1);
          if (!((String)localObject1).contains("64")) {
            break label668;
          }
          i1 = 64;
          if (!q.b(this.h)) {
            continue;
          }
          localObject1 = this.m.listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, i1));
          int i3 = localObject1.length;
          i2 = 0;
          if (i2 < i3)
          {
            Object localObject2 = localObject1[i2];
            if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label674;
            }
            localObject2.delete();
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup delete file " + localObject2.getAbsolutePath());
            break label674;
          }
          localObject1 = new File(this.m, a.a(false, i1) + "." + TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_decouplecoreversion", -1));
          if ((localObject1 == null) || (!((File)localObject1).exists())) {
            break label605;
          }
          TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup  file already exist " + ((File)localObject1).getAbsolutePath());
        }
        catch (Throwable localThrowable)
        {
          TbsLog.i("TbsApkDownloader", "stack is " + Log.getStackTraceString(localThrowable));
        }
        continue;
        return false;
      }
      catch (Exception localException)
      {
        TbsLog.i("TbsApkDownloader", "stack is " + Log.getStackTraceString(localException));
      }
      label603:
      label605:
      localThrowable.createNewFile();
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup create file " + localThrowable.getAbsolutePath());
      continue;
      label644:
      TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup goto installDecoupleCoreFromBackup");
      boolean bool = p.a().f(this.h);
      return bool;
      label668:
      int i1 = 32;
      continue;
      label674:
      i2 += 1;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT == 23) {}
    label73:
    label335:
    label337:
    label353:
    label359:
    label379:
    do
    {
      return false;
      int i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("use_backup_version", 0);
      int i2 = p.a().j(this.h);
      File localFile;
      Object localObject;
      if (i1 == 0)
      {
        i1 = TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version", 0);
        this.a = "by default key";
        if ((i1 == 0) || (i1 == i2)) {
          break label335;
        }
        if (!paramBoolean2) {
          break label438;
        }
        localFile = TbsDownloader.a(i1);
        if ((localFile == null) || (!localFile.exists())) {
          break label353;
        }
        String str = FileUtil.a(this.h, 4);
        if (!TbsDownloader.getOverSea(this.h)) {
          break label337;
        }
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
      }
      for (;;)
      {
        try
        {
          if (TbsDownloadConfig.getInstance(this.h).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            break label353;
          }
          FileUtil.b(localFile, (File)localObject);
          i2 = 1;
          localObject = i();
          if ((localObject == null) || (!((File)localObject).exists()) || (!a((File)localObject))) {
            break label379;
          }
          if (!b(i1)) {
            break label438;
          }
          TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
          d(false);
          if (i2 != 0)
          {
            a(100, "use local backup apk in startDownload" + this.a, true);
            if (!TbsDownloader.a(this.h)) {
              break label359;
            }
            TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.x);
            this.x.resetArgs();
          }
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.a = "by new key";
        break label73;
        break;
        localObject = TbsDownloader.getBackupFileName(false);
        break label130;
        i2 = 0;
        continue;
        TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.x);
      }
      if (!q.b(this.h)) {
        j();
      }
      if ((localFile != null) && (localFile.exists()) && (!a.a(this.h, localFile, 0L, i1)) && (localFile != null) && (localFile.exists())) {
        FileUtil.b(localFile);
      }
      if (c(false, paramBoolean2))
      {
        TbsDownloadConfig.getInstance(this.h).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
        TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-214);
        d(false);
        return true;
      }
    } while ((e(true)) || (e(true)));
    label130:
    label438:
    TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
    TbsDownloadConfig.getInstance(this.h).setDownloadInterruptCode(-301);
    return false;
  }
  
  public void b()
  {
    this.t = true;
    TbsLogReport.TbsLogInfo localTbsLogInfo;
    if (TbsShareManager.isThirdPartyApp(this.h))
    {
      localTbsLogInfo = TbsLogReport.getInstance(this.h).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.a(this.h)) {
        TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
      }
    }
    else
    {
      return;
    }
    TbsLogReport.getInstance(this.h).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
  }
  
  /* Error */
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 138	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   3: aload_0
    //   4: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   7: invokevirtual 1039	com/tencent/smtt/sdk/p:d	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 800	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   21: aload_0
    //   22: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   25: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush -322
    //   31: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   39: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 614
    //   48: iconst_0
    //   49: invokeinterface 377 3 0
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_1
    //   57: if_icmpeq +13 -> 70
    //   60: iload_3
    //   61: iconst_2
    //   62: if_icmpeq +8 -> 70
    //   65: iload_3
    //   66: iconst_4
    //   67: if_icmpne +25 -> 92
    //   70: iconst_1
    //   71: istore 8
    //   73: iload_2
    //   74: ifne +24 -> 98
    //   77: aload_0
    //   78: iload_1
    //   79: iload 8
    //   81: invokevirtual 1041	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   84: ifeq +14 -> 98
    //   87: iconst_0
    //   88: putstatic 800	com/tencent/smtt/sdk/TbsDownloader:a	Z
    //   91: return
    //   92: iconst_0
    //   93: istore 8
    //   95: goto -22 -> 73
    //   98: aload_0
    //   99: iload_1
    //   100: putfield 1043	com/tencent/smtt/sdk/m:E	Z
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   108: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   114: ldc_w 1045
    //   117: aconst_null
    //   118: invokeinterface 458 3 0
    //   123: putfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   130: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   136: ldc_w 1049
    //   139: aconst_null
    //   140: invokeinterface 458 3 0
    //   145: astore 27
    //   147: ldc_w 273
    //   150: new 117	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 1051
    //   160: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 27
    //   165: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: iconst_1
    //   172: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 88	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 90	com/tencent/smtt/sdk/m:c	I
    //   185: iload_1
    //   186: ifne +36 -> 222
    //   189: aload 27
    //   191: ifnull +31 -> 222
    //   194: ldc 253
    //   196: aload 27
    //   198: invokevirtual 1057	java/lang/String:trim	()Ljava/lang/String;
    //   201: invokevirtual 465	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifne +18 -> 222
    //   207: aload_0
    //   208: aload 27
    //   210: invokevirtual 1057	java/lang/String:trim	()Ljava/lang/String;
    //   213: ldc_w 1059
    //   216: invokevirtual 1063	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   219: putfield 88	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   222: ldc_w 273
    //   225: new 117	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 1065
    //   235: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   242: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 1067
    //   248: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 27
    //   253: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 1069
    //   259: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_0
    //   263: getfield 728	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   266: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc_w 1071
    //   272: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   279: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   282: ldc_w 1073
    //   285: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   292: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_0
    //   302: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   305: ifnonnull +34 -> 339
    //   308: aload_0
    //   309: getfield 728	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   312: ifnonnull +27 -> 339
    //   315: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   318: bipush 110
    //   320: invokeinterface 612 2 0
    //   325: aload_0
    //   326: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   329: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   332: sipush -302
    //   335: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   338: return
    //   339: aload_0
    //   340: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   343: ifnull +34 -> 377
    //   346: aload_0
    //   347: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   350: ifne +27 -> 377
    //   353: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   356: bipush 110
    //   358: invokeinterface 612 2 0
    //   363: aload_0
    //   364: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   367: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   370: sipush -303
    //   373: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   376: return
    //   377: iload_1
    //   378: ifne +55 -> 433
    //   381: aload_0
    //   382: getfield 115	com/tencent/smtt/sdk/m:C	Ljava/util/Set;
    //   385: aload_0
    //   386: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   389: invokestatic 859	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   392: invokeinterface 881 2 0
    //   397: ifeq +36 -> 433
    //   400: ldc_w 273
    //   403: ldc_w 1075
    //   406: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   412: bipush 110
    //   414: invokeinterface 612 2 0
    //   419: aload_0
    //   420: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   423: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   426: sipush -304
    //   429: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   432: return
    //   433: aload_0
    //   434: invokespecial 168	com/tencent/smtt/sdk/m:g	()V
    //   437: ldc_w 273
    //   440: ldc_w 1077
    //   443: iconst_1
    //   444: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   447: aload_0
    //   448: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   451: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   454: invokevirtual 1080	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   457: lstore 25
    //   459: iconst_0
    //   460: istore 5
    //   462: aload_0
    //   463: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   466: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   469: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   472: ldc_w 1082
    //   475: lconst_0
    //   476: invokeinterface 482 4 0
    //   481: lstore 9
    //   483: iload_1
    //   484: ifeq +439 -> 923
    //   487: aload_0
    //   488: getstatic 55	com/tencent/smtt/sdk/m:f	I
    //   491: putfield 86	com/tencent/smtt/sdk/m:D	I
    //   494: iload_2
    //   495: ifeq +438 -> 933
    //   498: new 117	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 617
    //   508: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_0
    //   512: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   515: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   518: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   521: ldc_w 371
    //   524: iconst_0
    //   525: invokeinterface 377 3 0
    //   530: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: astore 27
    //   538: new 117	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   545: aload 27
    //   547: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 619
    //   553: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 621
    //   559: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_0
    //   563: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   566: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   569: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   572: ldc_w 478
    //   575: lconst_0
    //   576: invokeinterface 482 4 0
    //   581: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   584: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: astore 27
    //   589: aload_0
    //   590: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   593: ldc_w 1084
    //   596: aload 27
    //   598: invokestatic 626	com/tencent/smtt/utils/q:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   601: iload 5
    //   603: istore 4
    //   605: lload 9
    //   607: lstore 11
    //   609: aload_0
    //   610: getfield 257	com/tencent/smtt/sdk/m:r	I
    //   613: aload_0
    //   614: getfield 86	com/tencent/smtt/sdk/m:D	I
    //   617: if_icmple +448 -> 1065
    //   620: iload 4
    //   622: istore 5
    //   624: aload_0
    //   625: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   628: ifne +290 -> 918
    //   631: iload 5
    //   633: istore_1
    //   634: aload_0
    //   635: getfield 734	com/tencent/smtt/sdk/m:u	Z
    //   638: ifeq +209 -> 847
    //   641: iload 5
    //   643: istore_1
    //   644: aload_0
    //   645: getfield 88	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   648: ifnonnull +73 -> 721
    //   651: iload 5
    //   653: istore_1
    //   654: iload 5
    //   656: ifne +65 -> 721
    //   659: iload_2
    //   660: ifeq +6343 -> 7003
    //   663: aload_0
    //   664: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   667: invokestatic 636	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   670: ifeq +6333 -> 7003
    //   673: aload_0
    //   674: iconst_1
    //   675: iload 8
    //   677: new 158	java/io/File
    //   680: dup
    //   681: aload_0
    //   682: getfield 166	com/tencent/smtt/sdk/m:m	Ljava/io/File;
    //   685: new 117	java/lang/StringBuilder
    //   688: dup
    //   689: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   692: iconst_0
    //   693: invokestatic 215	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   696: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: ldc_w 379
    //   702: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 643
    //   708: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   717: invokespecial 574	com/tencent/smtt/sdk/m:a	(ZZLjava/io/File;)Z
    //   720: istore_1
    //   721: aload_0
    //   722: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   725: astore 27
    //   727: iload_1
    //   728: ifeq +6286 -> 7014
    //   731: iconst_1
    //   732: istore_3
    //   733: aload 27
    //   735: iload_3
    //   736: invokevirtual 1087	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   739: new 117	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 1089
    //   749: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: iload_1
    //   753: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   756: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 1091	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   762: iload 8
    //   764: ifne +6260 -> 7024
    //   767: aload_0
    //   768: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   771: astore 27
    //   773: iload_1
    //   774: ifeq +6245 -> 7019
    //   777: iconst_1
    //   778: istore_3
    //   779: aload 27
    //   781: iload_3
    //   782: invokevirtual 1094	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   785: ldc_w 273
    //   788: new 117	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 1096
    //   798: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: iload_1
    //   802: invokevirtual 446	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   805: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   811: iload_1
    //   812: ifeq +6223 -> 7035
    //   815: aload_0
    //   816: invokespecial 1098	com/tencent/smtt/sdk/m:h	()V
    //   819: aload_0
    //   820: iconst_1
    //   821: invokespecial 1021	com/tencent/smtt/sdk/m:d	(Z)V
    //   824: aload_0
    //   825: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   828: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   831: sipush -317
    //   834: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   837: aload_0
    //   838: bipush 100
    //   840: ldc_w 1100
    //   843: iconst_1
    //   844: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   847: aload_0
    //   848: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   851: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   854: astore 27
    //   856: iload_1
    //   857: ifeq +6200 -> 7057
    //   860: aload 27
    //   862: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   865: ldc_w 1102
    //   868: iconst_0
    //   869: invokeinterface 377 3 0
    //   874: istore_3
    //   875: aload 27
    //   877: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   880: ldc_w 1102
    //   883: iload_3
    //   884: iconst_1
    //   885: iadd
    //   886: invokestatic 528	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   889: invokeinterface 595 3 0
    //   894: pop
    //   895: aload 27
    //   897: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   900: aload_0
    //   901: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   904: astore 27
    //   906: iload_1
    //   907: ifeq +6211 -> 7118
    //   910: iconst_1
    //   911: istore_3
    //   912: aload 27
    //   914: iload_3
    //   915: invokevirtual 1105	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   918: aload_0
    //   919: invokespecial 1098	com/tencent/smtt/sdk/m:h	()V
    //   922: return
    //   923: aload_0
    //   924: getstatic 53	com/tencent/smtt/sdk/m:e	I
    //   927: putfield 86	com/tencent/smtt/sdk/m:D	I
    //   930: goto -436 -> 494
    //   933: lload 9
    //   935: lstore 11
    //   937: iload 5
    //   939: istore 4
    //   941: aload_0
    //   942: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   945: invokestatic 315	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   948: ifeq -339 -> 609
    //   951: new 117	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 617
    //   961: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload_0
    //   965: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   968: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   971: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   974: ldc_w 371
    //   977: iconst_0
    //   978: invokeinterface 377 3 0
    //   983: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   986: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: astore 27
    //   991: new 117	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   998: aload 27
    //   1000: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc_w 619
    //   1006: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: ldc_w 621
    //   1012: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload_0
    //   1016: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1019: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1022: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1025: ldc_w 478
    //   1028: lconst_0
    //   1029: invokeinterface 482 4 0
    //   1034: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: astore 27
    //   1042: aload_0
    //   1043: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1046: ldc_w 1084
    //   1049: aload 27
    //   1051: invokestatic 641	com/tencent/smtt/utils/q:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1054: lload 9
    //   1056: lstore 11
    //   1058: iload 5
    //   1060: istore 4
    //   1062: goto -453 -> 609
    //   1065: aload_0
    //   1066: getfield 722	com/tencent/smtt/sdk/m:s	I
    //   1069: bipush 8
    //   1071: if_icmple +31 -> 1102
    //   1074: aload_0
    //   1075: bipush 123
    //   1077: aconst_null
    //   1078: iconst_1
    //   1079: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1082: aload_0
    //   1083: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1086: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1089: sipush -306
    //   1092: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1095: iload 4
    //   1097: istore 5
    //   1099: goto -475 -> 624
    //   1102: invokestatic 183	java/lang/System:currentTimeMillis	()J
    //   1105: lstore 23
    //   1107: lload 11
    //   1109: lstore 9
    //   1111: iload_1
    //   1112: ifne +462 -> 1574
    //   1115: lload 11
    //   1117: lstore 15
    //   1119: iload 4
    //   1121: istore 5
    //   1123: lload 11
    //   1125: lstore 13
    //   1127: lload 23
    //   1129: aload_0
    //   1130: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1133: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1136: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1139: ldc_w 1107
    //   1142: lconst_0
    //   1143: invokeinterface 482 4 0
    //   1148: lsub
    //   1149: ldc2_w 1108
    //   1152: lcmp
    //   1153: ifle +258 -> 1411
    //   1156: lload 11
    //   1158: lstore 15
    //   1160: iload 4
    //   1162: istore 5
    //   1164: lload 11
    //   1166: lstore 13
    //   1168: ldc_w 273
    //   1171: ldc_w 1111
    //   1174: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1177: lload 11
    //   1179: lstore 15
    //   1181: iload 4
    //   1183: istore 5
    //   1185: lload 11
    //   1187: lstore 13
    //   1189: aload_0
    //   1190: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1193: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1196: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1199: ldc_w 1107
    //   1202: lload 23
    //   1204: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1207: invokeinterface 595 3 0
    //   1212: pop
    //   1213: lload 11
    //   1215: lstore 15
    //   1217: iload 4
    //   1219: istore 5
    //   1221: lload 11
    //   1223: lstore 13
    //   1225: aload_0
    //   1226: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1229: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1232: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1235: ldc_w 1082
    //   1238: lconst_0
    //   1239: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1242: invokeinterface 595 3 0
    //   1247: pop
    //   1248: lload 11
    //   1250: lstore 15
    //   1252: iload 4
    //   1254: istore 5
    //   1256: lload 11
    //   1258: lstore 13
    //   1260: aload_0
    //   1261: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1264: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1267: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1270: lconst_0
    //   1271: lstore 9
    //   1273: iload 4
    //   1275: istore 5
    //   1277: lload 9
    //   1279: lstore 11
    //   1281: lload 9
    //   1283: lstore 13
    //   1285: aload_0
    //   1286: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1289: invokestatic 1117	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   1292: ifne +282 -> 1574
    //   1295: iload 4
    //   1297: istore 5
    //   1299: lload 9
    //   1301: lstore 11
    //   1303: lload 9
    //   1305: lstore 13
    //   1307: ldc_w 273
    //   1310: ldc_w 1119
    //   1313: iconst_1
    //   1314: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1317: iload 4
    //   1319: istore 5
    //   1321: lload 9
    //   1323: lstore 11
    //   1325: lload 9
    //   1327: lstore 13
    //   1329: aload_0
    //   1330: bipush 105
    //   1332: aconst_null
    //   1333: iconst_1
    //   1334: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1337: iload 4
    //   1339: istore 5
    //   1341: lload 9
    //   1343: lstore 11
    //   1345: lload 9
    //   1347: lstore 13
    //   1349: aload_0
    //   1350: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1353: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1356: sipush -308
    //   1359: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1362: iload 4
    //   1364: istore 5
    //   1366: iload_1
    //   1367: ifne -743 -> 624
    //   1370: aload_0
    //   1371: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1374: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1377: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1380: ldc_w 1082
    //   1383: lload 9
    //   1385: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1388: invokeinterface 595 3 0
    //   1393: pop
    //   1394: aload_0
    //   1395: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1398: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1401: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1404: iload 4
    //   1406: istore 5
    //   1408: goto -784 -> 624
    //   1411: lload 11
    //   1413: lstore 15
    //   1415: iload 4
    //   1417: istore 5
    //   1419: lload 11
    //   1421: lstore 13
    //   1423: ldc_w 273
    //   1426: new 117	java/lang/StringBuilder
    //   1429: dup
    //   1430: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1433: ldc_w 1121
    //   1436: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: lload 11
    //   1441: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1450: lload 11
    //   1452: lload 25
    //   1454: lcmp
    //   1455: iflt +5849 -> 7304
    //   1458: lload 11
    //   1460: lstore 15
    //   1462: iload 4
    //   1464: istore 5
    //   1466: lload 11
    //   1468: lstore 13
    //   1470: ldc_w 273
    //   1473: ldc_w 1123
    //   1476: iconst_1
    //   1477: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1480: lload 11
    //   1482: lstore 15
    //   1484: iload 4
    //   1486: istore 5
    //   1488: lload 11
    //   1490: lstore 13
    //   1492: aload_0
    //   1493: bipush 112
    //   1495: aconst_null
    //   1496: iconst_1
    //   1497: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   1500: lload 11
    //   1502: lstore 15
    //   1504: iload 4
    //   1506: istore 5
    //   1508: lload 11
    //   1510: lstore 13
    //   1512: aload_0
    //   1513: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1516: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1519: sipush -307
    //   1522: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1525: iload 4
    //   1527: istore 5
    //   1529: iload_1
    //   1530: ifne -906 -> 624
    //   1533: aload_0
    //   1534: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1537: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1540: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1543: ldc_w 1082
    //   1546: lload 11
    //   1548: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1551: invokeinterface 595 3 0
    //   1556: pop
    //   1557: aload_0
    //   1558: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   1561: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1564: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1567: iload 4
    //   1569: istore 5
    //   1571: goto -947 -> 624
    //   1574: lload 9
    //   1576: lstore 15
    //   1578: iload 4
    //   1580: istore 5
    //   1582: lload 9
    //   1584: lstore 13
    //   1586: aload_0
    //   1587: iconst_1
    //   1588: putfield 736	com/tencent/smtt/sdk/m:A	Z
    //   1591: lload 9
    //   1593: lstore 15
    //   1595: iload 4
    //   1597: istore 5
    //   1599: lload 9
    //   1601: lstore 13
    //   1603: aload_0
    //   1604: getfield 728	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   1607: ifnull +888 -> 2495
    //   1610: lload 9
    //   1612: lstore 15
    //   1614: iload 4
    //   1616: istore 5
    //   1618: lload 9
    //   1620: lstore 13
    //   1622: aload_0
    //   1623: getfield 728	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   1626: astore 27
    //   1628: lload 9
    //   1630: lstore 15
    //   1632: iload 4
    //   1634: istore 5
    //   1636: lload 9
    //   1638: lstore 13
    //   1640: ldc_w 273
    //   1643: new 117	java/lang/StringBuilder
    //   1646: dup
    //   1647: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1650: ldc_w 1125
    //   1653: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: aload 27
    //   1658: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: ldc_w 1127
    //   1664: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: aload_0
    //   1668: getfield 257	com/tencent/smtt/sdk/m:r	I
    //   1671: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1674: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: iconst_1
    //   1678: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1681: lload 9
    //   1683: lstore 15
    //   1685: iload 4
    //   1687: istore 5
    //   1689: lload 9
    //   1691: lstore 13
    //   1693: aload 27
    //   1695: aload_0
    //   1696: getfield 1129	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1699: invokevirtual 465	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1702: ifne +24 -> 1726
    //   1705: lload 9
    //   1707: lstore 15
    //   1709: iload 4
    //   1711: istore 5
    //   1713: lload 9
    //   1715: lstore 13
    //   1717: aload_0
    //   1718: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1721: aload 27
    //   1723: invokevirtual 1132	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1726: lload 9
    //   1728: lstore 15
    //   1730: iload 4
    //   1732: istore 5
    //   1734: lload 9
    //   1736: lstore 13
    //   1738: aload_0
    //   1739: aload 27
    //   1741: putfield 1129	com/tencent/smtt/sdk/m:j	Ljava/lang/String;
    //   1744: lload 9
    //   1746: lstore 15
    //   1748: iload 4
    //   1750: istore 5
    //   1752: lload 9
    //   1754: lstore 13
    //   1756: aload_0
    //   1757: aload 27
    //   1759: invokespecial 1133	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;)V
    //   1762: lconst_0
    //   1763: lstore 11
    //   1765: lload 9
    //   1767: lstore 15
    //   1769: iload 4
    //   1771: istore 5
    //   1773: lload 9
    //   1775: lstore 13
    //   1777: aload_0
    //   1778: getfield 730	com/tencent/smtt/sdk/m:q	Z
    //   1781: ifne +170 -> 1951
    //   1784: lload 9
    //   1786: lstore 15
    //   1788: iload 4
    //   1790: istore 5
    //   1792: lload 9
    //   1794: lstore 13
    //   1796: aload_0
    //   1797: invokespecial 1135	com/tencent/smtt/sdk/m:l	()J
    //   1800: lstore 11
    //   1802: lload 9
    //   1804: lstore 15
    //   1806: iload 4
    //   1808: istore 5
    //   1810: lload 9
    //   1812: lstore 13
    //   1814: ldc_w 273
    //   1817: new 117	java/lang/StringBuilder
    //   1820: dup
    //   1821: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1824: ldc_w 1137
    //   1827: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: lload 11
    //   1832: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1835: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1838: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1841: lload 9
    //   1843: lstore 15
    //   1845: iload 4
    //   1847: istore 5
    //   1849: lload 9
    //   1851: lstore 13
    //   1853: aload_0
    //   1854: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   1857: lconst_0
    //   1858: lcmp
    //   1859: ifgt +657 -> 2516
    //   1862: lload 9
    //   1864: lstore 15
    //   1866: iload 4
    //   1868: istore 5
    //   1870: lload 9
    //   1872: lstore 13
    //   1874: ldc_w 273
    //   1877: new 117	java/lang/StringBuilder
    //   1880: dup
    //   1881: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1884: ldc_w 1139
    //   1887: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: lload 11
    //   1892: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1895: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1898: iconst_1
    //   1899: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1902: lload 9
    //   1904: lstore 15
    //   1906: iload 4
    //   1908: istore 5
    //   1910: lload 9
    //   1912: lstore 13
    //   1914: aload_0
    //   1915: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   1918: ldc_w 1141
    //   1921: new 117	java/lang/StringBuilder
    //   1924: dup
    //   1925: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1928: ldc_w 1143
    //   1931: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: lload 11
    //   1936: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1939: ldc_w 1145
    //   1942: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1948: invokevirtual 409	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1951: lload 9
    //   1953: lstore 15
    //   1955: iload 4
    //   1957: istore 5
    //   1959: lload 9
    //   1961: lstore 13
    //   1963: aload_0
    //   1964: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1967: astore 27
    //   1969: lload 11
    //   1971: lconst_0
    //   1972: lcmp
    //   1973: ifne +886 -> 2859
    //   1976: iconst_0
    //   1977: istore_3
    //   1978: lload 9
    //   1980: lstore 15
    //   1982: iload 4
    //   1984: istore 5
    //   1986: lload 9
    //   1988: lstore 13
    //   1990: aload 27
    //   1992: iload_3
    //   1993: invokevirtual 1148	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1996: lload 9
    //   1998: lstore 15
    //   2000: iload 4
    //   2002: istore 5
    //   2004: lload 9
    //   2006: lstore 13
    //   2008: aload_0
    //   2009: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2012: invokestatic 763	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2015: istore_3
    //   2016: lload 9
    //   2018: lstore 15
    //   2020: iload 4
    //   2022: istore 5
    //   2024: lload 9
    //   2026: lstore 13
    //   2028: aload_0
    //   2029: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2032: invokestatic 759	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   2035: astore 27
    //   2037: lload 9
    //   2039: lstore 15
    //   2041: iload 4
    //   2043: istore 5
    //   2045: lload 9
    //   2047: lstore 13
    //   2049: aload_0
    //   2050: getfield 170	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2053: ifnonnull +811 -> 2864
    //   2056: lload 9
    //   2058: lstore 15
    //   2060: iload 4
    //   2062: istore 5
    //   2064: lload 9
    //   2066: lstore 13
    //   2068: aload_0
    //   2069: getfield 172	com/tencent/smtt/sdk/m:z	I
    //   2072: iconst_m1
    //   2073: if_icmpne +791 -> 2864
    //   2076: lload 9
    //   2078: lstore 15
    //   2080: iload 4
    //   2082: istore 5
    //   2084: lload 9
    //   2086: lstore 13
    //   2088: aload_0
    //   2089: aload 27
    //   2091: putfield 170	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2094: lload 9
    //   2096: lstore 15
    //   2098: iload 4
    //   2100: istore 5
    //   2102: lload 9
    //   2104: lstore 13
    //   2106: aload_0
    //   2107: iload_3
    //   2108: putfield 172	com/tencent/smtt/sdk/m:z	I
    //   2111: lload 9
    //   2113: lstore 15
    //   2115: iload 4
    //   2117: istore 5
    //   2119: lload 9
    //   2121: lstore 13
    //   2123: aload_0
    //   2124: getfield 257	com/tencent/smtt/sdk/m:r	I
    //   2127: iconst_1
    //   2128: if_icmplt +29 -> 2157
    //   2131: lload 9
    //   2133: lstore 15
    //   2135: iload 4
    //   2137: istore 5
    //   2139: lload 9
    //   2141: lstore 13
    //   2143: aload_0
    //   2144: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   2147: ldc_w 1150
    //   2150: aload_0
    //   2151: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   2154: invokevirtual 1153	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2157: lload 9
    //   2159: lstore 15
    //   2161: iload 4
    //   2163: istore 5
    //   2165: lload 9
    //   2167: lstore 13
    //   2169: aload_0
    //   2170: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   2173: invokevirtual 870	java/net/HttpURLConnection:getResponseCode	()I
    //   2176: istore_3
    //   2177: lload 9
    //   2179: lstore 15
    //   2181: iload 4
    //   2183: istore 5
    //   2185: lload 9
    //   2187: lstore 13
    //   2189: ldc_w 273
    //   2192: new 117	java/lang/StringBuilder
    //   2195: dup
    //   2196: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2199: ldc_w 1155
    //   2202: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: iload_3
    //   2206: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2209: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2212: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2215: lload 9
    //   2217: lstore 15
    //   2219: iload 4
    //   2221: istore 5
    //   2223: lload 9
    //   2225: lstore 13
    //   2227: aload_0
    //   2228: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2231: iload_3
    //   2232: invokevirtual 1158	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   2235: iload_1
    //   2236: ifne +166 -> 2402
    //   2239: lload 9
    //   2241: lstore 15
    //   2243: iload 4
    //   2245: istore 5
    //   2247: lload 9
    //   2249: lstore 13
    //   2251: aload_0
    //   2252: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2255: invokestatic 206	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   2258: ifne +144 -> 2402
    //   2261: lload 9
    //   2263: lstore 15
    //   2265: iload 4
    //   2267: istore 5
    //   2269: lload 9
    //   2271: lstore 13
    //   2273: aload_0
    //   2274: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2277: invokestatic 763	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2280: iconst_3
    //   2281: if_icmpne +25 -> 2306
    //   2284: lload 9
    //   2286: lstore 15
    //   2288: iload 4
    //   2290: istore 5
    //   2292: lload 9
    //   2294: lstore 13
    //   2296: aload_0
    //   2297: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2300: invokestatic 763	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2303: ifne +99 -> 2402
    //   2306: lload 9
    //   2308: lstore 15
    //   2310: iload 4
    //   2312: istore 5
    //   2314: lload 9
    //   2316: lstore 13
    //   2318: invokestatic 1161	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2321: ifne +81 -> 2402
    //   2324: lload 9
    //   2326: lstore 15
    //   2328: iload 4
    //   2330: istore 5
    //   2332: lload 9
    //   2334: lstore 13
    //   2336: aload_0
    //   2337: invokevirtual 1162	com/tencent/smtt/sdk/m:b	()V
    //   2340: lload 9
    //   2342: lstore 15
    //   2344: iload 4
    //   2346: istore 5
    //   2348: lload 9
    //   2350: lstore 13
    //   2352: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   2355: ifnull +25 -> 2380
    //   2358: lload 9
    //   2360: lstore 15
    //   2362: iload 4
    //   2364: istore 5
    //   2366: lload 9
    //   2368: lstore 13
    //   2370: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   2373: bipush 111
    //   2375: invokeinterface 612 2 0
    //   2380: lload 9
    //   2382: lstore 15
    //   2384: iload 4
    //   2386: istore 5
    //   2388: lload 9
    //   2390: lstore 13
    //   2392: ldc_w 273
    //   2395: ldc_w 1164
    //   2398: iconst_0
    //   2399: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2402: lload 9
    //   2404: lstore 15
    //   2406: iload 4
    //   2408: istore 5
    //   2410: lload 9
    //   2412: lstore 13
    //   2414: aload_0
    //   2415: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   2418: ifeq +591 -> 3009
    //   2421: lload 9
    //   2423: lstore 15
    //   2425: iload 4
    //   2427: istore 5
    //   2429: lload 9
    //   2431: lstore 13
    //   2433: aload_0
    //   2434: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2437: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2440: sipush -309
    //   2443: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2446: iload 4
    //   2448: istore 5
    //   2450: iload_1
    //   2451: ifne -1827 -> 624
    //   2454: aload_0
    //   2455: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2458: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2461: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2464: ldc_w 1082
    //   2467: lload 9
    //   2469: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2472: invokeinterface 595 3 0
    //   2477: pop
    //   2478: aload_0
    //   2479: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2482: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2485: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2488: iload 4
    //   2490: istore 5
    //   2492: goto -1868 -> 624
    //   2495: lload 9
    //   2497: lstore 15
    //   2499: iload 4
    //   2501: istore 5
    //   2503: lload 9
    //   2505: lstore 13
    //   2507: aload_0
    //   2508: getfield 1047	com/tencent/smtt/sdk/m:i	Ljava/lang/String;
    //   2511: astore 27
    //   2513: goto -885 -> 1628
    //   2516: lload 9
    //   2518: lstore 15
    //   2520: iload 4
    //   2522: istore 5
    //   2524: lload 9
    //   2526: lstore 13
    //   2528: ldc_w 273
    //   2531: new 117	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2538: ldc_w 1166
    //   2541: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: lload 11
    //   2546: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2549: ldc_w 1168
    //   2552: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: aload_0
    //   2556: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   2559: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2562: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2565: iconst_1
    //   2566: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2569: lload 9
    //   2571: lstore 15
    //   2573: iload 4
    //   2575: istore 5
    //   2577: lload 9
    //   2579: lstore 13
    //   2581: ldc_w 273
    //   2584: new 117	java/lang/StringBuilder
    //   2587: dup
    //   2588: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2591: ldc_w 1166
    //   2594: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2597: lload 11
    //   2599: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2602: ldc_w 1168
    //   2605: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: aload_0
    //   2609: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   2612: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2615: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2618: invokestatic 1171	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2621: pop
    //   2622: lload 9
    //   2624: lstore 15
    //   2626: iload 4
    //   2628: istore 5
    //   2630: lload 9
    //   2632: lstore 13
    //   2634: aload_0
    //   2635: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   2638: ldc_w 1141
    //   2641: new 117	java/lang/StringBuilder
    //   2644: dup
    //   2645: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2648: ldc_w 1143
    //   2651: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: lload 11
    //   2656: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2659: ldc_w 1145
    //   2662: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: aload_0
    //   2666: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   2669: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2672: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2675: invokevirtual 409	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2678: goto -727 -> 1951
    //   2681: astore 27
    //   2683: iload 5
    //   2685: istore 6
    //   2687: lload 15
    //   2689: lstore 13
    //   2691: aload 27
    //   2693: instanceof 1173
    //   2696: ifeq +4195 -> 6891
    //   2699: iload_1
    //   2700: ifne +4191 -> 6891
    //   2703: lload 15
    //   2705: lstore 13
    //   2707: aload_0
    //   2708: getfield 88	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   2711: ifnull +4180 -> 6891
    //   2714: lload 15
    //   2716: lstore 13
    //   2718: aload_0
    //   2719: iconst_0
    //   2720: invokevirtual 1175	com/tencent/smtt/sdk/m:b	(Z)Z
    //   2723: ifeq +4168 -> 6891
    //   2726: lload 15
    //   2728: lstore 13
    //   2730: ldc_w 273
    //   2733: new 117	java/lang/StringBuilder
    //   2736: dup
    //   2737: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2740: ldc_w 1177
    //   2743: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: aload_0
    //   2747: getfield 728	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   2750: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: ldc_w 1179
    //   2756: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2759: aload 27
    //   2761: invokevirtual 431	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2764: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2767: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2770: invokestatic 386	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2773: lload 15
    //   2775: lstore 13
    //   2777: aload_0
    //   2778: bipush 125
    //   2780: aconst_null
    //   2781: iconst_1
    //   2782: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   2785: lload 15
    //   2787: lstore 13
    //   2789: aload_0
    //   2790: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2793: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2796: sipush -316
    //   2799: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2802: lload 15
    //   2804: lstore 11
    //   2806: iload 6
    //   2808: istore 4
    //   2810: iload_1
    //   2811: ifne -2202 -> 609
    //   2814: aload_0
    //   2815: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2818: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2821: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2824: ldc_w 1082
    //   2827: lload 15
    //   2829: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2832: invokeinterface 595 3 0
    //   2837: pop
    //   2838: aload_0
    //   2839: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2842: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2845: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2848: lload 15
    //   2850: lstore 11
    //   2852: iload 6
    //   2854: istore 4
    //   2856: goto -2247 -> 609
    //   2859: iconst_1
    //   2860: istore_3
    //   2861: goto -883 -> 1978
    //   2864: lload 9
    //   2866: lstore 15
    //   2868: iload 4
    //   2870: istore 5
    //   2872: lload 9
    //   2874: lstore 13
    //   2876: iload_3
    //   2877: aload_0
    //   2878: getfield 172	com/tencent/smtt/sdk/m:z	I
    //   2881: if_icmpne +27 -> 2908
    //   2884: lload 9
    //   2886: lstore 15
    //   2888: iload 4
    //   2890: istore 5
    //   2892: lload 9
    //   2894: lstore 13
    //   2896: aload 27
    //   2898: aload_0
    //   2899: getfield 170	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2902: invokevirtual 465	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2905: ifne -794 -> 2111
    //   2908: lload 9
    //   2910: lstore 15
    //   2912: iload 4
    //   2914: istore 5
    //   2916: lload 9
    //   2918: lstore 13
    //   2920: aload_0
    //   2921: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2924: iconst_0
    //   2925: invokevirtual 772	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2928: lload 9
    //   2930: lstore 15
    //   2932: iload 4
    //   2934: istore 5
    //   2936: lload 9
    //   2938: lstore 13
    //   2940: aload_0
    //   2941: aload 27
    //   2943: putfield 170	com/tencent/smtt/sdk/m:y	Ljava/lang/String;
    //   2946: lload 9
    //   2948: lstore 15
    //   2950: iload 4
    //   2952: istore 5
    //   2954: lload 9
    //   2956: lstore 13
    //   2958: aload_0
    //   2959: iload_3
    //   2960: putfield 172	com/tencent/smtt/sdk/m:z	I
    //   2963: goto -852 -> 2111
    //   2966: astore 27
    //   2968: iload_1
    //   2969: ifne +37 -> 3006
    //   2972: aload_0
    //   2973: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   2976: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2979: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2982: ldc_w 1082
    //   2985: lload 13
    //   2987: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2990: invokeinterface 595 3 0
    //   2995: pop
    //   2996: aload_0
    //   2997: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3000: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3003: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3006: aload 27
    //   3008: athrow
    //   3009: iload_3
    //   3010: sipush 200
    //   3013: if_icmpeq +10 -> 3023
    //   3016: iload_3
    //   3017: sipush 206
    //   3020: if_icmpne +2645 -> 5665
    //   3023: lload 9
    //   3025: lstore 15
    //   3027: iload 4
    //   3029: istore 5
    //   3031: lload 9
    //   3033: lstore 13
    //   3035: aload_0
    //   3036: aload_0
    //   3037: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   3040: invokevirtual 1182	java/net/HttpURLConnection:getContentLength	()I
    //   3043: i2l
    //   3044: lload 11
    //   3046: ladd
    //   3047: putfield 726	com/tencent/smtt/sdk/m:n	J
    //   3050: lload 9
    //   3052: lstore 15
    //   3054: iload 4
    //   3056: istore 5
    //   3058: lload 9
    //   3060: lstore 13
    //   3062: ldc_w 273
    //   3065: new 117	java/lang/StringBuilder
    //   3068: dup
    //   3069: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   3072: ldc_w 1184
    //   3075: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3078: aload_0
    //   3079: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   3082: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3085: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3088: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3091: lload 9
    //   3093: lstore 15
    //   3095: iload 4
    //   3097: istore 5
    //   3099: lload 9
    //   3101: lstore 13
    //   3103: aload_0
    //   3104: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3107: aload_0
    //   3108: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   3111: invokevirtual 1187	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   3114: lload 9
    //   3116: lstore 15
    //   3118: iload 4
    //   3120: istore 5
    //   3122: lload 9
    //   3124: lstore 13
    //   3126: aload_0
    //   3127: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3130: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3133: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3136: ldc_w 478
    //   3139: lconst_0
    //   3140: invokeinterface 482 4 0
    //   3145: lstore 17
    //   3147: lload 17
    //   3149: lconst_0
    //   3150: lcmp
    //   3151: ifeq +410 -> 3561
    //   3154: lload 9
    //   3156: lstore 15
    //   3158: iload 4
    //   3160: istore 5
    //   3162: lload 9
    //   3164: lstore 13
    //   3166: aload_0
    //   3167: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   3170: lload 17
    //   3172: lcmp
    //   3173: ifeq +388 -> 3561
    //   3176: lload 9
    //   3178: lstore 15
    //   3180: iload 4
    //   3182: istore 5
    //   3184: lload 9
    //   3186: lstore 13
    //   3188: ldc_w 273
    //   3191: new 117	java/lang/StringBuilder
    //   3194: dup
    //   3195: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   3198: ldc_w 1189
    //   3201: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3204: lload 17
    //   3206: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3209: ldc_w 1191
    //   3212: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3215: aload_0
    //   3216: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   3219: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3222: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3225: iconst_1
    //   3226: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3229: iload_1
    //   3230: ifne +281 -> 3511
    //   3233: lload 9
    //   3235: lstore 15
    //   3237: iload 4
    //   3239: istore 5
    //   3241: lload 9
    //   3243: lstore 13
    //   3245: aload_0
    //   3246: invokespecial 434	com/tencent/smtt/sdk/m:o	()Z
    //   3249: ifne +43 -> 3292
    //   3252: lload 9
    //   3254: lstore 15
    //   3256: iload 4
    //   3258: istore 5
    //   3260: lload 9
    //   3262: lstore 13
    //   3264: invokestatic 1161	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   3267: ifeq +244 -> 3511
    //   3270: lload 9
    //   3272: lstore 15
    //   3274: iload 4
    //   3276: istore 5
    //   3278: lload 9
    //   3280: lstore 13
    //   3282: aload_0
    //   3283: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3286: invokestatic 778	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3289: ifeq +222 -> 3511
    //   3292: lload 9
    //   3294: lstore 15
    //   3296: iload 4
    //   3298: istore 5
    //   3300: lload 9
    //   3302: lstore 13
    //   3304: aload_0
    //   3305: getfield 88	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   3308: ifnull +76 -> 3384
    //   3311: lload 9
    //   3313: lstore 15
    //   3315: iload 4
    //   3317: istore 5
    //   3319: lload 9
    //   3321: lstore 13
    //   3323: aload_0
    //   3324: iconst_0
    //   3325: invokevirtual 1175	com/tencent/smtt/sdk/m:b	(Z)Z
    //   3328: istore 6
    //   3330: iload 6
    //   3332: ifeq +52 -> 3384
    //   3335: lload 9
    //   3337: lstore 11
    //   3339: iload_1
    //   3340: ifne -2731 -> 609
    //   3343: aload_0
    //   3344: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3347: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3350: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3353: ldc_w 1082
    //   3356: lload 9
    //   3358: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3361: invokeinterface 595 3 0
    //   3366: pop
    //   3367: aload_0
    //   3368: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3371: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3374: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3377: lload 9
    //   3379: lstore 11
    //   3381: goto -2772 -> 609
    //   3384: lload 9
    //   3386: lstore 15
    //   3388: iload 4
    //   3390: istore 5
    //   3392: lload 9
    //   3394: lstore 13
    //   3396: aload_0
    //   3397: bipush 113
    //   3399: new 117	java/lang/StringBuilder
    //   3402: dup
    //   3403: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   3406: ldc_w 1193
    //   3409: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: lload 17
    //   3414: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3417: ldc_w 1191
    //   3420: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3423: aload_0
    //   3424: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   3427: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3430: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3433: iconst_1
    //   3434: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3437: lload 9
    //   3439: lstore 15
    //   3441: iload 4
    //   3443: istore 5
    //   3445: lload 9
    //   3447: lstore 13
    //   3449: aload_0
    //   3450: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3453: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3456: sipush -310
    //   3459: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3462: iload 4
    //   3464: istore 5
    //   3466: iload_1
    //   3467: ifne -2843 -> 624
    //   3470: aload_0
    //   3471: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3474: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3477: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3480: ldc_w 1082
    //   3483: lload 9
    //   3485: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3488: invokeinterface 595 3 0
    //   3493: pop
    //   3494: aload_0
    //   3495: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3498: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3501: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3504: iload 4
    //   3506: istore 5
    //   3508: goto -2884 -> 624
    //   3511: lload 9
    //   3513: lstore 15
    //   3515: iload 4
    //   3517: istore 5
    //   3519: lload 9
    //   3521: lstore 13
    //   3523: aload_0
    //   3524: bipush 101
    //   3526: ldc_w 1195
    //   3529: iconst_1
    //   3530: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   3533: lload 9
    //   3535: lstore 15
    //   3537: iload 4
    //   3539: istore 5
    //   3541: lload 9
    //   3543: lstore 13
    //   3545: aload_0
    //   3546: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3549: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3552: sipush -304
    //   3555: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3558: goto -96 -> 3462
    //   3561: aconst_null
    //   3562: astore 31
    //   3564: aconst_null
    //   3565: astore 27
    //   3567: aconst_null
    //   3568: astore 29
    //   3570: lload 9
    //   3572: lstore 15
    //   3574: iload 4
    //   3576: istore 5
    //   3578: lload 9
    //   3580: lstore 13
    //   3582: ldc_w 273
    //   3585: ldc_w 1197
    //   3588: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3591: aload_0
    //   3592: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   3595: invokevirtual 867	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3598: astore 28
    //   3600: aload 28
    //   3602: ifnull +3693 -> 7295
    //   3605: aload_0
    //   3606: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   3609: invokevirtual 1200	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3612: astore 27
    //   3614: aload 27
    //   3616: ifnull +365 -> 3981
    //   3619: aload 27
    //   3621: ldc_w 1202
    //   3624: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3627: ifeq +354 -> 3981
    //   3630: new 1204	java/util/zip/GZIPInputStream
    //   3633: dup
    //   3634: aload 28
    //   3636: invokespecial 1205	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3639: astore 27
    //   3641: sipush 8192
    //   3644: newarray byte
    //   3646: astore 32
    //   3648: iload_2
    //   3649: ifeq +552 -> 4201
    //   3652: aload_0
    //   3653: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3656: invokestatic 636	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   3659: ifeq +542 -> 4201
    //   3662: new 158	java/io/File
    //   3665: dup
    //   3666: aload_0
    //   3667: getfield 166	com/tencent/smtt/sdk/m:m	Ljava/io/File;
    //   3670: new 117	java/lang/StringBuilder
    //   3673: dup
    //   3674: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   3677: iconst_0
    //   3678: invokestatic 215	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   3681: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3684: ldc_w 379
    //   3687: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3690: ldc_w 643
    //   3693: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3699: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3702: astore 30
    //   3704: aload 30
    //   3706: astore 29
    //   3708: aload 30
    //   3710: invokevirtual 197	java/io/File:exists	()Z
    //   3713: ifeq +13 -> 3726
    //   3716: aload 30
    //   3718: invokevirtual 320	java/io/File:delete	()Z
    //   3721: pop
    //   3722: aload 30
    //   3724: astore 29
    //   3726: ldc_w 273
    //   3729: new 117	java/lang/StringBuilder
    //   3732: dup
    //   3733: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   3736: ldc_w 1207
    //   3739: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3742: aload 29
    //   3744: invokevirtual 297	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3747: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3750: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3753: iconst_1
    //   3754: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3757: new 1209	java/io/FileOutputStream
    //   3760: dup
    //   3761: aload 29
    //   3763: iconst_1
    //   3764: invokespecial 1212	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3767: astore 30
    //   3769: invokestatic 183	java/lang/System:currentTimeMillis	()J
    //   3772: lstore 15
    //   3774: lload 11
    //   3776: lstore 21
    //   3778: lload 11
    //   3780: lstore 13
    //   3782: iload 4
    //   3784: istore 6
    //   3786: lload 9
    //   3788: lstore 17
    //   3790: iload 4
    //   3792: istore 7
    //   3794: lload 9
    //   3796: lstore 19
    //   3798: aload_0
    //   3799: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   3802: ifeq +447 -> 4249
    //   3805: iload 4
    //   3807: istore 6
    //   3809: lload 9
    //   3811: lstore 17
    //   3813: iload 4
    //   3815: istore 7
    //   3817: lload 9
    //   3819: lstore 19
    //   3821: ldc_w 273
    //   3824: ldc_w 1214
    //   3827: iconst_1
    //   3828: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3831: iload 4
    //   3833: istore 6
    //   3835: lload 9
    //   3837: lstore 17
    //   3839: iload 4
    //   3841: istore 7
    //   3843: lload 9
    //   3845: lstore 19
    //   3847: aload_0
    //   3848: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3851: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3854: sipush -309
    //   3857: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3860: iconst_0
    //   3861: istore_3
    //   3862: iload 4
    //   3864: istore 6
    //   3866: iload_3
    //   3867: ifeq +1217 -> 5084
    //   3870: lload 9
    //   3872: lstore 15
    //   3874: iload 6
    //   3876: istore 5
    //   3878: lload 9
    //   3880: lstore 13
    //   3882: aload_0
    //   3883: aload 30
    //   3885: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3888: lload 9
    //   3890: lstore 15
    //   3892: iload 6
    //   3894: istore 5
    //   3896: lload 9
    //   3898: lstore 13
    //   3900: aload_0
    //   3901: aload 27
    //   3903: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3906: lload 9
    //   3908: lstore 15
    //   3910: iload 6
    //   3912: istore 5
    //   3914: lload 9
    //   3916: lstore 13
    //   3918: aload_0
    //   3919: aload 28
    //   3921: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   3924: lload 9
    //   3926: lstore 11
    //   3928: iload 6
    //   3930: istore 4
    //   3932: iload_1
    //   3933: ifne -3324 -> 609
    //   3936: aload_0
    //   3937: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3940: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3943: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3946: ldc_w 1082
    //   3949: lload 9
    //   3951: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3954: invokeinterface 595 3 0
    //   3959: pop
    //   3960: aload_0
    //   3961: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   3964: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3967: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3970: lload 9
    //   3972: lstore 11
    //   3974: iload 6
    //   3976: istore 4
    //   3978: goto -3369 -> 609
    //   3981: aload 27
    //   3983: ifnull +211 -> 4194
    //   3986: aload 27
    //   3988: ldc_w 1216
    //   3991: invokevirtual 332	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3994: ifeq +200 -> 4194
    //   3997: new 1218	java/util/zip/InflaterInputStream
    //   4000: dup
    //   4001: aload 28
    //   4003: new 1220	java/util/zip/Inflater
    //   4006: dup
    //   4007: iconst_1
    //   4008: invokespecial 1222	java/util/zip/Inflater:<init>	(Z)V
    //   4011: invokespecial 1225	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   4014: astore 27
    //   4016: goto -375 -> 3641
    //   4019: astore 32
    //   4021: aload 28
    //   4023: astore 27
    //   4025: aload 31
    //   4027: astore 30
    //   4029: aload 32
    //   4031: astore 28
    //   4033: iload 4
    //   4035: istore 6
    //   4037: aload 28
    //   4039: invokevirtual 1226	java/io/IOException:printStackTrace	()V
    //   4042: aload 28
    //   4044: instanceof 1228
    //   4047: ifne +11 -> 4058
    //   4050: aload 28
    //   4052: instanceof 1230
    //   4055: ifeq +1180 -> 5235
    //   4058: aload_0
    //   4059: ldc_w 1231
    //   4062: putfield 82	com/tencent/smtt/sdk/m:o	I
    //   4065: aload_0
    //   4066: lconst_0
    //   4067: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   4070: aload_0
    //   4071: bipush 103
    //   4073: aload_0
    //   4074: aload 28
    //   4076: invokespecial 535	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4079: iconst_0
    //   4080: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4083: lload 9
    //   4085: lstore 15
    //   4087: iload 6
    //   4089: istore 5
    //   4091: lload 9
    //   4093: lstore 13
    //   4095: aload_0
    //   4096: aload 30
    //   4098: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4101: lload 9
    //   4103: lstore 15
    //   4105: iload 6
    //   4107: istore 5
    //   4109: lload 9
    //   4111: lstore 13
    //   4113: aload_0
    //   4114: aload 29
    //   4116: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4119: lload 9
    //   4121: lstore 15
    //   4123: iload 6
    //   4125: istore 5
    //   4127: lload 9
    //   4129: lstore 13
    //   4131: aload_0
    //   4132: aload 27
    //   4134: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   4137: lload 9
    //   4139: lstore 11
    //   4141: iload 6
    //   4143: istore 4
    //   4145: iload_1
    //   4146: ifne -3537 -> 609
    //   4149: aload_0
    //   4150: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4153: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4156: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4159: ldc_w 1082
    //   4162: lload 9
    //   4164: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4167: invokeinterface 595 3 0
    //   4172: pop
    //   4173: aload_0
    //   4174: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4177: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4180: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4183: lload 9
    //   4185: lstore 11
    //   4187: iload 6
    //   4189: istore 4
    //   4191: goto -3582 -> 609
    //   4194: aload 28
    //   4196: astore 27
    //   4198: goto -557 -> 3641
    //   4201: new 158	java/io/File
    //   4204: dup
    //   4205: aload_0
    //   4206: getfield 143	com/tencent/smtt/sdk/m:l	Ljava/io/File;
    //   4209: ldc_w 452
    //   4212: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   4215: astore 29
    //   4217: goto -491 -> 3726
    //   4220: astore 29
    //   4222: aload 28
    //   4224: astore 30
    //   4226: iload 4
    //   4228: istore 6
    //   4230: aload 29
    //   4232: astore 28
    //   4234: aload 27
    //   4236: astore 29
    //   4238: aload 30
    //   4240: astore 27
    //   4242: aload 31
    //   4244: astore 30
    //   4246: goto -209 -> 4037
    //   4249: iload 4
    //   4251: istore 6
    //   4253: lload 9
    //   4255: lstore 17
    //   4257: iload 4
    //   4259: istore 7
    //   4261: lload 9
    //   4263: lstore 19
    //   4265: aload 27
    //   4267: aload 32
    //   4269: iconst_0
    //   4270: sipush 8192
    //   4273: invokevirtual 1239	java/io/InputStream:read	([BII)I
    //   4276: istore_3
    //   4277: iload_3
    //   4278: ifgt +207 -> 4485
    //   4281: iload 4
    //   4283: istore 6
    //   4285: lload 9
    //   4287: lstore 17
    //   4289: iload 4
    //   4291: istore 7
    //   4293: lload 9
    //   4295: lstore 19
    //   4297: aload_0
    //   4298: getfield 88	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   4301: ifnull +95 -> 4396
    //   4304: iload 4
    //   4306: istore 6
    //   4308: lload 9
    //   4310: lstore 17
    //   4312: iload 4
    //   4314: istore 7
    //   4316: lload 9
    //   4318: lstore 19
    //   4320: aload_0
    //   4321: iconst_1
    //   4322: iload 8
    //   4324: invokespecial 1029	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   4327: ifne +69 -> 4396
    //   4330: iload_1
    //   4331: ifne +36 -> 4367
    //   4334: iload 4
    //   4336: istore 6
    //   4338: lload 9
    //   4340: lstore 17
    //   4342: iload 4
    //   4344: istore 7
    //   4346: lload 9
    //   4348: lstore 19
    //   4350: aload_0
    //   4351: iconst_0
    //   4352: invokevirtual 1175	com/tencent/smtt/sdk/m:b	(Z)Z
    //   4355: ifeq +12 -> 4367
    //   4358: iconst_1
    //   4359: istore_3
    //   4360: iload 4
    //   4362: istore 6
    //   4364: goto -498 -> 3866
    //   4367: iload 4
    //   4369: istore 6
    //   4371: lload 9
    //   4373: lstore 17
    //   4375: iload 4
    //   4377: istore 7
    //   4379: lload 9
    //   4381: lstore 19
    //   4383: aload_0
    //   4384: iconst_1
    //   4385: putfield 734	com/tencent/smtt/sdk/m:u	Z
    //   4388: iconst_0
    //   4389: istore 6
    //   4391: iconst_0
    //   4392: istore_3
    //   4393: goto -527 -> 3866
    //   4396: iload 4
    //   4398: istore 6
    //   4400: lload 9
    //   4402: lstore 17
    //   4404: iload 4
    //   4406: istore 7
    //   4408: lload 9
    //   4410: lstore 19
    //   4412: aload_0
    //   4413: iconst_1
    //   4414: putfield 734	com/tencent/smtt/sdk/m:u	Z
    //   4417: iload 4
    //   4419: istore 5
    //   4421: iload 4
    //   4423: istore 6
    //   4425: lload 9
    //   4427: lstore 17
    //   4429: iload 4
    //   4431: istore 7
    //   4433: lload 9
    //   4435: lstore 19
    //   4437: aload_0
    //   4438: getfield 88	com/tencent/smtt/sdk/m:b	[Ljava/lang/String;
    //   4441: ifnull +6 -> 4447
    //   4444: iconst_1
    //   4445: istore 5
    //   4447: iload 5
    //   4449: istore 6
    //   4451: lload 9
    //   4453: lstore 17
    //   4455: iload 5
    //   4457: istore 7
    //   4459: lload 9
    //   4461: lstore 19
    //   4463: aload_0
    //   4464: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4467: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4470: sipush -311
    //   4473: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4476: iconst_0
    //   4477: istore_3
    //   4478: iload 5
    //   4480: istore 6
    //   4482: goto -616 -> 3866
    //   4485: iload 4
    //   4487: istore 6
    //   4489: lload 9
    //   4491: lstore 17
    //   4493: iload 4
    //   4495: istore 7
    //   4497: lload 9
    //   4499: lstore 19
    //   4501: aload 30
    //   4503: aload 32
    //   4505: iconst_0
    //   4506: iload_3
    //   4507: invokevirtual 1243	java/io/FileOutputStream:write	([BII)V
    //   4510: iload 4
    //   4512: istore 6
    //   4514: lload 9
    //   4516: lstore 17
    //   4518: iload 4
    //   4520: istore 7
    //   4522: lload 9
    //   4524: lstore 19
    //   4526: aload 30
    //   4528: invokevirtual 1246	java/io/FileOutputStream:flush	()V
    //   4531: lload 9
    //   4533: lstore 11
    //   4535: iload_1
    //   4536: ifne +295 -> 4831
    //   4539: lload 9
    //   4541: iload_3
    //   4542: i2l
    //   4543: ladd
    //   4544: lstore 9
    //   4546: lload 9
    //   4548: lload 25
    //   4550: lcmp
    //   4551: iflt +122 -> 4673
    //   4554: iload 4
    //   4556: istore 6
    //   4558: lload 9
    //   4560: lstore 17
    //   4562: iload 4
    //   4564: istore 7
    //   4566: lload 9
    //   4568: lstore 19
    //   4570: ldc_w 273
    //   4573: ldc_w 1123
    //   4576: iconst_1
    //   4577: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4580: iload 4
    //   4582: istore 6
    //   4584: lload 9
    //   4586: lstore 17
    //   4588: iload 4
    //   4590: istore 7
    //   4592: lload 9
    //   4594: lstore 19
    //   4596: aload_0
    //   4597: bipush 112
    //   4599: new 117	java/lang/StringBuilder
    //   4602: dup
    //   4603: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   4606: ldc_w 1248
    //   4609: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4612: lload 9
    //   4614: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4617: ldc_w 1250
    //   4620: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4623: lload 25
    //   4625: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4628: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4631: iconst_1
    //   4632: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4635: iload 4
    //   4637: istore 6
    //   4639: lload 9
    //   4641: lstore 17
    //   4643: iload 4
    //   4645: istore 7
    //   4647: lload 9
    //   4649: lstore 19
    //   4651: aload_0
    //   4652: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4655: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4658: sipush -307
    //   4661: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4664: iconst_0
    //   4665: istore_3
    //   4666: iload 4
    //   4668: istore 6
    //   4670: goto -804 -> 3866
    //   4673: lload 9
    //   4675: lstore 11
    //   4677: iload 4
    //   4679: istore 6
    //   4681: lload 9
    //   4683: lstore 17
    //   4685: iload 4
    //   4687: istore 7
    //   4689: lload 9
    //   4691: lstore 19
    //   4693: aload_0
    //   4694: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4697: invokestatic 1117	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   4700: ifne +131 -> 4831
    //   4703: iload 4
    //   4705: istore 6
    //   4707: lload 9
    //   4709: lstore 17
    //   4711: iload 4
    //   4713: istore 7
    //   4715: lload 9
    //   4717: lstore 19
    //   4719: ldc_w 273
    //   4722: ldc_w 1252
    //   4725: iconst_1
    //   4726: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4729: iload 4
    //   4731: istore 6
    //   4733: lload 9
    //   4735: lstore 17
    //   4737: iload 4
    //   4739: istore 7
    //   4741: lload 9
    //   4743: lstore 19
    //   4745: aload_0
    //   4746: bipush 105
    //   4748: new 117	java/lang/StringBuilder
    //   4751: dup
    //   4752: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   4755: ldc_w 1254
    //   4758: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4761: invokestatic 1256	com/tencent/smtt/utils/q:a	()J
    //   4764: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4767: ldc_w 1258
    //   4770: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4773: aload_0
    //   4774: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4777: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4780: invokevirtual 1261	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4783: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4786: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4789: iconst_1
    //   4790: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   4793: iload 4
    //   4795: istore 6
    //   4797: lload 9
    //   4799: lstore 17
    //   4801: iload 4
    //   4803: istore 7
    //   4805: lload 9
    //   4807: lstore 19
    //   4809: aload_0
    //   4810: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4813: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4816: sipush -308
    //   4819: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4822: iconst_0
    //   4823: istore_3
    //   4824: iload 4
    //   4826: istore 6
    //   4828: goto -962 -> 3866
    //   4831: iload_3
    //   4832: i2l
    //   4833: lstore 9
    //   4835: aload_0
    //   4836: lload 23
    //   4838: lload 9
    //   4840: invokespecial 1263	com/tencent/smtt/sdk/m:a	(JJ)J
    //   4843: lstore 23
    //   4845: invokestatic 183	java/lang/System:currentTimeMillis	()J
    //   4848: lstore 19
    //   4850: iload_3
    //   4851: i2l
    //   4852: lload 21
    //   4854: ladd
    //   4855: lstore 17
    //   4857: lload 19
    //   4859: lload 15
    //   4861: lsub
    //   4862: ldc2_w 1264
    //   4865: lcmp
    //   4866: ifle +2418 -> 7284
    //   4869: ldc_w 273
    //   4872: new 117	java/lang/StringBuilder
    //   4875: dup
    //   4876: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   4879: ldc_w 1267
    //   4882: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4885: lload 17
    //   4887: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4890: ldc_w 1168
    //   4893: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4896: aload_0
    //   4897: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   4900: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4903: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4906: iconst_1
    //   4907: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4910: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   4913: ifnull +27 -> 4940
    //   4916: lload 17
    //   4918: l2d
    //   4919: aload_0
    //   4920: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   4923: l2d
    //   4924: ddiv
    //   4925: ldc2_w 1268
    //   4928: dmul
    //   4929: d2i
    //   4930: istore_3
    //   4931: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   4934: iload_3
    //   4935: invokeinterface 1272 2 0
    //   4940: lload 13
    //   4942: lstore 9
    //   4944: iload_1
    //   4945: ifne +116 -> 5061
    //   4948: lload 13
    //   4950: lstore 9
    //   4952: lload 17
    //   4954: lload 13
    //   4956: lsub
    //   4957: ldc2_w 1273
    //   4960: lcmp
    //   4961: ifle +100 -> 5061
    //   4964: aload_0
    //   4965: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4968: invokestatic 206	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4971: ifne +86 -> 5057
    //   4974: aload_0
    //   4975: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4978: invokestatic 763	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4981: iconst_3
    //   4982: if_icmpne +13 -> 4995
    //   4985: aload_0
    //   4986: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   4989: invokestatic 763	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4992: ifne +65 -> 5057
    //   4995: invokestatic 1161	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4998: ifne +59 -> 5057
    //   5001: aload_0
    //   5002: invokevirtual 1162	com/tencent/smtt/sdk/m:b	()V
    //   5005: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   5008: ifnull +13 -> 5021
    //   5011: getstatic 607	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   5014: bipush 111
    //   5016: invokeinterface 612 2 0
    //   5021: ldc_w 273
    //   5024: ldc_w 1276
    //   5027: iconst_0
    //   5028: invokestatic 1054	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   5031: aload_0
    //   5032: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5035: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5038: sipush -304
    //   5041: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5044: iconst_0
    //   5045: istore_3
    //   5046: lload 11
    //   5048: lstore 9
    //   5050: iload 4
    //   5052: istore 6
    //   5054: goto -1188 -> 3866
    //   5057: lload 17
    //   5059: lstore 9
    //   5061: lload 19
    //   5063: lstore 13
    //   5065: lload 13
    //   5067: lstore 15
    //   5069: lload 9
    //   5071: lstore 13
    //   5073: lload 11
    //   5075: lstore 9
    //   5077: lload 17
    //   5079: lstore 21
    //   5081: goto -1299 -> 3782
    //   5084: iload 6
    //   5086: istore 4
    //   5088: iload 4
    //   5090: istore 5
    //   5092: lload 9
    //   5094: lstore 11
    //   5096: lload 9
    //   5098: lstore 13
    //   5100: aload_0
    //   5101: aload 30
    //   5103: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5106: iload 4
    //   5108: istore 5
    //   5110: lload 9
    //   5112: lstore 11
    //   5114: lload 9
    //   5116: lstore 13
    //   5118: aload_0
    //   5119: aload 27
    //   5121: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5124: iload 4
    //   5126: istore 5
    //   5128: lload 9
    //   5130: lstore 11
    //   5132: lload 9
    //   5134: lstore 13
    //   5136: aload_0
    //   5137: aload 28
    //   5139: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5142: iload 4
    //   5144: istore 5
    //   5146: lload 9
    //   5148: lstore 11
    //   5150: lload 9
    //   5152: lstore 13
    //   5154: aload_0
    //   5155: getfield 734	com/tencent/smtt/sdk/m:u	Z
    //   5158: ifne +28 -> 5186
    //   5161: iload 4
    //   5163: istore 5
    //   5165: lload 9
    //   5167: lstore 11
    //   5169: lload 9
    //   5171: lstore 13
    //   5173: aload_0
    //   5174: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5177: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5180: sipush -319
    //   5183: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5186: iload 4
    //   5188: istore 5
    //   5190: iload_1
    //   5191: ifne -4567 -> 624
    //   5194: aload_0
    //   5195: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5198: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5201: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5204: ldc_w 1082
    //   5207: lload 9
    //   5209: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5212: invokeinterface 595 3 0
    //   5217: pop
    //   5218: aload_0
    //   5219: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5222: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5225: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5228: iload 4
    //   5230: istore 5
    //   5232: goto -4608 -> 624
    //   5235: iload_1
    //   5236: ifne +177 -> 5413
    //   5239: aload_0
    //   5240: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5243: invokestatic 1117	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   5246: ifne +167 -> 5413
    //   5249: aload_0
    //   5250: bipush 105
    //   5252: new 117	java/lang/StringBuilder
    //   5255: dup
    //   5256: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   5259: ldc_w 1254
    //   5262: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5265: invokestatic 1256	com/tencent/smtt/utils/q:a	()J
    //   5268: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5271: ldc_w 1258
    //   5274: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5277: aload_0
    //   5278: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5281: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5284: invokevirtual 1261	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   5287: invokevirtual 491	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5290: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5293: iconst_1
    //   5294: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5297: aload_0
    //   5298: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5301: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5304: sipush -308
    //   5307: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5310: lload 9
    //   5312: lstore 15
    //   5314: iload 6
    //   5316: istore 5
    //   5318: lload 9
    //   5320: lstore 13
    //   5322: aload_0
    //   5323: aload 30
    //   5325: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5328: lload 9
    //   5330: lstore 15
    //   5332: iload 6
    //   5334: istore 5
    //   5336: lload 9
    //   5338: lstore 13
    //   5340: aload_0
    //   5341: aload 29
    //   5343: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5346: lload 9
    //   5348: lstore 15
    //   5350: iload 6
    //   5352: istore 5
    //   5354: lload 9
    //   5356: lstore 13
    //   5358: aload_0
    //   5359: aload 27
    //   5361: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5364: iload 6
    //   5366: istore 5
    //   5368: iload_1
    //   5369: ifne -4745 -> 624
    //   5372: aload_0
    //   5373: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5376: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5379: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5382: ldc_w 1082
    //   5385: lload 9
    //   5387: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5390: invokeinterface 595 3 0
    //   5395: pop
    //   5396: aload_0
    //   5397: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5400: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5403: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5406: iload 6
    //   5408: istore 5
    //   5410: goto -4786 -> 624
    //   5413: aload_0
    //   5414: lconst_0
    //   5415: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   5418: aload_0
    //   5419: invokespecial 1278	com/tencent/smtt/sdk/m:k	()Z
    //   5422: ifne +127 -> 5549
    //   5425: aload_0
    //   5426: bipush 106
    //   5428: aload_0
    //   5429: aload 28
    //   5431: invokespecial 535	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5434: iconst_0
    //   5435: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5438: lload 9
    //   5440: lstore 15
    //   5442: iload 6
    //   5444: istore 5
    //   5446: lload 9
    //   5448: lstore 13
    //   5450: aload_0
    //   5451: aload 30
    //   5453: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5456: lload 9
    //   5458: lstore 15
    //   5460: iload 6
    //   5462: istore 5
    //   5464: lload 9
    //   5466: lstore 13
    //   5468: aload_0
    //   5469: aload 29
    //   5471: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5474: lload 9
    //   5476: lstore 15
    //   5478: iload 6
    //   5480: istore 5
    //   5482: lload 9
    //   5484: lstore 13
    //   5486: aload_0
    //   5487: aload 27
    //   5489: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5492: lload 9
    //   5494: lstore 11
    //   5496: iload 6
    //   5498: istore 4
    //   5500: iload_1
    //   5501: ifne -4892 -> 609
    //   5504: aload_0
    //   5505: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5508: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5511: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5514: ldc_w 1082
    //   5517: lload 9
    //   5519: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5522: invokeinterface 595 3 0
    //   5527: pop
    //   5528: aload_0
    //   5529: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5532: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5535: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5538: lload 9
    //   5540: lstore 11
    //   5542: iload 6
    //   5544: istore 4
    //   5546: goto -4937 -> 609
    //   5549: aload_0
    //   5550: bipush 104
    //   5552: aload_0
    //   5553: aload 28
    //   5555: invokespecial 535	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5558: iconst_0
    //   5559: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5562: goto -124 -> 5438
    //   5565: astore 31
    //   5567: aload 27
    //   5569: astore 28
    //   5571: aload 29
    //   5573: astore 27
    //   5575: iload 6
    //   5577: istore 4
    //   5579: aload 31
    //   5581: astore 29
    //   5583: iload 4
    //   5585: istore 5
    //   5587: lload 9
    //   5589: lstore 11
    //   5591: lload 9
    //   5593: lstore 13
    //   5595: aload_0
    //   5596: aload 30
    //   5598: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5601: iload 4
    //   5603: istore 5
    //   5605: lload 9
    //   5607: lstore 11
    //   5609: lload 9
    //   5611: lstore 13
    //   5613: aload_0
    //   5614: aload 27
    //   5616: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5619: iload 4
    //   5621: istore 5
    //   5623: lload 9
    //   5625: lstore 11
    //   5627: lload 9
    //   5629: lstore 13
    //   5631: aload_0
    //   5632: aload 28
    //   5634: invokespecial 847	com/tencent/smtt/sdk/m:a	(Ljava/io/Closeable;)V
    //   5637: iload 4
    //   5639: istore 5
    //   5641: lload 9
    //   5643: lstore 11
    //   5645: lload 9
    //   5647: lstore 13
    //   5649: aload 29
    //   5651: athrow
    //   5652: astore 27
    //   5654: lload 11
    //   5656: lstore 15
    //   5658: iload 5
    //   5660: istore 6
    //   5662: goto -2975 -> 2687
    //   5665: iload_3
    //   5666: sipush 300
    //   5669: if_icmplt +237 -> 5906
    //   5672: iload_3
    //   5673: sipush 307
    //   5676: if_icmpgt +230 -> 5906
    //   5679: lload 9
    //   5681: lstore 15
    //   5683: iload 4
    //   5685: istore 5
    //   5687: lload 9
    //   5689: lstore 13
    //   5691: aload_0
    //   5692: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   5695: ldc_w 1280
    //   5698: invokevirtual 1284	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5701: astore 27
    //   5703: lload 9
    //   5705: lstore 15
    //   5707: iload 4
    //   5709: istore 5
    //   5711: lload 9
    //   5713: lstore 13
    //   5715: aload 27
    //   5717: invokestatic 877	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5720: ifne +92 -> 5812
    //   5723: lload 9
    //   5725: lstore 15
    //   5727: iload 4
    //   5729: istore 5
    //   5731: lload 9
    //   5733: lstore 13
    //   5735: aload_0
    //   5736: aload 27
    //   5738: putfield 728	com/tencent/smtt/sdk/m:k	Ljava/lang/String;
    //   5741: lload 9
    //   5743: lstore 15
    //   5745: iload 4
    //   5747: istore 5
    //   5749: lload 9
    //   5751: lstore 13
    //   5753: aload_0
    //   5754: aload_0
    //   5755: getfield 722	com/tencent/smtt/sdk/m:s	I
    //   5758: iconst_1
    //   5759: iadd
    //   5760: putfield 722	com/tencent/smtt/sdk/m:s	I
    //   5763: lload 9
    //   5765: lstore 11
    //   5767: iload_1
    //   5768: ifne -5159 -> 609
    //   5771: aload_0
    //   5772: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5775: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5778: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5781: ldc_w 1082
    //   5784: lload 9
    //   5786: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5789: invokeinterface 595 3 0
    //   5794: pop
    //   5795: aload_0
    //   5796: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5799: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5802: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5805: lload 9
    //   5807: lstore 11
    //   5809: goto -5200 -> 609
    //   5812: lload 9
    //   5814: lstore 15
    //   5816: iload 4
    //   5818: istore 5
    //   5820: lload 9
    //   5822: lstore 13
    //   5824: aload_0
    //   5825: bipush 124
    //   5827: aconst_null
    //   5828: iconst_1
    //   5829: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5832: lload 9
    //   5834: lstore 15
    //   5836: iload 4
    //   5838: istore 5
    //   5840: lload 9
    //   5842: lstore 13
    //   5844: aload_0
    //   5845: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5848: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5851: sipush -312
    //   5854: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5857: iload 4
    //   5859: istore 5
    //   5861: iload_1
    //   5862: ifne -5238 -> 624
    //   5865: aload_0
    //   5866: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5869: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5872: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5875: ldc_w 1082
    //   5878: lload 9
    //   5880: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5883: invokeinterface 595 3 0
    //   5888: pop
    //   5889: aload_0
    //   5890: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5893: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5896: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5899: iload 4
    //   5901: istore 5
    //   5903: goto -5279 -> 624
    //   5906: lload 9
    //   5908: lstore 15
    //   5910: iload 4
    //   5912: istore 5
    //   5914: lload 9
    //   5916: lstore 13
    //   5918: aload_0
    //   5919: bipush 102
    //   5921: iload_3
    //   5922: invokestatic 1287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5925: iconst_0
    //   5926: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   5929: iload_3
    //   5930: sipush 416
    //   5933: if_icmpne +193 -> 6126
    //   5936: lload 9
    //   5938: lstore 15
    //   5940: iload 4
    //   5942: istore 5
    //   5944: lload 9
    //   5946: lstore 13
    //   5948: aload_0
    //   5949: iconst_1
    //   5950: iload 8
    //   5952: invokespecial 1029	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   5955: ifeq +79 -> 6034
    //   5958: iconst_1
    //   5959: istore 5
    //   5961: iconst_1
    //   5962: istore 4
    //   5964: lload 9
    //   5966: lstore 15
    //   5968: lload 9
    //   5970: lstore 13
    //   5972: aload_0
    //   5973: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5976: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5979: sipush -214
    //   5982: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5985: iload 4
    //   5987: istore 5
    //   5989: iload_1
    //   5990: ifne -5366 -> 624
    //   5993: aload_0
    //   5994: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   5997: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6000: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6003: ldc_w 1082
    //   6006: lload 9
    //   6008: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6011: invokeinterface 595 3 0
    //   6016: pop
    //   6017: aload_0
    //   6018: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6021: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6024: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6027: iload 4
    //   6029: istore 5
    //   6031: goto -5407 -> 624
    //   6034: lload 9
    //   6036: lstore 15
    //   6038: iload 4
    //   6040: istore 5
    //   6042: lload 9
    //   6044: lstore 13
    //   6046: aload_0
    //   6047: iconst_0
    //   6048: invokespecial 1031	com/tencent/smtt/sdk/m:e	(Z)Z
    //   6051: pop
    //   6052: lload 9
    //   6054: lstore 15
    //   6056: iload 4
    //   6058: istore 5
    //   6060: lload 9
    //   6062: lstore 13
    //   6064: aload_0
    //   6065: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6068: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6071: sipush -313
    //   6074: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6077: iload 4
    //   6079: istore 5
    //   6081: iload_1
    //   6082: ifne -5458 -> 624
    //   6085: aload_0
    //   6086: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6089: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6092: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6095: ldc_w 1082
    //   6098: lload 9
    //   6100: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6103: invokeinterface 595 3 0
    //   6108: pop
    //   6109: aload_0
    //   6110: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6113: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6116: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6119: iload 4
    //   6121: istore 5
    //   6123: goto -5499 -> 624
    //   6126: iload_3
    //   6127: sipush 403
    //   6130: if_icmpeq +10 -> 6140
    //   6133: iload_3
    //   6134: sipush 406
    //   6137: if_icmpne +100 -> 6237
    //   6140: lload 9
    //   6142: lstore 15
    //   6144: iload 4
    //   6146: istore 5
    //   6148: lload 9
    //   6150: lstore 13
    //   6152: aload_0
    //   6153: getfield 726	com/tencent/smtt/sdk/m:n	J
    //   6156: ldc2_w 723
    //   6159: lcmp
    //   6160: ifne +77 -> 6237
    //   6163: lload 9
    //   6165: lstore 15
    //   6167: iload 4
    //   6169: istore 5
    //   6171: lload 9
    //   6173: lstore 13
    //   6175: aload_0
    //   6176: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6179: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6182: sipush -314
    //   6185: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6188: iload 4
    //   6190: istore 5
    //   6192: iload_1
    //   6193: ifne -5569 -> 624
    //   6196: aload_0
    //   6197: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6200: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6203: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6206: ldc_w 1082
    //   6209: lload 9
    //   6211: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6214: invokeinterface 595 3 0
    //   6219: pop
    //   6220: aload_0
    //   6221: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6224: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6227: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6230: iload 4
    //   6232: istore 5
    //   6234: goto -5610 -> 624
    //   6237: iload_3
    //   6238: sipush 202
    //   6241: if_icmpne +52 -> 6293
    //   6244: lload 9
    //   6246: lstore 11
    //   6248: iload_1
    //   6249: ifne -5640 -> 609
    //   6252: aload_0
    //   6253: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6256: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6259: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6262: ldc_w 1082
    //   6265: lload 9
    //   6267: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6270: invokeinterface 595 3 0
    //   6275: pop
    //   6276: aload_0
    //   6277: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6280: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6283: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6286: lload 9
    //   6288: lstore 11
    //   6290: goto -5681 -> 609
    //   6293: lload 9
    //   6295: lstore 15
    //   6297: iload 4
    //   6299: istore 5
    //   6301: lload 9
    //   6303: lstore 13
    //   6305: aload_0
    //   6306: getfield 257	com/tencent/smtt/sdk/m:r	I
    //   6309: aload_0
    //   6310: getfield 86	com/tencent/smtt/sdk/m:D	I
    //   6313: if_icmpge +181 -> 6494
    //   6316: iload_3
    //   6317: sipush 503
    //   6320: if_icmpne +174 -> 6494
    //   6323: lload 9
    //   6325: lstore 15
    //   6327: iload 4
    //   6329: istore 5
    //   6331: lload 9
    //   6333: lstore 13
    //   6335: aload_0
    //   6336: aload_0
    //   6337: getfield 392	com/tencent/smtt/sdk/m:v	Ljava/net/HttpURLConnection;
    //   6340: ldc_w 1289
    //   6343: invokevirtual 1284	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   6346: invokestatic 1293	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   6349: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   6352: lload 9
    //   6354: lstore 15
    //   6356: iload 4
    //   6358: istore 5
    //   6360: lload 9
    //   6362: lstore 13
    //   6364: aload_0
    //   6365: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   6368: ifeq +77 -> 6445
    //   6371: lload 9
    //   6373: lstore 15
    //   6375: iload 4
    //   6377: istore 5
    //   6379: lload 9
    //   6381: lstore 13
    //   6383: aload_0
    //   6384: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6387: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6390: sipush -309
    //   6393: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6396: iload 4
    //   6398: istore 5
    //   6400: iload_1
    //   6401: ifne -5777 -> 624
    //   6404: aload_0
    //   6405: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6408: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6411: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6414: ldc_w 1082
    //   6417: lload 9
    //   6419: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6422: invokeinterface 595 3 0
    //   6427: pop
    //   6428: aload_0
    //   6429: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6432: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6435: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6438: iload 4
    //   6440: istore 5
    //   6442: goto -5818 -> 624
    //   6445: lload 9
    //   6447: lstore 11
    //   6449: iload_1
    //   6450: ifne -5841 -> 609
    //   6453: aload_0
    //   6454: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6457: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6460: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6463: ldc_w 1082
    //   6466: lload 9
    //   6468: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6471: invokeinterface 595 3 0
    //   6476: pop
    //   6477: aload_0
    //   6478: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6481: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6484: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6487: lload 9
    //   6489: lstore 11
    //   6491: goto -5882 -> 609
    //   6494: lload 9
    //   6496: lstore 15
    //   6498: iload 4
    //   6500: istore 5
    //   6502: lload 9
    //   6504: lstore 13
    //   6506: aload_0
    //   6507: getfield 257	com/tencent/smtt/sdk/m:r	I
    //   6510: aload_0
    //   6511: getfield 86	com/tencent/smtt/sdk/m:D	I
    //   6514: if_icmpge +190 -> 6704
    //   6517: iload_3
    //   6518: sipush 408
    //   6521: if_icmpeq +24 -> 6545
    //   6524: iload_3
    //   6525: sipush 504
    //   6528: if_icmpeq +17 -> 6545
    //   6531: iload_3
    //   6532: sipush 502
    //   6535: if_icmpeq +10 -> 6545
    //   6538: iload_3
    //   6539: sipush 408
    //   6542: if_icmpne +162 -> 6704
    //   6545: lload 9
    //   6547: lstore 15
    //   6549: iload 4
    //   6551: istore 5
    //   6553: lload 9
    //   6555: lstore 13
    //   6557: aload_0
    //   6558: lconst_0
    //   6559: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   6562: lload 9
    //   6564: lstore 15
    //   6566: iload 4
    //   6568: istore 5
    //   6570: lload 9
    //   6572: lstore 13
    //   6574: aload_0
    //   6575: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   6578: ifeq +77 -> 6655
    //   6581: lload 9
    //   6583: lstore 15
    //   6585: iload 4
    //   6587: istore 5
    //   6589: lload 9
    //   6591: lstore 13
    //   6593: aload_0
    //   6594: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6597: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6600: sipush -309
    //   6603: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6606: iload 4
    //   6608: istore 5
    //   6610: iload_1
    //   6611: ifne -5987 -> 624
    //   6614: aload_0
    //   6615: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6618: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6621: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6624: ldc_w 1082
    //   6627: lload 9
    //   6629: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6632: invokeinterface 595 3 0
    //   6637: pop
    //   6638: aload_0
    //   6639: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6642: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6645: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6648: iload 4
    //   6650: istore 5
    //   6652: goto -6028 -> 624
    //   6655: lload 9
    //   6657: lstore 11
    //   6659: iload_1
    //   6660: ifne -6051 -> 609
    //   6663: aload_0
    //   6664: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6667: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6670: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6673: ldc_w 1082
    //   6676: lload 9
    //   6678: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6681: invokeinterface 595 3 0
    //   6686: pop
    //   6687: aload_0
    //   6688: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6691: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6694: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6697: lload 9
    //   6699: lstore 11
    //   6701: goto -6092 -> 609
    //   6704: lload 9
    //   6706: lstore 15
    //   6708: iload 4
    //   6710: istore 5
    //   6712: lload 9
    //   6714: lstore 13
    //   6716: aload_0
    //   6717: invokespecial 1135	com/tencent/smtt/sdk/m:l	()J
    //   6720: lconst_0
    //   6721: lcmp
    //   6722: ifgt +95 -> 6817
    //   6725: lload 9
    //   6727: lstore 15
    //   6729: iload 4
    //   6731: istore 5
    //   6733: lload 9
    //   6735: lstore 13
    //   6737: aload_0
    //   6738: getfield 730	com/tencent/smtt/sdk/m:q	Z
    //   6741: ifne +76 -> 6817
    //   6744: iload_3
    //   6745: sipush 410
    //   6748: if_icmpeq +69 -> 6817
    //   6751: lload 9
    //   6753: lstore 15
    //   6755: iload 4
    //   6757: istore 5
    //   6759: lload 9
    //   6761: lstore 13
    //   6763: aload_0
    //   6764: iconst_1
    //   6765: putfield 730	com/tencent/smtt/sdk/m:q	Z
    //   6768: lload 9
    //   6770: lstore 11
    //   6772: iload_1
    //   6773: ifne -6164 -> 609
    //   6776: aload_0
    //   6777: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6780: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6783: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6786: ldc_w 1082
    //   6789: lload 9
    //   6791: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6794: invokeinterface 595 3 0
    //   6799: pop
    //   6800: aload_0
    //   6801: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6804: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6807: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6810: lload 9
    //   6812: lstore 11
    //   6814: goto -6205 -> 609
    //   6817: lload 9
    //   6819: lstore 15
    //   6821: iload 4
    //   6823: istore 5
    //   6825: lload 9
    //   6827: lstore 13
    //   6829: aload_0
    //   6830: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6833: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6836: sipush -315
    //   6839: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6842: iload 4
    //   6844: istore 5
    //   6846: iload_1
    //   6847: ifne -6223 -> 624
    //   6850: aload_0
    //   6851: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6854: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6857: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6860: ldc_w 1082
    //   6863: lload 9
    //   6865: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6868: invokeinterface 595 3 0
    //   6873: pop
    //   6874: aload_0
    //   6875: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6878: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6881: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6884: iload 4
    //   6886: istore 5
    //   6888: goto -6264 -> 624
    //   6891: lload 15
    //   6893: lstore 13
    //   6895: aload 27
    //   6897: invokevirtual 848	java/lang/Throwable:printStackTrace	()V
    //   6900: lload 15
    //   6902: lstore 13
    //   6904: aload_0
    //   6905: lconst_0
    //   6906: invokespecial 1233	com/tencent/smtt/sdk/m:a	(J)V
    //   6909: lload 15
    //   6911: lstore 13
    //   6913: aload_0
    //   6914: bipush 107
    //   6916: aload_0
    //   6917: aload 27
    //   6919: invokespecial 535	com/tencent/smtt/sdk/m:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6922: iconst_0
    //   6923: invokespecial 537	com/tencent/smtt/sdk/m:a	(ILjava/lang/String;Z)V
    //   6926: lload 15
    //   6928: lstore 13
    //   6930: aload_0
    //   6931: getfield 732	com/tencent/smtt/sdk/m:t	Z
    //   6934: ifeq -4149 -> 2785
    //   6937: lload 15
    //   6939: lstore 13
    //   6941: aload_0
    //   6942: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6945: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6948: sipush -309
    //   6951: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6954: iload 6
    //   6956: istore 5
    //   6958: iload_1
    //   6959: ifne -6335 -> 624
    //   6962: aload_0
    //   6963: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6966: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6969: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6972: ldc_w 1082
    //   6975: lload 15
    //   6977: invokestatic 1116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6980: invokeinterface 595 3 0
    //   6985: pop
    //   6986: aload_0
    //   6987: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   6990: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6993: invokevirtual 602	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6996: iload 6
    //   6998: istore 5
    //   7000: goto -6376 -> 624
    //   7003: aload_0
    //   7004: iconst_1
    //   7005: iload 8
    //   7007: invokespecial 1029	com/tencent/smtt/sdk/m:c	(ZZ)Z
    //   7010: istore_1
    //   7011: goto -6290 -> 721
    //   7014: iconst_0
    //   7015: istore_3
    //   7016: goto -6283 -> 733
    //   7019: iconst_2
    //   7020: istore_3
    //   7021: goto -6242 -> 779
    //   7024: aload_0
    //   7025: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   7028: iconst_0
    //   7029: invokevirtual 1094	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   7032: goto -6247 -> 785
    //   7035: aload_0
    //   7036: getfield 98	com/tencent/smtt/sdk/m:h	Landroid/content/Context;
    //   7039: invokestatic 365	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   7042: sipush -318
    //   7045: invokevirtual 1019	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   7048: aload_0
    //   7049: iconst_0
    //   7050: invokespecial 1031	com/tencent/smtt/sdk/m:e	(Z)Z
    //   7053: pop
    //   7054: goto -6207 -> 847
    //   7057: aload 27
    //   7059: getfield 369	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   7062: ldc_w 1295
    //   7065: iconst_0
    //   7066: invokeinterface 377 3 0
    //   7071: istore_3
    //   7072: aload 27
    //   7074: getfield 582	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   7077: astore 28
    //   7079: iload_3
    //   7080: iconst_1
    //   7081: iadd
    //   7082: istore_3
    //   7083: aload 28
    //   7085: ldc_w 1295
    //   7088: iload_3
    //   7089: invokestatic 528	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7092: invokeinterface 595 3 0
    //   7097: pop
    //   7098: iload_3
    //   7099: aload 27
    //   7101: invokevirtual 1298	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   7104: if_icmpne -6209 -> 895
    //   7107: aload_0
    //   7108: getfield 110	com/tencent/smtt/sdk/m:x	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   7111: iconst_2
    //   7112: invokevirtual 1148	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   7115: goto -6220 -> 895
    //   7118: iconst_0
    //   7119: istore_3
    //   7120: goto -6208 -> 912
    //   7123: astore 27
    //   7125: goto -4157 -> 2968
    //   7128: astore 29
    //   7130: aconst_null
    //   7131: astore 27
    //   7133: aconst_null
    //   7134: astore 28
    //   7136: aconst_null
    //   7137: astore 30
    //   7139: goto -1556 -> 5583
    //   7142: astore 29
    //   7144: aconst_null
    //   7145: astore 27
    //   7147: aconst_null
    //   7148: astore 30
    //   7150: goto -1567 -> 5583
    //   7153: astore 29
    //   7155: aconst_null
    //   7156: astore 30
    //   7158: goto -1575 -> 5583
    //   7161: astore 29
    //   7163: goto -1580 -> 5583
    //   7166: astore 29
    //   7168: iload 6
    //   7170: istore 4
    //   7172: lload 17
    //   7174: lstore 9
    //   7176: goto -1593 -> 5583
    //   7179: astore 29
    //   7181: lload 11
    //   7183: lstore 9
    //   7185: goto -1602 -> 5583
    //   7188: astore 28
    //   7190: iload 4
    //   7192: istore 6
    //   7194: aload 31
    //   7196: astore 30
    //   7198: goto -3161 -> 4037
    //   7201: astore 29
    //   7203: aload 28
    //   7205: astore 31
    //   7207: iload 4
    //   7209: istore 6
    //   7211: aload 29
    //   7213: astore 28
    //   7215: aload 27
    //   7217: astore 29
    //   7219: aload 31
    //   7221: astore 27
    //   7223: goto -3186 -> 4037
    //   7226: astore 29
    //   7228: aload 28
    //   7230: astore 31
    //   7232: lload 19
    //   7234: lstore 9
    //   7236: aload 29
    //   7238: astore 28
    //   7240: iload 7
    //   7242: istore 6
    //   7244: aload 27
    //   7246: astore 29
    //   7248: aload 31
    //   7250: astore 27
    //   7252: goto -3215 -> 4037
    //   7255: astore 29
    //   7257: aload 28
    //   7259: astore 31
    //   7261: lload 11
    //   7263: lstore 9
    //   7265: iload 4
    //   7267: istore 6
    //   7269: aload 29
    //   7271: astore 28
    //   7273: aload 27
    //   7275: astore 29
    //   7277: aload 31
    //   7279: astore 27
    //   7281: goto -3244 -> 4037
    //   7284: lload 13
    //   7286: lstore 9
    //   7288: lload 15
    //   7290: lstore 13
    //   7292: goto -2227 -> 5065
    //   7295: aconst_null
    //   7296: astore 27
    //   7298: aconst_null
    //   7299: astore 30
    //   7301: goto -2213 -> 5088
    //   7304: lload 11
    //   7306: lstore 9
    //   7308: goto -6035 -> 1273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7311	0	this	m
    //   0	7311	1	paramBoolean1	boolean
    //   0	7311	2	paramBoolean2	boolean
    //   54	7066	3	i1	int
    //   603	6663	4	bool1	boolean
    //   460	6539	5	bool2	boolean
    //   2685	4583	6	bool3	boolean
    //   3792	3449	7	bool4	boolean
    //   71	6935	8	bool5	boolean
    //   481	6826	9	l1	long
    //   607	6698	11	l2	long
    //   1125	6166	13	l3	long
    //   1117	6172	15	l4	long
    //   3145	4028	17	l5	long
    //   3796	3437	19	l6	long
    //   3776	1304	21	l7	long
    //   1105	3739	23	l8	long
    //   457	4167	25	l9	long
    //   145	2367	27	localObject1	Object
    //   2681	261	27	localThrowable1	Throwable
    //   2966	41	27	localObject2	Object
    //   3565	2050	27	localObject3	Object
    //   5652	1	27	localThrowable2	Throwable
    //   5701	1399	27	str	String
    //   7123	1	27	localObject4	Object
    //   7131	166	27	localObject5	Object
    //   3598	3537	28	localObject6	Object
    //   7188	16	28	localIOException1	IOException
    //   7213	59	28	localIOException2	IOException
    //   3568	648	29	localObject7	Object
    //   4220	11	29	localIOException3	IOException
    //   4236	1414	29	localObject8	Object
    //   7128	1	29	localObject9	Object
    //   7142	1	29	localObject10	Object
    //   7153	1	29	localObject11	Object
    //   7161	1	29	localObject12	Object
    //   7166	1	29	localObject13	Object
    //   7179	1	29	localObject14	Object
    //   7201	11	29	localIOException4	IOException
    //   7217	1	29	localObject15	Object
    //   7226	11	29	localIOException5	IOException
    //   7246	1	29	localObject16	Object
    //   7255	15	29	localIOException6	IOException
    //   7275	1	29	localObject17	Object
    //   3702	3598	30	localObject18	Object
    //   3562	681	31	localObject19	Object
    //   5565	1630	31	localObject20	Object
    //   7205	73	31	localObject21	Object
    //   3646	1	32	arrayOfByte	byte[]
    //   4019	485	32	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   1127	1156	2681	java/lang/Throwable
    //   1168	1177	2681	java/lang/Throwable
    //   1189	1213	2681	java/lang/Throwable
    //   1225	1248	2681	java/lang/Throwable
    //   1260	1270	2681	java/lang/Throwable
    //   1423	1450	2681	java/lang/Throwable
    //   1470	1480	2681	java/lang/Throwable
    //   1492	1500	2681	java/lang/Throwable
    //   1512	1525	2681	java/lang/Throwable
    //   1586	1591	2681	java/lang/Throwable
    //   1603	1610	2681	java/lang/Throwable
    //   1622	1628	2681	java/lang/Throwable
    //   1640	1681	2681	java/lang/Throwable
    //   1693	1705	2681	java/lang/Throwable
    //   1717	1726	2681	java/lang/Throwable
    //   1738	1744	2681	java/lang/Throwable
    //   1756	1762	2681	java/lang/Throwable
    //   1777	1784	2681	java/lang/Throwable
    //   1796	1802	2681	java/lang/Throwable
    //   1814	1841	2681	java/lang/Throwable
    //   1853	1862	2681	java/lang/Throwable
    //   1874	1902	2681	java/lang/Throwable
    //   1914	1951	2681	java/lang/Throwable
    //   1963	1969	2681	java/lang/Throwable
    //   1990	1996	2681	java/lang/Throwable
    //   2008	2016	2681	java/lang/Throwable
    //   2028	2037	2681	java/lang/Throwable
    //   2049	2056	2681	java/lang/Throwable
    //   2068	2076	2681	java/lang/Throwable
    //   2088	2094	2681	java/lang/Throwable
    //   2106	2111	2681	java/lang/Throwable
    //   2123	2131	2681	java/lang/Throwable
    //   2143	2157	2681	java/lang/Throwable
    //   2169	2177	2681	java/lang/Throwable
    //   2189	2215	2681	java/lang/Throwable
    //   2227	2235	2681	java/lang/Throwable
    //   2251	2261	2681	java/lang/Throwable
    //   2273	2284	2681	java/lang/Throwable
    //   2296	2306	2681	java/lang/Throwable
    //   2318	2324	2681	java/lang/Throwable
    //   2336	2340	2681	java/lang/Throwable
    //   2352	2358	2681	java/lang/Throwable
    //   2370	2380	2681	java/lang/Throwable
    //   2392	2402	2681	java/lang/Throwable
    //   2414	2421	2681	java/lang/Throwable
    //   2433	2446	2681	java/lang/Throwable
    //   2507	2513	2681	java/lang/Throwable
    //   2528	2569	2681	java/lang/Throwable
    //   2581	2622	2681	java/lang/Throwable
    //   2634	2678	2681	java/lang/Throwable
    //   2876	2884	2681	java/lang/Throwable
    //   2896	2908	2681	java/lang/Throwable
    //   2920	2928	2681	java/lang/Throwable
    //   2940	2946	2681	java/lang/Throwable
    //   2958	2963	2681	java/lang/Throwable
    //   3035	3050	2681	java/lang/Throwable
    //   3062	3091	2681	java/lang/Throwable
    //   3103	3114	2681	java/lang/Throwable
    //   3126	3147	2681	java/lang/Throwable
    //   3166	3176	2681	java/lang/Throwable
    //   3188	3229	2681	java/lang/Throwable
    //   3245	3252	2681	java/lang/Throwable
    //   3264	3270	2681	java/lang/Throwable
    //   3282	3292	2681	java/lang/Throwable
    //   3304	3311	2681	java/lang/Throwable
    //   3323	3330	2681	java/lang/Throwable
    //   3396	3437	2681	java/lang/Throwable
    //   3449	3462	2681	java/lang/Throwable
    //   3523	3533	2681	java/lang/Throwable
    //   3545	3558	2681	java/lang/Throwable
    //   3582	3591	2681	java/lang/Throwable
    //   3882	3888	2681	java/lang/Throwable
    //   3900	3906	2681	java/lang/Throwable
    //   3918	3924	2681	java/lang/Throwable
    //   4095	4101	2681	java/lang/Throwable
    //   4113	4119	2681	java/lang/Throwable
    //   4131	4137	2681	java/lang/Throwable
    //   5322	5328	2681	java/lang/Throwable
    //   5340	5346	2681	java/lang/Throwable
    //   5358	5364	2681	java/lang/Throwable
    //   5450	5456	2681	java/lang/Throwable
    //   5468	5474	2681	java/lang/Throwable
    //   5486	5492	2681	java/lang/Throwable
    //   5691	5703	2681	java/lang/Throwable
    //   5715	5723	2681	java/lang/Throwable
    //   5735	5741	2681	java/lang/Throwable
    //   5753	5763	2681	java/lang/Throwable
    //   5824	5832	2681	java/lang/Throwable
    //   5844	5857	2681	java/lang/Throwable
    //   5918	5929	2681	java/lang/Throwable
    //   5948	5958	2681	java/lang/Throwable
    //   5972	5985	2681	java/lang/Throwable
    //   6046	6052	2681	java/lang/Throwable
    //   6064	6077	2681	java/lang/Throwable
    //   6152	6163	2681	java/lang/Throwable
    //   6175	6188	2681	java/lang/Throwable
    //   6305	6316	2681	java/lang/Throwable
    //   6335	6352	2681	java/lang/Throwable
    //   6364	6371	2681	java/lang/Throwable
    //   6383	6396	2681	java/lang/Throwable
    //   6506	6517	2681	java/lang/Throwable
    //   6557	6562	2681	java/lang/Throwable
    //   6574	6581	2681	java/lang/Throwable
    //   6593	6606	2681	java/lang/Throwable
    //   6716	6725	2681	java/lang/Throwable
    //   6737	6744	2681	java/lang/Throwable
    //   6763	6768	2681	java/lang/Throwable
    //   6829	6842	2681	java/lang/Throwable
    //   1127	1156	2966	finally
    //   1168	1177	2966	finally
    //   1189	1213	2966	finally
    //   1225	1248	2966	finally
    //   1260	1270	2966	finally
    //   1423	1450	2966	finally
    //   1470	1480	2966	finally
    //   1492	1500	2966	finally
    //   1512	1525	2966	finally
    //   1586	1591	2966	finally
    //   1603	1610	2966	finally
    //   1622	1628	2966	finally
    //   1640	1681	2966	finally
    //   1693	1705	2966	finally
    //   1717	1726	2966	finally
    //   1738	1744	2966	finally
    //   1756	1762	2966	finally
    //   1777	1784	2966	finally
    //   1796	1802	2966	finally
    //   1814	1841	2966	finally
    //   1853	1862	2966	finally
    //   1874	1902	2966	finally
    //   1914	1951	2966	finally
    //   1963	1969	2966	finally
    //   1990	1996	2966	finally
    //   2008	2016	2966	finally
    //   2028	2037	2966	finally
    //   2049	2056	2966	finally
    //   2068	2076	2966	finally
    //   2088	2094	2966	finally
    //   2106	2111	2966	finally
    //   2123	2131	2966	finally
    //   2143	2157	2966	finally
    //   2169	2177	2966	finally
    //   2189	2215	2966	finally
    //   2227	2235	2966	finally
    //   2251	2261	2966	finally
    //   2273	2284	2966	finally
    //   2296	2306	2966	finally
    //   2318	2324	2966	finally
    //   2336	2340	2966	finally
    //   2352	2358	2966	finally
    //   2370	2380	2966	finally
    //   2392	2402	2966	finally
    //   2414	2421	2966	finally
    //   2433	2446	2966	finally
    //   2507	2513	2966	finally
    //   2528	2569	2966	finally
    //   2581	2622	2966	finally
    //   2634	2678	2966	finally
    //   2691	2699	2966	finally
    //   2707	2714	2966	finally
    //   2718	2726	2966	finally
    //   2730	2773	2966	finally
    //   2777	2785	2966	finally
    //   2789	2802	2966	finally
    //   2876	2884	2966	finally
    //   2896	2908	2966	finally
    //   2920	2928	2966	finally
    //   2940	2946	2966	finally
    //   2958	2963	2966	finally
    //   3035	3050	2966	finally
    //   3062	3091	2966	finally
    //   3103	3114	2966	finally
    //   3126	3147	2966	finally
    //   3166	3176	2966	finally
    //   3188	3229	2966	finally
    //   3245	3252	2966	finally
    //   3264	3270	2966	finally
    //   3282	3292	2966	finally
    //   3304	3311	2966	finally
    //   3323	3330	2966	finally
    //   3396	3437	2966	finally
    //   3449	3462	2966	finally
    //   3523	3533	2966	finally
    //   3545	3558	2966	finally
    //   3582	3591	2966	finally
    //   3882	3888	2966	finally
    //   3900	3906	2966	finally
    //   3918	3924	2966	finally
    //   4095	4101	2966	finally
    //   4113	4119	2966	finally
    //   4131	4137	2966	finally
    //   5322	5328	2966	finally
    //   5340	5346	2966	finally
    //   5358	5364	2966	finally
    //   5450	5456	2966	finally
    //   5468	5474	2966	finally
    //   5486	5492	2966	finally
    //   5691	5703	2966	finally
    //   5715	5723	2966	finally
    //   5735	5741	2966	finally
    //   5753	5763	2966	finally
    //   5824	5832	2966	finally
    //   5844	5857	2966	finally
    //   5918	5929	2966	finally
    //   5948	5958	2966	finally
    //   5972	5985	2966	finally
    //   6046	6052	2966	finally
    //   6064	6077	2966	finally
    //   6152	6163	2966	finally
    //   6175	6188	2966	finally
    //   6305	6316	2966	finally
    //   6335	6352	2966	finally
    //   6364	6371	2966	finally
    //   6383	6396	2966	finally
    //   6506	6517	2966	finally
    //   6557	6562	2966	finally
    //   6574	6581	2966	finally
    //   6593	6606	2966	finally
    //   6716	6725	2966	finally
    //   6737	6744	2966	finally
    //   6763	6768	2966	finally
    //   6829	6842	2966	finally
    //   6895	6900	2966	finally
    //   6904	6909	2966	finally
    //   6913	6926	2966	finally
    //   6930	6937	2966	finally
    //   6941	6954	2966	finally
    //   3605	3614	4019	java/io/IOException
    //   3619	3641	4019	java/io/IOException
    //   3986	4016	4019	java/io/IOException
    //   3641	3648	4220	java/io/IOException
    //   3652	3704	4220	java/io/IOException
    //   3708	3722	4220	java/io/IOException
    //   3726	3769	4220	java/io/IOException
    //   4201	4217	4220	java/io/IOException
    //   4037	4058	5565	finally
    //   4058	4083	5565	finally
    //   5239	5310	5565	finally
    //   5413	5438	5565	finally
    //   5549	5562	5565	finally
    //   1285	1295	5652	java/lang/Throwable
    //   1307	1317	5652	java/lang/Throwable
    //   1329	1337	5652	java/lang/Throwable
    //   1349	1362	5652	java/lang/Throwable
    //   5100	5106	5652	java/lang/Throwable
    //   5118	5124	5652	java/lang/Throwable
    //   5136	5142	5652	java/lang/Throwable
    //   5154	5161	5652	java/lang/Throwable
    //   5173	5186	5652	java/lang/Throwable
    //   5595	5601	5652	java/lang/Throwable
    //   5613	5619	5652	java/lang/Throwable
    //   5631	5637	5652	java/lang/Throwable
    //   5649	5652	5652	java/lang/Throwable
    //   1285	1295	7123	finally
    //   1307	1317	7123	finally
    //   1329	1337	7123	finally
    //   1349	1362	7123	finally
    //   5100	5106	7123	finally
    //   5118	5124	7123	finally
    //   5136	5142	7123	finally
    //   5154	5161	7123	finally
    //   5173	5186	7123	finally
    //   5595	5601	7123	finally
    //   5613	5619	7123	finally
    //   5631	5637	7123	finally
    //   5649	5652	7123	finally
    //   3591	3600	7128	finally
    //   3605	3614	7142	finally
    //   3619	3641	7142	finally
    //   3986	4016	7142	finally
    //   3641	3648	7153	finally
    //   3652	3704	7153	finally
    //   3708	3722	7153	finally
    //   3726	3769	7153	finally
    //   4201	4217	7153	finally
    //   3769	3774	7161	finally
    //   3798	3805	7166	finally
    //   3821	3831	7166	finally
    //   3847	3860	7166	finally
    //   4265	4277	7166	finally
    //   4297	4304	7166	finally
    //   4320	4330	7166	finally
    //   4350	4358	7166	finally
    //   4383	4388	7166	finally
    //   4412	4417	7166	finally
    //   4437	4444	7166	finally
    //   4463	4476	7166	finally
    //   4501	4510	7166	finally
    //   4526	4531	7166	finally
    //   4570	4580	7166	finally
    //   4596	4635	7166	finally
    //   4651	4664	7166	finally
    //   4693	4703	7166	finally
    //   4719	4729	7166	finally
    //   4745	4793	7166	finally
    //   4809	4822	7166	finally
    //   4835	4850	7179	finally
    //   4869	4940	7179	finally
    //   4964	4995	7179	finally
    //   4995	5021	7179	finally
    //   5021	5044	7179	finally
    //   3591	3600	7188	java/io/IOException
    //   3769	3774	7201	java/io/IOException
    //   3798	3805	7226	java/io/IOException
    //   3821	3831	7226	java/io/IOException
    //   3847	3860	7226	java/io/IOException
    //   4265	4277	7226	java/io/IOException
    //   4297	4304	7226	java/io/IOException
    //   4320	4330	7226	java/io/IOException
    //   4350	4358	7226	java/io/IOException
    //   4383	4388	7226	java/io/IOException
    //   4412	4417	7226	java/io/IOException
    //   4437	4444	7226	java/io/IOException
    //   4463	4476	7226	java/io/IOException
    //   4501	4510	7226	java/io/IOException
    //   4526	4531	7226	java/io/IOException
    //   4570	4580	7226	java/io/IOException
    //   4596	4635	7226	java/io/IOException
    //   4651	4664	7226	java/io/IOException
    //   4693	4703	7226	java/io/IOException
    //   4719	4729	7226	java/io/IOException
    //   4745	4793	7226	java/io/IOException
    //   4809	4822	7226	java/io/IOException
    //   4835	4850	7255	java/io/IOException
    //   4869	4940	7255	java/io/IOException
    //   4964	4995	7255	java/io/IOException
    //   4995	5021	7255	java/io/IOException
    //   5021	5044	7255	java/io/IOException
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!o()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.h)))) {}
    while ((this.b == null) || (this.c < 0) || (this.c >= this.b.length)) {
      return false;
    }
    String[] arrayOfString = this.b;
    int i1 = this.c;
    this.c = (i1 + 1);
    this.k = arrayOfString[i1];
    this.r = 0;
    this.s = 0;
    this.n = -1L;
    this.q = false;
    this.t = false;
    this.u = false;
    this.A = false;
    return true;
  }
  
  public int c(boolean paramBoolean)
  {
    File localFile = c(this.h);
    if (paramBoolean) {
      if (localFile != null) {}
    }
    while (localFile == null)
    {
      return 0;
      return a.a(this.h, new File(localFile, TbsDownloader.getBackupFileName(true)));
    }
    Context localContext = this.h;
    if (TbsDownloader.getOverSea(this.h)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false)) {
      return a.a(localContext, new File(localFile, str));
    }
  }
  
  public void c()
  {
    b();
    e(false);
    e(true);
  }
  
  public boolean d()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.E);
    return this.E;
  }
  
  void e()
  {
    TbsLog.i("TbsDownload", "pauseDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
    if ((!this.d) && (TbsDownloader.isDownloading()))
    {
      b();
      this.d = true;
      this.A = false;
    }
  }
  
  void f()
  {
    TbsLog.i("TbsDownload", "resumeDownload,isPause=" + this.d + "isDownloading=" + TbsDownloader.isDownloading());
    if ((this.d) && (TbsDownloader.isDownloading()))
    {
      this.d = false;
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */