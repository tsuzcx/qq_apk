package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqpinyin.voicerecoapi.TRSpeexNative;
import com.tencent.qqpinyin.voicerecoapi.a;
import java.io.InputStream;

public final class l
  implements d
{
  AudioTrack ayN;
  private int cCy;
  com.tencent.mm.compatible.util.b cih;
  String fZP;
  String fZQ;
  boolean fZY;
  String fileName;
  MediaPlayer.OnCompletionListener gab;
  MediaPlayer.OnErrorListener gac;
  d.a gaf;
  d.b gag;
  private int gah;
  private int gai;
  private Runnable gaj;
  a gak;
  private int gal;
  int gam;
  boolean gan;
  byte[] gao;
  int gap;
  InputStream gaq;
  int gar;
  private int nSamplerate;
  volatile int status;
  
  public l()
  {
    AppMethodBeat.i(55819);
    this.fileName = "";
    this.gaf = null;
    this.gag = null;
    this.status = 0;
    this.gah = 2;
    this.nSamplerate = 16000;
    this.cCy = 1;
    this.gai = 20;
    this.gak = null;
    this.gam = 0;
    this.gan = false;
    this.fZP = "";
    this.fZQ = "";
    this.fZY = true;
    this.gao = new byte[a.MAX_FRAME_SIZE];
    this.gap = 0;
    this.gaq = null;
    this.gar = 314;
    this.gab = new l.1(this);
    this.gac = new l.2(this);
    this.gak = new a();
    a locala = this.gak;
    if (locala.BhL != 0) {
      i = -103;
    }
    for (;;)
    {
      if (i != 0) {
        ab.e("speex", "res: ".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(55819);
      return;
      int j = locala.BhM.nativeTRSpeexDecodeInit();
      if ((j == -1) || (j == -100) || (j == -101) || (j == -102))
      {
        i = j;
      }
      else
      {
        locala.BhL = j;
        locala.BhJ = new byte[a.MAX_FRAME_SIZE * 15];
      }
    }
  }
  
  public l(Context paramContext)
  {
    this();
    AppMethodBeat.i(55820);
    this.cih = new com.tencent.mm.compatible.util.b(paramContext);
    AppMethodBeat.o(55820);
  }
  
  private boolean U(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55825);
    if (this.status != 0)
    {
      ab.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
      AppMethodBeat.o(55825);
      return false;
    }
    ab.i("MicroMsg.SpeexPlayer", "startPlay");
    this.status = 1;
    this.fileName = paramString;
    try
    {
      dn(paramBoolean);
      AppMethodBeat.o(55825);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        dn(true);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
        ab.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bo.l(paramString) });
        this.status = -1;
        AppMethodBeat.o(55825);
      }
    }
    return false;
  }
  
  private void amq()
  {
    AppMethodBeat.i(55827);
    if (this.ayN != null) {}
    try
    {
      this.ayN.play();
      this.gaj = new l.3(this);
      com.tencent.mm.sdk.g.d.post(this.gaj, "SpeexPlayer_play");
      AppMethodBeat.o(55827);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(55827);
    }
  }
  
  private void dn(boolean paramBoolean)
  {
    int j = 3;
    AppMethodBeat.i(55826);
    if (!com.tencent.mm.vfs.e.cN(this.fileName))
    {
      AppMethodBeat.o(55826);
      return;
    }
    int i;
    if (paramBoolean) {
      i = 3;
    }
    label243:
    for (;;)
    {
      try
      {
        if (!ac.erv.emD) {
          break label243;
        }
        ac.erv.dump();
        if (ac.erv.emK != 1) {
          break label243;
        }
        i = j;
        this.gal = AudioTrack.getMinBufferSize(this.nSamplerate, this.gah, 2);
        amp();
        this.ayN = new com.tencent.mm.compatible.b.e(i, this.nSamplerate, this.gah, this.gal * 8);
        this.gar = (this.nSamplerate / 1000 * this.cCy * this.gai * 2);
        if ((this.cih != null) && (this.fZY)) {
          this.cih.requestFocus();
        }
        amq();
        AppMethodBeat.o(55826);
        return;
      }
      catch (Exception localException)
      {
        if ((this.cih == null) || (!this.fZY)) {
          continue;
        }
        this.cih.Mh();
        amp();
        ab.e("MicroMsg.SpeexPlayer", "playImp : fail, exception = " + localException.getMessage());
        ab.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bo.l(localException) });
        AppMethodBeat.o(55826);
        return;
      }
      i = 0;
    }
  }
  
  /* Error */
  public final boolean Eo()
  {
    // Byte code:
    //   0: ldc_w 302
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 64	com/tencent/mm/modelvoice/l:status	I
    //   10: iconst_2
    //   11: if_icmpeq +11 -> 22
    //   14: ldc_w 302
    //   17: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 64	com/tencent/mm/modelvoice/l:status	I
    //   27: aload_0
    //   28: getfield 80	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: ldc 166
    //   36: ldc_w 304
    //   39: invokestatic 307	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 80	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   46: invokevirtual 310	java/lang/Object:notify	()V
    //   49: ldc 166
    //   51: ldc_w 312
    //   54: invokestatic 307	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   61: ifnull +18 -> 79
    //   64: aload_0
    //   65: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   68: ifeq +11 -> 79
    //   71: aload_0
    //   72: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   75: invokevirtual 293	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   78: pop
    //   79: aload_1
    //   80: monitorexit
    //   81: ldc_w 302
    //   84: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_1
    //   88: ireturn
    //   89: astore_2
    //   90: ldc 166
    //   92: ldc 198
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_2
    //   101: invokestatic 204	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   112: ifnull +18 -> 130
    //   115: aload_0
    //   116: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   119: ifeq +11 -> 130
    //   122: aload_0
    //   123: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   126: invokevirtual 293	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   129: pop
    //   130: aload_1
    //   131: monitorexit
    //   132: ldc_w 302
    //   135: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_2
    //   141: aload_0
    //   142: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   145: ifnull +18 -> 163
    //   148: aload_0
    //   149: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   152: ifeq +11 -> 163
    //   155: aload_0
    //   156: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   159: invokevirtual 293	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   162: pop
    //   163: ldc_w 302
    //   166: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: ldc_w 302
    //   177: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_2
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	l
    //   31	142	1	str	String
    //   89	12	2	localException	Exception
    //   140	30	2	localObject1	Object
    //   171	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	57	89	java/lang/Exception
    //   34	57	140	finally
    //   90	108	140	finally
    //   57	79	171	finally
    //   79	81	171	finally
    //   108	130	171	finally
    //   130	132	171	finally
    //   141	163	171	finally
    //   163	171	171	finally
    //   172	174	171	finally
  }
  
  public final double Er()
  {
    return 0.0D;
  }
  
  /* Error */
  public final boolean Ez()
  {
    // Byte code:
    //   0: ldc_w 316
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 166
    //   8: new 168	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 318
    //   15: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 64	com/tencent/mm/modelvoice/l:status	I
    //   22: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 64	com/tencent/mm/modelvoice/l:status	I
    //   35: iconst_1
    //   36: if_icmpeq +107 -> 143
    //   39: aload_0
    //   40: getfield 64	com/tencent/mm/modelvoice/l:status	I
    //   43: iconst_2
    //   44: if_icmpeq +99 -> 143
    //   47: ldc 166
    //   49: new 168	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 320
    //   56: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 64	com/tencent/mm/modelvoice/l:status	I
    //   63: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield 80	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   76: astore_1
    //   77: aload_1
    //   78: monitorenter
    //   79: aload_0
    //   80: getfield 80	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   83: invokevirtual 310	java/lang/Object:notify	()V
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_0
    //   89: getfield 82	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   92: astore_1
    //   93: aload_1
    //   94: monitorenter
    //   95: aload_0
    //   96: getfield 82	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   99: invokevirtual 310	java/lang/Object:notify	()V
    //   102: aload_1
    //   103: monitorexit
    //   104: aload_0
    //   105: iconst_3
    //   106: putfield 64	com/tencent/mm/modelvoice/l:status	I
    //   109: ldc_w 316
    //   112: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_2
    //   118: aload_1
    //   119: monitorexit
    //   120: ldc_w 316
    //   123: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_2
    //   127: athrow
    //   128: astore_1
    //   129: goto -25 -> 104
    //   132: astore_2
    //   133: aload_1
    //   134: monitorexit
    //   135: ldc_w 316
    //   138: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_2
    //   142: athrow
    //   143: aload_0
    //   144: iconst_3
    //   145: putfield 64	com/tencent/mm/modelvoice/l:status	I
    //   148: aload_0
    //   149: getfield 80	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   152: astore_1
    //   153: aload_1
    //   154: monitorenter
    //   155: aload_0
    //   156: getfield 80	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   159: invokevirtual 310	java/lang/Object:notify	()V
    //   162: aload_0
    //   163: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   166: ifnull +18 -> 184
    //   169: aload_0
    //   170: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   173: ifeq +11 -> 184
    //   176: aload_0
    //   177: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   180: invokevirtual 298	com/tencent/mm/compatible/util/b:Mh	()Z
    //   183: pop
    //   184: aload_1
    //   185: monitorexit
    //   186: ldc_w 316
    //   189: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: iconst_1
    //   193: ireturn
    //   194: astore_2
    //   195: ldc 166
    //   197: ldc 198
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_2
    //   206: invokestatic 204	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   209: aastore
    //   210: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload_0
    //   214: invokevirtual 284	com/tencent/mm/modelvoice/l:amp	()V
    //   217: aload_0
    //   218: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   221: ifnull +18 -> 239
    //   224: aload_0
    //   225: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   228: ifeq +11 -> 239
    //   231: aload_0
    //   232: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   235: invokevirtual 298	com/tencent/mm/compatible/util/b:Mh	()Z
    //   238: pop
    //   239: aload_1
    //   240: monitorexit
    //   241: ldc_w 316
    //   244: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_2
    //   250: aload_0
    //   251: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   254: ifnull +18 -> 272
    //   257: aload_0
    //   258: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   261: ifeq +11 -> 272
    //   264: aload_0
    //   265: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   268: invokevirtual 298	com/tencent/mm/compatible/util/b:Mh	()Z
    //   271: pop
    //   272: ldc_w 316
    //   275: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_2
    //   279: athrow
    //   280: astore_2
    //   281: aload_1
    //   282: monitorexit
    //   283: ldc_w 316
    //   286: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_2
    //   290: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	l
    //   76	43	1	str1	String
    //   128	6	1	localException1	Exception
    //   152	130	1	str2	String
    //   117	10	2	localObject1	Object
    //   132	10	2	localObject2	Object
    //   194	12	2	localException2	Exception
    //   249	30	2	localObject3	Object
    //   280	10	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   79	88	117	finally
    //   118	120	117	finally
    //   72	79	128	java/lang/Exception
    //   88	95	128	java/lang/Exception
    //   120	128	128	java/lang/Exception
    //   135	143	128	java/lang/Exception
    //   95	104	132	finally
    //   133	135	132	finally
    //   155	162	194	java/lang/Exception
    //   155	162	249	finally
    //   195	217	249	finally
    //   162	184	280	finally
    //   184	186	280	finally
    //   217	239	280	finally
    //   239	241	280	finally
    //   250	272	280	finally
    //   272	280	280	finally
    //   281	283	280	finally
  }
  
  public final boolean T(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55823);
    paramBoolean = U(paramString, paramBoolean);
    AppMethodBeat.o(55823);
    return paramBoolean;
  }
  
  public final void a(d.a parama)
  {
    this.gaf = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.gag = paramb;
  }
  
  public final void ami()
  {
    this.fZY = false;
  }
  
  final void amp()
  {
    AppMethodBeat.i(55821);
    if (this.ayN != null)
    {
      this.ayN.stop();
      this.ayN.release();
      this.ayN = null;
    }
    AppMethodBeat.o(55821);
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(55831);
    if ((parama != null) && (this.cih != null)) {
      this.cih.a(parama);
    }
    AppMethodBeat.o(55831);
  }
  
  /* Error */
  public final boolean bw(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 342
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 64	com/tencent/mm/modelvoice/l:status	I
    //   10: iconst_1
    //   11: if_icmpeq +11 -> 22
    //   14: ldc_w 342
    //   17: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: iconst_2
    //   24: putfield 64	com/tencent/mm/modelvoice/l:status	I
    //   27: aload_0
    //   28: getfield 82	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   31: astore 4
    //   33: aload 4
    //   35: monitorenter
    //   36: ldc 166
    //   38: ldc_w 344
    //   41: invokestatic 307	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   47: lstore_2
    //   48: aload_0
    //   49: getfield 82	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   52: invokevirtual 353	java/lang/Object:wait	()V
    //   55: ldc 166
    //   57: new 168	java/lang/StringBuilder
    //   60: dup
    //   61: ldc_w 355
    //   64: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: invokestatic 350	java/lang/System:currentTimeMillis	()J
    //   70: lload_2
    //   71: lsub
    //   72: invokevirtual 358	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 307	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   85: ifnull +22 -> 107
    //   88: iload_1
    //   89: ifeq +18 -> 107
    //   92: aload_0
    //   93: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   96: ifeq +11 -> 107
    //   99: aload_0
    //   100: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   103: invokevirtual 298	com/tencent/mm/compatible/util/b:Mh	()Z
    //   106: pop
    //   107: aload 4
    //   109: monitorexit
    //   110: ldc_w 342
    //   113: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: iconst_1
    //   117: ireturn
    //   118: astore 5
    //   120: ldc 166
    //   122: ldc 198
    //   124: iconst_1
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload 5
    //   132: invokestatic 204	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_0
    //   140: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   143: ifnull +22 -> 165
    //   146: iload_1
    //   147: ifeq +18 -> 165
    //   150: aload_0
    //   151: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   154: ifeq +11 -> 165
    //   157: aload_0
    //   158: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   161: invokevirtual 298	com/tencent/mm/compatible/util/b:Mh	()Z
    //   164: pop
    //   165: aload 4
    //   167: monitorexit
    //   168: ldc_w 342
    //   171: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore 5
    //   178: aload_0
    //   179: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   182: ifnull +22 -> 204
    //   185: iload_1
    //   186: ifeq +18 -> 204
    //   189: aload_0
    //   190: getfield 84	com/tencent/mm/modelvoice/l:fZY	Z
    //   193: ifeq +11 -> 204
    //   196: aload_0
    //   197: getfield 159	com/tencent/mm/modelvoice/l:cih	Lcom/tencent/mm/compatible/util/b;
    //   200: invokevirtual 298	com/tencent/mm/compatible/util/b:Mh	()Z
    //   203: pop
    //   204: ldc_w 342
    //   207: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload 5
    //   212: athrow
    //   213: astore 5
    //   215: aload 4
    //   217: monitorexit
    //   218: ldc_w 342
    //   221: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload 5
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	l
    //   0	227	1	paramBoolean	boolean
    //   47	24	2	l	long
    //   31	185	4	str	String
    //   118	13	5	localException	Exception
    //   176	35	5	localObject1	Object
    //   213	12	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	81	118	java/lang/Exception
    //   36	81	176	finally
    //   120	139	176	finally
    //   81	88	213	finally
    //   92	107	213	finally
    //   107	110	213	finally
    //   139	146	213	finally
    //   150	165	213	finally
    //   165	168	213	finally
    //   178	185	213	finally
    //   189	204	213	finally
    //   204	213	213	finally
    //   215	218	213	finally
  }
  
  /* Error */
  public final void bx(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 360
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield 78	com/tencent/mm/modelvoice/l:gan	Z
    //   11: aload_0
    //   12: getfield 70	com/tencent/mm/modelvoice/l:cCy	I
    //   15: iconst_2
    //   16: if_icmpne +133 -> 149
    //   19: aload_0
    //   20: iconst_3
    //   21: putfield 66	com/tencent/mm/modelvoice/l:gah	I
    //   24: aload_0
    //   25: aload_0
    //   26: getfield 68	com/tencent/mm/modelvoice/l:nSamplerate	I
    //   29: aload_0
    //   30: getfield 66	com/tencent/mm/modelvoice/l:gah	I
    //   33: iconst_2
    //   34: invokestatic 279	android/media/AudioTrack:getMinBufferSize	(III)I
    //   37: putfield 281	com/tencent/mm/modelvoice/l:gal	I
    //   40: aload_0
    //   41: getfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   44: ifnull +22 -> 66
    //   47: aload_0
    //   48: getfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   51: invokevirtual 331	android/media/AudioTrack:stop	()V
    //   54: aload_0
    //   55: getfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   58: invokevirtual 334	android/media/AudioTrack:release	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   66: iload_1
    //   67: ifeq +126 -> 193
    //   70: iconst_3
    //   71: istore_2
    //   72: iload_2
    //   73: istore_3
    //   74: getstatic 264	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   77: getfield 269	com/tencent/mm/compatible/e/b:emD	Z
    //   80: ifeq +23 -> 103
    //   83: getstatic 264	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   86: invokevirtual 272	com/tencent/mm/compatible/e/b:dump	()V
    //   89: iload_2
    //   90: istore_3
    //   91: getstatic 264	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   94: getfield 275	com/tencent/mm/compatible/e/b:emK	I
    //   97: iconst_1
    //   98: if_icmpne +5 -> 103
    //   101: iconst_3
    //   102: istore_3
    //   103: aload_0
    //   104: new 286	com/tencent/mm/compatible/b/e
    //   107: dup
    //   108: iload_3
    //   109: aload_0
    //   110: getfield 68	com/tencent/mm/modelvoice/l:nSamplerate	I
    //   113: aload_0
    //   114: getfield 66	com/tencent/mm/modelvoice/l:gah	I
    //   117: aload_0
    //   118: getfield 281	com/tencent/mm/modelvoice/l:gal	I
    //   121: bipush 8
    //   123: imul
    //   124: invokespecial 289	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   127: putfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   130: aload_0
    //   131: getfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   134: invokevirtual 237	android/media/AudioTrack:play	()V
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 78	com/tencent/mm/modelvoice/l:gan	Z
    //   142: ldc_w 360
    //   145: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: aload_0
    //   150: iconst_2
    //   151: putfield 66	com/tencent/mm/modelvoice/l:gah	I
    //   154: goto -130 -> 24
    //   157: astore 4
    //   159: ldc 166
    //   161: aload 4
    //   163: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   174: goto -108 -> 66
    //   177: astore 4
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 232	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   184: ldc_w 360
    //   187: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload 4
    //   192: athrow
    //   193: iconst_0
    //   194: istore_2
    //   195: goto -123 -> 72
    //   198: astore 4
    //   200: ldc 166
    //   202: ldc 248
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload 4
    //   212: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: aastore
    //   216: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: goto -82 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	l
    //   0	222	1	paramBoolean	boolean
    //   71	124	2	i	int
    //   73	36	3	j	int
    //   157	5	4	localException1	Exception
    //   177	14	4	localObject	Object
    //   198	13	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   47	61	157	java/lang/Exception
    //   47	61	177	finally
    //   159	169	177	finally
    //   130	137	198	java/lang/Exception
  }
  
  public final boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(55824);
    paramBoolean = U(paramString, paramBoolean);
    AppMethodBeat.o(55824);
    return paramBoolean;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean isPlaying()
  {
    return this.status == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.l
 * JD-Core Version:    0.7.0.1
 */