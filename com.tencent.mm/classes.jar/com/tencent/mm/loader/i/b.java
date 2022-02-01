package com.tencent.mm.loader.i;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;

public final class b
{
  private static final String[] nsF = { null };
  private static final String[] nsG = { null };
  private static final String[] nsH = { null };
  private static final String[] nsI = { null };
  private static final String[] nsJ = { null };
  private static final String[] nsK = { null };
  
  /* Error */
  public static void F(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 32
    //   5: new 34	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 36
    //   11: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: invokestatic 44	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   17: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 50
    //   22: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokestatic 53	com/tencent/mm/loader/i/b:bmu	()Ljava/lang/String;
    //   28: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iload_1
    //   38: ifeq +54 -> 92
    //   41: getstatic 23	com/tencent/mm/loader/i/b:nsI	[Ljava/lang/String;
    //   44: iconst_0
    //   45: aload_0
    //   46: aastore
    //   47: getstatic 17	com/tencent/mm/loader/i/b:nsF	[Ljava/lang/String;
    //   50: iconst_0
    //   51: ldc 64
    //   53: aastore
    //   54: ldc 32
    //   56: new 34	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 66
    //   62: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: invokestatic 44	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   68: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 50
    //   73: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 53	com/tencent/mm/loader/i/b:bmu	()Ljava/lang/String;
    //   79: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc 2
    //   90: monitorexit
    //   91: return
    //   92: invokestatic 44	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   95: invokestatic 69	com/tencent/mm/loader/i/b:bmv	()Ljava/lang/String;
    //   98: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifne +9 -> 110
    //   104: getstatic 23	com/tencent/mm/loader/i/b:nsI	[Ljava/lang/String;
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: getstatic 25	com/tencent/mm/loader/i/b:nsJ	[Ljava/lang/String;
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
  
  public static String bmA()
  {
    try
    {
      String str = bmv() + "/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmB()
  {
    try
    {
      String str = bmz() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmC()
  {
    try
    {
      String str = bmz() + "Download/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmD()
  {
    try
    {
      String str = bmz() + "vusericon/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmE()
  {
    try
    {
      String str = bmz() + "Game/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmF()
  {
    try
    {
      String str = bmz() + "CDNTemp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmG()
  {
    try
    {
      String str = bmz() + "xlog";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmH()
  {
    try
    {
      String str = bmz() + "avatar/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmI()
  {
    try
    {
      String str = bmz() + "Cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmJ()
  {
    try
    {
      String str = bmu() + "/tencent/MicroMsg/" + bmM();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmK()
  {
    for (;;)
    {
      try
      {
        localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (localObject1 != null) {
          localObject1 = new File((File)localObject1, bmM());
        }
      }
      finally {}
      try
      {
        localObject3 = ((File)localObject1).getCanonicalPath() + "/";
        localObject1 = localObject3;
      }
      finally
      {
        String str = localObject2.getAbsolutePath() + "/";
      }
      return localObject1;
      Object localObject3 = new File(bmv(), "Pictures/" + bmM());
      Object localObject1 = localObject3;
      if (!((File)localObject3).exists())
      {
        localObject1 = localObject3;
        if (!((File)localObject3).mkdirs()) {
          localObject1 = new File(bmJ());
        }
      }
    }
  }
  
  /* Error */
  public static String bmL()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 44	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   6: invokestatic 69	com/tencent/mm/loader/i/b:bmv	()Ljava/lang/String;
    //   9: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +12 -> 24
    //   15: invokestatic 150	com/tencent/mm/loader/i/b:bmK	()Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: invokestatic 143	com/tencent/mm/loader/i/b:bmJ	()Ljava/lang/String;
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
  private static String bmM()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 156	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo:current	()Lcom/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp;
    //   6: invokevirtual 161	com/tencent/mm/sdk/platformtools/WeChatBrands$AppInfo$WhichApp:isUS	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 163
    //   14: astore_0
    //   15: ldc 2
    //   17: monitorexit
    //   18: aload_0
    //   19: areturn
    //   20: new 34	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   27: invokestatic 53	com/tencent/mm/loader/i/b:bmu	()Ljava/lang/String;
    //   30: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 165
    //   35: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: new 34	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   49: invokestatic 53	com/tencent/mm/loader/i/b:bmu	()Ljava/lang/String;
    //   52: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 167
    //   57: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: new 122	java/io/File
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: invokevirtual 138	java/io/File:exists	()Z
    //   75: ifeq +9 -> 84
    //   78: ldc 163
    //   80: astore_0
    //   81: goto -66 -> 15
    //   84: new 122	java/io/File
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: invokevirtual 138	java/io/File:exists	()Z
    //   95: ifeq +9 -> 104
    //   98: ldc 169
    //   100: astore_0
    //   101: goto -86 -> 15
    //   104: invokestatic 174	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   107: ldc 176
    //   109: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: ifeq +9 -> 121
    //   115: ldc 169
    //   117: astore_0
    //   118: goto -103 -> 15
    //   121: ldc 163
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
  
  public static String bmN()
  {
    try
    {
      String str = bmz() + "appbrand/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmO()
  {
    try
    {
      String str = bmz() + "watchdog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmP()
  {
    try
    {
      String str = bmz() + "exdevice/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmQ()
  {
    try
    {
      String str = bmz() + "newyear/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmR()
  {
    try
    {
      String str = bmz() + "WebviewCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmS()
  {
    try
    {
      String str = bmz() + "browser/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmT()
  {
    try
    {
      String str = bmz() + "card/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmU()
  {
    try
    {
      String str = bmz() + "CheckResUpdate/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmV()
  {
    try
    {
      String str = bmz() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmW()
  {
    try
    {
      String str = bmz() + "diskcache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmX()
  {
    try
    {
      String str = bmz() + "FailMsgFileCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmY()
  {
    try
    {
      String str = bmz() + "fts/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmZ()
  {
    try
    {
      String str = bmz() + "Handler/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmp()
  {
    try
    {
      if (nsF[0] == null) {
        nsF[0] = "/tencent/MicroMsg/";
      }
      String str = nsF[0];
      return str;
    }
    finally {}
  }
  
  public static String bmq()
  {
    try
    {
      if (nsH[0] != null) {
        break label68;
      }
      Context localContext = MMApplicationContext.getContext();
      if (localContext == null) {
        throw new RuntimeException("MMApplicationContext not initialized.");
      }
    }
    finally {}
    nsH[0] = (localObject.getFilesDir().getParentFile().getAbsolutePath() + "/");
    label68:
    String str = nsH[0];
    return str;
  }
  
  /* Error */
  public static String bmr()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 34	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 238	com/tencent/mm/loader/i/b:bmq	()Ljava/lang/String;
    //   13: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 240
    //   18: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_0
    //   25: new 122	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 138	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_1
    //   42: invokevirtual 141	java/io/File:mkdirs	()Z
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
    //   51	5	0	localObject1	Object
    //   33	9	1	localFile	File
    //   57	1	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	25	51	finally
    //   25	46	57	finally
  }
  
  public static String bms()
  {
    try
    {
      String str = bmq() + "files/public/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmt()
  {
    try
    {
      if (nsI[0] == null) {
        nsI[0] = bmv();
      }
      String str = nsI[0];
      return str;
    }
    finally {}
  }
  
  public static String bmu()
  {
    for (;;)
    {
      String[] arrayOfString;
      try
      {
        if (nsJ[0] == null)
        {
          arrayOfString = nsJ;
          if (MMApplicationContext.isToolsIsolatedProcess())
          {
            str = "/sdcard";
            break label54;
          }
        }
        else
        {
          str = nsJ[0];
          return str;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      finally {}
      label54:
      arrayOfString[0] = localObject;
    }
  }
  
  public static String bmv()
  {
    try
    {
      if (nsK[0] == null) {
        nsK[0] = new File(bmw()).getParentFile().getAbsolutePath();
      }
      String str = nsK[0];
      return str;
    }
    finally {}
  }
  
  /* Error */
  private static String bmw()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 221	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +19 -> 29
    //   13: new 223	java/lang/RuntimeException
    //   16: dup
    //   17: ldc 225
    //   19: invokespecial 226	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    //   29: aload_2
    //   30: invokevirtual 257	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +140 -> 175
    //   38: aload_2
    //   39: invokevirtual 138	java/io/File:exists	()Z
    //   42: ifne +133 -> 175
    //   45: aload_2
    //   46: invokevirtual 141	java/io/File:mkdirs	()Z
    //   49: istore_0
    //   50: iload_0
    //   51: ifne +124 -> 175
    //   54: aload_1
    //   55: astore_2
    //   56: aload_1
    //   57: ifnonnull +78 -> 135
    //   60: invokestatic 246	com/tencent/mm/sdk/platformtools/MMApplicationContext:isToolsIsolatedProcess	()Z
    //   63: ifeq +82 -> 145
    //   66: invokestatic 251	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull +101 -> 172
    //   74: new 122	java/io/File
    //   77: dup
    //   78: ldc_w 259
    //   81: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore_1
    //   85: new 122	java/io/File
    //   88: dup
    //   89: aload_1
    //   90: new 34	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 261
    //   97: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: invokestatic 264	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   103: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 266
    //   109: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 125	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   118: astore_1
    //   119: aload_1
    //   120: astore_2
    //   121: aload_1
    //   122: invokevirtual 138	java/io/File:exists	()Z
    //   125: ifne +10 -> 135
    //   128: aload_1
    //   129: invokevirtual 141	java/io/File:mkdirs	()Z
    //   132: pop
    //   133: aload_1
    //   134: astore_2
    //   135: aload_2
    //   136: invokevirtual 128	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   139: astore_1
    //   140: ldc 2
    //   142: monitorexit
    //   143: aload_1
    //   144: areturn
    //   145: new 122	java/io/File
    //   148: dup
    //   149: ldc_w 259
    //   152: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore_1
    //   156: goto -71 -> 85
    //   159: astore_1
    //   160: aload_2
    //   161: invokevirtual 147	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   164: astore_1
    //   165: goto -25 -> 140
    //   168: astore_2
    //   169: goto -115 -> 54
    //   172: goto -87 -> 85
    //   175: aload_2
    //   176: astore_1
    //   177: goto -123 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	2	0	bool	boolean
    //   1	1	1	localObject1	Object
    //   23	34	1	localObject2	Object
    //   69	87	1	localObject3	Object
    //   159	1	1	localObject4	Object
    //   164	13	1	localObject5	Object
    //   8	153	2	localObject6	Object
    //   168	8	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	23	finally
    //   13	23	23	finally
    //   60	70	23	finally
    //   74	85	23	finally
    //   85	119	23	finally
    //   121	133	23	finally
    //   145	156	23	finally
    //   160	165	23	finally
    //   135	140	159	finally
    //   29	34	168	finally
    //   38	50	168	finally
  }
  
  public static String bmx()
  {
    try
    {
      String str = bmw() + "/image/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmy()
  {
    try
    {
      String str = bmu() + "/tencent/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bmz()
  {
    try
    {
      String str = bmt() + bmp();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnA()
  {
    try
    {
      String str = bmz() + "appbrand/appBrandXnetModelCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnB()
  {
    try
    {
      localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
      localObject5 = localObject1;
      if (localObject1 != null) {}
    }
    finally
    {
      try
      {
        localObject5 = new File(bmu(), Environment.DIRECTORY_DOWNLOADS);
        localObject5 = new File((File)localObject5, bmM());
      }
      finally
      {
        try
        {
          Object localObject1;
          return localObject1;
          localThrowable = finally;
          Log.printErrStackTrace("MicroMsg.CConstants", localThrowable, "[-] Fail to get public download path from system.", new Object[0]);
          Object localObject2 = null;
        }
        finally
        {
          for (;;)
          {
            Object localObject5;
            String str = ((File)localObject5).getAbsolutePath();
          }
          localObject4 = finally;
        }
      }
    }
  }
  
  public static void bnC()
  {
    try
    {
      nsK[0] = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bna()
  {
    try
    {
      String str = bmz() + "MixAudio/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnb()
  {
    try
    {
      String str = bmz() + "preloadedRes/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnc()
  {
    try
    {
      String str = bmz() + "recovery/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnd()
  {
    try
    {
      String str = bmz() + "share/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bne()
  {
    try
    {
      String str = bnd() + "upload_cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnf()
  {
    try
    {
      String str = bmz() + "sns_ad_landingpages/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bng()
  {
    try
    {
      String str = bmz() + "SQLTrace/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnh()
  {
    try
    {
      String str = bmz() + "tracedog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bni()
  {
    try
    {
      String str = bmz() + "vproxy/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnj()
  {
    try
    {
      String str = bmz() + "wagamefiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnk()
  {
    try
    {
      String str = bmz() + "wallet/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnl()
  {
    try
    {
      String str = bmz() + "wepkg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnm()
  {
    try
    {
      String str = bmz() + "wxacache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnn()
  {
    try
    {
      String str = bmz() + "wxafiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bno()
  {
    try
    {
      String str = bmr() + "appbrand/jscache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnp()
  {
    try
    {
      String str = bmr() + "appbrand/wasmcache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnq()
  {
    try
    {
      String str = bmr() + "appbrand/emojicache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnr()
  {
    try
    {
      String str = bmz() + "wxanewfiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bns()
  {
    try
    {
      String str = bmz() + "appbrand/secureInput/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnt()
  {
    try
    {
      String str = bmz() + "temp_video_cache";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnu()
  {
    try
    {
      String str = bmz() + "egg_spring/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnv()
  {
    try
    {
      String str = bmz() + "wxvideocache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnw()
  {
    try
    {
      String str = bmz() + "wxvideotmp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnx()
  {
    try
    {
      String str = bmz() + "favoffline/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bny()
  {
    try
    {
      String str = bmz() + "image_crop/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bnz()
  {
    try
    {
      String str = bmz() + "mail/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.i.b
 * JD-Core Version:    0.7.0.1
 */