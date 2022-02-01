package com.tencent.mm.bk;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class g
{
  private int bufId;
  private long cwj;
  private String gWS;
  private boolean iCs;
  private a jtA;
  private List<a> jtB;
  private List<a> jtC;
  private String jtD;
  private String jtE;
  private VideoTransPara jtF;
  private long jtG;
  private int jtH;
  private int jtI;
  boolean jtJ;
  boolean jtK;
  private c jty;
  private a jtz;
  
  public g()
  {
    AppMethodBeat.i(127102);
    this.jtB = new ArrayList();
    this.jtC = new ArrayList();
    this.jtH = -1;
    this.jtI = -1;
    this.iCs = false;
    this.jtJ = false;
    this.jtK = false;
    AppMethodBeat.o(127102);
  }
  
  private void AN(long paramLong)
  {
    AppMethodBeat.i(127112);
    Log.e("MicroMsg.VideoTranferH265toH264", "init %s", new Object[] { Boolean.valueOf(this.iCs) });
    if (!this.iCs) {
      Log.e("MicroMsg.VideoTranferH265toH264", "checkTimeParameter has not been initialized.");
    }
    this.cwj = 0L;
    Object localObject = ((a)this.jtB.get(0)).mediaFormat;
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
    this.jtG = l;
    AppMethodBeat.o(127112);
  }
  
  /* Error */
  private static int QZ(String paramString)
  {
    // Byte code:
    //   0: ldc 127
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 129	com/tencent/mm/compatible/i/d
    //   8: dup
    //   9: invokespecial 130	com/tencent/mm/compatible/i/d:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: invokevirtual 135	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   18: bipush 17
    //   20: invokestatic 141	com/tencent/mm/compatible/util/d:oD	(I)Z
    //   23: ifeq +85 -> 108
    //   26: aload_2
    //   27: bipush 24
    //   29: invokevirtual 145	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   32: astore_0
    //   33: ldc 70
    //   35: ldc 147
    //   37: aload_0
    //   38: invokestatic 152	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_2
    //   48: bipush 19
    //   50: invokevirtual 145	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: astore_3
    //   54: aload_2
    //   55: bipush 18
    //   57: invokevirtual 145	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   60: astore 4
    //   62: ldc 70
    //   64: ldc 161
    //   66: aload_3
    //   67: invokestatic 152	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: ldc 70
    //   78: ldc 163
    //   80: aload 4
    //   82: invokestatic 152	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   85: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: iconst_0
    //   93: invokestatic 169	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   96: istore_1
    //   97: aload_2
    //   98: invokevirtual 172	android/media/MediaMetadataRetriever:release	()V
    //   101: ldc 127
    //   103: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iload_1
    //   107: ireturn
    //   108: new 174	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: invokestatic 180	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4RotateVFS	(Ljava/lang/String;)I
    //   119: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: goto -93 -> 33
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 172	android/media/MediaMetadataRetriever:release	()V
    //   140: ldc 127
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
    //   0: ldc 192
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 70
    //   7: ldc 194
    //   9: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aconst_null
    //   13: astore 17
    //   15: new 198	com/tencent/mm/bk/h
    //   18: dup
    //   19: aload_0
    //   20: getfield 200	com/tencent/mm/bk/g:bufId	I
    //   23: invokespecial 202	com/tencent/mm/bk/h:<init>	(I)V
    //   26: astore 16
    //   28: aload 16
    //   30: aload_0
    //   31: getfield 91	com/tencent/mm/bk/g:cwj	J
    //   34: putfield 205	com/tencent/mm/bk/h:startTimeMs	J
    //   37: aload 16
    //   39: aload_0
    //   40: getfield 124	com/tencent/mm/bk/g:jtG	J
    //   43: putfield 208	com/tencent/mm/bk/h:endTimeMs	J
    //   46: aload_0
    //   47: getfield 210	com/tencent/mm/bk/g:jtF	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   50: astore 17
    //   52: ldc 212
    //   54: ldc 214
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 17
    //   64: aastore
    //   65: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload 16
    //   70: aload 17
    //   72: putfield 219	com/tencent/mm/bk/h:jtV	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   75: aload_0
    //   76: getfield 55	com/tencent/mm/bk/g:jtI	I
    //   79: bipush 90
    //   81: if_icmpeq +13 -> 94
    //   84: aload_0
    //   85: getfield 55	com/tencent/mm/bk/g:jtI	I
    //   88: sipush 270
    //   91: if_icmpne +838 -> 929
    //   94: aload 16
    //   96: aload 17
    //   98: getfield 224	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   101: aload 17
    //   103: getfield 227	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   106: invokevirtual 231	com/tencent/mm/bk/h:dA	(II)V
    //   109: aload 16
    //   111: aload 4
    //   113: putfield 234	com/tencent/mm/bk/h:jtX	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 55	com/tencent/mm/bk/g:jtI	I
    //   120: istore 7
    //   122: ldc 212
    //   124: ldc 236
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: iload 7
    //   134: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 16
    //   143: iload 7
    //   145: putfield 244	com/tencent/mm/bk/h:dYT	I
    //   148: aload 16
    //   150: aload_0
    //   151: getfield 61	com/tencent/mm/bk/g:jtK	Z
    //   154: putfield 245	com/tencent/mm/bk/h:jtK	Z
    //   157: ldc 70
    //   159: ldc 247
    //   161: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: ldc 70
    //   166: ldc 249
    //   168: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: aload_0
    //   173: getfield 251	com/tencent/mm/bk/g:jtz	Lcom/tencent/mm/bk/g$a;
    //   176: getfield 254	com/tencent/mm/bk/g$a:index	I
    //   179: invokevirtual 259	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   182: aload_1
    //   183: aload_0
    //   184: getfield 91	com/tencent/mm/bk/g:cwj	J
    //   187: ldc2_w 121
    //   190: lmul
    //   191: iconst_0
    //   192: invokevirtual 263	com/tencent/mm/compatible/i/c:seekTo	(JI)V
    //   195: aload_0
    //   196: getfield 210	com/tencent/mm/bk/g:jtF	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   199: astore 4
    //   201: aload 4
    //   203: getfield 266	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   206: ifle +776 -> 982
    //   209: aload 4
    //   211: getfield 266	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   214: istore 7
    //   216: aload_0
    //   217: iload 7
    //   219: invokestatic 272	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBufLock	(I)I
    //   222: putfield 200	com/tencent/mm/bk/g:bufId	I
    //   225: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   228: lstore 11
    //   230: aload_0
    //   231: getfield 251	com/tencent/mm/bk/g:jtz	Lcom/tencent/mm/bk/g$a;
    //   234: getfield 254	com/tencent/mm/bk/g$a:index	I
    //   237: istore 7
    //   239: aload 16
    //   241: aload_1
    //   242: putfield 279	com/tencent/mm/bk/h:igg	Lcom/tencent/mm/compatible/i/c;
    //   245: aload 16
    //   247: iload 7
    //   249: putfield 282	com/tencent/mm/bk/h:videoTrackIndex	I
    //   252: aload 16
    //   254: aload_0
    //   255: getfield 251	com/tencent/mm/bk/g:jtz	Lcom/tencent/mm/bk/g$a;
    //   258: getfield 101	com/tencent/mm/bk/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   261: aload_0
    //   262: getfield 59	com/tencent/mm/bk/g:jtJ	Z
    //   265: invokevirtual 285	com/tencent/mm/bk/h:a	(Landroid/media/MediaFormat;Z)I
    //   268: istore 7
    //   270: iload 7
    //   272: ifge +23 -> 295
    //   275: aload_0
    //   276: getfield 200	com/tencent/mm/bk/g:bufId	I
    //   279: invokestatic 288	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   282: aload_1
    //   283: getfield 292	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   286: invokevirtual 295	android/media/MediaExtractor:release	()V
    //   289: getstatic 301	com/tencent/mm/bk/b:jtf	Lcom/tencent/mm/bk/b;
    //   292: invokevirtual 304	com/tencent/mm/bk/b:aRR	()V
    //   295: aload 16
    //   297: getfield 234	com/tencent/mm/bk/h:jtX	Ljava/lang/String;
    //   300: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   303: ifne +144 -> 447
    //   306: aload 16
    //   308: getfield 234	com/tencent/mm/bk/h:jtX	Ljava/lang/String;
    //   311: invokestatic 310	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4InfoVFS	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 17
    //   316: ldc 212
    //   318: ldc_w 312
    //   321: iconst_1
    //   322: anewarray 4	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: aload 17
    //   329: aastore
    //   330: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: aload 17
    //   335: invokestatic 307	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   338: istore 15
    //   340: iload 15
    //   342: ifne +105 -> 447
    //   345: new 314	org/json/JSONObject
    //   348: dup
    //   349: aload 17
    //   351: invokespecial 315	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   354: ldc_w 317
    //   357: invokevirtual 321	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   360: d2i
    //   361: istore 7
    //   363: aload 16
    //   365: getfield 219	com/tencent/mm/bk/h:jtV	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   368: ifnull +621 -> 989
    //   371: aload 16
    //   373: getfield 219	com/tencent/mm/bk/h:jtV	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   376: getfield 324	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   379: ifle +610 -> 989
    //   382: aload 16
    //   384: getfield 219	com/tencent/mm/bk/h:jtV	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   387: getfield 324	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   390: i2d
    //   391: dstore 5
    //   393: aload 16
    //   395: iload 7
    //   397: i2d
    //   398: dload 5
    //   400: ddiv
    //   401: invokestatic 330	java/lang/Math:ceil	(D)D
    //   404: d2i
    //   405: putfield 333	com/tencent/mm/bk/h:ies	I
    //   408: ldc 212
    //   410: ldc_w 335
    //   413: iconst_3
    //   414: anewarray 4	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: aload 16
    //   421: getfield 333	com/tencent/mm/bk/h:ies	I
    //   424: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: iload 7
    //   432: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   435: aastore
    //   436: dup
    //   437: iconst_2
    //   438: dload 5
    //   440: invokestatic 340	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   443: aastore
    //   444: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   447: aload 16
    //   449: getfield 344	com/tencent/mm/bk/h:jtY	Lcom/tencent/mm/bk/a;
    //   452: aload 16
    //   454: getfield 333	com/tencent/mm/bk/h:ies	I
    //   457: invokeinterface 349 2 0
    //   462: aload 16
    //   464: getfield 344	com/tencent/mm/bk/h:jtY	Lcom/tencent/mm/bk/a;
    //   467: new 351	com/tencent/mm/bk/h$2
    //   470: dup
    //   471: aload 16
    //   473: invokespecial 354	com/tencent/mm/bk/h$2:<init>	(Lcom/tencent/mm/bk/h;)V
    //   476: invokeinterface 357 2 0
    //   481: lload 11
    //   483: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   486: lstore 11
    //   488: aload_1
    //   489: aload_0
    //   490: getfield 251	com/tencent/mm/bk/g:jtz	Lcom/tencent/mm/bk/g$a;
    //   493: getfield 254	com/tencent/mm/bk/g$a:index	I
    //   496: invokevirtual 364	com/tencent/mm/compatible/i/c:unselectTrack	(I)V
    //   499: aload_0
    //   500: getfield 366	com/tencent/mm/bk/g:jtA	Lcom/tencent/mm/bk/g$a;
    //   503: ifnull +45 -> 548
    //   506: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   509: lstore 13
    //   511: aload_0
    //   512: aload_1
    //   513: iload_2
    //   514: iload_3
    //   515: invokespecial 369	com/tencent/mm/bk/g:a	(Lcom/tencent/mm/compatible/i/c;II)Z
    //   518: pop
    //   519: ldc 70
    //   521: ldc_w 371
    //   524: iconst_2
    //   525: anewarray 4	java/lang/Object
    //   528: dup
    //   529: iconst_0
    //   530: lload 13
    //   532: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   535: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   538: aastore
    //   539: dup
    //   540: iconst_1
    //   541: getstatic 380	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   544: aastore
    //   545: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   548: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   551: lstore 13
    //   553: aload_0
    //   554: invokespecial 383	com/tencent/mm/bk/g:bhO	()Ljava/lang/String;
    //   557: astore 17
    //   559: ldc 70
    //   561: ldc_w 385
    //   564: iconst_1
    //   565: anewarray 4	java/lang/Object
    //   568: dup
    //   569: iconst_0
    //   570: lload 11
    //   572: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   575: aastore
    //   576: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   579: ldc 70
    //   581: ldc_w 387
    //   584: iconst_1
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload 17
    //   592: aastore
    //   593: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   596: iconst_1
    //   597: istore_3
    //   598: aload 4
    //   600: getfield 390	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   603: istore 8
    //   605: aload 4
    //   607: getfield 393	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
    //   610: istore 9
    //   612: iload 8
    //   614: istore_2
    //   615: aload_0
    //   616: getfield 366	com/tencent/mm/bk/g:jtA	Lcom/tencent/mm/bk/g$a;
    //   619: getfield 101	com/tencent/mm/bk/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   622: ldc_w 395
    //   625: invokevirtual 398	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   628: istore 7
    //   630: iload 8
    //   632: istore_2
    //   633: iload 7
    //   635: istore_3
    //   636: aload_0
    //   637: getfield 366	com/tencent/mm/bk/g:jtA	Lcom/tencent/mm/bk/g$a;
    //   640: getfield 101	com/tencent/mm/bk/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   643: ldc_w 400
    //   646: invokevirtual 398	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   649: istore 8
    //   651: iload 8
    //   653: istore_2
    //   654: iload 7
    //   656: istore_3
    //   657: aload_0
    //   658: getfield 366	com/tencent/mm/bk/g:jtA	Lcom/tencent/mm/bk/g$a;
    //   661: getfield 101	com/tencent/mm/bk/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   664: ldc_w 402
    //   667: invokevirtual 398	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   670: istore 10
    //   672: iload 10
    //   674: istore_2
    //   675: iload_2
    //   676: istore_3
    //   677: iload 7
    //   679: istore_2
    //   680: ldc 70
    //   682: ldc_w 404
    //   685: iconst_3
    //   686: anewarray 4	java/lang/Object
    //   689: dup
    //   690: iconst_0
    //   691: iload_2
    //   692: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: iload 8
    //   700: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   703: aastore
    //   704: dup
    //   705: iconst_2
    //   706: iload_3
    //   707: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   710: aastore
    //   711: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   714: ldc 70
    //   716: ldc_w 406
    //   719: iconst_4
    //   720: anewarray 4	java/lang/Object
    //   723: dup
    //   724: iconst_0
    //   725: iload 8
    //   727: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   730: aastore
    //   731: dup
    //   732: iconst_1
    //   733: iload_2
    //   734: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   737: aastore
    //   738: dup
    //   739: iconst_2
    //   740: aload 4
    //   742: getfield 324	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   745: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   748: aastore
    //   749: dup
    //   750: iconst_3
    //   751: aload 17
    //   753: aastore
    //   754: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   757: aload 16
    //   759: getfield 245	com/tencent/mm/bk/h:jtK	Z
    //   762: ifeq +346 -> 1108
    //   765: iload 8
    //   767: sipush 1024
    //   770: iconst_2
    //   771: iload_2
    //   772: aload 17
    //   774: aload 4
    //   776: getfield 324	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   779: i2f
    //   780: aload_0
    //   781: getfield 124	com/tencent/mm/bk/g:jtG	J
    //   784: aload_0
    //   785: getfield 91	com/tencent/mm/bk/g:cwj	J
    //   788: lsub
    //   789: l2i
    //   790: aconst_null
    //   791: iconst_0
    //   792: invokestatic 410	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264Lock	(IIIILjava/lang/String;FI[BI)I
    //   795: istore_2
    //   796: ldc 70
    //   798: ldc_w 412
    //   801: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: iload_2
    //   805: ifge +22 -> 827
    //   808: ldc 70
    //   810: ldc_w 414
    //   813: iconst_1
    //   814: anewarray 4	java/lang/Object
    //   817: dup
    //   818: iconst_0
    //   819: iload_2
    //   820: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   823: aastore
    //   824: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   827: aload_0
    //   828: getfield 55	com/tencent/mm/bk/g:jtI	I
    //   831: ifle +305 -> 1136
    //   834: aload_0
    //   835: invokespecial 383	com/tencent/mm/bk/g:bhO	()Ljava/lang/String;
    //   838: aload_0
    //   839: getfield 416	com/tencent/mm/bk/g:jtE	Ljava/lang/String;
    //   842: aload_0
    //   843: getfield 55	com/tencent/mm/bk/g:jtI	I
    //   846: invokestatic 420	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideoVFS	(Ljava/lang/String;Ljava/lang/String;I)I
    //   849: pop
    //   850: ldc 70
    //   852: ldc_w 422
    //   855: iconst_1
    //   856: anewarray 4	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: lload 13
    //   863: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   866: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   869: aastore
    //   870: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   873: ldc 70
    //   875: ldc_w 424
    //   878: iconst_1
    //   879: anewarray 4	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   887: invokestatic 361	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   890: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   893: aastore
    //   894: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   897: aload_0
    //   898: getfield 200	com/tencent/mm/bk/g:bufId	I
    //   901: invokestatic 427	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   904: aload_1
    //   905: getfield 292	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   908: invokevirtual 295	android/media/MediaExtractor:release	()V
    //   911: getstatic 301	com/tencent/mm/bk/b:jtf	Lcom/tencent/mm/bk/b;
    //   914: invokevirtual 304	com/tencent/mm/bk/b:aRR	()V
    //   917: aload 16
    //   919: invokevirtual 428	com/tencent/mm/bk/h:release	()V
    //   922: ldc 192
    //   924: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   927: iconst_0
    //   928: ireturn
    //   929: aload 16
    //   931: aload 17
    //   933: getfield 227	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   936: aload 17
    //   938: getfield 224	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   941: invokevirtual 231	com/tencent/mm/bk/h:dA	(II)V
    //   944: goto -835 -> 109
    //   947: astore_1
    //   948: aload 16
    //   950: astore 4
    //   952: ldc 70
    //   954: aload_1
    //   955: ldc_w 430
    //   958: iconst_0
    //   959: anewarray 4	java/lang/Object
    //   962: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   965: aload 4
    //   967: ifnull +8 -> 975
    //   970: aload 4
    //   972: invokevirtual 428	com/tencent/mm/bk/h:release	()V
    //   975: ldc 192
    //   977: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   980: iconst_m1
    //   981: ireturn
    //   982: bipush 10
    //   984: istore 7
    //   986: goto -770 -> 216
    //   989: ldc2_w 435
    //   992: dstore 5
    //   994: goto -601 -> 393
    //   997: astore 17
    //   999: ldc 212
    //   1001: aload 17
    //   1003: ldc_w 438
    //   1006: iconst_1
    //   1007: anewarray 4	java/lang/Object
    //   1010: dup
    //   1011: iconst_0
    //   1012: aload 17
    //   1014: invokevirtual 441	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1017: aastore
    //   1018: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1021: goto -574 -> 447
    //   1024: astore 4
    //   1026: ldc 70
    //   1028: aload 4
    //   1030: ldc_w 443
    //   1033: iconst_1
    //   1034: anewarray 4	java/lang/Object
    //   1037: dup
    //   1038: iconst_0
    //   1039: aload 4
    //   1041: invokevirtual 441	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1044: aastore
    //   1045: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1048: aload_0
    //   1049: getfield 200	com/tencent/mm/bk/g:bufId	I
    //   1052: invokestatic 427	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   1055: aload_1
    //   1056: getfield 292	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   1059: invokevirtual 295	android/media/MediaExtractor:release	()V
    //   1062: getstatic 301	com/tencent/mm/bk/b:jtf	Lcom/tencent/mm/bk/b;
    //   1065: invokevirtual 304	com/tencent/mm/bk/b:aRR	()V
    //   1068: goto -151 -> 917
    //   1071: astore_1
    //   1072: goto -155 -> 917
    //   1075: astore 18
    //   1077: ldc 70
    //   1079: ldc_w 445
    //   1082: iconst_1
    //   1083: anewarray 4	java/lang/Object
    //   1086: dup
    //   1087: iconst_0
    //   1088: aload 18
    //   1090: invokevirtual 441	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1093: aastore
    //   1094: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1097: iload_2
    //   1098: istore 8
    //   1100: iload_3
    //   1101: istore_2
    //   1102: iload 9
    //   1104: istore_3
    //   1105: goto -425 -> 680
    //   1108: aload_0
    //   1109: getfield 200	com/tencent/mm/bk/g:bufId	I
    //   1112: iload 8
    //   1114: sipush 1024
    //   1117: iconst_2
    //   1118: iload_2
    //   1119: aload 17
    //   1121: aload 4
    //   1123: getfield 324	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   1126: i2f
    //   1127: aconst_null
    //   1128: iconst_0
    //   1129: invokestatic 449	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingLock	(IIIIILjava/lang/String;F[BI)I
    //   1132: istore_2
    //   1133: goto -337 -> 796
    //   1136: aload_0
    //   1137: invokespecial 383	com/tencent/mm/bk/g:bhO	()Ljava/lang/String;
    //   1140: aload_0
    //   1141: getfield 416	com/tencent/mm/bk/g:jtE	Ljava/lang/String;
    //   1144: invokestatic 455	com/tencent/mm/vfs/s:nx	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1147: pop
    //   1148: goto -298 -> 850
    //   1151: astore 4
    //   1153: aload_0
    //   1154: getfield 200	com/tencent/mm/bk/g:bufId	I
    //   1157: invokestatic 427	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   1160: aload_1
    //   1161: getfield 292	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   1164: invokevirtual 295	android/media/MediaExtractor:release	()V
    //   1167: getstatic 301	com/tencent/mm/bk/b:jtf	Lcom/tencent/mm/bk/b;
    //   1170: invokevirtual 304	com/tencent/mm/bk/b:aRR	()V
    //   1173: ldc 192
    //   1175: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1178: aload 4
    //   1180: athrow
    //   1181: astore_1
    //   1182: ldc 70
    //   1184: aload_1
    //   1185: ldc_w 457
    //   1188: iconst_1
    //   1189: anewarray 4	java/lang/Object
    //   1192: dup
    //   1193: iconst_0
    //   1194: aload_1
    //   1195: invokevirtual 441	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1198: aastore
    //   1199: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1202: aload 16
    //   1204: invokevirtual 428	com/tencent/mm/bk/h:release	()V
    //   1207: ldc 192
    //   1209: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1212: iconst_m1
    //   1213: ireturn
    //   1214: astore_1
    //   1215: aload 16
    //   1217: invokevirtual 428	com/tencent/mm/bk/h:release	()V
    //   1220: ldc 192
    //   1222: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1225: aload_1
    //   1226: athrow
    //   1227: astore_1
    //   1228: goto -306 -> 922
    //   1231: astore_1
    //   1232: goto -25 -> 1207
    //   1235: astore 4
    //   1237: goto -17 -> 1220
    //   1240: astore_1
    //   1241: goto -68 -> 1173
    //   1244: astore_1
    //   1245: goto -328 -> 917
    //   1248: astore 17
    //   1250: goto -955 -> 295
    //   1253: astore_1
    //   1254: aload 17
    //   1256: astore 4
    //   1258: goto -306 -> 952
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1261	0	this	g
    //   0	1261	1	paramc	c
    //   0	1261	2	paramInt1	int
    //   0	1261	3	paramInt2	int
    //   0	1261	4	paramString	String
    //   391	602	5	d	double
    //   120	865	7	i	int
    //   603	510	8	j	int
    //   610	493	9	k	int
    //   670	3	10	m	int
    //   228	343	11	l1	long
    //   509	353	13	l2	long
    //   338	3	15	bool	boolean
    //   26	1190	16	localh	h
    //   13	924	17	localObject	Object
    //   997	123	17	localException1	Exception
    //   1248	7	17	localException2	Exception
    //   1075	14	18	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   28	94	947	java/lang/Exception
    //   94	109	947	java/lang/Exception
    //   109	157	947	java/lang/Exception
    //   929	944	947	java/lang/Exception
    //   345	393	997	java/lang/Exception
    //   393	447	997	java/lang/Exception
    //   195	216	1024	java/lang/Exception
    //   216	270	1024	java/lang/Exception
    //   295	340	1024	java/lang/Exception
    //   447	548	1024	java/lang/Exception
    //   548	596	1024	java/lang/Exception
    //   598	612	1024	java/lang/Exception
    //   680	796	1024	java/lang/Exception
    //   796	804	1024	java/lang/Exception
    //   808	827	1024	java/lang/Exception
    //   827	850	1024	java/lang/Exception
    //   850	897	1024	java/lang/Exception
    //   999	1021	1024	java/lang/Exception
    //   1077	1097	1024	java/lang/Exception
    //   1108	1133	1024	java/lang/Exception
    //   1136	1148	1024	java/lang/Exception
    //   1048	1068	1071	java/lang/Exception
    //   615	630	1075	java/lang/Exception
    //   636	651	1075	java/lang/Exception
    //   657	672	1075	java/lang/Exception
    //   195	216	1151	finally
    //   216	270	1151	finally
    //   275	295	1151	finally
    //   295	340	1151	finally
    //   345	393	1151	finally
    //   393	447	1151	finally
    //   447	548	1151	finally
    //   548	596	1151	finally
    //   598	612	1151	finally
    //   615	630	1151	finally
    //   636	651	1151	finally
    //   657	672	1151	finally
    //   680	796	1151	finally
    //   796	804	1151	finally
    //   808	827	1151	finally
    //   827	850	1151	finally
    //   850	897	1151	finally
    //   999	1021	1151	finally
    //   1026	1048	1151	finally
    //   1077	1097	1151	finally
    //   1108	1133	1151	finally
    //   1136	1148	1151	finally
    //   164	195	1181	java/lang/Exception
    //   1173	1181	1181	java/lang/Exception
    //   164	195	1214	finally
    //   897	917	1214	finally
    //   1048	1068	1214	finally
    //   1153	1173	1214	finally
    //   1173	1181	1214	finally
    //   1182	1202	1214	finally
    //   917	922	1227	java/lang/Exception
    //   1202	1207	1231	java/lang/Exception
    //   1215	1220	1235	java/lang/Exception
    //   1153	1173	1240	java/lang/Exception
    //   897	917	1244	java/lang/Exception
    //   275	295	1248	java/lang/Exception
    //   15	28	1253	java/lang/Exception
  }
  
  private boolean a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127106);
    if (this.jtA == null)
    {
      AppMethodBeat.o(127106);
      return false;
    }
    paramc.selectTrack(this.jtA.index);
    paramc.seekTo(this.cwj * 1000L, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1);
    try
    {
      this.jtA.mediaFormat.getInteger("channel-count");
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
        if (paramc.gLF.getSampleTime() < this.jtG * 1000L) {
          if (paramc.gLF.getSampleTrackIndex() != this.jtA.index)
          {
            Log.e("MicroMsg.VideoTranferH265toH264", "track index not match! break");
          }
          else
          {
            localByteBuffer.position(0);
            MP4MuxerJNI.writeAACDataLock(paramInt2, localByteBuffer, paramInt1);
            paramc.gLF.advance();
          }
        }
      }
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(127108);
    int j = paramc.gLF.getTrackCount();
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
        this.jtC.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label119:
        if (str.startsWith("video/")) {
          this.jtB.add(new a(localMediaFormat, i));
        }
      }
    }
    Log.i("MicroMsg.VideoTranferH265toH264", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.jtC.size()), Integer.valueOf(this.jtB.size()) });
    AppMethodBeat.o(127108);
  }
  
  private int bhN()
  {
    AppMethodBeat.i(127109);
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.jtC != null)
    {
      i = j;
      if (this.jtC.size() != 0)
      {
        localIterator = this.jtC.iterator();
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
      if (this.jtB != null)
      {
        j = i;
        if (this.jtB.size() != 0)
        {
          localIterator = this.jtB.iterator();
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
  
  private String bhO()
  {
    AppMethodBeat.i(127113);
    if (this.gWS == null) {
      this.gWS = (this.jtE + "video_temp.mp4");
    }
    String str = this.gWS;
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
    paramVideoTransPara = new o(paramString1);
    new o(paramString2);
    if ((!paramVideoTransPara.exists()) || (!paramVideoTransPara.canRead()) || (paramVideoTransPara.length() == 0L))
    {
      paramString1 = new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
      AppMethodBeat.o(127107);
      throw paramString1;
    }
    AppMethodBeat.o(127107);
  }
  
  private void release()
  {
    AppMethodBeat.i(127111);
    this.iCs = false;
    if (this.jty != null) {
      this.jty.gLF.release();
    }
    AppMethodBeat.o(127111);
  }
  
  public final int AM(long paramLong)
  {
    AppMethodBeat.i(127104);
    AN(paramLong);
    this.jtz = ((a)this.jtB.get(0));
    if ((this.jtC != null) && (this.jtC.size() != 0)) {
      this.jtA = ((a)this.jtC.get(0));
    }
    c localc = this.jty;
    if (this.jtH <= 0) {}
    for (int i = 1048576; a(localc, i, this.bufId, this.jtD) == -1; i = this.jtH)
    {
      Log.e("MicroMsg.VideoTranferH265toH264", "transcodeAndMux error");
      release();
      AppMethodBeat.o(127104);
      return -1;
    }
    AppMethodBeat.o(127104);
    return 0;
  }
  
  public final void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(127103);
    Log.d("MicroMsg.VideoTranferH265toH264", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = Util.currentTicks();
    c(paramString1, paramString2, paramVideoTransPara);
    this.jtD = paramString1;
    this.jtE = paramString2;
    this.jtF = paramVideoTransPara;
    this.jty = new c();
    this.jty.setDataSource(paramString1);
    b(this.jty);
    if ((this.jtB == null) || (this.jtB.size() == 0))
    {
      paramString1 = new f("Can not find video or audio track in this video file.");
      AppMethodBeat.o(127103);
      throw paramString1;
    }
    this.jtH = bhN();
    this.jtI = QZ(paramString1);
    this.iCs = true;
    Log.e("MicroMsg.VideoTranferH265toH264", "init cost time %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(127103);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bk.g
 * JD-Core Version:    0.7.0.1
 */