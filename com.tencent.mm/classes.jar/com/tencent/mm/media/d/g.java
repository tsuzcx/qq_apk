package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "codeOver", "", "drainDecoder", "readNextSample", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class g
  extends e
{
  private static final String TAG = "MicroMsg.MediaCodecAACDecoder";
  private static final long kTr = 60000L;
  public static final a kTs;
  private boolean codeOver;
  
  static
  {
    AppMethodBeat.i(93536);
    kTs = new a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoder";
    kTr = 60000L;
    AppMethodBeat.o(93536);
  }
  
  public g(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2)
  {
    this(parama, paramString, paramLong1, paramLong2, null, null);
    AppMethodBeat.i(93535);
    AppMethodBeat.o(93535);
  }
  
  public g(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, x> paramm, kotlin.g.a.a<x> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(93534);
    AppMethodBeat.o(93534);
  }
  
  private final boolean aUs()
  {
    AppMethodBeat.i(93531);
    int m;
    try
    {
      synchronized (aUl())
      {
        if (this.kSO) {
          Log.i(TAG, "readNextSample decoder stop");
        }
        Object localObject3 = x.aazN;
        localObject3 = this.kSN;
        if (localObject3 != null)
        {
          this.kSQ = Util.currentTicks();
          m = ((aa)localObject3).EX(100L);
          if (m < 0) {
            aUt();
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
      Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
    }
    return true;
    label125:
    Log.i(TAG, "inputIndex: ".concat(String.valueOf(m)));
    this.kSQ = Util.currentTicks();
    ByteBuffer localByteBuffer = localObject4.avj()[m];
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    Object localObject2 = aUp();
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
      p.j(localByteBuffer, "inputBuffer");
      localObject2 = Boolean.valueOf(com.tencent.mm.media.f.a.a((com.tencent.mm.media.f.a)localObject2, localByteBuffer));
      if (!p.h(localObject2, Boolean.FALSE)) {
        break label404;
      }
      Log.i(TAG, "read sample end");
      i = 1;
      l2 = 0L;
      if (i != 0) {
        break label399;
      }
      localObject2 = aUp();
      if (localObject2 == null) {
        break label381;
      }
      j = ((com.tencent.mm.media.f.a)localObject2).sampleSize;
      if (localByteBuffer != null) {
        localByteBuffer.position(0);
      }
      localObject2 = aUp();
      if (localObject2 == null) {
        break label386;
      }
      l1 = ((com.tencent.mm.media.f.a)localObject2).getSampleTime();
      Log.i(TAG, "sampleTime : " + l1 + ", sampleSize:" + j);
      if (j >= 0)
      {
        k = j;
        l2 = l1;
        if (l1 < getEndTimeMs() * 1000L) {
          break label409;
        }
      }
      Log.i(TAG, "sawInputEOS");
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
        aUn();
      }
      aUt();
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
  private final void aUt()
  {
    // Byte code:
    //   0: ldc 248
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 98	com/tencent/mm/media/d/g:aUl	()Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 101	com/tencent/mm/media/d/e:kSO	Z
    //   18: ifeq +20 -> 38
    //   21: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   24: ldc 250
    //   26: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload 5
    //   31: monitorexit
    //   32: ldc 248
    //   34: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: getstatic 114	kotlin/x:aazN	Lkotlin/x;
    //   41: astore 6
    //   43: aload 5
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 118	com/tencent/mm/media/d/e:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +452 -> 506
    //   57: aload_0
    //   58: new 252	android/media/MediaCodec$BufferInfo
    //   61: dup
    //   62: invokespecial 254	android/media/MediaCodec$BufferInfo:<init>	()V
    //   65: invokevirtual 257	com/tencent/mm/media/d/g:a	(Landroid/media/MediaCodec$BufferInfo;)V
    //   68: aload 5
    //   70: aload_0
    //   71: invokevirtual 261	com/tencent/mm/media/d/g:aUm	()Landroid/media/MediaCodec$BufferInfo;
    //   74: getstatic 68	com/tencent/mm/media/d/g:kTr	J
    //   77: invokevirtual 264	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   80: istore_1
    //   81: iload_1
    //   82: bipush 254
    //   84: if_icmpne +184 -> 268
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 268	com/tencent/mm/compatible/deviceinfo/aa:avi	()Landroid/media/MediaFormat;
    //   93: putfield 272	com/tencent/mm/media/d/e:kRH	Landroid/media/MediaFormat;
    //   96: aload_0
    //   97: getfield 272	com/tencent/mm/media/d/e:kRH	Landroid/media/MediaFormat;
    //   100: astore 6
    //   102: aload 6
    //   104: ifnull +44 -> 148
    //   107: aload 6
    //   109: ldc_w 274
    //   112: invokevirtual 280	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   115: iconst_1
    //   116: if_icmpne +32 -> 148
    //   119: aload_0
    //   120: getfield 272	com/tencent/mm/media/d/e:kRH	Landroid/media/MediaFormat;
    //   123: astore 6
    //   125: aload 6
    //   127: ifnull +385 -> 512
    //   130: aload 6
    //   132: ldc_w 274
    //   135: invokevirtual 284	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   138: istore_1
    //   139: iload_1
    //   140: ifle +8 -> 148
    //   143: aload_0
    //   144: iload_1
    //   145: putfield 287	com/tencent/mm/media/d/e:kSP	I
    //   148: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   151: new 211	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 289
    //   158: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: getfield 272	com/tencent/mm/media/d/e:kRH	Landroid/media/MediaFormat;
    //   165: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: ldc_w 294
    //   171: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: getfield 287	com/tencent/mm/media/d/e:kSP	I
    //   178: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: ldc_w 296
    //   184: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: invokevirtual 299	com/tencent/mm/media/d/g:adU	()Ljava/lang/String;
    //   191: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 5
    //   202: aload_0
    //   203: invokevirtual 261	com/tencent/mm/media/d/g:aUm	()Landroid/media/MediaCodec$BufferInfo;
    //   206: getstatic 68	com/tencent/mm/media/d/g:kTr	J
    //   209: invokevirtual 264	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   212: istore_2
    //   213: iload_2
    //   214: istore_1
    //   215: iload_2
    //   216: ifge -135 -> 81
    //   219: ldc 248
    //   221: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    //   225: astore 5
    //   227: aload_0
    //   228: iconst_1
    //   229: putfield 301	com/tencent/mm/media/d/g:codeOver	Z
    //   232: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   235: aload 5
    //   237: checkcast 140	java/lang/Throwable
    //   240: ldc 141
    //   242: iconst_0
    //   243: anewarray 143	java/lang/Object
    //   246: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: ldc 248
    //   251: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: astore 6
    //   257: aload 5
    //   259: monitorexit
    //   260: ldc 248
    //   262: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload 6
    //   267: athrow
    //   268: iload_1
    //   269: iflt -69 -> 200
    //   272: aload 5
    //   274: invokevirtual 304	com/tencent/mm/compatible/deviceinfo/aa:avk	()[Ljava/nio/ByteBuffer;
    //   277: iload_1
    //   278: aaload
    //   279: astore 6
    //   281: aload 6
    //   283: ifnonnull +18 -> 301
    //   286: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   289: ldc_w 306
    //   292: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: ldc 248
    //   297: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: return
    //   301: aload_0
    //   302: invokevirtual 261	com/tencent/mm/media/d/g:aUm	()Landroid/media/MediaCodec$BufferInfo;
    //   305: getfield 312	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   308: lstore_3
    //   309: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   312: ldc_w 314
    //   315: lload_3
    //   316: invokestatic 317	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   319: invokevirtual 159	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   322: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: lload_3
    //   326: aload_0
    //   327: invokevirtual 320	com/tencent/mm/media/d/g:getStartTimeMs	()J
    //   330: ldc2_w 236
    //   333: lmul
    //   334: lcmp
    //   335: ifge +68 -> 403
    //   338: aload_0
    //   339: invokevirtual 261	com/tencent/mm/media/d/g:aUm	()Landroid/media/MediaCodec$BufferInfo;
    //   342: getfield 323	android/media/MediaCodec$BufferInfo:flags	I
    //   345: iconst_4
    //   346: iand
    //   347: ifne +56 -> 403
    //   350: aload 5
    //   352: iload_1
    //   353: iconst_0
    //   354: invokevirtual 327	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   357: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   360: new 211	java/lang/StringBuilder
    //   363: dup
    //   364: ldc_w 329
    //   367: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   370: lload_3
    //   371: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: ldc_w 331
    //   377: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: invokevirtual 320	com/tencent/mm/media/d/g:getStartTimeMs	()J
    //   384: ldc2_w 236
    //   387: lmul
    //   388: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: ldc 248
    //   399: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: return
    //   403: aload_0
    //   404: invokevirtual 261	com/tencent/mm/media/d/g:aUm	()Landroid/media/MediaCodec$BufferInfo;
    //   407: getfield 334	android/media/MediaCodec$BufferInfo:size	I
    //   410: ifle +13 -> 423
    //   413: aload_0
    //   414: aload 6
    //   416: aload_0
    //   417: invokevirtual 261	com/tencent/mm/media/d/g:aUm	()Landroid/media/MediaCodec$BufferInfo;
    //   420: invokevirtual 337	com/tencent/mm/media/d/g:e	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   423: aload 5
    //   425: iload_1
    //   426: iconst_0
    //   427: invokevirtual 327	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   430: aload_0
    //   431: invokevirtual 235	com/tencent/mm/media/d/g:getEndTimeMs	()J
    //   434: ldc2_w 236
    //   437: lmul
    //   438: lconst_1
    //   439: lcmp
    //   440: ifeq +35 -> 475
    //   443: lload_3
    //   444: aload_0
    //   445: invokevirtual 235	com/tencent/mm/media/d/g:getEndTimeMs	()J
    //   448: ldc2_w 236
    //   451: lmul
    //   452: lcmp
    //   453: iflt +22 -> 475
    //   456: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   459: ldc_w 339
    //   462: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload_0
    //   466: invokevirtual 245	com/tencent/mm/media/d/g:aUn	()V
    //   469: ldc 248
    //   471: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: return
    //   475: aload_0
    //   476: invokevirtual 261	com/tencent/mm/media/d/g:aUm	()Landroid/media/MediaCodec$BufferInfo;
    //   479: getfield 323	android/media/MediaCodec$BufferInfo:flags	I
    //   482: iconst_4
    //   483: iand
    //   484: ifeq -284 -> 200
    //   487: getstatic 66	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   490: ldc_w 341
    //   493: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload_0
    //   497: invokevirtual 245	com/tencent/mm/media/d/g:aUn	()V
    //   500: ldc 248
    //   502: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   505: return
    //   506: ldc 248
    //   508: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: return
    //   512: iconst_0
    //   513: istore_1
    //   514: goto -375 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	g
    //   80	434	1	i	int
    //   212	4	2	j	int
    //   308	136	3	l	long
    //   225	199	5	localException	Exception
    //   41	90	6	localObject2	Object
    //   255	11	6	localObject3	Object
    //   279	136	6	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	14	225	java/lang/Exception
    //   29	37	225	java/lang/Exception
    //   43	52	225	java/lang/Exception
    //   57	81	225	java/lang/Exception
    //   87	102	225	java/lang/Exception
    //   107	125	225	java/lang/Exception
    //   130	139	225	java/lang/Exception
    //   143	148	225	java/lang/Exception
    //   148	200	225	java/lang/Exception
    //   200	213	225	java/lang/Exception
    //   219	224	225	java/lang/Exception
    //   257	268	225	java/lang/Exception
    //   272	281	225	java/lang/Exception
    //   286	300	225	java/lang/Exception
    //   301	402	225	java/lang/Exception
    //   403	423	225	java/lang/Exception
    //   423	474	225	java/lang/Exception
    //   475	505	225	java/lang/Exception
    //   14	29	255	finally
    //   38	43	255	finally
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(93533);
    aa localaa = this.kSN;
    if (localaa != null) {
      localaa.start();
    }
    while ((!this.codeOver) && (!this.kSO)) {
      aUs();
    }
    aUn();
    AppMethodBeat.o(93533);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder$Companion;", "", "()V", "TAG", "", "TIMEOUT", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.g
 * JD-Core Version:    0.7.0.1
 */