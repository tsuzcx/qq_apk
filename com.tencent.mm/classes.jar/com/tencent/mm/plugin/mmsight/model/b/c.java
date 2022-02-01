package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class c
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private com.tencent.mm.compatible.h.c cSi;
  private int channelCount;
  private String filePath;
  private int gNJ;
  private int gOu;
  private Bitmap gSY;
  private int gTG;
  private int gTH;
  private int gTI;
  private long gTJ;
  private int gUm;
  private int gUq;
  private int grA;
  private int grB;
  private Point icA;
  private String outputFilePath;
  private long remuxEndTime;
  private a uNA;
  private byte[] uNE;
  private byte[] uNF;
  private a.a uNG;
  private g uNI;
  private int uNJ;
  private int uNK;
  private int videoDuration;
  private int videoFps;
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89613);
    this.videoDuration = -1;
    this.gTJ = -1L;
    this.remuxEndTime = -1L;
    this.gUq = -1;
    this.icA = null;
    this.uNE = null;
    this.uNF = null;
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ac.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89613);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.grA = paramInt1;
    this.grB = paramInt2;
    this.gUm = paramInt3;
    this.gUq = paramInt4;
    this.uNJ = paramInt5;
    this.uNK = paramInt6;
    this.gTI = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = e.asx(paramString1);
    if (locala != null)
    {
      this.gTG = locala.width;
      this.gTH = locala.height;
      this.videoDuration = locala.videoDuration;
      this.videoFps = locala.frameRate;
    }
    this.gTJ = 0L;
    this.remuxEndTime = this.videoDuration;
    ac.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.gTG), Integer.valueOf(this.gTH), Integer.valueOf(this.gTI), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89613);
  }
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89614);
    this.videoDuration = -1;
    this.gTJ = -1L;
    this.remuxEndTime = -1L;
    this.gUq = -1;
    this.icA = null;
    this.uNE = null;
    this.uNF = null;
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ac.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89614);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.grA = paramInt1;
    this.grB = paramInt2;
    this.gUm = paramInt3;
    this.gUq = paramInt4;
    this.uNJ = paramInt5;
    this.uNK = paramInt6;
    this.gTI = SightVideoJNI.getMp4RotateVFS(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = e.asx(paramString1);
    if (locala != null)
    {
      this.gTG = locala.width;
      this.gTH = locala.height;
      this.videoFps = locala.frameRate;
    }
    this.gTJ = paramLong1;
    this.remuxEndTime = paramLong2;
    ac.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.gTG), Integer.valueOf(this.gTH), Integer.valueOf(this.gTI), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(89614);
  }
  
  /* Error */
  public final int arc()
  {
    // Byte code:
    //   0: ldc 188
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   9: i2f
    //   10: ldc 189
    //   12: fdiv
    //   13: invokestatic 195	java/lang/Math:round	(F)I
    //   16: istore_2
    //   17: iload_2
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   23: lconst_0
    //   24: lcmp
    //   25: iflt +33 -> 58
    //   28: iload_2
    //   29: istore_1
    //   30: aload_0
    //   31: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   34: lconst_0
    //   35: lcmp
    //   36: iflt +22 -> 58
    //   39: aload_0
    //   40: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   43: aload_0
    //   44: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   47: lsub
    //   48: l2f
    //   49: ldc 189
    //   51: fdiv
    //   52: invokestatic 195	java/lang/Math:round	(F)I
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: aload_0
    //   59: iload_1
    //   60: invokestatic 201	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBufLock	(I)I
    //   63: putfield 203	com/tencent/mm/plugin/mmsight/model/b/c:gNJ	I
    //   66: aload_0
    //   67: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   70: invokestatic 208	com/tencent/mm/bk/e:Et	(Ljava/lang/String;)Z
    //   73: ifeq +88 -> 161
    //   76: ldc 78
    //   78: ldc 210
    //   80: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: new 215	com/tencent/mm/plugin/mmsight/model/b/e
    //   87: dup
    //   88: invokespecial 216	com/tencent/mm/plugin/mmsight/model/b/e:<init>	()V
    //   91: putfield 168	com/tencent/mm/plugin/mmsight/model/b/c:uNA	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   94: aload_0
    //   95: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   98: ifle +77 -> 175
    //   101: aload_0
    //   102: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:uNA	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   105: aload_0
    //   106: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   109: lconst_0
    //   110: aload_0
    //   111: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   114: i2l
    //   115: aload_0
    //   116: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   119: invokeinterface 221 7 0
    //   124: istore_1
    //   125: ldc 78
    //   127: ldc 223
    //   129: iconst_1
    //   130: anewarray 82	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: iload_1
    //   136: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: invokestatic 147	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: iload_1
    //   144: ifge +133 -> 277
    //   147: aload_0
    //   148: getfield 203	com/tencent/mm/plugin/mmsight/model/b/c:gNJ	I
    //   151: invokestatic 226	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   154: ldc 188
    //   156: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iconst_m1
    //   160: ireturn
    //   161: aload_0
    //   162: new 228	com/tencent/mm/plugin/mmsight/model/b/d
    //   165: dup
    //   166: invokespecial 229	com/tencent/mm/plugin/mmsight/model/b/d:<init>	()V
    //   169: putfield 168	com/tencent/mm/plugin/mmsight/model/b/c:uNA	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   172: goto -78 -> 94
    //   175: aload_0
    //   176: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   179: lconst_0
    //   180: lcmp
    //   181: iflt +41 -> 222
    //   184: aload_0
    //   185: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt +32 -> 222
    //   193: aload_0
    //   194: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:uNA	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   197: aload_0
    //   198: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   205: aload_0
    //   206: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   209: aload_0
    //   210: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   213: invokeinterface 221 7 0
    //   218: istore_1
    //   219: goto -94 -> 125
    //   222: ldc 78
    //   224: ldc 231
    //   226: iconst_3
    //   227: anewarray 82	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_0
    //   233: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   236: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_0
    //   243: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   246: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: aastore
    //   250: dup
    //   251: iconst_2
    //   252: aload_0
    //   253: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   256: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   259: aastore
    //   260: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 203	com/tencent/mm/plugin/mmsight/model/b/c:gNJ	I
    //   267: invokestatic 226	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   270: ldc 188
    //   272: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iconst_m1
    //   276: ireturn
    //   277: aload_0
    //   278: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:gUq	I
    //   281: ifle +39 -> 320
    //   284: aload_0
    //   285: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:gUq	I
    //   288: aload_0
    //   289: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   292: if_icmpge +28 -> 320
    //   295: aload_0
    //   296: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:uNA	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   299: aload_0
    //   300: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   303: i2f
    //   304: aload_0
    //   305: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:gUq	I
    //   308: i2f
    //   309: fdiv
    //   310: f2d
    //   311: invokestatic 235	java/lang/Math:ceil	(D)D
    //   314: d2i
    //   315: invokeinterface 238 2 0
    //   320: aload_0
    //   321: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:gUq	I
    //   324: ifle +622 -> 946
    //   327: aload_0
    //   328: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:gUq	I
    //   331: aload_0
    //   332: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   335: invokestatic 242	java/lang/Math:min	(II)I
    //   338: istore_1
    //   339: aload_0
    //   340: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:uNA	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   343: new 6	com/tencent/mm/plugin/mmsight/model/b/c$1
    //   346: dup
    //   347: aload_0
    //   348: invokespecial 245	com/tencent/mm/plugin/mmsight/model/b/c$1:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/c;)V
    //   351: invokeinterface 248 2 0
    //   356: aload_0
    //   357: new 250	com/tencent/mm/plugin/mmsight/model/b/g
    //   360: dup
    //   361: aload_0
    //   362: getfield 132	com/tencent/mm/plugin/mmsight/model/b/c:gTG	I
    //   365: aload_0
    //   366: getfield 137	com/tencent/mm/plugin/mmsight/model/b/c:gTH	I
    //   369: aload_0
    //   370: getfield 103	com/tencent/mm/plugin/mmsight/model/b/c:grA	I
    //   373: aload_0
    //   374: getfield 105	com/tencent/mm/plugin/mmsight/model/b/c:grB	I
    //   377: aload_0
    //   378: getfield 107	com/tencent/mm/plugin/mmsight/model/b/c:gUm	I
    //   381: iload_1
    //   382: getstatic 255	com/tencent/mm/plugin/sight/base/c:xCr	I
    //   385: aload_0
    //   386: getfield 109	com/tencent/mm/plugin/mmsight/model/b/c:uNJ	I
    //   389: aload_0
    //   390: getfield 111	com/tencent/mm/plugin/mmsight/model/b/c:uNK	I
    //   393: invokespecial 258	com/tencent/mm/plugin/mmsight/model/b/g:<init>	(IIIIIIIII)V
    //   396: putfield 181	com/tencent/mm/plugin/mmsight/model/b/c:uNI	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   399: aload_0
    //   400: getfield 181	com/tencent/mm/plugin/mmsight/model/b/c:uNI	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   403: astore 5
    //   405: aload 5
    //   407: iconst_0
    //   408: putfield 261	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   411: aload 5
    //   413: getfield 264	com/tencent/mm/plugin/mmsight/model/b/g:gNU	I
    //   416: aload 5
    //   418: getfield 267	com/tencent/mm/plugin/mmsight/model/b/g:gNV	I
    //   421: aload 5
    //   423: getfield 268	com/tencent/mm/plugin/mmsight/model/b/g:frameRate	I
    //   426: i2f
    //   427: aload 5
    //   429: getfield 271	com/tencent/mm/plugin/mmsight/model/b/g:bitrate	I
    //   432: aload 5
    //   434: getfield 274	com/tencent/mm/plugin/mmsight/model/b/g:hCA	I
    //   437: bipush 8
    //   439: aload 5
    //   441: getfield 277	com/tencent/mm/plugin/mmsight/model/b/g:hCz	I
    //   444: ldc_w 278
    //   447: aload 5
    //   449: getfield 279	com/tencent/mm/plugin/mmsight/model/b/g:uNJ	I
    //   452: aload 5
    //   454: getfield 280	com/tencent/mm/plugin/mmsight/model/b/g:uNK	I
    //   457: invokestatic 284	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initH264EncoderLock	(IIFIIIIFII)I
    //   460: pop
    //   461: aload 5
    //   463: new 286	com/tencent/mm/plugin/mmsight/model/b/g$a
    //   466: dup
    //   467: aload 5
    //   469: iconst_0
    //   470: invokespecial 289	com/tencent/mm/plugin/mmsight/model/b/g$a:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/g;B)V
    //   473: putfield 293	com/tencent/mm/plugin/mmsight/model/b/g:uNS	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   476: getstatic 299	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   479: astore 6
    //   481: new 286	com/tencent/mm/plugin/mmsight/model/b/g$a
    //   484: dup
    //   485: aload 5
    //   487: iconst_0
    //   488: invokespecial 289	com/tencent/mm/plugin/mmsight/model/b/g$a:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/g;B)V
    //   491: astore 7
    //   493: aload 5
    //   495: aload 7
    //   497: putfield 293	com/tencent/mm/plugin/mmsight/model/b/g:uNS	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   500: aload 6
    //   502: aload 7
    //   504: invokeinterface 305 2 0
    //   509: pop
    //   510: aload 5
    //   512: iconst_0
    //   513: putfield 309	com/tencent/mm/plugin/mmsight/model/b/g:isStart	Z
    //   516: ldc_w 311
    //   519: ldc_w 313
    //   522: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_0
    //   526: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:uNA	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   529: invokeinterface 316 1 0
    //   534: aload_0
    //   535: getfield 181	com/tencent/mm/plugin/mmsight/model/b/c:uNI	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   538: astore 5
    //   540: aload 5
    //   542: getfield 293	com/tencent/mm/plugin/mmsight/model/b/g:uNS	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   545: ifnull +20 -> 565
    //   548: aload 5
    //   550: getfield 293	com/tencent/mm/plugin/mmsight/model/b/g:uNS	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   553: iconst_1
    //   554: putfield 319	com/tencent/mm/plugin/mmsight/model/b/g$a:icB	Z
    //   557: aload 5
    //   559: getfield 293	com/tencent/mm/plugin/mmsight/model/b/g:uNS	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   562: invokevirtual 322	com/tencent/mm/plugin/mmsight/model/b/g$a:fEw	()V
    //   565: aload_0
    //   566: new 324	com/tencent/mm/compatible/h/c
    //   569: dup
    //   570: invokespecial 325	com/tencent/mm/compatible/h/c:<init>	()V
    //   573: putfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   576: aload_0
    //   577: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   580: aload_0
    //   581: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   584: invokevirtual 331	com/tencent/mm/compatible/h/c:sI	(Ljava/lang/String;)V
    //   587: aconst_null
    //   588: astore 5
    //   590: iconst_0
    //   591: istore_1
    //   592: iload_1
    //   593: aload_0
    //   594: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   597: getfield 335	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   600: invokevirtual 340	android/media/MediaExtractor:getTrackCount	()I
    //   603: if_icmpge +518 -> 1121
    //   606: aload_0
    //   607: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   610: iload_1
    //   611: invokevirtual 344	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   614: astore 6
    //   616: aload 6
    //   618: ldc_w 346
    //   621: invokevirtual 352	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   624: astore 5
    //   626: aload 5
    //   628: ldc_w 354
    //   631: invokevirtual 359	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   634: ifeq +495 -> 1129
    //   637: iload_1
    //   638: iflt +144 -> 782
    //   641: aload 6
    //   643: ifnull +139 -> 782
    //   646: aload 5
    //   648: invokestatic 76	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   651: ifne +131 -> 782
    //   654: aload_0
    //   655: aload 6
    //   657: ldc_w 361
    //   660: invokevirtual 364	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   663: putfield 366	com/tencent/mm/plugin/mmsight/model/b/c:channelCount	I
    //   666: aload_0
    //   667: aload 6
    //   669: ldc_w 368
    //   672: invokevirtual 364	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   675: putfield 370	com/tencent/mm/plugin/mmsight/model/b/c:gOu	I
    //   678: aload_0
    //   679: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   682: iload_1
    //   683: invokevirtual 373	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   686: aload_0
    //   687: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   690: lconst_0
    //   691: lcmp
    //   692: ifle +19 -> 711
    //   695: aload_0
    //   696: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   699: aload_0
    //   700: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   703: ldc2_w 374
    //   706: lmul
    //   707: iconst_0
    //   708: invokevirtual 379	com/tencent/mm/compatible/h/c:seekTo	(JI)V
    //   711: aload 6
    //   713: ldc_w 381
    //   716: invokevirtual 364	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   719: invokestatic 387	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   722: astore 5
    //   724: aload 5
    //   726: invokevirtual 391	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   729: pop
    //   730: aload_0
    //   731: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   734: aload 5
    //   736: invokevirtual 395	com/tencent/mm/compatible/h/c:j	(Ljava/nio/ByteBuffer;)I
    //   739: istore_2
    //   740: ldc 78
    //   742: ldc_w 397
    //   745: iconst_1
    //   746: anewarray 82	java/lang/Object
    //   749: dup
    //   750: iconst_0
    //   751: iload_2
    //   752: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   755: aastore
    //   756: invokestatic 399	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: iload_2
    //   760: ifgt +280 -> 1040
    //   763: ldc 78
    //   765: ldc_w 401
    //   768: iconst_1
    //   769: anewarray 82	java/lang/Object
    //   772: dup
    //   773: iconst_0
    //   774: iload_2
    //   775: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   778: aastore
    //   779: invokestatic 147	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: aload_0
    //   783: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:outputFilePath	Ljava/lang/String;
    //   786: astore 6
    //   788: aload 6
    //   790: astore 5
    //   792: aload_0
    //   793: getfield 119	com/tencent/mm/plugin/mmsight/model/b/c:gTI	I
    //   796: ifle +26 -> 822
    //   799: new 403	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   806: aload 6
    //   808: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 410
    //   814: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 414	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: astore 5
    //   822: aload_0
    //   823: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   826: i2l
    //   827: lstore_3
    //   828: lload_3
    //   829: lconst_0
    //   830: lcmp
    //   831: ifgt +287 -> 1118
    //   834: aload_0
    //   835: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   838: aload_0
    //   839: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:gTJ	J
    //   842: lsub
    //   843: lstore_3
    //   844: aload_0
    //   845: getfield 370	com/tencent/mm/plugin/mmsight/model/b/c:gOu	I
    //   848: sipush 1024
    //   851: iconst_2
    //   852: aload_0
    //   853: getfield 366	com/tencent/mm/plugin/mmsight/model/b/c:channelCount	I
    //   856: aload 5
    //   858: aload_0
    //   859: getfield 181	com/tencent/mm/plugin/mmsight/model/b/c:uNI	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   862: getfield 261	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   865: i2f
    //   866: ldc 189
    //   868: fmul
    //   869: lload_3
    //   870: l2f
    //   871: fdiv
    //   872: lload_3
    //   873: l2i
    //   874: aconst_null
    //   875: iconst_0
    //   876: invokestatic 418	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264Lock	(IIIILjava/lang/String;FI[BI)I
    //   879: istore_1
    //   880: ldc 78
    //   882: ldc_w 420
    //   885: iconst_1
    //   886: anewarray 82	java/lang/Object
    //   889: dup
    //   890: iconst_0
    //   891: iload_1
    //   892: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   895: aastore
    //   896: invokestatic 147	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   899: aload_0
    //   900: getfield 119	com/tencent/mm/plugin/mmsight/model/b/c:gTI	I
    //   903: ifle +23 -> 926
    //   906: aload 5
    //   908: aload_0
    //   909: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:outputFilePath	Ljava/lang/String;
    //   912: aload_0
    //   913: getfield 119	com/tencent/mm/plugin/mmsight/model/b/c:gTI	I
    //   916: invokestatic 424	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideoVFS	(Ljava/lang/String;Ljava/lang/String;I)I
    //   919: pop
    //   920: aload 5
    //   922: invokestatic 429	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   925: pop
    //   926: aload_0
    //   927: getfield 203	com/tencent/mm/plugin/mmsight/model/b/c:gNJ	I
    //   930: invokestatic 226	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   933: getstatic 435	com/tencent/mm/plugin/mmsight/model/a/j:uMV	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   936: invokevirtual 438	com/tencent/mm/plugin/mmsight/model/a/j:avJ	()V
    //   939: ldc 188
    //   941: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   944: iload_1
    //   945: ireturn
    //   946: aload_0
    //   947: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   950: istore_1
    //   951: goto -612 -> 339
    //   954: astore 5
    //   956: ldc_w 311
    //   959: aload 5
    //   961: ldc_w 440
    //   964: iconst_1
    //   965: anewarray 82	java/lang/Object
    //   968: dup
    //   969: iconst_0
    //   970: aload 5
    //   972: invokevirtual 443	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   975: aastore
    //   976: invokestatic 447	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   979: goto -414 -> 565
    //   982: astore 5
    //   984: ldc 78
    //   986: aload 5
    //   988: ldc_w 449
    //   991: iconst_1
    //   992: anewarray 82	java/lang/Object
    //   995: dup
    //   996: iconst_0
    //   997: aload 5
    //   999: invokevirtual 443	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1002: aastore
    //   1003: invokestatic 447	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1006: ldc 188
    //   1008: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1011: iconst_m1
    //   1012: ireturn
    //   1013: astore 5
    //   1015: ldc 78
    //   1017: aload 5
    //   1019: ldc_w 451
    //   1022: iconst_1
    //   1023: anewarray 82	java/lang/Object
    //   1026: dup
    //   1027: iconst_0
    //   1028: aload 5
    //   1030: invokevirtual 452	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1033: aastore
    //   1034: invokestatic 447	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1037: goto -255 -> 782
    //   1040: aload_0
    //   1041: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   1044: getfield 335	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   1047: invokevirtual 456	android/media/MediaExtractor:getSampleTime	()J
    //   1050: aload_0
    //   1051: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   1054: ldc2_w 374
    //   1057: lmul
    //   1058: lcmp
    //   1059: ifge -277 -> 782
    //   1062: aload_0
    //   1063: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   1066: getfield 335	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   1069: invokevirtual 459	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   1072: iload_1
    //   1073: if_icmpeq +14 -> 1087
    //   1076: ldc 78
    //   1078: ldc_w 461
    //   1081: invokestatic 463	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1084: goto -302 -> 782
    //   1087: aload 5
    //   1089: iconst_0
    //   1090: invokevirtual 467	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1093: pop
    //   1094: aload_0
    //   1095: getfield 203	com/tencent/mm/plugin/mmsight/model/b/c:gNJ	I
    //   1098: aload 5
    //   1100: iload_2
    //   1101: invokestatic 471	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:writeAACDataLock	(ILjava/nio/ByteBuffer;I)V
    //   1104: aload_0
    //   1105: getfield 327	com/tencent/mm/plugin/mmsight/model/b/c:cSi	Lcom/tencent/mm/compatible/h/c;
    //   1108: getfield 335	com/tencent/mm/compatible/h/c:fKr	Landroid/media/MediaExtractor;
    //   1111: invokevirtual 475	android/media/MediaExtractor:advance	()Z
    //   1114: pop
    //   1115: goto -391 -> 724
    //   1118: goto -274 -> 844
    //   1121: aconst_null
    //   1122: astore 6
    //   1124: iconst_m1
    //   1125: istore_1
    //   1126: goto -489 -> 637
    //   1129: iload_1
    //   1130: iconst_1
    //   1131: iadd
    //   1132: istore_1
    //   1133: goto -541 -> 592
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1136	0	this	c
    //   18	1115	1	i	int
    //   16	1085	2	j	int
    //   827	46	3	l	long
    //   403	518	5	localObject1	Object
    //   954	17	5	localException1	java.lang.Exception
    //   982	16	5	localException2	java.lang.Exception
    //   1013	86	5	localIOException	java.io.IOException
    //   479	644	6	localObject2	Object
    //   491	12	7	locala	g.a
    // Exception table:
    //   from	to	target	type
    //   557	565	954	java/lang/Exception
    //   525	557	982	java/lang/Exception
    //   565	576	982	java/lang/Exception
    //   576	587	982	java/lang/Exception
    //   592	637	982	java/lang/Exception
    //   646	711	982	java/lang/Exception
    //   711	724	982	java/lang/Exception
    //   724	759	982	java/lang/Exception
    //   763	782	982	java/lang/Exception
    //   782	788	982	java/lang/Exception
    //   792	822	982	java/lang/Exception
    //   822	828	982	java/lang/Exception
    //   834	844	982	java/lang/Exception
    //   844	926	982	java/lang/Exception
    //   926	939	982	java/lang/Exception
    //   956	979	982	java/lang/Exception
    //   1015	1037	982	java/lang/Exception
    //   1040	1084	982	java/lang/Exception
    //   1087	1115	982	java/lang/Exception
    //   576	587	1013	java/io/IOException
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void y(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.gSY = paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.c
 * JD-Core Version:    0.7.0.1
 */