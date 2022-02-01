package com.tencent.mm.audio.mix.d;

import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.c.a;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.compatible.deviceinfo.z;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class d
  extends c
{
  private int BUFFER_SIZE;
  private byte[] buffer;
  private int dcY;
  private com.tencent.mm.compatible.h.c deA;
  private z deB;
  private byte[] deC;
  private int deD;
  private byte[] deE;
  private long duration;
  private int mSize;
  private String mime;
  private long presentationTimeUs;
  
  public d(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(136799);
    this.mime = null;
    this.dcY = 2;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    this.BUFFER_SIZE = 14144;
    this.buffer = new byte[this.BUFFER_SIZE];
    this.deC = new byte[3536];
    this.deD = 3536;
    this.deE = new byte[3536];
    this.mSize = 0;
    AppMethodBeat.o(136799);
  }
  
  private void OU()
  {
    AppMethodBeat.i(136808);
    try
    {
      if (this.deA != null)
      {
        this.deA.gga.release();
        this.deA = null;
      }
      AppMethodBeat.o(136808);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaExtractor", new Object[0]);
      AppMethodBeat.o(136808);
    }
  }
  
  private void OV()
  {
    AppMethodBeat.i(136809);
    try
    {
      if (this.deB != null)
      {
        this.deB.stop();
        this.deB.release();
        this.deB = null;
      }
      AppMethodBeat.o(136809);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaCodec", new Object[0]);
      AppMethodBeat.o(136809);
    }
  }
  
  private void a(com.tencent.mm.audio.mix.a.d paramd, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136805);
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "pushBuffer chunk is null");
      AppMethodBeat.o(136805);
      return;
    }
    int j = paramArrayOfByte.length;
    if (j == 3536)
    {
      if (this.mSize > 0) {
        c(paramd);
      }
      b(paramd, paramArrayOfByte);
      AppMethodBeat.o(136805);
      return;
    }
    if (j != 3536)
    {
      if (j > this.BUFFER_SIZE)
      {
        while (this.BUFFER_SIZE < j) {
          this.BUFFER_SIZE += 3536;
        }
        byte[] arrayOfByte = new byte[this.BUFFER_SIZE];
        if (this.mSize > 0) {
          System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.mSize);
        }
        this.buffer = arrayOfByte;
      }
      int i = this.mSize + j;
      int k = this.mSize;
      System.arraycopy(paramArrayOfByte, 0, this.buffer, k, j);
      j = i / 3536;
      k = i % 3536;
      i = 0;
      while (i < j)
      {
        paramArrayOfByte = new byte[3536];
        System.arraycopy(this.buffer, i * 3536, paramArrayOfByte, 0, 3536);
        b(paramd, paramArrayOfByte);
        i += 1;
      }
      System.arraycopy(this.buffer, j * 3536, this.deE, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.deE, 0, this.buffer, 0, k);
      this.mSize = k;
    }
    AppMethodBeat.o(136805);
  }
  
  private void b(com.tencent.mm.audio.mix.a.d paramd, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136806);
    e locale = com.tencent.mm.audio.mix.b.d.Oq().Op();
    locale.dcZ = paramArrayOfByte;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.dcY = this.dcY;
    paramd.a(locale);
    a(locale);
    AppMethodBeat.o(136806);
  }
  
  /* Error */
  protected final void OM()
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 77
    //   7: ldc 164
    //   9: invokestatic 166	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: new 66	com/tencent/mm/compatible/h/c
    //   16: dup
    //   17: invokespecial 168	com/tencent/mm/compatible/h/c:<init>	()V
    //   20: putfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   23: aload_0
    //   24: getfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   27: aload_0
    //   28: getfield 171	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   31: invokevirtual 175	com/tencent/mm/compatible/h/c:vT	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   38: getfield 70	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
    //   41: invokevirtual 179	android/media/MediaExtractor:getTrackCount	()I
    //   44: istore_2
    //   45: ldc 77
    //   47: ldc 181
    //   49: iconst_1
    //   50: anewarray 81	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: iload_2
    //   56: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokestatic 190	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge +1486 -> 1553
    //   70: aload_0
    //   71: getfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   74: iload_1
    //   75: invokevirtual 194	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   78: astore 10
    //   80: aload_0
    //   81: aload 10
    //   83: ldc 195
    //   85: invokevirtual 201	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 35	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 35	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   95: invokestatic 207	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +91 -> 189
    //   101: aload_0
    //   102: getfield 35	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   105: ldc 209
    //   107: invokevirtual 215	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   110: ifeq +79 -> 189
    //   113: aload 10
    //   115: ifnonnull +81 -> 196
    //   118: ldc 77
    //   120: ldc 217
    //   122: invokestatic 108	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: sipush 703
    //   129: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   137: invokevirtual 223	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   140: aload_0
    //   141: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   144: ldc 162
    //   146: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: return
    //   150: astore 10
    //   152: ldc 77
    //   154: aload 10
    //   156: ldc 227
    //   158: iconst_1
    //   159: anewarray 81	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: getfield 171	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic 87	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_0
    //   173: sipush 702
    //   176: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   179: aload_0
    //   180: invokevirtual 230	com/tencent/mm/audio/mix/d/d:OF	()V
    //   183: ldc 162
    //   185: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: return
    //   189: iload_1
    //   190: iconst_1
    //   191: iadd
    //   192: istore_1
    //   193: goto -128 -> 65
    //   196: ldc 77
    //   198: ldc 232
    //   200: iconst_1
    //   201: anewarray 81	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload 10
    //   208: aastore
    //   209: invokestatic 190	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload_0
    //   213: aload 10
    //   215: ldc 234
    //   217: invokevirtual 238	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   220: putfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   223: aload_0
    //   224: aload 10
    //   226: ldc 240
    //   228: invokevirtual 238	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   231: putfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   234: aload_0
    //   235: aload 10
    //   237: ldc 242
    //   239: invokevirtual 246	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   242: putfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 35	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   250: invokestatic 250	com/tencent/mm/compatible/deviceinfo/z:vI	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   253: putfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   256: aload_0
    //   257: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   260: aload 10
    //   262: aconst_null
    //   263: iconst_0
    //   264: invokevirtual 253	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   267: aload_0
    //   268: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   271: invokevirtual 256	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   274: aload_0
    //   275: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   278: invokevirtual 260	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   281: astore 12
    //   283: aload_0
    //   284: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   287: invokevirtual 263	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   290: astore 11
    //   292: ldc 77
    //   294: ldc_w 265
    //   297: iconst_2
    //   298: anewarray 81	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload 10
    //   305: aastore
    //   306: dup
    //   307: iconst_1
    //   308: aload_0
    //   309: getfield 35	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   312: aastore
    //   313: invokestatic 190	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: ldc 77
    //   318: ldc_w 267
    //   321: iconst_5
    //   322: anewarray 81	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: aload_0
    //   328: getfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   331: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: aastore
    //   335: dup
    //   336: iconst_1
    //   337: aload_0
    //   338: getfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   341: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: dup
    //   346: iconst_2
    //   347: aload_0
    //   348: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   351: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: aastore
    //   355: dup
    //   356: iconst_3
    //   357: aload_0
    //   358: getfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   361: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   364: aastore
    //   365: dup
    //   366: iconst_4
    //   367: aload_0
    //   368: getfield 276	com/tencent/mm/audio/mix/d/d:den	Lcom/tencent/mm/audio/mix/g/b;
    //   371: invokeinterface 282 1 0
    //   376: getfield 287	com/tencent/mm/ai/b:ddg	Ljava/lang/String;
    //   379: aastore
    //   380: invokestatic 190	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: aload_0
    //   384: getfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   387: iconst_0
    //   388: invokevirtual 290	com/tencent/mm/compatible/h/c:selectTrack	(I)V
    //   391: new 292	android/media/MediaCodec$BufferInfo
    //   394: dup
    //   395: invokespecial 293	android/media/MediaCodec$BufferInfo:<init>	()V
    //   398: astore 14
    //   400: iconst_0
    //   401: istore_2
    //   402: aload_0
    //   403: invokevirtual 297	com/tencent/mm/audio/mix/d/d:OI	()Lcom/tencent/mm/audio/mix/a/d;
    //   406: astore 13
    //   408: aload 13
    //   410: invokevirtual 300	com/tencent/mm/audio/mix/a/d:reset	()V
    //   413: aload_0
    //   414: getfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   417: aload_0
    //   418: getfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   421: aload_0
    //   422: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   425: invokestatic 305	com/tencent/mm/audio/mix/f/a:I	(III)Z
    //   428: ifne +40 -> 468
    //   431: ldc 77
    //   433: ldc_w 307
    //   436: invokestatic 108	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload_0
    //   440: new 309	com/tencent/mm/audio/mix/c/d
    //   443: dup
    //   444: aload 13
    //   446: aload_0
    //   447: getfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   450: aload_0
    //   451: getfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   454: aload_0
    //   455: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   458: aload_0
    //   459: getfield 171	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   462: invokespecial 312	com/tencent/mm/audio/mix/c/d:<init>	(Lcom/tencent/mm/audio/mix/a/d;IIILjava/lang/String;)V
    //   465: putfield 316	com/tencent/mm/audio/mix/d/d:dep	Lcom/tencent/mm/audio/mix/c/g;
    //   468: aload 13
    //   470: aload_0
    //   471: getfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   474: ldc2_w 317
    //   477: ldiv
    //   478: putfield 319	com/tencent/mm/audio/mix/a/d:duration	J
    //   481: iconst_0
    //   482: istore_3
    //   483: iconst_0
    //   484: istore_1
    //   485: aload 11
    //   487: astore 10
    //   489: iload_3
    //   490: ifne +931 -> 1421
    //   493: iload_2
    //   494: bipush 50
    //   496: if_icmpge +925 -> 1421
    //   499: aload_0
    //   500: invokevirtual 323	com/tencent/mm/audio/mix/d/d:OH	()Z
    //   503: ifne +918 -> 1421
    //   506: aload_0
    //   507: invokevirtual 326	com/tencent/mm/audio/mix/d/d:OJ	()V
    //   510: iload_2
    //   511: iconst_1
    //   512: iadd
    //   513: istore 4
    //   515: iload_1
    //   516: istore 5
    //   518: iload_1
    //   519: ifne +103 -> 622
    //   522: aload_0
    //   523: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   526: ldc2_w 317
    //   529: invokevirtual 330	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   532: istore 6
    //   534: iload 6
    //   536: iflt +332 -> 868
    //   539: aload 12
    //   541: iload 6
    //   543: aaload
    //   544: astore 11
    //   546: aload_0
    //   547: getfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   550: aload 11
    //   552: iconst_0
    //   553: invokevirtual 334	com/tencent/mm/compatible/h/c:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   556: istore_2
    //   557: iload_2
    //   558: ifge +293 -> 851
    //   561: ldc 77
    //   563: ldc_w 336
    //   566: invokestatic 108	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: iconst_1
    //   570: istore_1
    //   571: iconst_0
    //   572: istore_2
    //   573: aload_0
    //   574: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   577: astore 11
    //   579: aload_0
    //   580: getfield 39	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   583: lstore 7
    //   585: iload_1
    //   586: ifeq +979 -> 1565
    //   589: iconst_4
    //   590: istore 5
    //   592: aload 11
    //   594: iload 6
    //   596: iload_2
    //   597: lload 7
    //   599: iload 5
    //   601: invokevirtual 339	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   604: iload_1
    //   605: ifne +954 -> 1559
    //   608: aload_0
    //   609: getfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   612: getfield 70	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
    //   615: invokevirtual 342	android/media/MediaExtractor:advance	()Z
    //   618: pop
    //   619: goto +940 -> 1559
    //   622: aload_0
    //   623: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   626: aload 14
    //   628: ldc2_w 317
    //   631: invokevirtual 346	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   634: istore_2
    //   635: iload_2
    //   636: iflt +323 -> 959
    //   639: aload 14
    //   641: getfield 349	android/media/MediaCodec$BufferInfo:size	I
    //   644: ifle +903 -> 1547
    //   647: iconst_0
    //   648: istore_1
    //   649: aload 10
    //   651: iload_2
    //   652: aaload
    //   653: astore 11
    //   655: aload 14
    //   657: getfield 349	android/media/MediaCodec$BufferInfo:size	I
    //   660: istore 4
    //   662: iload 4
    //   664: ifle +13 -> 677
    //   667: aload_0
    //   668: aload 13
    //   670: aload 11
    //   672: iload 4
    //   674: invokevirtual 352	com/tencent/mm/audio/mix/d/d:a	(Lcom/tencent/mm/audio/mix/a/d;Ljava/nio/ByteBuffer;I)V
    //   677: aload 11
    //   679: invokevirtual 358	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   682: pop
    //   683: aload_0
    //   684: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   687: iload_2
    //   688: iconst_0
    //   689: invokevirtual 362	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   692: aload 14
    //   694: getfield 365	android/media/MediaCodec$BufferInfo:flags	I
    //   697: iconst_4
    //   698: iand
    //   699: ifeq +13 -> 712
    //   702: ldc 77
    //   704: ldc_w 367
    //   707: invokestatic 108	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: iconst_1
    //   711: istore_3
    //   712: iload_1
    //   713: istore_2
    //   714: iload 5
    //   716: istore_1
    //   717: goto -228 -> 489
    //   720: astore 10
    //   722: ldc 77
    //   724: aload 10
    //   726: ldc_w 369
    //   729: iconst_0
    //   730: anewarray 81	java/lang/Object
    //   733: invokestatic 87	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   736: aload_0
    //   737: sipush 705
    //   740: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   743: aload_0
    //   744: aload_0
    //   745: getfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   748: invokevirtual 223	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   751: aload_0
    //   752: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   755: ldc 162
    //   757: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   760: return
    //   761: astore 10
    //   763: ldc 77
    //   765: aload 10
    //   767: ldc_w 371
    //   770: iconst_0
    //   771: anewarray 81	java/lang/Object
    //   774: invokestatic 87	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   777: aload_0
    //   778: sipush 704
    //   781: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   784: aload_0
    //   785: aload_0
    //   786: getfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   789: invokevirtual 223	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   792: aload_0
    //   793: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   796: aload_0
    //   797: invokespecial 373	com/tencent/mm/audio/mix/d/d:OV	()V
    //   800: ldc 162
    //   802: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   805: return
    //   806: astore 10
    //   808: ldc 77
    //   810: aload 10
    //   812: ldc_w 375
    //   815: iconst_0
    //   816: anewarray 81	java/lang/Object
    //   819: invokestatic 87	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   822: aload_0
    //   823: sipush 716
    //   826: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   829: aload_0
    //   830: aload_0
    //   831: getfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   834: invokevirtual 223	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   837: aload_0
    //   838: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   841: aload_0
    //   842: invokespecial 373	com/tencent/mm/audio/mix/d/d:OV	()V
    //   845: ldc 162
    //   847: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   850: return
    //   851: aload_0
    //   852: aload_0
    //   853: getfield 64	com/tencent/mm/audio/mix/d/d:deA	Lcom/tencent/mm/compatible/h/c;
    //   856: getfield 70	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
    //   859: invokevirtual 379	android/media/MediaExtractor:getSampleTime	()J
    //   862: putfield 39	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   865: goto -292 -> 573
    //   868: ldc 77
    //   870: ldc_w 381
    //   873: iload 6
    //   875: invokestatic 384	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   878: invokevirtual 387	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   881: invokestatic 108	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: iload_1
    //   885: istore 5
    //   887: goto -265 -> 622
    //   890: astore 10
    //   892: ldc 77
    //   894: aload 10
    //   896: ldc 164
    //   898: iconst_0
    //   899: anewarray 81	java/lang/Object
    //   902: invokestatic 87	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   905: aload_0
    //   906: sipush 706
    //   909: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   912: aload_0
    //   913: aload_0
    //   914: getfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   917: invokevirtual 223	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   920: aload_0
    //   921: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   924: aload_0
    //   925: invokespecial 373	com/tencent/mm/audio/mix/d/d:OV	()V
    //   928: aload 13
    //   930: aload_0
    //   931: getfield 276	com/tencent/mm/audio/mix/d/d:den	Lcom/tencent/mm/audio/mix/g/b;
    //   934: invokeinterface 282 1 0
    //   939: getfield 391	com/tencent/mm/ai/b:ddd	Z
    //   942: putfield 392	com/tencent/mm/audio/mix/a/d:ddd	Z
    //   945: ldc 77
    //   947: ldc_w 394
    //   950: invokestatic 166	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: ldc 162
    //   955: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   958: return
    //   959: iload_2
    //   960: bipush 253
    //   962: if_icmpne +29 -> 991
    //   965: aload_0
    //   966: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   969: invokevirtual 263	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   972: astore 10
    //   974: ldc 77
    //   976: ldc_w 396
    //   979: invokestatic 166	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   982: iload 5
    //   984: istore_1
    //   985: iload 4
    //   987: istore_2
    //   988: goto -499 -> 489
    //   991: iload_2
    //   992: bipush 254
    //   994: if_icmpne +403 -> 1397
    //   997: aload_0
    //   998: getfield 91	com/tencent/mm/audio/mix/d/d:deB	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1001: invokevirtual 400	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   1004: astore 11
    //   1006: ldc 77
    //   1008: ldc_w 402
    //   1011: aload 11
    //   1013: invokestatic 405	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1016: invokevirtual 387	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1019: invokestatic 166	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_0
    //   1023: aload 11
    //   1025: ldc 234
    //   1027: invokevirtual 238	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1030: putfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1033: aload_0
    //   1034: aload 11
    //   1036: ldc 240
    //   1038: invokevirtual 238	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1041: putfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   1044: aload 11
    //   1046: ldc_w 407
    //   1049: invokevirtual 410	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1052: ifeq +163 -> 1215
    //   1055: aload_0
    //   1056: aload 11
    //   1058: ldc_w 407
    //   1061: invokevirtual 238	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1064: putfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1067: ldc 77
    //   1069: ldc_w 412
    //   1072: iconst_5
    //   1073: anewarray 81	java/lang/Object
    //   1076: dup
    //   1077: iconst_0
    //   1078: aload_0
    //   1079: getfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1082: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1085: aastore
    //   1086: dup
    //   1087: iconst_1
    //   1088: aload_0
    //   1089: getfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   1092: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1095: aastore
    //   1096: dup
    //   1097: iconst_2
    //   1098: aload_0
    //   1099: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1102: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1105: aastore
    //   1106: dup
    //   1107: iconst_3
    //   1108: aload_0
    //   1109: getfield 276	com/tencent/mm/audio/mix/d/d:den	Lcom/tencent/mm/audio/mix/g/b;
    //   1112: invokeinterface 282 1 0
    //   1117: getfield 287	com/tencent/mm/ai/b:ddg	Ljava/lang/String;
    //   1120: aastore
    //   1121: dup
    //   1122: iconst_4
    //   1123: aload_0
    //   1124: getfield 171	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   1127: aastore
    //   1128: invokestatic 190	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1131: aload_0
    //   1132: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1135: tableswitch	default:+436 -> 1571, 1:+441->1576, 2:+441->1576, 3:+441->1576
    //   1161: ifne +120 -> 1281
    //   1164: ldc 77
    //   1166: ldc_w 414
    //   1169: iconst_1
    //   1170: anewarray 81	java/lang/Object
    //   1173: dup
    //   1174: iconst_0
    //   1175: aload_0
    //   1176: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1179: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1182: aastore
    //   1183: invokestatic 416	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1186: aload_0
    //   1187: sipush 709
    //   1190: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   1193: aload_0
    //   1194: aload_0
    //   1195: getfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   1198: invokevirtual 223	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1201: aload_0
    //   1202: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   1205: aload_0
    //   1206: invokespecial 373	com/tencent/mm/audio/mix/d/d:OV	()V
    //   1209: ldc 162
    //   1211: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1214: return
    //   1215: aload 11
    //   1217: ldc_w 418
    //   1220: invokevirtual 410	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1223: ifeq -156 -> 1067
    //   1226: aload 11
    //   1228: ldc_w 418
    //   1231: invokevirtual 238	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1234: istore_1
    //   1235: iload_1
    //   1236: bipush 16
    //   1238: if_icmpne +29 -> 1267
    //   1241: aload_0
    //   1242: iconst_2
    //   1243: putfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1246: goto -179 -> 1067
    //   1249: astore 10
    //   1251: aload_0
    //   1252: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   1255: aload_0
    //   1256: invokespecial 373	com/tencent/mm/audio/mix/d/d:OV	()V
    //   1259: ldc 162
    //   1261: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1264: aload 10
    //   1266: athrow
    //   1267: iload_1
    //   1268: bipush 8
    //   1270: if_icmpne -203 -> 1067
    //   1273: aload_0
    //   1274: iconst_3
    //   1275: putfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1278: goto -211 -> 1067
    //   1281: aload_0
    //   1282: getfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1285: aload_0
    //   1286: getfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   1289: aload_0
    //   1290: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1293: invokestatic 305	com/tencent/mm/audio/mix/f/a:I	(III)Z
    //   1296: ifeq +50 -> 1346
    //   1299: aload_0
    //   1300: getfield 316	com/tencent/mm/audio/mix/d/d:dep	Lcom/tencent/mm/audio/mix/c/g;
    //   1303: ifnull +43 -> 1346
    //   1306: ldc 77
    //   1308: ldc_w 420
    //   1311: invokestatic 166	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1314: aload_0
    //   1315: getfield 316	com/tencent/mm/audio/mix/d/d:dep	Lcom/tencent/mm/audio/mix/c/g;
    //   1318: invokeinterface 425 1 0
    //   1323: aload_0
    //   1324: getfield 316	com/tencent/mm/audio/mix/d/d:dep	Lcom/tencent/mm/audio/mix/c/g;
    //   1327: invokeinterface 426 1 0
    //   1332: aload_0
    //   1333: aconst_null
    //   1334: putfield 316	com/tencent/mm/audio/mix/d/d:dep	Lcom/tencent/mm/audio/mix/c/g;
    //   1337: iload 5
    //   1339: istore_1
    //   1340: iload 4
    //   1342: istore_2
    //   1343: goto -854 -> 489
    //   1346: iload 5
    //   1348: istore_1
    //   1349: iload 4
    //   1351: istore_2
    //   1352: aload_0
    //   1353: getfield 316	com/tencent/mm/audio/mix/d/d:dep	Lcom/tencent/mm/audio/mix/c/g;
    //   1356: ifnull -867 -> 489
    //   1359: ldc 77
    //   1361: ldc_w 428
    //   1364: invokestatic 166	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1367: aload_0
    //   1368: getfield 316	com/tencent/mm/audio/mix/d/d:dep	Lcom/tencent/mm/audio/mix/c/g;
    //   1371: aload_0
    //   1372: getfield 146	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1375: aload_0
    //   1376: getfield 150	com/tencent/mm/audio/mix/d/d:channels	I
    //   1379: aload_0
    //   1380: getfield 37	com/tencent/mm/audio/mix/d/d:dcY	I
    //   1383: invokeinterface 432 4 0
    //   1388: iload 5
    //   1390: istore_1
    //   1391: iload 4
    //   1393: istore_2
    //   1394: goto -905 -> 489
    //   1397: ldc 77
    //   1399: ldc_w 434
    //   1402: iload_2
    //   1403: invokestatic 384	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1406: invokevirtual 387	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1409: invokestatic 166	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1412: iload 5
    //   1414: istore_1
    //   1415: iload 4
    //   1417: istore_2
    //   1418: goto -929 -> 489
    //   1421: aload_0
    //   1422: getfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   1425: ldc2_w 317
    //   1428: ldiv
    //   1429: aload_0
    //   1430: getfield 39	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   1433: ldc2_w 317
    //   1436: ldiv
    //   1437: lsub
    //   1438: ldc2_w 435
    //   1441: lcmp
    //   1442: ifge +57 -> 1499
    //   1445: iconst_1
    //   1446: istore 9
    //   1448: iload_2
    //   1449: bipush 50
    //   1451: if_icmplt +54 -> 1505
    //   1454: ldc 77
    //   1456: ldc_w 438
    //   1459: iconst_1
    //   1460: anewarray 81	java/lang/Object
    //   1463: dup
    //   1464: iconst_0
    //   1465: iload_2
    //   1466: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1469: aastore
    //   1470: invokestatic 416	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1473: aload_0
    //   1474: sipush 706
    //   1477: putfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   1480: aload_0
    //   1481: aload_0
    //   1482: getfield 220	com/tencent/mm/audio/mix/d/d:deq	I
    //   1485: invokevirtual 223	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1488: aload_0
    //   1489: invokespecial 225	com/tencent/mm/audio/mix/d/d:OU	()V
    //   1492: aload_0
    //   1493: invokespecial 373	com/tencent/mm/audio/mix/d/d:OV	()V
    //   1496: goto -568 -> 928
    //   1499: iconst_0
    //   1500: istore 9
    //   1502: goto -54 -> 1448
    //   1505: ldc 77
    //   1507: ldc_w 440
    //   1510: iconst_1
    //   1511: anewarray 81	java/lang/Object
    //   1514: dup
    //   1515: iconst_0
    //   1516: iload 9
    //   1518: invokestatic 445	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1521: aastore
    //   1522: invokestatic 190	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1525: iload 9
    //   1527: ifeq +12 -> 1539
    //   1530: aload_0
    //   1531: aload 13
    //   1533: invokevirtual 447	com/tencent/mm/audio/mix/d/d:b	(Lcom/tencent/mm/audio/mix/a/d;)V
    //   1536: goto -48 -> 1488
    //   1539: aload 13
    //   1541: invokevirtual 300	com/tencent/mm/audio/mix/a/d:reset	()V
    //   1544: goto -56 -> 1488
    //   1547: iload 4
    //   1549: istore_1
    //   1550: goto -901 -> 649
    //   1553: aconst_null
    //   1554: astore 10
    //   1556: goto -1443 -> 113
    //   1559: iload_1
    //   1560: istore 5
    //   1562: goto -940 -> 622
    //   1565: iconst_0
    //   1566: istore 5
    //   1568: goto -976 -> 592
    //   1571: iconst_0
    //   1572: istore_1
    //   1573: goto -413 -> 1160
    //   1576: iconst_1
    //   1577: istore_1
    //   1578: goto -418 -> 1160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1581	0	this	d
    //   64	1514	1	i	int
    //   44	1422	2	j	int
    //   482	230	3	k	int
    //   513	1035	4	m	int
    //   516	1051	5	n	int
    //   532	342	6	i1	int
    //   583	15	7	l	long
    //   1446	80	9	bool	boolean
    //   78	36	10	localMediaFormat	android.media.MediaFormat
    //   150	154	10	localException1	Exception
    //   487	163	10	localObject1	Object
    //   720	5	10	localException2	Exception
    //   761	5	10	localException3	Exception
    //   806	5	10	localIllegalStateException	java.lang.IllegalStateException
    //   890	5	10	localException4	Exception
    //   972	1	10	arrayOfByteBuffer1	ByteBuffer[]
    //   1249	16	10	localObject2	Object
    //   1554	1	10	localObject3	Object
    //   290	937	11	localObject4	Object
    //   281	259	12	arrayOfByteBuffer2	ByteBuffer[]
    //   406	1134	13	locald	com.tencent.mm.audio.mix.a.d
    //   398	295	14	localBufferInfo	android.media.MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   23	34	150	java/lang/Exception
    //   34	63	720	java/lang/Exception
    //   70	113	720	java/lang/Exception
    //   118	144	720	java/lang/Exception
    //   196	245	720	java/lang/Exception
    //   245	274	761	java/lang/Exception
    //   274	292	806	java/lang/IllegalStateException
    //   499	510	890	java/lang/Exception
    //   522	534	890	java/lang/Exception
    //   546	557	890	java/lang/Exception
    //   561	569	890	java/lang/Exception
    //   573	585	890	java/lang/Exception
    //   592	604	890	java/lang/Exception
    //   608	619	890	java/lang/Exception
    //   622	635	890	java/lang/Exception
    //   639	647	890	java/lang/Exception
    //   655	662	890	java/lang/Exception
    //   667	677	890	java/lang/Exception
    //   677	692	890	java/lang/Exception
    //   692	710	890	java/lang/Exception
    //   851	865	890	java/lang/Exception
    //   868	884	890	java/lang/Exception
    //   965	982	890	java/lang/Exception
    //   997	1067	890	java/lang/Exception
    //   1067	1160	890	java/lang/Exception
    //   1164	1201	890	java/lang/Exception
    //   1215	1235	890	java/lang/Exception
    //   1241	1246	890	java/lang/Exception
    //   1273	1278	890	java/lang/Exception
    //   1281	1337	890	java/lang/Exception
    //   1352	1388	890	java/lang/Exception
    //   1397	1412	890	java/lang/Exception
    //   1421	1445	890	java/lang/Exception
    //   1454	1488	890	java/lang/Exception
    //   1505	1525	890	java/lang/Exception
    //   1530	1536	890	java/lang/Exception
    //   1539	1544	890	java/lang/Exception
    //   499	510	1249	finally
    //   522	534	1249	finally
    //   546	557	1249	finally
    //   561	569	1249	finally
    //   573	585	1249	finally
    //   592	604	1249	finally
    //   608	619	1249	finally
    //   622	635	1249	finally
    //   639	647	1249	finally
    //   655	662	1249	finally
    //   667	677	1249	finally
    //   677	692	1249	finally
    //   692	710	1249	finally
    //   851	865	1249	finally
    //   868	884	1249	finally
    //   892	920	1249	finally
    //   965	982	1249	finally
    //   997	1067	1249	finally
    //   1067	1160	1249	finally
    //   1164	1201	1249	finally
    //   1215	1235	1249	finally
    //   1241	1246	1249	finally
    //   1273	1278	1249	finally
    //   1281	1337	1249	finally
    //   1352	1388	1249	finally
    //   1397	1412	1249	finally
    //   1421	1445	1249	finally
    //   1454	1488	1249	finally
    //   1505	1525	1249	finally
    //   1530	1536	1249	finally
    //   1539	1544	1249	finally
  }
  
  protected void a(com.tencent.mm.audio.mix.a.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(136801);
    if (this.dep != null)
    {
      if (paramInt != this.deD)
      {
        this.deD = paramInt;
        this.deC = new byte[paramInt];
      }
      paramByteBuffer.get(this.deC);
      if (this.den.PA().hOM) {
        a.a(this.deC, OS().hOA);
      }
      this.dep.J(this.deC);
      AppMethodBeat.o(136801);
      return;
    }
    b(paramd, paramByteBuffer, paramInt);
    AppMethodBeat.o(136801);
  }
  
  protected void b(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(136803);
    if (this.dep != null)
    {
      this.dep.Oy();
      if (OH())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
        this.dep.flushCache();
        AppMethodBeat.o(136803);
        return;
      }
      if (OG())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
        this.dep.flushCache();
        ON();
        AppMethodBeat.o(136803);
        return;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
      a(paramd);
      AppMethodBeat.o(136803);
      return;
    }
    c(paramd);
    paramd.complete();
    AppMethodBeat.o(136803);
  }
  
  protected final void b(com.tencent.mm.audio.mix.a.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(136802);
    byte[] arrayOfByte;
    if (3536 == paramInt)
    {
      arrayOfByte = new byte[paramInt];
      paramByteBuffer.get(arrayOfByte);
    }
    for (paramByteBuffer = arrayOfByte;; paramByteBuffer = this.deC)
    {
      if (this.den.PA().hOM) {
        a.a(paramByteBuffer, OS().hOA);
      }
      a(paramd, paramByteBuffer);
      AppMethodBeat.o(136802);
      return;
      if (paramInt != this.deD)
      {
        this.deD = paramInt;
        this.deC = new byte[paramInt];
      }
      Arrays.fill(this.deC, 0, this.deD, (byte)0);
      paramByteBuffer.get(this.deC, 0, this.deD);
    }
  }
  
  protected final void c(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(136804);
    if (this.mSize <= 0)
    {
      AppMethodBeat.o(136804);
      return;
    }
    byte[] arrayOfByte;
    if (this.mSize > 3536)
    {
      int i = this.mSize;
      int j = i / 3536;
      int k = i % 3536;
      i = 0;
      while (i < j)
      {
        arrayOfByte = new byte[3536];
        System.arraycopy(this.buffer, i * 3536, arrayOfByte, 0, 3536);
        b(paramd, arrayOfByte);
        i += 1;
      }
      System.arraycopy(this.buffer, j * 3536, this.deE, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.deE, 0, this.buffer, 0, k);
      this.mSize = k;
    }
    if (this.mSize <= 3536)
    {
      arrayOfByte = new byte[3536];
      System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.mSize);
      b(paramd, arrayOfByte);
      this.mSize = 0;
    }
    AppMethodBeat.o(136804);
  }
  
  public void onRelease()
  {
    AppMethodBeat.i(136807);
    OU();
    OV();
    if (this.dep != null)
    {
      this.dep.Oy();
      this.dep.release();
      this.dep = null;
    }
    this.sourcePath = null;
    this.mime = null;
    this.sampleRate = 0;
    this.channels = 0;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    AppMethodBeat.o(136807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.d
 * JD-Core Version:    0.7.0.1
 */