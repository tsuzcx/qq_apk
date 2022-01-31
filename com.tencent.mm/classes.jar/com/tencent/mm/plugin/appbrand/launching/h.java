package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.appcache.ay;

public final class h
{
  /* Error */
  static com.tencent.mm.plugin.appbrand.appcache.at a(com.tencent.mm.plugin.appbrand.appcache.y paramy, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 23	com/tencent/mm/plugin/appbrand/app/g:auM	()Lcom/tencent/mm/plugin/appbrand/appcache/ay;
    //   8: astore 5
    //   10: aload_0
    //   11: ifnull +10 -> 21
    //   14: aload_3
    //   15: invokestatic 29	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifeq +102 -> 120
    //   21: aconst_null
    //   22: astore_0
    //   23: aload_0
    //   24: ifnull +334 -> 358
    //   27: aload_0
    //   28: invokeinterface 35 1 0
    //   33: astore 6
    //   35: aload 6
    //   37: invokeinterface 41 1 0
    //   42: ifeq +316 -> 358
    //   45: aload 6
    //   47: invokeinterface 45 1 0
    //   52: checkcast 47	com/tencent/mm/plugin/appbrand/appcache/at
    //   55: astore_0
    //   56: aload_0
    //   57: getfield 51	com/tencent/mm/plugin/appbrand/appcache/at:field_version	I
    //   60: iload_2
    //   61: if_icmpeq -26 -> 35
    //   64: aload_3
    //   65: aload_0
    //   66: getfield 55	com/tencent/mm/plugin/appbrand/appcache/at:field_versionMd5	Ljava/lang/String;
    //   69: invokevirtual 61	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq -37 -> 35
    //   75: aload_0
    //   76: getfield 64	com/tencent/mm/plugin/appbrand/appcache/at:field_pkgPath	Ljava/lang/String;
    //   79: invokestatic 70	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   82: astore 7
    //   84: aload_3
    //   85: aload 7
    //   87: sipush 4096
    //   90: invokestatic 76	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   93: invokevirtual 61	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: istore 4
    //   98: iload 4
    //   100: ifeq +188 -> 288
    //   103: aload 7
    //   105: ifnull +8 -> 113
    //   108: aload 7
    //   110: invokevirtual 82	java/io/InputStream:close	()V
    //   113: ldc 11
    //   115: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: areturn
    //   120: getstatic 91	java/util/Locale:US	Ljava/util/Locale;
    //   123: ldc 93
    //   125: iconst_5
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: ldc 95
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc 97
    //   138: aastore
    //   139: dup
    //   140: iconst_2
    //   141: ldc 99
    //   143: aastore
    //   144: dup
    //   145: iconst_3
    //   146: ldc 101
    //   148: aastore
    //   149: dup
    //   150: iconst_4
    //   151: ldc 103
    //   153: aastore
    //   154: invokestatic 107	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   157: astore 6
    //   159: aload 5
    //   161: getfield 113	com/tencent/mm/plugin/appbrand/appcache/ay:gWU	Lcom/tencent/mm/sdk/e/f;
    //   164: aload 6
    //   166: iconst_3
    //   167: anewarray 57	java/lang/String
    //   170: dup
    //   171: iconst_0
    //   172: aload_0
    //   173: invokevirtual 119	com/tencent/mm/plugin/appbrand/appcache/y:toString	()Ljava/lang/String;
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: iload_1
    //   180: invokestatic 123	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   183: aastore
    //   184: dup
    //   185: iconst_2
    //   186: aload_3
    //   187: aastore
    //   188: invokeinterface 129 3 0
    //   193: astore 5
    //   195: aload 5
    //   197: ifnull +13 -> 210
    //   200: aload 5
    //   202: invokeinterface 134 1 0
    //   207: ifeq +8 -> 215
    //   210: aconst_null
    //   211: astore_0
    //   212: goto -189 -> 23
    //   215: aload 5
    //   217: invokeinterface 137 1 0
    //   222: ifne +15 -> 237
    //   225: aload 5
    //   227: invokeinterface 138 1 0
    //   232: aconst_null
    //   233: astore_0
    //   234: goto -211 -> 23
    //   237: new 140	java/util/LinkedList
    //   240: dup
    //   241: invokespecial 143	java/util/LinkedList:<init>	()V
    //   244: astore_0
    //   245: new 47	com/tencent/mm/plugin/appbrand/appcache/at
    //   248: dup
    //   249: invokespecial 144	com/tencent/mm/plugin/appbrand/appcache/at:<init>	()V
    //   252: astore 6
    //   254: aload 6
    //   256: aload 5
    //   258: invokevirtual 148	com/tencent/mm/plugin/appbrand/appcache/at:convertFrom	(Landroid/database/Cursor;)V
    //   261: aload_0
    //   262: aload 6
    //   264: invokevirtual 151	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   267: pop
    //   268: aload 5
    //   270: invokeinterface 154 1 0
    //   275: ifne -30 -> 245
    //   278: aload 5
    //   280: invokeinterface 138 1 0
    //   285: goto -262 -> 23
    //   288: aload 7
    //   290: ifnull -255 -> 35
    //   293: aload 7
    //   295: invokevirtual 82	java/io/InputStream:close	()V
    //   298: goto -263 -> 35
    //   301: astore_0
    //   302: goto -267 -> 35
    //   305: astore 5
    //   307: ldc 11
    //   309: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload 5
    //   314: athrow
    //   315: astore_0
    //   316: aload 7
    //   318: ifnull +13 -> 331
    //   321: aload 5
    //   323: ifnull +27 -> 350
    //   326: aload 7
    //   328: invokevirtual 82	java/io/InputStream:close	()V
    //   331: ldc 11
    //   333: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload_0
    //   337: athrow
    //   338: astore 7
    //   340: aload 5
    //   342: aload 7
    //   344: invokevirtual 158	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   347: goto -16 -> 331
    //   350: aload 7
    //   352: invokevirtual 82	java/io/InputStream:close	()V
    //   355: goto -24 -> 331
    //   358: ldc 11
    //   360: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aconst_null
    //   364: areturn
    //   365: astore_0
    //   366: aconst_null
    //   367: astore 5
    //   369: goto -53 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramy	com.tencent.mm.plugin.appbrand.appcache.y
    //   0	372	1	paramInt1	int
    //   0	372	2	paramInt2	int
    //   0	372	3	paramString	String
    //   96	3	4	bool	boolean
    //   8	271	5	localObject1	Object
    //   305	36	5	localThrowable1	java.lang.Throwable
    //   367	1	5	localObject2	Object
    //   33	230	6	localObject3	Object
    //   82	245	7	localInputStream	java.io.InputStream
    //   338	13	7	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   75	84	301	java/io/IOException
    //   108	113	301	java/io/IOException
    //   293	298	301	java/io/IOException
    //   326	331	301	java/io/IOException
    //   331	338	301	java/io/IOException
    //   340	347	301	java/io/IOException
    //   350	355	301	java/io/IOException
    //   84	98	305	java/lang/Throwable
    //   307	315	315	finally
    //   326	331	338	java/lang/Throwable
    //   84	98	365	finally
  }
  
