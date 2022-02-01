package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class m
{
  private static WxaPkgWrappingInfo C(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(174935);
    if ((!bt.isNullOrNil(paramString2)) && (paramString2.endsWith("__PLUGINCODE__"))) {}
    for (paramString1 = WxaPkgWrappingInfo.Es(paramString1); paramString1 == null; paramString1 = WxaPkgWrappingInfo.Er(paramString1))
    {
      AppMethodBeat.o(174935);
      return null;
    }
    paramString1.pkgVersion = paramInt;
    AppMethodBeat.o(174935);
    return paramString1;
  }
  
  public static WxaPkgWrappingInfo Kg(String paramString)
  {
    AppMethodBeat.i(205042);
    paramString = bD(paramString, 1);
    AppMethodBeat.o(205042);
    return paramString;
  }
  
  static int Kh(String paramString)
  {
    AppMethodBeat.i(196003);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = bD(paramString, 1);
      if (paramString != null)
      {
        int i = paramString.pkgVersion;
        AppMethodBeat.o(196003);
        return i;
      }
    }
    AppMethodBeat.o(196003);
    return 0;
  }
  
  static bb a(ab paramab, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(47160);
    Object localObject1 = j.aOK();
    if ((paramab == null) || (bt.isNullOrNil(paramString))) {
      paramab = null;
    }
    while (paramab != null)
    {
      paramab = paramab.iterator();
      do
      {
        if (!paramab.hasNext()) {
          break;
        }
        localObject1 = (bb)paramab.next();
      } while ((((bb)localObject1).field_version == paramInt2) || (!paramString.equals(((bb)localObject1).field_versionMd5)) || (!paramString.equals(WxaPkgIntegrityChecker.Eg(((bb)localObject1).field_pkgPath))));
      AppMethodBeat.o(47160);
      return localObject1;
      Object localObject2 = String.format(Locale.US, "select * from %s where %s=? and %s=? and %s=? order by %s desc", new Object[] { "AppBrandWxaPkgManifestRecord", "appId", "debugType", "versionMd5", "version" });
      localObject1 = ((bf)localObject1).iOE.rawQuery((String)localObject2, new String[] { paramab.toString(), String.valueOf(paramInt1), paramString });
      if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
      {
        paramab = null;
      }
      else if (!((Cursor)localObject1).moveToFirst())
      {
        ((Cursor)localObject1).close();
        paramab = null;
      }
      else
      {
        paramab = new LinkedList();
        do
        {
          localObject2 = new bb();
          ((bb)localObject2).convertFrom((Cursor)localObject1);
          paramab.add(localObject2);
        } while (((Cursor)localObject1).moveToNext());
        ((Cursor)localObject1).close();
      }
    }
    AppMethodBeat.o(47160);
    return null;
  }
  
  static WxaPkgWrappingInfo b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174934);
    ab localab = new ab(paramString1, paramString2, paramInt1);
    ad.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "multiPkg findPkgInfoAvailable pkgQueryKey:%s,codeType:%d", new Object[] { localab, Integer.valueOf(paramInt3) });
    if (j.a.qD(paramInt3))
    {
      Object localObject = j.aOK();
      if (localObject == null)
      {
        AppMethodBeat.o(174934);
        return null;
      }
      localObject = ((bf)localObject).a(localab.toString(), paramInt2, paramInt3, new String[0]);
      if (localObject == null)
      {
        AppMethodBeat.o(174934);
        return null;
      }
      if (bt.isNullOrNil(((bb)localObject).field_versionMd5))
      {
        AppMethodBeat.o(174934);
        return null;
      }
      if (((bb)localObject).field_versionMd5.equals(WxaPkgIntegrityChecker.Eg(((bb)localObject).field_pkgPath)))
      {
        ad.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "appid:%s release already exist modulename:%s,codeType:%d,desirePkgVersion:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
        paramString1 = C(((bb)localObject).field_pkgPath, paramString2, paramInt2);
        AppMethodBeat.o(174934);
        return paramString1;
      }
      i.deleteFile(((bb)localObject).field_pkgPath);
      paramString1 = a(localab, paramInt3, paramInt2, ((bb)localObject).field_versionMd5);
      if (paramString1 != null)
      {
        localObject = ay.aF(localab.toString(), paramInt2);
        i.lC(paramString1.field_pkgPath, (String)localObject);
        j.aOK().d(localab.toString(), paramInt3, paramInt2, (String)localObject);
        paramString1 = C((String)localObject, paramString2, paramInt2);
        AppMethodBeat.o(174934);
        return paramString1;
      }
    }
    else
    {
      paramString1 = WxaPkgIntegrityChecker.C(localab.toString(), paramInt3, 1);
      if (paramString1.second != null)
      {
        ((WxaPkgWrappingInfo)paramString1.second).name = paramString2;
        paramString1 = (WxaPkgWrappingInfo)paramString1.second;
        AppMethodBeat.o(174934);
        return paramString1;
      }
    }
    AppMethodBeat.o(174934);
    return null;
  }
  
  public static WxaPkgWrappingInfo bD(String paramString, int paramInt)
  {
    AppMethodBeat.i(47158);
    int[] arrayOfInt = j.aOK().Em(paramString);
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt)) {}
    for (;;)
    {
      int i = paramInt + 1;
      Pair localPair = WxaPkgIntegrityChecker.C(paramString, 0, arrayOfInt[paramInt]);
      if ((localPair.first == WxaPkgIntegrityChecker.a.iOg) && (localPair.second != null))
      {
        paramString = (WxaPkgWrappingInfo)localPair.second;
        AppMethodBeat.o(47158);
        return paramString;
      }
      if (i >= arrayOfInt.length)
      {
        AppMethodBeat.o(47158);
        return null;
      }
      paramInt = i;
    }
  }
  
  public static WxaPkgWrappingInfo bE(String paramString, int paramInt)
  {
    AppMethodBeat.i(196002);
    int[] arrayOfInt = j.aOK().Em(paramString);
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
    {
      AppMethodBeat.o(196002);
      return null;
    }
    int i = Math.abs(paramInt - arrayOfInt[0]);
    int j = Math.abs(paramInt - arrayOfInt[(arrayOfInt.length - 1)]);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo;
    if (i > j)
    {
      ad.d("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg appId:%s,versionArray:%s", new Object[] { paramString, Arrays.toString(arrayOfInt) });
      int m = arrayOfInt.length;
      j = 0;
      localWxaPkgWrappingInfo = null;
      label95:
      if (j >= m) {
        break label175;
      }
      int n = arrayOfInt[j];
      int k = Math.abs(paramInt - n);
      Pair localPair = WxaPkgIntegrityChecker.C(paramString, 0, n);
      if ((localPair.first != WxaPkgIntegrityChecker.a.iOg) || (localPair.second == null) || (k > i)) {
        break label225;
      }
      localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)localPair.second;
      i = k;
    }
    label175:
    label225:
    for (;;)
    {
      j += 1;
      break label95;
      i = j;
      break;
      if (localWxaPkgWrappingInfo != null) {
        ad.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg leastStep:%d,desireVersion:%d,localVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localWxaPkgWrappingInfo.pkgVersion) });
      }
      AppMethodBeat.o(196002);
      return localWxaPkgWrappingInfo;
    }
  }
  
  static int bF(String paramString, int paramInt)
  {
    AppMethodBeat.i(196004);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = bE(paramString, paramInt);
      if (paramString != null)
      {
        paramInt = paramString.pkgVersion;
        AppMethodBeat.o(196004);
        return paramInt;
      }
    }
    AppMethodBeat.o(196004);
    return 0;
  }
  
  /* Error */
  static boolean dw(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 280
    //   5: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifne +10 -> 22
    //   15: aload_0
    //   16: invokestatic 283	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   19: ifne +11 -> 30
    //   22: ldc_w 280
    //   25: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: new 285	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 288	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   38: astore 5
    //   40: aload 5
    //   42: invokevirtual 291	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aPe	()Z
    //   45: istore 4
    //   47: iload 4
    //   49: ifne +16 -> 65
    //   52: aload 5
    //   54: invokevirtual 292	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   57: ldc_w 280
    //   60: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_0
    //   64: ireturn
    //   65: aload_1
    //   66: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   69: istore 4
    //   71: iload 4
    //   73: ifeq +16 -> 89
    //   76: aload 5
    //   78: invokevirtual 292	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   81: ldc_w 280
    //   84: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_1
    //   88: ireturn
    //   89: aload_1
    //   90: invokestatic 297	com/tencent/luggage/h/k:cA	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokestatic 302	com/tencent/mm/plugin/appbrand/appcache/e:DK	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_1
    //   97: aload_1
    //   98: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   101: istore 4
    //   103: iload 4
    //   105: ifeq +16 -> 121
    //   108: aload 5
    //   110: invokevirtual 292	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   113: ldc_w 280
    //   116: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: iconst_1
    //   120: ireturn
    //   121: aload 5
    //   123: aload_1
    //   124: invokevirtual 306	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:DM	(Ljava/lang/String;)Ljava/io/InputStream;
    //   127: astore 6
    //   129: aload 6
    //   131: ifnull +21 -> 152
    //   134: aload 6
    //   136: invokestatic 309	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   139: aload 5
    //   141: invokevirtual 292	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   144: ldc_w 280
    //   147: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iload_3
    //   151: ireturn
    //   152: aload 5
    //   154: ldc_w 311
    //   157: invokevirtual 306	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:DM	(Ljava/lang/String;)Ljava/io/InputStream;
    //   160: invokestatic 317	com/tencent/mm/plugin/appbrand/aa/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   163: astore 6
    //   165: aload 6
    //   167: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   170: istore_3
    //   171: iload_3
    //   172: ifne +109 -> 281
    //   175: aload 6
    //   177: invokestatic 323	com/tencent/mm/ac/h:qE	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   180: ldc_w 325
    //   183: invokevirtual 331	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   186: astore 6
    //   188: iconst_0
    //   189: istore_2
    //   190: iload_2
    //   191: aload 6
    //   193: invokevirtual 337	org/json/JSONArray:length	()I
    //   196: if_icmpge +53 -> 249
    //   199: aload 6
    //   201: iload_2
    //   202: invokevirtual 340	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   205: astore 7
    //   207: aload 7
    //   209: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   212: ifne +30 -> 242
    //   215: aload_1
    //   216: aload 7
    //   218: invokestatic 302	com/tencent/mm/plugin/appbrand/appcache/e:DK	(Ljava/lang/String;)Ljava/lang/String;
    //   221: invokevirtual 343	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   224: istore_3
    //   225: iload_3
    //   226: ifeq +16 -> 242
    //   229: aload 5
    //   231: invokevirtual 292	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   234: ldc_w 280
    //   237: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: iconst_1
    //   241: ireturn
    //   242: iload_2
    //   243: iconst_1
    //   244: iadd
    //   245: istore_2
    //   246: goto -56 -> 190
    //   249: iconst_0
    //   250: istore_3
    //   251: goto -112 -> 139
    //   254: astore 6
    //   256: ldc 179
    //   258: ldc_w 345
    //   261: iconst_3
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_0
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: aload_1
    //   272: aastore
    //   273: dup
    //   274: iconst_2
    //   275: aload 6
    //   277: aastore
    //   278: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: iconst_0
    //   282: istore_3
    //   283: goto -144 -> 139
    //   286: astore_0
    //   287: aload 5
    //   289: invokevirtual 292	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   292: ldc_w 280
    //   295: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_0
    //   299: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramString1	String
    //   0	300	1	paramString2	String
    //   189	57	2	i	int
    //   1	282	3	bool1	boolean
    //   45	59	4	bool2	boolean
    //   38	250	5	localWxaPkg	com.tencent.mm.plugin.appbrand.appcache.WxaPkg
    //   127	73	6	localObject	Object
    //   254	22	6	localException	java.lang.Exception
    //   205	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   175	188	254	java/lang/Exception
    //   190	225	254	java/lang/Exception
    //   40	47	286	finally
    //   65	71	286	finally
    //   89	103	286	finally
    //   121	129	286	finally
    //   134	139	286	finally
    //   152	171	286	finally
    //   175	188	286	finally
    //   190	225	286	finally
    //   256	281	286	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m
 * JD-Core Version:    0.7.0.1
 */