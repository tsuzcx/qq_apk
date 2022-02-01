package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public enum WxaPkgIntegrityChecker
{
  static
  {
    AppMethodBeat.i(90638);
    kNj = new WxaPkgIntegrityChecker[0];
    WxaPkgWrappingInfo.class.getClassLoader();
    j.Ed("appbrandcommon");
    AppMethodBeat.o(90638);
  }
  
  public static Pair<a, WxaPkgWrappingInfo> D(final String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90633);
    if ((!com.tencent.mm.kernel.g.aAf().hpY) || (((e)com.tencent.mm.kernel.g.af(e.class)).bub() == null))
    {
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(a.kNq, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    Object localObject = new String[7];
    localObject[0] = "pkgPath";
    localObject[1] = "versionMd5";
    localObject[2] = "NewMd5";
    localObject[3] = "version";
    localObject[4] = "createTime";
    localObject[5] = "startTime";
    localObject[6] = "endTime";
    if ((j.a.vP(paramInt1)) && (paramInt2 > 0)) {}
    for (localObject = ((e)com.tencent.mm.kernel.g.af(e.class)).bub().a(paramString, paramInt2, paramInt1, (String[])localObject); localObject == null; localObject = ((e)com.tencent.mm.kernel.g.af(e.class)).bub().a(paramString, paramInt1, (String[])localObject))
    {
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(a.kNm, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    if (paramInt1 == 999)
    {
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", new Object[] { Long.valueOf(((bd)localObject).field_startTime), Long.valueOf(((bd)localObject).field_endTime) });
      if ((((bd)localObject).field_endTime > 0L) && (((bd)localObject).field_endTime <= Util.nowSecond()))
      {
        paramString = Pair.create(a.kNn, null);
        AppMethodBeat.o(90633);
        return paramString;
      }
    }
    String str1 = ((bd)localObject).field_pkgPath;
    if (paramInt2 < 0) {}
    long l;
    for (int i = ((bd)localObject).field_version;; i = paramInt2)
    {
      l = ((bd)localObject).field_createTime;
      if ((!Util.isNullOrNil(str1)) && (s.YS(str1))) {
        break;
      }
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[] { str1, paramString, Integer.valueOf(paramInt1), Integer.valueOf(i) });
      paramString = Pair.create(a.kNp, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    String str2 = Vn(str1);
    if (!new kotlin.g.a.b()
    {
      public final Boolean n(String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(230562);
        int j = paramAnonymousArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramAnonymousArrayOfString[i];
          if ((!TextUtils.isEmpty(str)) && (str.equals(this.kNk)))
          {
            paramAnonymousArrayOfString = Boolean.TRUE;
            AppMethodBeat.o(230562);
            return paramAnonymousArrayOfString;
          }
          i += 1;
        }
        Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { paramString, org.apache.commons.b.g.a(paramAnonymousArrayOfString, ","), this.kNk });
        paramAnonymousArrayOfString = Boolean.FALSE;
        AppMethodBeat.o(230562);
        return paramAnonymousArrayOfString;
      }
    }.n(new String[] { ((bd)localObject).field_versionMd5, ((bd)localObject).field_NewMd5 }).booleanValue())
    {
      paramString = Pair.create(a.kNp, null);
      AppMethodBeat.o(90633);
      return paramString;
    }
    localObject = new WxaPkgWrappingInfo();
    ((WxaPkgWrappingInfo)localObject).pkgVersion = i;
    ((WxaPkgWrappingInfo)localObject).kNX = l;
    ((WxaPkgWrappingInfo)localObject).pkgPath = str1;
    ((WxaPkgWrappingInfo)localObject).kNY = false;
    ((WxaPkgWrappingInfo)localObject).kNW = paramInt1;
    ((WxaPkgWrappingInfo)localObject).md5 = str2;
    Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, return %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), localObject });
    paramString = Pair.create(a.kNl, localObject);
    AppMethodBeat.o(90633);
    return paramString;
  }
  
  public static String Vn(String paramString)
  {
    AppMethodBeat.i(90635);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90635);
      return null;
    }
    paramString = n(new o(paramString));
    AppMethodBeat.o(90635);
    return paramString;
  }
  
  private static WxaPkgWrappingInfo aU(String paramString, int paramInt)
  {
    AppMethodBeat.i(90630);
    if (("@LibraryAppId".equals(paramString)) && ((paramInt < 0) || (ay.VERSION >= paramInt)))
    {
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[] { Integer.valueOf(ay.VERSION), paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      paramString = ay.bwf();
      AppMethodBeat.o(90630);
      return paramString;
    }
    AppMethodBeat.o(90630);
    return null;
  }
  
  private static String checkFileMD5JNI(o paramo)
  {
    AppMethodBeat.i(176910);
    String[] arrayOfString = new String[1];
    int i = MD5JNI.getMD5String(s.k(aa.z(paramo.her()), false), arrayOfString);
    if (i == 0)
    {
      paramo = arrayOfString[0];
      AppMethodBeat.o(176910);
      return paramo;
    }
    paramo = new IOException("MD5JNI ret=".concat(String.valueOf(i)));
    AppMethodBeat.o(176910);
    throw paramo;
  }
  
  public static Pair<a, WxaPkgWrappingInfo> gJ(boolean paramBoolean)
  {
    AppMethodBeat.i(90631);
    Pair localPair = r(paramBoolean, false);
    AppMethodBeat.o(90631);
    return localPair;
  }
  
  private static String n(o paramo)
  {
    AppMethodBeat.i(176908);
    long l = Util.currentTicks();
    boolean bool2 = openMD5JNICheck();
    boolean bool3 = bool2;
    try
    {
      if (paramo.exists())
      {
        bool3 = bool2;
        if (!paramo.isDirectory()) {}
      }
      else
      {
        bool3 = bool2;
        Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] invalid", new Object[] { paramo.getName() });
        return null;
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool3 = bool2;
        try
        {
          String str1 = checkFileMD5JNI(paramo);
          Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", new Object[] { paramo.getName(), Float.valueOf((float)paramo.length() / 1024.0F), Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool2) });
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
      String str2 = o(paramo);
      return str2;
    }
    finally
    {
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", new Object[] { paramo.getName(), Float.valueOf((float)paramo.length() / 1024.0F), Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool3) });
      AppMethodBeat.o(176908);
    }
  }
  
  /* Error */
  private static String o(o paramo)
  {
    // Byte code:
    //   0: ldc_w 350
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 354	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   10: astore_2
    //   11: aload_2
    //   12: sipush 16384
    //   15: invokestatic 360	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   18: astore_0
    //   19: aload_2
    //   20: ifnull +7 -> 27
    //   23: aload_2
    //   24: invokevirtual 365	java/io/InputStream:close	()V
    //   27: ldc_w 350
    //   30: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: astore_1
    //   36: ldc_w 350
    //   39: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    //   44: astore_0
    //   45: aload_2
    //   46: ifnull +11 -> 57
    //   49: aload_1
    //   50: ifnull +49 -> 99
    //   53: aload_2
    //   54: invokevirtual 365	java/io/InputStream:close	()V
    //   57: ldc_w 350
    //   60: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: ldc 70
    //   68: ldc_w 367
    //   71: iconst_1
    //   72: anewarray 74	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: ldc_w 350
    //   85: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_2
    //   91: aload_1
    //   92: aload_2
    //   93: invokevirtual 371	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   96: goto -39 -> 57
    //   99: aload_2
    //   100: invokevirtual 365	java/io/InputStream:close	()V
    //   103: goto -46 -> 57
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -64 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramo	o
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
  
  private static boolean openMD5JNICheck()
  {
    AppMethodBeat.i(90634);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXF, true);
    AppMethodBeat.o(90634);
    return bool;
  }
  
  public static Pair<a, WxaPkgWrappingInfo> r(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(90632);
    Object localObject;
    if ((paramBoolean1) && ((!paramBoolean2) || (ay.kMy != ay.a.kMC)))
    {
      localObject = (e)com.tencent.mm.kernel.g.af(e.class);
      if (localObject != null)
      {
        localObject = ((e)localObject).bub();
        if (localObject != null) {}
      }
      else
      {
        localObject = Pair.create(a.kNl, ay.bwf());
        AppMethodBeat.o(90632);
        return localObject;
      }
      i = ((bh)localObject).aY("@LibraryAppId", 0);
      localObject = aU("@LibraryAppId", i);
      if (localObject != null)
      {
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[] { Integer.valueOf(i), Integer.valueOf(ay.VERSION) });
        localObject = Pair.create(a.kNl, localObject);
        AppMethodBeat.o(90632);
        return localObject;
      }
    }
    if (paramBoolean1) {}
    for (int i = 0;; i = 999)
    {
      localObject = D("@LibraryAppId", i, -1);
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), ay.kMy, ((Pair)localObject).first });
      AppMethodBeat.o(90632);
      return localObject;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(90627);
      kNl = new a("APP_READY", 0);
      kNm = new a("APP_MANIFEST_NULL", 1);
      kNn = new a("PKG_EXPIRED", 2);
      kNo = new a("APP_NOT_INSTALLED", 3);
      kNp = new a("APP_BROKEN", 4);
      kNq = new a("ENV_ERR", 5);
      kNr = new a[] { kNl, kNm, kNn, kNo, kNp, kNq };
      AppMethodBeat.o(90627);
    }
    
    private a() {}
    
    public final int bwv()
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