package com.tencent.mm.loader.j;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.File;

public final class b
{
  private static final String[] hjA = { null };
  private static final String[] hjB = { null };
  private static final String[] hjC = { null };
  private static final String[] hjD = { null };
  private static final String[] hjE = { null };
  private static final String[] hjz = { null };
  
  public static String arZ()
  {
    try
    {
      if (hjz[0] == null) {
        hjz[0] = "/tencent/MicroMsg/";
      }
      String str = hjz[0];
      return str;
    }
    finally {}
  }
  
  public static String asA()
  {
    try
    {
      String str = asj() + "newyear/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asB()
  {
    try
    {
      String str = asj() + "WebviewCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asC()
  {
    try
    {
      String str = asj() + "browser/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asD()
  {
    try
    {
      String str = asj() + "card/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asE()
  {
    try
    {
      String str = asj() + "CheckResUpdate/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asF()
  {
    try
    {
      String str = asj() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asG()
  {
    try
    {
      String str = asj() + "diskcache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asH()
  {
    try
    {
      String str = asj() + "FailMsgFileCache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asI()
  {
    try
    {
      String str = asj() + "fts/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asJ()
  {
    try
    {
      String str = asj() + "Handler/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asK()
  {
    try
    {
      String str = asj() + "MixAudio/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asL()
  {
    try
    {
      String str = asj() + "preloadedRes/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asM()
  {
    try
    {
      String str = asj() + "recovery/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asN()
  {
    try
    {
      String str = asj() + "share/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asO()
  {
    try
    {
      String str = asN() + "upload_cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asP()
  {
    try
    {
      String str = asj() + "sns_ad_landingpages/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asQ()
  {
    try
    {
      String str = asj() + "SQLTrace/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asR()
  {
    try
    {
      String str = asj() + "tracedog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asS()
  {
    try
    {
      String str = asj() + "vproxy/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asT()
  {
    try
    {
      String str = asj() + "wagamefiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asU()
  {
    try
    {
      String str = asj() + "wallet/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asV()
  {
    try
    {
      String str = asj() + "wepkg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asW()
  {
    try
    {
      String str = asj() + "wxacache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asX()
  {
    try
    {
      String str = asj() + "wxafiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asY()
  {
    try
    {
      String str = asj() + "wxajscahce/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asZ()
  {
    try
    {
      String str = asj() + "wxanewfiles/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asa()
  {
    try
    {
      if (hjB[0] != null) {
        break label68;
      }
      Context localContext = ak.getContext();
      if (localContext == null) {
        throw new RuntimeException("MMApplicationContext not initialized.");
      }
    }
    finally {}
    hjB[0] = (localObject.getFilesDir().getParentFile().getAbsolutePath() + "/");
    label68:
    String str = hjB[0];
    return str;
  }
  
  /* Error */
  public static String asb()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 35	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 162	com/tencent/mm/loader/j/b:asa	()Ljava/lang/String;
    //   13: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 164
    //   18: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_0
    //   25: new 149	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 169	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_1
    //   42: invokevirtual 172	java/io/File:mkdirs	()Z
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
  
  public static String asc()
  {
    try
    {
      String str = asa() + "files/public/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asd()
  {
    try
    {
      if (hjC[0] == null) {
        hjC[0] = ase();
      }
      String str = hjC[0];
      return str;
    }
    finally {}
  }
  
  public static String ase()
  {
    for (;;)
    {
      String[] arrayOfString;
      try
      {
        if (hjD[0] == null)
        {
          arrayOfString = hjD;
          if (ak.foB())
          {
            str = "/sdcard";
            break label54;
          }
        }
        else
        {
          str = hjD[0];
          return str;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      }
      finally {}
      label54:
      arrayOfString[0] = localObject;
    }
  }
  
  public static String asf()
  {
    try
    {
      if (hjE[0] == null) {
        hjE[0] = new File(asg()).getParentFile().getAbsolutePath();
      }
      String str = hjE[0];
      return str;
    }
    finally {}
  }
  
  private static String asg()
  {
    Object localObject1 = null;
    try
    {
      localObject5 = ak.getContext();
      if (localObject5 == null) {
        throw new RuntimeException("MMApplicationContext not initialized.");
      }
    }
    finally {}
    try
    {
      localObject5 = ((Context)localObject5).getExternalCacheDir();
      if ((localObject5 == null) || (((File)localObject5).exists())) {
        break label150;
      }
      boolean bool = ((File)localObject5).mkdirs();
      if (bool) {
        break label150;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        Object localObject3;
        label121:
        continue;
        continue;
        Object localObject4 = localThrowable2;
      }
    }
    Object localObject5 = localObject2;
    if (localObject2 == null)
    {
      if (!ak.foB()) {
        break label121;
      }
      localObject3 = Environment.getExternalStorageDirectory();
      if (localObject3 != null) {
        break label147;
      }
      localObject3 = new File("/sdcard/");
    }
    for (;;)
    {
      localObject3 = new File((File)localObject3, "Android/data/com.tencent.mm/cache");
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
  
  public static String ash()
  {
    try
    {
      String str = asg() + "/image/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asi()
  {
    try
    {
      String str = ase() + "/tencent/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asj()
  {
    try
    {
      String str = asd() + arZ();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String ask()
  {
    try
    {
      String str = asf() + "/MicroMsg/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asl()
  {
    try
    {
      String str = asj() + "crash/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asm()
  {
    try
    {
      String str = asj() + "Download/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asn()
  {
    try
    {
      String str = asj() + "vusericon/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String aso()
  {
    try
    {
      String str = asj() + "Game/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asp()
  {
    try
    {
      String str = asj() + "CDNTemp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asq()
  {
    try
    {
      String str = asj() + "xlog";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asr()
  {
    try
    {
      String str = asj() + "avatar/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String ass()
  {
    try
    {
      String str = asj() + "Cache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String ast()
  {
    try
    {
      String str = ase() + "/tencent/MicroMsg/" + asw();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asu()
  {
    for (;;)
    {
      try
      {
        localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (localObject1 != null) {
          localObject1 = new File((File)localObject1, asw());
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
      Object localObject3 = new File(asf(), "Pictures/" + asw());
      Object localObject1 = localObject3;
      if (!((File)localObject3).exists())
      {
        localObject1 = localObject3;
        if (!((File)localObject3).mkdirs()) {
          localObject1 = new File(ast());
        }
      }
    }
  }
  
  /* Error */
  public static String asv()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 212	com/tencent/mm/loader/j/b:asd	()Ljava/lang/String;
    //   6: invokestatic 217	com/tencent/mm/loader/j/b:asf	()Ljava/lang/String;
    //   9: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +12 -> 24
    //   15: invokestatic 269	com/tencent/mm/loader/j/b:asu	()Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: invokestatic 262	com/tencent/mm/loader/j/b:ast	()Ljava/lang/String;
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
  private static String asw()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 35	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   10: invokestatic 179	com/tencent/mm/loader/j/b:ase	()Ljava/lang/String;
    //   13: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 271
    //   19: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore_0
    //   26: new 35	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   33: invokestatic 179	com/tencent/mm/loader/j/b:ase	()Ljava/lang/String;
    //   36: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 273
    //   42: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore_1
    //   49: new 149	java/io/File
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: invokevirtual 169	java/io/File:exists	()Z
    //   60: ifeq +12 -> 72
    //   63: ldc_w 275
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: areturn
    //   72: new 149	java/io/File
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 169	java/io/File:exists	()Z
    //   83: ifeq +10 -> 93
    //   86: ldc_w 277
    //   89: astore_0
    //   90: goto -23 -> 67
    //   93: invokestatic 282	com/tencent/mm/sdk/platformtools/ad:fom	()Ljava/lang/String;
    //   96: ldc_w 284
    //   99: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +10 -> 112
    //   105: ldc_w 277
    //   108: astore_0
    //   109: goto -42 -> 67
    //   112: ldc_w 275
    //   115: astore_0
    //   116: goto -49 -> 67
    //   119: astore_0
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	91	0	str1	String
    //   119	5	0	localObject	Object
    //   48	29	1	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	63	119	finally
    //   72	86	119	finally
    //   93	105	119	finally
  }
  
  public static String asx()
  {
    try
    {
      String str = asj() + "appbrand/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asy()
  {
    try
    {
      String str = asj() + "watchdog/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String asz()
  {
    try
    {
      String str = asj() + "exdevice/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String ata()
  {
    try
    {
      String str = asj() + "temp_video_cache";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String atb()
  {
    try
    {
      String str = asj() + "egg_spring/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String atc()
  {
    try
    {
      String str = asj() + "wxvideocache/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String atd()
  {
    try
    {
      String str = asj() + "wxvideotmp/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String ate()
  {
    try
    {
      String str = asj() + "favoffline/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String atf()
  {
    try
    {
      String str = asj() + "image_crop/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String atg()
  {
    try
    {
      String str = asj() + "mail/";
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static String ath()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 318	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   6: invokestatic 254	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   9: astore_0
    //   10: aload_0
    //   11: astore_1
    //   12: aload_0
    //   13: ifnonnull +17 -> 30
    //   16: new 149	java/io/File
    //   19: dup
    //   20: invokestatic 179	com/tencent/mm/loader/j/b:ase	()Ljava/lang/String;
    //   23: getstatic 318	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   26: invokespecial 260	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore_1
    //   30: new 149	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokestatic 245	com/tencent/mm/loader/j/b:asw	()Ljava/lang/String;
    //   38: invokespecial 203	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 206	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc_w 320
    //   56: aload_0
    //   57: ldc_w 322
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 328	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aconst_null
    //   68: astore_0
    //   69: goto -59 -> 10
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: astore_0
    //   78: goto -31 -> 47
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	42	0	localObject1	Object
    //   52	5	0	localThrowable1	Throwable
    //   68	1	0	localObject2	Object
    //   72	1	0	localThrowable2	Throwable
    //   77	1	0	str	String
    //   81	5	0	localObject3	Object
    //   11	63	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	10	52	java/lang/Throwable
    //   42	47	72	java/lang/Throwable
    //   3	10	81	finally
    //   16	30	81	finally
    //   30	42	81	finally
    //   42	47	81	finally
    //   53	67	81	finally
    //   73	78	81	finally
  }
  
  public static void ati()
  {
    try
    {
      hjE[0] = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void z(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 320
    //   6: new 35	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 333
    //   13: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: invokestatic 212	com/tencent/mm/loader/j/b:asd	()Ljava/lang/String;
    //   19: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 335
    //   25: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokestatic 179	com/tencent/mm/loader/j/b:ase	()Ljava/lang/String;
    //   31: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 338	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: iload_1
    //   41: ifeq +57 -> 98
    //   44: getstatic 23	com/tencent/mm/loader/j/b:hjC	[Ljava/lang/String;
    //   47: iconst_0
    //   48: aload_0
    //   49: aastore
    //   50: getstatic 17	com/tencent/mm/loader/j/b:hjz	[Ljava/lang/String;
    //   53: iconst_0
    //   54: ldc 219
    //   56: aastore
    //   57: ldc_w 320
    //   60: new 35	java/lang/StringBuilder
    //   63: dup
    //   64: ldc_w 340
    //   67: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: invokestatic 212	com/tencent/mm/loader/j/b:asd	()Ljava/lang/String;
    //   73: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 335
    //   79: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokestatic 179	com/tencent/mm/loader/j/b:ase	()Ljava/lang/String;
    //   85: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 338	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: ldc 2
    //   96: monitorexit
    //   97: return
    //   98: invokestatic 212	com/tencent/mm/loader/j/b:asd	()Ljava/lang/String;
    //   101: invokestatic 217	com/tencent/mm/loader/j/b:asf	()Ljava/lang/String;
    //   104: invokevirtual 267	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +9 -> 116
    //   110: getstatic 23	com/tencent/mm/loader/j/b:hjC	[Ljava/lang/String;
    //   113: iconst_0
    //   114: aload_0
    //   115: aastore
    //   116: getstatic 25	com/tencent/mm/loader/j/b:hjD	[Ljava/lang/String;
    //   119: iconst_0
    //   120: aload_0
    //   121: aastore
    //   122: goto -65 -> 57
    //   125: astore_0
    //   126: ldc 2
    //   128: monitorexit
    //   129: aload_0
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   0	131	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	40	125	finally
    //   44	57	125	finally
    //   57	94	125	finally
    //   98	116	125	finally
    //   116	122	125	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.b
 * JD-Core Version:    0.7.0.1
 */