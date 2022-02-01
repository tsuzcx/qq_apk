package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class p
{
  public static ThreadLocal<Integer> a;
  static boolean b = false;
  static final FileFilter c = new FileFilter()
  {
    public boolean accept(File paramAnonymousFile)
    {
      paramAnonymousFile = paramAnonymousFile.getName();
      if (paramAnonymousFile == null) {}
      while ((paramAnonymousFile.endsWith(".jar_is_first_load_dex_flag_file")) || ((Build.VERSION.SDK_INT >= 21) && (paramAnonymousFile.endsWith(".dex"))) || ((Build.VERSION.SDK_INT >= 26) && (paramAnonymousFile.endsWith(".prof"))) || ((Build.VERSION.SDK_INT >= 26) && (paramAnonymousFile.equals("oat")))) {
        return false;
      }
      return true;
    }
  };
  private static p d = null;
  private static final ReentrantLock i = new ReentrantLock();
  private static final Lock j = new ReentrantLock();
  private static FileLock l = null;
  private static Handler m;
  private static final Long[][] n;
  private static int o = 0;
  private static boolean p = false;
  private int e = 0;
  private FileLock f;
  private FileOutputStream g;
  private boolean h = false;
  private boolean k = false;
  
  static
  {
    a = new ThreadLocal()
    {
      public Integer a()
      {
        return Integer.valueOf(0);
      }
    };
    m = null;
    Long[] arrayOfLong1 = { Long.valueOf(44005L), Long.valueOf(39094008L) };
    Long[] arrayOfLong2 = { Long.valueOf(44027L), Long.valueOf(39094008L) };
    Long[] arrayOfLong3 = { Long.valueOf(44028L), Long.valueOf(39094008L) };
    Long[] arrayOfLong4 = { Long.valueOf(44029L), Long.valueOf(39094008L) };
    Long[] arrayOfLong5 = { Long.valueOf(44032L), Long.valueOf(39094008L) };
    Long[] arrayOfLong6 = { Long.valueOf(44033L), Long.valueOf(39094008L) };
    Long[] arrayOfLong7 = { Long.valueOf(44034L), Long.valueOf(39094008L) };
    Long[] arrayOfLong8 = { Long.valueOf(43909L), Long.valueOf(38917816L) };
    n = new Long[][] { { Long.valueOf(44006L), Long.valueOf(39094008L) }, arrayOfLong1, { Long.valueOf(43910L), Long.valueOf(38917816L) }, arrayOfLong2, arrayOfLong3, arrayOfLong4, { Long.valueOf(44030L), Long.valueOf(39094008L) }, arrayOfLong5, arrayOfLong6, arrayOfLong7, arrayOfLong8 };
  }
  
  private p()
  {
    if (m == null) {
      m = new Handler(o.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          QbSdk.setTBSInstallingStatus(true);
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          case 1: 
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            p.a(p.this, (Context)paramAnonymousMessage[0], (String)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            return;
          case 2: 
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            p.a(p.this, (Context)paramAnonymousMessage[0], (Context)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            return;
          case 3: 
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            p.this.b((Context)paramAnonymousMessage[0], (Bundle)paramAnonymousMessage[1]);
            return;
          }
          TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
          Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
          p.this.b((Context)arrayOfObject[0], (File)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
          QbSdk.setTBSInstallingStatus(false);
          super.handleMessage(paramAnonymousMessage);
        }
      };
    }
  }
  
  private void A(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    for (;;)
    {
      try
      {
        B(paramContext);
        D(paramContext);
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
        n.a(paramContext).a(0, 3);
        n.a(paramContext).a("tpatch_num", 0);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().i(paramContext)) || (i1 != a().j(paramContext))) {
            continue;
          }
          o(paramContext);
        }
      }
      catch (Exception localException)
      {
        int i1;
        localException.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from copy:" + localException.toString());
        continue;
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().i(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().j(paramContext));
        continue;
      }
      a.set(Integer.valueOf(0));
      h(paramContext);
      return;
      TbsShareManager.a(paramContext);
    }
  }
  
  private void B(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    FileUtil.a(r(paramContext), false);
  }
  
  private void C(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile1 = f(paramContext, 0);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + localFile1 + "tbsSharePath=" + localFile2);
      return;
    }
    boolean bool = localFile1.renameTo(localFile2);
    TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=" + bool);
    q.a("8is" + bool);
    if ((paramContext != null) && ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)))
    {
      if (!bool) {
        break label170;
      }
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(230, " ");
    }
    for (;;)
    {
      g(paramContext, false);
      return;
      label170:
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(231, " ");
    }
  }
  
  private void D(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null)) {
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
  }
  
  private void E(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null)) {
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
  }
  
  private void F(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = f(paramContext, 0);
    if (localFile != null) {
      FileUtil.a(localFile, false);
    }
    n.a(paramContext).c(0, 5);
    n.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
  }
  
  /* Error */
  static p a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 52	com/tencent/smtt/sdk/p:d	Lcom/tencent/smtt/sdk/p;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 52	com/tencent/smtt/sdk/p:d	Lcom/tencent/smtt/sdk/p;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/smtt/sdk/p
    //   21: dup
    //   22: invokespecial 352	com/tencent/smtt/sdk/p:<init>	()V
    //   25: putstatic 52	com/tencent/smtt/sdk/p:d	Lcom/tencent/smtt/sdk/p;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 52	com/tencent/smtt/sdk/p:d	Lcom/tencent/smtt/sdk/p;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localp	p
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  /* Error */
  private void a(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 286	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 363	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 139
    //   20: new 235	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 365
    //   30: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 367
    //   40: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: iconst_1
    //   47: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   50: new 286	java/io/File
    //   53: dup
    //   54: aload_3
    //   55: invokestatic 373	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   58: ldc_w 375
    //   61: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +113 -> 179
    //   69: aload_2
    //   70: invokevirtual 381	java/io/File:canRead	()Z
    //   73: ifeq +106 -> 179
    //   76: new 286	java/io/File
    //   79: dup
    //   80: aload_2
    //   81: ldc_w 383
    //   84: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   87: astore_2
    //   88: new 385	java/util/Properties
    //   91: dup
    //   92: invokespecial 386	java/util/Properties:<init>	()V
    //   95: astore 6
    //   97: new 388	java/io/BufferedInputStream
    //   100: dup
    //   101: new 390	java/io/FileInputStream
    //   104: dup
    //   105: aload_2
    //   106: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   112: astore_3
    //   113: aload 6
    //   115: aload_3
    //   116: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   119: new 401	java/io/BufferedOutputStream
    //   122: dup
    //   123: new 403	java/io/FileOutputStream
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 404	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   131: invokespecial 407	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   134: astore_2
    //   135: aload 6
    //   137: ldc_w 409
    //   140: ldc_w 411
    //   143: invokevirtual 415	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   146: pop
    //   147: aload 6
    //   149: aload_2
    //   150: aconst_null
    //   151: invokevirtual 419	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   154: ldc 139
    //   156: ldc_w 421
    //   159: iconst_1
    //   160: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 424	java/io/BufferedOutputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   179: return
    //   180: astore_2
    //   181: aload_2
    //   182: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   185: goto -14 -> 171
    //   188: astore_2
    //   189: aload_2
    //   190: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   193: return
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_2
    //   198: aload 5
    //   200: astore_3
    //   201: aload 4
    //   203: invokevirtual 427	java/lang/Throwable:printStackTrace	()V
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 424	java/io/BufferedOutputStream:close	()V
    //   214: aload_3
    //   215: ifnull -36 -> 179
    //   218: aload_3
    //   219: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   222: return
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   228: return
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   234: goto -20 -> 214
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 424	java/io/BufferedOutputStream:close	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore 4
    //   262: aload 4
    //   264: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   267: goto -17 -> 250
    //   270: astore_3
    //   271: aload_3
    //   272: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   275: goto -17 -> 258
    //   278: astore_2
    //   279: goto -39 -> 240
    //   282: astore 5
    //   284: aload_2
    //   285: astore 4
    //   287: aload 5
    //   289: astore_2
    //   290: goto -50 -> 240
    //   293: astore 5
    //   295: aload_2
    //   296: astore 4
    //   298: aload 5
    //   300: astore_2
    //   301: goto -61 -> 240
    //   304: astore 4
    //   306: aconst_null
    //   307: astore_2
    //   308: goto -107 -> 201
    //   311: astore 4
    //   313: goto -112 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	p
    //   0	316	1	paramInt	int
    //   0	316	2	paramString	String
    //   0	316	3	paramContext	Context
    //   1	1	4	localObject1	Object
    //   194	52	4	localThrowable1	Throwable
    //   260	3	4	localIOException	java.io.IOException
    //   285	12	4	str	String
    //   304	1	4	localThrowable2	Throwable
    //   311	1	4	localThrowable3	Throwable
    //   4	195	5	localObject2	Object
    //   282	6	5	localObject3	Object
    //   293	6	5	localObject4	Object
    //   95	53	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   167	171	180	java/io/IOException
    //   175	179	188	java/io/IOException
    //   97	113	194	java/lang/Throwable
    //   218	222	223	java/io/IOException
    //   210	214	229	java/io/IOException
    //   97	113	237	finally
    //   245	250	260	java/io/IOException
    //   254	258	270	java/io/IOException
    //   113	135	278	finally
    //   135	163	282	finally
    //   201	206	293	finally
    //   113	135	304	java/lang/Throwable
    //   135	163	311	java/lang/Throwable
  }
  
  public static void a(Context paramContext)
  {
    if (!w(paramContext))
    {
      if (!a(paramContext, "core_unzip_tmp")) {
        break label46;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
      TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
    }
    label46:
    do
    {
      return;
      if (a(paramContext, "core_share_backup_tmp"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        return;
      }
    } while (!a(paramContext, "core_copy_tmp"));
    TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
    TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4: sipush -524
    //   7: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 469	com/tencent/smtt/sdk/p:d	(Landroid/content/Context;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: ldc 139
    //   21: new 235	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 471
    //   31: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_3
    //   35: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: getstatic 476	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 11
    //   49: if_icmplt +70 -> 119
    //   52: aload_2
    //   53: ldc_w 478
    //   56: iconst_4
    //   57: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   60: astore 13
    //   62: aload 13
    //   64: ldc_w 484
    //   67: iconst_m1
    //   68: invokeinterface 201 3 0
    //   73: iload_3
    //   74: if_icmpne +58 -> 132
    //   77: ldc 139
    //   79: new 235	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 486
    //   89: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_3
    //   93: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc_w 488
    //   99: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   112: sipush -525
    //   115: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   118: return
    //   119: aload_2
    //   120: ldc_w 478
    //   123: iconst_0
    //   124: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   127: astore 13
    //   129: goto -67 -> 62
    //   132: aload_0
    //   133: aload_2
    //   134: invokevirtual 491	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   137: ifne +14 -> 151
    //   140: aload_1
    //   141: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   144: sipush -526
    //   147: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   150: return
    //   151: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   154: invokeinterface 496 1 0
    //   159: istore 8
    //   161: ldc 139
    //   163: new 235	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 498
    //   173: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload 8
    //   178: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iload 8
    //   189: ifeq +1756 -> 1945
    //   192: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   195: invokevirtual 501	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   198: aconst_null
    //   199: astore 14
    //   201: aload_2
    //   202: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   205: ldc_w 503
    //   208: invokevirtual 506	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   211: istore 4
    //   213: aload_2
    //   214: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   217: ldc_w 508
    //   220: invokevirtual 510	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   223: istore 5
    //   225: iload 4
    //   227: iload_3
    //   228: if_icmpne +43 -> 271
    //   231: getstatic 513	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   234: sipush 220
    //   237: invokeinterface 518 2 0
    //   242: aload_1
    //   243: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   246: sipush -528
    //   249: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   252: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   255: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   258: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   261: invokeinterface 522 1 0
    //   266: aload_0
    //   267: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   270: return
    //   271: aload_0
    //   272: aload_2
    //   273: invokevirtual 208	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;)I
    //   276: istore 6
    //   278: ldc 139
    //   280: new 235	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 526
    //   290: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: iload 6
    //   295: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: iload 6
    //   306: iload_3
    //   307: if_icmpne +69 -> 376
    //   310: getstatic 513	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   313: sipush 220
    //   316: invokeinterface 518 2 0
    //   321: aload_1
    //   322: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   325: sipush -528
    //   328: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   331: ldc 139
    //   333: new 235	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 528
    //   343: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload 6
    //   348: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   360: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   363: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   366: invokeinterface 522 1 0
    //   371: aload_0
    //   372: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   375: return
    //   376: aload_2
    //   377: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   380: invokevirtual 531	com/tencent/smtt/sdk/n:b	()I
    //   383: istore 7
    //   385: iload 7
    //   387: ifle +1615 -> 2002
    //   390: iload_3
    //   391: iload 7
    //   393: if_icmpgt +6 -> 399
    //   396: goto +1606 -> 2002
    //   399: aload_0
    //   400: aload_2
    //   401: invokevirtual 533	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)V
    //   404: goto +1612 -> 2016
    //   407: aload_0
    //   408: aload_2
    //   409: invokevirtual 533	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)V
    //   412: ldc 139
    //   414: ldc_w 535
    //   417: iconst_1
    //   418: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   421: iconst_m1
    //   422: istore 4
    //   424: aload_2
    //   425: invokestatic 537	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   428: ifne +88 -> 516
    //   431: invokestatic 540	com/tencent/smtt/utils/q:a	()J
    //   434: lstore 9
    //   436: aload_2
    //   437: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   440: invokevirtual 543	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   443: lstore 11
    //   445: aload_1
    //   446: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   449: sipush -529
    //   452: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   455: aload_2
    //   456: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   459: sipush 210
    //   462: new 235	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 545
    //   472: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: lload 9
    //   477: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: ldc_w 550
    //   483: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: lload 11
    //   488: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   491: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   497: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   500: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   503: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   506: invokeinterface 522 1 0
    //   511: aload_0
    //   512: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   515: return
    //   516: iload 4
    //   518: ifle +26 -> 544
    //   521: aload_2
    //   522: invokestatic 163	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   525: ifne +84 -> 609
    //   528: aload_2
    //   529: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   532: ifeq +77 -> 609
    //   535: iload_3
    //   536: aload_0
    //   537: aload_2
    //   538: invokevirtual 206	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   541: if_icmpeq +68 -> 609
    //   544: iload 4
    //   546: ifne +125 -> 671
    //   549: aload_2
    //   550: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   553: ldc_w 556
    //   556: invokevirtual 506	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   559: istore 4
    //   561: iload 4
    //   563: iconst_2
    //   564: if_icmple +93 -> 657
    //   567: aload_2
    //   568: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   571: sipush 211
    //   574: ldc_w 558
    //   577: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   580: aload_1
    //   581: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   584: sipush -530
    //   587: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   590: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   593: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   596: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   599: invokeinterface 522 1 0
    //   604: aload_0
    //   605: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   608: return
    //   609: ldc 139
    //   611: new 235	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 560
    //   621: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_0
    //   625: aload_2
    //   626: invokevirtual 206	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   629: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   641: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   644: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   647: invokeinterface 522 1 0
    //   652: aload_0
    //   653: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   656: return
    //   657: aload_2
    //   658: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   661: ldc_w 556
    //   664: iload 4
    //   666: iconst_1
    //   667: iadd
    //   668: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   671: aload_0
    //   672: aload_1
    //   673: invokevirtual 266	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   676: astore 15
    //   678: aload_2
    //   679: invokestatic 163	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   682: ifne +207 -> 889
    //   685: aload_2
    //   686: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   689: ifeq +189 -> 878
    //   692: aload_0
    //   693: aload_2
    //   694: invokevirtual 563	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   697: astore 13
    //   699: aload 15
    //   701: ifnull +1140 -> 1841
    //   704: aload 13
    //   706: ifnull +1135 -> 1841
    //   709: aload_2
    //   710: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   713: iload_3
    //   714: iconst_0
    //   715: invokevirtual 178	com/tencent/smtt/sdk/n:a	(II)V
    //   718: new 565	com/tencent/smtt/utils/p
    //   721: dup
    //   722: invokespecial 566	com/tencent/smtt/utils/p:<init>	()V
    //   725: astore 14
    //   727: aload 14
    //   729: aload 15
    //   731: invokevirtual 568	com/tencent/smtt/utils/p:a	(Ljava/io/File;)V
    //   734: invokestatic 573	java/lang/System:currentTimeMillis	()J
    //   737: lstore 9
    //   739: aload_1
    //   740: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   743: sipush -551
    //   746: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   749: aload 15
    //   751: aload 13
    //   753: getstatic 109	com/tencent/smtt/sdk/p:c	Ljava/io/FileFilter;
    //   756: invokestatic 576	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   759: istore 8
    //   761: aload_2
    //   762: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   765: ifeq +7 -> 772
    //   768: aload_2
    //   769: invokestatic 578	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   772: ldc 139
    //   774: new 235	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   781: ldc_w 580
    //   784: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokestatic 573	java/lang/System:currentTimeMillis	()J
    //   790: lload 9
    //   792: lsub
    //   793: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   796: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: iload 8
    //   804: ifeq +988 -> 1792
    //   807: aload 14
    //   809: aload 15
    //   811: invokevirtual 582	com/tencent/smtt/utils/p:b	(Ljava/io/File;)V
    //   814: aload 14
    //   816: invokevirtual 584	com/tencent/smtt/utils/p:a	()Z
    //   819: ifne +81 -> 900
    //   822: ldc 139
    //   824: ldc_w 586
    //   827: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 13
    //   832: iconst_1
    //   833: invokestatic 271	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   836: aload_2
    //   837: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   840: sipush 213
    //   843: ldc_w 588
    //   846: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   849: aload_1
    //   850: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   853: sipush -531
    //   856: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   859: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   862: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   865: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   868: invokeinterface 522 1 0
    //   873: aload_0
    //   874: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   877: return
    //   878: aload_0
    //   879: aload_2
    //   880: iconst_1
    //   881: invokevirtual 277	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   884: astore 13
    //   886: goto -187 -> 699
    //   889: aload_0
    //   890: aload_2
    //   891: iconst_1
    //   892: invokevirtual 277	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   895: astore 13
    //   897: goto -198 -> 699
    //   900: aconst_null
    //   901: astore 16
    //   903: new 286	java/io/File
    //   906: dup
    //   907: aload 13
    //   909: ldc_w 590
    //   912: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   915: astore 14
    //   917: new 385	java/util/Properties
    //   920: dup
    //   921: invokespecial 386	java/util/Properties:<init>	()V
    //   924: astore 15
    //   926: aload 14
    //   928: ifnull +1136 -> 2064
    //   931: aload 14
    //   933: invokevirtual 593	java/io/File:exists	()Z
    //   936: ifeq +1128 -> 2064
    //   939: aload 15
    //   941: ifnull +1123 -> 2064
    //   944: new 388	java/io/BufferedInputStream
    //   947: dup
    //   948: new 390	java/io/FileInputStream
    //   951: dup
    //   952: aload 14
    //   954: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   957: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   960: astore 14
    //   962: aload 14
    //   964: astore 17
    //   966: aload 15
    //   968: aload 14
    //   970: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   973: iconst_1
    //   974: istore 4
    //   976: aload 14
    //   978: ifnull +1021 -> 1999
    //   981: aload 14
    //   983: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   986: iload 4
    //   988: ifeq +999 -> 1987
    //   991: aload 13
    //   993: invokevirtual 597	java/io/File:listFiles	()[Ljava/io/File;
    //   996: astore 14
    //   998: aload_1
    //   999: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1002: sipush -552
    //   1005: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1008: iconst_0
    //   1009: istore 5
    //   1011: iload 5
    //   1013: aload 14
    //   1015: arraylength
    //   1016: if_icmpge +971 -> 1987
    //   1019: aload 14
    //   1021: iload 5
    //   1023: aaload
    //   1024: astore 16
    //   1026: ldc_w 590
    //   1029: aload 16
    //   1031: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   1034: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1037: ifne +1018 -> 2055
    //   1040: aload 16
    //   1042: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   1045: ldc_w 602
    //   1048: invokevirtual 606	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1051: ifne +1004 -> 2055
    //   1054: ldc_w 383
    //   1057: aload 16
    //   1059: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   1062: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1065: ifne +990 -> 2055
    //   1068: aload 16
    //   1070: invokevirtual 609	java/io/File:isDirectory	()Z
    //   1073: ifne +982 -> 2055
    //   1076: aload 16
    //   1078: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   1081: ldc_w 611
    //   1084: invokevirtual 606	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1087: ifeq +181 -> 1268
    //   1090: goto +965 -> 2055
    //   1093: astore 14
    //   1095: aload 14
    //   1097: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   1100: goto -114 -> 986
    //   1103: astore 16
    //   1105: aconst_null
    //   1106: astore 15
    //   1108: aconst_null
    //   1109: astore 14
    //   1111: aload 14
    //   1113: astore 17
    //   1115: aload 16
    //   1117: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1120: aload 14
    //   1122: ifnull +871 -> 1993
    //   1125: aload 14
    //   1127: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   1130: iconst_1
    //   1131: istore 4
    //   1133: goto -147 -> 986
    //   1136: astore 14
    //   1138: aload 14
    //   1140: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   1143: iconst_1
    //   1144: istore 4
    //   1146: goto -160 -> 986
    //   1149: astore 14
    //   1151: aload 16
    //   1153: astore 15
    //   1155: aload 15
    //   1157: ifnull +8 -> 1165
    //   1160: aload 15
    //   1162: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   1165: aload 14
    //   1167: athrow
    //   1168: astore 15
    //   1170: aload 13
    //   1172: astore 14
    //   1174: aload 15
    //   1176: astore 13
    //   1178: aload_2
    //   1179: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1182: sipush 215
    //   1185: aload 13
    //   1187: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   1190: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1193: aload_1
    //   1194: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1197: sipush -537
    //   1200: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1203: aload 14
    //   1205: iconst_0
    //   1206: invokestatic 271	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1209: aload_2
    //   1210: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1213: iconst_0
    //   1214: iconst_m1
    //   1215: invokevirtual 178	com/tencent/smtt/sdk/n:a	(II)V
    //   1218: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1221: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1224: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1227: invokeinterface 522 1 0
    //   1232: aload_0
    //   1233: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1236: return
    //   1237: astore 15
    //   1239: aload 15
    //   1241: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   1244: goto -79 -> 1165
    //   1247: astore_1
    //   1248: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1251: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1254: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1257: invokeinterface 522 1 0
    //   1262: aload_0
    //   1263: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1266: aload_1
    //   1267: athrow
    //   1268: aload 16
    //   1270: invokestatic 616	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1273: astore 17
    //   1275: aload 15
    //   1277: aload 16
    //   1279: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   1282: ldc_w 618
    //   1285: invokevirtual 622	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1288: astore 18
    //   1290: aload 18
    //   1292: ldc_w 618
    //   1295: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1298: ifne +51 -> 1349
    //   1301: aload 17
    //   1303: aload 18
    //   1305: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1308: ifeq +41 -> 1349
    //   1311: ldc 139
    //   1313: new 235	java/lang/StringBuilder
    //   1316: dup
    //   1317: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1320: ldc_w 624
    //   1323: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: aload 16
    //   1328: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   1331: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: ldc_w 626
    //   1337: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1343: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1346: goto +709 -> 2055
    //   1349: ldc 139
    //   1351: new 235	java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1358: ldc_w 628
    //   1361: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: aload 16
    //   1366: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   1369: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: ldc_w 626
    //   1375: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 630
    //   1381: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: aload 18
    //   1386: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: ldc_w 632
    //   1392: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: aload 17
    //   1397: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1406: iconst_0
    //   1407: istore 8
    //   1409: ldc 139
    //   1411: new 235	java/lang/StringBuilder
    //   1414: dup
    //   1415: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1418: ldc_w 634
    //   1421: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: iload 8
    //   1426: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1429: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1432: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1435: iload 4
    //   1437: ifeq +64 -> 1501
    //   1440: iload 8
    //   1442: ifne +59 -> 1501
    //   1445: ldc 139
    //   1447: ldc_w 636
    //   1450: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1453: aload 13
    //   1455: iconst_1
    //   1456: invokestatic 271	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1459: aload_2
    //   1460: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1463: sipush 213
    //   1466: ldc_w 638
    //   1469: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1472: aload_1
    //   1473: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1476: sipush -532
    //   1479: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1482: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1485: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1488: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1491: invokeinterface 522 1 0
    //   1496: aload_0
    //   1497: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1500: return
    //   1501: ldc 139
    //   1503: ldc_w 640
    //   1506: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: aload_0
    //   1510: aload_2
    //   1511: iconst_1
    //   1512: invokespecial 331	com/tencent/smtt/sdk/p:g	(Landroid/content/Context;Z)V
    //   1515: aload_1
    //   1516: invokestatic 644	com/tencent/smtt/sdk/m:d	(Landroid/content/Context;)Ljava/io/File;
    //   1519: astore 15
    //   1521: aload 15
    //   1523: ifnull +38 -> 1561
    //   1526: aload 15
    //   1528: invokevirtual 593	java/io/File:exists	()Z
    //   1531: ifeq +30 -> 1561
    //   1534: aload_2
    //   1535: invokestatic 647	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1538: ifeq +182 -> 1720
    //   1541: ldc_w 649
    //   1544: astore 14
    //   1546: new 286	java/io/File
    //   1549: dup
    //   1550: aload 15
    //   1552: aload 14
    //   1554: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1557: aload_2
    //   1558: invokestatic 652	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1561: aload_2
    //   1562: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1565: iload_3
    //   1566: iconst_1
    //   1567: invokevirtual 178	com/tencent/smtt/sdk/n:a	(II)V
    //   1570: aload_0
    //   1571: getfield 121	com/tencent/smtt/sdk/p:k	Z
    //   1574: ifeq +155 -> 1729
    //   1577: aload_2
    //   1578: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1581: sipush 220
    //   1584: ldc_w 654
    //   1587: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1590: aload_1
    //   1591: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1594: sipush -533
    //   1597: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1600: ldc 139
    //   1602: new 235	java/lang/StringBuilder
    //   1605: dup
    //   1606: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1609: ldc_w 656
    //   1612: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: iload_3
    //   1616: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1619: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1622: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1625: getstatic 476	android/os/Build$VERSION:SDK_INT	I
    //   1628: bipush 11
    //   1630: if_icmplt +115 -> 1745
    //   1633: aload_2
    //   1634: ldc_w 478
    //   1637: iconst_4
    //   1638: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1641: astore 14
    //   1643: aload 14
    //   1645: invokeinterface 660 1 0
    //   1650: astore 14
    //   1652: aload 14
    //   1654: ldc_w 662
    //   1657: iconst_0
    //   1658: invokeinterface 668 3 0
    //   1663: pop
    //   1664: aload 14
    //   1666: ldc_w 670
    //   1669: iconst_0
    //   1670: invokeinterface 668 3 0
    //   1675: pop
    //   1676: aload 14
    //   1678: ldc_w 672
    //   1681: iload_3
    //   1682: invokeinterface 668 3 0
    //   1687: pop
    //   1688: aload 14
    //   1690: invokeinterface 675 1 0
    //   1695: pop
    //   1696: aload_2
    //   1697: invokestatic 676	com/tencent/smtt/utils/q:a	(Landroid/content/Context;)Z
    //   1700: pop
    //   1701: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1704: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1707: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1710: invokeinterface 522 1 0
    //   1715: aload_0
    //   1716: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1719: return
    //   1720: iconst_0
    //   1721: invokestatic 680	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1724: astore 14
    //   1726: goto -180 -> 1546
    //   1729: aload_2
    //   1730: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1733: sipush 220
    //   1736: ldc_w 682
    //   1739: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1742: goto -152 -> 1590
    //   1745: aload_2
    //   1746: ldc_w 478
    //   1749: iconst_0
    //   1750: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1753: astore 14
    //   1755: goto -112 -> 1643
    //   1758: astore 14
    //   1760: ldc 139
    //   1762: new 235	java/lang/StringBuilder
    //   1765: dup
    //   1766: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1769: ldc_w 684
    //   1772: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: aload 14
    //   1777: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1780: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1786: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1789: goto -93 -> 1696
    //   1792: ldc 139
    //   1794: ldc_w 692
    //   1797: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1800: aload_2
    //   1801: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1804: iload_3
    //   1805: iconst_2
    //   1806: invokevirtual 178	com/tencent/smtt/sdk/n:a	(II)V
    //   1809: aload 13
    //   1811: iconst_0
    //   1812: invokestatic 271	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1815: aload_1
    //   1816: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1819: sipush -534
    //   1822: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1825: aload_2
    //   1826: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1829: sipush 212
    //   1832: ldc_w 694
    //   1835: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1838: goto -137 -> 1701
    //   1841: aload 15
    //   1843: ifnonnull +26 -> 1869
    //   1846: aload_2
    //   1847: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1850: sipush 213
    //   1853: ldc_w 696
    //   1856: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1859: aload_1
    //   1860: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1863: sipush -535
    //   1866: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1869: aload 13
    //   1871: ifnonnull -170 -> 1701
    //   1874: aload_2
    //   1875: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1878: sipush 214
    //   1881: ldc_w 698
    //   1884: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1887: aload_1
    //   1888: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1891: sipush -536
    //   1894: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1897: goto -196 -> 1701
    //   1900: astore_1
    //   1901: ldc 139
    //   1903: new 235	java/lang/StringBuilder
    //   1906: dup
    //   1907: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1910: ldc_w 700
    //   1913: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: aload_1
    //   1917: invokevirtual 703	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1920: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: ldc_w 705
    //   1926: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: aload_1
    //   1930: invokevirtual 709	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1933: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1936: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1939: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1942: goto -724 -> 1218
    //   1945: aload_0
    //   1946: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1949: aload_1
    //   1950: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1953: sipush -538
    //   1956: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1959: return
    //   1960: astore 13
    //   1962: goto -784 -> 1178
    //   1965: astore 14
    //   1967: aload 17
    //   1969: astore 15
    //   1971: goto -816 -> 1155
    //   1974: astore 16
    //   1976: aconst_null
    //   1977: astore 14
    //   1979: goto -868 -> 1111
    //   1982: astore 16
    //   1984: goto -873 -> 1111
    //   1987: iconst_1
    //   1988: istore 8
    //   1990: goto -581 -> 1409
    //   1993: iconst_1
    //   1994: istore 4
    //   1996: goto -1010 -> 986
    //   1999: goto -1013 -> 986
    //   2002: iload 4
    //   2004: ifle +12 -> 2016
    //   2007: iload_3
    //   2008: iload 4
    //   2010: if_icmple +6 -> 2016
    //   2013: goto -1614 -> 399
    //   2016: iload 5
    //   2018: istore 4
    //   2020: iload 5
    //   2022: iconst_3
    //   2023: if_icmpne -1599 -> 424
    //   2026: iload 5
    //   2028: istore 4
    //   2030: iload 6
    //   2032: ifle -1608 -> 424
    //   2035: iload_3
    //   2036: iload 6
    //   2038: if_icmpgt -1631 -> 407
    //   2041: iload 5
    //   2043: istore 4
    //   2045: iload_3
    //   2046: ldc_w 710
    //   2049: if_icmpne -1625 -> 424
    //   2052: goto -1645 -> 407
    //   2055: iload 5
    //   2057: iconst_1
    //   2058: iadd
    //   2059: istore 5
    //   2061: goto -1050 -> 1011
    //   2064: aconst_null
    //   2065: astore 14
    //   2067: iconst_0
    //   2068: istore 4
    //   2070: goto -1094 -> 976
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2073	0	this	p
    //   0	2073	1	paramContext1	Context
    //   0	2073	2	paramContext2	Context
    //   0	2073	3	paramInt	int
    //   211	1858	4	i1	int
    //   223	1837	5	i2	int
    //   276	1763	6	i3	int
    //   383	11	7	i4	int
    //   159	1830	8	bool	boolean
    //   434	357	9	l1	long
    //   443	44	11	l2	long
    //   60	1810	13	localObject1	Object
    //   1960	1	13	localException1	Exception
    //   199	821	14	localObject2	Object
    //   1093	3	14	localIOException1	java.io.IOException
    //   1109	17	14	localObject3	Object
    //   1136	3	14	localIOException2	java.io.IOException
    //   1149	17	14	localObject4	Object
    //   1172	582	14	localObject5	Object
    //   1758	18	14	localThrowable	Throwable
    //   1965	1	14	localObject6	Object
    //   1977	89	14	localObject7	Object
    //   676	485	15	localObject8	Object
    //   1168	7	15	localException2	Exception
    //   1237	39	15	localIOException3	java.io.IOException
    //   1519	451	15	localObject9	Object
    //   901	176	16	localObject10	Object
    //   1103	262	16	localException3	Exception
    //   1974	1	16	localException4	Exception
    //   1982	1	16	localException5	Exception
    //   964	1004	17	localObject11	Object
    //   1288	97	18	str	String
    // Exception table:
    //   from	to	target	type
    //   981	986	1093	java/io/IOException
    //   903	926	1103	java/lang/Exception
    //   1125	1130	1136	java/io/IOException
    //   903	926	1149	finally
    //   931	939	1149	finally
    //   944	962	1149	finally
    //   709	772	1168	java/lang/Exception
    //   772	802	1168	java/lang/Exception
    //   807	859	1168	java/lang/Exception
    //   981	986	1168	java/lang/Exception
    //   991	1008	1168	java/lang/Exception
    //   1011	1019	1168	java/lang/Exception
    //   1026	1090	1168	java/lang/Exception
    //   1095	1100	1168	java/lang/Exception
    //   1125	1130	1168	java/lang/Exception
    //   1138	1143	1168	java/lang/Exception
    //   1160	1165	1168	java/lang/Exception
    //   1165	1168	1168	java/lang/Exception
    //   1239	1244	1168	java/lang/Exception
    //   1268	1346	1168	java/lang/Exception
    //   1349	1406	1168	java/lang/Exception
    //   1409	1435	1168	java/lang/Exception
    //   1445	1482	1168	java/lang/Exception
    //   1501	1521	1168	java/lang/Exception
    //   1526	1541	1168	java/lang/Exception
    //   1546	1561	1168	java/lang/Exception
    //   1561	1590	1168	java/lang/Exception
    //   1590	1643	1168	java/lang/Exception
    //   1643	1696	1168	java/lang/Exception
    //   1696	1701	1168	java/lang/Exception
    //   1720	1726	1168	java/lang/Exception
    //   1729	1742	1168	java/lang/Exception
    //   1745	1755	1168	java/lang/Exception
    //   1760	1789	1168	java/lang/Exception
    //   1792	1838	1168	java/lang/Exception
    //   1846	1869	1168	java/lang/Exception
    //   1874	1897	1168	java/lang/Exception
    //   1160	1165	1237	java/io/IOException
    //   201	225	1247	finally
    //   231	252	1247	finally
    //   271	304	1247	finally
    //   310	357	1247	finally
    //   376	385	1247	finally
    //   399	404	1247	finally
    //   407	421	1247	finally
    //   424	497	1247	finally
    //   521	544	1247	finally
    //   549	561	1247	finally
    //   567	590	1247	finally
    //   609	638	1247	finally
    //   657	671	1247	finally
    //   671	699	1247	finally
    //   709	772	1247	finally
    //   772	802	1247	finally
    //   807	859	1247	finally
    //   878	886	1247	finally
    //   889	897	1247	finally
    //   981	986	1247	finally
    //   991	1008	1247	finally
    //   1011	1019	1247	finally
    //   1026	1090	1247	finally
    //   1095	1100	1247	finally
    //   1125	1130	1247	finally
    //   1138	1143	1247	finally
    //   1160	1165	1247	finally
    //   1165	1168	1247	finally
    //   1178	1203	1247	finally
    //   1203	1218	1247	finally
    //   1239	1244	1247	finally
    //   1268	1346	1247	finally
    //   1349	1406	1247	finally
    //   1409	1435	1247	finally
    //   1445	1482	1247	finally
    //   1501	1521	1247	finally
    //   1526	1541	1247	finally
    //   1546	1561	1247	finally
    //   1561	1590	1247	finally
    //   1590	1643	1247	finally
    //   1643	1696	1247	finally
    //   1696	1701	1247	finally
    //   1720	1726	1247	finally
    //   1729	1742	1247	finally
    //   1745	1755	1247	finally
    //   1760	1789	1247	finally
    //   1792	1838	1247	finally
    //   1846	1869	1247	finally
    //   1874	1897	1247	finally
    //   1901	1942	1247	finally
    //   1643	1696	1758	java/lang/Throwable
    //   1203	1218	1900	java/lang/Exception
    //   201	225	1960	java/lang/Exception
    //   231	252	1960	java/lang/Exception
    //   271	304	1960	java/lang/Exception
    //   310	357	1960	java/lang/Exception
    //   376	385	1960	java/lang/Exception
    //   399	404	1960	java/lang/Exception
    //   407	421	1960	java/lang/Exception
    //   424	497	1960	java/lang/Exception
    //   521	544	1960	java/lang/Exception
    //   549	561	1960	java/lang/Exception
    //   567	590	1960	java/lang/Exception
    //   609	638	1960	java/lang/Exception
    //   657	671	1960	java/lang/Exception
    //   671	699	1960	java/lang/Exception
    //   878	886	1960	java/lang/Exception
    //   889	897	1960	java/lang/Exception
    //   966	973	1965	finally
    //   1115	1120	1965	finally
    //   931	939	1974	java/lang/Exception
    //   944	962	1974	java/lang/Exception
    //   966	973	1982	java/lang/Exception
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: ldc 139
    //   8: new 235	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 721
    //   18: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_3
    //   22: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   25: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_2
    //   32: invokestatic 723	com/tencent/smtt/utils/FileUtil:c	(Ljava/io/File;)Z
    //   35: ifne +28 -> 63
    //   38: aload_1
    //   39: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   42: sipush 204
    //   45: ldc_w 725
    //   48: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   51: aload_1
    //   52: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   55: sipush -520
    //   58: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_1
    //   64: invokestatic 373	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   67: astore 9
    //   69: iload_3
    //   70: ifeq +84 -> 154
    //   73: new 286	java/io/File
    //   76: dup
    //   77: aload 9
    //   79: ldc_w 727
    //   82: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore 9
    //   87: aload 9
    //   89: ifnull +23 -> 112
    //   92: aload 9
    //   94: invokevirtual 593	java/io/File:exists	()Z
    //   97: ifeq +15 -> 112
    //   100: aload_1
    //   101: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   104: ifne +8 -> 112
    //   107: aload 9
    //   109: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   112: iload_3
    //   113: ifeq +92 -> 205
    //   116: aload_0
    //   117: aload_1
    //   118: iconst_2
    //   119: invokevirtual 277	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   122: astore 9
    //   124: aload 9
    //   126: ifnonnull +90 -> 216
    //   129: aload_1
    //   130: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   133: sipush 205
    //   136: ldc_w 730
    //   139: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   142: aload_1
    //   143: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   146: sipush -521
    //   149: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   152: iconst_0
    //   153: ireturn
    //   154: new 286	java/io/File
    //   157: dup
    //   158: aload 9
    //   160: ldc_w 375
    //   163: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   166: astore 9
    //   168: goto -81 -> 87
    //   171: astore 9
    //   173: ldc 139
    //   175: new 235	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 732
    //   185: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 9
    //   190: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: goto -90 -> 112
    //   205: aload_0
    //   206: aload_1
    //   207: iconst_0
    //   208: invokevirtual 277	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   211: astore 9
    //   213: goto -89 -> 124
    //   216: aload 9
    //   218: invokestatic 734	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;)Z
    //   221: pop
    //   222: iload_3
    //   223: ifeq +9 -> 232
    //   226: aload 9
    //   228: iconst_1
    //   229: invokestatic 271	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   232: aload_2
    //   233: aload 9
    //   235: invokestatic 737	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   238: istore 8
    //   240: iload 8
    //   242: istore 7
    //   244: iload 8
    //   246: ifeq +12 -> 258
    //   249: aload_0
    //   250: aload 9
    //   252: aload_1
    //   253: invokespecial 740	com/tencent/smtt/sdk/p:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   256: istore 7
    //   258: iload_3
    //   259: ifeq +81 -> 340
    //   262: aload 9
    //   264: invokevirtual 744	java/io/File:list	()[Ljava/lang/String;
    //   267: astore_2
    //   268: iconst_0
    //   269: istore 4
    //   271: iload 4
    //   273: aload_2
    //   274: arraylength
    //   275: if_icmpge +47 -> 322
    //   278: new 286	java/io/File
    //   281: dup
    //   282: aload 9
    //   284: aload_2
    //   285: iload 4
    //   287: aaload
    //   288: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   291: astore 10
    //   293: aload 10
    //   295: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   298: ldc_w 602
    //   301: invokevirtual 606	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   304: ifeq +9 -> 313
    //   307: aload 10
    //   309: invokevirtual 363	java/io/File:delete	()Z
    //   312: pop
    //   313: iload 4
    //   315: iconst_1
    //   316: iadd
    //   317: istore 4
    //   319: goto -48 -> 271
    //   322: new 286	java/io/File
    //   325: dup
    //   326: aload_1
    //   327: invokestatic 747	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Ljava/io/File;
    //   330: ldc_w 749
    //   333: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   336: invokevirtual 363	java/io/File:delete	()Z
    //   339: pop
    //   340: iload 7
    //   342: ifne +64 -> 406
    //   345: aload 9
    //   347: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   350: aload_1
    //   351: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   354: sipush -522
    //   357: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   360: ldc 139
    //   362: new 235	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 751
    //   372: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 9
    //   377: invokevirtual 593	java/io/File:exists	()Z
    //   380: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: ldc 139
    //   391: ldc_w 753
    //   394: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: ldc_w 755
    //   400: invokestatic 302	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   403: iload 7
    //   405: ireturn
    //   406: aload_0
    //   407: aload_1
    //   408: iconst_1
    //   409: invokespecial 331	com/tencent/smtt/sdk/p:g	(Landroid/content/Context;Z)V
    //   412: iload_3
    //   413: ifeq -24 -> 389
    //   416: aload_0
    //   417: aload_1
    //   418: invokevirtual 563	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   421: astore_2
    //   422: aload_2
    //   423: iconst_1
    //   424: invokestatic 271	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   427: aload 9
    //   429: aload_2
    //   430: invokevirtual 290	java/io/File:renameTo	(Ljava/io/File;)Z
    //   433: pop
    //   434: aload_1
    //   435: invokestatic 578	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   438: goto -49 -> 389
    //   441: astore_2
    //   442: aload_1
    //   443: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   446: sipush -523
    //   449: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   452: aload_1
    //   453: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   456: sipush 206
    //   459: aload_2
    //   460: invokevirtual 758	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   463: aload 9
    //   465: ifnull +269 -> 734
    //   468: aload 9
    //   470: invokevirtual 593	java/io/File:exists	()Z
    //   473: istore_3
    //   474: iload_3
    //   475: ifeq +259 -> 734
    //   478: iload 5
    //   480: istore 4
    //   482: iload 4
    //   484: ifeq +42 -> 526
    //   487: aload 9
    //   489: ifnull +37 -> 526
    //   492: aload 9
    //   494: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   497: ldc 139
    //   499: new 235	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 760
    //   509: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 9
    //   514: invokevirtual 593	java/io/File:exists	()Z
    //   517: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   520: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: ldc 139
    //   528: ldc_w 753
    //   531: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: ldc_w 755
    //   537: invokestatic 302	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   540: iconst_0
    //   541: ireturn
    //   542: astore_1
    //   543: ldc 139
    //   545: new 235	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   552: ldc_w 762
    //   555: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload_1
    //   559: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   562: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: goto -45 -> 526
    //   574: astore_2
    //   575: aload_1
    //   576: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   579: sipush -523
    //   582: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   585: aload_1
    //   586: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   589: sipush 207
    //   592: aload_2
    //   593: invokevirtual 758	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   596: aload 9
    //   598: ifnull +130 -> 728
    //   601: aload 9
    //   603: invokevirtual 593	java/io/File:exists	()Z
    //   606: istore_3
    //   607: iload_3
    //   608: ifeq +120 -> 728
    //   611: iload 6
    //   613: istore 4
    //   615: iload 4
    //   617: ifeq +42 -> 659
    //   620: aload 9
    //   622: ifnull +37 -> 659
    //   625: aload 9
    //   627: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   630: ldc 139
    //   632: new 235	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   639: ldc_w 760
    //   642: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload 9
    //   647: invokevirtual 593	java/io/File:exists	()Z
    //   650: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   653: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: ldc 139
    //   661: ldc_w 753
    //   664: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   667: ldc_w 755
    //   670: invokestatic 302	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   673: iconst_0
    //   674: ireturn
    //   675: astore_1
    //   676: ldc 139
    //   678: new 235	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   685: ldc_w 762
    //   688: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload_1
    //   692: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   695: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: goto -45 -> 659
    //   707: astore_1
    //   708: ldc 139
    //   710: ldc_w 753
    //   713: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   716: ldc_w 755
    //   719: invokestatic 302	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   722: aload_1
    //   723: athrow
    //   724: astore_2
    //   725: goto -385 -> 340
    //   728: iconst_0
    //   729: istore 4
    //   731: goto -116 -> 615
    //   734: iconst_0
    //   735: istore 4
    //   737: goto -255 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	this	p
    //   0	740	1	paramContext	Context
    //   0	740	2	paramFile	File
    //   0	740	3	paramBoolean	boolean
    //   269	467	4	i1	int
    //   4	475	5	i2	int
    //   1	611	6	i3	int
    //   242	162	7	bool1	boolean
    //   238	7	8	bool2	boolean
    //   67	100	9	localFile1	File
    //   171	18	9	localThrowable	Throwable
    //   211	435	9	localFile2	File
    //   291	17	10	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   63	69	171	java/lang/Throwable
    //   73	87	171	java/lang/Throwable
    //   92	112	171	java/lang/Throwable
    //   154	168	171	java/lang/Throwable
    //   216	222	441	java/io/IOException
    //   226	232	441	java/io/IOException
    //   232	240	441	java/io/IOException
    //   249	258	441	java/io/IOException
    //   262	268	441	java/io/IOException
    //   271	313	441	java/io/IOException
    //   322	340	441	java/io/IOException
    //   345	389	441	java/io/IOException
    //   406	412	441	java/io/IOException
    //   416	438	441	java/io/IOException
    //   492	526	542	java/lang/Throwable
    //   216	222	574	java/lang/Exception
    //   226	232	574	java/lang/Exception
    //   232	240	574	java/lang/Exception
    //   249	258	574	java/lang/Exception
    //   262	268	574	java/lang/Exception
    //   271	313	574	java/lang/Exception
    //   345	389	574	java/lang/Exception
    //   406	412	574	java/lang/Exception
    //   416	438	574	java/lang/Exception
    //   625	659	675	java/lang/Throwable
    //   216	222	707	finally
    //   226	232	707	finally
    //   232	240	707	finally
    //   249	258	707	finally
    //   262	268	707	finally
    //   271	313	707	finally
    //   322	340	707	finally
    //   345	389	707	finally
    //   406	412	707	finally
    //   416	438	707	finally
    //   442	463	707	finally
    //   468	474	707	finally
    //   575	596	707	finally
    //   601	607	707	finally
    //   322	340	724	java/lang/Exception
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), paramString);
    if ((paramContext == null) || (!paramContext.exists()))
    {
      TbsLog.i("TbsInstaller", "isPrepareTbsCore", "#1# " + paramString);
      return false;
    }
    paramContext = new File(paramContext, "tbs.conf");
    if ((paramContext == null) || (!paramContext.exists()))
    {
      TbsLog.i("TbsInstaller", "isPrepareTbsCore", "#2# " + paramString);
      return false;
    }
    TbsLog.i("TbsInstaller", "isPrepareTbsCore", "#3# " + paramString);
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 139
    //   8: new 235	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 775
    //   18: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 777
    //   28: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload 6
    //   43: astore_2
    //   44: new 286	java/io/File
    //   47: dup
    //   48: aload_1
    //   49: ldc_w 590
    //   52: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 9
    //   57: aload 6
    //   59: astore_2
    //   60: new 385	java/util/Properties
    //   63: dup
    //   64: invokespecial 386	java/util/Properties:<init>	()V
    //   67: astore 7
    //   69: aload 9
    //   71: ifnull +191 -> 262
    //   74: aload 6
    //   76: astore_2
    //   77: aload 9
    //   79: invokevirtual 593	java/io/File:exists	()Z
    //   82: ifeq +180 -> 262
    //   85: aload 7
    //   87: ifnull +175 -> 262
    //   90: aload 6
    //   92: astore_2
    //   93: new 388	java/io/BufferedInputStream
    //   96: dup
    //   97: new 390	java/io/FileInputStream
    //   100: dup
    //   101: aload 9
    //   103: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: astore 6
    //   111: aload 7
    //   113: aload 6
    //   115: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   118: iconst_1
    //   119: istore 5
    //   121: aload 6
    //   123: astore_2
    //   124: aload 7
    //   126: astore 6
    //   128: iload 5
    //   130: istore 4
    //   132: aload_2
    //   133: ifnull +15 -> 148
    //   136: aload_2
    //   137: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   140: iload 5
    //   142: istore 4
    //   144: aload 7
    //   146: astore 6
    //   148: ldc 139
    //   150: new 235	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 779
    //   160: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload 4
    //   165: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: iload 4
    //   176: ifeq +395 -> 571
    //   179: aload_1
    //   180: invokevirtual 597	java/io/File:listFiles	()[Ljava/io/File;
    //   183: astore_1
    //   184: iconst_0
    //   185: istore_3
    //   186: iload_3
    //   187: aload_1
    //   188: arraylength
    //   189: if_icmpge +382 -> 571
    //   192: aload_1
    //   193: iload_3
    //   194: aaload
    //   195: astore_2
    //   196: ldc_w 590
    //   199: aload_2
    //   200: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   203: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifne +49 -> 255
    //   209: aload_2
    //   210: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   213: ldc_w 602
    //   216: invokevirtual 606	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   219: ifne +36 -> 255
    //   222: ldc_w 383
    //   225: aload_2
    //   226: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   229: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifne +23 -> 255
    //   235: aload_2
    //   236: invokevirtual 609	java/io/File:isDirectory	()Z
    //   239: ifne +16 -> 255
    //   242: aload_2
    //   243: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   246: ldc_w 611
    //   249: invokevirtual 606	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   252: ifeq +93 -> 345
    //   255: iload_3
    //   256: iconst_1
    //   257: iadd
    //   258: istore_3
    //   259: goto -73 -> 186
    //   262: aconst_null
    //   263: astore_2
    //   264: iconst_0
    //   265: istore 5
    //   267: goto -143 -> 124
    //   270: astore_2
    //   271: aload_2
    //   272: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   275: aload 7
    //   277: astore 6
    //   279: iload 5
    //   281: istore 4
    //   283: goto -135 -> 148
    //   286: astore 7
    //   288: aconst_null
    //   289: astore 6
    //   291: aload 8
    //   293: astore_2
    //   294: aload 7
    //   296: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   299: aload 8
    //   301: ifnull +276 -> 577
    //   304: aload 8
    //   306: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   309: iconst_1
    //   310: istore 4
    //   312: goto -164 -> 148
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   320: iconst_1
    //   321: istore 4
    //   323: goto -175 -> 148
    //   326: astore_1
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_2
    //   338: aload_2
    //   339: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   342: goto -7 -> 335
    //   345: aload_2
    //   346: invokestatic 616	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   349: astore 7
    //   351: aload 6
    //   353: aload_2
    //   354: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   357: ldc_w 618
    //   360: invokevirtual 622	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   363: astore 8
    //   365: aload 8
    //   367: ldc_w 618
    //   370: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifne +50 -> 423
    //   376: aload 8
    //   378: aload 7
    //   380: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: ifeq +40 -> 423
    //   386: ldc 139
    //   388: new 235	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 624
    //   398: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_2
    //   402: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   405: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 626
    //   411: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: goto -165 -> 255
    //   423: ldc 139
    //   425: new 235	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 628
    //   435: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_2
    //   439: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   442: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 626
    //   448: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: ldc_w 630
    //   454: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 8
    //   459: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 632
    //   465: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 7
    //   470: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: iconst_0
    //   480: istore 5
    //   482: ldc 139
    //   484: new 235	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 781
    //   494: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: iload 5
    //   499: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   502: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: iload 4
    //   510: ifeq +18 -> 528
    //   513: iload 5
    //   515: ifne +13 -> 528
    //   518: ldc 139
    //   520: ldc_w 783
    //   523: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: iconst_0
    //   527: ireturn
    //   528: ldc 139
    //   530: ldc_w 785
    //   533: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: iconst_1
    //   537: ireturn
    //   538: astore_1
    //   539: aload 6
    //   541: astore_2
    //   542: goto -215 -> 327
    //   545: astore_2
    //   546: aload 7
    //   548: astore 6
    //   550: aload_2
    //   551: astore 7
    //   553: goto -262 -> 291
    //   556: astore_2
    //   557: aload 6
    //   559: astore 8
    //   561: aload 7
    //   563: astore 6
    //   565: aload_2
    //   566: astore 7
    //   568: goto -277 -> 291
    //   571: iconst_1
    //   572: istore 5
    //   574: goto -92 -> 482
    //   577: iconst_1
    //   578: istore 4
    //   580: goto -432 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	p
    //   0	583	1	paramFile	File
    //   0	583	2	paramContext	Context
    //   185	74	3	i1	int
    //   130	449	4	bool1	boolean
    //   119	454	5	bool2	boolean
    //   1	563	6	localObject1	Object
    //   67	209	7	localProperties	java.util.Properties
    //   286	9	7	localException	Exception
    //   349	218	7	localObject2	Object
    //   4	556	8	localObject3	Object
    //   55	47	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   136	140	270	java/io/IOException
    //   44	57	286	java/lang/Exception
    //   60	69	286	java/lang/Exception
    //   304	309	315	java/io/IOException
    //   44	57	326	finally
    //   60	69	326	finally
    //   77	85	326	finally
    //   93	111	326	finally
    //   294	299	326	finally
    //   331	335	337	java/io/IOException
    //   111	118	538	finally
    //   77	85	545	java/lang/Exception
    //   93	111	545	java/lang/Exception
    //   111	118	556	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 7
    //   6: aload_1
    //   7: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   10: sipush -501
    //   13: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 469	com/tencent/smtt/sdk/p:d	(Landroid/content/Context;)Z
    //   21: ifeq +34 -> 55
    //   24: ldc 139
    //   26: ldc_w 787
    //   29: iconst_1
    //   30: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   33: aload_1
    //   34: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   37: sipush -502
    //   40: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   43: getstatic 513	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   46: sipush -502
    //   49: invokeinterface 518 2 0
    //   54: return
    //   55: ldc 139
    //   57: new 235	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 789
    //   67: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc 139
    //   82: new 235	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 791
    //   92: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload_3
    //   96: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: ldc 139
    //   107: new 235	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 793
    //   117: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 314	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   124: getfield 796	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   127: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: ldc 139
    //   138: new 235	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 798
    //   148: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokestatic 803	android/os/Process:myPid	()I
    //   154: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: ldc 139
    //   165: new 235	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 805
    //   175: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokestatic 811	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   181: invokevirtual 812	java/lang/Thread:getName	()Ljava/lang/String;
    //   184: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: getstatic 476	android/os/Build$VERSION:SDK_INT	I
    //   196: bipush 11
    //   198: if_icmplt +81 -> 279
    //   201: aload_1
    //   202: ldc_w 478
    //   205: iconst_4
    //   206: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   209: astore 14
    //   211: aload 14
    //   213: ldc_w 484
    //   216: iconst_m1
    //   217: invokeinterface 201 3 0
    //   222: iload_3
    //   223: if_icmpne +69 -> 292
    //   226: ldc 139
    //   228: new 235	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 814
    //   238: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: iload_3
    //   242: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: ldc_w 488
    //   248: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_1
    //   258: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   261: sipush -503
    //   264: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   267: getstatic 513	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   270: sipush -503
    //   273: invokeinterface 518 2 0
    //   278: return
    //   279: aload_1
    //   280: ldc_w 478
    //   283: iconst_0
    //   284: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   287: astore 14
    //   289: goto -78 -> 211
    //   292: aload_1
    //   293: invokestatic 537	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   296: ifne +89 -> 385
    //   299: invokestatic 540	com/tencent/smtt/utils/q:a	()J
    //   302: lstore 9
    //   304: aload_1
    //   305: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   308: invokevirtual 543	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   311: lstore 11
    //   313: aload_1
    //   314: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   317: sipush -504
    //   320: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   323: new 235	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 816
    //   333: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: lload 9
    //   338: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   341: ldc_w 550
    //   344: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: lload 11
    //   349: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: astore_2
    //   356: aload_1
    //   357: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   360: sipush 210
    //   363: aload_2
    //   364: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   367: ldc 139
    //   369: aload_2
    //   370: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: getstatic 513	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   376: sipush 210
    //   379: invokeinterface 518 2 0
    //   384: return
    //   385: aload_0
    //   386: aload_1
    //   387: invokevirtual 491	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   390: ifne +33 -> 423
    //   393: aload_1
    //   394: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   397: sipush -505
    //   400: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   403: ldc 139
    //   405: ldc_w 818
    //   408: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: getstatic 513	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   414: sipush -505
    //   417: invokeinterface 518 2 0
    //   422: return
    //   423: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   426: invokeinterface 496 1 0
    //   431: istore 13
    //   433: ldc 139
    //   435: new 235	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 820
    //   445: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: iload 13
    //   450: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   453: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: iload 13
    //   461: ifeq +1952 -> 2413
    //   464: aload_1
    //   465: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   468: sipush -507
    //   471: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   474: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   477: invokevirtual 501	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   480: aload_1
    //   481: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   484: ldc_w 503
    //   487: invokevirtual 506	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   490: istore 4
    //   492: aload_1
    //   493: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   496: invokevirtual 531	com/tencent/smtt/sdk/n:b	()I
    //   499: istore 5
    //   501: ldc 139
    //   503: new 235	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 822
    //   513: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: iload 4
    //   518: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: ldc 139
    //   529: new 235	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 824
    //   539: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: iload 5
    //   544: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: ldc 139
    //   555: new 235	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 826
    //   565: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: iload_3
    //   569: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: iload 5
    //   580: ifle +1854 -> 2434
    //   583: iload_3
    //   584: iload 5
    //   586: if_icmpgt +6 -> 592
    //   589: goto +1845 -> 2434
    //   592: aload_0
    //   593: aload_1
    //   594: invokevirtual 533	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)V
    //   597: aload_1
    //   598: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   601: invokevirtual 828	com/tencent/smtt/sdk/n:c	()I
    //   604: istore 5
    //   606: aload_0
    //   607: aload_1
    //   608: invokevirtual 208	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;)I
    //   611: istore 6
    //   613: ldc 139
    //   615: new 235	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   622: ldc_w 830
    //   625: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: iload 5
    //   630: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: ldc 139
    //   641: new 235	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 832
    //   651: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload 6
    //   656: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   659: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: iload 5
    //   667: iflt +159 -> 826
    //   670: iload 5
    //   672: iconst_2
    //   673: if_icmpge +153 -> 826
    //   676: ldc 139
    //   678: ldc_w 834
    //   681: iconst_1
    //   682: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   685: iconst_1
    //   686: istore 6
    //   688: aload_1
    //   689: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   692: sipush -508
    //   695: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   698: ldc 139
    //   700: new 235	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 836
    //   710: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: iload 5
    //   715: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   718: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: iload 5
    //   726: iconst_1
    //   727: if_icmpge +1154 -> 1881
    //   730: ldc 139
    //   732: ldc_w 838
    //   735: iconst_1
    //   736: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   739: aload_1
    //   740: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   743: sipush -509
    //   746: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   749: iload 6
    //   751: ifeq +157 -> 908
    //   754: aload_1
    //   755: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   758: ldc_w 840
    //   761: invokevirtual 506	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   764: istore 4
    //   766: iload 4
    //   768: bipush 10
    //   770: if_icmple +127 -> 897
    //   773: aload_1
    //   774: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   777: sipush 201
    //   780: ldc_w 842
    //   783: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   786: aload_0
    //   787: aload_1
    //   788: invokespecial 844	com/tencent/smtt/sdk/p:F	(Landroid/content/Context;)V
    //   791: aload_1
    //   792: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   795: sipush -510
    //   798: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   801: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   804: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   807: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   810: invokeinterface 522 1 0
    //   815: aload_0
    //   816: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   819: return
    //   820: astore_1
    //   821: aload_1
    //   822: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   825: return
    //   826: iload 5
    //   828: istore 4
    //   830: iload 5
    //   832: iconst_3
    //   833: if_icmpne +46 -> 879
    //   836: iload 5
    //   838: istore 4
    //   840: iload 6
    //   842: iflt +37 -> 879
    //   845: iload_3
    //   846: iload 6
    //   848: if_icmpgt +14 -> 862
    //   851: iload 5
    //   853: istore 4
    //   855: iload_3
    //   856: ldc_w 710
    //   859: if_icmpne +20 -> 879
    //   862: iconst_m1
    //   863: istore 4
    //   865: aload_0
    //   866: aload_1
    //   867: invokevirtual 533	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)V
    //   870: ldc 139
    //   872: ldc_w 846
    //   875: iconst_1
    //   876: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   879: iconst_0
    //   880: istore 6
    //   882: iload 4
    //   884: istore 5
    //   886: goto -198 -> 688
    //   889: astore_1
    //   890: aload_1
    //   891: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   894: goto -79 -> 815
    //   897: aload_1
    //   898: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   901: iload 4
    //   903: iconst_1
    //   904: iadd
    //   905: invokevirtual 848	com/tencent/smtt/sdk/n:b	(I)V
    //   908: aload_2
    //   909: ifnonnull +80 -> 989
    //   912: aload_1
    //   913: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   916: ldc_w 850
    //   919: invokevirtual 853	com/tencent/smtt/sdk/n:d	(Ljava/lang/String;)Ljava/lang/String;
    //   922: astore 15
    //   924: aload 15
    //   926: astore 14
    //   928: aload 15
    //   930: ifnonnull +62 -> 992
    //   933: aload_1
    //   934: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   937: sipush 202
    //   940: ldc_w 855
    //   943: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   946: aload_1
    //   947: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   950: sipush -511
    //   953: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   956: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   959: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   962: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   965: invokeinterface 522 1 0
    //   970: aload_0
    //   971: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   974: return
    //   975: astore_1
    //   976: aload_1
    //   977: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   980: return
    //   981: astore_1
    //   982: aload_1
    //   983: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   986: goto -16 -> 970
    //   989: aload_2
    //   990: astore 14
    //   992: ldc 139
    //   994: new 235	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1001: ldc_w 857
    //   1004: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload 14
    //   1009: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1018: aload_0
    //   1019: aload_1
    //   1020: aload 14
    //   1022: invokevirtual 860	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   1025: istore 8
    //   1027: iload 8
    //   1029: ifne +59 -> 1088
    //   1032: aload_1
    //   1033: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1036: sipush -512
    //   1039: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1042: aload_1
    //   1043: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1046: sipush 203
    //   1049: ldc_w 862
    //   1052: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1055: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1058: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1061: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1064: invokeinterface 522 1 0
    //   1069: aload_0
    //   1070: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1073: return
    //   1074: astore_1
    //   1075: aload_1
    //   1076: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1079: return
    //   1080: astore_1
    //   1081: aload_1
    //   1082: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1085: goto -16 -> 1069
    //   1088: aload_1
    //   1089: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1092: ldc_w 850
    //   1095: aload 14
    //   1097: invokevirtual 864	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1100: aload_1
    //   1101: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1104: iload 8
    //   1106: iconst_0
    //   1107: invokevirtual 341	com/tencent/smtt/sdk/n:c	(II)V
    //   1110: aload_1
    //   1111: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1114: sipush -548
    //   1117: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1120: aload_1
    //   1121: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1124: ifeq +70 -> 1194
    //   1127: aload_0
    //   1128: aload_1
    //   1129: new 286	java/io/File
    //   1132: dup
    //   1133: aload 14
    //   1135: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   1138: iconst_1
    //   1139: invokespecial 866	com/tencent/smtt/sdk/p:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1142: ifne +115 -> 1257
    //   1145: aload_1
    //   1146: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1149: sipush 207
    //   1152: ldc_w 868
    //   1155: getstatic 874	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1158: invokevirtual 877	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1161: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1164: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1167: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1170: invokeinterface 522 1 0
    //   1175: aload_0
    //   1176: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1179: return
    //   1180: astore_1
    //   1181: aload_1
    //   1182: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1185: return
    //   1186: astore_1
    //   1187: aload_1
    //   1188: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1191: goto -16 -> 1175
    //   1194: aload_0
    //   1195: aload_1
    //   1196: new 286	java/io/File
    //   1199: dup
    //   1200: aload 14
    //   1202: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   1205: invokespecial 880	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;Ljava/io/File;)Z
    //   1208: ifne +49 -> 1257
    //   1211: aload_1
    //   1212: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1215: sipush 207
    //   1218: ldc_w 868
    //   1221: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1224: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1227: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1230: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1233: invokeinterface 522 1 0
    //   1238: aload_0
    //   1239: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1242: return
    //   1243: astore_1
    //   1244: aload_1
    //   1245: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1248: return
    //   1249: astore_1
    //   1250: aload_1
    //   1251: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1254: goto -16 -> 1238
    //   1257: iload 6
    //   1259: ifeq +144 -> 1403
    //   1262: aload_1
    //   1263: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1266: ldc_w 882
    //   1269: invokevirtual 510	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   1272: istore 4
    //   1274: iload 4
    //   1276: iconst_5
    //   1277: if_icmple +115 -> 1392
    //   1280: aload_1
    //   1281: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1284: sipush 223
    //   1287: ldc_w 884
    //   1290: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1293: aload_1
    //   1294: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1297: sipush -553
    //   1300: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1303: aload_0
    //   1304: aload_1
    //   1305: invokespecial 844	com/tencent/smtt/sdk/p:F	(Landroid/content/Context;)V
    //   1308: aload_1
    //   1309: invokestatic 886	com/tencent/smtt/sdk/m:e	(Landroid/content/Context;)V
    //   1312: aload_1
    //   1313: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1316: getfield 890	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1319: ldc_w 892
    //   1322: iconst_1
    //   1323: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1326: invokeinterface 903 3 0
    //   1331: pop
    //   1332: aload_1
    //   1333: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1336: getfield 890	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1339: ldc_w 905
    //   1342: iconst_1
    //   1343: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1346: invokeinterface 903 3 0
    //   1351: pop
    //   1352: aload_1
    //   1353: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1356: invokevirtual 907	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1359: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1362: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1365: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1368: invokeinterface 522 1 0
    //   1373: aload_0
    //   1374: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1377: return
    //   1378: astore_1
    //   1379: aload_1
    //   1380: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1383: return
    //   1384: astore_1
    //   1385: aload_1
    //   1386: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1389: goto -16 -> 1373
    //   1392: aload_1
    //   1393: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1396: iload 4
    //   1398: iconst_1
    //   1399: iadd
    //   1400: invokevirtual 909	com/tencent/smtt/sdk/n:d	(I)V
    //   1403: ldc 139
    //   1405: ldc_w 911
    //   1408: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1411: invokestatic 914	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1414: getfield 193	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1417: ldc_w 916
    //   1420: iconst_0
    //   1421: invokeinterface 201 3 0
    //   1426: istore 4
    //   1428: aload_0
    //   1429: aload_1
    //   1430: invokevirtual 208	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;)I
    //   1433: ifeq +343 -> 1776
    //   1436: aload_1
    //   1437: ldc_w 918
    //   1440: aconst_null
    //   1441: invokestatic 921	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1444: astore 14
    //   1446: aload 14
    //   1448: ifnull +980 -> 2428
    //   1451: aload 14
    //   1453: instanceof 894
    //   1456: ifeq +972 -> 2428
    //   1459: aload 14
    //   1461: checkcast 894	java/lang/Boolean
    //   1464: invokevirtual 924	java/lang/Boolean:booleanValue	()Z
    //   1467: istore 13
    //   1469: iload 13
    //   1471: ifeq +305 -> 1776
    //   1474: new 926	android/os/Bundle
    //   1477: dup
    //   1478: invokespecial 927	android/os/Bundle:<init>	()V
    //   1481: astore 14
    //   1483: aload 14
    //   1485: ldc_w 929
    //   1488: iload 4
    //   1490: invokevirtual 931	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1493: aload_1
    //   1494: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1497: ifeq +90 -> 1587
    //   1500: aload 14
    //   1502: ldc_w 933
    //   1505: aload_0
    //   1506: aload_1
    //   1507: invokevirtual 563	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   1510: invokevirtual 936	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1513: invokevirtual 939	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1516: aload_1
    //   1517: ldc_w 941
    //   1520: aload 14
    //   1522: invokestatic 921	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1525: astore 14
    //   1527: aload 14
    //   1529: ifnonnull +99 -> 1628
    //   1532: ldc 139
    //   1534: ldc_w 943
    //   1537: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1540: aload_1
    //   1541: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1544: sipush 222
    //   1547: ldc_w 945
    //   1550: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1553: iload 7
    //   1555: istore 4
    //   1557: iload 4
    //   1559: ifne +217 -> 1776
    //   1562: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1565: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1568: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1571: invokeinterface 522 1 0
    //   1576: aload_0
    //   1577: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1580: return
    //   1581: astore_1
    //   1582: aload_1
    //   1583: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1586: return
    //   1587: aload 14
    //   1589: ldc_w 933
    //   1592: aload_0
    //   1593: aload_1
    //   1594: iconst_0
    //   1595: invokevirtual 277	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   1598: invokevirtual 936	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1601: invokevirtual 939	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1604: goto -88 -> 1516
    //   1607: astore_1
    //   1608: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1611: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1614: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1617: invokeinterface 522 1 0
    //   1622: aload_0
    //   1623: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1626: aload_1
    //   1627: athrow
    //   1628: aload 14
    //   1630: instanceof 894
    //   1633: ifeq +55 -> 1688
    //   1636: aload 14
    //   1638: checkcast 894	java/lang/Boolean
    //   1641: invokevirtual 924	java/lang/Boolean:booleanValue	()Z
    //   1644: ifeq +17 -> 1661
    //   1647: ldc 139
    //   1649: ldc_w 947
    //   1652: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1655: iconst_1
    //   1656: istore 4
    //   1658: goto +790 -> 2448
    //   1661: ldc 139
    //   1663: ldc_w 949
    //   1666: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1669: aload_1
    //   1670: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1673: sipush 222
    //   1676: ldc_w 949
    //   1679: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1682: iconst_0
    //   1683: istore 4
    //   1685: goto +763 -> 2448
    //   1688: aload 14
    //   1690: instanceof 926
    //   1693: ifeq +9 -> 1702
    //   1696: iconst_1
    //   1697: istore 4
    //   1699: goto -142 -> 1557
    //   1702: iload 7
    //   1704: istore 4
    //   1706: aload 14
    //   1708: instanceof 355
    //   1711: ifeq -154 -> 1557
    //   1714: ldc 139
    //   1716: new 235	java/lang/StringBuilder
    //   1719: dup
    //   1720: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1723: ldc_w 951
    //   1726: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: aload 14
    //   1731: checkcast 355	java/lang/Throwable
    //   1734: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1737: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1743: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1746: aload_1
    //   1747: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1750: sipush 222
    //   1753: aload 14
    //   1755: checkcast 355	java/lang/Throwable
    //   1758: invokevirtual 758	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1761: iload 7
    //   1763: istore 4
    //   1765: goto -208 -> 1557
    //   1768: astore_1
    //   1769: aload_1
    //   1770: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1773: goto -197 -> 1576
    //   1776: ldc 139
    //   1778: ldc_w 953
    //   1781: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1784: aload_1
    //   1785: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1788: iload 8
    //   1790: iconst_1
    //   1791: invokevirtual 341	com/tencent/smtt/sdk/n:c	(II)V
    //   1794: iload 8
    //   1796: istore 4
    //   1798: iload 5
    //   1800: iconst_2
    //   1801: if_icmpge +568 -> 2369
    //   1804: iload 6
    //   1806: ifeq +222 -> 2028
    //   1809: aload_1
    //   1810: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1813: ldc_w 955
    //   1816: invokevirtual 506	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   1819: istore 5
    //   1821: iload 5
    //   1823: bipush 10
    //   1825: if_icmple +192 -> 2017
    //   1828: aload_1
    //   1829: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1832: sipush 208
    //   1835: ldc_w 957
    //   1838: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1841: aload_1
    //   1842: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1845: sipush -514
    //   1848: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1851: aload_0
    //   1852: aload_1
    //   1853: invokespecial 844	com/tencent/smtt/sdk/p:F	(Landroid/content/Context;)V
    //   1856: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1859: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1862: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1865: invokeinterface 522 1 0
    //   1870: aload_0
    //   1871: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1874: return
    //   1875: astore_1
    //   1876: aload_1
    //   1877: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1880: return
    //   1881: iload 8
    //   1883: istore 4
    //   1885: aload_1
    //   1886: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1889: ifeq -91 -> 1798
    //   1892: aload_2
    //   1893: ifnonnull +80 -> 1973
    //   1896: aload_1
    //   1897: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1900: ldc_w 850
    //   1903: invokevirtual 853	com/tencent/smtt/sdk/n:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1906: astore 15
    //   1908: aload 15
    //   1910: astore 14
    //   1912: aload 15
    //   1914: ifnonnull +62 -> 1976
    //   1917: aload_1
    //   1918: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1921: sipush 202
    //   1924: ldc_w 855
    //   1927: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1930: aload_1
    //   1931: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1934: sipush -511
    //   1937: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1940: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1943: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1946: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1949: invokeinterface 522 1 0
    //   1954: aload_0
    //   1955: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1958: return
    //   1959: astore_1
    //   1960: aload_1
    //   1961: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1964: return
    //   1965: astore_1
    //   1966: aload_1
    //   1967: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   1970: goto -16 -> 1954
    //   1973: aload_2
    //   1974: astore 14
    //   1976: aload_0
    //   1977: aload_1
    //   1978: new 286	java/io/File
    //   1981: dup
    //   1982: aload 14
    //   1984: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   1987: iconst_1
    //   1988: invokespecial 866	com/tencent/smtt/sdk/p:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1991: istore 13
    //   1993: iload 8
    //   1995: istore 4
    //   1997: iload 13
    //   1999: ifne -201 -> 1798
    //   2002: iload 8
    //   2004: istore 4
    //   2006: goto -208 -> 1798
    //   2009: astore_1
    //   2010: aload_1
    //   2011: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   2014: goto -144 -> 1870
    //   2017: aload_1
    //   2018: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   2021: iload 5
    //   2023: iconst_1
    //   2024: iadd
    //   2025: invokevirtual 959	com/tencent/smtt/sdk/n:a	(I)V
    //   2028: aload_1
    //   2029: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2032: sipush -549
    //   2035: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2038: aload_0
    //   2039: aload_1
    //   2040: iconst_0
    //   2041: invokespecial 962	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;I)Z
    //   2044: ifne +46 -> 2090
    //   2047: aload_1
    //   2048: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2051: sipush -515
    //   2054: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2057: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2060: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2063: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2066: invokeinterface 522 1 0
    //   2071: aload_0
    //   2072: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   2075: return
    //   2076: astore_1
    //   2077: aload_1
    //   2078: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   2081: return
    //   2082: astore_1
    //   2083: aload_1
    //   2084: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   2087: goto -16 -> 2071
    //   2090: aload_1
    //   2091: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   2094: iload 4
    //   2096: iconst_2
    //   2097: invokevirtual 341	com/tencent/smtt/sdk/n:c	(II)V
    //   2100: ldc 139
    //   2102: ldc_w 964
    //   2105: iconst_1
    //   2106: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2109: aload_1
    //   2110: invokestatic 965	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)V
    //   2113: aload_1
    //   2114: invokestatic 966	com/tencent/smtt/sdk/m:b	(Landroid/content/Context;)V
    //   2117: ldc 139
    //   2119: new 235	java/lang/StringBuilder
    //   2122: dup
    //   2123: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   2126: ldc_w 968
    //   2129: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: iload_3
    //   2133: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2136: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2139: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2142: aload_1
    //   2143: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2146: sipush -516
    //   2149: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2152: getstatic 476	android/os/Build$VERSION:SDK_INT	I
    //   2155: bipush 11
    //   2157: if_icmplt +137 -> 2294
    //   2160: aload_1
    //   2161: ldc_w 478
    //   2164: iconst_4
    //   2165: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2168: astore 14
    //   2170: aload 14
    //   2172: invokeinterface 660 1 0
    //   2177: astore 14
    //   2179: aload 14
    //   2181: ldc_w 662
    //   2184: iconst_0
    //   2185: invokeinterface 668 3 0
    //   2190: pop
    //   2191: aload 14
    //   2193: ldc_w 670
    //   2196: iconst_0
    //   2197: invokeinterface 668 3 0
    //   2202: pop
    //   2203: aload 14
    //   2205: ldc_w 672
    //   2208: iload_3
    //   2209: invokeinterface 668 3 0
    //   2214: pop
    //   2215: aload 14
    //   2217: invokeinterface 675 1 0
    //   2222: pop
    //   2223: aload_1
    //   2224: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2227: sipush -517
    //   2230: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2233: iload_3
    //   2234: ldc_w 710
    //   2237: if_icmpne +10 -> 2247
    //   2240: aload_0
    //   2241: iload_3
    //   2242: aload_2
    //   2243: aload_1
    //   2244: invokespecial 970	com/tencent/smtt/sdk/p:a	(ILjava/lang/String;Landroid/content/Context;)V
    //   2247: aload_0
    //   2248: getfield 121	com/tencent/smtt/sdk/p:k	Z
    //   2251: ifeq +100 -> 2351
    //   2254: aload_1
    //   2255: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2258: aload_0
    //   2259: aload_1
    //   2260: invokespecial 973	com/tencent/smtt/sdk/p:v	(Landroid/content/Context;)I
    //   2263: ldc_w 654
    //   2266: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2269: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2272: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2275: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2278: invokeinterface 522 1 0
    //   2283: aload_0
    //   2284: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   2287: return
    //   2288: astore_1
    //   2289: aload_1
    //   2290: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   2293: return
    //   2294: aload_1
    //   2295: ldc_w 478
    //   2298: iconst_0
    //   2299: invokevirtual 482	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2302: astore 14
    //   2304: goto -134 -> 2170
    //   2307: astore 14
    //   2309: ldc 139
    //   2311: new 235	java/lang/StringBuilder
    //   2314: dup
    //   2315: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   2318: ldc_w 975
    //   2321: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: aload 14
    //   2326: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2329: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2332: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2335: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2338: aload_1
    //   2339: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2342: sipush -518
    //   2345: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2348: goto -115 -> 2233
    //   2351: aload_1
    //   2352: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2355: aload_0
    //   2356: aload_1
    //   2357: invokespecial 973	com/tencent/smtt/sdk/p:v	(Landroid/content/Context;)I
    //   2360: ldc_w 682
    //   2363: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2366: goto -97 -> 2269
    //   2369: iload 5
    //   2371: iconst_2
    //   2372: if_icmpne -103 -> 2269
    //   2375: getstatic 513	com/tencent/smtt/sdk/QbSdk:n	Lcom/tencent/smtt/sdk/TbsListener;
    //   2378: sipush 200
    //   2381: invokeinterface 518 2 0
    //   2386: goto -117 -> 2269
    //   2389: astore_1
    //   2390: aload_1
    //   2391: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   2394: goto -111 -> 2283
    //   2397: astore_2
    //   2398: aload_2
    //   2399: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   2402: goto -780 -> 1622
    //   2405: astore_2
    //   2406: aload_2
    //   2407: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   2410: goto -784 -> 1626
    //   2413: aload_1
    //   2414: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2417: sipush -519
    //   2420: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2423: aload_0
    //   2424: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   2427: return
    //   2428: iconst_0
    //   2429: istore 13
    //   2431: goto -962 -> 1469
    //   2434: iload 4
    //   2436: ifle -1839 -> 597
    //   2439: iload_3
    //   2440: iload 4
    //   2442: if_icmple -1845 -> 597
    //   2445: goto -1853 -> 592
    //   2448: goto -891 -> 1557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2451	0	this	p
    //   0	2451	1	paramContext	Context
    //   0	2451	2	paramString	String
    //   0	2451	3	paramInt	int
    //   490	1953	4	i1	int
    //   499	1874	5	i2	int
    //   611	1194	6	i3	int
    //   4	1758	7	i4	int
    //   1	2002	8	i5	int
    //   302	35	9	l1	long
    //   311	37	11	l2	long
    //   431	1999	13	bool	boolean
    //   209	2094	14	localObject	Object
    //   2307	18	14	localThrowable	Throwable
    //   922	991	15	str	String
    // Exception table:
    //   from	to	target	type
    //   815	819	820	java/lang/Exception
    //   801	815	889	java/lang/Exception
    //   970	974	975	java/lang/Exception
    //   956	970	981	java/lang/Exception
    //   1069	1073	1074	java/lang/Exception
    //   1055	1069	1080	java/lang/Exception
    //   1175	1179	1180	java/lang/Exception
    //   1161	1175	1186	java/lang/Exception
    //   1238	1242	1243	java/lang/Exception
    //   1224	1238	1249	java/lang/Exception
    //   1373	1377	1378	java/lang/Exception
    //   1359	1373	1384	java/lang/Exception
    //   1576	1580	1581	java/lang/Exception
    //   480	578	1607	finally
    //   592	597	1607	finally
    //   597	665	1607	finally
    //   676	685	1607	finally
    //   688	724	1607	finally
    //   730	749	1607	finally
    //   754	766	1607	finally
    //   773	801	1607	finally
    //   865	879	1607	finally
    //   897	908	1607	finally
    //   912	924	1607	finally
    //   933	956	1607	finally
    //   992	1027	1607	finally
    //   1032	1055	1607	finally
    //   1088	1161	1607	finally
    //   1194	1224	1607	finally
    //   1262	1274	1607	finally
    //   1280	1359	1607	finally
    //   1392	1403	1607	finally
    //   1403	1446	1607	finally
    //   1451	1469	1607	finally
    //   1474	1516	1607	finally
    //   1516	1527	1607	finally
    //   1532	1553	1607	finally
    //   1587	1604	1607	finally
    //   1628	1655	1607	finally
    //   1661	1682	1607	finally
    //   1688	1696	1607	finally
    //   1706	1761	1607	finally
    //   1776	1794	1607	finally
    //   1809	1821	1607	finally
    //   1828	1856	1607	finally
    //   1885	1892	1607	finally
    //   1896	1908	1607	finally
    //   1917	1940	1607	finally
    //   1976	1993	1607	finally
    //   2017	2028	1607	finally
    //   2028	2057	1607	finally
    //   2090	2170	1607	finally
    //   2170	2233	1607	finally
    //   2240	2247	1607	finally
    //   2247	2269	1607	finally
    //   2294	2304	1607	finally
    //   2309	2348	1607	finally
    //   2351	2366	1607	finally
    //   2375	2386	1607	finally
    //   1562	1576	1768	java/lang/Exception
    //   1870	1874	1875	java/lang/Exception
    //   1954	1958	1959	java/lang/Exception
    //   1940	1954	1965	java/lang/Exception
    //   1856	1870	2009	java/lang/Exception
    //   2071	2075	2076	java/lang/Exception
    //   2057	2071	2082	java/lang/Exception
    //   2283	2287	2288	java/lang/Exception
    //   2170	2233	2307	java/lang/Throwable
    //   2269	2283	2389	java/lang/Exception
    //   1608	1622	2397	java/lang/Exception
    //   1622	1626	2405	java/lang/Exception
  }
  
  private boolean b(Context paramContext, File paramFile)
  {
    return a(paramContext, paramFile, false);
  }
  
  /* Error */
  private int c(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: aload_2
    //   5: invokestatic 979	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   8: astore 9
    //   10: ldc 139
    //   12: new 235	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 981
    //   22: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload 9
    //   27: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload 9
    //   38: ldc_w 983
    //   41: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   44: istore_3
    //   45: iload_3
    //   46: ifne +690 -> 736
    //   49: aload_2
    //   50: ldc_w 987
    //   53: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 9
    //   58: aload_2
    //   59: ldc_w 992
    //   62: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   65: istore 7
    //   67: aload_2
    //   68: ldc_w 994
    //   71: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   74: istore_3
    //   75: iload_3
    //   76: iconst_1
    //   77: if_icmpne +437 -> 514
    //   80: new 286	java/io/File
    //   83: dup
    //   84: aload_1
    //   85: ldc_w 304
    //   88: iconst_4
    //   89: iconst_1
    //   90: invokestatic 997	com/tencent/smtt/utils/FileUtil:a	(Landroid/content/Context;Ljava/lang/String;IZ)Ljava/lang/String;
    //   93: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_1
    //   98: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   101: astore 9
    //   103: aload 9
    //   105: getfield 193	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   108: ldc_w 999
    //   111: iconst_0
    //   112: invokeinterface 201 3 0
    //   117: istore 6
    //   119: aload_2
    //   120: invokevirtual 597	java/io/File:listFiles	()[Ljava/io/File;
    //   123: astore 10
    //   125: iconst_0
    //   126: iload 6
    //   128: invokestatic 1002	com/tencent/smtt/utils/a:a	(ZI)Ljava/lang/String;
    //   131: invokestatic 1008	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   134: astore 11
    //   136: aload 10
    //   138: arraylength
    //   139: istore 8
    //   141: iconst_0
    //   142: istore 4
    //   144: iload 4
    //   146: iload 8
    //   148: if_icmpge +51 -> 199
    //   151: aload 10
    //   153: iload 4
    //   155: aaload
    //   156: astore 12
    //   158: aload 11
    //   160: aload 12
    //   162: invokevirtual 600	java/io/File:getName	()Ljava/lang/String;
    //   165: invokevirtual 1012	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   168: invokevirtual 1017	java/util/regex/Matcher:find	()Z
    //   171: ifeq +622 -> 793
    //   174: aload 12
    //   176: invokevirtual 1020	java/io/File:isFile	()Z
    //   179: ifeq +614 -> 793
    //   182: aload 12
    //   184: invokevirtual 593	java/io/File:exists	()Z
    //   187: ifeq +606 -> 793
    //   190: aload 12
    //   192: invokevirtual 363	java/io/File:delete	()Z
    //   195: pop
    //   196: goto +597 -> 793
    //   199: new 286	java/io/File
    //   202: dup
    //   203: aload_2
    //   204: new 235	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   211: iconst_0
    //   212: iload 6
    //   214: invokestatic 1002	com/tencent/smtt/utils/a:a	(ZI)Ljava/lang/String;
    //   217: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 1022
    //   223: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 9
    //   228: getfield 193	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   231: ldc_w 1024
    //   234: iconst_0
    //   235: invokeinterface 201 3 0
    //   240: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   249: astore_2
    //   250: aload_2
    //   251: ifnull +213 -> 464
    //   254: aload_2
    //   255: invokevirtual 593	java/io/File:exists	()Z
    //   258: ifeq +206 -> 464
    //   261: aload_1
    //   262: iload 6
    //   264: invokestatic 1028	com/tencent/smtt/sdk/TbsShareManager:getTbsStableCoreVersion	(Landroid/content/Context;I)I
    //   267: istore 4
    //   269: new 235	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 1030
    //   279: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload 4
    //   284: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: astore_2
    //   291: aload_1
    //   292: ldc_w 1032
    //   295: new 235	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   302: aload_2
    //   303: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc_w 1034
    //   309: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 1036
    //   315: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: iload 7
    //   320: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 1039	com/tencent/smtt/utils/q:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   329: ldc 139
    //   331: new 235	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 1041
    //   341: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: iload_3
    //   345: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: ldc_w 1043
    //   351: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: iload 7
    //   356: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc_w 1045
    //   362: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 4
    //   367: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: iload 7
    //   378: iload 4
    //   380: if_icmpeq +227 -> 607
    //   383: ldc 139
    //   385: new 235	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 1047
    //   395: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: iload 7
    //   400: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: ldc_w 1049
    //   406: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: iload 4
    //   411: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload_1
    //   421: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   424: sipush 240
    //   427: new 235	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 1051
    //   437: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload 7
    //   442: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 1053
    //   448: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: iload 4
    //   453: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   462: iconst_1
    //   463: ireturn
    //   464: aload_2
    //   465: invokevirtual 1056	java/io/File:createNewFile	()Z
    //   468: pop
    //   469: goto -208 -> 261
    //   472: astore_2
    //   473: aload_2
    //   474: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   477: aload_1
    //   478: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   481: sipush 239
    //   484: new 235	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 1058
    //   494: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_2
    //   498: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   501: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   510: iconst_1
    //   511: istore_3
    //   512: iload_3
    //   513: ireturn
    //   514: aload_0
    //   515: new 286	java/io/File
    //   518: dup
    //   519: aload 9
    //   521: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   524: invokevirtual 1061	com/tencent/smtt/sdk/p:a	(Ljava/io/File;)I
    //   527: istore 6
    //   529: iload 6
    //   531: istore 4
    //   533: aload_1
    //   534: invokestatic 163	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   537: ifeq -208 -> 329
    //   540: new 235	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 1030
    //   550: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: iload 6
    //   555: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: astore_2
    //   562: aload_1
    //   563: ldc_w 1032
    //   566: new 235	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   573: aload_2
    //   574: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 1034
    //   580: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: ldc_w 1036
    //   586: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iload 7
    //   591: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 1063	com/tencent/smtt/utils/q:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   600: iload 6
    //   602: istore 4
    //   604: goto -275 -> 329
    //   607: iload_3
    //   608: iconst_1
    //   609: if_icmpne +31 -> 640
    //   612: aload_1
    //   613: ldc_w 1065
    //   616: new 235	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 1067
    //   626: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: iload 4
    //   631: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 1039	com/tencent/smtt/utils/q:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   640: aload_1
    //   641: invokestatic 163	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   644: ifeq +31 -> 675
    //   647: aload_1
    //   648: ldc_w 1065
    //   651: new 235	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 1067
    //   661: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: iload 4
    //   666: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   669: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokestatic 1063	com/tencent/smtt/utils/q:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   675: aload_1
    //   676: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   679: ifeq +30 -> 709
    //   682: ldc 139
    //   684: ldc_w 1069
    //   687: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: aload_1
    //   691: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   694: sipush 237
    //   697: ldc_w 618
    //   700: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   703: iload 5
    //   705: istore_3
    //   706: goto -194 -> 512
    //   709: ldc 139
    //   711: ldc_w 1071
    //   714: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: aload_1
    //   718: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   721: sipush 236
    //   724: ldc_w 618
    //   727: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   730: iload 5
    //   732: istore_3
    //   733: goto -221 -> 512
    //   736: aload_2
    //   737: ldc_w 987
    //   740: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   743: astore_2
    //   744: aload_2
    //   745: invokestatic 1077	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   748: ifne +14 -> 762
    //   751: new 286	java/io/File
    //   754: dup
    //   755: aload_2
    //   756: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   759: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   762: aload_1
    //   763: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   766: iload_3
    //   767: new 235	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   774: ldc_w 1079
    //   777: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: iload_3
    //   781: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   790: goto -280 -> 510
    //   793: iload 4
    //   795: iconst_1
    //   796: iadd
    //   797: istore 4
    //   799: goto -655 -> 144
    //   802: astore_2
    //   803: iconst_0
    //   804: istore_3
    //   805: goto -730 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	p
    //   0	808	1	paramContext	Context
    //   0	808	2	paramBundle	Bundle
    //   44	761	3	i1	int
    //   142	656	4	i2	int
    //   1	730	5	i3	int
    //   117	484	6	i4	int
    //   65	525	7	i5	int
    //   139	10	8	i6	int
    //   8	512	9	localObject	Object
    //   123	29	10	arrayOfFile	File[]
    //   134	25	11	localPattern	java.util.regex.Pattern
    //   156	35	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	45	472	java/lang/Exception
    //   49	67	472	java/lang/Exception
    //   67	75	472	java/lang/Exception
    //   80	141	472	java/lang/Exception
    //   158	196	472	java/lang/Exception
    //   199	250	472	java/lang/Exception
    //   254	261	472	java/lang/Exception
    //   261	329	472	java/lang/Exception
    //   329	376	472	java/lang/Exception
    //   383	462	472	java/lang/Exception
    //   464	469	472	java/lang/Exception
    //   514	529	472	java/lang/Exception
    //   533	600	472	java/lang/Exception
    //   612	640	472	java/lang/Exception
    //   640	675	472	java/lang/Exception
    //   675	703	472	java/lang/Exception
    //   709	730	472	java/lang/Exception
    //   736	762	472	java/lang/Exception
    //   762	790	472	java/lang/Exception
    //   67	75	802	java/lang/Throwable
  }
  
  /* Error */
  private boolean c(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: new 18	com/tencent/smtt/sdk/p$5
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 1082	com/tencent/smtt/sdk/p$5:<init>	(Lcom/tencent/smtt/sdk/p;)V
    //   9: invokevirtual 1085	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: arraylength
    //   17: istore 4
    //   19: getstatic 476	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 16
    //   24: if_icmpge +33 -> 57
    //   27: aload_1
    //   28: invokevirtual 1088	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: ifnull +26 -> 57
    //   34: aload_1
    //   35: invokevirtual 1088	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: ldc_w 1090
    //   41: invokevirtual 1093	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifeq +9 -> 57
    //   51: ldc2_w 1094
    //   54: invokestatic 1099	java/lang/Thread:sleep	(J)V
    //   57: aload_1
    //   58: invokevirtual 1103	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   61: astore 7
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: iload 4
    //   68: if_icmpge +63 -> 131
    //   71: ldc 139
    //   73: new 235	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 1105
    //   83: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 6
    //   88: iload_3
    //   89: aaload
    //   90: invokevirtual 936	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: new 1107	dalvik/system/DexClassLoader
    //   105: dup
    //   106: aload 6
    //   108: iload_3
    //   109: aaload
    //   110: invokevirtual 936	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: aload_2
    //   114: invokevirtual 936	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   117: aconst_null
    //   118: aload 7
    //   120: invokespecial 1110	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   123: pop
    //   124: iload_3
    //   125: iconst_1
    //   126: iadd
    //   127: istore_3
    //   128: goto -63 -> 65
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   138: aload_1
    //   139: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   142: sipush 209
    //   145: aload_2
    //   146: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   149: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   152: ldc 139
    //   154: ldc_w 1112
    //   157: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore 7
    //   164: goto -107 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	p
    //   0	167	1	paramContext	Context
    //   0	167	2	paramFile	File
    //   64	64	3	i1	int
    //   17	52	4	i2	int
    //   44	3	5	bool	boolean
    //   12	95	6	arrayOfFile	File[]
    //   61	58	7	localClassLoader	ClassLoader
    //   162	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	46	133	java/lang/Exception
    //   57	63	133	java/lang/Exception
    //   71	124	133	java/lang/Exception
    //   51	57	162	java/lang/Exception
  }
  
  private boolean c(Context paramContext, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool3 = true;
    label47:
    try
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
      bool2 = bool4;
      try
      {
        boolean bool6 = u(paramContext);
        if (bool6) {
          break label47;
        }
        bool1 = bool5;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            i1 = n.a(paramContext).b("tpatch_status");
            i2 = a(false, paramContext);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + i1);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + i2);
            if (i1 != 1) {
              break label319;
            }
            if (i2 == 0)
            {
              TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
              z(paramContext);
              paramBoolean = bool3;
            }
          }
          finally
          {
            bool2 = bool4;
            i.unlock();
            bool2 = bool4;
          }
          try
          {
            i.unlock();
            bool1 = paramBoolean;
            bool2 = bool1;
            b();
          }
          catch (Throwable localThrowable2)
          {
            bool1 = paramBoolean;
            continue;
          }
          localThrowable1 = localThrowable1;
          bool1 = bool2;
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(215, localThrowable1.toString());
          QbSdk.a(paramContext, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(localThrowable1));
        }
      }
      return bool1;
    }
    finally {}
    boolean bool2 = bool4;
    bool5 = i.tryLock();
    bool2 = bool4;
    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + bool5);
    if (bool5) {}
    for (;;)
    {
      int i1;
      int i2;
      if (paramBoolean)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
        z(paramContext);
        paramBoolean = bool3;
      }
      else
      {
        label319:
        paramBoolean = false;
      }
    }
  }
  
  private boolean d(Context paramContext, File paramFile)
  {
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = f.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        return false;
      }
      paramFile = paramFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return paramAnonymousFile.getName().endsWith(".jar");
        }
      });
      int i2 = paramFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2 = paramFile[i1];
        localObject2 = ((File)localObject2).getName().substring(0, ((File)localObject2).getName().length() - 4);
        localObject3 = ((String)localObject1).replaceAll("tbs_sdk_extension_dex", (String)localObject2);
        localObject2 = "/system/bin/dex2oat " + (String)localObject3 + " --dex-location=" + a().r(paramContext) + File.separator + (String)localObject2 + ".jar";
        Runtime.getRuntime().exec((String)localObject2).waitFor();
        i1 += 1;
      }
      return true;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, paramFile);
    }
    return false;
  }
  
  /* Error */
  private boolean d(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_1
    //   10: istore 7
    //   12: aload_0
    //   13: monitorenter
    //   14: ldc 139
    //   16: ldc_w 1187
    //   19: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload 8
    //   24: istore 6
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 491	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   31: istore 10
    //   33: iload 10
    //   35: ifne +12 -> 47
    //   38: iload 9
    //   40: istore 5
    //   42: aload_0
    //   43: monitorexit
    //   44: iload 5
    //   46: ireturn
    //   47: iload 8
    //   49: istore 6
    //   51: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   54: invokevirtual 1116	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   57: istore 9
    //   59: iload 8
    //   61: istore 6
    //   63: ldc 139
    //   65: new 235	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 1189
    //   75: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload 9
    //   80: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   83: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: iload 9
    //   91: ifeq +109 -> 200
    //   94: aload_1
    //   95: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   98: ldc_w 508
    //   101: invokevirtual 510	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   104: istore_3
    //   105: aload_0
    //   106: iconst_0
    //   107: aload_1
    //   108: invokevirtual 1123	com/tencent/smtt/sdk/p:a	(ZLandroid/content/Context;)I
    //   111: istore 4
    //   113: ldc 139
    //   115: new 235	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 1191
    //   125: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: iload_3
    //   129: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: ldc 139
    //   140: new 235	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1193
    //   150: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 4
    //   155: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iload_3
    //   165: iconst_1
    //   166: if_icmpne +156 -> 322
    //   169: iload 4
    //   171: ifne +100 -> 271
    //   174: ldc 139
    //   176: ldc_w 1195
    //   179: iconst_1
    //   180: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   183: aload_0
    //   184: aload_1
    //   185: invokespecial 1197	com/tencent/smtt/sdk/p:A	(Landroid/content/Context;)V
    //   188: iload 7
    //   190: istore_2
    //   191: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   194: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   197: iload_2
    //   198: istore 5
    //   200: iload 5
    //   202: istore 6
    //   204: aload_0
    //   205: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   208: goto -166 -> 42
    //   211: astore 11
    //   213: iload 6
    //   215: istore 5
    //   217: aload_1
    //   218: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   221: sipush 215
    //   224: aload 11
    //   226: invokevirtual 1133	java/lang/Throwable:toString	()Ljava/lang/String;
    //   229: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   232: aload_1
    //   233: new 235	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 1199
    //   243: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 11
    //   248: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   251: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 351	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   260: goto -218 -> 42
    //   263: astore_1
    //   264: aload_1
    //   265: athrow
    //   266: astore_1
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    //   271: iload_2
    //   272: ifeq +50 -> 322
    //   275: ldc 139
    //   277: ldc_w 1201
    //   280: iconst_1
    //   281: invokestatic 370	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   284: aload_0
    //   285: aload_1
    //   286: invokespecial 1197	com/tencent/smtt/sdk/p:A	(Landroid/content/Context;)V
    //   289: iload 7
    //   291: istore_2
    //   292: goto -101 -> 191
    //   295: astore 11
    //   297: iload 8
    //   299: istore 6
    //   301: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   304: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   307: iload 8
    //   309: istore 6
    //   311: aload 11
    //   313: athrow
    //   314: astore 11
    //   316: iload_2
    //   317: istore 5
    //   319: goto -102 -> 217
    //   322: iconst_0
    //   323: istore_2
    //   324: goto -133 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	p
    //   0	327	1	paramContext	Context
    //   0	327	2	paramBoolean	boolean
    //   104	63	3	i1	int
    //   111	59	4	i2	int
    //   1	317	5	bool1	boolean
    //   24	286	6	bool2	boolean
    //   10	280	7	bool3	boolean
    //   4	304	8	bool4	boolean
    //   7	83	9	bool5	boolean
    //   31	3	10	bool6	boolean
    //   211	36	11	localThrowable1	Throwable
    //   295	17	11	localObject	Object
    //   314	1	11	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	33	211	java/lang/Throwable
    //   51	59	211	java/lang/Throwable
    //   63	89	211	java/lang/Throwable
    //   204	208	211	java/lang/Throwable
    //   301	307	211	java/lang/Throwable
    //   311	314	211	java/lang/Throwable
    //   26	33	263	finally
    //   51	59	263	finally
    //   63	89	263	finally
    //   191	197	263	finally
    //   204	208	263	finally
    //   217	260	263	finally
    //   301	307	263	finally
    //   311	314	263	finally
    //   14	22	266	finally
    //   264	266	266	finally
    //   94	164	295	finally
    //   174	188	295	finally
    //   275	289	295	finally
    //   191	197	314	java/lang/Throwable
  }
  
  private boolean e(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private boolean e(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (paramContext != null) {}
    label114:
    try
    {
      if ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)) {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(229, " ");
      }
      TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "canRenameTmpDir =" + paramBoolean);
      TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "#1#");
      bool2 = bool4;
      try
      {
        boolean bool6 = u(paramContext);
        if (bool6) {
          break label114;
        }
        bool1 = bool5;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            i1 = n.a(paramContext).c();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + i1);
            i2 = a(false, paramContext);
            if (i1 != 2) {
              break label373;
            }
            TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "#4# In Rename Logic");
            if (i2 == 0)
            {
              TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
              y(paramContext);
              paramBoolean = bool3;
            }
          }
          finally
          {
            bool2 = bool4;
            i.unlock();
            bool2 = bool4;
          }
          try
          {
            i.unlock();
            bool1 = paramBoolean;
            bool2 = bool1;
            b();
          }
          catch (Exception localException2)
          {
            bool1 = paramBoolean;
            continue;
          }
          localException1 = localException1;
          bool1 = bool2;
          QbSdk.a(paramContext, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + localException1);
          localException1.printStackTrace();
        }
      }
      return bool1;
    }
    finally {}
    boolean bool2 = bool4;
    TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "#2# getInstallFileLock Success!!");
    bool2 = bool4;
    bool5 = i.tryLock();
    bool2 = bool4;
    TbsLog.i("TbsInstaller", "enableTbsCoreFromUnzip", "locked=" + bool5);
    if (bool5) {}
    for (;;)
    {
      int i1;
      int i2;
      if (paramBoolean)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
        y(paramContext);
        paramBoolean = bool3;
      }
      else
      {
        label373:
        paramBoolean = false;
      }
    }
  }
  
  private boolean f(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  private void g(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
    }
    for (;;)
    {
      return;
      try
      {
        File localFile = new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf");
        if (paramBoolean)
        {
          if ((localFile != null) && (localFile.exists())) {
            continue;
          }
          localFile.createNewFile();
        }
      }
      catch (Exception localException)
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + localException.getMessage() + " Exception cause is " + localException.getCause());
        return;
      }
    }
    FileUtil.b(localException);
  }
  
  private void h(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QbSdk.setTBSInstallingStatus(false);
      return;
      if (TbsDownloader.a(paramContext))
      {
        i(paramContext, 6);
      }
      else
      {
        g(paramContext, true);
        paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        n.a(paramContext).b(paramInt, 1);
      }
    }
  }
  
  private void i(Context paramContext, int paramInt)
  {
    File localFile1 = a().f(paramContext, paramInt);
    a().g(paramContext, true);
    File localFile2 = q(paramContext);
    FileUtil.a(localFile2, true);
    localFile1.renameTo(localFile2);
    TbsShareManager.b(paramContext);
  }
  
  private boolean j(Context paramContext, int paramInt)
  {
    boolean bool = true;
    int i3 = 0;
    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + paramInt);
    switch (paramInt)
    {
    default: 
    case 0: 
      try
      {
        TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: " + paramInt);
        return false;
      }
      catch (Exception localException)
      {
        File localFile1;
        String str;
        localException.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(209, localException.toString());
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
        return true;
      }
      if (TbsDownloader.a(paramContext)) {
        break label317;
      }
      localFile1 = f(paramContext, 0);
    }
    try
    {
      str = System.getProperty("java.vm.version");
      if (str == null) {
        break label320;
      }
      bool = str.startsWith("2");
      if (!bool) {
        break label320;
      }
      paramInt = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label132:
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, localThrowable);
        paramInt = 0;
        continue;
        if (paramInt == 0) {
          break;
        }
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
      }
      TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
      bool = c(paramContext, localFile2);
    }
    if (Build.VERSION.SDK_INT == 23) {}
    for (int i1 = 1;; i1 = 0)
    {
      bool = TbsDownloadConfig.getInstance(paramContext).mPreferences.getBoolean("tbs_stop_preoat", false);
      int i2 = i3;
      if (paramInt != 0)
      {
        i2 = i3;
        if (i1 != 0)
        {
          i2 = i3;
          if (!bool) {
            i2 = 1;
          }
        }
      }
      File localFile2;
      if ((i2 != 0) && (d(paramContext, localFile1)))
      {
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
        return true;
        localFile2 = f(paramContext, 1);
        break;
        localFile2 = r(paramContext);
        break;
      }
      label317:
      return bool;
      label320:
      paramInt = 0;
      break label132;
    }
  }
  
  static File t(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  private int v(Context paramContext)
  {
    int i1 = 1;
    if (n.a(paramContext).d() == 1) {}
    boolean bool;
    for (;;)
    {
      bool = TbsDownloader.a(paramContext);
      if (i1 == 0) {
        break label39;
      }
      if (!bool) {
        break;
      }
      return 234;
      i1 = 0;
    }
    return 221;
    label39:
    if (bool) {
      return 233;
    }
    return 200;
  }
  
  private static boolean w(Context paramContext)
  {
    if (paramContext == null)
    {
      TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#1#");
      return true;
    }
    try
    {
      if (new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf").exists())
      {
        TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#2#");
        return true;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#4#");
      return true;
    }
    TbsLog.i("TbsInstaller", "getTmpFolderCoreToRead", "#3#");
    return false;
  }
  
  private boolean x(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    l = FileUtil.f(paramContext);
    if (l == null)
    {
      TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
      return false;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
    return true;
  }
  
  private void y(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    for (;;)
    {
      try
      {
        B(paramContext);
        C(paramContext);
        TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
        TbsShareManager.a(paramContext);
        n.a(paramContext).a(0);
        n.a(paramContext).b(0);
        n.a(paramContext).d(0);
        n.a(paramContext).a("incrupdate_retry_num", 0);
        n.a(paramContext).c(0, 3);
        n.a(paramContext).a("");
        n.a(paramContext).a("tpatch_num", 0);
        n.a(paramContext).c(-1);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().i(paramContext)) || (i1 != a().j(paramContext))) {
            continue;
          }
          o(paramContext);
        }
      }
      catch (Throwable localThrowable)
      {
        int i1;
        localThrowable.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localThrowable.toString());
        TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        continue;
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().i(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().j(paramContext));
        continue;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
      }
      a.set(Integer.valueOf(0));
      o = 0;
      h(paramContext);
      return;
      TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
    }
  }
  
  private void z(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    for (;;)
    {
      try
      {
        B(paramContext);
        E(paramContext);
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
        n.a(paramContext).b(0, -1);
        n.a(paramContext).a("tpatch_num", 0);
        a.set(Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(242, "exception when renameing from tpatch:" + localException.toString());
        continue;
      }
      h(paramContext);
      return;
      TbsShareManager.a(paramContext);
    }
  }
  
  /* Error */
  int a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: ldc 139
    //   7: new 235	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 1337
    //   17: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 286	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: ldc_w 383
    //   38: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +14 -> 57
    //   46: aload_1
    //   47: invokevirtual 593	java/io/File:exists	()Z
    //   50: istore 4
    //   52: iload 4
    //   54: ifne +17 -> 71
    //   57: iconst_0
    //   58: ifeq +11 -> 69
    //   61: new 1339	java/lang/NullPointerException
    //   64: dup
    //   65: invokespecial 1340	java/lang/NullPointerException:<init>	()V
    //   68: athrow
    //   69: iload_3
    //   70: ireturn
    //   71: new 385	java/util/Properties
    //   74: dup
    //   75: invokespecial 386	java/util/Properties:<init>	()V
    //   78: astore 6
    //   80: new 388	java/io/BufferedInputStream
    //   83: dup
    //   84: new 390	java/io/FileInputStream
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   92: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   95: astore_1
    //   96: aload 6
    //   98: aload_1
    //   99: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   102: aload_1
    //   103: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   106: aload 6
    //   108: ldc_w 1342
    //   111: invokevirtual 1343	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 5
    //   116: aload 5
    //   118: ifnonnull +16 -> 134
    //   121: aload_1
    //   122: ifnull -53 -> 69
    //   125: aload_1
    //   126: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: iconst_0
    //   133: ireturn
    //   134: aload 5
    //   136: invokestatic 1346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   139: istore_2
    //   140: iload_2
    //   141: istore_3
    //   142: aload_1
    //   143: ifnull -74 -> 69
    //   146: aload_1
    //   147: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   150: iload_2
    //   151: ireturn
    //   152: astore_1
    //   153: iload_2
    //   154: ireturn
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull -90 -> 69
    //   162: aload_1
    //   163: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_1
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_1
    //   172: aload 5
    //   174: ifnull +8 -> 182
    //   177: aload 5
    //   179: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: iconst_0
    //   186: ireturn
    //   187: astore 5
    //   189: goto -7 -> 182
    //   192: astore 6
    //   194: aload_1
    //   195: astore 5
    //   197: aload 6
    //   199: astore_1
    //   200: goto -28 -> 172
    //   203: astore 5
    //   205: goto -47 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	p
    //   0	208	1	paramFile	File
    //   139	15	2	i1	int
    //   1	141	3	i2	int
    //   50	3	4	bool	boolean
    //   3	175	5	str	String
    //   187	1	5	localIOException	java.io.IOException
    //   195	1	5	localFile	File
    //   203	1	5	localException	Exception
    //   78	29	6	localProperties	java.util.Properties
    //   192	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   125	129	131	java/io/IOException
    //   146	150	152	java/io/IOException
    //   5	42	155	java/lang/Exception
    //   46	52	155	java/lang/Exception
    //   71	96	155	java/lang/Exception
    //   162	166	168	java/io/IOException
    //   5	42	171	finally
    //   46	52	171	finally
    //   71	96	171	finally
    //   61	69	184	java/io/IOException
    //   177	182	187	java/io/IOException
    //   96	116	192	finally
    //   134	140	192	finally
    //   96	116	203	java/lang/Exception
    //   134	140	203	java/lang/Exception
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iload_2
    //   7: ireturn
    //   8: aconst_null
    //   9: astore 5
    //   11: new 286	java/io/File
    //   14: dup
    //   15: new 286	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: ldc_w 383
    //   26: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +14 -> 45
    //   34: aload_1
    //   35: invokevirtual 593	java/io/File:exists	()Z
    //   38: istore 4
    //   40: iload 4
    //   42: ifne +18 -> 60
    //   45: iconst_0
    //   46: ifeq -40 -> 6
    //   49: new 1339	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 1340	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: astore_1
    //   58: iconst_0
    //   59: ireturn
    //   60: new 385	java/util/Properties
    //   63: dup
    //   64: invokespecial 386	java/util/Properties:<init>	()V
    //   67: astore 6
    //   69: new 388	java/io/BufferedInputStream
    //   72: dup
    //   73: new 390	java/io/FileInputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_1
    //   85: aload 6
    //   87: aload_1
    //   88: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   91: aload_1
    //   92: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   95: aload 6
    //   97: ldc_w 1342
    //   100: invokevirtual 1343	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 5
    //   105: aload 5
    //   107: ifnonnull +16 -> 123
    //   110: aload_1
    //   111: ifnull -105 -> 6
    //   114: aload_1
    //   115: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_1
    //   121: iconst_0
    //   122: ireturn
    //   123: aload 5
    //   125: invokestatic 1346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore_3
    //   129: iload_3
    //   130: istore_2
    //   131: aload_1
    //   132: ifnull -126 -> 6
    //   135: aload_1
    //   136: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   139: iload_3
    //   140: ireturn
    //   141: astore_1
    //   142: iload_3
    //   143: ireturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull -142 -> 6
    //   151: aload_1
    //   152: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_1
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: aload 5
    //   163: ifnull +8 -> 171
    //   166: aload 5
    //   168: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore 5
    //   175: goto -4 -> 171
    //   178: astore 6
    //   180: aload_1
    //   181: astore 5
    //   183: aload 6
    //   185: astore_1
    //   186: goto -25 -> 161
    //   189: astore 5
    //   191: goto -44 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	p
    //   0	194	1	paramString	String
    //   1	130	2	i1	int
    //   128	15	3	i2	int
    //   38	3	4	bool	boolean
    //   9	158	5	str1	String
    //   173	1	5	localIOException	java.io.IOException
    //   181	1	5	str2	String
    //   189	1	5	localException	Exception
    //   67	29	6	localProperties	java.util.Properties
    //   178	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	57	java/io/IOException
    //   114	118	120	java/io/IOException
    //   135	139	141	java/io/IOException
    //   11	30	144	java/lang/Exception
    //   34	40	144	java/lang/Exception
    //   60	85	144	java/lang/Exception
    //   151	155	157	java/io/IOException
    //   11	30	160	finally
    //   34	40	160	finally
    //   60	85	160	finally
    //   166	171	173	java/io/IOException
    //   85	105	178	finally
    //   123	129	178	finally
    //   85	105	189	java/lang/Exception
    //   123	129	189	java/lang/Exception
  }
  
  public int a(boolean paramBoolean, Context paramContext)
  {
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(j(paramContext)));
    }
    return ((Integer)a.get()).intValue();
  }
  
  File a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    File localFile = QbSdk.getTbsFolderDir(paramContext);
    paramContext = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      TbsLog.i("TbsInstaller", "type=" + paramInt + "needMakeDir=" + paramBoolean + "folder=" + paramContext);
      paramContext = new File(localFile, paramContext);
      if (paramContext == null) {
        break label201;
      }
      if (paramContext.isDirectory()) {
        break label199;
      }
      if (!paramBoolean) {
        break;
      }
      if (paramContext.mkdir()) {
        break label199;
      }
      TbsLog.i("TbsInstaller", "getCoreDir,mkdir false");
      return null;
      paramContext = "core_unzip_tmp";
      continue;
      paramContext = "core_unzip_tmp_decouple";
      continue;
      paramContext = "core_share_backup";
      continue;
      paramContext = "core_share_backup_tmp";
      continue;
      paramContext = "core_copy_tmp";
      continue;
      paramContext = "tpatch_tmp";
      continue;
      paramContext = "tpatch_decouple_tmp";
    }
    TbsLog.i("TbsInstaller", "getCoreDir,no need mkdir");
    return null;
    label199:
    return paramContext;
    label201:
    TbsLog.i("TbsInstaller", "getCoreDir,tmpTbsShareDir = null");
    return null;
  }
  
  File a(Context paramContext, File paramFile)
  {
    paramContext = new File(paramFile, "core_share_decouple");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    g(paramContext, true);
    n.a(paramContext).c(paramInt, 2);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    m.sendMessage(localMessage);
  }
  
  void a(Context paramContext, File paramFile, int paramInt)
  {
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + paramContext + "File=" + paramFile + "coreVersion=" + paramInt);
    if ((paramFile == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.obj = new Object[] { paramContext, paramFile, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i5 = 0;
    if (paramBoolean) {
      this.k = true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    if (!u(paramContext)) {
      return;
    }
    if (i.tryLock()) {}
    for (;;)
    {
      try
      {
        i4 = n.a(paramContext).c();
        i3 = n.a(paramContext).b();
        str = n.a(paramContext).d("install_apk_path");
        i1 = n.a(paramContext).c("copy_core_ver");
        i2 = n.a(paramContext).b("copy_status");
        i.unlock();
        b();
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + i4);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + i3);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + i1);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + i2);
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          c(paramContext, TbsShareManager.a(paramContext, false));
          return;
        }
      }
      finally
      {
        i.unlock();
      }
      int i6 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
      if ((i6 == 1) || (i6 == 2) || (i6 == 4)) {
        i5 = 1;
      }
      if ((i5 == 0) && (i6 != 0) && (i6 != 5))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("operation", 10001);
        a(paramContext, localBundle);
      }
      if ((i4 > -1) && (i4 < 2)) {
        a(paramContext, str, i3);
      }
      if (i2 != 0) {
        break;
      }
      b(paramContext, i1);
      return;
      int i2 = -1;
      String str = null;
      int i3 = 0;
      int i4 = -1;
      int i1 = 0;
    }
  }
  
  /* Error */
  public boolean a(final Context paramContext1, final Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 139
    //   4: ldc_w 1437
    //   7: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: getstatic 113	com/tencent/smtt/sdk/p:p	Z
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_1
    //   16: if_icmpne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_1
    //   22: ireturn
    //   23: iconst_1
    //   24: putstatic 113	com/tencent/smtt/sdk/p:p	Z
    //   27: new 12	com/tencent/smtt/sdk/p$4
    //   30: dup
    //   31: aload_0
    //   32: aload_2
    //   33: aload_1
    //   34: invokespecial 1440	com/tencent/smtt/sdk/p$4:<init>	(Lcom/tencent/smtt/sdk/p;Landroid/content/Context;Landroid/content/Context;)V
    //   37: invokevirtual 1443	com/tencent/smtt/sdk/p$4:start	()V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	p
    //   0	48	1	paramContext1	Context
    //   0	48	2	paramContext2	Context
    //   13	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   23	40	43	finally
  }
  
  public boolean a(Context paramContext, File[] paramArrayOfFile)
  {
    return false;
  }
  
  public int b(Context paramContext)
  {
    if (w(paramContext))
    {
      if (a(paramContext, "core_unzip_tmp")) {
        return -1;
      }
      if (a(paramContext, "core_share_backup_tmp")) {
        return -2;
      }
      if (a(paramContext, "core_copy_tmp")) {
        return -3;
      }
      if (a(paramContext, "tpatch_tmp")) {
        return -4;
      }
      return 1;
    }
    return 0;
  }
  
  Context b(Context paramContext, String paramString)
  {
    try
    {
      if ((paramContext.getPackageName() != paramString) && (TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray())) {
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(QbSdk.getTbsFolderDir(paramContext2), "core_share");
    if (paramContext2 != null)
    {
      if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))
      {
        TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
      }
      return paramContext2;
    }
    TbsLog.i("TbsInstaller", "getTbsCoreShareDir,tbsShareDir = null");
    return null;
  }
  
  void b()
  {
    for (;;)
    {
      try
      {
        if (this.e <= 0)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + Log.getStackTraceString(new Throwable()));
          return;
        }
        if (this.e > 1)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
          this.e -= 1;
          continue;
        }
        if (this.e != 1) {
          continue;
        }
      }
      finally {}
      TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
      FileUtil.a(this.f, this.g);
      this.e = 0;
    }
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 139
    //   2: new 235	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 1482
    //   12: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokestatic 811	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18: invokevirtual 812	java/lang/Thread:getName	()Ljava/lang/String;
    //   21: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: new 355	java/lang/Throwable
    //   27: dup
    //   28: invokespecial 1469	java/lang/Throwable:<init>	()V
    //   31: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   34: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 469	com/tencent/smtt/sdk/p:d	(Landroid/content/Context;)Z
    //   48: ifeq +14 -> 62
    //   51: aload_1
    //   52: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   55: sipush -539
    //   58: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   61: return
    //   62: ldc 139
    //   64: ldc_w 1484
    //   67: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_2
    //   71: ifnull -10 -> 61
    //   74: aload_1
    //   75: ifnull -14 -> 61
    //   78: aload_1
    //   79: invokestatic 537	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   82: ifne +70 -> 152
    //   85: invokestatic 540	com/tencent/smtt/utils/q:a	()J
    //   88: lstore 9
    //   90: aload_1
    //   91: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   94: invokevirtual 543	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   97: lstore 7
    //   99: aload_1
    //   100: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   103: sipush 210
    //   106: new 235	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 1486
    //   116: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: lload 9
    //   121: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   124: ldc_w 550
    //   127: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: lload 7
    //   132: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   141: aload_1
    //   142: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   145: sipush -540
    //   148: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   151: return
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 491	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   157: ifne +14 -> 171
    //   160: aload_1
    //   161: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   164: sipush -541
    //   167: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   170: return
    //   171: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   174: invokeinterface 496 1 0
    //   179: istore 6
    //   181: ldc 139
    //   183: new 235	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 1488
    //   193: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 6
    //   198: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   201: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: iload 6
    //   209: ifeq +1882 -> 2091
    //   212: aload_1
    //   213: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   216: getfield 193	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   219: ldc_w 916
    //   222: iconst_0
    //   223: invokeinterface 201 3 0
    //   228: istore 5
    //   230: iconst_1
    //   231: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   234: iload 5
    //   236: iconst_5
    //   237: if_icmpeq +9 -> 246
    //   240: iload 5
    //   242: iconst_3
    //   243: if_icmpne +532 -> 775
    //   246: aload_0
    //   247: aload_1
    //   248: aload_2
    //   249: invokespecial 1490	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   252: istore_3
    //   253: ldc 139
    //   255: new 235	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 1492
    //   265: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload_3
    //   269: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: iload_3
    //   279: iconst_1
    //   280: if_icmpne +70 -> 350
    //   283: aload_1
    //   284: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   287: ldc 180
    //   289: invokevirtual 506	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   292: istore 4
    //   294: aload_1
    //   295: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   298: ldc 180
    //   300: iload 4
    //   302: iconst_1
    //   303: iadd
    //   304: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   307: aload_2
    //   308: ldc_w 1494
    //   311: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore_2
    //   315: aload_2
    //   316: ldc_w 1496
    //   319: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +163 -> 485
    //   325: invokestatic 1500	com/tencent/smtt/utils/b:b	()Z
    //   328: ifeq +47 -> 375
    //   331: aload_1
    //   332: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   335: ldc_w 1502
    //   338: iconst_1
    //   339: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   342: ldc 139
    //   344: ldc_w 1504
    //   347: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   353: invokeinterface 522 1 0
    //   358: aload_0
    //   359: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   362: iload 5
    //   364: iconst_5
    //   365: if_icmpne +213 -> 578
    //   368: aload_0
    //   369: aload_1
    //   370: iload_3
    //   371: invokespecial 1506	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   374: return
    //   375: aload_1
    //   376: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   379: ldc_w 1508
    //   382: iconst_1
    //   383: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   386: ldc 139
    //   388: ldc_w 1510
    //   391: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: goto -44 -> 350
    //   397: astore 11
    //   399: aconst_null
    //   400: astore_2
    //   401: ldc 139
    //   403: new 235	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 1512
    //   413: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 11
    //   418: invokestatic 690	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   421: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload 11
    //   432: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   435: aload_1
    //   436: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   439: sipush -543
    //   442: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   445: aload_1
    //   446: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   449: sipush 218
    //   452: aload 11
    //   454: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   457: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   460: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   463: invokeinterface 522 1 0
    //   468: aload_0
    //   469: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   472: iload 5
    //   474: iconst_5
    //   475: if_icmpne +1153 -> 1628
    //   478: aload_0
    //   479: aload_1
    //   480: iconst_1
    //   481: invokespecial 1506	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   484: return
    //   485: aload_2
    //   486: ldc_w 1514
    //   489: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   492: ifeq +54 -> 546
    //   495: aload_1
    //   496: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   499: ldc_w 1508
    //   502: iconst_1
    //   503: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   506: ldc 139
    //   508: ldc_w 1510
    //   511: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -164 -> 350
    //   517: astore_2
    //   518: aconst_null
    //   519: astore 11
    //   521: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   524: invokeinterface 522 1 0
    //   529: aload_0
    //   530: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   533: iload 5
    //   535: iconst_5
    //   536: if_icmpne +1212 -> 1748
    //   539: aload_0
    //   540: aload_1
    //   541: iload_3
    //   542: invokespecial 1506	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   545: return
    //   546: aload_2
    //   547: ldc_w 1516
    //   550: invokevirtual 326	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   553: ifeq -203 -> 350
    //   556: aload_1
    //   557: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   560: ldc_w 1502
    //   563: iconst_1
    //   564: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   567: ldc 139
    //   569: ldc_w 1504
    //   572: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   575: goto -225 -> 350
    //   578: iload_3
    //   579: ifne +62 -> 641
    //   582: ldc 139
    //   584: ldc_w 1518
    //   587: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_1
    //   591: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   594: ldc_w 1318
    //   597: iconst_0
    //   598: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   601: aload_1
    //   602: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   605: sipush -544
    //   608: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   611: aload_1
    //   612: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   615: iconst_0
    //   616: iconst_m1
    //   617: invokevirtual 341	com/tencent/smtt/sdk/n:c	(II)V
    //   620: aload_1
    //   621: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   624: iconst_1
    //   625: invokevirtual 344	com/tencent/smtt/sdk/n:c	(I)V
    //   628: new 1339	java/lang/NullPointerException
    //   631: dup
    //   632: invokespecial 1340	java/lang/NullPointerException:<init>	()V
    //   635: athrow
    //   636: iconst_0
    //   637: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   640: return
    //   641: iload_3
    //   642: iconst_2
    //   643: if_icmpne +14 -> 657
    //   646: ldc 139
    //   648: ldc_w 1520
    //   651: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: goto -18 -> 636
    //   657: aload_1
    //   658: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   661: sipush -546
    //   664: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   667: ldc 139
    //   669: ldc_w 1522
    //   672: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   675: aload_1
    //   676: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   679: getfield 890	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   682: ldc_w 892
    //   685: iconst_1
    //   686: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   689: invokeinterface 903 3 0
    //   694: pop
    //   695: aload_1
    //   696: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   699: invokevirtual 907	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   702: aload_1
    //   703: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   706: ifeq +36 -> 742
    //   709: aload_1
    //   710: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   713: sipush 235
    //   716: new 235	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   723: ldc_w 1524
    //   726: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: iload_3
    //   730: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   733: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   739: goto -103 -> 636
    //   742: aload_1
    //   743: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   746: sipush 217
    //   749: new 235	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   756: ldc_w 1526
    //   759: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: iload_3
    //   763: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   766: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   772: goto -136 -> 636
    //   775: aload_0
    //   776: aload_1
    //   777: invokevirtual 208	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;)I
    //   780: ifle +14 -> 794
    //   783: aload_1
    //   784: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   787: invokevirtual 1291	com/tencent/smtt/sdk/n:d	()I
    //   790: iconst_1
    //   791: if_icmpne +45 -> 836
    //   794: iconst_0
    //   795: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   798: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   801: invokeinterface 522 1 0
    //   806: aload_0
    //   807: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   810: iload 5
    //   812: iconst_5
    //   813: if_icmpne +10 -> 823
    //   816: aload_0
    //   817: aload_1
    //   818: iconst_2
    //   819: invokespecial 1506	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   822: return
    //   823: ldc 139
    //   825: ldc_w 1520
    //   828: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: iconst_0
    //   832: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   835: return
    //   836: iload 5
    //   838: iconst_1
    //   839: if_icmpeq +15 -> 854
    //   842: iload 5
    //   844: iconst_2
    //   845: if_icmpeq +9 -> 854
    //   848: iload 5
    //   850: iconst_4
    //   851: if_icmpne +187 -> 1038
    //   854: iconst_1
    //   855: istore_3
    //   856: iload_3
    //   857: ifne +1335 -> 2192
    //   860: iload 5
    //   862: ifeq +1330 -> 2192
    //   865: aload_1
    //   866: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   869: ldc_w 1318
    //   872: invokevirtual 506	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   875: istore_3
    //   876: iload_3
    //   877: iconst_5
    //   878: if_icmple +178 -> 1056
    //   881: ldc 139
    //   883: ldc_w 1528
    //   886: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: aload_2
    //   890: ldc_w 1530
    //   893: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   896: astore 12
    //   898: aload_2
    //   899: ldc_w 987
    //   902: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   905: astore 11
    //   907: aload_2
    //   908: ldc_w 1532
    //   911: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   914: astore_2
    //   915: aload 12
    //   917: invokestatic 1077	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   920: ifne +15 -> 935
    //   923: new 286	java/io/File
    //   926: dup
    //   927: aload 12
    //   929: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   932: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   935: aload 11
    //   937: invokestatic 1077	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   940: ifne +15 -> 955
    //   943: new 286	java/io/File
    //   946: dup
    //   947: aload 11
    //   949: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   952: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   955: aload_2
    //   956: invokestatic 1077	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   959: ifne +14 -> 973
    //   962: new 286	java/io/File
    //   965: dup
    //   966: aload_2
    //   967: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   970: invokestatic 728	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   973: aload_1
    //   974: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   977: getfield 890	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   980: ldc_w 892
    //   983: iconst_1
    //   984: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   987: invokeinterface 903 3 0
    //   992: pop
    //   993: aload_1
    //   994: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   997: invokevirtual 907	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1000: aload_1
    //   1001: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1004: sipush 224
    //   1007: ldc_w 1534
    //   1010: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1013: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1016: invokeinterface 522 1 0
    //   1021: aload_0
    //   1022: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1025: iload 5
    //   1027: iconst_5
    //   1028: if_icmpne +15 -> 1043
    //   1031: aload_0
    //   1032: aload_1
    //   1033: iconst_2
    //   1034: invokespecial 1506	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1037: return
    //   1038: iconst_0
    //   1039: istore_3
    //   1040: goto -184 -> 856
    //   1043: ldc 139
    //   1045: ldc_w 1520
    //   1048: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1051: iconst_0
    //   1052: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1055: return
    //   1056: aload_1
    //   1057: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1060: ldc_w 1318
    //   1063: iload_3
    //   1064: iconst_1
    //   1065: iadd
    //   1066: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1069: aload_1
    //   1070: invokestatic 747	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Ljava/io/File;
    //   1073: astore 11
    //   1075: aload 11
    //   1077: ifnull +1115 -> 2192
    //   1080: new 286	java/io/File
    //   1083: dup
    //   1084: aload 11
    //   1086: ldc_w 749
    //   1089: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1092: astore 11
    //   1094: aload 11
    //   1096: ifnull +1096 -> 2192
    //   1099: aload 11
    //   1101: invokevirtual 593	java/io/File:exists	()Z
    //   1104: ifeq +1088 -> 2192
    //   1107: aload_1
    //   1108: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1111: sipush -550
    //   1114: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1117: aload_1
    //   1118: aload_2
    //   1119: invokestatic 979	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   1122: astore 11
    //   1124: aload 11
    //   1126: ifnonnull +72 -> 1198
    //   1129: aload_1
    //   1130: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1133: sipush 228
    //   1136: new 235	java/lang/StringBuilder
    //   1139: dup
    //   1140: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1143: ldc_w 1536
    //   1146: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: aload_2
    //   1150: ldc_w 992
    //   1153: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1156: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1165: iconst_1
    //   1166: istore 4
    //   1168: aload 11
    //   1170: astore 12
    //   1172: getstatic 61	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1175: invokeinterface 522 1 0
    //   1180: aload_0
    //   1181: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   1184: iload 5
    //   1186: iconst_5
    //   1187: if_icmpne +99 -> 1286
    //   1190: aload_0
    //   1191: aload_1
    //   1192: iload 4
    //   1194: invokespecial 1506	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1197: return
    //   1198: aload 11
    //   1200: ldc_w 983
    //   1203: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1206: istore_3
    //   1207: iload_3
    //   1208: istore 4
    //   1210: aload 11
    //   1212: astore 12
    //   1214: iload_3
    //   1215: ifeq -43 -> 1172
    //   1218: aload_1
    //   1219: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1222: sipush 228
    //   1225: new 235	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1232: ldc_w 1538
    //   1235: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: iload_3
    //   1239: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1242: ldc_w 1540
    //   1245: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: aload_2
    //   1249: ldc_w 992
    //   1252: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1255: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1264: iload_3
    //   1265: istore 4
    //   1267: aload 11
    //   1269: astore 12
    //   1271: goto -99 -> 1172
    //   1274: astore 12
    //   1276: aload 11
    //   1278: astore_2
    //   1279: aload 12
    //   1281: astore 11
    //   1283: goto -882 -> 401
    //   1286: iload 4
    //   1288: ifne +203 -> 1491
    //   1291: ldc 139
    //   1293: ldc_w 1518
    //   1296: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1299: aload_1
    //   1300: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1303: ldc_w 1318
    //   1306: iconst_0
    //   1307: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1310: aload_1
    //   1311: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1314: sipush -544
    //   1317: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1320: aload_1
    //   1321: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1324: iconst_0
    //   1325: iconst_m1
    //   1326: invokevirtual 341	com/tencent/smtt/sdk/n:c	(II)V
    //   1329: aload_1
    //   1330: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1333: iconst_1
    //   1334: invokevirtual 344	com/tencent/smtt/sdk/n:c	(I)V
    //   1337: aload 12
    //   1339: ldc_w 1542
    //   1342: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1345: astore_2
    //   1346: aload_1
    //   1347: invokestatic 1543	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   1350: ifeq +126 -> 1476
    //   1353: aload_1
    //   1354: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1357: getfield 193	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1360: ldc 195
    //   1362: iconst_0
    //   1363: invokeinterface 201 3 0
    //   1368: istore 4
    //   1370: aload 12
    //   1372: ldc_w 1545
    //   1375: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1378: istore_3
    //   1379: ldc 139
    //   1381: new 235	java/lang/StringBuilder
    //   1384: dup
    //   1385: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1388: ldc_w 1547
    //   1391: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: iload_3
    //   1395: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1398: ldc_w 1549
    //   1401: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: iload 4
    //   1406: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1409: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1412: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1415: iload_3
    //   1416: iload 4
    //   1418: if_icmpne +24 -> 1442
    //   1421: ldc_w 1551
    //   1424: ldc_w 1553
    //   1427: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1430: new 286	java/io/File
    //   1433: dup
    //   1434: aload_2
    //   1435: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   1438: aload_1
    //   1439: invokestatic 652	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1442: aload_0
    //   1443: aload_1
    //   1444: aload_2
    //   1445: aload 12
    //   1447: ldc_w 1545
    //   1450: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1453: invokespecial 718	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1456: aload_1
    //   1457: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1460: ifeq +11 -> 1471
    //   1463: aload_1
    //   1464: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1467: iconst_m1
    //   1468: invokevirtual 344	com/tencent/smtt/sdk/n:c	(I)V
    //   1471: iconst_0
    //   1472: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1475: return
    //   1476: new 286	java/io/File
    //   1479: dup
    //   1480: aload_2
    //   1481: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   1484: aload_1
    //   1485: invokestatic 652	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1488: goto -46 -> 1442
    //   1491: iload 4
    //   1493: iconst_2
    //   1494: if_icmpne +14 -> 1508
    //   1497: ldc 139
    //   1499: ldc_w 1520
    //   1502: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1505: goto -34 -> 1471
    //   1508: aload_1
    //   1509: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1512: sipush -546
    //   1515: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1518: ldc 139
    //   1520: ldc_w 1522
    //   1523: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1526: aload_1
    //   1527: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1530: getfield 890	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1533: ldc_w 892
    //   1536: iconst_1
    //   1537: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1540: invokeinterface 903 3 0
    //   1545: pop
    //   1546: aload_1
    //   1547: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1550: invokevirtual 907	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1553: aload_1
    //   1554: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1557: ifeq +37 -> 1594
    //   1560: aload_1
    //   1561: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1564: sipush 235
    //   1567: new 235	java/lang/StringBuilder
    //   1570: dup
    //   1571: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1574: ldc_w 1524
    //   1577: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: iload 4
    //   1582: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1585: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1591: goto -120 -> 1471
    //   1594: aload_1
    //   1595: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1598: sipush 217
    //   1601: new 235	java/lang/StringBuilder
    //   1604: dup
    //   1605: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1608: ldc_w 1526
    //   1611: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: iload 4
    //   1616: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1619: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1622: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1625: goto -154 -> 1471
    //   1628: aload_1
    //   1629: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1632: sipush -546
    //   1635: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1638: ldc 139
    //   1640: ldc_w 1522
    //   1643: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1646: aload_1
    //   1647: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1650: getfield 890	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1653: ldc_w 892
    //   1656: iconst_1
    //   1657: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1660: invokeinterface 903 3 0
    //   1665: pop
    //   1666: aload_1
    //   1667: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1670: invokevirtual 907	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1673: aload_1
    //   1674: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1677: ifeq +38 -> 1715
    //   1680: aload_1
    //   1681: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1684: sipush 235
    //   1687: new 235	java/lang/StringBuilder
    //   1690: dup
    //   1691: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1694: ldc_w 1524
    //   1697: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: iconst_1
    //   1701: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1704: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1707: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1710: iconst_0
    //   1711: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1714: return
    //   1715: aload_1
    //   1716: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1719: sipush 217
    //   1722: new 235	java/lang/StringBuilder
    //   1725: dup
    //   1726: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1729: ldc_w 1526
    //   1732: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: iconst_1
    //   1736: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1739: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1742: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1745: goto -35 -> 1710
    //   1748: iload_3
    //   1749: ifne +208 -> 1957
    //   1752: ldc 139
    //   1754: ldc_w 1518
    //   1757: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1760: aload_1
    //   1761: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1764: ldc_w 1318
    //   1767: iconst_0
    //   1768: invokevirtual 183	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1771: aload_1
    //   1772: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1775: sipush -544
    //   1778: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1781: aload_1
    //   1782: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1785: iconst_0
    //   1786: iconst_m1
    //   1787: invokevirtual 341	com/tencent/smtt/sdk/n:c	(II)V
    //   1790: aload_1
    //   1791: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1794: iconst_1
    //   1795: invokevirtual 344	com/tencent/smtt/sdk/n:c	(I)V
    //   1798: aload 11
    //   1800: ldc_w 1542
    //   1803: invokevirtual 990	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1806: astore 12
    //   1808: aload_1
    //   1809: invokestatic 1543	com/tencent/smtt/utils/q:b	(Landroid/content/Context;)Z
    //   1812: ifeq +129 -> 1941
    //   1815: aload_1
    //   1816: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1819: getfield 193	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1822: ldc 195
    //   1824: iconst_0
    //   1825: invokeinterface 201 3 0
    //   1830: istore_3
    //   1831: aload 11
    //   1833: ldc_w 1545
    //   1836: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1839: istore 4
    //   1841: ldc 139
    //   1843: new 235	java/lang/StringBuilder
    //   1846: dup
    //   1847: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   1850: ldc_w 1547
    //   1853: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: iload 4
    //   1858: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1861: ldc_w 1549
    //   1864: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1867: iload_3
    //   1868: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1871: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1877: iload 4
    //   1879: iload_3
    //   1880: if_icmpne +25 -> 1905
    //   1883: ldc_w 1551
    //   1886: ldc_w 1553
    //   1889: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1892: new 286	java/io/File
    //   1895: dup
    //   1896: aload 12
    //   1898: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   1901: aload_1
    //   1902: invokestatic 652	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1905: aload_0
    //   1906: aload_1
    //   1907: aload 12
    //   1909: aload 11
    //   1911: ldc_w 1545
    //   1914: invokevirtual 985	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1917: invokespecial 718	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1920: aload_1
    //   1921: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1924: ifeq +11 -> 1935
    //   1927: aload_1
    //   1928: invokestatic 175	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1931: iconst_m1
    //   1932: invokevirtual 344	com/tencent/smtt/sdk/n:c	(I)V
    //   1935: iconst_0
    //   1936: invokestatic 1251	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1939: aload_2
    //   1940: athrow
    //   1941: new 286	java/io/File
    //   1944: dup
    //   1945: aload 12
    //   1947: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   1950: aload_1
    //   1951: invokestatic 652	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1954: goto -49 -> 1905
    //   1957: iload_3
    //   1958: iconst_2
    //   1959: if_icmpne +14 -> 1973
    //   1962: ldc 139
    //   1964: ldc_w 1520
    //   1967: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1970: goto -35 -> 1935
    //   1973: aload_1
    //   1974: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1977: sipush -546
    //   1980: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1983: ldc 139
    //   1985: ldc_w 1522
    //   1988: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1991: aload_1
    //   1992: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1995: getfield 890	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1998: ldc_w 892
    //   2001: iconst_1
    //   2002: invokestatic 897	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2005: invokeinterface 903 3 0
    //   2010: pop
    //   2011: aload_1
    //   2012: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2015: invokevirtual 907	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2018: aload_1
    //   2019: invokestatic 554	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2022: ifeq +36 -> 2058
    //   2025: aload_1
    //   2026: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2029: sipush 235
    //   2032: new 235	java/lang/StringBuilder
    //   2035: dup
    //   2036: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   2039: ldc_w 1524
    //   2042: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: iload_3
    //   2046: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2049: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2052: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2055: goto -120 -> 1935
    //   2058: aload_1
    //   2059: invokestatic 233	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2062: sipush 217
    //   2065: new 235	java/lang/StringBuilder
    //   2068: dup
    //   2069: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   2072: ldc_w 1526
    //   2075: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: iload_3
    //   2079: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2082: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2085: invokevirtual 251	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2088: goto -153 -> 1935
    //   2091: aload_1
    //   2092: invokestatic 189	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2095: sipush -547
    //   2098: invokevirtual 467	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2101: aload_0
    //   2102: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   2105: return
    //   2106: astore_2
    //   2107: iconst_2
    //   2108: istore_3
    //   2109: aconst_null
    //   2110: astore 11
    //   2112: goto -1591 -> 521
    //   2115: astore_2
    //   2116: iconst_1
    //   2117: istore_3
    //   2118: goto -1597 -> 521
    //   2121: astore_2
    //   2122: iconst_2
    //   2123: istore_3
    //   2124: goto -1603 -> 521
    //   2127: astore_2
    //   2128: goto -1607 -> 521
    //   2131: astore 12
    //   2133: aload_2
    //   2134: astore 11
    //   2136: aload 12
    //   2138: astore_2
    //   2139: goto -1618 -> 521
    //   2142: astore 12
    //   2144: aload_2
    //   2145: astore 11
    //   2147: iconst_1
    //   2148: istore_3
    //   2149: aload 12
    //   2151: astore_2
    //   2152: goto -1631 -> 521
    //   2155: astore 11
    //   2157: aconst_null
    //   2158: astore_2
    //   2159: iconst_2
    //   2160: istore_3
    //   2161: goto -1760 -> 401
    //   2164: astore 12
    //   2166: aload 11
    //   2168: astore_2
    //   2169: iconst_1
    //   2170: istore_3
    //   2171: aload 12
    //   2173: astore 11
    //   2175: goto -1774 -> 401
    //   2178: astore 12
    //   2180: aload 11
    //   2182: astore_2
    //   2183: iconst_2
    //   2184: istore_3
    //   2185: aload 12
    //   2187: astore 11
    //   2189: goto -1788 -> 401
    //   2192: aconst_null
    //   2193: astore 12
    //   2195: iconst_2
    //   2196: istore 4
    //   2198: goto -1026 -> 1172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2201	0	this	p
    //   0	2201	1	paramContext	Context
    //   0	2201	2	paramBundle	Bundle
    //   252	1933	3	i1	int
    //   292	1905	4	i2	int
    //   228	960	5	i3	int
    //   179	29	6	bool	boolean
    //   97	34	7	l1	long
    //   88	32	9	l2	long
    //   397	56	11	localException1	Exception
    //   519	1627	11	localObject1	Object
    //   2155	12	11	localException2	Exception
    //   2173	15	11	localObject2	Object
    //   896	374	12	localObject3	Object
    //   1274	172	12	localException3	Exception
    //   1806	140	12	str	String
    //   2131	6	12	localObject4	Object
    //   2142	8	12	localObject5	Object
    //   2164	8	12	localException4	Exception
    //   2178	8	12	localException5	Exception
    //   2193	1	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   253	278	397	java/lang/Exception
    //   283	350	397	java/lang/Exception
    //   375	394	397	java/lang/Exception
    //   485	514	397	java/lang/Exception
    //   546	575	397	java/lang/Exception
    //   253	278	517	finally
    //   283	350	517	finally
    //   375	394	517	finally
    //   485	514	517	finally
    //   546	575	517	finally
    //   1218	1264	1274	java/lang/Exception
    //   230	234	2106	finally
    //   246	253	2106	finally
    //   775	794	2106	finally
    //   794	798	2106	finally
    //   865	876	2106	finally
    //   881	935	2106	finally
    //   935	955	2106	finally
    //   955	973	2106	finally
    //   973	1013	2106	finally
    //   1056	1075	2106	finally
    //   1080	1094	2106	finally
    //   1099	1124	2106	finally
    //   1129	1165	2115	finally
    //   1198	1207	2121	finally
    //   1218	1264	2127	finally
    //   401	435	2131	finally
    //   435	460	2142	finally
    //   230	234	2155	java/lang/Exception
    //   246	253	2155	java/lang/Exception
    //   775	794	2155	java/lang/Exception
    //   794	798	2155	java/lang/Exception
    //   865	876	2155	java/lang/Exception
    //   881	935	2155	java/lang/Exception
    //   935	955	2155	java/lang/Exception
    //   955	973	2155	java/lang/Exception
    //   973	1013	2155	java/lang/Exception
    //   1056	1075	2155	java/lang/Exception
    //   1080	1094	2155	java/lang/Exception
    //   1099	1124	2155	java/lang/Exception
    //   1129	1165	2164	java/lang/Exception
    //   1198	1207	2178	java/lang/Exception
  }
  
  public void b(Context paramContext, File paramFile, int paramInt)
  {
    FileOutputStream localFileOutputStream = FileUtil.b(paramContext, true, "core_unzip.lock");
    FileLock localFileLock = FileUtil.a(paramContext, localFileOutputStream);
    if (localFileLock != null)
    {
      TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
      boolean bool = a(paramContext, paramFile, false);
      TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + bool);
      paramFile = "coreVersionIs" + paramInt;
      q.a(paramContext, "copy_host_core_v3", paramFile + "_" + "ret=is=" + bool);
      if (bool) {
        a().a(paramContext, paramInt);
      }
      FileUtil.a(localFileLock, localFileOutputStream);
      return;
    }
    TbsLog.i("TbsInstaller", "can not get Core unzip FileLock,skip!!!");
  }
  
  void b(Context paramContext, boolean paramBoolean)
  {
    if (QbSdk.b) {}
    label260:
    label296:
    do
    {
      return;
      if (Build.VERSION.SDK_INT < 8)
      {
        TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
        return;
      }
      TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "#1# check local x5core prepared to install");
      File localFile;
      if ((TbsShareManager.isThirdPartyApp(paramContext)) && (n.a(paramContext).b("remove_old_core") == 1) && (paramBoolean)) {
        localFile = a().r(paramContext);
      }
      do
      {
        do
        {
          do
          {
            try
            {
              FileUtil.b(localFile);
              TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "thirdAPP success--> delete old core_share Directory");
              n.a(paramContext).a("remove_old_core", 0);
              if (!w(paramContext)) {
                break;
              }
              if (TbsShareManager.isThirdPartyApp(paramContext)) {
                q.a(paramContext, "has_tmpfile_torename", "");
              }
              TbsLog.i("TbsInstaller", "installTbsCoreIfNeeded", "#2# try to install tbs core from tmp dir");
              if (!a(paramContext, "core_unzip_tmp"))
              {
                if (a(paramContext, "core_share_backup_tmp")) {
                  continue;
                }
                if (a(paramContext, "core_copy_tmp")) {
                  break label260;
                }
                if (a(paramContext, "tpatch_tmp")) {
                  break label296;
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              do
              {
                for (;;)
                {
                  localThrowable.printStackTrace();
                }
              } while (!e(paramContext, paramBoolean));
              TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip !!", true);
            }
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              break;
            }
            q.a(paramContext, "rename_ok", "enableTbsCoreFromUnzip");
            return;
          } while (!f(paramContext, paramBoolean));
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup !!", true);
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break;
          }
          q.a(paramContext, "rename_ok", "enableTbsCoreFromBackup");
          return;
        } while (!d(paramContext, paramBoolean));
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy !!", true);
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break;
        }
        q.a(paramContext, "rename_ok", "enableTbsCoreFromCopy");
        return;
      } while (!c(paramContext, paramBoolean));
      TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch !!", true);
    } while (!TbsShareManager.isThirdPartyApp(paramContext));
    q.a(paramContext, "rename_ok", "enableTbsCoreFromTpatch");
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
    Context localContext = d(paramContext, paramInt);
    if (localContext != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localContext, paramContext, Integer.valueOf(paramInt) };
      m.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  int c(Context paramContext, String paramString)
  {
    int i1 = 0;
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      i1 = paramContext.versionCode;
    }
    return i1;
  }
  
  File c(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(QbSdk.getTbsFolderDir(paramContext2), "core_share_decouple");
    if ((paramContext2 == null) || ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))) {
      return null;
    }
    return paramContext2;
  }
  
  public void c(Context paramContext)
  {
    g(paramContext, true);
    n.a(paramContext).c(i(paramContext), 2);
  }
  
  void c(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {}
    int i1;
    do
    {
      do
      {
        return;
        i1 = j(paramContext);
      } while (i1 == paramInt);
      Context localContext = TbsShareManager.e(paramContext);
      if ((localContext != null) || (TbsShareManager.getHostCorePathAppDefined() != null))
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        a(paramContext, localContext);
        return;
      }
    } while (i1 > 0);
    TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
    QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
  }
  
  public Context d(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + paramInt);
    if (paramInt <= 0) {
      return null;
    }
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = 0;
    if (i1 < arrayOfString.length)
    {
      if (paramContext.getPackageName().equalsIgnoreCase(arrayOfString[i1])) {}
      Context localContext;
      label140:
      int i2;
      do
      {
        for (;;)
        {
          i1 += 1;
          break;
          if (e(paramContext, arrayOfString[i1]))
          {
            localContext = b(paramContext, arrayOfString[i1]);
            if (localContext != null)
            {
              if (g(localContext)) {
                break label140;
              }
              TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + arrayOfString[i1] + " illegal signature go on next");
            }
          }
        }
        i2 = j(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + i2);
      } while ((i2 == 0) || (i2 != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[i1]);
      return localContext;
    }
    return null;
  }
  
  /* Error */
  public String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: invokestatic 1077	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 4
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: new 286	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 266	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   24: ldc_w 383
    //   27: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +12 -> 44
    //   35: aload_1
    //   36: invokevirtual 593	java/io/File:exists	()Z
    //   39: istore_3
    //   40: iload_3
    //   41: ifne +21 -> 62
    //   44: aload 4
    //   46: astore_2
    //   47: iconst_0
    //   48: ifeq -35 -> 13
    //   51: new 1339	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 1340	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: astore_1
    //   60: aconst_null
    //   61: areturn
    //   62: new 385	java/util/Properties
    //   65: dup
    //   66: invokespecial 386	java/util/Properties:<init>	()V
    //   69: astore 5
    //   71: new 388	java/io/BufferedInputStream
    //   74: dup
    //   75: new 390	java/io/FileInputStream
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_1
    //   87: aload 5
    //   89: aload_1
    //   90: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   93: aload_1
    //   94: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   97: aload 5
    //   99: aload_2
    //   100: invokevirtual 1343	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: aload_2
    //   105: astore 4
    //   107: aload 4
    //   109: astore_2
    //   110: aload_1
    //   111: ifnull -98 -> 13
    //   114: aload_1
    //   115: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   118: aload 4
    //   120: areturn
    //   121: astore_1
    //   122: aload 4
    //   124: areturn
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_1
    //   128: aload 4
    //   130: astore_2
    //   131: aload_1
    //   132: ifnull -119 -> 13
    //   135: aload_1
    //   136: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_1
    //   142: aconst_null
    //   143: areturn
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_1
    //   158: goto -3 -> 155
    //   161: astore_2
    //   162: goto -15 -> 147
    //   165: astore_2
    //   166: goto -38 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	p
    //   0	169	1	paramContext	Context
    //   0	169	2	paramString	String
    //   39	2	3	bool	boolean
    //   1	128	4	str	String
    //   69	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   51	59	59	java/io/IOException
    //   114	118	121	java/io/IOException
    //   15	31	125	java/lang/Exception
    //   35	40	125	java/lang/Exception
    //   62	87	125	java/lang/Exception
    //   135	139	141	java/io/IOException
    //   15	31	144	finally
    //   35	40	144	finally
    //   62	87	144	finally
    //   151	155	157	java/io/IOException
    //   87	104	161	finally
    //   87	104	165	java/lang/Exception
  }
  
  /* Error */
  boolean d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 286	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 266	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   11: ldc_w 383
    //   14: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +11 -> 32
    //   24: aload 5
    //   26: invokevirtual 593	java/io/File:exists	()Z
    //   29: ifne +9 -> 38
    //   32: iconst_0
    //   33: istore 4
    //   35: iload 4
    //   37: ireturn
    //   38: new 385	java/util/Properties
    //   41: dup
    //   42: invokespecial 386	java/util/Properties:<init>	()V
    //   45: astore 6
    //   47: new 388	java/io/BufferedInputStream
    //   50: dup
    //   51: new 390	java/io/FileInputStream
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 6
    //   66: aload_1
    //   67: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload 6
    //   72: ldc_w 409
    //   75: ldc_w 1672
    //   78: invokevirtual 622	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 1675	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   84: invokevirtual 924	java/lang/Boolean:booleanValue	()Z
    //   87: istore 4
    //   89: iload 4
    //   91: ifeq +175 -> 266
    //   94: invokestatic 573	java/lang/System:currentTimeMillis	()J
    //   97: aload 5
    //   99: invokevirtual 1678	java/io/File:lastModified	()J
    //   102: lsub
    //   103: ldc2_w 1679
    //   106: lcmp
    //   107: ifle +70 -> 177
    //   110: iconst_1
    //   111: istore_3
    //   112: ldc 139
    //   114: new 235	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 1682
    //   124: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload 4
    //   129: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 1684
    //   135: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_3
    //   139: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: iload_3
    //   149: ifne +33 -> 182
    //   152: iload 4
    //   154: iload_2
    //   155: iand
    //   156: istore_3
    //   157: iload_3
    //   158: istore 4
    //   160: aload_1
    //   161: ifnull -126 -> 35
    //   164: aload_1
    //   165: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   168: iload_3
    //   169: ireturn
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   175: iload_3
    //   176: ireturn
    //   177: iconst_0
    //   178: istore_3
    //   179: goto -67 -> 112
    //   182: iconst_0
    //   183: istore_2
    //   184: goto -32 -> 152
    //   187: astore 5
    //   189: iconst_0
    //   190: istore_3
    //   191: aconst_null
    //   192: astore_1
    //   193: aload 5
    //   195: invokevirtual 427	java/lang/Throwable:printStackTrace	()V
    //   198: iload_3
    //   199: istore 4
    //   201: aload_1
    //   202: ifnull -167 -> 35
    //   205: aload_1
    //   206: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   209: iload_3
    //   210: ireturn
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   216: iload_3
    //   217: ireturn
    //   218: astore 5
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   230: aload 5
    //   232: athrow
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   238: goto -8 -> 230
    //   241: astore 5
    //   243: goto -21 -> 222
    //   246: astore 5
    //   248: goto -26 -> 222
    //   251: astore 5
    //   253: iconst_0
    //   254: istore_3
    //   255: goto -62 -> 193
    //   258: astore 5
    //   260: iload 4
    //   262: istore_3
    //   263: goto -70 -> 193
    //   266: iconst_0
    //   267: istore_3
    //   268: goto -156 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	p
    //   0	271	1	paramContext	Context
    //   1	183	2	bool1	boolean
    //   111	157	3	bool2	boolean
    //   33	228	4	bool3	boolean
    //   17	81	5	localFile	File
    //   187	7	5	localThrowable1	Throwable
    //   218	13	5	localObject1	Object
    //   241	1	5	localObject2	Object
    //   246	1	5	localObject3	Object
    //   251	1	5	localThrowable2	Throwable
    //   258	1	5	localThrowable3	Throwable
    //   45	26	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   164	168	170	java/io/IOException
    //   47	64	187	java/lang/Throwable
    //   205	209	211	java/io/IOException
    //   47	64	218	finally
    //   226	230	233	java/io/IOException
    //   64	89	241	finally
    //   94	110	241	finally
    //   112	148	241	finally
    //   193	198	246	finally
    //   64	89	251	java/lang/Throwable
    //   94	110	258	java/lang/Throwable
    //   112	148	258	java/lang/Throwable
  }
  
  int e(Context paramContext, int paramInt)
  {
    return a(f(paramContext, paramInt));
  }
  
  /* Error */
  public void e(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 286	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 266	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   13: ldc_w 383
    //   16: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore 5
    //   21: new 385	java/util/Properties
    //   24: dup
    //   25: invokespecial 386	java/util/Properties:<init>	()V
    //   28: astore 4
    //   30: new 388	java/io/BufferedInputStream
    //   33: dup
    //   34: new 390	java/io/FileInputStream
    //   37: dup
    //   38: aload 5
    //   40: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore_1
    //   47: aload 4
    //   49: aload_1
    //   50: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   53: new 401	java/io/BufferedOutputStream
    //   56: dup
    //   57: new 403	java/io/FileOutputStream
    //   60: dup
    //   61: aload 5
    //   63: invokespecial 404	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 407	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload 4
    //   72: ldc_w 409
    //   75: ldc_w 1672
    //   78: invokevirtual 415	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   81: pop
    //   82: aload 4
    //   84: aload_2
    //   85: aconst_null
    //   86: invokevirtual 419	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 424	java/io/BufferedOutputStream:close	()V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   105: return
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 424	java/io/BufferedOutputStream:close	()V
    //   117: aload_2
    //   118: ifnull -13 -> 105
    //   121: aload_2
    //   122: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   125: return
    //   126: astore_1
    //   127: return
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 424	java/io/BufferedOutputStream:close	()V
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: return
    //   151: astore_2
    //   152: goto -55 -> 97
    //   155: astore_1
    //   156: return
    //   157: astore_1
    //   158: goto -41 -> 117
    //   161: astore_3
    //   162: goto -23 -> 139
    //   165: astore_1
    //   166: goto -19 -> 147
    //   169: astore_2
    //   170: goto -39 -> 131
    //   173: astore 4
    //   175: aload_2
    //   176: astore_3
    //   177: aload 4
    //   179: astore_2
    //   180: goto -49 -> 131
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_3
    //   186: aload_1
    //   187: astore_2
    //   188: aload_3
    //   189: astore_1
    //   190: goto -81 -> 109
    //   193: astore_3
    //   194: aload_1
    //   195: astore_3
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: astore_2
    //   200: goto -91 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	p
    //   0	203	1	paramContext	Context
    //   3	119	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   128	20	2	localObject1	Object
    //   151	1	2	localIOException1	java.io.IOException
    //   169	7	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   183	1	2	localThrowable1	Throwable
    //   187	13	2	localContext1	Context
    //   1	135	3	localObject4	Object
    //   161	1	3	localIOException2	java.io.IOException
    //   176	13	3	localObject5	Object
    //   193	1	3	localThrowable2	Throwable
    //   195	4	3	localContext2	Context
    //   28	55	4	localProperties	java.util.Properties
    //   173	5	4	localObject6	Object
    //   19	43	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	47	106	java/lang/Throwable
    //   121	125	126	java/io/IOException
    //   30	47	128	finally
    //   4	30	149	java/lang/Throwable
    //   93	97	149	java/lang/Throwable
    //   101	105	149	java/lang/Throwable
    //   113	117	149	java/lang/Throwable
    //   121	125	149	java/lang/Throwable
    //   135	139	149	java/lang/Throwable
    //   143	147	149	java/lang/Throwable
    //   147	149	149	java/lang/Throwable
    //   93	97	151	java/io/IOException
    //   101	105	155	java/io/IOException
    //   113	117	157	java/io/IOException
    //   135	139	161	java/io/IOException
    //   143	147	165	java/io/IOException
    //   47	70	169	finally
    //   70	89	173	finally
    //   47	70	183	java/lang/Throwable
    //   70	89	193	java/lang/Throwable
  }
  
  File f(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, true);
  }
  
  public boolean f(Context paramContext)
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new File(FileUtil.a(paramContext, 4), TbsDownloader.getBackupFileName(true));
        File localFile1 = a().f(paramContext, 2);
        FileUtil.a(localFile1);
        FileUtil.a(localFile1, true);
        FileUtil.a((File)localObject, localFile1);
        localObject = localFile1.list();
        i1 = 0;
        if (i1 < localObject.length)
        {
          File localFile2 = new File(localFile1, localObject[i1]);
          if (localFile2.getName().endsWith(".dex")) {
            localFile2.delete();
          }
        }
        else
        {
          i(paramContext, 2);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      i1 += 1;
    }
  }
  
  boolean g(Context paramContext)
  {
    if (TbsShareManager.getHostCorePathAppDefined() != null) {}
    for (;;)
    {
      return true;
      try
      {
        Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
        if (paramContext.getPackageName().equals("com.tencent.mtt"))
        {
          if (!localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
            return false;
          }
        }
        else if (paramContext.getPackageName().equals("com.tencent.mm"))
        {
          if (!localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
            return false;
          }
        }
        else if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
        {
          if (!localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
            return false;
          }
        }
        else if (paramContext.getPackageName().equals("com.tencent.tbs"))
        {
          if (!localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
            return false;
          }
        }
        else if (paramContext.getPackageName().equals("com.qzone"))
        {
          if (!localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
            return false;
          }
        }
        else if (paramContext.getPackageName().equals("com.tencent.qqpimsecure"))
        {
          boolean bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
          if (!bool) {
            return false;
          }
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
      }
    }
    return false;
  }
  
  boolean g(Context paramContext, int paramInt)
  {
    for (;;)
    {
      boolean bool;
      int i1;
      try
      {
        bool = TbsShareManager.isThirdPartyApp(paramContext);
        if (bool)
        {
          if (TbsShareManager.j(paramContext))
          {
            localFile = new File(TbsShareManager.c(paramContext));
            if (!localFile.getAbsolutePath().contains("com.tencent.tbs")) {
              break label286;
            }
            return true;
          }
          TbsLog.e("TbsInstaller", "321");
          return false;
        }
        File localFile = r(paramContext);
        if (localFile == null) {
          break label276;
        }
        Long[][] arrayOfLong1 = n;
        int i2 = arrayOfLong1.length;
        i1 = 0;
        if (i1 >= i2) {
          break label289;
        }
        Long[] arrayOfLong = arrayOfLong1[i1];
        if (paramInt != arrayOfLong[0].intValue()) {
          break label291;
        }
        localFile = new File(localFile, "libmttwebview.so");
        if ((localFile != null) && (localFile.exists()) && (localFile.length() == arrayOfLong[1].longValue()))
        {
          TbsLog.d("TbsInstaller", "check so success: " + paramInt + "; file: " + localFile);
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + paramContext.getMessage());
        TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + paramContext.getCause());
        return false;
      }
      if (!bool) {
        FileUtil.b(QbSdk.getTbsFolderDir(paramContext));
      }
      a.set(Integer.valueOf(0));
      TbsLog.e("TbsInstaller", "322");
      return false;
      label276:
      TbsLog.e("TbsInstaller", "323");
      return false;
      label286:
      continue;
      label289:
      return true;
      label291:
      i1 += 1;
    }
  }
  
  public void h(Context paramContext)
  {
    if (l != null) {
      FileUtil.a(paramContext, l);
    }
  }
  
  /* Error */
  int i(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 286	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 563	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc_w 383
    //   17: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +14 -> 36
    //   25: aload_1
    //   26: invokevirtual 593	java/io/File:exists	()Z
    //   29: istore 4
    //   31: iload 4
    //   33: ifne +17 -> 50
    //   36: iconst_0
    //   37: ifeq +11 -> 48
    //   40: new 1339	java/lang/NullPointerException
    //   43: dup
    //   44: invokespecial 1340	java/lang/NullPointerException:<init>	()V
    //   47: athrow
    //   48: iload_3
    //   49: ireturn
    //   50: new 385	java/util/Properties
    //   53: dup
    //   54: invokespecial 386	java/util/Properties:<init>	()V
    //   57: astore 6
    //   59: new 388	java/io/BufferedInputStream
    //   62: dup
    //   63: new 390	java/io/FileInputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   74: astore_1
    //   75: aload 6
    //   77: aload_1
    //   78: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   81: aload_1
    //   82: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   85: aload 6
    //   87: ldc_w 1342
    //   90: invokevirtual 1343	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 5
    //   95: aload 5
    //   97: ifnonnull +16 -> 113
    //   100: aload_1
    //   101: ifnull -53 -> 48
    //   104: aload_1
    //   105: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_1
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 5
    //   115: invokestatic 1346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   118: istore_2
    //   119: iload_2
    //   120: istore_3
    //   121: aload_1
    //   122: ifnull -74 -> 48
    //   125: aload_1
    //   126: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   129: iload_2
    //   130: ireturn
    //   131: astore_1
    //   132: iload_2
    //   133: ireturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull -90 -> 48
    //   141: aload_1
    //   142: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_1
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: iconst_0
    //   165: ireturn
    //   166: astore 5
    //   168: goto -7 -> 161
    //   171: astore 6
    //   173: aload_1
    //   174: astore 5
    //   176: aload 6
    //   178: astore_1
    //   179: goto -28 -> 151
    //   182: astore 5
    //   184: goto -47 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	p
    //   0	187	1	paramContext	Context
    //   118	15	2	i1	int
    //   1	120	3	i2	int
    //   29	3	4	bool	boolean
    //   3	154	5	str	String
    //   166	1	5	localIOException	java.io.IOException
    //   174	1	5	localContext	Context
    //   182	1	5	localException	Exception
    //   57	29	6	localProperties	java.util.Properties
    //   171	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   104	108	110	java/io/IOException
    //   125	129	131	java/io/IOException
    //   5	21	134	java/lang/Exception
    //   25	31	134	java/lang/Exception
    //   50	75	134	java/lang/Exception
    //   141	145	147	java/io/IOException
    //   5	21	150	finally
    //   25	31	150	finally
    //   50	75	150	finally
    //   40	48	163	java/io/IOException
    //   156	161	166	java/io/IOException
    //   75	95	171	finally
    //   113	119	171	finally
    //   75	95	182	java/lang/Exception
    //   113	119	182	java/lang/Exception
  }
  
  /* Error */
  int j(Context paramContext)
  {
    // Byte code:
    //   0: new 286	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 266	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 383
    //   12: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +12 -> 29
    //   20: aload_1
    //   21: invokevirtual 593	java/io/File:exists	()Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifne +48 -> 74
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 1339	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 1340	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: iconst_0
    //   42: ireturn
    //   43: astore_1
    //   44: ldc 139
    //   46: new 235	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 1759
    //   56: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   63: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: new 385	java/util/Properties
    //   77: dup
    //   78: invokespecial 386	java/util/Properties:<init>	()V
    //   81: astore 5
    //   83: new 388	java/io/BufferedInputStream
    //   86: dup
    //   87: new 390	java/io/FileInputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: astore 4
    //   100: aload 4
    //   102: astore_1
    //   103: aload 5
    //   105: aload 4
    //   107: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   110: aload 4
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   118: aload 4
    //   120: astore_1
    //   121: aload 5
    //   123: ldc_w 1342
    //   126: invokevirtual 1343	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 5
    //   131: aload 5
    //   133: ifnonnull +46 -> 179
    //   136: aload 4
    //   138: ifnull -97 -> 41
    //   141: aload 4
    //   143: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: ldc 139
    //   151: new 235	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 1759
    //   161: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   168: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iconst_0
    //   178: ireturn
    //   179: aload 4
    //   181: astore_1
    //   182: aload 5
    //   184: invokestatic 1346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload 4
    //   190: astore_1
    //   191: getstatic 111	com/tencent/smtt/sdk/p:o	I
    //   194: ifne +10 -> 204
    //   197: aload 4
    //   199: astore_1
    //   200: iload_2
    //   201: putstatic 111	com/tencent/smtt/sdk/p:o	I
    //   204: aload 4
    //   206: ifnull +8 -> 214
    //   209: aload 4
    //   211: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   214: iload_2
    //   215: ireturn
    //   216: astore_1
    //   217: ldc 139
    //   219: new 235	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 1759
    //   229: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   236: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: goto -31 -> 214
    //   248: astore 5
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 4
    //   255: astore_1
    //   256: ldc 139
    //   258: new 235	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 1762
    //   268: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 5
    //   273: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   276: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 4
    //   287: ifnull -246 -> 41
    //   290: aload 4
    //   292: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   295: iconst_0
    //   296: ireturn
    //   297: astore_1
    //   298: ldc 139
    //   300: new 235	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 1759
    //   310: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   317: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: iconst_0
    //   327: ireturn
    //   328: astore 4
    //   330: aconst_null
    //   331: astore_1
    //   332: aload_1
    //   333: ifnull +7 -> 340
    //   336: aload_1
    //   337: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   340: aload 4
    //   342: athrow
    //   343: astore_1
    //   344: ldc 139
    //   346: new 235	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 1759
    //   356: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   363: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: goto -32 -> 340
    //   375: astore 4
    //   377: goto -45 -> 332
    //   380: astore 5
    //   382: goto -129 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	p
    //   0	385	1	paramContext	Context
    //   187	28	2	i1	int
    //   24	2	3	bool	boolean
    //   98	193	4	localBufferedInputStream	java.io.BufferedInputStream
    //   328	13	4	localObject1	Object
    //   375	1	4	localObject2	Object
    //   81	102	5	localObject3	Object
    //   248	24	5	localException1	Exception
    //   380	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   33	41	43	java/io/IOException
    //   141	146	148	java/io/IOException
    //   209	214	216	java/io/IOException
    //   0	16	248	java/lang/Exception
    //   20	25	248	java/lang/Exception
    //   74	100	248	java/lang/Exception
    //   290	295	297	java/io/IOException
    //   0	16	328	finally
    //   20	25	328	finally
    //   74	100	328	finally
    //   336	340	343	java/io/IOException
    //   103	110	375	finally
    //   113	118	375	finally
    //   121	131	375	finally
    //   182	188	375	finally
    //   191	197	375	finally
    //   200	204	375	finally
    //   256	285	375	finally
    //   103	110	380	java/lang/Exception
    //   113	118	380	java/lang/Exception
    //   121	131	380	java/lang/Exception
    //   182	188	380	java/lang/Exception
    //   191	197	380	java/lang/Exception
    //   200	204	380	java/lang/Exception
  }
  
  int k(Context paramContext)
  {
    if (o != 0) {
      return o;
    }
    return j(paramContext);
  }
  
  void l(Context paramContext)
  {
    if (o != 0) {
      return;
    }
    o = j(paramContext);
  }
  
  boolean m(Context paramContext)
  {
    paramContext = new File(r(paramContext), "tbs.conf");
    return (paramContext != null) && (paramContext.exists());
  }
  
  /* Error */
  int n(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 491	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: invokevirtual 1116	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   16: istore_3
    //   17: ldc 139
    //   19: new 235	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 1764
    //   29: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: iload_3
    //   43: ifeq +629 -> 672
    //   46: new 286	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 266	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   55: ldc_w 383
    //   58: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +12 -> 75
    //   66: aload_1
    //   67: invokevirtual 593	java/io/File:exists	()Z
    //   70: istore_3
    //   71: iload_3
    //   72: ifne +97 -> 169
    //   75: iconst_0
    //   76: ifeq +11 -> 87
    //   79: new 1339	java/lang/NullPointerException
    //   82: dup
    //   83: invokespecial 1340	java/lang/NullPointerException:<init>	()V
    //   86: athrow
    //   87: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   90: invokevirtual 1767	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   93: ifeq +9 -> 102
    //   96: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   99: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   102: aload_0
    //   103: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: ldc 139
    //   111: new 235	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 1769
    //   121: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   128: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: goto -50 -> 87
    //   140: astore_1
    //   141: ldc 139
    //   143: new 235	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 1771
    //   153: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -64 -> 102
    //   169: new 385	java/util/Properties
    //   172: dup
    //   173: invokespecial 386	java/util/Properties:<init>	()V
    //   176: astore 5
    //   178: new 388	java/io/BufferedInputStream
    //   181: dup
    //   182: new 390	java/io/FileInputStream
    //   185: dup
    //   186: aload_1
    //   187: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   190: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   193: astore 4
    //   195: aload 4
    //   197: astore_1
    //   198: aload 5
    //   200: aload 4
    //   202: invokevirtual 399	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   205: aload 4
    //   207: astore_1
    //   208: aload 4
    //   210: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   213: aload 4
    //   215: astore_1
    //   216: aload 5
    //   218: ldc_w 1342
    //   221: invokevirtual 1343	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 5
    //   226: aload 5
    //   228: ifnonnull +95 -> 323
    //   231: aload 4
    //   233: ifnull +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   241: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   244: invokevirtual 1767	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   247: ifeq +9 -> 256
    //   250: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   253: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   256: aload_0
    //   257: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_1
    //   263: ldc 139
    //   265: new 235	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 1769
    //   275: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_1
    //   279: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   282: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: goto -50 -> 241
    //   294: astore_1
    //   295: ldc 139
    //   297: new 235	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 1771
    //   307: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: goto -64 -> 256
    //   323: aload 4
    //   325: astore_1
    //   326: getstatic 66	com/tencent/smtt/sdk/p:a	Ljava/lang/ThreadLocal;
    //   329: aload 5
    //   331: invokestatic 1346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   334: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: invokevirtual 221	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   340: aload 4
    //   342: astore_1
    //   343: getstatic 66	com/tencent/smtt/sdk/p:a	Ljava/lang/ThreadLocal;
    //   346: invokevirtual 1350	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   349: checkcast 212	java/lang/Integer
    //   352: invokevirtual 1353	java/lang/Integer:intValue	()I
    //   355: istore_2
    //   356: aload 4
    //   358: ifnull +8 -> 366
    //   361: aload 4
    //   363: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   366: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   369: invokevirtual 1767	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   372: ifeq +9 -> 381
    //   375: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   378: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   381: aload_0
    //   382: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   385: iload_2
    //   386: ireturn
    //   387: astore_1
    //   388: ldc 139
    //   390: new 235	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 1769
    //   400: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_1
    //   404: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   407: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: goto -50 -> 366
    //   419: astore_1
    //   420: ldc 139
    //   422: new 235	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 1771
    //   432: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: goto -64 -> 381
    //   448: astore 5
    //   450: aconst_null
    //   451: astore 4
    //   453: aload 4
    //   455: astore_1
    //   456: ldc 139
    //   458: new 235	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   465: ldc_w 1773
    //   468: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload 5
    //   473: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   476: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload 4
    //   487: ifnull +8 -> 495
    //   490: aload 4
    //   492: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   495: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   498: invokevirtual 1767	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   501: ifeq +9 -> 510
    //   504: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   507: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   510: aload_0
    //   511: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   514: iconst_0
    //   515: ireturn
    //   516: astore_1
    //   517: ldc 139
    //   519: new 235	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 1769
    //   529: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_1
    //   533: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   536: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: goto -50 -> 495
    //   548: astore_1
    //   549: ldc 139
    //   551: new 235	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 1771
    //   561: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_1
    //   565: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: goto -64 -> 510
    //   577: astore 4
    //   579: aconst_null
    //   580: astore_1
    //   581: aload_1
    //   582: ifnull +7 -> 589
    //   585: aload_1
    //   586: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   589: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   592: invokevirtual 1767	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   595: ifeq +9 -> 604
    //   598: getstatic 59	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   601: invokevirtual 521	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   604: aload_0
    //   605: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   608: aload 4
    //   610: athrow
    //   611: astore_1
    //   612: ldc 139
    //   614: new 235	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   621: ldc_w 1769
    //   624: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_1
    //   628: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   631: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: goto -51 -> 589
    //   643: astore_1
    //   644: ldc 139
    //   646: new 235	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 1771
    //   656: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_1
    //   660: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 448	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: goto -65 -> 604
    //   672: aload_0
    //   673: invokevirtual 524	com/tencent/smtt/sdk/p:b	()V
    //   676: iconst_0
    //   677: ireturn
    //   678: astore 4
    //   680: goto -99 -> 581
    //   683: astore 5
    //   685: goto -232 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	this	p
    //   0	688	1	paramContext	Context
    //   355	31	2	i1	int
    //   16	56	3	bool	boolean
    //   193	298	4	localBufferedInputStream	java.io.BufferedInputStream
    //   577	32	4	localObject1	Object
    //   678	1	4	localObject2	Object
    //   176	154	5	localObject3	Object
    //   448	24	5	localException1	Exception
    //   683	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   79	87	108	java/io/IOException
    //   87	102	140	java/lang/Throwable
    //   236	241	262	java/io/IOException
    //   241	256	294	java/lang/Throwable
    //   361	366	387	java/io/IOException
    //   366	381	419	java/lang/Throwable
    //   46	62	448	java/lang/Exception
    //   66	71	448	java/lang/Exception
    //   169	195	448	java/lang/Exception
    //   490	495	516	java/io/IOException
    //   495	510	548	java/lang/Throwable
    //   46	62	577	finally
    //   66	71	577	finally
    //   169	195	577	finally
    //   585	589	611	java/io/IOException
    //   589	604	643	java/lang/Throwable
    //   198	205	678	finally
    //   208	213	678	finally
    //   216	226	678	finally
    //   326	340	678	finally
    //   343	356	678	finally
    //   456	485	678	finally
    //   198	205	683	java/lang/Exception
    //   208	213	683	java/lang/Exception
    //   216	226	683	java/lang/Exception
    //   326	340	683	java/lang/Exception
    //   343	356	683	java/lang/Exception
  }
  
  public boolean o(Context paramContext)
  {
    return true;
  }
  
  void p(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    n.a(paramContext).a(0);
    n.a(paramContext).b(0);
    n.a(paramContext).d(0);
    n.a(paramContext).a("incrupdate_retry_num", 0);
    if (!TbsDownloader.a(paramContext))
    {
      n.a(paramContext).c(0, -1);
      n.a(paramContext).a("");
      n.a(paramContext).a("copy_retry_num", 0);
      n.a(paramContext).c(-1);
      n.a(paramContext).a(0, -1);
      FileUtil.a(f(paramContext, 0), true);
      FileUtil.a(f(paramContext, 1), true);
    }
  }
  
  File q(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File r(Context paramContext)
  {
    return b(null, paramContext);
  }
  
  File s(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "share");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  /* Error */
  boolean u(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 117	com/tencent/smtt/sdk/p:e	I
    //   8: ifle +25 -> 33
    //   11: ldc 139
    //   13: ldc_w 1782
    //   16: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 117	com/tencent/smtt/sdk/p:e	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 117	com/tencent/smtt/sdk/p:e	I
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: aload_1
    //   35: iconst_1
    //   36: ldc_w 1784
    //   39: invokestatic 1558	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   42: putfield 1477	com/tencent/smtt/sdk/p:g	Ljava/io/FileOutputStream;
    //   45: aload_0
    //   46: getfield 1477	com/tencent/smtt/sdk/p:g	Ljava/io/FileOutputStream;
    //   49: ifnull +35 -> 84
    //   52: aload_0
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 1477	com/tencent/smtt/sdk/p:g	Ljava/io/FileOutputStream;
    //   58: invokestatic 1561	com/tencent/smtt/utils/FileUtil:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   61: putfield 1475	com/tencent/smtt/sdk/p:f	Ljava/nio/channels/FileLock;
    //   64: aload_0
    //   65: getfield 1475	com/tencent/smtt/sdk/p:f	Ljava/nio/channels/FileLock;
    //   68: ifnonnull +29 -> 97
    //   71: ldc 139
    //   73: ldc_w 1786
    //   76: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -52 -> 29
    //   84: ldc 139
    //   86: ldc_w 1788
    //   89: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -65 -> 29
    //   97: ldc 139
    //   99: ldc_w 1790
    //   102: invokestatic 146	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: aload_0
    //   107: getfield 117	com/tencent/smtt/sdk/p:e	I
    //   110: iconst_1
    //   111: iadd
    //   112: putfield 117	com/tencent/smtt/sdk/p:e	I
    //   115: goto -86 -> 29
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	p
    //   0	123	1	paramContext	Context
    //   1	93	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	118	finally
    //   33	79	118	finally
    //   84	92	118	finally
    //   97	115	118	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.p
 * JD-Core Version:    0.7.0.1
 */