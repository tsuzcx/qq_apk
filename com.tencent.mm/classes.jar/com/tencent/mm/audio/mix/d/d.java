package com.tencent.mm.audio.mix.d;

import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.compatible.deviceinfo.z;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class d
  extends c
{
  private static int dvE = 0;
  private static int dvF = 0;
  private int BUFFER_SIZE;
  private byte[] buffer;
  private int dtP;
  private long duration;
  private g dvA;
  private byte[] dvB;
  private int dvC;
  private byte[] dvD;
  private MediaExtractor dvy;
  private z dvz;
  private int mSize;
  private String mime;
  private long presentationTimeUs;
  
  public d(com.tencent.mm.audio.mix.g.d paramd, com.tencent.mm.audio.mix.h.c paramc)
  {
    super(paramd, paramc);
    AppMethodBeat.i(136799);
    this.mime = null;
    this.dtP = 2;
    this.presentationTimeUs = 0L;
    this.duration = 0L;
    this.BUFFER_SIZE = 14144;
    this.buffer = new byte[this.BUFFER_SIZE];
    this.dvB = new byte[3536];
    this.dvC = 3536;
    this.dvD = new byte[3536];
    this.mSize = 0;
    AppMethodBeat.o(136799);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(136808);
    try
    {
      if (this.dvy != null)
      {
        this.dvy.release();
        this.dvy = null;
      }
      Zo();
      AppMethodBeat.o(136808);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaExtractor", new Object[0]);
      }
    }
  }
  
  private void Zn()
  {
    AppMethodBeat.i(136809);
    try
    {
      if (this.dvz != null)
      {
        this.dvz.stop();
        this.dvz.release();
        this.dvz = null;
      }
      AppMethodBeat.o(136809);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseMediaCodec", new Object[0]);
      AppMethodBeat.o(136809);
    }
  }
  
  private void Zo()
  {
    AppMethodBeat.i(198106);
    try
    {
      if (this.dvA != null)
      {
        this.dvA.close();
        this.dvA = null;
      }
      AppMethodBeat.o(198106);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderMediaCodec", localException, "releaseDataSource", new Object[0]);
      AppMethodBeat.o(198106);
    }
  }
  
  private void a(com.tencent.mm.audio.mix.a.d paramd, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136805);
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderMediaCodec", "pushBuffer chunk is null");
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
      System.arraycopy(this.buffer, j * 3536, this.dvD, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.dvD, 0, this.buffer, 0, k);
      this.mSize = k;
    }
    AppMethodBeat.o(136805);
  }
  
  private void b(com.tencent.mm.audio.mix.a.d paramd, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136806);
    com.tencent.mm.audio.mix.a.e locale = com.tencent.mm.audio.mix.b.e.YJ().YI();
    locale.dtQ = paramArrayOfByte;
    locale.sampleRate = this.sampleRate;
    locale.channels = this.channels;
    locale.dtP = this.dtP;
    paramd.a(locale);
    a(locale);
    AppMethodBeat.o(136806);
  }
  
  /* Error */
  protected final void Ze()
  {
    // Byte code:
    //   0: ldc 178
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 83
    //   7: ldc 180
    //   9: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: new 75	android/media/MediaExtractor
    //   16: dup
    //   17: invokespecial 184	android/media/MediaExtractor:<init>	()V
    //   20: putfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   23: getstatic 189	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 23
    //   28: if_icmplt +214 -> 242
    //   31: aload_0
    //   32: getfield 193	com/tencent/mm/audio/mix/d/d:dvk	Lcom/tencent/mm/ai/b;
    //   35: getfield 198	com/tencent/mm/ai/b:dvn	Ljava/lang/String;
    //   38: ifnull +204 -> 242
    //   41: aload_0
    //   42: getfield 193	com/tencent/mm/audio/mix/d/d:dvk	Lcom/tencent/mm/ai/b;
    //   45: getfield 198	com/tencent/mm/ai/b:dvn	Ljava/lang/String;
    //   48: ldc 200
    //   50: invokevirtual 206	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   53: ifeq +189 -> 242
    //   56: aload_0
    //   57: getfield 193	com/tencent/mm/audio/mix/d/d:dvk	Lcom/tencent/mm/ai/b;
    //   60: getfield 210	com/tencent/mm/ai/b:iJU	Ljava/nio/ByteBuffer;
    //   63: ifnull +179 -> 242
    //   66: ldc 83
    //   68: ldc 212
    //   70: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: new 214	com/tencent/mm/plugin/music/g/a
    //   76: dup
    //   77: aload_0
    //   78: getfield 193	com/tencent/mm/audio/mix/d/d:dvk	Lcom/tencent/mm/ai/b;
    //   81: getfield 210	com/tencent/mm/ai/b:iJU	Ljava/nio/ByteBuffer;
    //   84: invokespecial 217	com/tencent/mm/plugin/music/g/a:<init>	(Ljava/nio/ByteBuffer;)V
    //   87: astore 11
    //   89: aload_0
    //   90: getfield 108	com/tencent/mm/audio/mix/d/d:dvA	Lcom/tencent/mm/audio/mix/d/g;
    //   93: ifnull +10 -> 103
    //   96: aload_0
    //   97: getfield 108	com/tencent/mm/audio/mix/d/d:dvA	Lcom/tencent/mm/audio/mix/d/g;
    //   100: invokevirtual 113	com/tencent/mm/audio/mix/d/g:close	()V
    //   103: aload_0
    //   104: new 110	com/tencent/mm/audio/mix/d/g
    //   107: dup
    //   108: aload 11
    //   110: invokespecial 220	com/tencent/mm/audio/mix/d/g:<init>	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)V
    //   113: putfield 108	com/tencent/mm/audio/mix/d/d:dvA	Lcom/tencent/mm/audio/mix/d/g;
    //   116: aload_0
    //   117: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   120: aload_0
    //   121: getfield 108	com/tencent/mm/audio/mix/d/d:dvA	Lcom/tencent/mm/audio/mix/d/g;
    //   124: invokevirtual 224	android/media/MediaExtractor:setDataSource	(Landroid/media/MediaDataSource;)V
    //   127: aload_0
    //   128: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   131: invokevirtual 228	android/media/MediaExtractor:getTrackCount	()I
    //   134: istore_2
    //   135: ldc 83
    //   137: ldc 230
    //   139: iconst_1
    //   140: anewarray 87	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: iload_2
    //   146: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: iconst_0
    //   154: istore_1
    //   155: iload_1
    //   156: iload_2
    //   157: if_icmpge +1964 -> 2121
    //   160: aload_0
    //   161: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   164: iload_1
    //   165: invokevirtual 243	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   168: astore 11
    //   170: aload_0
    //   171: aload 11
    //   173: ldc 244
    //   175: invokevirtual 250	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   178: putfield 46	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   181: aload_0
    //   182: getfield 46	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   185: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +112 -> 300
    //   191: aload_0
    //   192: getfield 46	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   195: ldc_w 258
    //   198: invokevirtual 206	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   201: ifeq +99 -> 300
    //   204: aload 11
    //   206: ifnonnull +101 -> 307
    //   209: ldc 83
    //   211: ldc_w 260
    //   214: invokestatic 124	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: sipush 703
    //   221: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   224: aload_0
    //   225: aload_0
    //   226: getfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   229: invokevirtual 266	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   232: aload_0
    //   233: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   236: ldc 178
    //   238: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: return
    //   242: aload_0
    //   243: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   246: aload_0
    //   247: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   250: invokevirtual 274	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   253: goto -126 -> 127
    //   256: astore 11
    //   258: ldc 83
    //   260: aload 11
    //   262: ldc_w 276
    //   265: iconst_1
    //   266: anewarray 87	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: aload_0
    //   272: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   275: aastore
    //   276: invokestatic 93	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload_0
    //   280: sipush 702
    //   283: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   286: aload_0
    //   287: invokevirtual 279	com/tencent/mm/audio/mix/d/d:YX	()V
    //   290: aload_0
    //   291: invokespecial 81	com/tencent/mm/audio/mix/d/d:Zo	()V
    //   294: ldc 178
    //   296: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: return
    //   300: iload_1
    //   301: iconst_1
    //   302: iadd
    //   303: istore_1
    //   304: goto -149 -> 155
    //   307: ldc 83
    //   309: ldc_w 281
    //   312: iconst_1
    //   313: anewarray 87	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload 11
    //   320: aastore
    //   321: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: aload_0
    //   325: aload 11
    //   327: ldc_w 283
    //   330: invokevirtual 287	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   333: putfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   336: aload_0
    //   337: aload 11
    //   339: ldc_w 289
    //   342: invokevirtual 287	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   345: putfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   348: aload_0
    //   349: aload 11
    //   351: ldc_w 291
    //   354: invokevirtual 295	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   357: putfield 52	com/tencent/mm/audio/mix/d/d:duration	J
    //   360: invokestatic 301	com/tencent/mm/audio/mix/b/a:Yw	()Lcom/tencent/mm/audio/mix/b/a;
    //   363: aload_0
    //   364: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   367: invokevirtual 304	com/tencent/mm/audio/mix/b/a:gD	(Ljava/lang/String;)Z
    //   370: ifeq +455 -> 825
    //   373: new 306	java/io/File
    //   376: dup
    //   377: aload_0
    //   378: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   381: invokestatic 311	com/tencent/mm/audio/mix/i/a:hr	(Ljava/lang/String;)Ljava/lang/String;
    //   384: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   387: astore 13
    //   389: new 306	java/io/File
    //   392: dup
    //   393: aload_0
    //   394: getfield 193	com/tencent/mm/audio/mix/d/d:dvk	Lcom/tencent/mm/ai/b;
    //   397: getfield 316	com/tencent/mm/ai/b:appId	Ljava/lang/String;
    //   400: aload_0
    //   401: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   404: invokestatic 320	com/tencent/mm/audio/mix/i/a:S	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   407: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   410: astore 14
    //   412: aload 13
    //   414: invokevirtual 324	java/io/File:exists	()Z
    //   417: ifne +11 -> 428
    //   420: aload 14
    //   422: invokevirtual 324	java/io/File:exists	()Z
    //   425: ifeq +381 -> 806
    //   428: aload_0
    //   429: invokevirtual 328	com/tencent/mm/audio/mix/d/d:Za	()Lcom/tencent/mm/audio/mix/a/d;
    //   432: astore 12
    //   434: aload 12
    //   436: invokevirtual 331	com/tencent/mm/audio/mix/a/d:reset	()V
    //   439: aload 12
    //   441: aload_0
    //   442: getfield 52	com/tencent/mm/audio/mix/d/d:duration	J
    //   445: ldc2_w 332
    //   448: ldiv
    //   449: putfield 334	com/tencent/mm/audio/mix/a/d:duration	J
    //   452: aload_0
    //   453: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   456: astore 15
    //   458: aload 13
    //   460: invokevirtual 324	java/io/File:exists	()Z
    //   463: ifne +271 -> 734
    //   466: aload 14
    //   468: invokevirtual 324	java/io/File:exists	()Z
    //   471: ifeq +263 -> 734
    //   474: iconst_1
    //   475: istore 7
    //   477: new 336	com/tencent/mm/audio/mix/c/b
    //   480: dup
    //   481: aload 15
    //   483: iload 7
    //   485: aload_0
    //   486: getfield 193	com/tencent/mm/audio/mix/d/d:dvk	Lcom/tencent/mm/ai/b;
    //   489: getfield 316	com/tencent/mm/ai/b:appId	Ljava/lang/String;
    //   492: invokespecial 339	com/tencent/mm/audio/mix/c/b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   495: astore 13
    //   497: iconst_0
    //   498: istore 8
    //   500: ldc 83
    //   502: ldc_w 341
    //   505: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: iload 8
    //   510: istore 7
    //   512: aload_0
    //   513: invokevirtual 344	com/tencent/mm/audio/mix/d/d:YZ	()Z
    //   516: ifne +73 -> 589
    //   519: aload_0
    //   520: invokevirtual 347	com/tencent/mm/audio/mix/d/d:Zb	()V
    //   523: aload 13
    //   525: invokevirtual 351	com/tencent/mm/audio/mix/c/b:YO	()[B
    //   528: astore 14
    //   530: aload 14
    //   532: ifnull +28 -> 560
    //   535: aload_0
    //   536: ldc_w 352
    //   539: putfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   542: aload_0
    //   543: iconst_2
    //   544: putfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   547: aload_0
    //   548: iconst_2
    //   549: putfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   552: aload_0
    //   553: aload 12
    //   555: aload 14
    //   557: invokespecial 131	com/tencent/mm/audio/mix/d/d:b	(Lcom/tencent/mm/audio/mix/a/d;[B)V
    //   560: aload 12
    //   562: invokevirtual 355	com/tencent/mm/audio/mix/a/d:size	()I
    //   565: ifle +175 -> 740
    //   568: aload 14
    //   570: ifnonnull +170 -> 740
    //   573: aload 12
    //   575: invokevirtual 358	com/tencent/mm/audio/mix/a/d:complete	()V
    //   578: getstatic 30	com/tencent/mm/audio/mix/d/d:dvE	I
    //   581: iconst_1
    //   582: iadd
    //   583: putstatic 30	com/tencent/mm/audio/mix/d/d:dvE	I
    //   586: iconst_1
    //   587: istore 7
    //   589: ldc 83
    //   591: ldc_w 360
    //   594: iconst_1
    //   595: anewarray 87	java/lang/Object
    //   598: dup
    //   599: iconst_0
    //   600: iload 7
    //   602: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   605: aastore
    //   606: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   609: ldc_w 367
    //   612: ldc_w 368
    //   615: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 13
    //   620: getfield 372	com/tencent/mm/audio/mix/c/b:inputStream	Ljava/io/InputStream;
    //   623: ifnull +17 -> 640
    //   626: aload 13
    //   628: getfield 372	com/tencent/mm/audio/mix/c/b:inputStream	Ljava/io/InputStream;
    //   631: invokevirtual 375	java/io/InputStream:close	()V
    //   634: aload 13
    //   636: aconst_null
    //   637: putfield 372	com/tencent/mm/audio/mix/c/b:inputStream	Ljava/io/InputStream;
    //   640: iload 7
    //   642: ifeq +183 -> 825
    //   645: aload 12
    //   647: aload_0
    //   648: getfield 379	com/tencent/mm/audio/mix/d/d:dvj	Lcom/tencent/mm/audio/mix/h/c;
    //   651: invokeinterface 385 1 0
    //   656: getfield 389	com/tencent/mm/ai/b:dtU	Z
    //   659: putfield 390	com/tencent/mm/audio/mix/a/d:dtU	Z
    //   662: aload_0
    //   663: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   666: ldc 83
    //   668: ldc_w 392
    //   671: iconst_1
    //   672: anewarray 87	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: getstatic 30	com/tencent/mm/audio/mix/d/d:dvE	I
    //   680: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   683: aastore
    //   684: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   687: ldc 178
    //   689: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   692: return
    //   693: astore 11
    //   695: ldc 83
    //   697: aload 11
    //   699: ldc_w 394
    //   702: iconst_0
    //   703: anewarray 87	java/lang/Object
    //   706: invokestatic 93	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   709: aload_0
    //   710: sipush 705
    //   713: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   716: aload_0
    //   717: aload_0
    //   718: getfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   721: invokevirtual 266	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   724: aload_0
    //   725: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   728: ldc 178
    //   730: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   733: return
    //   734: iconst_0
    //   735: istore 7
    //   737: goto -260 -> 477
    //   740: aload 12
    //   742: invokevirtual 355	com/tencent/mm/audio/mix/a/d:size	()I
    //   745: ifne +20 -> 765
    //   748: aload 14
    //   750: ifnonnull +15 -> 765
    //   753: aload 12
    //   755: invokevirtual 331	com/tencent/mm/audio/mix/a/d:reset	()V
    //   758: iload 8
    //   760: istore 7
    //   762: goto -173 -> 589
    //   765: iload 8
    //   767: istore 7
    //   769: aload 14
    //   771: ifnull -182 -> 589
    //   774: aload 14
    //   776: ifnonnull -268 -> 508
    //   779: iload 8
    //   781: istore 7
    //   783: goto -194 -> 589
    //   786: astore 13
    //   788: ldc_w 367
    //   791: aload 13
    //   793: ldc_w 396
    //   796: iconst_0
    //   797: anewarray 87	java/lang/Object
    //   800: invokestatic 93	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   803: goto -163 -> 640
    //   806: ldc 83
    //   808: ldc_w 398
    //   811: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: invokestatic 301	com/tencent/mm/audio/mix/b/a:Yw	()Lcom/tencent/mm/audio/mix/b/a;
    //   817: aload_0
    //   818: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   821: invokevirtual 401	com/tencent/mm/audio/mix/b/a:gC	(Ljava/lang/String;)Z
    //   824: pop
    //   825: aload_0
    //   826: aload_0
    //   827: getfield 46	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   830: invokestatic 405	com/tencent/mm/compatible/deviceinfo/z:DZ	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/z;
    //   833: putfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   836: aload_0
    //   837: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   840: aload 11
    //   842: aconst_null
    //   843: iconst_0
    //   844: invokevirtual 408	com/tencent/mm/compatible/deviceinfo/z:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   847: aload_0
    //   848: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   851: invokevirtual 411	com/tencent/mm/compatible/deviceinfo/z:start	()V
    //   854: aload_0
    //   855: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   858: invokevirtual 415	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   861: astore 13
    //   863: aload_0
    //   864: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   867: invokevirtual 418	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   870: astore 12
    //   872: ldc 83
    //   874: ldc_w 420
    //   877: iconst_2
    //   878: anewarray 87	java/lang/Object
    //   881: dup
    //   882: iconst_0
    //   883: aload 11
    //   885: aastore
    //   886: dup
    //   887: iconst_1
    //   888: aload_0
    //   889: getfield 46	com/tencent/mm/audio/mix/d/d:mime	Ljava/lang/String;
    //   892: aastore
    //   893: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   896: ldc 83
    //   898: ldc_w 422
    //   901: iconst_5
    //   902: anewarray 87	java/lang/Object
    //   905: dup
    //   906: iconst_0
    //   907: aload_0
    //   908: getfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   911: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   914: aastore
    //   915: dup
    //   916: iconst_1
    //   917: aload_0
    //   918: getfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   921: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   924: aastore
    //   925: dup
    //   926: iconst_2
    //   927: aload_0
    //   928: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   931: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   934: aastore
    //   935: dup
    //   936: iconst_3
    //   937: aload_0
    //   938: getfield 52	com/tencent/mm/audio/mix/d/d:duration	J
    //   941: invokestatic 427	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   944: aastore
    //   945: dup
    //   946: iconst_4
    //   947: aload_0
    //   948: getfield 379	com/tencent/mm/audio/mix/d/d:dvj	Lcom/tencent/mm/audio/mix/h/c;
    //   951: invokeinterface 385 1 0
    //   956: getfield 430	com/tencent/mm/ai/b:dtX	Ljava/lang/String;
    //   959: aastore
    //   960: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   963: aload_0
    //   964: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   967: iconst_0
    //   968: invokevirtual 433	android/media/MediaExtractor:selectTrack	(I)V
    //   971: new 435	android/media/MediaCodec$BufferInfo
    //   974: dup
    //   975: invokespecial 436	android/media/MediaCodec$BufferInfo:<init>	()V
    //   978: astore 15
    //   980: iconst_0
    //   981: istore_2
    //   982: aload_0
    //   983: invokevirtual 328	com/tencent/mm/audio/mix/d/d:Za	()Lcom/tencent/mm/audio/mix/a/d;
    //   986: astore 14
    //   988: aload 14
    //   990: invokevirtual 331	com/tencent/mm/audio/mix/a/d:reset	()V
    //   993: aload_0
    //   994: getfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   997: aload_0
    //   998: getfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   1001: aload_0
    //   1002: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1005: invokestatic 441	com/tencent/mm/audio/mix/g/a:I	(III)Z
    //   1008: ifne +379 -> 1387
    //   1011: ldc 83
    //   1013: ldc_w 443
    //   1016: invokestatic 124	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1019: aload_0
    //   1020: new 445	com/tencent/mm/audio/mix/c/e
    //   1023: dup
    //   1024: aload 14
    //   1026: aload_0
    //   1027: getfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1030: aload_0
    //   1031: getfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   1034: aload_0
    //   1035: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1038: aload_0
    //   1039: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   1042: invokespecial 448	com/tencent/mm/audio/mix/c/e:<init>	(Lcom/tencent/mm/audio/mix/a/d;IIILjava/lang/String;)V
    //   1045: putfield 452	com/tencent/mm/audio/mix/d/d:dvl	Lcom/tencent/mm/audio/mix/c/h;
    //   1048: aload 14
    //   1050: aload_0
    //   1051: getfield 52	com/tencent/mm/audio/mix/d/d:duration	J
    //   1054: ldc2_w 332
    //   1057: ldiv
    //   1058: putfield 334	com/tencent/mm/audio/mix/a/d:duration	J
    //   1061: iconst_0
    //   1062: istore_1
    //   1063: aload 12
    //   1065: astore 11
    //   1067: iconst_0
    //   1068: istore_3
    //   1069: iload_3
    //   1070: ifne +919 -> 1989
    //   1073: iload_2
    //   1074: bipush 50
    //   1076: if_icmpge +913 -> 1989
    //   1079: aload_0
    //   1080: invokevirtual 344	com/tencent/mm/audio/mix/d/d:YZ	()Z
    //   1083: ifne +906 -> 1989
    //   1086: aload_0
    //   1087: invokevirtual 347	com/tencent/mm/audio/mix/d/d:Zb	()V
    //   1090: iload_2
    //   1091: iconst_1
    //   1092: iadd
    //   1093: istore 4
    //   1095: iload_1
    //   1096: istore 5
    //   1098: iload_1
    //   1099: ifne +100 -> 1199
    //   1102: aload_0
    //   1103: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1106: ldc2_w 332
    //   1109: invokevirtual 456	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   1112: istore 6
    //   1114: iload 6
    //   1116: iflt +317 -> 1433
    //   1119: aload 13
    //   1121: iload 6
    //   1123: aaload
    //   1124: astore 12
    //   1126: aload_0
    //   1127: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   1130: aload 12
    //   1132: iconst_0
    //   1133: invokevirtual 460	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   1136: istore_2
    //   1137: iload_2
    //   1138: ifge +281 -> 1419
    //   1141: ldc 83
    //   1143: ldc_w 462
    //   1146: invokestatic 124	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1149: iconst_1
    //   1150: istore_1
    //   1151: iconst_0
    //   1152: istore_2
    //   1153: aload_0
    //   1154: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1157: astore 12
    //   1159: aload_0
    //   1160: getfield 50	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   1163: lstore 9
    //   1165: iload_1
    //   1166: ifeq +967 -> 2133
    //   1169: iconst_4
    //   1170: istore 5
    //   1172: aload 12
    //   1174: iload 6
    //   1176: iload_2
    //   1177: lload 9
    //   1179: iload 5
    //   1181: invokevirtual 465	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   1184: iload_1
    //   1185: ifne +942 -> 2127
    //   1188: aload_0
    //   1189: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   1192: invokevirtual 468	android/media/MediaExtractor:advance	()Z
    //   1195: pop
    //   1196: goto +931 -> 2127
    //   1199: aload_0
    //   1200: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1203: aload 15
    //   1205: ldc2_w 332
    //   1208: invokevirtual 472	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1211: istore_2
    //   1212: iload_2
    //   1213: iflt +311 -> 1524
    //   1216: aload 15
    //   1218: getfield 474	android/media/MediaCodec$BufferInfo:size	I
    //   1221: ifle +894 -> 2115
    //   1224: iconst_0
    //   1225: istore_1
    //   1226: aload 11
    //   1228: iload_2
    //   1229: aaload
    //   1230: astore 12
    //   1232: aload 15
    //   1234: getfield 474	android/media/MediaCodec$BufferInfo:size	I
    //   1237: istore 4
    //   1239: iload 4
    //   1241: ifle +13 -> 1254
    //   1244: aload_0
    //   1245: aload 14
    //   1247: aload 12
    //   1249: iload 4
    //   1251: invokevirtual 477	com/tencent/mm/audio/mix/d/d:a	(Lcom/tencent/mm/audio/mix/a/d;Ljava/nio/ByteBuffer;I)V
    //   1254: aload 12
    //   1256: invokevirtual 483	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1259: pop
    //   1260: aload_0
    //   1261: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1264: iload_2
    //   1265: iconst_0
    //   1266: invokevirtual 487	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   1269: aload 15
    //   1271: getfield 490	android/media/MediaCodec$BufferInfo:flags	I
    //   1274: iconst_4
    //   1275: iand
    //   1276: ifeq +13 -> 1289
    //   1279: ldc 83
    //   1281: ldc_w 492
    //   1284: invokestatic 124	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1287: iconst_1
    //   1288: istore_3
    //   1289: iload_1
    //   1290: istore_2
    //   1291: iload 5
    //   1293: istore_1
    //   1294: goto -225 -> 1069
    //   1297: astore 11
    //   1299: ldc 83
    //   1301: aload 11
    //   1303: ldc_w 494
    //   1306: iconst_0
    //   1307: anewarray 87	java/lang/Object
    //   1310: invokestatic 93	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1313: aload_0
    //   1314: sipush 704
    //   1317: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1320: aload_0
    //   1321: aload_0
    //   1322: getfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1325: invokevirtual 266	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1328: aload_0
    //   1329: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   1332: aload_0
    //   1333: invokespecial 496	com/tencent/mm/audio/mix/d/d:Zn	()V
    //   1336: ldc 178
    //   1338: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1341: return
    //   1342: astore 11
    //   1344: ldc 83
    //   1346: aload 11
    //   1348: ldc_w 498
    //   1351: iconst_0
    //   1352: anewarray 87	java/lang/Object
    //   1355: invokestatic 93	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1358: aload_0
    //   1359: sipush 716
    //   1362: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1365: aload_0
    //   1366: aload_0
    //   1367: getfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1370: invokevirtual 266	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1373: aload_0
    //   1374: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   1377: aload_0
    //   1378: invokespecial 496	com/tencent/mm/audio/mix/d/d:Zn	()V
    //   1381: ldc 178
    //   1383: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1386: return
    //   1387: getstatic 32	com/tencent/mm/audio/mix/d/d:dvF	I
    //   1390: iconst_1
    //   1391: iadd
    //   1392: putstatic 32	com/tencent/mm/audio/mix/d/d:dvF	I
    //   1395: ldc 83
    //   1397: ldc_w 500
    //   1400: iconst_1
    //   1401: anewarray 87	java/lang/Object
    //   1404: dup
    //   1405: iconst_0
    //   1406: getstatic 32	com/tencent/mm/audio/mix/d/d:dvF	I
    //   1409: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1412: aastore
    //   1413: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1416: goto -368 -> 1048
    //   1419: aload_0
    //   1420: aload_0
    //   1421: getfield 73	com/tencent/mm/audio/mix/d/d:dvy	Landroid/media/MediaExtractor;
    //   1424: invokevirtual 504	android/media/MediaExtractor:getSampleTime	()J
    //   1427: putfield 50	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   1430: goto -277 -> 1153
    //   1433: ldc 83
    //   1435: ldc_w 506
    //   1438: iload 6
    //   1440: invokestatic 509	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1443: invokevirtual 512	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1446: invokestatic 124	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1449: iload_1
    //   1450: istore 5
    //   1452: goto -253 -> 1199
    //   1455: astore 11
    //   1457: ldc 83
    //   1459: aload 11
    //   1461: ldc 180
    //   1463: iconst_0
    //   1464: anewarray 87	java/lang/Object
    //   1467: invokestatic 93	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1470: aload_0
    //   1471: sipush 706
    //   1474: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1477: aload_0
    //   1478: aload_0
    //   1479: getfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1482: invokevirtual 266	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1485: aload_0
    //   1486: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   1489: aload_0
    //   1490: invokespecial 496	com/tencent/mm/audio/mix/d/d:Zn	()V
    //   1493: aload 14
    //   1495: aload_0
    //   1496: getfield 379	com/tencent/mm/audio/mix/d/d:dvj	Lcom/tencent/mm/audio/mix/h/c;
    //   1499: invokeinterface 385 1 0
    //   1504: getfield 389	com/tencent/mm/ai/b:dtU	Z
    //   1507: putfield 390	com/tencent/mm/audio/mix/a/d:dtU	Z
    //   1510: ldc 83
    //   1512: ldc_w 514
    //   1515: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1518: ldc 178
    //   1520: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1523: return
    //   1524: iload_2
    //   1525: bipush 253
    //   1527: if_icmpne +29 -> 1556
    //   1530: aload_0
    //   1531: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1534: invokevirtual 418	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1537: astore 11
    //   1539: ldc 83
    //   1541: ldc_w 516
    //   1544: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1547: iload 5
    //   1549: istore_1
    //   1550: iload 4
    //   1552: istore_2
    //   1553: goto -484 -> 1069
    //   1556: iload_2
    //   1557: bipush 254
    //   1559: if_icmpne +406 -> 1965
    //   1562: aload_0
    //   1563: getfield 97	com/tencent/mm/audio/mix/d/d:dvz	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1566: invokevirtual 520	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   1569: astore 12
    //   1571: ldc 83
    //   1573: ldc_w 522
    //   1576: aload 12
    //   1578: invokestatic 525	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1581: invokevirtual 512	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1584: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1587: aload_0
    //   1588: aload 12
    //   1590: ldc_w 283
    //   1593: invokevirtual 287	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1596: putfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1599: aload_0
    //   1600: aload 12
    //   1602: ldc_w 289
    //   1605: invokevirtual 287	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1608: putfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   1611: aload 12
    //   1613: ldc_w 527
    //   1616: invokevirtual 530	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1619: ifeq +164 -> 1783
    //   1622: aload_0
    //   1623: aload 12
    //   1625: ldc_w 527
    //   1628: invokevirtual 287	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1631: putfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1634: ldc 83
    //   1636: ldc_w 532
    //   1639: iconst_5
    //   1640: anewarray 87	java/lang/Object
    //   1643: dup
    //   1644: iconst_0
    //   1645: aload_0
    //   1646: getfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1649: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1652: aastore
    //   1653: dup
    //   1654: iconst_1
    //   1655: aload_0
    //   1656: getfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   1659: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1662: aastore
    //   1663: dup
    //   1664: iconst_2
    //   1665: aload_0
    //   1666: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1669: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1672: aastore
    //   1673: dup
    //   1674: iconst_3
    //   1675: aload_0
    //   1676: getfield 379	com/tencent/mm/audio/mix/d/d:dvj	Lcom/tencent/mm/audio/mix/h/c;
    //   1679: invokeinterface 385 1 0
    //   1684: getfield 430	com/tencent/mm/ai/b:dtX	Ljava/lang/String;
    //   1687: aastore
    //   1688: dup
    //   1689: iconst_4
    //   1690: aload_0
    //   1691: getfield 271	com/tencent/mm/audio/mix/d/d:sourcePath	Ljava/lang/String;
    //   1694: aastore
    //   1695: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1698: aload_0
    //   1699: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1702: tableswitch	default:+437 -> 2139, 1:+442->2144, 2:+442->2144, 3:+442->2144
    //   1729: ifne +120 -> 1849
    //   1732: ldc 83
    //   1734: ldc_w 534
    //   1737: iconst_1
    //   1738: anewarray 87	java/lang/Object
    //   1741: dup
    //   1742: iconst_0
    //   1743: aload_0
    //   1744: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1747: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1750: aastore
    //   1751: invokestatic 536	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1754: aload_0
    //   1755: sipush 709
    //   1758: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1761: aload_0
    //   1762: aload_0
    //   1763: getfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   1766: invokevirtual 266	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   1769: aload_0
    //   1770: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   1773: aload_0
    //   1774: invokespecial 496	com/tencent/mm/audio/mix/d/d:Zn	()V
    //   1777: ldc 178
    //   1779: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1782: return
    //   1783: aload 12
    //   1785: ldc_w 538
    //   1788: invokevirtual 530	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   1791: ifeq -157 -> 1634
    //   1794: aload 12
    //   1796: ldc_w 538
    //   1799: invokevirtual 287	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   1802: istore_1
    //   1803: iload_1
    //   1804: bipush 16
    //   1806: if_icmpne +29 -> 1835
    //   1809: aload_0
    //   1810: iconst_2
    //   1811: putfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1814: goto -180 -> 1634
    //   1817: astore 11
    //   1819: aload_0
    //   1820: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   1823: aload_0
    //   1824: invokespecial 496	com/tencent/mm/audio/mix/d/d:Zn	()V
    //   1827: ldc 178
    //   1829: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1832: aload 11
    //   1834: athrow
    //   1835: iload_1
    //   1836: bipush 8
    //   1838: if_icmpne -204 -> 1634
    //   1841: aload_0
    //   1842: iconst_3
    //   1843: putfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1846: goto -212 -> 1634
    //   1849: aload_0
    //   1850: getfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1853: aload_0
    //   1854: getfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   1857: aload_0
    //   1858: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1861: invokestatic 441	com/tencent/mm/audio/mix/g/a:I	(III)Z
    //   1864: ifeq +50 -> 1914
    //   1867: aload_0
    //   1868: getfield 452	com/tencent/mm/audio/mix/d/d:dvl	Lcom/tencent/mm/audio/mix/c/h;
    //   1871: ifnull +43 -> 1914
    //   1874: ldc 83
    //   1876: ldc_w 540
    //   1879: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1882: aload_0
    //   1883: getfield 452	com/tencent/mm/audio/mix/d/d:dvl	Lcom/tencent/mm/audio/mix/c/h;
    //   1886: invokeinterface 545 1 0
    //   1891: aload_0
    //   1892: getfield 452	com/tencent/mm/audio/mix/d/d:dvl	Lcom/tencent/mm/audio/mix/c/h;
    //   1895: invokeinterface 546 1 0
    //   1900: aload_0
    //   1901: aconst_null
    //   1902: putfield 452	com/tencent/mm/audio/mix/d/d:dvl	Lcom/tencent/mm/audio/mix/c/h;
    //   1905: iload 5
    //   1907: istore_1
    //   1908: iload 4
    //   1910: istore_2
    //   1911: goto -842 -> 1069
    //   1914: iload 5
    //   1916: istore_1
    //   1917: iload 4
    //   1919: istore_2
    //   1920: aload_0
    //   1921: getfield 452	com/tencent/mm/audio/mix/d/d:dvl	Lcom/tencent/mm/audio/mix/c/h;
    //   1924: ifnull -855 -> 1069
    //   1927: ldc 83
    //   1929: ldc_w 548
    //   1932: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1935: aload_0
    //   1936: getfield 452	com/tencent/mm/audio/mix/d/d:dvl	Lcom/tencent/mm/audio/mix/c/h;
    //   1939: aload_0
    //   1940: getfield 162	com/tencent/mm/audio/mix/d/d:sampleRate	I
    //   1943: aload_0
    //   1944: getfield 166	com/tencent/mm/audio/mix/d/d:channels	I
    //   1947: aload_0
    //   1948: getfield 48	com/tencent/mm/audio/mix/d/d:dtP	I
    //   1951: invokeinterface 552 4 0
    //   1956: iload 5
    //   1958: istore_1
    //   1959: iload 4
    //   1961: istore_2
    //   1962: goto -893 -> 1069
    //   1965: ldc 83
    //   1967: ldc_w 554
    //   1970: iload_2
    //   1971: invokestatic 509	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1974: invokevirtual 512	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1977: invokestatic 182	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1980: iload 5
    //   1982: istore_1
    //   1983: iload 4
    //   1985: istore_2
    //   1986: goto -917 -> 1069
    //   1989: aload_0
    //   1990: getfield 52	com/tencent/mm/audio/mix/d/d:duration	J
    //   1993: ldc2_w 332
    //   1996: ldiv
    //   1997: aload_0
    //   1998: getfield 50	com/tencent/mm/audio/mix/d/d:presentationTimeUs	J
    //   2001: ldc2_w 332
    //   2004: ldiv
    //   2005: lsub
    //   2006: ldc2_w 555
    //   2009: lcmp
    //   2010: ifge +57 -> 2067
    //   2013: iconst_1
    //   2014: istore 7
    //   2016: iload_2
    //   2017: bipush 50
    //   2019: if_icmplt +54 -> 2073
    //   2022: ldc 83
    //   2024: ldc_w 558
    //   2027: iconst_1
    //   2028: anewarray 87	java/lang/Object
    //   2031: dup
    //   2032: iconst_0
    //   2033: iload_2
    //   2034: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2037: aastore
    //   2038: invokestatic 536	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2041: aload_0
    //   2042: sipush 706
    //   2045: putfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   2048: aload_0
    //   2049: aload_0
    //   2050: getfield 263	com/tencent/mm/audio/mix/d/d:dvm	I
    //   2053: invokevirtual 266	com/tencent/mm/audio/mix/d/d:onError	(I)V
    //   2056: aload_0
    //   2057: invokespecial 268	com/tencent/mm/audio/mix/d/d:Zm	()V
    //   2060: aload_0
    //   2061: invokespecial 496	com/tencent/mm/audio/mix/d/d:Zn	()V
    //   2064: goto -571 -> 1493
    //   2067: iconst_0
    //   2068: istore 7
    //   2070: goto -54 -> 2016
    //   2073: ldc 83
    //   2075: ldc_w 560
    //   2078: iconst_1
    //   2079: anewarray 87	java/lang/Object
    //   2082: dup
    //   2083: iconst_0
    //   2084: iload 7
    //   2086: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2089: aastore
    //   2090: invokestatic 239	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2093: iload 7
    //   2095: ifeq +12 -> 2107
    //   2098: aload_0
    //   2099: aload 14
    //   2101: invokevirtual 562	com/tencent/mm/audio/mix/d/d:b	(Lcom/tencent/mm/audio/mix/a/d;)V
    //   2104: goto -48 -> 2056
    //   2107: aload 14
    //   2109: invokevirtual 331	com/tencent/mm/audio/mix/a/d:reset	()V
    //   2112: goto -56 -> 2056
    //   2115: iload 4
    //   2117: istore_1
    //   2118: goto -892 -> 1226
    //   2121: aconst_null
    //   2122: astore 11
    //   2124: goto -1920 -> 204
    //   2127: iload_1
    //   2128: istore 5
    //   2130: goto -931 -> 1199
    //   2133: iconst_0
    //   2134: istore 5
    //   2136: goto -964 -> 1172
    //   2139: iconst_0
    //   2140: istore_1
    //   2141: goto -413 -> 1728
    //   2144: iconst_1
    //   2145: istore_1
    //   2146: goto -418 -> 1728
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2149	0	this	d
    //   154	1992	1	i	int
    //   134	1900	2	j	int
    //   1068	221	3	k	int
    //   1093	1023	4	m	int
    //   1096	1039	5	n	int
    //   1112	327	6	i1	int
    //   475	1619	7	bool1	boolean
    //   498	282	8	bool2	boolean
    //   1163	15	9	l	long
    //   87	118	11	localObject1	Object
    //   256	94	11	localException1	Exception
    //   693	191	11	localException2	Exception
    //   1065	162	11	localObject2	Object
    //   1297	5	11	localException3	Exception
    //   1342	5	11	localIllegalStateException	java.lang.IllegalStateException
    //   1455	5	11	localException4	Exception
    //   1537	1	11	arrayOfByteBuffer1	ByteBuffer[]
    //   1817	16	11	localObject3	Object
    //   2122	1	11	localObject4	Object
    //   432	1363	12	localObject5	Object
    //   387	248	13	localObject6	Object
    //   786	6	13	localException5	Exception
    //   861	259	13	arrayOfByteBuffer2	ByteBuffer[]
    //   410	1698	14	localObject7	Object
    //   456	814	15	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   23	103	256	java/lang/Exception
    //   103	127	256	java/lang/Exception
    //   242	253	256	java/lang/Exception
    //   127	153	693	java/lang/Exception
    //   160	204	693	java/lang/Exception
    //   209	236	693	java/lang/Exception
    //   307	360	693	java/lang/Exception
    //   618	640	786	java/lang/Exception
    //   825	854	1297	java/lang/Exception
    //   854	872	1342	java/lang/IllegalStateException
    //   1079	1090	1455	java/lang/Exception
    //   1102	1114	1455	java/lang/Exception
    //   1126	1137	1455	java/lang/Exception
    //   1141	1149	1455	java/lang/Exception
    //   1153	1165	1455	java/lang/Exception
    //   1172	1184	1455	java/lang/Exception
    //   1188	1196	1455	java/lang/Exception
    //   1199	1212	1455	java/lang/Exception
    //   1216	1224	1455	java/lang/Exception
    //   1232	1239	1455	java/lang/Exception
    //   1244	1254	1455	java/lang/Exception
    //   1254	1269	1455	java/lang/Exception
    //   1269	1287	1455	java/lang/Exception
    //   1419	1430	1455	java/lang/Exception
    //   1433	1449	1455	java/lang/Exception
    //   1530	1547	1455	java/lang/Exception
    //   1562	1634	1455	java/lang/Exception
    //   1634	1728	1455	java/lang/Exception
    //   1732	1769	1455	java/lang/Exception
    //   1783	1803	1455	java/lang/Exception
    //   1809	1814	1455	java/lang/Exception
    //   1841	1846	1455	java/lang/Exception
    //   1849	1905	1455	java/lang/Exception
    //   1920	1956	1455	java/lang/Exception
    //   1965	1980	1455	java/lang/Exception
    //   1989	2013	1455	java/lang/Exception
    //   2022	2056	1455	java/lang/Exception
    //   2073	2093	1455	java/lang/Exception
    //   2098	2104	1455	java/lang/Exception
    //   2107	2112	1455	java/lang/Exception
    //   1079	1090	1817	finally
    //   1102	1114	1817	finally
    //   1126	1137	1817	finally
    //   1141	1149	1817	finally
    //   1153	1165	1817	finally
    //   1172	1184	1817	finally
    //   1188	1196	1817	finally
    //   1199	1212	1817	finally
    //   1216	1224	1817	finally
    //   1232	1239	1817	finally
    //   1244	1254	1817	finally
    //   1254	1269	1817	finally
    //   1269	1287	1817	finally
    //   1419	1430	1817	finally
    //   1433	1449	1817	finally
    //   1457	1485	1817	finally
    //   1530	1547	1817	finally
    //   1562	1634	1817	finally
    //   1634	1728	1817	finally
    //   1732	1769	1817	finally
    //   1783	1803	1817	finally
    //   1809	1814	1817	finally
    //   1841	1846	1817	finally
    //   1849	1905	1817	finally
    //   1920	1956	1817	finally
    //   1965	1980	1817	finally
    //   1989	2013	1817	finally
    //   2022	2056	1817	finally
    //   2073	2093	1817	finally
    //   2098	2104	1817	finally
    //   2107	2112	1817	finally
  }
  
  protected void a(com.tencent.mm.audio.mix.a.d paramd, ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(136801);
    if (this.dvl != null)
    {
      if (paramInt != this.dvC)
      {
        this.dvC = paramInt;
        this.dvB = new byte[paramInt];
      }
      paramByteBuffer.get(this.dvB);
      if (this.dvj.ZU().iJS) {
        com.tencent.mm.audio.mix.c.a.a(this.dvB, Zk().iJG);
      }
      this.dvl.X(this.dvB);
      AppMethodBeat.o(136801);
      return;
    }
    b(paramd, paramByteBuffer, paramInt);
    AppMethodBeat.o(136801);
  }
  
  protected void b(com.tencent.mm.audio.mix.a.d paramd)
  {
    AppMethodBeat.i(136803);
    if (this.dvl != null)
    {
      this.dvl.YR();
      com.tencent.mm.audio.mix.b.a.Yw().gB(paramd.dtT);
      if (YZ())
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
        this.dvl.flushCache();
        AppMethodBeat.o(136803);
        return;
      }
      if (YY())
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
        this.dvl.flushCache();
        Zf();
        AppMethodBeat.o(136803);
        return;
      }
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
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
    for (paramByteBuffer = arrayOfByte;; paramByteBuffer = this.dvB)
    {
      if (this.dvj.ZU().iJS) {
        com.tencent.mm.audio.mix.c.a.a(paramByteBuffer, Zk().iJG);
      }
      a(paramd, paramByteBuffer);
      AppMethodBeat.o(136802);
      return;
      if (paramInt != this.dvC)
      {
        this.dvC = paramInt;
        this.dvB = new byte[paramInt];
      }
      Arrays.fill(this.dvB, 0, this.dvC, (byte)0);
      paramByteBuffer.get(this.dvB, 0, this.dvC);
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
      System.arraycopy(this.buffer, j * 3536, this.dvD, 0, k);
      Arrays.fill(this.buffer, 0, this.BUFFER_SIZE, (byte)0);
      System.arraycopy(this.dvD, 0, this.buffer, 0, k);
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
    Zm();
    Zn();
    if (this.dvl != null)
    {
      this.dvl.YR();
      this.dvl.release();
      this.dvl = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.d
 * JD-Core Version:    0.7.0.1
 */