package com.tencent.mm.be;

import android.media.MediaMetadataRetriever;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class e
{
  private static final Object pcu;
  private static volatile boolean pcv;
  
  static
  {
    AppMethodBeat.i(127101);
    pcu = new Object();
    pcv = false;
    AppMethodBeat.o(127101);
  }
  
  private static void F(int paramInt, long paramLong)
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
    h.OAn.b(localArrayList, false);
    AppMethodBeat.o(127098);
  }
  
  /* Error */
  private static VideoTransPara QA(String paramString)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 109	com/tencent/mm/modelcontrol/VideoTransPara
    //   8: dup
    //   9: invokespecial 110	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   12: astore 5
    //   14: iconst_2
    //   15: newarray int
    //   17: astore 6
    //   19: new 112	com/tencent/mm/compatible/i/d
    //   22: dup
    //   23: invokespecial 113	com/tencent/mm/compatible/i/d:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_0
    //   31: invokevirtual 119	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   34: aload 4
    //   36: bipush 18
    //   38: invokevirtual 123	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   45: istore_3
    //   46: aload 4
    //   48: bipush 19
    //   50: invokevirtual 123	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: iconst_0
    //   54: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   89: invokevirtual 130	android/media/MediaMetadataRetriever:release	()V
    //   92: aload 5
    //   94: aload 6
    //   96: iconst_0
    //   97: iaload
    //   98: putfield 134	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   101: aload 5
    //   103: aload 6
    //   105: iconst_1
    //   106: iaload
    //   107: putfield 137	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   110: aload 5
    //   112: getstatic 142	com/tencent/mm/plugin/sight/base/d:PFk	I
    //   115: putfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   118: aload 5
    //   120: getstatic 148	com/tencent/mm/plugin/sight/base/d:PFj	I
    //   123: putfield 151	com/tencent/mm/modelcontrol/VideoTransPara:oBP	I
    //   126: aload 5
    //   128: iconst_2
    //   129: putfield 154	com/tencent/mm/modelcontrol/VideoTransPara:oBO	I
    //   132: aload 5
    //   134: getstatic 157	com/tencent/mm/plugin/sight/base/d:PFl	F
    //   137: f2i
    //   138: putfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   141: aload 5
    //   143: aload_0
    //   144: invokestatic 164	com/tencent/mm/be/e:jx	(Ljava/lang/String;)I
    //   147: putfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   150: ldc 107
    //   152: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   208: invokevirtual 130	android/media/MediaMetadataRetriever:release	()V
    //   211: goto -119 -> 92
    //   214: astore_0
    //   215: ldc 37
    //   217: aload_0
    //   218: ldc 169
    //   220: iconst_1
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_0
    //   227: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: ldc 107
    //   236: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   267: invokevirtual 130	android/media/MediaMetadataRetriever:release	()V
    //   270: ldc 107
    //   272: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   26	240	4	locald	com.tencent.mm.compatible.i.d
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
  
  public static boolean Qy(String paramString)
  {
    AppMethodBeat.i(127091);
    Log.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
    boolean bool = y.isH265Video(paramString);
    AppMethodBeat.o(127091);
    return bool;
  }
  
  /* Error */
  public static VideoTransPara Qz(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 189
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 37
    //   10: ldc 191
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: aastore
    //   20: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: new 109	com/tencent/mm/modelcontrol/VideoTransPara
    //   26: dup
    //   27: invokespecial 110	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   30: astore 7
    //   32: aload_0
    //   33: invokestatic 193	com/tencent/mm/be/e:Qy	(Ljava/lang/String;)Z
    //   36: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: astore_3
    //   40: ldc 37
    //   42: ldc 200
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_3
    //   51: aastore
    //   52: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_3
    //   56: invokevirtual 204	java/lang/Boolean:booleanValue	()Z
    //   59: ifeq +669 -> 728
    //   62: new 112	com/tencent/mm/compatible/i/d
    //   65: dup
    //   66: invokespecial 113	com/tencent/mm/compatible/i/d:<init>	()V
    //   69: astore 8
    //   71: aload 8
    //   73: aload_0
    //   74: invokevirtual 119	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   77: aload 7
    //   79: aload 8
    //   81: bipush 9
    //   83: invokevirtual 123	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   86: iconst_0
    //   87: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   90: putfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   93: aload 7
    //   95: aload 7
    //   97: getfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   100: i2l
    //   101: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   104: putfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   107: aload 7
    //   109: aload 8
    //   111: bipush 18
    //   113: invokevirtual 123	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   116: iconst_0
    //   117: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   120: putfield 134	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   123: aload 7
    //   125: aload 8
    //   127: bipush 19
    //   129: invokevirtual 123	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   132: iconst_0
    //   133: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   136: putfield 137	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   139: aload 7
    //   141: aload 8
    //   143: bipush 20
    //   145: invokevirtual 123	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   148: iconst_0
    //   149: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   152: putfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   155: new 210	com/tencent/mm/compatible/i/c
    //   158: dup
    //   159: invokespecial 211	com/tencent/mm/compatible/i/c:<init>	()V
    //   162: astore 4
    //   164: aload 4
    //   166: astore_3
    //   167: aload 4
    //   169: aload_0
    //   170: invokevirtual 212	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   173: aload 4
    //   175: astore_3
    //   176: aload 4
    //   178: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   181: invokevirtual 222	android/media/MediaExtractor:getTrackCount	()I
    //   184: istore_2
    //   185: iconst_0
    //   186: istore_1
    //   187: iload_1
    //   188: iload_2
    //   189: if_icmpge +128 -> 317
    //   192: aload 4
    //   194: astore_3
    //   195: aload 4
    //   197: iload_1
    //   198: invokevirtual 226	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   201: astore 5
    //   203: aload 4
    //   205: astore_3
    //   206: aload 5
    //   208: ldc 228
    //   210: invokevirtual 233	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   213: ifeq +350 -> 563
    //   216: aload 4
    //   218: astore_3
    //   219: aload 5
    //   221: ldc 228
    //   223: invokevirtual 237	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   229: ifne +334 -> 563
    //   232: aload 4
    //   234: astore_3
    //   235: aload 5
    //   237: ldc 228
    //   239: invokevirtual 237	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore 9
    //   244: aload 4
    //   246: astore_3
    //   247: ldc 37
    //   249: ldc 242
    //   251: iconst_1
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload 9
    //   259: aastore
    //   260: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload 4
    //   265: astore_3
    //   266: aload 9
    //   268: ldc 244
    //   270: invokevirtual 249	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   273: ifeq +290 -> 563
    //   276: aload 4
    //   278: astore_3
    //   279: aload 7
    //   281: aload 5
    //   283: ldc 251
    //   285: invokevirtual 254	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   288: putfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   291: aload 4
    //   293: astore_3
    //   294: ldc 37
    //   296: ldc_w 256
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload 7
    //   307: getfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   310: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload 4
    //   319: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   322: invokevirtual 257	android/media/MediaExtractor:release	()V
    //   325: aload 8
    //   327: invokevirtual 130	android/media/MediaMetadataRetriever:release	()V
    //   330: aload 7
    //   332: getfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   335: ifle +19 -> 354
    //   338: aload 7
    //   340: getfield 137	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   343: ifle +11 -> 354
    //   346: aload 7
    //   348: getfield 134	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   351: ifgt +187 -> 538
    //   354: ldc 37
    //   356: ldc_w 259
    //   359: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: new 210	com/tencent/mm/compatible/i/c
    //   365: dup
    //   366: invokespecial 211	com/tencent/mm/compatible/i/c:<init>	()V
    //   369: astore_3
    //   370: aload_3
    //   371: aload_0
    //   372: invokevirtual 212	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   375: iconst_0
    //   376: istore_1
    //   377: aload 6
    //   379: astore_0
    //   380: iload_1
    //   381: aload_3
    //   382: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   385: invokevirtual 222	android/media/MediaExtractor:getTrackCount	()I
    //   388: if_icmpge +33 -> 421
    //   391: aload_3
    //   392: iload_1
    //   393: invokevirtual 226	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   396: astore_0
    //   397: aload_0
    //   398: ldc 228
    //   400: invokevirtual 233	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   403: ifeq +279 -> 682
    //   406: aload_0
    //   407: ldc 228
    //   409: invokevirtual 237	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   412: ldc_w 264
    //   415: invokevirtual 268	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   418: ifeq +264 -> 682
    //   421: aload_0
    //   422: ifnull +109 -> 531
    //   425: aload_0
    //   426: ldc_w 270
    //   429: invokevirtual 233	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   432: ifeq +33 -> 465
    //   435: aload 7
    //   437: aload_0
    //   438: ldc_w 270
    //   441: invokevirtual 254	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   444: putfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   447: aload 7
    //   449: aload 7
    //   451: getfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   454: i2f
    //   455: ldc_w 271
    //   458: fdiv
    //   459: invokestatic 277	java/lang/Math:round	(F)I
    //   462: putfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   465: aload_0
    //   466: ldc_w 278
    //   469: invokevirtual 233	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   472: ifeq +37 -> 509
    //   475: aload_0
    //   476: ldc_w 279
    //   479: invokevirtual 233	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   482: ifeq +27 -> 509
    //   485: aload 7
    //   487: aload_0
    //   488: ldc_w 278
    //   491: invokevirtual 254	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   494: putfield 134	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   497: aload 7
    //   499: aload_0
    //   500: ldc_w 279
    //   503: invokevirtual 254	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   506: putfield 137	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   509: aload_0
    //   510: ldc_w 281
    //   513: invokevirtual 233	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   516: ifeq +15 -> 531
    //   519: aload 7
    //   521: aload_0
    //   522: ldc_w 281
    //   525: invokevirtual 254	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   528: putfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   531: aload_3
    //   532: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   535: invokevirtual 257	android/media/MediaExtractor:release	()V
    //   538: ldc 37
    //   540: ldc_w 283
    //   543: iconst_1
    //   544: anewarray 4	java/lang/Object
    //   547: dup
    //   548: iconst_0
    //   549: aload 7
    //   551: aastore
    //   552: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   555: ldc 189
    //   557: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   560: aload 7
    //   562: areturn
    //   563: iload_1
    //   564: iconst_1
    //   565: iadd
    //   566: istore_1
    //   567: goto -380 -> 187
    //   570: astore 5
    //   572: aconst_null
    //   573: astore 4
    //   575: aload 4
    //   577: astore_3
    //   578: ldc 37
    //   580: aload 5
    //   582: ldc_w 288
    //   585: iconst_0
    //   586: anewarray 4	java/lang/Object
    //   589: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   592: aload 4
    //   594: astore_3
    //   595: aload_0
    //   596: invokestatic 294	com/tencent/mm/plugin/sight/base/f:aVX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/b;
    //   599: astore 5
    //   601: aload 5
    //   603: ifnull +42 -> 645
    //   606: aload 4
    //   608: astore_3
    //   609: aload 7
    //   611: aload 5
    //   613: getfield 299	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   616: putfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   619: aload 4
    //   621: astore_3
    //   622: ldc 37
    //   624: ldc_w 301
    //   627: iconst_1
    //   628: anewarray 4	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: aload 5
    //   635: getfield 299	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   638: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   641: aastore
    //   642: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   645: aload 4
    //   647: ifnull -322 -> 325
    //   650: aload 4
    //   652: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   655: invokevirtual 257	android/media/MediaExtractor:release	()V
    //   658: goto -333 -> 325
    //   661: astore_0
    //   662: aconst_null
    //   663: astore_3
    //   664: aload_3
    //   665: ifnull +10 -> 675
    //   668: aload_3
    //   669: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   672: invokevirtual 257	android/media/MediaExtractor:release	()V
    //   675: ldc 189
    //   677: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   680: aload_0
    //   681: athrow
    //   682: iload_1
    //   683: iconst_1
    //   684: iadd
    //   685: istore_1
    //   686: goto -309 -> 377
    //   689: astore_0
    //   690: ldc 37
    //   692: aload_0
    //   693: ldc_w 303
    //   696: iconst_0
    //   697: anewarray 4	java/lang/Object
    //   700: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   703: aload_3
    //   704: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   707: invokevirtual 257	android/media/MediaExtractor:release	()V
    //   710: goto -172 -> 538
    //   713: astore_0
    //   714: aload_3
    //   715: getfield 216	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   718: invokevirtual 257	android/media/MediaExtractor:release	()V
    //   721: ldc 189
    //   723: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_0
    //   727: athrow
    //   728: new 305	com/tencent/mm/pointers/PInt
    //   731: dup
    //   732: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   735: astore_3
    //   736: new 305	com/tencent/mm/pointers/PInt
    //   739: dup
    //   740: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   743: astore 4
    //   745: new 305	com/tencent/mm/pointers/PInt
    //   748: dup
    //   749: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   752: astore 5
    //   754: new 305	com/tencent/mm/pointers/PInt
    //   757: dup
    //   758: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   761: astore 6
    //   763: new 305	com/tencent/mm/pointers/PInt
    //   766: dup
    //   767: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   770: astore 8
    //   772: aload_0
    //   773: aload_3
    //   774: aload 4
    //   776: aload 5
    //   778: aload 6
    //   780: aload 8
    //   782: invokestatic 310	com/tencent/mm/plugin/sight/base/f:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   785: pop
    //   786: aload 7
    //   788: aload_3
    //   789: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   792: i2l
    //   793: invokestatic 208	com/tencent/mm/sdk/platformtools/Util:videoMsToSec	(J)I
    //   796: putfield 167	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   799: aload 7
    //   801: aload 4
    //   803: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   806: putfield 134	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   809: aload 7
    //   811: aload 5
    //   813: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   816: putfield 137	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   819: aload 7
    //   821: aload 6
    //   823: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   826: putfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   829: aload 7
    //   831: aload 8
    //   833: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   836: putfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   839: goto -301 -> 538
    //   842: astore_0
    //   843: goto -179 -> 664
    //   846: astore 5
    //   848: goto -273 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	851	0	paramString	String
    //   186	500	1	i	int
    //   184	6	2	j	int
    //   39	750	3	localObject1	Object
    //   162	640	4	localObject2	Object
    //   201	81	5	localMediaFormat	android.media.MediaFormat
    //   570	11	5	localException1	Exception
    //   599	213	5	localObject3	Object
    //   846	1	5	localException2	Exception
    //   1	821	6	localPInt	com.tencent.mm.pointers.PInt
    //   30	800	7	localVideoTransPara	VideoTransPara
    //   69	763	8	localObject4	Object
    //   242	25	9	str	String
    // Exception table:
    //   from	to	target	type
    //   155	164	570	java/lang/Exception
    //   155	164	661	finally
    //   370	375	689	java/lang/Exception
    //   380	421	689	java/lang/Exception
    //   425	465	689	java/lang/Exception
    //   465	509	689	java/lang/Exception
    //   509	531	689	java/lang/Exception
    //   370	375	713	finally
    //   380	421	713	finally
    //   425	465	713	finally
    //   465	509	713	finally
    //   509	531	713	finally
    //   690	703	713	finally
    //   167	173	842	finally
    //   176	185	842	finally
    //   195	203	842	finally
    //   206	216	842	finally
    //   219	232	842	finally
    //   235	244	842	finally
    //   247	263	842	finally
    //   266	276	842	finally
    //   279	291	842	finally
    //   294	317	842	finally
    //   578	592	842	finally
    //   595	601	842	finally
    //   609	619	842	finally
    //   622	645	842	finally
    //   167	173	846	java/lang/Exception
    //   176	185	846	java/lang/Exception
    //   195	203	846	java/lang/Exception
    //   206	216	846	java/lang/Exception
    //   219	232	846	java/lang/Exception
    //   235	244	846	java/lang/Exception
    //   247	263	846	java/lang/Exception
    //   266	276	846	java/lang/Exception
    //   279	291	846	java/lang/Exception
    //   294	317	846	java/lang/Exception
  }
  
  public static int a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(231418);
    int i = a(paramString1, paramString2, paramVideoTransPara, false);
    AppMethodBeat.o(231418);
    return i;
  }
  
  /* Error */
  public static int a(String paramString1, final String paramString2, final VideoTransPara paramVideoTransPara, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 319
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 37
    //   8: ldc_w 321
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_3
    //   18: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   28: lstore 14
    //   30: iconst_0
    //   31: putstatic 28	com/tencent/mm/be/e:pcv	Z
    //   34: new 6	com/tencent/mm/be/e$1
    //   37: dup
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: lload 14
    //   43: invokespecial 324	com/tencent/mm/be/e$1:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
    //   46: astore 16
    //   48: iconst_1
    //   49: istore 9
    //   51: invokestatic 329	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
    //   54: ifeq +278 -> 332
    //   57: ldc_w 331
    //   60: invokestatic 337	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   63: checkcast 331	com/tencent/mm/plugin/zero/b/a
    //   66: invokeinterface 341 1 0
    //   71: ldc_w 343
    //   74: iconst_1
    //   75: invokevirtual 346	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   78: iconst_1
    //   79: if_icmpne +247 -> 326
    //   82: iconst_1
    //   83: istore 8
    //   85: goto +1123 -> 1208
    //   88: getstatic 352	com/tencent/mm/compatible/deviceinfo/af:lYj	Lcom/tencent/mm/compatible/deviceinfo/k;
    //   91: getfield 357	com/tencent/mm/compatible/deviceinfo/k:lVr	I
    //   94: istore 5
    //   96: iload 5
    //   98: iconst_m1
    //   99: if_icmpeq +1122 -> 1221
    //   102: iload 5
    //   104: iconst_1
    //   105: if_icmpne +1110 -> 1215
    //   108: iconst_1
    //   109: istore 8
    //   111: ldc 37
    //   113: ldc_w 359
    //   116: iconst_3
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: iload 9
    //   124: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: iload 5
    //   132: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: iload 8
    //   140: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   143: aastore
    //   144: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: iload 8
    //   149: ifeq +218 -> 367
    //   152: new 361	com/tencent/mm/be/g
    //   155: dup
    //   156: invokespecial 362	com/tencent/mm/be/g:<init>	()V
    //   159: astore 17
    //   161: aload 17
    //   163: aload_0
    //   164: aload_1
    //   165: aload_2
    //   166: invokevirtual 365	com/tencent/mm/be/g:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;)V
    //   169: aload 17
    //   171: iconst_1
    //   172: putfield 368	com/tencent/mm/be/g:pcK	Z
    //   175: aload 17
    //   177: iload 8
    //   179: putfield 371	com/tencent/mm/be/g:pcL	Z
    //   182: aconst_null
    //   183: astore 16
    //   185: ldc2_w 372
    //   188: lstore 10
    //   190: iconst_0
    //   191: istore 6
    //   193: aload 17
    //   195: ifnull +421 -> 616
    //   198: iload 8
    //   200: ifeq +416 -> 616
    //   203: aload 17
    //   205: aload_0
    //   206: invokestatic 164	com/tencent/mm/be/e:jx	(Ljava/lang/String;)I
    //   209: i2l
    //   210: invokevirtual 376	com/tencent/mm/be/g:jf	(J)I
    //   213: istore 5
    //   215: iload 5
    //   217: lload 14
    //   219: invokestatic 102	com/tencent/mm/be/e:F	(IJ)V
    //   222: aload_2
    //   223: ifnonnull +646 -> 869
    //   226: ldc 37
    //   228: ldc_w 378
    //   231: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload_0
    //   235: invokestatic 381	com/tencent/mm/plugin/sight/base/f:aMu	(Ljava/lang/String;)Ljava/lang/String;
    //   238: astore_2
    //   239: aload_1
    //   240: invokestatic 381	com/tencent/mm/plugin/sight/base/f:aMu	(Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 16
    //   245: aload_1
    //   246: invokestatic 386	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   249: ifne +33 -> 282
    //   252: getstatic 94	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   255: ldc2_w 387
    //   258: ldc2_w 389
    //   261: lconst_1
    //   262: iconst_0
    //   263: invokevirtual 394	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   266: ldc 37
    //   268: ldc_w 396
    //   271: iconst_1
    //   272: anewarray 4	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_1
    //   278: aastore
    //   279: invokestatic 398	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: ldc 37
    //   284: ldc_w 400
    //   287: iconst_4
    //   288: anewarray 4	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload_0
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: aload_2
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: aload_1
    //   302: aastore
    //   303: dup
    //   304: iconst_3
    //   305: aload 16
    //   307: aastore
    //   308: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: getstatic 406	com/tencent/mm/be/b:pcg	Lcom/tencent/mm/be/b;
    //   314: invokevirtual 409	com/tencent/mm/be/b:bvG	()V
    //   317: ldc_w 319
    //   320: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: iload 5
    //   325: ireturn
    //   326: iconst_0
    //   327: istore 8
    //   329: goto +879 -> 1208
    //   332: getstatic 415	com/tencent/mm/ipcinvoker/wx_extension/service/MainProcessIPCService:PROCESS_NAME	Ljava/lang/String;
    //   335: new 417	com/tencent/mm/ipcinvoker/type/IPCVoid
    //   338: dup
    //   339: invokespecial 418	com/tencent/mm/ipcinvoker/type/IPCVoid:<init>	()V
    //   342: ldc 8
    //   344: invokestatic 423	com/tencent/mm/ipcinvoker/j:a	(Ljava/lang/String;Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;
    //   347: checkcast 425	com/tencent/mm/ipcinvoker/type/IPCBoolean
    //   350: astore 17
    //   352: aload 17
    //   354: ifnull -266 -> 88
    //   357: aload 17
    //   359: getfield 427	com/tencent/mm/ipcinvoker/type/IPCBoolean:value	Z
    //   362: istore 9
    //   364: goto -276 -> 88
    //   367: aload_0
    //   368: invokestatic 294	com/tencent/mm/plugin/sight/base/f:aVX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/b;
    //   371: astore 17
    //   373: aload 17
    //   375: ifnull +825 -> 1200
    //   378: aload 17
    //   380: getfield 299	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   383: ifle +817 -> 1200
    //   386: aload_2
    //   387: ldc_w 428
    //   390: aload 17
    //   392: getfield 299	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   395: i2f
    //   396: invokestatic 432	java/lang/Math:min	(FF)F
    //   399: f2i
    //   400: putfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   403: ldc 37
    //   405: ldc_w 434
    //   408: iconst_2
    //   409: anewarray 4	java/lang/Object
    //   412: dup
    //   413: iconst_0
    //   414: aload_2
    //   415: getfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   418: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: dup
    //   423: iconst_1
    //   424: aload 17
    //   426: getfield 299	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   429: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: aastore
    //   433: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: aload 17
    //   438: getfield 437	com/tencent/mm/plugin/sight/base/b:videoDuration	I
    //   441: ifle +759 -> 1200
    //   444: aload 17
    //   446: getfield 437	com/tencent/mm/plugin/sight/base/b:videoDuration	I
    //   449: iconst_3
    //   450: imul
    //   451: i2l
    //   452: lstore 10
    //   454: aload_2
    //   455: getfield 440	com/tencent/mm/modelcontrol/VideoTransPara:oCh	I
    //   458: iconst_1
    //   459: if_icmpne +779 -> 1238
    //   462: iconst_1
    //   463: istore 9
    //   465: aload_2
    //   466: getfield 134	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   469: iconst_4
    //   470: invokestatic 444	com/tencent/mm/plugin/sight/base/f:lc	(II)I
    //   473: istore 7
    //   475: aload_2
    //   476: getfield 137	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   479: iconst_3
    //   480: invokestatic 444	com/tencent/mm/plugin/sight/base/f:lc	(II)I
    //   483: istore 6
    //   485: iload 6
    //   487: istore 5
    //   489: iload 6
    //   491: iconst_2
    //   492: irem
    //   493: ifeq +9 -> 502
    //   496: iload 6
    //   498: iconst_1
    //   499: iadd
    //   500: istore 5
    //   502: iload_3
    //   503: ifeq +43 -> 546
    //   506: getstatic 450	com/tencent/mm/media/i/c:nBL	Lcom/tencent/mm/media/i/c$a;
    //   509: aload_0
    //   510: aload_1
    //   511: iload 7
    //   513: iload 5
    //   515: aload_2
    //   516: getfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   519: aload_2
    //   520: getfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   523: aload_2
    //   524: getfield 453	com/tencent/mm/modelcontrol/VideoTransPara:nxU	I
    //   527: aload_2
    //   528: getfield 456	com/tencent/mm/modelcontrol/VideoTransPara:nxV	I
    //   531: aload 16
    //   533: invokeinterface 461 10 0
    //   538: astore 16
    //   540: aconst_null
    //   541: astore 17
    //   543: goto -353 -> 190
    //   546: getstatic 450	com/tencent/mm/media/i/c:nBL	Lcom/tencent/mm/media/i/c$a;
    //   549: aload_0
    //   550: aload_1
    //   551: iload 7
    //   553: iload 5
    //   555: aload_2
    //   556: getfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   559: aload_2
    //   560: getfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   563: aload_2
    //   564: getfield 453	com/tencent/mm/modelcontrol/VideoTransPara:nxU	I
    //   567: aload_2
    //   568: getfield 456	com/tencent/mm/modelcontrol/VideoTransPara:nxV	I
    //   571: iload 9
    //   573: aload 16
    //   575: invokeinterface 464 11 0
    //   580: astore 16
    //   582: aconst_null
    //   583: astore 17
    //   585: goto -395 -> 190
    //   588: astore_0
    //   589: ldc 37
    //   591: ldc_w 466
    //   594: iconst_1
    //   595: anewarray 4	java/lang/Object
    //   598: dup
    //   599: iconst_0
    //   600: aload_0
    //   601: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   604: aastore
    //   605: invokestatic 398	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   608: ldc_w 319
    //   611: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   614: iconst_m1
    //   615: ireturn
    //   616: iload 6
    //   618: istore 5
    //   620: aload 16
    //   622: ifnull -400 -> 222
    //   625: ldc 37
    //   627: ldc_w 468
    //   630: iconst_2
    //   631: anewarray 4	java/lang/Object
    //   634: dup
    //   635: iconst_0
    //   636: getstatic 28	com/tencent/mm/be/e:pcv	Z
    //   639: invokestatic 198	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   642: aastore
    //   643: dup
    //   644: iconst_1
    //   645: lload 10
    //   647: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   650: aastore
    //   651: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   654: aload 16
    //   656: invokevirtual 471	com/tencent/mm/media/i/c:bpE	()I
    //   659: pop
    //   660: getstatic 28	com/tencent/mm/be/e:pcv	Z
    //   663: ifne +74 -> 737
    //   666: getstatic 26	com/tencent/mm/be/e:pcu	Ljava/lang/Object;
    //   669: astore 16
    //   671: aload 16
    //   673: monitorenter
    //   674: ldc_w 473
    //   677: invokestatic 337	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   680: checkcast 473	com/tencent/mm/plugin/expt/b/c
    //   683: getstatic 479	com/tencent/mm/plugin/expt/b/c$a:yIW	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   686: iconst_m1
    //   687: invokeinterface 482 3 0
    //   692: i2l
    //   693: lstore 12
    //   695: lload 12
    //   697: lconst_0
    //   698: lcmp
    //   699: ifle +27 -> 726
    //   702: ldc 37
    //   704: ldc_w 484
    //   707: iconst_1
    //   708: anewarray 4	java/lang/Object
    //   711: dup
    //   712: iconst_0
    //   713: lload 12
    //   715: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   718: aastore
    //   719: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   722: lload 12
    //   724: lstore 10
    //   726: getstatic 26	com/tencent/mm/be/e:pcu	Ljava/lang/Object;
    //   729: lload 10
    //   731: invokevirtual 487	java/lang/Object:wait	(J)V
    //   734: aload 16
    //   736: monitorexit
    //   737: ldc 37
    //   739: ldc_w 489
    //   742: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: iload 6
    //   747: istore 5
    //   749: goto -527 -> 222
    //   752: astore 16
    //   754: ldc 37
    //   756: ldc_w 491
    //   759: iconst_1
    //   760: anewarray 4	java/lang/Object
    //   763: dup
    //   764: iconst_0
    //   765: aload 16
    //   767: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   770: aastore
    //   771: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   774: aload_0
    //   775: aload_1
    //   776: aload_2
    //   777: lload 14
    //   779: invokestatic 493	com/tencent/mm/be/e:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelcontrol/VideoTransPara;J)V
    //   782: iload 6
    //   784: istore 5
    //   786: goto -564 -> 222
    //   789: astore_0
    //   790: iconst_m1
    //   791: istore 5
    //   793: ldc 37
    //   795: ldc_w 495
    //   798: iconst_1
    //   799: anewarray 4	java/lang/Object
    //   802: dup
    //   803: iconst_0
    //   804: aload_0
    //   805: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   808: aastore
    //   809: invokestatic 398	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: getstatic 406	com/tencent/mm/be/b:pcg	Lcom/tencent/mm/be/b;
    //   815: invokevirtual 409	com/tencent/mm/be/b:bvG	()V
    //   818: goto -501 -> 317
    //   821: astore 17
    //   823: ldc 37
    //   825: aload 17
    //   827: ldc_w 497
    //   830: iconst_0
    //   831: anewarray 4	java/lang/Object
    //   834: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   837: goto -103 -> 734
    //   840: astore 17
    //   842: aload 16
    //   844: monitorexit
    //   845: ldc_w 319
    //   848: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   851: aload 17
    //   853: athrow
    //   854: astore_0
    //   855: getstatic 406	com/tencent/mm/be/b:pcg	Lcom/tencent/mm/be/b;
    //   858: invokevirtual 409	com/tencent/mm/be/b:bvG	()V
    //   861: ldc_w 319
    //   864: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   867: aload_0
    //   868: athrow
    //   869: aload_1
    //   870: invokestatic 502	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   873: ifeq +22 -> 895
    //   876: ldc 37
    //   878: ldc_w 504
    //   881: iconst_1
    //   882: anewarray 4	java/lang/Object
    //   885: dup
    //   886: iconst_0
    //   887: aload_1
    //   888: aastore
    //   889: invokestatic 398	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   892: goto -658 -> 234
    //   895: new 305	com/tencent/mm/pointers/PInt
    //   898: dup
    //   899: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   902: astore 16
    //   904: new 305	com/tencent/mm/pointers/PInt
    //   907: dup
    //   908: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   911: astore 17
    //   913: new 305	com/tencent/mm/pointers/PInt
    //   916: dup
    //   917: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   920: astore 18
    //   922: new 305	com/tencent/mm/pointers/PInt
    //   925: dup
    //   926: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   929: astore 19
    //   931: new 305	com/tencent/mm/pointers/PInt
    //   934: dup
    //   935: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	()V
    //   938: astore 20
    //   940: aload_1
    //   941: aload 16
    //   943: aload 17
    //   945: aload 18
    //   947: aload 19
    //   949: aload 20
    //   951: invokestatic 310	com/tencent/mm/plugin/sight/base/f:a	(Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Ljava/lang/String;
    //   954: pop
    //   955: ldc_w 331
    //   958: invokestatic 337	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   961: checkcast 331	com/tencent/mm/plugin/zero/b/a
    //   964: invokeinterface 341 1 0
    //   969: ldc_w 506
    //   972: invokevirtual 509	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   975: ldc_w 510
    //   978: invokestatic 514	com/tencent/mm/sdk/platformtools/Util:getFloat	(Ljava/lang/String;F)F
    //   981: fstore 4
    //   983: aload 20
    //   985: getfield 313	com/tencent/mm/pointers/PInt:value	I
    //   988: istore 6
    //   990: aload_2
    //   991: getfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   994: istore 7
    //   996: iload 6
    //   998: i2f
    //   999: fload 4
    //   1001: iload 7
    //   1003: i2f
    //   1004: fmul
    //   1005: fcmpg
    //   1006: ifge +34 -> 1040
    //   1009: ldc 37
    //   1011: ldc_w 516
    //   1014: iconst_2
    //   1015: anewarray 4	java/lang/Object
    //   1018: dup
    //   1019: iconst_0
    //   1020: iload 6
    //   1022: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1025: aastore
    //   1026: dup
    //   1027: iconst_1
    //   1028: iload 7
    //   1030: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1033: aastore
    //   1034: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1037: goto -803 -> 234
    //   1040: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   1043: lstore 10
    //   1045: ldc 37
    //   1047: ldc_w 523
    //   1050: iconst_2
    //   1051: anewarray 4	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: iload 6
    //   1058: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1061: aastore
    //   1062: dup
    //   1063: iconst_1
    //   1064: iload 7
    //   1066: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1069: aastore
    //   1070: invokestatic 526	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: new 528	java/lang/StringBuilder
    //   1076: dup
    //   1077: invokespecial 529	java/lang/StringBuilder:<init>	()V
    //   1080: aload_1
    //   1081: invokevirtual 533	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 535
    //   1087: invokevirtual 533	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 538	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: astore 16
    //   1095: aload_1
    //   1096: aload 16
    //   1098: iconst_0
    //   1099: invokestatic 542	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1102: pop2
    //   1103: aload_1
    //   1104: invokestatic 545	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1107: pop
    //   1108: aload 16
    //   1110: aload_1
    //   1111: aload_2
    //   1112: getfield 134	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   1115: aload_2
    //   1116: getfield 137	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   1119: aload_2
    //   1120: getfield 145	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   1123: aload_2
    //   1124: getfield 151	com/tencent/mm/modelcontrol/VideoTransPara:oBP	I
    //   1127: bipush 8
    //   1129: aload_2
    //   1130: getfield 154	com/tencent/mm/modelcontrol/VideoTransPara:oBO	I
    //   1133: ldc_w 546
    //   1136: aload_2
    //   1137: getfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   1140: i2f
    //   1141: aconst_null
    //   1142: iconst_0
    //   1143: iconst_0
    //   1144: iconst_0
    //   1145: bipush 51
    //   1147: invokestatic 552	com/tencent/mm/plugin/sight/base/SightVideoJNI:remuxingVFS	(Ljava/lang/String;Ljava/lang/String;IIIIIIFF[BIZII)I
    //   1150: istore 6
    //   1152: getstatic 94	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1155: ldc2_w 553
    //   1158: ldc2_w 555
    //   1161: lconst_1
    //   1162: invokevirtual 560	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   1165: ldc 37
    //   1167: ldc_w 562
    //   1170: iconst_2
    //   1171: anewarray 4	java/lang/Object
    //   1174: dup
    //   1175: iconst_0
    //   1176: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   1179: lload 10
    //   1181: lsub
    //   1182: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1185: aastore
    //   1186: dup
    //   1187: iconst_1
    //   1188: iload 6
    //   1190: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1193: aastore
    //   1194: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1197: goto -963 -> 234
    //   1200: ldc2_w 372
    //   1203: lstore 10
    //   1205: goto -751 -> 454
    //   1208: iload 8
    //   1210: istore 9
    //   1212: goto -1124 -> 88
    //   1215: iconst_0
    //   1216: istore 8
    //   1218: goto -1107 -> 111
    //   1221: iload 9
    //   1223: ifne +9 -> 1232
    //   1226: iconst_1
    //   1227: istore 8
    //   1229: goto -1118 -> 111
    //   1232: iconst_0
    //   1233: istore 8
    //   1235: goto -1124 -> 111
    //   1238: iconst_0
    //   1239: istore 9
    //   1241: goto -776 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1244	0	paramString1	String
    //   0	1244	1	paramString2	String
    //   0	1244	2	paramVideoTransPara	VideoTransPara
    //   0	1244	3	paramBoolean	boolean
    //   981	19	4	f	float
    //   94	698	5	i	int
    //   191	998	6	j	int
    //   473	592	7	k	int
    //   83	1151	8	bool1	boolean
    //   49	1191	9	bool2	boolean
    //   188	1016	10	l1	long
    //   693	30	12	l2	long
    //   28	750	14	l3	long
    //   752	91	16	localException1	Exception
    //   902	207	16	localObject2	Object
    //   159	425	17	localObject3	Object
    //   821	5	17	localException2	Exception
    //   840	12	17	localObject4	Object
    //   911	33	17	localPInt1	com.tencent.mm.pointers.PInt
    //   920	26	18	localPInt2	com.tencent.mm.pointers.PInt
    //   929	19	19	localPInt3	com.tencent.mm.pointers.PInt
    //   938	46	20	localPInt4	com.tencent.mm.pointers.PInt
    // Exception table:
    //   from	to	target	type
    //   51	82	588	java/lang/Exception
    //   88	96	588	java/lang/Exception
    //   111	147	588	java/lang/Exception
    //   152	182	588	java/lang/Exception
    //   332	352	588	java/lang/Exception
    //   357	364	588	java/lang/Exception
    //   367	373	588	java/lang/Exception
    //   378	454	588	java/lang/Exception
    //   454	462	588	java/lang/Exception
    //   465	485	588	java/lang/Exception
    //   506	540	588	java/lang/Exception
    //   546	582	588	java/lang/Exception
    //   625	674	752	java/lang/Exception
    //   737	745	752	java/lang/Exception
    //   842	854	752	java/lang/Exception
    //   203	222	789	java/lang/Exception
    //   226	234	789	java/lang/Exception
    //   234	282	789	java/lang/Exception
    //   282	311	789	java/lang/Exception
    //   754	782	789	java/lang/Exception
    //   869	892	789	java/lang/Exception
    //   895	996	789	java/lang/Exception
    //   1009	1037	789	java/lang/Exception
    //   1040	1197	789	java/lang/Exception
    //   674	695	821	java/lang/Exception
    //   702	722	821	java/lang/Exception
    //   726	734	821	java/lang/Exception
    //   674	695	840	finally
    //   702	722	840	finally
    //   726	734	840	finally
    //   734	737	840	finally
    //   823	837	840	finally
    //   203	222	854	finally
    //   226	234	854	finally
    //   234	282	854	finally
    //   282	311	854	finally
    //   625	674	854	finally
    //   737	745	854	finally
    //   754	782	854	finally
    //   793	812	854	finally
    //   842	854	854	finally
    //   869	892	854	finally
    //   895	996	854	finally
    //   1009	1037	854	finally
    //   1040	1197	854	finally
  }
  
  private static void a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, long paramLong)
  {
    AppMethodBeat.i(127097);
    Log.printInfoStack("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", new Object[] { paramString1, paramString2, paramVideoTransPara });
    g localg = new g();
    localg.b(paramString1, paramString2, paramVideoTransPara);
    localg.pcK = true;
    localg.pcL = true;
    int i = localg.jf(jx(paramString1));
    Log.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", new Object[] { Integer.valueOf(i) });
    F(i, paramLong);
    AppMethodBeat.o(127097);
  }
  
  public static VideoTransPara b(VideoTransPara paramVideoTransPara, String paramString)
  {
    AppMethodBeat.i(127093);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bIg().c(paramVideoTransPara);
    if (localVideoTransPara == null)
    {
      Log.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", new Object[] { paramVideoTransPara });
      paramVideoTransPara = QA(paramString);
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
      localVideoTransPara.fps = ((int)com.tencent.mm.plugin.sight.base.d.PFl);
    }
    Log.i("MicroMsg.TransferUtil", "final para is %s", new Object[] { paramVideoTransPara });
    AppMethodBeat.o(127093);
    return localVideoTransPara;
  }
  
  public static int jx(String paramString)
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
 * Qualified Name:     com.tencent.mm.be.e
 * JD-Core Version:    0.7.0.1
 */