  public static WxaPkgWrappingInfo bl(String paramString, int paramInt)
  {
    AppMethodBeat.i(131808);
    int[] arrayOfInt = g.auM().yF(paramString);
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt)) {}
    for (;;)
    {
      int i = paramInt + 1;
      Pair localPair = as.F(paramString, 0, arrayOfInt[paramInt]);
      if ((localPair.first == as.a.gWs) && (localPair.second != null))
      {
        paramString = (WxaPkgWrappingInfo)localPair.second;
        AppMethodBeat.o(131808);
        return paramString;
      }
      if (i >= arrayOfInt.length)
      {
        AppMethodBeat.o(131808);
        return null;
      }
      paramInt = i;
    }
  }
  
  /* Error */
  static boolean cA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 194
    //   4: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 29	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: invokestatic 197	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   18: ifne +10 -> 28
    //   21: ldc 194
    //   23: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 199	com/tencent/mm/plugin/appbrand/appcache/ao
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 202	com/tencent/mm/plugin/appbrand/appcache/ao:<init>	(Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 205	com/tencent/mm/plugin/appbrand/appcache/ao:avO	()Z
    //   43: istore 4
    //   45: iload 4
    //   47: ifne +15 -> 62
    //   50: aload 5
    //   52: invokevirtual 206	com/tencent/mm/plugin/appbrand/appcache/ao:close	()V
    //   55: ldc 194
    //   57: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iconst_0
    //   61: ireturn
    //   62: aload_1
    //   63: invokestatic 29	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   66: istore 4
    //   68: iload 4
    //   70: ifeq +15 -> 85
    //   73: aload 5
    //   75: invokevirtual 206	com/tencent/mm/plugin/appbrand/appcache/ao:close	()V
    //   78: ldc 194
    //   80: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: ireturn
    //   85: aload_1
    //   86: invokestatic 212	com/tencent/luggage/g/h:cg	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 217	com/tencent/mm/plugin/appbrand/appcache/b:ym	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload 5
    //   95: aload_1
    //   96: invokevirtual 220	com/tencent/mm/plugin/appbrand/appcache/ao:yw	(Ljava/lang/String;)Ljava/io/InputStream;
    //   99: astore 6
    //   101: aload 6
    //   103: ifnull +20 -> 123
    //   106: aload 6
    //   108: invokestatic 223	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   111: aload 5
    //   113: invokevirtual 206	com/tencent/mm/plugin/appbrand/appcache/ao:close	()V
    //   116: ldc 194
    //   118: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_3
    //   122: ireturn
    //   123: aload 5
    //   125: ldc 225
    //   127: invokevirtual 220	com/tencent/mm/plugin/appbrand/appcache/ao:yw	(Ljava/lang/String;)Ljava/io/InputStream;
    //   130: invokestatic 231	com/tencent/mm/plugin/appbrand/s/d:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   133: astore 6
    //   135: aload 6
    //   137: invokestatic 29	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   140: istore_3
    //   141: iload_3
    //   142: ifne +108 -> 250
    //   145: aload 6
    //   147: invokestatic 237	com/tencent/mm/aa/h:mo	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   150: ldc 239
    //   152: invokevirtual 245	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   155: astore 6
    //   157: iconst_0
    //   158: istore_2
    //   159: iload_2
    //   160: aload 6
    //   162: invokevirtual 251	org/json/JSONArray:length	()I
    //   165: if_icmpge +52 -> 217
    //   168: aload 6
    //   170: iload_2
    //   171: invokevirtual 254	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   174: astore 7
    //   176: aload 7
    //   178: invokestatic 29	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   181: ifne +29 -> 210
    //   184: aload_1
    //   185: aload 7
    //   187: invokestatic 217	com/tencent/mm/plugin/appbrand/appcache/b:ym	(Ljava/lang/String;)Ljava/lang/String;
    //   190: invokevirtual 257	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   193: istore_3
    //   194: iload_3
    //   195: ifeq +15 -> 210
    //   198: aload 5
    //   200: invokevirtual 206	com/tencent/mm/plugin/appbrand/appcache/ao:close	()V
    //   203: ldc 194
    //   205: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_1
    //   209: ireturn
    //   210: iload_2
    //   211: iconst_1
    //   212: iadd
    //   213: istore_2
    //   214: goto -55 -> 159
    //   217: iconst_0
    //   218: istore_3
    //   219: goto -108 -> 111
    //   222: astore 6
    //   224: ldc_w 259
    //   227: ldc_w 261
    //   230: iconst_3
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload_0
    //   237: aastore
    //   238: dup
    //   239: iconst_1
    //   240: aload_1
    //   241: aastore
    //   242: dup
    //   243: iconst_2
    //   244: aload 6
    //   246: aastore
    //   247: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: iconst_0
    //   251: istore_3
    //   252: goto -141 -> 111
    //   255: astore_0
    //   256: aload 5
    //   258: invokevirtual 206	com/tencent/mm/plugin/appbrand/appcache/ao:close	()V
    //   261: ldc 194
    //   263: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramString1	String
    //   0	268	1	paramString2	String
    //   158	56	2	i	int
    //   1	251	3	bool1	boolean
    //   43	26	4	bool2	boolean
    //   36	221	5	localao	com.tencent.mm.plugin.appbrand.appcache.ao
    //   99	70	6	localObject	Object
    //   222	23	6	localException	java.lang.Exception
    //   174	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   145	157	222	java/lang/Exception
    //   159	194	222	java/lang/Exception
    //   38	45	255	finally
    //   62	68	255	finally
    //   85	101	255	finally
    //   106	111	255	finally
    //   123	141	255	finally
    //   145	157	255	finally
    //   159	194	255	finally
    //   224	250	255	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.h
 * JD-Core Version:    0.7.0.1
 */