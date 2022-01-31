package com.tencent.mm.bj;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class g
{
  private int eRm;
  private String ewk;
  private a fYE;
  private a fYF;
  private List<a> fYG;
  private List<a> fYH;
  private String fYI;
  private String fYJ;
  private VideoTransPara fYK;
  private long fYL;
  private long fYM;
  private int fYN;
  boolean fYO;
  boolean fYP;
  private boolean isInited;
  private MediaExtractor mMediaExtractor;
  private int mRotationDegree;
  
  public g()
  {
    AppMethodBeat.i(50932);
    this.fYG = new ArrayList();
    this.fYH = new ArrayList();
    this.fYN = -1;
    this.mRotationDegree = -1;
    this.isInited = false;
    this.fYO = false;
    this.fYP = false;
    AppMethodBeat.o(50932);
  }
  
  /* Error */
  private int a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 71
    //   7: ldc 73
    //   9: invokestatic 78	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aconst_null
    //   13: astore 17
    //   15: new 80	com/tencent/mm/bj/h
    //   18: dup
    //   19: aload_0
    //   20: getfield 82	com/tencent/mm/bj/g:eRm	I
    //   23: invokespecial 84	com/tencent/mm/bj/h:<init>	(I)V
    //   26: astore 16
    //   28: aload 16
    //   30: aload_0
    //   31: getfield 86	com/tencent/mm/bj/g:fYL	J
    //   34: putfield 89	com/tencent/mm/bj/h:aZw	J
    //   37: aload 16
    //   39: aload_0
    //   40: getfield 91	com/tencent/mm/bj/g:fYM	J
    //   43: putfield 94	com/tencent/mm/bj/h:eRN	J
    //   46: aload_0
    //   47: getfield 96	com/tencent/mm/bj/g:fYK	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   50: astore 17
    //   52: ldc 98
    //   54: ldc 100
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 17
    //   64: aastore
    //   65: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload 16
    //   70: aload 17
    //   72: putfield 106	com/tencent/mm/bj/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   75: aload_0
    //   76: getfield 55	com/tencent/mm/bj/g:mRotationDegree	I
    //   79: bipush 90
    //   81: if_icmpeq +13 -> 94
    //   84: aload_0
    //   85: getfield 55	com/tencent/mm/bj/g:mRotationDegree	I
    //   88: sipush 270
    //   91: if_icmpne +829 -> 920
    //   94: aload 16
    //   96: aload 17
    //   98: getfield 111	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   101: aload 17
    //   103: getfield 114	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   106: invokevirtual 118	com/tencent/mm/bj/h:cI	(II)V
    //   109: aload 16
    //   111: aload 4
    //   113: putfield 121	com/tencent/mm/bj/h:fZg	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 55	com/tencent/mm/bj/g:mRotationDegree	I
    //   120: istore 7
    //   122: ldc 98
    //   124: ldc 123
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: iload 7
    //   134: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 16
    //   143: iload 7
    //   145: putfield 132	com/tencent/mm/bj/h:rotate	I
    //   148: aload 16
    //   150: aload_0
    //   151: getfield 61	com/tencent/mm/bj/g:fYP	Z
    //   154: putfield 133	com/tencent/mm/bj/h:fYP	Z
    //   157: ldc 71
    //   159: ldc 135
    //   161: invokestatic 78	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: ldc 71
    //   166: ldc 137
    //   168: invokestatic 78	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: aload_0
    //   173: getfield 139	com/tencent/mm/bj/g:fYE	Lcom/tencent/mm/bj/g$a;
    //   176: getfield 142	com/tencent/mm/bj/g$a:index	I
    //   179: invokevirtual 147	android/media/MediaExtractor:selectTrack	(I)V
    //   182: aload_1
    //   183: aload_0
    //   184: getfield 86	com/tencent/mm/bj/g:fYL	J
    //   187: ldc2_w 148
    //   190: lmul
    //   191: iconst_0
    //   192: invokevirtual 153	android/media/MediaExtractor:seekTo	(JI)V
    //   195: aload_0
    //   196: getfield 96	com/tencent/mm/bj/g:fYK	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   199: astore 4
    //   201: aload 4
    //   203: getfield 156	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   206: ifle +767 -> 973
    //   209: aload 4
    //   211: getfield 156	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   214: istore 7
    //   216: aload_0
    //   217: iload 7
    //   219: invokestatic 162	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBufLock	(I)I
    //   222: putfield 82	com/tencent/mm/bj/g:eRm	I
    //   225: invokestatic 168	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   228: lstore 11
    //   230: aload_0
    //   231: getfield 139	com/tencent/mm/bj/g:fYE	Lcom/tencent/mm/bj/g$a;
    //   234: getfield 142	com/tencent/mm/bj/g$a:index	I
    //   237: istore 7
    //   239: aload 16
    //   241: aload_1
    //   242: putfield 171	com/tencent/mm/bj/h:mediaExtractor	Landroid/media/MediaExtractor;
    //   245: aload 16
    //   247: iload 7
    //   249: putfield 174	com/tencent/mm/bj/h:eUR	I
    //   252: aload 16
    //   254: aload_0
    //   255: getfield 139	com/tencent/mm/bj/g:fYE	Lcom/tencent/mm/bj/g$a;
    //   258: getfield 178	com/tencent/mm/bj/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   261: aload_0
    //   262: getfield 59	com/tencent/mm/bj/g:fYO	Z
    //   265: invokevirtual 181	com/tencent/mm/bj/h:a	(Landroid/media/MediaFormat;Z)I
    //   268: istore 7
    //   270: iload 7
    //   272: ifge +20 -> 292
    //   275: aload_0
    //   276: getfield 82	com/tencent/mm/bj/g:eRm	I
    //   279: invokestatic 184	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   282: aload_1
    //   283: invokevirtual 187	android/media/MediaExtractor:release	()V
    //   286: getstatic 193	com/tencent/mm/bj/b:fYm	Lcom/tencent/mm/bj/b;
    //   289: invokevirtual 196	com/tencent/mm/bj/b:XJ	()V
    //   292: aload 16
    //   294: getfield 121	com/tencent/mm/bj/h:fZg	Ljava/lang/String;
    //   297: invokestatic 200	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   300: ifne +141 -> 441
    //   303: aload 16
    //   305: getfield 121	com/tencent/mm/bj/h:fZg	Ljava/lang/String;
    //   308: invokestatic 206	com/tencent/mm/plugin/sight/base/SightVideoJNI:getSimpleMp4Info	(Ljava/lang/String;)Ljava/lang/String;
    //   311: astore 17
    //   313: ldc 98
    //   315: ldc 208
    //   317: iconst_1
    //   318: anewarray 4	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: aload 17
    //   325: aastore
    //   326: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: aload 17
    //   331: invokestatic 200	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   334: istore 15
    //   336: iload 15
    //   338: ifne +103 -> 441
    //   341: new 210	org/json/JSONObject
    //   344: dup
    //   345: aload 17
    //   347: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   350: ldc 215
    //   352: invokevirtual 219	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   355: d2i
    //   356: istore 7
    //   358: aload 16
    //   360: getfield 106	com/tencent/mm/bj/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   363: ifnull +617 -> 980
    //   366: aload 16
    //   368: getfield 106	com/tencent/mm/bj/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   371: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   374: ifle +606 -> 980
    //   377: aload 16
    //   379: getfield 106	com/tencent/mm/bj/h:fZe	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   382: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   385: i2d
    //   386: dstore 5
    //   388: aload 16
    //   390: iload 7
    //   392: i2d
    //   393: dload 5
    //   395: ddiv
    //   396: invokestatic 228	java/lang/Math:ceil	(D)D
    //   399: d2i
    //   400: putfield 231	com/tencent/mm/bj/h:eRW	I
    //   403: ldc 98
    //   405: ldc 233
    //   407: iconst_3
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: aload 16
    //   415: getfield 231	com/tencent/mm/bj/h:eRW	I
    //   418: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: dup
    //   423: iconst_1
    //   424: iload 7
    //   426: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   429: aastore
    //   430: dup
    //   431: iconst_2
    //   432: dload 5
    //   434: invokestatic 238	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   437: aastore
    //   438: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: aload 16
    //   443: getfield 242	com/tencent/mm/bj/h:fZh	Lcom/tencent/mm/bj/a;
    //   446: aload 16
    //   448: getfield 231	com/tencent/mm/bj/h:eRW	I
    //   451: invokeinterface 247 2 0
    //   456: aload 16
    //   458: getfield 242	com/tencent/mm/bj/h:fZh	Lcom/tencent/mm/bj/a;
    //   461: new 249	com/tencent/mm/bj/h$2
    //   464: dup
    //   465: aload 16
    //   467: invokespecial 252	com/tencent/mm/bj/h$2:<init>	(Lcom/tencent/mm/bj/h;)V
    //   470: invokeinterface 256 2 0
    //   475: lload 11
    //   477: invokestatic 260	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   480: lstore 11
    //   482: aload_1
    //   483: aload_0
    //   484: getfield 139	com/tencent/mm/bj/g:fYE	Lcom/tencent/mm/bj/g$a;
    //   487: getfield 142	com/tencent/mm/bj/g$a:index	I
    //   490: invokevirtual 263	android/media/MediaExtractor:unselectTrack	(I)V
    //   493: aload_0
    //   494: getfield 265	com/tencent/mm/bj/g:fYF	Lcom/tencent/mm/bj/g$a;
    //   497: ifnull +45 -> 542
    //   500: invokestatic 168	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   503: lstore 13
    //   505: aload_0
    //   506: aload_1
    //   507: iload_2
    //   508: iload_3
    //   509: invokespecial 268	com/tencent/mm/bj/g:a	(Landroid/media/MediaExtractor;II)Z
    //   512: pop
    //   513: ldc 71
    //   515: ldc_w 270
    //   518: iconst_2
    //   519: anewarray 4	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: lload 13
    //   526: invokestatic 260	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   529: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   532: aastore
    //   533: dup
    //   534: iconst_1
    //   535: getstatic 281	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   538: aastore
    //   539: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   542: invokestatic 168	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   545: lstore 13
    //   547: aload_0
    //   548: invokespecial 285	com/tencent/mm/bj/g:amg	()Ljava/lang/String;
    //   551: astore 17
    //   553: ldc 71
    //   555: ldc_w 287
    //   558: iconst_1
    //   559: anewarray 4	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: lload 11
    //   566: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   569: aastore
    //   570: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   573: ldc 71
    //   575: ldc_w 289
    //   578: iconst_1
    //   579: anewarray 4	java/lang/Object
    //   582: dup
    //   583: iconst_0
    //   584: aload 17
    //   586: aastore
    //   587: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: iconst_1
    //   591: istore_3
    //   592: aload 4
    //   594: getfield 292	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   597: istore 8
    //   599: aload 4
    //   601: getfield 295	com/tencent/mm/modelcontrol/VideoTransPara:fzT	I
    //   604: istore 9
    //   606: iload 8
    //   608: istore_2
    //   609: aload_0
    //   610: getfield 265	com/tencent/mm/bj/g:fYF	Lcom/tencent/mm/bj/g$a;
    //   613: getfield 178	com/tencent/mm/bj/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   616: ldc_w 297
    //   619: invokevirtual 303	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   622: istore 7
    //   624: iload 8
    //   626: istore_2
    //   627: iload 7
    //   629: istore_3
    //   630: aload_0
    //   631: getfield 265	com/tencent/mm/bj/g:fYF	Lcom/tencent/mm/bj/g$a;
    //   634: getfield 178	com/tencent/mm/bj/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   637: ldc_w 305
    //   640: invokevirtual 303	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   643: istore 8
    //   645: iload 8
    //   647: istore_2
    //   648: iload 7
    //   650: istore_3
    //   651: aload_0
    //   652: getfield 265	com/tencent/mm/bj/g:fYF	Lcom/tencent/mm/bj/g$a;
    //   655: getfield 178	com/tencent/mm/bj/g$a:mediaFormat	Landroid/media/MediaFormat;
    //   658: ldc_w 307
    //   661: invokevirtual 303	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   664: istore 10
    //   666: iload 10
    //   668: istore_2
    //   669: iload_2
    //   670: istore_3
    //   671: iload 7
    //   673: istore_2
    //   674: ldc 71
    //   676: ldc_w 309
    //   679: iconst_3
    //   680: anewarray 4	java/lang/Object
    //   683: dup
    //   684: iconst_0
    //   685: iload_2
    //   686: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   689: aastore
    //   690: dup
    //   691: iconst_1
    //   692: iload 8
    //   694: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   697: aastore
    //   698: dup
    //   699: iconst_2
    //   700: iload_3
    //   701: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   704: aastore
    //   705: invokestatic 312	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   708: ldc 71
    //   710: ldc_w 314
    //   713: iconst_4
    //   714: anewarray 4	java/lang/Object
    //   717: dup
    //   718: iconst_0
    //   719: iload 8
    //   721: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   724: aastore
    //   725: dup
    //   726: iconst_1
    //   727: iload_2
    //   728: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   731: aastore
    //   732: dup
    //   733: iconst_2
    //   734: aload 4
    //   736: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   739: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   742: aastore
    //   743: dup
    //   744: iconst_3
    //   745: aload 17
    //   747: aastore
    //   748: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   751: aload 16
    //   753: getfield 133	com/tencent/mm/bj/h:fYP	Z
    //   756: ifeq +340 -> 1096
    //   759: iload 8
    //   761: sipush 1024
    //   764: iconst_2
    //   765: iload_2
    //   766: aload 17
    //   768: aload 4
    //   770: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   773: i2f
    //   774: aload_0
    //   775: getfield 91	com/tencent/mm/bj/g:fYM	J
    //   778: aload_0
    //   779: getfield 86	com/tencent/mm/bj/g:fYL	J
    //   782: lsub
    //   783: l2i
    //   784: aconst_null
    //   785: iconst_0
    //   786: invokestatic 318	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264Lock	(IIIILjava/lang/String;FI[BI)I
    //   789: istore_2
    //   790: ldc 71
    //   792: ldc_w 320
    //   795: invokestatic 322	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   798: iload_2
    //   799: ifge +22 -> 821
    //   802: ldc 71
    //   804: ldc_w 324
    //   807: iconst_1
    //   808: anewarray 4	java/lang/Object
    //   811: dup
    //   812: iconst_0
    //   813: iload_2
    //   814: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: invokestatic 312	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   821: aload_0
    //   822: getfield 55	com/tencent/mm/bj/g:mRotationDegree	I
    //   825: ifle +299 -> 1124
    //   828: aload_0
    //   829: invokespecial 285	com/tencent/mm/bj/g:amg	()Ljava/lang/String;
    //   832: aload_0
    //   833: getfield 326	com/tencent/mm/bj/g:fYJ	Ljava/lang/String;
    //   836: aload_0
    //   837: getfield 55	com/tencent/mm/bj/g:mRotationDegree	I
    //   840: invokestatic 330	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideo	(Ljava/lang/String;Ljava/lang/String;I)I
    //   843: pop
    //   844: ldc 71
    //   846: ldc_w 332
    //   849: iconst_1
    //   850: anewarray 4	java/lang/Object
    //   853: dup
    //   854: iconst_0
    //   855: lload 13
    //   857: invokestatic 260	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   860: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   863: aastore
    //   864: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   867: ldc 71
    //   869: ldc_w 334
    //   872: iconst_1
    //   873: anewarray 4	java/lang/Object
    //   876: dup
    //   877: iconst_0
    //   878: invokestatic 168	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   881: invokestatic 260	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   884: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   887: aastore
    //   888: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   891: aload_0
    //   892: getfield 82	com/tencent/mm/bj/g:eRm	I
    //   895: invokestatic 337	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   898: aload_1
    //   899: invokevirtual 187	android/media/MediaExtractor:release	()V
    //   902: getstatic 193	com/tencent/mm/bj/b:fYm	Lcom/tencent/mm/bj/b;
    //   905: invokevirtual 196	com/tencent/mm/bj/b:XJ	()V
    //   908: aload 16
    //   910: invokevirtual 338	com/tencent/mm/bj/h:release	()V
    //   913: ldc 69
    //   915: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   918: iconst_0
    //   919: ireturn
    //   920: aload 16
    //   922: aload 17
    //   924: getfield 114	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   927: aload 17
    //   929: getfield 111	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   932: invokevirtual 118	com/tencent/mm/bj/h:cI	(II)V
    //   935: goto -826 -> 109
    //   938: astore_1
    //   939: aload 16
    //   941: astore 4
    //   943: ldc 71
    //   945: aload_1
    //   946: ldc_w 340
    //   949: iconst_0
    //   950: anewarray 4	java/lang/Object
    //   953: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   956: aload 4
    //   958: ifnull +8 -> 966
    //   961: aload 4
    //   963: invokevirtual 338	com/tencent/mm/bj/h:release	()V
    //   966: ldc 69
    //   968: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   971: iconst_m1
    //   972: ireturn
    //   973: bipush 10
    //   975: istore 7
    //   977: goto -761 -> 216
    //   980: ldc2_w 345
    //   983: dstore 5
    //   985: goto -597 -> 388
    //   988: astore 17
    //   990: ldc 98
    //   992: aload 17
    //   994: ldc_w 348
    //   997: iconst_1
    //   998: anewarray 4	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: aload 17
    //   1005: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1008: aastore
    //   1009: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1012: goto -571 -> 441
    //   1015: astore 4
    //   1017: ldc 71
    //   1019: aload 4
    //   1021: ldc_w 353
    //   1024: iconst_1
    //   1025: anewarray 4	java/lang/Object
    //   1028: dup
    //   1029: iconst_0
    //   1030: aload 4
    //   1032: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1035: aastore
    //   1036: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1039: aload_0
    //   1040: getfield 82	com/tencent/mm/bj/g:eRm	I
    //   1043: invokestatic 337	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   1046: aload_1
    //   1047: invokevirtual 187	android/media/MediaExtractor:release	()V
    //   1050: getstatic 193	com/tencent/mm/bj/b:fYm	Lcom/tencent/mm/bj/b;
    //   1053: invokevirtual 196	com/tencent/mm/bj/b:XJ	()V
    //   1056: goto -148 -> 908
    //   1059: astore_1
    //   1060: goto -152 -> 908
    //   1063: astore 18
    //   1065: ldc 71
    //   1067: ldc_w 355
    //   1070: iconst_1
    //   1071: anewarray 4	java/lang/Object
    //   1074: dup
    //   1075: iconst_0
    //   1076: aload 18
    //   1078: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1081: aastore
    //   1082: invokestatic 312	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1085: iload_2
    //   1086: istore 8
    //   1088: iload_3
    //   1089: istore_2
    //   1090: iload 9
    //   1092: istore_3
    //   1093: goto -419 -> 674
    //   1096: aload_0
    //   1097: getfield 82	com/tencent/mm/bj/g:eRm	I
    //   1100: iload 8
    //   1102: sipush 1024
    //   1105: iconst_2
    //   1106: iload_2
    //   1107: aload 17
    //   1109: aload 4
    //   1111: getfield 222	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   1114: i2f
    //   1115: aconst_null
    //   1116: iconst_0
    //   1117: invokestatic 359	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingLock	(IIIIILjava/lang/String;F[BI)I
    //   1120: istore_2
    //   1121: goto -331 -> 790
    //   1124: aload_0
    //   1125: invokespecial 285	com/tencent/mm/bj/g:amg	()Ljava/lang/String;
    //   1128: aload_0
    //   1129: getfield 326	com/tencent/mm/bj/g:fYJ	Ljava/lang/String;
    //   1132: invokestatic 365	com/tencent/mm/modelsfs/FileOp:aT	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1135: pop
    //   1136: goto -292 -> 844
    //   1139: astore 4
    //   1141: aload_0
    //   1142: getfield 82	com/tencent/mm/bj/g:eRm	I
    //   1145: invokestatic 337	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   1148: aload_1
    //   1149: invokevirtual 187	android/media/MediaExtractor:release	()V
    //   1152: getstatic 193	com/tencent/mm/bj/b:fYm	Lcom/tencent/mm/bj/b;
    //   1155: invokevirtual 196	com/tencent/mm/bj/b:XJ	()V
    //   1158: ldc 69
    //   1160: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1163: aload 4
    //   1165: athrow
    //   1166: astore_1
    //   1167: ldc 71
    //   1169: aload_1
    //   1170: ldc_w 367
    //   1173: iconst_1
    //   1174: anewarray 4	java/lang/Object
    //   1177: dup
    //   1178: iconst_0
    //   1179: aload_1
    //   1180: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1183: aastore
    //   1184: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1187: aload 16
    //   1189: invokevirtual 338	com/tencent/mm/bj/h:release	()V
    //   1192: ldc 69
    //   1194: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1197: iconst_m1
    //   1198: ireturn
    //   1199: astore_1
    //   1200: aload 16
    //   1202: invokevirtual 338	com/tencent/mm/bj/h:release	()V
    //   1205: ldc 69
    //   1207: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1210: aload_1
    //   1211: athrow
    //   1212: astore_1
    //   1213: goto -300 -> 913
    //   1216: astore_1
    //   1217: goto -25 -> 1192
    //   1220: astore 4
    //   1222: goto -17 -> 1205
    //   1225: astore_1
    //   1226: goto -68 -> 1158
    //   1229: astore_1
    //   1230: goto -322 -> 908
    //   1233: astore 17
    //   1235: goto -943 -> 292
    //   1238: astore_1
    //   1239: aload 17
    //   1241: astore 4
    //   1243: goto -300 -> 943
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1246	0	this	g
    //   0	1246	1	paramMediaExtractor	MediaExtractor
    //   0	1246	2	paramInt1	int
    //   0	1246	3	paramInt2	int
    //   0	1246	4	paramString	String
    //   386	598	5	d	double
    //   120	856	7	i	int
    //   597	504	8	j	int
    //   604	487	9	k	int
    //   664	3	10	m	int
    //   228	337	11	l1	long
    //   503	353	13	l2	long
    //   334	3	15	bool	boolean
    //   26	1175	16	localh	h
    //   13	915	17	localObject	Object
    //   988	120	17	localException1	Exception
    //   1233	7	17	localException2	Exception
    //   1063	14	18	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   28	94	938	java/lang/Exception
    //   94	109	938	java/lang/Exception
    //   109	157	938	java/lang/Exception
    //   920	935	938	java/lang/Exception
    //   341	388	988	java/lang/Exception
    //   388	441	988	java/lang/Exception
    //   195	216	1015	java/lang/Exception
    //   216	270	1015	java/lang/Exception
    //   292	336	1015	java/lang/Exception
    //   441	542	1015	java/lang/Exception
    //   542	590	1015	java/lang/Exception
    //   592	606	1015	java/lang/Exception
    //   674	790	1015	java/lang/Exception
    //   790	798	1015	java/lang/Exception
    //   802	821	1015	java/lang/Exception
    //   821	844	1015	java/lang/Exception
    //   844	891	1015	java/lang/Exception
    //   990	1012	1015	java/lang/Exception
    //   1065	1085	1015	java/lang/Exception
    //   1096	1121	1015	java/lang/Exception
    //   1124	1136	1015	java/lang/Exception
    //   1039	1056	1059	java/lang/Exception
    //   609	624	1063	java/lang/Exception
    //   630	645	1063	java/lang/Exception
    //   651	666	1063	java/lang/Exception
    //   195	216	1139	finally
    //   216	270	1139	finally
    //   275	292	1139	finally
    //   292	336	1139	finally
    //   341	388	1139	finally
    //   388	441	1139	finally
    //   441	542	1139	finally
    //   542	590	1139	finally
    //   592	606	1139	finally
    //   609	624	1139	finally
    //   630	645	1139	finally
    //   651	666	1139	finally
    //   674	790	1139	finally
    //   790	798	1139	finally
    //   802	821	1139	finally
    //   821	844	1139	finally
    //   844	891	1139	finally
    //   990	1012	1139	finally
    //   1017	1039	1139	finally
    //   1065	1085	1139	finally
    //   1096	1121	1139	finally
    //   1124	1136	1139	finally
    //   164	195	1166	java/lang/Exception
    //   1158	1166	1166	java/lang/Exception
    //   164	195	1199	finally
    //   891	908	1199	finally
    //   1039	1056	1199	finally
    //   1141	1158	1199	finally
    //   1158	1166	1199	finally
    //   1167	1187	1199	finally
    //   908	913	1212	java/lang/Exception
    //   1187	1192	1216	java/lang/Exception
    //   1200	1205	1220	java/lang/Exception
    //   1141	1158	1225	java/lang/Exception
    //   891	908	1229	java/lang/Exception
    //   275	292	1233	java/lang/Exception
    //   15	28	1238	java/lang/Exception
  }
  
  private void a(MediaExtractor paramMediaExtractor)
  {
    AppMethodBeat.i(50938);
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    if (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str;
      if ((localMediaFormat.containsKey("mime")) && (!bo.isNullOrNil(localMediaFormat.getString("mime"))))
      {
        str = localMediaFormat.getString("mime");
        ab.i("MicroMsg.VideoTranferH265toH264", "mime: %s", new Object[] { str });
        if (!str.startsWith("audio/")) {
          break label116;
        }
        this.fYH.add(new a(localMediaFormat, i));
      }
      for (;;)
      {
        i += 1;
        break;
        label116:
        if (str.startsWith("video/")) {
          this.fYG.add(new a(localMediaFormat, i));
        }
      }
    }
    ab.i("MicroMsg.VideoTranferH265toH264", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", new Object[] { Integer.valueOf(this.fYH.size()), Integer.valueOf(this.fYG.size()) });
    AppMethodBeat.o(50938);
  }
  
  private boolean a(MediaExtractor paramMediaExtractor, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50936);
    if (this.fYF == null)
    {
      AppMethodBeat.o(50936);
      return false;
    }
    paramMediaExtractor.selectTrack(this.fYF.index);
    paramMediaExtractor.seekTo(this.fYL * 1000L, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1);
    try
    {
      this.fYF.mediaFormat.getInteger("channel-count");
      ab.i("MicroMsg.VideoTranferH265toH264", "audio channel count");
      localByteBuffer.clear();
      paramInt1 = paramMediaExtractor.readSampleData(localByteBuffer, 0);
      if (paramInt1 <= 0)
      {
        ab.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(50936);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.VideoTranferH265toH264", "get channel count error: %s", new Object[] { Integer.valueOf(1) });
        continue;
        if (paramMediaExtractor.getSampleTime() < this.fYM * 1000L) {
          if (paramMediaExtractor.getSampleTrackIndex() != this.fYF.index)
          {
            ab.e("MicroMsg.VideoTranferH265toH264", "track index not match! break");
          }
          else
          {
            localByteBuffer.position(0);
            MP4MuxerJNI.writeAACDataLock(paramInt2, localByteBuffer, paramInt1);
            paramMediaExtractor.advance();
          }
        }
      }
    }
  }
  
  private int amf()
  {
    AppMethodBeat.i(50939);
    int j = -1;
    int i = j;
    Iterator localIterator;
    a locala;
    if (this.fYH != null)
    {
      i = j;
      if (this.fYH.size() != 0)
      {
        localIterator = this.fYH.iterator();
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
      if (this.fYG != null)
      {
        j = i;
        if (this.fYG.size() != 0)
        {
          localIterator = this.fYG.iterator();
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
        AppMethodBeat.o(50939);
        return j;
      }
    }
  }
  
  private String amg()
  {
    AppMethodBeat.i(50943);
    if (this.ewk == null) {
      this.ewk = (this.fYJ + "video_temp.mp4");
    }
    String str = this.ewk;
    AppMethodBeat.o(50943);
    return str;
  }
  
  private static void c(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(50937);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (paramVideoTransPara == null))
    {
      paramString1 = new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[] { paramString1, paramString2, paramVideoTransPara }));
      AppMethodBeat.o(50937);
      throw paramString1;
    }
    paramVideoTransPara = new File(paramString1);
    new File(paramString2);
    if ((!FileOp.cN(paramString1)) || (!paramVideoTransPara.canRead()) || (paramVideoTransPara.length() == 0L))
    {
      paramString1 = new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[] { paramString1 }));
      AppMethodBeat.o(50937);
      throw paramString1;
    }
    AppMethodBeat.o(50937);
  }
  
  private void hh(long paramLong)
  {
    AppMethodBeat.i(50942);
    ab.e("MicroMsg.VideoTranferH265toH264", "init %s", new Object[] { Boolean.valueOf(this.isInited) });
    if (!this.isInited) {
      ab.e("MicroMsg.VideoTranferH265toH264", "checkTimeParameter has not been initialized.");
    }
    this.fYL = 0L;
    Object localObject = ((a)this.fYG.get(0)).mediaFormat;
    if (!((MediaFormat)localObject).containsKey("durationUs"))
    {
      localObject = new f("Can not find duration.");
      AppMethodBeat.o(50942);
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
    this.fYM = l;
    AppMethodBeat.o(50942);
  }
  
  private void release()
  {
    AppMethodBeat.i(50941);
    this.isInited = false;
    if (this.mMediaExtractor != null) {
      this.mMediaExtractor.release();
    }
    AppMethodBeat.o(50941);
  }
  
  /* Error */
  private static int vE(String paramString)
  {
    // Byte code:
    //   0: ldc_w 549
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 551	android/media/MediaMetadataRetriever
    //   9: dup
    //   10: invokespecial 552	android/media/MediaMetadataRetriever:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_0
    //   16: invokevirtual 555	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   19: bipush 17
    //   21: invokestatic 561	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   24: ifeq +89 -> 113
    //   27: aload_2
    //   28: bipush 24
    //   30: invokevirtual 565	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   33: astore_0
    //   34: ldc 71
    //   36: ldc_w 567
    //   39: aload_0
    //   40: invokestatic 570	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokevirtual 573	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 576	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_2
    //   50: bipush 19
    //   52: invokevirtual 565	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_2
    //   57: bipush 18
    //   59: invokevirtual 565	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   62: astore 4
    //   64: ldc 71
    //   66: ldc_w 578
    //   69: aload_3
    //   70: invokestatic 570	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokevirtual 573	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokestatic 576	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: ldc 71
    //   81: ldc_w 580
    //   84: aload 4
    //   86: invokestatic 570	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokevirtual 573	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokestatic 576	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: iconst_0
    //   97: invokestatic 584	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   100: istore_1
    //   101: aload_2
    //   102: invokevirtual 585	android/media/MediaMetadataRetriever:release	()V
    //   105: ldc_w 549
    //   108: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iload_1
    //   112: ireturn
    //   113: new 477	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 478	java/lang/StringBuilder:<init>	()V
    //   120: aload_0
    //   121: invokestatic 588	com/tencent/mm/plugin/sight/base/SightVideoJNI:getMp4Rotate	(Ljava/lang/String;)I
    //   124: invokevirtual 591	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore_0
    //   131: goto -97 -> 34
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 585	android/media/MediaMetadataRetriever:release	()V
    //   145: ldc_w 549
    //   148: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: goto -17 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramString	String
    //   100	12	1	i	int
    //   13	129	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   55	15	3	str1	String
    //   62	23	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   6	14	134	finally
    //   14	34	153	finally
    //   34	101	153	finally
    //   113	131	153	finally
  }
  
  public final void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(50933);
    ab.d("MicroMsg.VideoTranferH265toH264", "init() called with: src = [" + paramString1 + "], dst = [" + paramString2 + "], para = [" + paramVideoTransPara + "]");
    long l = bo.yB();
    c(paramString1, paramString2, paramVideoTransPara);
    this.fYI = paramString1;
    this.fYJ = paramString2;
    this.fYK = paramVideoTransPara;
    this.mMediaExtractor = new MediaExtractor();
    this.mMediaExtractor.setDataSource(paramString1);
    a(this.mMediaExtractor);
    if ((this.fYG == null) || (this.fYG.size() == 0))
    {
      paramString1 = new f("Can not find video or audio track in this video file.");
      AppMethodBeat.o(50933);
      throw paramString1;
    }
    this.fYN = amf();
    this.mRotationDegree = vE(paramString1);
    this.isInited = true;
    ab.e("MicroMsg.VideoTranferH265toH264", "init cost time %dms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(50933);
  }
  
  public final int hg(long paramLong)
  {
    AppMethodBeat.i(50934);
    hh(paramLong);
    this.fYE = ((a)this.fYG.get(0));
    if ((this.fYH != null) && (this.fYH.size() != 0)) {
      this.fYF = ((a)this.fYH.get(0));
    }
    MediaExtractor localMediaExtractor = this.mMediaExtractor;
    if (this.fYN <= 0) {}
    for (int i = 1048576; a(localMediaExtractor, i, this.eRm, this.fYI) == -1; i = this.fYN)
    {
      ab.e("MicroMsg.VideoTranferH265toH264", "transcodeAndMux error");
      release();
      AppMethodBeat.o(50934);
      return -1;
    }
    AppMethodBeat.o(50934);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.g
 * JD-Core Version:    0.7.0.1
 */