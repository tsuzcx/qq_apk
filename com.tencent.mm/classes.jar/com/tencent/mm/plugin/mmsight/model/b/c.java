package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class c
  extends com.tencent.mm.plugin.mmsight.api.a
{
  private a KXR;
  private byte[] KXV;
  private byte[] KXW;
  private a.a KXX;
  private g KXZ;
  private int KYa;
  private int KYb;
  private int bufId;
  private int channelCount;
  private String filePath;
  private int inputHeight;
  private int inputWidth;
  private int nBU;
  private int nBY;
  private Bitmap nBq;
  private long nBy;
  private int nCg;
  private int nyB;
  private String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private com.tencent.mm.compatible.i.c pcp;
  private Point pde;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89613);
    this.videoDuration = -1;
    this.nBy = -1L;
    this.remuxEndTime = -1L;
    this.nBY = -1;
    this.pde = null;
    this.KXV = null;
    this.KXW = null;
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89613);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    this.nBU = paramInt3;
    this.nBY = paramInt4;
    this.KYa = paramInt5;
    this.KYb = paramInt6;
    this.nCg = SightVideoJNI.getMp4RotateVFS(paramString1);
    b localb = f.aVX(paramString1);
    if (localb != null)
    {
      this.inputWidth = localb.width;
      this.inputHeight = localb.height;
      this.videoDuration = localb.videoDuration;
      this.videoFps = localb.frameRate;
    }
    this.nBy = 0L;
    this.remuxEndTime = this.videoDuration;
    Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.inputWidth), Integer.valueOf(this.inputHeight), Integer.valueOf(this.nCg), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(89613);
  }
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(89614);
    this.videoDuration = -1;
    this.nBy = -1L;
    this.remuxEndTime = -1L;
    this.nBY = -1;
    this.pde = null;
    this.KXV = null;
    this.KXW = null;
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      Log.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(89614);
      return;
    }
    this.filePath = paramString1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    this.nBU = paramInt3;
    this.nBY = paramInt4;
    this.KYa = paramInt5;
    this.KYb = paramInt6;
    this.nCg = SightVideoJNI.getMp4RotateVFS(paramString1);
    b localb = f.aVX(paramString1);
    if (localb != null)
    {
      this.inputWidth = localb.width;
      this.inputHeight = localb.height;
      this.videoFps = localb.frameRate;
    }
    this.nBy = paramLong1;
    this.remuxEndTime = paramLong2;
    Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[] { paramString1, paramString2, Integer.valueOf(this.inputWidth), Integer.valueOf(this.inputHeight), Integer.valueOf(this.nCg), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(89614);
  }
  
  public final void I(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.nBq = paramBitmap;
    }
  }
  
  /* Error */
  public final int bpE()
  {
    // Byte code:
    //   0: ldc 189
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   9: i2f
    //   10: ldc 190
    //   12: fdiv
    //   13: invokestatic 196	java/lang/Math:round	(F)I
    //   16: istore_2
    //   17: iload_2
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
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
    //   44: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
    //   47: lsub
    //   48: l2f
    //   49: ldc 190
    //   51: fdiv
    //   52: invokestatic 196	java/lang/Math:round	(F)I
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: aload_0
    //   59: iload_1
    //   60: invokestatic 202	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initDataBufLock	(I)I
    //   63: putfield 204	com/tencent/mm/plugin/mmsight/model/b/c:bufId	I
    //   66: aload_0
    //   67: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   70: invokestatic 209	com/tencent/mm/be/e:Qy	(Ljava/lang/String;)Z
    //   73: ifeq +88 -> 161
    //   76: ldc 78
    //   78: ldc 211
    //   80: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: new 216	com/tencent/mm/plugin/mmsight/model/b/e
    //   87: dup
    //   88: invokespecial 217	com/tencent/mm/plugin/mmsight/model/b/e:<init>	()V
    //   91: putfield 168	com/tencent/mm/plugin/mmsight/model/b/c:KXR	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   94: aload_0
    //   95: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   98: ifle +77 -> 175
    //   101: aload_0
    //   102: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:KXR	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   105: aload_0
    //   106: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   109: lconst_0
    //   110: aload_0
    //   111: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   114: i2l
    //   115: aload_0
    //   116: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   119: invokeinterface 222 7 0
    //   124: istore_1
    //   125: ldc 78
    //   127: ldc 224
    //   129: iconst_1
    //   130: anewarray 82	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: iload_1
    //   136: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: iload_1
    //   144: ifge +133 -> 277
    //   147: aload_0
    //   148: getfield 204	com/tencent/mm/plugin/mmsight/model/b/c:bufId	I
    //   151: invokestatic 227	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   154: ldc 189
    //   156: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iconst_m1
    //   160: ireturn
    //   161: aload_0
    //   162: new 229	com/tencent/mm/plugin/mmsight/model/b/d
    //   165: dup
    //   166: invokespecial 230	com/tencent/mm/plugin/mmsight/model/b/d:<init>	()V
    //   169: putfield 168	com/tencent/mm/plugin/mmsight/model/b/c:KXR	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   172: goto -78 -> 94
    //   175: aload_0
    //   176: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
    //   179: lconst_0
    //   180: lcmp
    //   181: iflt +41 -> 222
    //   184: aload_0
    //   185: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt +32 -> 222
    //   193: aload_0
    //   194: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:KXR	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   197: aload_0
    //   198: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   201: aload_0
    //   202: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
    //   205: aload_0
    //   206: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   209: aload_0
    //   210: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   213: invokeinterface 222 7 0
    //   218: istore_1
    //   219: goto -94 -> 125
    //   222: ldc 78
    //   224: ldc 232
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
    //   243: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
    //   246: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: aastore
    //   250: dup
    //   251: iconst_2
    //   252: aload_0
    //   253: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   256: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   259: aastore
    //   260: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 204	com/tencent/mm/plugin/mmsight/model/b/c:bufId	I
    //   267: invokestatic 227	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   270: ldc 189
    //   272: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iconst_m1
    //   276: ireturn
    //   277: aload_0
    //   278: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:nBY	I
    //   281: ifle +39 -> 320
    //   284: aload_0
    //   285: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:nBY	I
    //   288: aload_0
    //   289: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   292: if_icmpge +28 -> 320
    //   295: aload_0
    //   296: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:KXR	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   299: aload_0
    //   300: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   303: i2f
    //   304: aload_0
    //   305: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:nBY	I
    //   308: i2f
    //   309: fdiv
    //   310: f2d
    //   311: invokestatic 236	java/lang/Math:ceil	(D)D
    //   314: d2i
    //   315: invokeinterface 239 2 0
    //   320: aload_0
    //   321: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:nBY	I
    //   324: ifle +623 -> 947
    //   327: aload_0
    //   328: getfield 64	com/tencent/mm/plugin/mmsight/model/b/c:nBY	I
    //   331: aload_0
    //   332: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   335: invokestatic 243	java/lang/Math:min	(II)I
    //   338: istore_1
    //   339: aload_0
    //   340: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:KXR	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   343: new 6	com/tencent/mm/plugin/mmsight/model/b/c$1
    //   346: dup
    //   347: aload_0
    //   348: invokespecial 246	com/tencent/mm/plugin/mmsight/model/b/c$1:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/c;)V
    //   351: invokeinterface 249 2 0
    //   356: aload_0
    //   357: new 251	com/tencent/mm/plugin/mmsight/model/b/g
    //   360: dup
    //   361: aload_0
    //   362: getfield 132	com/tencent/mm/plugin/mmsight/model/b/c:inputWidth	I
    //   365: aload_0
    //   366: getfield 137	com/tencent/mm/plugin/mmsight/model/b/c:inputHeight	I
    //   369: aload_0
    //   370: getfield 103	com/tencent/mm/plugin/mmsight/model/b/c:outputWidth	I
    //   373: aload_0
    //   374: getfield 105	com/tencent/mm/plugin/mmsight/model/b/c:outputHeight	I
    //   377: aload_0
    //   378: getfield 107	com/tencent/mm/plugin/mmsight/model/b/c:nBU	I
    //   381: iload_1
    //   382: getstatic 256	com/tencent/mm/plugin/sight/base/d:PFj	I
    //   385: aload_0
    //   386: getfield 109	com/tencent/mm/plugin/mmsight/model/b/c:KYa	I
    //   389: aload_0
    //   390: getfield 111	com/tencent/mm/plugin/mmsight/model/b/c:KYb	I
    //   393: invokespecial 259	com/tencent/mm/plugin/mmsight/model/b/g:<init>	(IIIIIIIII)V
    //   396: putfield 181	com/tencent/mm/plugin/mmsight/model/b/c:KXZ	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   399: aload_0
    //   400: getfield 181	com/tencent/mm/plugin/mmsight/model/b/c:KXZ	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   403: astore 5
    //   405: aload 5
    //   407: iconst_0
    //   408: putfield 262	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   411: aload 5
    //   413: getfield 265	com/tencent/mm/plugin/mmsight/model/b/g:nxO	I
    //   416: aload 5
    //   418: getfield 268	com/tencent/mm/plugin/mmsight/model/b/g:nxP	I
    //   421: aload 5
    //   423: getfield 269	com/tencent/mm/plugin/mmsight/model/b/g:frameRate	I
    //   426: i2f
    //   427: aload 5
    //   429: getfield 272	com/tencent/mm/plugin/mmsight/model/b/g:bitrate	I
    //   432: aload 5
    //   434: getfield 275	com/tencent/mm/plugin/mmsight/model/b/g:oBP	I
    //   437: bipush 8
    //   439: aload 5
    //   441: getfield 278	com/tencent/mm/plugin/mmsight/model/b/g:oBO	I
    //   444: ldc_w 279
    //   447: aload 5
    //   449: getfield 280	com/tencent/mm/plugin/mmsight/model/b/g:KYa	I
    //   452: aload 5
    //   454: getfield 281	com/tencent/mm/plugin/mmsight/model/b/g:KYb	I
    //   457: invokestatic 285	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:initH264EncoderLock	(IIFIIIIFII)I
    //   460: pop
    //   461: aload 5
    //   463: new 287	com/tencent/mm/plugin/mmsight/model/b/g$a
    //   466: dup
    //   467: aload 5
    //   469: iconst_0
    //   470: invokespecial 290	com/tencent/mm/plugin/mmsight/model/b/g$a:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/g;B)V
    //   473: putfield 294	com/tencent/mm/plugin/mmsight/model/b/g:KYj	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   476: getstatic 300	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   479: astore 6
    //   481: new 287	com/tencent/mm/plugin/mmsight/model/b/g$a
    //   484: dup
    //   485: aload 5
    //   487: iconst_0
    //   488: invokespecial 290	com/tencent/mm/plugin/mmsight/model/b/g$a:<init>	(Lcom/tencent/mm/plugin/mmsight/model/b/g;B)V
    //   491: astore 7
    //   493: aload 5
    //   495: aload 7
    //   497: putfield 294	com/tencent/mm/plugin/mmsight/model/b/g:KYj	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   500: aload 6
    //   502: aload 7
    //   504: invokeinterface 306 2 0
    //   509: pop
    //   510: aload 5
    //   512: iconst_0
    //   513: putfield 310	com/tencent/mm/plugin/mmsight/model/b/g:isStart	Z
    //   516: ldc_w 312
    //   519: ldc_w 314
    //   522: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_0
    //   526: getfield 168	com/tencent/mm/plugin/mmsight/model/b/c:KXR	Lcom/tencent/mm/plugin/mmsight/model/b/a;
    //   529: invokeinterface 317 1 0
    //   534: aload_0
    //   535: getfield 181	com/tencent/mm/plugin/mmsight/model/b/c:KXZ	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   538: astore 5
    //   540: aload 5
    //   542: getfield 294	com/tencent/mm/plugin/mmsight/model/b/g:KYj	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   545: ifnull +20 -> 565
    //   548: aload 5
    //   550: getfield 294	com/tencent/mm/plugin/mmsight/model/b/g:KYj	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   553: iconst_1
    //   554: putfield 320	com/tencent/mm/plugin/mmsight/model/b/g$a:pdf	Z
    //   557: aload 5
    //   559: getfield 294	com/tencent/mm/plugin/mmsight/model/b/g:KYj	Lcom/tencent/mm/plugin/mmsight/model/b/g$a;
    //   562: invokevirtual 323	com/tencent/mm/plugin/mmsight/model/b/g$a:jZu	()V
    //   565: aload_0
    //   566: new 325	com/tencent/mm/compatible/i/c
    //   569: dup
    //   570: invokespecial 326	com/tencent/mm/compatible/i/c:<init>	()V
    //   573: putfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   576: aload_0
    //   577: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   580: aload_0
    //   581: getfield 99	com/tencent/mm/plugin/mmsight/model/b/c:filePath	Ljava/lang/String;
    //   584: invokevirtual 332	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   587: aconst_null
    //   588: astore 5
    //   590: iconst_0
    //   591: istore_1
    //   592: iload_1
    //   593: aload_0
    //   594: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   597: getfield 336	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   600: invokevirtual 341	android/media/MediaExtractor:getTrackCount	()I
    //   603: if_icmpge +519 -> 1122
    //   606: aload_0
    //   607: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   610: iload_1
    //   611: invokevirtual 345	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   614: astore 6
    //   616: aload 6
    //   618: ldc_w 347
    //   621: invokevirtual 353	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   624: astore 5
    //   626: aload 5
    //   628: ldc_w 355
    //   631: invokevirtual 360	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   634: ifeq +496 -> 1130
    //   637: iload_1
    //   638: iflt +145 -> 783
    //   641: aload 6
    //   643: ifnull +140 -> 783
    //   646: aload 5
    //   648: invokestatic 76	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   651: ifne +132 -> 783
    //   654: aload_0
    //   655: aload 6
    //   657: ldc_w 362
    //   660: invokevirtual 365	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   663: putfield 367	com/tencent/mm/plugin/mmsight/model/b/c:channelCount	I
    //   666: aload_0
    //   667: aload 6
    //   669: ldc_w 369
    //   672: invokevirtual 365	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   675: putfield 371	com/tencent/mm/plugin/mmsight/model/b/c:nyB	I
    //   678: aload_0
    //   679: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   682: iload_1
    //   683: invokevirtual 374	com/tencent/mm/compatible/i/c:selectTrack	(I)V
    //   686: aload_0
    //   687: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
    //   690: lconst_0
    //   691: lcmp
    //   692: ifle +19 -> 711
    //   695: aload_0
    //   696: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   699: aload_0
    //   700: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
    //   703: ldc2_w 375
    //   706: lmul
    //   707: iconst_0
    //   708: invokevirtual 380	com/tencent/mm/compatible/i/c:seekTo	(JI)V
    //   711: aload 6
    //   713: ldc_w 382
    //   716: invokevirtual 365	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   719: invokestatic 388	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   722: astore 5
    //   724: aload 5
    //   726: invokevirtual 392	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   729: pop
    //   730: aload_0
    //   731: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   734: aload 5
    //   736: iconst_0
    //   737: invokevirtual 396	com/tencent/mm/compatible/i/c:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   740: istore_2
    //   741: ldc 78
    //   743: ldc_w 398
    //   746: iconst_1
    //   747: anewarray 82	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: iload_2
    //   753: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   756: aastore
    //   757: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   760: iload_2
    //   761: ifgt +280 -> 1041
    //   764: ldc 78
    //   766: ldc_w 402
    //   769: iconst_1
    //   770: anewarray 82	java/lang/Object
    //   773: dup
    //   774: iconst_0
    //   775: iload_2
    //   776: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   779: aastore
    //   780: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   783: aload_0
    //   784: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:outputFilePath	Ljava/lang/String;
    //   787: astore 6
    //   789: aload 6
    //   791: astore 5
    //   793: aload_0
    //   794: getfield 119	com/tencent/mm/plugin/mmsight/model/b/c:nCg	I
    //   797: ifle +26 -> 823
    //   800: new 404	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   807: aload 6
    //   809: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: ldc_w 411
    //   815: invokevirtual 409	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: invokevirtual 415	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: astore 5
    //   823: aload_0
    //   824: getfield 56	com/tencent/mm/plugin/mmsight/model/b/c:videoDuration	I
    //   827: i2l
    //   828: lstore_3
    //   829: lload_3
    //   830: lconst_0
    //   831: lcmp
    //   832: ifgt +287 -> 1119
    //   835: aload_0
    //   836: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   839: aload_0
    //   840: getfield 60	com/tencent/mm/plugin/mmsight/model/b/c:nBy	J
    //   843: lsub
    //   844: lstore_3
    //   845: aload_0
    //   846: getfield 371	com/tencent/mm/plugin/mmsight/model/b/c:nyB	I
    //   849: sipush 1024
    //   852: iconst_2
    //   853: aload_0
    //   854: getfield 367	com/tencent/mm/plugin/mmsight/model/b/c:channelCount	I
    //   857: aload 5
    //   859: aload_0
    //   860: getfield 181	com/tencent/mm/plugin/mmsight/model/b/c:KXZ	Lcom/tencent/mm/plugin/mmsight/model/b/g;
    //   863: getfield 262	com/tencent/mm/plugin/mmsight/model/b/g:frameCount	I
    //   866: i2f
    //   867: ldc 190
    //   869: fmul
    //   870: lload_3
    //   871: l2f
    //   872: fdiv
    //   873: lload_3
    //   874: l2i
    //   875: aconst_null
    //   876: iconst_0
    //   877: invokestatic 419	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:muxingForX264Lock	(IIIILjava/lang/String;FI[BI)I
    //   880: istore_1
    //   881: ldc 78
    //   883: ldc_w 421
    //   886: iconst_1
    //   887: anewarray 82	java/lang/Object
    //   890: dup
    //   891: iconst_0
    //   892: iload_1
    //   893: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   896: aastore
    //   897: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   900: aload_0
    //   901: getfield 119	com/tencent/mm/plugin/mmsight/model/b/c:nCg	I
    //   904: ifle +23 -> 927
    //   907: aload 5
    //   909: aload_0
    //   910: getfield 101	com/tencent/mm/plugin/mmsight/model/b/c:outputFilePath	Ljava/lang/String;
    //   913: aload_0
    //   914: getfield 119	com/tencent/mm/plugin/mmsight/model/b/c:nCg	I
    //   917: invokestatic 425	com/tencent/mm/plugin/sight/base/SightVideoJNI:tagRotateVideoVFS	(Ljava/lang/String;Ljava/lang/String;I)I
    //   920: pop
    //   921: aload 5
    //   923: invokestatic 430	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   926: pop
    //   927: aload_0
    //   928: getfield 204	com/tencent/mm/plugin/mmsight/model/b/c:bufId	I
    //   931: invokestatic 227	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:releaseDataBufLock	(I)V
    //   934: getstatic 436	com/tencent/mm/plugin/mmsight/model/a/j:KXq	Lcom/tencent/mm/plugin/mmsight/model/a/j;
    //   937: invokevirtual 439	com/tencent/mm/plugin/mmsight/model/a/j:bvG	()V
    //   940: ldc 189
    //   942: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   945: iload_1
    //   946: ireturn
    //   947: aload_0
    //   948: getfield 143	com/tencent/mm/plugin/mmsight/model/b/c:videoFps	I
    //   951: istore_1
    //   952: goto -613 -> 339
    //   955: astore 5
    //   957: ldc_w 312
    //   960: aload 5
    //   962: ldc_w 441
    //   965: iconst_1
    //   966: anewarray 82	java/lang/Object
    //   969: dup
    //   970: iconst_0
    //   971: aload 5
    //   973: invokevirtual 444	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   976: aastore
    //   977: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   980: goto -415 -> 565
    //   983: astore 5
    //   985: ldc 78
    //   987: aload 5
    //   989: ldc_w 450
    //   992: iconst_1
    //   993: anewarray 82	java/lang/Object
    //   996: dup
    //   997: iconst_0
    //   998: aload 5
    //   1000: invokevirtual 444	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1003: aastore
    //   1004: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1007: ldc 189
    //   1009: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1012: iconst_m1
    //   1013: ireturn
    //   1014: astore 5
    //   1016: ldc 78
    //   1018: aload 5
    //   1020: ldc_w 452
    //   1023: iconst_1
    //   1024: anewarray 82	java/lang/Object
    //   1027: dup
    //   1028: iconst_0
    //   1029: aload 5
    //   1031: invokevirtual 453	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1034: aastore
    //   1035: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1038: goto -255 -> 783
    //   1041: aload_0
    //   1042: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   1045: getfield 336	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   1048: invokevirtual 457	android/media/MediaExtractor:getSampleTime	()J
    //   1051: aload_0
    //   1052: getfield 62	com/tencent/mm/plugin/mmsight/model/b/c:remuxEndTime	J
    //   1055: ldc2_w 375
    //   1058: lmul
    //   1059: lcmp
    //   1060: ifge -277 -> 783
    //   1063: aload_0
    //   1064: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   1067: getfield 336	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   1070: invokevirtual 460	android/media/MediaExtractor:getSampleTrackIndex	()I
    //   1073: iload_1
    //   1074: if_icmpeq +14 -> 1088
    //   1077: ldc 78
    //   1079: ldc_w 462
    //   1082: invokestatic 464	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1085: goto -302 -> 783
    //   1088: aload 5
    //   1090: iconst_0
    //   1091: invokevirtual 468	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1094: pop
    //   1095: aload_0
    //   1096: getfield 204	com/tencent/mm/plugin/mmsight/model/b/c:bufId	I
    //   1099: aload 5
    //   1101: iload_2
    //   1102: invokestatic 472	com/tencent/mm/plugin/mmsight/segment/MP4MuxerJNI:writeAACDataLock	(ILjava/nio/ByteBuffer;I)V
    //   1105: aload_0
    //   1106: getfield 328	com/tencent/mm/plugin/mmsight/model/b/c:pcp	Lcom/tencent/mm/compatible/i/c;
    //   1109: getfield 336	com/tencent/mm/compatible/i/c:lZm	Landroid/media/MediaExtractor;
    //   1112: invokevirtual 476	android/media/MediaExtractor:advance	()Z
    //   1115: pop
    //   1116: goto -392 -> 724
    //   1119: goto -274 -> 845
    //   1122: aconst_null
    //   1123: astore 6
    //   1125: iconst_m1
    //   1126: istore_1
    //   1127: goto -490 -> 637
    //   1130: iload_1
    //   1131: iconst_1
    //   1132: iadd
    //   1133: istore_1
    //   1134: goto -542 -> 592
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	this	c
    //   18	1116	1	i	int
    //   16	1086	2	j	int
    //   828	46	3	l	long
    //   403	519	5	localObject1	Object
    //   955	17	5	localException1	java.lang.Exception
    //   983	16	5	localException2	java.lang.Exception
    //   1014	86	5	localIOException	java.io.IOException
    //   479	645	6	localObject2	Object
    //   491	12	7	locala	g.a
    // Exception table:
    //   from	to	target	type
    //   557	565	955	java/lang/Exception
    //   525	557	983	java/lang/Exception
    //   565	576	983	java/lang/Exception
    //   576	587	983	java/lang/Exception
    //   592	637	983	java/lang/Exception
    //   646	711	983	java/lang/Exception
    //   711	724	983	java/lang/Exception
    //   724	760	983	java/lang/Exception
    //   764	783	983	java/lang/Exception
    //   783	789	983	java/lang/Exception
    //   793	823	983	java/lang/Exception
    //   823	829	983	java/lang/Exception
    //   835	845	983	java/lang/Exception
    //   845	927	983	java/lang/Exception
    //   927	940	983	java/lang/Exception
    //   957	980	983	java/lang/Exception
    //   1016	1038	983	java/lang/Exception
    //   1041	1085	983	java/lang/Exception
    //   1088	1116	983	java/lang/Exception
    //   576	587	1014	java/io/IOException
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.c
 * JD-Core Version:    0.7.0.1
 */