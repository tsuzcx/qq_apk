package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import junit.framework.Assert;

public enum WxaPkgIntegrityChecker
{
  static
  {
    AppMethodBeat.i(90638);
    nHj = new WxaPkgIntegrityChecker[0];
    WxaPkgWrappingInfo.class.getClassLoader();
    j.KW("appbrandcommon");
    AppMethodBeat.o(90638);
  }
  
  public static Pair<a, WxaPkgWrappingInfo> D(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293017);
    paramString = e(paramString, paramInt1, paramInt2, null);
    AppMethodBeat.o(293017);
    return paramString;
  }
  
  public static String acX(String paramString)
  {
    AppMethodBeat.i(90635);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90635);
      return null;
    }
    paramString = n(new q(paramString));
    AppMethodBeat.o(90635);
    return paramString;
  }
  
  private static String checkFileMD5JNI(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(206735);
    String[] arrayOfString = new String[1];
    if (paramBoolean) {}
    for (int i = MD5JNI.getMD5String(u.n(paramq.bOF(), false), arrayOfString); i != 0; i = MD5JNI.getMD5StringLegacy(u.n(paramq.bOF(), false), arrayOfString))
    {
      paramq = new IOException("MD5JNI ret=".concat(String.valueOf(i)));
      AppMethodBeat.o(206735);
      throw paramq;
    }
    Assert.assertNotNull(arrayOfString[0]);
    paramq = arrayOfString[0];
    AppMethodBeat.o(206735);
    return paramq;
  }
  
  public static Pair<a, WxaPkgWrappingInfo> e(final String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(206728);
    if ((!h.aHE().kbT) || (h.ae(e.class) == null))
    {
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString1 = Pair.create(a.nHq, null);
      AppMethodBeat.o(206728);
      return paramString1;
    }
    Object localObject1 = ((e)h.ae(e.class)).n(paramString1, paramInt1, paramString2);
    Object localObject2 = new String[7];
    localObject2[0] = "pkgPath";
    localObject2[1] = "versionMd5";
    localObject2[2] = "NewMd5";
    localObject2[3] = "version";
    localObject2[4] = "createTime";
    localObject2[5] = "startTime";
    localObject2[6] = "endTime";
    if ((j.a.za(paramInt1)) && (paramInt2 > 0)) {
      paramString2 = (g)((s)localObject1).a(paramString1, paramInt2, paramInt1, (String[])localObject2);
    }
    while (paramString2 == null)
    {
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString1 = Pair.create(a.nHm, null);
      AppMethodBeat.o(206728);
      return paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString2 = (g)((s)localObject1).a(paramString1, paramInt1, paramString2, (String[])localObject2);
      } else {
        paramString2 = (g)((s)localObject1).a(paramString1, paramInt1, (String[])localObject2);
      }
    }
    if (paramInt1 == 999)
    {
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", new Object[] { Long.valueOf(paramString2.field_startTime), Long.valueOf(paramString2.field_endTime) });
      if ((paramString2.field_endTime > 0L) && (paramString2.field_endTime <= Util.nowSecond()))
      {
        paramString1 = Pair.create(a.nHn, null);
        AppMethodBeat.o(206728);
        return paramString1;
      }
    }
    localObject1 = paramString2.field_pkgPath;
    if (paramInt2 < 0) {}
    long l;
    for (int i = paramString2.field_version;; i = paramInt2)
    {
      l = paramString2.field_createTime;
      if ((!Util.isNullOrNil((String)localObject1)) && (u.agG((String)localObject1))) {
        break;
      }
      Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[] { localObject1, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(i) });
      paramString1 = Pair.create(a.nHp, null);
      AppMethodBeat.o(206728);
      return paramString1;
    }
    localObject2 = acX((String)localObject1);
    if (!new kotlin.g.a.b()
    {
      public final Boolean m(String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(206496);
        int j = paramAnonymousArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramAnonymousArrayOfString[i];
          if ((!TextUtils.isEmpty(str)) && (str.equals(this.nHk)))
          {
            paramAnonymousArrayOfString = Boolean.TRUE;
            AppMethodBeat.o(206496);
            return paramAnonymousArrayOfString;
          }
          i += 1;
        }
        Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { paramString1, org.apache.commons.b.g.a(paramAnonymousArrayOfString, ","), this.nHk });
        paramAnonymousArrayOfString = Boolean.FALSE;
        AppMethodBeat.o(206496);
        return paramAnonymousArrayOfString;
      }
    }.m(new String[] { paramString2.field_versionMd5, paramString2.field_NewMd5 }).booleanValue())
    {
      paramString1 = Pair.create(a.nHp, null);
      AppMethodBeat.o(206728);
      return paramString1;
    }
    paramString2 = new WxaPkgWrappingInfo();
    paramString2.pkgVersion = i;
    paramString2.nHZ = l;
    paramString2.pkgPath = ((String)localObject1);
    paramString2.nIa = false;
    paramString2.nHY = paramInt1;
    paramString2.md5 = ((String)localObject2);
    Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, return %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), paramString2 });
    paramString1 = Pair.create(a.nHl, paramString2);
    AppMethodBeat.o(206728);
    return paramString1;
  }
  
  public static Pair<a, WxaPkgWrappingInfo> hu(boolean paramBoolean)
  {
    AppMethodBeat.i(206721);
    Object localObject;
    if ((paramBoolean) && (bb.nGs != bb.a.nGw))
    {
      localObject = (e)h.ae(e.class);
      if (localObject != null)
      {
        localObject = ((e)localObject).bFb();
        if (localObject != null) {}
      }
      else
      {
        localObject = Pair.create(a.nHl, bb.bHm());
        AppMethodBeat.o(206721);
        return localObject;
      }
      i = ((bm)localObject).bp("@LibraryAppId", 0);
      if (("@LibraryAppId".equals("@LibraryAppId")) && ((i < 0) || (bb.VERSION >= i))) {
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[] { Integer.valueOf(bb.VERSION), "@LibraryAppId", Integer.valueOf(0), Integer.valueOf(i) });
      }
      for (localObject = bb.bHm(); localObject != null; localObject = null)
      {
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[] { Integer.valueOf(i), Integer.valueOf(bb.VERSION) });
        localObject = Pair.create(a.nHl, localObject);
        AppMethodBeat.o(206721);
        return localObject;
      }
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 999)
    {
      localObject = e("@LibraryAppId", i, -1, null);
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.TRUE, bb.nGs, ((Pair)localObject).first });
      AppMethodBeat.o(206721);
      return localObject;
    }
  }
  
  private static String n(q paramq)
  {
    AppMethodBeat.i(176908);
    long l = Util.currentTicks();
    boolean bool2 = openMD5JNICheck();
    boolean bool4 = openMD5JNINewImplCheck();
    boolean bool3 = bool2;
    try
    {
      if (paramq.ifE())
      {
        bool3 = bool2;
        if (!paramq.isDirectory()) {}
      }
      else
      {
        bool3 = bool2;
        Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] invalid", new Object[] { paramq.getName() });
        return null;
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool3 = bool2;
        try
        {
          String str1 = checkFileMD5JNI(paramq, bool4);
          Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b] openJNINewImpl[%b]", new Object[] { paramq.getName(), Float.valueOf((float)paramq.length() / 1024.0F), Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
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
      String str2 = o(paramq);
      return str2;
    }
    finally
    {
      Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b] openJNINewImpl[%b]", new Object[] { paramq.getName(), Float.valueOf((float)paramq.length() / 1024.0F), Long.valueOf(Util.currentTicks() - l), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
      AppMethodBeat.o(176908);
    }
  }
  
  /* Error */
  private static String o(q paramq)
  {
    // Byte code:
    //   0: ldc_w 387
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 391	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   10: astore_2
    //   11: aload_2
    //   12: sipush 16384
    //   15: invokestatic 397	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   18: astore_0
    //   19: aload_2
    //   20: ifnull +7 -> 27
    //   23: aload_2
    //   24: invokevirtual 402	java/io/InputStream:close	()V
    //   27: ldc_w 387
    //   30: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: astore_1
    //   36: ldc_w 387
    //   39: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    //   44: astore_0
    //   45: aload_2
    //   46: ifnull +11 -> 57
    //   49: aload_1
    //   50: ifnull +49 -> 99
    //   53: aload_2
    //   54: invokevirtual 402	java/io/InputStream:close	()V
    //   57: ldc_w 387
    //   60: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: athrow
    //   65: astore_0
    //   66: ldc 132
    //   68: ldc_w 404
    //   71: iconst_1
    //   72: anewarray 136	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload_0
    //   78: aastore
    //   79: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: ldc_w 387
    //   85: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_2
    //   91: aload_1
    //   92: aload_2
    //   93: invokevirtual 408	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   96: goto -39 -> 57
    //   99: aload_2
    //   100: invokevirtual 402	java/io/InputStream:close	()V
    //   103: goto -46 -> 57
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -64 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramq	q
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
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEw, true);
    AppMethodBeat.o(90634);
    return bool;
  }
  
  private static boolean openMD5JNINewImplCheck()
  {
    AppMethodBeat.i(206733);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEx, 1) == 1)
    {
      AppMethodBeat.o(206733);
      return true;
    }
    AppMethodBeat.o(206733);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(90627);
      nHl = new a("APP_READY", 0);
      nHm = new a("APP_MANIFEST_NULL", 1);
      nHn = new a("PKG_EXPIRED", 2);
      nHo = new a("APP_NOT_INSTALLED", 3);
      nHp = new a("APP_BROKEN", 4);
      nHq = new a("ENV_ERR", 5);
      nHr = new a[] { nHl, nHm, nHn, nHo, nHp, nHq };
      AppMethodBeat.o(90627);
    }
    
    private a() {}
    
    public final int bHC()
    {
      AppMethodBeat.i(90626);
      int i = super.ordinal();
      AppMethodBeat.o(90626);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker
 * JD-Core Version:    0.7.0.1
 */