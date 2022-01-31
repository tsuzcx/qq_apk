package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.cf.h.a;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.cf.h.e;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.z;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Lcom.tencent.mm.cf.h.d;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class e
{
  private static HashMap<Integer, h.d> dgp;
  public String cachePath;
  boolean dKA = false;
  cd dKB;
  ConcurrentHashMap<String, SharedPreferences> dKC = new ConcurrentHashMap();
  private long dKD = 0L;
  private com.tencent.mm.sdk.platformtools.ah dKE = null;
  private volatile Boolean dKF = null;
  private a dKG = new a((byte)0);
  private long dKH = 0L;
  public final com.tencent.mm.storage.y dKo = Ds();
  private com.tencent.mm.kernel.api.e dKp;
  public b dKq = new b();
  b dKr = new b();
  public String dKs;
  public String dKt;
  public com.tencent.mm.cf.h dKu = null;
  public com.tencent.mm.cf.h dKv = null;
  public z dKw;
  bs dKx;
  by dKy;
  ConcurrentHashMap<Integer, String> dKz;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return z.dXp;
      }
    });
    dgp.put(Integer.valueOf("TablesVersion".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return by.dXp;
      }
    });
  }
  
  public e(com.tencent.mm.kernel.api.e parame)
  {
    a.dJt.a(this.dKo);
    String str1 = ac.dOP + "alphahold.ini";
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.spa), Boolean.valueOf(com.tencent.mm.protocal.d.spd), str1 });
    String str2;
    int i;
    if (com.tencent.mm.protocal.d.spd)
    {
      str2 = com.tencent.mm.sdk.e.a.getValue(str1, "noneedhold");
      i = com.tencent.mm.protocal.d.spa;
    }
    try
    {
      int j = Integer.decode(com.tencent.mm.loader.a.a.CLIENT_VERSION).intValue();
      i = j;
    }
    catch (Throwable localThrowable)
    {
      label190:
      break label190;
    }
    if (!String.valueOf(i).equals(str2))
    {
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.spd) });
      a.CO();
      com.tencent.mm.sdk.e.a.an(str1, "noneedhold", String.valueOf(i));
    }
    for (;;)
    {
      this.dKs = Dy();
      this.dKp = parame;
      return;
      com.tencent.mm.a.e.deleteFile(str1);
    }
  }
  
  /* Error */
  private static boolean DE()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 262	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   5: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   8: astore 8
    //   10: getstatic 272	com/tencent/mm/compatible/util/e:bkF	Ljava/lang/String;
    //   13: aload 8
    //   15: invokevirtual 275	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   18: istore_3
    //   19: invokestatic 278	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   22: ldc_w 280
    //   25: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: istore 4
    //   30: new 264	java/io/File
    //   33: dup
    //   34: invokestatic 262	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   37: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   40: invokespecial 283	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 286	java/io/File:canWrite	()Z
    //   46: istore_1
    //   47: new 264	java/io/File
    //   50: dup
    //   51: invokestatic 262	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   54: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: ldc_w 288
    //   60: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore 7
    //   65: aload 7
    //   67: invokevirtual 294	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: new 296	java/io/FileOutputStream
    //   74: dup
    //   75: aload 7
    //   77: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore 6
    //   82: aload 6
    //   84: astore 5
    //   86: aload 6
    //   88: ldc_w 301
    //   91: invokevirtual 305	java/lang/String:getBytes	()[B
    //   94: invokevirtual 309	java/io/FileOutputStream:write	([B)V
    //   97: aload 6
    //   99: astore 5
    //   101: aload 6
    //   103: invokevirtual 312	java/io/FileOutputStream:flush	()V
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   115: aload 6
    //   117: astore 5
    //   119: aload 7
    //   121: invokevirtual 318	java/io/File:delete	()Z
    //   124: istore_0
    //   125: aload 6
    //   127: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   130: ldc 176
    //   132: new 158	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 320
    //   139: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload 8
    //   144: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 323
    //   150: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 272	com/tencent/mm/compatible/util/e:bkF	Ljava/lang/String;
    //   156: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 325
    //   162: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload_3
    //   166: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   169: ldc_w 330
    //   172: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 4
    //   177: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: ldc_w 332
    //   183: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload_1
    //   187: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   190: ldc_w 334
    //   193: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload_0
    //   197: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   200: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 336	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: iload_0
    //   207: ireturn
    //   208: astore 5
    //   210: ldc 176
    //   212: new 158	java/lang/StringBuilder
    //   215: dup
    //   216: ldc_w 338
    //   219: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: aload 5
    //   224: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 343	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: iconst_0
    //   237: istore_1
    //   238: goto -191 -> 47
    //   241: astore 5
    //   243: ldc 176
    //   245: ldc_w 345
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 5
    //   256: invokestatic 351	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   259: aastore
    //   260: invokestatic 354	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: goto -133 -> 130
    //   266: astore 7
    //   268: aconst_null
    //   269: astore 6
    //   271: aload 6
    //   273: astore 5
    //   275: ldc 176
    //   277: new 158	java/lang/StringBuilder
    //   280: dup
    //   281: ldc_w 356
    //   284: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: aload 7
    //   289: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 343	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: iload_2
    //   302: istore_0
    //   303: aload 6
    //   305: ifnull -175 -> 130
    //   308: aload 6
    //   310: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   313: iload_2
    //   314: istore_0
    //   315: goto -185 -> 130
    //   318: astore 5
    //   320: ldc 176
    //   322: ldc_w 345
    //   325: iconst_1
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 5
    //   333: invokestatic 351	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   336: aastore
    //   337: invokestatic 354	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: iload_2
    //   341: istore_0
    //   342: goto -212 -> 130
    //   345: astore 6
    //   347: aconst_null
    //   348: astore 5
    //   350: aload 5
    //   352: ifnull +8 -> 360
    //   355: aload 5
    //   357: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   360: aload 6
    //   362: athrow
    //   363: astore 5
    //   365: ldc 176
    //   367: ldc_w 345
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload 5
    //   378: invokestatic 351	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   381: aastore
    //   382: invokestatic 354	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: goto -25 -> 360
    //   388: astore 6
    //   390: goto -40 -> 350
    //   393: astore 7
    //   395: goto -124 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   124	218	0	bool1	boolean
    //   46	192	1	bool2	boolean
    //   1	340	2	bool3	boolean
    //   18	148	3	bool4	boolean
    //   28	148	4	bool5	boolean
    //   84	34	5	localFileOutputStream1	java.io.FileOutputStream
    //   208	15	5	localException1	Exception
    //   241	14	5	localIOException1	IOException
    //   273	1	5	localFileOutputStream2	java.io.FileOutputStream
    //   318	14	5	localIOException2	IOException
    //   348	8	5	localObject1	Object
    //   363	14	5	localIOException3	IOException
    //   80	229	6	localFileOutputStream3	java.io.FileOutputStream
    //   345	16	6	localObject2	Object
    //   388	1	6	localObject3	Object
    //   63	57	7	localFile	File
    //   266	22	7	localException2	Exception
    //   393	1	7	localException3	Exception
    //   8	135	8	str	String
    // Exception table:
    //   from	to	target	type
    //   30	47	208	java/lang/Exception
    //   125	130	241	java/io/IOException
    //   65	82	266	java/lang/Exception
    //   308	313	318	java/io/IOException
    //   65	82	345	finally
    //   355	360	363	java/io/IOException
    //   86	97	388	finally
    //   101	106	388	finally
    //   110	115	388	finally
    //   119	125	388	finally
    //   275	301	388	finally
    //   86	97	393	java/lang/Exception
    //   101	106	393	java/lang/Exception
    //   110	115	393	java/lang/Exception
    //   119	125	393	java/lang/Exception
  }
  
  private static boolean DF()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool2 = com.tencent.mm.compatible.util.e.bkF.equalsIgnoreCase(str);
    boolean bool3 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
      File localFile = new File(com.tencent.mm.compatible.util.e.bkH);
      boolean bool4 = localFile.exists();
      if (bool4) {
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + localFile.isDirectory() + " isFile:" + localFile.isFile());
      }
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bkF + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.bkH + " isPrimaryExtStg: " + bool2 + " mounted: " + bool3 + " canRead: " + bool1 + " canTrueRead:" + bool4);
      return bool4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = false;
        com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + localException.getMessage());
      }
    }
  }
  
  private static com.tencent.mm.storage.y Ds()
  {
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", new Object[] { com.tencent.mm.sdk.platformtools.d.ayN(), Integer.valueOf(com.tencent.mm.protocal.d.spa) });
    Object localObject1 = new File(ac.dOP);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new com.tencent.mm.storage.y(ac.dOP + "systemInfo.cfg");
    Object localObject2 = (String)((com.tencent.mm.storage.y)localObject1).get(258);
    if (localObject2 != null) {
      com.tencent.mm.compatible.e.l.yP().set(258, localObject2);
    }
    try
    {
      localObject2 = com.tencent.mm.compatible.util.h.getDataDirectory();
      StatFs localStatFs = new StatFs(((File)localObject2).getPath());
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { ((File)localObject2).getAbsolutePath(), Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
      return localObject1;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "check data size failed :%s", new Object[] { localException.getMessage() });
    }
    return localObject1;
  }
  
  private static String Dy()
  {
    Object localObject2 = ac.dOP;
    File localFile = new File(com.tencent.mm.compatible.util.e.bkF);
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + (String)localObject2 + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.bkF + "] file.exists:" + localFile.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.f.zF());
    Object localObject1 = localObject2;
    if (localFile.exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.f.zF())
      {
        localObject1 = localObject2;
        if (bN(com.tencent.mm.compatible.util.e.bkH)) {
          localObject1 = com.tencent.mm.compatible.util.e.bkH;
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.dzD);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.dzE);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.dzF);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.dzG);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.dzE + ".nomedia");
        if (((File)localObject2).exists()) {}
      }
    }
    try
    {
      ((File)localObject2).createNewFile();
      bN(com.tencent.mm.compatible.util.e.dzB);
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: " + (String)localObject1);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "exception:%s", new Object[] { bk.j(localIOException) });
      }
    }
  }
  
  private static final boolean bN(String paramString)
  {
    if (bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
      return false;
    }
    Object localObject = new File(paramString);
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", new Object[] { paramString, Boolean.valueOf(((File)localObject).exists()), Boolean.valueOf(((File)localObject).isDirectory()) });
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
      return true;
    }
    String[] arrayOfString = paramString.split("/");
    if ((arrayOfString == null) || (arrayOfString.length < 2))
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
      return false;
    }
    localObject = "/";
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = (String)localObject;
      if (!bk.bl(arrayOfString[i]))
      {
        localObject = (String)localObject + "/" + arrayOfString[i];
        File localFile = new File((String)localObject);
        if ((localFile.isFile()) && (!localFile.renameTo(new File((String)localObject + "_mmbak"))))
        {
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", new Object[] { localFile.getName() });
          return false;
        }
        paramString = (String)localObject;
        if (!localFile.exists())
        {
          paramString = (String)localObject;
          if (!localFile.mkdir())
          {
            com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", new Object[] { localFile.getName() });
            return false;
          }
        }
      }
      i += 1;
      localObject = paramString;
    }
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
    return true;
  }
  
  static HashMap<Integer, h.d> xe()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(dgp);
    return localHashMap;
  }
  
  public final bs DA()
  {
    g.DQ();
    g.DN().CX();
    return this.dKx;
  }
  
  public final void DB()
  {
    this.dKF = Boolean.valueOf(isSDCardAvailable());
  }
  
  public final boolean DC()
  {
    if (this.dKF == null) {
      this.dKF = Boolean.valueOf(isSDCardAvailable());
    }
    for (;;)
    {
      return this.dKF.booleanValue();
      long l = System.currentTimeMillis() - this.dKH;
      if ((l <= 0L) || (l >= 1000L))
      {
        if (this.dKE == null) {
          this.dKE = new com.tencent.mm.sdk.platformtools.ah(g.DS().mnU.getLooper());
        }
        this.dKE.removeCallbacksAndMessages(null);
        this.dKE.postDelayed(this.dKG, 1000L);
        this.dKH = System.currentTimeMillis();
      }
    }
  }
  
  /* Error */
  public final void DD()
  {
    // Byte code:
    //   0: invokestatic 535	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   3: pop
    //   4: invokestatic 539	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
    //   7: getfield 594	com/tencent/mm/kernel/a:dJs	[B
    //   10: astore_2
    //   11: aload_2
    //   12: monitorenter
    //   13: invokestatic 240	com/tencent/mm/kernel/e:Dy	()Ljava/lang/String;
    //   16: astore_3
    //   17: ldc 176
    //   19: ldc_w 596
    //   22: iconst_4
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: invokestatic 599	com/tencent/mm/kernel/a:CK	()I
    //   31: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_0
    //   38: getfield 242	com/tencent/mm/kernel/e:dKs	Ljava/lang/String;
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: aload_3
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: invokestatic 539	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
    //   51: invokevirtual 602	com/tencent/mm/kernel/a:Dc	()Z
    //   54: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: aastore
    //   58: invokestatic 198	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_3
    //   62: invokestatic 479	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   65: ifne +335 -> 400
    //   68: aload_3
    //   69: aload_0
    //   70: getfield 242	com/tencent/mm/kernel/e:dKs	Ljava/lang/String;
    //   73: invokevirtual 275	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   76: istore_1
    //   77: iload_1
    //   78: ifeq +117 -> 195
    //   81: ldc 176
    //   83: new 158	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 604
    //   90: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: invokestatic 606	com/tencent/mm/kernel/e:DE	()Z
    //   96: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   99: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 336	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: ldc 176
    //   107: new 158	java/lang/StringBuilder
    //   110: dup
    //   111: ldc_w 608
    //   114: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: invokestatic 610	com/tencent/mm/kernel/e:DF	()Z
    //   120: invokevirtual 328	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 336	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_2
    //   130: monitorexit
    //   131: return
    //   132: astore_3
    //   133: ldc 176
    //   135: new 158	java/lang/StringBuilder
    //   138: dup
    //   139: ldc_w 612
    //   142: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: aload_3
    //   146: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   149: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 343	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -53 -> 105
    //   161: astore_3
    //   162: aload_2
    //   163: monitorexit
    //   164: aload_3
    //   165: athrow
    //   166: astore_3
    //   167: ldc 176
    //   169: new 158	java/lang/StringBuilder
    //   172: dup
    //   173: ldc_w 614
    //   176: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: aload_3
    //   180: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 343	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -63 -> 129
    //   195: ldc 176
    //   197: ldc_w 616
    //   200: iconst_4
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_0
    //   207: getfield 242	com/tencent/mm/kernel/e:dKs	Ljava/lang/String;
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: aload_3
    //   214: aastore
    //   215: dup
    //   216: iconst_2
    //   217: aload_0
    //   218: getfield 618	com/tencent/mm/kernel/e:dKt	Ljava/lang/String;
    //   221: aastore
    //   222: dup
    //   223: iconst_3
    //   224: aload_0
    //   225: getfield 620	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 198	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_3
    //   233: invokestatic 479	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   236: ifne +134 -> 370
    //   239: aload_0
    //   240: aload_3
    //   241: putfield 242	com/tencent/mm/kernel/e:dKs	Ljava/lang/String;
    //   244: new 158	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 622
    //   251: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: astore_3
    //   255: invokestatic 535	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   258: pop
    //   259: invokestatic 539	com/tencent/mm/kernel/g:DN	()Lcom/tencent/mm/kernel/a;
    //   262: pop
    //   263: aload_3
    //   264: invokestatic 599	com/tencent/mm/kernel/a:CK	()I
    //   267: invokevirtual 498	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 305	java/lang/String:getBytes	()[B
    //   276: invokestatic 628	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   279: astore_3
    //   280: aload_0
    //   281: new 158	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   288: aload_0
    //   289: getfield 242	com/tencent/mm/kernel/e:dKs	Ljava/lang/String;
    //   292: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_3
    //   296: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 487
    //   302: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: putfield 618	com/tencent/mm/kernel/e:dKt	Ljava/lang/String;
    //   311: invokestatic 634	com/tencent/mm/vfs/FileSystemManager:cVw	()Lcom/tencent/mm/vfs/FileSystemManager;
    //   314: astore 4
    //   316: aload 4
    //   318: invokevirtual 638	com/tencent/mm/vfs/FileSystemManager:cVy	()Lcom/tencent/mm/vfs/FileSystemManager$a;
    //   321: ldc_w 640
    //   324: aload_3
    //   325: invokevirtual 646	com/tencent/mm/vfs/FileSystemManager$a:gB	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/FileSystemManager$a;
    //   328: iconst_0
    //   329: invokevirtual 650	com/tencent/mm/vfs/FileSystemManager$a:oc	(Z)V
    //   332: aload 4
    //   334: invokevirtual 653	com/tencent/mm/vfs/FileSystemManager:cVz	()V
    //   337: ldc_w 655
    //   340: new 158	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 657
    //   347: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload_3
    //   351: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 659
    //   357: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 336	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 662	com/tencent/mm/kernel/e:Dt	()V
    //   370: invokestatic 668	com/tencent/mm/kernel/a/c:DY	()Lcom/tencent/mm/kernel/a/c;
    //   373: getfield 672	com/tencent/mm/kernel/a/c:dLE	Lcom/tencent/mm/kernel/a/c$d;
    //   376: invokevirtual 677	com/tencent/mm/kernel/a/c$d:DU	()V
    //   379: ldc 176
    //   381: ldc_w 679
    //   384: iconst_1
    //   385: anewarray 4	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: invokestatic 450	com/tencent/mm/compatible/util/f:zF	()Z
    //   393: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   396: aastore
    //   397: invokestatic 198	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: aload_2
    //   401: monitorexit
    //   402: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	e
    //   76	2	1	bool	boolean
    //   10	391	2	arrayOfByte	byte[]
    //   16	53	3	str	String
    //   132	14	3	localException1	Exception
    //   161	4	3	localObject1	Object
    //   166	75	3	localException2	Exception
    //   254	97	3	localObject2	Object
    //   314	19	4	localFileSystemManager	com.tencent.mm.vfs.FileSystemManager
    // Exception table:
    //   from	to	target	type
    //   81	105	132	java/lang/Exception
    //   13	77	161	finally
    //   81	105	161	finally
    //   105	129	161	finally
    //   129	131	161	finally
    //   133	158	161	finally
    //   162	164	161	finally
    //   167	192	161	finally
    //   195	370	161	finally
    //   370	400	161	finally
    //   400	402	161	finally
    //   105	129	166	java/lang/Exception
  }
  
  final void Dt()
  {
    c.DY().gj(this.dKt);
    File localFile = new File(this.dKt + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "exception:%s", new Object[] { bk.j(localIOException) });
    }
  }
  
  public final String Du()
  {
    Object localObject1 = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
    if (((File)localObject1).isFile()) {
      return ((File)localObject1).getAbsolutePath();
    }
    localObject1 = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
    if (((File)localObject1).isFile()) {
      return ((File)localObject1).getAbsolutePath();
    }
    String[] arrayOfString = new File(this.cachePath).list(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("EnMicroMsg.dberr");
      }
    });
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localObject1 = arrayOfString[0];
      int i = 1;
      while (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        Object localObject2 = localObject1;
        if (str.compareTo((String)localObject1) > 0) {
          localObject2 = str;
        }
        i += 1;
        localObject1 = localObject2;
      }
      return this.cachePath + '/' + (String)localObject1;
    }
    return null;
  }
  
  public final com.tencent.mm.cf.h Dv()
  {
    return this.dKu;
  }
  
  public final String Dw()
  {
    return this.cachePath + "MicroMsg.db";
  }
  
  public final String Dx()
  {
    return this.cachePath + "EnMicroMsg.db";
  }
  
  public final z Dz()
  {
    g.DQ();
    g.DN().CX();
    return this.dKw;
  }
  
  public final boolean a(com.tencent.mm.cf.f paramf, HashMap<Integer, h.d> paramHashMap)
  {
    int i;
    g.a locala;
    Iterator localIterator;
    if (paramHashMap == null)
    {
      i = -1;
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "createtables %d %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(false) });
      locala = new g.a();
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        localIterator = paramHashMap.entrySet().iterator();
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramHashMap = (Map.Entry)localIterator.next();
          Integer localInteger = (Integer)paramHashMap.getKey();
          h.d locald = (h.d)paramHashMap.getValue();
          paramHashMap = null;
          Object localObject1;
          int k;
          int j;
          label253:
          Object localObject2;
          if (!this.dKA)
          {
            paramHashMap = new StringBuilder();
            localObject1 = locald.rK();
            k = localObject1.length;
            j = 0;
            for (;;)
            {
              if (j < k)
              {
                paramHashMap.append(localObject1[j].hashCode());
                j += 1;
                continue;
                i = paramHashMap.size();
                break;
              }
            }
            localObject1 = com.tencent.mm.a.g.o(paramHashMap.toString().getBytes());
            if (this.dKz != null)
            {
              paramHashMap = (String)this.dKz.get(localInteger);
              com.tencent.mm.sdk.platformtools.y.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", new Object[] { localInteger, paramHashMap, localObject1 });
              if ((paramHashMap != null) && (((String)localObject1).equals(paramHashMap))) {
                continue;
              }
              paramHashMap = (HashMap<Integer, h.d>)localObject1;
            }
          }
          else
          {
            paramf.beginTransaction();
            localObject1 = locald.rK();
            k = localObject1.length;
            j = 0;
            for (;;)
            {
              if (j >= k) {
                break label575;
              }
              localObject2 = localObject1[j];
              try
              {
                paramf.execSQL((String)localObject2);
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Object localObject3 = com.tencent.mm.cf.a.uDB.matcher((CharSequence)localObject2);
                  if ((localObject3 != null) && (((Matcher)localObject3).matches())) {
                    Assert.assertTrue("CreateTable failed:[" + (String)localObject2 + "][" + localException.getMessage() + "]", false);
                  } else {
                    com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "CreateTable failed:[" + (String)localObject2 + "][" + localException.getMessage() + "]");
                  }
                }
              }
              j += 1;
            }
          }
          if (this.dKy != null)
          {
            localObject3 = this.dKy;
            j = localInteger.intValue();
            paramHashMap = null;
            localObject2 = null;
            localObject3 = ((by)localObject3).rawQuery("select * from TablesVersion where tableHash = " + j, new String[0]);
            if (localObject3 != null)
            {
              paramHashMap = (HashMap<Integer, h.d>)localObject2;
              if (((Cursor)localObject3).moveToFirst())
              {
                paramHashMap = new bx();
                paramHashMap.d((Cursor)localObject3);
              }
              ((Cursor)localObject3).close();
            }
            if (paramHashMap != null) {
              break label451;
            }
          }
          label451:
          for (paramHashMap = null;; paramHashMap = paramHashMap.field_tableSQLMD5)
          {
            com.tencent.mm.sdk.platformtools.y.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", new Object[] { localInteger, paramHashMap, localObject1 });
            if ((paramHashMap != null) && (((String)localObject1).equals(paramHashMap))) {
              break;
            }
            paramHashMap = (HashMap<Integer, h.d>)localObject1;
            break label253;
          }
          label575:
          paramf.endTransaction();
          if ((!this.dKA) && (this.dKy != null) && (paramHashMap != null))
          {
            localObject1 = this.dKy;
            j = localInteger.intValue();
            if (j == 0) {
              break label693;
            }
          }
          label693:
          for (boolean bool = true;; bool = false)
          {
            Assert.assertTrue(bool);
            Assert.assertNotNull(paramHashMap);
            localObject2 = new bx();
            ((bx)localObject2).field_tableHash = j;
            ((bx)localObject2).field_tableSQLMD5 = paramHashMap;
            ((by)localObject1).dXo.replace("TablesVersion", "tableHash", ((bx)localObject2).vf());
            if ((this.dKz != null) && (paramHashMap != null)) {
              this.dKz.put(localInteger, paramHashMap);
            }
            break;
          }
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(locala.zJ()), Long.valueOf(locala.zJ()), Integer.valueOf(i) });
    }
    return true;
  }
  
  public final boolean a(com.tencent.mm.model.ai paramai)
  {
    int i = 0;
    if (paramai == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
      return false;
    }
    int j = bk.g((Integer)this.dKw.get(14, null));
    int k = com.tencent.mm.protocal.d.spa;
    com.tencent.mm.sdk.platformtools.y.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + j + ", cVer = " + k);
    paramai = paramai.getDataTransferList();
    if (paramai == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
      return false;
    }
    if ((com.tencent.mm.platformtools.ae.eSH > 0) && (com.tencent.mm.platformtools.ae.eSI > 0)) {
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
    }
    long l1;
    label353:
    boolean bool1;
    do
    {
      com.tencent.mm.sdk.platformtools.y.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + paramai.size());
      com.tencent.mm.sdk.platformtools.y.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
      l1 = this.dKu.eV(Thread.currentThread().getId());
      try
      {
        paramai = paramai.iterator();
        while (paramai.hasNext())
        {
          localObject = (com.tencent.mm.model.ah)paramai.next();
          long l2 = System.currentTimeMillis();
          ((com.tencent.mm.model.ah)localObject).transfer(j);
          ((com.tencent.mm.model.ah)localObject).dVx = (System.currentTimeMillis() - l2);
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + ((com.tencent.mm.model.ah)localObject).dVx + ", tag = " + ((com.tencent.mm.model.ah)localObject).getTag());
        }
        if (j != k) {
          break label353;
        }
      }
      catch (Throwable paramai)
      {
        throw paramai;
      }
      finally
      {
        if (l1 > 0L) {
          this.dKu.hI(l1);
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + j + ", cVer = " + k);
      return false;
      Object localObject = paramai.iterator();
      bool1 = false;
      while (((Iterator)localObject).hasNext())
      {
        boolean bool2 = ((com.tencent.mm.model.ah)((Iterator)localObject).next()).hJ(j);
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
      com.tencent.mm.sdk.platformtools.y.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = " + bool1);
    } while (bool1);
    return false;
    if ((com.tencent.mm.platformtools.ae.eSH != 0) && (com.tencent.mm.platformtools.ae.eSI != 0)) {
      for (;;)
      {
        j = com.tencent.mm.platformtools.ae.eSH;
        if (i < j) {
          try
          {
            Thread.sleep(com.tencent.mm.platformtools.ae.eSI);
            i += 1;
          }
          catch (InterruptedException paramai)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "exception:%s", new Object[] { bk.j(paramai) });
            }
          }
        }
      }
    }
    if (l1 > 0L) {
      this.dKu.hI(l1);
    }
    return true;
  }
  
  public final void ek(String paramString)
  {
    if (this.dKv != null) {
      this.dKv.closeDB();
    }
    if (this.dKu != null) {
      this.dKu.ek(paramString);
    }
    this.dKp.onDataBaseClosed(this.dKu, this.dKv);
    this.dKA = false;
  }
  
  final void gg(final String paramString)
  {
    File localFile = new File(paramString + "-recovery");
    if (localFile.isFile())
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
      new File(paramString + ".ini").delete();
      paramString = new File(paramString);
      paramString.delete();
      if (!localFile.renameTo(paramString)) {
        com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "Rename database file failed!");
      }
    }
    paramString = localFile.getName();
    paramString = localFile.getParentFile().listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return (paramAnonymousString.startsWith(paramString)) && (!paramAnonymousString.equals(paramString));
      }
    });
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramString[i];
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + localFile.getName());
        localFile.delete();
        i += 1;
      }
    }
  }
  
  public final SharedPreferences gh(String paramString)
  {
    g.DQ();
    g.DN();
    int i = a.CK();
    if (i != 0) {
      if (this.dKC.containsKey(paramString)) {
        return (SharedPreferences)this.dKC.get(paramString);
      }
    }
    try
    {
      localObject1 = com.tencent.mm.sdk.platformtools.ae.getContext().getFilesDir().getParent() + "/shared_prefs/";
      Object localObject2 = com.tencent.mm.sdk.platformtools.ae.cqR() + paramString + i + ".xml";
      String str = com.tencent.mm.sdk.platformtools.ae.cqR() + paramString + i + ".xml.bak";
      localObject2 = new File((String)localObject1 + (String)localObject2);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject1 = new File((String)localObject1 + str);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label213:
      break label213;
    }
    localObject1 = ad.bB(String.valueOf(i / 2));
    localObject1 = com.tencent.mm.sdk.platformtools.ae.cqR() + paramString + ad.bB(new StringBuilder().append(i).append((String)localObject1).toString());
    localObject1 = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences((String)localObject1, 0);
    this.dKC.put(paramString, localObject1);
    return localObject1;
    return null;
  }
  
  public final boolean isSDCardAvailable()
  {
    boolean bool1 = this.dKs.startsWith(com.tencent.mm.compatible.util.e.bkF);
    long l1 = bk.UY();
    long l2 = l1 - this.dKD;
    if (bool1)
    {
      g.DQ();
      if ((!g.DN().Dc()) || (l2 <= 0L) || (l2 >= 1000L) || (!new File(this.dKs).exists())) {}
    }
    do
    {
      do
      {
        return true;
        this.dKD = l1;
        boolean bool2 = com.tencent.mm.compatible.util.f.zF();
        g.DQ();
        g.DN();
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", new Object[] { Boolean.valueOf(bool2), o.getString(a.CK()), Long.valueOf(l2), this.dKs, com.tencent.mm.compatible.util.e.bkF, Boolean.valueOf(g.DN().Dc()) });
        if (!bool2) {
          return false;
        }
      } while (bool1);
      g.DQ();
    } while (!g.DN().Dc());
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
    DD();
    return true;
  }
  
  private final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      e.this.DB();
    }
  }
  
  public static final class b
    extends com.tencent.mm.ck.a<h.a>
    implements h.a
  {
    public final void DG()
    {
      a(new a.a() {});
    }
    
    public final void DH()
    {
      a(new a.a() {});
    }
    
    public final void DI()
    {
      a(new a.a() {});
    }
  }
  
  public static final class c
  {
    public boolean dKL = false;
    public int dKM = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.e
 * JD-Core Version:    0.7.0.1
 */