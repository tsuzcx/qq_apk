package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private int awU;
  private MediaExtractor cfO;
  private int eRG;
  private int eRm;
  private int eVA;
  private Bitmap eVZ;
  private int eWJ;
  private int eWK;
  private int eWL;
  private long eWM;
  private long eWN;
  private String eXn;
  private int eXo;
  private int eXp;
  private int eXq;
  private int eXu;
  private Point fZm;
  private String filePath;
  private a oJU;
  private byte[] oJY;
  private byte[] oJZ;
  private a.a oKa;
  private g oKc;
  private int oKd;
  private int oKe;
  private int videoFps;
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(140135);
    this.eVA = -1;
    this.eWM = -1L;
    this.eWN = -1L;
    this.eXu = -1;
    this.fZm = null;
    this.oJY = null;
    this.oJZ = null;
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(140135);
      return;
    }
    this.filePath = paramString1;
    this.eXn = paramString2;
    this.eXo = paramInt1;
    this.eXp = paramInt2;
    this.eXq = paramInt3;
    this.eXu = paramInt4;
    this.oKd = paramInt5;
    this.oKe = paramInt6;
    this.eWL = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = d.Zo(paramString1);
    if (locala != null)
    {
      this.eWJ = locala.width;
      this.eWK = locala.height;
      this.eVA = locala.eVA;
      this.videoFps = locala.eRw;
    }
    this.eWM = 0L;
    this.eWN = this.eVA;
    ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.eWJ), Integer.valueOf(this.eWK), Integer.valueOf(this.eWL), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(140135);
  }
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(140136);
    this.eVA = -1;
    this.eWM = -1L;
    this.eWN = -1L;
    this.eXu = -1;
    this.fZm = null;
    this.oJY = null;
    this.oJZ = null;
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(140136);
      return;
    }
    this.filePath = paramString1;
    this.eXn = paramString2;
    this.eXo = paramInt1;
    this.eXp = paramInt2;
    this.eXq = paramInt3;
    this.eXu = paramInt4;
    this.oKd = paramInt5;
    this.oKe = paramInt6;
    this.eWL = SightVideoJNI.getMp4Rotate(paramString1);
    com.tencent.mm.plugin.sight.base.a locala = d.Zo(paramString1);
    if (locala != null)
    {
      this.eWJ = locala.width;
      this.eWK = locala.height;
      this.videoFps = locala.eRw;
    }
    this.eWM = paramLong1;
    this.eWN = paramLong2;
    ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.eWJ), Integer.valueOf(this.eWK), Integer.valueOf(this.eWL), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(140136);
  }
  
  /* Error */
  public final int Va()
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 54	com/tencent/mm/plugin/mmsight/model/b/c:eVA	I
    //   9: i2f
    //   10: ldc 187
    //   12: fdiv
    //   13: invokestatic 193	java/lang/Math:round	(F)I
    //   16: istore_2
    //   17: iload_2
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   23: lconst_0
    //   24: lcmp
    //   25: iflt +33 -> 58
    //   28: iload_2
    //   29: istore_1
    //   30: aload_0
    //   31: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:eWN	J
    //   34: lconst_0
    //   35: lcmp
    //   36: iflt +22 -> 58
    //   39: aload_0
    //   40: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:eWN	J
    //   43: aload_0
    //   44: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   47: lsub
    //   48: l2f
    //   49: ldc 187
    //   51: fdiv
    //   52: invokestatic 193	java/lang/Math:round	(F)I
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: aload_0
    //   59: iload_1
    //   60: invokestatic 199	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBufLock	(I)I
    //   63: putfield 201	com/tencent/mm/plugin/mmsight/model/b/c:eRm	I
    //   66: aload_0
    //   67: getfield 97	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   70: invokestatic 206	com/tencent/mm/bj/e:vB	(Ljava/lang/String;)Z
    //   73: ifeq +88 -> 161
    //   76: ldc 76
    //   78: ldc 208
    //   80: invokestatic 211	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: new 213	com/tencent/mm/plugin/mmsight/model/b/e
    //   87: dup
    //   88: invokespecial 214	com/tencent/mm/plugin/mmsight/model/b/e:<init>	()V
    //   91: putfield 166	com/tencent/mm/plugin/mmsight/model/b/c:oJU	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   94: aload_0
    //   95: getfield 54	com/tencent/mm/plugin/mmsight/model/b/c:eVA	I
    //   98: ifle +77 -> 175
    //   101: aload_0
    //   102: getfield 166	com/tencent/mm/plugin/mmsight/model/b/c:oJU	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   105: aload_0
    //   106: getfield 97	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   109: lconst_0
    //   110: aload_0
    //   111: getfield 54	com/tencent/mm/plugin/mmsight/model/b/c:eVA	I
    //   114: i2l
    //   115: aload_0
    //   116: getfield 141	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   119: invokeinterface 219 7 0
    //   124: istore_1
    //   125: ldc 76
    //   127: ldc 221
    //   129: iconst_1
    //   130: anewarray 80	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: iload_1
    //   136: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: iload_1
    //   144: ifge +133 -> 277
    //   147: aload_0
    //   148: getfield 201	com/tencent/mm/plugin/mmsight/model/b/c:eRm	I
    //   151: invokestatic 224	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   154: ldc 186
    //   156: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iconst_m1
    //   160: ireturn
    //   161: aload_0
    //   162: new 226	com/tencent/mm/plugin/mmsight/model/b/d
    //   165: dup
    //   166: invokespecial 227	com/tencent/mm/plugin/mmsight/model/b/d:<init>	()V
    //   169: putfield 166	com/tencent/mm/plugin/mmsight/model/b/c:oJU	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   172: goto -78 -> 94
    //   175: aload_0
    //   176: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   179: lconst_0
    //   180: lcmp
    //   181: iflt +41 -> 222
    //   184: aload_0
    //   185: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:eWN	J
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt +32 -> 222
    //   193: aload_0
    //   194: getfield 166	com/tencent/mm/plugin/mmsight/model/b/c:oJU	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   197: aload_0
    //   198: getfield 97	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   205: aload_0
    //   206: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:eWN	J
    //   209: aload_0
    //   210: getfield 141	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   213: invokeinterface 219 7 0
    //   218: istore_1
    //   219: goto -94 -> 125
    //   222: ldc 76
    //   224: ldc 229
    //   226: iconst_3
    //   227: anewarray 80	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_0
    //   233: getfield 54	com/tencent/mm/plugin/mmsight/model/b/c:eVA	I
    //   236: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_0
    //   243: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   246: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: aastore
    //   250: dup
    //   251: iconst_2
    //   252: aload_0
    //   253: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:eWN	J
    //   256: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   259: aastore
    //   260: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 201	com/tencent/mm/plugin/mmsight/model/b/c:eRm	I
    //   267: invokestatic 224	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   270: ldc 186
    //   272: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iconst_m1
    //   276: ireturn
    //   277: aload_0
    //   278: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:eXu	I
    //   281: ifle +39 -> 320
    //   284: aload_0
    //   285: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:eXu	I
    //   288: aload_0
    //   289: getfield 141	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   292: if_icmpge +28 -> 320
    //   295: aload_0
    //   296: getfield 166	com/tencent/mm/plugin/mmsight/model/b/c:oJU	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   299: aload_0
    //   300: getfield 141	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   303: i2f
    //   304: aload_0
    //   305: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:eXu	I
    //   308: i2f
    //   309: fdiv
    //   310: f2d
    //   311: invokestatic 233	java/lang/Math:ceil	(D)D
    //   314: d2i
    //   315: invokeinterface 236 2 0
    //   320: aload_0
    //   321: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:eXu	I
    //   324: ifle +632 -> 956
    //   327: aload_0
    //   328: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:eXu	I
    //   331: aload_0
    //   332: getfield 141	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   335: invokestatic 240	java/lang/Math:min	(II)I
    //   338: istore_1
    //   339: aload_0
    //   340: getfield 166	com/tencent/mm/plugin/mmsight/model/b/c:oJU	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   343: new 242	com/tencent/mm/plugin/mmsight/model/b/c$1
    //   346: dup
    //   347: aload_0
    //   348: invokespecial 245	com/tencent/mm/plugin/mmsight/model/b/c$1:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/c;)V
    //   351: invokeinterface 248 2 0
    //   356: aload_0
    //   357: new 250	com/tencent/mm/plugin/mmsight/model/b/g
    //   360: dup
    //   361: aload_0
    //   362: getfield 130	com/tencent/mm/plugin/mmsight/model/b/c:eWJ	I
    //   365: aload_0
    //   366: getfield 135	com/tencent/mm/plugin/mmsight/model/b/c:eWK	I
    //   369: aload_0
    //   370: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:eXo	I
    //   373: aload_0
    //   374: getfield 103	com/tencent/mm/plugin/mmsight/model/b/c:eXp	I
    //   377: aload_0
    //   378: getfield 105	com/tencent/mm/plugin/mmsight/model/b/c:eXq	I
    //   381: iload_1
    //   382: getstatic 255	com/tencent/mm/plugin/sight/base/b:qSp	I
    //   385: aload_0
    //   386: getfield 107	com/tencent/mm/plugin/mmsight/model/b/c:oKd	I
    //   389: aload_0
    //   390: getfield 109	com/tencent/mm/plugin/mmsight/model/b/c:oKe	I
    //   393: invokespecial 258	com/tencent/mm/plugin/mmsight/model/b/g:<init>	(IIIIIIIII)V
    //   396: putfield 179	com/tencent/mm/plugin/mmsight/model/b/c:oKc	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   399: aload_0
    //   400: getfield 179	com/tencent/mm/plugin/mmsight/model/b/c:oKc	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   403: astore 5
    //   405: aload 5
    //   407: iconst_0
    //   408: putfield 261	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   411: aload 5
    //   413: getfield 264	com/tencent/mm/plugin/mmsight/model/b/g:eRu	I
    //   416: aload 5
    //   418: getfield 267	com/tencent/mm/plugin/mmsight/model/b/g:eRv	I
    //   421: aload 5
    //   423: getfield 268	com/tencent/mm/plugin/mmsight/model/b/g:eRw	I
    //   426: i2f
    //   427: aload 5
    //   429: getfield 271	com/tencent/mm/plugin/mmsight/model/b/g:bitrate	I
    //   432: aload 5
    //   434: getfield 274	com/tencent/mm/plugin/mmsight/model/b/g:fzW	I
    //   437: bipush 8
    //   439: aload 5
    //   441: getfield 277	com/tencent/mm/plugin/mmsight/model/b/g:fzV	I
    //   444: ldc_w 278
    //   447: aload 5
    //   449: getfield 279	com/tencent/mm/plugin/mmsight/model/b/g:oKd	I
    //   452: aload 5
    //   454: getfield 280	com/tencent/mm/plugin/mmsight/model/b/g:oKe	I
    //   457: invokestatic 284	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initH264EncoderLock	(IIFIIIIFII)I
    //   460: pop
    //   461: aload 5
    //   463: new 286	com/tencent/mm/plugin/mmsight/model/b/g$a
    //   466: dup
    //   467: aload 5
    //   469: iconst_0
    //   470: invokespecial 289	com/tencent/mm/plugin/mmsight/model/b/g$a:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/g;B)V
    //   473: putfield 293	com/tencent/mm/plugin/mmsight/model/b/g:oKm	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   476: aload 5
    //   478: aload 5
    //   480: getfield 293	com/tencent/mm/plugin/mmsight/model/b/g:oKm	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   483: ldc_w 295
    //   486: invokestatic 301	com/tencent/mm/sdk/g/d:h	(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   489: putfield 305	com/tencent/mm/plugin/mmsight/model/b/g:eUH	Ljava/lang/Thread;
    //   492: aload 5
    //   494: getfield 305	com/tencent/mm/plugin/mmsight/model/b/g:eUH	Ljava/lang/Thread;
    //   497: invokevirtual 310	java/lang/Thread:start	()V
    //   500: aload 5
    //   502: iconst_0
    //   503: putfield 314	com/tencent/mm/plugin/mmsight/model/b/g:isStart	Z
    //   506: ldc_w 316
    //   509: ldc_w 318
    //   512: invokestatic 211	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload_0
    //   516: getfield 166	com/tencent/mm/plugin/mmsight/model/b/c:oJU	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   519: invokeinterface 321 1 0
    //   524: aload_0
    //   525: getfield 179	com/tencent/mm/plugin/mmsight/model/b/c:oKc	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   528: astore 5
    //   530: aload 5
    //   532: getfield 293	com/tencent/mm/plugin/mmsight/model/b/g:oKm	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   535: ifnull +42 -> 577
    //   538: aload 5
    //   540: getfield 305	com/tencent/mm/plugin/mmsight/model/b/g:eUH	Ljava/lang/Thread;
    //   543: ifnull +34 -> 577
    //   546: aload 5
    //   548: getfield 293	com/tencent/mm/plugin/mmsight/model/b/g:oKm	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   551: iconst_1
    //   552: putfield 324	com/tencent/mm/plugin/mmsight/model/b/g$a:fZn	Z
    //   555: aload 5
    //   557: getfield 305	com/tencent/mm/plugin/mmsight/model/b/g:eUH	Ljava/lang/Thread;
    //   560: invokevirtual 327	java/lang/Thread:join	()V
    //   563: getstatic 331	com/tencent/mm/sdk/g/d:ysm	Lcom/tencent/mm/sdk/g/a/e;
    //   566: aload 5
    //   568: getfield 293	com/tencent/mm/plugin/mmsight/model/b/g:oKm	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   571: invokeinterface 337 2 0
    //   576: pop
    //   577: aload_0
    //   578: new 339	android/media/MediaExtractor
    //   581: dup
    //   582: invokespecial 340	android/media/MediaExtractor:<init>	()V
    //   585: putfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   588: aload_0
    //   589: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   592: aload_0
    //   593: getfield 97	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   596: invokevirtual 346	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   599: aconst_null
    //   600: astore 5
    //   602: iconst_0
    //   603: istore_1
    //   604: iload_1
    //   605: aload_0
    //   606: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   609: invokevirtual 349	android/media/MediaExtractor:getTrackCount	()I
    //   612: if_icmpge +510 -> 1122
    //   615: aload_0
    //   616: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   619: iload_1
    //   620: invokevirtual 353	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   623: astore 6
    //   625: aload 6
    //   627: ldc_w 355
    //   630: invokevirtual 361	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   633: astore 5
    //   635: aload 5
    //   637: ldc_w 363
    //   640: invokevirtual 368	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   643: ifeq +487 -> 1130
    //   646: iload_1
    //   647: iflt +145 -> 792
    //   650: aload 6
    //   652: ifnull +140 -> 792
    //   655: aload 5
    //   657: invokestatic 74	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   660: ifne +132 -> 792
    //   663: aload_0
    //   664: aload 6
    //   666: ldc_w 370
    //   669: invokevirtual 373	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   672: putfield 375	com/tencent/mm/plugin/mmsight/model/b/c:awU	I
    //   675: aload_0
    //   676: aload 6
    //   678: ldc_w 377
    //   681: invokevirtual 373	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   684: putfield 379	com/tencent/mm/plugin/mmsight/model/b/c:eRG	I
    //   687: aload_0
    //   688: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   691: iload_1
    //   692: invokevirtual 382	android/media/MediaExtractor:selectTrack	(I)V
    //   695: aload_0
    //   696: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   699: lconst_0
    //   700: lcmp
    //   701: ifle +19 -> 720
    //   704: aload_0
    //   705: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   708: aload_0
    //   709: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   712: ldc2_w 383
    //   715: lmul
    //   716: iconst_0
    //   717: invokevirtual 388	android/media/MediaExtractor:seekTo	(JI)V
    //   720: aload 6
    //   722: ldc_w 390
    //   725: invokevirtual 373	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   728: invokestatic 396	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   731: astore 5
    //   733: aload 5
    //   735: invokevirtual 400	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   738: pop
    //   739: aload_0
    //   740: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   743: aload 5
    //   745: iconst_0
    //   746: invokevirtual 404	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   749: istore_2
    //   750: ldc 76
    //   752: ldc_w 406
    //   755: iconst_1
    //   756: anewarray 80	java/lang/Object
    //   759: dup
    //   760: iconst_0
    //   761: iload_2
    //   762: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   765: aastore
    //   766: invokestatic 408	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   769: iload_2
    //   770: ifgt +280 -> 1050
    //   773: ldc 76
    //   775: ldc_w 410
    //   778: iconst_1
    //   779: anewarray 80	java/lang/Object
    //   782: dup
    //   783: iconst_0
    //   784: iload_2
    //   785: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: aastore
    //   789: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   792: aload_0
    //   793: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:eXn	Ljava/lang/String;
    //   796: astore 6
    //   798: aload 6
    //   800: astore 5
    //   802: aload_0
    //   803: getfield 117	com/tencent/mm/plugin/mmsight/model/b/c:eWL	I
    //   806: ifle +26 -> 832
    //   809: new 412	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   816: aload 6
    //   818: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: ldc_w 419
    //   824: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: astore 5
    //   832: aload_0
    //   833: getfield 54	com/tencent/mm/plugin/mmsight/model/b/c:eVA	I
    //   836: i2l
    //   837: lstore_3
    //   838: lload_3
    //   839: lconst_0
    //   840: lcmp
    //   841: ifgt +278 -> 1119
    //   844: aload_0
    //   845: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:eWN	J
    //   848: aload_0
    //   849: getfield 58	com/tencent/mm/plugin/mmsight/model/b/c:eWM	J
    //   852: lsub
    //   853: lstore_3
    //   854: aload_0
    //   855: getfield 379	com/tencent/mm/plugin/mmsight/model/b/c:eRG	I
    //   858: sipush 1024
    //   861: iconst_2
    //   862: aload_0
    //   863: getfield 375	com/tencent/mm/plugin/mmsight/model/b/c:awU	I
    //   866: aload 5
    //   868: aload_0
    //   869: getfield 179	com/tencent/mm/plugin/mmsight/model/b/c:oKc	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   872: getfield 261	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   875: i2f
    //   876: ldc 187
    //   878: fmul
    //   879: lload_3
    //   880: l2f
    //   881: fdiv
    //   882: lload_3
    //   883: l2i
    //   884: aconst_null
    //   885: iconst_0
    //   886: invokestatic 427	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264Lock	(IIIILjava/lang/String;FI[BI)I
    //   889: istore_1
    //   890: ldc 76
    //   892: ldc_w 429
    //   895: iconst_1
    //   896: anewarray 80	java/lang/Object
    //   899: dup
    //   900: iconst_0
    //   901: iload_1
    //   902: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   905: aastore
    //   906: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   909: aload_0
    //   910: getfield 117	com/tencent/mm/plugin/mmsight/model/b/c:eWL	I
    //   913: ifle +23 -> 936
    //   916: aload 5
    //   918: aload_0
    //   919: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:eXn	Ljava/lang/String;
    //   922: aload_0
    //   923: getfield 117	com/tencent/mm/plugin/mmsight/model/b/c:eWL	I
    //   926: invokestatic 433	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideo	(Ljava/lang/String;Ljava/lang/String;I)I
    //   929: pop
    //   930: aload 5
    //   932: invokestatic 438	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   935: pop
    //   936: aload_0
    //   937: getfield 201	com/tencent/mm/plugin/mmsight/model/b/c:eRm	I
    //   940: invokestatic 224	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   943: getstatic 444	com/tencent/mm/plugin/mmsight/model/a/j:oJp	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   946: invokevirtual 447	com/tencent/mm/plugin/mmsight/model/a/j:XJ	()V
    //   949: ldc 186
    //   951: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   954: iload_1
    //   955: ireturn
    //   956: aload_0
    //   957: getfield 141	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   960: istore_1
    //   961: goto -622 -> 339
    //   964: astore 5
    //   966: ldc_w 316
    //   969: aload 5
    //   971: ldc_w 449
    //   974: iconst_1
    //   975: anewarray 80	java/lang/Object
    //   978: dup
    //   979: iconst_0
    //   980: aload 5
    //   982: invokevirtual 452	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   985: aastore
    //   986: invokestatic 456	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   989: goto -412 -> 577
    //   992: astore 5
    //   994: ldc 76
    //   996: aload 5
    //   998: ldc_w 458
    //   1001: iconst_1
    //   1002: anewarray 80	java/lang/Object
    //   1005: dup
    //   1006: iconst_0
    //   1007: aload 5
    //   1009: invokevirtual 452	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1012: aastore
    //   1013: invokestatic 456	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: ldc 186
    //   1018: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1021: iconst_m1
    //   1022: ireturn
    //   1023: astore 5
    //   1025: ldc 76
    //   1027: aload 5
    //   1029: ldc_w 460
    //   1032: iconst_1
    //   1033: anewarray 80	java/lang/Object
    //   1036: dup
    //   1037: iconst_0
    //   1038: aload 5
    //   1040: invokevirtual 461	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1043: aastore
    //   1044: invokestatic 456	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1047: goto -255 -> 792
    //   1050: aload_0
    //   1051: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   1054: invokevirtual 465	android/media/MediaExtractor:getSampleTime	()J
    //   1057: aload_0
    //   1058: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:eWN	J
    //   1061: ldc2_w 383
    //   1064: lmul
    //   1065: lcmp
    //   1066: ifge -274 -> 792
    //   1069: aload_0
    //   1070: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   1073: invokevirtual 468	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   1076: iload_1
    //   1077: if_icmpeq +14 -> 1091
    //   1080: ldc 76
    //   1082: ldc_w 470
    //   1085: invokestatic 472	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1088: goto -296 -> 792
    //   1091: aload 5
    //   1093: iconst_0
    //   1094: invokevirtual 476	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1097: pop
    //   1098: aload_0
    //   1099: getfield 201	com/tencent/mm/plugin/mmsight/model/b/c:eRm	I
    //   1102: aload 5
    //   1104: iload_2
    //   1105: invokestatic 480	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:writeAACDataLock	(ILjava/nio/ByteBuffer;I)V
    //   1108: aload_0
    //   1109: getfield 342	com/tencent/mm/plugin/mmsight/model/b/c:cfO	Landroid/media/MediaExtractor;
    //   1112: invokevirtual 484	android/media/MediaExtractor:advance	()Z
    //   1115: pop
    //   1116: goto -383 -> 733
    //   1119: goto -265 -> 854
    //   1122: aconst_null
    //   1123: astore 6
    //   1125: iconst_m1
    //   1126: istore_1
    //   1127: goto -481 -> 646
    //   1130: iload_1
    //   1131: iconst_1
    //   1132: iadd
    //   1133: istore_1
    //   1134: goto -530 -> 604
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	this	c
    //   18	1116	1	i	int
    //   16	1089	2	j	int
    //   837	46	3	l	long
    //   403	528	5	localObject1	Object
    //   964	17	5	localException1	java.lang.Exception
    //   992	16	5	localException2	java.lang.Exception
    //   1023	80	5	localIOException	java.io.IOException
    //   623	501	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   555	577	964	java/lang/Exception
    //   515	555	992	java/lang/Exception
    //   577	588	992	java/lang/Exception
    //   588	599	992	java/lang/Exception
    //   604	646	992	java/lang/Exception
    //   655	720	992	java/lang/Exception
    //   720	733	992	java/lang/Exception
    //   733	769	992	java/lang/Exception
    //   773	792	992	java/lang/Exception
    //   792	798	992	java/lang/Exception
    //   802	832	992	java/lang/Exception
    //   832	838	992	java/lang/Exception
    //   844	854	992	java/lang/Exception
    //   854	936	992	java/lang/Exception
    //   936	949	992	java/lang/Exception
    //   966	989	992	java/lang/Exception
    //   1025	1047	992	java/lang/Exception
    //   1050	1088	992	java/lang/Exception
    //   1091	1116	992	java/lang/Exception
    //   588	599	1023	java/io/IOException
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void p(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.eVZ = paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.c
 * JD-Core Version:    0.7.0.1
 */