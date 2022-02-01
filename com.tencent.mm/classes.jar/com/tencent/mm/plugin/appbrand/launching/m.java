package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bg.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class m
{
  private static WxaPkgWrappingInfo E(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(174935);
    if ((!bt.isNullOrNil(paramString2)) && (paramString2.endsWith("__PLUGINCODE__"))) {}
    for (paramString1 = WxaPkgWrappingInfo.LM(paramString1); paramString1 == null; paramString1 = WxaPkgWrappingInfo.LL(paramString1))
    {
      AppMethodBeat.o(174935);
      return null;
    }
    paramString1.pkgVersion = paramInt;
    AppMethodBeat.o(174935);
    return paramString1;
  }
  
  public static WxaPkgWrappingInfo RL(String paramString)
  {
    AppMethodBeat.i(221293);
    paramString = bK(paramString, 1);
    AppMethodBeat.o(221293);
    return paramString;
  }
  
  static int RM(String paramString)
  {
    AppMethodBeat.i(188605);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = bK(paramString, 1);
      if (paramString != null)
      {
        int i = paramString.pkgVersion;
        AppMethodBeat.o(188605);
        return i;
      }
    }
    AppMethodBeat.o(188605);
    return 0;
  }
  
  static bc a(ac paramac, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(188604);
    paramac = j.aYX().a(paramac, paramInt1, bg.a.jIN);
    if (paramac != null)
    {
      paramac = paramac.iterator();
      while (paramac.hasNext())
      {
        bc localbc = (bc)paramac.next();
        if (localbc.field_version != paramInt2)
        {
          String str1 = WxaPkgIntegrityChecker.LB(localbc.field_pkgPath);
          int i = paramArrayOfString.length;
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            String str2 = paramArrayOfString[paramInt1];
            if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1)))
            {
              AppMethodBeat.o(188604);
              return localbc;
            }
            paramInt1 += 1;
          }
        }
      }
    }
    AppMethodBeat.o(188604);
    return null;
  }
  
  static WxaPkgWrappingInfo b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174934);
    ac localac = new ac(paramString1, paramString2, paramInt1);
    ad.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "multiPkg findPkgInfoAvailable pkgQueryKey:%s,codeType:%d", new Object[] { localac, Integer.valueOf(paramInt3) });
    if (j.a.rQ(paramInt3))
    {
      Object localObject = j.aYX();
      if (localObject == null)
      {
        AppMethodBeat.o(174934);
        return null;
      }
      localObject = ((bg)localObject).a(localac.toString(), paramInt2, paramInt3, new String[0]);
      if (localObject == null)
      {
        AppMethodBeat.o(174934);
        return null;
      }
      if (bt.isNullOrNil(((bc)localObject).field_versionMd5))
      {
        AppMethodBeat.o(174934);
        return null;
      }
      if (((bc)localObject).field_versionMd5.equals(WxaPkgIntegrityChecker.LB(((bc)localObject).field_pkgPath)))
      {
        ad.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "appid:%s release already exist modulename:%s,codeType:%d,desirePkgVersion:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
        paramString1 = E(((bc)localObject).field_pkgPath, paramString2, paramInt2);
        AppMethodBeat.o(174934);
        return paramString1;
      }
      i.deleteFile(((bc)localObject).field_pkgPath);
      paramString1 = a(localac, paramInt3, paramInt2, new String[] { ((bc)localObject).field_versionMd5, ((bc)localObject).field_NewMd5 });
      if (paramString1 != null)
      {
        localObject = az.aL(localac.toString(), paramInt2);
        i.mz(paramString1.field_pkgPath, (String)localObject);
        j.aYX().e(localac.toString(), paramInt3, paramInt2, (String)localObject);
        paramString1 = E((String)localObject, paramString2, paramInt2);
        AppMethodBeat.o(174934);
        return paramString1;
      }
    }
    else
    {
      paramString1 = WxaPkgIntegrityChecker.D(localac.toString(), paramInt3, 1);
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
  
  public static WxaPkgWrappingInfo bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(47158);
    int[] arrayOfInt = j.aYX().LH(paramString);
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt)) {}
    for (;;)
    {
      int i = paramInt + 1;
      Pair localPair = WxaPkgIntegrityChecker.D(paramString, 0, arrayOfInt[paramInt]);
      if ((localPair.first == WxaPkgIntegrityChecker.a.jIl) && (localPair.second != null))
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
  
  public static WxaPkgWrappingInfo bL(String paramString, int paramInt)
  {
    AppMethodBeat.i(188603);
    int[] arrayOfInt = j.aYX().LH(paramString);
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
    {
      AppMethodBeat.o(188603);
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
      label94:
      if (j >= m) {
        break label174;
      }
      int n = arrayOfInt[j];
      int k = Math.abs(paramInt - n);
      Pair localPair = WxaPkgIntegrityChecker.D(paramString, 0, n);
      if ((localPair.first != WxaPkgIntegrityChecker.a.jIl) || (localPair.second == null) || (k > i)) {
        break label223;
      }
      localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)localPair.second;
      i = k;
    }
    label174:
    label223:
    for (;;)
    {
      j += 1;
      break label94;
      i = j;
      break;
      if (localWxaPkgWrappingInfo != null) {
        ad.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg leastStep:%d,desireVersion:%d,localVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localWxaPkgWrappingInfo.pkgVersion) });
      }
      AppMethodBeat.o(188603);
      return localWxaPkgWrappingInfo;
    }
  }
  
  static int bM(String paramString, int paramInt)
  {
    AppMethodBeat.i(188606);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = bL(paramString, paramInt);
      if (paramString != null)
      {
        paramInt = paramString.pkgVersion;
        AppMethodBeat.o(188606);
        return paramInt;
      }
    }
    AppMethodBeat.o(188606);
    return 0;
  }
  
  /* Error */
  static boolean dK(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 238
    //   4: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: invokestatic 241	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   18: ifne +10 -> 28
    //   21: ldc 238
    //   23: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 243	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 246	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 249	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:aZr	()Z
    //   43: istore 4
    //   45: iload 4
    //   47: ifne +15 -> 62
    //   50: aload 5
    //   52: invokevirtual 253	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   55: ldc 238
    //   57: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iconst_0
    //   61: ireturn
    //   62: aload_1
    //   63: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   66: istore 4
    //   68: iload 4
    //   70: ifeq +15 -> 85
    //   73: aload 5
    //   75: invokevirtual 253	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   78: ldc 238
    //   80: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_1
    //   84: ireturn
    //   85: aload_1
    //   86: invokestatic 258	com/tencent/luggage/h/k:dr	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 263	com/tencent/mm/plugin/appbrand/appcache/e:Lg	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_1
    //   94: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   97: istore 4
    //   99: iload 4
    //   101: ifeq +15 -> 116
    //   104: aload 5
    //   106: invokevirtual 253	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   109: ldc 238
    //   111: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iconst_1
    //   115: ireturn
    //   116: aload 5
    //   118: aload_1
    //   119: invokevirtual 267	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   122: astore 6
    //   124: aload 6
    //   126: ifnull +20 -> 146
    //   129: aload 6
    //   131: invokestatic 270	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   134: aload 5
    //   136: invokevirtual 253	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   139: ldc 238
    //   141: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iload_3
    //   145: ireturn
    //   146: aload 5
    //   148: ldc_w 272
    //   151: invokevirtual 267	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   154: invokestatic 278	com/tencent/mm/plugin/appbrand/z/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   157: astore 6
    //   159: aload 6
    //   161: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   164: istore_3
    //   165: iload_3
    //   166: ifne +108 -> 274
    //   169: aload 6
    //   171: invokestatic 284	com/tencent/mm/ac/h:wJ	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   174: ldc_w 286
    //   177: invokevirtual 292	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   180: astore 6
    //   182: iconst_0
    //   183: istore_2
    //   184: iload_2
    //   185: aload 6
    //   187: invokevirtual 298	org/json/JSONArray:length	()I
    //   190: if_icmpge +52 -> 242
    //   193: aload 6
    //   195: iload_2
    //   196: invokevirtual 302	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   199: astore 7
    //   201: aload 7
    //   203: invokestatic 19	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   206: ifne +29 -> 235
    //   209: aload_1
    //   210: aload 7
    //   212: invokestatic 263	com/tencent/mm/plugin/appbrand/appcache/e:Lg	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 305	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   218: istore_3
    //   219: iload_3
    //   220: ifeq +15 -> 235
    //   223: aload 5
    //   225: invokevirtual 253	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   228: ldc 238
    //   230: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: iconst_1
    //   234: ireturn
    //   235: iload_2
    //   236: iconst_1
    //   237: iadd
    //   238: istore_2
    //   239: goto -55 -> 184
    //   242: iconst_0
    //   243: istore_3
    //   244: goto -110 -> 134
    //   247: astore 6
    //   249: ldc 124
    //   251: ldc_w 307
    //   254: iconst_3
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload_0
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload_1
    //   265: aastore
    //   266: dup
    //   267: iconst_2
    //   268: aload 6
    //   270: aastore
    //   271: invokestatic 309	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: iconst_0
    //   275: istore_3
    //   276: goto -142 -> 134
    //   279: astore_0
    //   280: aload 5
    //   282: invokevirtual 253	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   285: ldc 238
    //   287: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_0
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramString1	String
    //   0	292	1	paramString2	String
    //   183	56	2	i	int
    //   1	275	3	bool1	boolean
    //   43	57	4	bool2	boolean
    //   36	245	5	localWxaPkg	com.tencent.mm.plugin.appbrand.appcache.WxaPkg
    //   122	72	6	localObject	Object
    //   247	22	6	localException	java.lang.Exception
    //   199	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   169	182	247	java/lang/Exception
    //   184	219	247	java/lang/Exception
    //   38	45	279	finally
    //   62	68	279	finally
    //   85	99	279	finally
    //   116	124	279	finally
    //   129	134	279	finally
    //   146	165	279	finally
    //   169	182	279	finally
    //   184	219	279	finally
    //   249	274	279	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m
 * JD-Core Version:    0.7.0.1
 */