package com.tencent.mm.loader.j;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;

public final class b
{
  private static final String[] icA = { null };
  private static final String[] icv = { null };
  private static final String[] icw = { null };
  private static final String[] icx = { null };
  private static final String[] icy = { null };
  private static final String[] icz = { null };
  
  /* Error */
  public static void A(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 32
    //   5: new 34	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 36
    //   11: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: invokestatic 44	com/tencent/mm/loader/j/b:aKD	()Ljava/lang/String;
    //   17: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 50
    //   22: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokestatic 53	com/tencent/mm/loader/j/b:aKE	()Ljava/lang/String;
    //   28: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iload_1
    //   38: ifeq +54 -> 92
    //   41: getstatic 23	com/tencent/mm/loader/j/b:icy	[Ljava/lang/String;
    //   44: iconst_0
    //   45: aload_0
    //   46: aastore
    //   47: getstatic 17	com/tencent/mm/loader/j/b:icv	[Ljava/lang/String;
    //   50: iconst_0
    //   51: ldc 64
    //   53: aastore
    //   54: ldc 32
    //   56: new 34	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 66
    //   62: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: invokestatic 44	com/tencent/mm/loader/j/b:aKD	()Ljava/lang/String;
    //   68: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 50
    //   73: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 53	com/tencent/mm/loader/j/b:aKE	()Ljava/lang/String;
    //   79: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc 2
    //   90: monitorexit
    //   91: return
    //   92: invokestatic 44	com/tencent/mm/loader/j/b:aKD	()Ljava/lang/String;
    //   95: invokestatic 69	com/tencent/mm/loader/j/b:aKF	()Ljava/lang/String;
    //   98: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifne +9 -> 110
    //   104: getstatic 23	com/tencent/mm/loader/j/b:icy	[Ljava/lang/String;
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: getstatic 25	com/tencent/mm/loader/j/b:icz	[Ljava/lang/String;
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
  
  public static String aKA()
  {
    try
    {
      if (icx[0] != null) {
        break label68;
      }
      Context localContext = MMApplicationContext.getContext();
      if (localContext == null) {
        throw new RuntimeException("MMApplicationContext not initialized.");
      }
    }
    finally {}
    icx[0] = (localObject.getFilesDir().getParentFile().getAbsolutePath() + "/");
    label68:
    String str = icx[0];
    return str;
  }
  
  /* Error */
  public static String aKB()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 34	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 108	com/tencent/mm/loader/j/b:aKA	()Ljava/lang/String;
    //   13: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 110
    //   18: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_0
    //   25: new 95	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 115	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_1
    //   42: invokevirtual 118	java/io/File:mkdirs	()Z
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
  
  public static String aKC()
  {
    try
    {
      String str = aKA() + "files/public/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKD()
  {
    try
    {
      if (icy[0] == null) {
        icy[0] = aKE();
      }
      String str = icy[0];
      return str;
    }
    finally {}
  }
  
  public static String aKE()
  {
    for (;;)
    {
      String[] arrayOfString;
      try
      {
        if (icz[0] == null)
        {
          arrayOfString = icz;
          if (MMApplicationContext.isToolsIsolatedProcess())
          {
            str = "/sdcard";
            break label54;
          }
        }
        else
        {
          str = icz[0];
          return str;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      finally {}
      label54:
      arrayOfString[0] = localObject;
    }
  }
  
  public static String aKF()
  {
    try
    {
      if (icA[0] == null) {
        icA[0] = new File(aKG()).getParentFile().getAbsolutePath();
      }
      String str = icA[0];
      return str;
    }
    finally {}
  }
  
  private static String aKG()
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
  
  public static String aKH()
  {
    try
    {
      String str = aKG() + "/image/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKI()
  {
    try
    {
      String str = aKE() + "/tencent/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKJ()
  {
    try
    {
      String str = aKD() + aKz();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKK()
  {
    try
    {
      String str = aKF() + "/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKL()
  {
    try
    {
      String str = aKJ() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKM()
  {
    try
    {
      String str = aKJ() + "Download/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKN()
  {
    try
    {
      String str = aKJ() + "vusericon/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKO()
  {
    try
    {
      String str = aKJ() + "Game/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKP()
  {
    try
    {
      String str = aKJ() + "CDNTemp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKQ()
  {
    try
    {
      String str = aKJ() + "xlog";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKR()
  {
    try
    {
      String str = aKJ() + "avatar/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKS()
  {
    try
    {
      String str = aKJ() + "Cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKT()
  {
    try
    {
      String str = aKE() + "/tencent/MicroMsg/" + aKW();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKU()
  {
    for (;;)
    {
      try
      {
        localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (localObject1 != null) {
          localObject1 = new File((File)localObject1, aKW());
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
      Object localObject3 = new File(aKF(), "Pictures/" + aKW());
      Object localObject1 = localObject3;
      if (!((File)localObject3).exists())
      {
        localObject1 = localObject3;
        if (!((File)localObject3).mkdirs()) {
          localObject1 = new File(aKT());
        }
      }
    }
  }
  
  /* Error */
  public static String aKV()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 44	com/tencent/mm/loader/j/b:aKD	()Ljava/lang/String;
    //   6: invokestatic 69	com/tencent/mm/loader/j/b:aKF	()Ljava/lang/String;
    //   9: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +12 -> 24
    //   15: invokestatic 211	com/tencent/mm/loader/j/b:aKU	()Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: invokestatic 208	com/tencent/mm/loader/j/b:aKT	()Ljava/lang/String;
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
  private static String aKW()
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
    //   24: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   27: invokestatic 53	com/tencent/mm/loader/j/b:aKE	()Ljava/lang/String;
    //   30: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 226
    //   35: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: new 34	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   49: invokestatic 53	com/tencent/mm/loader/j/b:aKE	()Ljava/lang/String;
    //   52: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 228
    //   57: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: new 95	java/io/File
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: invokevirtual 115	java/io/File:exists	()Z
    //   75: ifeq +9 -> 84
    //   78: ldc 224
    //   80: astore_0
    //   81: goto -66 -> 15
    //   84: new 95	java/io/File
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: invokevirtual 115	java/io/File:exists	()Z
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
  
  public static String aKX()
  {
    try
    {
      String str = aKJ() + "appbrand/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKY()
  {
    try
    {
      String str = aKJ() + "watchdog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKZ()
  {
    try
    {
      String str = aKJ() + "exdevice/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aKz()
  {
    try
    {
      if (icv[0] == null) {
        icv[0] = "/tencent/MicroMsg/";
      }
      String str = icv[0];
      return str;
    }
    finally {}
  }
  
  public static String aLA()
  {
    try
    {
      String str = aKJ() + "temp_video_cache";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLB()
  {
    try
    {
      String str = aKJ() + "egg_spring/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLC()
  {
    try
    {
      String str = aKJ() + "wxvideocache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLD()
  {
    try
    {
      String str = aKJ() + "wxvideotmp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLE()
  {
    try
    {
      String str = aKJ() + "favoffline/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLF()
  {
    try
    {
      String str = aKJ() + "image_crop/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLG()
  {
    try
    {
      String str = aKJ() + "mail/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static String aLH()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 271	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   6: invokestatic 202	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   9: astore_0
    //   10: aload_0
    //   11: astore_1
    //   12: aload_0
    //   13: ifnonnull +17 -> 30
    //   16: new 95	java/io/File
    //   19: dup
    //   20: invokestatic 53	com/tencent/mm/loader/j/b:aKE	()Ljava/lang/String;
    //   23: getstatic 271	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   26: invokespecial 206	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore_1
    //   30: new 95	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokestatic 193	com/tencent/mm/loader/j/b:aKW	()Ljava/lang/String;
    //   38: invokespecial 149	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 152	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 32
    //   55: aload_0
    //   56: ldc_w 273
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aconst_null
    //   67: astore_0
    //   68: goto -58 -> 10
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 101	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
  
  public static void aLI()
  {
    try
    {
      icA[0] = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLa()
  {
    try
    {
      String str = aKJ() + "newyear/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLb()
  {
    try
    {
      String str = aKJ() + "WebviewCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLc()
  {
    try
    {
      String str = aKJ() + "browser/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLd()
  {
    try
    {
      String str = aKJ() + "card/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLe()
  {
    try
    {
      String str = aKJ() + "CheckResUpdate/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLf()
  {
    try
    {
      String str = aKJ() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLg()
  {
    try
    {
      String str = aKJ() + "diskcache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLh()
  {
    try
    {
      String str = aKJ() + "FailMsgFileCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLi()
  {
    try
    {
      String str = aKJ() + "fts/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLj()
  {
    try
    {
      String str = aKJ() + "Handler/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLk()
  {
    try
    {
      String str = aKJ() + "MixAudio/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLl()
  {
    try
    {
      String str = aKJ() + "preloadedRes/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLm()
  {
    try
    {
      String str = aKJ() + "recovery/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLn()
  {
    try
    {
      String str = aKJ() + "share/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLo()
  {
    try
    {
      String str = aLn() + "upload_cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLp()
  {
    try
    {
      String str = aKJ() + "sns_ad_landingpages/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLq()
  {
    try
    {
      String str = aKJ() + "SQLTrace/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLr()
  {
    try
    {
      String str = aKJ() + "tracedog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLs()
  {
    try
    {
      String str = aKJ() + "vproxy/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLt()
  {
    try
    {
      String str = aKJ() + "wagamefiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLu()
  {
    try
    {
      String str = aKJ() + "wallet/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLv()
  {
    try
    {
      String str = aKJ() + "wepkg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLw()
  {
    try
    {
      String str = aKJ() + "wxacache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLx()
  {
    try
    {
      String str = aKJ() + "wxafiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLy()
  {
    try
    {
      String str = aKJ() + "wxajscahce/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aLz()
  {
    try
    {
      String str = aKJ() + "wxanewfiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.b
 * JD-Core Version:    0.7.0.1
 */