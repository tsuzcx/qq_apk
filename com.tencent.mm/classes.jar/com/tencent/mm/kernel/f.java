package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.cw.a;
import com.tencent.mm.cw.a.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.cq;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cr;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.storagebase.h.c;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.z;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  private static HashMap<Integer, h.b> baseDBFactories;
  public String cachePath;
  public String kcA;
  public String kcB;
  public String kcC;
  String kcD;
  public String kcE;
  public com.tencent.mm.storagebase.h kcF;
  public com.tencent.mm.storagebase.h kcG;
  ao kcH;
  cl kcI;
  cr kcJ;
  ConcurrentHashMap<Integer, String> kcK;
  boolean kcL;
  cq kcM;
  ConcurrentHashMap<String, SharedPreferences> kcN;
  boolean kcO;
  private long kcP;
  private MMHandler kcQ;
  public volatile Boolean kcR;
  public f.a kcS;
  public long kcT;
  public final an kcw;
  private com.tencent.mm.kernel.api.e kcx;
  private b kcy;
  b kcz;
  
  static
  {
    AppMethodBeat.i(132107);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ao.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("TablesVersion".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return cr.SQL_CREATE;
      }
    });
    AppMethodBeat.o(132107);
  }
  
  public f(com.tencent.mm.kernel.api.e parame)
  {
    AppMethodBeat.i(132077);
    this.kcy = new b();
    this.kcz = new b();
    this.kcF = null;
    this.kcG = null;
    this.kcL = false;
    this.kcN = new ConcurrentHashMap();
    this.kcO = false;
    this.kcP = 0L;
    this.kcQ = null;
    this.kcR = null;
    this.kcS = new f.a(this, (byte)0);
    this.kcT = 0L;
    this.kcw = aHg();
    b.kbD.a(this.kcw);
    this.kcA = aHo();
    this.kcx = parame;
    AppMethodBeat.o(132077);
  }
  
  private void A(String paramString, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(132081);
    Log.i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", new Object[] { this.kcA, paramString, this.kcB, this.cachePath });
    if (!Util.isNullOrNil(paramString))
    {
      int j = this.kcA.length();
      this.kcB.substring(j);
      this.kcA = paramString;
      if ((!paramBoolean) || (!this.kcA.startsWith(com.tencent.mm.loader.j.b.aSF()))) {
        break label148;
      }
      if (i == 0) {
        break label153;
      }
    }
    label148:
    label153:
    for (paramString = this.kcD;; paramString = this.kcC)
    {
      this.kcE = paramString;
      this.kcB = (this.kcA + this.kcE + "/");
      aHi();
      AppMethodBeat.o(132081);
      return;
      i = 0;
      break;
    }
  }
  
  static String F(int paramInt, String paramString)
  {
    AppMethodBeat.i(132106);
    q localq2 = new q(com.tencent.mm.loader.j.b.aSC(), "account.bin");
    q localq3 = new q(com.tencent.mm.loader.j.b.aSC() + "MicroMsg/" + paramString + "/account.bin");
    q localq1 = new q(com.tencent.mm.loader.j.b.aSC() + "MicroMsg/" + paramString + "/account.mapping");
    Object localObject1 = g(localq2);
    Object localObject2 = g(localq3);
    int i;
    if (localObject2 != null)
    {
      i = 0;
      paramString = (String)localObject2;
    }
    for (;;)
    {
      boolean bool1 = false;
      if ((localObject2 == null) || (localq3.length() != 4112L)) {
        bool1 = a(localq3, paramString) | false;
      }
      boolean bool2;
      if (localObject1 != null)
      {
        bool2 = bool1;
        if (localq2.length() == 4112L) {}
      }
      else
      {
        bool2 = bool1 | a(localq2, paramString);
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
        paramString = aHv();
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
      Object tmp290_288 = localObject2;
      tmp290_288[0] = 48;
      Object tmp296_290 = tmp290_288;
      tmp296_290[1] = 49;
      Object tmp302_296 = tmp296_290;
      tmp302_296[2] = 50;
      Object tmp308_302 = tmp302_296;
      tmp308_302[3] = 51;
      Object tmp314_308 = tmp308_302;
      tmp314_308[4] = 52;
      Object tmp320_314 = tmp314_308;
      tmp320_314[5] = 53;
      Object tmp326_320 = tmp320_314;
      tmp326_320[6] = 54;
      Object tmp333_326 = tmp326_320;
      tmp333_326[7] = 55;
      Object tmp340_333 = tmp333_326;
      tmp340_333[8] = 56;
      Object tmp347_340 = tmp340_333;
      tmp347_340[9] = 57;
      Object tmp354_347 = tmp347_340;
      tmp354_347[10] = 97;
      Object tmp361_354 = tmp354_347;
      tmp361_354[11] = 98;
      Object tmp368_361 = tmp361_354;
      tmp368_361[12] = 99;
      Object tmp375_368 = tmp368_361;
      tmp375_368[13] = 100;
      Object tmp382_375 = tmp375_368;
      tmp382_375[14] = 101;
      Object tmp389_382 = tmp382_375;
      tmp389_382[15] = 102;
      tmp389_382;
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
    if (!localq1.ifE()) {
      c(localq1, paramString);
    }
    AppMethodBeat.o(132106);
    return paramString;
  }
  
  private static final boolean MR(String paramString)
  {
    AppMethodBeat.i(132093);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
      AppMethodBeat.o(132093);
      return false;
    }
    Object localObject = new q(paramString);
    Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", new Object[] { paramString, Boolean.valueOf(((q)localObject).ifE()), Boolean.valueOf(((q)localObject).isDirectory()) });
    if ((((q)localObject).ifE()) && (((q)localObject).isDirectory()))
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
        q localq = new q((String)localObject);
        if ((localq.ifH()) && (!localq.aj(new q((String)localObject + "_mmbak"))))
        {
          Log.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", new Object[] { localq.getName() });
          AppMethodBeat.o(132093);
          return false;
        }
        paramString = (String)localObject;
        if (!localq.ifE())
        {
          paramString = (String)localObject;
          if (!localq.ifK())
          {
            Log.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", new Object[] { localq.getName() });
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
  private static boolean a(q paramq, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 392
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: arraylength
    //   8: sipush 4096
    //   11: if_icmpeq +19 -> 30
    //   14: ldc 181
    //   16: ldc_w 394
    //   19: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 392
    //   25: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: invokevirtual 398	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   34: invokevirtual 401	com/tencent/mm/vfs/q:ifL	()Z
    //   37: pop
    //   38: aload_0
    //   39: invokestatic 407	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   42: astore_3
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 412	java/io/OutputStream:write	([B)V
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 418	com/tencent/mm/b/g:V	([B)[B
    //   55: invokevirtual 412	java/io/OutputStream:write	([B)V
    //   58: ldc 181
    //   60: ldc_w 420
    //   63: aload_0
    //   64: invokestatic 423	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   67: invokevirtual 427	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: invokevirtual 430	java/io/OutputStream:close	()V
    //   81: ldc_w 392
    //   84: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_1
    //   88: ireturn
    //   89: astore_2
    //   90: ldc_w 392
    //   93: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: aload_3
    //   100: ifnull +11 -> 111
    //   103: aload_2
    //   104: ifnull +50 -> 154
    //   107: aload_3
    //   108: invokevirtual 430	java/io/OutputStream:close	()V
    //   111: ldc_w 392
    //   114: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: ldc 181
    //   122: aload_1
    //   123: ldc_w 432
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: ldc_w 392
    //   140: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_3
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 439	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   151: goto -40 -> 111
    //   154: aload_3
    //   155: invokevirtual 430	java/io/OutputStream:close	()V
    //   158: goto -47 -> 111
    //   161: astore_1
    //   162: goto -63 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramq	q
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
  
  private static an aHg()
  {
    AppMethodBeat.i(132078);
    Log.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", new Object[] { BuildInfo.info(), Integer.valueOf(d.RAD) });
    Object localObject1 = new q(ar.Vgb);
    if (!((q)localObject1).ifE()) {
      ((q)localObject1).ifL();
    }
    localObject1 = new an(ar.Vgb + "systemInfo.cfg");
    Object localObject2 = (String)((an)localObject1).get(258);
    if (localObject2 != null) {
      l.auq().i(258, localObject2);
    }
    try
    {
      localObject2 = new StatFs(com.tencent.mm.compatible.util.g.avG().getPath());
      Log.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", new Object[] { com.tencent.mm.compatible.util.g.avG().getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()) });
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
  
  private static String aHo()
  {
    AppMethodBeat.i(132092);
    Object localObject2 = ar.Vgb;
    q localq = new q(com.tencent.mm.loader.j.b.aSF());
    Log.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + (String)localObject2 + "] SDCARD_ROOT[" + com.tencent.mm.loader.j.b.aSF() + "] file.exists:" + localq.ifE() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.e.avA());
    Object localObject1 = localObject2;
    if (localq.ifE())
    {
      localObject1 = localObject2;
      if (com.tencent.mm.compatible.util.e.avA())
      {
        localObject1 = localObject2;
        if (MR(com.tencent.mm.loader.j.b.aSL())) {
          localObject1 = com.tencent.mm.loader.j.b.aSL();
        }
        localObject2 = new q(com.tencent.mm.loader.j.b.aSX());
        if (!((q)localObject2).ifE()) {
          ((q)localObject2).ifL();
        }
        localObject2 = new q(com.tencent.mm.loader.j.b.aSP());
        if (!((q)localObject2).ifE()) {
          ((q)localObject2).ifL();
        }
        localObject2 = new q(com.tencent.mm.loader.j.b.aSQ());
        if (!((q)localObject2).ifE()) {
          ((q)localObject2).ifL();
        }
        localObject2 = new q(com.tencent.mm.loader.j.b.aSR());
        if (!((q)localObject2).ifE()) {
          ((q)localObject2).ifL();
        }
        localObject2 = new q(com.tencent.mm.loader.j.b.aSP() + ".nomedia");
        if (((q)localObject2).ifE()) {}
      }
    }
    try
    {
      ((q)localObject2).ifM();
      MR(com.tencent.mm.loader.j.b.aSO());
      localObject2 = new q((String)localObject1);
      if (!((q)localObject2).ifE()) {
        ((q)localObject2).ifL();
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
  
  private static boolean aHt()
  {
    bool3 = false;
    AppMethodBeat.i(132100);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool4 = com.tencent.mm.loader.j.b.aSF().equalsIgnoreCase(str);
    boolean bool5 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool2 = new q(Environment.getExternalStorageDirectory().getAbsolutePath()).ifD();
      localq = new q(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
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
          q localq;
          Object localObject3;
          localq.ifM();
          localOutputStream2 = localOutputStream3;
          Object localObject1 = localObject3;
          localOutputStream3 = u.an(localq);
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
          bool1 = localq.cFq();
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
          Log.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + com.tencent.mm.loader.j.b.aSF() + " isPrimaryExtStg: " + bool4 + " mounted: " + bool5 + " canWrite: " + bool2 + " canTrueWrite:" + bool1);
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
  
  private static boolean aHu()
  {
    AppMethodBeat.i(132101);
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool2 = com.tencent.mm.loader.j.b.aSF().equalsIgnoreCase(str);
    boolean bool3 = Environment.getExternalStorageState().equals("mounted");
    try
    {
      bool1 = new q(Environment.getExternalStorageDirectory().getAbsolutePath()).ifC();
      q localq = new q(com.tencent.mm.loader.j.b.aSL());
      boolean bool4 = localq.ifE();
      if (bool4) {
        Log.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + localq.isDirectory() + " isFile:" + localq.ifH());
      }
      Log.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + str + " CConstants.SDCARD_ROOT: " + com.tencent.mm.loader.j.b.aSF() + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.loader.j.b.aSL() + " isPrimaryExtStg: " + bool2 + " mounted: " + bool3 + " canRead: " + bool1 + " canTrueRead:" + bool4);
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
  private static byte[] aHv()
  {
    // Byte code:
    //   0: ldc_w 632
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 634
    //   9: invokestatic 638	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   31: invokevirtual 644	java/io/InputStream:read	([BII)I
    //   34: istore_1
    //   35: iload_1
    //   36: ifge +29 -> 65
    //   39: ldc 181
    //   41: ldc_w 646
    //   44: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 4
    //   49: ifnull +8 -> 57
    //   52: aload 4
    //   54: invokevirtual 647	java/io/InputStream:close	()V
    //   57: ldc_w 632
    //   60: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   85: invokevirtual 647	java/io/InputStream:close	()V
    //   88: ldc_w 632
    //   91: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_2
    //   95: areturn
    //   96: astore_3
    //   97: ldc_w 632
    //   100: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_3
    //   104: athrow
    //   105: astore_2
    //   106: aload 4
    //   108: ifnull +12 -> 120
    //   111: aload_3
    //   112: ifnull +49 -> 161
    //   115: aload 4
    //   117: invokevirtual 647	java/io/InputStream:close	()V
    //   120: ldc_w 632
    //   123: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_2
    //   127: athrow
    //   128: astore_2
    //   129: ldc 181
    //   131: aload_2
    //   132: ldc_w 649
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: ldc_w 632
    //   145: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aconst_null
    //   149: areturn
    //   150: astore 4
    //   152: aload_3
    //   153: aload 4
    //   155: invokevirtual 439	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   158: goto -38 -> 120
    //   161: aload 4
    //   163: invokevirtual 647	java/io/InputStream:close	()V
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
  
  /* Error */
  private static boolean c(q paramq, String paramString)
  {
    // Byte code:
    //   0: ldc_w 654
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 407	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 296	java/lang/String:getBytes	()[B
    //   18: invokevirtual 412	java/io/OutputStream:write	([B)V
    //   21: ldc 181
    //   23: ldc_w 656
    //   26: aload_0
    //   27: invokestatic 423	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   30: invokevirtual 427	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_3
    //   37: ifnull +7 -> 44
    //   40: aload_3
    //   41: invokevirtual 430	java/io/OutputStream:close	()V
    //   44: ldc_w 654
    //   47: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_1
    //   51: ireturn
    //   52: astore_2
    //   53: ldc_w 654
    //   56: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_2
    //   60: athrow
    //   61: astore_1
    //   62: aload_3
    //   63: ifnull +11 -> 74
    //   66: aload_2
    //   67: ifnull +50 -> 117
    //   70: aload_3
    //   71: invokevirtual 430	java/io/OutputStream:close	()V
    //   74: ldc_w 654
    //   77: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: ldc 181
    //   85: aload_1
    //   86: ldc_w 658
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_0
    //   96: aastore
    //   97: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: ldc_w 654
    //   103: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_3
    //   109: aload_2
    //   110: aload_3
    //   111: invokevirtual 439	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   114: goto -40 -> 74
    //   117: aload_3
    //   118: invokevirtual 430	java/io/OutputStream:close	()V
    //   121: goto -47 -> 74
    //   124: astore_1
    //   125: goto -63 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramq	q
    //   0	128	1	paramString	String
    //   12	1	2	localObject	Object
    //   52	58	2	localThrowable1	Throwable
    //   10	61	3	localOutputStream	OutputStream
    //   108	10	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   13	36	52	java/lang/Throwable
    //   53	61	61	finally
    //   6	11	82	java/io/IOException
    //   40	44	82	java/io/IOException
    //   70	74	82	java/io/IOException
    //   74	82	82	java/io/IOException
    //   109	114	82	java/io/IOException
    //   117	121	82	java/io/IOException
    //   70	74	108	java/lang/Throwable
    //   13	36	124	finally
  }
  
  /* Error */
  private static byte[] g(q paramq)
  {
    // Byte code:
    //   0: ldc_w 659
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 265	com/tencent/mm/vfs/q:length	()J
    //   10: lstore_3
    //   11: lload_3
    //   12: ldc2_w 660
    //   15: lcmp
    //   16: ifeq +42 -> 58
    //   19: lload_3
    //   20: ldc2_w 266
    //   23: lcmp
    //   24: ifeq +34 -> 58
    //   27: ldc 181
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
    //   53: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: invokestatic 674	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
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
    //   83: invokevirtual 644	java/io/InputStream:read	([BII)I
    //   86: istore_2
    //   87: iload_2
    //   88: ifge +44 -> 132
    //   91: ldc 181
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
    //   107: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 7
    //   116: ifnull +8 -> 124
    //   119: aload 7
    //   121: invokevirtual 647	java/io/InputStream:close	()V
    //   124: ldc_w 659
    //   127: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   157: astore 6
    //   159: iconst_0
    //   160: istore_1
    //   161: aload 7
    //   163: aload 6
    //   165: iload_1
    //   166: bipush 16
    //   168: iload_1
    //   169: isub
    //   170: invokevirtual 644	java/io/InputStream:read	([BII)I
    //   173: istore_2
    //   174: iload_2
    //   175: ifge +44 -> 219
    //   178: ldc 181
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
    //   194: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 7
    //   203: ifnull +8 -> 211
    //   206: aload 7
    //   208: invokevirtual 647	java/io/InputStream:close	()V
    //   211: ldc_w 659
    //   214: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   235: invokestatic 418	com/tencent/mm/b/g:V	([B)[B
    //   238: invokestatic 681	java/util/Arrays:equals	([B[B)Z
    //   241: ifne +37 -> 278
    //   244: ldc 181
    //   246: ldc_w 683
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload_0
    //   256: aastore
    //   257: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 7
    //   262: ifnull +8 -> 270
    //   265: aload 7
    //   267: invokevirtual 647	java/io/InputStream:close	()V
    //   270: ldc_w 659
    //   273: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aconst_null
    //   277: areturn
    //   278: aload 7
    //   280: ifnull +8 -> 288
    //   283: aload 7
    //   285: invokevirtual 647	java/io/InputStream:close	()V
    //   288: ldc_w 659
    //   291: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload 5
    //   296: areturn
    //   297: astore 6
    //   299: ldc_w 659
    //   302: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload 6
    //   307: athrow
    //   308: astore 5
    //   310: aload 7
    //   312: ifnull +13 -> 325
    //   315: aload 6
    //   317: ifnull +57 -> 374
    //   320: aload 7
    //   322: invokevirtual 647	java/io/InputStream:close	()V
    //   325: ldc_w 659
    //   328: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload 5
    //   333: athrow
    //   334: astore 5
    //   336: ldc 181
    //   338: aload 5
    //   340: ldc_w 685
    //   343: iconst_1
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: aload_0
    //   350: aastore
    //   351: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: ldc_w 659
    //   357: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: aconst_null
    //   361: areturn
    //   362: astore 7
    //   364: aload 6
    //   366: aload 7
    //   368: invokevirtual 439	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   371: goto -46 -> 325
    //   374: aload 7
    //   376: invokevirtual 647	java/io/InputStream:close	()V
    //   379: goto -54 -> 325
    //   382: astore 5
    //   384: aconst_null
    //   385: astore 6
    //   387: goto -77 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramq	q
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
  
  static HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(132102);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(baseDBFactories);
    AppMethodBeat.o(132102);
    return localHashMap;
  }
  
  public static String sF(int paramInt)
  {
    AppMethodBeat.i(132088);
    String str = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(paramInt)).getBytes());
    str = ar.Vgb + str + '/';
    AppMethodBeat.o(132088);
    return str;
  }
  
  public final void JA(String paramString)
  {
    AppMethodBeat.i(132087);
    if (this.kcG != null) {
      this.kcG.closeDB();
    }
    if (this.kcF != null) {
      this.kcF.JA(paramString);
    }
    this.kcx.onDataBaseClosed(this.kcF, this.kcG);
    this.kcL = false;
    AppMethodBeat.o(132087);
  }
  
  final void MP(final String paramString)
  {
    AppMethodBeat.i(132083);
    q localq = new q(paramString + "-recovery");
    if (localq.ifH())
    {
      Log.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
      u.deleteFile(paramString + ".ini");
      paramString = new q(paramString);
      paramString.cFq();
      if (!localq.aj(paramString)) {
        Log.e("MMKernel.CoreStorage", "Rename database file failed!");
      }
    }
    paramString = localq.getName();
    paramString = localq.ifB().b(new z()
    {
      public final boolean accept(q paramAnonymousq, String paramAnonymousString)
      {
        AppMethodBeat.i(197031);
        if ((paramAnonymousString.startsWith(paramString)) && (!paramAnonymousString.equals(paramString)))
        {
          AppMethodBeat.o(197031);
          return true;
        }
        AppMethodBeat.o(197031);
        return false;
      }
    });
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localq = paramString[i];
        Log.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + localq.getName());
        localq.cFq();
        i += 1;
      }
    }
    AppMethodBeat.o(132083);
  }
  
  public final SharedPreferences MQ(String paramString)
  {
    AppMethodBeat.i(132091);
    h.aHH();
    h.aHE();
    int i = b.getUin();
    if (i != 0) {
      if (this.kcN.containsKey(paramString))
      {
        paramString = (SharedPreferences)this.kcN.get(paramString);
        AppMethodBeat.o(132091);
        return paramString;
      }
    }
    try
    {
      localObject1 = MMApplicationContext.getContext().getFilesDir().getParent() + "/shared_prefs/";
      Object localObject2 = MMApplicationContext.getDefaultPreferencePath() + paramString + i + ".xml";
      String str = MMApplicationContext.getDefaultPreferencePath() + paramString + i + ".xml.bak";
      localObject2 = new q((String)localObject1 + (String)localObject2);
      if (((q)localObject2).ifE()) {
        ((q)localObject2).cFq();
      }
      localObject1 = new q((String)localObject1 + str);
      if (((q)localObject1).ifE()) {
        ((q)localObject1).cFq();
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
    this.kcN.put(paramString, localObject1);
    AppMethodBeat.o(132091);
    return localObject1;
    AppMethodBeat.o(132091);
    return null;
  }
  
  public final com.tencent.mm.vending.b.b a(h.a parama)
  {
    AppMethodBeat.i(193907);
    parama = this.kcy.add(parama);
    AppMethodBeat.o(193907);
    return parama;
  }
  
  public final boolean a(au paramau)
  {
    AppMethodBeat.i(132079);
    if (paramau == null)
    {
      Log.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
      AppMethodBeat.o(132079);
      return false;
    }
    int i = Util.nullAsNil((Integer)this.kcH.b(14, null));
    int j = d.RAD;
    Log.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + i + ", cVer = " + j);
    paramau = paramau.getDataTransferList();
    if (paramau == null)
    {
      Log.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
      AppMethodBeat.o(132079);
      return false;
    }
    if ((ac.mFE > 0) && (ac.mFF > 0)) {
      Log.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
    }
    long l1;
    label383:
    boolean bool1;
    do
    {
      Log.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + paramau.size());
      Log.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
      l1 = this.kcF.beginTransaction(Thread.currentThread().getId());
      try
      {
        paramau = paramau.iterator();
        while (paramau.hasNext())
        {
          localObject = (at)paramau.next();
          long l2 = System.currentTimeMillis();
          ((at)localObject).uP(i);
          ((at)localObject).ltp = (System.currentTimeMillis() - l2);
          Log.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + ((at)localObject).ltp + ", tag = " + ((at)localObject).getTag());
        }
        if (i != j) {
          break label383;
        }
      }
      catch (Throwable paramau)
      {
        AppMethodBeat.o(132079);
        throw paramau;
      }
      finally
      {
        if (l1 > 0L) {
          this.kcF.endTransaction(l1);
        }
        AppMethodBeat.o(132079);
      }
      Log.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + i + ", cVer = " + j);
      AppMethodBeat.o(132079);
      return false;
      bool1 = false;
      Object localObject = paramau.iterator();
      while (((Iterator)localObject).hasNext())
      {
        boolean bool2 = ((at)((Iterator)localObject).next()).uQ(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
      Log.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = ".concat(String.valueOf(bool1)));
    } while (bool1);
    AppMethodBeat.o(132079);
    return false;
    if ((ac.mFE != 0) && (ac.mFF != 0))
    {
      i = 0;
      for (;;)
      {
        j = ac.mFE;
        if (i < j) {
          try
          {
            Thread.sleep(ac.mFF);
            i += 1;
          }
          catch (InterruptedException paramau)
          {
            for (;;)
            {
              Log.e("MMKernel.CoreStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramau) });
            }
          }
        }
      }
    }
    if (l1 > 0L) {
      this.kcF.endTransaction(l1);
    }
    AppMethodBeat.o(132079);
    return true;
  }
  
  /* Error */
  public final boolean a(com.tencent.mm.storagebase.f paramf, HashMap<Integer, h.b> paramHashMap)
  {
    // Byte code:
    //   0: ldc_w 927
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnonnull +991 -> 998
    //   10: iconst_m1
    //   11: istore_3
    //   12: ldc 181
    //   14: ldc_w 929
    //   17: iconst_2
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: iload_3
    //   24: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: getstatic 932	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   33: aastore
    //   34: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: invokestatic 938	com/tencent/mm/platformtools/ab:bvB	()Lcom/tencent/mm/platformtools/ab;
    //   40: astore 29
    //   42: invokestatic 941	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   45: ifeq +1417 -> 1462
    //   48: getstatic 945	com/tencent/mm/platformtools/ab:mEU	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   51: iconst_1
    //   52: iconst_0
    //   53: invokevirtual 951	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   56: ifeq +1406 -> 1462
    //   59: aload 29
    //   61: aload_1
    //   62: putfield 955	com/tencent/mm/platformtools/ab:mEV	Lcom/tencent/mm/storagebase/f;
    //   65: iconst_2
    //   66: anewarray 94	java/lang/String
    //   69: astore 30
    //   71: aload 30
    //   73: iconst_0
    //   74: ldc_w 957
    //   77: aastore
    //   78: aload 30
    //   80: iconst_1
    //   81: ldc_w 959
    //   84: aastore
    //   85: aload 30
    //   87: invokestatic 962	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([Ljava/lang/String;)Z
    //   90: ifne +1372 -> 1462
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
    //   143: aload 29
    //   145: getfield 955	com/tencent/mm/platformtools/ab:mEV	Lcom/tencent/mm/storagebase/f;
    //   148: invokestatic 968	com/tencent/mm/platformtools/ab:a	(Lcom/tencent/mm/storagebase/f;)I
    //   151: istore_3
    //   152: lload 6
    //   154: lstore 10
    //   156: lload 8
    //   158: lstore 12
    //   160: lload 6
    //   162: lstore 14
    //   164: lload 8
    //   166: lstore 16
    //   168: aload 29
    //   170: getfield 955	com/tencent/mm/platformtools/ab:mEV	Lcom/tencent/mm/storagebase/f;
    //   173: invokestatic 970	com/tencent/mm/platformtools/ab:b	(Lcom/tencent/mm/storagebase/f;)I
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
    //   219: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: iload 4
    //   227: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: lload 6
    //   236: lstore 10
    //   238: lload 8
    //   240: lstore 12
    //   242: lload 6
    //   244: lstore 14
    //   246: lload 8
    //   248: lstore 16
    //   250: new 85	java/util/HashMap
    //   253: dup
    //   254: invokespecial 88	java/util/HashMap:<init>	()V
    //   257: astore 31
    //   259: lload 6
    //   261: lstore 10
    //   263: lload 8
    //   265: lstore 12
    //   267: invokestatic 978	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   270: getfield 126	com/tencent/mm/kernel/f:kcF	Lcom/tencent/mm/storagebase/h;
    //   273: invokevirtual 982	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   276: getstatic 988	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   279: ldc_w 990
    //   282: aconst_null
    //   283: aconst_null
    //   284: invokevirtual 996	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   287: astore 32
    //   289: aconst_null
    //   290: astore 28
    //   292: aload 32
    //   294: invokeinterface 1001 1 0
    //   299: ifne +707 -> 1006
    //   302: aload 32
    //   304: iconst_0
    //   305: invokeinterface 1004 2 0
    //   310: astore 27
    //   312: aload 32
    //   314: iconst_1
    //   315: invokeinterface 1004 2 0
    //   320: astore 33
    //   322: aload 32
    //   324: iconst_2
    //   325: invokeinterface 1004 2 0
    //   330: astore 34
    //   332: aload 32
    //   334: iconst_3
    //   335: invokeinterface 1004 2 0
    //   340: astore 35
    //   342: aload 27
    //   344: ldc_w 1006
    //   347: invokevirtual 573	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   350: ifeq +36 -> 386
    //   353: aload 30
    //   355: aload 33
    //   357: aload 34
    //   359: invokestatic 1009	com/tencent/mm/platformtools/ab:a	([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   362: ifeq +24 -> 386
    //   365: aload 31
    //   367: aload 33
    //   369: new 1011	com/tencent/mm/platformtools/ab$a
    //   372: dup
    //   373: aload 29
    //   375: aload 34
    //   377: aload 35
    //   379: invokespecial 1014	com/tencent/mm/platformtools/ab$a:<init>	(Lcom/tencent/mm/platformtools/ab;Ljava/lang/String;Ljava/lang/String;)V
    //   382: invokevirtual 109	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   385: pop
    //   386: invokestatic 965	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   389: iconst_1
    //   390: if_icmpgt +26 -> 416
    //   393: ldc_w 972
    //   396: ldc_w 1016
    //   399: iconst_2
    //   400: anewarray 4	java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: aload 33
    //   407: aastore
    //   408: dup
    //   409: iconst_1
    //   410: aload 34
    //   412: aastore
    //   413: invokestatic 1018	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: aload 32
    //   418: invokeinterface 1021 1 0
    //   423: pop
    //   424: goto -132 -> 292
    //   427: astore 28
    //   429: ldc_w 927
    //   432: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: aload 28
    //   437: athrow
    //   438: astore 27
    //   440: aload 32
    //   442: ifnull +23 -> 465
    //   445: aload 28
    //   447: ifnull +751 -> 1198
    //   450: lload 6
    //   452: lstore 10
    //   454: lload 8
    //   456: lstore 12
    //   458: aload 32
    //   460: invokeinterface 1022 1 0
    //   465: lload 6
    //   467: lstore 10
    //   469: lload 8
    //   471: lstore 12
    //   473: ldc_w 927
    //   476: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   479: lload 6
    //   481: lstore 10
    //   483: lload 8
    //   485: lstore 12
    //   487: aload 27
    //   489: athrow
    //   490: astore 27
    //   492: lload 6
    //   494: lstore 10
    //   496: lload 8
    //   498: lstore 12
    //   500: lload 6
    //   502: lstore 14
    //   504: lload 8
    //   506: lstore 16
    //   508: ldc_w 972
    //   511: ldc_w 1024
    //   514: iconst_1
    //   515: anewarray 4	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: aload 27
    //   522: aastore
    //   523: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: lload 6
    //   528: lstore 10
    //   530: lload 8
    //   532: lstore 12
    //   534: lload 6
    //   536: lstore 14
    //   538: lload 8
    //   540: lstore 16
    //   542: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   545: ldc2_w 1031
    //   548: lconst_1
    //   549: lconst_1
    //   550: iconst_1
    //   551: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   554: lload 6
    //   556: lstore 10
    //   558: lload 8
    //   560: lstore 12
    //   562: lload 6
    //   564: lstore 14
    //   566: lload 8
    //   568: lstore 16
    //   570: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   573: sipush 20708
    //   576: iconst_3
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: ldc_w 1038
    //   585: aastore
    //   586: dup
    //   587: iconst_1
    //   588: iconst_1
    //   589: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   592: aastore
    //   593: dup
    //   594: iconst_2
    //   595: aload 27
    //   597: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   600: aastore
    //   601: invokevirtual 1041	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   604: lload 6
    //   606: lstore 10
    //   608: lload 8
    //   610: lstore 12
    //   612: lload 6
    //   614: lstore 14
    //   616: lload 8
    //   618: lstore 16
    //   620: aload 31
    //   622: invokevirtual 1045	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   625: invokeinterface 1048 1 0
    //   630: astore 27
    //   632: lload 6
    //   634: lstore 10
    //   636: lload 8
    //   638: lstore 12
    //   640: lload 6
    //   642: lstore 14
    //   644: lload 8
    //   646: lstore 16
    //   648: aload 27
    //   650: invokeinterface 880 1 0
    //   655: ifeq +561 -> 1216
    //   658: lload 6
    //   660: lstore 10
    //   662: lload 8
    //   664: lstore 12
    //   666: lload 6
    //   668: lstore 14
    //   670: lload 8
    //   672: lstore 16
    //   674: aload 27
    //   676: invokeinterface 884 1 0
    //   681: checkcast 1050	java/util/Map$Entry
    //   684: astore 28
    //   686: lload 6
    //   688: lstore 10
    //   690: lload 8
    //   692: lstore 12
    //   694: lload 6
    //   696: lstore 14
    //   698: lload 8
    //   700: lstore 16
    //   702: aload 28
    //   704: invokeinterface 1053 1 0
    //   709: checkcast 1011	com/tencent/mm/platformtools/ab$a
    //   712: getfield 1056	com/tencent/mm/platformtools/ab$a:table	Ljava/lang/String;
    //   715: astore 32
    //   717: lload 6
    //   719: lstore 10
    //   721: lload 8
    //   723: lstore 12
    //   725: lload 6
    //   727: lstore 14
    //   729: lload 8
    //   731: lstore 16
    //   733: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   736: lstore 24
    //   738: lload 6
    //   740: lstore 20
    //   742: lload 8
    //   744: lstore 18
    //   746: lload 6
    //   748: lstore 10
    //   750: lload 8
    //   752: lstore 12
    //   754: lload 6
    //   756: lstore 14
    //   758: lload 8
    //   760: lstore 16
    //   762: aload 29
    //   764: getfield 955	com/tencent/mm/platformtools/ab:mEV	Lcom/tencent/mm/storagebase/f;
    //   767: aload 28
    //   769: invokeinterface 1064 1 0
    //   774: checkcast 94	java/lang/String
    //   777: aload 32
    //   779: invokestatic 1067	com/tencent/mm/platformtools/ab:a	(Lcom/tencent/mm/storagebase/f;Ljava/lang/String;Ljava/lang/String;)Z
    //   782: ifeq +205 -> 987
    //   785: lload 6
    //   787: lstore 10
    //   789: lload 8
    //   791: lstore 12
    //   793: lload 6
    //   795: lstore 14
    //   797: lload 8
    //   799: lstore 16
    //   801: lload 8
    //   803: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   806: lload 24
    //   808: lsub
    //   809: ladd
    //   810: lstore 8
    //   812: lload 6
    //   814: lstore 10
    //   816: lload 8
    //   818: lstore 12
    //   820: lload 6
    //   822: lstore 14
    //   824: lload 8
    //   826: lstore 16
    //   828: aload 32
    //   830: aload 30
    //   832: iconst_2
    //   833: anewarray 94	java/lang/String
    //   836: dup
    //   837: iconst_0
    //   838: ldc_w 1069
    //   841: aastore
    //   842: dup
    //   843: iconst_1
    //   844: ldc_w 1071
    //   847: aastore
    //   848: invokestatic 1074	com/tencent/mm/platformtools/ab:d	(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   851: astore 33
    //   853: lload 6
    //   855: lstore 10
    //   857: lload 8
    //   859: lstore 12
    //   861: lload 6
    //   863: lstore 14
    //   865: lload 8
    //   867: lstore 16
    //   869: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   872: lstore 24
    //   874: lload 6
    //   876: lstore 20
    //   878: lload 8
    //   880: lstore 18
    //   882: lload 6
    //   884: lstore 10
    //   886: lload 8
    //   888: lstore 12
    //   890: lload 6
    //   892: lstore 14
    //   894: lload 8
    //   896: lstore 16
    //   898: aload 29
    //   900: getfield 955	com/tencent/mm/platformtools/ab:mEV	Lcom/tencent/mm/storagebase/f;
    //   903: aload 33
    //   905: aload 32
    //   907: aload 28
    //   909: invokeinterface 1053 1 0
    //   914: checkcast 1011	com/tencent/mm/platformtools/ab$a
    //   917: getfield 1077	com/tencent/mm/platformtools/ab$a:sql	Ljava/lang/String;
    //   920: invokestatic 1080	com/tencent/mm/platformtools/ab:a	(Lcom/tencent/mm/storagebase/f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   923: ifeq +64 -> 987
    //   926: lload 6
    //   928: lstore 10
    //   930: lload 8
    //   932: lstore 12
    //   934: lload 6
    //   936: lstore 14
    //   938: lload 8
    //   940: lstore 16
    //   942: lload 6
    //   944: invokestatic 1061	android/os/SystemClock:uptimeMillis	()J
    //   947: lload 24
    //   949: lsub
    //   950: ladd
    //   951: lstore 20
    //   953: lload 20
    //   955: lstore 10
    //   957: lload 8
    //   959: lstore 12
    //   961: lload 20
    //   963: lstore 14
    //   965: lload 8
    //   967: lstore 16
    //   969: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   972: ldc2_w 1031
    //   975: ldc2_w 1081
    //   978: lconst_1
    //   979: iconst_1
    //   980: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   983: lload 8
    //   985: lstore 18
    //   987: lload 20
    //   989: lstore 6
    //   991: lload 18
    //   993: lstore 8
    //   995: goto -363 -> 632
    //   998: aload_2
    //   999: invokevirtual 1083	java/util/HashMap:size	()I
    //   1002: istore_3
    //   1003: goto -991 -> 12
    //   1006: aload 32
    //   1008: ifnull -404 -> 604
    //   1011: lload 6
    //   1013: lstore 10
    //   1015: lload 8
    //   1017: lstore 12
    //   1019: aload 32
    //   1021: invokeinterface 1022 1 0
    //   1026: goto -422 -> 604
    //   1029: astore_1
    //   1030: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   1033: lload 22
    //   1035: lsub
    //   1036: lstore 6
    //   1038: ldc_w 1085
    //   1041: iconst_3
    //   1042: anewarray 4	java/lang/Object
    //   1045: dup
    //   1046: iconst_0
    //   1047: lload 6
    //   1049: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1052: aastore
    //   1053: dup
    //   1054: iconst_1
    //   1055: lload 12
    //   1057: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1060: aastore
    //   1061: dup
    //   1062: iconst_2
    //   1063: lload 10
    //   1065: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1068: aastore
    //   1069: invokestatic 1089	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1072: astore_2
    //   1073: ldc_w 972
    //   1076: aload_2
    //   1077: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1080: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1083: ldc2_w 1031
    //   1086: ldc2_w 1090
    //   1089: lload 6
    //   1091: iconst_0
    //   1092: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1095: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1098: ldc2_w 1031
    //   1101: ldc2_w 1092
    //   1104: lload 12
    //   1106: iconst_0
    //   1107: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1110: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1113: ldc2_w 1031
    //   1116: ldc2_w 1094
    //   1119: lload 10
    //   1121: iconst_0
    //   1122: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1125: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1128: ldc2_w 1031
    //   1131: ldc2_w 1096
    //   1134: lconst_1
    //   1135: iconst_0
    //   1136: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1139: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1142: sipush 20708
    //   1145: iconst_3
    //   1146: anewarray 4	java/lang/Object
    //   1149: dup
    //   1150: iconst_0
    //   1151: ldc_w 1038
    //   1154: aastore
    //   1155: dup
    //   1156: iconst_1
    //   1157: bipush 10
    //   1159: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1162: aastore
    //   1163: dup
    //   1164: iconst_2
    //   1165: aload_2
    //   1166: aastore
    //   1167: invokevirtual 1041	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   1170: ldc_w 927
    //   1173: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1176: aload_1
    //   1177: athrow
    //   1178: astore 32
    //   1180: lload 6
    //   1182: lstore 10
    //   1184: lload 8
    //   1186: lstore 12
    //   1188: aload 28
    //   1190: aload 32
    //   1192: invokevirtual 439	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   1195: goto -730 -> 465
    //   1198: lload 6
    //   1200: lstore 10
    //   1202: lload 8
    //   1204: lstore 12
    //   1206: aload 32
    //   1208: invokeinterface 1022 1 0
    //   1213: goto -748 -> 465
    //   1216: lload 6
    //   1218: lstore 10
    //   1220: lload 8
    //   1222: lstore 12
    //   1224: lload 6
    //   1226: lstore 14
    //   1228: lload 8
    //   1230: lstore 16
    //   1232: aload 31
    //   1234: invokevirtual 1083	java/util/HashMap:size	()I
    //   1237: ifle +82 -> 1319
    //   1240: lload 6
    //   1242: lstore 10
    //   1244: lload 8
    //   1246: lstore 12
    //   1248: lload 6
    //   1250: lstore 14
    //   1252: lload 8
    //   1254: lstore 16
    //   1256: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1259: ldc2_w 1031
    //   1262: ldc2_w 1098
    //   1265: lconst_1
    //   1266: iconst_1
    //   1267: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1270: lload 6
    //   1272: lstore 10
    //   1274: lload 8
    //   1276: lstore 12
    //   1278: lload 6
    //   1280: lstore 14
    //   1282: lload 8
    //   1284: lstore 16
    //   1286: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1289: sipush 20708
    //   1292: iconst_3
    //   1293: anewarray 4	java/lang/Object
    //   1296: dup
    //   1297: iconst_0
    //   1298: ldc_w 1038
    //   1301: aastore
    //   1302: dup
    //   1303: iconst_1
    //   1304: iconst_3
    //   1305: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1308: aastore
    //   1309: dup
    //   1310: iconst_2
    //   1311: iconst_1
    //   1312: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1315: aastore
    //   1316: invokevirtual 1041	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   1319: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   1322: lload 22
    //   1324: lsub
    //   1325: lstore 10
    //   1327: ldc_w 1085
    //   1330: iconst_3
    //   1331: anewarray 4	java/lang/Object
    //   1334: dup
    //   1335: iconst_0
    //   1336: lload 10
    //   1338: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1341: aastore
    //   1342: dup
    //   1343: iconst_1
    //   1344: lload 8
    //   1346: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1349: aastore
    //   1350: dup
    //   1351: iconst_2
    //   1352: lload 6
    //   1354: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1357: aastore
    //   1358: invokestatic 1089	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1361: astore 27
    //   1363: ldc_w 972
    //   1366: aload 27
    //   1368: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1371: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1374: ldc2_w 1031
    //   1377: ldc2_w 1090
    //   1380: lload 10
    //   1382: iconst_0
    //   1383: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1386: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1389: ldc2_w 1031
    //   1392: ldc2_w 1092
    //   1395: lload 8
    //   1397: iconst_0
    //   1398: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1401: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1404: ldc2_w 1031
    //   1407: ldc2_w 1094
    //   1410: lload 6
    //   1412: iconst_0
    //   1413: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1416: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1419: ldc2_w 1031
    //   1422: ldc2_w 1096
    //   1425: lconst_1
    //   1426: iconst_0
    //   1427: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1430: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1433: sipush 20708
    //   1436: iconst_3
    //   1437: anewarray 4	java/lang/Object
    //   1440: dup
    //   1441: iconst_0
    //   1442: ldc_w 1038
    //   1445: aastore
    //   1446: dup
    //   1447: iconst_1
    //   1448: bipush 10
    //   1450: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1453: aastore
    //   1454: dup
    //   1455: iconst_2
    //   1456: aload 27
    //   1458: aastore
    //   1459: invokevirtual 1041	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   1462: new 1101	com/tencent/mm/compatible/util/f$a
    //   1465: dup
    //   1466: invokespecial 1102	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   1469: astore 29
    //   1471: aload_2
    //   1472: ifnull +946 -> 2418
    //   1475: aload_2
    //   1476: invokevirtual 1083	java/util/HashMap:size	()I
    //   1479: ifle +939 -> 2418
    //   1482: aload_2
    //   1483: invokevirtual 1045	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   1486: invokeinterface 1048 1 0
    //   1491: astore 30
    //   1493: iconst_0
    //   1494: istore_3
    //   1495: aload 30
    //   1497: invokeinterface 880 1 0
    //   1502: ifeq +875 -> 2377
    //   1505: aload 30
    //   1507: invokeinterface 884 1 0
    //   1512: checkcast 1050	java/util/Map$Entry
    //   1515: astore_2
    //   1516: aload_2
    //   1517: invokeinterface 1064 1 0
    //   1522: checkcast 100	java/lang/Integer
    //   1525: astore 31
    //   1527: aload_2
    //   1528: invokeinterface 1053 1 0
    //   1533: checkcast 1104	com/tencent/mm/storagebase/h$b
    //   1536: astore 32
    //   1538: aload 32
    //   1540: invokeinterface 1108 1 0
    //   1545: ifnonnull +240 -> 1785
    //   1548: ldc 181
    //   1550: ldc_w 1110
    //   1553: iconst_2
    //   1554: anewarray 4	java/lang/Object
    //   1557: dup
    //   1558: iconst_0
    //   1559: aload 31
    //   1561: aastore
    //   1562: dup
    //   1563: iconst_1
    //   1564: aload 32
    //   1566: aastore
    //   1567: invokestatic 513	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1570: goto -75 -> 1495
    //   1573: astore 27
    //   1575: lload 14
    //   1577: lstore 10
    //   1579: lload 16
    //   1581: lstore 12
    //   1583: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1586: ldc2_w 1031
    //   1589: ldc2_w 1111
    //   1592: lconst_1
    //   1593: iconst_1
    //   1594: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1597: lload 14
    //   1599: lstore 10
    //   1601: lload 16
    //   1603: lstore 12
    //   1605: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1608: sipush 20708
    //   1611: iconst_3
    //   1612: anewarray 4	java/lang/Object
    //   1615: dup
    //   1616: iconst_0
    //   1617: ldc_w 1038
    //   1620: aastore
    //   1621: dup
    //   1622: iconst_1
    //   1623: iconst_2
    //   1624: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1627: aastore
    //   1628: dup
    //   1629: iconst_2
    //   1630: aload 27
    //   1632: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1635: aastore
    //   1636: invokevirtual 1041	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   1639: invokestatic 891	java/lang/System:currentTimeMillis	()J
    //   1642: lload 22
    //   1644: lsub
    //   1645: lstore 6
    //   1647: ldc_w 1085
    //   1650: iconst_3
    //   1651: anewarray 4	java/lang/Object
    //   1654: dup
    //   1655: iconst_0
    //   1656: lload 6
    //   1658: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1661: aastore
    //   1662: dup
    //   1663: iconst_1
    //   1664: lload 16
    //   1666: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1669: aastore
    //   1670: dup
    //   1671: iconst_2
    //   1672: lload 14
    //   1674: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1677: aastore
    //   1678: invokestatic 1089	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1681: astore 27
    //   1683: ldc_w 972
    //   1686: aload 27
    //   1688: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1691: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1694: ldc2_w 1031
    //   1697: ldc2_w 1090
    //   1700: lload 6
    //   1702: iconst_0
    //   1703: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1706: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1709: ldc2_w 1031
    //   1712: ldc2_w 1092
    //   1715: lload 16
    //   1717: iconst_0
    //   1718: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1721: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1724: ldc2_w 1031
    //   1727: ldc2_w 1094
    //   1730: lload 14
    //   1732: iconst_0
    //   1733: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1736: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1739: ldc2_w 1031
    //   1742: ldc2_w 1096
    //   1745: lconst_1
    //   1746: iconst_0
    //   1747: invokevirtual 1036	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   1750: getstatic 1030	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   1753: sipush 20708
    //   1756: iconst_3
    //   1757: anewarray 4	java/lang/Object
    //   1760: dup
    //   1761: iconst_0
    //   1762: ldc_w 1038
    //   1765: aastore
    //   1766: dup
    //   1767: iconst_1
    //   1768: bipush 10
    //   1770: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1773: aastore
    //   1774: dup
    //   1775: iconst_2
    //   1776: aload 27
    //   1778: aastore
    //   1779: invokevirtual 1041	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   1782: goto -320 -> 1462
    //   1785: aload_0
    //   1786: getfield 130	com/tencent/mm/kernel/f:kcL	Z
    //   1789: ifne +642 -> 2431
    //   1792: new 219	java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1799: astore_2
    //   1800: aload 32
    //   1802: invokeinterface 1108 1 0
    //   1807: astore 27
    //   1809: aload 27
    //   1811: arraylength
    //   1812: istore 5
    //   1814: iconst_0
    //   1815: istore 4
    //   1817: iload 4
    //   1819: iload 5
    //   1821: if_icmpge +25 -> 1846
    //   1824: aload_2
    //   1825: aload 27
    //   1827: iload 4
    //   1829: aaload
    //   1830: invokevirtual 98	java/lang/String:hashCode	()I
    //   1833: invokevirtual 363	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1836: pop
    //   1837: iload 4
    //   1839: iconst_1
    //   1840: iadd
    //   1841: istore 4
    //   1843: goto -26 -> 1817
    //   1846: aload_2
    //   1847: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1850: invokevirtual 296	java/lang/String:getBytes	()[B
    //   1853: invokestatic 704	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   1856: astore 28
    //   1858: aload_0
    //   1859: getfield 1114	com/tencent/mm/kernel/f:kcK	Ljava/util/concurrent/ConcurrentHashMap;
    //   1862: ifnull +119 -> 1981
    //   1865: aload_0
    //   1866: getfield 1114	com/tencent/mm/kernel/f:kcK	Ljava/util/concurrent/ConcurrentHashMap;
    //   1869: aload 31
    //   1871: invokevirtual 762	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1874: checkcast 94	java/lang/String
    //   1877: astore 27
    //   1879: ldc 181
    //   1881: ldc_w 1116
    //   1884: iconst_3
    //   1885: anewarray 4	java/lang/Object
    //   1888: dup
    //   1889: iconst_0
    //   1890: aload 31
    //   1892: aastore
    //   1893: dup
    //   1894: iconst_1
    //   1895: aload 27
    //   1897: aastore
    //   1898: dup
    //   1899: iconst_2
    //   1900: aload 28
    //   1902: aastore
    //   1903: invokestatic 1018	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1906: aload 28
    //   1908: astore_2
    //   1909: aload 27
    //   1911: ifnull +16 -> 1927
    //   1914: aload 28
    //   1916: aload 27
    //   1918: invokevirtual 582	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1921: ifne -426 -> 1495
    //   1924: aload 28
    //   1926: astore_2
    //   1927: aload_1
    //   1928: invokevirtual 1120	com/tencent/mm/storagebase/f:beginTransaction	()V
    //   1931: aload 32
    //   1933: invokeinterface 1108 1 0
    //   1938: astore 27
    //   1940: aload 27
    //   1942: arraylength
    //   1943: istore 5
    //   1945: iconst_0
    //   1946: istore 4
    //   1948: iload 4
    //   1950: iload 5
    //   1952: if_icmpge +301 -> 2253
    //   1955: aload 27
    //   1957: iload 4
    //   1959: aaload
    //   1960: astore 28
    //   1962: aload_1
    //   1963: aload 28
    //   1965: invokevirtual 1123	com/tencent/mm/storagebase/f:execSQL	(Ljava/lang/String;)V
    //   1968: iload_3
    //   1969: iconst_1
    //   1970: iadd
    //   1971: istore_3
    //   1972: iload 4
    //   1974: iconst_1
    //   1975: iadd
    //   1976: istore 4
    //   1978: goto -30 -> 1948
    //   1981: aload 28
    //   1983: astore_2
    //   1984: aload_0
    //   1985: getfield 653	com/tencent/mm/kernel/f:kcJ	Lcom/tencent/mm/storage/cr;
    //   1988: ifnull -61 -> 1927
    //   1991: aload_0
    //   1992: getfield 653	com/tencent/mm/kernel/f:kcJ	Lcom/tencent/mm/storage/cr;
    //   1995: astore 33
    //   1997: aload 31
    //   1999: invokevirtual 1126	java/lang/Integer:intValue	()I
    //   2002: istore 4
    //   2004: aconst_null
    //   2005: astore_2
    //   2006: aconst_null
    //   2007: astore 27
    //   2009: aload 33
    //   2011: ldc_w 1128
    //   2014: iload 4
    //   2016: invokestatic 700	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2019: invokevirtual 427	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2022: iconst_0
    //   2023: anewarray 94	java/lang/String
    //   2026: invokevirtual 1134	com/tencent/mm/storage/cr:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   2029: astore 33
    //   2031: aload 33
    //   2033: ifnull +37 -> 2070
    //   2036: aload 27
    //   2038: astore_2
    //   2039: aload 33
    //   2041: invokeinterface 1137 1 0
    //   2046: ifeq +17 -> 2063
    //   2049: new 1139	com/tencent/mm/storage/cq
    //   2052: dup
    //   2053: invokespecial 1140	com/tencent/mm/storage/cq:<init>	()V
    //   2056: astore_2
    //   2057: aload_2
    //   2058: aload 33
    //   2060: invokevirtual 1144	com/tencent/mm/storage/cq:convertFrom	(Landroid/database/Cursor;)V
    //   2063: aload 33
    //   2065: invokeinterface 1022 1 0
    //   2070: aload_2
    //   2071: ifnonnull +57 -> 2128
    //   2074: aconst_null
    //   2075: astore 27
    //   2077: ldc 181
    //   2079: ldc_w 1146
    //   2082: iconst_3
    //   2083: anewarray 4	java/lang/Object
    //   2086: dup
    //   2087: iconst_0
    //   2088: aload 31
    //   2090: aastore
    //   2091: dup
    //   2092: iconst_1
    //   2093: aload 27
    //   2095: aastore
    //   2096: dup
    //   2097: iconst_2
    //   2098: aload 28
    //   2100: aastore
    //   2101: invokestatic 1018	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2104: aload 28
    //   2106: astore_2
    //   2107: aload 27
    //   2109: ifnull -182 -> 1927
    //   2112: aload 28
    //   2114: aload 27
    //   2116: invokevirtual 582	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2119: ifne -624 -> 1495
    //   2122: aload 28
    //   2124: astore_2
    //   2125: goto -198 -> 1927
    //   2128: aload_2
    //   2129: getfield 1149	com/tencent/mm/storage/cq:field_tableSQLMD5	Ljava/lang/String;
    //   2132: astore 27
    //   2134: goto -57 -> 2077
    //   2137: astore 32
    //   2139: getstatic 1155	com/tencent/mm/storagebase/a:VIU	Ljava/util/regex/Pattern;
    //   2142: aload 28
    //   2144: invokevirtual 1161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   2147: astore 33
    //   2149: aload 33
    //   2151: ifnull +56 -> 2207
    //   2154: aload 33
    //   2156: invokevirtual 1166	java/util/regex/Matcher:matches	()Z
    //   2159: ifeq +48 -> 2207
    //   2162: new 219	java/lang/StringBuilder
    //   2165: dup
    //   2166: ldc_w 1168
    //   2169: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2172: aload 28
    //   2174: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: ldc_w 1170
    //   2180: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: aload 32
    //   2185: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2188: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2191: ldc_w 1172
    //   2194: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2200: iconst_0
    //   2201: invokestatic 1177	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   2204: goto -232 -> 1972
    //   2207: ldc 181
    //   2209: new 219	java/lang/StringBuilder
    //   2212: dup
    //   2213: ldc_w 1168
    //   2216: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2219: aload 28
    //   2221: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: ldc_w 1170
    //   2227: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2230: aload 32
    //   2232: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2235: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2238: ldc_w 1172
    //   2241: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2244: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2247: invokestatic 612	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2250: goto -278 -> 1972
    //   2253: aload_1
    //   2254: invokevirtual 1179	com/tencent/mm/storagebase/f:endTransaction	()V
    //   2257: aload_0
    //   2258: getfield 130	com/tencent/mm/kernel/f:kcL	Z
    //   2261: ifne +107 -> 2368
    //   2264: aload_0
    //   2265: getfield 653	com/tencent/mm/kernel/f:kcJ	Lcom/tencent/mm/storage/cr;
    //   2268: ifnull +100 -> 2368
    //   2271: aload_2
    //   2272: ifnull +96 -> 2368
    //   2275: aload_0
    //   2276: getfield 653	com/tencent/mm/kernel/f:kcJ	Lcom/tencent/mm/storage/cr;
    //   2279: astore 27
    //   2281: aload 31
    //   2283: invokevirtual 1126	java/lang/Integer:intValue	()I
    //   2286: istore 4
    //   2288: iload 4
    //   2290: ifeq +81 -> 2371
    //   2293: iconst_1
    //   2294: istore 26
    //   2296: iload 26
    //   2298: invokestatic 1182	junit/framework/Assert:assertTrue	(Z)V
    //   2301: aload_2
    //   2302: invokestatic 1186	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   2305: new 1139	com/tencent/mm/storage/cq
    //   2308: dup
    //   2309: invokespecial 1140	com/tencent/mm/storage/cq:<init>	()V
    //   2312: astore 28
    //   2314: aload 28
    //   2316: iload 4
    //   2318: putfield 1189	com/tencent/mm/storage/cq:field_tableHash	I
    //   2321: aload 28
    //   2323: aload_2
    //   2324: putfield 1149	com/tencent/mm/storage/cq:field_tableSQLMD5	Ljava/lang/String;
    //   2327: aload 27
    //   2329: getfield 1192	com/tencent/mm/storage/cr:lvy	Lcom/tencent/mm/storagebase/h;
    //   2332: ldc 111
    //   2334: ldc_w 1194
    //   2337: aload 28
    //   2339: invokevirtual 1198	com/tencent/mm/storage/cq:convertTo	()Landroid/content/ContentValues;
    //   2342: invokevirtual 1202	com/tencent/mm/storagebase/h:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   2345: pop2
    //   2346: aload_0
    //   2347: getfield 1114	com/tencent/mm/kernel/f:kcK	Ljava/util/concurrent/ConcurrentHashMap;
    //   2350: ifnull +18 -> 2368
    //   2353: aload_2
    //   2354: ifnull +14 -> 2368
    //   2357: aload_0
    //   2358: getfield 1114	com/tencent/mm/kernel/f:kcK	Ljava/util/concurrent/ConcurrentHashMap;
    //   2361: aload 31
    //   2363: aload_2
    //   2364: invokevirtual 797	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2367: pop
    //   2368: goto -873 -> 1495
    //   2371: iconst_0
    //   2372: istore 26
    //   2374: goto -78 -> 2296
    //   2377: ldc 181
    //   2379: ldc_w 1204
    //   2382: iconst_3
    //   2383: anewarray 4	java/lang/Object
    //   2386: dup
    //   2387: iconst_0
    //   2388: aload 29
    //   2390: invokevirtual 1207	com/tencent/mm/compatible/util/f$a:avE	()J
    //   2393: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2396: aastore
    //   2397: dup
    //   2398: iconst_1
    //   2399: aload 29
    //   2401: invokevirtual 1207	com/tencent/mm/compatible/util/f$a:avE	()J
    //   2404: invokestatic 668	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2407: aastore
    //   2408: dup
    //   2409: iconst_2
    //   2410: iload_3
    //   2411: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2414: aastore
    //   2415: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2418: ldc_w 927
    //   2421: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2424: iconst_1
    //   2425: ireturn
    //   2426: astore 27
    //   2428: goto -1988 -> 440
    //   2431: aconst_null
    //   2432: astore_2
    //   2433: goto -506 -> 1927
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2436	0	this	f
    //   0	2436	1	paramf	com.tencent.mm.storagebase.f
    //   0	2436	2	paramHashMap	HashMap<Integer, h.b>
    //   11	2400	3	i	int
    //   176	2141	4	j	int
    //   1812	141	5	k	int
    //   102	1599	6	l1	long
    //   99	1297	8	l2	long
    //   106	1494	10	l3	long
    //   110	1494	12	l4	long
    //   114	1617	14	l5	long
    //   118	1598	16	l6	long
    //   744	248	18	l7	long
    //   740	248	20	l8	long
    //   96	1547	22	l9	long
    //   736	212	24	l10	long
    //   2294	79	26	bool	boolean
    //   310	33	27	str1	String
    //   438	50	27	localObject1	Object
    //   490	106	27	localException1	Exception
    //   630	827	27	localObject2	Object
    //   1573	58	27	localException2	Exception
    //   1681	647	27	localObject3	Object
    //   2426	1	27	localObject4	Object
    //   290	1	28	localObject5	Object
    //   427	19	28	localThrowable1	Throwable
    //   684	1654	28	localObject6	Object
    //   40	2360	29	localObject7	Object
    //   69	1437	30	localObject8	Object
    //   257	2105	31	localObject9	Object
    //   287	733	32	localObject10	Object
    //   1178	29	32	localThrowable2	Throwable
    //   1536	396	32	localb	h.b
    //   2137	94	32	localException3	Exception
    //   320	1835	33	localObject11	Object
    //   330	81	34	str2	String
    //   340	38	35	str3	String
    // Exception table:
    //   from	to	target	type
    //   292	386	427	java/lang/Throwable
    //   386	416	427	java/lang/Throwable
    //   416	424	427	java/lang/Throwable
    //   429	438	438	finally
    //   267	289	490	java/lang/Exception
    //   458	465	490	java/lang/Exception
    //   473	479	490	java/lang/Exception
    //   487	490	490	java/lang/Exception
    //   1019	1026	490	java/lang/Exception
    //   1188	1195	490	java/lang/Exception
    //   1206	1213	490	java/lang/Exception
    //   120	127	1029	finally
    //   143	152	1029	finally
    //   168	178	1029	finally
    //   194	234	1029	finally
    //   250	259	1029	finally
    //   267	289	1029	finally
    //   458	465	1029	finally
    //   473	479	1029	finally
    //   487	490	1029	finally
    //   508	526	1029	finally
    //   542	554	1029	finally
    //   570	604	1029	finally
    //   620	632	1029	finally
    //   648	658	1029	finally
    //   674	686	1029	finally
    //   702	717	1029	finally
    //   733	738	1029	finally
    //   762	785	1029	finally
    //   801	812	1029	finally
    //   828	853	1029	finally
    //   869	874	1029	finally
    //   898	926	1029	finally
    //   942	953	1029	finally
    //   969	983	1029	finally
    //   1019	1026	1029	finally
    //   1188	1195	1029	finally
    //   1206	1213	1029	finally
    //   1232	1240	1029	finally
    //   1256	1270	1029	finally
    //   1286	1319	1029	finally
    //   1583	1597	1029	finally
    //   1605	1639	1029	finally
    //   458	465	1178	java/lang/Throwable
    //   120	127	1573	java/lang/Exception
    //   143	152	1573	java/lang/Exception
    //   168	178	1573	java/lang/Exception
    //   194	234	1573	java/lang/Exception
    //   250	259	1573	java/lang/Exception
    //   508	526	1573	java/lang/Exception
    //   542	554	1573	java/lang/Exception
    //   570	604	1573	java/lang/Exception
    //   620	632	1573	java/lang/Exception
    //   648	658	1573	java/lang/Exception
    //   674	686	1573	java/lang/Exception
    //   702	717	1573	java/lang/Exception
    //   733	738	1573	java/lang/Exception
    //   762	785	1573	java/lang/Exception
    //   801	812	1573	java/lang/Exception
    //   828	853	1573	java/lang/Exception
    //   869	874	1573	java/lang/Exception
    //   898	926	1573	java/lang/Exception
    //   942	953	1573	java/lang/Exception
    //   969	983	1573	java/lang/Exception
    //   1232	1240	1573	java/lang/Exception
    //   1256	1270	1573	java/lang/Exception
    //   1286	1319	1573	java/lang/Exception
    //   1962	1968	2137	java/lang/Exception
    //   292	386	2426	finally
    //   386	416	2426	finally
    //   416	424	2426	finally
  }
  
  final void aHh()
  {
    AppMethodBeat.i(132080);
    this.kcH.i(14, Integer.valueOf(d.RAD));
    AppMethodBeat.o(132080);
  }
  
  final void aHi()
  {
    AppMethodBeat.i(132082);
    c.aHV().MU(this.kcB);
    q localq = new q(this.kcB + ".nomedia");
    if (!localq.ifE()) {
      try
      {
        localq.ifM();
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
  
  public final boolean aHj()
  {
    AppMethodBeat.i(132085);
    h.aHH();
    h.aHE().aGH();
    int i = Util.nullAsNil((Integer)this.kcH.b(89, null));
    if (i != 0)
    {
      Log.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: ".concat(String.valueOf(i)));
      AppMethodBeat.o(132085);
      return false;
    }
    if ((Util.nullAsNil((String)this.kcH.b(8195, null)).length() <= 0) || (Util.nullAsNil((Integer)this.kcH.b(15, null)) == 0)) {}
    for (boolean bool = true; (!bool) || (aHk() == null); bool = false)
    {
      this.kcH.i(89, Integer.valueOf(1));
      this.kcH.hxT();
      Log.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(132085);
      return false;
    }
    Log.i("MMKernel.CoreStorage", "isDBCorrupted: true");
    AppMethodBeat.o(132085);
    return true;
  }
  
  public final String aHk()
  {
    AppMethodBeat.i(132086);
    Object localObject1 = new q(this.cachePath + "/ctest", "EnMicroMsg.db");
    if (((q)localObject1).ifH())
    {
      localObject1 = ((q)localObject1).bOF();
      AppMethodBeat.o(132086);
      return localObject1;
    }
    localObject1 = new q(this.cachePath + "/corrupted", "EnMicroMsg.db");
    if (((q)localObject1).ifH())
    {
      localObject1 = ((q)localObject1).bOF();
      AppMethodBeat.o(132086);
      return localObject1;
    }
    String[] arrayOfString = new q(this.cachePath).a(new f.5(this));
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
  
  public final String aHl()
  {
    return this.cachePath;
  }
  
  public final String aHm()
  {
    AppMethodBeat.i(132089);
    String str = this.cachePath + "MicroMsg.db";
    AppMethodBeat.o(132089);
    return str;
  }
  
  public final String aHn()
  {
    AppMethodBeat.i(132090);
    String str = this.cachePath + "EnMicroMsg.db";
    AppMethodBeat.o(132090);
    return str;
  }
  
  public final ao aHp()
  {
    AppMethodBeat.i(132094);
    h.aHH();
    h.aHE().aGH();
    ao localao = this.kcH;
    AppMethodBeat.o(132094);
    return localao;
  }
  
  public final cl aHq()
  {
    AppMethodBeat.i(132095);
    h.aHH();
    h.aHE().aGH();
    cl localcl = this.kcI;
    AppMethodBeat.o(132095);
    return localcl;
  }
  
  public final void aHr()
  {
    AppMethodBeat.i(132096);
    this.kcR = Boolean.valueOf(isSDCardAvailable());
    AppMethodBeat.o(132096);
  }
  
  /* Error */
  public final void aHs()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 1284
    //   5: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 749	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   11: pop
    //   12: invokestatic 753	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
    //   15: getfield 1288	com/tencent/mm/kernel/b:kbC	[B
    //   18: astore 5
    //   20: aload 5
    //   22: monitorenter
    //   23: invokestatic 530	com/tencent/mm/compatible/util/e:avA	()Z
    //   26: istore_3
    //   27: invokestatic 172	com/tencent/mm/kernel/f:aHo	()Ljava/lang/String;
    //   30: astore 4
    //   32: ldc 181
    //   34: ldc_w 1290
    //   37: iconst_4
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: invokestatic 756	com/tencent/mm/kernel/b:getUin	()I
    //   46: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_0
    //   53: getfield 174	com/tencent/mm/kernel/f:kcA	Ljava/lang/String;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload 4
    //   61: aastore
    //   62: dup
    //   63: iconst_3
    //   64: invokestatic 753	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
    //   67: invokevirtual 1293	com/tencent/mm/kernel/b:aGM	()Z
    //   70: invokestatic 346	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aload 4
    //   79: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   82: ifne +269 -> 351
    //   85: aload 4
    //   87: aload_0
    //   88: getfield 174	com/tencent/mm/kernel/f:kcA	Ljava/lang/String;
    //   91: invokevirtual 573	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   94: istore_1
    //   95: iload_1
    //   96: ifeq +137 -> 233
    //   99: ldc 181
    //   101: new 219	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 1295
    //   108: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: invokestatic 1297	com/tencent/mm/kernel/f:aHt	()Z
    //   114: invokevirtual 523	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: ldc 181
    //   125: new 219	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1299
    //   132: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: invokestatic 1301	com/tencent/mm/kernel/f:aHu	()Z
    //   138: invokevirtual 523	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   141: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 5
    //   149: monitorexit
    //   150: ldc_w 1284
    //   153: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: astore 4
    //   159: ldc 181
    //   161: new 219	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 1303
    //   168: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload 4
    //   173: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 612	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -62 -> 123
    //   188: astore 4
    //   190: aload 5
    //   192: monitorexit
    //   193: ldc_w 1284
    //   196: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: ldc 181
    //   206: new 219	java/lang/StringBuilder
    //   209: dup
    //   210: ldc_w 1305
    //   213: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload 4
    //   218: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 612	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: goto -83 -> 147
    //   233: aload_0
    //   234: aload 4
    //   236: iload_3
    //   237: invokespecial 1307	com/tencent/mm/kernel/f:A	(Ljava/lang/String;Z)V
    //   240: iload_3
    //   241: ifeq +120 -> 361
    //   244: aload_0
    //   245: getfield 174	com/tencent/mm/kernel/f:kcA	Ljava/lang/String;
    //   248: invokestatic 210	com/tencent/mm/loader/j/b:aSF	()Ljava/lang/String;
    //   251: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   254: ifeq +107 -> 361
    //   257: iconst_1
    //   258: istore_1
    //   259: invokestatic 1313	com/tencent/mm/vfs/h:iWH	()Lcom/tencent/mm/vfs/h;
    //   262: invokevirtual 1317	com/tencent/mm/vfs/h:iWK	()Lcom/tencent/mm/vfs/h$a;
    //   265: astore 6
    //   267: aload_0
    //   268: getfield 215	com/tencent/mm/kernel/f:kcD	Ljava/lang/String;
    //   271: aload_0
    //   272: getfield 234	com/tencent/mm/kernel/f:kcC	Ljava/lang/String;
    //   275: invokevirtual 582	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +88 -> 366
    //   281: aload 6
    //   283: iload_1
    //   284: iload_2
    //   285: invokestatic 1322	com/tencent/mm/vfs/ab:a	(Lcom/tencent/mm/vfs/h$a;ZZ)Lcom/tencent/mm/vfs/h$a;
    //   288: pop
    //   289: aload 6
    //   291: aload_0
    //   292: getfield 174	com/tencent/mm/kernel/f:kcA	Ljava/lang/String;
    //   295: iload_1
    //   296: invokestatic 1325	com/tencent/mm/vfs/ab:a	(Lcom/tencent/mm/vfs/h$a;Ljava/lang/String;Z)Lcom/tencent/mm/vfs/h$a;
    //   299: pop
    //   300: iload_1
    //   301: ifeq +70 -> 371
    //   304: aload_0
    //   305: getfield 215	com/tencent/mm/kernel/f:kcD	Ljava/lang/String;
    //   308: astore 4
    //   310: aload 6
    //   312: ldc_w 1327
    //   315: aload 4
    //   317: invokevirtual 1333	com/tencent/mm/vfs/h$a:oj	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/vfs/h$a;
    //   320: invokevirtual 1336	com/tencent/mm/vfs/h$a:commit	()V
    //   323: invokestatic 1218	com/tencent/mm/kernel/a/c:aHV	()Lcom/tencent/mm/kernel/a/c;
    //   326: getfield 1340	com/tencent/mm/kernel/a/c:kdS	Lcom/tencent/mm/kernel/a/c$e;
    //   329: invokevirtual 1345	com/tencent/mm/kernel/a/c$e:aHQ	()V
    //   332: ldc 181
    //   334: ldc_w 1347
    //   337: iconst_1
    //   338: anewarray 4	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: iload_3
    //   344: invokestatic 346	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   347: aastore
    //   348: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload 5
    //   353: monitorexit
    //   354: ldc_w 1284
    //   357: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: return
    //   361: iconst_0
    //   362: istore_1
    //   363: goto -104 -> 259
    //   366: iconst_0
    //   367: istore_2
    //   368: goto -87 -> 281
    //   371: aload_0
    //   372: getfield 234	com/tencent/mm/kernel/f:kcC	Ljava/lang/String;
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
    //   265	46	6	locala	com.tencent.mm.vfs.h.a
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
  
  public final void b(h.a parama)
  {
    AppMethodBeat.i(193908);
    this.kcy.remove(parama);
    AppMethodBeat.o(193908);
  }
  
  public final String getAccPath()
  {
    return this.kcB;
  }
  
  public final com.tencent.mm.storagebase.h getDataDB()
  {
    return this.kcF;
  }
  
  public final boolean isSDCardAvailable()
  {
    AppMethodBeat.i(132098);
    boolean bool1 = this.kcA.startsWith(com.tencent.mm.loader.j.b.aSF());
    long l1 = Util.nowMilliSecond();
    long l2 = l1 - this.kcP;
    if (bool1)
    {
      h.aHH();
      if ((h.aHE().aGM()) && (l2 > 0L) && (l2 < 2000L) && (new q(this.kcA).ifE()))
      {
        AppMethodBeat.o(132098);
        return true;
      }
    }
    this.kcP = l1;
    boolean bool2 = com.tencent.mm.compatible.util.e.avA();
    h.aHH();
    h.aHE();
    Log.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", new Object[] { Boolean.valueOf(bool2), p.getString(b.getUin()), Long.valueOf(l2), this.kcA, com.tencent.mm.loader.j.b.aSF(), Boolean.valueOf(h.aHE().aGM()) });
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
    h.aHH();
    if (h.aHE().aGM())
    {
      Log.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
      aHs();
    }
    AppMethodBeat.o(132098);
    return true;
  }
  
  static final class b
    extends a<h.a>
    implements h.a
  {
    public final void aHw()
    {
      AppMethodBeat.i(132074);
      a(new a.a() {});
      AppMethodBeat.o(132074);
    }
    
    public final void aHx()
    {
      AppMethodBeat.i(132075);
      a(new a.a() {});
      AppMethodBeat.o(132075);
    }
    
    public final void aHy()
    {
      AppMethodBeat.i(132076);
      a(new a.a() {});
      AppMethodBeat.o(132076);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.f
 * JD-Core Version:    0.7.0.1
 */