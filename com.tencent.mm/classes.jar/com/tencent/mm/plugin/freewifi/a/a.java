package com.tencent.mm.plugin.freewifi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import java.net.HttpURLConnection;

public final class a
{
  private static final int tma;
  private static final int tmb;
  
  static
  {
    AppMethodBeat.i(24737);
    tma = h.b.cQP().cQL();
    tmb = h.b.cQP().cQM();
    AppMethodBeat.o(24737);
  }
  
  /* Error */
  public static void a(java.lang.String paramString, a parama)
  {
    // Byte code:
    //   0: sipush 24735
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 56
    //   8: ldc 58
    //   10: iconst_1
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_0
    //   17: aastore
    //   18: invokestatic 63	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: invokestatic 69	com/tencent/mm/plugin/freewifi/m:ea	(Ljava/lang/String;)Z
    //   25: ifeq +10 -> 35
    //   28: sipush 24735
    //   31: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: return
    //   35: aconst_null
    //   36: astore_2
    //   37: aconst_null
    //   38: astore 4
    //   40: new 71	java/net/URL
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 74	java/net/URL:<init>	(Ljava/lang/String;)V
    //   48: invokevirtual 78	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   51: checkcast 80	java/net/HttpURLConnection
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +46 -> 102
    //   59: aload_0
    //   60: getstatic 35	com/tencent/mm/plugin/freewifi/a/a:tma	I
    //   63: invokevirtual 83	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   66: aload_0
    //   67: getstatic 40	com/tencent/mm/plugin/freewifi/a/a:tmb	I
    //   70: invokevirtual 86	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   73: aload_0
    //   74: ldc 88
    //   76: invokestatic 27	com/tencent/mm/plugin/freewifi/h$b:cQP	()Lcom/tencent/mm/plugin/freewifi/h;
    //   79: invokevirtual 92	com/tencent/mm/plugin/freewifi/h:getUserAgent	()Ljava/lang/String;
    //   82: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: iconst_0
    //   87: invokevirtual 100	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   90: aload_0
    //   91: iconst_0
    //   92: invokevirtual 103	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   95: aload_1
    //   96: aload_0
    //   97: invokeinterface 107 2 0
    //   102: aload_0
    //   103: ifnull +142 -> 245
    //   106: aload_0
    //   107: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   110: invokevirtual 116	java/io/InputStream:close	()V
    //   113: aload_0
    //   114: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   117: sipush 24735
    //   120: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: astore_2
    //   125: aload_1
    //   126: aload_2
    //   127: invokeinterface 122 2 0
    //   132: goto -30 -> 102
    //   135: astore_3
    //   136: aload_0
    //   137: astore_2
    //   138: aload_1
    //   139: aload_3
    //   140: invokeinterface 122 2 0
    //   145: aload_0
    //   146: ifnull +99 -> 245
    //   149: aload_0
    //   150: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   153: invokevirtual 116	java/io/InputStream:close	()V
    //   156: aload_0
    //   157: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   160: sipush 24735
    //   163: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: astore_2
    //   168: aload_1
    //   169: aload_2
    //   170: invokeinterface 122 2 0
    //   175: goto -73 -> 102
    //   178: astore_1
    //   179: aload_0
    //   180: astore_2
    //   181: aload_1
    //   182: astore_0
    //   183: aload_2
    //   184: ifnull +14 -> 198
    //   187: aload_2
    //   188: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   191: invokevirtual 116	java/io/InputStream:close	()V
    //   194: aload_2
    //   195: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   198: sipush 24735
    //   201: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_0
    //   205: athrow
    //   206: astore_1
    //   207: ldc 56
    //   209: aload_1
    //   210: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   213: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: goto -103 -> 113
    //   219: astore_1
    //   220: ldc 56
    //   222: aload_1
    //   223: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: goto -73 -> 156
    //   232: astore_1
    //   233: ldc 56
    //   235: aload_1
    //   236: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -48 -> 194
    //   245: sipush 24735
    //   248: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    //   252: astore_0
    //   253: goto -70 -> 183
    //   256: astore_3
    //   257: aload 4
    //   259: astore_0
    //   260: goto -124 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramString	java.lang.String
    //   0	263	1	parama	a
    //   36	1	2	localObject1	Object
    //   124	3	2	localIOException	java.io.IOException
    //   137	1	2	str1	java.lang.String
    //   167	3	2	localException1	Exception
    //   180	15	2	str2	java.lang.String
    //   135	5	3	localException2	Exception
    //   256	1	3	localException3	Exception
    //   38	220	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   95	102	124	java/io/IOException
    //   59	95	135	java/lang/Exception
    //   125	132	135	java/lang/Exception
    //   168	175	135	java/lang/Exception
    //   95	102	167	java/lang/Exception
    //   59	95	178	finally
    //   95	102	178	finally
    //   125	132	178	finally
    //   168	175	178	finally
    //   106	113	206	java/lang/Exception
    //   149	156	219	java/lang/Exception
    //   187	194	232	java/lang/Exception
    //   40	55	252	finally
    //   138	145	252	finally
    //   40	55	256	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.lang.String paramString1, java.lang.String paramString2, a parama)
  {
    // Byte code:
    //   0: sipush 24736
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 56
    //   8: ldc 131
    //   10: iconst_2
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_0
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_1
    //   21: aastore
    //   22: invokestatic 63	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: invokestatic 69	com/tencent/mm/plugin/freewifi/m:ea	(Ljava/lang/String;)Z
    //   29: ifne +10 -> 39
    //   32: aload_1
    //   33: invokestatic 69	com/tencent/mm/plugin/freewifi/m:ea	(Ljava/lang/String;)Z
    //   36: ifeq +10 -> 46
    //   39: sipush 24736
    //   42: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_1
    //   47: ifnull +12 -> 59
    //   50: ldc 133
    //   52: aload_1
    //   53: invokevirtual 138	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   56: ifeq +194 -> 250
    //   59: ldc 133
    //   61: astore 6
    //   63: ldc 56
    //   65: ldc 140
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_0
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload 6
    //   79: aastore
    //   80: invokestatic 63	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aconst_null
    //   84: astore_1
    //   85: aconst_null
    //   86: astore 7
    //   88: new 71	java/net/URL
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 74	java/net/URL:<init>	(Ljava/lang/String;)V
    //   96: invokevirtual 78	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   99: checkcast 80	java/net/HttpURLConnection
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +124 -> 228
    //   107: aload_0
    //   108: getstatic 35	com/tencent/mm/plugin/freewifi/a/a:tma	I
    //   111: invokevirtual 83	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   114: aload_0
    //   115: getstatic 40	com/tencent/mm/plugin/freewifi/a/a:tmb	I
    //   118: invokevirtual 86	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   121: aload_0
    //   122: ldc 88
    //   124: invokestatic 27	com/tencent/mm/plugin/freewifi/h$b:cQP	()Lcom/tencent/mm/plugin/freewifi/h;
    //   127: invokevirtual 92	com/tencent/mm/plugin/freewifi/h:getUserAgent	()Ljava/lang/String;
    //   130: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: iconst_0
    //   135: invokevirtual 103	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   138: aload_0
    //   139: iconst_1
    //   140: invokevirtual 143	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   143: aload_0
    //   144: ldc 145
    //   146: invokevirtual 148	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: ldc 150
    //   152: ldc 152
    //   154: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_0
    //   158: ldc 154
    //   160: ldc 156
    //   162: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: iconst_0
    //   167: invokevirtual 100	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   170: aload 6
    //   172: ldc 158
    //   174: invokestatic 164	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   177: invokevirtual 168	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   180: astore_1
    //   181: aload_0
    //   182: ldc 170
    //   184: aload_1
    //   185: arraylength
    //   186: invokestatic 176	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   189: invokevirtual 96	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: new 178	java/io/DataOutputStream
    //   195: dup
    //   196: aload_0
    //   197: invokevirtual 182	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   200: invokespecial 185	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   203: astore 6
    //   205: aload 6
    //   207: aload_1
    //   208: invokevirtual 189	java/io/DataOutputStream:write	([B)V
    //   211: aload 6
    //   213: invokevirtual 192	java/io/DataOutputStream:flush	()V
    //   216: aload 6
    //   218: invokevirtual 193	java/io/DataOutputStream:close	()V
    //   221: aload_2
    //   222: aload_0
    //   223: invokeinterface 107 2 0
    //   228: aload_0
    //   229: ifnull +423 -> 652
    //   232: aload_0
    //   233: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   236: invokevirtual 116	java/io/InputStream:close	()V
    //   239: aload_0
    //   240: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   243: sipush 24736
    //   246: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: return
    //   250: ldc 133
    //   252: astore 6
    //   254: aload_1
    //   255: ldc 195
    //   257: invokevirtual 199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   260: astore 10
    //   262: iconst_1
    //   263: istore_3
    //   264: aload 6
    //   266: astore_1
    //   267: iload_3
    //   268: bipush 10
    //   270: if_icmpgt +253 -> 523
    //   273: ldc 201
    //   275: iload_3
    //   276: invokestatic 204	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   279: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   282: astore 11
    //   284: ldc 210
    //   286: iload_3
    //   287: invokestatic 204	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   290: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   293: astore 12
    //   295: aconst_null
    //   296: astore 6
    //   298: aconst_null
    //   299: astore 7
    //   301: aload 10
    //   303: arraylength
    //   304: istore 5
    //   306: iconst_0
    //   307: istore 4
    //   309: iload 4
    //   311: iload 5
    //   313: if_icmpge +120 -> 433
    //   316: aload 10
    //   318: iload 4
    //   320: aaload
    //   321: astore 13
    //   323: aload 13
    //   325: aload 11
    //   327: invokevirtual 214	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   330: iflt +47 -> 377
    //   333: aload 13
    //   335: ldc 216
    //   337: invokevirtual 199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   340: arraylength
    //   341: iconst_2
    //   342: if_icmpne +35 -> 377
    //   345: aload 13
    //   347: ldc 216
    //   349: invokevirtual 199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   352: iconst_1
    //   353: aaload
    //   354: astore 9
    //   356: aload 7
    //   358: astore 8
    //   360: iload 4
    //   362: iconst_1
    //   363: iadd
    //   364: istore 4
    //   366: aload 8
    //   368: astore 7
    //   370: aload 9
    //   372: astore 6
    //   374: goto -65 -> 309
    //   377: aload 7
    //   379: astore 8
    //   381: aload 6
    //   383: astore 9
    //   385: aload 13
    //   387: aload 12
    //   389: invokevirtual 214	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   392: iflt -32 -> 360
    //   395: aload 7
    //   397: astore 8
    //   399: aload 6
    //   401: astore 9
    //   403: aload 13
    //   405: ldc 216
    //   407: invokevirtual 199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   410: arraylength
    //   411: iconst_2
    //   412: if_icmpne -52 -> 360
    //   415: aload 13
    //   417: ldc 216
    //   419: invokevirtual 199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   422: iconst_1
    //   423: aaload
    //   424: astore 8
    //   426: aload 6
    //   428: astore 9
    //   430: goto -70 -> 360
    //   433: aload 6
    //   435: ifnull +88 -> 523
    //   438: aload 7
    //   440: ifnull +83 -> 523
    //   443: iload_3
    //   444: iconst_1
    //   445: if_icmpne +40 -> 485
    //   448: new 218	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   455: aload_1
    //   456: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 6
    //   461: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc 216
    //   466: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 7
    //   471: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: astore_1
    //   478: iload_3
    //   479: iconst_1
    //   480: iadd
    //   481: istore_3
    //   482: goto -215 -> 267
    //   485: new 218	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   492: aload_1
    //   493: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc 195
    //   498: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 6
    //   503: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc 216
    //   508: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 7
    //   513: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: astore_1
    //   520: goto -42 -> 478
    //   523: aload_1
    //   524: astore 6
    //   526: goto -463 -> 63
    //   529: astore_1
    //   530: aload_2
    //   531: aload_1
    //   532: invokeinterface 122 2 0
    //   537: goto -309 -> 228
    //   540: astore 6
    //   542: aload_0
    //   543: astore_1
    //   544: aload_2
    //   545: aload 6
    //   547: invokeinterface 122 2 0
    //   552: aload_0
    //   553: ifnull +99 -> 652
    //   556: aload_0
    //   557: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   560: invokevirtual 116	java/io/InputStream:close	()V
    //   563: aload_0
    //   564: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   567: sipush 24736
    //   570: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   573: return
    //   574: astore_1
    //   575: aload_2
    //   576: aload_1
    //   577: invokeinterface 122 2 0
    //   582: goto -354 -> 228
    //   585: astore_2
    //   586: aload_0
    //   587: astore_1
    //   588: aload_2
    //   589: astore_0
    //   590: aload_1
    //   591: ifnull +14 -> 605
    //   594: aload_1
    //   595: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   598: invokevirtual 116	java/io/InputStream:close	()V
    //   601: aload_1
    //   602: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   605: sipush 24736
    //   608: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   611: aload_0
    //   612: athrow
    //   613: astore_1
    //   614: ldc 56
    //   616: aload_1
    //   617: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   620: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: goto -384 -> 239
    //   626: astore_1
    //   627: ldc 56
    //   629: aload_1
    //   630: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   633: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: goto -73 -> 563
    //   639: astore_2
    //   640: ldc 56
    //   642: aload_2
    //   643: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   646: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   649: goto -48 -> 601
    //   652: sipush 24736
    //   655: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   658: return
    //   659: astore_0
    //   660: goto -70 -> 590
    //   663: astore 6
    //   665: aload 7
    //   667: astore_0
    //   668: goto -126 -> 542
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	paramString1	java.lang.String
    //   0	671	1	paramString2	java.lang.String
    //   0	671	2	parama	a
    //   263	219	3	i	int
    //   307	58	4	j	int
    //   304	10	5	k	int
    //   61	464	6	localObject1	Object
    //   540	6	6	localException1	Exception
    //   663	1	6	localException2	Exception
    //   86	580	7	localObject2	Object
    //   358	67	8	localObject3	Object
    //   354	75	9	localObject4	Object
    //   260	57	10	arrayOfString	java.lang.String[]
    //   282	44	11	str1	java.lang.String
    //   293	95	12	str2	java.lang.String
    //   321	95	13	str3	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   221	228	529	java/io/IOException
    //   107	221	540	java/lang/Exception
    //   530	537	540	java/lang/Exception
    //   575	582	540	java/lang/Exception
    //   221	228	574	java/lang/Exception
    //   107	221	585	finally
    //   221	228	585	finally
    //   530	537	585	finally
    //   575	582	585	finally
    //   232	239	613	java/lang/Exception
    //   556	563	626	java/lang/Exception
    //   594	601	639	java/lang/Exception
    //   88	103	659	finally
    //   544	552	659	finally
    //   88	103	663	java/lang/Exception
  }
  
  public static a cQZ()
  {
    AppMethodBeat.i(24734);
    a locala = b.cRa();
    AppMethodBeat.o(24734);
    return locala;
  }
  
  public static abstract interface a
  {
    public abstract void d(HttpURLConnection paramHttpURLConnection);
    
    public abstract void o(Exception paramException);
  }
  
  static final class b
  {
    private static a tmc;
    
    static
    {
      AppMethodBeat.i(24733);
      tmc = new a((byte)0);
      AppMethodBeat.o(24733);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a.a
 * JD-Core Version:    0.7.0.1
 */