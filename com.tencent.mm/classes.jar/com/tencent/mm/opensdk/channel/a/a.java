package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.security.MessageDigest;

public class a
{
  public static int a(Bundle paramBundle, String paramString, int paramInt)
  {
    AppMethodBeat.i(242962);
    if (paramBundle == null)
    {
      AppMethodBeat.o(242962);
      return paramInt;
    }
    try
    {
      int i = paramBundle.getInt(paramString, paramInt);
      paramInt = i;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + paramBundle.getMessage());
      }
    }
    AppMethodBeat.o(242962);
    return paramInt;
  }
  
  public static Object a(int paramInt, String paramString)
  {
    AppMethodBeat.i(242967);
    switch (paramInt)
    {
    }
    try
    {
      Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
      AppMethodBeat.o(242967);
      return null;
      paramString = Double.valueOf(paramString);
      AppMethodBeat.o(242967);
      return paramString;
      paramString = Float.valueOf(paramString);
      AppMethodBeat.o(242967);
      return paramString;
      paramString = Boolean.valueOf(paramString);
      AppMethodBeat.o(242967);
      return paramString;
      AppMethodBeat.o(242967);
      return paramString;
      paramString = Long.valueOf(paramString);
      AppMethodBeat.o(242967);
      return paramString;
      paramString = Integer.valueOf(paramString);
      AppMethodBeat.o(242967);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + paramString.getMessage());
      }
    }
  }
  
  public static String a(Bundle paramBundle, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(242966);
    if (paramBundle == null)
    {
      AppMethodBeat.o(242966);
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      AppMethodBeat.o(242966);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + paramBundle.getMessage());
        paramBundle = localObject;
      }
    }
  }
  
  public static boolean a(Context paramContext, a parama)
  {
    AppMethodBeat.i(3827);
    if ((paramContext != null) && (parama != null))
    {
      if (b.b(parama.b))
      {
        Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
        AppMethodBeat.o(3827);
        return false;
      }
      String str = null;
      if (!b.b(parama.a)) {
        str = parama.a + ".permission.MM_MESSAGE";
      }
      Intent localIntent = new Intent(parama.b);
      Object localObject = parama.e;
      if (localObject != null) {
        localIntent.putExtras((Bundle)localObject);
      }
      localObject = paramContext.getPackageName();
      localIntent.putExtra("_mmessage_sdkVersion", 638058496);
      localIntent.putExtra("_mmessage_appPackage", (String)localObject);
      localIntent.putExtra("_mmessage_content", parama.c);
      localIntent.putExtra("_mmessage_support_content_type", parama.d);
      localIntent.putExtra("_mmessage_checksum", a(parama.c, 638058496, (String)localObject));
      paramContext.sendBroadcast(localIntent, str);
      Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + localIntent + ", perm=" + str);
      AppMethodBeat.o(3827);
      return true;
    }
    Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
    AppMethodBeat.o(3827);
    return false;
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +582 -> 588
    //   9: aload_0
    //   10: invokevirtual 193	java/lang/String:length	()I
    //   13: ifeq +575 -> 588
    //   16: new 195	java/net/URL
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 196	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 200	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 202	java/net/HttpURLConnection
    //   30: astore_0
    //   31: aload_0
    //   32: ifnonnull +309 -> 341
    //   35: ldc 204
    //   37: ldc 206
    //   39: invokestatic 53	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: ifnull +7 -> 50
    //   46: aload_0
    //   47: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   50: ldc 187
    //   52: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aconst_null
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore 4
    //   61: aconst_null
    //   62: astore 5
    //   64: aload_0
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   74: aload 4
    //   76: ifnull +8 -> 84
    //   79: aload 4
    //   81: invokevirtual 214	java/io/InputStream:close	()V
    //   84: aload 5
    //   86: ifnull +8 -> 94
    //   89: aload 5
    //   91: invokevirtual 217	java/io/ByteArrayOutputStream:close	()V
    //   94: ldc 187
    //   96: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: athrow
    //   101: astore 8
    //   103: aconst_null
    //   104: astore_2
    //   105: aconst_null
    //   106: astore 6
    //   108: aload_0
    //   109: astore 7
    //   111: aload 7
    //   113: astore_3
    //   114: aload_2
    //   115: astore 5
    //   117: aload 6
    //   119: astore 4
    //   121: ldc 204
    //   123: new 30	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 219
    //   129: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload 8
    //   134: invokevirtual 40	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   137: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 53	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload 7
    //   148: ifnull +8 -> 156
    //   151: aload 7
    //   153: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 214	java/io/InputStream:close	()V
    //   164: aload 6
    //   166: ifnull +8 -> 174
    //   169: aload 6
    //   171: invokevirtual 217	java/io/ByteArrayOutputStream:close	()V
    //   174: ldc 187
    //   176: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aconst_null
    //   180: areturn
    //   181: astore 8
    //   183: aconst_null
    //   184: astore_2
    //   185: aconst_null
    //   186: astore 6
    //   188: aload_0
    //   189: astore 7
    //   191: aload 7
    //   193: astore_3
    //   194: aload_2
    //   195: astore 5
    //   197: aload 6
    //   199: astore 4
    //   201: ldc 204
    //   203: new 30	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 219
    //   209: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload 8
    //   214: invokevirtual 220	java/io/IOException:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 53	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 7
    //   228: ifnull +8 -> 236
    //   231: aload 7
    //   233: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 214	java/io/InputStream:close	()V
    //   244: aload 6
    //   246: ifnull +8 -> 254
    //   249: aload 6
    //   251: invokevirtual 217	java/io/ByteArrayOutputStream:close	()V
    //   254: ldc 187
    //   256: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aconst_null
    //   260: areturn
    //   261: astore 8
    //   263: aconst_null
    //   264: astore_2
    //   265: aconst_null
    //   266: astore 6
    //   268: aload_0
    //   269: astore 7
    //   271: aload 7
    //   273: astore_3
    //   274: aload_2
    //   275: astore 5
    //   277: aload 6
    //   279: astore 4
    //   281: ldc 204
    //   283: new 30	java/lang/StringBuilder
    //   286: dup
    //   287: ldc 219
    //   289: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload 8
    //   294: invokevirtual 221	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 53	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload 7
    //   308: ifnull +8 -> 316
    //   311: aload 7
    //   313: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   316: aload_2
    //   317: ifnull +7 -> 324
    //   320: aload_2
    //   321: invokevirtual 214	java/io/InputStream:close	()V
    //   324: aload 6
    //   326: ifnull +8 -> 334
    //   329: aload 6
    //   331: invokevirtual 217	java/io/ByteArrayOutputStream:close	()V
    //   334: ldc 187
    //   336: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aconst_null
    //   340: areturn
    //   341: aload_0
    //   342: ldc 223
    //   344: invokevirtual 226	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   347: aload_0
    //   348: iload_1
    //   349: invokevirtual 229	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   352: aload_0
    //   353: iload_1
    //   354: invokevirtual 232	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   357: aload_0
    //   358: invokevirtual 235	java/net/HttpURLConnection:getResponseCode	()I
    //   361: istore_1
    //   362: iload_1
    //   363: sipush 300
    //   366: if_icmplt +21 -> 387
    //   369: ldc 204
    //   371: ldc 237
    //   373: invokestatic 53	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload_0
    //   377: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   380: ldc 187
    //   382: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aconst_null
    //   386: areturn
    //   387: aload_0
    //   388: invokevirtual 241	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   391: astore_2
    //   392: new 216	java/io/ByteArrayOutputStream
    //   395: dup
    //   396: invokespecial 242	java/io/ByteArrayOutputStream:<init>	()V
    //   399: astore 6
    //   401: aload_0
    //   402: astore_3
    //   403: aload_2
    //   404: astore 5
    //   406: aload 6
    //   408: astore 4
    //   410: sipush 1024
    //   413: newarray byte
    //   415: astore 7
    //   417: aload_0
    //   418: astore_3
    //   419: aload_2
    //   420: astore 5
    //   422: aload 6
    //   424: astore 4
    //   426: aload_2
    //   427: aload 7
    //   429: invokevirtual 246	java/io/InputStream:read	([B)I
    //   432: istore_1
    //   433: iload_1
    //   434: iconst_m1
    //   435: if_icmpeq +24 -> 459
    //   438: aload_0
    //   439: astore_3
    //   440: aload_2
    //   441: astore 5
    //   443: aload 6
    //   445: astore 4
    //   447: aload 6
    //   449: aload 7
    //   451: iconst_0
    //   452: iload_1
    //   453: invokevirtual 250	java/io/ByteArrayOutputStream:write	([BII)V
    //   456: goto -39 -> 417
    //   459: aload_0
    //   460: astore_3
    //   461: aload_2
    //   462: astore 5
    //   464: aload 6
    //   466: astore 4
    //   468: aload 6
    //   470: invokevirtual 254	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   473: astore 7
    //   475: aload_0
    //   476: astore_3
    //   477: aload_2
    //   478: astore 5
    //   480: aload 6
    //   482: astore 4
    //   484: ldc 204
    //   486: ldc_w 256
    //   489: invokestatic 179	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload_0
    //   493: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   496: aload_2
    //   497: invokevirtual 214	java/io/InputStream:close	()V
    //   500: aload 6
    //   502: invokevirtual 217	java/io/ByteArrayOutputStream:close	()V
    //   505: ldc 187
    //   507: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   510: aload 7
    //   512: areturn
    //   513: astore_0
    //   514: aconst_null
    //   515: astore_2
    //   516: aconst_null
    //   517: astore_3
    //   518: aload_2
    //   519: astore 4
    //   521: aconst_null
    //   522: astore 5
    //   524: aload_0
    //   525: astore_2
    //   526: goto -460 -> 66
    //   529: astore_0
    //   530: aconst_null
    //   531: astore_2
    //   532: aconst_null
    //   533: astore 7
    //   535: aconst_null
    //   536: astore 6
    //   538: aload_0
    //   539: astore 8
    //   541: goto -430 -> 111
    //   544: astore_0
    //   545: aconst_null
    //   546: astore_2
    //   547: aconst_null
    //   548: astore 7
    //   550: aconst_null
    //   551: astore 6
    //   553: aload_0
    //   554: astore 8
    //   556: goto -365 -> 191
    //   559: astore_0
    //   560: aconst_null
    //   561: astore_2
    //   562: aconst_null
    //   563: astore 7
    //   565: aconst_null
    //   566: astore 6
    //   568: aload_0
    //   569: astore 8
    //   571: goto -300 -> 271
    //   574: astore_2
    //   575: aload 4
    //   577: astore_0
    //   578: aload 5
    //   580: astore 4
    //   582: aload_0
    //   583: astore 5
    //   585: goto -519 -> 66
    //   588: ldc 204
    //   590: ldc_w 258
    //   593: invokestatic 53	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: ldc 187
    //   598: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   601: aconst_null
    //   602: areturn
    //   603: astore_0
    //   604: goto -554 -> 50
    //   607: astore_0
    //   608: goto -228 -> 380
    //   611: astore_0
    //   612: goto -116 -> 496
    //   615: astore_0
    //   616: goto -116 -> 500
    //   619: astore_0
    //   620: goto -115 -> 505
    //   623: astore_0
    //   624: goto -468 -> 156
    //   627: astore_0
    //   628: goto -464 -> 164
    //   631: astore_0
    //   632: goto -458 -> 174
    //   635: astore_0
    //   636: goto -400 -> 236
    //   639: astore_0
    //   640: goto -396 -> 244
    //   643: astore_0
    //   644: goto -390 -> 254
    //   647: astore_0
    //   648: goto -332 -> 316
    //   651: astore_0
    //   652: goto -328 -> 324
    //   655: astore_0
    //   656: goto -322 -> 334
    //   659: astore_0
    //   660: goto -586 -> 74
    //   663: astore_0
    //   664: goto -580 -> 84
    //   667: astore_0
    //   668: goto -574 -> 94
    //   671: astore_3
    //   672: aconst_null
    //   673: astore_2
    //   674: aload_0
    //   675: astore 7
    //   677: aload_3
    //   678: astore_0
    //   679: goto -114 -> 565
    //   682: astore_3
    //   683: aload_0
    //   684: astore 7
    //   686: aload_3
    //   687: astore_0
    //   688: goto -123 -> 565
    //   691: astore_3
    //   692: aconst_null
    //   693: astore_2
    //   694: aload_0
    //   695: astore 7
    //   697: aload_3
    //   698: astore_0
    //   699: goto -149 -> 550
    //   702: astore_3
    //   703: aload_0
    //   704: astore 7
    //   706: aload_3
    //   707: astore_0
    //   708: goto -158 -> 550
    //   711: astore_3
    //   712: aconst_null
    //   713: astore_2
    //   714: aload_0
    //   715: astore 7
    //   717: aload_3
    //   718: astore_0
    //   719: goto -184 -> 535
    //   722: astore_3
    //   723: aload_0
    //   724: astore 7
    //   726: aload_3
    //   727: astore_0
    //   728: goto -193 -> 535
    //   731: astore_2
    //   732: aconst_null
    //   733: astore 4
    //   735: aload_0
    //   736: astore_3
    //   737: aload_2
    //   738: astore_0
    //   739: aload 4
    //   741: astore_2
    //   742: goto -224 -> 518
    //   745: astore 4
    //   747: aload_0
    //   748: astore_3
    //   749: aload 4
    //   751: astore_0
    //   752: goto -234 -> 518
    //   755: astore 8
    //   757: aload_0
    //   758: astore 7
    //   760: goto -569 -> 191
    //   763: astore 8
    //   765: aload_0
    //   766: astore 7
    //   768: goto -657 -> 111
    //   771: astore 8
    //   773: aload_0
    //   774: astore 7
    //   776: goto -505 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	779	0	paramString	String
    //   0	779	1	paramInt	int
    //   57	43	2	localObject1	Object
    //   104	458	2	localObject2	Object
    //   574	1	2	localObject3	Object
    //   673	41	2	localObject4	Object
    //   731	7	2	localObject5	Object
    //   741	1	2	localObject6	Object
    //   65	453	3	localObject7	Object
    //   671	7	3	localMalformedURLException1	java.net.MalformedURLException
    //   682	5	3	localMalformedURLException2	java.net.MalformedURLException
    //   691	7	3	localIOException1	java.io.IOException
    //   702	5	3	localIOException2	java.io.IOException
    //   711	7	3	localException1	Exception
    //   722	5	3	localException2	Exception
    //   736	13	3	str1	String
    //   59	681	4	localObject8	Object
    //   745	5	4	localObject9	Object
    //   62	522	5	localObject10	Object
    //   106	461	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   109	666	7	localObject11	Object
    //   101	32	8	localException3	Exception
    //   181	32	8	localIOException3	java.io.IOException
    //   261	32	8	localMalformedURLException3	java.net.MalformedURLException
    //   539	31	8	str2	String
    //   755	1	8	localIOException4	java.io.IOException
    //   763	1	8	localException4	Exception
    //   771	1	8	localMalformedURLException4	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   35	42	57	finally
    //   369	376	57	finally
    //   35	42	101	java/lang/Exception
    //   369	376	101	java/lang/Exception
    //   35	42	181	java/io/IOException
    //   369	376	181	java/io/IOException
    //   35	42	261	java/net/MalformedURLException
    //   369	376	261	java/net/MalformedURLException
    //   16	31	513	finally
    //   16	31	529	java/lang/Exception
    //   16	31	544	java/io/IOException
    //   16	31	559	java/net/MalformedURLException
    //   121	146	574	finally
    //   201	226	574	finally
    //   281	306	574	finally
    //   410	417	574	finally
    //   426	433	574	finally
    //   447	456	574	finally
    //   468	475	574	finally
    //   484	492	574	finally
    //   46	50	603	finally
    //   376	380	607	finally
    //   492	496	611	finally
    //   496	500	615	finally
    //   500	505	619	finally
    //   151	156	623	finally
    //   160	164	627	finally
    //   169	174	631	finally
    //   231	236	635	finally
    //   240	244	639	finally
    //   249	254	643	finally
    //   311	316	647	finally
    //   320	324	651	finally
    //   329	334	655	finally
    //   70	74	659	finally
    //   79	84	663	finally
    //   89	94	667	finally
    //   341	362	671	java/net/MalformedURLException
    //   387	392	671	java/net/MalformedURLException
    //   392	401	682	java/net/MalformedURLException
    //   341	362	691	java/io/IOException
    //   387	392	691	java/io/IOException
    //   392	401	702	java/io/IOException
    //   341	362	711	java/lang/Exception
    //   387	392	711	java/lang/Exception
    //   392	401	722	java/lang/Exception
    //   341	362	731	finally
    //   387	392	731	finally
    //   392	401	745	finally
    //   410	417	755	java/io/IOException
    //   426	433	755	java/io/IOException
    //   447	456	755	java/io/IOException
    //   468	475	755	java/io/IOException
    //   484	492	755	java/io/IOException
    //   410	417	763	java/lang/Exception
    //   426	433	763	java/lang/Exception
    //   447	456	763	java/lang/Exception
    //   468	475	763	java/lang/Exception
    //   484	492	763	java/lang/Exception
    //   410	417	771	java/net/MalformedURLException
    //   426	433	771	java/net/MalformedURLException
    //   447	456	771	java/net/MalformedURLException
    //   468	475	771	java/net/MalformedURLException
    //   484	492	771	java/net/MalformedURLException
  }
  
  public static byte[] a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(242955);
    Object localObject = new StringBuffer();
    if (paramString1 != null) {
      ((StringBuffer)localObject).append(paramString1);
    }
    ((StringBuffer)localObject).append(paramInt);
    ((StringBuffer)localObject).append(paramString2);
    ((StringBuffer)localObject).append("mMcShCsTr");
    paramString2 = ((StringBuffer)localObject).toString().substring(1, 9).getBytes();
    paramString1 = new char[16];
    paramString1[0] = 48;
    paramString1[1] = 49;
    paramString1[2] = 50;
    paramString1[3] = 51;
    paramString1[4] = 52;
    paramString1[5] = 53;
    paramString1[6] = 54;
    paramString1[7] = 55;
    paramString1[8] = 56;
    paramString1[9] = 57;
    paramString1[10] = 97;
    paramString1[11] = 98;
    paramString1[12] = 99;
    paramString1[13] = 100;
    paramString1[14] = 101;
    paramString1[15] = 102;
    for (;;)
    {
      int j;
      int i;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString2);
        paramString2 = ((MessageDigest)localObject).digest();
        j = paramString2.length;
        localObject = new char[j * 2];
        paramInt = 0;
        i = 0;
      }
      catch (Exception paramString1)
      {
        paramString1 = null;
        continue;
      }
      paramString1 = new String((char[])localObject);
      paramString1 = paramString1.getBytes();
      AppMethodBeat.o(242955);
      return paramString1;
      while (paramInt < j)
      {
        int m = paramString2[paramInt];
        int k = i + 1;
        localObject[i] = paramString1[(m >>> 4 & 0xF)];
        localObject[k] = paramString1[(m & 0xF)];
        paramInt += 1;
        i = k + 1;
      }
    }
  }
  
  public static class a
  {
    public String a;
    public String b;
    public String c;
    public long d;
    public Bundle e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.a.a
 * JD-Core Version:    0.7.0.1
 */