package com.tencent.mm.bi;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  g.a eIY;
  g.a eIZ;
  int eIz;
  List<g.a> eJa = new ArrayList();
  List<g.a> eJb = new ArrayList();
  String eJc;
  String eJd;
  private String eJe;
  VideoTransPara eJf;
  long eJg;
  long eJh;
  int eJi = -1;
  int eJj = -1;
  boolean eJk = false;
  boolean isInited = false;
  MediaExtractor mMediaExtractor;
  
  private String SV()
  {
    if (this.eJe == null) {
      this.eJe = (this.eJd + "video_temp.mp4");
    }
    return this.eJe;
  }
  
  private boolean a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2)
  {
    if (this.eIZ == null) {
      return false;
    }
    paramMediaExtractor.selectTrack(this.eIZ.index);
    paramMediaExtractor.seekTo(this.eJg * 1000L, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1);
    for (;;)
    {
      try
      {
        this.eIZ.eIG.getInteger("channel-count");
        y.i("MicroMsg.VideoTranferH265toH264", "audio channel count");
        localByteBuffer.clear();
        paramInt1 = paramMediaExtractor.readSampleData(localByteBuffer, 0);
        if (paramInt1 <= 0)
        {
          y.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(paramInt1) });
          return false;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.VideoTranferH265toH264", "get channel count error: %s", new Object[] { Integer.valueOf(1) });
        continue;
      }
      if (paramMediaExtractor.getSampleTime() >= this.eJh * 1000L) {
        break;
      }
      if (paramMediaExtractor.getSampleTrackIndex() != this.eIZ.index)
      {
        y.e("MicroMsg.VideoTranferH265toH264", "track index not match! break");
        return false;
      }
      localByteBuffer.position(0);
      MP4MuxerJNI.writeAACData(paramInt2, localByteBuffer, paramInt1);
      paramMediaExtractor.advance();
    }
  }
  
  /* Error */
  public static int oq(String paramString)
  {
    // Byte code:
    //   0: new 175	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 176	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 180	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: bipush 17
    //   15: invokestatic 186	com/tencent/mm/compatible/util/d:gF	(I)Z
    //   18: ifeq +101 -> 119
    //   21: aload_2
    //   22: bipush 24
    //   24: invokevirtual 190	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   27: astore_0
    //   28: ldc 112
    //   30: new 57	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 192
    //   36: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 197	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_2
    //   50: bipush 19
    //   52: invokevirtual 190	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_2
    //   57: bipush 18
    //   59: invokevirtual 190	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   62: astore 4
    //   64: ldc 112
    //   66: new 57	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 199
    //   72: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_3
    //   76: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 197	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: ldc 112
    //   87: new 57	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 201
    //   93: invokespecial 194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 4
    //   98: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 197	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: iconst_0
    //   109: invokestatic 207	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   112: istore_1
    //   113: aload_2
    //   114: invokevirtual 210	android/media/MediaMetadataRetriever:release	()V
    //   117: iload_1
    //   118: ireturn
    //   119: new 57	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   126: aload_0
    //   127: invokestatic 215	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4Rotate	(Ljava/lang/String;)I
    //   130: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_0
    //   137: goto -109 -> 28
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 210	android/media/MediaMetadataRetriever:release	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: goto -11 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramString	String
    //   112	6	1	i	int
    //   7	141	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   55	21	3	str1	String
    //   62	35	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	8	140	finally
    //   8	28	153	finally
    //   28	113	153	finally
    //   119	137	153	finally
  }
  
  final int SU()
  {
    int j = -1;
    int i = j;
    Iterator localIterator;
    g.a locala;
    if (this.eJb != null)
    {
      i = j;
      if (this.eJb.size() != 0)
      {
        localIterator = this.eJb.iterator();
        i = -1;
        if (localIterator.hasNext())
        {
          locala = (g.a)localIterator.next();
          if (!locala.eIG.containsKey("max-input-size")) {
            break label179;
          }
          i = Math.max(locala.eIG.getInteger("max-input-size"), i);
        }
      }
    }
    label176:
    label179:
    for (;;)
    {
      break;
      j = i;
      if (this.eJa != null)
      {
        j = i;
        if (this.eJa.size() != 0)
        {
          localIterator = this.eJa.iterator();
          if (localIterator.hasNext())
          {
            locala = (g.a)localIterator.next();
            if (!locala.eIG.containsKey("max-input-size")) {
              break label176;
            }
            i = Math.max(locala.eIG.getInteger("max-input-size"), i);
          }
        }
      }
      for (;;)
      {
        break;
        j = i;
        return j;
      }
    }
  }
  
  /* Error */
  final int a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 112
    //   2: ldc 252
    //   4: invokestatic 120	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore 17
    //   10: new 254	com/tencent/mm/bi/h
    //   13: dup
    //   14: aload_0
    //   15: getfield 256	com/tencent/mm/bi/g:eIz	I
    //   18: invokespecial 258	com/tencent/mm/bi/h:<init>	(I)V
    //   21: astore 16
    //   23: aload 16
    //   25: aload_0
    //   26: getfield 86	com/tencent/mm/bi/g:eJg	J
    //   29: putfield 261	com/tencent/mm/bi/h:aRW	J
    //   32: aload 16
    //   34: aload_0
    //   35: getfield 150	com/tencent/mm/bi/g:eJh	J
    //   38: putfield 264	com/tencent/mm/bi/h:eIR	J
    //   41: aload_0
    //   42: getfield 266	com/tencent/mm/bi/g:eJf	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   45: astore 17
    //   47: ldc_w 268
    //   50: ldc_w 270
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload 17
    //   61: aastore
    //   62: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload 16
    //   67: aload 17
    //   69: putfield 273	com/tencent/mm/bi/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   72: aload_0
    //   73: getfield 46	com/tencent/mm/bi/g:eJj	I
    //   76: bipush 90
    //   78: if_icmpeq +13 -> 91
    //   81: aload_0
    //   82: getfield 46	com/tencent/mm/bi/g:eJj	I
    //   85: sipush 270
    //   88: if_icmpne +823 -> 911
    //   91: aload 16
    //   93: aload 17
    //   95: getfield 278	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   98: aload 17
    //   100: getfield 281	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   103: invokevirtual 285	com/tencent/mm/bi/h:by	(II)V
    //   106: aload 16
    //   108: aload 4
    //   110: putfield 288	com/tencent/mm/bi/h:eJC	Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 46	com/tencent/mm/bi/g:eJj	I
    //   117: istore 7
    //   119: ldc_w 268
    //   122: ldc_w 290
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iload 7
    //   133: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: aastore
    //   137: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 16
    //   142: iload 7
    //   144: putfield 293	com/tencent/mm/bi/h:rotate	I
    //   147: ldc 112
    //   149: ldc_w 295
    //   152: invokestatic 120	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: ldc 112
    //   157: ldc_w 297
    //   160: invokestatic 120	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_1
    //   164: aload_0
    //   165: getfield 299	com/tencent/mm/bi/g:eIY	Lcom/tencent/mm/bi/g$a;
    //   168: getfield 78	com/tencent/mm/bi/g$a:index	I
    //   171: invokevirtual 84	android/media/MediaExtractor:selectTrack	(I)V
    //   174: aload_1
    //   175: aload_0
    //   176: getfield 86	com/tencent/mm/bi/g:eJg	J
    //   179: ldc2_w 87
    //   182: lmul
    //   183: iconst_0
    //   184: invokevirtual 92	android/media/MediaExtractor:seekTo	(JI)V
    //   187: aload_0
    //   188: getfield 266	com/tencent/mm/bi/g:eJf	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   191: astore 4
    //   193: aload 4
    //   195: getfield 302	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   198: ifle +761 -> 959
    //   201: aload 4
    //   203: getfield 302	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   206: istore 7
    //   208: aload_0
    //   209: iload 7
    //   211: invokestatic 306	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBuf	(I)I
    //   214: putfield 256	com/tencent/mm/bi/g:eIz	I
    //   217: invokestatic 309	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   220: lstore 11
    //   222: aload_0
    //   223: getfield 299	com/tencent/mm/bi/g:eIY	Lcom/tencent/mm/bi/g$a;
    //   226: getfield 78	com/tencent/mm/bi/g$a:index	I
    //   229: istore 7
    //   231: aload 16
    //   233: aload_1
    //   234: putfield 312	com/tencent/mm/bi/h:eJD	Landroid/media/MediaExtractor;
    //   237: aload 16
    //   239: iload 7
    //   241: putfield 315	com/tencent/mm/bi/h:eIU	I
    //   244: aload 16
    //   246: aload_0
    //   247: getfield 299	com/tencent/mm/bi/g:eIY	Lcom/tencent/mm/bi/g$a;
    //   250: getfield 102	com/tencent/mm/bi/g$a:eIG	Landroid/media/MediaFormat;
    //   253: aload_0
    //   254: getfield 50	com/tencent/mm/bi/g:eJk	Z
    //   257: invokevirtual 318	com/tencent/mm/bi/h:a	(Landroid/media/MediaFormat;Z)I
    //   260: istore 7
    //   262: iload 7
    //   264: ifge +20 -> 284
    //   267: aload_0
    //   268: getfield 256	com/tencent/mm/bi/g:eIz	I
    //   271: invokestatic 321	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   274: aload_1
    //   275: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   278: getstatic 328	com/tencent/mm/bi/b:eIx	Lcom/tencent/mm/bi/b;
    //   281: invokevirtual 331	com/tencent/mm/bi/b:ET	()V
    //   284: aload 16
    //   286: getfield 288	com/tencent/mm/bi/h:eJC	Ljava/lang/String;
    //   289: invokestatic 334	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   292: ifne +146 -> 438
    //   295: aload 16
    //   297: getfield 288	com/tencent/mm/bi/h:eJC	Ljava/lang/String;
    //   300: invokestatic 338	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4Info	(Ljava/lang/String;)Ljava/lang/String;
    //   303: astore 17
    //   305: ldc_w 268
    //   308: ldc_w 340
    //   311: iconst_1
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload 17
    //   319: aastore
    //   320: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   323: aload 17
    //   325: invokestatic 334	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   328: istore 15
    //   330: iload 15
    //   332: ifne +106 -> 438
    //   335: new 342	org/json/JSONObject
    //   338: dup
    //   339: aload 17
    //   341: invokespecial 343	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   344: ldc_w 345
    //   347: invokevirtual 349	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   350: d2i
    //   351: istore 7
    //   353: aload 16
    //   355: getfield 273	com/tencent/mm/bi/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   358: ifnull +608 -> 966
    //   361: aload 16
    //   363: getfield 273	com/tencent/mm/bi/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   366: getfield 352	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   369: ifle +597 -> 966
    //   372: aload 16
    //   374: getfield 273	com/tencent/mm/bi/h:eJA	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   377: getfield 352	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   380: i2d
    //   381: dstore 5
    //   383: aload 16
    //   385: iload 7
    //   387: i2d
    //   388: dload 5
    //   390: ddiv
    //   391: invokestatic 356	java/lang/Math:ceil	(D)D
    //   394: d2i
    //   395: putfield 359	com/tencent/mm/bi/h:eIV	I
    //   398: ldc_w 268
    //   401: ldc_w 361
    //   404: iconst_3
    //   405: anewarray 4	java/lang/Object
    //   408: dup
    //   409: iconst_0
    //   410: aload 16
    //   412: getfield 359	com/tencent/mm/bi/h:eIV	I
    //   415: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: aastore
    //   419: dup
    //   420: iconst_1
    //   421: iload 7
    //   423: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: aastore
    //   427: dup
    //   428: iconst_2
    //   429: dload 5
    //   431: invokestatic 366	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   434: aastore
    //   435: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: aload 16
    //   440: getfield 370	com/tencent/mm/bi/h:eJE	Lcom/tencent/mm/bi/a;
    //   443: aload 16
    //   445: getfield 359	com/tencent/mm/bi/h:eIV	I
    //   448: invokeinterface 375 2 0
    //   453: aload 16
    //   455: getfield 370	com/tencent/mm/bi/h:eJE	Lcom/tencent/mm/bi/a;
    //   458: new 377	com/tencent/mm/bi/h$2
    //   461: dup
    //   462: aload 16
    //   464: invokespecial 380	com/tencent/mm/bi/h$2:<init>	(Lcom/tencent/mm/bi/h;)V
    //   467: invokeinterface 384 2 0
    //   472: lload 11
    //   474: invokestatic 388	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   477: lstore 11
    //   479: aload_1
    //   480: aload_0
    //   481: getfield 299	com/tencent/mm/bi/g:eIY	Lcom/tencent/mm/bi/g$a;
    //   484: getfield 78	com/tencent/mm/bi/g$a:index	I
    //   487: invokevirtual 391	android/media/MediaExtractor:unselectTrack	(I)V
    //   490: aload_0
    //   491: getfield 75	com/tencent/mm/bi/g:eIZ	Lcom/tencent/mm/bi/g$a;
    //   494: ifnull +46 -> 540
    //   497: invokestatic 309	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   500: lstore 13
    //   502: aload_0
    //   503: aload_1
    //   504: iload_2
    //   505: iload_3
    //   506: invokespecial 393	com/tencent/mm/bi/g:a	(Landroid/media/MediaExtractor;II)Z
    //   509: pop
    //   510: ldc 112
    //   512: ldc_w 395
    //   515: iconst_2
    //   516: anewarray 4	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: lload 13
    //   523: invokestatic 388	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   526: invokestatic 400	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   529: aastore
    //   530: dup
    //   531: iconst_1
    //   532: iconst_0
    //   533: invokestatic 405	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   536: aastore
    //   537: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   540: invokestatic 309	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   543: lstore 13
    //   545: aload_0
    //   546: invokespecial 407	com/tencent/mm/bi/g:SV	()Ljava/lang/String;
    //   549: astore 17
    //   551: ldc 112
    //   553: ldc_w 409
    //   556: iconst_1
    //   557: anewarray 4	java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: lload 11
    //   564: invokestatic 400	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   567: aastore
    //   568: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: ldc 112
    //   573: ldc_w 411
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload 17
    //   584: aastore
    //   585: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: iconst_1
    //   589: istore_3
    //   590: aload 4
    //   592: getfield 414	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   595: istore 8
    //   597: aload 4
    //   599: getfield 417	com/tencent/mm/modelcontrol/VideoTransPara:ejM	I
    //   602: istore 9
    //   604: iload 8
    //   606: istore_2
    //   607: aload_0
    //   608: getfield 75	com/tencent/mm/bi/g:eIZ	Lcom/tencent/mm/bi/g$a;
    //   611: getfield 102	com/tencent/mm/bi/g$a:eIG	Landroid/media/MediaFormat;
    //   614: ldc 104
    //   616: invokevirtual 110	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   619: istore 7
    //   621: iload 8
    //   623: istore_2
    //   624: iload 7
    //   626: istore_3
    //   627: aload_0
    //   628: getfield 75	com/tencent/mm/bi/g:eIZ	Lcom/tencent/mm/bi/g$a;
    //   631: getfield 102	com/tencent/mm/bi/g$a:eIG	Landroid/media/MediaFormat;
    //   634: ldc_w 419
    //   637: invokevirtual 110	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   640: istore 8
    //   642: iload 8
    //   644: istore_2
    //   645: iload 7
    //   647: istore_3
    //   648: aload_0
    //   649: getfield 75	com/tencent/mm/bi/g:eIZ	Lcom/tencent/mm/bi/g$a;
    //   652: getfield 102	com/tencent/mm/bi/g$a:eIG	Landroid/media/MediaFormat;
    //   655: ldc_w 421
    //   658: invokevirtual 110	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   661: istore 10
    //   663: iload 10
    //   665: istore_2
    //   666: iload_2
    //   667: istore_3
    //   668: iload 7
    //   670: istore_2
    //   671: ldc 112
    //   673: ldc_w 423
    //   676: iconst_3
    //   677: anewarray 4	java/lang/Object
    //   680: dup
    //   681: iconst_0
    //   682: iload_2
    //   683: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   686: aastore
    //   687: dup
    //   688: iconst_1
    //   689: iload 8
    //   691: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   694: aastore
    //   695: dup
    //   696: iconst_2
    //   697: iload_3
    //   698: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   701: aastore
    //   702: invokestatic 144	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   705: ldc 112
    //   707: ldc_w 425
    //   710: iconst_4
    //   711: anewarray 4	java/lang/Object
    //   714: dup
    //   715: iconst_0
    //   716: iload 8
    //   718: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   721: aastore
    //   722: dup
    //   723: iconst_1
    //   724: iload_2
    //   725: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   728: aastore
    //   729: dup
    //   730: iconst_2
    //   731: aload 4
    //   733: getfield 352	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   736: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   739: aastore
    //   740: dup
    //   741: iconst_3
    //   742: aload 17
    //   744: aastore
    //   745: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   748: aload 16
    //   750: getfield 428	com/tencent/mm/bi/h:eJu	Z
    //   753: ifeq +328 -> 1081
    //   756: iload 8
    //   758: sipush 1024
    //   761: iconst_2
    //   762: iload_2
    //   763: aload 17
    //   765: aload 4
    //   767: getfield 352	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   770: i2f
    //   771: aload_0
    //   772: getfield 150	com/tencent/mm/bi/g:eJh	J
    //   775: aload_0
    //   776: getfield 86	com/tencent/mm/bi/g:eJg	J
    //   779: lsub
    //   780: l2i
    //   781: aconst_null
    //   782: iconst_0
    //   783: invokestatic 432	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264	(IIIILjava/lang/String;FI[BI)I
    //   786: istore_2
    //   787: ldc 112
    //   789: ldc_w 434
    //   792: invokestatic 158	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: iload_2
    //   796: ifge +22 -> 818
    //   799: ldc 112
    //   801: ldc_w 436
    //   804: iconst_1
    //   805: anewarray 4	java/lang/Object
    //   808: dup
    //   809: iconst_0
    //   810: iload_2
    //   811: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   814: aastore
    //   815: invokestatic 144	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   818: aload_0
    //   819: getfield 46	com/tencent/mm/bi/g:eJj	I
    //   822: ifle +287 -> 1109
    //   825: aload_0
    //   826: invokespecial 407	com/tencent/mm/bi/g:SV	()Ljava/lang/String;
    //   829: aload_0
    //   830: getfield 60	com/tencent/mm/bi/g:eJd	Ljava/lang/String;
    //   833: aload_0
    //   834: getfield 46	com/tencent/mm/bi/g:eJj	I
    //   837: invokestatic 440	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideo	(Ljava/lang/String;Ljava/lang/String;I)V
    //   840: ldc 112
    //   842: ldc_w 442
    //   845: iconst_1
    //   846: anewarray 4	java/lang/Object
    //   849: dup
    //   850: iconst_0
    //   851: lload 13
    //   853: invokestatic 388	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   856: invokestatic 400	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   859: aastore
    //   860: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   863: ldc 112
    //   865: ldc_w 444
    //   868: iconst_1
    //   869: anewarray 4	java/lang/Object
    //   872: dup
    //   873: iconst_0
    //   874: invokestatic 309	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   877: invokestatic 388	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   880: invokestatic 400	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   883: aastore
    //   884: invokestatic 139	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   887: aload_0
    //   888: getfield 256	com/tencent/mm/bi/g:eIz	I
    //   891: invokestatic 321	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   894: aload_1
    //   895: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   898: getstatic 328	com/tencent/mm/bi/b:eIx	Lcom/tencent/mm/bi/b;
    //   901: invokevirtual 331	com/tencent/mm/bi/b:ET	()V
    //   904: aload 16
    //   906: invokevirtual 445	com/tencent/mm/bi/h:release	()V
    //   909: iconst_0
    //   910: ireturn
    //   911: aload 16
    //   913: aload 17
    //   915: getfield 281	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   918: aload 17
    //   920: getfield 278	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   923: invokevirtual 285	com/tencent/mm/bi/h:by	(II)V
    //   926: goto -820 -> 106
    //   929: astore_1
    //   930: aload 16
    //   932: astore 4
    //   934: ldc 112
    //   936: aload_1
    //   937: ldc_w 447
    //   940: iconst_0
    //   941: anewarray 4	java/lang/Object
    //   944: invokestatic 451	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: aload 4
    //   949: ifnull +8 -> 957
    //   952: aload 4
    //   954: invokevirtual 445	com/tencent/mm/bi/h:release	()V
    //   957: iconst_m1
    //   958: ireturn
    //   959: bipush 10
    //   961: istore 7
    //   963: goto -755 -> 208
    //   966: ldc2_w 452
    //   969: dstore 5
    //   971: goto -588 -> 383
    //   974: astore 17
    //   976: ldc_w 268
    //   979: aload 17
    //   981: ldc_w 455
    //   984: iconst_1
    //   985: anewarray 4	java/lang/Object
    //   988: dup
    //   989: iconst_0
    //   990: aload 17
    //   992: invokevirtual 458	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   995: aastore
    //   996: invokestatic 451	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   999: goto -561 -> 438
    //   1002: astore 4
    //   1004: ldc 112
    //   1006: ldc_w 460
    //   1009: iconst_1
    //   1010: anewarray 4	java/lang/Object
    //   1013: dup
    //   1014: iconst_0
    //   1015: aload 4
    //   1017: invokevirtual 458	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1020: aastore
    //   1021: invokestatic 463	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1024: aload_0
    //   1025: getfield 256	com/tencent/mm/bi/g:eIz	I
    //   1028: invokestatic 321	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   1031: aload_1
    //   1032: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   1035: getstatic 328	com/tencent/mm/bi/b:eIx	Lcom/tencent/mm/bi/b;
    //   1038: invokevirtual 331	com/tencent/mm/bi/b:ET	()V
    //   1041: goto -137 -> 904
    //   1044: astore_1
    //   1045: goto -141 -> 904
    //   1048: astore 18
    //   1050: ldc 112
    //   1052: ldc_w 465
    //   1055: iconst_1
    //   1056: anewarray 4	java/lang/Object
    //   1059: dup
    //   1060: iconst_0
    //   1061: aload 18
    //   1063: invokevirtual 458	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1066: aastore
    //   1067: invokestatic 144	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1070: iload_2
    //   1071: istore 8
    //   1073: iload_3
    //   1074: istore_2
    //   1075: iload 9
    //   1077: istore_3
    //   1078: goto -407 -> 671
    //   1081: aload_0
    //   1082: getfield 256	com/tencent/mm/bi/g:eIz	I
    //   1085: iload 8
    //   1087: sipush 1024
    //   1090: iconst_2
    //   1091: iload_2
    //   1092: aload 17
    //   1094: aload 4
    //   1096: getfield 352	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   1099: i2f
    //   1100: aconst_null
    //   1101: iconst_0
    //   1102: invokestatic 469	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxing	(IIIIILjava/lang/String;F[BI)I
    //   1105: istore_2
    //   1106: goto -319 -> 787
    //   1109: aload_0
    //   1110: invokespecial 407	com/tencent/mm/bi/g:SV	()Ljava/lang/String;
    //   1113: aload_0
    //   1114: getfield 60	com/tencent/mm/bi/g:eJd	Ljava/lang/String;
    //   1117: invokestatic 475	com/tencent/mm/modelsfs/FileOp:aA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1120: pop
    //   1121: goto -281 -> 840
    //   1124: astore 4
    //   1126: aload_0
    //   1127: getfield 256	com/tencent/mm/bi/g:eIz	I
    //   1130: invokestatic 321	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   1133: aload_1
    //   1134: invokevirtual 322	android/media/MediaExtractor:release	()V
    //   1137: getstatic 328	com/tencent/mm/bi/b:eIx	Lcom/tencent/mm/bi/b;
    //   1140: invokevirtual 331	com/tencent/mm/bi/b:ET	()V
    //   1143: aload 4
    //   1145: athrow
    //   1146: astore_1
    //   1147: ldc 112
    //   1149: aload_1
    //   1150: ldc_w 477
    //   1153: iconst_1
    //   1154: anewarray 4	java/lang/Object
    //   1157: dup
    //   1158: iconst_0
    //   1159: aload_1
    //   1160: invokevirtual 458	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1163: aastore
    //   1164: invokestatic 451	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1167: aload 16
    //   1169: invokevirtual 445	com/tencent/mm/bi/h:release	()V
    //   1172: iconst_m1
    //   1173: ireturn
    //   1174: astore_1
    //   1175: aload 16
    //   1177: invokevirtual 445	com/tencent/mm/bi/h:release	()V
    //   1180: aload_1
    //   1181: athrow
    //   1182: astore_1
    //   1183: goto -274 -> 909
    //   1186: astore_1
    //   1187: goto -15 -> 1172
    //   1190: astore 4
    //   1192: goto -12 -> 1180
    //   1195: astore_1
    //   1196: goto -53 -> 1143
    //   1199: astore_1
    //   1200: goto -296 -> 904
    //   1203: astore 17
    //   1205: goto -921 -> 284
    //   1208: astore_1
    //   1209: aload 17
    //   1211: astore 4
    //   1213: goto -279 -> 934
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1216	0	this	g
    //   0	1216	1	paramMediaExtractor	MediaExtractor
    //   0	1216	2	paramInt1	int
    //   0	1216	3	paramInt2	int
    //   0	1216	4	paramString	String
    //   381	589	5	d	double
    //   117	845	7	i	int
    //   595	491	8	j	int
    //   602	474	9	k	int
    //   661	3	10	m	int
    //   220	343	11	l1	long
    //   500	352	13	l2	long
    //   328	3	15	bool	boolean
    //   21	1155	16	localh	h
    //   8	911	17	localObject	Object
    //   974	119	17	localException1	Exception
    //   1203	7	17	localException2	Exception
    //   1048	14	18	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   23	91	929	java/lang/Exception
    //   91	106	929	java/lang/Exception
    //   106	147	929	java/lang/Exception
    //   911	926	929	java/lang/Exception
    //   335	383	974	java/lang/Exception
    //   383	438	974	java/lang/Exception
    //   187	208	1002	java/lang/Exception
    //   208	262	1002	java/lang/Exception
    //   284	330	1002	java/lang/Exception
    //   438	540	1002	java/lang/Exception
    //   540	588	1002	java/lang/Exception
    //   590	604	1002	java/lang/Exception
    //   671	787	1002	java/lang/Exception
    //   787	795	1002	java/lang/Exception
    //   799	818	1002	java/lang/Exception
    //   818	840	1002	java/lang/Exception
    //   840	887	1002	java/lang/Exception
    //   976	999	1002	java/lang/Exception
    //   1050	1070	1002	java/lang/Exception
    //   1081	1106	1002	java/lang/Exception
    //   1109	1121	1002	java/lang/Exception
    //   1024	1041	1044	java/lang/Exception
    //   607	621	1048	java/lang/Exception
    //   627	642	1048	java/lang/Exception
    //   648	663	1048	java/lang/Exception
    //   187	208	1124	finally
    //   208	262	1124	finally
    //   267	284	1124	finally
    //   284	330	1124	finally
    //   335	383	1124	finally
    //   383	438	1124	finally
    //   438	540	1124	finally
    //   540	588	1124	finally
    //   590	604	1124	finally
    //   607	621	1124	finally
    //   627	642	1124	finally
    //   648	663	1124	finally
    //   671	787	1124	finally
    //   787	795	1124	finally
    //   799	818	1124	finally
    //   818	840	1124	finally
    //   840	887	1124	finally
    //   976	999	1124	finally
    //   1004	1024	1124	finally
    //   1050	1070	1124	finally
    //   1081	1106	1124	finally
    //   1109	1121	1124	finally
    //   155	187	1146	java/lang/Exception
    //   1143	1146	1146	java/lang/Exception
    //   155	187	1174	finally
    //   887	904	1174	finally
    //   1024	1041	1174	finally
    //   1126	1143	1174	finally
    //   1143	1146	1174	finally
    //   1147	1167	1174	finally
    //   904	909	1182	java/lang/Exception
    //   1167	1172	1186	java/lang/Exception
    //   1175	1180	1190	java/lang/Exception
    //   1126	1143	1195	java/lang/Exception
    //   887	904	1199	java/lang/Exception
    //   267	284	1203	java/lang/Exception
    //   10	23	1208	java/lang/Exception
  }
  
  final void a(MediaExtractor paramMediaExtractor)
  {
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!bk.bl(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        y.i("MicroMsg.VideoTranferH265toH264", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label110;
        }
        this.eJb.add(new g.a(this, localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label110:
        if (str.startsWith("video/")) {
          this.eJa.add(new g.a(this, localMediaFormat, i));
        }
      }
    }
    y.i("MicroMsg.VideoTranferH265toH264", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.eJb.size()), Integer.valueOf(this.eJa.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bi.g
 * JD-Core Version:    0.7.0.1
 */