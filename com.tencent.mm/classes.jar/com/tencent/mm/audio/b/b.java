package com.tencent.mm.audio.b;

import android.media.MediaRecorder;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bf.d.a;
import com.tencent.mm.bf.d.b;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.y;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public final class b
{
  private static Object ciN;
  private boolean bCp;
  private int ciC;
  private String ciD;
  private int ciE;
  private final Object ciF;
  private com.tencent.mm.audio.e.c ciG;
  private b.a ciH;
  private com.tencent.mm.bf.c ciI;
  private d.a ciJ;
  private long ciK;
  private long ciL;
  private int ciM;
  private int ciO;
  private boolean ciP;
  public MediaRecorder ciQ;
  public c ciR;
  public com.tencent.mm.compatible.b.c.a ciS;
  public b.b ciT;
  private volatile boolean ciU;
  private com.tencent.mm.compatible.util.g.a ciV;
  private int ciW;
  private int ciX;
  private c.a ciY;
  private int mSampleRate;
  private long oFw;
  
  static
  {
    AppMethodBeat.i(116494);
    ciN = new Object();
    AppMethodBeat.o(116494);
  }
  
  public b(com.tencent.mm.compatible.b.c.a parama)
  {
    AppMethodBeat.i(116481);
    this.ciC = 0;
    this.ciD = null;
    this.ciF = new Object();
    this.ciG = null;
    this.ciI = null;
    this.ciJ = null;
    this.ciK = 0L;
    this.ciL = 0L;
    this.ciM = 0;
    this.mSampleRate = 8000;
    this.ciO = 16000;
    this.ciP = false;
    this.ciR = null;
    this.ciU = false;
    this.oFw = -1L;
    this.ciV = new com.tencent.mm.compatible.util.g.a();
    this.ciW = 0;
    this.ciX = 0;
    this.ciY = new c.a()
    {
      private static byte[] t(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = paramAnonymousInt % 4;
        int i = paramAnonymousInt;
        if (j != 0) {
          i = paramAnonymousInt - j;
        }
        if (i <= 0) {
          return null;
        }
        byte[] arrayOfByte = new byte[i / 2];
        paramAnonymousInt = 0;
        while (paramAnonymousInt < i / 2)
        {
          arrayOfByte[paramAnonymousInt] = paramAnonymousArrayOfByte[(paramAnonymousInt * 2)];
          arrayOfByte[(paramAnonymousInt + 1)] = paramAnonymousArrayOfByte[(paramAnonymousInt * 2 + 1)];
          paramAnonymousInt += 2;
        }
        return arrayOfByte;
      }
      
      private void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(116477);
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          int j = (short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8);
          if (j > b.u(b.this)) {
            b.b(b.this, j);
          }
          i += 1;
        }
        AppMethodBeat.o(116477);
      }
      
      public final void bS(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void s(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(116476);
        ab.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", new Object[] { Boolean.valueOf(b.c(b.this)) });
        if ((b.d(b.this) == b.b.cjf) && (!b.c(b.this)))
        {
          ab.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
          AppMethodBeat.o(116476);
          return;
        }
        boolean bool1 = false;
        boolean bool2 = false;
        synchronized (b.EA())
        {
          if (b.c(b.this))
          {
            if (b.e(b.this) != null)
            {
              ab.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt) });
              b.e(b.this).Et();
              b.e(b.this).cjD = null;
              b.f(b.this);
              bool1 = true;
              b.g(b.this);
            }
          }
          else
          {
            long l = bo.hl(b.h(b.this));
            if ((b.i(b.this) <= 0L) || (l <= b.i(b.this))) {
              break label270;
            }
            ab.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:".concat(String.valueOf(l)));
            new ak(Looper.getMainLooper()).post(new b.2.1(this));
            AppMethodBeat.o(116476);
            return;
          }
          ab.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
          bool1 = bool2;
        }
        label270:
        ab.d("MicroMsg.MMAudioRecorder", "read :" + paramAnonymousInt + " time: " + b.j(b.this).Mm() + " dataReadedCnt: " + b.k(b.this));
        if (paramAnonymousInt < 0)
        {
          if (b.d(b.this) == b.b.cjf)
          {
            ab.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
            AppMethodBeat.o(116476);
            return;
          }
          new ak(Looper.getMainLooper()).post(new b.2.2(this));
          AppMethodBeat.o(116476);
          return;
        }
        ab.d("MicroMsg.MMAudioRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        ??? = new qe();
        ((qe)???).cGK.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        ((qe)???).cGK.len = paramAnonymousInt;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)???);
        b.a(b.this, b.k(b.this) + paramAnonymousInt);
        for (;;)
        {
          Object localObject2;
          int j;
          synchronized (b.l(b.this))
          {
            if ((b.m(b.this) == null) && ((b.n(b.this) == com.tencent.mm.compatible.b.c.a.elO) || (b.n(b.this) == com.tencent.mm.compatible.b.c.a.elQ)) && (b.o(b.this) != null) && (b.p(b.this)))
            {
              b.a(b.this, new com.tencent.mm.bf.c());
              localObject2 = b.m(b.this);
              i = b.q(b.this);
              ab.i("MicroMsg.SpeexEncoderWorker", "init ");
              ((com.tencent.mm.bf.c)localObject2).fQV.clear();
              d.b localb = new d.b();
              localb.fOn = com.tencent.mm.bf.d.getPrefix();
              localb.sampleRate = i;
              localb.fQR = 1;
              localb.audioFormat = 16;
              ((com.tencent.mm.bf.c)localObject2).mFileName = String.format("%s%d_%d_%d_%d", new Object[] { localb.fOn, Integer.valueOf(localb.sampleRate), Integer.valueOf(localb.fQR), Integer.valueOf(localb.audioFormat), Long.valueOf(System.currentTimeMillis()) });
            }
            if (b.m(b.this) != null)
            {
              localObject2 = b.m(b.this);
              ab.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + ((com.tencent.mm.bf.c)localObject2).fQV.size());
              if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
                ((com.tencent.mm.bf.c)localObject2).fQV.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length));
              }
            }
            if (b.n(b.this) != com.tencent.mm.compatible.b.c.a.elQ) {
              break;
            }
            if (b.r(b.this) == null)
            {
              b.a(b.this, new com.tencent.mm.audio.e.c(b.q(b.this), b.s(b.this)));
              b.r(b.this).eN(b.t(b.this));
            }
            u(paramAnonymousArrayOfByte, paramAnonymousInt);
            localObject2 = b.r(b.this);
            if (((com.tencent.mm.audio.e.c)localObject2).clz == null)
            {
              i = -1;
              if (paramAnonymousArrayOfByte != null) {
                break label962;
              }
              j = -1;
              label869:
              ab.d("MicroMsg.SilkWriter", "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
              if (paramAnonymousInt <= 0) {}
            }
          }
          try
          {
            if (((com.tencent.mm.audio.e.c)localObject2).clA) {
              ab.e("MicroMsg.SilkWriter", "already stop");
            }
            for (;;)
            {
              return;
              i = ((com.tencent.mm.audio.e.c)localObject2).clz.size();
              break;
              label962:
              j = paramAnonymousArrayOfByte.length;
              break label869;
              if (((com.tencent.mm.audio.e.c)localObject2).clG == null)
              {
                ((com.tencent.mm.audio.e.c)localObject2).clG = new com.tencent.mm.audio.e.c.a((com.tencent.mm.audio.e.c)localObject2, (byte)0);
                com.tencent.mm.sdk.g.d.post(((com.tencent.mm.audio.e.c)localObject2).clG, "SilkWriter_run");
              }
              if (((com.tencent.mm.audio.e.c)localObject2).clz != null) {
                ((com.tencent.mm.audio.e.c)localObject2).clz.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt, bool1));
              }
            }
            paramAnonymousArrayOfByte = finally;
            throw paramAnonymousArrayOfByte;
          }
          finally
          {
            AppMethodBeat.o(116476);
          }
        }
        ??? = paramAnonymousArrayOfByte;
        int i = paramAnonymousInt;
        if (b.q(b.this) == 16000)
        {
          ??? = t(paramAnonymousArrayOfByte, paramAnonymousInt);
          i = ???.length;
        }
        u((byte[])???, i);
        AppMethodBeat.o(116476);
      }
    };
    this.bCp = false;
    ab.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: ".concat(String.valueOf(parama)));
    this.ciS = parama;
    if (!g.b.EJ())
    {
      ab.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
      this.ciS = com.tencent.mm.compatible.b.c.a.elP;
    }
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      this.ciE = 7;
      this.ciQ = new MediaRecorder();
    }
    for (;;)
    {
      this.oFw = -1L;
      this.ciU = false;
      AppMethodBeat.o(116481);
      return;
      Ey();
      this.ciE = 1;
    }
  }
  
  public final void Ev()
  {
    AppMethodBeat.i(116485);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ != null) {
        this.ciQ.setAudioEncoder(1);
      }
      AppMethodBeat.o(116485);
      return;
    }
    AppMethodBeat.o(116485);
  }
  
  public final void Ew()
  {
    AppMethodBeat.i(116486);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ == null)
      {
        AppMethodBeat.o(116486);
        return;
      }
      this.ciQ.setAudioSource(1);
      AppMethodBeat.o(116486);
      return;
    }
    AppMethodBeat.o(116486);
  }
  
  public final void Ex()
  {
    AppMethodBeat.i(116487);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ == null)
      {
        AppMethodBeat.o(116487);
        return;
      }
      this.ciQ.setOutputFormat(3);
      AppMethodBeat.o(116487);
      return;
    }
    AppMethodBeat.o(116487);
  }
  
  public final void Ey()
  {
    AppMethodBeat.i(116489);
    this.ciJ = d.a.akr();
    if (this.ciJ != null) {
      this.ciP = this.ciJ.akq();
    }
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elQ)
    {
      ??? = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("VoiceSamplingRate");
      this.mSampleRate = bo.getInt((String)???, 16000);
      String str = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("VoiceRate");
      this.ciO = bo.getInt(str, 16000);
      ab.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", new Object[] { ???, Integer.valueOf(this.mSampleRate), str, Integer.valueOf(this.ciO) });
    }
    for (;;)
    {
      this.ciC = 0;
      this.ciD = null;
      synchronized (this.ciF)
      {
        this.ciI = null;
        this.ciG = null;
        this.ciM = 0;
      }
      try
      {
        synchronized (ciN)
        {
          this.ciR = new c(this.mSampleRate, 1, 0);
          this.ciR.bz(true);
          this.ciR.gA(120);
          this.ciR.cjD = this.ciY;
          this.ciT = b.b.cjb;
          AppMethodBeat.o(116489);
          return;
          if (this.ciP) {}
          for (this.mSampleRate = 16000;; this.mSampleRate = 8000)
          {
            g.RM();
            int i = bo.a((Integer)g.RL().eHM.get(27), 0);
            ab.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + i);
            if (i != 1) {
              break;
            }
            this.mSampleRate = 8000;
            break;
          }
          localObject2 = finally;
          AppMethodBeat.o(116489);
          throw localObject2;
        }
        ab.e("MicroMsg.MMAudioRecorder", localException.getMessage());
      }
      catch (Exception localException)
      {
        if (localException.getMessage() == null) {}
      }
    }
    for (;;)
    {
      this.ciT = b.b.cje;
      AppMethodBeat.o(116489);
      return;
      ab.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
    }
  }
  
  /* Error */
  public final boolean Ez()
  {
    // Byte code:
    //   0: ldc_w 348
    //   3: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 140	com/tencent/mm/audio/b/b:ciS	Lcom/tencent/mm/compatible/b/c$a;
    //   10: getstatic 153	com/tencent/mm/compatible/b/c$a:elP	Lcom/tencent/mm/compatible/b/c$a;
    //   13: if_acmpne +56 -> 69
    //   16: ldc 121
    //   18: ldc_w 350
    //   21: iconst_1
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_0
    //   28: getfield 160	com/tencent/mm/audio/b/b:ciQ	Landroid/media/MediaRecorder;
    //   31: aastore
    //   32: invokestatic 273	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield 160	com/tencent/mm/audio/b/b:ciQ	Landroid/media/MediaRecorder;
    //   39: ifnull +22 -> 61
    //   42: aload_0
    //   43: getfield 160	com/tencent/mm/audio/b/b:ciQ	Landroid/media/MediaRecorder;
    //   46: invokevirtual 353	android/media/MediaRecorder:stop	()V
    //   49: aload_0
    //   50: getfield 160	com/tencent/mm/audio/b/b:ciQ	Landroid/media/MediaRecorder;
    //   53: invokevirtual 356	android/media/MediaRecorder:release	()V
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 160	com/tencent/mm/audio/b/b:ciQ	Landroid/media/MediaRecorder;
    //   61: ldc_w 348
    //   64: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: iconst_1
    //   68: ireturn
    //   69: new 105	com/tencent/mm/compatible/util/g$a
    //   72: dup
    //   73: invokespecial 106	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   76: astore 9
    //   78: ldc 121
    //   80: new 316	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 358
    //   87: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 173	com/tencent/mm/audio/b/b:ciT	Lcom/tencent/mm/audio/b/b$b;
    //   94: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 138	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 173	com/tencent/mm/audio/b/b:ciT	Lcom/tencent/mm/audio/b/b$b;
    //   107: getstatic 291	com/tencent/mm/audio/b/b$b:cjb	Lcom/tencent/mm/audio/b/b$b;
    //   110: if_acmpne +43 -> 153
    //   113: getstatic 367	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   116: ldc2_w 368
    //   119: ldc2_w 370
    //   122: lconst_1
    //   123: iconst_1
    //   124: invokevirtual 375	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   127: aload_0
    //   128: getfield 119	com/tencent/mm/audio/b/b:bCp	Z
    //   131: ifne +17 -> 148
    //   134: getstatic 367	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   137: ldc2_w 368
    //   140: ldc2_w 376
    //   143: lconst_1
    //   144: iconst_1
    //   145: invokevirtual 375	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   148: aload_0
    //   149: iconst_1
    //   150: putfield 119	com/tencent/mm/audio/b/b:bCp	Z
    //   153: aload_0
    //   154: getfield 173	com/tencent/mm/audio/b/b:ciT	Lcom/tencent/mm/audio/b/b$b;
    //   157: getstatic 380	com/tencent/mm/audio/b/b$b:cjd	Lcom/tencent/mm/audio/b/b$b;
    //   160: if_acmpeq +26 -> 186
    //   163: ldc 121
    //   165: ldc_w 382
    //   168: invokestatic 339	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_0
    //   172: getstatic 342	com/tencent/mm/audio/b/b$b:cje	Lcom/tencent/mm/audio/b/b$b;
    //   175: putfield 173	com/tencent/mm/audio/b/b:ciT	Lcom/tencent/mm/audio/b/b$b;
    //   178: ldc_w 348
    //   181: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iconst_1
    //   185: ireturn
    //   186: getstatic 65	com/tencent/mm/audio/b/b:ciN	Ljava/lang/Object;
    //   189: astore 10
    //   191: aload 10
    //   193: monitorenter
    //   194: aload_0
    //   195: getfield 97	com/tencent/mm/audio/b/b:ciR	Lcom/tencent/mm/audio/b/c;
    //   198: ifnull +407 -> 605
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 99	com/tencent/mm/audio/b/b:ciU	Z
    //   206: aload 10
    //   208: monitorexit
    //   209: aload 9
    //   211: invokevirtual 386	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   214: lstore_3
    //   215: aload_0
    //   216: getstatic 389	com/tencent/mm/audio/b/b$b:cjf	Lcom/tencent/mm/audio/b/b$b;
    //   219: putfield 173	com/tencent/mm/audio/b/b:ciT	Lcom/tencent/mm/audio/b/b$b;
    //   222: aload 9
    //   224: invokevirtual 386	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   227: lstore 5
    //   229: aload_0
    //   230: getfield 99	com/tencent/mm/audio/b/b:ciU	Z
    //   233: ifeq +145 -> 378
    //   236: ldc 121
    //   238: ldc_w 391
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_0
    //   248: getfield 99	com/tencent/mm/audio/b/b:ciU	Z
    //   251: invokestatic 396	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   254: aastore
    //   255: invokestatic 273	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: iconst_0
    //   259: istore_1
    //   260: iload_1
    //   261: istore_2
    //   262: aload_0
    //   263: getfield 99	com/tencent/mm/audio/b/b:ciU	Z
    //   266: ifeq +83 -> 349
    //   269: iload_1
    //   270: iconst_1
    //   271: iadd
    //   272: istore_2
    //   273: ldc2_w 397
    //   276: invokestatic 404	java/lang/Thread:sleep	(J)V
    //   279: iload_2
    //   280: istore_1
    //   281: iload_2
    //   282: bipush 25
    //   284: if_icmplt -24 -> 260
    //   287: getstatic 65	com/tencent/mm/audio/b/b:ciN	Ljava/lang/Object;
    //   290: astore 10
    //   292: aload 10
    //   294: monitorenter
    //   295: ldc 121
    //   297: ldc_w 406
    //   300: iconst_1
    //   301: anewarray 4	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: aload_0
    //   307: getfield 97	com/tencent/mm/audio/b/b:ciR	Lcom/tencent/mm/audio/b/c;
    //   310: aastore
    //   311: invokestatic 273	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: aload_0
    //   315: getfield 97	com/tencent/mm/audio/b/b:ciR	Lcom/tencent/mm/audio/b/c;
    //   318: astore 11
    //   320: aload 11
    //   322: ifnull +24 -> 346
    //   325: aload_0
    //   326: getfield 97	com/tencent/mm/audio/b/b:ciR	Lcom/tencent/mm/audio/b/c;
    //   329: invokevirtual 409	com/tencent/mm/audio/b/c:Et	()Z
    //   332: pop
    //   333: aload_0
    //   334: getfield 97	com/tencent/mm/audio/b/b:ciR	Lcom/tencent/mm/audio/b/c;
    //   337: aconst_null
    //   338: putfield 288	com/tencent/mm/audio/b/c:cjD	Lcom/tencent/mm/audio/b/c$a;
    //   341: aload_0
    //   342: aconst_null
    //   343: putfield 97	com/tencent/mm/audio/b/b:ciR	Lcom/tencent/mm/audio/b/c;
    //   346: aload 10
    //   348: monitorexit
    //   349: ldc 121
    //   351: ldc_w 411
    //   354: iconst_2
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload_0
    //   361: getfield 99	com/tencent/mm/audio/b/b:ciU	Z
    //   364: invokestatic 396	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   367: aastore
    //   368: dup
    //   369: iconst_1
    //   370: iload_2
    //   371: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: aastore
    //   375: invokestatic 273	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: aload_0
    //   379: getfield 77	com/tencent/mm/audio/b/b:ciF	Ljava/lang/Object;
    //   382: astore 10
    //   384: aload 10
    //   386: monitorenter
    //   387: aload_0
    //   388: getfield 79	com/tencent/mm/audio/b/b:ciG	Lcom/tencent/mm/audio/e/c;
    //   391: ifnull +10 -> 401
    //   394: aload_0
    //   395: getfield 79	com/tencent/mm/audio/b/b:ciG	Lcom/tencent/mm/audio/e/c;
    //   398: invokevirtual 416	com/tencent/mm/audio/e/c:Fb	()V
    //   401: aload_0
    //   402: getfield 81	com/tencent/mm/audio/b/b:ciI	Lcom/tencent/mm/bf/c;
    //   405: ifnull +41 -> 446
    //   408: aload_0
    //   409: getfield 81	com/tencent/mm/audio/b/b:ciI	Lcom/tencent/mm/bf/c;
    //   412: astore 11
    //   414: ldc_w 418
    //   417: ldc_w 420
    //   420: invokestatic 138	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: new 422	com/tencent/mm/sdk/platformtools/ak
    //   426: dup
    //   427: invokestatic 428	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   430: invokespecial 431	com/tencent/mm/sdk/platformtools/ak:<init>	(Landroid/os/Looper;)V
    //   433: new 433	com/tencent/mm/bf/c$1
    //   436: dup
    //   437: aload 11
    //   439: invokespecial 436	com/tencent/mm/bf/c$1:<init>	(Lcom/tencent/mm/bf/c;)V
    //   442: invokevirtual 440	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   445: pop
    //   446: aload 10
    //   448: monitorexit
    //   449: aload_0
    //   450: getfield 87	com/tencent/mm/audio/b/b:ciL	J
    //   453: invokestatic 444	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   456: lstore 7
    //   458: ldc 121
    //   460: new 316	java/lang/StringBuilder
    //   463: dup
    //   464: ldc_w 446
    //   467: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: lload 7
    //   472: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   475: ldc_w 451
    //   478: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_0
    //   482: getfield 87	com/tencent/mm/audio/b/b:ciL	J
    //   485: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: ldc_w 453
    //   491: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_0
    //   495: getfield 89	com/tencent/mm/audio/b/b:ciM	I
    //   498: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   501: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 138	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: lload 7
    //   509: ldc2_w 454
    //   512: lcmp
    //   513: ifle +37 -> 550
    //   516: aload_0
    //   517: getfield 89	com/tencent/mm/audio/b/b:ciM	I
    //   520: ifne +30 -> 550
    //   523: invokestatic 295	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   526: pop
    //   527: invokestatic 299	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   530: getfield 305	com/tencent/mm/kernel/e:eHM	Lcom/tencent/mm/storage/y;
    //   533: bipush 27
    //   535: iconst_1
    //   536: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: invokevirtual 459	com/tencent/mm/storage/y:set	(ILjava/lang/Object;)V
    //   542: ldc 121
    //   544: ldc_w 461
    //   547: invokestatic 138	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: ldc 121
    //   552: new 316	java/lang/StringBuilder
    //   555: dup
    //   556: ldc_w 463
    //   559: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   562: lload_3
    //   563: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   566: ldc_w 465
    //   569: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: lload 5
    //   574: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   577: ldc_w 467
    //   580: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 9
    //   585: invokevirtual 386	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   588: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   591: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 138	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   597: ldc_w 348
    //   600: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   603: iconst_0
    //   604: ireturn
    //   605: aload_0
    //   606: iconst_0
    //   607: putfield 99	com/tencent/mm/audio/b/b:ciU	Z
    //   610: goto -404 -> 206
    //   613: astore 9
    //   615: aload 10
    //   617: monitorexit
    //   618: ldc_w 348
    //   621: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   624: aload 9
    //   626: athrow
    //   627: astore 10
    //   629: ldc 121
    //   631: aload 10
    //   633: ldc_w 469
    //   636: iconst_0
    //   637: anewarray 4	java/lang/Object
    //   640: invokestatic 473	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   643: goto -364 -> 279
    //   646: astore 11
    //   648: ldc 121
    //   650: aload 11
    //   652: ldc_w 469
    //   655: iconst_0
    //   656: anewarray 4	java/lang/Object
    //   659: invokestatic 473	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   662: goto -316 -> 346
    //   665: astore 9
    //   667: aload 10
    //   669: monitorexit
    //   670: ldc_w 348
    //   673: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   676: aload 9
    //   678: athrow
    //   679: astore 9
    //   681: aload 10
    //   683: monitorexit
    //   684: ldc_w 348
    //   687: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   690: aload 9
    //   692: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	693	0	this	b
    //   259	22	1	i	int
    //   261	110	2	j	int
    //   214	349	3	l1	long
    //   227	346	5	l2	long
    //   456	52	7	l3	long
    //   76	508	9	locala	com.tencent.mm.compatible.util.g.a
    //   613	12	9	localObject1	Object
    //   665	12	9	localObject2	Object
    //   679	12	9	localObject3	Object
    //   627	55	10	localInterruptedException	java.lang.InterruptedException
    //   318	120	11	localObject5	Object
    //   646	5	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   194	206	613	finally
    //   206	209	613	finally
    //   605	610	613	finally
    //   615	618	613	finally
    //   273	279	627	java/lang/InterruptedException
    //   325	346	646	java/lang/Exception
    //   295	320	665	finally
    //   325	346	665	finally
    //   346	349	665	finally
    //   648	662	665	finally
    //   667	670	665	finally
    //   387	401	679	finally
    //   401	446	679	finally
    //   446	449	679	finally
    //   681	684	679	finally
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(116482);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ == null)
      {
        AppMethodBeat.o(116482);
        return;
      }
      this.ciH = parama;
      this.ciQ.setOnErrorListener(new b.1(this));
      AppMethodBeat.o(116482);
      return;
    }
    if (this.ciT == b.b.cjb)
    {
      this.ciH = parama;
      AppMethodBeat.o(116482);
      return;
    }
    ab.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
    AppMethodBeat.o(116482);
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(116488);
    int i;
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ == null)
      {
        AppMethodBeat.o(116488);
        return 0;
      }
      i = this.ciQ.getMaxAmplitude();
      AppMethodBeat.o(116488);
      return i;
    }
    if (this.ciT == b.b.cjd)
    {
      i = this.ciC;
      if ((this.oFw <= 0L) || (bo.av(this.oFw) > 500L))
      {
        ab.i("MicroMsg.MMAudioRecorder", "mCurAmplitude:%s", new Object[] { Integer.valueOf(this.ciC) });
        this.oFw = bo.yB();
      }
      this.ciC = 0;
      AppMethodBeat.o(116488);
      return i;
    }
    AppMethodBeat.o(116488);
    return 0;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(116491);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ != null) {
        this.ciQ.prepare();
      }
      AppMethodBeat.o(116491);
      return;
    }
    if ((this.ciT != b.b.cjb) || (this.ciD == null))
    {
      this.ciT = b.b.cje;
      release();
      AppMethodBeat.o(116491);
      return;
    }
    this.ciT = b.b.cjc;
    AppMethodBeat.o(116491);
  }
  
  public final void release()
  {
    AppMethodBeat.i(116492);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ != null) {
        this.ciQ.release();
      }
      AppMethodBeat.o(116492);
      return;
    }
    if (this.ciT == b.b.cjd) {
      Ez();
    }
    synchronized (ciN)
    {
      if (this.ciR != null)
      {
        this.ciR.Et();
        this.ciR.cjD = null;
        this.ciR = null;
      }
      AppMethodBeat.o(116492);
      return;
      ??? = b.b.cjc;
    }
  }
  
  public final void setMaxDuration(int paramInt)
  {
    AppMethodBeat.i(116484);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ != null) {
        this.ciQ.setMaxDuration(paramInt);
      }
      AppMethodBeat.o(116484);
      return;
    }
    this.ciK = paramInt;
    AppMethodBeat.o(116484);
  }
  
  public final void setOutputFile(String paramString)
  {
    AppMethodBeat.i(116483);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ == null)
      {
        AppMethodBeat.o(116483);
        return;
      }
      this.ciQ.setOutputFile(paramString);
      this.ciD = paramString;
      AppMethodBeat.o(116483);
      return;
    }
    if (this.ciT == b.b.cjb)
    {
      this.ciD = paramString;
      AppMethodBeat.o(116483);
      return;
    }
    ab.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
    this.ciT = b.b.cje;
    AppMethodBeat.o(116483);
  }
  
  public final void start()
  {
    AppMethodBeat.i(116490);
    if (this.ciS == com.tencent.mm.compatible.b.c.a.elP)
    {
      if (this.ciQ != null) {
        this.ciQ.start();
      }
      AppMethodBeat.o(116490);
      return;
    }
    ab.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.ciT + " recMode: " + this.ciS);
    if (this.ciT == b.b.cjc)
    {
      this.ciL = System.currentTimeMillis();
      this.ciM = 0;
    }
    for (this.ciT = b.b.cjd;; this.ciT = b.b.cje)
    {
      synchronized (ciN)
      {
        this.ciR.EC();
        this.ciU = false;
        AppMethodBeat.o(116490);
        return;
      }
      g.RM();
      g.RL().eHM.set(27, Integer.valueOf(1));
      ab.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.b.b
 * JD-Core Version:    0.7.0.1
 */