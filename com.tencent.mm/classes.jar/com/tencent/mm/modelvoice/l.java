package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.qqpinyin.voicerecoapi.TRSpeexNative;
import java.io.InputStream;

public final class l
  implements d
{
  AudioTrack aUg;
  private com.tencent.e.i.d cVv;
  com.tencent.mm.compatible.util.b cZO;
  private int channel;
  String fileName;
  String hCB;
  String hCC;
  boolean hCL;
  MediaPlayer.OnCompletionListener hCO;
  MediaPlayer.OnErrorListener hCP;
  d.a hCS;
  d.b hCT;
  private int hCU;
  private int hCV;
  com.tencent.qqpinyin.voicerecoapi.a hCW;
  private int hCX;
  int hCY;
  boolean hCZ;
  byte[] hDa;
  int hDb;
  InputStream hDc;
  int hDd;
  private int nSamplerate;
  volatile int status;
  
  public l()
  {
    AppMethodBeat.i(130073);
    this.fileName = "";
    this.hCS = null;
    this.hCT = null;
    this.status = 0;
    this.hCU = 2;
    this.nSamplerate = 16000;
    this.channel = 1;
    this.hCV = 20;
    this.hCW = null;
    this.hCY = 0;
    this.hCZ = false;
    this.hCB = "";
    this.hCC = "";
    this.hCL = true;
    this.hDa = new byte[com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE];
    this.hDb = 0;
    this.hDc = null;
    this.hDd = 314;
    this.hCO = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130070);
        if ((l.this.cZO != null) && (l.this.hCL)) {
          l.this.cZO.XF();
        }
        try
        {
          l.this.status = 0;
          l.this.aDv();
          try
          {
            l.a(l.this);
            AppMethodBeat.o(130070);
            return;
          }
          catch (InterruptedException paramAnonymousMediaPlayer)
          {
            ad.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bt.m(paramAnonymousMediaPlayer) });
            AppMethodBeat.o(130070);
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          ad.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bt.m(paramAnonymousMediaPlayer) });
          ad.e("MicroMsg.SpeexPlayer", "setCompletion File[" + l.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(130070);
        }
      }
    };
    this.hCP = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130071);
        ad.d("MicroMsg.SpeexPlayer", "onError");
        if ((l.this.cZO != null) && (l.this.hCL)) {
          l.this.cZO.XF();
        }
        if (l.this.hCT != null) {
          l.this.hCT.onError();
        }
        for (;;)
        {
          try
          {
            l.this.status = -1;
            l.this.aDv();
          }
          catch (Exception paramAnonymousMediaPlayer)
          {
            ad.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + l.this.fileName + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
            continue;
          }
          try
          {
            l.a(l.this);
            AppMethodBeat.o(130071);
            return false;
          }
          catch (InterruptedException paramAnonymousMediaPlayer)
          {
            ad.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bt.m(paramAnonymousMediaPlayer) });
          }
        }
      }
    };
    this.hCW = new com.tencent.qqpinyin.voicerecoapi.a();
    com.tencent.qqpinyin.voicerecoapi.a locala = this.hCW;
    if (locala.IpF != 0L) {
      i = -103;
    }
    for (;;)
    {
      if (i != 0) {
        ad.e("speex", "res: ".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(130073);
      return;
      long l = locala.IpG.nativeTRSpeexDecodeInit();
      if (l == -1L)
      {
        i = (int)l;
      }
      else
      {
        locala.IpF = l;
        locala.IpD = new byte[com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE * 15];
      }
    }
  }
  
  public l(Context paramContext)
  {
    this();
    AppMethodBeat.i(130074);
    this.cZO = new com.tencent.mm.compatible.util.b(paramContext);
    AppMethodBeat.o(130074);
  }
  
  private boolean W(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(130079);
    if (this.status != 0)
    {
      ad.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
      AppMethodBeat.o(130079);
      return false;
    }
    ad.i("MicroMsg.SpeexPlayer", "startPlay");
    this.status = 1;
    this.fileName = paramString;
    try
    {
      eG(paramBoolean);
      AppMethodBeat.o(130079);
      return true;
    }
    catch (Exception paramString)
    {
      try
      {
        eG(true);
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
        ad.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bt.m(paramString) });
        this.status = -1;
        AppMethodBeat.o(130079);
      }
    }
    return false;
  }
  
  private void aDw()
  {
    AppMethodBeat.i(130081);
    if (this.aUg != null) {}
    try
    {
      this.aUg.play();
      com.tencent.e.i.h local3 = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "SpeexPlayer_play";
        }
        
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 30
          //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: bipush 240
          //   7: invokestatic 41	android/os/Process:setThreadPriority	(I)V
          //   10: aload_0
          //   11: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   14: aload_0
          //   15: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   18: getfield 45	com/tencent/mm/modelvoice/l:fileName	Ljava/lang/String;
          //   21: invokestatic 51	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
          //   24: putfield 55	com/tencent/mm/modelvoice/l:hDc	Ljava/io/InputStream;
          //   27: aload_0
          //   28: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   31: getfield 59	com/tencent/mm/modelvoice/l:status	I
          //   34: iconst_1
          //   35: if_icmpeq +14 -> 49
          //   38: aload_0
          //   39: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   42: getfield 59	com/tencent/mm/modelvoice/l:status	I
          //   45: iconst_2
          //   46: if_icmpne +747 -> 793
          //   49: aload_0
          //   50: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   53: aload_0
          //   54: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   57: getfield 55	com/tencent/mm/modelvoice/l:hDc	Ljava/io/InputStream;
          //   60: aload_0
          //   61: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   64: getfield 63	com/tencent/mm/modelvoice/l:hDa	[B
          //   67: invokevirtual 69	java/io/InputStream:read	([B)I
          //   70: putfield 72	com/tencent/mm/modelvoice/l:hDb	I
          //   73: aload_0
          //   74: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   77: getfield 72	com/tencent/mm/modelvoice/l:hDb	I
          //   80: iconst_m1
          //   81: if_icmpeq +580 -> 661
          //   84: aload_0
          //   85: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   88: getfield 76	com/tencent/mm/modelvoice/l:hCW	Lcom/tencent/qqpinyin/voicerecoapi/a;
          //   91: astore 4
          //   93: aload_0
          //   94: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   97: getfield 63	com/tencent/mm/modelvoice/l:hDa	[B
          //   100: astore_3
          //   101: aload_0
          //   102: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   105: getfield 72	com/tencent/mm/modelvoice/l:hDb	I
          //   108: istore_1
          //   109: aload 4
          //   111: getfield 82	com/tencent/qqpinyin/voicerecoapi/a:IpF	J
          //   114: lconst_0
          //   115: lcmp
          //   116: ifne +201 -> 317
          //   119: new 84	com/tencent/qqpinyin/voicerecoapi/b
          //   122: dup
          //   123: bipush 154
          //   125: invokespecial 86	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
          //   128: astore_3
          //   129: ldc 30
          //   131: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   134: aload_3
          //   135: athrow
          //   136: astore_3
          //   137: ldc 91
          //   139: ldc 93
          //   141: iconst_1
          //   142: anewarray 4	java/lang/Object
          //   145: dup
          //   146: iconst_0
          //   147: aload_3
          //   148: invokestatic 99	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   151: aastore
          //   152: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   155: aload_0
          //   156: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   159: getfield 109	com/tencent/mm/modelvoice/l:hCP	Landroid/media/MediaPlayer$OnErrorListener;
          //   162: ifnull +19 -> 181
          //   165: aload_0
          //   166: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   169: getfield 109	com/tencent/mm/modelvoice/l:hCP	Landroid/media/MediaPlayer$OnErrorListener;
          //   172: aconst_null
          //   173: iconst_0
          //   174: iconst_0
          //   175: invokeinterface 115 4 0
          //   180: pop
          //   181: aload_0
          //   182: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   185: iconst_0
          //   186: putfield 59	com/tencent/mm/modelvoice/l:status	I
          //   189: aload_0
          //   190: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   193: getfield 55	com/tencent/mm/modelvoice/l:hDc	Ljava/io/InputStream;
          //   196: ifnull +21 -> 217
          //   199: aload_0
          //   200: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   203: getfield 55	com/tencent/mm/modelvoice/l:hDc	Ljava/io/InputStream;
          //   206: invokevirtual 118	java/io/InputStream:close	()V
          //   209: aload_0
          //   210: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   213: aconst_null
          //   214: putfield 55	com/tencent/mm/modelvoice/l:hDc	Ljava/io/InputStream;
          //   217: aload_0
          //   218: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   221: getfield 76	com/tencent/mm/modelvoice/l:hCW	Lcom/tencent/qqpinyin/voicerecoapi/a;
          //   224: astore_3
          //   225: aload_3
          //   226: getfield 82	com/tencent/qqpinyin/voicerecoapi/a:IpF	J
          //   229: lconst_0
          //   230: lcmp
          //   231: ifne +604 -> 835
          //   234: bipush 154
          //   236: istore_1
          //   237: aload_0
          //   238: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   241: getfield 59	com/tencent/mm/modelvoice/l:status	I
          //   244: iconst_3
          //   245: if_icmpeq +615 -> 860
          //   248: aload_0
          //   249: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   252: getfield 122	com/tencent/mm/modelvoice/l:hCS	Lcom/tencent/mm/modelvoice/d$a;
          //   255: ifnull +15 -> 270
          //   258: aload_0
          //   259: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   262: getfield 122	com/tencent/mm/modelvoice/l:hCS	Lcom/tencent/mm/modelvoice/d$a;
          //   265: invokeinterface 127 1 0
          //   270: aload_0
          //   271: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   274: getfield 131	com/tencent/mm/modelvoice/l:hCO	Landroid/media/MediaPlayer$OnCompletionListener;
          //   277: ifnull +16 -> 293
          //   280: aload_0
          //   281: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   284: getfield 131	com/tencent/mm/modelvoice/l:hCO	Landroid/media/MediaPlayer$OnCompletionListener;
          //   287: aconst_null
          //   288: invokeinterface 136 2 0
          //   293: iload_1
          //   294: ifeq +17 -> 311
          //   297: ldc 91
          //   299: ldc 138
          //   301: iload_1
          //   302: invokestatic 144	java/lang/String:valueOf	(I)Ljava/lang/String;
          //   305: invokevirtual 148	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   308: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   311: ldc 30
          //   313: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   316: return
          //   317: aload_3
          //   318: ifnull +8 -> 326
          //   321: aload_3
          //   322: arraylength
          //   323: ifne +20 -> 343
          //   326: new 84	com/tencent/qqpinyin/voicerecoapi/b
          //   329: dup
          //   330: bipush 152
          //   332: invokespecial 86	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
          //   335: astore_3
          //   336: ldc 30
          //   338: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   341: aload_3
          //   342: athrow
          //   343: aload 4
          //   345: getfield 155	com/tencent/qqpinyin/voicerecoapi/a:IpG	Lcom/tencent/qqpinyin/voicerecoapi/TRSpeexNative;
          //   348: aload 4
          //   350: getfield 82	com/tencent/qqpinyin/voicerecoapi/a:IpF	J
          //   353: aload_3
          //   354: iconst_0
          //   355: iload_1
          //   356: aload 4
          //   358: getfield 158	com/tencent/qqpinyin/voicerecoapi/a:IpD	[B
          //   361: invokevirtual 164	com/tencent/qqpinyin/voicerecoapi/TRSpeexNative:nativeTRSpeexDecode	(J[BII[B)I
          //   364: istore_1
          //   365: iload_1
          //   366: ifge +508 -> 874
          //   369: new 84	com/tencent/qqpinyin/voicerecoapi/b
          //   372: dup
          //   373: iload_1
          //   374: invokespecial 86	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
          //   377: astore_3
          //   378: ldc 30
          //   380: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   383: aload_3
          //   384: athrow
          //   385: aload_0
          //   386: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   389: iconst_0
          //   390: putfield 59	com/tencent/mm/modelvoice/l:status	I
          //   393: goto -366 -> 27
          //   396: iload_1
          //   397: newarray byte
          //   399: astore_3
          //   400: aload 4
          //   402: getfield 158	com/tencent/qqpinyin/voicerecoapi/a:IpD	[B
          //   405: iconst_0
          //   406: aload_3
          //   407: iconst_0
          //   408: iload_1
          //   409: invokestatic 170	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
          //   412: goto +468 -> 880
          //   415: iconst_0
          //   416: istore_2
          //   417: aload_3
          //   418: arraylength
          //   419: istore_1
          //   420: iload_1
          //   421: aload_0
          //   422: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   425: getfield 173	com/tencent/mm/modelvoice/l:hDd	I
          //   428: if_icmplt +96 -> 524
          //   431: aload_0
          //   432: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   435: getfield 59	com/tencent/mm/modelvoice/l:status	I
          //   438: iconst_1
          //   439: if_icmpne +85 -> 524
          //   442: aload_0
          //   443: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   446: getfield 177	com/tencent/mm/modelvoice/l:hCZ	Z
          //   449: ifeq +12 -> 461
          //   452: ldc2_w 178
          //   455: invokestatic 185	java/lang/Thread:sleep	(J)V
          //   458: goto -38 -> 420
          //   461: aload_0
          //   462: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   465: getfield 189	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
          //   468: ifnull -48 -> 420
          //   471: aload_0
          //   472: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   475: getfield 177	com/tencent/mm/modelvoice/l:hCZ	Z
          //   478: ifne -58 -> 420
          //   481: aload_0
          //   482: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   485: getfield 189	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
          //   488: aload_3
          //   489: iload_2
          //   490: aload_0
          //   491: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   494: getfield 173	com/tencent/mm/modelvoice/l:hDd	I
          //   497: invokevirtual 195	android/media/AudioTrack:write	([BII)I
          //   500: pop
          //   501: iload_2
          //   502: aload_0
          //   503: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   506: getfield 173	com/tencent/mm/modelvoice/l:hDd	I
          //   509: iadd
          //   510: istore_2
          //   511: iload_1
          //   512: aload_0
          //   513: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   516: getfield 173	com/tencent/mm/modelvoice/l:hDd	I
          //   519: isub
          //   520: istore_1
          //   521: goto -101 -> 420
          //   524: iload_1
          //   525: aload_0
          //   526: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   529: getfield 173	com/tencent/mm/modelvoice/l:hDd	I
          //   532: if_icmpge +31 -> 563
          //   535: iload_1
          //   536: ifle +27 -> 563
          //   539: aload_0
          //   540: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   543: getfield 189	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
          //   546: ifnull +17 -> 563
          //   549: aload_0
          //   550: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   553: getfield 189	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
          //   556: aload_3
          //   557: iload_2
          //   558: iload_1
          //   559: invokevirtual 195	android/media/AudioTrack:write	([BII)I
          //   562: pop
          //   563: aload_0
          //   564: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   567: getfield 59	com/tencent/mm/modelvoice/l:status	I
          //   570: iconst_2
          //   571: if_icmpne +161 -> 732
          //   574: aload_0
          //   575: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   578: getfield 198	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
          //   581: astore_3
          //   582: aload_3
          //   583: monitorenter
          //   584: ldc 91
          //   586: ldc 200
          //   588: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
          //   591: aload_0
          //   592: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   595: getfield 198	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
          //   598: invokevirtual 206	java/lang/Object:notify	()V
          //   601: ldc 91
          //   603: ldc 208
          //   605: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
          //   608: aload_3
          //   609: monitorexit
          //   610: aload_0
          //   611: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   614: getfield 211	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
          //   617: astore_3
          //   618: aload_3
          //   619: monitorenter
          //   620: ldc 91
          //   622: ldc 213
          //   624: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
          //   627: aload_0
          //   628: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   631: getfield 211	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
          //   634: invokevirtual 216	java/lang/Object:wait	()V
          //   637: ldc 91
          //   639: ldc 218
          //   641: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
          //   644: aload_3
          //   645: monitorexit
          //   646: goto -619 -> 27
          //   649: astore 4
          //   651: aload_3
          //   652: monitorexit
          //   653: ldc 30
          //   655: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   658: aload 4
          //   660: athrow
          //   661: aload_0
          //   662: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   665: iconst_0
          //   666: putfield 59	com/tencent/mm/modelvoice/l:status	I
          //   669: goto -106 -> 563
          //   672: astore 4
          //   674: ldc 91
          //   676: ldc 93
          //   678: iconst_1
          //   679: anewarray 4	java/lang/Object
          //   682: dup
          //   683: iconst_0
          //   684: aload 4
          //   686: invokestatic 99	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   689: aastore
          //   690: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   693: goto -85 -> 608
          //   696: astore 4
          //   698: aload_3
          //   699: monitorexit
          //   700: ldc 30
          //   702: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   705: aload 4
          //   707: athrow
          //   708: astore 4
          //   710: ldc 91
          //   712: ldc 93
          //   714: iconst_1
          //   715: anewarray 4	java/lang/Object
          //   718: dup
          //   719: iconst_0
          //   720: aload 4
          //   722: invokestatic 99	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   725: aastore
          //   726: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   729: goto -85 -> 644
          //   732: aload_0
          //   733: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   736: getfield 198	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
          //   739: astore_3
          //   740: aload_3
          //   741: monitorenter
          //   742: aload_0
          //   743: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   746: getfield 198	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
          //   749: invokevirtual 206	java/lang/Object:notify	()V
          //   752: aload_3
          //   753: monitorexit
          //   754: goto -727 -> 27
          //   757: astore 4
          //   759: aload_3
          //   760: monitorexit
          //   761: ldc 30
          //   763: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   766: aload 4
          //   768: athrow
          //   769: astore 4
          //   771: ldc 91
          //   773: ldc 93
          //   775: iconst_1
          //   776: anewarray 4	java/lang/Object
          //   779: dup
          //   780: iconst_0
          //   781: aload 4
          //   783: invokestatic 99	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   786: aastore
          //   787: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   790: goto -38 -> 752
          //   793: aload_0
          //   794: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   797: getfield 59	com/tencent/mm/modelvoice/l:status	I
          //   800: iconst_3
          //   801: if_icmpeq -612 -> 189
          //   804: ldc2_w 219
          //   807: invokestatic 185	java/lang/Thread:sleep	(J)V
          //   810: goto -621 -> 189
          //   813: astore_3
          //   814: ldc 91
          //   816: ldc 93
          //   818: iconst_1
          //   819: anewarray 4	java/lang/Object
          //   822: dup
          //   823: iconst_0
          //   824: aload_3
          //   825: invokestatic 99	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   828: aastore
          //   829: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   832: goto -623 -> 209
          //   835: aload_3
          //   836: aconst_null
          //   837: putfield 158	com/tencent/qqpinyin/voicerecoapi/a:IpD	[B
          //   840: aload_3
          //   841: getfield 155	com/tencent/qqpinyin/voicerecoapi/a:IpG	Lcom/tencent/qqpinyin/voicerecoapi/TRSpeexNative;
          //   844: aload_3
          //   845: getfield 82	com/tencent/qqpinyin/voicerecoapi/a:IpF	J
          //   848: invokevirtual 224	com/tencent/qqpinyin/voicerecoapi/TRSpeexNative:nativeTRSpeexDecodeRelease	(J)I
          //   851: istore_1
          //   852: aload_3
          //   853: lconst_0
          //   854: putfield 82	com/tencent/qqpinyin/voicerecoapi/a:IpF	J
          //   857: goto -620 -> 237
          //   860: aload_0
          //   861: getfield 17	com/tencent/mm/modelvoice/l$3:hDe	Lcom/tencent/mm/modelvoice/l;
          //   864: invokevirtual 227	com/tencent/mm/modelvoice/l:aDv	()V
          //   867: goto -574 -> 293
          //   870: astore_3
          //   871: goto -578 -> 293
          //   874: iload_1
          //   875: ifne -479 -> 396
          //   878: aconst_null
          //   879: astore_3
          //   880: aload_3
          //   881: ifnull -496 -> 385
          //   884: iload_1
          //   885: ifne -470 -> 415
          //   888: goto -503 -> 385
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	891	0	this	3
          //   108	777	1	i	int
          //   416	142	2	j	int
          //   100	35	3	localObject1	Object
          //   136	12	3	localException1	Exception
          //   813	40	3	localIOException	java.io.IOException
          //   870	1	3	localException2	Exception
          //   879	2	3	localObject3	Object
          //   91	310	4	locala	com.tencent.qqpinyin.voicerecoapi.a
          //   649	10	4	localObject4	Object
          //   672	13	4	localException3	Exception
          //   696	10	4	localObject5	Object
          //   708	13	4	localException4	Exception
          //   757	10	4	localObject6	Object
          //   769	13	4	localException5	Exception
          // Exception table:
          //   from	to	target	type
          //   5	27	136	java/lang/Exception
          //   27	49	136	java/lang/Exception
          //   49	136	136	java/lang/Exception
          //   321	326	136	java/lang/Exception
          //   326	343	136	java/lang/Exception
          //   343	365	136	java/lang/Exception
          //   369	385	136	java/lang/Exception
          //   385	393	136	java/lang/Exception
          //   396	412	136	java/lang/Exception
          //   417	420	136	java/lang/Exception
          //   420	458	136	java/lang/Exception
          //   461	521	136	java/lang/Exception
          //   524	535	136	java/lang/Exception
          //   539	563	136	java/lang/Exception
          //   563	584	136	java/lang/Exception
          //   610	620	136	java/lang/Exception
          //   653	661	136	java/lang/Exception
          //   661	669	136	java/lang/Exception
          //   700	708	136	java/lang/Exception
          //   732	742	136	java/lang/Exception
          //   761	769	136	java/lang/Exception
          //   793	810	136	java/lang/Exception
          //   620	644	649	finally
          //   644	646	649	finally
          //   651	653	649	finally
          //   710	729	649	finally
          //   584	608	672	java/lang/Exception
          //   584	608	696	finally
          //   608	610	696	finally
          //   674	693	696	finally
          //   698	700	696	finally
          //   620	644	708	java/lang/Exception
          //   742	752	757	finally
          //   752	754	757	finally
          //   759	761	757	finally
          //   771	790	757	finally
          //   742	752	769	java/lang/Exception
          //   199	209	813	java/io/IOException
          //   860	867	870	java/lang/Exception
        }
      };
      this.cVv = com.tencent.e.h.Iye.aP(local3);
      AppMethodBeat.o(130081);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(130081);
    }
  }
  
  private void eG(boolean paramBoolean)
  {
    int j = 3;
    AppMethodBeat.i(130080);
    if (!com.tencent.mm.vfs.i.eK(this.fileName))
    {
      AppMethodBeat.o(130080);
      return;
    }
    int i;
    if (paramBoolean) {
      i = 3;
    }
    for (;;)
    {
      try
      {
        if ((com.tencent.mm.plugin.audio.c.a.bvB().bvw()) || (com.tencent.mm.plugin.audio.c.a.bvE())) {
          break label268;
        }
        if (!ae.fFx.fzm) {
          break label265;
        }
        ae.fFx.dump();
        if (ae.fFx.fzt != 1) {
          break label265;
        }
        i = j;
        this.hCX = AudioTrack.getMinBufferSize(this.nSamplerate, this.hCU, 2);
        aDv();
        this.aUg = new e(i, this.nSamplerate, this.hCU, this.hCX * 8);
        this.hDd = (this.nSamplerate / 1000 * this.channel * this.hCV * 2);
        if ((this.cZO != null) && (this.hCL)) {
          this.cZO.requestFocus();
        }
        aDw();
        AppMethodBeat.o(130080);
        return;
      }
      catch (Exception localException)
      {
        if ((this.cZO == null) || (!this.hCL)) {
          continue;
        }
        this.cZO.XF();
        aDv();
        ad.e("MicroMsg.SpeexPlayer", "playImp : fail, exception = " + localException.getMessage());
        ad.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[] { bt.m(localException) });
        AppMethodBeat.o(130080);
        return;
      }
      i = 0;
      continue;
      label265:
      continue;
      label268:
      i = 3;
    }
  }
  
  /* Error */
  public final boolean Ft()
  {
    // Byte code:
    //   0: ldc_w 328
    //   3: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 171
    //   8: new 173	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 330
    //   15: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 70	com/tencent/mm/modelvoice/l:status	I
    //   22: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 136	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 70	com/tencent/mm/modelvoice/l:status	I
    //   35: iconst_1
    //   36: if_icmpeq +107 -> 143
    //   39: aload_0
    //   40: getfield 70	com/tencent/mm/modelvoice/l:status	I
    //   43: iconst_2
    //   44: if_icmpeq +99 -> 143
    //   47: ldc 171
    //   49: new 173	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 332
    //   56: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 70	com/tencent/mm/modelvoice/l:status	I
    //   63: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 136	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield 86	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
    //   76: astore_1
    //   77: aload_1
    //   78: monitorenter
    //   79: aload_0
    //   80: getfield 86	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
    //   83: invokevirtual 335	java/lang/Object:notify	()V
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_0
    //   89: getfield 88	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
    //   92: astore_1
    //   93: aload_1
    //   94: monitorenter
    //   95: aload_0
    //   96: getfield 88	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
    //   99: invokevirtual 335	java/lang/Object:notify	()V
    //   102: aload_1
    //   103: monitorexit
    //   104: aload_0
    //   105: iconst_3
    //   106: putfield 70	com/tencent/mm/modelvoice/l:status	I
    //   109: ldc_w 328
    //   112: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_2
    //   118: aload_1
    //   119: monitorexit
    //   120: ldc_w 328
    //   123: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_2
    //   127: athrow
    //   128: astore_1
    //   129: goto -25 -> 104
    //   132: astore_2
    //   133: aload_1
    //   134: monitorexit
    //   135: ldc_w 328
    //   138: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_2
    //   142: athrow
    //   143: aload_0
    //   144: iconst_3
    //   145: putfield 70	com/tencent/mm/modelvoice/l:status	I
    //   148: aload_0
    //   149: getfield 86	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
    //   152: astore_1
    //   153: aload_1
    //   154: monitorenter
    //   155: aload_0
    //   156: getfield 86	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
    //   159: invokevirtual 335	java/lang/Object:notify	()V
    //   162: aload_0
    //   163: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   166: ifnull +18 -> 184
    //   169: aload_0
    //   170: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   173: ifeq +11 -> 184
    //   176: aload_0
    //   177: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   180: invokevirtual 324	com/tencent/mm/compatible/util/b:XF	()Z
    //   183: pop
    //   184: aload_1
    //   185: monitorexit
    //   186: ldc_w 328
    //   189: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: iconst_1
    //   193: ireturn
    //   194: astore_2
    //   195: ldc 171
    //   197: ldc 203
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_2
    //   206: invokestatic 209	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   209: aastore
    //   210: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload_0
    //   214: invokevirtual 311	com/tencent/mm/modelvoice/l:aDv	()V
    //   217: aload_0
    //   218: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   221: ifnull +18 -> 239
    //   224: aload_0
    //   225: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   228: ifeq +11 -> 239
    //   231: aload_0
    //   232: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   235: invokevirtual 324	com/tencent/mm/compatible/util/b:XF	()Z
    //   238: pop
    //   239: aload_1
    //   240: monitorexit
    //   241: ldc_w 328
    //   244: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_2
    //   250: aload_0
    //   251: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   254: ifnull +18 -> 272
    //   257: aload_0
    //   258: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   261: ifeq +11 -> 272
    //   264: aload_0
    //   265: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   268: invokevirtual 324	com/tencent/mm/compatible/util/b:XF	()Z
    //   271: pop
    //   272: ldc_w 328
    //   275: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_2
    //   279: athrow
    //   280: astore_2
    //   281: aload_1
    //   282: monitorexit
    //   283: ldc_w 328
    //   286: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final double Oa()
  {
    return 0.0D;
  }
  
  public final void a(d.a parama)
  {
    this.hCS = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.hCT = paramb;
  }
  
  public final void aDn()
  {
    this.hCL = false;
  }
  
  final void aDv()
  {
    AppMethodBeat.i(130075);
    if (this.aUg != null)
    {
      this.aUg.stop();
      this.aUg.release();
      this.aUg = null;
    }
    AppMethodBeat.o(130075);
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(130085);
    if ((parama != null) && (this.cZO != null)) {
      this.cZO.a(parama);
    }
    AppMethodBeat.o(130085);
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130078);
    paramBoolean = W(paramString, paramBoolean);
    AppMethodBeat.o(130078);
    return paramBoolean;
  }
  
  /* Error */
  public final void cj(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 359
    //   3: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield 84	com/tencent/mm/modelvoice/l:hCZ	Z
    //   11: aload_0
    //   12: getfield 76	com/tencent/mm/modelvoice/l:channel	I
    //   15: iconst_2
    //   16: if_icmpne +133 -> 149
    //   19: aload_0
    //   20: iconst_3
    //   21: putfield 72	com/tencent/mm/modelvoice/l:hCU	I
    //   24: aload_0
    //   25: aload_0
    //   26: getfield 74	com/tencent/mm/modelvoice/l:nSamplerate	I
    //   29: aload_0
    //   30: getfield 72	com/tencent/mm/modelvoice/l:hCU	I
    //   33: iconst_2
    //   34: invokestatic 306	android/media/AudioTrack:getMinBufferSize	(III)I
    //   37: putfield 308	com/tencent/mm/modelvoice/l:hCX	I
    //   40: aload_0
    //   41: getfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   44: ifnull +22 -> 66
    //   47: aload_0
    //   48: getfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   51: invokevirtual 344	android/media/AudioTrack:stop	()V
    //   54: aload_0
    //   55: getfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   58: invokevirtual 347	android/media/AudioTrack:release	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   66: iload_1
    //   67: ifeq +126 -> 193
    //   70: iconst_3
    //   71: istore_2
    //   72: iload_2
    //   73: istore_3
    //   74: getstatic 291	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   77: getfield 296	com/tencent/mm/compatible/deviceinfo/b:fzm	Z
    //   80: ifeq +23 -> 103
    //   83: getstatic 291	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   86: invokevirtual 299	com/tencent/mm/compatible/deviceinfo/b:dump	()V
    //   89: iload_2
    //   90: istore_3
    //   91: getstatic 291	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   94: getfield 302	com/tencent/mm/compatible/deviceinfo/b:fzt	I
    //   97: iconst_1
    //   98: if_icmpne +5 -> 103
    //   101: iconst_3
    //   102: istore_3
    //   103: aload_0
    //   104: new 313	com/tencent/mm/compatible/b/e
    //   107: dup
    //   108: iload_3
    //   109: aload_0
    //   110: getfield 74	com/tencent/mm/modelvoice/l:nSamplerate	I
    //   113: aload_0
    //   114: getfield 72	com/tencent/mm/modelvoice/l:hCU	I
    //   117: aload_0
    //   118: getfield 308	com/tencent/mm/modelvoice/l:hCX	I
    //   121: bipush 8
    //   123: imul
    //   124: invokespecial 316	com/tencent/mm/compatible/b/e:<init>	(IIII)V
    //   127: putfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   130: aload_0
    //   131: getfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   134: invokevirtual 245	android/media/AudioTrack:play	()V
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 84	com/tencent/mm/modelvoice/l:hCZ	Z
    //   142: ldc_w 359
    //   145: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: aload_0
    //   150: iconst_2
    //   151: putfield 72	com/tencent/mm/modelvoice/l:hCU	I
    //   154: goto -130 -> 24
    //   157: astore 4
    //   159: ldc 171
    //   161: aload 4
    //   163: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: invokestatic 136	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   174: goto -108 -> 66
    //   177: astore 4
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 240	com/tencent/mm/modelvoice/l:aUg	Landroid/media/AudioTrack;
    //   184: ldc_w 359
    //   187: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload 4
    //   192: athrow
    //   193: iconst_0
    //   194: istore_2
    //   195: goto -123 -> 72
    //   198: astore 4
    //   200: ldc 171
    //   202: ldc_w 260
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 4
    //   213: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   216: aastore
    //   217: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: goto -83 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	l
    //   0	223	1	paramBoolean	boolean
    //   71	124	2	i	int
    //   73	36	3	j	int
    //   157	5	4	localException1	Exception
    //   177	14	4	localObject	Object
    //   198	14	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   47	61	157	java/lang/Exception
    //   47	61	177	finally
    //   159	169	177	finally
    //   130	137	198	java/lang/Exception
  }
  
  /* Error */
  public final boolean cp(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 362
    //   3: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 70	com/tencent/mm/modelvoice/l:status	I
    //   10: iconst_1
    //   11: if_icmpeq +11 -> 22
    //   14: ldc_w 362
    //   17: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: iconst_2
    //   24: putfield 70	com/tencent/mm/modelvoice/l:status	I
    //   27: aload_0
    //   28: getfield 88	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
    //   31: astore 4
    //   33: aload 4
    //   35: monitorenter
    //   36: ldc 171
    //   38: ldc_w 364
    //   41: invokestatic 367	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   47: lstore_2
    //   48: aload_0
    //   49: getfield 88	com/tencent/mm/modelvoice/l:hCC	Ljava/lang/String;
    //   52: invokevirtual 375	java/lang/Object:wait	()V
    //   55: ldc 171
    //   57: new 173	java/lang/StringBuilder
    //   60: dup
    //   61: ldc_w 377
    //   64: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: invokestatic 372	java/lang/System:currentTimeMillis	()J
    //   70: lload_2
    //   71: lsub
    //   72: invokevirtual 380	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 367	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   85: ifnull +22 -> 107
    //   88: iload_1
    //   89: ifeq +18 -> 107
    //   92: aload_0
    //   93: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   96: ifeq +11 -> 107
    //   99: aload_0
    //   100: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   103: invokevirtual 324	com/tencent/mm/compatible/util/b:XF	()Z
    //   106: pop
    //   107: aload 4
    //   109: monitorexit
    //   110: ldc_w 362
    //   113: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: iconst_1
    //   117: ireturn
    //   118: astore 5
    //   120: ldc 171
    //   122: ldc 203
    //   124: iconst_1
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload 5
    //   132: invokestatic 209	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_0
    //   140: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   143: ifnull +22 -> 165
    //   146: iload_1
    //   147: ifeq +18 -> 165
    //   150: aload_0
    //   151: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   154: ifeq +11 -> 165
    //   157: aload_0
    //   158: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   161: invokevirtual 324	com/tencent/mm/compatible/util/b:XF	()Z
    //   164: pop
    //   165: aload 4
    //   167: monitorexit
    //   168: ldc_w 362
    //   171: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore 5
    //   178: aload_0
    //   179: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   182: ifnull +22 -> 204
    //   185: iload_1
    //   186: ifeq +18 -> 204
    //   189: aload_0
    //   190: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   193: ifeq +11 -> 204
    //   196: aload_0
    //   197: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   200: invokevirtual 324	com/tencent/mm/compatible/util/b:XF	()Z
    //   203: pop
    //   204: ldc_w 362
    //   207: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload 5
    //   212: athrow
    //   213: astore 5
    //   215: aload 4
    //   217: monitorexit
    //   218: ldc_w 362
    //   221: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final boolean isPlaying()
  {
    return this.status == 1;
  }
  
  /* Error */
  public final boolean resume()
  {
    // Byte code:
    //   0: ldc_w 385
    //   3: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 70	com/tencent/mm/modelvoice/l:status	I
    //   10: iconst_2
    //   11: if_icmpeq +11 -> 22
    //   14: ldc_w 385
    //   17: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 70	com/tencent/mm/modelvoice/l:status	I
    //   27: aload_0
    //   28: getfield 86	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: ldc 171
    //   36: ldc_w 387
    //   39: invokestatic 367	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 86	com/tencent/mm/modelvoice/l:hCB	Ljava/lang/String;
    //   46: invokevirtual 335	java/lang/Object:notify	()V
    //   49: ldc 171
    //   51: ldc_w 389
    //   54: invokestatic 367	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   61: ifnull +18 -> 79
    //   64: aload_0
    //   65: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   68: ifeq +11 -> 79
    //   71: aload_0
    //   72: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   75: invokevirtual 319	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   78: pop
    //   79: aload_1
    //   80: monitorexit
    //   81: ldc_w 385
    //   84: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_1
    //   88: ireturn
    //   89: astore_2
    //   90: ldc 171
    //   92: ldc 203
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_2
    //   101: invokestatic 209	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   112: ifnull +18 -> 130
    //   115: aload_0
    //   116: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   119: ifeq +11 -> 130
    //   122: aload_0
    //   123: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   126: invokevirtual 319	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   129: pop
    //   130: aload_1
    //   131: monitorexit
    //   132: ldc_w 385
    //   135: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_2
    //   141: aload_0
    //   142: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   145: ifnull +18 -> 163
    //   148: aload_0
    //   149: getfield 90	com/tencent/mm/modelvoice/l:hCL	Z
    //   152: ifeq +11 -> 163
    //   155: aload_0
    //   156: getfield 164	com/tencent/mm/modelvoice/l:cZO	Lcom/tencent/mm/compatible/util/b;
    //   159: invokevirtual 319	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   162: pop
    //   163: ldc_w 385
    //   166: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: ldc_w 385
    //   177: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.l
 * JD-Core Version:    0.7.0.1
 */