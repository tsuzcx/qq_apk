package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import junit.framework.Assert;

public enum WxaPkgIntegrityChecker
{
  static
  {
    AppMethodBeat.i(90638);
    qGW = new WxaPkgIntegrityChecker[0];
    WxaPkgWrappingInfo.class.getClassLoader();
    k.DA("appbrandcommon");
    AppMethodBeat.o(90638);
  }
  
  public static Pair<a, WxaPkgWrappingInfo> H(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(370015);
    paramString = e(paramString, paramInt1, paramInt2, null);
    AppMethodBeat.o(370015);
    return paramString;
  }
  
  public static String Vu(String paramString)
  {
    AppMethodBeat.i(90635);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90635);
      return null;
    }
    paramString = n(new com.tencent.mm.vfs.u(paramString));
    AppMethodBeat.o(90635);
    return paramString;
  }
  
  private static String checkFileMD5JNI(com.tencent.mm.vfs.u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(320370);
    String[] arrayOfString = new String[1];
    if (paramBoolean) {}
    for (int i = MD5JNI.getMD5String(y.n(ah.v(paramu.jKT()), false), arrayOfString); i != 0; i = MD5JNI.getMD5StringLegacy(y.n(ah.v(paramu.jKT()), false), arrayOfString))
    {
      paramu = new IOException("MD5JNI ret=".concat(String.valueOf(i)));
      AppMethodBeat.o(320370);
      throw paramu;
    }
    Assert.assertNotNull(arrayOfString[0]);
    paramu = arrayOfString[0];
    AppMethodBeat.o(320370);
    return paramu;
  }
  
  public static Pair<a, WxaPkgWrappingInfo> e(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(320361);
    if ((!h.baC().mBZ) || (h.ax(e.class) == null))
    {
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString1 = Pair.create(a.qHd, null);
      AppMethodBeat.o(320361);
      return paramString1;
    }
    Object localObject1 = ((e)h.ax(e.class)).p(paramString1, paramInt1, paramString2);
    Object localObject2 = new String[7];
    localObject2[0] = "pkgPath";
    localObject2[1] = "versionMd5";
    localObject2[2] = "NewMd5";
    localObject2[3] = "version";
    localObject2[4] = "createTime";
    localObject2[5] = "startTime";
    localObject2[6] = "endTime";
    if ((k.a.zn(paramInt1)) && (paramInt2 > 0)) {
      paramString2 = (g)((u)localObject1).a(paramString1, paramInt2, paramInt1, (String[])localObject2);
    }
    while (paramString2 == null)
    {
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString1 = Pair.create(a.qGZ, null);
      AppMethodBeat.o(320361);
      return paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString2 = (g)((u)localObject1).a(paramString1, paramInt1, paramString2, (String[])localObject2);
      } else {
        paramString2 = (g)((u)localObject1).a(paramString1, paramInt1, (String[])localObject2);
      }
    }
    if (paramInt1 == 999)
    {
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", new Object[] { Long.valueOf(paramString2.field_startTime), Long.valueOf(paramString2.field_endTime) });
      if ((paramString2.field_endTime > 0L) && (paramString2.field_endTime <= Util.nowSecond()))
      {
        paramString1 = Pair.create(a.qHa, null);
        AppMethodBeat.o(320361);
        return paramString1;
      }
    }
    localObject1 = paramString2.field_pkgPath;
    if (paramInt2 < 0) {}
    long l;
    for (int i = paramString2.field_version;; i = paramInt2)
    {
      l = paramString2.field_createTime;
      if ((!Util.isNullOrNil((String)localObject1)) && (y.ZC((String)localObject1))) {
        break;
      }
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[] { localObject1, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(i) });
      paramString1 = Pair.create(a.qHc, null);
      AppMethodBeat.o(320361);
      return paramString1;
    }
    localObject2 = Vu((String)localObject1);
    if (!new WxaPkgIntegrityChecker.1((String)localObject2, paramString1).m(new String[] { paramString2.field_versionMd5, paramString2.field_NewMd5 }).booleanValue())
    {
      paramString1 = Pair.create(a.qHc, null);
      AppMethodBeat.o(320361);
      return paramString1;
    }
    paramString2 = new WxaPkgWrappingInfo();
    paramString2.pkgVersion = i;
    paramString2.qHP = l;
    paramString2.pkgPath = ((String)localObject1);
    paramString2.qHQ = false;
    paramString2.qHO = paramInt1;
    paramString2.md5 = ((String)localObject2);
    Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, return %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), paramString2 });
    paramString1 = Pair.create(a.qGY, paramString2);
    AppMethodBeat.o(320361);
    return paramString1;
  }
  
  public static Pair<a, WxaPkgWrappingInfo> il(boolean paramBoolean)
  {
    AppMethodBeat.i(320354);
    Object localObject;
    if ((paramBoolean) && (bc.qGl != bc.a.qGo))
    {
      localObject = (e)h.ax(e.class);
      if (localObject != null)
      {
        localObject = ((e)localObject).ceo();
        if (localObject != null) {}
      }
      else
      {
        localObject = Pair.create(a.qGY, bc.cgJ());
        AppMethodBeat.o(320354);
        return localObject;
      }
      i = ((bm)localObject).bG("@LibraryAppId", 0);
      if (("@LibraryAppId".equals("@LibraryAppId")) && ((i < 0) || (bc.VERSION >= i))) {
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[] { Integer.valueOf(bc.VERSION), "@LibraryAppId", Integer.valueOf(0), Integer.valueOf(i) });
      }
      for (localObject = bc.cgJ(); localObject != null; localObject = null)
      {
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[] { Integer.valueOf(i), Integer.valueOf(bc.VERSION) });
        localObject = Pair.create(a.qGY, localObject);
        AppMethodBeat.o(320354);
        return localObject;
      }
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 999)
    {
      localObject = e("@LibraryAppId", i, -1, null);
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.TRUE, bc.qGl, ((Pair)localObject).first });
      AppMethodBeat.o(320354);
      return localObject;
    }
  }
  
  private static String n(com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(176908);
    long l = Util.currentTicks();
    boolean bool2 = openMD5JNICheck();
    boolean bool4 = openMD5JNINewImplCheck();
    boolean bool3 = bool2;
    try
    {
      if (paramu.jKS())
      {
        bool3 = bool2;
        if (!paramu.isDirectory()) {}
      }
      else
      {
        bool3 = bool2;
        Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] invalid", new Object[] { paramu.getName() });
        return null;
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool3 = bool2;
        try
        {
          String str1 = checkFileMD5JNI(paramu, bool4);
          Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b] openJNINewImpl[%b]", new Object[] { paramu.getName(), Float.valueOf((float)paramu.length() / 1024.0F), Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
          AppMethodBeat.o(176908);
          return str1;
        }
        catch (IOException localIOException)
        {
          bool3 = bool2;
          Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] JNI exception = %s", new Object[] { localIOException });
          bool1 = false;
        }
      }
      bool3 = bool1;
      String str2 = o(paramu);
      return str2;
    }
    finally
    {
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b] openJNINewImpl[%b]", new Object[] { paramu.getName(), Float.valueOf((float)paramu.length() / 1024.0F), Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      AppMethodBeat.o(176908);
    }
  }
  
  /* Error */
  private static String o(com.tencent.mm.vfs.u paramu)
  {
    // Byte code:
    //   0: ldc_w 393
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 397	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: aload_0
    //   12: sipush 16384
    //   15: invokestatic 402	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: ifnull +7 -> 27
    //   23: aload_0
    //   24: invokevirtual 407	java/io/InputStream:close	()V
    //   27: ldc_w 393
    //   30: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: aload_0
    //   37: ifnull +7 -> 44
    //   40: aload_0
    //   41: invokevirtual 407	java/io/InputStream:close	()V
    //   44: ldc_w 393
    //   47: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_1
    //   51: athrow
    //   52: astore_0
    //   53: ldc 136
    //   55: ldc_w 409
    //   58: iconst_1
    //   59: anewarray 140	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: aastore
    //   66: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: ldc_w 393
    //   72: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aload_1
    //   79: aload_0
    //   80: invokevirtual 415	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   83: goto -39 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramu	com.tencent.mm.vfs.u
    //   18	16	1	str	String
    //   35	44	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	19	35	finally
    //   6	11	52	java/io/IOException
    //   23	27	52	java/io/IOException
    //   44	52	52	java/io/IOException
    //   78	83	52	java/io/IOException
    //   40	44	77	finally
  }
  
  private static boolean openMD5JNICheck()
  {
    AppMethodBeat.i(90634);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yTL, true);
    AppMethodBeat.o(90634);
    return bool;
  }
  
  private static boolean openMD5JNINewImplCheck()
  {
    AppMethodBeat.i(320365);
    if (((c)h.ax(c.class)).a(c.a.yTM, 1) == 1)
    {
      AppMethodBeat.o(320365);
      return true;
    }
    AppMethodBeat.o(320365);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(90627);
      qGY = new a("APP_READY", 0);
      qGZ = new a("APP_MANIFEST_NULL", 1);
      qHa = new a("PKG_EXPIRED", 2);
      qHb = new a("APP_NOT_INSTALLED", 3);
      qHc = new a("APP_BROKEN", 4);
      qHd = new a("ENV_ERR", 5);
      qHe = new a[] { qGY, qGZ, qHa, qHb, qHc, qHd };
      AppMethodBeat.o(90627);
    }
    
    private a() {}
    
    public final int cgZ()
    {
      AppMethodBeat.i(90626);
      int i = super.ordinal();
      AppMethodBeat.o(90626);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker
 * JD-Core Version:    0.7.0.1
 */