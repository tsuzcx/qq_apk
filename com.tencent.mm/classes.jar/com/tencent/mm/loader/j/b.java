package com.tencent.mm.loader.j;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;

public final class b
{
  private static final String[] kRc = { null };
  private static final String[] kRd = { null };
  private static final String[] kRe = { null };
  private static final String[] kRf = { null };
  private static final String[] kRg = { null };
  private static final String[] kRh = { null };
  
  /* Error */
  public static void C(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 32
    //   5: new 34	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 36
    //   11: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: invokestatic 44	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   17: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 50
    //   22: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokestatic 53	com/tencent/mm/loader/j/b:aSG	()Ljava/lang/String;
    //   28: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iload_1
    //   38: ifeq +54 -> 92
    //   41: getstatic 23	com/tencent/mm/loader/j/b:kRf	[Ljava/lang/String;
    //   44: iconst_0
    //   45: aload_0
    //   46: aastore
    //   47: getstatic 17	com/tencent/mm/loader/j/b:kRc	[Ljava/lang/String;
    //   50: iconst_0
    //   51: ldc 64
    //   53: aastore
    //   54: ldc 32
    //   56: new 34	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 66
    //   62: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: invokestatic 44	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   68: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 50
    //   73: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 53	com/tencent/mm/loader/j/b:aSG	()Ljava/lang/String;
    //   79: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc 2
    //   90: monitorexit
    //   91: return
    //   92: invokestatic 44	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   95: invokestatic 69	com/tencent/mm/loader/j/b:aSH	()Ljava/lang/String;
    //   98: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifne +9 -> 110
    //   104: getstatic 23	com/tencent/mm/loader/j/b:kRf	[Ljava/lang/String;
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: getstatic 25	com/tencent/mm/loader/j/b:kRg	[Ljava/lang/String;
    //   113: iconst_0
    //   114: aload_0
    //   115: aastore
    //   116: goto -62 -> 54
    //   119: astore_0
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   0	125	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	37	119	finally
    //   41	54	119	finally
    //   54	88	119	finally
    //   92	110	119	finally
    //   110	116	119	finally
  }
  
  public static String aSB()
  {
    try
    {
      if (kRc[0] == null) {
        kRc[0] = "/tencent/MicroMsg/";
      }
      String str = kRc[0];
      return str;
    }
    finally {}
  }
  
  public static String aSC()
  {
    try
    {
      if (kRe[0] != null) {
        break label68;
      }
      Context localContext = MMApplicationContext.getContext();
      if (localContext == null) {
        throw new RuntimeException("MMApplicationContext not initialized.");
      }
    }
    finally {}
    kRe[0] = (localObject.getFilesDir().getParentFile().getAbsolutePath() + "/");
    label68:
    String str = kRe[0];
    return str;
  }
  
  /* Error */
  public static String aSD()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 34	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 111	com/tencent/mm/loader/j/b:aSC	()Ljava/lang/String;
    //   13: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 113
    //   18: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_0
    //   25: new 98	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 118	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_1
    //   42: invokevirtual 121	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: astore_1
    //   58: goto -12 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	26	0	str	String
    //   51	5	0	localObject	Object
    //   33	9	1	localFile	File
    //   57	1	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   3	25	51	finally
    //   25	46	51	finally
    //   25	46	57	java/lang/Throwable
  }
  
