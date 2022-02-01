package com.tencent.mm.modelstat.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vfs.u;

public final class b
{
  /* Error */
  public static int b(u paramu, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 17
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +239 -> 248
    //   12: ldc 25
    //   14: astore_2
    //   15: new 27	java/net/URL
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 31	java/net/URL:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 35	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: checkcast 37	javax/net/ssl/HttpsURLConnection
    //   29: astore 4
    //   31: aload 4
    //   33: iconst_1
    //   34: invokevirtual 41	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   37: aload 4
    //   39: iconst_1
    //   40: invokevirtual 44	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   43: aload 4
    //   45: iconst_0
    //   46: invokevirtual 47	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   49: aload 4
    //   51: ldc 49
    //   53: invokevirtual 52	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   56: aload 4
    //   58: ldc 54
    //   60: new 56	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   67: aload_0
    //   68: invokevirtual 65	com/tencent/mm/vfs/u:length	()J
    //   71: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   74: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload 4
    //   82: ldc 79
    //   84: ldc 81
    //   86: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 4
    //   91: ldc 83
    //   93: ldc 85
    //   95: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: invokestatic 91	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   101: pop
    //   102: aload 4
    //   104: ldc 93
    //   106: invokestatic 98	com/tencent/mm/kernel/b:aZs	()Ljava/lang/String;
    //   109: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: invokestatic 91	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   115: pop
    //   116: aload 4
    //   118: ldc 100
    //   120: invokestatic 98	com/tencent/mm/kernel/b:aZs	()Ljava/lang/String;
    //   123: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_1
    //   127: iconst_1
    //   128: if_icmpne +126 -> 254
    //   131: aload 4
    //   133: ldc 102
    //   135: ldc 104
    //   137: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 4
    //   142: ldc 106
    //   144: ldc 108
    //   146: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload 4
    //   151: ldc 110
    //   153: aconst_null
    //   154: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 4
    //   159: invokevirtual 114	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   162: astore 5
    //   164: sipush 10240
    //   167: newarray byte
    //   169: astore 6
    //   171: aload_0
    //   172: invokestatic 120	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   175: astore_2
    //   176: aload_2
    //   177: astore_0
    //   178: aload_2
    //   179: aload 6
    //   181: iconst_0
    //   182: sipush 10240
    //   185: invokevirtual 126	java/io/InputStream:read	([BII)I
    //   188: istore_1
    //   189: iload_1
    //   190: iconst_m1
    //   191: if_icmpeq +110 -> 301
    //   194: aload_2
    //   195: astore_0
    //   196: aload 5
    //   198: aload 6
    //   200: iconst_0
    //   201: iload_1
    //   202: invokevirtual 132	java/io/OutputStream:write	([BII)V
    //   205: goto -29 -> 176
    //   208: astore_3
    //   209: aload_2
    //   210: astore_0
    //   211: ldc 134
    //   213: aload_3
    //   214: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 145	java/io/InputStream:close	()V
    //   228: aload 4
    //   230: invokevirtual 149	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   233: invokevirtual 145	java/io/InputStream:close	()V
    //   236: aload 4
    //   238: invokevirtual 152	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   241: ldc 17
    //   243: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: iconst_m1
    //   247: ireturn
    //   248: ldc 157
    //   250: astore_2
    //   251: goto -236 -> 15
    //   254: aload 4
    //   256: ldc 102
    //   258: ldc 159
    //   260: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 4
    //   265: ldc 161
    //   267: ldc 159
    //   269: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 4
    //   274: ldc 106
    //   276: ldc 159
    //   278: invokevirtual 77	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: goto -132 -> 149
    //   284: astore_0
    //   285: ldc 134
    //   287: aload_0
    //   288: invokevirtual 162	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   291: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: ldc 17
    //   296: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: iconst_0
    //   300: ireturn
    //   301: aload_2
    //   302: astore_0
    //   303: aload_2
    //   304: invokevirtual 145	java/io/InputStream:close	()V
    //   307: ldc 134
    //   309: ldc 164
    //   311: iconst_1
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload 4
    //   319: invokevirtual 168	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   322: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: aastore
    //   326: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: aload 4
    //   331: invokevirtual 149	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   334: invokevirtual 145	java/io/InputStream:close	()V
    //   337: aload 4
    //   339: invokevirtual 152	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   342: aload 5
    //   344: invokevirtual 178	java/io/OutputStream:close	()V
    //   347: goto -53 -> 294
    //   350: astore_0
    //   351: ldc 134
    //   353: aload_0
    //   354: invokevirtual 179	java/net/ProtocolException:getMessage	()Ljava/lang/String;
    //   357: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: goto -66 -> 294
    //   363: astore_0
    //   364: ldc 134
    //   366: aload_0
    //   367: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   370: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -36 -> 337
    //   376: astore_0
    //   377: ldc 134
    //   379: aload_0
    //   380: invokevirtual 180	java/io/IOException:getMessage	()Ljava/lang/String;
    //   383: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: goto -92 -> 294
    //   389: astore_0
    //   390: ldc 134
    //   392: aload_0
    //   393: invokevirtual 180	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: ldc 17
    //   401: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: iconst_m1
    //   405: ireturn
    //   406: astore_0
    //   407: ldc 134
    //   409: aload_0
    //   410: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   413: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: goto -180 -> 236
    //   419: astore_0
    //   420: aload_3
    //   421: astore_2
    //   422: aload_2
    //   423: ifnull +7 -> 430
    //   426: aload_2
    //   427: invokevirtual 145	java/io/InputStream:close	()V
    //   430: aload 4
    //   432: invokevirtual 149	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   435: invokevirtual 145	java/io/InputStream:close	()V
    //   438: aload 4
    //   440: invokevirtual 152	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   443: ldc 17
    //   445: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: aload_0
    //   449: athrow
    //   450: astore_0
    //   451: ldc 134
    //   453: aload_0
    //   454: invokevirtual 180	java/io/IOException:getMessage	()Ljava/lang/String;
    //   457: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: ldc 17
    //   462: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: iconst_m1
    //   466: ireturn
    //   467: astore_2
    //   468: ldc 134
    //   470: aload_2
    //   471: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: goto -39 -> 438
    //   480: astore_3
    //   481: aload_0
    //   482: astore_2
    //   483: aload_3
    //   484: astore_0
    //   485: goto -63 -> 422
    //   488: astore_3
    //   489: aconst_null
    //   490: astore_2
    //   491: goto -282 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	paramu	u
    //   0	494	1	paramInt	int
    //   14	413	2	localObject1	Object
    //   467	4	2	localException1	java.lang.Exception
    //   482	9	2	localu	u
    //   1	1	3	localObject2	Object
    //   208	213	3	localException2	java.lang.Exception
    //   480	4	3	localObject3	Object
    //   488	1	3	localException3	java.lang.Exception
    //   29	410	4	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   162	181	5	localOutputStream	java.io.OutputStream
    //   169	30	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   178	189	208	java/lang/Exception
    //   196	205	208	java/lang/Exception
    //   303	307	208	java/lang/Exception
    //   15	126	284	java/net/MalformedURLException
    //   131	149	284	java/net/MalformedURLException
    //   149	171	284	java/net/MalformedURLException
    //   224	228	284	java/net/MalformedURLException
    //   228	236	284	java/net/MalformedURLException
    //   236	241	284	java/net/MalformedURLException
    //   254	281	284	java/net/MalformedURLException
    //   329	337	284	java/net/MalformedURLException
    //   337	347	284	java/net/MalformedURLException
    //   364	373	284	java/net/MalformedURLException
    //   390	399	284	java/net/MalformedURLException
    //   407	416	284	java/net/MalformedURLException
    //   426	430	284	java/net/MalformedURLException
    //   430	438	284	java/net/MalformedURLException
    //   438	450	284	java/net/MalformedURLException
    //   451	460	284	java/net/MalformedURLException
    //   468	477	284	java/net/MalformedURLException
    //   15	126	350	java/net/ProtocolException
    //   131	149	350	java/net/ProtocolException
    //   149	171	350	java/net/ProtocolException
    //   224	228	350	java/net/ProtocolException
    //   228	236	350	java/net/ProtocolException
    //   236	241	350	java/net/ProtocolException
    //   254	281	350	java/net/ProtocolException
    //   329	337	350	java/net/ProtocolException
    //   337	347	350	java/net/ProtocolException
    //   364	373	350	java/net/ProtocolException
    //   390	399	350	java/net/ProtocolException
    //   407	416	350	java/net/ProtocolException
    //   426	430	350	java/net/ProtocolException
    //   430	438	350	java/net/ProtocolException
    //   438	450	350	java/net/ProtocolException
    //   451	460	350	java/net/ProtocolException
    //   468	477	350	java/net/ProtocolException
    //   329	337	363	java/lang/Exception
    //   15	126	376	java/io/IOException
    //   131	149	376	java/io/IOException
    //   149	171	376	java/io/IOException
    //   228	236	376	java/io/IOException
    //   236	241	376	java/io/IOException
    //   254	281	376	java/io/IOException
    //   329	337	376	java/io/IOException
    //   337	347	376	java/io/IOException
    //   364	373	376	java/io/IOException
    //   390	399	376	java/io/IOException
    //   407	416	376	java/io/IOException
    //   430	438	376	java/io/IOException
    //   438	450	376	java/io/IOException
    //   451	460	376	java/io/IOException
    //   468	477	376	java/io/IOException
    //   224	228	389	java/io/IOException
    //   228	236	406	java/lang/Exception
    //   171	176	419	finally
    //   307	329	419	finally
    //   426	430	450	java/io/IOException
    //   430	438	467	java/lang/Exception
    //   178	189	480	finally
    //   196	205	480	finally
    //   211	220	480	finally
    //   303	307	480	finally
    //   171	176	488	java/lang/Exception
    //   307	329	488	java/lang/Exception
  }
  
