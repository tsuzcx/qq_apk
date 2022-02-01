package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.IOException;

public enum WxaPkgIntegrityChecker
{
  static
  {
    AppMethodBeat.i(90638);
    iOf = new WxaPkgIntegrityChecker[0];
    WxaPkgWrappingInfo.class.getClassLoader();
    j.pq("appbrandcommon");
    AppMethodBeat.o(90638);
  }
  
  public static Pair<a, WxaPkgWrappingInfo> C(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90633);
    if ((!g.afz().gcn) || (((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk() == null))
    {
      ad.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(a.iOl, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    Object localObject1 = new String[6];
    localObject1[0] = "pkgPath";
    localObject1[1] = "versionMd5";
    localObject1[2] = "version";
    localObject1[3] = "createTime";
    localObject1[4] = "startTime";
    localObject1[5] = "endTime";
    if ((j.a.qD(paramInt1)) && (paramInt2 > 0)) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(paramString, paramInt2, paramInt1, (String[])localObject1); localObject1 == null; localObject1 = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(paramString, paramInt1, (String[])localObject1))
    {
      ad.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(a.iOh, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    if (paramInt1 == 999)
    {
      ad.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", new Object[] { Long.valueOf(((bb)localObject1).field_startTime), Long.valueOf(((bb)localObject1).field_endTime) });
      if ((((bb)localObject1).field_endTime > 0L) && (((bb)localObject1).field_endTime <= bt.aGK()))
      {
        paramString = Pair.create(a.iOi, null);
        AppMethodBeat.o(90633);
        return paramString;
      }
    }
    String str1 = ((bb)localObject1).field_pkgPath;
    Object localObject2 = ((bb)localObject1).field_versionMd5;
    if (paramInt2 < 0) {}
    long l;
    for (int i = ((bb)localObject1).field_version;; i = paramInt2)
    {
      l = ((bb)localObject1).field_createTime;
      if ((!bt.isNullOrNil(str1)) && (i.eK(str1))) {
        break;
      }
      ad.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[] { str1, paramString, Integer.valueOf(paramInt1), Integer.valueOf(i) });
      paramString = Pair.create(a.iOk, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    String str2 = Eg(str1);
    if ((!bt.isNullOrNil((String)localObject2)) && (!((String)localObject2).equals(str2)))
    {
      ad.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", new Object[] { str2, localObject2, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(a.iOk, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    localObject2 = new WxaPkgWrappingInfo();
    ((WxaPkgWrappingInfo)localObject2).pkgVersion = i;
    ((WxaPkgWrappingInfo)localObject2).iOR = l;
    ((WxaPkgWrappingInfo)localObject2).pkgPath = str1;
    ((WxaPkgWrappingInfo)localObject2).iOS = false;
    ((WxaPkgWrappingInfo)localObject2).iOQ = paramInt1;
    ((WxaPkgWrappingInfo)localObject2).md5 = str2;
    ad.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(((bb)localObject1).field_startTime), Long.valueOf(((bb)localObject1).field_endTime), localObject2 });
    paramString = Pair.create(a.iOg, localObject2);
    AppMethodBeat.o(90633);
    return paramString;
  }
  
  public static String Eg(String paramString)
  {
    AppMethodBeat.i(90635);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90635);
      return null;
    }
    paramString = o(new com.tencent.mm.vfs.e(paramString));
    AppMethodBeat.o(90635);
    return paramString;
  }
  
  private static WxaPkgWrappingInfo aG(String paramString, int paramInt)
  {
    AppMethodBeat.i(90630);
    if (("@LibraryAppId".equals(paramString)) && ((paramInt < 0) || (aw.VERSION >= paramInt)))
    {
      ad.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[] { Integer.valueOf(aw.VERSION), paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      paramString = aw.aQd();
      AppMethodBeat.o(90630);
      return paramString;
    }
    AppMethodBeat.o(90630);
    return null;
  }
  
  private static String checkFileMD5JNI(com.tencent.mm.vfs.e parame)
  {
    AppMethodBeat.i(176910);
    String[] arrayOfString = new String[1];
    int i = MD5JNI.getMD5String(i.k(q.B(parame.fhU()), false), arrayOfString);
    if (i == 0)
    {
      parame = arrayOfString[0];
      AppMethodBeat.o(176910);
      return parame;
    }
    parame = new IOException("MD5JNI ret=".concat(String.valueOf(i)));
    AppMethodBeat.o(176910);
    throw parame;
  }
  
  public static Pair<a, WxaPkgWrappingInfo> fo(boolean paramBoolean)
  {
    AppMethodBeat.i(90631);
    Pair localPair = q(paramBoolean, false);
    AppMethodBeat.o(90631);
    return localPair;
  }
  
  private static String o(com.tencent.mm.vfs.e parame)
  {
    AppMethodBeat.i(176908);
    long l = bt.GC();
    boolean bool2 = openMD5JNICheck();
    boolean bool3 = bool2;
    try
    {
      if (parame.exists())
      {
        bool3 = bool2;
        if (!parame.isDirectory()) {}
      }
      else
      {
        bool3 = bool2;
        ad.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] invalid", new Object[] { parame.getName() });
        return null;
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool3 = bool2;
        try
        {
          String str1 = checkFileMD5JNI(parame);
          ad.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", new Object[] { parame.getName(), Float.valueOf((float)parame.length() / 1024.0F), Long.valueOf(bt.GC() - l), Boolean.valueOf(bool2) });
          AppMethodBeat.o(176908);
          return str1;
        }
        catch (IOException localIOException)
        {
          bool3 = bool2;
          ad.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] JNI exception = %s", new Object[] { localIOException });
          bool1 = false;
        }
      }
      bool3 = bool1;
      String str2 = p(parame);
      return str2;
    }
    finally
    {
      ad.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", new Object[] { parame.getName(), Float.valueOf((float)parame.length() / 1024.0F), Long.valueOf(bt.GC() - l), Boolean.valueOf(bool3) });
      AppMethodBeat.o(176908);
    }
  }
  
  private static boolean openMD5JNICheck()
  {
    AppMethodBeat.i(90634);
    boolean bool = ((b)g.ab(b.class)).a(b.a.ppd, true);
    AppMethodBeat.o(90634);
    return bool;
  }
  
  /* Error */
  private static String p(com.tencent.mm.vfs.e parame)
  {
    // Byte code:
    //   0: ldc_w 348
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 352	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   10: astore_2
    //   11: aload_2
    //   12: sipush 16384
    //   15: invokestatic 358	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   18: astore_0
    //   19: aload_2
    //   20: ifnull +7 -> 27
    //   23: aload_2
    //   24: invokevirtual 363	java/io/InputStream:close	()V
    //   27: ldc_w 348
    //   30: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: astore_1
    //   36: ldc_w 348
    //   39: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    //   44: astore_0
    //   45: aload_2
    //   46: ifnull +11 -> 57
    //   49: aload_1
    //   50: ifnull +49 -> 99
    //   53: aload_2
    //   54: invokevirtual 363	java/io/InputStream:close	()V
    //   57: ldc_w 348
    //   60: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: ldc 68
    //   68: ldc_w 365
    //   71: iconst_1
    //   72: anewarray 72	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: ldc_w 348
    //   85: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_2
    //   91: aload_1
    //   92: aload_2
    //   93: invokevirtual 369	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   96: goto -39 -> 57
    //   99: aload_2
    //   100: invokevirtual 363	java/io/InputStream:close	()V
    //   103: goto -46 -> 57
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -64 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	parame	com.tencent.mm.vfs.e
    //   35	57	1	localThrowable1	java.lang.Throwable
    //   108	1	1	localObject	Object
    //   10	44	2	localInputStream	java.io.InputStream
    //   90	10	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   11	19	35	java/lang/Throwable
    //   36	44	44	finally
    //   6	11	65	java/io/IOException
    //   23	27	65	java/io/IOException
    //   53	57	65	java/io/IOException
    //   57	65	65	java/io/IOException
    //   91	96	65	java/io/IOException
    //   99	103	65	java/io/IOException
    //   53	57	90	java/lang/Throwable
    //   11	19	106	finally
  }
  
  public static Pair<a, WxaPkgWrappingInfo> q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(90632);
    Object localObject;
    if ((paramBoolean1) && ((!paramBoolean2) || (aw.iNt != aw.a.iNx)))
    {
      localObject = (com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.a.e)localObject).aOk();
        if (localObject != null) {}
      }
      else
      {
        localObject = Pair.create(a.iOg, aw.aQd());
        AppMethodBeat.o(90632);
        return localObject;
      }
      i = ((bf)localObject).aK("@LibraryAppId", 0);
      localObject = aG("@LibraryAppId", i);
      if (localObject != null)
      {
        ad.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[] { Integer.valueOf(i), Integer.valueOf(aw.VERSION) });
        localObject = Pair.create(a.iOg, localObject);
        AppMethodBeat.o(90632);
        return localObject;
      }
    }
    if (paramBoolean1) {}
    for (int i = 0;; i = 999)
    {
      localObject = C("@LibraryAppId", i, -1);
      ad.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), aw.iNt, ((Pair)localObject).first });
      AppMethodBeat.o(90632);
      return localObject;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(90627);
      iOg = new a("APP_READY", 0);
      iOh = new a("APP_MANIFEST_NULL", 1);
      iOi = new a("PKG_EXPIRED", 2);
      iOj = new a("APP_NOT_INSTALLED", 3);
      iOk = new a("APP_BROKEN", 4);
      iOl = new a("ENV_ERR", 5);
      iOm = new a[] { iOg, iOh, iOi, iOj, iOk, iOl };
      AppMethodBeat.o(90627);
    }
    
    private a() {}
    
    public final int aQs()
    {
      AppMethodBeat.i(90626);
      int i = super.ordinal();
      AppMethodBeat.o(90626);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker
 * JD-Core Version:    0.7.0.1
 */