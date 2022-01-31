package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiManufacturerLoadingUI$5
  implements Runnable
{
  private int kst = 0;
  private final int ksu = 5;
  
  FreeWifiManufacturerLoadingUI$5(FreeWifiManufacturerLoadingUI paramFreeWifiManufacturerLoadingUI, String paramString) {}
  
  private void aVe()
  {
    y.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
    this.kst += 1;
    try
    {
      Thread.sleep(2000L);
      aVf();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        y.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + localInterruptedException.getMessage());
      }
    }
  }
  
  /* Error */
  private void aVf()
  {
    // Byte code:
    //   0: invokestatic 82	com/tencent/mm/plugin/freewifi/h$b:aTv	()Lcom/tencent/mm/plugin/freewifi/h;
    //   3: invokevirtual 87	com/tencent/mm/plugin/freewifi/h:aTu	()Ljava/lang/String;
    //   6: astore 4
    //   8: ldc 34
    //   10: new 55	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 89
    //   16: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload 4
    //   21: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 42	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   34: aload_0
    //   35: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   38: getstatic 94	com/tencent/mm/R$l:free_wifi_manufacturer_loading_getting_portal_url	I
    //   41: invokevirtual 98	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:getString	(I)Ljava/lang/String;
    //   44: invokestatic 101	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore_2
    //   49: aconst_null
    //   50: astore 5
    //   52: new 103	java/net/URL
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 104	java/net/URL:<init>	(Ljava/lang/String;)V
    //   61: invokevirtual 108	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   64: checkcast 110	java/net/HttpURLConnection
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +457 -> 526
    //   72: aload_3
    //   73: sipush 5000
    //   76: invokevirtual 114	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   79: aload_3
    //   80: sipush 5000
    //   83: invokevirtual 117	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   86: aload_3
    //   87: iconst_0
    //   88: invokevirtual 121	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   91: aload_3
    //   92: iconst_0
    //   93: invokevirtual 124	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   96: aload_3
    //   97: ldc 126
    //   99: ldc 128
    //   101: invokevirtual 131	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: ldc 133
    //   107: ldc 128
    //   109: invokevirtual 131	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_3
    //   113: invokevirtual 137	java/net/HttpURLConnection:getResponseCode	()I
    //   116: istore_1
    //   117: ldc 34
    //   119: new 55	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 139
    //   125: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: iload_1
    //   129: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 42	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: sipush 200
    //   141: iload_1
    //   142: if_icmpne +284 -> 426
    //   145: ldc 34
    //   147: invokestatic 148	com/tencent/mm/plugin/freewifi/m:Do	(Ljava/lang/String;)Ljava/lang/String;
    //   150: aload_0
    //   151: getfield 21	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:knT	Ljava/lang/String;
    //   154: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifne +24 -> 181
    //   160: aload_0
    //   161: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   164: sipush 1150
    //   167: ldc 156
    //   169: invokestatic 159	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
    //   172: aload_3
    //   173: ifnull +7 -> 180
    //   176: aload_3
    //   177: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   180: return
    //   181: aload_3
    //   182: invokevirtual 166	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   185: invokestatic 170	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:y	(Ljava/io/InputStream;)Ljava/lang/String;
    //   188: astore_2
    //   189: ldc 34
    //   191: new 55	java/lang/StringBuilder
    //   194: dup
    //   195: ldc 172
    //   197: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: aload_2
    //   201: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 42	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_2
    //   211: ldc 174
    //   213: invokevirtual 178	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   216: iconst_m1
    //   217: if_icmpne +21 -> 238
    //   220: aload_0
    //   221: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   224: aload 4
    //   226: invokestatic 181	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:b	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
    //   229: aload_3
    //   230: ifnull -50 -> 180
    //   233: aload_3
    //   234: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   237: return
    //   238: aload_0
    //   239: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   242: iconst_0
    //   243: ldc 183
    //   245: invokestatic 159	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
    //   248: ldc 34
    //   250: ldc 185
    //   252: invokestatic 42	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_0
    //   256: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   259: iconst_0
    //   260: ldc 183
    //   262: invokestatic 159	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
    //   265: aload_0
    //   266: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   269: aload_0
    //   270: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   273: getstatic 188	com/tencent/mm/R$l:free_wifi_manufacturer_loading_already_connected	I
    //   276: invokevirtual 98	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:getString	(I)Ljava/lang/String;
    //   279: invokestatic 101	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
    //   282: aload_0
    //   283: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   286: invokestatic 191	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:e	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;)V
    //   289: aload_0
    //   290: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   293: invokestatic 194	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:f	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;)V
    //   296: goto -124 -> 172
    //   299: astore 4
    //   301: aload_3
    //   302: astore_2
    //   303: new 196	java/io/StringWriter
    //   306: dup
    //   307: invokespecial 197	java/io/StringWriter:<init>	()V
    //   310: astore 5
    //   312: aload_3
    //   313: astore_2
    //   314: aload 4
    //   316: new 199	java/io/PrintWriter
    //   319: dup
    //   320: aload 5
    //   322: invokespecial 202	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   325: invokevirtual 206	java/lang/Exception:printStackTrace	(Ljava/io/PrintWriter;)V
    //   328: aload_3
    //   329: astore_2
    //   330: aload 5
    //   332: invokevirtual 207	java/io/StringWriter:toString	()Ljava/lang/String;
    //   335: astore 5
    //   337: aload_3
    //   338: astore_2
    //   339: ldc 34
    //   341: new 55	java/lang/StringBuilder
    //   344: dup
    //   345: ldc 209
    //   347: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload 5
    //   352: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 42	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_3
    //   362: astore_2
    //   363: aload 4
    //   365: instanceof 211
    //   368: ifeq +228 -> 596
    //   371: aload_3
    //   372: astore_2
    //   373: ldc 34
    //   375: ldc 213
    //   377: iconst_2
    //   378: anewarray 4	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: aload_0
    //   384: getfield 26	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:kst	I
    //   387: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: aastore
    //   391: dup
    //   392: iconst_1
    //   393: iconst_5
    //   394: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aastore
    //   398: invokestatic 222	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: aload_3
    //   402: astore_2
    //   403: aload_0
    //   404: getfield 26	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:kst	I
    //   407: iconst_5
    //   408: if_icmpge +188 -> 596
    //   411: aload_3
    //   412: astore_2
    //   413: aload_0
    //   414: invokespecial 224	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:aVe	()V
    //   417: aload_3
    //   418: ifnull -238 -> 180
    //   421: aload_3
    //   422: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   425: return
    //   426: sipush 302
    //   429: iload_1
    //   430: if_icmpne +75 -> 505
    //   433: ldc 34
    //   435: ldc 226
    //   437: iconst_1
    //   438: anewarray 4	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: aload_3
    //   444: ldc 228
    //   446: invokevirtual 231	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   449: aastore
    //   450: invokestatic 222	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   453: aload_3
    //   454: ldc 228
    //   456: invokevirtual 231	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   459: astore_2
    //   460: aload_2
    //   461: invokestatic 235	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   464: ifne +20 -> 484
    //   467: aload_0
    //   468: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   471: aload_2
    //   472: invokestatic 181	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:b	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;Ljava/lang/String;)V
    //   475: aload_3
    //   476: ifnull -296 -> 180
    //   479: aload_3
    //   480: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   483: return
    //   484: aload_0
    //   485: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   488: sipush 1146
    //   491: ldc 237
    //   493: invokestatic 159	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
    //   496: aload_3
    //   497: ifnull -317 -> 180
    //   500: aload_3
    //   501: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   504: return
    //   505: aload_0
    //   506: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   509: sipush 1149
    //   512: ldc 239
    //   514: invokestatic 159	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
    //   517: aload_3
    //   518: ifnull -338 -> 180
    //   521: aload_3
    //   522: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   525: return
    //   526: ldc 34
    //   528: ldc 241
    //   530: iconst_2
    //   531: anewarray 4	java/lang/Object
    //   534: dup
    //   535: iconst_0
    //   536: aload_0
    //   537: getfield 26	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:kst	I
    //   540: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   543: aastore
    //   544: dup
    //   545: iconst_1
    //   546: iconst_5
    //   547: invokestatic 219	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   550: aastore
    //   551: invokestatic 222	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: aload_0
    //   555: getfield 26	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:kst	I
    //   558: iconst_5
    //   559: if_icmpge +16 -> 575
    //   562: aload_0
    //   563: invokespecial 224	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:aVe	()V
    //   566: aload_3
    //   567: ifnull -387 -> 180
    //   570: aload_3
    //   571: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   574: return
    //   575: aload_0
    //   576: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   579: sipush 1148
    //   582: ldc 243
    //   584: invokestatic 159	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
    //   587: aload_3
    //   588: ifnull -408 -> 180
    //   591: aload_3
    //   592: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   595: return
    //   596: aload_3
    //   597: astore_2
    //   598: aload_0
    //   599: getfield 19	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI$5:ksr	Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;
    //   602: sipush 1153
    //   605: ldc 243
    //   607: invokestatic 159	com/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI:a	(Lcom/tencent/mm/plugin/freewifi/ui/FreeWifiManufacturerLoadingUI;ILjava/lang/String;)V
    //   610: aload_3
    //   611: ifnull -431 -> 180
    //   614: aload_3
    //   615: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   618: return
    //   619: astore_3
    //   620: aload_2
    //   621: ifnull +7 -> 628
    //   624: aload_2
    //   625: invokevirtual 162	java/net/HttpURLConnection:disconnect	()V
    //   628: aload_3
    //   629: athrow
    //   630: astore 4
    //   632: aload_3
    //   633: astore_2
    //   634: aload 4
    //   636: astore_3
    //   637: goto -17 -> 620
    //   640: astore 4
    //   642: aload 5
    //   644: astore_3
    //   645: goto -344 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	5
    //   116	315	1	i	int
    //   48	586	2	localObject1	Object
    //   67	548	3	localHttpURLConnection	java.net.HttpURLConnection
    //   619	14	3	localObject2	Object
    //   636	9	3	localObject3	Object
    //   6	219	4	str	String
    //   299	65	4	localException1	java.lang.Exception
    //   630	5	4	localObject4	Object
    //   640	1	4	localException2	java.lang.Exception
    //   50	593	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   72	138	299	java/lang/Exception
    //   145	172	299	java/lang/Exception
    //   181	229	299	java/lang/Exception
    //   238	296	299	java/lang/Exception
    //   433	475	299	java/lang/Exception
    //   484	496	299	java/lang/Exception
    //   505	517	299	java/lang/Exception
    //   526	566	299	java/lang/Exception
    //   575	587	299	java/lang/Exception
    //   52	68	619	finally
    //   303	312	619	finally
    //   314	328	619	finally
    //   330	337	619	finally
    //   339	361	619	finally
    //   363	371	619	finally
    //   373	401	619	finally
    //   403	411	619	finally
    //   413	417	619	finally
    //   598	610	619	finally
    //   72	138	630	finally
    //   145	172	630	finally
    //   181	229	630	finally
    //   238	296	630	finally
    //   433	475	630	finally
    //   484	496	630	finally
    //   505	517	630	finally
    //   526	566	630	finally
    //   575	587	630	finally
    //   52	68	640	java/lang/Exception
  }
  
  public final void run()
  {
    Context localContext = ae.getContext();
    if (localContext == null)
    {
      FreeWifiManufacturerLoadingUI.a(this.ksr, 1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
      return;
    }
    if ((!m.aTE()) || (!m.Do("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(this.knT)))
    {
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + this.knT);
      FreeWifiManufacturerLoadingUI.a(this.ksr, this.ksr.getString(R.l.free_wifi_manufacturer_loading_switching_ssid));
      int i = new b(this.knT, localContext).aTm();
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=" + i);
      if (i != 0)
      {
        FreeWifiManufacturerLoadingUI.a(this.ksr, i, "An attempt to switch to special portal ap failed. connectRet=" + i);
        return;
      }
    }
    aVf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.5
 * JD-Core Version:    0.7.0.1
 */