package com.tencent.mm.audio.mix.d;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.a;
import com.tencent.mm.audio.mix.c.g;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class d
  extends c
{
  private int BUFFER_SIZE;
  private MediaCodec aMR;
  private byte[] buffer;
  private int cel;
  private MediaExtractor cfO;
  private String cfP;
  private byte[] cfQ;
  private int cfR;
  private byte[] cfS;
  private long duration;
  private int mSize;
  private long presentationTimeUs;
  
  public d(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    super(paramd, paramb);
    AppMethodBeat.i(137051);
    this.cfP = null;
    this.cel = 2;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    this.BUFFER_SIZE = 14144;
    this.buffer = new byte[this.BUFFER_SIZE];
    this.cfQ = new byte[3536];
    this.cfR = 3536;
    this.cfS = new byte[3536];
    this.mSize = 0;
    AppMethodBeat.o(137051);
  }
  
  private void DG()
  {
    AppMethodBeat.i(137060);
    try
    {
      if (this.cfO != null)
      {
        this.cfO.release();
        this.cfO = null;
      }
      AppMethodBeat.o(137060);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaExtractor", new Object[0]);
      AppMethodBeat.o(137060);
    }
  }
  
  private void DH()
  {
    AppMethodBeat.i(137061);
    try
    {
      if (this.aMR != null)
      {
        this.aMR.stop();
        this.aMR.release();
        this.aMR = null;
      }
      AppMethodBeat.o(137061);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaCodec", new Object[0]);
      AppMethodBeat.o(137061);
    }
  }
  
  private void a(com.tencent.mm.audio.mix.a.c paramc, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137057);
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "pushBuffer chunk is null");
      AppMethodBeat.o(137057);
      return;
    }
    int j = paramArrayOfByte.length;
    if (j == 3536)
    {
      if (this.mSize > 0) {
        c(paramc);
      }
      b(paramc, paramArrayOfByte);
      AppMethodBeat.o(137057);
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
        b(paramc, paramArrayOfByte);
        i += 1;
      }
      System.arraycopy(this.buffer, j * 3536, this.cfS, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.cfS, 0, this.buffer, 0, k);
      this.mSize = k;
    }
    AppMethodBeat.o(137057);
  }
  
  private void b(com.tencent.mm.audio.mix.a.c paramc, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137058);
    com.tencent.mm.audio.mix.a.d locald = com.tencent.mm.audio.mix.b.c.Dc().Db();
    locald.cem = paramArrayOfByte;
    locald.sampleRate = this.sampleRate;
    locald.channels = this.channels;
    locald.cel = this.cel;
    paramc.a(locald);
    a(locald);
    AppMethodBeat.o(137058);
  }
  
  /* Error */
  protected final void Dy()
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 71
    //   7: ldc 158
    //   9: invokestatic 160	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: new 66	android/media/MediaExtractor
    //   16: dup
    //   17: invokespecial 162	android/media/MediaExtractor:<init>	()V
    //   20: putfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   23: aload_0
    //   24: getfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   27: aload_0
    //   28: getfield 165	com/tencent/mm/audio/mix/d/d:cfF	Ljava/lang/String;
    //   31: invokevirtual 169	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   38: invokevirtual 173	android/media/MediaExtractor:getTrackCount	()I
    //   41: istore_2
    //   42: ldc 71
    //   44: ldc 175
    //   46: iconst_1
    //   47: anewarray 75	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: iload_2
    //   53: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: invokestatic 184	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: iload_2
    //   64: if_icmpge +1458 -> 1522
    //   67: aload_0
    //   68: getfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   71: iload_1
    //   72: invokevirtual 188	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   75: astore 10
    //   77: aload_0
    //   78: aload 10
    //   80: ldc 190
    //   82: invokevirtual 196	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 35	com/tencent/mm/audio/mix/d/d:cfP	Ljava/lang/String;
    //   88: aload_0
    //   89: getfield 35	com/tencent/mm/audio/mix/d/d:cfP	Ljava/lang/String;
    //   92: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +91 -> 186
    //   98: aload_0
    //   99: getfield 35	com/tencent/mm/audio/mix/d/d:cfP	Ljava/lang/String;
    //   102: ldc 204
    //   104: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   107: ifeq +79 -> 186
    //   110: aload 10
    //   112: ifnonnull +81 -> 193
    //   115: ldc 71
    //   117: ldc 212
    //   119: invokestatic 102	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: sipush 703
    //   126: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   134: invokevirtual 218	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   137: aload_0
    //   138: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   141: ldc 156
    //   143: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: return
    //   147: astore 10
    //   149: ldc 71
    //   151: aload 10
    //   153: ldc 222
    //   155: iconst_1
    //   156: anewarray 75	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: getfield 165	com/tencent/mm/audio/mix/d/d:cfF	Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 81	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: sipush 702
    //   173: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   176: aload_0
    //   177: invokevirtual 225	com/tencent/mm/audio/mix/d/d:Dr	()V
    //   180: ldc 156
    //   182: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: return
    //   186: iload_1
    //   187: iconst_1
    //   188: iadd
    //   189: istore_1
    //   190: goto -128 -> 62
    //   193: ldc 71
    //   195: ldc 227
    //   197: iconst_1
    //   198: anewarray 75	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload 10
    //   205: aastore
    //   206: invokestatic 184	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload_0
    //   210: aload 10
    //   212: ldc 229
    //   214: invokevirtual 233	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   217: putfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   220: aload_0
    //   221: aload 10
    //   223: ldc 235
    //   225: invokevirtual 233	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   228: putfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   231: aload_0
    //   232: aload 10
    //   234: ldc 237
    //   236: invokevirtual 241	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   239: putfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   242: aload_0
    //   243: aload_0
    //   244: getfield 35	com/tencent/mm/audio/mix/d/d:cfP	Ljava/lang/String;
    //   247: invokestatic 245	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   250: putfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   253: aload_0
    //   254: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   257: aload 10
    //   259: aconst_null
    //   260: aconst_null
    //   261: iconst_0
    //   262: invokevirtual 249	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   265: aload_0
    //   266: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   269: invokevirtual 252	android/media/MediaCodec:start	()V
    //   272: aload_0
    //   273: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   276: invokevirtual 256	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   279: astore 12
    //   281: aload_0
    //   282: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   285: invokevirtual 259	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   288: astore 11
    //   290: ldc 71
    //   292: ldc_w 261
    //   295: iconst_2
    //   296: anewarray 75	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload 10
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: aload_0
    //   307: getfield 35	com/tencent/mm/audio/mix/d/d:cfP	Ljava/lang/String;
    //   310: aastore
    //   311: invokestatic 184	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: ldc 71
    //   316: ldc_w 263
    //   319: iconst_5
    //   320: anewarray 75	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: aload_0
    //   326: getfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   329: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: aastore
    //   333: dup
    //   334: iconst_1
    //   335: aload_0
    //   336: getfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   339: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: dup
    //   344: iconst_2
    //   345: aload_0
    //   346: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   349: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_3
    //   355: aload_0
    //   356: getfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   359: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   362: aastore
    //   363: dup
    //   364: iconst_4
    //   365: aload_0
    //   366: getfield 272	com/tencent/mm/audio/mix/d/d:cfB	Lcom/tencent/mm/audio/mix/g/b;
    //   369: invokeinterface 278 1 0
    //   374: getfield 283	com/tencent/mm/ag/b:ceu	Ljava/lang/String;
    //   377: aastore
    //   378: invokestatic 184	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: aload_0
    //   382: getfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   385: iconst_0
    //   386: invokevirtual 286	android/media/MediaExtractor:selectTrack	(I)V
    //   389: new 288	android/media/MediaCodec$BufferInfo
    //   392: dup
    //   393: invokespecial 289	android/media/MediaCodec$BufferInfo:<init>	()V
    //   396: astore 14
    //   398: iconst_0
    //   399: istore_2
    //   400: aload_0
    //   401: invokevirtual 293	com/tencent/mm/audio/mix/d/d:Du	()Lcom/tencent/mm/audio/mix/a/c;
    //   404: astore 13
    //   406: aload 13
    //   408: invokevirtual 296	com/tencent/mm/audio/mix/a/c:reset	()V
    //   411: aload_0
    //   412: getfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   415: aload_0
    //   416: getfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   419: aload_0
    //   420: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   423: invokestatic 302	com/tencent/mm/audio/mix/f/a:E	(III)Z
    //   426: ifne +40 -> 466
    //   429: ldc 71
    //   431: ldc_w 304
    //   434: invokestatic 102	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload_0
    //   438: new 306	com/tencent/mm/audio/mix/c/d
    //   441: dup
    //   442: aload 13
    //   444: aload_0
    //   445: getfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   448: aload_0
    //   449: getfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   452: aload_0
    //   453: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   456: aload_0
    //   457: getfield 165	com/tencent/mm/audio/mix/d/d:cfF	Ljava/lang/String;
    //   460: invokespecial 309	com/tencent/mm/audio/mix/c/d:<init>	(Lcom/tencent/mm/audio/mix/a/c;IIILjava/lang/String;)V
    //   463: putfield 313	com/tencent/mm/audio/mix/d/d:cfD	Lcom/tencent/mm/audio/mix/c/g;
    //   466: aload 13
    //   468: aload_0
    //   469: getfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   472: ldc2_w 314
    //   475: ldiv
    //   476: putfield 316	com/tencent/mm/audio/mix/a/c:duration	J
    //   479: iconst_0
    //   480: istore_3
    //   481: iconst_0
    //   482: istore_1
    //   483: aload 11
    //   485: astore 10
    //   487: iload_3
    //   488: ifne +905 -> 1393
    //   491: iload_2
    //   492: bipush 50
    //   494: if_icmpge +899 -> 1393
    //   497: aload_0
    //   498: invokevirtual 320	com/tencent/mm/audio/mix/d/d:Dt	()Z
    //   501: ifne +892 -> 1393
    //   504: aload_0
    //   505: invokevirtual 323	com/tencent/mm/audio/mix/d/d:Dv	()V
    //   508: iload_2
    //   509: iconst_1
    //   510: iadd
    //   511: istore_2
    //   512: iload_1
    //   513: ifne +1024 -> 1537
    //   516: aload_0
    //   517: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   520: ldc2_w 314
    //   523: invokevirtual 327	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   526: istore 6
    //   528: iload 6
    //   530: iflt +330 -> 860
    //   533: aload 12
    //   535: iload 6
    //   537: aaload
    //   538: astore 11
    //   540: aload_0
    //   541: getfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   544: aload 11
    //   546: iconst_0
    //   547: invokevirtual 331	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   550: istore 4
    //   552: iload 4
    //   554: ifge +292 -> 846
    //   557: ldc 71
    //   559: ldc_w 333
    //   562: invokestatic 102	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: iconst_1
    //   566: istore_1
    //   567: iconst_0
    //   568: istore 4
    //   570: aload_0
    //   571: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   574: astore 11
    //   576: aload_0
    //   577: getfield 39	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   580: lstore 7
    //   582: iload_1
    //   583: ifeq +948 -> 1531
    //   586: iconst_4
    //   587: istore 5
    //   589: aload 11
    //   591: iload 6
    //   593: iconst_0
    //   594: iload 4
    //   596: lload 7
    //   598: iload 5
    //   600: invokevirtual 337	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   603: iload_1
    //   604: ifne +924 -> 1528
    //   607: aload_0
    //   608: getfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   611: invokevirtual 340	android/media/MediaExtractor:advance	()Z
    //   614: pop
    //   615: goto +913 -> 1528
    //   618: aload_0
    //   619: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   622: aload 14
    //   624: ldc2_w 314
    //   627: invokevirtual 344	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   630: istore 4
    //   632: iload 4
    //   634: iflt +245 -> 879
    //   637: aload 14
    //   639: getfield 347	android/media/MediaCodec$BufferInfo:size	I
    //   642: ifle +877 -> 1519
    //   645: iconst_0
    //   646: istore_2
    //   647: aload 10
    //   649: iload 4
    //   651: aaload
    //   652: astore 11
    //   654: aload 14
    //   656: getfield 347	android/media/MediaCodec$BufferInfo:size	I
    //   659: istore 5
    //   661: iload 5
    //   663: ifle +13 -> 676
    //   666: aload_0
    //   667: aload 13
    //   669: aload 11
    //   671: iload 5
    //   673: invokevirtual 350	com/tencent/mm/audio/mix/d/d:a	(Lcom/tencent/mm/audio/mix/a/c;Ljava/nio/ByteBuffer;I)V
    //   676: aload 11
    //   678: invokevirtual 356	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   681: pop
    //   682: aload_0
    //   683: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   686: iload 4
    //   688: iconst_0
    //   689: invokevirtual 360	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   692: aload 14
    //   694: getfield 363	android/media/MediaCodec$BufferInfo:flags	I
    //   697: iconst_4
    //   698: iand
    //   699: ifeq +13 -> 712
    //   702: ldc 71
    //   704: ldc_w 365
    //   707: invokestatic 102	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: iconst_1
    //   711: istore_3
    //   712: goto -225 -> 487
    //   715: astore 10
    //   717: ldc 71
    //   719: aload 10
    //   721: ldc_w 367
    //   724: iconst_0
    //   725: anewarray 75	java/lang/Object
    //   728: invokestatic 81	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   731: aload_0
    //   732: sipush 705
    //   735: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   743: invokevirtual 218	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   746: aload_0
    //   747: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   750: ldc 156
    //   752: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   755: return
    //   756: astore 10
    //   758: ldc 71
    //   760: aload 10
    //   762: ldc_w 368
    //   765: iconst_0
    //   766: anewarray 75	java/lang/Object
    //   769: invokestatic 81	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   772: aload_0
    //   773: sipush 704
    //   776: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   779: aload_0
    //   780: aload_0
    //   781: getfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   784: invokevirtual 218	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   787: aload_0
    //   788: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   791: aload_0
    //   792: invokespecial 370	com/tencent/mm/audio/mix/d/d:DH	()V
    //   795: ldc 156
    //   797: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   800: return
    //   801: astore 10
    //   803: ldc 71
    //   805: aload 10
    //   807: ldc_w 372
    //   810: iconst_0
    //   811: anewarray 75	java/lang/Object
    //   814: invokestatic 81	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   817: aload_0
    //   818: sipush 716
    //   821: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   824: aload_0
    //   825: aload_0
    //   826: getfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   829: invokevirtual 218	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   832: aload_0
    //   833: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   836: aload_0
    //   837: invokespecial 370	com/tencent/mm/audio/mix/d/d:DH	()V
    //   840: ldc 156
    //   842: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   845: return
    //   846: aload_0
    //   847: aload_0
    //   848: getfield 64	com/tencent/mm/audio/mix/d/d:cfO	Landroid/media/MediaExtractor;
    //   851: invokevirtual 376	android/media/MediaExtractor:getSampleTime	()J
    //   854: putfield 39	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   857: goto -287 -> 570
    //   860: ldc 71
    //   862: ldc_w 378
    //   865: iload 6
    //   867: invokestatic 381	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   870: invokevirtual 384	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   873: invokestatic 102	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   876: goto +661 -> 1537
    //   879: iload 4
    //   881: bipush 253
    //   883: if_icmpne +23 -> 906
    //   886: aload_0
    //   887: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   890: invokevirtual 259	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   893: astore 10
    //   895: ldc 71
    //   897: ldc_w 386
    //   900: invokestatic 160	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   903: goto -416 -> 487
    //   906: iload 4
    //   908: bipush 254
    //   910: if_icmpne +464 -> 1374
    //   913: aload_0
    //   914: getfield 85	com/tencent/mm/audio/mix/d/d:aMR	Landroid/media/MediaCodec;
    //   917: invokevirtual 390	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   920: astore 11
    //   922: ldc 71
    //   924: ldc_w 392
    //   927: aload 11
    //   929: invokestatic 395	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   932: invokevirtual 384	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   935: invokestatic 160	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: aload_0
    //   939: aload 11
    //   941: ldc 229
    //   943: invokevirtual 233	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   946: putfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   949: aload_0
    //   950: aload 11
    //   952: ldc 235
    //   954: invokevirtual 233	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   957: putfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   960: aload 11
    //   962: ldc_w 397
    //   965: invokevirtual 400	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   968: ifeq +164 -> 1132
    //   971: aload_0
    //   972: aload 11
    //   974: ldc_w 397
    //   977: invokevirtual 233	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   980: putfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   983: ldc 71
    //   985: ldc_w 402
    //   988: iconst_5
    //   989: anewarray 75	java/lang/Object
    //   992: dup
    //   993: iconst_0
    //   994: aload_0
    //   995: getfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   998: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1001: aastore
    //   1002: dup
    //   1003: iconst_1
    //   1004: aload_0
    //   1005: getfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   1008: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1011: aastore
    //   1012: dup
    //   1013: iconst_2
    //   1014: aload_0
    //   1015: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   1018: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1021: aastore
    //   1022: dup
    //   1023: iconst_3
    //   1024: aload_0
    //   1025: getfield 272	com/tencent/mm/audio/mix/d/d:cfB	Lcom/tencent/mm/audio/mix/g/b;
    //   1028: invokeinterface 278 1 0
    //   1033: getfield 283	com/tencent/mm/ag/b:ceu	Ljava/lang/String;
    //   1036: aastore
    //   1037: dup
    //   1038: iconst_4
    //   1039: aload_0
    //   1040: getfield 165	com/tencent/mm/audio/mix/d/d:cfF	Ljava/lang/String;
    //   1043: aastore
    //   1044: invokestatic 184	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1047: aload_0
    //   1048: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   1051: tableswitch	default:+489 -> 1540, 1:+219->1270, 2:+219->1270, 3:+219->1270
    //   1077: iconst_1
    //   1078: ifne +198 -> 1276
    //   1081: ldc 71
    //   1083: ldc_w 404
    //   1086: iconst_1
    //   1087: anewarray 75	java/lang/Object
    //   1090: dup
    //   1091: iconst_0
    //   1092: aload_0
    //   1093: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   1096: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1099: aastore
    //   1100: invokestatic 406	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1103: aload_0
    //   1104: sipush 709
    //   1107: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   1110: aload_0
    //   1111: aload_0
    //   1112: getfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   1115: invokevirtual 218	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1118: aload_0
    //   1119: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   1122: aload_0
    //   1123: invokespecial 370	com/tencent/mm/audio/mix/d/d:DH	()V
    //   1126: ldc 156
    //   1128: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1131: return
    //   1132: aload 11
    //   1134: ldc_w 408
    //   1137: invokevirtual 400	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1140: ifeq -157 -> 983
    //   1143: aload 11
    //   1145: ldc_w 408
    //   1148: invokevirtual 233	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1151: istore 4
    //   1153: iload 4
    //   1155: bipush 16
    //   1157: if_icmpne +80 -> 1237
    //   1160: aload_0
    //   1161: iconst_2
    //   1162: putfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   1165: goto -182 -> 983
    //   1168: astore 10
    //   1170: ldc 71
    //   1172: aload 10
    //   1174: ldc 158
    //   1176: iconst_0
    //   1177: anewarray 75	java/lang/Object
    //   1180: invokestatic 81	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1183: aload_0
    //   1184: sipush 706
    //   1187: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   1190: aload_0
    //   1191: aload_0
    //   1192: getfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   1195: invokevirtual 218	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1198: aload_0
    //   1199: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   1202: aload_0
    //   1203: invokespecial 370	com/tencent/mm/audio/mix/d/d:DH	()V
    //   1206: aload 13
    //   1208: aload_0
    //   1209: getfield 272	com/tencent/mm/audio/mix/d/d:cfB	Lcom/tencent/mm/audio/mix/g/b;
    //   1212: invokeinterface 278 1 0
    //   1217: getfield 412	com/tencent/mm/ag/b:cer	Z
    //   1220: putfield 413	com/tencent/mm/audio/mix/a/c:cer	Z
    //   1223: ldc 71
    //   1225: ldc_w 415
    //   1228: invokestatic 160	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1231: ldc 156
    //   1233: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1236: return
    //   1237: iload 4
    //   1239: bipush 8
    //   1241: if_icmpne -258 -> 983
    //   1244: aload_0
    //   1245: iconst_3
    //   1246: putfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   1249: goto -266 -> 983
    //   1252: astore 10
    //   1254: aload_0
    //   1255: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   1258: aload_0
    //   1259: invokespecial 370	com/tencent/mm/audio/mix/d/d:DH	()V
    //   1262: ldc 156
    //   1264: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1267: aload 10
    //   1269: athrow
    //   1270: iconst_1
    //   1271: istore 4
    //   1273: goto -197 -> 1076
    //   1276: aload_0
    //   1277: getfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1280: aload_0
    //   1281: getfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   1284: aload_0
    //   1285: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   1288: invokestatic 302	com/tencent/mm/audio/mix/f/a:E	(III)Z
    //   1291: ifeq +44 -> 1335
    //   1294: aload_0
    //   1295: getfield 313	com/tencent/mm/audio/mix/d/d:cfD	Lcom/tencent/mm/audio/mix/c/g;
    //   1298: ifnull +37 -> 1335
    //   1301: ldc 71
    //   1303: ldc_w 417
    //   1306: invokestatic 160	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1309: aload_0
    //   1310: getfield 313	com/tencent/mm/audio/mix/d/d:cfD	Lcom/tencent/mm/audio/mix/c/g;
    //   1313: invokeinterface 422 1 0
    //   1318: aload_0
    //   1319: getfield 313	com/tencent/mm/audio/mix/d/d:cfD	Lcom/tencent/mm/audio/mix/c/g;
    //   1322: invokeinterface 423 1 0
    //   1327: aload_0
    //   1328: aconst_null
    //   1329: putfield 313	com/tencent/mm/audio/mix/d/d:cfD	Lcom/tencent/mm/audio/mix/c/g;
    //   1332: goto -845 -> 487
    //   1335: aload_0
    //   1336: getfield 313	com/tencent/mm/audio/mix/d/d:cfD	Lcom/tencent/mm/audio/mix/c/g;
    //   1339: ifnull +207 -> 1546
    //   1342: ldc 71
    //   1344: ldc_w 425
    //   1347: invokestatic 160	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1350: aload_0
    //   1351: getfield 313	com/tencent/mm/audio/mix/d/d:cfD	Lcom/tencent/mm/audio/mix/c/g;
    //   1354: aload_0
    //   1355: getfield 140	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1358: aload_0
    //   1359: getfield 144	com/tencent/mm/audio/mix/d/d:channels	I
    //   1362: aload_0
    //   1363: getfield 37	com/tencent/mm/audio/mix/d/d:cel	I
    //   1366: invokeinterface 429 4 0
    //   1371: goto +175 -> 1546
    //   1374: ldc 71
    //   1376: ldc_w 431
    //   1379: iload 4
    //   1381: invokestatic 381	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1384: invokevirtual 384	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1387: invokestatic 160	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1390: goto -903 -> 487
    //   1393: aload_0
    //   1394: getfield 41	com/tencent/mm/audio/mix/d/d:duration	J
    //   1397: ldc2_w 314
    //   1400: ldiv
    //   1401: aload_0
    //   1402: getfield 39	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   1405: ldc2_w 314
    //   1408: ldiv
    //   1409: lsub
    //   1410: ldc2_w 432
    //   1413: lcmp
    //   1414: ifge +57 -> 1471
    //   1417: iconst_1
    //   1418: istore 9
    //   1420: iload_2
    //   1421: bipush 50
    //   1423: if_icmplt +54 -> 1477
    //   1426: ldc 71
    //   1428: ldc_w 435
    //   1431: iconst_1
    //   1432: anewarray 75	java/lang/Object
    //   1435: dup
    //   1436: iconst_0
    //   1437: iload_2
    //   1438: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1441: aastore
    //   1442: invokestatic 406	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1445: aload_0
    //   1446: sipush 706
    //   1449: putfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   1452: aload_0
    //   1453: aload_0
    //   1454: getfield 215	com/tencent/mm/audio/mix/d/d:cfE	I
    //   1457: invokevirtual 218	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1460: aload_0
    //   1461: invokespecial 220	com/tencent/mm/audio/mix/d/d:DG	()V
    //   1464: aload_0
    //   1465: invokespecial 370	com/tencent/mm/audio/mix/d/d:DH	()V
    //   1468: goto -262 -> 1206
    //   1471: iconst_0
    //   1472: istore 9
    //   1474: goto -54 -> 1420
    //   1477: ldc 71
    //   1479: ldc_w 437
    //   1482: iconst_1
    //   1483: anewarray 75	java/lang/Object
    //   1486: dup
    //   1487: iconst_0
    //   1488: iload 9
    //   1490: invokestatic 442	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1493: aastore
    //   1494: invokestatic 184	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1497: iload 9
    //   1499: ifeq +12 -> 1511
    //   1502: aload_0
    //   1503: aload 13
    //   1505: invokevirtual 444	com/tencent/mm/audio/mix/d/d:b	(Lcom/tencent/mm/audio/mix/a/c;)V
    //   1508: goto -48 -> 1460
    //   1511: aload 13
    //   1513: invokevirtual 296	com/tencent/mm/audio/mix/a/c:reset	()V
    //   1516: goto -56 -> 1460
    //   1519: goto -872 -> 647
    //   1522: aconst_null
    //   1523: astore 10
    //   1525: goto -1415 -> 110
    //   1528: goto -910 -> 618
    //   1531: iconst_0
    //   1532: istore 5
    //   1534: goto -945 -> 589
    //   1537: goto -919 -> 618
    //   1540: iconst_0
    //   1541: istore 4
    //   1543: goto -467 -> 1076
    //   1546: goto -1059 -> 487
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1549	0	this	d
    //   61	543	1	i	int
    //   41	1397	2	j	int
    //   480	232	3	k	int
    //   550	992	4	m	int
    //   587	946	5	n	int
    //   526	340	6	i1	int
    //   580	17	7	l	long
    //   1418	80	9	bool	boolean
    //   75	36	10	localMediaFormat	android.media.MediaFormat
    //   147	155	10	localException1	Exception
    //   485	163	10	localObject1	Object
    //   715	5	10	localException2	Exception
    //   756	5	10	localException3	Exception
    //   801	5	10	localIllegalStateException	java.lang.IllegalStateException
    //   893	1	10	arrayOfByteBuffer1	ByteBuffer[]
    //   1168	5	10	localException4	Exception
    //   1252	16	10	localObject2	Object
    //   1523	1	10	localObject3	Object
    //   288	856	11	localObject4	Object
    //   279	255	12	arrayOfByteBuffer2	ByteBuffer[]
    //   404	1108	13	localc	com.tencent.mm.audio.mix.a.c
    //   396	297	14	localBufferInfo	android.media.MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   23	34	147	java/lang/Exception
    //   34	60	715	java/lang/Exception
    //   67	110	715	java/lang/Exception
    //   115	141	715	java/lang/Exception
    //   193	242	715	java/lang/Exception
    //   242	272	756	java/lang/Exception
    //   272	290	801	java/lang/IllegalStateException
    //   497	508	1168	java/lang/Exception
    //   516	528	1168	java/lang/Exception
    //   540	552	1168	java/lang/Exception
    //   557	565	1168	java/lang/Exception
    //   570	582	1168	java/lang/Exception
    //   589	603	1168	java/lang/Exception
    //   607	615	1168	java/lang/Exception
    //   618	632	1168	java/lang/Exception
    //   637	645	1168	java/lang/Exception
    //   654	661	1168	java/lang/Exception
    //   666	676	1168	java/lang/Exception
    //   676	692	1168	java/lang/Exception
    //   692	710	1168	java/lang/Exception
    //   846	857	1168	java/lang/Exception
    //   860	876	1168	java/lang/Exception
    //   886	903	1168	java/lang/Exception
    //   913	983	1168	java/lang/Exception
    //   983	1076	1168	java/lang/Exception
    //   1081	1118	1168	java/lang/Exception
    //   1132	1153	1168	java/lang/Exception
    //   1160	1165	1168	java/lang/Exception
    //   1244	1249	1168	java/lang/Exception
    //   1276	1332	1168	java/lang/Exception
    //   1335	1371	1168	java/lang/Exception
    //   1374	1390	1168	java/lang/Exception
    //   1393	1417	1168	java/lang/Exception
    //   1426	1460	1168	java/lang/Exception
    //   1477	1497	1168	java/lang/Exception
    //   1502	1508	1168	java/lang/Exception
    //   1511	1516	1168	java/lang/Exception
    //   497	508	1252	finally
    //   516	528	1252	finally
    //   540	552	1252	finally
    //   557	565	1252	finally
    //   570	582	1252	finally
    //   589	603	1252	finally
    //   607	615	1252	finally
    //   618	632	1252	finally
    //   637	645	1252	finally
    //   654	661	1252	finally
    //   666	676	1252	finally
    //   676	692	1252	finally
    //   692	710	1252	finally
    //   846	857	1252	finally
    //   860	876	1252	finally
    //   886	903	1252	finally
    //   913	983	1252	finally
    //   983	1076	1252	finally
    //   1081	1118	1252	finally
    //   1132	1153	1252	finally
    //   1160	1165	1252	finally
    //   1170	1198	1252	finally
    //   1244	1249	1252	finally
    //   1276	1332	1252	finally
    //   1335	1371	1252	finally
    //   1374	1390	1252	finally
    //   1393	1417	1252	finally
    //   1426	1460	1252	finally
    //   1477	1497	1252	finally
    //   1502	1508	1252	finally
    //   1511	1516	1252	finally
  }
  
  protected void a(com.tencent.mm.audio.mix.a.c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(137053);
    if (this.cfD != null)
    {
      if (paramInt != this.cfR)
      {
        this.cfR = paramInt;
        this.cfQ = new byte[paramInt];
      }
      paramByteBuffer.get(this.cfQ);
      if (this.cfB.En().frj) {
        a.a(this.cfQ, DE().fra);
      }
      this.cfD.E(this.cfQ);
      AppMethodBeat.o(137053);
      return;
    }
    b(paramc, paramByteBuffer, paramInt);
    AppMethodBeat.o(137053);
  }
  
  protected void b(com.tencent.mm.audio.mix.a.c paramc)
  {
    AppMethodBeat.i(137055);
    if (this.cfD != null)
    {
      this.cfD.Dk();
      if (Dt())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
        this.cfD.flushCache();
        AppMethodBeat.o(137055);
        return;
      }
      if (Ds())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
        this.cfD.flushCache();
        Dz();
        AppMethodBeat.o(137055);
        return;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
      a(paramc);
      AppMethodBeat.o(137055);
      return;
    }
    c(paramc);
    paramc.complete();
    AppMethodBeat.o(137055);
  }
  
  protected final void b(com.tencent.mm.audio.mix.a.c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(137054);
    byte[] arrayOfByte;
    if (3536 == paramInt)
    {
      arrayOfByte = new byte[paramInt];
      paramByteBuffer.get(arrayOfByte);
    }
    for (paramByteBuffer = arrayOfByte;; paramByteBuffer = this.cfQ)
    {
      if (this.cfB.En().frj) {
        a.a(paramByteBuffer, DE().fra);
      }
      a(paramc, paramByteBuffer);
      AppMethodBeat.o(137054);
      return;
      if (paramInt != this.cfR)
      {
        this.cfR = paramInt;
        this.cfQ = new byte[paramInt];
      }
      Arrays.fill(this.cfQ, 0, this.cfR, (byte)0);
      paramByteBuffer.get(this.cfQ, 0, this.cfR);
    }
  }
  
  protected final void c(com.tencent.mm.audio.mix.a.c paramc)
  {
    AppMethodBeat.i(137056);
    if (this.mSize <= 0)
    {
      AppMethodBeat.o(137056);
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
        b(paramc, arrayOfByte);
        i += 1;
      }
      System.arraycopy(this.buffer, j * 3536, this.cfS, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.cfS, 0, this.buffer, 0, k);
      this.mSize = k;
    }
    if (this.mSize <= 3536)
    {
      arrayOfByte = new byte[3536];
      System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.mSize);
      b(paramc, arrayOfByte);
      this.mSize = 0;
    }
    AppMethodBeat.o(137056);
  }
  
  public void onRelease()
  {
    AppMethodBeat.i(137059);
    DG();
    DH();
    if (this.cfD != null)
    {
      this.cfD.Dk();
      this.cfD.release();
      this.cfD = null;
    }
    this.cfF = null;
    this.cfP = null;
    this.sampleRate = 0;
    this.channels = 0;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    AppMethodBeat.o(137059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.d
 * JD-Core Version:    0.7.0.1
 */