  public static String aSE()
  {
    try
    {
      String str = aSC() + "files/public/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSF()
  {
    try
    {
      if (kRf[0] == null) {
        kRf[0] = aSH();
      }
      String str = kRf[0];
      return str;
    }
    finally {}
  }
  
  public static String aSG()
  {
    for (;;)
    {
      String[] arrayOfString;
      try
      {
        if (kRg[0] == null)
        {
          arrayOfString = kRg;
          if (MMApplicationContext.isToolsIsolatedProcess())
          {
            str = "/sdcard";
            break label54;
          }
        }
        else
        {
          str = kRg[0];
          return str;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      finally {}
      label54:
      arrayOfString[0] = localObject;
    }
  }
  
  public static String aSH()
  {
    try
    {
      if (kRh[0] == null) {
        kRh[0] = new File(aSI()).getParentFile().getAbsolutePath();
      }
      String str = kRh[0];
      return str;
    }
    finally {}
  }
  
  private static String aSI()
  {
    Object localObject1 = null;
    try
    {
      localObject5 = MMApplicationContext.getContext();
      if (localObject5 == null) {
        throw new RuntimeException("MMApplicationContext not initialized.");
      }
    }
    finally {}
    try
    {
      localObject5 = ((Context)localObject5).getExternalCacheDir();
      if ((localObject5 == null) || (((File)localObject5).exists())) {
        break label171;
      }
      boolean bool = ((File)localObject5).mkdirs();
      if (bool) {
        break label171;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        Object localObject3;
        label142:
        continue;
        continue;
        Object localObject4 = localThrowable2;
      }
    }
    Object localObject5 = localObject2;
    if (localObject2 == null)
    {
      if (!MMApplicationContext.isToolsIsolatedProcess()) {
        break label142;
      }
      localObject3 = Environment.getExternalStorageDirectory();
      if (localObject3 != null) {
        break label168;
      }
      localObject3 = new File("/sdcard/");
    }
    for (;;)
    {
      localObject3 = new File((File)localObject3, "Android/data/" + MMApplicationContext.getApplicationId() + "/cache");
      localObject5 = localObject3;
      if (!((File)localObject3).exists())
      {
        ((File)localObject3).mkdirs();
        localObject5 = localObject3;
      }
      try
      {
        localObject3 = ((File)localObject5).getCanonicalPath();
        return localObject3;
        localObject3 = new File("/sdcard/");
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localObject4 = ((File)localObject5).getAbsolutePath();
        }
      }
    }
  }
  
  public static String aSJ()
  {
    try
    {
      String str = aSI() + "/image/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSK()
  {
    try
    {
      String str = aSG() + "/tencent/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSL()
  {
    try
    {
      String str = aSF() + aSB();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSM()
  {
    try
    {
      String str = aSH() + "/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSN()
  {
    try
    {
      String str = aSL() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSO()
  {
    try
    {
      String str = aSL() + "Download/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSP()
  {
    try
    {
      String str = aSL() + "vusericon/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSQ()
  {
    try
    {
      String str = aSL() + "Game/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSR()
  {
    try
    {
      String str = aSL() + "CDNTemp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSS()
  {
    try
    {
      String str = aSL() + "xlog";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aST()
  {
    try
    {
      String str = aSL() + "avatar/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSU()
  {
    try
    {
      String str = aSL() + "Cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSV()
  {
    try
    {
      String str = aSG() + "/tencent/MicroMsg/" + aSY();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aSW()
  {
    for (;;)
    {
      try
      {
        localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (localObject1 != null) {
          localObject1 = new File((File)localObject1, aSY());
        }
      }
      finally {}
      try
      {
        localObject3 = ((File)localObject1).getCanonicalPath() + "/";
        localObject1 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        String str = localObject2.getAbsolutePath() + "/";
        continue;
      }
      return localObject1;
      Object localObject3 = new File(aSH(), "Pictures/" + aSY());
      Object localObject1 = localObject3;
      if (!((File)localObject3).exists())
      {
        localObject1 = localObject3;
        if (!((File)localObject3).mkdirs()) {
          localObject1 = new File(aSV());
        }
      }
    }
  }
  
  /* Error */
  public static String aSX()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 44	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   6: invokestatic 69	com/tencent/mm/loader/j/b:aSH	()Ljava/lang/String;
    //   9: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +12 -> 24
    //   15: invokestatic 211	com/tencent/mm/loader/j/b:aSW	()Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: invokestatic 208	com/tencent/mm/loader/j/b:aSV	()Ljava/lang/String;
    //   27: astore_0
    //   28: goto -9 -> 19
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	10	0	str	String
    //   31	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	31	finally
    //   24	28	31	finally
  }
  
  /* Error */
  private static String aSY()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 217	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo:current	()Lcom/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp;
    //   6: invokevirtual 222	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp:isUS	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 224
    //   14: astore_0
    //   15: ldc 2
    //   17: monitorexit
    //   18: aload_0
    //   19: areturn
    //   20: new 34	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   27: invokestatic 53	com/tencent/mm/loader/j/b:aSG	()Ljava/lang/String;
    //   30: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 226
    //   35: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: new 34	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   49: invokestatic 53	com/tencent/mm/loader/j/b:aSG	()Ljava/lang/String;
    //   52: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 228
    //   57: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: new 98	java/io/File
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: invokevirtual 118	java/io/File:exists	()Z
    //   75: ifeq +9 -> 84
    //   78: ldc 224
    //   80: astore_0
    //   81: goto -66 -> 15
    //   84: new 98	java/io/File
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: invokevirtual 118	java/io/File:exists	()Z
    //   95: ifeq +9 -> 104
    //   98: ldc 230
    //   100: astore_0
    //   101: goto -86 -> 15
    //   104: invokestatic 235	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   107: ldc 237
    //   109: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: ifeq +9 -> 121
    //   115: ldc 230
    //   117: astore_0
    //   118: goto -103 -> 15
    //   121: ldc 224
    //   123: astore_0
    //   124: goto -109 -> 15
    //   127: astore_0
    //   128: ldc 2
    //   130: monitorexit
    //   131: aload_0
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	110	0	str1	String
    //   127	5	0	localObject	Object
    //   63	26	1	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	12	127	finally
    //   20	78	127	finally
    //   84	98	127	finally
    //   104	115	127	finally
  }
  
  public static String aSZ()
  {
    try
    {
      String str = aSL() + "appbrand/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTA()
  {
    try
    {
      String str = aSD() + "appbrand/jscache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTB()
  {
    try
    {
      String str = aSD() + "appbrand/wasmcache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTC()
  {
    try
    {
      String str = aSD() + "appbrand/emojicache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTD()
  {
    try
    {
      String str = aSL() + "wxanewfiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTE()
  {
    try
    {
      String str = aSL() + "appbrand/secureInput/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTF()
  {
    try
    {
      String str = aSL() + "temp_video_cache";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTG()
  {
    try
    {
      String str = aSL() + "egg_spring/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTH()
  {
    try
    {
      String str = aSL() + "wxvideocache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTI()
  {
    try
    {
      String str = aSL() + "wxvideotmp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTJ()
  {
    try
    {
      String str = aSL() + "favoffline/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTK()
  {
    try
    {
      String str = aSL() + "image_crop/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTL()
  {
    try
    {
      String str = aSL() + "mail/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static String aTM()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 282	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   6: invokestatic 202	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   9: astore_0
    //   10: aload_0
    //   11: astore_1
    //   12: aload_0
    //   13: ifnonnull +17 -> 30
    //   16: new 98	java/io/File
    //   19: dup
    //   20: invokestatic 53	com/tencent/mm/loader/j/b:aSG	()Ljava/lang/String;
    //   23: getstatic 282	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   26: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore_1
    //   30: new 98	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokestatic 193	com/tencent/mm/loader/j/b:aSY	()Ljava/lang/String;
    //   38: invokespecial 152	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 155	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 32
    //   55: aload_0
    //   56: ldc_w 284
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aconst_null
    //   67: astore_0
    //   68: goto -58 -> 10
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 104	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   76: astore_0
    //   77: goto -30 -> 47
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	42	0	localObject1	Object
    //   52	4	0	localThrowable1	Throwable
    //   67	1	0	localObject2	Object
    //   71	1	0	localThrowable2	Throwable
    //   76	1	0	str	String
    //   80	5	0	localObject3	Object
    //   11	62	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	10	52	java/lang/Throwable
    //   42	47	71	java/lang/Throwable
    //   3	10	80	finally
    //   16	30	80	finally
    //   30	42	80	finally
    //   42	47	80	finally
    //   53	66	80	finally
    //   72	77	80	finally
  }
  
  public static void aTN()
  {
    try
    {
      kRh[0] = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTa()
  {
    try
    {
      String str = aSL() + "watchdog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTb()
  {
    try
    {
      String str = aSL() + "exdevice/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTc()
  {
    try
    {
      String str = aSL() + "newyear/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTd()
  {
    try
    {
      String str = aSL() + "WebviewCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTe()
  {
    try
    {
      String str = aSL() + "browser/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTf()
  {
    try
    {
      String str = aSL() + "card/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTg()
  {
    try
    {
      String str = aSL() + "CheckResUpdate/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTh()
  {
    try
    {
      String str = aSL() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTi()
  {
    try
    {
      String str = aSL() + "diskcache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTj()
  {
    try
    {
      String str = aSL() + "FailMsgFileCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTk()
  {
    try
    {
      String str = aSL() + "fts/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTl()
  {
    try
    {
      String str = aSL() + "Handler/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTm()
  {
    try
    {
      String str = aSL() + "MixAudio/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTn()
  {
    try
    {
      String str = aSL() + "preloadedRes/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTo()
  {
    try
    {
      String str = aSL() + "recovery/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTp()
  {
    try
    {
      String str = aSL() + "share/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTq()
  {
    try
    {
      String str = aTp() + "upload_cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTr()
  {
    try
    {
      String str = aSL() + "sns_ad_landingpages/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTs()
  {
    try
    {
      String str = aSL() + "SQLTrace/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTt()
  {
    try
    {
      String str = aSL() + "tracedog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTu()
  {
    try
    {
      String str = aSL() + "vproxy/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTv()
  {
    try
    {
      String str = aSL() + "wagamefiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTw()
  {
    try
    {
      String str = aSL() + "wallet/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTx()
  {
    try
    {
      String str = aSL() + "wepkg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTy()
  {
    try
    {
      String str = aSL() + "wxacache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aTz()
  {
    try
    {
      String str = aSL() + "wxafiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.j.b
 * JD-Core Version:    0.7.0.1
 */