package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class c
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private int auC;
  private MediaExtractor eIP;
  private int eIz;
  private Point eJJ = null;
  private String filePath;
  private int jlu = -1;
  private a mkE;
  private String mkG;
  private int mkH;
  private int mkI;
  private int mkJ;
  private int mkK;
  private int mkL;
  private int mkM;
  private long mkN = -1L;
  private long mkO = -1L;
  private int mkP = -1;
  private int mkQ;
  private Bitmap mkT;
  private byte[] mkU = null;
  private byte[] mkV = null;
  private g mkX;
  private int videoFps;
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      y.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      return;
    }
    this.filePath = paramString1;
    this.mkG = paramString2;
    this.mkJ = paramInt1;
    this.mkK = paramInt2;
    this.mkL = paramInt3;
    this.mkP = paramInt4;
    this.mkM = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = d.MH(paramString1);
    if (locala != null)
    {
      this.mkH = locala.width;
      this.mkI = locala.height;
      this.jlu = locala.jlu;
      this.videoFps = locala.eIM;
    }
    this.mkN = 0L;
    this.mkO = this.jlu;
    y.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.mkH), Integer.valueOf(this.mkI), Integer.valueOf(this.mkM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      y.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      return;
    }
    this.filePath = paramString1;
    this.mkG = paramString2;
    this.mkJ = paramInt1;
    this.mkK = paramInt2;
    this.mkL = paramInt3;
    this.mkP = paramInt4;
    this.mkM = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = d.MH(paramString1);
    if (locala != null)
    {
      this.mkH = locala.width;
      this.mkI = locala.height;
      this.videoFps = locala.eIM;
    }
    this.mkN = paramLong1;
    this.mkO = paramLong2;
    y.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.mkH), Integer.valueOf(this.mkI), Integer.valueOf(this.mkM), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  public final void B(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.mkT = paramBitmap;
    }
  }
  
  /* Error */
  public final int biD()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/tencent/mm/plugin/mmsight/model/b/c:jlu	I
    //   4: i2f
    //   5: ldc 168
    //   7: fdiv
    //   8: invokestatic 174	java/lang/Math:round	(F)I
    //   11: istore_2
    //   12: iload_2
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   18: lconst_0
    //   19: lcmp
    //   20: iflt +33 -> 53
    //   23: iload_2
    //   24: istore_1
    //   25: aload_0
    //   26: getfield 51	com/tencent/mm/plugin/mmsight/model/b/c:mkO	J
    //   29: lconst_0
    //   30: lcmp
    //   31: iflt +22 -> 53
    //   34: aload_0
    //   35: getfield 51	com/tencent/mm/plugin/mmsight/model/b/c:mkO	J
    //   38: aload_0
    //   39: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   42: lsub
    //   43: l2f
    //   44: ldc 168
    //   46: fdiv
    //   47: invokestatic 174	java/lang/Math:round	(F)I
    //   50: iconst_1
    //   51: iadd
    //   52: istore_1
    //   53: aload_0
    //   54: iload_1
    //   55: invokestatic 180	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBuf	(I)I
    //   58: putfield 182	com/tencent/mm/plugin/mmsight/model/b/c:eIz	I
    //   61: aload_0
    //   62: getfield 85	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   65: invokestatic 187	com/tencent/mm/bi/e:om	(Ljava/lang/String;)Z
    //   68: ifeq +83 -> 151
    //   71: ldc 67
    //   73: ldc 189
    //   75: invokestatic 192	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: new 194	com/tencent/mm/plugin/mmsight/model/b/e
    //   82: dup
    //   83: invokespecial 195	com/tencent/mm/plugin/mmsight/model/b/e:<init>	()V
    //   86: putfield 150	com/tencent/mm/plugin/mmsight/model/b/c:mkE	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   89: aload_0
    //   90: getfield 45	com/tencent/mm/plugin/mmsight/model/b/c:jlu	I
    //   93: ifle +72 -> 165
    //   96: aload_0
    //   97: getfield 150	com/tencent/mm/plugin/mmsight/model/b/c:mkE	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   100: aload_0
    //   101: getfield 85	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   104: lconst_0
    //   105: aload_0
    //   106: getfield 45	com/tencent/mm/plugin/mmsight/model/b/c:jlu	I
    //   109: i2l
    //   110: aload_0
    //   111: getfield 125	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   114: invokeinterface 200 7 0
    //   119: istore_1
    //   120: ldc 67
    //   122: ldc 202
    //   124: iconst_1
    //   125: anewarray 71	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: iload_1
    //   131: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: aastore
    //   135: invokestatic 130	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: iload_1
    //   139: ifge +123 -> 262
    //   142: aload_0
    //   143: getfield 182	com/tencent/mm/plugin/mmsight/model/b/c:eIz	I
    //   146: invokestatic 206	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   149: iconst_m1
    //   150: ireturn
    //   151: aload_0
    //   152: new 208	com/tencent/mm/plugin/mmsight/model/b/d
    //   155: dup
    //   156: invokespecial 209	com/tencent/mm/plugin/mmsight/model/b/d:<init>	()V
    //   159: putfield 150	com/tencent/mm/plugin/mmsight/model/b/c:mkE	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   162: goto -73 -> 89
    //   165: aload_0
    //   166: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   169: lconst_0
    //   170: lcmp
    //   171: iflt +41 -> 212
    //   174: aload_0
    //   175: getfield 51	com/tencent/mm/plugin/mmsight/model/b/c:mkO	J
    //   178: lconst_0
    //   179: lcmp
    //   180: iflt +32 -> 212
    //   183: aload_0
    //   184: getfield 150	com/tencent/mm/plugin/mmsight/model/b/c:mkE	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   187: aload_0
    //   188: getfield 85	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   191: aload_0
    //   192: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   195: aload_0
    //   196: getfield 51	com/tencent/mm/plugin/mmsight/model/b/c:mkO	J
    //   199: aload_0
    //   200: getfield 125	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   203: invokeinterface 200 7 0
    //   208: istore_1
    //   209: goto -89 -> 120
    //   212: ldc 67
    //   214: ldc 211
    //   216: iconst_3
    //   217: anewarray 71	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_0
    //   223: getfield 45	com/tencent/mm/plugin/mmsight/model/b/c:jlu	I
    //   226: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: aload_0
    //   233: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   236: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   239: aastore
    //   240: dup
    //   241: iconst_2
    //   242: aload_0
    //   243: getfield 51	com/tencent/mm/plugin/mmsight/model/b/c:mkO	J
    //   246: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: aastore
    //   250: invokestatic 83	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload_0
    //   254: getfield 182	com/tencent/mm/plugin/mmsight/model/b/c:eIz	I
    //   257: invokestatic 206	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   260: iconst_m1
    //   261: ireturn
    //   262: aload_0
    //   263: getfield 53	com/tencent/mm/plugin/mmsight/model/b/c:mkP	I
    //   266: ifle +39 -> 305
    //   269: aload_0
    //   270: getfield 53	com/tencent/mm/plugin/mmsight/model/b/c:mkP	I
    //   273: aload_0
    //   274: getfield 125	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   277: if_icmpge +28 -> 305
    //   280: aload_0
    //   281: getfield 150	com/tencent/mm/plugin/mmsight/model/b/c:mkE	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   284: aload_0
    //   285: getfield 125	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   288: i2f
    //   289: aload_0
    //   290: getfield 53	com/tencent/mm/plugin/mmsight/model/b/c:mkP	I
    //   293: i2f
    //   294: fdiv
    //   295: f2d
    //   296: invokestatic 215	java/lang/Math:ceil	(D)D
    //   299: d2i
    //   300: invokeinterface 218 2 0
    //   305: aload_0
    //   306: getfield 53	com/tencent/mm/plugin/mmsight/model/b/c:mkP	I
    //   309: ifle +629 -> 938
    //   312: aload_0
    //   313: getfield 53	com/tencent/mm/plugin/mmsight/model/b/c:mkP	I
    //   316: aload_0
    //   317: getfield 125	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   320: invokestatic 222	java/lang/Math:min	(II)I
    //   323: istore_1
    //   324: aload_0
    //   325: getfield 150	com/tencent/mm/plugin/mmsight/model/b/c:mkE	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   328: new 6	com/tencent/mm/plugin/mmsight/model/b/c$1
    //   331: dup
    //   332: aload_0
    //   333: invokespecial 225	com/tencent/mm/plugin/mmsight/model/b/c$1:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/c;)V
    //   336: invokeinterface 228 2 0
    //   341: aload_0
    //   342: new 230	com/tencent/mm/plugin/mmsight/model/b/g
    //   345: dup
    //   346: aload_0
    //   347: getfield 114	com/tencent/mm/plugin/mmsight/model/b/c:mkH	I
    //   350: aload_0
    //   351: getfield 119	com/tencent/mm/plugin/mmsight/model/b/c:mkI	I
    //   354: aload_0
    //   355: getfield 89	com/tencent/mm/plugin/mmsight/model/b/c:mkJ	I
    //   358: aload_0
    //   359: getfield 91	com/tencent/mm/plugin/mmsight/model/b/c:mkK	I
    //   362: aload_0
    //   363: getfield 93	com/tencent/mm/plugin/mmsight/model/b/c:mkL	I
    //   366: iload_1
    //   367: getstatic 235	com/tencent/mm/plugin/sight/base/b:oea	I
    //   370: invokespecial 238	com/tencent/mm/plugin/mmsight/model/b/g:<init>	(IIIIIII)V
    //   373: putfield 159	com/tencent/mm/plugin/mmsight/model/b/c:mkX	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   376: aload_0
    //   377: getfield 159	com/tencent/mm/plugin/mmsight/model/b/c:mkX	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   380: astore 5
    //   382: aload 5
    //   384: iconst_0
    //   385: putfield 241	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   388: aload 5
    //   390: getfield 244	com/tencent/mm/plugin/mmsight/model/b/g:eIB	I
    //   393: aload 5
    //   395: getfield 247	com/tencent/mm/plugin/mmsight/model/b/g:eIC	I
    //   398: aload 5
    //   400: getfield 248	com/tencent/mm/plugin/mmsight/model/b/g:eIM	I
    //   403: i2f
    //   404: aload 5
    //   406: getfield 251	com/tencent/mm/plugin/mmsight/model/b/g:bitrate	I
    //   409: aload 5
    //   411: getfield 254	com/tencent/mm/plugin/mmsight/model/b/g:ejP	I
    //   414: bipush 8
    //   416: aload 5
    //   418: getfield 257	com/tencent/mm/plugin/mmsight/model/b/g:ejO	I
    //   421: ldc_w 258
    //   424: invokestatic 262	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initH264Encoder	(IIFIIIIF)I
    //   427: pop
    //   428: aload 5
    //   430: new 264	com/tencent/mm/plugin/mmsight/model/b/g$a
    //   433: dup
    //   434: aload 5
    //   436: iconst_0
    //   437: invokespecial 267	com/tencent/mm/plugin/mmsight/model/b/g$a:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/g;B)V
    //   440: putfield 271	com/tencent/mm/plugin/mmsight/model/b/g:mlf	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   443: aload 5
    //   445: aload 5
    //   447: getfield 271	com/tencent/mm/plugin/mmsight/model/b/g:mlf	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   450: ldc_w 273
    //   453: invokestatic 278	com/tencent/mm/sdk/f/e:b	(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   456: putfield 282	com/tencent/mm/plugin/mmsight/model/b/g:mlg	Ljava/lang/Thread;
    //   459: aload 5
    //   461: getfield 282	com/tencent/mm/plugin/mmsight/model/b/g:mlg	Ljava/lang/Thread;
    //   464: invokevirtual 287	java/lang/Thread:start	()V
    //   467: aload 5
    //   469: iconst_0
    //   470: putfield 291	com/tencent/mm/plugin/mmsight/model/b/g:bSr	Z
    //   473: ldc_w 293
    //   476: ldc_w 295
    //   479: invokestatic 192	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aload_0
    //   483: getfield 150	com/tencent/mm/plugin/mmsight/model/b/c:mkE	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   486: invokeinterface 298 1 0
    //   491: aload_0
    //   492: getfield 159	com/tencent/mm/plugin/mmsight/model/b/c:mkX	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   495: astore 5
    //   497: aload 5
    //   499: getfield 271	com/tencent/mm/plugin/mmsight/model/b/g:mlf	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   502: ifnull +37 -> 539
    //   505: aload 5
    //   507: getfield 282	com/tencent/mm/plugin/mmsight/model/b/g:mlg	Ljava/lang/Thread;
    //   510: ifnull +29 -> 539
    //   513: aload 5
    //   515: getfield 271	com/tencent/mm/plugin/mmsight/model/b/g:mlf	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   518: iconst_1
    //   519: putfield 301	com/tencent/mm/plugin/mmsight/model/b/g$a:eJM	Z
    //   522: aload 5
    //   524: getfield 282	com/tencent/mm/plugin/mmsight/model/b/g:mlg	Ljava/lang/Thread;
    //   527: invokevirtual 304	java/lang/Thread:join	()V
    //   530: aload 5
    //   532: getfield 271	com/tencent/mm/plugin/mmsight/model/b/g:mlf	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   535: invokestatic 308	com/tencent/mm/sdk/f/e:remove	(Ljava/lang/Runnable;)Z
    //   538: pop
    //   539: aload_0
    //   540: new 310	android/media/MediaExtractor
    //   543: dup
    //   544: invokespecial 311	android/media/MediaExtractor:<init>	()V
    //   547: putfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   550: aload_0
    //   551: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   554: aload_0
    //   555: getfield 85	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   558: invokevirtual 317	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   561: aconst_null
    //   562: astore 5
    //   564: iconst_0
    //   565: istore_1
    //   566: iload_1
    //   567: aload_0
    //   568: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   571: invokevirtual 320	android/media/MediaExtractor:getTrackCount	()I
    //   574: if_icmpge +499 -> 1073
    //   577: aload_0
    //   578: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   581: iload_1
    //   582: invokevirtual 324	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   585: astore 6
    //   587: aload 6
    //   589: ldc_w 326
    //   592: invokevirtual 332	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   595: astore 5
    //   597: aload 5
    //   599: ldc_w 334
    //   602: invokevirtual 339	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   605: ifeq +476 -> 1081
    //   608: iload_1
    //   609: iflt +145 -> 754
    //   612: aload 6
    //   614: ifnull +140 -> 754
    //   617: aload 5
    //   619: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   622: ifne +132 -> 754
    //   625: aload_0
    //   626: aload 6
    //   628: ldc_w 341
    //   631: invokevirtual 344	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   634: putfield 346	com/tencent/mm/plugin/mmsight/model/b/c:auC	I
    //   637: aload_0
    //   638: aload 6
    //   640: ldc_w 348
    //   643: invokevirtual 344	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   646: putfield 350	com/tencent/mm/plugin/mmsight/model/b/c:mkQ	I
    //   649: aload_0
    //   650: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   653: iload_1
    //   654: invokevirtual 353	android/media/MediaExtractor:selectTrack	(I)V
    //   657: aload_0
    //   658: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   661: lconst_0
    //   662: lcmp
    //   663: ifle +19 -> 682
    //   666: aload_0
    //   667: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   670: aload_0
    //   671: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   674: ldc2_w 354
    //   677: lmul
    //   678: iconst_0
    //   679: invokevirtual 359	android/media/MediaExtractor:seekTo	(JI)V
    //   682: aload 6
    //   684: ldc_w 361
    //   687: invokevirtual 344	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   690: invokestatic 367	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   693: astore 5
    //   695: aload 5
    //   697: invokevirtual 371	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   700: pop
    //   701: aload_0
    //   702: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   705: aload 5
    //   707: iconst_0
    //   708: invokevirtual 375	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   711: istore_2
    //   712: ldc 67
    //   714: ldc_w 377
    //   717: iconst_1
    //   718: anewarray 71	java/lang/Object
    //   721: dup
    //   722: iconst_0
    //   723: iload_2
    //   724: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   727: aastore
    //   728: invokestatic 379	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   731: iload_2
    //   732: ifgt +269 -> 1001
    //   735: ldc 67
    //   737: ldc_w 381
    //   740: iconst_1
    //   741: anewarray 71	java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: iload_2
    //   747: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: aastore
    //   751: invokestatic 130	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   754: aload_0
    //   755: getfield 87	com/tencent/mm/plugin/mmsight/model/b/c:mkG	Ljava/lang/String;
    //   758: astore 6
    //   760: aload 6
    //   762: astore 5
    //   764: aload_0
    //   765: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:mkM	I
    //   768: ifle +26 -> 794
    //   771: new 383	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   778: aload 6
    //   780: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: ldc_w 390
    //   786: invokevirtual 388	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: astore 5
    //   794: aload_0
    //   795: getfield 45	com/tencent/mm/plugin/mmsight/model/b/c:jlu	I
    //   798: i2l
    //   799: lstore_3
    //   800: lload_3
    //   801: lconst_0
    //   802: lcmp
    //   803: ifgt +267 -> 1070
    //   806: aload_0
    //   807: getfield 51	com/tencent/mm/plugin/mmsight/model/b/c:mkO	J
    //   810: aload_0
    //   811: getfield 49	com/tencent/mm/plugin/mmsight/model/b/c:mkN	J
    //   814: lsub
    //   815: lstore_3
    //   816: aload_0
    //   817: getfield 350	com/tencent/mm/plugin/mmsight/model/b/c:mkQ	I
    //   820: sipush 1024
    //   823: iconst_2
    //   824: aload_0
    //   825: getfield 346	com/tencent/mm/plugin/mmsight/model/b/c:auC	I
    //   828: aload 5
    //   830: aload_0
    //   831: getfield 159	com/tencent/mm/plugin/mmsight/model/b/c:mkX	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   834: getfield 241	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   837: i2f
    //   838: ldc 168
    //   840: fmul
    //   841: lload_3
    //   842: l2f
    //   843: fdiv
    //   844: lload_3
    //   845: l2i
    //   846: aconst_null
    //   847: iconst_0
    //   848: invokestatic 398	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264	(IIIILjava/lang/String;FI[BI)I
    //   851: istore_1
    //   852: ldc 67
    //   854: ldc_w 400
    //   857: iconst_1
    //   858: anewarray 71	java/lang/Object
    //   861: dup
    //   862: iconst_0
    //   863: iload_1
    //   864: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: aastore
    //   868: invokestatic 130	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   871: aload_0
    //   872: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:mkM	I
    //   875: ifle +22 -> 897
    //   878: aload 5
    //   880: aload_0
    //   881: getfield 87	com/tencent/mm/plugin/mmsight/model/b/c:mkG	Ljava/lang/String;
    //   884: aload_0
    //   885: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:mkM	I
    //   888: invokestatic 404	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideo	(Ljava/lang/String;Ljava/lang/String;I)V
    //   891: aload 5
    //   893: invokestatic 409	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   896: pop
    //   897: aload_0
    //   898: getfield 182	com/tencent/mm/plugin/mmsight/model/b/c:eIz	I
    //   901: invokestatic 206	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBuf	(I)V
    //   904: getstatic 415	com/tencent/mm/plugin/mmsight/model/a/j:mji	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   907: invokevirtual 418	com/tencent/mm/plugin/mmsight/model/a/j:ET	()V
    //   910: iload_1
    //   911: ireturn
    //   912: astore 5
    //   914: ldc 67
    //   916: aload 5
    //   918: ldc_w 420
    //   921: iconst_1
    //   922: anewarray 71	java/lang/Object
    //   925: dup
    //   926: iconst_0
    //   927: aload 5
    //   929: invokevirtual 423	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   932: aastore
    //   933: invokestatic 427	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   936: iconst_m1
    //   937: ireturn
    //   938: aload_0
    //   939: getfield 125	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   942: istore_1
    //   943: goto -619 -> 324
    //   946: astore 5
    //   948: ldc_w 293
    //   951: aload 5
    //   953: ldc_w 429
    //   956: iconst_1
    //   957: anewarray 71	java/lang/Object
    //   960: dup
    //   961: iconst_0
    //   962: aload 5
    //   964: invokevirtual 423	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   967: aastore
    //   968: invokestatic 427	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   971: goto -432 -> 539
    //   974: astore 5
    //   976: ldc 67
    //   978: aload 5
    //   980: ldc_w 431
    //   983: iconst_1
    //   984: anewarray 71	java/lang/Object
    //   987: dup
    //   988: iconst_0
    //   989: aload 5
    //   991: invokevirtual 432	java/io/IOException:getMessage	()Ljava/lang/String;
    //   994: aastore
    //   995: invokestatic 427	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   998: goto -244 -> 754
    //   1001: aload_0
    //   1002: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   1005: invokevirtual 436	android/media/MediaExtractor:getSampleTime	()J
    //   1008: aload_0
    //   1009: getfield 51	com/tencent/mm/plugin/mmsight/model/b/c:mkO	J
    //   1012: ldc2_w 354
    //   1015: lmul
    //   1016: lcmp
    //   1017: ifge -263 -> 754
    //   1020: aload_0
    //   1021: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   1024: invokevirtual 439	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   1027: iload_1
    //   1028: if_icmpeq +14 -> 1042
    //   1031: ldc 67
    //   1033: ldc_w 441
    //   1036: invokestatic 443	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1039: goto -285 -> 754
    //   1042: aload 5
    //   1044: iconst_0
    //   1045: invokevirtual 447	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1048: pop
    //   1049: aload_0
    //   1050: getfield 182	com/tencent/mm/plugin/mmsight/model/b/c:eIz	I
    //   1053: aload 5
    //   1055: iload_2
    //   1056: invokestatic 451	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:writeAACData	(ILjava/nio/ByteBuffer;I)V
    //   1059: aload_0
    //   1060: getfield 313	com/tencent/mm/plugin/mmsight/model/b/c:eIP	Landroid/media/MediaExtractor;
    //   1063: invokevirtual 455	android/media/MediaExtractor:advance	()Z
    //   1066: pop
    //   1067: goto -372 -> 695
    //   1070: goto -254 -> 816
    //   1073: aconst_null
    //   1074: astore 6
    //   1076: iconst_m1
    //   1077: istore_1
    //   1078: goto -470 -> 608
    //   1081: iload_1
    //   1082: iconst_1
    //   1083: iadd
    //   1084: istore_1
    //   1085: goto -519 -> 566
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1088	0	this	c
    //   13	1072	1	i	int
    //   11	1045	2	j	int
    //   799	46	3	l	long
    //   380	512	5	localObject1	Object
    //   912	16	5	localException1	java.lang.Exception
    //   946	17	5	localException2	java.lang.Exception
    //   974	80	5	localIOException	java.io.IOException
    //   585	490	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   482	522	912	java/lang/Exception
    //   539	550	912	java/lang/Exception
    //   550	561	912	java/lang/Exception
    //   566	608	912	java/lang/Exception
    //   617	682	912	java/lang/Exception
    //   682	695	912	java/lang/Exception
    //   695	731	912	java/lang/Exception
    //   735	754	912	java/lang/Exception
    //   754	760	912	java/lang/Exception
    //   764	794	912	java/lang/Exception
    //   794	800	912	java/lang/Exception
    //   806	816	912	java/lang/Exception
    //   816	897	912	java/lang/Exception
    //   897	910	912	java/lang/Exception
    //   948	971	912	java/lang/Exception
    //   976	998	912	java/lang/Exception
    //   1001	1039	912	java/lang/Exception
    //   1042	1067	912	java/lang/Exception
    //   522	539	946	java/lang/Exception
    //   550	561	974	java/io/IOException
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.c
 * JD-Core Version:    0.7.0.1
 */