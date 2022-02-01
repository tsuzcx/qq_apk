package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "codeOver", "", "drainDecoder", "readNextSample", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class g
  extends e
{
  private static final String TAG = "MicroMsg.MediaCodecAACDecoder";
  private static final long ieE = 60000L;
  public static final g.a ieF;
  private boolean codeOver;
  
  static
  {
    AppMethodBeat.i(93536);
    ieF = new g.a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoder";
    ieE = 60000L;
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
  
  private final boolean aMd()
  {
    AppMethodBeat.i(93531);
    int m;
    try
    {
      synchronized (this.stopLock)
      {
        if (this.ied) {
          Log.i(TAG, "readNextSample decoder stop");
        }
        Object localObject3 = x.SXb;
        localObject3 = this.iec;
        if (localObject3 != null)
        {
          this.ief = Util.currentTicks();
          m = ((z)localObject3).dequeueInputBuffer(100L);
          if (m < 0) {
            aMe();
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
    this.ief = Util.currentTicks();
    ByteBuffer localByteBuffer = localObject4.getInputBuffers()[m];
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    Object localObject2 = this.iei;
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
      p.g(localByteBuffer, "inputBuffer");
      localObject2 = Boolean.valueOf(com.tencent.mm.media.f.a.a((com.tencent.mm.media.f.a)localObject2, localByteBuffer));
      if (!p.j(localObject2, Boolean.FALSE)) {
        break label404;
      }
      Log.i(TAG, "read sample end");
      i = 1;
      l2 = 0L;
      if (i != 0) {
        break label399;
      }
      localObject2 = this.iei;
      if (localObject2 == null) {
        break label381;
      }
      j = ((com.tencent.mm.media.f.a)localObject2).sampleSize;
      if (localByteBuffer != null) {
        localByteBuffer.position(0);
      }
      localObject2 = this.iei;
      if (localObject2 == null) {
        break label386;
      }
      l1 = ((com.tencent.mm.media.f.a)localObject2).getSampleTime();
      Log.i(TAG, "sampleTime : " + l1 + ", sampleSize:" + j);
      if (j >= 0)
      {
        k = j;
        l2 = l1;
        if (l1 < this.endTimeMs * 1000L) {
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
        aMc();
      }
      aMe();
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
  private final void aMe()
  {
    // Byte code:
    //   0: ldc 247
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 97	com/tencent/mm/media/d/e:stopLock	Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 100	com/tencent/mm/media/d/e:ied	Z
    //   18: ifeq +20 -> 38
    //   21: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   24: ldc 249
    //   26: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload 5
    //   31: monitorexit
    //   32: ldc 247
    //   34: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: getstatic 113	kotlin/x:SXb	Lkotlin/x;
    //   41: astore 6
    //   43: aload 5
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 117	com/tencent/mm/media/d/e:iec	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +463 -> 517
    //   57: new 251	android/media/MediaCodec$BufferInfo
    //   60: dup
    //   61: invokespecial 253	android/media/MediaCodec$BufferInfo:<init>	()V
    //   64: astore 6
    //   66: aload 6
    //   68: ldc 255
    //   70: invokestatic 79	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   73: aload_0
    //   74: aload 6
    //   76: putfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   79: aload 5
    //   81: aload_0
    //   82: getfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   85: getstatic 67	com/tencent/mm/media/d/g:ieE	J
    //   88: invokevirtual 263	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   91: istore_1
    //   92: iload_1
    //   93: bipush 254
    //   95: if_icmpne +184 -> 279
    //   98: aload_0
    //   99: aload 5
    //   101: invokevirtual 267	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   104: putfield 271	com/tencent/mm/media/d/e:ida	Landroid/media/MediaFormat;
    //   107: aload_0
    //   108: getfield 271	com/tencent/mm/media/d/e:ida	Landroid/media/MediaFormat;
    //   111: astore 6
    //   113: aload 6
    //   115: ifnull +44 -> 159
    //   118: aload 6
    //   120: ldc_w 273
    //   123: invokevirtual 279	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   126: iconst_1
    //   127: if_icmpne +32 -> 159
    //   130: aload_0
    //   131: getfield 271	com/tencent/mm/media/d/e:ida	Landroid/media/MediaFormat;
    //   134: astore 6
    //   136: aload 6
    //   138: ifnull +385 -> 523
    //   141: aload 6
    //   143: ldc_w 273
    //   146: invokevirtual 283	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   149: istore_1
    //   150: iload_1
    //   151: ifle +8 -> 159
    //   154: aload_0
    //   155: iload_1
    //   156: putfield 286	com/tencent/mm/media/d/e:iee	I
    //   159: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   162: new 211	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 288
    //   169: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 271	com/tencent/mm/media/d/e:ida	Landroid/media/MediaFormat;
    //   176: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: ldc_w 293
    //   182: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield 286	com/tencent/mm/media/d/e:iee	I
    //   189: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc_w 295
    //   195: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: getfield 298	com/tencent/mm/media/d/e:dtX	Ljava/lang/String;
    //   202: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 5
    //   213: aload_0
    //   214: getfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   217: getstatic 67	com/tencent/mm/media/d/g:ieE	J
    //   220: invokevirtual 263	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   223: istore_2
    //   224: iload_2
    //   225: istore_1
    //   226: iload_2
    //   227: ifge -135 -> 92
    //   230: ldc 247
    //   232: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: astore 5
    //   238: aload_0
    //   239: iconst_1
    //   240: putfield 300	com/tencent/mm/media/d/g:codeOver	Z
    //   243: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   246: aload 5
    //   248: checkcast 139	java/lang/Throwable
    //   251: ldc 140
    //   253: iconst_0
    //   254: anewarray 142	java/lang/Object
    //   257: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: ldc 247
    //   262: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: astore 6
    //   268: aload 5
    //   270: monitorexit
    //   271: ldc 247
    //   273: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 6
    //   278: athrow
    //   279: iload_1
    //   280: iflt -69 -> 211
    //   283: aload 5
    //   285: invokevirtual 303	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   288: iload_1
    //   289: aaload
    //   290: astore 6
    //   292: aload 6
    //   294: ifnonnull +18 -> 312
    //   297: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   300: ldc_w 305
    //   303: invokestatic 308	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: ldc 247
    //   308: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: aload_0
    //   313: getfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   316: getfield 311	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   319: lstore_3
    //   320: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   323: ldc_w 313
    //   326: lload_3
    //   327: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   330: invokevirtual 158	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   333: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: lload_3
    //   337: aload_0
    //   338: getfield 318	com/tencent/mm/media/d/e:startTimeMs	J
    //   341: ldc2_w 235
    //   344: lmul
    //   345: lcmp
    //   346: ifge +68 -> 414
    //   349: aload_0
    //   350: getfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   353: getfield 321	android/media/MediaCodec$BufferInfo:flags	I
    //   356: iconst_4
    //   357: iand
    //   358: ifne +56 -> 414
    //   361: aload 5
    //   363: iload_1
    //   364: iconst_0
    //   365: invokevirtual 325	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   368: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   371: new 211	java/lang/StringBuilder
    //   374: dup
    //   375: ldc_w 327
    //   378: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: lload_3
    //   382: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: ldc_w 329
    //   388: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_0
    //   392: getfield 318	com/tencent/mm/media/d/e:startTimeMs	J
    //   395: ldc2_w 235
    //   398: lmul
    //   399: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   402: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: ldc 247
    //   410: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: return
    //   414: aload_0
    //   415: getfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   418: getfield 332	android/media/MediaCodec$BufferInfo:size	I
    //   421: ifle +13 -> 434
    //   424: aload_0
    //   425: aload 6
    //   427: aload_0
    //   428: getfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   431: invokevirtual 335	com/tencent/mm/media/d/g:e	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   434: aload 5
    //   436: iload_1
    //   437: iconst_0
    //   438: invokevirtual 325	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   441: aload_0
    //   442: getfield 234	com/tencent/mm/media/d/e:endTimeMs	J
    //   445: ldc2_w 235
    //   448: lmul
    //   449: lconst_1
    //   450: lcmp
    //   451: ifeq +35 -> 486
    //   454: lload_3
    //   455: aload_0
    //   456: getfield 234	com/tencent/mm/media/d/e:endTimeMs	J
    //   459: ldc2_w 235
    //   462: lmul
    //   463: lcmp
    //   464: iflt +22 -> 486
    //   467: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   470: ldc_w 337
    //   473: invokestatic 308	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload_0
    //   477: invokevirtual 244	com/tencent/mm/media/d/g:aMc	()V
    //   480: ldc 247
    //   482: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   485: return
    //   486: aload_0
    //   487: getfield 259	com/tencent/mm/media/d/e:bufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   490: getfield 321	android/media/MediaCodec$BufferInfo:flags	I
    //   493: iconst_4
    //   494: iand
    //   495: ifeq -284 -> 211
    //   498: getstatic 65	com/tencent/mm/media/d/g:TAG	Ljava/lang/String;
    //   501: ldc_w 339
    //   504: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aload_0
    //   508: invokevirtual 244	com/tencent/mm/media/d/g:aMc	()V
    //   511: ldc 247
    //   513: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: return
    //   517: ldc 247
    //   519: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   522: return
    //   523: iconst_0
    //   524: istore_1
    //   525: goto -375 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	g
    //   91	434	1	i	int
    //   223	4	2	j	int
    //   319	136	3	l	long
    //   236	199	5	localException	Exception
    //   41	101	6	localObject2	Object
    //   266	11	6	localObject3	Object
    //   290	136	6	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	14	236	java/lang/Exception
    //   29	37	236	java/lang/Exception
    //   43	52	236	java/lang/Exception
    //   57	92	236	java/lang/Exception
    //   98	113	236	java/lang/Exception
    //   118	136	236	java/lang/Exception
    //   141	150	236	java/lang/Exception
    //   154	159	236	java/lang/Exception
    //   159	211	236	java/lang/Exception
    //   211	224	236	java/lang/Exception
    //   230	235	236	java/lang/Exception
    //   268	279	236	java/lang/Exception
    //   283	292	236	java/lang/Exception
    //   297	311	236	java/lang/Exception
    //   312	413	236	java/lang/Exception
    //   414	434	236	java/lang/Exception
    //   434	485	236	java/lang/Exception
    //   486	516	236	java/lang/Exception
    //   14	29	266	finally
    //   38	43	266	finally
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(93533);
    z localz = this.iec;
    if (localz != null) {
      localz.start();
    }
    while ((!this.codeOver) && (!this.ied)) {
      aMd();
    }
    aMc();
    AppMethodBeat.o(93533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.d.g
 * JD-Core Version:    0.7.0.1
 */