package com.tencent.mm.bm;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

@TargetApi(16)
public final class e
{
  private static final Object miX;
  private static volatile boolean miY;
  
  static
  {
    AppMethodBeat.i(127101);
    miX = new Object();
    miY = false;
    AppMethodBeat.o(127101);
  }
  
  private static void C(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127098);
    if (paramInt < 0) {
      Log.i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", new Object[] { Integer.valueOf(paramInt) });
    }
    Log.i("MicroMsg.TransferUtil", "Transfer Finish");
    paramLong = Util.currentTicks() - paramLong;
    Log.i("MicroMsg.TransferUtil", "totalTime：%d", new Object[] { Long.valueOf(paramLong) });
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
    h.IzE.b(localArrayList, false);
    AppMethodBeat.o(127098);
  }
  
  public static boolean Yt(String paramString)
  {
    AppMethodBeat.i(127091);
    Log.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
    boolean bool = v.isH265Video(paramString);
    AppMethodBeat.o(127091);
    return bool;
  }
  
  /* Error */
  public static VideoTransPara Yu(String paramString)
  {
    // Byte code:
    //   0: ldc 120
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 40
    //   7: ldc 122
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: new 124	com/tencent/mm/modelcontrol/VideoTransPara
    //   23: dup
    //   24: invokespecial 125	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   27: astore 6
    //   29: aload_0
    //   30: invokestatic 127	com/tencent/mm/bm/e:Yt	(Ljava/lang/String;)Z
    //   33: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   36: astore_3
    //   37: ldc 40
    //   39: ldc 134
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_3
    //   48: aastore
    //   49: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_3
    //   53: invokevirtual 138	java/lang/Boolean:booleanValue	()Z
    //   56: ifeq +407 -> 463
    //   59: new 140	com/tencent/mm/compatible/i/d
    //   62: dup
    //   63: invokespecial 141	com/tencent/mm/compatible/i/d:<init>	()V
    //   66: astore 7
    //   68: aload 7
    //   70: aload_0
    //   71: invokevirtual 147	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   74: aload 6
    //   76: aload 7
    //   78: bipush 9
    //   80: invokevirtual 151	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   83: iconst_0
    //   84: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   87: putfield 159	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   90: aload 6
    //   92: aload 6
    //   94: getfield 159	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   97: i2l
    //   98: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   101: putfield 159	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   104: aload 6
    //   106: aload 7
    //   108: bipush 18
    //   110: invokevirtual 151	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   113: iconst_0
    //   114: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   117: putfield 166	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   120: aload 6
    //   122: aload 7
    //   124: bipush 19
    //   126: invokevirtual 151	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   129: iconst_0
    //   130: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   133: putfield 169	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   136: aload 6
    //   138: aload 7
    //   140: bipush 20
    //   142: invokevirtual 151	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   145: iconst_0
    //   146: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   149: putfield 172	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   152: new 174	com/tencent/mm/compatible/i/c
    //   155: dup
    //   156: invokespecial 175	com/tencent/mm/compatible/i/c:<init>	()V
    //   159: astore 4
    //   161: aload 4
    //   163: astore_3
    //   164: aload 4
    //   166: aload_0
    //   167: invokevirtual 176	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   170: aload 4
    //   172: astore_3
    //   173: aload 4
    //   175: getfield 180	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   178: invokevirtual 186	android/media/MediaExtractor:getTrackCount	()I
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
    //   195: invokevirtual 190	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   198: astore 5
    //   200: aload 4
    //   202: astore_3
    //   203: aload 5
    //   205: ldc 192
    //   207: invokevirtual 197	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   210: ifeq +140 -> 350
    //   213: aload 4
    //   215: astore_3
    //   216: aload 5
    //   218: ldc 192
    //   220: invokevirtual 201	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: invokestatic 204	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   226: ifne +124 -> 350
    //   229: aload 4
    //   231: astore_3
    //   232: aload 5
    //   234: ldc 192
    //   236: invokevirtual 201	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 8
    //   241: aload 4
    //   243: astore_3
    //   244: ldc 40
    //   246: ldc 206
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 8
    //   256: aastore
    //   257: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 4
    //   262: astore_3
    //   263: aload 8
    //   265: ldc 208
    //   267: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   270: ifeq +80 -> 350
    //   273: aload 4
    //   275: astore_3
    //   276: aload 6
    //   278: aload 5
    //   280: ldc 215
    //   282: invokevirtual 219	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   285: putfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   288: aload 4
    //   290: astore_3
    //   291: ldc 40
    //   293: ldc 224
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload 6
    //   303: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   306: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: aload 4
    //   315: getfield 180	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   318: invokevirtual 227	android/media/MediaExtractor:release	()V
    //   321: aload 7
    //   323: invokevirtual 228	android/media/MediaMetadataRetriever:release	()V
    //   326: ldc 40
    //   328: ldc 230
    //   330: iconst_1
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload 6
    //   338: aastore
    //   339: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: ldc 120
    //   344: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   365: ldc 40
    //   367: aload 5
    //   369: ldc 235
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: aload 4
    //   380: astore_3
    //   381: aload_0
    //   382: invokestatic 245	com/tencent/mm/plugin/sight/base/f:aYg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/b;
    //   385: astore_0
    //   386: aload_0
    //   387: ifnull +39 -> 426
    //   390: aload 4
    //   392: astore_3
    //   393: aload 6
    //   395: aload_0
    //   396: getfield 250	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   399: putfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   402: aload 4
    //   404: astore_3
    //   405: ldc 40
    //   407: ldc 252
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload_0
    //   416: getfield 250	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   419: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: aload 4
    //   428: ifnull -107 -> 321
    //   431: aload 4
    //   433: getfield 180	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   436: invokevirtual 227	android/media/MediaExtractor:release	()V
    //   439: goto -118 -> 321
    //   442: astore_0
    //   443: aconst_null
    //   444: astore_3
    //   445: aload_3
    //   446: ifnull +10 -> 456
    //   449: aload_3
    //   450: getfield 180	com/tencent/mm/compatible/i/c:jvU	Landroid/media/MediaExtractor;
    //   453: invokevirtual 227	android/media/MediaExtractor:release	()V
    //   456: ldc 120
    //   458: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload_0
    //   462: athrow
    //   463: new 254	com/tencent/mm/pointers/PInt
    //   466: dup
    //   467: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   470: astore_3
    //   471: new 254	com/tencent/mm/pointers/PInt
    //   474: dup
    //   475: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   478: astore 4
    //   480: new 254	com/tencent/mm/pointers/PInt
    //   483: dup
    //   484: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   487: astore 5
    //   489: new 254	com/tencent/mm/pointers/PInt
    //   492: dup
    //   493: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   496: astore 7
    //   498: new 254	com/tencent/mm/pointers/PInt
    //   501: dup
    //   502: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   505: astore 8
    //   507: aload_0
    //   508: aload_3
    //   509: aload 4
    //   511: aload 5
    //   513: aload 7
    //   515: aload 8
    //   517: invokestatic 259	com/tencent/mm/plugin/sight/base/f:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   520: pop
    //   521: aload 6
    //   523: aload_3
    //   524: getfield 261	com/tencent/mm/pointers/PInt:value	I
    //   527: i2l
    //   528: invokestatic 163	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   531: putfield 159	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   534: aload 6
    //   536: aload 4
    //   538: getfield 261	com/tencent/mm/pointers/PInt:value	I
    //   541: putfield 166	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   544: aload 6
    //   546: aload 5
    //   548: getfield 261	com/tencent/mm/pointers/PInt:value	I
    //   551: putfield 169	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   554: aload 6
    //   556: aload 7
    //   558: getfield 261	com/tencent/mm/pointers/PInt:value	I
    //   561: putfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   564: aload 6
    //   566: aload 8
    //   568: getfield 261	com/tencent/mm/pointers/PInt:value	I
    //   571: putfield 172	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
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
  private static VideoTransPara Yv(String paramString)
  {
    // Byte code:
    //   0: ldc_w 263
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 124	com/tencent/mm/modelcontrol/VideoTransPara
    //   9: dup
    //   10: invokespecial 125	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   13: astore 5
    //   15: iconst_2
    //   16: newarray int
    //   18: astore 6
    //   20: new 140	com/tencent/mm/compatible/i/d
    //   23: dup
    //   24: invokespecial 141	com/tencent/mm/compatible/i/d:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 147	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload 4
    //   37: bipush 18
    //   39: invokevirtual 151	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   42: iconst_0
    //   43: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   46: istore_3
    //   47: aload 4
    //   49: bipush 19
    //   51: invokevirtual 151	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   54: iconst_0
    //   55: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   90: invokevirtual 228	android/media/MediaMetadataRetriever:release	()V
    //   93: aload 5
    //   95: aload 6
    //   97: iconst_0
    //   98: iaload
    //   99: putfield 166	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   102: aload 5
    //   104: aload 6
    //   106: iconst_1
    //   107: iaload
    //   108: putfield 169	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   111: aload 5
    //   113: getstatic 268	com/tencent/mm/plugin/sight/base/d:JrI	I
    //   116: putfield 172	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   119: aload 5
    //   121: getstatic 271	com/tencent/mm/plugin/sight/base/d:JrH	I
    //   124: putfield 274	com/tencent/mm/modelcontrol/VideoTransPara:lJn	I
    //   127: aload 5
    //   129: iconst_2
    //   130: putfield 277	com/tencent/mm/modelcontrol/VideoTransPara:lJm	I
    //   133: aload 5
    //   135: getstatic 281	com/tencent/mm/plugin/sight/base/d:JrJ	F
    //   138: f2i
    //   139: putfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   142: aload 5
    //   144: aload_0
    //   145: invokestatic 284	com/tencent/mm/bm/e:hW	(Ljava/lang/String;)I
    //   148: putfield 159	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   151: ldc_w 263
    //   154: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   210: invokevirtual 228	android/media/MediaMetadataRetriever:release	()V
    //   213: goto -120 -> 93
    //   216: astore_0
    //   217: ldc 40
    //   219: aload_0
    //   220: ldc_w 286
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_0
    //   230: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 263
    //   240: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   271: invokevirtual 228	android/media/MediaMetadataRetriever:release	()V
    //   274: ldc_w 263
    //   277: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   27	243	4	locald	com.tencent.mm.compatible.i.d
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
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 40
    //   8: ldc_w 294
    //   11: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: invokestatic 64	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   17: lstore 11
    //   19: iconst_0
    //   20: putstatic 31	com/tencent/mm/bm/e:miY	Z
    //   23: new 6	com/tencent/mm/bm/e$1
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: lload 11
    //   32: invokespecial 297	com/tencent/mm/bm/e$1:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
    //   35: astore 15
    //   37: iconst_1
    //   38: istore 14
    //   40: invokestatic 302	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
    //   43: ifeq +278 -> 321
    //   46: ldc_w 304
    //   49: invokestatic 310	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   52: checkcast 304	com/tencent/mm/plugin/zero/b/a
    //   55: invokeinterface 314 1 0
    //   60: ldc_w 316
    //   63: iconst_1
    //   64: invokevirtual 319	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   67: iconst_1
    //   68: if_icmpne +247 -> 315
    //   71: iconst_1
    //   72: istore 13
    //   74: goto +1082 -> 1156
    //   77: getstatic 325	com/tencent/mm/compatible/deviceinfo/af:juS	Lcom/tencent/mm/compatible/deviceinfo/k;
    //   80: getfield 330	com/tencent/mm/compatible/deviceinfo/k:jsc	I
    //   83: istore 4
    //   85: iload 4
    //   87: iconst_m1
    //   88: if_icmpeq +1081 -> 1169
    //   91: iload 4
    //   93: iconst_1
    //   94: if_icmpne +1069 -> 1163
    //   97: iconst_1
    //   98: istore 13
    //   100: ldc 40
    //   102: ldc_w 332
    //   105: iconst_3
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: iload 14
    //   113: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: iload 4
    //   121: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: iload 13
    //   129: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   132: aastore
    //   133: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: iload 13
    //   138: ifeq +218 -> 356
    //   141: new 334	com/tencent/mm/bm/g
    //   144: dup
    //   145: invokespecial 335	com/tencent/mm/bm/g:<init>	()V
    //   148: astore 16
    //   150: aload 16
    //   152: aload_0
    //   153: aload_1
    //   154: aload_2
    //   155: invokevirtual 338	com/tencent/mm/bm/g:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;)V
    //   158: aload 16
    //   160: iconst_1
    //   161: putfield 341	com/tencent/mm/bm/g:mjn	Z
    //   164: aload 16
    //   166: iload 13
    //   168: putfield 344	com/tencent/mm/bm/g:mjo	Z
    //   171: aconst_null
    //   172: astore 15
    //   174: ldc2_w 345
    //   177: lstore 7
    //   179: iconst_0
    //   180: istore 5
    //   182: aload 16
    //   184: ifnull +383 -> 567
    //   187: iload 13
    //   189: ifeq +378 -> 567
    //   192: aload 16
    //   194: aload_0
    //   195: invokestatic 284	com/tencent/mm/bm/e:hW	(Ljava/lang/String;)I
    //   198: i2l
    //   199: invokevirtual 349	com/tencent/mm/bm/g:GU	(J)I
    //   202: istore 4
    //   204: iload 4
    //   206: lload 11
    //   208: invokestatic 105	com/tencent/mm/bm/e:C	(IJ)V
    //   211: aload_2
    //   212: ifnonnull +608 -> 820
    //   215: ldc 40
    //   217: ldc_w 351
    //   220: invokestatic 354	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: invokestatic 357	com/tencent/mm/plugin/sight/base/f:aPw	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore_2
    //   228: aload_1
    //   229: invokestatic 357	com/tencent/mm/plugin/sight/base/f:aPw	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 15
    //   234: aload_1
    //   235: invokestatic 362	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   238: ifne +33 -> 271
    //   241: getstatic 97	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   244: ldc2_w 363
    //   247: ldc2_w 365
    //   250: lconst_1
    //   251: iconst_0
    //   252: invokevirtual 370	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   255: ldc 40
    //   257: ldc_w 372
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_1
    //   267: aastore
    //   268: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: ldc 40
    //   273: ldc_w 376
    //   276: iconst_4
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload_0
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload_2
    //   287: aastore
    //   288: dup
    //   289: iconst_2
    //   290: aload_1
    //   291: aastore
    //   292: dup
    //   293: iconst_3
    //   294: aload 15
    //   296: aastore
    //   297: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: getstatic 382	com/tencent/mm/bm/b:miJ	Lcom/tencent/mm/bm/b;
    //   303: invokevirtual 385	com/tencent/mm/bm/b:baL	()V
    //   306: ldc_w 292
    //   309: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: iload 4
    //   314: ireturn
    //   315: iconst_0
    //   316: istore 13
    //   318: goto +838 -> 1156
    //   321: getstatic 391	com/tencent/mm/ipcinvoker/wx_extension/service/MainProcessIPCService:PROCESS_NAME	Ljava/lang/String;
    //   324: new 393	com/tencent/mm/ipcinvoker/type/IPCVoid
    //   327: dup
    //   328: invokespecial 394	com/tencent/mm/ipcinvoker/type/IPCVoid:<init>	()V
    //   331: ldc 8
    //   333: invokestatic 399	com/tencent/mm/ipcinvoker/j:a	(Ljava/lang/String;Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;
    //   336: checkcast 401	com/tencent/mm/ipcinvoker/type/IPCBoolean
    //   339: astore 16
    //   341: aload 16
    //   343: ifnull -266 -> 77
    //   346: aload 16
    //   348: getfield 403	com/tencent/mm/ipcinvoker/type/IPCBoolean:value	Z
    //   351: istore 14
    //   353: goto -276 -> 77
    //   356: aload_0
    //   357: invokestatic 245	com/tencent/mm/plugin/sight/base/f:aYg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/b;
    //   360: astore 16
    //   362: aload 16
    //   364: ifnull +784 -> 1148
    //   367: aload 16
    //   369: getfield 250	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   372: ifle +776 -> 1148
    //   375: aload_2
    //   376: ldc_w 404
    //   379: aload 16
    //   381: getfield 250	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   384: i2f
    //   385: invokestatic 410	java/lang/Math:min	(FF)F
    //   388: f2i
    //   389: putfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   392: ldc 40
    //   394: ldc_w 412
    //   397: iconst_2
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload_2
    //   404: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   407: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: aastore
    //   411: dup
    //   412: iconst_1
    //   413: aload 16
    //   415: getfield 250	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   418: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: aload 16
    //   427: getfield 415	com/tencent/mm/plugin/sight/base/b:videoDuration	I
    //   430: ifle +718 -> 1148
    //   433: aload 16
    //   435: getfield 415	com/tencent/mm/plugin/sight/base/b:videoDuration	I
    //   438: iconst_3
    //   439: imul
    //   440: i2l
    //   441: lstore 7
    //   443: aload_2
    //   444: getfield 418	com/tencent/mm/modelcontrol/VideoTransPara:lJF	I
    //   447: iconst_1
    //   448: if_icmpne +85 -> 533
    //   451: iconst_1
    //   452: istore 14
    //   454: aload_2
    //   455: getfield 166	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   458: iconst_4
    //   459: invokestatic 422	com/tencent/mm/plugin/sight/base/f:kD	(II)I
    //   462: istore 6
    //   464: aload_2
    //   465: getfield 169	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   468: iconst_3
    //   469: invokestatic 422	com/tencent/mm/plugin/sight/base/f:kD	(II)I
    //   472: istore 5
    //   474: iload 5
    //   476: istore 4
    //   478: iload 5
    //   480: iconst_2
    //   481: irem
    //   482: ifeq +9 -> 491
    //   485: iload 5
    //   487: iconst_1
    //   488: iadd
    //   489: istore 4
    //   491: getstatic 428	com/tencent/mm/media/i/d:kWt	Lcom/tencent/mm/media/i/d$a;
    //   494: aload_0
    //   495: aload_1
    //   496: iload 6
    //   498: iload 4
    //   500: aload_2
    //   501: getfield 172	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   504: aload_2
    //   505: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   508: aload_2
    //   509: getfield 431	com/tencent/mm/modelcontrol/VideoTransPara:kSl	I
    //   512: aload_2
    //   513: getfield 434	com/tencent/mm/modelcontrol/VideoTransPara:kSm	I
    //   516: iload 14
    //   518: aload 15
    //   520: invokeinterface 439 11 0
    //   525: astore 15
    //   527: aconst_null
    //   528: astore 16
    //   530: goto -351 -> 179
    //   533: iconst_0
    //   534: istore 14
    //   536: goto -82 -> 454
    //   539: astore_0
    //   540: ldc 40
    //   542: ldc_w 441
    //   545: iconst_1
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_0
    //   552: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   555: aastore
    //   556: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: ldc_w 292
    //   562: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: iconst_m1
    //   566: ireturn
    //   567: iload 5
    //   569: istore 4
    //   571: aload 15
    //   573: ifnull -362 -> 211
    //   576: ldc 40
    //   578: ldc_w 443
    //   581: iconst_2
    //   582: anewarray 4	java/lang/Object
    //   585: dup
    //   586: iconst_0
    //   587: getstatic 31	com/tencent/mm/bm/e:miY	Z
    //   590: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   593: aastore
    //   594: dup
    //   595: iconst_1
    //   596: lload 7
    //   598: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   601: aastore
    //   602: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   605: aload 15
    //   607: invokevirtual 446	com/tencent/mm/media/i/d:aUW	()I
    //   610: pop
    //   611: getstatic 31	com/tencent/mm/bm/e:miY	Z
    //   614: ifne +74 -> 688
    //   617: getstatic 29	com/tencent/mm/bm/e:miX	Ljava/lang/Object;
    //   620: astore 15
    //   622: aload 15
    //   624: monitorenter
    //   625: ldc_w 448
    //   628: invokestatic 310	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   631: checkcast 448	com/tencent/mm/plugin/expt/b/b
    //   634: getstatic 454	com/tencent/mm/plugin/expt/b/b$a:vvV	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   637: iconst_m1
    //   638: invokeinterface 457 3 0
    //   643: i2l
    //   644: lstore 9
    //   646: lload 9
    //   648: lconst_0
    //   649: lcmp
    //   650: ifle +27 -> 677
    //   653: ldc 40
    //   655: ldc_w 459
    //   658: iconst_1
    //   659: anewarray 4	java/lang/Object
    //   662: dup
    //   663: iconst_0
    //   664: lload 9
    //   666: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   669: aastore
    //   670: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: lload 9
    //   675: lstore 7
    //   677: getstatic 29	com/tencent/mm/bm/e:miX	Ljava/lang/Object;
    //   680: lload 7
    //   682: invokevirtual 462	java/lang/Object:wait	(J)V
    //   685: aload 15
    //   687: monitorexit
    //   688: ldc 40
    //   690: ldc_w 464
    //   693: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: iload 5
    //   698: istore 4
    //   700: goto -489 -> 211
    //   703: astore 15
    //   705: ldc 40
    //   707: ldc_w 466
    //   710: iconst_1
    //   711: anewarray 4	java/lang/Object
    //   714: dup
    //   715: iconst_0
    //   716: aload 15
    //   718: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   721: aastore
    //   722: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: aload_0
    //   726: aload_1
    //   727: aload_2
    //   728: lload 11
    //   730: invokestatic 468	com/tencent/mm/bm/e:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
    //   733: iload 5
    //   735: istore 4
    //   737: goto -526 -> 211
    //   740: astore_0
    //   741: iconst_m1
    //   742: istore 4
    //   744: ldc 40
    //   746: ldc_w 470
    //   749: iconst_1
    //   750: anewarray 4	java/lang/Object
    //   753: dup
    //   754: iconst_0
    //   755: aload_0
    //   756: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   759: aastore
    //   760: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   763: getstatic 382	com/tencent/mm/bm/b:miJ	Lcom/tencent/mm/bm/b;
    //   766: invokevirtual 385	com/tencent/mm/bm/b:baL	()V
    //   769: goto -463 -> 306
    //   772: astore 16
    //   774: ldc 40
    //   776: aload 16
    //   778: ldc_w 472
    //   781: iconst_0
    //   782: anewarray 4	java/lang/Object
    //   785: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   788: goto -103 -> 685
    //   791: astore 16
    //   793: aload 15
    //   795: monitorexit
    //   796: ldc_w 292
    //   799: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   802: aload 16
    //   804: athrow
    //   805: astore_0
    //   806: getstatic 382	com/tencent/mm/bm/b:miJ	Lcom/tencent/mm/bm/b;
    //   809: invokevirtual 385	com/tencent/mm/bm/b:baL	()V
    //   812: ldc_w 292
    //   815: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   818: aload_0
    //   819: athrow
    //   820: aload_1
    //   821: invokestatic 478	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   824: ifeq +22 -> 846
    //   827: ldc 40
    //   829: ldc_w 480
    //   832: iconst_1
    //   833: anewarray 4	java/lang/Object
    //   836: dup
    //   837: iconst_0
    //   838: aload_1
    //   839: aastore
    //   840: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   843: goto -620 -> 223
    //   846: new 254	com/tencent/mm/pointers/PInt
    //   849: dup
    //   850: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   853: astore 15
    //   855: new 254	com/tencent/mm/pointers/PInt
    //   858: dup
    //   859: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   862: astore 16
    //   864: new 254	com/tencent/mm/pointers/PInt
    //   867: dup
    //   868: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   871: astore 17
    //   873: new 254	com/tencent/mm/pointers/PInt
    //   876: dup
    //   877: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   880: astore 18
    //   882: new 254	com/tencent/mm/pointers/PInt
    //   885: dup
    //   886: invokespecial 255	com/tencent/mm/pointers/PInt:<init>	()V
    //   889: astore 19
    //   891: aload_1
    //   892: aload 15
    //   894: aload 16
    //   896: aload 17
    //   898: aload 18
    //   900: aload 19
    //   902: invokestatic 259	com/tencent/mm/plugin/sight/base/f:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   905: pop
    //   906: ldc_w 304
    //   909: invokestatic 310	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   912: checkcast 304	com/tencent/mm/plugin/zero/b/a
    //   915: invokeinterface 314 1 0
    //   920: ldc_w 482
    //   923: invokevirtual 485	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   926: ldc_w 486
    //   929: invokestatic 490	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   932: fstore_3
    //   933: aload 19
    //   935: getfield 261	com/tencent/mm/pointers/PInt:value	I
    //   938: istore 5
    //   940: aload_2
    //   941: getfield 172	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   944: istore 6
    //   946: iload 5
    //   948: i2f
    //   949: fload_3
    //   950: iload 6
    //   952: i2f
    //   953: fmul
    //   954: fcmpg
    //   955: ifge +34 -> 989
    //   958: ldc 40
    //   960: ldc_w 492
    //   963: iconst_2
    //   964: anewarray 4	java/lang/Object
    //   967: dup
    //   968: iconst_0
    //   969: iload 5
    //   971: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   974: aastore
    //   975: dup
    //   976: iconst_1
    //   977: iload 6
    //   979: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   982: aastore
    //   983: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   986: goto -763 -> 223
    //   989: invokestatic 497	java/lang/System:currentTimeMillis	()J
    //   992: lstore 7
    //   994: ldc 40
    //   996: ldc_w 499
    //   999: iconst_2
    //   1000: anewarray 4	java/lang/Object
    //   1003: dup
    //   1004: iconst_0
    //   1005: iload 5
    //   1007: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1010: aastore
    //   1011: dup
    //   1012: iconst_1
    //   1013: iload 6
    //   1015: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1018: aastore
    //   1019: invokestatic 502	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1022: new 504	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 505	java/lang/StringBuilder:<init>	()V
    //   1029: aload_1
    //   1030: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: ldc_w 511
    //   1036: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: astore 15
    //   1044: aload_1
    //   1045: aload 15
    //   1047: invokestatic 518	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1050: pop2
    //   1051: aload_1
    //   1052: invokestatic 521	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   1055: pop
    //   1056: aload 15
    //   1058: aload_1
    //   1059: aload_2
    //   1060: getfield 166	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   1063: aload_2
    //   1064: getfield 169	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   1067: aload_2
    //   1068: getfield 172	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   1071: aload_2
    //   1072: getfield 274	com/tencent/mm/modelcontrol/VideoTransPara:lJn	I
    //   1075: bipush 8
    //   1077: aload_2
    //   1078: getfield 277	com/tencent/mm/modelcontrol/VideoTransPara:lJm	I
    //   1081: ldc_w 522
    //   1084: aload_2
    //   1085: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   1088: i2f
    //   1089: aconst_null
    //   1090: iconst_0
    //   1091: iconst_0
    //   1092: iconst_0
    //   1093: bipush 51
    //   1095: invokestatic 528	com/tencent/mm/plugin/sight/base/SightVideoJNI:remuxingVFS	(Ljava/lang/String;Ljava/lang/String;IIIIIIFF[BIZII)I
    //   1098: istore 5
    //   1100: getstatic 97	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1103: ldc2_w 529
    //   1106: ldc2_w 531
    //   1109: lconst_1
    //   1110: invokevirtual 536	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   1113: ldc 40
    //   1115: ldc_w 538
    //   1118: iconst_2
    //   1119: anewarray 4	java/lang/Object
    //   1122: dup
    //   1123: iconst_0
    //   1124: invokestatic 497	java/lang/System:currentTimeMillis	()J
    //   1127: lload 7
    //   1129: lsub
    //   1130: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1133: aastore
    //   1134: dup
    //   1135: iconst_1
    //   1136: iload 5
    //   1138: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1141: aastore
    //   1142: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1145: goto -922 -> 223
    //   1148: ldc2_w 345
    //   1151: lstore 7
    //   1153: goto -710 -> 443
    //   1156: iload 13
    //   1158: istore 14
    //   1160: goto -1083 -> 77
    //   1163: iconst_0
    //   1164: istore 13
    //   1166: goto -1066 -> 100
    //   1169: iload 14
    //   1171: ifne +9 -> 1180
    //   1174: iconst_1
    //   1175: istore 13
    //   1177: goto -1077 -> 100
    //   1180: iconst_0
    //   1181: istore 13
    //   1183: goto -1083 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1186	0	paramString1	String
    //   0	1186	1	paramString2	String
    //   0	1186	2	paramVideoTransPara	VideoTransPara
    //   932	18	3	f	float
    //   83	660	4	i	int
    //   180	957	5	j	int
    //   462	552	6	k	int
    //   177	975	7	l1	long
    //   644	30	9	l2	long
    //   17	712	11	l3	long
    //   72	1110	13	bool1	boolean
    //   38	1132	14	bool2	boolean
    //   703	91	15	localException1	Exception
    //   853	204	15	localObject2	Object
    //   148	381	16	localObject3	Object
    //   772	5	16	localException2	Exception
    //   791	12	16	localObject4	Object
    //   862	33	16	localPInt1	com.tencent.mm.pointers.PInt
    //   871	26	17	localPInt2	com.tencent.mm.pointers.PInt
    //   880	19	18	localPInt3	com.tencent.mm.pointers.PInt
    //   889	45	19	localPInt4	com.tencent.mm.pointers.PInt
    // Exception table:
    //   from	to	target	type
    //   40	71	539	java/lang/Exception
    //   77	85	539	java/lang/Exception
    //   100	136	539	java/lang/Exception
    //   141	171	539	java/lang/Exception
    //   321	341	539	java/lang/Exception
    //   346	353	539	java/lang/Exception
    //   356	362	539	java/lang/Exception
    //   367	443	539	java/lang/Exception
    //   443	451	539	java/lang/Exception
    //   454	474	539	java/lang/Exception
    //   491	527	539	java/lang/Exception
    //   576	625	703	java/lang/Exception
    //   688	696	703	java/lang/Exception
    //   793	805	703	java/lang/Exception
    //   192	211	740	java/lang/Exception
    //   215	223	740	java/lang/Exception
    //   223	271	740	java/lang/Exception
    //   271	300	740	java/lang/Exception
    //   705	733	740	java/lang/Exception
    //   820	843	740	java/lang/Exception
    //   846	946	740	java/lang/Exception
    //   958	986	740	java/lang/Exception
    //   989	1145	740	java/lang/Exception
    //   625	646	772	java/lang/Exception
    //   653	673	772	java/lang/Exception
    //   677	685	772	java/lang/Exception
    //   625	646	791	finally
    //   653	673	791	finally
    //   677	685	791	finally
    //   685	688	791	finally
    //   774	788	791	finally
    //   192	211	805	finally
    //   215	223	805	finally
    //   223	271	805	finally
    //   271	300	805	finally
    //   576	625	805	finally
    //   688	696	805	finally
    //   705	733	805	finally
    //   744	763	805	finally
    //   793	805	805	finally
    //   820	843	805	finally
    //   846	946	805	finally
    //   958	986	805	finally
    //   989	1145	805	finally
  }
  
  public static VideoTransPara a(VideoTransPara paramVideoTransPara, String paramString)
  {
    AppMethodBeat.i(127093);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bkp().c(paramVideoTransPara);
    if (localVideoTransPara == null)
    {
      Log.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", new Object[] { paramVideoTransPara });
      paramVideoTransPara = Yv(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    Log.i("MicroMsg.TransferUtil", "compress new para is %s  old para is:%s", new Object[] { localVideoTransPara, paramVideoTransPara });
    if ((paramVideoTransPara.videoBitrate <= 640000) || (localVideoTransPara.videoBitrate > paramVideoTransPara.videoBitrate))
    {
      Log.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara, paramVideoTransPara });
      localVideoTransPara.videoBitrate = Math.max(Math.min(localVideoTransPara.videoBitrate, paramVideoTransPara.videoBitrate), 640000);
    }
    if (paramVideoTransPara.width * paramVideoTransPara.height < localVideoTransPara.width * localVideoTransPara.height * 0.85D)
    {
      localVideoTransPara.width = xg(paramVideoTransPara.width);
      localVideoTransPara.height = xg(paramVideoTransPara.height);
      Log.i("MicroMsg.TransferUtil", "new resolution is bigger than old, value[%d %d]", new Object[] { Integer.valueOf(localVideoTransPara.width), Integer.valueOf(localVideoTransPara.height) });
    }
    if ((paramVideoTransPara.fps >= 45) && (paramVideoTransPara.duration * 1000 >= 180000))
    {
      Log.i("MicroMsg.TransferUtil", "make fps lower");
      localVideoTransPara.fps = ((int)com.tencent.mm.plugin.sight.base.d.JrJ);
    }
    Log.i("MicroMsg.TransferUtil", "final para is %s", new Object[] { paramVideoTransPara });
    AppMethodBeat.o(127093);
    return localVideoTransPara;
  }
  
  private static void a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, long paramLong)
  {
    AppMethodBeat.i(127097);
    Log.printInfoStack("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", new Object[] { paramString1, paramString2, paramVideoTransPara });
    g localg = new g();
    localg.b(paramString1, paramString2, paramVideoTransPara);
    localg.mjn = true;
    localg.mjo = true;
    int i = localg.GU(hW(paramString1));
    Log.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", new Object[] { Integer.valueOf(i) });
    C(i, paramLong);
    AppMethodBeat.o(127097);
  }
  
  public static int hW(String paramString)
  {
    AppMethodBeat.i(127095);
    com.tencent.mm.compatible.i.d locald = new com.tencent.mm.compatible.i.d();
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
      Log.e("MicroMsg.TransferUtil", "getDuration error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(127095);
    }
    return 0;
  }
  
  private static int xg(int paramInt)
  {
    int i = paramInt % 16;
    if (i == 0) {
      return paramInt;
    }
    int j = 16 - i + paramInt;
    if (j < 2147483647) {
      return j;
    }
    return paramInt - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bm.e
 * JD-Core Version:    0.7.0.1
 */