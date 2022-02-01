package com.tencent.mm.audio.mix.decode;

import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.compatible.deviceinfo.aa;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class d
  extends c
{
  private static int fon = 0;
  private static int foo = 0;
  private int BUFFER_SIZE;
  private String aFM;
  private byte[] buffer;
  private long duration;
  private int fmx;
  private MediaExtractor fog;
  private aa foh;
  private g foi;
  private long foj;
  private byte[] fok;
  private int fol;
  private byte[] fom;
  private int mSize;
  
  public d(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.c paramc)
  {
    super(paramd, paramc);
    AppMethodBeat.i(136799);
    this.aFM = null;
    this.fmx = 2;
    this.foj = 0L;
    this.duration = 0L;
    this.BUFFER_SIZE = 14144;
    this.buffer = new byte[this.BUFFER_SIZE];
    this.fok = new byte[3536];
    this.fol = 3536;
    this.fom = new byte[3536];
    this.mSize = 0;
    AppMethodBeat.o(136799);
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
      System.arraycopy(this.buffer, j * 3536, this.fom, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.fom, 0, this.buffer, 0, k);
      this.mSize = k;
    }
    AppMethodBeat.o(136805);
  }
  
  private void adV()
  {
    AppMethodBeat.i(136808);
    try
    {
      if (this.fog != null)
      {
        this.fog.release();
        this.fog = null;
      }
      adX();
      AppMethodBeat.o(136808);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaExtractor", new Object[0]);
      }
    }
  }
  
  private void adW()
  {
    AppMethodBeat.i(136809);
    try
    {
      if (this.foh != null)
      {
        this.foh.stop();
        this.foh.release();
        this.foh = null;
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
  
  private void adX()
  {
    AppMethodBeat.i(257468);
    try
    {
      if (this.foi != null)
      {
        this.foi.close();
        this.foi = null;
      }
      AppMethodBeat.o(257468);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseDataSource", new Object[0]);
      AppMethodBeat.o(257468);
    }
  }
  
  private void b(com.tencent.mm.audio.mix.a.d paramd, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136806);
    com.tencent.mm.audio.mix.a.e locale = com.tencent.mm.audio.mix.b.e.adq().adp();
    locale.fmy = paramArrayOfByte;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.fmx = this.fmx;
    paramd.a(locale);
    a(locale);
    AppMethodBeat.o(136806);
  }
  
  protected void a(com.tencent.mm.audio.mix.a.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(136801);
    if (this.fnT != null)
    {
      if (paramInt != this.fol)
      {
        this.fol = paramInt;
        this.fok = new byte[paramInt];
      }
      paramByteBuffer.get(this.fok);
      if (this.fnR.aeD().lzW) {
        com.tencent.mm.audio.mix.c.a.a(this.fok, adT().lzK);
      }
      this.fnT.ae(this.fok);
      AppMethodBeat.o(136801);
      return;
    }
    b(paramd, paramByteBuffer, paramInt);
    AppMethodBeat.o(136801);
  }
  
  /* Error */
  protected final void adN()
  {
    // Byte code:
    //   0: ldc 226
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 72
    //   7: ldc 228
    //   9: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: new 107	android/media/MediaExtractor
    //   16: dup
    //   17: invokespecial 232	android/media/MediaExtractor:<init>	()V
    //   20: putfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   23: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 23
    //   28: if_icmplt +217 -> 245
    //   31: aload_0
    //   32: getfield 241	com/tencent/mm/audio/mix/decode/d:fnS	Lcom/tencent/mm/al/b;
    //   35: getfield 244	com/tencent/mm/al/b:fnV	Ljava/lang/String;
    //   38: ifnull +207 -> 245
    //   41: aload_0
    //   42: getfield 241	com/tencent/mm/audio/mix/decode/d:fnS	Lcom/tencent/mm/al/b;
    //   45: getfield 244	com/tencent/mm/al/b:fnV	Ljava/lang/String;
    //   48: ldc 246
    //   50: invokevirtual 252	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   53: ifeq +192 -> 245
    //   56: aload_0
    //   57: getfield 241	com/tencent/mm/audio/mix/decode/d:fnS	Lcom/tencent/mm/al/b;
    //   60: getfield 256	com/tencent/mm/al/b:lzY	Ljava/nio/ByteBuffer;
    //   63: ifnull +182 -> 245
    //   66: ldc 72
    //   68: ldc_w 258
    //   71: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: new 260	com/tencent/mm/plugin/music/g/a
    //   77: dup
    //   78: aload_0
    //   79: getfield 241	com/tencent/mm/audio/mix/decode/d:fnS	Lcom/tencent/mm/al/b;
    //   82: getfield 256	com/tencent/mm/al/b:lzY	Ljava/nio/ByteBuffer;
    //   85: invokespecial 263	com/tencent/mm/plugin/music/g/a:<init>	(Ljava/nio/ByteBuffer;)V
    //   88: astore 11
    //   90: aload_0
    //   91: getfield 136	com/tencent/mm/audio/mix/decode/d:foi	Lcom/tencent/mm/audio/mix/decode/g;
    //   94: ifnull +10 -> 104
    //   97: aload_0
    //   98: getfield 136	com/tencent/mm/audio/mix/decode/d:foi	Lcom/tencent/mm/audio/mix/decode/g;
    //   101: invokevirtual 141	com/tencent/mm/audio/mix/decode/g:close	()V
    //   104: aload_0
    //   105: new 138	com/tencent/mm/audio/mix/decode/g
    //   108: dup
    //   109: aload 11
    //   111: invokespecial 266	com/tencent/mm/audio/mix/decode/g:<init>	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)V
    //   114: putfield 136	com/tencent/mm/audio/mix/decode/d:foi	Lcom/tencent/mm/audio/mix/decode/g;
    //   117: aload_0
    //   118: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   121: aload_0
    //   122: getfield 136	com/tencent/mm/audio/mix/decode/d:foi	Lcom/tencent/mm/audio/mix/decode/g;
    //   125: invokevirtual 270	android/media/MediaExtractor:setDataSource	(Landroid/media/MediaDataSource;)V
    //   128: aload_0
    //   129: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   132: invokevirtual 274	android/media/MediaExtractor:getTrackCount	()I
    //   135: istore_2
    //   136: ldc 72
    //   138: ldc_w 276
    //   141: iconst_1
    //   142: anewarray 117	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: iload_2
    //   148: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: iconst_0
    //   156: istore_1
    //   157: iload_1
    //   158: iload_2
    //   159: if_icmpge +1966 -> 2125
    //   162: aload_0
    //   163: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   166: iload_1
    //   167: invokevirtual 289	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   170: astore 11
    //   172: aload_0
    //   173: aload 11
    //   175: ldc_w 291
    //   178: invokevirtual 297	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: putfield 46	com/tencent/mm/audio/mix/decode/d:aFM	Ljava/lang/String;
    //   184: aload_0
    //   185: getfield 46	com/tencent/mm/audio/mix/decode/d:aFM	Ljava/lang/String;
    //   188: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +112 -> 303
    //   194: aload_0
    //   195: getfield 46	com/tencent/mm/audio/mix/decode/d:aFM	Ljava/lang/String;
    //   198: ldc_w 305
    //   201: invokevirtual 252	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   204: ifeq +99 -> 303
    //   207: aload 11
    //   209: ifnonnull +101 -> 310
    //   212: ldc 72
    //   214: ldc_w 307
    //   217: invokestatic 80	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: sipush 703
    //   224: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   232: invokevirtual 313	com/tencent/mm/audio/mix/decode/d:kv	(I)V
    //   235: aload_0
    //   236: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   239: ldc 226
    //   241: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: return
    //   245: aload_0
    //   246: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   249: aload_0
    //   250: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   253: invokevirtual 321	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   256: goto -128 -> 128
    //   259: astore 11
    //   261: ldc 72
    //   263: aload 11
    //   265: ldc_w 323
    //   268: iconst_1
    //   269: anewarray 117	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: aload_0
    //   275: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   278: aastore
    //   279: invokestatic 121	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload_0
    //   283: sipush 702
    //   286: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   289: aload_0
    //   290: invokevirtual 326	com/tencent/mm/audio/mix/decode/d:adG	()V
    //   293: aload_0
    //   294: invokespecial 113	com/tencent/mm/audio/mix/decode/d:adX	()V
    //   297: ldc 226
    //   299: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: iload_1
    //   304: iconst_1
    //   305: iadd
    //   306: istore_1
    //   307: goto -150 -> 157
    //   310: ldc 72
    //   312: ldc_w 328
    //   315: iconst_1
    //   316: anewarray 117	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: aload 11
    //   323: aastore
    //   324: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: aload_0
    //   328: aload 11
    //   330: ldc_w 330
    //   333: invokevirtual 334	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   336: putfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   339: aload_0
    //   340: aload 11
    //   342: ldc_w 336
    //   345: invokevirtual 334	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   348: putfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   351: aload_0
    //   352: aload 11
    //   354: ldc_w 338
    //   357: invokevirtual 342	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   360: putfield 52	com/tencent/mm/audio/mix/decode/d:duration	J
    //   363: invokestatic 348	com/tencent/mm/audio/mix/b/a:adc	()Lcom/tencent/mm/audio/mix/b/a;
    //   366: aload_0
    //   367: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   370: invokevirtual 351	com/tencent/mm/audio/mix/b/a:hp	(Ljava/lang/String;)Z
    //   373: ifeq +455 -> 828
    //   376: new 353	java/io/File
    //   379: dup
    //   380: aload_0
    //   381: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   384: invokestatic 358	com/tencent/mm/audio/mix/h/a:if	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokespecial 360	java/io/File:<init>	(Ljava/lang/String;)V
    //   390: astore 13
    //   392: new 353	java/io/File
    //   395: dup
    //   396: aload_0
    //   397: getfield 241	com/tencent/mm/audio/mix/decode/d:fnS	Lcom/tencent/mm/al/b;
    //   400: getfield 363	com/tencent/mm/al/b:appId	Ljava/lang/String;
    //   403: aload_0
    //   404: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   407: invokestatic 367	com/tencent/mm/audio/mix/h/a:X	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   410: invokespecial 360	java/io/File:<init>	(Ljava/lang/String;)V
    //   413: astore 14
    //   415: aload 13
    //   417: invokevirtual 371	java/io/File:exists	()Z
    //   420: ifne +11 -> 431
    //   423: aload 14
    //   425: invokevirtual 371	java/io/File:exists	()Z
    //   428: ifeq +381 -> 809
    //   431: aload_0
    //   432: invokevirtual 375	com/tencent/mm/audio/mix/decode/d:adJ	()Lcom/tencent/mm/audio/mix/a/d;
    //   435: astore 12
    //   437: aload 12
    //   439: invokevirtual 378	com/tencent/mm/audio/mix/a/d:reset	()V
    //   442: aload 12
    //   444: aload_0
    //   445: getfield 52	com/tencent/mm/audio/mix/decode/d:duration	J
    //   448: ldc2_w 379
    //   451: ldiv
    //   452: putfield 381	com/tencent/mm/audio/mix/a/d:duration	J
    //   455: aload_0
    //   456: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   459: astore 15
    //   461: aload 13
    //   463: invokevirtual 371	java/io/File:exists	()Z
    //   466: ifne +271 -> 737
    //   469: aload 14
    //   471: invokevirtual 371	java/io/File:exists	()Z
    //   474: ifeq +263 -> 737
    //   477: iconst_1
    //   478: istore 7
    //   480: new 383	com/tencent/mm/audio/mix/c/b
    //   483: dup
    //   484: aload 15
    //   486: iload 7
    //   488: aload_0
    //   489: getfield 241	com/tencent/mm/audio/mix/decode/d:fnS	Lcom/tencent/mm/al/b;
    //   492: getfield 363	com/tencent/mm/al/b:appId	Ljava/lang/String;
    //   495: invokespecial 386	com/tencent/mm/audio/mix/c/b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   498: astore 13
    //   500: iconst_0
    //   501: istore 8
    //   503: ldc 72
    //   505: ldc_w 388
    //   508: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: iload 8
    //   513: istore 7
    //   515: aload_0
    //   516: invokevirtual 391	com/tencent/mm/audio/mix/decode/d:adI	()Z
    //   519: ifne +73 -> 592
    //   522: aload_0
    //   523: invokevirtual 394	com/tencent/mm/audio/mix/decode/d:adK	()V
    //   526: aload 13
    //   528: invokevirtual 398	com/tencent/mm/audio/mix/c/b:adv	()[B
    //   531: astore 14
    //   533: aload 14
    //   535: ifnull +28 -> 563
    //   538: aload_0
    //   539: ldc_w 399
    //   542: putfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   545: aload_0
    //   546: iconst_2
    //   547: putfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   550: aload_0
    //   551: iconst_2
    //   552: putfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   555: aload_0
    //   556: aload 12
    //   558: aload 14
    //   560: invokespecial 87	com/tencent/mm/audio/mix/decode/d:b	(Lcom/tencent/mm/audio/mix/a/d;[B)V
    //   563: aload 12
    //   565: invokevirtual 402	com/tencent/mm/audio/mix/a/d:size	()I
    //   568: ifle +175 -> 743
    //   571: aload 14
    //   573: ifnonnull +170 -> 743
    //   576: aload 12
    //   578: invokevirtual 405	com/tencent/mm/audio/mix/a/d:ph	()V
    //   581: getstatic 30	com/tencent/mm/audio/mix/decode/d:fon	I
    //   584: iconst_1
    //   585: iadd
    //   586: putstatic 30	com/tencent/mm/audio/mix/decode/d:fon	I
    //   589: iconst_1
    //   590: istore 7
    //   592: ldc 72
    //   594: ldc_w 407
    //   597: iconst_1
    //   598: anewarray 117	java/lang/Object
    //   601: dup
    //   602: iconst_0
    //   603: iload 7
    //   605: invokestatic 412	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   608: aastore
    //   609: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   612: ldc_w 414
    //   615: ldc_w 415
    //   618: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload 13
    //   623: getfield 419	com/tencent/mm/audio/mix/c/b:aFw	Ljava/io/InputStream;
    //   626: ifnull +17 -> 643
    //   629: aload 13
    //   631: getfield 419	com/tencent/mm/audio/mix/c/b:aFw	Ljava/io/InputStream;
    //   634: invokevirtual 422	java/io/InputStream:close	()V
    //   637: aload 13
    //   639: aconst_null
    //   640: putfield 419	com/tencent/mm/audio/mix/c/b:aFw	Ljava/io/InputStream;
    //   643: iload 7
    //   645: ifeq +183 -> 828
    //   648: aload 12
    //   650: aload_0
    //   651: getfield 190	com/tencent/mm/audio/mix/decode/d:fnR	Lcom/tencent/mm/audio/mix/g/c;
    //   654: invokeinterface 196 1 0
    //   659: getfield 425	com/tencent/mm/al/b:fmC	Z
    //   662: putfield 426	com/tencent/mm/audio/mix/a/d:fmC	Z
    //   665: aload_0
    //   666: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   669: ldc 72
    //   671: ldc_w 428
    //   674: iconst_1
    //   675: anewarray 117	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: getstatic 30	com/tencent/mm/audio/mix/decode/d:fon	I
    //   683: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   686: aastore
    //   687: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   690: ldc 226
    //   692: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   695: return
    //   696: astore 11
    //   698: ldc 72
    //   700: aload 11
    //   702: ldc_w 430
    //   705: iconst_0
    //   706: anewarray 117	java/lang/Object
    //   709: invokestatic 121	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   712: aload_0
    //   713: sipush 705
    //   716: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   719: aload_0
    //   720: aload_0
    //   721: getfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   724: invokevirtual 313	com/tencent/mm/audio/mix/decode/d:kv	(I)V
    //   727: aload_0
    //   728: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   731: ldc 226
    //   733: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: return
    //   737: iconst_0
    //   738: istore 7
    //   740: goto -260 -> 480
    //   743: aload 12
    //   745: invokevirtual 402	com/tencent/mm/audio/mix/a/d:size	()I
    //   748: ifne +20 -> 768
    //   751: aload 14
    //   753: ifnonnull +15 -> 768
    //   756: aload 12
    //   758: invokevirtual 378	com/tencent/mm/audio/mix/a/d:reset	()V
    //   761: iload 8
    //   763: istore 7
    //   765: goto -173 -> 592
    //   768: iload 8
    //   770: istore 7
    //   772: aload 14
    //   774: ifnull -182 -> 592
    //   777: aload 14
    //   779: ifnonnull -268 -> 511
    //   782: iload 8
    //   784: istore 7
    //   786: goto -194 -> 592
    //   789: astore 13
    //   791: ldc_w 414
    //   794: aload 13
    //   796: ldc_w 432
    //   799: iconst_0
    //   800: anewarray 117	java/lang/Object
    //   803: invokestatic 121	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: goto -163 -> 643
    //   809: ldc 72
    //   811: ldc_w 434
    //   814: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   817: invokestatic 348	com/tencent/mm/audio/mix/b/a:adc	()Lcom/tencent/mm/audio/mix/b/a;
    //   820: aload_0
    //   821: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   824: invokevirtual 437	com/tencent/mm/audio/mix/b/a:ho	(Ljava/lang/String;)Z
    //   827: pop
    //   828: aload_0
    //   829: aload_0
    //   830: getfield 46	com/tencent/mm/audio/mix/decode/d:aFM	Ljava/lang/String;
    //   833: invokestatic 441	com/tencent/mm/compatible/deviceinfo/aa:KR	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   836: putfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   839: aload_0
    //   840: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   843: aload 11
    //   845: aconst_null
    //   846: iconst_0
    //   847: invokevirtual 444	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   850: aload_0
    //   851: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   854: invokevirtual 447	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   857: aload_0
    //   858: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   861: invokevirtual 451	com/tencent/mm/compatible/deviceinfo/aa:avj	()[Ljava/nio/ByteBuffer;
    //   864: astore 13
    //   866: aload_0
    //   867: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   870: invokevirtual 454	com/tencent/mm/compatible/deviceinfo/aa:avk	()[Ljava/nio/ByteBuffer;
    //   873: astore 12
    //   875: ldc 72
    //   877: ldc_w 456
    //   880: iconst_2
    //   881: anewarray 117	java/lang/Object
    //   884: dup
    //   885: iconst_0
    //   886: aload 11
    //   888: aastore
    //   889: dup
    //   890: iconst_1
    //   891: aload_0
    //   892: getfield 46	com/tencent/mm/audio/mix/decode/d:aFM	Ljava/lang/String;
    //   895: aastore
    //   896: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   899: ldc 72
    //   901: ldc_w 458
    //   904: iconst_5
    //   905: anewarray 117	java/lang/Object
    //   908: dup
    //   909: iconst_0
    //   910: aload_0
    //   911: getfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   914: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   917: aastore
    //   918: dup
    //   919: iconst_1
    //   920: aload_0
    //   921: getfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   924: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   927: aastore
    //   928: dup
    //   929: iconst_2
    //   930: aload_0
    //   931: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   934: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   937: aastore
    //   938: dup
    //   939: iconst_3
    //   940: aload_0
    //   941: getfield 52	com/tencent/mm/audio/mix/decode/d:duration	J
    //   944: invokestatic 463	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   947: aastore
    //   948: dup
    //   949: iconst_4
    //   950: aload_0
    //   951: getfield 190	com/tencent/mm/audio/mix/decode/d:fnR	Lcom/tencent/mm/audio/mix/g/c;
    //   954: invokeinterface 196 1 0
    //   959: getfield 466	com/tencent/mm/al/b:fmF	Ljava/lang/String;
    //   962: aastore
    //   963: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   966: aload_0
    //   967: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   970: iconst_0
    //   971: invokevirtual 469	android/media/MediaExtractor:selectTrack	(I)V
    //   974: new 471	android/media/MediaCodec$BufferInfo
    //   977: dup
    //   978: invokespecial 472	android/media/MediaCodec$BufferInfo:<init>	()V
    //   981: astore 15
    //   983: iconst_0
    //   984: istore_2
    //   985: aload_0
    //   986: invokevirtual 375	com/tencent/mm/audio/mix/decode/d:adJ	()Lcom/tencent/mm/audio/mix/a/d;
    //   989: astore 14
    //   991: aload 14
    //   993: invokevirtual 378	com/tencent/mm/audio/mix/a/d:reset	()V
    //   996: aload_0
    //   997: getfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   1000: aload_0
    //   1001: getfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   1004: aload_0
    //   1005: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1008: invokestatic 478	com/tencent/mm/audio/mix/f/a:L	(III)Z
    //   1011: ifne +379 -> 1390
    //   1014: ldc 72
    //   1016: ldc_w 480
    //   1019: invokestatic 80	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_0
    //   1023: new 482	com/tencent/mm/audio/mix/c/e
    //   1026: dup
    //   1027: aload 14
    //   1029: aload_0
    //   1030: getfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   1033: aload_0
    //   1034: getfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   1037: aload_0
    //   1038: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1041: aload_0
    //   1042: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   1045: invokespecial 485	com/tencent/mm/audio/mix/c/e:<init>	(Lcom/tencent/mm/audio/mix/a/d;IIILjava/lang/String;)V
    //   1048: putfield 180	com/tencent/mm/audio/mix/decode/d:fnT	Lcom/tencent/mm/audio/mix/c/h;
    //   1051: aload 14
    //   1053: aload_0
    //   1054: getfield 52	com/tencent/mm/audio/mix/decode/d:duration	J
    //   1057: ldc2_w 379
    //   1060: ldiv
    //   1061: putfield 381	com/tencent/mm/audio/mix/a/d:duration	J
    //   1064: iconst_0
    //   1065: istore_1
    //   1066: aload 12
    //   1068: astore 11
    //   1070: iconst_0
    //   1071: istore_3
    //   1072: iload_3
    //   1073: ifne +920 -> 1993
    //   1076: iload_2
    //   1077: bipush 50
    //   1079: if_icmpge +914 -> 1993
    //   1082: aload_0
    //   1083: invokevirtual 391	com/tencent/mm/audio/mix/decode/d:adI	()Z
    //   1086: ifne +907 -> 1993
    //   1089: aload_0
    //   1090: invokevirtual 394	com/tencent/mm/audio/mix/decode/d:adK	()V
    //   1093: iload_2
    //   1094: iconst_1
    //   1095: iadd
    //   1096: istore 4
    //   1098: iload_1
    //   1099: istore 5
    //   1101: iload_1
    //   1102: ifne +100 -> 1202
    //   1105: aload_0
    //   1106: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1109: ldc2_w 379
    //   1112: invokevirtual 489	com/tencent/mm/compatible/deviceinfo/aa:EX	(J)I
    //   1115: istore 6
    //   1117: iload 6
    //   1119: iflt +317 -> 1436
    //   1122: aload 13
    //   1124: iload 6
    //   1126: aaload
    //   1127: astore 12
    //   1129: aload_0
    //   1130: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   1133: aload 12
    //   1135: iconst_0
    //   1136: invokevirtual 493	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   1139: istore_2
    //   1140: iload_2
    //   1141: ifge +281 -> 1422
    //   1144: ldc 72
    //   1146: ldc_w 495
    //   1149: invokestatic 80	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1152: iconst_1
    //   1153: istore_1
    //   1154: iconst_0
    //   1155: istore_2
    //   1156: aload_0
    //   1157: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1160: astore 12
    //   1162: aload_0
    //   1163: getfield 50	com/tencent/mm/audio/mix/decode/d:foj	J
    //   1166: lstore 9
    //   1168: iload_1
    //   1169: ifeq +968 -> 2137
    //   1172: iconst_4
    //   1173: istore 5
    //   1175: aload 12
    //   1177: iload 6
    //   1179: iload_2
    //   1180: lload 9
    //   1182: iload 5
    //   1184: invokevirtual 498	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   1187: iload_1
    //   1188: ifne +943 -> 2131
    //   1191: aload_0
    //   1192: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   1195: invokevirtual 501	android/media/MediaExtractor:advance	()Z
    //   1198: pop
    //   1199: goto +932 -> 2131
    //   1202: aload_0
    //   1203: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1206: aload 15
    //   1208: ldc2_w 379
    //   1211: invokevirtual 504	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1214: istore_2
    //   1215: iload_2
    //   1216: iflt +311 -> 1527
    //   1219: aload 15
    //   1221: getfield 506	android/media/MediaCodec$BufferInfo:size	I
    //   1224: ifle +895 -> 2119
    //   1227: iconst_0
    //   1228: istore_1
    //   1229: aload 11
    //   1231: iload_2
    //   1232: aaload
    //   1233: astore 12
    //   1235: aload 15
    //   1237: getfield 506	android/media/MediaCodec$BufferInfo:size	I
    //   1240: istore 4
    //   1242: iload 4
    //   1244: ifle +13 -> 1257
    //   1247: aload_0
    //   1248: aload 14
    //   1250: aload 12
    //   1252: iload 4
    //   1254: invokevirtual 508	com/tencent/mm/audio/mix/decode/d:a	(Lcom/tencent/mm/audio/mix/a/d;Ljava/nio/ByteBuffer;I)V
    //   1257: aload 12
    //   1259: invokevirtual 512	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1262: pop
    //   1263: aload_0
    //   1264: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1267: iload_2
    //   1268: iconst_0
    //   1269: invokevirtual 516	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   1272: aload 15
    //   1274: getfield 519	android/media/MediaCodec$BufferInfo:flags	I
    //   1277: iconst_4
    //   1278: iand
    //   1279: ifeq +13 -> 1292
    //   1282: ldc 72
    //   1284: ldc_w 521
    //   1287: invokestatic 80	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1290: iconst_1
    //   1291: istore_3
    //   1292: iload_1
    //   1293: istore_2
    //   1294: iload 5
    //   1296: istore_1
    //   1297: goto -225 -> 1072
    //   1300: astore 11
    //   1302: ldc 72
    //   1304: aload 11
    //   1306: ldc_w 523
    //   1309: iconst_0
    //   1310: anewarray 117	java/lang/Object
    //   1313: invokestatic 121	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1316: aload_0
    //   1317: sipush 704
    //   1320: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1323: aload_0
    //   1324: aload_0
    //   1325: getfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1328: invokevirtual 313	com/tencent/mm/audio/mix/decode/d:kv	(I)V
    //   1331: aload_0
    //   1332: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   1335: aload_0
    //   1336: invokespecial 525	com/tencent/mm/audio/mix/decode/d:adW	()V
    //   1339: ldc 226
    //   1341: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1344: return
    //   1345: astore 11
    //   1347: ldc 72
    //   1349: aload 11
    //   1351: ldc_w 527
    //   1354: iconst_0
    //   1355: anewarray 117	java/lang/Object
    //   1358: invokestatic 121	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1361: aload_0
    //   1362: sipush 716
    //   1365: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1368: aload_0
    //   1369: aload_0
    //   1370: getfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1373: invokevirtual 313	com/tencent/mm/audio/mix/decode/d:kv	(I)V
    //   1376: aload_0
    //   1377: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   1380: aload_0
    //   1381: invokespecial 525	com/tencent/mm/audio/mix/decode/d:adW	()V
    //   1384: ldc 226
    //   1386: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1389: return
    //   1390: getstatic 32	com/tencent/mm/audio/mix/decode/d:foo	I
    //   1393: iconst_1
    //   1394: iadd
    //   1395: putstatic 32	com/tencent/mm/audio/mix/decode/d:foo	I
    //   1398: ldc 72
    //   1400: ldc_w 529
    //   1403: iconst_1
    //   1404: anewarray 117	java/lang/Object
    //   1407: dup
    //   1408: iconst_0
    //   1409: getstatic 32	com/tencent/mm/audio/mix/decode/d:foo	I
    //   1412: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1415: aastore
    //   1416: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1419: goto -368 -> 1051
    //   1422: aload_0
    //   1423: aload_0
    //   1424: getfield 105	com/tencent/mm/audio/mix/decode/d:fog	Landroid/media/MediaExtractor;
    //   1427: invokevirtual 533	android/media/MediaExtractor:getSampleTime	()J
    //   1430: putfield 50	com/tencent/mm/audio/mix/decode/d:foj	J
    //   1433: goto -277 -> 1156
    //   1436: ldc 72
    //   1438: ldc_w 535
    //   1441: iload 6
    //   1443: invokestatic 538	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1446: invokevirtual 541	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1449: invokestatic 80	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1452: iload_1
    //   1453: istore 5
    //   1455: goto -253 -> 1202
    //   1458: astore 11
    //   1460: ldc 72
    //   1462: aload 11
    //   1464: ldc 228
    //   1466: iconst_0
    //   1467: anewarray 117	java/lang/Object
    //   1470: invokestatic 121	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1473: aload_0
    //   1474: sipush 706
    //   1477: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1480: aload_0
    //   1481: aload_0
    //   1482: getfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1485: invokevirtual 313	com/tencent/mm/audio/mix/decode/d:kv	(I)V
    //   1488: aload_0
    //   1489: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   1492: aload_0
    //   1493: invokespecial 525	com/tencent/mm/audio/mix/decode/d:adW	()V
    //   1496: aload 14
    //   1498: aload_0
    //   1499: getfield 190	com/tencent/mm/audio/mix/decode/d:fnR	Lcom/tencent/mm/audio/mix/g/c;
    //   1502: invokeinterface 196 1 0
    //   1507: getfield 425	com/tencent/mm/al/b:fmC	Z
    //   1510: putfield 426	com/tencent/mm/audio/mix/a/d:fmC	Z
    //   1513: ldc 72
    //   1515: ldc_w 543
    //   1518: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1521: ldc 226
    //   1523: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1526: return
    //   1527: iload_2
    //   1528: bipush 253
    //   1530: if_icmpne +29 -> 1559
    //   1533: aload_0
    //   1534: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1537: invokevirtual 454	com/tencent/mm/compatible/deviceinfo/aa:avk	()[Ljava/nio/ByteBuffer;
    //   1540: astore 11
    //   1542: ldc 72
    //   1544: ldc_w 545
    //   1547: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1550: iload 5
    //   1552: istore_1
    //   1553: iload 4
    //   1555: istore_2
    //   1556: goto -484 -> 1072
    //   1559: iload_2
    //   1560: bipush 254
    //   1562: if_icmpne +407 -> 1969
    //   1565: aload_0
    //   1566: getfield 125	com/tencent/mm/audio/mix/decode/d:foh	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   1569: invokevirtual 549	com/tencent/mm/compatible/deviceinfo/aa:avi	()Landroid/media/MediaFormat;
    //   1572: astore 12
    //   1574: ldc 72
    //   1576: ldc_w 551
    //   1579: aload 12
    //   1581: invokestatic 554	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1584: invokevirtual 541	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1587: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1590: aload_0
    //   1591: aload 12
    //   1593: ldc_w 330
    //   1596: invokevirtual 334	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1599: putfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   1602: aload_0
    //   1603: aload 12
    //   1605: ldc_w 336
    //   1608: invokevirtual 334	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1611: putfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   1614: aload 12
    //   1616: ldc_w 556
    //   1619: invokevirtual 559	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1622: ifeq +165 -> 1787
    //   1625: aload_0
    //   1626: aload 12
    //   1628: ldc_w 556
    //   1631: invokevirtual 334	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1634: putfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1637: ldc 72
    //   1639: ldc_w 561
    //   1642: iconst_5
    //   1643: anewarray 117	java/lang/Object
    //   1646: dup
    //   1647: iconst_0
    //   1648: aload_0
    //   1649: getfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   1652: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1655: aastore
    //   1656: dup
    //   1657: iconst_1
    //   1658: aload_0
    //   1659: getfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   1662: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1665: aastore
    //   1666: dup
    //   1667: iconst_2
    //   1668: aload_0
    //   1669: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1672: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1675: aastore
    //   1676: dup
    //   1677: iconst_3
    //   1678: aload_0
    //   1679: getfield 190	com/tencent/mm/audio/mix/decode/d:fnR	Lcom/tencent/mm/audio/mix/g/c;
    //   1682: invokeinterface 196 1 0
    //   1687: getfield 466	com/tencent/mm/al/b:fmF	Ljava/lang/String;
    //   1690: aastore
    //   1691: dup
    //   1692: iconst_4
    //   1693: aload_0
    //   1694: getfield 318	com/tencent/mm/audio/mix/decode/d:sourcePath	Ljava/lang/String;
    //   1697: aastore
    //   1698: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1701: aload_0
    //   1702: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1705: tableswitch	default:+438 -> 2143, 1:+443->2148, 2:+443->2148, 3:+443->2148
    //   1733: ifne +120 -> 1853
    //   1736: ldc 72
    //   1738: ldc_w 563
    //   1741: iconst_1
    //   1742: anewarray 117	java/lang/Object
    //   1745: dup
    //   1746: iconst_0
    //   1747: aload_0
    //   1748: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1751: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1754: aastore
    //   1755: invokestatic 565	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1758: aload_0
    //   1759: sipush 709
    //   1762: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1765: aload_0
    //   1766: aload_0
    //   1767: getfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   1770: invokevirtual 313	com/tencent/mm/audio/mix/decode/d:kv	(I)V
    //   1773: aload_0
    //   1774: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   1777: aload_0
    //   1778: invokespecial 525	com/tencent/mm/audio/mix/decode/d:adW	()V
    //   1781: ldc 226
    //   1783: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1786: return
    //   1787: aload 12
    //   1789: ldc_w 567
    //   1792: invokevirtual 559	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1795: ifeq -158 -> 1637
    //   1798: aload 12
    //   1800: ldc_w 567
    //   1803: invokevirtual 334	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1806: istore_1
    //   1807: iload_1
    //   1808: bipush 16
    //   1810: if_icmpne +29 -> 1839
    //   1813: aload_0
    //   1814: iconst_2
    //   1815: putfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1818: goto -181 -> 1637
    //   1821: astore 11
    //   1823: aload_0
    //   1824: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   1827: aload_0
    //   1828: invokespecial 525	com/tencent/mm/audio/mix/decode/d:adW	()V
    //   1831: ldc 226
    //   1833: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1836: aload 11
    //   1838: athrow
    //   1839: iload_1
    //   1840: bipush 8
    //   1842: if_icmpne -205 -> 1637
    //   1845: aload_0
    //   1846: iconst_3
    //   1847: putfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1850: goto -213 -> 1637
    //   1853: aload_0
    //   1854: getfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   1857: aload_0
    //   1858: getfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   1861: aload_0
    //   1862: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1865: invokestatic 478	com/tencent/mm/audio/mix/f/a:L	(III)Z
    //   1868: ifeq +50 -> 1918
    //   1871: aload_0
    //   1872: getfield 180	com/tencent/mm/audio/mix/decode/d:fnT	Lcom/tencent/mm/audio/mix/c/h;
    //   1875: ifnull +43 -> 1918
    //   1878: ldc 72
    //   1880: ldc_w 569
    //   1883: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1886: aload_0
    //   1887: getfield 180	com/tencent/mm/audio/mix/decode/d:fnT	Lcom/tencent/mm/audio/mix/c/h;
    //   1890: invokeinterface 572 1 0
    //   1895: aload_0
    //   1896: getfield 180	com/tencent/mm/audio/mix/decode/d:fnT	Lcom/tencent/mm/audio/mix/c/h;
    //   1899: invokeinterface 573 1 0
    //   1904: aload_0
    //   1905: aconst_null
    //   1906: putfield 180	com/tencent/mm/audio/mix/decode/d:fnT	Lcom/tencent/mm/audio/mix/c/h;
    //   1909: iload 5
    //   1911: istore_1
    //   1912: iload 4
    //   1914: istore_2
    //   1915: goto -843 -> 1072
    //   1918: iload 5
    //   1920: istore_1
    //   1921: iload 4
    //   1923: istore_2
    //   1924: aload_0
    //   1925: getfield 180	com/tencent/mm/audio/mix/decode/d:fnT	Lcom/tencent/mm/audio/mix/c/h;
    //   1928: ifnull -856 -> 1072
    //   1931: ldc 72
    //   1933: ldc_w 575
    //   1936: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1939: aload_0
    //   1940: getfield 180	com/tencent/mm/audio/mix/decode/d:fnT	Lcom/tencent/mm/audio/mix/c/h;
    //   1943: aload_0
    //   1944: getfield 162	com/tencent/mm/audio/mix/decode/d:sampleRate	I
    //   1947: aload_0
    //   1948: getfield 166	com/tencent/mm/audio/mix/decode/d:channels	I
    //   1951: aload_0
    //   1952: getfield 48	com/tencent/mm/audio/mix/decode/d:fmx	I
    //   1955: invokeinterface 578 4 0
    //   1960: iload 5
    //   1962: istore_1
    //   1963: iload 4
    //   1965: istore_2
    //   1966: goto -894 -> 1072
    //   1969: ldc 72
    //   1971: ldc_w 580
    //   1974: iload_2
    //   1975: invokestatic 538	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1978: invokevirtual 541	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1981: invokestatic 230	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1984: iload 5
    //   1986: istore_1
    //   1987: iload 4
    //   1989: istore_2
    //   1990: goto -918 -> 1072
    //   1993: aload_0
    //   1994: getfield 52	com/tencent/mm/audio/mix/decode/d:duration	J
    //   1997: ldc2_w 379
    //   2000: ldiv
    //   2001: aload_0
    //   2002: getfield 50	com/tencent/mm/audio/mix/decode/d:foj	J
    //   2005: ldc2_w 379
    //   2008: ldiv
    //   2009: lsub
    //   2010: ldc2_w 581
    //   2013: lcmp
    //   2014: ifge +57 -> 2071
    //   2017: iconst_1
    //   2018: istore 7
    //   2020: iload_2
    //   2021: bipush 50
    //   2023: if_icmplt +54 -> 2077
    //   2026: ldc 72
    //   2028: ldc_w 584
    //   2031: iconst_1
    //   2032: anewarray 117	java/lang/Object
    //   2035: dup
    //   2036: iconst_0
    //   2037: iload_2
    //   2038: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2041: aastore
    //   2042: invokestatic 565	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2045: aload_0
    //   2046: sipush 706
    //   2049: putfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   2052: aload_0
    //   2053: aload_0
    //   2054: getfield 310	com/tencent/mm/audio/mix/decode/d:fnU	I
    //   2057: invokevirtual 313	com/tencent/mm/audio/mix/decode/d:kv	(I)V
    //   2060: aload_0
    //   2061: invokespecial 315	com/tencent/mm/audio/mix/decode/d:adV	()V
    //   2064: aload_0
    //   2065: invokespecial 525	com/tencent/mm/audio/mix/decode/d:adW	()V
    //   2068: goto -572 -> 1496
    //   2071: iconst_0
    //   2072: istore 7
    //   2074: goto -54 -> 2020
    //   2077: ldc 72
    //   2079: ldc_w 586
    //   2082: iconst_1
    //   2083: anewarray 117	java/lang/Object
    //   2086: dup
    //   2087: iconst_0
    //   2088: iload 7
    //   2090: invokestatic 412	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2093: aastore
    //   2094: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2097: iload 7
    //   2099: ifeq +12 -> 2111
    //   2102: aload_0
    //   2103: aload 14
    //   2105: invokevirtual 588	com/tencent/mm/audio/mix/decode/d:b	(Lcom/tencent/mm/audio/mix/a/d;)V
    //   2108: goto -48 -> 2060
    //   2111: aload 14
    //   2113: invokevirtual 378	com/tencent/mm/audio/mix/a/d:reset	()V
    //   2116: goto -56 -> 2060
    //   2119: iload 4
    //   2121: istore_1
    //   2122: goto -893 -> 1229
    //   2125: aconst_null
    //   2126: astore 11
    //   2128: goto -1921 -> 207
    //   2131: iload_1
    //   2132: istore 5
    //   2134: goto -932 -> 1202
    //   2137: iconst_0
    //   2138: istore 5
    //   2140: goto -965 -> 1175
    //   2143: iconst_0
    //   2144: istore_1
    //   2145: goto -413 -> 1732
    //   2148: iconst_1
    //   2149: istore_1
    //   2150: goto -418 -> 1732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2153	0	this	d
    //   156	1994	1	i	int
    //   135	1903	2	j	int
    //   1071	221	3	k	int
    //   1096	1024	4	m	int
    //   1099	1040	5	n	int
    //   1115	327	6	i1	int
    //   478	1620	7	bool1	boolean
    //   501	282	8	bool2	boolean
    //   1166	15	9	l	long
    //   88	120	11	localObject1	Object
    //   259	94	11	localException1	Exception
    //   696	191	11	localException2	Exception
    //   1068	162	11	localObject2	Object
    //   1300	5	11	localException3	Exception
    //   1345	5	11	localIllegalStateException	java.lang.IllegalStateException
    //   1458	5	11	localException4	Exception
    //   1540	1	11	arrayOfByteBuffer1	ByteBuffer[]
    //   1821	16	11	localObject3	Object
    //   2126	1	11	localObject4	Object
    //   435	1364	12	localObject5	Object
    //   390	248	13	localObject6	Object
    //   789	6	13	localException5	Exception
    //   864	259	13	arrayOfByteBuffer2	ByteBuffer[]
    //   413	1699	14	localObject7	Object
    //   459	814	15	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   23	104	259	java/lang/Exception
    //   104	128	259	java/lang/Exception
    //   245	256	259	java/lang/Exception
    //   128	155	696	java/lang/Exception
    //   162	207	696	java/lang/Exception
    //   212	239	696	java/lang/Exception
    //   310	363	696	java/lang/Exception
    //   621	643	789	java/lang/Exception
    //   828	857	1300	java/lang/Exception
    //   857	875	1345	java/lang/IllegalStateException
    //   1082	1093	1458	java/lang/Exception
    //   1105	1117	1458	java/lang/Exception
    //   1129	1140	1458	java/lang/Exception
    //   1144	1152	1458	java/lang/Exception
    //   1156	1168	1458	java/lang/Exception
    //   1175	1187	1458	java/lang/Exception
    //   1191	1199	1458	java/lang/Exception
    //   1202	1215	1458	java/lang/Exception
    //   1219	1227	1458	java/lang/Exception
    //   1235	1242	1458	java/lang/Exception
    //   1247	1257	1458	java/lang/Exception
    //   1257	1272	1458	java/lang/Exception
    //   1272	1290	1458	java/lang/Exception
    //   1422	1433	1458	java/lang/Exception
    //   1436	1452	1458	java/lang/Exception
    //   1533	1550	1458	java/lang/Exception
    //   1565	1637	1458	java/lang/Exception
    //   1637	1732	1458	java/lang/Exception
    //   1736	1773	1458	java/lang/Exception
    //   1787	1807	1458	java/lang/Exception
    //   1813	1818	1458	java/lang/Exception
    //   1845	1850	1458	java/lang/Exception
    //   1853	1909	1458	java/lang/Exception
    //   1924	1960	1458	java/lang/Exception
    //   1969	1984	1458	java/lang/Exception
    //   1993	2017	1458	java/lang/Exception
    //   2026	2060	1458	java/lang/Exception
    //   2077	2097	1458	java/lang/Exception
    //   2102	2108	1458	java/lang/Exception
    //   2111	2116	1458	java/lang/Exception
    //   1082	1093	1821	finally
    //   1105	1117	1821	finally
    //   1129	1140	1821	finally
    //   1144	1152	1821	finally
    //   1156	1168	1821	finally
    //   1175	1187	1821	finally
    //   1191	1199	1821	finally
    //   1202	1215	1821	finally
    //   1219	1227	1821	finally
    //   1235	1242	1821	finally
    //   1247	1257	1821	finally
    //   1257	1272	1821	finally
    //   1272	1290	1821	finally
    //   1422	1433	1821	finally
    //   1436	1452	1821	finally
    //   1460	1488	1821	finally
    //   1533	1550	1821	finally
    //   1565	1637	1821	finally
    //   1637	1732	1821	finally
    //   1736	1773	1821	finally
    //   1787	1807	1821	finally
    //   1813	1818	1821	finally
    //   1845	1850	1821	finally
    //   1853	1909	1821	finally
    //   1924	1960	1821	finally
    //   1969	1984	1821	finally
    //   1993	2017	1821	finally
    //   2026	2060	1821	finally
    //   2077	2097	1821	finally
    //   2102	2108	1821	finally
    //   2111	2116	1821	finally
  }
  
  protected void b(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(136803);
    if (this.fnT != null)
    {
      this.fnT.ady();
      com.tencent.mm.audio.mix.b.a.adc().hn(paramd.fmB);
      if (adI())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
        this.fnT.adA();
        AppMethodBeat.o(136803);
        return;
      }
      if (adH())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
        this.fnT.adA();
        adO();
        AppMethodBeat.o(136803);
        return;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
      a(paramd);
      AppMethodBeat.o(136803);
      return;
    }
    c(paramd);
    paramd.ph();
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
    for (paramByteBuffer = arrayOfByte;; paramByteBuffer = this.fok)
    {
      if (this.fnR.aeD().lzW) {
        com.tencent.mm.audio.mix.c.a.a(paramByteBuffer, adT().lzK);
      }
      a(paramd, paramByteBuffer);
      AppMethodBeat.o(136802);
      return;
      if (paramInt != this.fol)
      {
        this.fol = paramInt;
        this.fok = new byte[paramInt];
      }
      Arrays.fill(this.fok, 0, this.fol, (byte)0);
      paramByteBuffer.get(this.fok, 0, this.fol);
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
      System.arraycopy(this.buffer, j * 3536, this.fom, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.fom, 0, this.buffer, 0, k);
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
    adV();
    adW();
    if (this.fnT != null)
    {
      this.fnT.ady();
      this.fnT.release();
      this.fnT = null;
    }
    this.sourcePath = null;
    this.aFM = null;
    this.sampleRate = 0;
    this.channels = 0;
    this.foj = 0L;
    this.duration = 0L;
    AppMethodBeat.o(136807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.d
 * JD-Core Version:    0.7.0.1
 */