package com.tencent.mm.media.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "codeOver", "", "drainDecoder", "readNextSample", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private static final String TAG = "MicroMsg.MediaCodecAACDecoder";
  private static final long eSh = 60000L;
  public static final c.a eSi;
  private boolean codeOver;
  
  static
  {
    AppMethodBeat.i(12855);
    eSi = new c.a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoder";
    eSh = 60000L;
    AppMethodBeat.o(12855);
  }
  
  public c(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2, m<? super byte[], ? super Long, y> paramm, a.f.a.a<y> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(12854);
    Uy().start();
    AppMethodBeat.o(12854);
  }
  
  private final boolean UB()
  {
    AppMethodBeat.i(12851);
    int m;
    try
    {
      synchronized (this.eRH)
      {
        if (this.eRE) {
          ab.i(TAG, "readNextSample decoder stop");
        }
        y localy = y.BMg;
        this.eRI = bo.yB();
        m = Uy().dequeueInputBuffer(100L);
        if (m < 0) {
          UC();
        }
        if (m >= 0) {
          break label120;
        }
        AppMethodBeat.o(12851);
        return false;
      }
      AppMethodBeat.o(12851);
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
    }
    return true;
    label120:
    ab.i(TAG, "inputIndex: ".concat(String.valueOf(m)));
    this.eRI = bo.yB();
    Object localObject2 = Uy().getInputBuffers()[m];
    if (localObject2 != null) {
      ((ByteBuffer)localObject2).clear();
    }
    com.tencent.mm.media.e.a locala = this.eRM;
    j.p(localObject2, "inputBuffer");
    if (!locala.g((ByteBuffer)localObject2)) {
      ab.i(TAG, "read sample end");
    }
    for (int i = 1;; i = 0)
    {
      long l = 0L;
      int j;
      if (i == 0)
      {
        j = this.eRM.sampleSize;
        ((ByteBuffer)localObject2).position(0);
        l = this.eRM.getSampleTime();
        ab.i(TAG, "sampleTime : " + l + ", sampleSize:" + j);
        if ((j < 0) || (l >= this.eRN * 1000L))
        {
          ab.i(TAG, "sawInputEOS");
          i = 1;
        }
      }
      for (;;)
      {
        localObject2 = Uy();
        if (i != 0) {}
        for (int k = 4;; k = 0)
        {
          ((MediaCodec)localObject2).queueInputBuffer(m, 0, j, l, k);
          if (i != 0) {
            UA();
          }
          UC();
          break;
        }
        continue;
        j = 0;
      }
    }
  }
  
  /* Error */
  private final void UC()
  {
    // Byte code:
    //   0: sipush 12852
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 101	com/tencent/mm/media/c/a:eRH	Ljava/lang/Object;
    //   10: astore 4
    //   12: aload 4
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 104	com/tencent/mm/media/c/a:eRE	Z
    //   19: ifeq +21 -> 40
    //   22: getstatic 63	com/tencent/mm/media/c/c:TAG	Ljava/lang/String;
    //   25: ldc 233
    //   27: invokestatic 111	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload 4
    //   32: monitorexit
    //   33: sipush 12852
    //   36: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: return
    //   40: getstatic 117	a/y:BMg	La/y;
    //   43: astore 5
    //   45: aload 4
    //   47: monitorexit
    //   48: new 235	android/media/MediaCodec$BufferInfo
    //   51: dup
    //   52: invokespecial 237	android/media/MediaCodec$BufferInfo:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc 239
    //   61: invokestatic 77	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   64: aload_0
    //   65: aload 4
    //   67: putfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   70: aload_0
    //   71: invokevirtual 86	com/tencent/mm/media/c/c:Uy	()Landroid/media/MediaCodec;
    //   74: aload_0
    //   75: getfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   78: getstatic 65	com/tencent/mm/media/c/c:eSh	J
    //   81: invokevirtual 247	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   84: istore_1
    //   85: iload_1
    //   86: iflt +58 -> 144
    //   89: aload_0
    //   90: invokevirtual 86	com/tencent/mm/media/c/c:Uy	()Landroid/media/MediaCodec;
    //   93: invokevirtual 250	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   96: iload_1
    //   97: aaload
    //   98: astore 4
    //   100: aload 4
    //   102: ifnonnull +63 -> 165
    //   105: getstatic 63	com/tencent/mm/media/c/c:TAG	Ljava/lang/String;
    //   108: ldc 252
    //   110: invokestatic 255	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: sipush 12852
    //   116: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore 4
    //   122: aload_0
    //   123: iconst_1
    //   124: putfield 257	com/tencent/mm/media/c/c:codeOver	Z
    //   127: getstatic 63	com/tencent/mm/media/c/c:TAG	Ljava/lang/String;
    //   130: aload 4
    //   132: checkcast 137	java/lang/Throwable
    //   135: ldc 138
    //   137: iconst_0
    //   138: anewarray 140	java/lang/Object
    //   141: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: sipush 12852
    //   147: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore 5
    //   153: aload 4
    //   155: monitorexit
    //   156: sipush 12852
    //   159: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload 5
    //   164: athrow
    //   165: aload_0
    //   166: getfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   169: getfield 260	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   172: lstore_2
    //   173: getstatic 63	com/tencent/mm/media/c/c:TAG	Ljava/lang/String;
    //   176: ldc_w 262
    //   179: lload_2
    //   180: invokestatic 265	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   183: invokevirtual 156	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   186: invokestatic 111	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: lload_2
    //   190: aload_0
    //   191: getfield 268	com/tencent/mm/media/c/a:aZw	J
    //   194: ldc2_w 221
    //   197: lmul
    //   198: lcmp
    //   199: ifge +71 -> 270
    //   202: aload_0
    //   203: getfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   206: getfield 271	android/media/MediaCodec$BufferInfo:flags	I
    //   209: iconst_4
    //   210: iand
    //   211: ifne +59 -> 270
    //   214: aload_0
    //   215: invokevirtual 86	com/tencent/mm/media/c/c:Uy	()Landroid/media/MediaCodec;
    //   218: iload_1
    //   219: iconst_0
    //   220: invokevirtual 275	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   223: getstatic 63	com/tencent/mm/media/c/c:TAG	Ljava/lang/String;
    //   226: new 196	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 277
    //   233: invokespecial 201	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: lload_2
    //   237: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: ldc_w 279
    //   243: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: getfield 268	com/tencent/mm/media/c/a:aZw	J
    //   250: ldc2_w 221
    //   253: lmul
    //   254: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   257: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 111	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: sipush 12852
    //   266: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: return
    //   270: aload_0
    //   271: getfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   274: getfield 282	android/media/MediaCodec$BufferInfo:size	I
    //   277: ifle +13 -> 290
    //   280: aload_0
    //   281: aload 4
    //   283: aload_0
    //   284: getfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   287: invokevirtual 285	com/tencent/mm/media/c/c:e	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   290: aload_0
    //   291: invokevirtual 86	com/tencent/mm/media/c/c:Uy	()Landroid/media/MediaCodec;
    //   294: iload_1
    //   295: iconst_0
    //   296: invokevirtual 275	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   299: aload_0
    //   300: getfield 220	com/tencent/mm/media/c/a:eRN	J
    //   303: ldc2_w 221
    //   306: lmul
    //   307: lconst_1
    //   308: lcmp
    //   309: ifeq +36 -> 345
    //   312: lload_2
    //   313: aload_0
    //   314: getfield 220	com/tencent/mm/media/c/a:eRN	J
    //   317: ldc2_w 221
    //   320: lmul
    //   321: lcmp
    //   322: iflt +23 -> 345
    //   325: getstatic 63	com/tencent/mm/media/c/c:TAG	Ljava/lang/String;
    //   328: ldc_w 287
    //   331: invokestatic 255	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload_0
    //   335: invokevirtual 231	com/tencent/mm/media/c/c:UA	()V
    //   338: sipush 12852
    //   341: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: return
    //   345: aload_0
    //   346: getfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   349: getfield 271	android/media/MediaCodec$BufferInfo:flags	I
    //   352: iconst_4
    //   353: iand
    //   354: ifeq +23 -> 377
    //   357: getstatic 63	com/tencent/mm/media/c/c:TAG	Ljava/lang/String;
    //   360: ldc_w 289
    //   363: invokestatic 111	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 231	com/tencent/mm/media/c/c:UA	()V
    //   370: sipush 12852
    //   373: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: return
    //   377: aload_0
    //   378: invokevirtual 86	com/tencent/mm/media/c/c:Uy	()Landroid/media/MediaCodec;
    //   381: aload_0
    //   382: getfield 243	com/tencent/mm/media/c/a:eRL	Landroid/media/MediaCodec$BufferInfo;
    //   385: getstatic 65	com/tencent/mm/media/c/c:eSh	J
    //   388: invokevirtual 247	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   391: istore_1
    //   392: goto -307 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	c
    //   84	308	1	i	int
    //   172	141	2	l	long
    //   120	162	4	localException	Exception
    //   43	1	5	localy	y
    //   151	12	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	120	java/lang/Exception
    //   30	39	120	java/lang/Exception
    //   45	85	120	java/lang/Exception
    //   89	100	120	java/lang/Exception
    //   105	119	120	java/lang/Exception
    //   153	165	120	java/lang/Exception
    //   165	269	120	java/lang/Exception
    //   270	290	120	java/lang/Exception
    //   290	344	120	java/lang/Exception
    //   345	376	120	java/lang/Exception
    //   377	392	120	java/lang/Exception
    //   15	30	151	finally
    //   40	45	151	finally
  }
  
  public final void Uz()
  {
    AppMethodBeat.i(12853);
    while ((!this.codeOver) && (!this.eRE)) {
      UB();
    }
    UA();
    AppMethodBeat.o(12853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.c.c
 * JD-Core Version:    0.7.0.1
 */