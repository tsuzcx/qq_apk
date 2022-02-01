package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.cp.a;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cr;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.cu;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.storagebase.h.c;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public final class f
{
  private static HashMap<Integer, h.b> baseDBFactories;
  public String cachePath;
  public final ap mCE;
  private com.tencent.mm.kernel.api.e mCF;
  public b mCG;
  b mCH;
  public String mCI;
  public String mCJ;
  public String mCK;
  String mCL;
  public String mCM;
  public com.tencent.mm.storagebase.h mCN;
  public com.tencent.mm.storagebase.h mCO;
  aq mCP;
  co mCQ;
  cu mCR;
  ConcurrentHashMap<Integer, String> mCS;
  boolean mCT;
  cr mCU;
  ConcurrentHashMap<String, SharedPreferences> mCV;
  boolean mCW;
  private long mCX;
  private MMHandler mCY;
  public volatile Boolean mCZ;
  public a mDa;
  public long mDc;
  
  static
  {
    AppMethodBeat.i(132107);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return aq.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("TablesVersion".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return cu.SQL_CREATE;
      }
    });
    AppMethodBeat.o(132107);
  }
  
  public f(com.tencent.mm.kernel.api.e parame)
  {
    AppMethodBeat.i(132077);
    this.mCG = new b();
    this.mCH = new b();
    this.mCN = null;
    this.mCO = null;
    this.mCT = false;
    this.mCV = new ConcurrentHashMap();
    this.mCW = false;
    this.mCX = 0L;
    this.mCY = null;
    this.mCZ = null;
    this.mDa = new a((byte)0);
    this.mDc = 0L;
    this.mCE = bae();
    b.mBJ.a(this.mCE);
    this.mCI = bam();
    this.mCF = parame;
    AppMethodBeat.o(132077);
  }
  
  private void C(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(132081);
    Log.i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", new Object[] { this.mCI, paramString, this.mCJ, this.cachePath });
    if (!Util.isNullOrNil(paramString))
    {
      int j = this.mCI.length();
      this.mCJ.substring(j);
      this.mCI = paramString;
      if ((!paramBoolean) || (!this.mCI.startsWith(com.tencent.mm.loader.i.b.bmt()))) {
        break label148;
      }
      if (i == 0) {
        break label153;
      }
    }
    label148:
    label153:
    for (paramString = this.mCL;; paramString = this.mCK)
    {
      this.mCM = paramString;
      this.mCJ = (this.mCI + this.mCM + "/");
      bag();
      AppMethodBeat.o(132081);
      return;
      i = 0;
      break;
    }
  }
  
  static String E(int paramInt, String paramString)
  {
    AppMethodBeat.i(132106);
    u localu2 = new u(com.tencent.mm.loader.i.b.bmq(), "account.bin");
    u localu3 = new u(com.tencent.mm.loader.i.b.bmq() + "MicroMsg/" + paramString + "/account.bin");
    u localu1 = new u(com.tencent.mm.loader.i.b.bmq() + "MicroMsg/" + paramString + "/account.mapping");
    Object localObject1 = g(localu2);
    Object localObject2 = g(localu3);
    int i;
    if (localObject2 != null)
    {
      i = 0;
      paramString = (String)localObject2;
    }
    for (;;)
    {
      boolean bool1 = false;
      if ((localObject2 == null) || (localu3.length() != 4112L)) {
        bool1 = a(localu3, paramString) | false;
      }
      boolean bool2;
      if (localObject1 != null)
      {
        bool2 = bool1;
        if (localu2.length() == 4112L) {}
      }
      else
      {
        bool2 = bool1 | a(localu2, paramString);
      }
      if ((i == 0) || (bool2)) {
        break;
      }
      Log.e("MMKernel.CoreStorage", "Cannot write new generated data to account files.");
      AppMethodBeat.o(132106);
      return null;
      if (localObject1 != null)
      {
        i = 0;
        paramString = (String)localObject1;
      }
      else
      {
        paramString = bat();
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
      Object tmp291_289 = localObject2;
      tmp291_289[0] = 48;
      Object tmp297_291 = tmp291_289;
      tmp297_291[1] = 49;
      Object tmp303_297 = tmp297_291;
      tmp303_297[2] = 50;
      Object tmp309_303 = tmp303_297;
      tmp309_303[3] = 51;
      Object tmp315_309 = tmp309_303;
      tmp315_309[4] = 52;
      Object tmp321_315 = tmp315_309;
      tmp321_315[5] = 53;
      Object tmp327_321 = tmp321_315;
      tmp327_321[6] = 54;
      Object tmp334_327 = tmp327_321;
      tmp334_327[7] = 55;
      Object tmp341_334 = tmp334_327;
      tmp341_334[8] = 56;
      Object tmp348_341 = tmp341_334;
      tmp348_341[9] = 57;
      Object tmp355_348 = tmp348_341;
      tmp355_348[10] = 97;
      Object tmp362_355 = tmp355_348;
      tmp362_355[11] = 98;
      Object tmp369_362 = tmp362_355;
      tmp369_362[12] = 99;
      Object tmp376_369 = tmp369_362;
      tmp376_369[13] = 100;
      Object tmp383_376 = tmp376_369;
      tmp383_376[14] = 101;
      Object tmp390_383 = tmp383_376;
      tmp390_383[15] = 102;
      tmp390_383;
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
    if (!localu1.jKS()) {
      c(localu1, paramString);
    }
    AppMethodBeat.o(132106);
    return paramString;
  }
  
  private static final boolean FA(String paramString)
  {
    AppMethodBeat.i(132093);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
      AppMethodBeat.o(132093);
      return false;
    }
    Object localObject = new u(paramString);
    Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", new Object[] { paramString, Boolean.valueOf(((u)localObject).jKS()), Boolean.valueOf(((u)localObject).isDirectory()) });
    if ((((u)localObject).jKS()) && (((u)localObject).isDirectory()))
    {
      Log.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
      AppMethodBeat.o(132093);
      return true;
    }
    String[] arrayOfString = paramString.split("/");
    if ((arrayOfString == null) || (arrayOfString.length < 2))
    {
      Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
      AppMethodBeat.o(132093);
      return false;
    }
    localObject = "/";
    Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + arrayOfString.length);
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = (String)localObject;
      if (!Util.isNullOrNil(arrayOfString[i]))
      {
        localObject = (String)localObject + "/" + arrayOfString[i];
        u localu = new u((String)localObject);
        if ((localu.jKV()) && (!localu.am(new u((String)localObject + "_mmbak"))))
        {
          Log.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", new Object[] { localu.getName() });
          AppMethodBeat.o(132093);
          return false;
        }
        paramString = (String)localObject;
        if (!localu.jKS())
        {
          paramString = (String)localObject;
          if (!localu.jKY())
          {
            Log.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", new Object[] { localu.getName() });
            AppMethodBeat.o(132093);
            return false;
          }
        }
      }
      i += 1;
      localObject = paramString;
    }
    Log.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
    AppMethodBeat.o(132093);
    return true;
  }
  
  /* Error */
  private static boolean a(u paramu, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 392
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: arraylength
    //   8: sipush 4096
    //   11: if_icmpeq +19 -> 30
    //   14: ldc 184
    //   16: ldc_w 394
    //   19: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 392
    //   25: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: invokevirtual 398	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   34: invokevirtual 382	com/tencent/mm/vfs/u:jKY	()Z
    //   37: pop
    //   38: aload_0
    //   39: invokestatic 404	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 409	java/io/OutputStream:write	([B)V
    //   48: aload_2
    //   49: aload_1
    //   50: invokestatic 415	com/tencent/mm/b/g:U	([B)[B
    //   53: invokevirtual 409	java/io/OutputStream:write	([B)V
    //   56: ldc 184
    //   58: ldc_w 417
    //   61: aload_0
    //   62: invokestatic 420	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokevirtual 424	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 427	java/io/OutputStream:close	()V
    //   79: ldc_w 392
    //   82: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_1
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 427	java/io/OutputStream:close	()V
    //   96: ldc_w 392
    //   99: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: ldc 184
    //   107: aload_1
    //   108: ldc_w 429
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_0
    //   118: aastore
    //   119: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: ldc_w 392
    //   125: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_2
    //   131: aload_1
    //   132: aload_2
    //   133: invokevirtual 438	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   136: goto -40 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramu	u
    //   0	139	1	paramArrayOfByte	byte[]
    //   42	51	2	localOutputStream	OutputStream
    //   130	3	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   43	71	87	finally
    //   38	43	104	java/io/IOException
    //   75	79	104	java/io/IOException
    //   96	104	104	java/io/IOException
    //   131	136	104	java/io/IOException
    //   92	96	130	finally
  }
  
  private static ap bae()
  {
    AppMethodBeat.i(132078);
    Log.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", new Object[] { BuildInfo.info(), Integer.valueOf(d.Yxh) });
    Object localObject1 = new u(at.acHq);
    if (!((u)localObject1).jKS()) {
      ((u)localObject1).jKY();
    }
    localObject1 = new ap(at.acHq + "systemInfo.cfg");
    Object localObject2 = (String)((ap)localObject1).get(258);
    if (localObject2 != null) {
      l.aOI().B(258, localObject2);
    }
    try
    {
      localObject2 = new StatFs(com.tencent.mm.compatible.util.g.aQa().getPath());
      Log.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { com.tencent.mm.compatible.util.g.aQa().getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
      AppMethodBeat.o(132078);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MMKernel.CoreStorage", "check data size failed :%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static String bam()
  {
    AppMethodBeat.i(132092);
    Object localObject2 = at.acHq;
    u localu = new u(com.tencent.mm.loader.i.b.bmt());
    Log.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + (String)localObject2 + "] SDCARD_ROOT[" + com.tencent.mm.loader.i.b.bmt() + "] file.exists:" + localu.jKS() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.e.aPU());
    Object localObject1 = localObject2;
    if (localu.jKS())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.aPU())
      {
        localObject1 = localObject2;
        if (FA(com.tencent.mm.loader.i.b.bmz())) {
          localObject1 = com.tencent.mm.loader.i.b.bmz();
        }
        localObject2 = new u(com.tencent.mm.loader.i.b.bmL());
        if (!((u)localObject2).jKS()) {
          ((u)localObject2).jKY();
        }
        localObject2 = new u(com.tencent.mm.loader.i.b.bmD());
        if (!((u)localObject2).jKS()) {
          ((u)localObject2).jKY();
        }
        localObject2 = new u(com.tencent.mm.loader.i.b.bmE());
        if (!((u)localObject2).jKS()) {
          ((u)localObject2).jKY();
        }
        localObject2 = new u(com.tencent.mm.loader.i.b.bmF());
        if (!((u)localObject2).jKS()) {
          ((u)localObject2).jKY();
        }
        localObject2 = new u(com.tencent.mm.loader.i.b.bmD() + ".nomedia");
        if (((u)localObject2).jKS()) {}
      }
    }
    try
    {
      ((u)localObject2).jKZ();
      FA(com.tencent.mm.loader.i.b.bmC());
      localObject2 = new u((String)localObject1);
      if (!((u)localObject2).jKS()) {
        ((u)localObject2).jKY();
      }
      Log.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(132092);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MMKernel.CoreStorage", "exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
      }
    }
  }
  
  private static boolean bar()
  {
    bool3 = false;
    AppMethodBeat.i(132100);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool4 = com.tencent.mm.loader.i.b.bmt().equalsIgnoreCase(str);
    boolean bool5 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool2 = new u(Environment.getExternalStorageDirectory().getAbsolutePath()).jKR();
      localu = new u(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
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
          u localu;
          Object localObject3;
          localu.jKZ();
          localOutputStream2 = localOutputStream3;
          Object localObject1 = localObject3;
          localOutputStream3 = y.ap(localu);
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
          bool1 = localu.diJ();
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
          Log.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + localException2.getMessage());
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
            Log.e("MMKernel.CoreStorage", "exception:%s", new Object[] { Util.stackTraceToString(localIOException2) });
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
            Log.e("MMKernel.CoreStorage", "exception:%s", new Object[] { Util.stackTraceToString(localIOException3) });
            continue;
          }
          continue;
        }
        try
        {
          localOutputStream3.close();
          Log.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + com.tencent.mm.loader.i.b.bmt() + " isPrimaryExtStg: " + bool4 + " mounted: " + bool5 + " canWrite: " + bool2 + " canTrueWrite:" + bool1);
          AppMethodBeat.o(132100);
          return bool1;
          localException1 = localException1;
          Log.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + localException1.getMessage());
          bool2 = false;
        }
        catch (IOException localIOException1)
        {
          Log.e("MMKernel.CoreStorage", "exception:%s", new Object[] { Util.stackTraceToString(localIOException1) });
        }
      }
    }
  }
  
  private static boolean bas()
  {
    AppMethodBeat.i(132101);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool2 = com.tencent.mm.loader.i.b.bmt().equalsIgnoreCase(str);
    boolean bool3 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool1 = new u(Environment.getExternalStorageDirectory().getAbsolutePath()).jKQ();
      u localu = new u(com.tencent.mm.loader.i.b.bmz());
      boolean bool4 = localu.jKS();
      if (bool4) {
        Log.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + localu.isDirectory() + " isFile:" + localu.jKV());
      }
      Log.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + com.tencent.mm.loader.i.b.bmt() + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.loader.i.b.bmz() + " isPrimaryExtStg: " + bool2 + " mounted: " + bool3 + " canRead: " + bool1 + " canTrueRead:" + bool4);
      AppMethodBeat.o(132101);
      return bool4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = false;
        Log.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + localException.getMessage());
      }
    }
  }
  
  /* Error */
  private static byte[] bat()
  {
    // Byte code:
    //   0: ldc_w 633
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 635
    //   9: invokestatic 639	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_2
    //   13: sipush 4096
    //   16: newarray byte
    //   18: astore_3
    //   19: iconst_0
    //   20: istore_0
    //   21: aload_2
    //   22: aload_3
    //   23: iload_0
    //   24: sipush 4096
    //   27: iload_0
    //   28: isub
    //   29: invokevirtual 645	java/io/InputStream:read	([BII)I
    //   32: istore_1
    //   33: iload_1
    //   34: ifge +27 -> 61
    //   37: ldc 184
    //   39: ldc_w 647
    //   42: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +7 -> 53
    //   49: aload_2
    //   50: invokevirtual 648	java/io/InputStream:close	()V
    //   53: ldc_w 633
    //   56: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aconst_null
    //   60: areturn
    //   61: iload_0
    //   62: iload_1
    //   63: iadd
    //   64: istore_1
    //   65: iload_1
    //   66: istore_0
    //   67: iload_1
    //   68: sipush 4096
    //   71: if_icmplt -50 -> 21
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 648	java/io/InputStream:close	()V
    //   82: ldc_w 633
    //   85: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_3
    //   89: areturn
    //   90: astore_3
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 648	java/io/InputStream:close	()V
    //   99: ldc_w 633
    //   102: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_3
    //   106: athrow
    //   107: astore_2
    //   108: ldc 184
    //   110: aload_2
    //   111: ldc_w 650
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: ldc_w 633
    //   124: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_2
    //   130: aload_3
    //   131: aload_2
    //   132: invokevirtual 438	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   135: goto -36 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	47	0	i	int
    //   32	40	1	j	int
    //   12	84	2	localInputStream	java.io.InputStream
    //   107	4	2	localIOException	IOException
    //   129	3	2	localThrowable	java.lang.Throwable
    //   18	71	3	arrayOfByte	byte[]
    //   90	41	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	19	90	finally
    //   21	33	90	finally
    //   37	45	90	finally
    //   6	13	107	java/io/IOException
    //   49	53	107	java/io/IOException
    //   78	82	107	java/io/IOException
    //   99	107	107	java/io/IOException
    //   130	135	107	java/io/IOException
    //   95	99	129	finally
  }
  
  /* Error */
  private static boolean c(u paramu, String paramString)
  {
    // Byte code:
    //   0: ldc_w 654
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 404	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: invokevirtual 299	java/lang/String:getBytes	()[B
    //   16: invokevirtual 409	java/io/OutputStream:write	([B)V
    //   19: ldc 184
    //   21: ldc_w 656
    //   24: aload_0
    //   25: invokestatic 420	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokevirtual 424	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_2
    //   35: ifnull +7 -> 42
    //   38: aload_2
    //   39: invokevirtual 427	java/io/OutputStream:close	()V
    //   42: ldc_w 654
    //   45: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +7 -> 59
    //   55: aload_2
    //   56: invokevirtual 427	java/io/OutputStream:close	()V
    //   59: ldc_w 654
    //   62: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: ldc 184
    //   70: aload_1
    //   71: ldc_w 658
    //   74: iconst_1
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: ldc_w 654
    //   88: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iconst_0
    //   92: ireturn
    //   93: astore_2
    //   94: aload_1
    //   95: aload_2
    //   96: invokevirtual 438	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   99: goto -40 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramu	u
    //   0	102	1	paramString	String
    //   10	46	2	localOutputStream	OutputStream
    //   93	3	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   11	34	50	finally
    //   6	11	67	java/io/IOException
    //   38	42	67	java/io/IOException
    //   59	67	67	java/io/IOException
    //   94	99	67	java/io/IOException
    //   55	59	93	finally
  }
  
  /* Error */
  private static byte[] g(u paramu)
  {
    // Byte code:
    //   0: ldc_w 659
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 268	com/tencent/mm/vfs/u:length	()J
    //   10: lstore_3
    //   11: lload_3
    //   12: ldc2_w 660
    //   15: lcmp
    //   16: ifeq +42 -> 58
    //   19: lload_3
    //   20: ldc2_w 269
    //   23: lcmp
    //   24: ifeq +34 -> 58
    //   27: ldc 184
    //   29: ldc_w 663
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: lload_3
    //   43: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: aastore
    //   47: invokestatic 670	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc_w 659
    //   53: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: invokestatic 674	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   62: astore 5
    //   64: sipush 4096
    //   67: newarray byte
    //   69: astore 6
    //   71: iconst_0
    //   72: istore_1
    //   73: aload 5
    //   75: aload 6
    //   77: iload_1
    //   78: sipush 4096
    //   81: iload_1
    //   82: isub
    //   83: invokevirtual 645	java/io/InputStream:read	([BII)I
    //   86: istore_2
    //   87: iload_2
    //   88: ifge +44 -> 132
    //   91: ldc 184
    //   93: ldc_w 676
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_0
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: iload_1
    //   107: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 5
    //   116: ifnull +8 -> 124
    //   119: aload 5
    //   121: invokevirtual 648	java/io/InputStream:close	()V
    //   124: ldc_w 659
    //   127: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   146: ldc2_w 660
    //   149: lcmp
    //   150: ifle +128 -> 278
    //   153: bipush 16
    //   155: newarray byte
    //   157: astore 7
    //   159: iconst_0
    //   160: istore_1
    //   161: aload 5
    //   163: aload 7
    //   165: iload_1
    //   166: bipush 16
    //   168: iload_1
    //   169: isub
    //   170: invokevirtual 645	java/io/InputStream:read	([BII)I
    //   173: istore_2
    //   174: iload_2
    //   175: ifge +44 -> 219
    //   178: ldc 184
    //   180: ldc_w 676
    //   183: iconst_2
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_0
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: iload_1
    //   194: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 5
    //   203: ifnull +8 -> 211
    //   206: aload 5
    //   208: invokevirtual 648	java/io/InputStream:close	()V
    //   211: ldc_w 659
    //   214: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   231: aload 7
    //   233: aload 6
    //   235: invokestatic 415	com/tencent/mm/b/g:U	([B)[B
    //   238: invokestatic 681	java/util/Arrays:equals	([B[B)Z
    //   241: ifne +37 -> 278
    //   244: ldc 184
    //   246: ldc_w 683
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload_0
    //   256: aastore
    //   257: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 648	java/io/InputStream:close	()V
    //   270: ldc_w 659
    //   273: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aconst_null
    //   277: areturn
    //   278: aload 5
    //   280: ifnull +8 -> 288
    //   283: aload 5
    //   285: invokevirtual 648	java/io/InputStream:close	()V
    //   288: ldc_w 659
    //   291: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload 6
    //   296: areturn
    //   297: astore 6
    //   299: aload 5
    //   301: ifnull +8 -> 309
    //   304: aload 5
    //   306: invokevirtual 648	java/io/InputStream:close	()V
    //   309: ldc_w 659
    //   312: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload 6
    //   317: athrow
    //   318: astore 5
    //   320: ldc 184
    //   322: aload 5
    //   324: ldc_w 685
    //   327: iconst_1
    //   328: anewarray 4	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: aload_0
    //   334: aastore
    //   335: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: ldc_w 659
    //   341: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aconst_null
    //   345: areturn
    //   346: astore 5
    //   348: aload 6
    //   350: aload 5
    //   352: invokevirtual 438	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   355: goto -46 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramu	u
    //   72	153	1	i	int
    //   86	143	2	j	int
    //   10	136	3	l	long
    //   62	243	5	localInputStream	java.io.InputStream
    //   318	5	5	localIOException	IOException
    //   346	5	5	localThrowable	java.lang.Throwable
    //   69	226	6	arrayOfByte1	byte[]
    //   297	52	6	localObject	Object
    //   157	75	7	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   64	71	297	finally
    //   73	87	297	finally
    //   91	114	297	finally
    //   153	159	297	finally
    //   161	174	297	finally
    //   178	201	297	finally
    //   231	260	297	finally
    //   58	64	318	java/io/IOException
    //   119	124	318	java/io/IOException
    //   206	211	318	java/io/IOException
    //   265	270	318	java/io/IOException
    //   283	288	318	java/io/IOException
    //   309	318	318	java/io/IOException
    //   348	355	318	java/io/IOException
    //   304	309	346	finally
  }
  
  static HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(132102);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(baseDBFactories);
    AppMethodBeat.o(132102);
    return localHashMap;
  }
  
  public static String sB(int paramInt)
  {
    AppMethodBeat.i(132088);
    String str = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(paramInt)).getBytes());
    str = at.acHq + str + '/';
    AppMethodBeat.o(132088);
    return str;
  }
  
  public final void Cg(String paramString)
  {
    AppMethodBeat.i(132087);
    if (this.mCO != null) {
      this.mCO.closeDB();
    }
    if (this.mCN != null) {
      this.mCN.Cg(paramString);
    }
    this.mCF.onDataBaseClosed(this.mCN, this.mCO);
    this.mCT = false;
    AppMethodBeat.o(132087);
  }
  
  final void Fy(final String paramString)
  {
    AppMethodBeat.i(132083);
    u localu = new u(paramString + "-recovery");
    if (localu.jKV())
    {
      Log.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
      y.deleteFile(paramString + ".ini");
      paramString = new u(paramString);
      paramString.diJ();
      if (!localu.am(paramString)) {
        Log.e("MMKernel.CoreStorage", "Rename database file failed!");
      }
    }
    paramString = localu.getName();
    paramString = localu.jKP().b(new ad()
    {
      public final boolean accept(u paramAnonymousu, String paramAnonymousString)
      {
        AppMethodBeat.i(235221);
        if ((paramAnonymousString.startsWith(paramString)) && (!paramAnonymousString.equals(paramString)))
        {
          AppMethodBeat.o(235221);
          return true;
        }
        AppMethodBeat.o(235221);
        return false;
      }
    });
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localu = paramString[i];
        Log.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + localu.getName());
        localu.diJ();
        i += 1;
      }
    }
    AppMethodBeat.o(132083);
  }
  
  public final SharedPreferences Fz(String paramString)
  {
    AppMethodBeat.i(132091);
    h.baF();
    h.baC();
    int i = b.getUin();
    if (i != 0) {
      if (this.mCV.containsKey(paramString))
      {
        paramString = (SharedPreferences)this.mCV.get(paramString);
        AppMethodBeat.o(132091);
        return paramString;
      }
    }
    try
    {
      localObject1 = MMApplicationContext.getContext().getFilesDir().getParent() + "/shared_prefs/";
      Object localObject2 = MMApplicationContext.getDefaultPreferencePath() + paramString + i + ".xml";
      String str = MMApplicationContext.getDefaultPreferencePath() + paramString + i + ".xml.bak";
      localObject2 = new u((String)localObject1 + (String)localObject2);
      if (((u)localObject2).jKS()) {
        ((u)localObject2).diJ();
      }
      localObject1 = new u((String)localObject1 + str);
      if (((u)localObject1).jKS()) {
        ((u)localObject1).diJ();
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      label227:
      break label227;
    }
    localObject1 = MD5Util.getMD5String(String.valueOf(i / 2));
    localObject1 = MMApplicationContext.getDefaultPreferencePath() + paramString + MD5Util.getMD5String(new StringBuilder().append(i).append((String)localObject1).toString());
    localObject1 = MMApplicationContext.getContext().getSharedPreferences((String)localObject1, 0);
    this.mCV.put(paramString, localObject1);
    AppMethodBeat.o(132091);
    return localObject1;
    AppMethodBeat.o(132091);
    return null;
  }
  
  public final com.tencent.mm.vending.b.b a(h.a parama)
  {
    AppMethodBeat.i(235283);
    parama = this.mCG.add(parama);
    AppMethodBeat.o(235283);
    return parama;
  }
  
  public final boolean a(av paramav)
  {
    AppMethodBeat.i(132079);
    if (paramav == null)
    {
      Log.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
      AppMethodBeat.o(132079);
      return false;
    }
    int i = Util.nullAsNil((Integer)this.mCP.d(14, null));
    int j = d.Yxh;
    Log.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + i + ", cVer = " + j);
    paramav = paramav.getDataTransferList();
    if (paramav == null)
    {
      Log.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
      AppMethodBeat.o(132079);
      return false;
    }
    if ((z.pCe > 0) && (z.pCf > 0)) {
      Log.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
    }
    long l1;
    label383:
    boolean bool1;
    do
    {
      Log.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + paramav.size());
      Log.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
      l1 = this.mCN.beginTransaction(Thread.currentThread().getId());
      try
      {
        paramav = paramav.iterator();
        while (paramav.hasNext())
        {
          localObject = (au)paramav.next();
          long l2 = System.currentTimeMillis();
          ((au)localObject).vb(i);
          ((au)localObject).okO = (System.currentTimeMillis() - l2);
          Log.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + ((au)localObject).okO + ", tag = " + ((au)localObject).getTag());
        }
        if (i != j) {
          break label383;
        }
      }
      finally
      {
        try
        {
          AppMethodBeat.o(132079);
          throw paramav;
        }
        finally
        {
          if (l1 > 0L) {
            this.mCN.endTransaction(l1);
          }
          AppMethodBeat.o(132079);
        }
      }
      Log.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + i + ", cVer = " + j);
      AppMethodBeat.o(132079);
      return false;
      bool1 = false;
      Object localObject = paramav.iterator();
      while (((Iterator)localObject).hasNext())
      {
        boolean bool2 = ((au)((Iterator)localObject).next()).vc(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
      Log.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = ".concat(String.valueOf(bool1)));
    } while (bool1);
    AppMethodBeat.o(132079);
    return false;
    if ((z.pCe != 0) && (z.pCf != 0))
    {
      i = 0;
      for (;;)
      {
        j = z.pCe;
        if (i < j) {
          try
          {
            Thread.sleep(z.pCf);
            i += 1;
          }
          catch (InterruptedException paramav)
          {
            for (;;)
            {
              Log.e("MMKernel.CoreStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramav) });
            }
          }
        }
      }
    }
    if (l1 > 0L) {
      this.mCN.endTransaction(l1);
    }
    AppMethodBeat.o(132079);
    return true;
  }
  
  /* Error */
  public final boolean a(com.tencent.mm.storagebase.f paramf, HashMap<Integer, h.b> paramHashMap)
  {
    // Byte code:
    //   0: ldc_w 927
    //   3: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnonnull +964 -> 971
    //   10: iconst_m1
    //   11: istore_3
    //   12: ldc 184
    //   14: ldc_w 929
    //   17: iconst_2
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_3
    //   24: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: getstatic 932	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   33: aastore
    //   34: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: invokestatic 938	com/tencent/mm/platformtools/y:bTN	()Lcom/tencent/mm/platformtools/y;
    //   40: astore 27
    //   42: invokestatic 941	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   45: ifeq +1372 -> 1417
    //   48: getstatic 945	com/tencent/mm/platformtools/y:pBw	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   51: iconst_1
    //   52: iconst_0
    //   53: invokevirtual 951	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   56: ifeq +1361 -> 1417
    //   59: aload 27
    //   61: aload_1
    //   62: putfield 955	com/tencent/mm/platformtools/y:pBx	Lcom/tencent/mm/storagebase/f;
    //   65: iconst_2
    //   66: anewarray 98	java/lang/String
    //   69: astore 28
    //   71: aload 28
    //   73: iconst_0
    //   74: ldc_w 957
    //   77: aastore
    //   78: aload 28
    //   80: iconst_1
    //   81: ldc_w 959
    //   84: aastore
    //   85: aload 28
    //   87: invokestatic 962	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([Ljava/lang/String;)Z
    //   90: ifne +1327 -> 1417
    //   93: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   96: lstore 22
    //   98: lconst_0
    //   99: lstore 8
    //   101: lconst_0
    //   102: lstore 6
    //   104: lload 6
    //   106: lstore 10
    //   108: lload 8
    //   110: lstore 12
    //   112: lload 6
    //   114: lstore 14
    //   116: lload 8
    //   118: lstore 16
    //   120: invokestatic 965	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   123: iconst_1
    //   124: if_icmpgt +110 -> 234
    //   127: lload 6
    //   129: lstore 10
    //   131: lload 8
    //   133: lstore 12
    //   135: lload 6
    //   137: lstore 14
    //   139: lload 8
    //   141: lstore 16
    //   143: aload 27
    //   145: getfield 955	com/tencent/mm/platformtools/y:pBx	Lcom/tencent/mm/storagebase/f;
    //   148: invokestatic 968	com/tencent/mm/platformtools/y:a	(Lcom/tencent/mm/storagebase/f;)I
    //   151: istore_3
    //   152: lload 6
    //   154: lstore 10
    //   156: lload 8
    //   158: lstore 12
    //   160: lload 6
    //   162: lstore 14
    //   164: lload 8
    //   166: lstore 16
    //   168: aload 27
    //   170: getfield 955	com/tencent/mm/platformtools/y:pBx	Lcom/tencent/mm/storagebase/f;
    //   173: invokestatic 970	com/tencent/mm/platformtools/y:b	(Lcom/tencent/mm/storagebase/f;)I
    //   176: istore 4
    //   178: lload 6
    //   180: lstore 10
    //   182: lload 8
    //   184: lstore 12
    //   186: lload 6
    //   188: lstore 14
    //   190: lload 8
    //   192: lstore 16
    //   194: ldc_w 972
    //   197: ldc_w 974
    //   200: iconst_3
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   209: lload 22
    //   211: lsub
    //   212: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: iload_3
    //   219: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: iload 4
    //   227: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: lload 6
    //   236: lstore 10
    //   238: lload 8
    //   240: lstore 12
    //   242: lload 6
    //   244: lstore 14
    //   246: lload 8
    //   248: lstore 16
    //   250: new 89	java/util/HashMap
    //   253: dup
    //   254: invokespecial 92	java/util/HashMap:<init>	()V
    //   257: astore 29
    //   259: lload 6
    //   261: lstore 10
    //   263: lload 8
    //   265: lstore 12
    //   267: invokestatic 978	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   270: getfield 130	com/tencent/mm/kernel/f:mCN	Lcom/tencent/mm/storagebase/h;
    //   273: invokevirtual 982	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   276: getstatic 988	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   279: ldc_w 990
    //   282: aconst_null
    //   283: aconst_null
    //   284: invokevirtual 996	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   287: astore 30
    //   289: aload 30
    //   291: invokeinterface 1001 1 0
    //   296: ifne +683 -> 979
    //   299: aload 30
    //   301: iconst_0
    //   302: invokeinterface 1004 2 0
    //   307: astore 31
    //   309: aload 30
    //   311: iconst_1
    //   312: invokeinterface 1004 2 0
    //   317: astore 32
    //   319: aload 30
    //   321: iconst_2
    //   322: invokeinterface 1004 2 0
    //   327: astore 33
    //   329: aload 30
    //   331: iconst_3
    //   332: invokeinterface 1004 2 0
    //   337: astore 34
    //   339: aload 31
    //   341: ldc_w 1006
    //   344: invokevirtual 574	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   347: ifeq +36 -> 383
    //   350: aload 28
    //   352: aload 32
    //   354: aload 33
    //   356: invokestatic 1009	com/tencent/mm/platformtools/y:a	([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   359: ifeq +24 -> 383
    //   362: aload 29
    //   364: aload 32
    //   366: new 1011	com/tencent/mm/platformtools/y$a
    //   369: dup
    //   370: aload 27
    //   372: aload 33
    //   374: aload 34
    //   376: invokespecial 1014	com/tencent/mm/platformtools/y$a:<init>	(Lcom/tencent/mm/platformtools/y;Ljava/lang/String;Ljava/lang/String;)V
    //   379: invokevirtual 113	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: invokestatic 965	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   386: iconst_1
    //   387: if_icmpgt +26 -> 413
    //   390: ldc_w 972
    //   393: ldc_w 1016
    //   396: iconst_2
    //   397: anewarray 4	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: aload 32
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: aload 33
    //   409: aastore
    //   410: invokestatic 1018	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: aload 30
    //   415: invokeinterface 1021 1 0
    //   420: pop
    //   421: goto -132 -> 289
    //   424: astore 31
    //   426: aload 30
    //   428: ifnull +10 -> 438
    //   431: aload 30
    //   433: invokeinterface 1022 1 0
    //   438: lload 6
    //   440: lstore 10
    //   442: lload 8
    //   444: lstore 12
    //   446: ldc_w 927
    //   449: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: lload 6
    //   454: lstore 10
    //   456: lload 8
    //   458: lstore 12
    //   460: aload 31
    //   462: athrow
    //   463: astore 30
    //   465: lload 6
    //   467: lstore 10
    //   469: lload 8
    //   471: lstore 12
    //   473: lload 6
    //   475: lstore 14
    //   477: lload 8
    //   479: lstore 16
    //   481: ldc_w 972
    //   484: ldc_w 1024
    //   487: iconst_1
    //   488: anewarray 4	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: aload 30
    //   495: aastore
    //   496: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   499: lload 6
    //   501: lstore 10
    //   503: lload 8
    //   505: lstore 12
    //   507: lload 6
    //   509: lstore 14
    //   511: lload 8
    //   513: lstore 16
    //   515: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   518: ldc2_w 1031
    //   521: lconst_1
    //   522: lconst_1
    //   523: iconst_1
    //   524: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   527: lload 6
    //   529: lstore 10
    //   531: lload 8
    //   533: lstore 12
    //   535: lload 6
    //   537: lstore 14
    //   539: lload 8
    //   541: lstore 16
    //   543: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   546: sipush 20708
    //   549: iconst_3
    //   550: anewarray 4	java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: ldc_w 1038
    //   558: aastore
    //   559: dup
    //   560: iconst_1
    //   561: iconst_1
    //   562: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: aastore
    //   566: dup
    //   567: iconst_2
    //   568: aload 30
    //   570: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   573: aastore
    //   574: invokevirtual 1041	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
    //   577: lload 6
    //   579: lstore 10
    //   581: lload 8
    //   583: lstore 12
    //   585: lload 6
    //   587: lstore 14
    //   589: lload 8
    //   591: lstore 16
    //   593: aload 29
    //   595: invokevirtual 1045	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   598: invokeinterface 1048 1 0
    //   603: astore 30
    //   605: lload 6
    //   607: lstore 10
    //   609: lload 8
    //   611: lstore 12
    //   613: lload 6
    //   615: lstore 14
    //   617: lload 8
    //   619: lstore 16
    //   621: aload 30
    //   623: invokeinterface 880 1 0
    //   628: ifeq +543 -> 1171
    //   631: lload 6
    //   633: lstore 10
    //   635: lload 8
    //   637: lstore 12
    //   639: lload 6
    //   641: lstore 14
    //   643: lload 8
    //   645: lstore 16
    //   647: aload 30
    //   649: invokeinterface 884 1 0
    //   654: checkcast 1050	java/util/Map$Entry
    //   657: astore 31
    //   659: lload 6
    //   661: lstore 10
    //   663: lload 8
    //   665: lstore 12
    //   667: lload 6
    //   669: lstore 14
    //   671: lload 8
    //   673: lstore 16
    //   675: aload 31
    //   677: invokeinterface 1053 1 0
    //   682: checkcast 1011	com/tencent/mm/platformtools/y$a
    //   685: getfield 1056	com/tencent/mm/platformtools/y$a:table	Ljava/lang/String;
    //   688: astore 32
    //   690: lload 6
    //   692: lstore 10
    //   694: lload 8
    //   696: lstore 12
    //   698: lload 6
    //   700: lstore 14
    //   702: lload 8
    //   704: lstore 16
    //   706: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   709: lstore 24
    //   711: lload 6
    //   713: lstore 20
    //   715: lload 8
    //   717: lstore 18
    //   719: lload 6
    //   721: lstore 10
    //   723: lload 8
    //   725: lstore 12
    //   727: lload 6
    //   729: lstore 14
    //   731: lload 8
    //   733: lstore 16
    //   735: aload 27
    //   737: getfield 955	com/tencent/mm/platformtools/y:pBx	Lcom/tencent/mm/storagebase/f;
    //   740: aload 31
    //   742: invokeinterface 1064 1 0
    //   747: checkcast 98	java/lang/String
    //   750: aload 32
    //   752: invokestatic 1067	com/tencent/mm/platformtools/y:a	(Lcom/tencent/mm/storagebase/f;Ljava/lang/String;Ljava/lang/String;)Z
    //   755: ifeq +205 -> 960
    //   758: lload 6
    //   760: lstore 10
    //   762: lload 8
    //   764: lstore 12
    //   766: lload 6
    //   768: lstore 14
    //   770: lload 8
    //   772: lstore 16
    //   774: lload 8
    //   776: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   779: lload 24
    //   781: lsub
    //   782: ladd
    //   783: lstore 8
    //   785: lload 6
    //   787: lstore 10
    //   789: lload 8
    //   791: lstore 12
    //   793: lload 6
    //   795: lstore 14
    //   797: lload 8
    //   799: lstore 16
    //   801: aload 32
    //   803: aload 28
    //   805: iconst_2
    //   806: anewarray 98	java/lang/String
    //   809: dup
    //   810: iconst_0
    //   811: ldc_w 1069
    //   814: aastore
    //   815: dup
    //   816: iconst_1
    //   817: ldc_w 1071
    //   820: aastore
    //   821: invokestatic 1074	com/tencent/mm/platformtools/y:d	(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   824: astore 33
    //   826: lload 6
    //   828: lstore 10
    //   830: lload 8
    //   832: lstore 12
    //   834: lload 6
    //   836: lstore 14
    //   838: lload 8
    //   840: lstore 16
    //   842: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   845: lstore 24
    //   847: lload 6
    //   849: lstore 20
    //   851: lload 8
    //   853: lstore 18
    //   855: lload 6
    //   857: lstore 10
    //   859: lload 8
    //   861: lstore 12
    //   863: lload 6
    //   865: lstore 14
    //   867: lload 8
    //   869: lstore 16
    //   871: aload 27
    //   873: getfield 955	com/tencent/mm/platformtools/y:pBx	Lcom/tencent/mm/storagebase/f;
    //   876: aload 33
    //   878: aload 32
    //   880: aload 31
    //   882: invokeinterface 1053 1 0
    //   887: checkcast 1011	com/tencent/mm/platformtools/y$a
    //   890: getfield 1077	com/tencent/mm/platformtools/y$a:sql	Ljava/lang/String;
    //   893: invokestatic 1080	com/tencent/mm/platformtools/y:a	(Lcom/tencent/mm/storagebase/f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   896: ifeq +64 -> 960
    //   899: lload 6
    //   901: lstore 10
    //   903: lload 8
    //   905: lstore 12
    //   907: lload 6
    //   909: lstore 14
    //   911: lload 8
    //   913: lstore 16
    //   915: lload 6
    //   917: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   920: lload 24
    //   922: lsub
    //   923: ladd
    //   924: lstore 20
    //   926: lload 20
    //   928: lstore 10
    //   930: lload 8
    //   932: lstore 12
    //   934: lload 20
    //   936: lstore 14
    //   938: lload 8
    //   940: lstore 16
    //   942: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   945: ldc2_w 1031
    //   948: ldc2_w 1081
    //   951: lconst_1
    //   952: iconst_1
    //   953: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   956: lload 8
    //   958: lstore 18
    //   960: lload 20
    //   962: lstore 6
    //   964: lload 18
    //   966: lstore 8
    //   968: goto -363 -> 605
    //   971: aload_2
    //   972: invokevirtual 1083	java/util/HashMap:size	()I
    //   975: istore_3
    //   976: goto -964 -> 12
    //   979: aload 30
    //   981: ifnull -404 -> 577
    //   984: lload 6
    //   986: lstore 10
    //   988: lload 8
    //   990: lstore 12
    //   992: aload 30
    //   994: invokeinterface 1022 1 0
    //   999: goto -422 -> 577
    //   1002: astore_1
    //   1003: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   1006: lload 22
    //   1008: lsub
    //   1009: lstore 6
    //   1011: ldc_w 1085
    //   1014: iconst_3
    //   1015: anewarray 4	java/lang/Object
    //   1018: dup
    //   1019: iconst_0
    //   1020: lload 6
    //   1022: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1025: aastore
    //   1026: dup
    //   1027: iconst_1
    //   1028: lload 12
    //   1030: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1033: aastore
    //   1034: dup
    //   1035: iconst_2
    //   1036: lload 10
    //   1038: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1041: aastore
    //   1042: invokestatic 1089	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1045: astore_2
    //   1046: ldc_w 972
    //   1049: aload_2
    //   1050: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1053: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1056: ldc2_w 1031
    //   1059: ldc2_w 1090
    //   1062: lload 6
    //   1064: iconst_0
    //   1065: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1068: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1071: ldc2_w 1031
    //   1074: ldc2_w 1092
    //   1077: lload 12
    //   1079: iconst_0
    //   1080: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1083: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1086: ldc2_w 1031
    //   1089: ldc2_w 1094
    //   1092: lload 10
    //   1094: iconst_0
    //   1095: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1098: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1101: ldc2_w 1031
    //   1104: ldc2_w 1096
    //   1107: lconst_1
    //   1108: iconst_0
    //   1109: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1112: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1115: sipush 20708
    //   1118: iconst_3
    //   1119: anewarray 4	java/lang/Object
    //   1122: dup
    //   1123: iconst_0
    //   1124: ldc_w 1038
    //   1127: aastore
    //   1128: dup
    //   1129: iconst_1
    //   1130: bipush 10
    //   1132: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1135: aastore
    //   1136: dup
    //   1137: iconst_2
    //   1138: aload_2
    //   1139: aastore
    //   1140: invokevirtual 1041	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
    //   1143: ldc_w 927
    //   1146: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1149: aload_1
    //   1150: athrow
    //   1151: astore 30
    //   1153: lload 6
    //   1155: lstore 10
    //   1157: lload 8
    //   1159: lstore 12
    //   1161: aload 31
    //   1163: aload 30
    //   1165: invokevirtual 438	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   1168: goto -730 -> 438
    //   1171: lload 6
    //   1173: lstore 10
    //   1175: lload 8
    //   1177: lstore 12
    //   1179: lload 6
    //   1181: lstore 14
    //   1183: lload 8
    //   1185: lstore 16
    //   1187: aload 29
    //   1189: invokevirtual 1083	java/util/HashMap:size	()I
    //   1192: ifle +82 -> 1274
    //   1195: lload 6
    //   1197: lstore 10
    //   1199: lload 8
    //   1201: lstore 12
    //   1203: lload 6
    //   1205: lstore 14
    //   1207: lload 8
    //   1209: lstore 16
    //   1211: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1214: ldc2_w 1031
    //   1217: ldc2_w 1098
    //   1220: lconst_1
    //   1221: iconst_1
    //   1222: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1225: lload 6
    //   1227: lstore 10
    //   1229: lload 8
    //   1231: lstore 12
    //   1233: lload 6
    //   1235: lstore 14
    //   1237: lload 8
    //   1239: lstore 16
    //   1241: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1244: sipush 20708
    //   1247: iconst_3
    //   1248: anewarray 4	java/lang/Object
    //   1251: dup
    //   1252: iconst_0
    //   1253: ldc_w 1038
    //   1256: aastore
    //   1257: dup
    //   1258: iconst_1
    //   1259: iconst_3
    //   1260: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1263: aastore
    //   1264: dup
    //   1265: iconst_2
    //   1266: iconst_1
    //   1267: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1270: aastore
    //   1271: invokevirtual 1041	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
    //   1274: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   1277: lload 22
    //   1279: lsub
    //   1280: lstore 10
    //   1282: ldc_w 1085
    //   1285: iconst_3
    //   1286: anewarray 4	java/lang/Object
    //   1289: dup
    //   1290: iconst_0
    //   1291: lload 10
    //   1293: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1296: aastore
    //   1297: dup
    //   1298: iconst_1
    //   1299: lload 8
    //   1301: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1304: aastore
    //   1305: dup
    //   1306: iconst_2
    //   1307: lload 6
    //   1309: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1312: aastore
    //   1313: invokestatic 1089	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1316: astore 27
    //   1318: ldc_w 972
    //   1321: aload 27
    //   1323: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1326: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1329: ldc2_w 1031
    //   1332: ldc2_w 1090
    //   1335: lload 10
    //   1337: iconst_0
    //   1338: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1341: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1344: ldc2_w 1031
    //   1347: ldc2_w 1092
    //   1350: lload 8
    //   1352: iconst_0
    //   1353: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1356: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1359: ldc2_w 1031
    //   1362: ldc2_w 1094
    //   1365: lload 6
    //   1367: iconst_0
    //   1368: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1371: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1374: ldc2_w 1031
    //   1377: ldc2_w 1096
    //   1380: lconst_1
    //   1381: iconst_0
    //   1382: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1385: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1388: sipush 20708
    //   1391: iconst_3
    //   1392: anewarray 4	java/lang/Object
    //   1395: dup
    //   1396: iconst_0
    //   1397: ldc_w 1038
    //   1400: aastore
    //   1401: dup
    //   1402: iconst_1
    //   1403: bipush 10
    //   1405: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1408: aastore
    //   1409: dup
    //   1410: iconst_2
    //   1411: aload 27
    //   1413: aastore
    //   1414: invokevirtual 1041	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
    //   1417: new 1101	com/tencent/mm/compatible/util/f$a
    //   1420: dup
    //   1421: invokespecial 1102	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   1424: astore 29
    //   1426: aload_2
    //   1427: ifnull +946 -> 2373
    //   1430: aload_2
    //   1431: invokevirtual 1083	java/util/HashMap:size	()I
    //   1434: ifle +939 -> 2373
    //   1437: aload_2
    //   1438: invokevirtual 1045	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   1441: invokeinterface 1048 1 0
    //   1446: astore 30
    //   1448: iconst_0
    //   1449: istore_3
    //   1450: aload 30
    //   1452: invokeinterface 880 1 0
    //   1457: ifeq +875 -> 2332
    //   1460: aload 30
    //   1462: invokeinterface 884 1 0
    //   1467: checkcast 1050	java/util/Map$Entry
    //   1470: astore_2
    //   1471: aload_2
    //   1472: invokeinterface 1064 1 0
    //   1477: checkcast 104	java/lang/Integer
    //   1480: astore 31
    //   1482: aload_2
    //   1483: invokeinterface 1053 1 0
    //   1488: checkcast 1104	com/tencent/mm/storagebase/h$b
    //   1491: astore 32
    //   1493: aload 32
    //   1495: invokeinterface 1108 1 0
    //   1500: ifnonnull +240 -> 1740
    //   1503: ldc 184
    //   1505: ldc_w 1110
    //   1508: iconst_2
    //   1509: anewarray 4	java/lang/Object
    //   1512: dup
    //   1513: iconst_0
    //   1514: aload 31
    //   1516: aastore
    //   1517: dup
    //   1518: iconst_1
    //   1519: aload 32
    //   1521: aastore
    //   1522: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1525: goto -75 -> 1450
    //   1528: astore 27
    //   1530: lload 14
    //   1532: lstore 10
    //   1534: lload 16
    //   1536: lstore 12
    //   1538: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1541: ldc2_w 1031
    //   1544: ldc2_w 1111
    //   1547: lconst_1
    //   1548: iconst_1
    //   1549: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1552: lload 14
    //   1554: lstore 10
    //   1556: lload 16
    //   1558: lstore 12
    //   1560: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1563: sipush 20708
    //   1566: iconst_3
    //   1567: anewarray 4	java/lang/Object
    //   1570: dup
    //   1571: iconst_0
    //   1572: ldc_w 1038
    //   1575: aastore
    //   1576: dup
    //   1577: iconst_1
    //   1578: iconst_2
    //   1579: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1582: aastore
    //   1583: dup
    //   1584: iconst_2
    //   1585: aload 27
    //   1587: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1590: aastore
    //   1591: invokevirtual 1041	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
    //   1594: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   1597: lload 22
    //   1599: lsub
    //   1600: lstore 6
    //   1602: ldc_w 1085
    //   1605: iconst_3
    //   1606: anewarray 4	java/lang/Object
    //   1609: dup
    //   1610: iconst_0
    //   1611: lload 6
    //   1613: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1616: aastore
    //   1617: dup
    //   1618: iconst_1
    //   1619: lload 16
    //   1621: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1624: aastore
    //   1625: dup
    //   1626: iconst_2
    //   1627: lload 14
    //   1629: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1632: aastore
    //   1633: invokestatic 1089	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1636: astore 27
    //   1638: ldc_w 972
    //   1641: aload 27
    //   1643: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1646: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1649: ldc2_w 1031
    //   1652: ldc2_w 1090
    //   1655: lload 6
    //   1657: iconst_0
    //   1658: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1661: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1664: ldc2_w 1031
    //   1667: ldc2_w 1092
    //   1670: lload 16
    //   1672: iconst_0
    //   1673: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1676: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1679: ldc2_w 1031
    //   1682: ldc2_w 1094
    //   1685: lload 14
    //   1687: iconst_0
    //   1688: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1691: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1694: ldc2_w 1031
    //   1697: ldc2_w 1096
    //   1700: lconst_1
    //   1701: iconst_0
    //   1702: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1705: getstatic 1030	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   1708: sipush 20708
    //   1711: iconst_3
    //   1712: anewarray 4	java/lang/Object
    //   1715: dup
    //   1716: iconst_0
    //   1717: ldc_w 1038
    //   1720: aastore
    //   1721: dup
    //   1722: iconst_1
    //   1723: bipush 10
    //   1725: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1728: aastore
    //   1729: dup
    //   1730: iconst_2
    //   1731: aload 27
    //   1733: aastore
    //   1734: invokevirtual 1041	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
    //   1737: goto -320 -> 1417
    //   1740: aload_0
    //   1741: getfield 134	com/tencent/mm/kernel/f:mCT	Z
    //   1744: ifne +637 -> 2381
    //   1747: new 222	java/lang/StringBuilder
    //   1750: dup
    //   1751: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   1754: astore_2
    //   1755: aload 32
    //   1757: invokeinterface 1108 1 0
    //   1762: astore 27
    //   1764: aload 27
    //   1766: arraylength
    //   1767: istore 5
    //   1769: iconst_0
    //   1770: istore 4
    //   1772: iload 4
    //   1774: iload 5
    //   1776: if_icmpge +25 -> 1801
    //   1779: aload_2
    //   1780: aload 27
    //   1782: iload 4
    //   1784: aaload
    //   1785: invokevirtual 102	java/lang/String:hashCode	()I
    //   1788: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1791: pop
    //   1792: iload 4
    //   1794: iconst_1
    //   1795: iadd
    //   1796: istore 4
    //   1798: goto -26 -> 1772
    //   1801: aload_2
    //   1802: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1805: invokevirtual 299	java/lang/String:getBytes	()[B
    //   1808: invokestatic 704	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   1811: astore 28
    //   1813: aload_0
    //   1814: getfield 1114	com/tencent/mm/kernel/f:mCS	Ljava/util/concurrent/ConcurrentHashMap;
    //   1817: ifnull +119 -> 1936
    //   1820: aload_0
    //   1821: getfield 1114	com/tencent/mm/kernel/f:mCS	Ljava/util/concurrent/ConcurrentHashMap;
    //   1824: aload 31
    //   1826: invokevirtual 762	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1829: checkcast 98	java/lang/String
    //   1832: astore 27
    //   1834: ldc 184
    //   1836: ldc_w 1116
    //   1839: iconst_3
    //   1840: anewarray 4	java/lang/Object
    //   1843: dup
    //   1844: iconst_0
    //   1845: aload 31
    //   1847: aastore
    //   1848: dup
    //   1849: iconst_1
    //   1850: aload 27
    //   1852: aastore
    //   1853: dup
    //   1854: iconst_2
    //   1855: aload 28
    //   1857: aastore
    //   1858: invokestatic 1018	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1861: aload 28
    //   1863: astore_2
    //   1864: aload 27
    //   1866: ifnull +16 -> 1882
    //   1869: aload 28
    //   1871: aload 27
    //   1873: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1876: ifne -426 -> 1450
    //   1879: aload 28
    //   1881: astore_2
    //   1882: aload_1
    //   1883: invokevirtual 1120	com/tencent/mm/storagebase/f:beginTransaction	()V
    //   1886: aload 32
    //   1888: invokeinterface 1108 1 0
    //   1893: astore 27
    //   1895: aload 27
    //   1897: arraylength
    //   1898: istore 5
    //   1900: iconst_0
    //   1901: istore 4
    //   1903: iload 4
    //   1905: iload 5
    //   1907: if_icmpge +301 -> 2208
    //   1910: aload 27
    //   1912: iload 4
    //   1914: aaload
    //   1915: astore 28
    //   1917: aload_1
    //   1918: aload 28
    //   1920: invokevirtual 1123	com/tencent/mm/storagebase/f:execSQL	(Ljava/lang/String;)V
    //   1923: iload_3
    //   1924: iconst_1
    //   1925: iadd
    //   1926: istore_3
    //   1927: iload 4
    //   1929: iconst_1
    //   1930: iadd
    //   1931: istore 4
    //   1933: goto -30 -> 1903
    //   1936: aload 28
    //   1938: astore_2
    //   1939: aload_0
    //   1940: getfield 653	com/tencent/mm/kernel/f:mCR	Lcom/tencent/mm/storage/cu;
    //   1943: ifnull -61 -> 1882
    //   1946: aload_0
    //   1947: getfield 653	com/tencent/mm/kernel/f:mCR	Lcom/tencent/mm/storage/cu;
    //   1950: astore 33
    //   1952: aload 31
    //   1954: invokevirtual 1126	java/lang/Integer:intValue	()I
    //   1957: istore 4
    //   1959: aconst_null
    //   1960: astore_2
    //   1961: aconst_null
    //   1962: astore 27
    //   1964: aload 33
    //   1966: ldc_w 1128
    //   1969: iload 4
    //   1971: invokestatic 700	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1974: invokevirtual 424	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1977: iconst_0
    //   1978: anewarray 98	java/lang/String
    //   1981: invokevirtual 1134	com/tencent/mm/storage/cu:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   1984: astore 33
    //   1986: aload 33
    //   1988: ifnull +37 -> 2025
    //   1991: aload 27
    //   1993: astore_2
    //   1994: aload 33
    //   1996: invokeinterface 1137 1 0
    //   2001: ifeq +17 -> 2018
    //   2004: new 1139	com/tencent/mm/storage/ct
    //   2007: dup
    //   2008: invokespecial 1140	com/tencent/mm/storage/ct:<init>	()V
    //   2011: astore_2
    //   2012: aload_2
    //   2013: aload 33
    //   2015: invokevirtual 1144	com/tencent/mm/storage/ct:convertFrom	(Landroid/database/Cursor;)V
    //   2018: aload 33
    //   2020: invokeinterface 1022 1 0
    //   2025: aload_2
    //   2026: ifnonnull +57 -> 2083
    //   2029: aconst_null
    //   2030: astore 27
    //   2032: ldc 184
    //   2034: ldc_w 1146
    //   2037: iconst_3
    //   2038: anewarray 4	java/lang/Object
    //   2041: dup
    //   2042: iconst_0
    //   2043: aload 31
    //   2045: aastore
    //   2046: dup
    //   2047: iconst_1
    //   2048: aload 27
    //   2050: aastore
    //   2051: dup
    //   2052: iconst_2
    //   2053: aload 28
    //   2055: aastore
    //   2056: invokestatic 1018	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2059: aload 28
    //   2061: astore_2
    //   2062: aload 27
    //   2064: ifnull -182 -> 1882
    //   2067: aload 28
    //   2069: aload 27
    //   2071: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2074: ifne -624 -> 1450
    //   2077: aload 28
    //   2079: astore_2
    //   2080: goto -198 -> 1882
    //   2083: aload_2
    //   2084: getfield 1149	com/tencent/mm/storage/ct:field_tableSQLMD5	Ljava/lang/String;
    //   2087: astore 27
    //   2089: goto -57 -> 2032
    //   2092: astore 32
    //   2094: getstatic 1155	com/tencent/mm/storagebase/a:admY	Ljava/util/regex/Pattern;
    //   2097: aload 28
    //   2099: invokevirtual 1161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   2102: astore 33
    //   2104: aload 33
    //   2106: ifnull +56 -> 2162
    //   2109: aload 33
    //   2111: invokevirtual 1166	java/util/regex/Matcher:matches	()Z
    //   2114: ifeq +48 -> 2162
    //   2117: new 222	java/lang/StringBuilder
    //   2120: dup
    //   2121: ldc_w 1168
    //   2124: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2127: aload 28
    //   2129: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: ldc_w 1170
    //   2135: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: aload 32
    //   2140: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2143: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: ldc_w 1172
    //   2149: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2155: iconst_0
    //   2156: invokestatic 1177	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   2159: goto -232 -> 1927
    //   2162: ldc 184
    //   2164: new 222	java/lang/StringBuilder
    //   2167: dup
    //   2168: ldc_w 1168
    //   2171: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2174: aload 28
    //   2176: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2179: ldc_w 1170
    //   2182: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: aload 32
    //   2187: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2190: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: ldc_w 1172
    //   2196: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2202: invokestatic 613	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2205: goto -278 -> 1927
    //   2208: aload_1
    //   2209: invokevirtual 1179	com/tencent/mm/storagebase/f:endTransaction	()V
    //   2212: aload_0
    //   2213: getfield 134	com/tencent/mm/kernel/f:mCT	Z
    //   2216: ifne +107 -> 2323
    //   2219: aload_0
    //   2220: getfield 653	com/tencent/mm/kernel/f:mCR	Lcom/tencent/mm/storage/cu;
    //   2223: ifnull +100 -> 2323
    //   2226: aload_2
    //   2227: ifnull +96 -> 2323
    //   2230: aload_0
    //   2231: getfield 653	com/tencent/mm/kernel/f:mCR	Lcom/tencent/mm/storage/cu;
    //   2234: astore 27
    //   2236: aload 31
    //   2238: invokevirtual 1126	java/lang/Integer:intValue	()I
    //   2241: istore 4
    //   2243: iload 4
    //   2245: ifeq +81 -> 2326
    //   2248: iconst_1
    //   2249: istore 26
    //   2251: iload 26
    //   2253: invokestatic 1182	junit/framework/Assert:assertTrue	(Z)V
    //   2256: aload_2
    //   2257: invokestatic 1186	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   2260: new 1139	com/tencent/mm/storage/ct
    //   2263: dup
    //   2264: invokespecial 1140	com/tencent/mm/storage/ct:<init>	()V
    //   2267: astore 28
    //   2269: aload 28
    //   2271: iload 4
    //   2273: putfield 1189	com/tencent/mm/storage/ct:field_tableHash	I
    //   2276: aload 28
    //   2278: aload_2
    //   2279: putfield 1149	com/tencent/mm/storage/ct:field_tableSQLMD5	Ljava/lang/String;
    //   2282: aload 27
    //   2284: getfield 1192	com/tencent/mm/storage/cu:omV	Lcom/tencent/mm/storagebase/h;
    //   2287: ldc 115
    //   2289: ldc_w 1194
    //   2292: aload 28
    //   2294: invokevirtual 1198	com/tencent/mm/storage/ct:convertTo	()Landroid/content/ContentValues;
    //   2297: invokevirtual 1202	com/tencent/mm/storagebase/h:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   2300: pop2
    //   2301: aload_0
    //   2302: getfield 1114	com/tencent/mm/kernel/f:mCS	Ljava/util/concurrent/ConcurrentHashMap;
    //   2305: ifnull +18 -> 2323
    //   2308: aload_2
    //   2309: ifnull +14 -> 2323
    //   2312: aload_0
    //   2313: getfield 1114	com/tencent/mm/kernel/f:mCS	Ljava/util/concurrent/ConcurrentHashMap;
    //   2316: aload 31
    //   2318: aload_2
    //   2319: invokevirtual 797	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2322: pop
    //   2323: goto -873 -> 1450
    //   2326: iconst_0
    //   2327: istore 26
    //   2329: goto -78 -> 2251
    //   2332: ldc 184
    //   2334: ldc_w 1204
    //   2337: iconst_3
    //   2338: anewarray 4	java/lang/Object
    //   2341: dup
    //   2342: iconst_0
    //   2343: aload 29
    //   2345: invokevirtual 1207	com/tencent/mm/compatible/util/f$a:aPY	()J
    //   2348: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2351: aastore
    //   2352: dup
    //   2353: iconst_1
    //   2354: aload 29
    //   2356: invokevirtual 1207	com/tencent/mm/compatible/util/f$a:aPY	()J
    //   2359: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2362: aastore
    //   2363: dup
    //   2364: iconst_2
    //   2365: iload_3
    //   2366: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2369: aastore
    //   2370: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2373: ldc_w 927
    //   2376: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2379: iconst_1
    //   2380: ireturn
    //   2381: aconst_null
    //   2382: astore_2
    //   2383: goto -501 -> 1882
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2386	0	this	f
    //   0	2386	1	paramf	com.tencent.mm.storagebase.f
    //   0	2386	2	paramHashMap	HashMap<Integer, h.b>
    //   11	2355	3	i	int
    //   176	2096	4	j	int
    //   1767	141	5	k	int
    //   102	1554	6	l1	long
    //   99	1252	8	l2	long
    //   106	1449	10	l3	long
    //   110	1449	12	l4	long
    //   114	1572	14	l5	long
    //   118	1553	16	l6	long
    //   717	248	18	l7	long
    //   713	248	20	l8	long
    //   96	1502	22	l9	long
    //   709	212	24	l10	long
    //   2249	79	26	bool	boolean
    //   40	1372	27	localObject1	Object
    //   1528	58	27	localException1	Exception
    //   1636	647	27	localObject2	Object
    //   69	2224	28	localObject3	Object
    //   257	2098	29	localObject4	Object
    //   287	145	30	localCursor	com.tencent.wcdb.Cursor
    //   463	106	30	localException2	Exception
    //   603	390	30	localIterator1	Iterator
    //   1151	13	30	localThrowable	java.lang.Throwable
    //   1446	15	30	localIterator2	Iterator
    //   307	33	31	str1	String
    //   424	37	31	localObject5	Object
    //   657	1660	31	localObject6	Object
    //   317	1570	32	localObject7	Object
    //   2092	94	32	localException3	Exception
    //   327	1783	33	localObject8	Object
    //   337	38	34	str2	String
    // Exception table:
    //   from	to	target	type
    //   289	383	424	finally
    //   383	413	424	finally
    //   413	421	424	finally
    //   267	289	463	java/lang/Exception
    //   446	452	463	java/lang/Exception
    //   460	463	463	java/lang/Exception
    //   992	999	463	java/lang/Exception
    //   1161	1168	463	java/lang/Exception
    //   120	127	1002	finally
    //   143	152	1002	finally
    //   168	178	1002	finally
    //   194	234	1002	finally
    //   250	259	1002	finally
    //   267	289	1002	finally
    //   446	452	1002	finally
    //   460	463	1002	finally
    //   481	499	1002	finally
    //   515	527	1002	finally
    //   543	577	1002	finally
    //   593	605	1002	finally
    //   621	631	1002	finally
    //   647	659	1002	finally
    //   675	690	1002	finally
    //   706	711	1002	finally
    //   735	758	1002	finally
    //   774	785	1002	finally
    //   801	826	1002	finally
    //   842	847	1002	finally
    //   871	899	1002	finally
    //   915	926	1002	finally
    //   942	956	1002	finally
    //   992	999	1002	finally
    //   1161	1168	1002	finally
    //   1187	1195	1002	finally
    //   1211	1225	1002	finally
    //   1241	1274	1002	finally
    //   1538	1552	1002	finally
    //   1560	1594	1002	finally
    //   431	438	1151	finally
    //   120	127	1528	java/lang/Exception
    //   143	152	1528	java/lang/Exception
    //   168	178	1528	java/lang/Exception
    //   194	234	1528	java/lang/Exception
    //   250	259	1528	java/lang/Exception
    //   481	499	1528	java/lang/Exception
    //   515	527	1528	java/lang/Exception
    //   543	577	1528	java/lang/Exception
    //   593	605	1528	java/lang/Exception
    //   621	631	1528	java/lang/Exception
    //   647	659	1528	java/lang/Exception
    //   675	690	1528	java/lang/Exception
    //   706	711	1528	java/lang/Exception
    //   735	758	1528	java/lang/Exception
    //   774	785	1528	java/lang/Exception
    //   801	826	1528	java/lang/Exception
    //   842	847	1528	java/lang/Exception
    //   871	899	1528	java/lang/Exception
    //   915	926	1528	java/lang/Exception
    //   942	956	1528	java/lang/Exception
    //   1187	1195	1528	java/lang/Exception
    //   1211	1225	1528	java/lang/Exception
    //   1241	1274	1528	java/lang/Exception
    //   1917	1923	2092	java/lang/Exception
  }
  
  final void baf()
  {
    AppMethodBeat.i(132080);
    this.mCP.B(14, Integer.valueOf(d.Yxh));
    AppMethodBeat.o(132080);
  }
  
  final void bag()
  {
    AppMethodBeat.i(132082);
    c.baR().FD(this.mCJ);
    u localu = new u(this.mCJ + ".nomedia");
    if (!localu.jKS()) {
      try
      {
        localu.jKZ();
        AppMethodBeat.o(132082);
        return;
      }
      catch (IOException localIOException)
      {
        Log.e("MMKernel.CoreStorage", "exception:%s", new Object[] { Util.stackTraceToString(localIOException) });
      }
    }
    AppMethodBeat.o(132082);
  }
  
  public final boolean bah()
  {
    AppMethodBeat.i(132085);
    h.baF();
    h.baC().aZJ();
    int i = Util.nullAsNil((Integer)this.mCP.d(89, null));
    if (i != 0)
    {
      Log.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: ".concat(String.valueOf(i)));
      AppMethodBeat.o(132085);
      return false;
    }
    if ((Util.nullAsNil((String)this.mCP.d(8195, null)).length() <= 0) || (Util.nullAsNil((Integer)this.mCP.d(15, null)) == 0)) {}
    for (boolean bool = true; (!bool) || (bai() == null); bool = false)
    {
      this.mCP.B(89, Integer.valueOf(1));
      this.mCP.iZy();
      Log.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(132085);
      return false;
    }
    Log.i("MMKernel.CoreStorage", "isDBCorrupted: true");
    AppMethodBeat.o(132085);
    return true;
  }
  
  public final String bai()
  {
    AppMethodBeat.i(132086);
    Object localObject1 = new u(this.cachePath + "/ctest", "EnMicroMsg.db");
    if (((u)localObject1).jKV())
    {
      localObject1 = ah.v(((u)localObject1).jKT());
      AppMethodBeat.o(132086);
      return localObject1;
    }
    localObject1 = new u(this.cachePath + "/corrupted", "EnMicroMsg.db");
    if (((u)localObject1).jKV())
    {
      localObject1 = ah.v(((u)localObject1).jKT());
      AppMethodBeat.o(132086);
      return localObject1;
    }
    String[] arrayOfString = new u(this.cachePath).a(new ad()
    {
      public final boolean accept(u paramAnonymousu, String paramAnonymousString)
      {
        AppMethodBeat.i(235222);
        boolean bool = paramAnonymousString.startsWith("EnMicroMsg.dberr");
        AppMethodBeat.o(235222);
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
  
  public final String baj()
  {
    return this.cachePath;
  }
  
  public final String bak()
  {
    AppMethodBeat.i(132089);
    String str = this.cachePath + "MicroMsg.db";
    AppMethodBeat.o(132089);
    return str;
  }
  
  public final String bal()
  {
    AppMethodBeat.i(132090);
    String str = this.cachePath + "EnMicroMsg.db";
    AppMethodBeat.o(132090);
    return str;
  }
  
  public final aq ban()
  {
    AppMethodBeat.i(132094);
    h.baF();
    h.baC().aZJ();
    aq localaq = this.mCP;
    AppMethodBeat.o(132094);
    return localaq;
  }
  
  public final co bao()
  {
    AppMethodBeat.i(132095);
    h.baF();
    h.baC().aZJ();
    co localco = this.mCQ;
    AppMethodBeat.o(132095);
    return localco;
  }
  
  public final void bap()
  {
    AppMethodBeat.i(132096);
    this.mCZ = Boolean.valueOf(isSDCardAvailable());
    AppMethodBeat.o(132096);
  }
  
  /* Error */
  public final void baq()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 1289
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 749	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   11: pop
    //   12: invokestatic 753	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   15: getfield 1293	com/tencent/mm/kernel/b:mBI	[B
    //   18: astore 5
    //   20: aload 5
    //   22: monitorenter
    //   23: invokestatic 531	com/tencent/mm/compatible/util/e:aPU	()Z
    //   26: istore_3
    //   27: invokestatic 175	com/tencent/mm/kernel/f:bam	()Ljava/lang/String;
    //   30: astore 4
    //   32: ldc 184
    //   34: ldc_w 1295
    //   37: iconst_4
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: invokestatic 756	com/tencent/mm/kernel/b:getUin	()I
    //   46: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_0
    //   53: getfield 177	com/tencent/mm/kernel/f:mCI	Ljava/lang/String;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload 4
    //   61: aastore
    //   62: dup
    //   63: iconst_3
    //   64: invokestatic 753	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   67: invokevirtual 1298	com/tencent/mm/kernel/b:aZN	()Z
    //   70: invokestatic 348	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aload 4
    //   79: invokestatic 201	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   82: ifne +269 -> 351
    //   85: aload 4
    //   87: aload_0
    //   88: getfield 177	com/tencent/mm/kernel/f:mCI	Ljava/lang/String;
    //   91: invokevirtual 574	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   94: istore_1
    //   95: iload_1
    //   96: ifeq +137 -> 233
    //   99: ldc 184
    //   101: new 222	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 1300
    //   108: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: invokestatic 1302	com/tencent/mm/kernel/f:bar	()Z
    //   114: invokevirtual 524	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: ldc 184
    //   125: new 222	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1304
    //   132: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: invokestatic 1306	com/tencent/mm/kernel/f:bas	()Z
    //   138: invokevirtual 524	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   141: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 341	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 5
    //   149: monitorexit
    //   150: ldc_w 1289
    //   153: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: astore 4
    //   159: ldc 184
    //   161: new 222	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 1308
    //   168: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload 4
    //   173: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 613	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -62 -> 123
    //   188: astore 4
    //   190: aload 5
    //   192: monitorexit
    //   193: ldc_w 1289
    //   196: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: ldc 184
    //   206: new 222	java/lang/StringBuilder
    //   209: dup
    //   210: ldc_w 1310
    //   213: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload 4
    //   218: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 613	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: goto -83 -> 147
    //   233: aload_0
    //   234: aload 4
    //   236: iload_3
    //   237: invokespecial 1312	com/tencent/mm/kernel/f:C	(Ljava/lang/String;Z)V
    //   240: iload_3
    //   241: ifeq +120 -> 361
    //   244: aload_0
    //   245: getfield 177	com/tencent/mm/kernel/f:mCI	Ljava/lang/String;
    //   248: invokestatic 213	com/tencent/mm/loader/i/b:bmt	()Ljava/lang/String;
    //   251: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   254: ifeq +107 -> 361
    //   257: iconst_1
    //   258: istore_1
    //   259: invokestatic 1318	com/tencent/mm/vfs/k:kMs	()Lcom/tencent/mm/vfs/k;
    //   262: invokevirtual 1322	com/tencent/mm/vfs/k:kMv	()Lcom/tencent/mm/vfs/k$a;
    //   265: astore 6
    //   267: aload_0
    //   268: getfield 218	com/tencent/mm/kernel/f:mCL	Ljava/lang/String;
    //   271: aload_0
    //   272: getfield 237	com/tencent/mm/kernel/f:mCK	Ljava/lang/String;
    //   275: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +88 -> 366
    //   281: aload 6
    //   283: iload_1
    //   284: iload_2
    //   285: invokestatic 1327	com/tencent/mm/vfs/af:a	(Lcom/tencent/mm/vfs/k$a;ZZ)Lcom/tencent/mm/vfs/k$a;
    //   288: pop
    //   289: aload 6
    //   291: aload_0
    //   292: getfield 177	com/tencent/mm/kernel/f:mCI	Ljava/lang/String;
    //   295: iload_1
    //   296: invokestatic 1330	com/tencent/mm/vfs/af:a	(Lcom/tencent/mm/vfs/k$a;Ljava/lang/String;Z)Lcom/tencent/mm/vfs/k$a;
    //   299: pop
    //   300: iload_1
    //   301: ifeq +70 -> 371
    //   304: aload_0
    //   305: getfield 218	com/tencent/mm/kernel/f:mCL	Ljava/lang/String;
    //   308: astore 4
    //   310: aload 6
    //   312: ldc_w 1332
    //   315: aload 4
    //   317: invokevirtual 1338	com/tencent/mm/vfs/k$a:qh	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/k$a;
    //   320: invokevirtual 1341	com/tencent/mm/vfs/k$a:commit	()V
    //   323: invokestatic 1218	com/tencent/mm/kernel/a/c:baR	()Lcom/tencent/mm/kernel/a/c;
    //   326: getfield 1345	com/tencent/mm/kernel/a/c:mEc	Lcom/tencent/mm/kernel/a/c$e;
    //   329: invokevirtual 1350	com/tencent/mm/kernel/a/c$e:baN	()V
    //   332: ldc 184
    //   334: ldc_w 1352
    //   337: iconst_1
    //   338: anewarray 4	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: iload_3
    //   344: invokestatic 348	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   347: aastore
    //   348: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload 5
    //   353: monitorexit
    //   354: ldc_w 1289
    //   357: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: return
    //   361: iconst_0
    //   362: istore_1
    //   363: goto -104 -> 259
    //   366: iconst_0
    //   367: istore_2
    //   368: goto -87 -> 281
    //   371: aload_0
    //   372: getfield 237	com/tencent/mm/kernel/f:mCK	Ljava/lang/String;
    //   375: astore 4
    //   377: goto -67 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	f
    //   94	269	1	bool1	boolean
    //   1	367	2	bool2	boolean
    //   26	318	3	bool3	boolean
    //   30	56	4	str1	String
    //   157	15	4	localException1	Exception
    //   188	12	4	localObject	Object
    //   202	33	4	localException2	Exception
    //   308	68	4	str2	String
    //   18	334	5	arrayOfByte	byte[]
    //   265	46	6	locala	com.tencent.mm.vfs.k.a
    // Exception table:
    //   from	to	target	type
    //   99	123	157	java/lang/Exception
    //   23	95	188	finally
    //   99	123	188	finally
    //   123	147	188	finally
    //   147	150	188	finally
    //   159	185	188	finally
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
  
  public final boolean isSDCardAvailable()
  {
    AppMethodBeat.i(132098);
    boolean bool1 = this.mCI.startsWith(com.tencent.mm.loader.i.b.bmt());
    long l1 = Util.nowMilliSecond();
    long l2 = l1 - this.mCX;
    if (bool1)
    {
      h.baF();
      if ((h.baC().aZN()) && (l2 > 0L) && (l2 < 2000L) && (new u(this.mCI).jKS()))
      {
        AppMethodBeat.o(132098);
        return true;
      }
    }
    this.mCX = l1;
    boolean bool2 = com.tencent.mm.compatible.util.e.aPU();
    h.baF();
    h.baC();
    Log.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", new Object[] { Boolean.valueOf(bool2), p.getString(b.getUin()), Long.valueOf(l2), this.mCI, com.tencent.mm.loader.i.b.bmt(), Boolean.valueOf(h.baC().aZN()) });
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
    h.baF();
    if (h.baC().aZN())
    {
      Log.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
      baq();
    }
    AppMethodBeat.o(132098);
    return true;
  }
  
  public final class a
    implements com.tencent.threadpool.i.e, Runnable
  {
    public Future dBj;
    
    private a() {}
    
    public final void c(Future paramFuture)
    {
      this.dBj = paramFuture;
    }
    
    public final void run()
    {
      AppMethodBeat.i(132070);
      f.this.bap();
      AppMethodBeat.o(132070);
    }
  }
  
  public static final class b
    extends a<h.a>
    implements h.a
  {
    public final void bau()
    {
      AppMethodBeat.i(132074);
      a(new a.a() {});
      AppMethodBeat.o(132074);
    }
    
    public final void bav()
    {
      AppMethodBeat.i(132075);
      a(new a.a() {});
      AppMethodBeat.o(132075);
    }
    
    public final void baw()
    {
      AppMethodBeat.i(132076);
      a(new a.a() {});
      AppMethodBeat.o(132076);
    }
  }
  
  public static class c
  {
    public boolean mDg = false;
    public int mDh = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.f
 * JD-Core Version:    0.7.0.1
 */