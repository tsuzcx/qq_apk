package com.tencent.mm.audio.b;

import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import com.tencent.mm.bg.d.a;
import com.tencent.mm.bg.d.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public final class b
{
  private static Object cVa;
  private int cUP;
  private String cUQ;
  private int cUR;
  private final Object cUS;
  private com.tencent.mm.audio.e.c cUT;
  private a cUU;
  private com.tencent.mm.bg.c cUV;
  private d.a cUW;
  private long cUX;
  private long cUY;
  private int cUZ;
  private int cVb;
  private boolean cVc;
  public MediaRecorder cVd;
  public c cVe;
  public com.tencent.mm.compatible.b.c.a cVf;
  public b cVg;
  private volatile boolean cVh;
  private long cVi;
  private f.a cVj;
  private int cVk;
  private int cVl;
  private c.a cVm;
  private boolean cbi;
  private int mSampleRate;
  
  static
  {
    AppMethodBeat.i(148328);
    cVa = new Object();
    AppMethodBeat.o(148328);
  }
  
  public b(com.tencent.mm.compatible.b.c.a parama)
  {
    AppMethodBeat.i(148315);
    this.cUP = 0;
    this.cUQ = null;
    this.cUS = new Object();
    this.cUT = null;
    this.cUV = null;
    this.cUW = null;
    this.cUX = 0L;
    this.cUY = 0L;
    this.cUZ = 0;
    this.mSampleRate = 8000;
    this.cVb = 16000;
    this.cVc = false;
    this.cVe = null;
    this.cVh = false;
    this.cVi = -1L;
    this.cVj = new f.a();
    this.cVk = 0;
    this.cVl = 0;
    this.cVm = new c.a()
    {
      private static byte[] v(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
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
      
      private void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148311);
        int i = 0;
        while (i < paramAnonymousInt / 2)
        {
          int j = (short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8);
          if (j > b.u(b.this)) {
            b.b(b.this, j);
          }
          i += 1;
        }
        AppMethodBeat.o(148311);
      }
      
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(148310);
        ac.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", new Object[] { Boolean.valueOf(b.c(b.this)) });
        if ((b.d(b.this) == b.b.cVt) && (!b.c(b.this)))
        {
          ac.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
          AppMethodBeat.o(148310);
          return;
        }
        if (com.tencent.mm.plugin.audio.c.a.bCx().audioManager.isMusicActive()) {
          com.tencent.mm.audio.c.b.a.hR(0);
        }
        com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
        boolean bool1 = false;
        boolean bool2 = false;
        synchronized (b.Od())
        {
          if (b.c(b.this))
          {
            if (b.e(b.this) != null)
            {
              ac.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt) });
              b.e(b.this).NX();
              b.e(b.this).cVR = null;
              b.f(b.this);
              bool1 = true;
              b.g(b.this);
            }
          }
          else
          {
            long l = bs.Ap(b.h(b.this));
            if ((b.i(b.this) <= 0L) || (l <= b.i(b.this))) {
              break label291;
            }
            ac.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:".concat(String.valueOf(l)));
            new ao(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148308);
                b.this.Fb();
                if (b.a(b.this) != null) {
                  b.a(b.this).onError();
                }
                AppMethodBeat.o(148308);
              }
            });
            AppMethodBeat.o(148310);
            return;
          }
          ac.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
          bool1 = bool2;
        }
        label291:
        ac.i("MicroMsg.MMAudioRecorder", "read :" + paramAnonymousInt + " time: " + b.j(b.this).YH() + " dataReadedCnt: " + b.k(b.this));
        if (paramAnonymousInt < 0)
        {
          if (b.d(b.this) == b.b.cVt)
          {
            ac.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
            AppMethodBeat.o(148310);
            return;
          }
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(148309);
              b.this.Fb();
              if (b.a(b.this) != null) {
                b.a(b.this).onError();
              }
              AppMethodBeat.o(148309);
            }
          });
          AppMethodBeat.o(148310);
          return;
        }
        ac.i("MicroMsg.MMAudioRecorder", "publish SceneVoiceRcdDataEvent, buf.len %d, len: %d.", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
        ??? = new sf();
        ((sf)???).dvj.buf = Arrays.copyOf(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length);
        ((sf)???).dvj.len = paramAnonymousInt;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)???);
        b.a(b.this, b.k(b.this) + paramAnonymousInt);
        for (;;)
        {
          Object localObject2;
          Object localObject3;
          int j;
          synchronized (b.l(b.this))
          {
            if ((b.m(b.this) == null) && ((b.n(b.this) == com.tencent.mm.compatible.b.c.a.fCm) || (b.n(b.this) == com.tencent.mm.compatible.b.c.a.fCo)) && (b.o(b.this) != null) && (b.p(b.this)))
            {
              b.a(b.this, new com.tencent.mm.bg.c());
              localObject2 = b.m(b.this);
              i = b.q(b.this);
              ac.i("MicroMsg.SpeexEncoderWorker", "init ");
              ((com.tencent.mm.bg.c)localObject2).hUe.clear();
              localObject3 = new d.b();
              ((d.b)localObject3).hUu = d.getPrefix();
              ((d.b)localObject3).sampleRate = i;
              ((d.b)localObject3).hUa = 1;
              ((d.b)localObject3).audioFormat = 16;
              ((com.tencent.mm.bg.c)localObject2).mFileName = String.format("%s%d_%d_%d_%d", new Object[] { ((d.b)localObject3).hUu, Integer.valueOf(((d.b)localObject3).sampleRate), Integer.valueOf(((d.b)localObject3).hUa), Integer.valueOf(((d.b)localObject3).audioFormat), Long.valueOf(System.currentTimeMillis()) });
            }
            if (b.m(b.this) != null)
            {
              localObject2 = b.m(b.this);
              ac.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + ((com.tencent.mm.bg.c)localObject2).hUe.size());
              if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
                ((com.tencent.mm.bg.c)localObject2).hUe.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length));
              }
            }
            if (b.n(b.this) != com.tencent.mm.compatible.b.c.a.fCo) {
              break;
            }
            if (b.r(b.this) == null)
            {
              b.a(b.this, new com.tencent.mm.audio.e.c(b.q(b.this), b.s(b.this)));
              b.r(b.this).fH(b.t(b.this));
            }
            w(paramAnonymousArrayOfByte, paramAnonymousInt);
            localObject2 = b.r(b.this);
            if (((com.tencent.mm.audio.e.c)localObject2).cXI == null)
            {
              i = -1;
              if (paramAnonymousArrayOfByte != null) {
                break label983;
              }
              j = -1;
              label890:
              ac.i("MicroMsg.SilkWriter", "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
              if (paramAnonymousInt <= 0) {}
            }
          }
          try
          {
            if (((com.tencent.mm.audio.e.c)localObject2).cXJ) {
              ac.e("MicroMsg.SilkWriter", "already stop");
            }
            for (;;)
            {
              return;
              i = ((com.tencent.mm.audio.e.c)localObject2).cXI.size();
              break;
              label983:
              j = paramAnonymousArrayOfByte.length;
              break label890;
              if (((com.tencent.mm.audio.e.c)localObject2).cXP == null)
              {
                ((com.tencent.mm.audio.e.c)localObject2).cXP = new com.tencent.mm.audio.e.c.a((com.tencent.mm.audio.e.c)localObject2, (byte)0);
                h.JZN.aS(((com.tencent.mm.audio.e.c)localObject2).cXP);
              }
              localObject3 = ((com.tencent.mm.audio.e.c)localObject2).cXI;
              if (localObject3 != null) {
                try
                {
                  ((com.tencent.mm.audio.e.c)localObject2).cXI.add(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt, bool1));
                }
                catch (Exception paramAnonymousArrayOfByte)
                {
                  ac.printErrStackTrace("MicroMsg.SilkWriter", paramAnonymousArrayOfByte, "pushBuf add queue error:%s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
                }
              }
            }
            paramAnonymousArrayOfByte = finally;
            throw paramAnonymousArrayOfByte;
          }
          finally
          {
            AppMethodBeat.o(148310);
          }
        }
        ??? = paramAnonymousArrayOfByte;
        int i = paramAnonymousInt;
        if (b.q(b.this) == 16000)
        {
          ??? = v(paramAnonymousArrayOfByte, paramAnonymousInt);
          i = ???.length;
        }
        w((byte[])???, i);
        AppMethodBeat.o(148310);
      }
    };
    this.cbi = false;
    ac.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: ".concat(String.valueOf(parama)));
    this.cVf = parama;
    if (!g.b.On())
    {
      ac.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
      this.cVf = com.tencent.mm.compatible.b.c.a.fCn;
    }
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      this.cUR = 7;
      this.cVd = new com.tencent.mm.compatible.h.e();
    }
    for (;;)
    {
      this.cVi = -1L;
      this.cVh = false;
      AppMethodBeat.o(148315);
      return;
      Oc();
      this.cUR = 1;
    }
  }
  
  /* Error */
  public final boolean Fb()
  {
    // Byte code:
    //   0: ldc 218
    //   2: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 148	com/tencent/mm/audio/b/b:cVf	Lcom/tencent/mm/compatible/b/c$a;
    //   9: getstatic 161	com/tencent/mm/compatible/b/c$a:fCn	Lcom/tencent/mm/compatible/b/c$a;
    //   12: if_acmpne +54 -> 66
    //   15: ldc 129
    //   17: ldc 220
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 168	com/tencent/mm/audio/b/b:cVd	Landroid/media/MediaRecorder;
    //   29: aastore
    //   30: invokestatic 223	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 168	com/tencent/mm/audio/b/b:cVd	Landroid/media/MediaRecorder;
    //   37: ifnull +22 -> 59
    //   40: aload_0
    //   41: getfield 168	com/tencent/mm/audio/b/b:cVd	Landroid/media/MediaRecorder;
    //   44: invokevirtual 228	android/media/MediaRecorder:stop	()V
    //   47: aload_0
    //   48: getfield 168	com/tencent/mm/audio/b/b:cVd	Landroid/media/MediaRecorder;
    //   51: invokevirtual 231	android/media/MediaRecorder:release	()V
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 168	com/tencent/mm/audio/b/b:cVd	Landroid/media/MediaRecorder;
    //   59: ldc 218
    //   61: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_1
    //   65: ireturn
    //   66: new 113	com/tencent/mm/compatible/util/f$a
    //   69: dup
    //   70: invokespecial 114	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   73: astore 9
    //   75: ldc 129
    //   77: new 233	java/lang/StringBuilder
    //   80: dup
    //   81: ldc 235
    //   83: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: getfield 180	com/tencent/mm/audio/b/b:cVg	Lcom/tencent/mm/audio/b/b$b;
    //   90: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 180	com/tencent/mm/audio/b/b:cVg	Lcom/tencent/mm/audio/b/b$b;
    //   103: getstatic 249	com/tencent/mm/audio/b/b$b:cVp	Lcom/tencent/mm/audio/b/b$b;
    //   106: if_acmpne +43 -> 149
    //   109: getstatic 255	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   112: ldc2_w 256
    //   115: ldc2_w 258
    //   118: lconst_1
    //   119: iconst_1
    //   120: invokevirtual 263	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   123: aload_0
    //   124: getfield 127	com/tencent/mm/audio/b/b:cbi	Z
    //   127: ifne +17 -> 144
    //   130: getstatic 255	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   133: ldc2_w 256
    //   136: ldc2_w 264
    //   139: lconst_1
    //   140: iconst_1
    //   141: invokevirtual 263	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   144: aload_0
    //   145: iconst_1
    //   146: putfield 127	com/tencent/mm/audio/b/b:cbi	Z
    //   149: aload_0
    //   150: getfield 180	com/tencent/mm/audio/b/b:cVg	Lcom/tencent/mm/audio/b/b$b;
    //   153: getstatic 268	com/tencent/mm/audio/b/b$b:cVr	Lcom/tencent/mm/audio/b/b$b;
    //   156: if_acmpeq +25 -> 181
    //   159: ldc 129
    //   161: ldc_w 270
    //   164: invokestatic 272	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_0
    //   168: getstatic 275	com/tencent/mm/audio/b/b$b:cVs	Lcom/tencent/mm/audio/b/b$b;
    //   171: putfield 180	com/tencent/mm/audio/b/b:cVg	Lcom/tencent/mm/audio/b/b$b;
    //   174: ldc 218
    //   176: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_1
    //   180: ireturn
    //   181: getstatic 73	com/tencent/mm/audio/b/b:cVa	Ljava/lang/Object;
    //   184: astore 10
    //   186: aload 10
    //   188: monitorenter
    //   189: aload_0
    //   190: getfield 105	com/tencent/mm/audio/b/b:cVe	Lcom/tencent/mm/audio/b/c;
    //   193: ifnull +406 -> 599
    //   196: aload_0
    //   197: iconst_1
    //   198: putfield 107	com/tencent/mm/audio/b/b:cVh	Z
    //   201: aload 10
    //   203: monitorexit
    //   204: aload 9
    //   206: invokevirtual 279	com/tencent/mm/compatible/util/f$a:YH	()J
    //   209: lstore_3
    //   210: aload_0
    //   211: getstatic 282	com/tencent/mm/audio/b/b$b:cVt	Lcom/tencent/mm/audio/b/b$b;
    //   214: putfield 180	com/tencent/mm/audio/b/b:cVg	Lcom/tencent/mm/audio/b/b$b;
    //   217: aload 9
    //   219: invokevirtual 279	com/tencent/mm/compatible/util/f$a:YH	()J
    //   222: lstore 5
    //   224: aload_0
    //   225: getfield 107	com/tencent/mm/audio/b/b:cVh	Z
    //   228: ifeq +145 -> 373
    //   231: ldc 129
    //   233: ldc_w 284
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload_0
    //   243: getfield 107	com/tencent/mm/audio/b/b:cVh	Z
    //   246: invokestatic 289	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   249: aastore
    //   250: invokestatic 223	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: iconst_0
    //   254: istore_1
    //   255: iload_1
    //   256: istore_2
    //   257: aload_0
    //   258: getfield 107	com/tencent/mm/audio/b/b:cVh	Z
    //   261: ifeq +83 -> 344
    //   264: iload_1
    //   265: iconst_1
    //   266: iadd
    //   267: istore_2
    //   268: ldc2_w 290
    //   271: invokestatic 297	java/lang/Thread:sleep	(J)V
    //   274: iload_2
    //   275: istore_1
    //   276: iload_2
    //   277: bipush 25
    //   279: if_icmplt -24 -> 255
    //   282: getstatic 73	com/tencent/mm/audio/b/b:cVa	Ljava/lang/Object;
    //   285: astore 10
    //   287: aload 10
    //   289: monitorenter
    //   290: ldc 129
    //   292: ldc_w 299
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload_0
    //   302: getfield 105	com/tencent/mm/audio/b/b:cVe	Lcom/tencent/mm/audio/b/c;
    //   305: aastore
    //   306: invokestatic 223	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: aload_0
    //   310: getfield 105	com/tencent/mm/audio/b/b:cVe	Lcom/tencent/mm/audio/b/c;
    //   313: astore 11
    //   315: aload 11
    //   317: ifnull +24 -> 341
    //   320: aload_0
    //   321: getfield 105	com/tencent/mm/audio/b/b:cVe	Lcom/tencent/mm/audio/b/c;
    //   324: invokevirtual 304	com/tencent/mm/audio/b/c:NX	()Z
    //   327: pop
    //   328: aload_0
    //   329: getfield 105	com/tencent/mm/audio/b/b:cVe	Lcom/tencent/mm/audio/b/c;
    //   332: aconst_null
    //   333: putfield 307	com/tencent/mm/audio/b/c:cVR	Lcom/tencent/mm/audio/b/c$a;
    //   336: aload_0
    //   337: aconst_null
    //   338: putfield 105	com/tencent/mm/audio/b/b:cVe	Lcom/tencent/mm/audio/b/c;
    //   341: aload 10
    //   343: monitorexit
    //   344: ldc 129
    //   346: ldc_w 309
    //   349: iconst_2
    //   350: anewarray 4	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload_0
    //   356: getfield 107	com/tencent/mm/audio/b/b:cVh	Z
    //   359: invokestatic 289	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: iload_2
    //   366: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: invokestatic 223	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: aload_0
    //   374: getfield 85	com/tencent/mm/audio/b/b:cUS	Ljava/lang/Object;
    //   377: astore 10
    //   379: aload 10
    //   381: monitorenter
    //   382: aload_0
    //   383: getfield 87	com/tencent/mm/audio/b/b:cUT	Lcom/tencent/mm/audio/e/c;
    //   386: ifnull +10 -> 396
    //   389: aload_0
    //   390: getfield 87	com/tencent/mm/audio/b/b:cUT	Lcom/tencent/mm/audio/e/c;
    //   393: invokevirtual 319	com/tencent/mm/audio/e/c:PM	()V
    //   396: aload_0
    //   397: getfield 89	com/tencent/mm/audio/b/b:cUV	Lcom/tencent/mm/bg/c;
    //   400: ifnull +41 -> 441
    //   403: aload_0
    //   404: getfield 89	com/tencent/mm/audio/b/b:cUV	Lcom/tencent/mm/bg/c;
    //   407: astore 11
    //   409: ldc_w 321
    //   412: ldc_w 323
    //   415: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: new 325	com/tencent/mm/sdk/platformtools/ao
    //   421: dup
    //   422: invokestatic 331	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   425: invokespecial 334	com/tencent/mm/sdk/platformtools/ao:<init>	(Landroid/os/Looper;)V
    //   428: new 336	com/tencent/mm/bg/c$1
    //   431: dup
    //   432: aload 11
    //   434: invokespecial 339	com/tencent/mm/bg/c$1:<init>	(Lcom/tencent/mm/bg/c;)V
    //   437: invokevirtual 343	com/tencent/mm/sdk/platformtools/ao:post	(Ljava/lang/Runnable;)Z
    //   440: pop
    //   441: aload 10
    //   443: monitorexit
    //   444: aload_0
    //   445: getfield 95	com/tencent/mm/audio/b/b:cUY	J
    //   448: invokestatic 349	com/tencent/mm/sdk/platformtools/bs:Ap	(J)J
    //   451: lstore 7
    //   453: ldc 129
    //   455: new 233	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 351
    //   462: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: lload 7
    //   467: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: ldc_w 356
    //   473: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 95	com/tencent/mm/audio/b/b:cUY	J
    //   480: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   483: ldc_w 361
    //   486: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_0
    //   490: getfield 97	com/tencent/mm/audio/b/b:cUZ	I
    //   493: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: lload 7
    //   504: ldc2_w 365
    //   507: lcmp
    //   508: ifle +37 -> 545
    //   511: aload_0
    //   512: getfield 97	com/tencent/mm/audio/b/b:cUZ	I
    //   515: ifne +30 -> 545
    //   518: invokestatic 372	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   521: pop
    //   522: invokestatic 376	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   525: getfield 382	com/tencent/mm/kernel/e:ghx	Lcom/tencent/mm/storage/ad;
    //   528: bipush 27
    //   530: iconst_1
    //   531: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: invokevirtual 388	com/tencent/mm/storage/ad:set	(ILjava/lang/Object;)V
    //   537: ldc 129
    //   539: ldc_w 390
    //   542: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: ldc 129
    //   547: new 233	java/lang/StringBuilder
    //   550: dup
    //   551: ldc_w 392
    //   554: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   557: lload_3
    //   558: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: ldc_w 394
    //   564: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: lload 5
    //   569: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   572: ldc_w 396
    //   575: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload 9
    //   580: invokevirtual 279	com/tencent/mm/compatible/util/f$a:YH	()J
    //   583: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   586: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: ldc 218
    //   594: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: iconst_0
    //   598: ireturn
    //   599: aload_0
    //   600: iconst_0
    //   601: putfield 107	com/tencent/mm/audio/b/b:cVh	Z
    //   604: goto -403 -> 201
    //   607: astore 9
    //   609: aload 10
    //   611: monitorexit
    //   612: ldc 218
    //   614: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   617: aload 9
    //   619: athrow
    //   620: astore 10
    //   622: ldc 129
    //   624: aload 10
    //   626: ldc_w 398
    //   629: iconst_0
    //   630: anewarray 4	java/lang/Object
    //   633: invokestatic 402	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: goto -362 -> 274
    //   639: astore 11
    //   641: ldc 129
    //   643: aload 11
    //   645: ldc_w 398
    //   648: iconst_0
    //   649: anewarray 4	java/lang/Object
    //   652: invokestatic 402	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   655: goto -314 -> 341
    //   658: astore 9
    //   660: aload 10
    //   662: monitorexit
    //   663: ldc 218
    //   665: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   668: aload 9
    //   670: athrow
    //   671: astore 9
    //   673: aload 10
    //   675: monitorexit
    //   676: ldc 218
    //   678: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   681: aload 9
    //   683: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	b
    //   254	22	1	i	int
    //   256	110	2	j	int
    //   209	349	3	l1	long
    //   222	346	5	l2	long
    //   451	52	7	l3	long
    //   73	506	9	locala	f.a
    //   607	11	9	localObject1	Object
    //   658	11	9	localObject2	Object
    //   671	11	9	localObject3	Object
    //   620	54	10	localInterruptedException	java.lang.InterruptedException
    //   313	120	11	localObject5	Object
    //   639	5	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   189	201	607	finally
    //   201	204	607	finally
    //   599	604	607	finally
    //   609	612	607	finally
    //   268	274	620	java/lang/InterruptedException
    //   320	341	639	java/lang/Exception
    //   290	315	658	finally
    //   320	341	658	finally
    //   341	344	658	finally
    //   641	655	658	finally
    //   660	663	658	finally
    //   382	396	671	finally
    //   396	441	671	finally
    //   441	444	671	finally
    //   673	676	671	finally
  }
  
  public final void NZ()
  {
    AppMethodBeat.i(148319);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd != null) {
        this.cVd.setAudioEncoder(1);
      }
      AppMethodBeat.o(148319);
      return;
    }
    AppMethodBeat.o(148319);
  }
  
  public final void Oa()
  {
    AppMethodBeat.i(148320);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd == null)
      {
        AppMethodBeat.o(148320);
        return;
      }
      this.cVd.setAudioSource(1);
      AppMethodBeat.o(148320);
      return;
    }
    AppMethodBeat.o(148320);
  }
  
  public final void Ob()
  {
    AppMethodBeat.i(148321);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd == null)
      {
        AppMethodBeat.o(148321);
        return;
      }
      this.cVd.setOutputFormat(3);
      AppMethodBeat.o(148321);
      return;
    }
    AppMethodBeat.o(148321);
  }
  
  public final void Oc()
  {
    AppMethodBeat.i(148323);
    this.cUW = d.a.aIm();
    if (this.cUW != null) {
      this.cVc = this.cUW.aIl();
    }
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCo)
    {
      ??? = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("VoiceSamplingRate");
      this.mSampleRate = bs.getInt((String)???, 16000);
      String str = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("VoiceRate");
      this.cVb = bs.getInt(str, 16000);
      ac.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", new Object[] { ???, Integer.valueOf(this.mSampleRate), str, Integer.valueOf(this.cVb) });
    }
    for (;;)
    {
      this.cUP = 0;
      this.cUQ = null;
      synchronized (this.cUS)
      {
        this.cUV = null;
        this.cUT = null;
        this.cUZ = 0;
      }
      try
      {
        synchronized (cVa)
        {
          this.cVe = new c(this.mSampleRate, 1, 0);
          this.cVe.cs(true);
          this.cVe.hH(120);
          this.cVe.cVR = this.cVm;
          this.cVg = b.cVp;
          AppMethodBeat.o(148323);
          return;
          if (this.cVc) {}
          for (this.mSampleRate = 16000;; this.mSampleRate = 8000)
          {
            g.agS();
            int i = bs.a((Integer)g.agR().ghx.get(27), 0);
            ac.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + i);
            if (i != 1) {
              break;
            }
            this.mSampleRate = 8000;
            break;
          }
          localObject2 = finally;
          AppMethodBeat.o(148323);
          throw localObject2;
        }
        ac.e("MicroMsg.MMAudioRecorder", localException.getMessage());
      }
      catch (Exception localException)
      {
        if (localException.getMessage() == null) {}
      }
    }
    for (;;)
    {
      this.cVg = b.cVs;
      AppMethodBeat.o(148323);
      return;
      ac.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(148316);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd == null)
      {
        AppMethodBeat.o(148316);
        return;
      }
      this.cUU = parama;
      this.cVd.setOnErrorListener(new MediaRecorder.OnErrorListener()
      {
        public final void onError(MediaRecorder paramAnonymousMediaRecorder, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(148307);
          if (b.a(b.this) != null) {
            b.a(b.this).onError();
          }
          try
          {
            b.b(b.this).release();
            b.a(b.this, b.b.cVs);
            AppMethodBeat.o(148307);
            return;
          }
          catch (Exception paramAnonymousMediaRecorder)
          {
            for (;;)
            {
              ac.e("MicroMsg.MMAudioRecorder", paramAnonymousMediaRecorder.getMessage());
            }
          }
        }
      });
      AppMethodBeat.o(148316);
      return;
    }
    if (this.cVg == b.cVp)
    {
      this.cUU = parama;
      AppMethodBeat.o(148316);
      return;
    }
    ac.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
    AppMethodBeat.o(148316);
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(148322);
    int i;
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd == null)
      {
        AppMethodBeat.o(148322);
        return 0;
      }
      i = this.cVd.getMaxAmplitude();
      AppMethodBeat.o(148322);
      return i;
    }
    if (this.cVg == b.cVr)
    {
      i = this.cUP;
      if ((this.cVi <= 0L) || (bs.aO(this.cVi) > 500L))
      {
        ac.i("MicroMsg.MMAudioRecorder", "mCurAmplitude:%s", new Object[] { Integer.valueOf(this.cUP) });
        this.cVi = bs.Gn();
      }
      this.cUP = 0;
      AppMethodBeat.o(148322);
      return i;
    }
    AppMethodBeat.o(148322);
    return 0;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(148325);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd != null) {
        this.cVd.prepare();
      }
      AppMethodBeat.o(148325);
      return;
    }
    if ((this.cVg != b.cVp) || (this.cUQ == null))
    {
      this.cVg = b.cVs;
      release();
      AppMethodBeat.o(148325);
      return;
    }
    this.cVg = b.cVq;
    AppMethodBeat.o(148325);
  }
  
  public final void release()
  {
    AppMethodBeat.i(148326);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd != null) {
        this.cVd.release();
      }
      AppMethodBeat.o(148326);
      return;
    }
    if (this.cVg == b.cVr) {
      Fb();
    }
    synchronized (cVa)
    {
      if (this.cVe != null)
      {
        this.cVe.NX();
        this.cVe.cVR = null;
        this.cVe = null;
      }
      AppMethodBeat.o(148326);
      return;
      ??? = b.cVq;
    }
  }
  
  public final void setMaxDuration(int paramInt)
  {
    AppMethodBeat.i(148318);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd != null) {
        this.cVd.setMaxDuration(paramInt);
      }
      AppMethodBeat.o(148318);
      return;
    }
    this.cUX = paramInt;
    AppMethodBeat.o(148318);
  }
  
  public final void setOutputFile(String paramString)
  {
    AppMethodBeat.i(148317);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd == null)
      {
        AppMethodBeat.o(148317);
        return;
      }
      this.cVd.setOutputFile(paramString);
      this.cUQ = paramString;
      AppMethodBeat.o(148317);
      return;
    }
    if (this.cVg == b.cVp)
    {
      this.cUQ = paramString;
      if (this.cVe != null)
      {
        this.cVe.cVY = this.cUQ;
        AppMethodBeat.o(148317);
      }
    }
    else
    {
      ac.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
      this.cVg = b.cVs;
    }
    AppMethodBeat.o(148317);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148324);
    if (this.cVf == com.tencent.mm.compatible.b.c.a.fCn)
    {
      if (this.cVd != null) {
        this.cVd.start();
      }
      AppMethodBeat.o(148324);
      return;
    }
    ac.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.cVg + " recMode: " + this.cVf);
    if (this.cVg == b.cVq)
    {
      this.cUY = System.currentTimeMillis();
      this.cUZ = 0;
    }
    for (this.cVg = b.cVr;; this.cVg = b.cVs)
    {
      synchronized (cVa)
      {
        this.cVe.Og();
        this.cVh = false;
        AppMethodBeat.o(148324);
        return;
      }
      g.agS();
      g.agR().ghx.set(27, Integer.valueOf(1));
      ac.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
    }
  }
  
  public static abstract interface a
  {
    public abstract void onError();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(148314);
      cVp = new b("INITIALIZING", 0);
      cVq = new b("READY", 1);
      cVr = new b("RECORDING", 2);
      cVs = new b("ERROR", 3);
      cVt = new b("STOPPED", 4);
      cVu = new b[] { cVp, cVq, cVr, cVs, cVt };
      AppMethodBeat.o(148314);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.b.b
 * JD-Core Version:    0.7.0.1
 */