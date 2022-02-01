package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class g
{
  static int a = 0;
  static boolean b = false;
  private static g e = null;
  private static int h = 0;
  private static int i = 3;
  private static String k = null;
  private v c = null;
  private v d = null;
  private boolean f = false;
  private boolean g = false;
  private File j = null;
  
  public static g a(boolean paramBoolean)
  {
    if ((e == null) && (paramBoolean)) {}
    try
    {
      if (e == null) {
        e = new g();
      }
      return e;
    }
    finally {}
  }
  
  static void a(int paramInt)
  {
    h = paramInt;
  }
  
  private void b(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(k, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.j, "count.prop")), null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static int d()
  {
    return h;
  }
  
  /* Error */
  private int i()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 73	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 49	com/tencent/smtt/sdk/g:j	Ljava/io/File;
    //   10: ldc 75
    //   12: invokespecial 78	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 96	java/io/File:exists	()Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +26 -> 50
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 98	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 99	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: iload_1
    //   40: ireturn
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   48: iconst_0
    //   49: ireturn
    //   50: new 101	java/io/BufferedInputStream
    //   53: dup
    //   54: new 103	java/io/FileInputStream
    //   57: dup
    //   58: aload 4
    //   60: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 107	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: new 58	java/util/Properties
    //   75: dup
    //   76: invokespecial 59	java/util/Properties:<init>	()V
    //   79: astore 6
    //   81: aload 5
    //   83: astore 4
    //   85: aload 6
    //   87: aload 5
    //   89: invokevirtual 110	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   92: aload 5
    //   94: astore 4
    //   96: aload 6
    //   98: getstatic 35	com/tencent/smtt/sdk/g:k	Ljava/lang/String;
    //   101: ldc 112
    //   103: invokevirtual 116	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 121	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   109: invokevirtual 124	java/lang/Integer:intValue	()I
    //   112: istore_2
    //   113: iload_2
    //   114: istore_1
    //   115: aload 5
    //   117: ifnull -78 -> 39
    //   120: aload 5
    //   122: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   125: iload_2
    //   126: ireturn
    //   127: astore 4
    //   129: aload 4
    //   131: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   134: iload_2
    //   135: ireturn
    //   136: astore 6
    //   138: aconst_null
    //   139: astore 5
    //   141: aload 5
    //   143: astore 4
    //   145: aload 6
    //   147: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   150: aload 5
    //   152: ifnull -113 -> 39
    //   155: aload 5
    //   157: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore 5
    //   173: aconst_null
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +8 -> 186
    //   181: aload 4
    //   183: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   186: aload 5
    //   188: athrow
    //   189: astore 4
    //   191: aload 4
    //   193: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   196: goto -10 -> 186
    //   199: astore 5
    //   201: goto -25 -> 176
    //   204: astore 6
    //   206: goto -65 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	g
    //   1	114	1	m	int
    //   112	23	2	n	int
    //   22	2	3	bool	boolean
    //   15	3	4	localFile	File
    //   41	18	4	localIOException1	IOException
    //   70	25	4	localObject1	Object
    //   127	3	4	localIOException2	IOException
    //   143	1	4	localObject2	Object
    //   162	3	4	localIOException3	IOException
    //   174	8	4	localObject3	Object
    //   189	3	4	localIOException4	IOException
    //   66	90	5	localBufferedInputStream	java.io.BufferedInputStream
    //   171	16	5	localObject4	Object
    //   199	1	5	localObject5	Object
    //   79	18	6	localProperties	Properties
    //   136	10	6	localException1	java.lang.Exception
    //   204	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   120	125	127	java/io/IOException
    //   2	23	136	java/lang/Exception
    //   50	68	136	java/lang/Exception
    //   155	160	162	java/io/IOException
    //   2	23	171	finally
    //   50	68	171	finally
    //   181	186	189	java/io/IOException
    //   72	81	199	finally
    //   85	92	199	finally
    //   96	113	199	finally
    //   145	150	199	finally
    //   72	81	204	java/lang/Exception
    //   85	92	204	java/lang/Exception
    //   96	113	204	java/lang/Exception
  }
  
  public v a()
  {
    if (this.f) {
      return this.c;
    }
    return null;
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 1;
    int n = 0;
    boolean bool2;
    label233:
    Object localObject4;
    Object localObject5;
    Object localObject3;
    label382:
    int m;
    label412:
    label440:
    label455:
    label490:
    Object localObject2;
    for (;;)
    {
      try
      {
        TbsLog.initIfNeed(paramContext);
        a += 1;
        TbsLog.i("SDKEngine", "init", "#1# context: " + paramContext + ", mInitCount: " + a);
        Object localObject1 = p.a();
        boolean bool1;
        if (a == 1)
        {
          bool1 = true;
          ((p)localObject1).b(paramContext, bool1);
          p.a().l(paramContext);
          TbsShareManager.forceToLoadX5ForThirdApp(paramContext, true);
          bool2 = QbSdk.a(paramContext, paramBoolean1, paramBoolean2);
          TbsLog.i("SDKEngine", "init", "#2# canLoadX5 is " + bool2);
          if (Build.VERSION.SDK_INT >= 7)
          {
            paramBoolean2 = true;
            break label795;
            bool1 = paramBoolean1;
            if (paramBoolean1)
            {
              long l = System.currentTimeMillis();
              bool1 = p.a().g(paramContext, d());
              TbsLog.i("SDKEngine", "init", "isTbsCoreLegal: " + bool1 + "; cost: " + (System.currentTimeMillis() - l));
            }
            if (!bool1) {
              break label693;
            }
            paramBoolean1 = this.f;
            if (!paramBoolean1) {
              continue;
            }
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        paramBoolean2 = false;
        break label795;
        paramBoolean1 = false;
        continue;
        TbsLog.i("SDKEngine", "init", "#3# start to load tbs");
        try
        {
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break label455;
          }
          paramBoolean1 = TbsShareManager.j(paramContext);
          TbsLog.i("SDKEngine", "init", "#3-1# isShareTbsCoreAvailable: " + paramBoolean1);
          if (!paramBoolean1) {
            break label440;
          }
          localObject4 = new File(TbsShareManager.c(paramContext));
          localObject5 = p.a().r(paramContext);
          localObject1 = TbsShareManager.e(paramContext);
          localObject3 = localObject5;
          if (localObject5 != null) {
            break;
          }
          this.f = false;
          QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
        }
        catch (Throwable localThrowable)
        {
          TbsLog.e("SDKEngine", "useSystemWebView by exception: " + localThrowable);
          if (localThrowable != null) {
            break label678;
          }
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 326);
        this.f = false;
        QbSdk.a(paramContext, "SDKEngine::useSystemWebView by exception: " + localThrowable);
        d.a().a(paramContext);
        this.j = p.t(paramContext);
        this.g = true;
        continue;
        this.f = false;
      }
      finally {}
      QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
      continue;
      localObject3 = p.a().r(paramContext);
      m = i1;
      if (h != 25436)
      {
        if (h != 25437) {
          break label809;
        }
        m = i1;
      }
      if (m == 0) {
        break label815;
      }
      localObject2 = paramContext.getApplicationContext();
      label501:
      if (localObject3 != null) {
        break label821;
      }
      this.f = false;
      QbSdk.a(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
    }
    for (;;)
    {
      localObject5 = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject2, ((File)localObject4).getAbsolutePath());
      m = n;
      while (m < localObject5.length) {
        m += 1;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null)
      {
        localObject3 = TbsShareManager.getHostCorePathAppDefined();
        label566:
        TbsLog.i("SDKEngine", "init", "#4# optDir is " + (String)localObject3);
        if (this.d == null) {
          break label649;
        }
        this.c = this.d;
        this.c.a(paramContext, (Context)localObject2, ((File)localObject4).getAbsolutePath(), (String)localObject3, (String[])localObject5, QbSdk.d);
      }
      for (;;)
      {
        this.f = true;
        break;
        localObject3 = ((File)localObject3).getAbsolutePath();
        break label566;
        label649:
        this.c = new v(paramContext, (Context)localObject2, ((File)localObject4).getAbsolutePath(), (String)localObject3, (String[])localObject5, QbSdk.d);
      }
      label678:
      TbsCoreLoadStat.getInstance().a(paramContext, 327, (Throwable)localObject2);
      break label382;
      label693:
      localObject2 = "QbSdk.canLoadX5 = " + bool2 + "; is_compatible = " + paramBoolean2;
      TbsLog.e("SDKEngine", "init", "canLoadTbs = false; failure: " + (String)localObject2);
      if ((QbSdk.a) && (this.f)) {
        break label412;
      }
      this.f = false;
      TbsCoreLoadStat.getInstance().a(paramContext, 405);
      TbsLog.e("SDKEngine", "init", "[LoadError] check log upon for details");
      break label412;
      label795:
      if ((!bool2) || (!paramBoolean2)) {
        break label233;
      }
      paramBoolean1 = true;
      break;
      label809:
      m = 0;
      break label490;
      label815:
      localObject2 = paramContext;
      break label501;
      label821:
      localObject4 = localObject3;
    }
  }
  
  void a(String paramString)
  {
    k = paramString;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  boolean b(boolean paramBoolean)
  {
    b = paramBoolean;
    return paramBoolean;
  }
  
  v c()
  {
    return this.c;
  }
  
  public String e()
  {
    if ((this.c == null) || (QbSdk.a)) {
      return "system webview get nothing...";
    }
    return this.c.a();
  }
  
  boolean f()
  {
    int m;
    if (b)
    {
      if (k == null) {
        return false;
      }
      m = i();
      if (m != 0) {
        break label32;
      }
      b(1);
    }
    for (;;)
    {
      return b;
      label32:
      if (m + 1 > i) {
        break;
      }
      b(m + 1);
    }
  }
  
  boolean g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return QbSdk.useSoftWare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.g
 * JD-Core Version:    0.7.0.1
 */