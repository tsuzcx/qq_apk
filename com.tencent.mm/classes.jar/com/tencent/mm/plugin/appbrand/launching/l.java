package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bm.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class l
{
  static bh a(ae paramae, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(248121);
    paramae = m.bFP().a(paramae, paramInt1, bm.a.nHO);
    if (paramae != null)
    {
      paramae = paramae.iterator();
      while (paramae.hasNext())
      {
        bh localbh = (bh)paramae.next();
        if (localbh.field_version != paramInt2)
        {
          String str1 = WxaPkgIntegrityChecker.acX(localbh.field_pkgPath);
          paramInt1 = 0;
          while (paramInt1 < 2)
          {
            String str2 = paramArrayOfString[paramInt1];
            if ((!TextUtils.isEmpty(str2)) && (str2.equals(str1)))
            {
              AppMethodBeat.o(248121);
              return localbh;
            }
            paramInt1 += 1;
          }
        }
      }
    }
    AppMethodBeat.o(248121);
    return null;
  }
  
  public static WxaPkgWrappingInfo ajV(String paramString)
  {
    AppMethodBeat.i(292948);
    paramString = cq(paramString, 1);
    AppMethodBeat.o(292948);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(47158);
    int[] arrayOfInt = m.bFP().adc(paramString);
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt)) {}
    for (;;)
    {
      int i = paramInt + 1;
      Pair localPair = WxaPkgIntegrityChecker.D(paramString, 0, arrayOfInt[paramInt]);
      if ((localPair.first == WxaPkgIntegrityChecker.a.nHl) && (localPair.second != null))
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
  
  public static WxaPkgWrappingInfo cr(String paramString, int paramInt)
  {
    AppMethodBeat.i(248116);
    int[] arrayOfInt = m.bFP().adc(paramString);
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
    {
      AppMethodBeat.o(248116);
      return null;
    }
    int i = Math.abs(paramInt - arrayOfInt[0]);
    int j = Math.abs(paramInt - arrayOfInt[(arrayOfInt.length - 1)]);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo;
    if (i > j)
    {
      Log.d("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg appId:%s,versionArray:%s", new Object[] { paramString, Arrays.toString(arrayOfInt) });
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
      if ((localPair.first != WxaPkgIntegrityChecker.a.nHl) || (localPair.second == null) || (k > i)) {
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
        Log.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg leastStep:%d,desireVersion:%d,localVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(localWxaPkgWrappingInfo.pkgVersion) });
      }
      AppMethodBeat.o(248116);
      return localWxaPkgWrappingInfo;
    }
  }
  
  /* Error */
  static boolean eo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 153
    //   4: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 159	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: invokestatic 164	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   18: ifne +10 -> 28
    //   21: ldc 153
    //   23: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 166	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 170	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 173	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bGl	()Z
    //   43: istore 4
    //   45: iload 4
    //   47: ifne +15 -> 62
    //   50: aload 5
    //   52: invokevirtual 177	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   55: ldc 153
    //   57: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iconst_0
    //   61: ireturn
    //   62: aload_1
    //   63: invokestatic 159	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   66: istore 4
    //   68: iload 4
    //   70: ifeq +15 -> 85
    //   73: aload 5
    //   75: invokevirtual 177	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   78: ldc 153
    //   80: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_1
    //   84: ireturn
    //   85: aload_1
    //   86: invokestatic 181	com/tencent/luggage/k/l:eo	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 186	com/tencent/mm/plugin/appbrand/appcache/e:acz	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_1
    //   94: invokestatic 159	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   97: istore 4
    //   99: iload 4
    //   101: ifeq +15 -> 116
    //   104: aload 5
    //   106: invokevirtual 177	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   109: ldc 153
    //   111: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iconst_1
    //   115: ireturn
    //   116: aload 5
    //   118: aload_1
    //   119: invokevirtual 190	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:acB	(Ljava/lang/String;)Ljava/io/InputStream;
    //   122: astore 6
    //   124: aload 6
    //   126: ifnull +20 -> 146
    //   129: aload 6
    //   131: invokestatic 194	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   134: aload 5
    //   136: invokevirtual 177	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   139: ldc 153
    //   141: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iload_3
    //   145: ireturn
    //   146: aload 5
    //   148: ldc 196
    //   150: invokevirtual 190	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:acB	(Ljava/lang/String;)Ljava/io/InputStream;
    //   153: invokestatic 202	com/tencent/mm/plugin/appbrand/ac/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   156: astore 6
    //   158: aload 6
    //   160: invokestatic 159	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   163: istore_3
    //   164: iload_3
    //   165: ifne +106 -> 271
    //   168: aload 6
    //   170: invokestatic 208	com/tencent/mm/ad/h:ME	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   173: ldc 210
    //   175: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   178: astore 6
    //   180: iconst_0
    //   181: istore_2
    //   182: iload_2
    //   183: aload 6
    //   185: invokevirtual 222	org/json/JSONArray:length	()I
    //   188: if_icmpge +52 -> 240
    //   191: aload 6
    //   193: iload_2
    //   194: invokevirtual 226	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   197: astore 7
    //   199: aload 7
    //   201: invokestatic 159	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   204: ifne +29 -> 233
    //   207: aload_1
    //   208: aload 7
    //   210: invokestatic 186	com/tencent/mm/plugin/appbrand/appcache/e:acz	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokevirtual 229	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   216: istore_3
    //   217: iload_3
    //   218: ifeq +15 -> 233
    //   221: aload 5
    //   223: invokevirtual 177	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   226: ldc 153
    //   228: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: iconst_1
    //   232: ireturn
    //   233: iload_2
    //   234: iconst_1
    //   235: iadd
    //   236: istore_2
    //   237: goto -55 -> 182
    //   240: iconst_0
    //   241: istore_3
    //   242: goto -108 -> 134
    //   245: astore 6
    //   247: ldc 121
    //   249: ldc 231
    //   251: iconst_3
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_0
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: aload_1
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: aload 6
    //   267: aastore
    //   268: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: iconst_0
    //   272: istore_3
    //   273: goto -139 -> 134
    //   276: astore_0
    //   277: aload 5
    //   279: invokevirtual 177	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:close	()V
    //   282: ldc 153
    //   284: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload_0
    //   288: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramString1	String
    //   0	289	1	paramString2	String
    //   181	56	2	i	int
    //   1	272	3	bool1	boolean
    //   43	57	4	bool2	boolean
    //   36	242	5	localWxaPkg	com.tencent.mm.plugin.appbrand.appcache.WxaPkg
    //   122	70	6	localObject	Object
    //   245	21	6	localException	java.lang.Exception
    //   197	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   168	180	245	java/lang/Exception
    //   182	217	245	java/lang/Exception
    //   38	45	276	finally
    //   62	68	276	finally
    //   85	99	276	finally
    //   116	124	276	finally
    //   129	134	276	finally
    //   146	164	276	finally
    //   168	180	276	finally
    //   182	217	276	finally
    //   247	271	276	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.l
 * JD-Core Version:    0.7.0.1
 */