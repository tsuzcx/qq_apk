package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.co.a.a;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.al;
import com.tencent.mm.model.am;
import com.tencent.mm.model.ci;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storagebase.f;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.storagebase.h.c;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.Integer;Lcom.tencent.mm.storagebase.h.b;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class e
{
  private static HashMap<Integer, h.b> baseDBFactories;
  public String cachePath;
  public final aa gcR;
  private com.tencent.mm.kernel.api.e gcS;
  public b gcT;
  b gcU;
  public String gcV;
  public String gcW;
  public String gcX;
  String gcY;
  String gcZ;
  public com.tencent.mm.storagebase.h gda;
  public com.tencent.mm.storagebase.h gdb;
  com.tencent.mm.storage.ab gdc;
  com.tencent.mm.storage.bt gdd;
  bz gde;
  ConcurrentHashMap<Integer, String> gdf;
  boolean gdg;
  ci gdh;
  ConcurrentHashMap<String, SharedPreferences> gdi;
  private long gdj;
  private ap gdk;
  public volatile Boolean gdl;
  public a gdm;
  public long gdn;
  
  static
  {
    AppMethodBeat.i(132107);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.ab.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("TablesVersion".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bz.SQL_CREATE;
      }
    });
    AppMethodBeat.o(132107);
  }
  
  public e(com.tencent.mm.kernel.api.e parame)
  {
    AppMethodBeat.i(132077);
    this.gcT = new b();
    this.gcU = new b();
    this.gda = null;
    this.gdb = null;
    this.gdg = false;
    this.gdi = new ConcurrentHashMap();
    this.gdj = 0L;
    this.gdk = null;
    this.gdl = null;
    this.gdm = new a((byte)0);
    this.gdn = 0L;
    this.gcR = afa();
    a.gbY.a(this.gcR);
    String str1 = com.tencent.mm.storage.ae.FfH + "alphahold.ini";
    ad.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", new Object[] { Integer.valueOf(d.CpK), Boolean.valueOf(d.CpN), str1 });
    String str2;
    int i;
    if (d.CpN)
    {
      str2 = com.tencent.mm.sdk.e.a.getValue(str1, "noneedhold");
      i = d.CpK;
    }
    try
    {
      int j = Integer.decode(com.tencent.mm.loader.j.a.glW).intValue();
      i = j;
    }
    catch (Throwable localThrowable)
    {
      label195:
      break label195;
    }
    if (!String.valueOf(i).equals(str2))
    {
      ad.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(d.CpN) });
      a.aeu();
      com.tencent.mm.sdk.e.a.aS(str1, "noneedhold", String.valueOf(i));
    }
    for (;;)
    {
      this.gcV = afj();
      this.gcS = parame;
      AppMethodBeat.o(132077);
      return;
      i.deleteFile(str1);
    }
  }
  
  static String C(int paramInt, String paramString)
  {
    AppMethodBeat.i(132106);
    com.tencent.mm.vfs.e locale1 = new com.tencent.mm.vfs.e(b.ahY(), "account.bin");
    com.tencent.mm.vfs.e locale2 = new com.tencent.mm.vfs.e(b.ahY() + "MicroMsg/" + paramString + "/account.bin");
    Object localObject1 = h(locale1);
    Object localObject2 = h(locale2);
    int i;
    if (localObject2 != null)
    {
      i = 0;
      paramString = (String)localObject2;
    }
    for (;;)
    {
      boolean bool1 = false;
      if ((localObject2 == null) || (locale2.length() != 4112L)) {
        bool1 = a(locale2, paramString) | false;
      }
      boolean bool2;
      if (localObject1 != null)
      {
        bool2 = bool1;
        if (locale1.length() == 4112L) {}
      }
      else
      {
        bool2 = bool1 | a(locale1, paramString);
      }
      if ((i == 0) || (bool2)) {
        break;
      }
      ad.e("MMKernel.CoreStorage", "Cannot write new generated data to account files.");
      AppMethodBeat.o(132106);
      return null;
      if (localObject1 != null)
      {
        i = 0;
        paramString = (String)localObject1;
      }
      else
      {
        paramString = afq();
        if (paramString == null)
        {
          AppMethodBeat.o(132106);
          return null;
        }
        i = 1;
      }
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(paramString);
      ((MessageDigest)localObject1).update(Integer.toString(paramInt).getBytes());
      paramString = ((MessageDigest)localObject1).digest();
      localObject1 = new StringBuilder(paramString.length * 2);
      localObject2 = new char[16];
      Object tmp256_254 = localObject2;
      tmp256_254[0] = 48;
      Object tmp262_256 = tmp256_254;
      tmp262_256[1] = 49;
      Object tmp268_262 = tmp262_256;
      tmp268_262[2] = 50;
      Object tmp274_268 = tmp268_262;
      tmp274_268[3] = 51;
      Object tmp280_274 = tmp274_268;
      tmp280_274[4] = 52;
      Object tmp286_280 = tmp280_274;
      tmp286_280[5] = 53;
      Object tmp292_286 = tmp286_280;
      tmp292_286[6] = 54;
      Object tmp299_292 = tmp292_286;
      tmp299_292[7] = 55;
      Object tmp306_299 = tmp299_292;
      tmp306_299[8] = 56;
      Object tmp313_306 = tmp306_299;
      tmp313_306[9] = 57;
      Object tmp320_313 = tmp313_306;
      tmp320_313[10] = 97;
      Object tmp327_320 = tmp320_313;
      tmp327_320[11] = 98;
      Object tmp334_327 = tmp327_320;
      tmp334_327[12] = 99;
      Object tmp341_334 = tmp334_327;
      tmp341_334[13] = 100;
      Object tmp348_341 = tmp341_334;
      tmp348_341[14] = 101;
      Object tmp355_348 = tmp348_341;
      tmp355_348[15] = 102;
      tmp355_348;
      paramInt = 0;
      while (paramInt < 16)
      {
        i = paramString[paramInt];
        ((StringBuilder)localObject1).append(localObject2[(i >>> 4 & 0xF)]).append(localObject2[(i & 0xF)]);
        paramInt += 1;
      }
      paramString = ((StringBuilder)localObject1).toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(132106);
      throw paramString;
    }
    AppMethodBeat.o(132106);
    return paramString;
  }
  
  /* Error */
  private static boolean a(com.tencent.mm.vfs.e parame, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 361
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: arraylength
    //   8: sipush 4096
    //   11: if_icmpeq +19 -> 30
    //   14: ldc 190
    //   16: ldc_w 363
    //   19: invokestatic 305	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 361
    //   25: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: invokevirtual 367	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   34: invokevirtual 371	com/tencent/mm/vfs/e:mkdirs	()Z
    //   37: pop
    //   38: aload_0
    //   39: invokestatic 375	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   42: astore_3
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 380	java/io/OutputStream:write	([B)V
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 386	com/tencent/mm/b/g:E	([B)[B
    //   55: invokevirtual 380	java/io/OutputStream:write	([B)V
    //   58: ldc 190
    //   60: ldc_w 388
    //   63: aload_0
    //   64: invokestatic 391	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokevirtual 395	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokestatic 397	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: invokevirtual 400	java/io/OutputStream:close	()V
    //   81: ldc_w 361
    //   84: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_1
    //   88: ireturn
    //   89: astore_2
    //   90: ldc_w 361
    //   93: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: aload_3
    //   100: ifnull +11 -> 111
    //   103: aload_2
    //   104: ifnull +50 -> 154
    //   107: aload_3
    //   108: invokevirtual 400	java/io/OutputStream:close	()V
    //   111: ldc_w 361
    //   114: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: ldc 190
    //   122: aload_1
    //   123: ldc_w 402
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: invokestatic 406	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: ldc_w 361
    //   140: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_3
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 409	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   151: goto -40 -> 111
    //   154: aload_3
    //   155: invokevirtual 400	java/io/OutputStream:close	()V
    //   158: goto -47 -> 111
    //   161: astore_1
    //   162: goto -63 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	parame	com.tencent.mm.vfs.e
    //   0	165	1	paramArrayOfByte	byte[]
    //   44	1	2	localObject	Object
    //   89	58	2	localThrowable1	Throwable
    //   42	66	3	localOutputStream	OutputStream
    //   145	10	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   45	73	89	java/lang/Throwable
    //   90	98	98	finally
    //   38	43	119	java/io/IOException
    //   77	81	119	java/io/IOException
    //   107	111	119	java/io/IOException
    //   111	119	119	java/io/IOException
    //   146	151	119	java/io/IOException
    //   154	158	119	java/io/IOException
    //   107	111	145	java/lang/Throwable
    //   45	73	161	finally
  }
  
  private static aa afa()
  {
    AppMethodBeat.i(132078);
    ad.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", new Object[] { com.tencent.mm.sdk.platformtools.h.info(), Integer.valueOf(d.CpK) });
    Object localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.storage.ae.FfH);
    if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
      ((com.tencent.mm.vfs.e)localObject1).mkdirs();
    }
    localObject1 = new aa(com.tencent.mm.storage.ae.FfH + "systemInfo.cfg");
    Object localObject2 = (String)((aa)localObject1).get(258);
    if (localObject2 != null) {
      l.WE().set(258, localObject2);
    }
    try
    {
      localObject2 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
      ad.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { com.tencent.mm.compatible.util.g.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      AppMethodBeat.o(132078);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MMKernel.CoreStorage", "check data size failed :%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static String afj()
  {
    AppMethodBeat.i(132092);
    Object localObject2 = com.tencent.mm.storage.ae.FfH;
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(b.aib());
    ad.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + (String)localObject2 + "] SDCARD_ROOT[" + b.aib() + "] file.exists:" + locale.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.e.XG());
    Object localObject1 = localObject2;
    if (locale.exists())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.XG())
      {
        localObject1 = localObject2;
        if (qS(b.aih())) {
          localObject1 = b.aih();
        }
        localObject2 = new com.tencent.mm.vfs.e(b.ais());
        if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
          ((com.tencent.mm.vfs.e)localObject2).mkdirs();
        }
        localObject2 = new com.tencent.mm.vfs.e(b.aik());
        if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
          ((com.tencent.mm.vfs.e)localObject2).mkdirs();
        }
        localObject2 = new com.tencent.mm.vfs.e(b.ail());
        if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
          ((com.tencent.mm.vfs.e)localObject2).mkdirs();
        }
        localObject2 = new com.tencent.mm.vfs.e(b.aim());
        if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
          ((com.tencent.mm.vfs.e)localObject2).mkdirs();
        }
        localObject2 = new com.tencent.mm.vfs.e(b.aik() + ".nomedia");
        if (((com.tencent.mm.vfs.e)localObject2).exists()) {}
      }
    }
    try
    {
      ((com.tencent.mm.vfs.e)localObject2).createNewFile();
      qS(b.aij());
      localObject2 = new com.tencent.mm.vfs.e((String)localObject1);
      if (!((com.tencent.mm.vfs.e)localObject2).exists()) {
        ((com.tencent.mm.vfs.e)localObject2).mkdirs();
      }
      ad.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(132092);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MMKernel.CoreStorage", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException) });
      }
    }
  }
  
  private static boolean afo()
  {
    bool3 = false;
    AppMethodBeat.i(132100);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool4 = b.aib().equalsIgnoreCase(str);
    boolean bool5 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool2 = new com.tencent.mm.vfs.e(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
      locale = new com.tencent.mm.vfs.e(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
      localObject3 = null;
      localOutputStream3 = null;
      localOutputStream2 = localOutputStream3;
      localObject1 = localObject3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          com.tencent.mm.vfs.e locale;
          Object localObject3;
          locale.createNewFile();
          localOutputStream2 = localOutputStream3;
          Object localObject1 = localObject3;
          localOutputStream3 = i.ai(locale);
          localOutputStream2 = localOutputStream3;
          localObject1 = localOutputStream3;
          localOutputStream3.write("test".getBytes());
          localOutputStream2 = localOutputStream3;
          localObject1 = localOutputStream3;
          localOutputStream3.flush();
          localOutputStream2 = localOutputStream3;
          localObject1 = localOutputStream3;
          localOutputStream3.close();
          localOutputStream2 = localOutputStream3;
          localObject1 = localOutputStream3;
          bool1 = locale.delete();
          if (localOutputStream3 == null) {
            continue;
          }
        }
        catch (Exception localException2)
        {
          boolean bool2;
          OutputStream localOutputStream3;
          OutputStream localOutputStream2;
          OutputStream localOutputStream1 = localOutputStream2;
          ad.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + localException2.getMessage());
          boolean bool1 = bool3;
          if (localOutputStream2 == null) {
            continue;
          }
          try
          {
            localOutputStream2.close();
            bool1 = bool3;
          }
          catch (IOException localIOException2)
          {
            ad.e("MMKernel.CoreStorage", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException2) });
            bool1 = bool3;
          }
          continue;
        }
        finally
        {
          if (localIOException2 == null) {
            continue;
          }
          try
          {
            localIOException2.close();
            AppMethodBeat.o(132100);
            throw localObject2;
          }
          catch (IOException localIOException3)
          {
            ad.e("MMKernel.CoreStorage", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException3) });
            continue;
          }
          continue;
        }
        try
        {
          localOutputStream3.close();
          ad.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + b.aib() + " isPrimaryExtStg: " + bool4 + " mounted: " + bool5 + " canWrite: " + bool2 + " canTrueWrite:" + bool1);
          AppMethodBeat.o(132100);
          return bool1;
          localException1 = localException1;
          ad.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + localException1.getMessage());
          bool2 = false;
        }
        catch (IOException localIOException1)
        {
          ad.e("MMKernel.CoreStorage", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException1) });
        }
      }
    }
  }
  
  private static boolean afp()
  {
    AppMethodBeat.i(132101);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool2 = b.aib().equalsIgnoreCase(str);
    boolean bool3 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool1 = new com.tencent.mm.vfs.e(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(b.aih());
      boolean bool4 = locale.exists();
      if (bool4) {
        ad.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + locale.isDirectory() + " isFile:" + locale.isFile());
      }
      ad.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + b.aib() + " CConstants.DATAROOT_SDCARD_PATH: " + b.aih() + " isPrimaryExtStg: " + bool2 + " mounted: " + bool3 + " canRead: " + bool1 + " canTrueRead:" + bool4);
      AppMethodBeat.o(132101);
      return bool4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = false;
        ad.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + localException.getMessage());
      }
    }
  }
  
  /* Error */
  private static byte[] afq()
  {
    // Byte code:
    //   0: ldc_w 603
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 605
    //   9: invokestatic 609	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 4
    //   14: sipush 4096
    //   17: newarray byte
    //   19: astore_2
    //   20: iconst_0
    //   21: istore_0
    //   22: aload 4
    //   24: aload_2
    //   25: iload_0
    //   26: sipush 4096
    //   29: iload_0
    //   30: isub
    //   31: invokevirtual 615	java/io/InputStream:read	([BII)I
    //   34: istore_1
    //   35: iload_1
    //   36: ifge +29 -> 65
    //   39: ldc 190
    //   41: ldc_w 617
    //   44: invokestatic 305	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 4
    //   49: ifnull +8 -> 57
    //   52: aload 4
    //   54: invokevirtual 618	java/io/InputStream:close	()V
    //   57: ldc_w 603
    //   60: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aconst_null
    //   64: areturn
    //   65: iload_0
    //   66: iload_1
    //   67: iadd
    //   68: istore_1
    //   69: iload_1
    //   70: istore_0
    //   71: iload_1
    //   72: sipush 4096
    //   75: if_icmplt -53 -> 22
    //   78: aload 4
    //   80: ifnull +8 -> 88
    //   83: aload 4
    //   85: invokevirtual 618	java/io/InputStream:close	()V
    //   88: ldc_w 603
    //   91: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_2
    //   95: areturn
    //   96: astore_3
    //   97: ldc_w 603
    //   100: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_3
    //   104: athrow
    //   105: astore_2
    //   106: aload 4
    //   108: ifnull +12 -> 120
    //   111: aload_3
    //   112: ifnull +49 -> 161
    //   115: aload 4
    //   117: invokevirtual 618	java/io/InputStream:close	()V
    //   120: ldc_w 603
    //   123: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_2
    //   127: athrow
    //   128: astore_2
    //   129: ldc 190
    //   131: aload_2
    //   132: ldc_w 620
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 406	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: ldc_w 603
    //   145: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aconst_null
    //   149: areturn
    //   150: astore 4
    //   152: aload_3
    //   153: aload 4
    //   155: invokevirtual 409	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   158: goto -38 -> 120
    //   161: aload 4
    //   163: invokevirtual 618	java/io/InputStream:close	()V
    //   166: goto -46 -> 120
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_3
    //   172: goto -66 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	50	0	i	int
    //   34	42	1	j	int
    //   19	76	2	arrayOfByte	byte[]
    //   105	22	2	localObject1	Object
    //   128	4	2	localIOException	IOException
    //   169	1	2	localObject2	Object
    //   96	57	3	localThrowable1	Throwable
    //   171	1	3	localObject3	Object
    //   12	104	4	localInputStream	java.io.InputStream
    //   150	12	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	20	96	java/lang/Throwable
    //   22	35	96	java/lang/Throwable
    //   39	47	96	java/lang/Throwable
    //   97	105	105	finally
    //   6	14	128	java/io/IOException
    //   52	57	128	java/io/IOException
    //   83	88	128	java/io/IOException
    //   115	120	128	java/io/IOException
    //   120	128	128	java/io/IOException
    //   152	158	128	java/io/IOException
    //   161	166	128	java/io/IOException
    //   115	120	150	java/lang/Throwable
    //   14	20	169	finally
    //   22	35	169	finally
    //   39	47	169	finally
  }
  
  static HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(132102);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(baseDBFactories);
    AppMethodBeat.o(132102);
    return localHashMap;
  }
  
  /* Error */
  private static byte[] h(com.tencent.mm.vfs.e parame)
  {
    // Byte code:
    //   0: ldc_w 634
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 295	com/tencent/mm/vfs/e:length	()J
    //   10: lstore_3
    //   11: lload_3
    //   12: ldc2_w 635
    //   15: lcmp
    //   16: ifeq +42 -> 58
    //   19: lload_3
    //   20: ldc2_w 296
    //   23: lcmp
    //   24: ifeq +34 -> 58
    //   27: ldc 190
    //   29: ldc_w 638
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: lload_3
    //   43: invokestatic 643	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: aastore
    //   47: invokestatic 243	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc_w 634
    //   53: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: invokestatic 647	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   62: astore 7
    //   64: sipush 4096
    //   67: newarray byte
    //   69: astore 5
    //   71: iconst_0
    //   72: istore_1
    //   73: aload 7
    //   75: aload 5
    //   77: iload_1
    //   78: sipush 4096
    //   81: iload_1
    //   82: isub
    //   83: invokevirtual 615	java/io/InputStream:read	([BII)I
    //   86: istore_2
    //   87: iload_2
    //   88: ifge +44 -> 132
    //   91: ldc 190
    //   93: ldc_w 649
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_0
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: iload_1
    //   107: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: invokestatic 476	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 7
    //   116: ifnull +8 -> 124
    //   119: aload 7
    //   121: invokevirtual 618	java/io/InputStream:close	()V
    //   124: ldc_w 634
    //   127: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aconst_null
    //   131: areturn
    //   132: iload_1
    //   133: iload_2
    //   134: iadd
    //   135: istore_2
    //   136: iload_2
    //   137: istore_1
    //   138: iload_2
    //   139: sipush 4096
    //   142: if_icmplt -69 -> 73
    //   145: lload_3
    //   146: ldc2_w 635
    //   149: lcmp
    //   150: ifle +128 -> 278
    //   153: bipush 16
    //   155: newarray byte
    //   157: astore 6
    //   159: iconst_0
    //   160: istore_1
    //   161: aload 7
    //   163: aload 6
    //   165: iload_1
    //   166: bipush 16
    //   168: iload_1
    //   169: isub
    //   170: invokevirtual 615	java/io/InputStream:read	([BII)I
    //   173: istore_2
    //   174: iload_2
    //   175: ifge +44 -> 219
    //   178: ldc 190
    //   180: ldc_w 649
    //   183: iconst_2
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_0
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: iload_1
    //   194: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 476	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 7
    //   203: ifnull +8 -> 211
    //   206: aload 7
    //   208: invokevirtual 618	java/io/InputStream:close	()V
    //   211: ldc_w 634
    //   214: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aconst_null
    //   218: areturn
    //   219: iload_1
    //   220: iload_2
    //   221: iadd
    //   222: istore_2
    //   223: iload_2
    //   224: istore_1
    //   225: iload_2
    //   226: bipush 16
    //   228: if_icmplt -67 -> 161
    //   231: aload 6
    //   233: aload 5
    //   235: invokestatic 386	com/tencent/mm/b/g:E	([B)[B
    //   238: invokestatic 654	java/util/Arrays:equals	([B[B)Z
    //   241: ifne +37 -> 278
    //   244: ldc 190
    //   246: ldc_w 656
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload_0
    //   256: aastore
    //   257: invokestatic 476	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 7
    //   262: ifnull +8 -> 270
    //   265: aload 7
    //   267: invokevirtual 618	java/io/InputStream:close	()V
    //   270: ldc_w 634
    //   273: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aconst_null
    //   277: areturn
    //   278: aload 7
    //   280: ifnull +8 -> 288
    //   283: aload 7
    //   285: invokevirtual 618	java/io/InputStream:close	()V
    //   288: ldc_w 634
    //   291: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload 5
    //   296: areturn
    //   297: astore 6
    //   299: ldc_w 634
    //   302: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload 6
    //   307: athrow
    //   308: astore 5
    //   310: aload 7
    //   312: ifnull +13 -> 325
    //   315: aload 6
    //   317: ifnull +57 -> 374
    //   320: aload 7
    //   322: invokevirtual 618	java/io/InputStream:close	()V
    //   325: ldc_w 634
    //   328: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload 5
    //   333: athrow
    //   334: astore 5
    //   336: ldc 190
    //   338: aload 5
    //   340: ldc_w 658
    //   343: iconst_1
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: aload_0
    //   350: aastore
    //   351: invokestatic 406	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: ldc_w 634
    //   357: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: aconst_null
    //   361: areturn
    //   362: astore 7
    //   364: aload 6
    //   366: aload 7
    //   368: invokevirtual 409	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   371: goto -46 -> 325
    //   374: aload 7
    //   376: invokevirtual 618	java/io/InputStream:close	()V
    //   379: goto -54 -> 325
    //   382: astore 5
    //   384: aconst_null
    //   385: astore 6
    //   387: goto -77 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	parame	com.tencent.mm.vfs.e
    //   72	153	1	i	int
    //   86	143	2	j	int
    //   10	136	3	l	long
    //   69	226	5	arrayOfByte1	byte[]
    //   308	24	5	localObject1	Object
    //   334	5	5	localIOException	IOException
    //   382	1	5	localObject2	Object
    //   157	75	6	arrayOfByte2	byte[]
    //   297	68	6	localThrowable1	Throwable
    //   385	1	6	localObject3	Object
    //   62	259	7	localInputStream	java.io.InputStream
    //   362	13	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   64	71	297	java/lang/Throwable
    //   73	87	297	java/lang/Throwable
    //   91	114	297	java/lang/Throwable
    //   153	159	297	java/lang/Throwable
    //   161	174	297	java/lang/Throwable
    //   178	201	297	java/lang/Throwable
    //   231	260	297	java/lang/Throwable
    //   299	308	308	finally
    //   58	64	334	java/io/IOException
    //   119	124	334	java/io/IOException
    //   206	211	334	java/io/IOException
    //   265	270	334	java/io/IOException
    //   283	288	334	java/io/IOException
    //   320	325	334	java/io/IOException
    //   325	334	334	java/io/IOException
    //   364	371	334	java/io/IOException
    //   374	379	334	java/io/IOException
    //   320	325	362	java/lang/Throwable
    //   64	71	382	finally
    //   73	87	382	finally
    //   91	114	382	finally
    //   153	159	382	finally
    //   161	174	382	finally
    //   178	201	382	finally
    //   231	260	382	finally
  }
  
  public static String mr(int paramInt)
  {
    AppMethodBeat.i(132088);
    String str = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(paramInt)).getBytes());
    str = com.tencent.mm.storage.ae.FfH + str + '/';
    AppMethodBeat.o(132088);
    return str;
  }
  
  private static final boolean qS(String paramString)
  {
    AppMethodBeat.i(132093);
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
    {
      ad.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
      AppMethodBeat.o(132093);
      return false;
    }
    Object localObject = new com.tencent.mm.vfs.e(paramString);
    ad.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", new Object[] { paramString, Boolean.valueOf(((com.tencent.mm.vfs.e)localObject).exists()), Boolean.valueOf(((com.tencent.mm.vfs.e)localObject).isDirectory()) });
    if ((((com.tencent.mm.vfs.e)localObject).exists()) && (((com.tencent.mm.vfs.e)localObject).isDirectory()))
    {
      ad.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
      AppMethodBeat.o(132093);
      return true;
    }
    String[] arrayOfString = paramString.split("/");
    if ((arrayOfString == null) || (arrayOfString.length < 2))
    {
      ad.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
      AppMethodBeat.o(132093);
      return false;
    }
    localObject = "/";
    ad.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = (String)localObject;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(arrayOfString[i]))
      {
        localObject = (String)localObject + "/" + arrayOfString[i];
        com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e((String)localObject);
        if ((locale.isFile()) && (!locale.af(new com.tencent.mm.vfs.e((String)localObject + "_mmbak"))))
        {
          ad.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", new Object[] { locale.getName() });
          AppMethodBeat.o(132093);
          return false;
        }
        paramString = (String)localObject;
        if (!locale.exists())
        {
          paramString = (String)localObject;
          if (!locale.mkdirs())
          {
            ad.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", new Object[] { locale.getName() });
            AppMethodBeat.o(132093);
            return false;
          }
        }
      }
      i += 1;
      localObject = paramString;
    }
    ad.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
    AppMethodBeat.o(132093);
    return true;
  }
  
  private void x(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(132081);
    ad.i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", new Object[] { this.gcV, paramString, this.gcW, this.cachePath });
    if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
    {
      int j = this.gcV.length();
      this.gcW.substring(j);
      this.gcV = paramString;
      if ((!paramBoolean) || (!this.gcV.startsWith(b.aib()))) {
        break label152;
      }
      if (i == 0) {
        break label157;
      }
    }
    label152:
    label157:
    for (paramString = this.gcY;; paramString = this.gcX)
    {
      this.gcZ = paramString;
      this.gcW = (this.gcV + this.gcZ + "/");
      afc();
      AppMethodBeat.o(132081);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean a(am paramam)
  {
    AppMethodBeat.i(132079);
    if (paramam == null)
    {
      ad.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
      AppMethodBeat.o(132079);
      return false;
    }
    int i = com.tencent.mm.sdk.platformtools.bt.l((Integer)this.gdc.get(14, null));
    int j = d.CpK;
    ad.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + i + ", cVer = " + j);
    paramam = paramam.getDataTransferList();
    if (paramam == null)
    {
      ad.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
      AppMethodBeat.o(132079);
      return false;
    }
    if ((com.tencent.mm.platformtools.ab.hVu > 0) && (com.tencent.mm.platformtools.ab.hVv > 0)) {
      ad.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
    }
    long l1;
    label383:
    boolean bool1;
    do
    {
      ad.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + paramam.size());
      ad.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
      l1 = this.gda.rb(Thread.currentThread().getId());
      try
      {
        paramam = paramam.iterator();
        while (paramam.hasNext())
        {
          localObject = (al)paramam.next();
          long l2 = System.currentTimeMillis();
          ((al)localObject).transfer(i);
          ((al)localObject).gMV = (System.currentTimeMillis() - l2);
          ad.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + ((al)localObject).gMV + ", tag = " + ((al)localObject).getTag());
        }
        if (i != j) {
          break label383;
        }
      }
      catch (Throwable paramam)
      {
        AppMethodBeat.o(132079);
        throw paramam;
      }
      finally
      {
        if (l1 > 0L) {
          this.gda.mX(l1);
        }
        AppMethodBeat.o(132079);
      }
      ad.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + i + ", cVer = " + j);
      AppMethodBeat.o(132079);
      return false;
      bool1 = false;
      Object localObject = paramam.iterator();
      while (((Iterator)localObject).hasNext())
      {
        boolean bool2 = ((al)((Iterator)localObject).next()).nb(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
      ad.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = ".concat(String.valueOf(bool1)));
    } while (bool1);
    AppMethodBeat.o(132079);
    return false;
    if ((com.tencent.mm.platformtools.ab.hVu != 0) && (com.tencent.mm.platformtools.ab.hVv != 0))
    {
      i = 0;
      for (;;)
      {
        j = com.tencent.mm.platformtools.ab.hVu;
        if (i < j) {
          try
          {
            Thread.sleep(com.tencent.mm.platformtools.ab.hVv);
            i += 1;
          }
          catch (InterruptedException paramam)
          {
            for (;;)
            {
              ad.e("MMKernel.CoreStorage", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(paramam) });
            }
          }
        }
      }
    }
    if (l1 > 0L) {
      this.gda.mX(l1);
    }
    AppMethodBeat.o(132079);
    return true;
  }
  
  public final boolean a(f paramf, HashMap<Integer, h.b> paramHashMap)
  {
    AppMethodBeat.i(132084);
    int i;
    f.a locala;
    Iterator localIterator;
    if (paramHashMap == null)
    {
      i = -1;
      ad.i("MMKernel.CoreStorage", "createtables %d %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
      locala = new f.a();
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
          h.b localb = (h.b)paramHashMap.getValue();
          paramHashMap = null;
          if (localb.getSQLs() == null)
          {
            ad.e("MMKernel.CoreStorage", "factory.getSQLs() is null! %s, %s", new Object[] { localInteger, localb });
            continue;
            i = paramHashMap.size();
            break;
          }
          Object localObject1;
          int k;
          int j;
          label293:
          Object localObject2;
          if (!this.gdg)
          {
            paramHashMap = new StringBuilder();
            localObject1 = localb.getSQLs();
            k = localObject1.length;
            j = 0;
            while (j < k)
            {
              paramHashMap.append(localObject1[j].hashCode());
              j += 1;
            }
            localObject1 = com.tencent.mm.b.g.getMessageDigest(paramHashMap.toString().getBytes());
            if (this.gdf != null)
            {
              paramHashMap = (String)this.gdf.get(localInteger);
              ad.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", new Object[] { localInteger, paramHashMap, localObject1 });
              if ((paramHashMap != null) && (((String)localObject1).equals(paramHashMap))) {
                continue;
              }
              paramHashMap = (HashMap<Integer, h.b>)localObject1;
            }
          }
          else
          {
            paramf.beginTransaction();
            localObject1 = localb.getSQLs();
            k = localObject1.length;
            j = 0;
            for (;;)
            {
              if (j >= k) {
                break label608;
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
                  Object localObject3 = com.tencent.mm.storagebase.a.FCa.matcher((CharSequence)localObject2);
                  if ((localObject3 != null) && (((Matcher)localObject3).matches())) {
                    Assert.assertTrue("CreateTable failed:[" + (String)localObject2 + "][" + localException.getMessage() + "]", false);
                  } else {
                    ad.w("MMKernel.CoreStorage", "CreateTable failed:[" + (String)localObject2 + "][" + localException.getMessage() + "]");
                  }
                }
              }
              j += 1;
            }
          }
          if (this.gde != null)
          {
            localObject3 = this.gde;
            j = localInteger.intValue();
            paramHashMap = null;
            localObject2 = null;
            localObject3 = ((bz)localObject3).rawQuery("select * from TablesVersion where tableHash = ".concat(String.valueOf(j)), new String[0]);
            if (localObject3 != null)
            {
              paramHashMap = (HashMap<Integer, h.b>)localObject2;
              if (((Cursor)localObject3).moveToFirst())
              {
                paramHashMap = new by();
                paramHashMap.convertFrom((Cursor)localObject3);
              }
              ((Cursor)localObject3).close();
            }
            if (paramHashMap != null) {
              break label484;
            }
          }
          label484:
          for (paramHashMap = null;; paramHashMap = paramHashMap.field_tableSQLMD5)
          {
            ad.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", new Object[] { localInteger, paramHashMap, localObject1 });
            if ((paramHashMap != null) && (((String)localObject1).equals(paramHashMap))) {
              break;
            }
            paramHashMap = (HashMap<Integer, h.b>)localObject1;
            break label293;
          }
          label608:
          paramf.endTransaction();
          if ((!this.gdg) && (this.gde != null) && (paramHashMap != null))
          {
            localObject1 = this.gde;
            j = localInteger.intValue();
            if (j == 0) {
              break label726;
            }
          }
          label726:
          for (boolean bool = true;; bool = false)
          {
            Assert.assertTrue(bool);
            Assert.assertNotNull(paramHashMap);
            localObject2 = new by();
            ((by)localObject2).field_tableHash = j;
            ((by)localObject2).field_tableSQLMD5 = paramHashMap;
            ((bz)localObject1).gPa.replace("TablesVersion", "tableHash", ((by)localObject2).convertTo());
            if ((this.gdf != null) && (paramHashMap != null)) {
              this.gdf.put(localInteger, paramHashMap);
            }
            break;
          }
        }
      }
      ad.i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(locala.XK()), Long.valueOf(locala.XK()), Integer.valueOf(i) });
    }
    AppMethodBeat.o(132084);
    return true;
  }
  
  final void afb()
  {
    AppMethodBeat.i(132080);
    this.gdc.set(14, Integer.valueOf(d.CpK));
    AppMethodBeat.o(132080);
  }
  
  final void afc()
  {
    AppMethodBeat.i(132082);
    c.afO().qW(this.gcW);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(this.gcW + ".nomedia");
    if (!locale.exists()) {
      try
      {
        locale.createNewFile();
        AppMethodBeat.o(132082);
        return;
      }
      catch (IOException localIOException)
      {
        ad.e("MMKernel.CoreStorage", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localIOException) });
      }
    }
    AppMethodBeat.o(132082);
  }
  
  public final boolean afd()
  {
    AppMethodBeat.i(132085);
    g.afC();
    g.afz().aeD();
    int i = com.tencent.mm.sdk.platformtools.bt.l((Integer)this.gdc.get(89, null));
    if (i != 0)
    {
      ad.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: ".concat(String.valueOf(i)));
      AppMethodBeat.o(132085);
      return false;
    }
    if ((com.tencent.mm.sdk.platformtools.bt.nullAsNil((String)this.gdc.get(8195, null)).length() <= 0) || (com.tencent.mm.sdk.platformtools.bt.l((Integer)this.gdc.get(15, null)) == 0)) {}
    for (boolean bool = true; (!bool) || (afe() == null); bool = false)
    {
      this.gdc.set(89, Integer.valueOf(1));
      this.gdc.eKy();
      ad.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(132085);
      return false;
    }
    ad.i("MMKernel.CoreStorage", "isDBCorrupted: true");
    AppMethodBeat.o(132085);
    return true;
  }
  
  public final String afe()
  {
    AppMethodBeat.i(132086);
    Object localObject1 = new com.tencent.mm.vfs.e(this.cachePath + "/ctest", "EnMicroMsg.db");
    if (((com.tencent.mm.vfs.e)localObject1).isFile())
    {
      localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
      AppMethodBeat.o(132086);
      return localObject1;
    }
    localObject1 = new com.tencent.mm.vfs.e(this.cachePath + "/corrupted", "EnMicroMsg.db");
    if (((com.tencent.mm.vfs.e)localObject1).isFile())
    {
      localObject1 = q.B(((com.tencent.mm.vfs.e)localObject1).fhU());
      AppMethodBeat.o(132086);
      return localObject1;
    }
    String[] arrayOfString = new com.tencent.mm.vfs.e(this.cachePath).a(new com.tencent.mm.vfs.m()
    {
      public final boolean qT(String paramAnonymousString)
      {
        AppMethodBeat.i(176836);
        boolean bool = paramAnonymousString.startsWith("EnMicroMsg.dberr");
        AppMethodBeat.o(176836);
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
      AppMethodBeat.o(132086);
      return localObject1;
    }
    AppMethodBeat.o(132086);
    return null;
  }
  
  public final String aff()
  {
    return this.cachePath;
  }
  
  public final com.tencent.mm.storagebase.h afg()
  {
    return this.gda;
  }
  
  public final String afh()
  {
    AppMethodBeat.i(132089);
    String str = this.cachePath + "MicroMsg.db";
    AppMethodBeat.o(132089);
    return str;
  }
  
  public final String afi()
  {
    AppMethodBeat.i(132090);
    String str = this.cachePath + "EnMicroMsg.db";
    AppMethodBeat.o(132090);
    return str;
  }
  
  public final com.tencent.mm.storage.ab afk()
  {
    AppMethodBeat.i(132094);
    g.afC();
    g.afz().aeD();
    com.tencent.mm.storage.ab localab = this.gdc;
    AppMethodBeat.o(132094);
    return localab;
  }
  
  public final com.tencent.mm.storage.bt afl()
  {
    AppMethodBeat.i(132095);
    g.afC();
    g.afz().aeD();
    com.tencent.mm.storage.bt localbt = this.gdd;
    AppMethodBeat.o(132095);
    return localbt;
  }
  
  public final void afm()
  {
    AppMethodBeat.i(132096);
    this.gdl = Boolean.valueOf(isSDCardAvailable());
    AppMethodBeat.o(132096);
  }
  
  /* Error */
  public final void afn()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 1085
    //   5: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 1012	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   11: pop
    //   12: invokestatic 1016	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
    //   15: getfield 1089	com/tencent/mm/kernel/a:gbX	[B
    //   18: astore 5
    //   20: aload 5
    //   22: monitorenter
    //   23: invokestatic 497	com/tencent/mm/compatible/util/e:XG	()Z
    //   26: istore_3
    //   27: invokestatic 253	com/tencent/mm/kernel/e:afj	()Ljava/lang/String;
    //   30: astore 4
    //   32: ldc 190
    //   34: ldc_w 1091
    //   37: iconst_4
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: invokestatic 1094	com/tencent/mm/kernel/a:getUin	()I
    //   46: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_0
    //   53: getfield 255	com/tencent/mm/kernel/e:gcV	Ljava/lang/String;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload 4
    //   61: aastore
    //   62: dup
    //   63: iconst_3
    //   64: invokestatic 1016	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
    //   67: invokevirtual 1097	com/tencent/mm/kernel/a:aeI	()Z
    //   70: invokestatic 206	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: invokestatic 211	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aload 4
    //   79: invokestatic 670	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   82: ifne +269 -> 351
    //   85: aload 4
    //   87: aload_0
    //   88: getfield 255	com/tencent/mm/kernel/e:gcV	Ljava/lang/String;
    //   91: invokevirtual 543	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   94: istore_1
    //   95: iload_1
    //   96: ifeq +137 -> 233
    //   99: ldc 190
    //   101: new 172	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 1099
    //   108: invokespecial 483	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: invokestatic 1101	com/tencent/mm/kernel/e:afo	()Z
    //   114: invokevirtual 490	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 397	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: ldc 190
    //   125: new 172	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1103
    //   132: invokespecial 483	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: invokestatic 1105	com/tencent/mm/kernel/e:afp	()Z
    //   138: invokevirtual 490	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   141: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 397	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 5
    //   149: monitorexit
    //   150: ldc_w 1085
    //   153: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: astore 4
    //   159: ldc 190
    //   161: new 172	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 1107
    //   168: invokespecial 483	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload 4
    //   173: invokevirtual 474	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 577	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -62 -> 123
    //   188: astore 4
    //   190: aload 5
    //   192: monitorexit
    //   193: ldc_w 1085
    //   196: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: ldc 190
    //   206: new 172	java/lang/StringBuilder
    //   209: dup
    //   210: ldc_w 1109
    //   213: invokespecial 483	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload 4
    //   218: invokevirtual 474	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 577	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: goto -83 -> 147
    //   233: aload_0
    //   234: aload 4
    //   236: iload_3
    //   237: invokespecial 1111	com/tencent/mm/kernel/e:x	(Ljava/lang/String;Z)V
    //   240: iload_3
    //   241: ifeq +120 -> 361
    //   244: aload_0
    //   245: getfield 255	com/tencent/mm/kernel/e:gcV	Ljava/lang/String;
    //   248: invokestatic 480	com/tencent/mm/loader/j/b:aib	()Ljava/lang/String;
    //   251: invokevirtual 721	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   254: ifeq +107 -> 361
    //   257: iconst_1
    //   258: istore_1
    //   259: invokestatic 1117	com/tencent/mm/vfs/a:gap	()Lcom/tencent/mm/vfs/a;
    //   262: invokevirtual 1121	com/tencent/mm/vfs/a:gar	()Lcom/tencent/mm/vfs/a$a;
    //   265: astore 6
    //   267: aload_0
    //   268: getfield 723	com/tencent/mm/kernel/e:gcY	Ljava/lang/String;
    //   271: aload_0
    //   272: getfield 730	com/tencent/mm/kernel/e:gcX	Ljava/lang/String;
    //   275: invokevirtual 238	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +88 -> 366
    //   281: aload 6
    //   283: iload_1
    //   284: iload_2
    //   285: invokestatic 1126	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;ZZ)Lcom/tencent/mm/vfs/a$a;
    //   288: pop
    //   289: aload 6
    //   291: aload_0
    //   292: getfield 255	com/tencent/mm/kernel/e:gcV	Ljava/lang/String;
    //   295: iload_1
    //   296: invokestatic 1129	com/tencent/mm/vfs/o:a	(Lcom/tencent/mm/vfs/a$a;Ljava/lang/String;Z)Lcom/tencent/mm/vfs/a$a;
    //   299: pop
    //   300: iload_1
    //   301: ifeq +70 -> 371
    //   304: aload_0
    //   305: getfield 723	com/tencent/mm/kernel/e:gcY	Ljava/lang/String;
    //   308: astore 4
    //   310: aload 6
    //   312: ldc_w 1131
    //   315: aload 4
    //   317: invokevirtual 1137	com/tencent/mm/vfs/a$a:lz	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/a$a;
    //   320: invokevirtual 1140	com/tencent/mm/vfs/a$a:commit	()V
    //   323: invokestatic 1001	com/tencent/mm/kernel/a/c:afO	()Lcom/tencent/mm/kernel/a/c;
    //   326: getfield 1144	com/tencent/mm/kernel/a/c:gem	Lcom/tencent/mm/kernel/a/c$e;
    //   329: invokevirtual 1149	com/tencent/mm/kernel/a/c$e:afJ	()V
    //   332: ldc 190
    //   334: ldc_w 1151
    //   337: iconst_1
    //   338: anewarray 4	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: iload_3
    //   344: invokestatic 206	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   347: aastore
    //   348: invokestatic 211	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload 5
    //   353: monitorexit
    //   354: ldc_w 1085
    //   357: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: return
    //   361: iconst_0
    //   362: istore_1
    //   363: goto -104 -> 259
    //   366: iconst_0
    //   367: istore_2
    //   368: goto -87 -> 281
    //   371: aload_0
    //   372: getfield 730	com/tencent/mm/kernel/e:gcX	Ljava/lang/String;
    //   375: astore 4
    //   377: goto -67 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	e
    //   94	269	1	bool1	boolean
    //   1	367	2	bool2	boolean
    //   26	318	3	bool3	boolean
    //   30	56	4	str1	String
    //   157	15	4	localException1	Exception
    //   188	12	4	localObject	Object
    //   202	33	4	localException2	Exception
    //   308	68	4	str2	String
    //   18	334	5	arrayOfByte	byte[]
    //   265	46	6	locala	com.tencent.mm.vfs.a.a
    // Exception table:
    //   from	to	target	type
    //   99	123	157	java/lang/Exception
    //   23	95	188	finally
    //   99	123	188	finally
    //   123	147	188	finally
    //   147	150	188	finally
    //   159	185	188	finally
    //   190	193	188	finally
    //   204	230	188	finally
    //   233	240	188	finally
    //   244	257	188	finally
    //   259	281	188	finally
    //   281	300	188	finally
    //   304	310	188	finally
    //   310	351	188	finally
    //   351	354	188	finally
    //   371	377	188	finally
    //   123	147	202	java/lang/Exception
  }
  
  public final String getAccPath()
  {
    return this.gcW;
  }
  
  public final boolean isSDCardAvailable()
  {
    AppMethodBeat.i(132098);
    boolean bool1 = this.gcV.startsWith(b.aib());
    long l1 = com.tencent.mm.sdk.platformtools.bt.eGO();
    long l2 = l1 - this.gdj;
    if (bool1)
    {
      g.afC();
      if ((g.afz().aeI()) && (l2 > 0L) && (l2 < 2000L) && (new com.tencent.mm.vfs.e(this.gcV).exists()))
      {
        AppMethodBeat.o(132098);
        return true;
      }
    }
    this.gdj = l1;
    boolean bool2 = com.tencent.mm.compatible.util.e.XG();
    g.afC();
    g.afz();
    ad.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", new Object[] { Boolean.valueOf(bool2), p.getString(a.getUin()), Long.valueOf(l2), this.gcV, b.aib(), Boolean.valueOf(g.afz().aeI()) });
    if (!bool2)
    {
      AppMethodBeat.o(132098);
      return false;
    }
    if (bool1)
    {
      AppMethodBeat.o(132098);
      return true;
    }
    g.afC();
    if (g.afz().aeI())
    {
      ad.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
      afn();
    }
    AppMethodBeat.o(132098);
    return true;
  }
  
  public final void oi(String paramString)
  {
    AppMethodBeat.i(132087);
    if (this.gdb != null) {
      this.gdb.closeDB();
    }
    if (this.gda != null) {
      this.gda.oi(paramString);
    }
    this.gcS.onDataBaseClosed(this.gda, this.gdb);
    this.gdg = false;
    AppMethodBeat.o(132087);
  }
  
  final void qQ(final String paramString)
  {
    AppMethodBeat.i(132083);
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString + "-recovery");
    if (locale.isFile())
    {
      ad.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
      i.deleteFile(paramString + ".ini");
      paramString = new com.tencent.mm.vfs.e(paramString);
      paramString.delete();
      if (!locale.af(paramString)) {
        ad.e("MMKernel.CoreStorage", "Rename database file failed!");
      }
    }
    paramString = locale.getName();
    paramString = locale.fhT().b(new com.tencent.mm.vfs.m()
    {
      public final boolean qT(String paramAnonymousString)
      {
        AppMethodBeat.i(176835);
        if ((paramAnonymousString.startsWith(paramString)) && (!paramAnonymousString.equals(paramString)))
        {
          AppMethodBeat.o(176835);
          return true;
        }
        AppMethodBeat.o(176835);
        return false;
      }
    });
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        locale = paramString[i];
        ad.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + locale.getName());
        locale.delete();
        i += 1;
      }
    }
    AppMethodBeat.o(132083);
  }
  
  public final SharedPreferences qR(String paramString)
  {
    AppMethodBeat.i(132091);
    g.afC();
    g.afz();
    int i = a.getUin();
    if (i != 0) {
      if (this.gdi.containsKey(paramString))
      {
        paramString = (SharedPreferences)this.gdi.get(paramString);
        AppMethodBeat.o(132091);
        return paramString;
      }
    }
    try
    {
      localObject1 = aj.getContext().getFilesDir().getParent() + "/shared_prefs/";
      Object localObject2 = aj.eFD() + paramString + i + ".xml";
      String str = aj.eFD() + paramString + i + ".xml.bak";
      localObject2 = new com.tencent.mm.vfs.e((String)localObject1 + (String)localObject2);
      if (((com.tencent.mm.vfs.e)localObject2).exists()) {
        ((com.tencent.mm.vfs.e)localObject2).delete();
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1 + str);
      if (((com.tencent.mm.vfs.e)localObject1).exists()) {
        ((com.tencent.mm.vfs.e)localObject1).delete();
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label227:
      break label227;
    }
    localObject1 = ai.du(String.valueOf(i / 2));
    localObject1 = aj.eFD() + paramString + ai.du(new StringBuilder().append(i).append((String)localObject1).toString());
    localObject1 = aj.getContext().getSharedPreferences((String)localObject1, 0);
    this.gdi.put(paramString, localObject1);
    AppMethodBeat.o(132091);
    return localObject1;
    AppMethodBeat.o(132091);
    return null;
  }
  
  public final class a
    implements com.tencent.e.i.e, Runnable
  {
    public Future daz;
    
    private a() {}
    
    public final void a(Future paramFuture)
    {
      this.daz = paramFuture;
    }
    
    public final void run()
    {
      AppMethodBeat.i(132070);
      e.this.afm();
      AppMethodBeat.o(132070);
    }
  }
  
  public static final class b
    extends com.tencent.mm.co.a<h.a>
    implements h.a
  {
    public final void afr()
    {
      AppMethodBeat.i(132074);
      a(new a.a() {});
      AppMethodBeat.o(132074);
    }
    
    public final void afs()
    {
      AppMethodBeat.i(132075);
      a(new a.a() {});
      AppMethodBeat.o(132075);
    }
    
    public final void aft()
    {
      AppMethodBeat.i(132076);
      a(new a.a() {});
      AppMethodBeat.o(132076);
    }
  }
  
  public static final class c
  {
    public boolean gdr = false;
    public int gds = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.e
 * JD-Core Version:    0.7.0.1
 */