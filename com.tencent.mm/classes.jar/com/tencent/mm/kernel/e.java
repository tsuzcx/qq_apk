package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.cg.h.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.cg.h.e;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.cf;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Lcom.tencent.mm.cg.h.d;>;
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
  private static HashMap<Integer, h.d> baseDBFactories;
  public String cachePath;
  public final y eHM;
  private com.tencent.mm.kernel.api.e eHN;
  public b eHO;
  b eHP;
  public String eHQ;
  public String eHR;
  public com.tencent.mm.cg.h eHS;
  public com.tencent.mm.cg.h eHT;
  z eHU;
  bs eHV;
  by eHW;
  ConcurrentHashMap<Integer, String> eHX;
  boolean eHY;
  cf eHZ;
  ConcurrentHashMap<String, SharedPreferences> eIa;
  private long eIb;
  private ak eIc;
  private volatile Boolean eId;
  private a eIe;
  private long eIf;
  
  static
  {
    AppMethodBeat.i(57978);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return z.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("TablesVersion".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return by.SQL_CREATE;
      }
    });
    AppMethodBeat.o(57978);
  }
  
  public e(com.tencent.mm.kernel.api.e parame)
  {
    AppMethodBeat.i(57953);
    this.eHO = new b();
    this.eHP = new b();
    this.eHS = null;
    this.eHT = null;
    this.eHY = false;
    this.eIa = new ConcurrentHashMap();
    this.eIb = 0L;
    this.eIc = null;
    this.eId = null;
    this.eIe = new a((byte)0);
    this.eIf = 0L;
    this.eHM = Rk();
    a.eGR.a(this.eHM);
    String str1 = com.tencent.mm.storage.ac.eQv + "alphahold.ini";
    ab.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH), Boolean.valueOf(com.tencent.mm.protocal.d.whK), str1 });
    String str2;
    int i;
    if (com.tencent.mm.protocal.d.whK)
    {
      str2 = com.tencent.mm.sdk.e.a.getValue(str1, "noneedhold");
      i = com.tencent.mm.protocal.d.whH;
    }
    try
    {
      int j = Integer.decode(com.tencent.mm.loader.j.a.CLIENT_VERSION).intValue();
      i = j;
    }
    catch (Throwable localThrowable)
    {
      label195:
      break label195;
    }
    if (!String.valueOf(i).equals(str2))
    {
      ab.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.whK) });
      a.QH();
      com.tencent.mm.sdk.e.a.aE(str1, "noneedhold", String.valueOf(i));
    }
    for (;;)
    {
      this.eHQ = Rt();
      this.eHN = parame;
      AppMethodBeat.o(57953);
      return;
      com.tencent.mm.a.e.deleteFile(str1);
    }
  }
  
  private static boolean RA()
  {
    AppMethodBeat.i(57976);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool2 = com.tencent.mm.compatible.util.e.eQx.equalsIgnoreCase(str);
    boolean bool3 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
      File localFile = new File(com.tencent.mm.compatible.util.e.eQz);
      boolean bool4 = localFile.exists();
      if (bool4) {
        ab.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + localFile.isDirectory() + " isFile:" + localFile.isFile());
      }
      ab.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.eQx + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.eQz + " isPrimaryExtStg: " + bool2 + " mounted: " + bool3 + " canRead: " + bool1 + " canTrueRead:" + bool4);
      AppMethodBeat.o(57976);
      return bool4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = false;
        ab.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + localException.getMessage());
      }
    }
  }
  
  private static y Rk()
  {
    AppMethodBeat.i(57954);
    ab.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", new Object[] { com.tencent.mm.sdk.platformtools.f.bau(), Integer.valueOf(com.tencent.mm.protocal.d.whH) });
    Object localObject1 = new File(com.tencent.mm.storage.ac.eQv);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new y(com.tencent.mm.storage.ac.eQv + "systemInfo.cfg");
    Object localObject2 = (String)((y)localObject1).get(258);
    if (localObject2 != null) {
      l.Lm().set(258, localObject2);
    }
    try
    {
      localObject2 = com.tencent.mm.compatible.util.h.getDataDirectory();
      StatFs localStatFs = new StatFs(((File)localObject2).getPath());
      ab.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { ((File)localObject2).getAbsolutePath(), Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
      AppMethodBeat.o(57954);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MMKernel.CoreStorage", "check data size failed :%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static String Rt()
  {
    AppMethodBeat.i(57967);
    Object localObject2 = com.tencent.mm.storage.ac.eQv;
    File localFile = new File(com.tencent.mm.compatible.util.e.eQx);
    ab.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + (String)localObject2 + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.eQx + "] file.exists:" + localFile.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.f.Mi());
    Object localObject1 = localObject2;
    if (localFile.exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.f.Mi())
      {
        localObject1 = localObject2;
        if (cQ(com.tencent.mm.compatible.util.e.eQz)) {
          localObject1 = com.tencent.mm.compatible.util.e.eQz;
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.esr);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.ess);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.est);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.esu);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        localObject2 = new File(com.tencent.mm.compatible.util.e.ess + ".nomedia");
        if (((File)localObject2).exists()) {}
      }
    }
    try
    {
      ((File)localObject2).createNewFile();
      cQ(com.tencent.mm.compatible.util.e.esq);
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      ab.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(57967);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MMKernel.CoreStorage", "exception:%s", new Object[] { bo.l(localIOException) });
      }
    }
  }
  
  /* Error */
  private static boolean Rz()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 454
    //   5: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 271	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   11: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   14: astore 8
    //   16: getstatic 281	com/tencent/mm/compatible/util/e:eQx	Ljava/lang/String;
    //   19: aload 8
    //   21: invokevirtual 284	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   24: istore_3
    //   25: invokestatic 287	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   28: ldc_w 289
    //   31: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: istore 4
    //   36: new 273	java/io/File
    //   39: dup
    //   40: invokestatic 271	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   43: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   46: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: invokevirtual 457	java/io/File:canWrite	()Z
    //   52: istore_1
    //   53: new 273	java/io/File
    //   56: dup
    //   57: invokestatic 271	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   60: invokevirtual 276	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: ldc_w 459
    //   66: invokespecial 461	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: astore 7
    //   71: aload 7
    //   73: invokevirtual 432	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: new 463	java/io/FileOutputStream
    //   80: dup
    //   81: aload 7
    //   83: invokespecial 466	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: astore 6
    //   88: aload 6
    //   90: astore 5
    //   92: aload 6
    //   94: ldc_w 468
    //   97: invokevirtual 472	java/lang/String:getBytes	()[B
    //   100: invokevirtual 476	java/io/FileOutputStream:write	([B)V
    //   103: aload 6
    //   105: astore 5
    //   107: aload 6
    //   109: invokevirtual 479	java/io/FileOutputStream:flush	()V
    //   112: aload 6
    //   114: astore 5
    //   116: aload 6
    //   118: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   121: aload 6
    //   123: astore 5
    //   125: aload 7
    //   127: invokevirtual 485	java/io/File:delete	()Z
    //   130: istore_0
    //   131: aload 6
    //   133: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   136: ldc 187
    //   138: new 169	java/lang/StringBuilder
    //   141: dup
    //   142: ldc_w 320
    //   145: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: aload 8
    //   150: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 322
    //   156: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 281	com/tencent/mm/compatible/util/e:eQx	Ljava/lang/String;
    //   162: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 326
    //   168: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload_3
    //   172: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   175: ldc_w 328
    //   178: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload 4
    //   183: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: ldc_w 487
    //   189: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: iload_1
    //   193: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   196: ldc_w 489
    //   199: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload_0
    //   203: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   206: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 318	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: ldc_w 454
    //   215: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: iload_0
    //   219: ireturn
    //   220: astore 5
    //   222: ldc 187
    //   224: new 169	java/lang/StringBuilder
    //   227: dup
    //   228: ldc_w 491
    //   231: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   234: aload 5
    //   236: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 339	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: iconst_0
    //   249: istore_1
    //   250: goto -197 -> 53
    //   253: astore 5
    //   255: ldc 187
    //   257: ldc_w 446
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 5
    //   268: invokestatic 452	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   271: aastore
    //   272: invokestatic 396	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -139 -> 136
    //   278: astore 7
    //   280: aconst_null
    //   281: astore 6
    //   283: aload 6
    //   285: astore 5
    //   287: ldc 187
    //   289: new 169	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 493
    //   296: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload 7
    //   301: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   304: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 339	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: iload_2
    //   314: istore_0
    //   315: aload 6
    //   317: ifnull -181 -> 136
    //   320: aload 6
    //   322: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   325: iload_2
    //   326: istore_0
    //   327: goto -191 -> 136
    //   330: astore 5
    //   332: ldc 187
    //   334: ldc_w 446
    //   337: iconst_1
    //   338: anewarray 4	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: aload 5
    //   345: invokestatic 452	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   348: aastore
    //   349: invokestatic 396	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   352: iload_2
    //   353: istore_0
    //   354: goto -218 -> 136
    //   357: astore 6
    //   359: aconst_null
    //   360: astore 5
    //   362: aload 5
    //   364: ifnull +8 -> 372
    //   367: aload 5
    //   369: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   372: ldc_w 454
    //   375: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload 6
    //   380: athrow
    //   381: astore 5
    //   383: ldc 187
    //   385: ldc_w 446
    //   388: iconst_1
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload 5
    //   396: invokestatic 452	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   399: aastore
    //   400: invokestatic 396	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: goto -31 -> 372
    //   406: astore 6
    //   408: goto -46 -> 362
    //   411: astore 7
    //   413: goto -130 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   130	224	0	bool1	boolean
    //   52	198	1	bool2	boolean
    //   1	352	2	bool3	boolean
    //   24	148	3	bool4	boolean
    //   34	148	4	bool5	boolean
    //   90	34	5	localFileOutputStream1	java.io.FileOutputStream
    //   220	15	5	localException1	Exception
    //   253	14	5	localIOException1	IOException
    //   285	1	5	localFileOutputStream2	java.io.FileOutputStream
    //   330	14	5	localIOException2	IOException
    //   360	8	5	localObject1	Object
    //   381	14	5	localIOException3	IOException
    //   86	235	6	localFileOutputStream3	java.io.FileOutputStream
    //   357	22	6	localObject2	Object
    //   406	1	6	localObject3	Object
    //   69	57	7	localFile	File
    //   278	22	7	localException2	Exception
    //   411	1	7	localException3	Exception
    //   14	135	8	str	String
    // Exception table:
    //   from	to	target	type
    //   36	53	220	java/lang/Exception
    //   131	136	253	java/io/IOException
    //   71	88	278	java/lang/Exception
    //   320	325	330	java/io/IOException
    //   71	88	357	finally
    //   367	372	381	java/io/IOException
    //   92	103	406	finally
    //   107	112	406	finally
    //   116	121	406	finally
    //   125	131	406	finally
    //   287	313	406	finally
    //   92	103	411	java/lang/Exception
    //   107	112	411	java/lang/Exception
    //   116	121	411	java/lang/Exception
    //   125	131	411	java/lang/Exception
  }
  
  private static final boolean cQ(String paramString)
  {
    AppMethodBeat.i(57968);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
      AppMethodBeat.o(57968);
      return false;
    }
    Object localObject = new File(paramString);
    ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", new Object[] { paramString, Boolean.valueOf(((File)localObject).exists()), Boolean.valueOf(((File)localObject).isDirectory()) });
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      ab.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
      AppMethodBeat.o(57968);
      return true;
    }
    String[] arrayOfString = paramString.split("/");
    if ((arrayOfString == null) || (arrayOfString.length < 2))
    {
      ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
      AppMethodBeat.o(57968);
      return false;
    }
    localObject = "/";
    ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = (String)localObject;
      if (!bo.isNullOrNil(arrayOfString[i]))
      {
        localObject = (String)localObject + "/" + arrayOfString[i];
        File localFile = new File((String)localObject);
        if ((localFile.isFile()) && (!localFile.renameTo(new File((String)localObject + "_mmbak"))))
        {
          ab.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", new Object[] { localFile.getName() });
          AppMethodBeat.o(57968);
          return false;
        }
        paramString = (String)localObject;
        if (!localFile.exists())
        {
          paramString = (String)localObject;
          if (!localFile.mkdir())
          {
            ab.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", new Object[] { localFile.getName() });
            AppMethodBeat.o(57968);
            return false;
          }
        }
      }
      i += 1;
      localObject = paramString;
    }
    ab.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
    AppMethodBeat.o(57968);
    return true;
  }
  
  static HashMap<Integer, h.d> getBaseDBFactories()
  {
    AppMethodBeat.i(57977);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(baseDBFactories);
    AppMethodBeat.o(57977);
    return localHashMap;
  }
  
  private void mA(String paramString)
  {
    AppMethodBeat.i(57957);
    ab.i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", new Object[] { this.eHQ, paramString, this.eHR, this.cachePath });
    if (!bo.isNullOrNil(paramString))
    {
      this.eHQ = paramString;
      paramString = new StringBuilder("mm");
      g.RM();
      g.RJ();
      paramString = com.tencent.mm.a.g.w(a.getUin().getBytes());
      this.eHR = (this.eHQ + paramString + "/");
      FileSystemManager localFileSystemManager = FileSystemManager.dQE();
      localFileSystemManager.erS().iE("account", paramString).rM(false);
      localFileSystemManager.erT();
      ab.i("VFS.Debug", "SetEnv ${account} = " + paramString + " and broadcast.");
      Rm();
    }
    AppMethodBeat.o(57957);
  }
  
  final void Rl()
  {
    AppMethodBeat.i(57956);
    this.eHU.set(14, Integer.valueOf(com.tencent.mm.protocal.d.whH));
    AppMethodBeat.o(57956);
  }
  
  final void Rm()
  {
    AppMethodBeat.i(57958);
    com.tencent.mm.kernel.a.c.RX().mE(this.eHR);
    File localFile = new File(this.eHR + ".nomedia");
    if (!localFile.exists()) {
      try
      {
        localFile.createNewFile();
        AppMethodBeat.o(57958);
        return;
      }
      catch (IOException localIOException)
      {
        ab.e("MMKernel.CoreStorage", "exception:%s", new Object[] { bo.l(localIOException) });
      }
    }
    AppMethodBeat.o(57958);
  }
  
  public final boolean Rn()
  {
    AppMethodBeat.i(57961);
    g.RM();
    g.RJ().QQ();
    int i = bo.g((Integer)this.eHU.get(89, null));
    if (i != 0)
    {
      ab.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: ".concat(String.valueOf(i)));
      AppMethodBeat.o(57961);
      return false;
    }
    if ((bo.nullAsNil((String)this.eHU.get(8195, null)).length() <= 0) || (bo.g((Integer)this.eHU.get(15, null)) == 0)) {}
    for (boolean bool = true; (!bool) || (Ro() == null); bool = false)
    {
      this.eHU.set(89, Integer.valueOf(1));
      this.eHU.dww();
      ab.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(57961);
      return false;
    }
    ab.i("MMKernel.CoreStorage", "isDBCorrupted: true");
    AppMethodBeat.o(57961);
    return true;
  }
  
  public final String Ro()
  {
    AppMethodBeat.i(57962);
    Object localObject1 = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
    if (((File)localObject1).isFile())
    {
      localObject1 = ((File)localObject1).getAbsolutePath();
      AppMethodBeat.o(57962);
      return localObject1;
    }
    localObject1 = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
    if (((File)localObject1).isFile())
    {
      localObject1 = ((File)localObject1).getAbsolutePath();
      AppMethodBeat.o(57962);
      return localObject1;
    }
    String[] arrayOfString = new File(this.cachePath).list(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(57945);
        boolean bool = paramAnonymousString.startsWith("EnMicroMsg.dberr");
        AppMethodBeat.o(57945);
        return bool;
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
      localObject1 = this.cachePath + '/' + (String)localObject1;
      AppMethodBeat.o(57962);
      return localObject1;
    }
    AppMethodBeat.o(57962);
    return null;
  }
  
  public final String Rp()
  {
    return this.cachePath;
  }
  
  public final com.tencent.mm.cg.h Rq()
  {
    return this.eHS;
  }
  
  public final String Rr()
  {
    AppMethodBeat.i(57964);
    String str = this.cachePath + "MicroMsg.db";
    AppMethodBeat.o(57964);
    return str;
  }
  
  public final String Rs()
  {
    AppMethodBeat.i(57965);
    String str = this.cachePath + "EnMicroMsg.db";
    AppMethodBeat.o(57965);
    return str;
  }
  
  public final z Ru()
  {
    AppMethodBeat.i(57969);
    g.RM();
    g.RJ().QQ();
    z localz = this.eHU;
    AppMethodBeat.o(57969);
    return localz;
  }
  
  public final bs Rv()
  {
    AppMethodBeat.i(57970);
    g.RM();
    g.RJ().QQ();
    bs localbs = this.eHV;
    AppMethodBeat.o(57970);
    return localbs;
  }
  
  public final void Rw()
  {
    AppMethodBeat.i(57971);
    this.eId = Boolean.valueOf(isSDCardAvailable());
    AppMethodBeat.o(57971);
  }
  
  public final boolean Rx()
  {
    AppMethodBeat.i(57972);
    if (this.eId == null) {
      this.eId = Boolean.valueOf(isSDCardAvailable());
    }
    for (;;)
    {
      boolean bool = this.eId.booleanValue();
      AppMethodBeat.o(57972);
      return bool;
      long l = System.currentTimeMillis() - this.eIf;
      if ((l <= 0L) || (l >= 1000L))
      {
        com.tencent.mm.sdk.g.d.ysn.ak(this.eIe);
        com.tencent.mm.sdk.g.d.ysn.q(this.eIe, 1000L);
        this.eIf = System.currentTimeMillis();
      }
    }
  }
  
  /* Error */
  public final void Ry()
  {
    // Byte code:
    //   0: ldc_w 734
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 566	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   9: pop
    //   10: invokestatic 570	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   13: getfield 738	com/tencent/mm/kernel/a:eGQ	[B
    //   16: astore_2
    //   17: aload_2
    //   18: monitorenter
    //   19: invokestatic 250	com/tencent/mm/kernel/e:Rt	()Ljava/lang/String;
    //   22: astore_3
    //   23: ldc 187
    //   25: ldc_w 740
    //   28: iconst_4
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: invokestatic 573	com/tencent/mm/kernel/a:getUin	()I
    //   37: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_0
    //   44: getfield 252	com/tencent/mm/kernel/e:eHQ	Ljava/lang/String;
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: aload_3
    //   51: aastore
    //   52: dup
    //   53: iconst_3
    //   54: invokestatic 570	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   57: invokevirtual 743	com/tencent/mm/kernel/a:QU	()Z
    //   60: invokestatic 203	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   63: aastore
    //   64: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_3
    //   68: invokestatic 504	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   71: ifne +177 -> 248
    //   74: aload_3
    //   75: aload_0
    //   76: getfield 252	com/tencent/mm/kernel/e:eHQ	Ljava/lang/String;
    //   79: invokevirtual 284	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: istore_1
    //   83: iload_1
    //   84: ifeq +129 -> 213
    //   87: ldc 187
    //   89: new 169	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 745
    //   96: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: invokestatic 747	com/tencent/mm/kernel/e:Rz	()Z
    //   102: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   105: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 318	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc 187
    //   113: new 169	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 749
    //   120: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: invokestatic 751	com/tencent/mm/kernel/e:RA	()Z
    //   126: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   129: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 318	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_2
    //   136: monitorexit
    //   137: ldc_w 734
    //   140: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: return
    //   144: astore_3
    //   145: ldc 187
    //   147: new 169	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 753
    //   154: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_3
    //   158: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 339	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: goto -59 -> 111
    //   173: astore_3
    //   174: aload_2
    //   175: monitorexit
    //   176: ldc_w 734
    //   179: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_3
    //   183: athrow
    //   184: astore_3
    //   185: ldc 187
    //   187: new 169	java/lang/StringBuilder
    //   190: dup
    //   191: ldc_w 755
    //   194: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload_3
    //   198: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 339	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: goto -75 -> 135
    //   213: aload_0
    //   214: aload_3
    //   215: invokespecial 757	com/tencent/mm/kernel/e:mA	(Ljava/lang/String;)V
    //   218: invokestatic 624	com/tencent/mm/kernel/a/c:RX	()Lcom/tencent/mm/kernel/a/c;
    //   221: getfield 761	com/tencent/mm/kernel/a/c:eJd	Lcom/tencent/mm/kernel/a/c$e;
    //   224: invokevirtual 766	com/tencent/mm/kernel/a/c$e:RS	()V
    //   227: ldc 187
    //   229: ldc_w 768
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: invokestatic 412	com/tencent/mm/compatible/util/f:Mi	()Z
    //   241: invokestatic 203	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   244: aastore
    //   245: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload_2
    //   249: monitorexit
    //   250: ldc_w 734
    //   253: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	e
    //   82	2	1	bool	boolean
    //   16	233	2	arrayOfByte	byte[]
    //   22	53	3	str	String
    //   144	14	3	localException1	Exception
    //   173	10	3	localObject	Object
    //   184	31	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   87	111	144	java/lang/Exception
    //   19	83	173	finally
    //   87	111	173	finally
    //   111	135	173	finally
    //   135	137	173	finally
    //   145	170	173	finally
    //   174	176	173	finally
    //   185	210	173	finally
    //   213	248	173	finally
    //   248	250	173	finally
    //   111	135	184	java/lang/Exception
  }
  
  public final boolean a(com.tencent.mm.cg.f paramf, HashMap<Integer, h.d> paramHashMap)
  {
    AppMethodBeat.i(57960);
    int i;
    g.a locala;
    Iterator localIterator;
    if (paramHashMap == null)
    {
      i = -1;
      ab.i("MMKernel.CoreStorage", "createtables %d %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
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
          label258:
          Object localObject2;
          if (!this.eHY)
          {
            paramHashMap = new StringBuilder();
            localObject1 = locald.getSQLs();
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
            localObject1 = com.tencent.mm.a.g.w(paramHashMap.toString().getBytes());
            if (this.eHX != null)
            {
              paramHashMap = (String)this.eHX.get(localInteger);
              ab.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", new Object[] { localInteger, paramHashMap, localObject1 });
              if ((paramHashMap != null) && (((String)localObject1).equals(paramHashMap))) {
                continue;
              }
              paramHashMap = (HashMap<Integer, h.d>)localObject1;
            }
          }
          else
          {
            paramf.beginTransaction();
            localObject1 = locald.getSQLs();
            k = localObject1.length;
            j = 0;
            for (;;)
            {
              if (j >= k) {
                break label573;
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
                  Object localObject3 = com.tencent.mm.cg.a.yQi.matcher((CharSequence)localObject2);
                  if ((localObject3 != null) && (((Matcher)localObject3).matches())) {
                    Assert.assertTrue("CreateTable failed:[" + (String)localObject2 + "][" + localException.getMessage() + "]", false);
                  } else {
                    ab.w("MMKernel.CoreStorage", "CreateTable failed:[" + (String)localObject2 + "][" + localException.getMessage() + "]");
                  }
                }
              }
              j += 1;
            }
          }
          if (this.eHW != null)
          {
            localObject3 = this.eHW;
            j = localInteger.intValue();
            paramHashMap = null;
            localObject2 = null;
            localObject3 = ((by)localObject3).rawQuery("select * from TablesVersion where tableHash = ".concat(String.valueOf(j)), new String[0]);
            if (localObject3 != null)
            {
              paramHashMap = (HashMap<Integer, h.d>)localObject2;
              if (((Cursor)localObject3).moveToFirst())
              {
                paramHashMap = new bx();
                paramHashMap.convertFrom((Cursor)localObject3);
              }
              ((Cursor)localObject3).close();
            }
            if (paramHashMap != null) {
              break label449;
            }
          }
          label449:
          for (paramHashMap = null;; paramHashMap = paramHashMap.field_tableSQLMD5)
          {
            ab.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", new Object[] { localInteger, paramHashMap, localObject1 });
            if ((paramHashMap != null) && (((String)localObject1).equals(paramHashMap))) {
              break;
            }
            paramHashMap = (HashMap<Integer, h.d>)localObject1;
            break label258;
          }
          label573:
          paramf.endTransaction();
          if ((!this.eHY) && (this.eHW != null) && (paramHashMap != null))
          {
            localObject1 = this.eHW;
            j = localInteger.intValue();
            if (j == 0) {
              break label691;
            }
          }
          label691:
          for (boolean bool = true;; bool = false)
          {
            Assert.assertTrue(bool);
            Assert.assertNotNull(paramHashMap);
            localObject2 = new bx();
            ((bx)localObject2).field_tableHash = j;
            ((bx)localObject2).field_tableSQLMD5 = paramHashMap;
            ((by)localObject1).fnw.replace("TablesVersion", "tableHash", ((bx)localObject2).convertTo());
            if ((this.eHX != null) && (paramHashMap != null)) {
              this.eHX.put(localInteger, paramHashMap);
            }
            break;
          }
        }
      }
      ab.i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(locala.Mm()), Long.valueOf(locala.Mm()), Integer.valueOf(i) });
    }
    AppMethodBeat.o(57960);
    return true;
  }
  
  public final boolean a(aj paramaj)
  {
    AppMethodBeat.i(57955);
    if (paramaj == null)
    {
      ab.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
      AppMethodBeat.o(57955);
      return false;
    }
    int i = bo.g((Integer)this.eHU.get(14, null));
    int j = com.tencent.mm.protocal.d.whH;
    ab.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + i + ", cVer = " + j);
    paramaj = paramaj.getDataTransferList();
    if (paramaj == null)
    {
      ab.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
      AppMethodBeat.o(57955);
      return false;
    }
    if ((ae.gkC > 0) && (ae.gkD > 0)) {
      ab.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
    }
    long l1;
    label383:
    boolean bool1;
    do
    {
      ab.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + paramaj.size());
      ab.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
      l1 = this.eHS.kr(Thread.currentThread().getId());
      try
      {
        paramaj = paramaj.iterator();
        while (paramaj.hasNext())
        {
          localObject = (ai)paramaj.next();
          long l2 = System.currentTimeMillis();
          ((ai)localObject).transfer(i);
          ((ai)localObject).flH = (System.currentTimeMillis() - l2);
          ab.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + ((ai)localObject).flH + ", tag = " + ((ai)localObject).getTag());
        }
        if (i != j) {
          break label383;
        }
      }
      catch (Throwable paramaj)
      {
        AppMethodBeat.o(57955);
        throw paramaj;
      }
      finally
      {
        if (l1 > 0L) {
          this.eHS.nY(l1);
        }
        AppMethodBeat.o(57955);
      }
      ab.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + i + ", cVer = " + j);
      AppMethodBeat.o(57955);
      return false;
      bool1 = false;
      Object localObject = paramaj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        boolean bool2 = ((ai)((Iterator)localObject).next()).kv(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
      ab.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = ".concat(String.valueOf(bool1)));
    } while (bool1);
    AppMethodBeat.o(57955);
    return false;
    if ((ae.gkC != 0) && (ae.gkD != 0))
    {
      i = 0;
      for (;;)
      {
        j = ae.gkC;
        if (i < j) {
          try
          {
            Thread.sleep(ae.gkD);
            i += 1;
          }
          catch (InterruptedException paramaj)
          {
            for (;;)
            {
              ab.e("MMKernel.CoreStorage", "exception:%s", new Object[] { bo.l(paramaj) });
            }
          }
        }
      }
    }
    if (l1 > 0L) {
      this.eHS.nY(l1);
    }
    AppMethodBeat.o(57955);
    return true;
  }
  
  public final String getAccPath()
  {
    return this.eHR;
  }
  
  public final boolean isSDCardAvailable()
  {
    AppMethodBeat.i(57973);
    boolean bool1 = this.eHQ.startsWith(com.tencent.mm.compatible.util.e.eQx);
    long l1 = bo.aoy();
    long l2 = l1 - this.eIb;
    if (bool1)
    {
      g.RM();
      if ((g.RJ().QU()) && (l2 > 0L) && (l2 < 2000L) && (new File(this.eHQ).exists()))
      {
        AppMethodBeat.o(57973);
        return true;
      }
    }
    this.eIb = l1;
    boolean bool2 = com.tencent.mm.compatible.util.f.Mi();
    g.RM();
    g.RJ();
    ab.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", new Object[] { Boolean.valueOf(bool2), p.getString(a.getUin()), Long.valueOf(l2), this.eHQ, com.tencent.mm.compatible.util.e.eQx, Boolean.valueOf(g.RJ().QU()) });
    if (!bool2)
    {
      AppMethodBeat.o(57973);
      return false;
    }
    if (bool1)
    {
      AppMethodBeat.o(57973);
      return true;
    }
    g.RM();
    if (g.RJ().QU())
    {
      ab.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
      Ry();
    }
    AppMethodBeat.o(57973);
    return true;
  }
  
  public final void kr(String paramString)
  {
    AppMethodBeat.i(57963);
    if (this.eHT != null) {
      this.eHT.closeDB();
    }
    if (this.eHS != null) {
      this.eHS.kr(paramString);
    }
    this.eHN.onDataBaseClosed(this.eHS, this.eHT);
    this.eHY = false;
    AppMethodBeat.o(57963);
  }
  
  final void mB(final String paramString)
  {
    AppMethodBeat.i(57959);
    File localFile = new File(paramString + "-recovery");
    if (localFile.isFile())
    {
      ab.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
      new File(paramString + ".ini").delete();
      paramString = new File(paramString);
      paramString.delete();
      if (!localFile.renameTo(paramString)) {
        ab.e("MMKernel.CoreStorage", "Rename database file failed!");
      }
    }
    paramString = localFile.getName();
    paramString = localFile.getParentFile().listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(57939);
        if ((paramAnonymousString.startsWith(paramString)) && (!paramAnonymousString.equals(paramString)))
        {
          AppMethodBeat.o(57939);
          return true;
        }
        AppMethodBeat.o(57939);
        return false;
      }
    });
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramString[i];
        ab.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + localFile.getName());
        localFile.delete();
        i += 1;
      }
    }
    AppMethodBeat.o(57959);
  }
  
  public final SharedPreferences mC(String paramString)
  {
    AppMethodBeat.i(57966);
    g.RM();
    g.RJ();
    int i = a.getUin();
    if (i != 0) {
      if (this.eIa.containsKey(paramString))
      {
        paramString = (SharedPreferences)this.eIa.get(paramString);
        AppMethodBeat.o(57966);
        return paramString;
      }
    }
    try
    {
      localObject1 = ah.getContext().getFilesDir().getParent() + "/shared_prefs/";
      Object localObject2 = ah.dsP() + paramString + i + ".xml";
      String str = ah.dsP() + paramString + i + ".xml.bak";
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
      label227:
      break label227;
    }
    localObject1 = ag.cE(String.valueOf(i / 2));
    localObject1 = ah.dsP() + paramString + ag.cE(new StringBuilder().append(i).append((String)localObject1).toString());
    localObject1 = ah.getContext().getSharedPreferences((String)localObject1, 0);
    this.eIa.put(paramString, localObject1);
    AppMethodBeat.o(57966);
    return localObject1;
    AppMethodBeat.o(57966);
    return null;
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(57946);
      e.this.Rw();
      AppMethodBeat.o(57946);
    }
  }
  
  public static final class b
    extends com.tencent.mm.cm.a<h.a>
    implements h.a
  {
    public final void RB()
    {
      AppMethodBeat.i(57950);
      a(new a.a() {});
      AppMethodBeat.o(57950);
    }
    
    public final void RC()
    {
      AppMethodBeat.i(57951);
      a(new a.a() {});
      AppMethodBeat.o(57951);
    }
    
    public final void RD()
    {
      AppMethodBeat.i(57952);
      a(new a.a() {});
      AppMethodBeat.o(57952);
    }
  }
  
  public static final class c
  {
    public boolean eIj = false;
    public int eIk = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.e
 * JD-Core Version:    0.7.0.1
 */