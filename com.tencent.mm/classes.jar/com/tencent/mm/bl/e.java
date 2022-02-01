package com.tencent.mm.bl;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

@TargetApi(16)
public final class e
{
  private static final Object hBm;
  
  static
  {
    AppMethodBeat.i(127101);
    hBm = new Object();
    AppMethodBeat.o(127101);
  }
  
  public static boolean Ao(String paramString)
  {
    AppMethodBeat.i(127091);
    ad.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
    boolean bool = r.isH265Video(paramString);
    AppMethodBeat.o(127091);
    return bool;
  }
  
  /* Error */
  public static VideoTransPara Ap(String paramString)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 36
    //   7: ldc 55
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: new 60	com/tencent/mm/modelcontrol/VideoTransPara
    //   23: dup
    //   24: invokespecial 61	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   27: astore 6
    //   29: aload_0
    //   30: invokestatic 63	com/tencent/mm/bl/e:Ao	(Ljava/lang/String;)Z
    //   33: invokestatic 69	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   36: astore_3
    //   37: ldc 36
    //   39: ldc 71
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_3
    //   48: aastore
    //   49: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_3
    //   53: invokevirtual 75	java/lang/Boolean:booleanValue	()Z
    //   56: ifeq +407 -> 463
    //   59: new 77	com/tencent/mm/compatible/h/d
    //   62: dup
    //   63: invokespecial 78	com/tencent/mm/compatible/h/d:<init>	()V
    //   66: astore 7
    //   68: aload 7
    //   70: aload_0
    //   71: invokevirtual 84	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   74: aload 6
    //   76: aload 7
    //   78: bipush 9
    //   80: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   83: iconst_0
    //   84: invokestatic 94	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   87: putfield 98	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   90: aload 6
    //   92: aload 6
    //   94: getfield 98	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   97: i2l
    //   98: invokestatic 102	com/tencent/mm/sdk/platformtools/bt:vN	(J)I
    //   101: putfield 98	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   104: aload 6
    //   106: aload 7
    //   108: bipush 18
    //   110: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   113: iconst_0
    //   114: invokestatic 94	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   117: putfield 105	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   120: aload 6
    //   122: aload 7
    //   124: bipush 19
    //   126: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   129: iconst_0
    //   130: invokestatic 94	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   133: putfield 108	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   136: aload 6
    //   138: aload 7
    //   140: bipush 20
    //   142: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   145: iconst_0
    //   146: invokestatic 94	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   149: putfield 111	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   152: new 113	com/tencent/mm/compatible/h/c
    //   155: dup
    //   156: invokespecial 114	com/tencent/mm/compatible/h/c:<init>	()V
    //   159: astore 4
    //   161: aload 4
    //   163: astore_3
    //   164: aload 4
    //   166: aload_0
    //   167: invokevirtual 117	com/tencent/mm/compatible/h/c:px	(Ljava/lang/String;)V
    //   170: aload 4
    //   172: astore_3
    //   173: aload 4
    //   175: getfield 121	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   178: invokevirtual 127	android/media/MediaExtractor:getTrackCount	()I
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
    //   195: invokevirtual 131	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   198: astore 5
    //   200: aload 4
    //   202: astore_3
    //   203: aload 5
    //   205: ldc 133
    //   207: invokevirtual 138	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   210: ifeq +140 -> 350
    //   213: aload 4
    //   215: astore_3
    //   216: aload 5
    //   218: ldc 133
    //   220: invokevirtual 142	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   223: invokestatic 145	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   226: ifne +124 -> 350
    //   229: aload 4
    //   231: astore_3
    //   232: aload 5
    //   234: ldc 133
    //   236: invokevirtual 142	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 8
    //   241: aload 4
    //   243: astore_3
    //   244: ldc 36
    //   246: ldc 147
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 8
    //   256: aastore
    //   257: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload 4
    //   262: astore_3
    //   263: aload 8
    //   265: ldc 149
    //   267: invokevirtual 154	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   270: ifeq +80 -> 350
    //   273: aload 4
    //   275: astore_3
    //   276: aload 6
    //   278: aload 5
    //   280: ldc 156
    //   282: invokevirtual 160	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   285: putfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   288: aload 4
    //   290: astore_3
    //   291: ldc 36
    //   293: ldc 165
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload 6
    //   303: getfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   306: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: aload 4
    //   315: getfield 121	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   318: invokevirtual 173	android/media/MediaExtractor:release	()V
    //   321: aload 7
    //   323: invokevirtual 174	android/media/MediaMetadataRetriever:release	()V
    //   326: ldc 36
    //   328: ldc 176
    //   330: iconst_1
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload 6
    //   338: aastore
    //   339: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: ldc 53
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
    //   369: ldc 181
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: aload 4
    //   380: astore_3
    //   381: aload_0
    //   382: invokestatic 191	com/tencent/mm/plugin/sight/base/e:ano	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   385: astore_0
    //   386: aload_0
    //   387: ifnull +39 -> 426
    //   390: aload 4
    //   392: astore_3
    //   393: aload 6
    //   395: aload_0
    //   396: getfield 196	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   399: putfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   402: aload 4
    //   404: astore_3
    //   405: ldc 36
    //   407: ldc 198
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload_0
    //   416: getfield 196	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   419: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: aload 4
    //   428: ifnull -107 -> 321
    //   431: aload 4
    //   433: getfield 121	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   436: invokevirtual 173	android/media/MediaExtractor:release	()V
    //   439: goto -118 -> 321
    //   442: astore_0
    //   443: aconst_null
    //   444: astore_3
    //   445: aload_3
    //   446: ifnull +10 -> 456
    //   449: aload_3
    //   450: getfield 121	com/tencent/mm/compatible/h/c:fGK	Landroid/media/MediaExtractor;
    //   453: invokevirtual 173	android/media/MediaExtractor:release	()V
    //   456: ldc 53
    //   458: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload_0
    //   462: athrow
    //   463: new 200	com/tencent/mm/pointers/PInt
    //   466: dup
    //   467: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   470: astore_3
    //   471: new 200	com/tencent/mm/pointers/PInt
    //   474: dup
    //   475: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   478: astore 4
    //   480: new 200	com/tencent/mm/pointers/PInt
    //   483: dup
    //   484: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   487: astore 5
    //   489: new 200	com/tencent/mm/pointers/PInt
    //   492: dup
    //   493: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   496: astore 7
    //   498: new 200	com/tencent/mm/pointers/PInt
    //   501: dup
    //   502: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   505: astore 8
    //   507: aload_0
    //   508: aload_3
    //   509: aload 4
    //   511: aload 5
    //   513: aload 7
    //   515: aload 8
    //   517: invokestatic 205	com/tencent/mm/plugin/sight/base/e:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   520: pop
    //   521: aload 6
    //   523: aload_3
    //   524: getfield 207	com/tencent/mm/pointers/PInt:value	I
    //   527: i2l
    //   528: invokestatic 102	com/tencent/mm/sdk/platformtools/bt:vN	(J)I
    //   531: putfield 98	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   534: aload 6
    //   536: aload 4
    //   538: getfield 207	com/tencent/mm/pointers/PInt:value	I
    //   541: putfield 105	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   544: aload 6
    //   546: aload 5
    //   548: getfield 207	com/tencent/mm/pointers/PInt:value	I
    //   551: putfield 108	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   554: aload 6
    //   556: aload 7
    //   558: getfield 207	com/tencent/mm/pointers/PInt:value	I
    //   561: putfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   564: aload 6
    //   566: aload 8
    //   568: getfield 207	com/tencent/mm/pointers/PInt:value	I
    //   571: putfield 111	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
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
  private static VideoTransPara Aq(String paramString)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 60	com/tencent/mm/modelcontrol/VideoTransPara
    //   8: dup
    //   9: invokespecial 61	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   12: astore 5
    //   14: iconst_2
    //   15: newarray int
    //   17: astore 6
    //   19: new 77	com/tencent/mm/compatible/h/d
    //   22: dup
    //   23: invokespecial 78	com/tencent/mm/compatible/h/d:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_0
    //   31: invokevirtual 84	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   34: aload 4
    //   36: bipush 18
    //   38: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 94	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   45: istore_3
    //   46: aload 4
    //   48: bipush 19
    //   50: invokevirtual 88	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: iconst_0
    //   54: invokestatic 94	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   57: istore_2
    //   58: aload 6
    //   60: iconst_0
    //   61: iload_3
    //   62: iastore
    //   63: aload 6
    //   65: iconst_1
    //   66: iload_2
    //   67: iastore
    //   68: iconst_0
    //   69: istore_1
    //   70: iload_1
    //   71: iconst_3
    //   72: if_icmpge +124 -> 196
    //   75: iload_3
    //   76: iconst_2
    //   77: irem
    //   78: ifne +9 -> 87
    //   81: iload_2
    //   82: iconst_2
    //   83: irem
    //   84: ifeq +74 -> 158
    //   87: aload 4
    //   89: invokevirtual 174	android/media/MediaMetadataRetriever:release	()V
    //   92: aload 5
    //   94: aload 6
    //   96: iconst_0
    //   97: iaload
    //   98: putfield 105	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   101: aload 5
    //   103: aload 6
    //   105: iconst_1
    //   106: iaload
    //   107: putfield 108	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   110: aload 5
    //   112: getstatic 214	com/tencent/mm/plugin/sight/base/c:wrb	I
    //   115: putfield 111	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   118: aload 5
    //   120: getstatic 217	com/tencent/mm/plugin/sight/base/c:wra	I
    //   123: putfield 220	com/tencent/mm/modelcontrol/VideoTransPara:hbY	I
    //   126: aload 5
    //   128: iconst_2
    //   129: putfield 223	com/tencent/mm/modelcontrol/VideoTransPara:hbX	I
    //   132: aload 5
    //   134: getstatic 227	com/tencent/mm/plugin/sight/base/c:wrc	F
    //   137: f2i
    //   138: putfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   141: aload 5
    //   143: aload_0
    //   144: invokestatic 230	com/tencent/mm/bl/e:fD	(Ljava/lang/String;)I
    //   147: putfield 98	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   150: ldc 209
    //   152: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 5
    //   157: areturn
    //   158: iload_3
    //   159: iload_2
    //   160: if_icmplt +17 -> 177
    //   163: iload_3
    //   164: sipush 640
    //   167: if_icmple +29 -> 196
    //   170: iload_2
    //   171: sipush 480
    //   174: if_icmple +22 -> 196
    //   177: iload_3
    //   178: iload_2
    //   179: if_icmpgt +62 -> 241
    //   182: iload_3
    //   183: sipush 480
    //   186: if_icmple +10 -> 196
    //   189: iload_2
    //   190: sipush 640
    //   193: if_icmpgt +48 -> 241
    //   196: aload 6
    //   198: iconst_0
    //   199: iload_3
    //   200: iastore
    //   201: aload 6
    //   203: iconst_1
    //   204: iload_2
    //   205: iastore
    //   206: aload 4
    //   208: invokevirtual 174	android/media/MediaMetadataRetriever:release	()V
    //   211: goto -119 -> 92
    //   214: astore_0
    //   215: ldc 36
    //   217: aload_0
    //   218: ldc 232
    //   220: iconst_1
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_0
    //   227: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: ldc 209
    //   236: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aconst_null
    //   240: areturn
    //   241: iload_3
    //   242: iconst_2
    //   243: idiv
    //   244: istore_3
    //   245: iload_2
    //   246: iconst_2
    //   247: idiv
    //   248: istore_2
    //   249: iload_1
    //   250: iconst_1
    //   251: iadd
    //   252: istore_1
    //   253: goto -183 -> 70
    //   256: astore_0
    //   257: aconst_null
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 174	android/media/MediaMetadataRetriever:release	()V
    //   270: ldc 209
    //   272: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: athrow
    //   277: astore_0
    //   278: goto -18 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramString	String
    //   69	184	1	i	int
    //   57	192	2	j	int
    //   45	200	3	k	int
    //   26	240	4	locald	com.tencent.mm.compatible.h.d
    //   12	144	5	localVideoTransPara	VideoTransPara
    //   17	185	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   5	19	214	java/lang/Exception
    //   87	92	214	java/lang/Exception
    //   92	150	214	java/lang/Exception
    //   206	211	214	java/lang/Exception
    //   265	270	214	java/lang/Exception
    //   270	277	214	java/lang/Exception
    //   19	28	256	finally
    //   28	58	277	finally
    //   241	249	277	finally
  }
  
  private static void B(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127098);
    if (paramInt < 0) {
      ad.i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", new Object[] { Integer.valueOf(paramInt) });
    }
    ad.i("MicroMsg.TransferUtil", "Transfer Finish");
    paramLong = bt.GC() - paramLong;
    ad.i("MicroMsg.TransferUtil", "totalTime：%d", new Object[] { Long.valueOf(paramLong) });
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
    h.vKh.b(localArrayList, false);
    AppMethodBeat.o(127098);
  }
  
  /* Error */
  public static int a(String paramString1, final String paramString2, final VideoTransPara paramVideoTransPara)
  {
    // Byte code:
    //   0: ldc_w 292
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 36
    //   8: ldc_w 294
    //   11: invokestatic 43	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: invokestatic 247	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   17: lstore 7
    //   19: new 6	com/tencent/mm/bl/e$1
    //   22: dup
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: lload 7
    //   28: invokespecial 297	com/tencent/mm/bl/e$1:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
    //   31: astore 11
    //   33: invokestatic 302	com/tencent/mm/sdk/platformtools/aj:cbv	()Z
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
    //   70: getstatic 325	com/tencent/mm/compatible/deviceinfo/ae:fFH	Lcom/tencent/mm/compatible/deviceinfo/k;
    //   73: getfield 330	com/tencent/mm/compatible/deviceinfo/k:fCX	I
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
    //   106: invokestatic 69	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: iload 4
    //   114: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: iload 9
    //   122: invokestatic 69	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: aastore
    //   126: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: iload 9
    //   131: ifeq +170 -> 301
    //   134: new 334	com/tencent/mm/bl/g
    //   137: dup
    //   138: invokespecial 335	com/tencent/mm/bl/g:<init>	()V
    //   141: astore 12
    //   143: aload 12
    //   145: aload_0
    //   146: aload_1
    //   147: aload_2
    //   148: invokevirtual 338	com/tencent/mm/bl/g:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;)V
    //   151: aload 12
    //   153: iconst_1
    //   154: putfield 342	com/tencent/mm/bl/g:hBD	Z
    //   157: aload 12
    //   159: iload 9
    //   161: putfield 345	com/tencent/mm/bl/g:hBE	Z
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
    //   183: invokestatic 230	com/tencent/mm/bl/e:fD	(Ljava/lang/String;)I
    //   186: i2l
    //   187: invokevirtual 348	com/tencent/mm/bl/g:mG	(J)I
    //   190: istore 4
    //   192: iload 4
    //   194: lload 7
    //   196: invokestatic 288	com/tencent/mm/bl/e:B	(IJ)V
    //   199: aload_2
    //   200: ifnonnull +414 -> 614
    //   203: ldc 36
    //   205: ldc_w 350
    //   208: invokestatic 353	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   227: invokestatic 358	com/tencent/mm/plugin/sight/base/e:ahc	(Ljava/lang/String;)Ljava/lang/String;
    //   230: aastore
    //   231: dup
    //   232: iconst_2
    //   233: aload_1
    //   234: aastore
    //   235: dup
    //   236: iconst_3
    //   237: aload_1
    //   238: invokestatic 358	com/tencent/mm/plugin/sight/base/e:ahc	(Ljava/lang/String;)Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: getstatic 364	com/tencent/mm/bl/b:hAZ	Lcom/tencent/mm/bl/b;
    //   248: invokevirtual 367	com/tencent/mm/bl/b:aoS	()V
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
    //   302: invokestatic 191	com/tencent/mm/plugin/sight/base/e:ano	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   305: astore 12
    //   307: aload 12
    //   309: ifnull +61 -> 370
    //   312: aload 12
    //   314: getfield 196	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   317: ifle +53 -> 370
    //   320: aload_2
    //   321: ldc_w 382
    //   324: aload 12
    //   326: getfield 196	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   329: i2f
    //   330: invokestatic 388	java/lang/Math:min	(FF)F
    //   333: f2i
    //   334: putfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   337: ldc 36
    //   339: ldc_w 390
    //   342: iconst_2
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload_2
    //   349: getfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   352: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: aload 12
    //   360: getfield 196	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   363: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: getstatic 396	com/tencent/mm/media/h/d:gsN	Lcom/tencent/mm/media/h/d$a;
    //   373: aload_0
    //   374: aload_1
    //   375: aload_2
    //   376: getfield 105	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   379: aload_2
    //   380: getfield 108	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   383: aload_2
    //   384: getfield 111	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   387: aload_2
    //   388: getfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   391: aload_2
    //   392: getfield 399	com/tencent/mm/modelcontrol/VideoTransPara:gnp	I
    //   395: aload_2
    //   396: getfield 402	com/tencent/mm/modelcontrol/VideoTransPara:gnq	I
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
    //   427: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: aastore
    //   431: invokestatic 411	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   456: invokestatic 43	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload 11
    //   461: invokevirtual 416	com/tencent/mm/media/h/d:akd	()I
    //   464: pop
    //   465: getstatic 27	com/tencent/mm/bl/e:hBm	Ljava/lang/Object;
    //   468: astore 11
    //   470: aload 11
    //   472: monitorenter
    //   473: getstatic 27	com/tencent/mm/bl/e:hBm	Ljava/lang/Object;
    //   476: invokevirtual 419	java/lang/Object:wait	()V
    //   479: aload 11
    //   481: monitorexit
    //   482: ldc 36
    //   484: ldc_w 421
    //   487: invokestatic 43	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   512: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   515: aastore
    //   516: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   519: aload_0
    //   520: aload_1
    //   521: aload_2
    //   522: lload 7
    //   524: invokestatic 425	com/tencent/mm/bl/e:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
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
    //   550: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   553: aastore
    //   554: invokestatic 411	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: getstatic 364	com/tencent/mm/bl/b:hAZ	Lcom/tencent/mm/bl/b;
    //   560: invokevirtual 367	com/tencent/mm/bl/b:aoS	()V
    //   563: goto -312 -> 251
    //   566: astore 12
    //   568: ldc 36
    //   570: aload 12
    //   572: ldc_w 429
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: goto -103 -> 479
    //   585: astore 12
    //   587: aload 11
    //   589: monitorexit
    //   590: ldc_w 292
    //   593: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: aload 12
    //   598: athrow
    //   599: astore_0
    //   600: getstatic 364	com/tencent/mm/bl/b:hAZ	Lcom/tencent/mm/bl/b;
    //   603: invokevirtual 367	com/tencent/mm/bl/b:aoS	()V
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
    //   634: invokestatic 411	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: goto -426 -> 211
    //   640: new 200	com/tencent/mm/pointers/PInt
    //   643: dup
    //   644: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   647: astore 11
    //   649: new 200	com/tencent/mm/pointers/PInt
    //   652: dup
    //   653: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   656: astore 12
    //   658: new 200	com/tencent/mm/pointers/PInt
    //   661: dup
    //   662: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   665: astore 13
    //   667: new 200	com/tencent/mm/pointers/PInt
    //   670: dup
    //   671: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   674: astore 14
    //   676: new 200	com/tencent/mm/pointers/PInt
    //   679: dup
    //   680: invokespecial 201	com/tencent/mm/pointers/PInt:<init>	()V
    //   683: astore 15
    //   685: aload_1
    //   686: aload 11
    //   688: aload 12
    //   690: aload 13
    //   692: aload 14
    //   694: aload 15
    //   696: invokestatic 205	com/tencent/mm/plugin/sight/base/e:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   699: pop
    //   700: ldc_w 304
    //   703: invokestatic 310	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   706: checkcast 304	com/tencent/mm/plugin/zero/b/a
    //   709: invokeinterface 314 1 0
    //   714: ldc_w 439
    //   717: invokevirtual 442	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   720: ldc_w 443
    //   723: invokestatic 447	com/tencent/mm/sdk/platformtools/bt:getFloat	(Ljava/lang/String;F)F
    //   726: fstore_3
    //   727: aload 15
    //   729: getfield 207	com/tencent/mm/pointers/PInt:value	I
    //   732: istore 5
    //   734: aload_2
    //   735: getfield 111	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
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
    //   765: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   768: aastore
    //   769: dup
    //   770: iconst_1
    //   771: iload 6
    //   773: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: aastore
    //   777: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   801: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   804: aastore
    //   805: dup
    //   806: iconst_1
    //   807: iload 6
    //   809: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   812: aastore
    //   813: invokestatic 459	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   841: invokestatic 477	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   844: pop2
    //   845: aload_1
    //   846: invokestatic 480	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   849: pop
    //   850: aload 11
    //   852: aload_1
    //   853: aload_2
    //   854: getfield 105	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   857: aload_2
    //   858: getfield 108	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   861: aload_2
    //   862: getfield 111	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   865: aload_2
    //   866: getfield 220	com/tencent/mm/modelcontrol/VideoTransPara:hbY	I
    //   869: bipush 8
    //   871: aload_2
    //   872: getfield 223	com/tencent/mm/modelcontrol/VideoTransPara:hbX	I
    //   875: ldc_w 481
    //   878: aload_2
    //   879: getfield 163	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   882: i2f
    //   883: aconst_null
    //   884: iconst_0
    //   885: iconst_0
    //   886: iconst_0
    //   887: bipush 51
    //   889: invokestatic 487	com/tencent/mm/plugin/sight/base/SightVideoJNI:remuxingVFS	(Ljava/lang/String;Ljava/lang/String;IIIIIIFF[BIZII)I
    //   892: istore 5
    //   894: getstatic 280	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   897: ldc2_w 488
    //   900: ldc2_w 490
    //   903: lconst_1
    //   904: invokevirtual 495	com/tencent/mm/plugin/report/service/h:m	(JJJ)V
    //   907: ldc 36
    //   909: ldc_w 497
    //   912: iconst_2
    //   913: anewarray 4	java/lang/Object
    //   916: dup
    //   917: iconst_0
    //   918: invokestatic 454	java/lang/System:currentTimeMillis	()J
    //   921: lload 7
    //   923: lsub
    //   924: invokestatic 254	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   927: aastore
    //   928: dup
    //   929: iconst_1
    //   930: iload 5
    //   932: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   935: aastore
    //   936: invokestatic 58	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.awT().c(paramVideoTransPara);
    if (localVideoTransPara == null)
    {
      ad.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", new Object[] { paramVideoTransPara });
      paramVideoTransPara = Aq(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    ad.d("MicroMsg.TransferUtil", "compress new para is %s", new Object[] { localVideoTransPara });
    if ((paramVideoTransPara.videoBitrate <= 640000) || (localVideoTransPara.videoBitrate > paramVideoTransPara.videoBitrate))
    {
      ad.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara, paramVideoTransPara });
      paramVideoTransPara = Aq(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    if ((paramVideoTransPara.fps >= 45) && (paramVideoTransPara.duration * 1000 >= 180000))
    {
      paramVideoTransPara = Aq(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    AppMethodBeat.o(127093);
    return localVideoTransPara;
  }
  
  private static void a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, long paramLong)
  {
    AppMethodBeat.i(127097);
    ad.m("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", new Object[] { paramString1, paramString2, paramVideoTransPara });
    g localg = new g();
    localg.b(paramString1, paramString2, paramVideoTransPara);
    localg.hBD = true;
    localg.hBE = true;
    int i = localg.mG(fD(paramString1));
    ad.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", new Object[] { Integer.valueOf(i) });
    B(i, paramLong);
    AppMethodBeat.o(127097);
  }
  
  public static int fD(String paramString)
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
      ad.e("MicroMsg.TransferUtil", "getDuration error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(127095);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bl.e
 * JD-Core Version:    0.7.0.1
 */