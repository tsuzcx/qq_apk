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
  public static Object a(int paramInt, String paramString)
  {
    AppMethodBeat.i(190382);
    switch (paramInt)
    {
    }
    try
    {
      Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
      AppMethodBeat.o(190382);
      return null;
      paramString = Double.valueOf(paramString);
      AppMethodBeat.o(190382);
      return paramString;
      paramString = Float.valueOf(paramString);
      AppMethodBeat.o(190382);
      return paramString;
      paramString = Boolean.valueOf(paramString);
      AppMethodBeat.o(190382);
      return paramString;
      AppMethodBeat.o(190382);
      return paramString;
      paramString = Long.valueOf(paramString);
      AppMethodBeat.o(190382);
      return paramString;
      paramString = Integer.valueOf(paramString);
      AppMethodBeat.o(190382);
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
    AppMethodBeat.i(190381);
    if (paramBundle == null)
    {
      AppMethodBeat.o(190381);
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      AppMethodBeat.o(190381);
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
      localIntent.putExtra("_mmessage_sdkVersion", 637928960);
      localIntent.putExtra("_mmessage_appPackage", (String)localObject);
      localIntent.putExtra("_mmessage_content", parama.c);
      localIntent.putExtra("_mmessage_support_content_type", parama.d);
      localIntent.putExtra("_mmessage_checksum", a(parama.c, 637928960, (String)localObject));
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
    //   0: ldc 179
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +581 -> 587
    //   9: aload_0
    //   10: invokevirtual 185	java/lang/String:length	()I
    //   13: ifeq +574 -> 587
    //   16: new 187	java/net/URL
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 188	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 192	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 194	java/net/HttpURLConnection
    //   30: astore_0
    //   31: aload_0
    //   32: ifnonnull +309 -> 341
    //   35: ldc 196
    //   37: ldc 198
    //   39: invokestatic 27	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: ifnull +7 -> 50
    //   46: aload_0
    //   47: invokevirtual 201	java/net/HttpURLConnection:disconnect	()V
    //   50: ldc 179
    //   52: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   71: invokevirtual 201	java/net/HttpURLConnection:disconnect	()V
    //   74: aload 4
    //   76: ifnull +8 -> 84
    //   79: aload 4
    //   81: invokevirtual 206	java/io/InputStream:close	()V
    //   84: aload 5
    //   86: ifnull +8 -> 94
    //   89: aload 5
    //   91: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   94: ldc 179
    //   96: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   121: ldc 196
    //   123: new 58	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 211
    //   129: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload 8
    //   134: invokevirtual 68	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   137: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 27	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload 7
    //   148: ifnull +8 -> 156
    //   151: aload 7
    //   153: invokevirtual 201	java/net/HttpURLConnection:disconnect	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 206	java/io/InputStream:close	()V
    //   164: aload 6
    //   166: ifnull +8 -> 174
    //   169: aload 6
    //   171: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   174: ldc 179
    //   176: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   201: ldc 196
    //   203: new 58	java/lang/StringBuilder
    //   206: dup
    //   207: ldc 211
    //   209: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload 8
    //   214: invokevirtual 212	java/io/IOException:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 27	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 7
    //   228: ifnull +8 -> 236
    //   231: aload 7
    //   233: invokevirtual 201	java/net/HttpURLConnection:disconnect	()V
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 206	java/io/InputStream:close	()V
    //   244: aload 6
    //   246: ifnull +8 -> 254
    //   249: aload 6
    //   251: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   254: ldc 179
    //   256: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   281: ldc 196
    //   283: new 58	java/lang/StringBuilder
    //   286: dup
    //   287: ldc 211
    //   289: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload 8
    //   294: invokevirtual 213	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 27	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload 7
    //   308: ifnull +8 -> 316
    //   311: aload 7
    //   313: invokevirtual 201	java/net/HttpURLConnection:disconnect	()V
    //   316: aload_2
    //   317: ifnull +7 -> 324
    //   320: aload_2
    //   321: invokevirtual 206	java/io/InputStream:close	()V
    //   324: aload 6
    //   326: ifnull +8 -> 334
    //   329: aload 6
    //   331: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   334: ldc 179
    //   336: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aconst_null
    //   340: areturn
    //   341: aload_0
    //   342: ldc 215
    //   344: invokevirtual 218	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   347: aload_0
    //   348: iload_1
    //   349: invokevirtual 221	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   352: aload_0
    //   353: iload_1
    //   354: invokevirtual 224	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   357: aload_0
    //   358: invokevirtual 227	java/net/HttpURLConnection:getResponseCode	()I
    //   361: istore_1
    //   362: iload_1
    //   363: sipush 300
    //   366: if_icmplt +21 -> 387
    //   369: ldc 196
    //   371: ldc 229
    //   373: invokestatic 27	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload_0
    //   377: invokevirtual 201	java/net/HttpURLConnection:disconnect	()V
    //   380: ldc 179
    //   382: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aconst_null
    //   386: areturn
    //   387: aload_0
    //   388: invokevirtual 233	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   391: astore_2
    //   392: new 208	java/io/ByteArrayOutputStream
    //   395: dup
    //   396: invokespecial 234	java/io/ByteArrayOutputStream:<init>	()V
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
    //   429: invokevirtual 238	java/io/InputStream:read	([B)I
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
    //   453: invokevirtual 242	java/io/ByteArrayOutputStream:write	([BII)V
    //   456: goto -39 -> 417
    //   459: aload_0
    //   460: astore_3
    //   461: aload_2
    //   462: astore 5
    //   464: aload 6
    //   466: astore 4
    //   468: aload 6
    //   470: invokevirtual 246	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   473: astore 7
    //   475: aload_0
    //   476: astore_3
    //   477: aload_2
    //   478: astore 5
    //   480: aload 6
    //   482: astore 4
    //   484: ldc 196
    //   486: ldc 248
    //   488: invokestatic 171	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: aload_0
    //   492: invokevirtual 201	java/net/HttpURLConnection:disconnect	()V
    //   495: aload_2
    //   496: invokevirtual 206	java/io/InputStream:close	()V
    //   499: aload 6
    //   501: invokevirtual 209	java/io/ByteArrayOutputStream:close	()V
    //   504: ldc 179
    //   506: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   509: aload 7
    //   511: areturn
    //   512: astore_0
    //   513: aconst_null
    //   514: astore_2
    //   515: aconst_null
    //   516: astore_3
    //   517: aload_2
    //   518: astore 4
    //   520: aconst_null
    //   521: astore 5
    //   523: aload_0
    //   524: astore_2
    //   525: goto -459 -> 66
    //   528: astore_0
    //   529: aconst_null
    //   530: astore_2
    //   531: aconst_null
    //   532: astore 7
    //   534: aconst_null
    //   535: astore 6
    //   537: aload_0
    //   538: astore 8
    //   540: goto -429 -> 111
    //   543: astore_0
    //   544: aconst_null
    //   545: astore_2
    //   546: aconst_null
    //   547: astore 7
    //   549: aconst_null
    //   550: astore 6
    //   552: aload_0
    //   553: astore 8
    //   555: goto -364 -> 191
    //   558: astore_0
    //   559: aconst_null
    //   560: astore_2
    //   561: aconst_null
    //   562: astore 7
    //   564: aconst_null
    //   565: astore 6
    //   567: aload_0
    //   568: astore 8
    //   570: goto -299 -> 271
    //   573: astore_2
    //   574: aload 4
    //   576: astore_0
    //   577: aload 5
    //   579: astore 4
    //   581: aload_0
    //   582: astore 5
    //   584: goto -518 -> 66
    //   587: ldc 196
    //   589: ldc 250
    //   591: invokestatic 27	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: ldc 179
    //   596: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   599: aconst_null
    //   600: areturn
    //   601: astore_0
    //   602: goto -552 -> 50
    //   605: astore_0
    //   606: goto -226 -> 380
    //   609: astore_0
    //   610: goto -115 -> 495
    //   613: astore_0
    //   614: goto -115 -> 499
    //   617: astore_0
    //   618: goto -114 -> 504
    //   621: astore_0
    //   622: goto -466 -> 156
    //   625: astore_0
    //   626: goto -462 -> 164
    //   629: astore_0
    //   630: goto -456 -> 174
    //   633: astore_0
    //   634: goto -398 -> 236
    //   637: astore_0
    //   638: goto -394 -> 244
    //   641: astore_0
    //   642: goto -388 -> 254
    //   645: astore_0
    //   646: goto -330 -> 316
    //   649: astore_0
    //   650: goto -326 -> 324
    //   653: astore_0
    //   654: goto -320 -> 334
    //   657: astore_0
    //   658: goto -584 -> 74
    //   661: astore_0
    //   662: goto -578 -> 84
    //   665: astore_0
    //   666: goto -572 -> 94
    //   669: astore_3
    //   670: aconst_null
    //   671: astore_2
    //   672: aload_0
    //   673: astore 7
    //   675: aload_3
    //   676: astore_0
    //   677: goto -113 -> 564
    //   680: astore_3
    //   681: aload_0
    //   682: astore 7
    //   684: aload_3
    //   685: astore_0
    //   686: goto -122 -> 564
    //   689: astore_3
    //   690: aconst_null
    //   691: astore_2
    //   692: aload_0
    //   693: astore 7
    //   695: aload_3
    //   696: astore_0
    //   697: goto -148 -> 549
    //   700: astore_3
    //   701: aload_0
    //   702: astore 7
    //   704: aload_3
    //   705: astore_0
    //   706: goto -157 -> 549
    //   709: astore_3
    //   710: aconst_null
    //   711: astore_2
    //   712: aload_0
    //   713: astore 7
    //   715: aload_3
    //   716: astore_0
    //   717: goto -183 -> 534
    //   720: astore_3
    //   721: aload_0
    //   722: astore 7
    //   724: aload_3
    //   725: astore_0
    //   726: goto -192 -> 534
    //   729: astore_2
    //   730: aconst_null
    //   731: astore 4
    //   733: aload_0
    //   734: astore_3
    //   735: aload_2
    //   736: astore_0
    //   737: aload 4
    //   739: astore_2
    //   740: goto -223 -> 517
    //   743: astore 4
    //   745: aload_0
    //   746: astore_3
    //   747: aload 4
    //   749: astore_0
    //   750: goto -233 -> 517
    //   753: astore 8
    //   755: aload_0
    //   756: astore 7
    //   758: goto -567 -> 191
    //   761: astore 8
    //   763: aload_0
    //   764: astore 7
    //   766: goto -655 -> 111
    //   769: astore 8
    //   771: aload_0
    //   772: astore 7
    //   774: goto -503 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	777	0	paramString	String
    //   0	777	1	paramInt	int
    //   57	43	2	localObject1	Object
    //   104	457	2	localObject2	Object
    //   573	1	2	localObject3	Object
    //   671	41	2	localObject4	Object
    //   729	7	2	localObject5	Object
    //   739	1	2	localObject6	Object
    //   65	452	3	localObject7	Object
    //   669	7	3	localMalformedURLException1	java.net.MalformedURLException
    //   680	5	3	localMalformedURLException2	java.net.MalformedURLException
    //   689	7	3	localIOException1	java.io.IOException
    //   700	5	3	localIOException2	java.io.IOException
    //   709	7	3	localException1	Exception
    //   720	5	3	localException2	Exception
    //   734	13	3	str1	String
    //   59	679	4	localObject8	Object
    //   743	5	4	localObject9	Object
    //   62	521	5	localObject10	Object
    //   106	460	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   109	664	7	localObject11	Object
    //   101	32	8	localException3	Exception
    //   181	32	8	localIOException3	java.io.IOException
    //   261	32	8	localMalformedURLException3	java.net.MalformedURLException
    //   538	31	8	str2	String
    //   753	1	8	localIOException4	java.io.IOException
    //   761	1	8	localException4	Exception
    //   769	1	8	localMalformedURLException4	java.net.MalformedURLException
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
    //   16	31	512	finally
    //   16	31	528	java/lang/Exception
    //   16	31	543	java/io/IOException
    //   16	31	558	java/net/MalformedURLException
    //   121	146	573	finally
    //   201	226	573	finally
    //   281	306	573	finally
    //   410	417	573	finally
    //   426	433	573	finally
    //   447	456	573	finally
    //   468	475	573	finally
    //   484	491	573	finally
    //   46	50	601	finally
    //   376	380	605	finally
    //   491	495	609	finally
    //   495	499	613	finally
    //   499	504	617	finally
    //   151	156	621	finally
    //   160	164	625	finally
    //   169	174	629	finally
    //   231	236	633	finally
    //   240	244	637	finally
    //   249	254	641	finally
    //   311	316	645	finally
    //   320	324	649	finally
    //   329	334	653	finally
    //   70	74	657	finally
    //   79	84	661	finally
    //   89	94	665	finally
    //   341	362	669	java/net/MalformedURLException
    //   387	392	669	java/net/MalformedURLException
    //   392	401	680	java/net/MalformedURLException
    //   341	362	689	java/io/IOException
    //   387	392	689	java/io/IOException
    //   392	401	700	java/io/IOException
    //   341	362	709	java/lang/Exception
    //   387	392	709	java/lang/Exception
    //   392	401	720	java/lang/Exception
    //   341	362	729	finally
    //   387	392	729	finally
    //   392	401	743	finally
    //   410	417	753	java/io/IOException
    //   426	433	753	java/io/IOException
    //   447	456	753	java/io/IOException
    //   468	475	753	java/io/IOException
    //   484	491	753	java/io/IOException
    //   410	417	761	java/lang/Exception
    //   426	433	761	java/lang/Exception
    //   447	456	761	java/lang/Exception
    //   468	475	761	java/lang/Exception
    //   484	491	761	java/lang/Exception
    //   410	417	769	java/net/MalformedURLException
    //   426	433	769	java/net/MalformedURLException
    //   447	456	769	java/net/MalformedURLException
    //   468	475	769	java/net/MalformedURLException
    //   484	491	769	java/net/MalformedURLException
  }
  
  public static byte[] a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(190379);
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
      AppMethodBeat.o(190379);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.a.a
 * JD-Core Version:    0.7.0.1
 */