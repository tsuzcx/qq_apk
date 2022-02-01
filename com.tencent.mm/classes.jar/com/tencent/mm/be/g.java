package com.tencent.mm.be;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class g
{
  private int bufId;
  private long emw;
  private String mhx;
  private boolean ojM;
  private a pcA;
  private a pcB;
  private List<a> pcC;
  private List<a> pcD;
  private String pcE;
  private String pcF;
  private VideoTransPara pcG;
  private long pcH;
  private int pcI;
  private int pcJ;
  boolean pcK;
  boolean pcL;
  private c pcz;
  
  public g()
  {
    AppMethodBeat.i(127102);
    this.pcC = new ArrayList();
    this.pcD = new ArrayList();
    this.pcI = -1;
    this.pcJ = -1;
    this.ojM = false;
    this.pcK = false;
    this.pcL = false;
    AppMethodBeat.o(127102);
  }
  
  /* Error */
  private static int QB(String paramString)
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 70	com/tencent/mm/compatible/i/d
    //   8: dup
    //   9: invokespecial 71	com/tencent/mm/compatible/i/d:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: invokevirtual 77	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   18: bipush 17
    //   20: invokestatic 83	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   23: ifeq +85 -> 108
    //   26: aload_2
    //   27: bipush 24
    //   29: invokevirtual 87	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   32: astore_0
    //   33: ldc 89
    //   35: ldc 91
    //   37: aload_0
    //   38: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokevirtual 101	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_2
    //   48: bipush 19
    //   50: invokevirtual 87	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: astore_3
    //   54: aload_2
    //   55: bipush 18
    //   57: invokevirtual 87	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   60: astore 4
    //   62: ldc 89
    //   64: ldc 109
    //   66: aload_3
    //   67: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 101	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: ldc 89
    //   78: ldc 111
    //   80: aload 4
    //   82: invokestatic 97	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   85: invokevirtual 101	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: iconst_0
    //   93: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   96: istore_1
    //   97: aload_2
    //   98: invokevirtual 120	android/media/MediaMetadataRetriever:release	()V
    //   101: ldc 68
    //   103: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iload_1
    //   107: ireturn
    //   108: new 122	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: invokestatic 128	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   119: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: goto -93 -> 33
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 120	android/media/MediaMetadataRetriever:release	()V
    //   140: ldc 68
    //   142: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_0
    //   146: athrow
    //   147: astore_0
    //   148: goto -16 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramString	String
    //   96	11	1	i	int
    //   12	125	2	locald	com.tencent.mm.compatible.i.d
    //   53	14	3	str1	String
    //   60	21	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	13	129	finally
    //   13	33	147	finally
    //   33	97	147	finally
    //   108	126	147	finally
  }
  
  /* Error */
  private int a(c paramc, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 140
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 89
    //   7: ldc 142
    //   9: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aconst_null
    //   13: astore 17
    //   15: new 146	com/tencent/mm/be/h
    //   18: dup
    //   19: aload_0
    //   20: getfield 148	com/tencent/mm/be/g:bufId	I
    //   23: invokespecial 150	com/tencent/mm/be/h:<init>	(I)V
    //   26: astore 16
    //   28: aload 16
    //   30: aload_0
    //   31: getfield 152	com/tencent/mm/be/g:emw	J
    //   34: putfield 155	com/tencent/mm/be/h:startTimeMs	J
    //   37: aload 16
    //   39: aload_0
    //   40: getfield 157	com/tencent/mm/be/g:pcH	J
    //   43: putfield 160	com/tencent/mm/be/h:endTimeMs	J
    //   46: aload_0
    //   47: getfield 162	com/tencent/mm/be/g:pcG	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   50: astore 17
    //   52: ldc 164
    //   54: ldc 166
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 17
    //   64: aastore
    //   65: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload 16
    //   70: aload 17
    //   72: putfield 172	com/tencent/mm/be/h:pcW	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   75: aload_0
    //   76: getfield 55	com/tencent/mm/be/g:pcJ	I
    //   79: bipush 90
    //   81: if_icmpeq +13 -> 94
    //   84: aload_0
    //   85: getfield 55	com/tencent/mm/be/g:pcJ	I
    //   88: sipush 270
    //   91: if_icmpne +858 -> 949
    //   94: aload 16
    //   96: aload 17
    //   98: getfield 177	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   101: aload 17
    //   103: getfield 180	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   106: invokevirtual 184	com/tencent/mm/be/h:eP	(II)V
    //   109: aload 16
    //   111: aload 4
    //   113: putfield 187	com/tencent/mm/be/h:pcY	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 55	com/tencent/mm/be/g:pcJ	I
    //   120: istore 7
    //   122: ldc 164
    //   124: ldc 189
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: iload 7
    //   134: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 16
    //   143: iload 7
    //   145: putfield 197	com/tencent/mm/be/h:hYK	I
    //   148: aload 16
    //   150: aload_0
    //   151: getfield 61	com/tencent/mm/be/g:pcL	Z
    //   154: putfield 198	com/tencent/mm/be/h:pcL	Z
    //   157: ldc 89
    //   159: ldc 200
    //   161: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: ldc 89
    //   166: ldc 202
    //   168: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: aload_0
    //   173: getfield 204	com/tencent/mm/be/g:pcA	Lcom/tencent/mm/be/g$a;
    //   176: getfield 207	com/tencent/mm/be/g$a:index	I
    //   179: invokevirtual 212	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   182: aload_1
    //   183: aload_0
    //   184: getfield 152	com/tencent/mm/be/g:emw	J
    //   187: ldc2_w 213
    //   190: lmul
    //   191: iconst_0
    //   192: invokevirtual 218	com/tencent/mm/compatible/i/c:seekTo	(JI)V
    //   195: aload_0
    //   196: getfield 162	com/tencent/mm/be/g:pcG	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   199: astore 4
    //   201: aload 4
    //   203: getfield 221	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   206: ifle +796 -> 1002
    //   209: aload 4
    //   211: getfield 221	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   214: istore 7
    //   216: aload_0
    //   217: iload 7
    //   219: invokestatic 227	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBufLock	(I)I
    //   222: putfield 148	com/tencent/mm/be/g:bufId	I
    //   225: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   228: lstore 11
    //   230: aload_0
    //   231: getfield 204	com/tencent/mm/be/g:pcA	Lcom/tencent/mm/be/g$a;
    //   234: getfield 207	com/tencent/mm/be/g$a:index	I
    //   237: istore 7
    //   239: aload 16
    //   241: aload_1
    //   242: putfield 234	com/tencent/mm/be/h:nAr	Lcom/tencent/mm/compatible/i/c;
    //   245: aload 16
    //   247: iload 7
    //   249: putfield 237	com/tencent/mm/be/h:videoTrackIndex	I
    //   252: aload 16
    //   254: aload_0
    //   255: getfield 204	com/tencent/mm/be/g:pcA	Lcom/tencent/mm/be/g$a;
    //   258: getfield 241	com/tencent/mm/be/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   261: aload_0
    //   262: getfield 59	com/tencent/mm/be/g:pcK	Z
    //   265: invokevirtual 244	com/tencent/mm/be/h:a	(Landroid/media/MediaFormat;Z)I
    //   268: istore 7
    //   270: iload 7
    //   272: ifge +23 -> 295
    //   275: aload_0
    //   276: getfield 148	com/tencent/mm/be/g:bufId	I
    //   279: invokestatic 247	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   282: aload_1
    //   283: getfield 251	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   286: invokevirtual 254	android/media/MediaExtractor:release	()V
    //   289: getstatic 260	com/tencent/mm/be/b:pcg	Lcom/tencent/mm/be/b;
    //   292: invokevirtual 263	com/tencent/mm/be/b:bvG	()V
    //   295: aload 16
    //   297: getfield 187	com/tencent/mm/be/h:pcY	Ljava/lang/String;
    //   300: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   303: ifne +144 -> 447
    //   306: aload 16
    //   308: getfield 187	com/tencent/mm/be/h:pcY	Ljava/lang/String;
    //   311: invokestatic 270	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 17
    //   316: ldc 164
    //   318: ldc_w 272
    //   321: iconst_1
    //   322: anewarray 4	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: aload 17
    //   329: aastore
    //   330: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: aload 17
    //   335: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   338: istore 15
    //   340: iload 15
    //   342: ifne +105 -> 447
    //   345: new 274	org/json/JSONObject
    //   348: dup
    //   349: aload 17
    //   351: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   354: ldc_w 278
    //   357: invokevirtual 282	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   360: d2i
    //   361: istore 7
    //   363: aload 16
    //   365: getfield 172	com/tencent/mm/be/h:pcW	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   368: ifnull +641 -> 1009
    //   371: aload 16
    //   373: getfield 172	com/tencent/mm/be/h:pcW	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   376: getfield 285	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   379: ifle +630 -> 1009
    //   382: aload 16
    //   384: getfield 172	com/tencent/mm/be/h:pcW	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   387: getfield 285	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   390: i2d
    //   391: dstore 5
    //   393: aload 16
    //   395: iload 7
    //   397: i2d
    //   398: dload 5
    //   400: ddiv
    //   401: invokestatic 291	java/lang/Math:ceil	(D)D
    //   404: d2i
    //   405: putfield 294	com/tencent/mm/be/h:nyO	I
    //   408: ldc 164
    //   410: ldc_w 296
    //   413: iconst_3
    //   414: anewarray 4	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: aload 16
    //   421: getfield 294	com/tencent/mm/be/h:nyO	I
    //   424: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: iload 7
    //   432: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   435: aastore
    //   436: dup
    //   437: iconst_2
    //   438: dload 5
    //   440: invokestatic 301	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   443: aastore
    //   444: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: aload 16
    //   449: getfield 305	com/tencent/mm/be/h:pcZ	Lcom/tencent/mm/be/a;
    //   452: aload 16
    //   454: getfield 294	com/tencent/mm/be/h:nyO	I
    //   457: invokeinterface 310 2 0
    //   462: aload 16
    //   464: getfield 305	com/tencent/mm/be/h:pcZ	Lcom/tencent/mm/be/a;
    //   467: new 312	com/tencent/mm/be/h$2
    //   470: dup
    //   471: aload 16
    //   473: invokespecial 315	com/tencent/mm/be/h$2:<init>	(Lcom/tencent/mm/be/h;)V
    //   476: invokeinterface 319 2 0
    //   481: lload 11
    //   483: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   486: lstore 11
    //   488: aload_1
    //   489: aload_0
    //   490: getfield 204	com/tencent/mm/be/g:pcA	Lcom/tencent/mm/be/g$a;
    //   493: getfield 207	com/tencent/mm/be/g$a:index	I
    //   496: invokevirtual 326	com/tencent/mm/compatible/i/c:unselectTrack	(I)V
    //   499: iconst_0
    //   500: istore 15
    //   502: aload_0
    //   503: getfield 328	com/tencent/mm/be/g:pcB	Lcom/tencent/mm/be/g$a;
    //   506: ifnull +48 -> 554
    //   509: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   512: lstore 13
    //   514: aload_0
    //   515: aload_1
    //   516: iload_2
    //   517: iload_3
    //   518: invokespecial 331	com/tencent/mm/be/g:a	(Lcom/tencent/mm/compatible/i/c;II)Z
    //   521: istore 15
    //   523: ldc 89
    //   525: ldc_w 333
    //   528: iconst_2
    //   529: anewarray 4	java/lang/Object
    //   532: dup
    //   533: iconst_0
    //   534: lload 13
    //   536: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   539: invokestatic 338	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   542: aastore
    //   543: dup
    //   544: iconst_1
    //   545: iload 15
    //   547: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   550: aastore
    //   551: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   557: lstore 13
    //   559: aload_0
    //   560: invokespecial 346	com/tencent/mm/be/g:bOS	()Ljava/lang/String;
    //   563: astore 17
    //   565: ldc 89
    //   567: ldc_w 348
    //   570: iconst_1
    //   571: anewarray 4	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: lload 11
    //   578: invokestatic 338	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   581: aastore
    //   582: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   585: ldc 89
    //   587: ldc_w 350
    //   590: iconst_1
    //   591: anewarray 4	java/lang/Object
    //   594: dup
    //   595: iconst_0
    //   596: aload 17
    //   598: aastore
    //   599: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   602: iconst_1
    //   603: istore_3
    //   604: iconst_1
    //   605: istore 8
    //   607: aload 4
    //   609: getfield 353	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   612: istore 7
    //   614: aload 4
    //   616: getfield 356	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
    //   619: istore 9
    //   621: iload 7
    //   623: istore_2
    //   624: iload 15
    //   626: ifne +647 -> 1273
    //   629: iload 7
    //   631: istore_2
    //   632: iload 8
    //   634: istore_3
    //   635: aload_0
    //   636: getfield 328	com/tencent/mm/be/g:pcB	Lcom/tencent/mm/be/g$a;
    //   639: getfield 241	com/tencent/mm/be/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   642: ldc_w 358
    //   645: invokevirtual 363	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   648: istore 8
    //   650: iload 7
    //   652: istore_2
    //   653: iload 8
    //   655: istore_3
    //   656: aload_0
    //   657: getfield 328	com/tencent/mm/be/g:pcB	Lcom/tencent/mm/be/g$a;
    //   660: getfield 241	com/tencent/mm/be/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   663: ldc_w 365
    //   666: invokevirtual 363	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   669: istore 7
    //   671: iload 7
    //   673: istore_2
    //   674: iload 8
    //   676: istore_3
    //   677: aload_0
    //   678: getfield 328	com/tencent/mm/be/g:pcB	Lcom/tencent/mm/be/g$a;
    //   681: getfield 241	com/tencent/mm/be/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   684: ldc_w 367
    //   687: invokevirtual 363	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   690: istore 10
    //   692: iload 10
    //   694: istore_2
    //   695: iload_2
    //   696: istore_3
    //   697: iload 8
    //   699: istore_2
    //   700: ldc 89
    //   702: ldc_w 369
    //   705: iconst_3
    //   706: anewarray 4	java/lang/Object
    //   709: dup
    //   710: iconst_0
    //   711: iload_2
    //   712: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   715: aastore
    //   716: dup
    //   717: iconst_1
    //   718: iload 7
    //   720: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   723: aastore
    //   724: dup
    //   725: iconst_2
    //   726: iload_3
    //   727: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   730: aastore
    //   731: invokestatic 372	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   734: ldc 89
    //   736: ldc_w 374
    //   739: iconst_4
    //   740: anewarray 4	java/lang/Object
    //   743: dup
    //   744: iconst_0
    //   745: iload 7
    //   747: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: aastore
    //   751: dup
    //   752: iconst_1
    //   753: iload_2
    //   754: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   757: aastore
    //   758: dup
    //   759: iconst_2
    //   760: aload 4
    //   762: getfield 285	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   765: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   768: aastore
    //   769: dup
    //   770: iconst_3
    //   771: aload 17
    //   773: aastore
    //   774: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   777: aload 16
    //   779: getfield 198	com/tencent/mm/be/h:pcL	Z
    //   782: ifeq +338 -> 1120
    //   785: iload 7
    //   787: sipush 1024
    //   790: iconst_2
    //   791: iload_2
    //   792: aload 17
    //   794: aload 4
    //   796: getfield 285	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   799: i2f
    //   800: aload_0
    //   801: getfield 157	com/tencent/mm/be/g:pcH	J
    //   804: aload_0
    //   805: getfield 152	com/tencent/mm/be/g:emw	J
    //   808: lsub
    //   809: l2i
    //   810: aconst_null
    //   811: iconst_0
    //   812: invokestatic 378	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264Lock	(IIIILjava/lang/String;FI[BI)I
    //   815: istore_2
    //   816: ldc 89
    //   818: ldc_w 380
    //   821: invokestatic 382	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: iload_2
    //   825: ifge +22 -> 847
    //   828: ldc 89
    //   830: ldc_w 384
    //   833: iconst_1
    //   834: anewarray 4	java/lang/Object
    //   837: dup
    //   838: iconst_0
    //   839: iload_2
    //   840: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   843: aastore
    //   844: invokestatic 372	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   847: aload_0
    //   848: getfield 55	com/tencent/mm/be/g:pcJ	I
    //   851: ifle +297 -> 1148
    //   854: aload_0
    //   855: invokespecial 346	com/tencent/mm/be/g:bOS	()Ljava/lang/String;
    //   858: aload_0
    //   859: getfield 386	com/tencent/mm/be/g:pcF	Ljava/lang/String;
    //   862: aload_0
    //   863: getfield 55	com/tencent/mm/be/g:pcJ	I
    //   866: invokestatic 390	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideoVFS	(Ljava/lang/String;Ljava/lang/String;I)I
    //   869: pop
    //   870: ldc 89
    //   872: ldc_w 392
    //   875: iconst_1
    //   876: anewarray 4	java/lang/Object
    //   879: dup
    //   880: iconst_0
    //   881: lload 13
    //   883: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   886: invokestatic 338	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   889: aastore
    //   890: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   893: ldc 89
    //   895: ldc_w 394
    //   898: iconst_1
    //   899: anewarray 4	java/lang/Object
    //   902: dup
    //   903: iconst_0
    //   904: invokestatic 231	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   907: invokestatic 323	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   910: invokestatic 338	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   913: aastore
    //   914: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   917: aload_0
    //   918: getfield 148	com/tencent/mm/be/g:bufId	I
    //   921: invokestatic 397	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   924: aload_1
    //   925: getfield 251	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   928: invokevirtual 254	android/media/MediaExtractor:release	()V
    //   931: getstatic 260	com/tencent/mm/be/b:pcg	Lcom/tencent/mm/be/b;
    //   934: invokevirtual 263	com/tencent/mm/be/b:bvG	()V
    //   937: aload 16
    //   939: invokevirtual 398	com/tencent/mm/be/h:release	()V
    //   942: ldc 140
    //   944: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   947: iconst_0
    //   948: ireturn
    //   949: aload 16
    //   951: aload 17
    //   953: getfield 180	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   956: aload 17
    //   958: getfield 177	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   961: invokevirtual 184	com/tencent/mm/be/h:eP	(II)V
    //   964: goto -855 -> 109
    //   967: astore_1
    //   968: aload 16
    //   970: astore 4
    //   972: ldc 89
    //   974: aload_1
    //   975: ldc_w 400
    //   978: iconst_0
    //   979: anewarray 4	java/lang/Object
    //   982: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   985: aload 4
    //   987: ifnull +8 -> 995
    //   990: aload 4
    //   992: invokevirtual 398	com/tencent/mm/be/h:release	()V
    //   995: ldc 140
    //   997: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1000: iconst_m1
    //   1001: ireturn
    //   1002: bipush 10
    //   1004: istore 7
    //   1006: goto -790 -> 216
    //   1009: ldc2_w 405
    //   1012: dstore 5
    //   1014: goto -621 -> 393
    //   1017: astore 17
    //   1019: ldc 164
    //   1021: aload 17
    //   1023: ldc_w 408
    //   1026: iconst_1
    //   1027: anewarray 4	java/lang/Object
    //   1030: dup
    //   1031: iconst_0
    //   1032: aload 17
    //   1034: invokevirtual 411	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1037: aastore
    //   1038: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1041: goto -594 -> 447
    //   1044: astore 4
    //   1046: ldc 89
    //   1048: aload 4
    //   1050: ldc_w 413
    //   1053: iconst_1
    //   1054: anewarray 4	java/lang/Object
    //   1057: dup
    //   1058: iconst_0
    //   1059: aload 4
    //   1061: invokevirtual 411	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1064: aastore
    //   1065: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1068: aload_0
    //   1069: getfield 148	com/tencent/mm/be/g:bufId	I
    //   1072: invokestatic 397	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   1075: aload_1
    //   1076: getfield 251	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   1079: invokevirtual 254	android/media/MediaExtractor:release	()V
    //   1082: getstatic 260	com/tencent/mm/be/b:pcg	Lcom/tencent/mm/be/b;
    //   1085: invokevirtual 263	com/tencent/mm/be/b:bvG	()V
    //   1088: goto -151 -> 937
    //   1091: astore_1
    //   1092: goto -155 -> 937
    //   1095: astore 18
    //   1097: ldc 89
    //   1099: ldc_w 415
    //   1102: iconst_1
    //   1103: anewarray 4	java/lang/Object
    //   1106: dup
    //   1107: iconst_0
    //   1108: aload 18
    //   1110: invokevirtual 411	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1113: aastore
    //   1114: invokestatic 372	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1117: goto +156 -> 1273
    //   1120: aload_0
    //   1121: getfield 148	com/tencent/mm/be/g:bufId	I
    //   1124: iload 7
    //   1126: sipush 1024
    //   1129: iconst_2
    //   1130: iload_2
    //   1131: aload 17
    //   1133: aload 4
    //   1135: getfield 285	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   1138: i2f
    //   1139: aconst_null
    //   1140: iconst_0
    //   1141: invokestatic 419	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingLock	(IIIIILjava/lang/String;F[BI)I
    //   1144: istore_2
    //   1145: goto -329 -> 816
    //   1148: aload_0
    //   1149: invokespecial 346	com/tencent/mm/be/g:bOS	()Ljava/lang/String;
    //   1152: aload_0
    //   1153: getfield 386	com/tencent/mm/be/g:pcF	Ljava/lang/String;
    //   1156: invokestatic 425	com/tencent/mm/vfs/y:qn	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1159: pop
    //   1160: goto -290 -> 870
    //   1163: astore 4
    //   1165: aload_0
    //   1166: getfield 148	com/tencent/mm/be/g:bufId	I
    //   1169: invokestatic 397	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   1172: aload_1
    //   1173: getfield 251	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   1176: invokevirtual 254	android/media/MediaExtractor:release	()V
    //   1179: getstatic 260	com/tencent/mm/be/b:pcg	Lcom/tencent/mm/be/b;
    //   1182: invokevirtual 263	com/tencent/mm/be/b:bvG	()V
    //   1185: ldc 140
    //   1187: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1190: aload 4
    //   1192: athrow
    //   1193: astore_1
    //   1194: ldc 89
    //   1196: aload_1
    //   1197: ldc_w 427
    //   1200: iconst_1
    //   1201: anewarray 4	java/lang/Object
    //   1204: dup
    //   1205: iconst_0
    //   1206: aload_1
    //   1207: invokevirtual 411	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1210: aastore
    //   1211: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1214: aload 16
    //   1216: invokevirtual 398	com/tencent/mm/be/h:release	()V
    //   1219: ldc 140
    //   1221: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1224: iconst_m1
    //   1225: ireturn
    //   1226: astore_1
    //   1227: aload 16
    //   1229: invokevirtual 398	com/tencent/mm/be/h:release	()V
    //   1232: ldc 140
    //   1234: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1237: aload_1
    //   1238: athrow
    //   1239: astore_1
    //   1240: goto -298 -> 942
    //   1243: astore_1
    //   1244: goto -25 -> 1219
    //   1247: astore 4
    //   1249: goto -17 -> 1232
    //   1252: astore_1
    //   1253: goto -68 -> 1185
    //   1256: astore_1
    //   1257: goto -320 -> 937
    //   1260: astore 17
    //   1262: goto -967 -> 295
    //   1265: astore_1
    //   1266: aload 17
    //   1268: astore 4
    //   1270: goto -298 -> 972
    //   1273: iload_2
    //   1274: istore 7
    //   1276: iload_3
    //   1277: istore_2
    //   1278: iload 9
    //   1280: istore_3
    //   1281: goto -581 -> 700
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1284	0	this	g
    //   0	1284	1	paramc	c
    //   0	1284	2	paramInt1	int
    //   0	1284	3	paramInt2	int
    //   0	1284	4	paramString	String
    //   391	622	5	d	double
    //   120	1155	7	i	int
    //   605	93	8	j	int
    //   619	660	9	k	int
    //   690	3	10	m	int
    //   228	349	11	l1	long
    //   512	370	13	l2	long
    //   338	287	15	bool	boolean
    //   26	1202	16	localh	h
    //   13	944	17	localObject	Object
    //   1017	115	17	localException1	Exception
    //   1260	7	17	localException2	Exception
    //   1095	14	18	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   28	94	967	java/lang/Exception
    //   94	109	967	java/lang/Exception
    //   109	157	967	java/lang/Exception
    //   949	964	967	java/lang/Exception
    //   345	393	1017	java/lang/Exception
    //   393	447	1017	java/lang/Exception
    //   195	216	1044	java/lang/Exception
    //   216	270	1044	java/lang/Exception
    //   295	340	1044	java/lang/Exception
    //   447	499	1044	java/lang/Exception
    //   502	554	1044	java/lang/Exception
    //   554	602	1044	java/lang/Exception
    //   607	621	1044	java/lang/Exception
    //   700	816	1044	java/lang/Exception
    //   816	824	1044	java/lang/Exception
    //   828	847	1044	java/lang/Exception
    //   847	870	1044	java/lang/Exception
    //   870	917	1044	java/lang/Exception
    //   1019	1041	1044	java/lang/Exception
    //   1097	1117	1044	java/lang/Exception
    //   1120	1145	1044	java/lang/Exception
    //   1148	1160	1044	java/lang/Exception
    //   1068	1088	1091	java/lang/Exception
    //   635	650	1095	java/lang/Exception
    //   656	671	1095	java/lang/Exception
    //   677	692	1095	java/lang/Exception
    //   195	216	1163	finally
    //   216	270	1163	finally
    //   275	295	1163	finally
    //   295	340	1163	finally
    //   345	393	1163	finally
    //   393	447	1163	finally
    //   447	499	1163	finally
    //   502	554	1163	finally
    //   554	602	1163	finally
    //   607	621	1163	finally
    //   635	650	1163	finally
    //   656	671	1163	finally
    //   677	692	1163	finally
    //   700	816	1163	finally
    //   816	824	1163	finally
    //   828	847	1163	finally
    //   847	870	1163	finally
    //   870	917	1163	finally
    //   1019	1041	1163	finally
    //   1046	1068	1163	finally
    //   1097	1117	1163	finally
    //   1120	1145	1163	finally
    //   1148	1160	1163	finally
    //   164	195	1193	java/lang/Exception
    //   1185	1193	1193	java/lang/Exception
    //   164	195	1226	finally
    //   917	937	1226	finally
    //   1068	1088	1226	finally
    //   1165	1185	1226	finally
    //   1185	1193	1226	finally
    //   1194	1214	1226	finally
    //   937	942	1239	java/lang/Exception
    //   1214	1219	1243	java/lang/Exception
    //   1227	1232	1247	java/lang/Exception
    //   1165	1185	1252	java/lang/Exception
    //   917	937	1256	java/lang/Exception
    //   275	295	1260	java/lang/Exception
    //   15	28	1265	java/lang/Exception
  }
  
  private boolean a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127106);
    if (this.pcB == null)
    {
      AppMethodBeat.o(127106);
      return false;
    }
    paramc.selectTrack(this.pcB.index);
    paramc.seekTo(this.emw * 1000L, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1);
    try
    {
      this.pcB.mediaFormat.getInteger("channel-count");
      Log.i("MicroMsg.VideoTranferH265toH264", "audio channel count");
      localByteBuffer.clear();
      paramInt1 = paramc.readSampleData(localByteBuffer, 0);
      if (paramInt1 <= 0)
      {
        Log.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(127106);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.VideoTranferH265toH264", "get channel count error: %s", new Object[] { Integer.valueOf(1) });
        continue;
        if (paramc.lZm.getSampleTime() < this.pcH * 1000L) {
          if (paramc.lZm.getSampleTrackIndex() != this.pcB.index)
          {
            Log.e("MicroMsg.VideoTranferH265toH264", "track index not match! break");
          }
          else
          {
            localByteBuffer.position(0);
            MP4MuxerJNI.writeAACDataLock(paramInt2, localByteBuffer, paramInt1);
            paramc.lZm.advance();
          }
        }
      }
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(127108);
    int j = paramc.lZm.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramc.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!Util.isNullOrNil(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        Log.i("MicroMsg.VideoTranferH265toH264", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label119;
        }
        this.pcD.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label119:
        if (str.startsWith("video/")) {
          this.pcC.add(new a(localMediaFormat, i));
        }
      }
    }
    Log.i("MicroMsg.VideoTranferH265toH264", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.pcD.size()), Integer.valueOf(this.pcC.size()) });
    AppMethodBeat.o(127108);
  }
  
  private int bOR()
  {
    AppMethodBeat.i(127109);
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.pcD != null)
    {
      i = j;
      if (this.pcD.size() != 0)
      {
        localIterator = this.pcD.iterator();
        i = -1;
        if (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          if (!locala.mediaFormat.containsKey("max-input-size")) {
            break label195;
          }
          i = Math.max(locala.mediaFormat.getInteger("max-input-size"), i);
        }
      }
    }
    label192:
    label195:
    for (;;)
    {
      break;
      j = i;
      if (this.pcC != null)
      {
        j = i;
        if (this.pcC.size() != 0)
        {
          localIterator = this.pcC.iterator();
          if (localIterator.hasNext())
          {
            locala = (a)localIterator.next();
            if (!locala.mediaFormat.containsKey("max-input-size")) {
              break label192;
            }
            i = Math.max(locala.mediaFormat.getInteger("max-input-size"), i);
          }
        }
      }
      for (;;)
      {
        break;
        j = i;
        AppMethodBeat.o(127109);
        return j;
      }
    }
  }
  
  private String bOS()
  {
    AppMethodBeat.i(127113);
    if (this.mhx == null) {
      this.mhx = (this.pcF + "video_temp.mp4");
    }
    String str = this.mhx;
    AppMethodBeat.o(127113);
    return str;
  }
  
  private static void c(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(127107);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramVideoTransPara == null))
    {
      paramString1 = new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
      AppMethodBeat.o(127107);
      throw paramString1;
    }
    paramVideoTransPara = new u(paramString1);
    new u(paramString2);
    if ((!paramVideoTransPara.jKS()) || (!paramVideoTransPara.jKQ()) || (paramVideoTransPara.length() == 0L))
    {
      paramString1 = new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
      AppMethodBeat.o(127107);
      throw paramString1;
    }
    AppMethodBeat.o(127107);
  }
  
  private void jg(long paramLong)
  {
    AppMethodBeat.i(127112);
    Log.e("MicroMsg.VideoTranferH265toH264", "init %s", new Object[] { Boolean.valueOf(this.ojM) });
    if (!this.ojM) {
      Log.e("MicroMsg.VideoTranferH265toH264", "checkTimeParameter has not been initialized.");
    }
    this.emw = 0L;
    Object localObject = ((a)this.pcC.get(0)).mediaFormat;
    if (!((MediaFormat)localObject).containsKey("durationUs"))
    {
      localObject = new f("Can not find duration.");
      AppMethodBeat.o(127112);
      throw ((Throwable)localObject);
    }
    long l;
    if (paramLong > 0L)
    {
      l = paramLong;
      if (paramLong <= ((MediaFormat)localObject).getLong("durationUs") / 1000L) {}
    }
    else
    {
      l = ((MediaFormat)localObject).getLong("durationUs") / 1000L;
    }
    this.pcH = l;
    AppMethodBeat.o(127112);
  }
  
  private void release()
  {
    AppMethodBeat.i(127111);
    this.ojM = false;
    if (this.pcz != null) {
      this.pcz.lZm.release();
    }
    AppMethodBeat.o(127111);
  }
  
  public final void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(127103);
    Log.d("MicroMsg.VideoTranferH265toH264", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = Util.currentTicks();
    c(paramString1, paramString2, paramVideoTransPara);
    this.pcE = paramString1;
    this.pcF = paramString2;
    this.pcG = paramVideoTransPara;
    this.pcz = new c();
    this.pcz.setDataSource(paramString1);
    b(this.pcz);
    if ((this.pcC == null) || (this.pcC.size() == 0))
    {
      paramString1 = new f("Can not find video or audio track in this video file.");
      AppMethodBeat.o(127103);
      throw paramString1;
    }
    this.pcI = bOR();
    this.pcJ = QB(paramString1);
    this.ojM = true;
    Log.e("MicroMsg.VideoTranferH265toH264", "init cost time %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(127103);
  }
  
  public final int jf(long paramLong)
  {
    AppMethodBeat.i(127104);
    jg(paramLong);
    this.pcA = ((a)this.pcC.get(0));
    if ((this.pcD != null) && (this.pcD.size() != 0)) {
      this.pcB = ((a)this.pcD.get(0));
    }
    c localc = this.pcz;
    if (this.pcI <= 0) {}
    for (int i = 1048576; a(localc, i, this.bufId, this.pcE) == -1; i = this.pcI)
    {
      Log.e("MicroMsg.VideoTranferH265toH264", "transcodeAndMux error");
      release();
      AppMethodBeat.o(127104);
      return -1;
    }
    AppMethodBeat.o(127104);
    return 0;
  }
  
  final class a
  {
    int index;
    MediaFormat mediaFormat;
    
    a(MediaFormat paramMediaFormat, int paramInt)
    {
      this.mediaFormat = paramMediaFormat;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.g
 * JD-Core Version:    0.7.0.1
 */