  public static void r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(242899);
    Log.i("MicroMsg.UploadX5Log", "upload, date %s,process %s,type %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        Log.w("MicroMsg.UploadX5Log", "date or process is null,date %s,process %s", new Object[] { paramString1, paramString2 });
        AppMethodBeat.o(242899);
        return;
      }
    }
    for (paramString1 = String.format("%s/files/Tencent/tbs_live_log/" + MMApplicationContext.getApplicationId() + "/com.tencent.mm_%s_%s.livelog", new Object[] { com.tencent.mm.loader.i.b.bmt(), paramString2, paramString1 });; paramString1 = com.tencent.mm.loader.i.b.bmt() + "/files/tbslog/tbslog.txt")
    {
      paramString2 = new u(paramString1);
      if (paramString2.jKS()) {
        break;
      }
      Log.i("MicroMsg.UploadX5Log", "upload file not exists");
      AppMethodBeat.o(242899);
      return;
    }
    paramString1 = r.a(paramString2, paramString1 + ".zip");
    if (paramString1 == null)
    {
      Log.i("MicroMsg.UploadX5Log", "zipPath is null");
      AppMethodBeat.o(242899);
      return;
    }
    paramString1 = new u(paramString1);
    if (!paramString1.jKS())
    {
      Log.i("MicroMsg.UploadX5Log", "upload zip file not exists");
      AppMethodBeat.o(242899);
      return;
    }
    g.ha(paramString1).h(new a() {});
    AppMethodBeat.o(242899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.a.b
 * JD-Core Version:    0.7.0.1
 */