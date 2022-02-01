package com.tencent.mm.bk;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;

@TargetApi(16)
public final class e
{
  private static final Object ibN;
  
  static
  {
    AppMethodBeat.i(127101);
    ibN = new Object();
    AppMethodBeat.o(127101);
  }
  
  private static void A(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127098);
    if (paramInt < 0) {
      ac.i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", new Object[] { Integer.valueOf(paramInt) });
    }
    ac.i("MicroMsg.TransferUtil", "Transfer Finish");
    paramLong = bs.Gn() - paramLong;
    ac.i("MicroMsg.TransferUtil", "totalTime：%d", new Object[] { Long.valueOf(paramLong) });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(354);
    localIDKey1.SetKey(253);
    localIDKey1.SetValue(paramLong);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(354);
    localIDKey2.SetKey(254);
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    h.wUl.b(localArrayList, false);
    AppMethodBeat.o(127098);
  }
  
  public static boolean Et(String paramString)
  {
    AppMethodBeat.i(127091);
    ac.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
    boolean bool = r.isH265Video(paramString);
    AppMethodBeat.o(127091);
    return bool;
  }
  
  /* Error */
  public static VideoTransPara Eu(String paramString)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 36
    //   7: ldc 118
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: new 120	com/tencent/mm/modelcontrol/VideoTransPara
    //   23: dup
    //   24: invokespecial 121	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   27: astore 6
    //   29: aload_0
    //   30: invokestatic 123	com/tencent/mm/bk/e:Et	(Ljava/lang/String;)Z
    //   33: invokestatic 128	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   36: astore_3
    //   37: ldc 36
    //   39: ldc 130
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_3
    //   48: aastore
    //   49: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_3
    //   53: invokevirtual 134	java/lang/Boolean:booleanValue	()Z
    //   56: ifeq +407 -> 463
    //   59: new 136	com/tencent/mm/compatible/h/d
    //   62: dup
    //   63: invokespecial 137	com/tencent/mm/compatible/h/d:<init>	()V
    //   66: astore 7
    //   68: aload 7
    //   70: aload_0
    //   71: invokevirtual 143	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   74: aload 6
    //   76: aload 7
    //   78: bipush 9
    //   80: invokevirtual 147	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   83: iconst_0
    //   84: invokestatic 151	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   87: putfield 155	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   90: aload 6
    //   92: aload 6
    //   94: getfield 155	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   97: i2l
    //   98: invokestatic 159	com/tencent/mm/sdk/platformtools/bs:Aq	(J)I
    //   101: putfield 155	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   104: aload 6
    //   106: aload 7
    //   108: bipush 18
    //   110: invokevirtual 147	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   113: iconst_0
    //   114: invokestatic 151	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   117: putfield 162	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   120: aload 6
    //   122: aload 7
    //   124: bipush 19
    //   126: invokevirtual 147	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   129: iconst_0
    //   130: invokestatic 151	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   133: putfield 165	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   136: aload 6
    //   138: aload 7
    //   140: bipush 20
    //   142: invokevirtual 147	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   145: iconst_0
    //   146: invokestatic 151	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   149: putfield 168	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   152: new 170	com/tencent/mm/compatible/h/c
    //   155: dup
    //   156: invokespecial 171	com/tencent/mm/compatible/h/c:<init>	()V
    //   159: astore 4
    //   161: aload 4
    //   163: astore_3
    //   164: aload 4
    //   166: aload_0
    //   167: invokevirtual 174	com/tencent/mm/compatible/h/c:sI	(Ljava/lang/String;)V
    //   170: aload 4
    //   172: astore_3
    //   173: aload 4
    //   175: getfield 178	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   178: invokevirtual 184	android/media/MediaExtractor:getTrackCount	()I
    //   181: istore_2
    //   182: iconst_0
    //   183: istore_1
    //   184: iload_1
    //   185: iload_2
    //   186: if_icmpge +127 -> 313
    //   189: aload 4
    //   191: astore_3
    //   192: aload 4
    //   194: iload_1
    //   195: invokevirtual 188	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   198: astore 5
    //   200: aload 4
    //   202: astore_3
    //   203: aload 5
    //   205: ldc 190
    //   207: invokevirtual 195	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   210: ifeq +140 -> 350
    //   213: aload 4
    //   215: astore_3
    //   216: aload 5
    //   218: ldc 190
    //   220: invokevirtual 199	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: invokestatic 202	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   226: ifne +124 -> 350
    //   229: aload 4
    //   231: astore_3
    //   232: aload 5
    //   234: ldc 190
    //   236: invokevirtual 199	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 8
    //   241: aload 4
    //   243: astore_3
    //   244: ldc 36
    //   246: ldc 204
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 8
    //   256: aastore
    //   257: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 4
    //   262: astore_3
    //   263: aload 8
    //   265: ldc 206
    //   267: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   270: ifeq +80 -> 350
    //   273: aload 4
    //   275: astore_3
    //   276: aload 6
    //   278: aload 5
    //   280: ldc 213
    //   282: invokevirtual 217	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   285: putfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   288: aload 4
    //   290: astore_3
    //   291: ldc 36
    //   293: ldc 222
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload 6
    //   303: getfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   306: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: aload 4
    //   315: getfield 178	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   318: invokevirtual 225	android/media/MediaExtractor:release	()V
    //   321: aload 7
    //   323: invokevirtual 226	android/media/MediaMetadataRetriever:release	()V
    //   326: ldc 36
    //   328: ldc 228
    //   330: iconst_1
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload 6
    //   338: aastore
    //   339: invokestatic 231	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: ldc 116
    //   344: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload 6
    //   349: areturn
    //   350: iload_1
    //   351: iconst_1
    //   352: iadd
    //   353: istore_1
    //   354: goto -170 -> 184
    //   357: astore 5
    //   359: aconst_null
    //   360: astore 4
    //   362: aload 4
    //   364: astore_3
    //   365: ldc 36
    //   367: aload 5
    //   369: ldc 233
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 237	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: aload 4
    //   380: astore_3
    //   381: aload_0
    //   382: invokestatic 243	com/tencent/mm/plugin/sight/base/e:asx	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   385: astore_0
    //   386: aload_0
    //   387: ifnull +39 -> 426
    //   390: aload 4
    //   392: astore_3
    //   393: aload 6
    //   395: aload_0
    //   396: getfield 248	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   399: putfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   402: aload 4
    //   404: astore_3
    //   405: ldc 36
    //   407: ldc 250
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload_0
    //   416: getfield 248	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   419: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: aload 4
    //   428: ifnull -107 -> 321
    //   431: aload 4
    //   433: getfield 178	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   436: invokevirtual 225	android/media/MediaExtractor:release	()V
    //   439: goto -118 -> 321
    //   442: astore_0
    //   443: aconst_null
    //   444: astore_3
    //   445: aload_3
    //   446: ifnull +10 -> 456
    //   449: aload_3
    //   450: getfield 178	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   453: invokevirtual 225	android/media/MediaExtractor:release	()V
    //   456: ldc 116
    //   458: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload_0
    //   462: athrow
    //   463: new 252	com/tencent/mm/pointers/PInt
    //   466: dup
    //   467: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   470: astore_3
    //   471: new 252	com/tencent/mm/pointers/PInt
    //   474: dup
    //   475: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   478: astore 4
    //   480: new 252	com/tencent/mm/pointers/PInt
    //   483: dup
    //   484: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   487: astore 5
    //   489: new 252	com/tencent/mm/pointers/PInt
    //   492: dup
    //   493: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   496: astore 7
    //   498: new 252	com/tencent/mm/pointers/PInt
    //   501: dup
    //   502: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   505: astore 8
    //   507: aload_0
    //   508: aload_3
    //   509: aload 4
    //   511: aload 5
    //   513: aload 7
    //   515: aload 8
    //   517: invokestatic 257	com/tencent/mm/plugin/sight/base/e:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   520: pop
    //   521: aload 6
    //   523: aload_3
    //   524: getfield 259	com/tencent/mm/pointers/PInt:value	I
    //   527: i2l
    //   528: invokestatic 159	com/tencent/mm/sdk/platformtools/bs:Aq	(J)I
    //   531: putfield 155	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   534: aload 6
    //   536: aload 4
    //   538: getfield 259	com/tencent/mm/pointers/PInt:value	I
    //   541: putfield 162	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   544: aload 6
    //   546: aload 5
    //   548: getfield 259	com/tencent/mm/pointers/PInt:value	I
    //   551: putfield 165	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   554: aload 6
    //   556: aload 7
    //   558: getfield 259	com/tencent/mm/pointers/PInt:value	I
    //   561: putfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   564: aload 6
    //   566: aload 8
    //   568: getfield 259	com/tencent/mm/pointers/PInt:value	I
    //   571: putfield 168	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   574: goto -248 -> 326
    //   577: astore_0
    //   578: goto -133 -> 445
    //   581: astore 5
    //   583: goto -221 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	paramString	String
    //   183	171	1	i	int
    //   181	6	2	j	int
    //   36	488	3	localObject1	Object
    //   159	378	4	localObject2	Object
    //   198	81	5	localMediaFormat	android.media.MediaFormat
    //   357	11	5	localException1	Exception
    //   487	60	5	localPInt	com.tencent.mm.pointers.PInt
    //   581	1	5	localException2	Exception
    //   27	538	6	localVideoTransPara	VideoTransPara
    //   66	491	7	localObject3	Object
    //   239	328	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   152	161	357	java/lang/Exception
    //   152	161	442	finally
    //   164	170	577	finally
    //   173	182	577	finally
    //   192	200	577	finally
    //   203	213	577	finally
    //   216	229	577	finally
    //   232	241	577	finally
    //   244	260	577	finally
    //   263	273	577	finally
    //   276	288	577	finally
    //   291	313	577	finally
    //   365	378	577	finally
    //   381	386	577	finally
    //   393	402	577	finally
    //   405	426	577	finally
    //   164	170	581	java/lang/Exception
    //   173	182	581	java/lang/Exception
    //   192	200	581	java/lang/Exception
    //   203	213	581	java/lang/Exception
    //   216	229	581	java/lang/Exception
    //   232	241	581	java/lang/Exception
    //   244	260	581	java/lang/Exception
    //   263	273	581	java/lang/Exception
    //   276	288	581	java/lang/Exception
    //   291	313	581	java/lang/Exception
  }
  
  /* Error */
  private static VideoTransPara Ev(String paramString)
  {
    // Byte code:
    //   0: ldc_w 261
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 120	com/tencent/mm/modelcontrol/VideoTransPara
    //   9: dup
    //   10: invokespecial 121	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   13: astore 5
    //   15: iconst_2
    //   16: newarray int
    //   18: astore 6
    //   20: new 136	com/tencent/mm/compatible/h/d
    //   23: dup
    //   24: invokespecial 137	com/tencent/mm/compatible/h/d:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 143	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload 4
    //   37: bipush 18
    //   39: invokevirtual 147	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   42: iconst_0
    //   43: invokestatic 151	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   46: istore_3
    //   47: aload 4
    //   49: bipush 19
    //   51: invokevirtual 147	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   54: iconst_0
    //   55: invokestatic 151	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   58: istore_2
    //   59: aload 6
    //   61: iconst_0
    //   62: iload_3
    //   63: iastore
    //   64: aload 6
    //   66: iconst_1
    //   67: iload_2
    //   68: iastore
    //   69: iconst_0
    //   70: istore_1
    //   71: iload_1
    //   72: iconst_3
    //   73: if_icmpge +125 -> 198
    //   76: iload_3
    //   77: iconst_2
    //   78: irem
    //   79: ifne +9 -> 88
    //   82: iload_2
    //   83: iconst_2
    //   84: irem
    //   85: ifeq +75 -> 160
    //   88: aload 4
    //   90: invokevirtual 226	android/media/MediaMetadataRetriever:release	()V
    //   93: aload 5
    //   95: aload 6
    //   97: iconst_0
    //   98: iaload
    //   99: putfield 162	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   102: aload 5
    //   104: aload 6
    //   106: iconst_1
    //   107: iaload
    //   108: putfield 165	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   111: aload 5
    //   113: getstatic 266	com/tencent/mm/plugin/sight/base/c:xCs	I
    //   116: putfield 168	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   119: aload 5
    //   121: getstatic 269	com/tencent/mm/plugin/sight/base/c:xCr	I
    //   124: putfield 272	com/tencent/mm/modelcontrol/VideoTransPara:hCA	I
    //   127: aload 5
    //   129: iconst_2
    //   130: putfield 275	com/tencent/mm/modelcontrol/VideoTransPara:hCz	I
    //   133: aload 5
    //   135: getstatic 279	com/tencent/mm/plugin/sight/base/c:xCt	F
    //   138: f2i
    //   139: putfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   142: aload 5
    //   144: aload_0
    //   145: invokestatic 282	com/tencent/mm/bk/e:ft	(Ljava/lang/String;)I
    //   148: putfield 155	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   151: ldc_w 261
    //   154: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload 5
    //   159: areturn
    //   160: iload_3
    //   161: iload_2
    //   162: if_icmplt +17 -> 179
    //   165: iload_3
    //   166: sipush 640
    //   169: if_icmple +29 -> 198
    //   172: iload_2
    //   173: sipush 480
    //   176: if_icmple +22 -> 198
    //   179: iload_3
    //   180: iload_2
    //   181: if_icmpgt +64 -> 245
    //   184: iload_3
    //   185: sipush 480
    //   188: if_icmple +10 -> 198
    //   191: iload_2
    //   192: sipush 640
    //   195: if_icmpgt +50 -> 245
    //   198: aload 6
    //   200: iconst_0
    //   201: iload_3
    //   202: iastore
    //   203: aload 6
    //   205: iconst_1
    //   206: iload_2
    //   207: iastore
    //   208: aload 4
    //   210: invokevirtual 226	android/media/MediaMetadataRetriever:release	()V
    //   213: goto -120 -> 93
    //   216: astore_0
    //   217: ldc 36
    //   219: aload_0
    //   220: ldc_w 284
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_0
    //   230: invokevirtual 288	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 237	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 261
    //   240: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aconst_null
    //   244: areturn
    //   245: iload_3
    //   246: iconst_2
    //   247: idiv
    //   248: istore_3
    //   249: iload_2
    //   250: iconst_2
    //   251: idiv
    //   252: istore_2
    //   253: iload_1
    //   254: iconst_1
    //   255: iadd
    //   256: istore_1
    //   257: goto -186 -> 71
    //   260: astore_0
    //   261: aconst_null
    //   262: astore 4
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 226	android/media/MediaMetadataRetriever:release	()V
    //   274: ldc_w 261
    //   277: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_0
    //   281: athrow
    //   282: astore_0
    //   283: goto -19 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramString	String
    //   70	187	1	i	int
    //   58	195	2	j	int
    //   46	203	3	k	int
    //   27	243	4	locald	com.tencent.mm.compatible.h.d
    //   13	145	5	localVideoTransPara	VideoTransPara
    //   18	186	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   6	20	216	java/lang/Exception
    //   88	93	216	java/lang/Exception
    //   93	151	216	java/lang/Exception
    //   208	213	216	java/lang/Exception
    //   269	274	216	java/lang/Exception
    //   274	282	216	java/lang/Exception
    //   20	29	260	finally
    //   29	59	282	finally
    //   245	253	282	finally
  }
  
  /* Error */
  public static int a(String paramString1, final String paramString2, final VideoTransPara paramVideoTransPara)
  {
    // Byte code:
    //   0: ldc_w 292
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 36
    //   8: ldc_w 294
    //   11: invokestatic 54	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: invokestatic 60	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   17: lstore 7
    //   19: new 6	com/tencent/mm/bk/e$1
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: lload 7
    //   28: invokespecial 297	com/tencent/mm/bk/e$1:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
    //   31: astore 11
    //   33: invokestatic 302	com/tencent/mm/sdk/platformtools/ai:ciE	()Z
    //   36: ifeq +230 -> 266
    //   39: ldc_w 304
    //   42: invokestatic 310	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   45: checkcast 304	com/tencent/mm/plugin/zero/b/a
    //   48: invokeinterface 314 1 0
    //   53: ldc_w 316
    //   56: iconst_1
    //   57: invokevirtual 319	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   60: iconst_1
    //   61: if_icmpne +199 -> 260
    //   64: iconst_1
    //   65: istore 9
    //   67: goto +881 -> 948
    //   70: getstatic 325	com/tencent/mm/compatible/deviceinfo/ae:fJo	Lcom/tencent/mm/compatible/deviceinfo/k;
    //   73: getfield 330	com/tencent/mm/compatible/deviceinfo/k:fGE	I
    //   76: istore 4
    //   78: iload 4
    //   80: iconst_m1
    //   81: if_icmpeq +880 -> 961
    //   84: iload 4
    //   86: iconst_1
    //   87: if_icmpne +868 -> 955
    //   90: iconst_1
    //   91: istore 9
    //   93: ldc 36
    //   95: ldc_w 332
    //   98: iconst_3
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: iload 10
    //   106: invokestatic 128	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: iload 4
    //   114: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: iload 9
    //   122: invokestatic 128	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: aastore
    //   126: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: iload 9
    //   131: ifeq +170 -> 301
    //   134: new 334	com/tencent/mm/bk/g
    //   137: dup
    //   138: invokespecial 335	com/tencent/mm/bk/g:<init>	()V
    //   141: astore 12
    //   143: aload 12
    //   145: aload_0
    //   146: aload_1
    //   147: aload_2
    //   148: invokevirtual 338	com/tencent/mm/bk/g:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;)V
    //   151: aload 12
    //   153: iconst_1
    //   154: putfield 342	com/tencent/mm/bk/g:ice	Z
    //   157: aload 12
    //   159: iload 9
    //   161: putfield 345	com/tencent/mm/bk/g:icf	Z
    //   164: aconst_null
    //   165: astore 11
    //   167: iconst_0
    //   168: istore 5
    //   170: aload 12
    //   172: ifnull +270 -> 442
    //   175: iload 9
    //   177: ifeq +265 -> 442
    //   180: aload 12
    //   182: aload_0
    //   183: invokestatic 282	com/tencent/mm/bk/e:ft	(Ljava/lang/String;)I
    //   186: i2l
    //   187: invokevirtual 348	com/tencent/mm/bk/g:qu	(J)I
    //   190: istore 4
    //   192: iload 4
    //   194: lload 7
    //   196: invokestatic 101	com/tencent/mm/bk/e:A	(IJ)V
    //   199: aload_2
    //   200: ifnonnull +414 -> 614
    //   203: ldc 36
    //   205: ldc_w 350
    //   208: invokestatic 353	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: ldc 36
    //   213: ldc_w 355
    //   216: iconst_4
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_0
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload_0
    //   227: invokestatic 358	com/tencent/mm/plugin/sight/base/e:alX	(Ljava/lang/String;)Ljava/lang/String;
    //   230: aastore
    //   231: dup
    //   232: iconst_2
    //   233: aload_1
    //   234: aastore
    //   235: dup
    //   236: iconst_3
    //   237: aload_1
    //   238: invokestatic 358	com/tencent/mm/plugin/sight/base/e:alX	(Ljava/lang/String;)Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: getstatic 364	com/tencent/mm/bk/b:ibA	Lcom/tencent/mm/bk/b;
    //   248: invokevirtual 367	com/tencent/mm/bk/b:avJ	()V
    //   251: ldc_w 292
    //   254: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iload 4
    //   259: ireturn
    //   260: iconst_0
    //   261: istore 9
    //   263: goto +685 -> 948
    //   266: ldc_w 369
    //   269: new 371	com/tencent/mm/ipcinvoker/type/IPCVoid
    //   272: dup
    //   273: invokespecial 372	com/tencent/mm/ipcinvoker/type/IPCVoid:<init>	()V
    //   276: ldc 8
    //   278: invokestatic 377	com/tencent/mm/ipcinvoker/h:a	(Ljava/lang/String;Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;
    //   281: checkcast 379	com/tencent/mm/ipcinvoker/type/IPCBoolean
    //   284: astore 12
    //   286: aload 12
    //   288: ifnull +654 -> 942
    //   291: aload 12
    //   293: getfield 381	com/tencent/mm/ipcinvoker/type/IPCBoolean:value	Z
    //   296: istore 10
    //   298: goto -228 -> 70
    //   301: aload_0
    //   302: invokestatic 243	com/tencent/mm/plugin/sight/base/e:asx	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   305: astore 12
    //   307: aload 12
    //   309: ifnull +61 -> 370
    //   312: aload 12
    //   314: getfield 248	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   317: ifle +53 -> 370
    //   320: aload_2
    //   321: ldc_w 382
    //   324: aload 12
    //   326: getfield 248	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   329: i2f
    //   330: invokestatic 388	java/lang/Math:min	(FF)F
    //   333: f2i
    //   334: putfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   337: ldc 36
    //   339: ldc_w 390
    //   342: iconst_2
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload_2
    //   349: getfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   352: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: aload 12
    //   360: getfield 248	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   363: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: getstatic 396	com/tencent/mm/media/h/d:gTv	Lcom/tencent/mm/media/h/d$a;
    //   373: aload_0
    //   374: aload_1
    //   375: aload_2
    //   376: getfield 162	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   379: aload_2
    //   380: getfield 165	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   383: aload_2
    //   384: getfield 168	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   387: aload_2
    //   388: getfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   391: aload_2
    //   392: getfield 399	com/tencent/mm/modelcontrol/VideoTransPara:gOb	I
    //   395: aload_2
    //   396: getfield 402	com/tencent/mm/modelcontrol/VideoTransPara:gOc	I
    //   399: aload 11
    //   401: invokeinterface 407 10 0
    //   406: astore 11
    //   408: aconst_null
    //   409: astore 12
    //   411: goto -244 -> 167
    //   414: astore_0
    //   415: ldc 36
    //   417: ldc_w 409
    //   420: iconst_1
    //   421: anewarray 4	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: aload_0
    //   427: invokevirtual 288	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: aastore
    //   431: invokestatic 411	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: ldc_w 292
    //   437: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: iconst_m1
    //   441: ireturn
    //   442: iload 5
    //   444: istore 4
    //   446: aload 11
    //   448: ifnull -249 -> 199
    //   451: ldc 36
    //   453: ldc_w 413
    //   456: invokestatic 54	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload 11
    //   461: invokevirtual 416	com/tencent/mm/media/h/d:arc	()I
    //   464: pop
    //   465: getstatic 27	com/tencent/mm/bk/e:ibN	Ljava/lang/Object;
    //   468: astore 11
    //   470: aload 11
    //   472: monitorenter
    //   473: getstatic 27	com/tencent/mm/bk/e:ibN	Ljava/lang/Object;
    //   476: invokevirtual 419	java/lang/Object:wait	()V
    //   479: aload 11
    //   481: monitorexit
    //   482: ldc 36
    //   484: ldc_w 421
    //   487: invokestatic 54	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: iload 5
    //   492: istore 4
    //   494: goto -295 -> 199
    //   497: astore 11
    //   499: ldc 36
    //   501: ldc_w 423
    //   504: iconst_1
    //   505: anewarray 4	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: aload 11
    //   512: invokevirtual 288	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   515: aastore
    //   516: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   519: aload_0
    //   520: aload_1
    //   521: aload_2
    //   522: lload 7
    //   524: invokestatic 425	com/tencent/mm/bk/e:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
    //   527: iload 5
    //   529: istore 4
    //   531: goto -332 -> 199
    //   534: astore_0
    //   535: iconst_m1
    //   536: istore 4
    //   538: ldc 36
    //   540: ldc_w 427
    //   543: iconst_1
    //   544: anewarray 4	java/lang/Object
    //   547: dup
    //   548: iconst_0
    //   549: aload_0
    //   550: invokevirtual 288	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   553: aastore
    //   554: invokestatic 411	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: getstatic 364	com/tencent/mm/bk/b:ibA	Lcom/tencent/mm/bk/b;
    //   560: invokevirtual 367	com/tencent/mm/bk/b:avJ	()V
    //   563: goto -312 -> 251
    //   566: astore 12
    //   568: ldc 36
    //   570: aload 12
    //   572: ldc_w 429
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 237	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: goto -103 -> 479
    //   585: astore 12
    //   587: aload 11
    //   589: monitorexit
    //   590: ldc_w 292
    //   593: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: aload 12
    //   598: athrow
    //   599: astore_0
    //   600: getstatic 364	com/tencent/mm/bk/b:ibA	Lcom/tencent/mm/bk/b;
    //   603: invokevirtual 367	com/tencent/mm/bk/b:avJ	()V
    //   606: ldc_w 292
    //   609: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   612: aload_0
    //   613: athrow
    //   614: aload_1
    //   615: invokestatic 435	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   618: ifeq +22 -> 640
    //   621: ldc 36
    //   623: ldc_w 437
    //   626: iconst_1
    //   627: anewarray 4	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: aload_1
    //   633: aastore
    //   634: invokestatic 411	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: goto -426 -> 211
    //   640: new 252	com/tencent/mm/pointers/PInt
    //   643: dup
    //   644: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   647: astore 11
    //   649: new 252	com/tencent/mm/pointers/PInt
    //   652: dup
    //   653: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   656: astore 12
    //   658: new 252	com/tencent/mm/pointers/PInt
    //   661: dup
    //   662: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   665: astore 13
    //   667: new 252	com/tencent/mm/pointers/PInt
    //   670: dup
    //   671: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   674: astore 14
    //   676: new 252	com/tencent/mm/pointers/PInt
    //   679: dup
    //   680: invokespecial 253	com/tencent/mm/pointers/PInt:<init>	()V
    //   683: astore 15
    //   685: aload_1
    //   686: aload 11
    //   688: aload 12
    //   690: aload 13
    //   692: aload 14
    //   694: aload 15
    //   696: invokestatic 257	com/tencent/mm/plugin/sight/base/e:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   699: pop
    //   700: ldc_w 304
    //   703: invokestatic 310	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   706: checkcast 304	com/tencent/mm/plugin/zero/b/a
    //   709: invokeinterface 314 1 0
    //   714: ldc_w 439
    //   717: invokevirtual 442	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   720: ldc_w 443
    //   723: invokestatic 447	com/tencent/mm/sdk/platformtools/bs:getFloat	(Ljava/lang/String;F)F
    //   726: fstore_3
    //   727: aload 15
    //   729: getfield 259	com/tencent/mm/pointers/PInt:value	I
    //   732: istore 5
    //   734: aload_2
    //   735: getfield 168	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   738: istore 6
    //   740: iload 5
    //   742: i2f
    //   743: fload_3
    //   744: iload 6
    //   746: i2f
    //   747: fmul
    //   748: fcmpg
    //   749: ifge +34 -> 783
    //   752: ldc 36
    //   754: ldc_w 449
    //   757: iconst_2
    //   758: anewarray 4	java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: iload 5
    //   765: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   768: aastore
    //   769: dup
    //   770: iconst_1
    //   771: iload 6
    //   773: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: aastore
    //   777: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   780: goto -569 -> 211
    //   783: invokestatic 454	java/lang/System:currentTimeMillis	()J
    //   786: lstore 7
    //   788: ldc 36
    //   790: ldc_w 456
    //   793: iconst_2
    //   794: anewarray 4	java/lang/Object
    //   797: dup
    //   798: iconst_0
    //   799: iload 5
    //   801: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   804: aastore
    //   805: dup
    //   806: iconst_1
    //   807: iload 6
    //   809: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   812: aastore
    //   813: invokestatic 459	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   816: new 461	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 462	java/lang/StringBuilder:<init>	()V
    //   823: aload_1
    //   824: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 468
    //   830: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: invokevirtual 471	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: astore 11
    //   838: aload_1
    //   839: aload 11
    //   841: invokestatic 477	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   844: pop2
    //   845: aload_1
    //   846: invokestatic 480	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   849: pop
    //   850: aload 11
    //   852: aload_1
    //   853: aload_2
    //   854: getfield 162	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   857: aload_2
    //   858: getfield 165	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   861: aload_2
    //   862: getfield 168	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   865: aload_2
    //   866: getfield 272	com/tencent/mm/modelcontrol/VideoTransPara:hCA	I
    //   869: bipush 8
    //   871: aload_2
    //   872: getfield 275	com/tencent/mm/modelcontrol/VideoTransPara:hCz	I
    //   875: ldc_w 481
    //   878: aload_2
    //   879: getfield 220	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   882: i2f
    //   883: aconst_null
    //   884: iconst_0
    //   885: iconst_0
    //   886: iconst_0
    //   887: bipush 51
    //   889: invokestatic 487	com/tencent/mm/plugin/sight/base/SightVideoJNI:remuxingVFS	(Ljava/lang/String;Ljava/lang/String;IIIIIIFF[BIZII)I
    //   892: istore 5
    //   894: getstatic 93	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   897: ldc2_w 488
    //   900: ldc2_w 490
    //   903: lconst_1
    //   904: invokevirtual 495	com/tencent/mm/plugin/report/service/h:n	(JJJ)V
    //   907: ldc 36
    //   909: ldc_w 497
    //   912: iconst_2
    //   913: anewarray 4	java/lang/Object
    //   916: dup
    //   917: iconst_0
    //   918: invokestatic 454	java/lang/System:currentTimeMillis	()J
    //   921: lload 7
    //   923: lsub
    //   924: invokestatic 67	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   927: aastore
    //   928: dup
    //   929: iconst_1
    //   930: iload 5
    //   932: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   935: aastore
    //   936: invokestatic 49	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   939: goto -728 -> 211
    //   942: iconst_1
    //   943: istore 10
    //   945: goto -875 -> 70
    //   948: iload 9
    //   950: istore 10
    //   952: goto -882 -> 70
    //   955: iconst_0
    //   956: istore 9
    //   958: goto -865 -> 93
    //   961: iload 10
    //   963: ifne +9 -> 972
    //   966: iconst_1
    //   967: istore 9
    //   969: goto -876 -> 93
    //   972: iconst_0
    //   973: istore 9
    //   975: goto -882 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	paramString1	String
    //   0	978	1	paramString2	String
    //   0	978	2	paramVideoTransPara	VideoTransPara
    //   726	18	3	f	float
    //   76	461	4	i	int
    //   168	763	5	j	int
    //   738	70	6	k	int
    //   17	905	7	l	long
    //   65	909	9	bool1	boolean
    //   104	858	10	bool2	boolean
    //   497	91	11	localException1	Exception
    //   647	204	11	localObject2	Object
    //   141	269	12	localObject3	Object
    //   566	5	12	localException2	Exception
    //   585	12	12	localObject4	Object
    //   656	33	12	localPInt1	com.tencent.mm.pointers.PInt
    //   665	26	13	localPInt2	com.tencent.mm.pointers.PInt
    //   674	19	14	localPInt3	com.tencent.mm.pointers.PInt
    //   683	45	15	localPInt4	com.tencent.mm.pointers.PInt
    // Exception table:
    //   from	to	target	type
    //   33	64	414	java/lang/Exception
    //   70	78	414	java/lang/Exception
    //   93	129	414	java/lang/Exception
    //   134	164	414	java/lang/Exception
    //   266	286	414	java/lang/Exception
    //   291	298	414	java/lang/Exception
    //   301	307	414	java/lang/Exception
    //   312	370	414	java/lang/Exception
    //   370	408	414	java/lang/Exception
    //   451	473	497	java/lang/Exception
    //   482	490	497	java/lang/Exception
    //   590	599	497	java/lang/Exception
    //   180	199	534	java/lang/Exception
    //   203	211	534	java/lang/Exception
    //   211	245	534	java/lang/Exception
    //   499	527	534	java/lang/Exception
    //   614	637	534	java/lang/Exception
    //   640	740	534	java/lang/Exception
    //   752	780	534	java/lang/Exception
    //   783	939	534	java/lang/Exception
    //   473	479	566	java/lang/Exception
    //   473	479	585	finally
    //   479	482	585	finally
    //   568	582	585	finally
    //   587	590	585	finally
    //   180	199	599	finally
    //   203	211	599	finally
    //   211	245	599	finally
    //   451	473	599	finally
    //   482	490	599	finally
    //   499	527	599	finally
    //   538	557	599	finally
    //   590	599	599	finally
    //   614	637	599	finally
    //   640	740	599	finally
    //   752	780	599	finally
    //   783	939	599	finally
  }
  
  public static VideoTransPara a(VideoTransPara paramVideoTransPara, String paramString)
  {
    AppMethodBeat.i(127093);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.aDL().c(paramVideoTransPara);
    if (localVideoTransPara == null)
    {
      ac.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", new Object[] { paramVideoTransPara });
      paramVideoTransPara = Ev(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    ac.d("MicroMsg.TransferUtil", "compress new para is %s", new Object[] { localVideoTransPara });
    if ((paramVideoTransPara.videoBitrate <= 640000) || (localVideoTransPara.videoBitrate > paramVideoTransPara.videoBitrate))
    {
      ac.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara, paramVideoTransPara });
      paramVideoTransPara = Ev(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    if ((paramVideoTransPara.fps >= 45) && (paramVideoTransPara.duration * 1000 >= 180000))
    {
      paramVideoTransPara = Ev(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    AppMethodBeat.o(127093);
    return localVideoTransPara;
  }
  
  private static void a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, long paramLong)
  {
    AppMethodBeat.i(127097);
    ac.m("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", new Object[] { paramString1, paramString2, paramVideoTransPara });
    g localg = new g();
    localg.b(paramString1, paramString2, paramVideoTransPara);
    localg.ice = true;
    localg.icf = true;
    int i = localg.qu(ft(paramString1));
    ac.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", new Object[] { Integer.valueOf(i) });
    A(i, paramLong);
    AppMethodBeat.o(127097);
  }
  
  public static int ft(String paramString)
  {
    AppMethodBeat.i(127095);
    com.tencent.mm.compatible.h.d locald = new com.tencent.mm.compatible.h.d();
    locald.setDataSource(paramString);
    paramString = locald.extractMetadata(9);
    locald.release();
    if (paramString == null)
    {
      AppMethodBeat.o(127095);
      return 0;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(127095);
      return i;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.TransferUtil", "getDuration error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(127095);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bk.e
 * JD-Core Version:    0.7.0.1
 */