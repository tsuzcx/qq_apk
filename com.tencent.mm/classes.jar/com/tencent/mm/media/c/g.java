package com.tencent.mm.media.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "codeOver", "", "drainDecoder", "readNextSample", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class g
  extends e
{
  private static final String TAG = "MicroMsg.MediaCodecAACDecoder";
  private static final long gOU = 60000L;
  public static final g.a gOV;
  private boolean codeOver;
  
  static
  {
    AppMethodBeat.i(93536);
    gOV = new g.a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoder";
    gOU = 60000L;
    AppMethodBeat.o(93536);
  }
  
  public g(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2)
  {
    this(parama, paramString, paramLong1, paramLong2, null, null);
    AppMethodBeat.i(93535);
    AppMethodBeat.o(93535);
  }
  
  public g(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, y> paramm, d.g.a.a<y> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(93534);
    AppMethodBeat.o(93534);
  }
  
  private final boolean aqs()
  {
    AppMethodBeat.i(93531);
    int m;
    try
    {
      synchronized (this.stopLock)
      {
        if (this.gOs) {
          ac.i(TAG, "readNextSample decoder stop");
        }
        Object localObject3 = y.KTp;
        localObject3 = this.gOr;
        if (localObject3 != null)
        {
          this.gOv = bs.Gn();
          m = ((z)localObject3).dequeueInputBuffer(100L);
          if (m < 0) {
            aqt();
          }
          if (m >= 0) {
            break label125;
          }
          AppMethodBeat.o(93531);
          return false;
        }
      }
      AppMethodBeat.o(93531);
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
    }
    return true;
    label125:
    ac.i(TAG, "inputIndex: ".concat(String.valueOf(m)));
    this.gOv = bs.Gn();
    ByteBuffer localByteBuffer = localObject4.getInputBuffers()[m];
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    Object localObject2 = this.gOy;
    label199:
    int i;
    long l2;
    int j;
    label244:
    long l1;
    label274:
    int k;
    if (localObject2 != null)
    {
      k.g(localByteBuffer, "inputBuffer");
      localObject2 = Boolean.valueOf(((com.tencent.mm.media.e.a)localObject2).k(localByteBuffer));
      if (!k.g(localObject2, Boolean.FALSE)) {
        break label404;
      }
      ac.i(TAG, "read sample end");
      i = 1;
      l2 = 0L;
      if (i != 0) {
        break label399;
      }
      localObject2 = this.gOy;
      if (localObject2 == null) {
        break label381;
      }
      j = ((com.tencent.mm.media.e.a)localObject2).sampleSize;
      if (localByteBuffer != null) {
        localByteBuffer.position(0);
      }
      localObject2 = this.gOy;
      if (localObject2 == null) {
        break label386;
      }
      l1 = ((com.tencent.mm.media.e.a)localObject2).getSampleTime();
      ac.i(TAG, "sampleTime : " + l1 + ", sampleSize:" + j);
      if (j >= 0)
      {
        k = j;
        l2 = l1;
        if (l1 < this.gOz * 1000L) {
          break label409;
        }
      }
      ac.i(TAG, "sawInputEOS");
      i = 1;
      k = j;
      l2 = l1;
      break label409;
    }
    for (;;)
    {
      label349:
      localObject4.a(m, k, l2, j);
      if (i != 0) {
        aqr();
      }
      aqt();
      break;
      localObject2 = null;
      break label199;
      label381:
      j = 0;
      break label244;
      label386:
      l1 = -1L;
      break label274;
      label399:
      label404:
      label409:
      do
      {
        j = 0;
        break label349;
        k = 0;
        continue;
        i = 0;
        break;
      } while (i == 0);
      j = 4;
    }
  }
  
  /* Error */
  private final void aqt()
  {
    // Byte code:
    //   0: ldc 248
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 97	com/tencent/mm/media/c/e:stopLock	Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 100	com/tencent/mm/media/c/e:gOs	Z
    //   18: ifeq +20 -> 38
    //   21: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   24: ldc 250
    //   26: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload 5
    //   31: monitorexit
    //   32: ldc 248
    //   34: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: getstatic 113	d/y:KTp	Ld/y;
    //   41: astore 6
    //   43: aload 5
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 117	com/tencent/mm/media/c/e:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +464 -> 518
    //   57: new 252	android/media/MediaCodec$BufferInfo
    //   60: dup
    //   61: invokespecial 254	android/media/MediaCodec$BufferInfo:<init>	()V
    //   64: astore 6
    //   66: aload 6
    //   68: ldc_w 256
    //   71: invokestatic 79	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   74: aload_0
    //   75: aload 6
    //   77: putfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   80: aload 5
    //   82: aload_0
    //   83: getfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   86: getstatic 67	com/tencent/mm/media/c/g:gOU	J
    //   89: invokevirtual 264	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   92: istore_1
    //   93: iload_1
    //   94: bipush 254
    //   96: if_icmpne +184 -> 280
    //   99: aload_0
    //   100: aload 5
    //   102: invokevirtual 268	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   105: putfield 272	com/tencent/mm/media/c/e:gNt	Landroid/media/MediaFormat;
    //   108: aload_0
    //   109: getfield 272	com/tencent/mm/media/c/e:gNt	Landroid/media/MediaFormat;
    //   112: astore 6
    //   114: aload 6
    //   116: ifnull +44 -> 160
    //   119: aload 6
    //   121: ldc_w 274
    //   124: invokevirtual 280	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   127: iconst_1
    //   128: if_icmpne +32 -> 160
    //   131: aload_0
    //   132: getfield 272	com/tencent/mm/media/c/e:gNt	Landroid/media/MediaFormat;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnull +385 -> 524
    //   142: aload 6
    //   144: ldc_w 274
    //   147: invokevirtual 284	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   150: istore_1
    //   151: iload_1
    //   152: ifle +8 -> 160
    //   155: aload_0
    //   156: iload_1
    //   157: putfield 287	com/tencent/mm/media/c/e:gOu	I
    //   160: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   163: new 210	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 289
    //   170: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: getfield 272	com/tencent/mm/media/c/e:gNt	Landroid/media/MediaFormat;
    //   177: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: ldc_w 294
    //   183: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_0
    //   187: getfield 287	com/tencent/mm/media/c/e:gOu	I
    //   190: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc_w 296
    //   196: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: getfield 299	com/tencent/mm/media/c/e:cQO	Ljava/lang/String;
    //   203: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 5
    //   214: aload_0
    //   215: getfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   218: getstatic 67	com/tencent/mm/media/c/g:gOU	J
    //   221: invokevirtual 264	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   224: istore_2
    //   225: iload_2
    //   226: istore_1
    //   227: iload_2
    //   228: ifge -135 -> 93
    //   231: ldc 248
    //   233: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: return
    //   237: astore 5
    //   239: aload_0
    //   240: iconst_1
    //   241: putfield 301	com/tencent/mm/media/c/g:codeOver	Z
    //   244: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   247: aload 5
    //   249: checkcast 139	java/lang/Throwable
    //   252: ldc 140
    //   254: iconst_0
    //   255: anewarray 142	java/lang/Object
    //   258: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: ldc 248
    //   263: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: return
    //   267: astore 6
    //   269: aload 5
    //   271: monitorexit
    //   272: ldc 248
    //   274: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload 6
    //   279: athrow
    //   280: iload_1
    //   281: iflt -69 -> 212
    //   284: aload 5
    //   286: invokevirtual 304	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   289: iload_1
    //   290: aaload
    //   291: astore 6
    //   293: aload 6
    //   295: ifnonnull +18 -> 313
    //   298: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   301: ldc_w 306
    //   304: invokestatic 309	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: ldc 248
    //   309: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: return
    //   313: aload_0
    //   314: getfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   317: getfield 312	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   320: lstore_3
    //   321: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   324: ldc_w 314
    //   327: lload_3
    //   328: invokestatic 317	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   331: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   334: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: lload_3
    //   338: aload_0
    //   339: getfield 320	com/tencent/mm/media/c/e:bvf	J
    //   342: ldc2_w 235
    //   345: lmul
    //   346: lcmp
    //   347: ifge +68 -> 415
    //   350: aload_0
    //   351: getfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   354: getfield 323	android/media/MediaCodec$BufferInfo:flags	I
    //   357: iconst_4
    //   358: iand
    //   359: ifne +56 -> 415
    //   362: aload 5
    //   364: iload_1
    //   365: iconst_0
    //   366: invokevirtual 327	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   369: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   372: new 210	java/lang/StringBuilder
    //   375: dup
    //   376: ldc_w 329
    //   379: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: lload_3
    //   383: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: ldc_w 331
    //   389: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_0
    //   393: getfield 320	com/tencent/mm/media/c/e:bvf	J
    //   396: ldc2_w 235
    //   399: lmul
    //   400: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: ldc 248
    //   411: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: return
    //   415: aload_0
    //   416: getfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   419: getfield 334	android/media/MediaCodec$BufferInfo:size	I
    //   422: ifle +13 -> 435
    //   425: aload_0
    //   426: aload 6
    //   428: aload_0
    //   429: getfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   432: invokevirtual 337	com/tencent/mm/media/c/g:e	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   435: aload 5
    //   437: iload_1
    //   438: iconst_0
    //   439: invokevirtual 327	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   442: aload_0
    //   443: getfield 234	com/tencent/mm/media/c/e:gOz	J
    //   446: ldc2_w 235
    //   449: lmul
    //   450: lconst_1
    //   451: lcmp
    //   452: ifeq +35 -> 487
    //   455: lload_3
    //   456: aload_0
    //   457: getfield 234	com/tencent/mm/media/c/e:gOz	J
    //   460: ldc2_w 235
    //   463: lmul
    //   464: lcmp
    //   465: iflt +22 -> 487
    //   468: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   471: ldc_w 339
    //   474: invokestatic 309	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload_0
    //   478: invokevirtual 245	com/tencent/mm/media/c/g:aqr	()V
    //   481: ldc 248
    //   483: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   486: return
    //   487: aload_0
    //   488: getfield 260	com/tencent/mm/media/c/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   491: getfield 323	android/media/MediaCodec$BufferInfo:flags	I
    //   494: iconst_4
    //   495: iand
    //   496: ifeq -284 -> 212
    //   499: getstatic 65	com/tencent/mm/media/c/g:TAG	Ljava/lang/String;
    //   502: ldc_w 341
    //   505: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload_0
    //   509: invokevirtual 245	com/tencent/mm/media/c/g:aqr	()V
    //   512: ldc 248
    //   514: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   517: return
    //   518: ldc 248
    //   520: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   523: return
    //   524: iconst_0
    //   525: istore_1
    //   526: goto -375 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	g
    //   92	434	1	i	int
    //   224	4	2	j	int
    //   320	136	3	l	long
    //   237	199	5	localException	Exception
    //   41	102	6	localObject2	Object
    //   267	11	6	localObject3	Object
    //   291	136	6	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	14	237	java/lang/Exception
    //   29	37	237	java/lang/Exception
    //   43	52	237	java/lang/Exception
    //   57	93	237	java/lang/Exception
    //   99	114	237	java/lang/Exception
    //   119	137	237	java/lang/Exception
    //   142	151	237	java/lang/Exception
    //   155	160	237	java/lang/Exception
    //   160	212	237	java/lang/Exception
    //   212	225	237	java/lang/Exception
    //   231	236	237	java/lang/Exception
    //   269	280	237	java/lang/Exception
    //   284	293	237	java/lang/Exception
    //   298	312	237	java/lang/Exception
    //   313	414	237	java/lang/Exception
    //   415	435	237	java/lang/Exception
    //   435	486	237	java/lang/Exception
    //   487	517	237	java/lang/Exception
    //   14	29	267	finally
    //   38	43	267	finally
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(93533);
    z localz = this.gOr;
    if (localz != null) {
      localz.start();
    }
    while ((!this.codeOver) && (!this.gOs)) {
      aqs();
    }
    aqr();
    AppMethodBeat.o(93533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.c.g
 * JD-Core Version:    0.7.0.1
 */