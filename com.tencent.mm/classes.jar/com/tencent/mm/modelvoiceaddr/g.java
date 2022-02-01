package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.List;
import java.util.Map;

public final class g
  implements i, b
{
  private static int dAR;
  private static final String jwd;
  public static int jwp;
  public static int jwq;
  public static int jwr;
  public static int jws;
  public static int jwt;
  public static int jwu;
  public static int jwv;
  public static int jww;
  public static int jwx;
  public static int jwy;
  private com.tencent.mm.audio.b.c dyI;
  private com.tencent.mm.audio.b.c.a dzv;
  private int jvS;
  private g.b jwA;
  private com.tencent.mm.modelvoiceaddr.a.c jwB;
  private com.tencent.mm.modelvoiceaddr.a.c.a jwC;
  private int jwf;
  private int jwg;
  private boolean jwh;
  private com.tencent.mm.audio.e.a jwl;
  private a jwn;
  private boolean jwz;
  private int scene;
  
  static
  {
    AppMethodBeat.i(148563);
    jwp = 0;
    jwq = 1;
    jwr = 2;
    jws = 4;
    jwt = 8;
    jwu = 16;
    jwv = 32;
    jww = 64;
    jwx = 128;
    jwy = 256;
    jwd = ar.NSe + "voice_temp.silk";
    dAR = 5000;
    AppMethodBeat.o(148563);
  }
  
  public g()
  {
    AppMethodBeat.i(148554);
    this.jwf = 0;
    this.jwg = 0;
    this.jwh = false;
    this.jwz = false;
    this.scene = 0;
    this.jvS = jwq;
    this.jwA = null;
    this.jwn = null;
    this.dzv = new com.tencent.mm.audio.b.c.a()
    {
      short[] jwD;
      
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(148547);
        Log.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.dD(10, -1);
        AppMethodBeat.o(148547);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(148546);
        Log.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(System.currentTimeMillis()) });
        int i;
        if (this.jwD != null)
        {
          i = j;
          if (this.jwD.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.jwD = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.jwD[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        g.a(g.this, this.jwD, paramAnonymousInt / 2);
        if (g.d(g.this) != null)
        {
          g.d(g.this).e(this.jwD, paramAnonymousInt / 2);
          AppMethodBeat.o(148546);
          return;
        }
        g.this.dD(9, -1);
        Log.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
        AppMethodBeat.o(148546);
      }
    };
    this.jwC = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      byte[] jwF;
      
      public final void Yh()
      {
        AppMethodBeat.i(148552);
        Log.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        g.this.stop(false);
        AppMethodBeat.o(148552);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(148549);
        if (paramAnonymousArrayOfShort == null)
        {
          AppMethodBeat.o(148549);
          return;
        }
        if ((this.jwF == null) || (this.jwF.length < paramAnonymousInt * 2)) {
          this.jwF = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.jwF[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.jwF[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (g.b(g.this) != null) {}
        for (paramAnonymousInt = g.b(g.this).a(new com.tencent.mm.audio.b.g.a(this.jwF, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            g.this.dD(4, -1);
            Log.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
            AppMethodBeat.o(148549);
            return;
          }
          g.a(g.this, paramAnonymousInt + g.h(g.this));
          if ((!g.i(g.this)) && (g.h(g.this) > 200) && (!g.j(g.this)))
          {
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148548);
                Log.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[] { Integer.valueOf(g.h(g.this)), Long.valueOf(System.currentTimeMillis()) });
                if ((g.i(g.this)) || (g.k(g.this) == null) || (g.h(g.this) == 0))
                {
                  Log.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                  AppMethodBeat.o(148548);
                  return;
                }
                com.tencent.mm.kernel.g.azz().a(235, g.this);
                if ((!((c)g.k(g.this)).bir()) || (!com.tencent.mm.kernel.g.azz().a(g.k(g.this), 0))) {
                  g.this.dD(13, 131);
                }
                AppMethodBeat.o(148548);
              }
            });
            g.l(g.this);
          }
          AppMethodBeat.o(148549);
          return;
        }
      }
      
      public final void bix()
      {
        AppMethodBeat.i(148550);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
        if ((g.k(g.this) instanceof c))
        {
          int i = (int)s.boW(g.biw());
          try
          {
            ((c)g.k(g.this)).ul(i);
            AppMethodBeat.o(148550);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "cutShortSentence error", new Object[0]);
            g.this.dD(6, -1);
          }
        }
        AppMethodBeat.o(148550);
      }
      
      public final void biy()
      {
        AppMethodBeat.i(148551);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
        if ((g.k(g.this) instanceof c)) {
          try
          {
            ((c)g.k(g.this)).jvN.biC();
            if (!g.b(g.this).abQ())
            {
              g.this.dD(5, -1);
              AppMethodBeat.o(148551);
              return;
            }
            AppMethodBeat.o(148551);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "createShortSentence error", new Object[0]);
            g.this.dD(6, -1);
          }
        }
        AppMethodBeat.o(148551);
      }
    };
    AppMethodBeat.o(148554);
  }
  
  public g(int paramInt1, int paramInt2, g.b paramb)
  {
    AppMethodBeat.i(148555);
    this.jwf = 0;
    this.jwg = 0;
    this.jwh = false;
    this.jwz = false;
    this.scene = 0;
    this.jvS = jwq;
    this.jwA = null;
    this.jwn = null;
    this.dzv = new com.tencent.mm.audio.b.c.a()
    {
      short[] jwD;
      
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(148547);
        Log.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.dD(10, -1);
        AppMethodBeat.o(148547);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(148546);
        Log.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(System.currentTimeMillis()) });
        int i;
        if (this.jwD != null)
        {
          i = j;
          if (this.jwD.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.jwD = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.jwD[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        g.a(g.this, this.jwD, paramAnonymousInt / 2);
        if (g.d(g.this) != null)
        {
          g.d(g.this).e(this.jwD, paramAnonymousInt / 2);
          AppMethodBeat.o(148546);
          return;
        }
        g.this.dD(9, -1);
        Log.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
        AppMethodBeat.o(148546);
      }
    };
    this.jwC = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      byte[] jwF;
      
      public final void Yh()
      {
        AppMethodBeat.i(148552);
        Log.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        g.this.stop(false);
        AppMethodBeat.o(148552);
      }
      
      public final void b(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(148549);
        if (paramAnonymousArrayOfShort == null)
        {
          AppMethodBeat.o(148549);
          return;
        }
        if ((this.jwF == null) || (this.jwF.length < paramAnonymousInt * 2)) {
          this.jwF = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.jwF[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.jwF[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (g.b(g.this) != null) {}
        for (paramAnonymousInt = g.b(g.this).a(new com.tencent.mm.audio.b.g.a(this.jwF, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            g.this.dD(4, -1);
            Log.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
            AppMethodBeat.o(148549);
            return;
          }
          g.a(g.this, paramAnonymousInt + g.h(g.this));
          if ((!g.i(g.this)) && (g.h(g.this) > 200) && (!g.j(g.this)))
          {
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148548);
                Log.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[] { Integer.valueOf(g.h(g.this)), Long.valueOf(System.currentTimeMillis()) });
                if ((g.i(g.this)) || (g.k(g.this) == null) || (g.h(g.this) == 0))
                {
                  Log.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                  AppMethodBeat.o(148548);
                  return;
                }
                com.tencent.mm.kernel.g.azz().a(235, g.this);
                if ((!((c)g.k(g.this)).bir()) || (!com.tencent.mm.kernel.g.azz().a(g.k(g.this), 0))) {
                  g.this.dD(13, 131);
                }
                AppMethodBeat.o(148548);
              }
            });
            g.l(g.this);
          }
          AppMethodBeat.o(148549);
          return;
        }
      }
      
      public final void bix()
      {
        AppMethodBeat.i(148550);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
        if ((g.k(g.this) instanceof c))
        {
          int i = (int)s.boW(g.biw());
          try
          {
            ((c)g.k(g.this)).ul(i);
            AppMethodBeat.o(148550);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "cutShortSentence error", new Object[0]);
            g.this.dD(6, -1);
          }
        }
        AppMethodBeat.o(148550);
      }
      
      public final void biy()
      {
        AppMethodBeat.i(148551);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
        if ((g.k(g.this) instanceof c)) {
          try
          {
            ((c)g.k(g.this)).jvN.biC();
            if (!g.b(g.this).abQ())
            {
              g.this.dD(5, -1);
              AppMethodBeat.o(148551);
              return;
            }
            AppMethodBeat.o(148551);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "createShortSentence error", new Object[0]);
            g.this.dD(6, -1);
          }
        }
        AppMethodBeat.o(148551);
      }
    };
    this.jvS = paramInt1;
    this.jwA = paramb;
    this.scene = paramInt2;
    AppMethodBeat.o(148555);
  }
  
  /* Error */
  private void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 155
    //   7: ldc 194
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: iload_1
    //   16: invokestatic 199	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_2
    //   23: invokestatic 199	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: aastore
    //   27: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 121	com/tencent/mm/modelvoiceaddr/g:jwz	Z
    //   37: aload_0
    //   38: getfield 143	com/tencent/mm/modelvoiceaddr/g:dyI	Lcom/tencent/mm/audio/b/c;
    //   41: ifnull +16 -> 57
    //   44: aload_0
    //   45: getfield 143	com/tencent/mm/modelvoiceaddr/g:dyI	Lcom/tencent/mm/audio/b/c;
    //   48: invokevirtual 207	com/tencent/mm/audio/b/c:ZZ	()Z
    //   51: pop
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 143	com/tencent/mm/modelvoiceaddr/g:dyI	Lcom/tencent/mm/audio/b/c;
    //   57: aload_0
    //   58: getfield 147	com/tencent/mm/modelvoiceaddr/g:jwl	Lcom/tencent/mm/audio/e/a;
    //   61: ifnull +17 -> 78
    //   64: aload_0
    //   65: getfield 147	com/tencent/mm/modelvoiceaddr/g:jwl	Lcom/tencent/mm/audio/e/a;
    //   68: invokeinterface 212 1 0
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 147	com/tencent/mm/modelvoiceaddr/g:jwl	Lcom/tencent/mm/audio/e/a;
    //   78: aload_0
    //   79: getfield 150	com/tencent/mm/modelvoiceaddr/g:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnull +15 -> 101
    //   89: aload_0
    //   90: getfield 150	com/tencent/mm/modelvoiceaddr/g:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   93: invokevirtual 217	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 150	com/tencent/mm/modelvoiceaddr/g:jwB	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 117	com/tencent/mm/modelvoiceaddr/g:jwg	I
    //   106: aload_0
    //   107: getfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   110: ifnull +43 -> 153
    //   113: aload_0
    //   114: getfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   117: instanceof 219
    //   120: ifeq +33 -> 153
    //   123: aload_0
    //   124: getfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   127: invokevirtual 224	com/tencent/mm/modelvoiceaddr/a:bim	()V
    //   130: getstatic 105	com/tencent/mm/modelvoiceaddr/g:jwd	Ljava/lang/String;
    //   133: invokestatic 230	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   136: lstore 4
    //   138: lload 4
    //   140: l2i
    //   141: istore_3
    //   142: aload_0
    //   143: getfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   146: checkcast 219	com/tencent/mm/modelvoiceaddr/c
    //   149: iload_3
    //   150: invokevirtual 233	com/tencent/mm/modelvoiceaddr/c:ul	(I)V
    //   153: iload_1
    //   154: ifne +10 -> 164
    //   157: aload_0
    //   158: getfield 119	com/tencent/mm/modelvoiceaddr/g:jwh	Z
    //   161: ifne +66 -> 227
    //   164: aload_0
    //   165: monitorexit
    //   166: ldc 192
    //   168: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: return
    //   172: astore 6
    //   174: ldc 155
    //   176: aload 6
    //   178: ldc 235
    //   180: iconst_0
    //   181: anewarray 4	java/lang/Object
    //   184: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: goto -86 -> 101
    //   190: astore 6
    //   192: aload_0
    //   193: monitorexit
    //   194: ldc 192
    //   196: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 6
    //   201: athrow
    //   202: astore 6
    //   204: ldc 155
    //   206: aload 6
    //   208: ldc 241
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload_0
    //   218: bipush 6
    //   220: iconst_m1
    //   221: invokevirtual 245	com/tencent/mm/modelvoiceaddr/g:dD	(II)V
    //   224: goto -71 -> 153
    //   227: aload_0
    //   228: getfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   231: ifnull +55 -> 286
    //   234: aload_0
    //   235: getfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   238: instanceof 219
    //   241: ifeq +45 -> 286
    //   244: ldc 155
    //   246: ldc 247
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: iload_2
    //   255: invokestatic 199	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   258: aastore
    //   259: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: iload_2
    //   263: ifeq +13 -> 276
    //   266: aload_0
    //   267: getfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   270: checkcast 219	com/tencent/mm/modelvoiceaddr/c
    //   273: invokevirtual 250	com/tencent/mm/modelvoiceaddr/c:bis	()V
    //   276: invokestatic 256	com/tencent/mm/kernel/g:azz	()Lcom/tencent/mm/ak/t;
    //   279: sipush 235
    //   282: aload_0
    //   283: invokevirtual 261	com/tencent/mm/ak/t:b	(ILcom/tencent/mm/ak/i;)V
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 129	com/tencent/mm/modelvoiceaddr/g:jwn	Lcom/tencent/mm/modelvoiceaddr/a;
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 119	com/tencent/mm/modelvoiceaddr/g:jwh	Z
    //   296: aload_0
    //   297: monitorexit
    //   298: ldc 192
    //   300: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	g
    //   0	304	1	paramBoolean1	boolean
    //   0	304	2	paramBoolean2	boolean
    //   141	9	3	i	int
    //   136	3	4	l	long
    //   82	3	6	localc	com.tencent.mm.modelvoiceaddr.a.c
    //   172	5	6	localException1	Exception
    //   190	10	6	localObject	Object
    //   202	5	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   89	101	172	java/lang/Exception
    //   32	57	190	finally
    //   57	78	190	finally
    //   78	84	190	finally
    //   89	101	190	finally
    //   101	138	190	finally
    //   142	153	190	finally
    //   157	164	190	finally
    //   164	166	190	finally
    //   174	187	190	finally
    //   192	194	190	finally
    //   204	224	190	finally
    //   227	262	190	finally
    //   266	276	190	finally
    //   276	286	190	finally
    //   286	298	190	finally
    //   142	153	202	java/lang/Exception
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(148560);
    Log.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jwA = null;
    n(false, paramBoolean);
    AppMethodBeat.o(148560);
  }
  
  public final void dD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148558);
    Log.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(-1) });
    if (this.jwA != null) {
      this.jwA.c(paramInt1, paramInt2, -1, -1L);
    }
    n(false, true);
    AppMethodBeat.o(148558);
  }
  
  public final int getMaxAmplitudeRate()
  {
    int i = this.jwf;
    this.jwf = 0;
    if (i > dAR) {
      dAR = i;
    }
    return i * 100 / dAR;
  }
  
  public final void init(int paramInt1, int paramInt2, g.b paramb)
  {
    this.jvS = paramInt1;
    this.jwA = paramb;
    this.scene = paramInt2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(148557);
    String[] arrayOfString = ((a)paramq).bin();
    List localList = ((a)paramq).biq();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramq.hashCode();
      if (this.jwn != null) {
        break label160;
      }
    }
    label160:
    for (int j = -1;; j = this.jwn.hashCode())
    {
      Log.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.jwn != null) && (paramq.hashCode() == this.jwn.hashCode())) {
        break label172;
      }
      Log.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(148557);
      return;
      i = arrayOfString.length;
      break;
    }
    label172:
    if (this.jwA != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.jwA.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          cancel(false);
          AppMethodBeat.o(148557);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.jwA.c(13, 133, -1, -1L);
          } else {
            this.jwA.c(11, paramInt1, paramInt2, ((a)paramq).bip());
          }
        }
      }
      this.jwA.b(arrayOfString, localList);
      if (((paramq instanceof c)) && (this.jwg == 0) && (((c)paramq).jvN.biB()))
      {
        this.jwA.biz();
        cancel(false);
      }
    }
    AppMethodBeat.o(148557);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148556);
    Log.i("MicroMsg.SceneVoiceInputAddr", "start record");
    ThreadPool.post(new a((byte)0), "SceneVoiceInputAddr_record", 10);
    AppMethodBeat.o(148556);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148559);
    Log.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (this.jwA != null)) {
      this.jwA.biv();
    }
    n(true, true);
    AppMethodBeat.o(148559);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(148553);
      long l1;
      synchronized (g.this)
      {
        Log.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        long l2 = System.nanoTime() & 0xFFFFFFFF;
        l1 = l2;
        if (l2 < 0L) {
          l1 = Math.abs(l2);
        }
        try
        {
          o localo = new o(g.jwd);
          if (!localo.exists()) {
            localo.mkdirs();
          }
          localo = new o(g.biw());
          if (!localo.exists()) {
            localo.createNewFile();
          }
          localo.delete();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "delete file failed", new Object[0]);
          }
        }
        g.a(g.this, new com.tencent.mm.audio.b.c(16000, 1, 3));
        g.a(g.this).dzk = -19;
        g.a(g.this).dc(false);
        g.a(g.this, new com.tencent.mm.audio.e.c(16000, 23900));
        if (!g.b(g.this).hz(g.biw()))
        {
          Log.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
          g.b(g.this).abP();
          g.a(g.this, null);
          g.this.dD(5, -1);
          AppMethodBeat.o(148553);
          return;
        }
      }
      if (ae.gKE.gGG > 0)
      {
        g.a(g.this).x(ae.gKE.gGG, true);
        label302:
        g.a(g.this).jk(50);
        g.a(g.this).dd(false);
      }
      for (;;)
      {
        try
        {
          g.a(g.this, new com.tencent.mm.modelvoiceaddr.a.c(true, true));
          g.d(g.this).jxj = g.c(g.this);
          com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100235");
          if (!localc.isValid()) {
            break label532;
          }
          i = Util.getInt((String)localc.gzz().get("MMVoipVadOn"), 0);
          g.a(g.this, new c(g.biw(), String.valueOf(l1), String.valueOf(i), g.e(g.this), g.f(g.this)));
          g.a(g.this).dzv = g.g(g.this);
          if (g.a(g.this).aai()) {
            break;
          }
          Log.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
          g.this.dD(8, -1);
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localThrowable, "init VoiceDetectAPI failed", new Object[0]);
          g.this.dD(7, -1);
        }
        g.a(g.this).x(5, false);
        break label302;
        break;
        label532:
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g
 * JD-Core Version:    0.7.0.1
 */