package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.y;
import java.util.List;

public final class g
  implements com.tencent.mm.am.h, b
{
  private static int hxV;
  public static int pfE;
  public static int pfF;
  public static int pfG;
  public static int pfH;
  public static int pfI;
  public static int pfJ;
  public static int pfK;
  public static int pfL;
  public static int pfM;
  public static int pfN;
  private static final String pfs;
  private com.tencent.mm.audio.b.c hvI;
  private com.tencent.mm.audio.b.c.a hwy;
  private com.tencent.mm.audio.e.a pfA;
  private a pfC;
  private boolean pfO;
  private g.b pfP;
  private com.tencent.mm.modelvoiceaddr.a.c pfQ;
  private com.tencent.mm.modelvoiceaddr.a.c.a pfR;
  private int pfh;
  private int pfu;
  private int pfv;
  private boolean pfw;
  private int scene;
  
  static
  {
    AppMethodBeat.i(148563);
    pfE = 0;
    pfF = 1;
    pfG = 2;
    pfH = 4;
    pfI = 8;
    pfJ = 16;
    pfK = 32;
    pfL = 64;
    pfM = 128;
    pfN = 256;
    pfs = at.acHq + "voice_temp.silk";
    hxV = 5000;
    AppMethodBeat.o(148563);
  }
  
  public g()
  {
    AppMethodBeat.i(148554);
    this.pfu = 0;
    this.pfv = 0;
    this.pfw = false;
    this.pfO = false;
    this.scene = 0;
    this.pfh = pfF;
    this.pfP = null;
    this.pfC = null;
    this.hwy = new com.tencent.mm.audio.b.c.a()
    {
      short[] pfS;
      
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(148547);
        Log.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.eS(10, -1);
        AppMethodBeat.o(148547);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(148546);
        Log.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(System.currentTimeMillis()) });
        int i;
        if (this.pfS != null)
        {
          i = j;
          if (this.pfS.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.pfS = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.pfS[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        g.a(g.this, this.pfS, paramAnonymousInt / 2);
        if (g.d(g.this) != null)
        {
          g.d(g.this).f(this.pfS, paramAnonymousInt / 2);
          AppMethodBeat.o(148546);
          return;
        }
        g.this.eS(9, -1);
        Log.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
        AppMethodBeat.o(148546);
      }
    };
    this.pfR = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      byte[] pfU;
      
      public final void aEN()
      {
        AppMethodBeat.i(148552);
        Log.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        g.this.stop(false);
        AppMethodBeat.o(148552);
      }
      
      public final void bPB()
      {
        AppMethodBeat.i(148550);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
        if ((g.k(g.this) instanceof c))
        {
          int i = (int)y.bEl(g.bPA());
          try
          {
            ((c)g.k(g.this)).xl(i);
            AppMethodBeat.o(148550);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "cutShortSentence error", new Object[0]);
            g.this.eS(6, -1);
          }
        }
        AppMethodBeat.o(148550);
      }
      
      public final void bPC()
      {
        AppMethodBeat.i(148551);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
        if ((g.k(g.this) instanceof c)) {
          try
          {
            ((c)g.k(g.this)).pfc.bPG();
            if (!g.b(g.this).aIA())
            {
              g.this.eS(5, -1);
              AppMethodBeat.o(148551);
              return;
            }
            AppMethodBeat.o(148551);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "createShortSentence error", new Object[0]);
            g.this.eS(6, -1);
          }
        }
        AppMethodBeat.o(148551);
      }
      
      public final void c(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(148549);
        if (paramAnonymousArrayOfShort == null)
        {
          AppMethodBeat.o(148549);
          return;
        }
        if ((this.pfU == null) || (this.pfU.length < paramAnonymousInt * 2)) {
          this.pfU = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.pfU[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.pfU[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (g.b(g.this) != null) {}
        for (paramAnonymousInt = g.b(g.this).a(new com.tencent.mm.audio.b.g.a(this.pfU, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            g.this.eS(4, -1);
            Log.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
            AppMethodBeat.o(148549);
            return;
          }
          g.a(g.this, paramAnonymousInt);
          if ((!g.h(g.this)) && (g.i(g.this) > 200) && (!g.j(g.this)))
          {
            com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148548);
                Log.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[] { Integer.valueOf(g.i(g.this)), Long.valueOf(System.currentTimeMillis()) });
                if ((g.h(g.this)) || (g.k(g.this) == null) || (g.i(g.this) == 0))
                {
                  Log.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                  AppMethodBeat.o(148548);
                  return;
                }
                com.tencent.mm.kernel.h.aZW().a(235, g.this);
                if ((!((c)g.k(g.this)).bPv()) || (!com.tencent.mm.kernel.h.aZW().a(g.k(g.this), 0))) {
                  g.this.eS(13, 131);
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
    };
    AppMethodBeat.o(148554);
  }
  
  public g(int paramInt1, int paramInt2, g.b paramb)
  {
    AppMethodBeat.i(148555);
    this.pfu = 0;
    this.pfv = 0;
    this.pfw = false;
    this.pfO = false;
    this.scene = 0;
    this.pfh = pfF;
    this.pfP = null;
    this.pfC = null;
    this.hwy = new com.tencent.mm.audio.b.c.a()
    {
      short[] pfS;
      
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(148547);
        Log.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.eS(10, -1);
        AppMethodBeat.o(148547);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(148546);
        Log.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(System.currentTimeMillis()) });
        int i;
        if (this.pfS != null)
        {
          i = j;
          if (this.pfS.length >= paramAnonymousInt / 2) {}
        }
        else
        {
          this.pfS = new short[paramAnonymousInt / 2];
          i = j;
        }
        while (i < paramAnonymousInt / 2)
        {
          this.pfS[i] = ((short)(paramAnonymousArrayOfByte[(i * 2)] & 0xFF | paramAnonymousArrayOfByte[(i * 2 + 1)] << 8));
          i += 1;
        }
        g.a(g.this, this.pfS, paramAnonymousInt / 2);
        if (g.d(g.this) != null)
        {
          g.d(g.this).f(this.pfS, paramAnonymousInt / 2);
          AppMethodBeat.o(148546);
          return;
        }
        g.this.eS(9, -1);
        Log.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
        AppMethodBeat.o(148546);
      }
    };
    this.pfR = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      byte[] pfU;
      
      public final void aEN()
      {
        AppMethodBeat.i(148552);
        Log.i("MicroMsg.SceneVoiceInputAddr", "Silent enough to finish time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        g.this.stop(false);
        AppMethodBeat.o(148552);
      }
      
      public final void bPB()
      {
        AppMethodBeat.i(148550);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSpeakToSilent");
        if ((g.k(g.this) instanceof c))
        {
          int i = (int)y.bEl(g.bPA());
          try
          {
            ((c)g.k(g.this)).xl(i);
            AppMethodBeat.o(148550);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "cutShortSentence error", new Object[0]);
            g.this.eS(6, -1);
          }
        }
        AppMethodBeat.o(148550);
      }
      
      public final void bPC()
      {
        AppMethodBeat.i(148551);
        Log.i("MicroMsg.SceneVoiceInputAddr", "onSilentToSpeak");
        if ((g.k(g.this) instanceof c)) {
          try
          {
            ((c)g.k(g.this)).pfc.bPG();
            if (!g.b(g.this).aIA())
            {
              g.this.eS(5, -1);
              AppMethodBeat.o(148551);
              return;
            }
            AppMethodBeat.o(148551);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", localException, "createShortSentence error", new Object[0]);
            g.this.eS(6, -1);
          }
        }
        AppMethodBeat.o(148551);
      }
      
      public final void c(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(148549);
        if (paramAnonymousArrayOfShort == null)
        {
          AppMethodBeat.o(148549);
          return;
        }
        if ((this.pfU == null) || (this.pfU.length < paramAnonymousInt * 2)) {
          this.pfU = new byte[paramAnonymousInt * 2];
        }
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.pfU[(i * 2)] = ((byte)(paramAnonymousArrayOfShort[i] & 0xFF));
          this.pfU[(i * 2 + 1)] = ((byte)((paramAnonymousArrayOfShort[i] & 0xFF00) >> 8));
          i += 1;
        }
        if (g.b(g.this) != null) {}
        for (paramAnonymousInt = g.b(g.this).a(new com.tencent.mm.audio.b.g.a(this.pfU, paramAnonymousInt * 2), 0, true);; paramAnonymousInt = -1)
        {
          if (-1 == paramAnonymousInt)
          {
            g.this.eS(4, -1);
            Log.e("MicroMsg.SceneVoiceInputAddr", "write to file failed");
            AppMethodBeat.o(148549);
            return;
          }
          g.a(g.this, paramAnonymousInt);
          if ((!g.h(g.this)) && (g.i(g.this) > 200) && (!g.j(g.this)))
          {
            com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(148548);
                Log.i("MicroMsg.SceneVoiceInputAddr", "run NetSceneNewVoiceInput mWroteBytesCnt %s time %s", new Object[] { Integer.valueOf(g.i(g.this)), Long.valueOf(System.currentTimeMillis()) });
                if ((g.h(g.this)) || (g.k(g.this) == null) || (g.i(g.this) == 0))
                {
                  Log.w("MicroMsg.SceneVoiceInputAddr", "WorkerThread too busy can not do work");
                  AppMethodBeat.o(148548);
                  return;
                }
                com.tencent.mm.kernel.h.aZW().a(235, g.this);
                if ((!((c)g.k(g.this)).bPv()) || (!com.tencent.mm.kernel.h.aZW().a(g.k(g.this), 0))) {
                  g.this.eS(13, 131);
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
    };
    this.pfh = paramInt1;
    this.pfP = paramb;
    this.scene = paramInt2;
    AppMethodBeat.o(148555);
  }
  
  /* Error */
  private void w(boolean paramBoolean1, boolean paramBoolean2)
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
    //   34: putfield 121	com/tencent/mm/modelvoiceaddr/g:pfO	Z
    //   37: aload_0
    //   38: getfield 143	com/tencent/mm/modelvoiceaddr/g:hvI	Lcom/tencent/mm/audio/b/c;
    //   41: ifnull +16 -> 57
    //   44: aload_0
    //   45: getfield 143	com/tencent/mm/modelvoiceaddr/g:hvI	Lcom/tencent/mm/audio/b/c;
    //   48: invokevirtual 207	com/tencent/mm/audio/b/c:aGH	()Z
    //   51: pop
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 143	com/tencent/mm/modelvoiceaddr/g:hvI	Lcom/tencent/mm/audio/b/c;
    //   57: aload_0
    //   58: getfield 147	com/tencent/mm/modelvoiceaddr/g:pfA	Lcom/tencent/mm/audio/e/a;
    //   61: ifnull +17 -> 78
    //   64: aload_0
    //   65: getfield 147	com/tencent/mm/modelvoiceaddr/g:pfA	Lcom/tencent/mm/audio/e/a;
    //   68: invokeinterface 212 1 0
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 147	com/tencent/mm/modelvoiceaddr/g:pfA	Lcom/tencent/mm/audio/e/a;
    //   78: aload_0
    //   79: getfield 150	com/tencent/mm/modelvoiceaddr/g:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnull +15 -> 101
    //   89: aload_0
    //   90: getfield 150	com/tencent/mm/modelvoiceaddr/g:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   93: invokevirtual 217	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 150	com/tencent/mm/modelvoiceaddr/g:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 117	com/tencent/mm/modelvoiceaddr/g:pfv	I
    //   106: aload_0
    //   107: getfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
    //   110: ifnull +43 -> 153
    //   113: aload_0
    //   114: getfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
    //   117: instanceof 219
    //   120: ifeq +33 -> 153
    //   123: aload_0
    //   124: getfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
    //   127: invokevirtual 224	com/tencent/mm/modelvoiceaddr/a:bPq	()V
    //   130: getstatic 105	com/tencent/mm/modelvoiceaddr/g:pfs	Ljava/lang/String;
    //   133: invokestatic 230	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   136: lstore 4
    //   138: lload 4
    //   140: l2i
    //   141: istore_3
    //   142: aload_0
    //   143: getfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
    //   146: checkcast 219	com/tencent/mm/modelvoiceaddr/c
    //   149: iload_3
    //   150: invokevirtual 233	com/tencent/mm/modelvoiceaddr/c:xl	(I)V
    //   153: iload_1
    //   154: ifne +10 -> 164
    //   157: aload_0
    //   158: getfield 119	com/tencent/mm/modelvoiceaddr/g:pfw	Z
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
    //   221: invokevirtual 245	com/tencent/mm/modelvoiceaddr/g:eS	(II)V
    //   224: goto -71 -> 153
    //   227: aload_0
    //   228: getfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
    //   231: ifnull +55 -> 286
    //   234: aload_0
    //   235: getfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
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
    //   267: getfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
    //   270: checkcast 219	com/tencent/mm/modelvoiceaddr/c
    //   273: invokevirtual 250	com/tencent/mm/modelvoiceaddr/c:bPw	()V
    //   276: invokestatic 256	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   279: sipush 235
    //   282: aload_0
    //   283: invokevirtual 261	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 129	com/tencent/mm/modelvoiceaddr/g:pfC	Lcom/tencent/mm/modelvoiceaddr/a;
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 119	com/tencent/mm/modelvoiceaddr/g:pfw	Z
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
    this.pfP = null;
    w(false, paramBoolean);
    AppMethodBeat.o(148560);
  }
  
  public final void eS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148558);
    Log.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(-1) });
    if (this.pfP != null) {
      this.pfP.c(paramInt1, paramInt2, -1, -1L);
    }
    w(false, true);
    AppMethodBeat.o(148558);
  }
  
  public final int getMaxAmplitudeRate()
  {
    int i = this.pfu;
    this.pfu = 0;
    if (i > hxV) {
      hxV = i;
    }
    return i * 100 / hxV;
  }
  
  public final void init(int paramInt1, int paramInt2, g.b paramb)
  {
    this.pfh = paramInt1;
    this.pfP = paramb;
    this.scene = paramInt2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(148557);
    String[] arrayOfString = ((a)paramp).bPr();
    ((a)paramp).bPs();
    List localList = ((a)paramp).bPu();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramp.hashCode();
      if (this.pfC != null) {
        break label169;
      }
    }
    label169:
    for (int j = -1;; j = this.pfC.hashCode())
    {
      Log.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.pfC != null) && (paramp.hashCode() == this.pfC.hashCode())) {
        break label181;
      }
      Log.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(148557);
      return;
      i = arrayOfString.length;
      break;
    }
    label181:
    if (this.pfP != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.pfP.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          cancel(false);
          AppMethodBeat.o(148557);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.pfP.c(13, 133, -1, -1L);
          } else {
            this.pfP.c(11, paramInt1, paramInt2, ((a)paramp).bPt());
          }
        }
      }
      this.pfP.b(arrayOfString, localList);
      if (((paramp instanceof c)) && (this.pfv == 0) && (((c)paramp).pfc.bPF()))
      {
        this.pfP.bPD();
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
    if ((!paramBoolean) && (this.pfP != null)) {
      this.pfP.bPz();
    }
    w(true, true);
    AppMethodBeat.o(148559);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 26
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   9: astore 6
      //   11: aload 6
      //   13: monitorenter
      //   14: ldc 34
      //   16: ldc 36
      //   18: iconst_1
      //   19: anewarray 4	java/lang/Object
      //   22: dup
      //   23: iconst_0
      //   24: invokestatic 42	java/lang/System:currentTimeMillis	()J
      //   27: invokestatic 48	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   30: aastore
      //   31: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   34: invokestatic 56	java/lang/System:nanoTime	()J
      //   37: ldc2_w 57
      //   40: land
      //   41: lstore 4
      //   43: lload 4
      //   45: lstore_2
      //   46: lload 4
      //   48: lconst_0
      //   49: lcmp
      //   50: ifge +9 -> 59
      //   53: lload 4
      //   55: invokestatic 64	java/lang/Math:abs	(J)J
      //   58: lstore_2
      //   59: new 66	com/tencent/mm/vfs/u
      //   62: dup
      //   63: invokestatic 70	com/tencent/mm/modelvoiceaddr/g:access$100	()Ljava/lang/String;
      //   66: invokespecial 73	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   69: astore 7
      //   71: aload 7
      //   73: invokevirtual 77	com/tencent/mm/vfs/u:jKS	()Z
      //   76: ifne +9 -> 85
      //   79: aload 7
      //   81: invokevirtual 80	com/tencent/mm/vfs/u:jKY	()Z
      //   84: pop
      //   85: new 66	com/tencent/mm/vfs/u
      //   88: dup
      //   89: invokestatic 83	com/tencent/mm/modelvoiceaddr/g:bPA	()Ljava/lang/String;
      //   92: invokespecial 73	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
      //   95: astore 7
      //   97: aload 7
      //   99: invokevirtual 77	com/tencent/mm/vfs/u:jKS	()Z
      //   102: ifne +9 -> 111
      //   105: aload 7
      //   107: invokevirtual 86	com/tencent/mm/vfs/u:jKZ	()Z
      //   110: pop
      //   111: aload 7
      //   113: invokevirtual 89	com/tencent/mm/vfs/u:diJ	()Z
      //   116: pop
      //   117: aload_0
      //   118: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   121: new 91	com/tencent/mm/audio/b/c
      //   124: dup
      //   125: sipush 16000
      //   128: iconst_1
      //   129: iconst_3
      //   130: invokespecial 94	com/tencent/mm/audio/b/c:<init>	(III)V
      //   133: invokestatic 97	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;Lcom/tencent/mm/audio/b/c;)Lcom/tencent/mm/audio/b/c;
      //   136: pop
      //   137: aload_0
      //   138: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   141: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   144: bipush 237
      //   146: putfield 104	com/tencent/mm/audio/b/c:hwn	I
      //   149: aload_0
      //   150: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   153: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   156: iconst_0
      //   157: invokevirtual 108	com/tencent/mm/audio/b/c:eo	(Z)V
      //   160: aload_0
      //   161: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   164: new 110	com/tencent/mm/audio/e/c
      //   167: dup
      //   168: sipush 16000
      //   171: sipush 23900
      //   174: invokespecial 113	com/tencent/mm/audio/e/c:<init>	(II)V
      //   177: invokestatic 116	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;Lcom/tencent/mm/audio/e/a;)Lcom/tencent/mm/audio/e/a;
      //   180: pop
      //   181: aload_0
      //   182: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   185: invokestatic 120	com/tencent/mm/modelvoiceaddr/g:b	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/e/a;
      //   188: invokestatic 83	com/tencent/mm/modelvoiceaddr/g:bPA	()Ljava/lang/String;
      //   191: invokeinterface 126 2 0
      //   196: ifne +80 -> 276
      //   199: ldc 34
      //   201: ldc 128
      //   203: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   206: aload_0
      //   207: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   210: invokestatic 120	com/tencent/mm/modelvoiceaddr/g:b	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/e/a;
      //   213: invokeinterface 135 1 0
      //   218: aload_0
      //   219: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   222: aconst_null
      //   223: invokestatic 116	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;Lcom/tencent/mm/audio/e/a;)Lcom/tencent/mm/audio/e/a;
      //   226: pop
      //   227: aload_0
      //   228: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   231: iconst_5
      //   232: iconst_m1
      //   233: invokevirtual 138	com/tencent/mm/modelvoiceaddr/g:eS	(II)V
      //   236: aload 6
      //   238: monitorexit
      //   239: ldc 26
      //   241: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   244: return
      //   245: astore 7
      //   247: ldc 34
      //   249: aload 7
      //   251: ldc 143
      //   253: iconst_0
      //   254: anewarray 4	java/lang/Object
      //   257: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   260: goto -143 -> 117
      //   263: astore 7
      //   265: aload 6
      //   267: monitorexit
      //   268: ldc 26
      //   270: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   273: aload 7
      //   275: athrow
      //   276: getstatic 153	com/tencent/mm/compatible/deviceinfo/af:lYj	Lcom/tencent/mm/compatible/deviceinfo/k;
      //   279: getfield 158	com/tencent/mm/compatible/deviceinfo/k:lUg	I
      //   282: ifle +211 -> 493
      //   285: aload_0
      //   286: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   289: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   292: getstatic 153	com/tencent/mm/compatible/deviceinfo/af:lYj	Lcom/tencent/mm/compatible/deviceinfo/k;
      //   295: getfield 158	com/tencent/mm/compatible/deviceinfo/k:lUg	I
      //   298: iconst_1
      //   299: invokevirtual 162	com/tencent/mm/audio/b/c:O	(IZ)V
      //   302: aload_0
      //   303: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   306: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   309: bipush 50
      //   311: invokevirtual 165	com/tencent/mm/audio/b/c:ok	(I)V
      //   314: aload_0
      //   315: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   318: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   321: iconst_0
      //   322: invokevirtual 168	com/tencent/mm/audio/b/c:ep	(Z)V
      //   325: aload_0
      //   326: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   329: new 170	com/tencent/mm/modelvoiceaddr/a/c
      //   332: dup
      //   333: iconst_1
      //   334: iconst_1
      //   335: invokespecial 173	com/tencent/mm/modelvoiceaddr/a/c:<init>	(ZZ)V
      //   338: invokestatic 176	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;Lcom/tencent/mm/modelvoiceaddr/a/c;)Lcom/tencent/mm/modelvoiceaddr/a/c;
      //   341: pop
      //   342: aload_0
      //   343: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   346: invokestatic 180	com/tencent/mm/modelvoiceaddr/g:d	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/modelvoiceaddr/a/c;
      //   349: aload_0
      //   350: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   353: invokestatic 184	com/tencent/mm/modelvoiceaddr/g:c	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/modelvoiceaddr/a/c$a;
      //   356: putfield 188	com/tencent/mm/modelvoiceaddr/a/c:pgz	Lcom/tencent/mm/modelvoiceaddr/a/c$a;
      //   359: invokestatic 194	com/tencent/mm/model/newabtest/d:bEt	()Lcom/tencent/mm/storage/d;
      //   362: ldc 196
      //   364: invokevirtual 202	com/tencent/mm/storage/d:Fd	(Ljava/lang/String;)Lcom/tencent/mm/storage/c;
      //   367: astore 7
      //   369: aload 7
      //   371: ifnull +166 -> 537
      //   374: aload 7
      //   376: invokevirtual 207	com/tencent/mm/storage/c:isValid	()Z
      //   379: ifeq +158 -> 537
      //   382: aload 7
      //   384: invokevirtual 211	com/tencent/mm/storage/c:iWZ	()Ljava/util/Map;
      //   387: ldc 213
      //   389: invokeinterface 219 2 0
      //   394: checkcast 221	java/lang/String
      //   397: iconst_0
      //   398: invokestatic 227	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
      //   401: istore_1
      //   402: aload_0
      //   403: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   406: new 229	com/tencent/mm/modelvoiceaddr/c
      //   409: dup
      //   410: invokestatic 83	com/tencent/mm/modelvoiceaddr/g:bPA	()Ljava/lang/String;
      //   413: lload_2
      //   414: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   417: iload_1
      //   418: invokestatic 235	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   421: aload_0
      //   422: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   425: invokestatic 238	com/tencent/mm/modelvoiceaddr/g:e	(Lcom/tencent/mm/modelvoiceaddr/g;)I
      //   428: aload_0
      //   429: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   432: invokestatic 241	com/tencent/mm/modelvoiceaddr/g:f	(Lcom/tencent/mm/modelvoiceaddr/g;)I
      //   435: invokespecial 244	com/tencent/mm/modelvoiceaddr/c:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
      //   438: invokestatic 247	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;Lcom/tencent/mm/modelvoiceaddr/a;)Lcom/tencent/mm/modelvoiceaddr/a;
      //   441: pop
      //   442: aload_0
      //   443: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   446: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   449: aload_0
      //   450: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   453: invokestatic 251	com/tencent/mm/modelvoiceaddr/g:g	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c$a;
      //   456: putfield 255	com/tencent/mm/audio/b/c:hwy	Lcom/tencent/mm/audio/b/c$a;
      //   459: aload_0
      //   460: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   463: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   466: invokevirtual 258	com/tencent/mm/audio/b/c:aGR	()Z
      //   469: ifne -233 -> 236
      //   472: ldc 34
      //   474: ldc_w 260
      //   477: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   480: aload_0
      //   481: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   484: bipush 8
      //   486: iconst_m1
      //   487: invokevirtual 138	com/tencent/mm/modelvoiceaddr/g:eS	(II)V
      //   490: goto -254 -> 236
      //   493: aload_0
      //   494: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   497: invokestatic 100	com/tencent/mm/modelvoiceaddr/g:a	(Lcom/tencent/mm/modelvoiceaddr/g;)Lcom/tencent/mm/audio/b/c;
      //   500: iconst_5
      //   501: iconst_0
      //   502: invokevirtual 162	com/tencent/mm/audio/b/c:O	(IZ)V
      //   505: goto -203 -> 302
      //   508: astore 7
      //   510: ldc 34
      //   512: aload 7
      //   514: ldc_w 262
      //   517: iconst_0
      //   518: anewarray 4	java/lang/Object
      //   521: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   524: aload_0
      //   525: getfield 15	com/tencent/mm/modelvoiceaddr/g$a:pfT	Lcom/tencent/mm/modelvoiceaddr/g;
      //   528: bipush 7
      //   530: iconst_m1
      //   531: invokevirtual 138	com/tencent/mm/modelvoiceaddr/g:eS	(II)V
      //   534: goto -298 -> 236
      //   537: iconst_0
      //   538: istore_1
      //   539: goto -137 -> 402
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	542	0	this	a
      //   401	138	1	i	int
      //   45	369	2	l1	long
      //   41	13	4	l2	long
      //   9	257	6	localg	g
      //   69	43	7	localu	com.tencent.mm.vfs.u
      //   245	5	7	localException	Exception
      //   263	11	7	localObject	Object
      //   367	16	7	localc	com.tencent.mm.storage.c
      //   508	5	7	localThrowable	java.lang.Throwable
      // Exception table:
      //   from	to	target	type
      //   59	85	245	java/lang/Exception
      //   85	111	245	java/lang/Exception
      //   111	117	245	java/lang/Exception
      //   14	43	263	finally
      //   53	59	263	finally
      //   59	85	263	finally
      //   85	111	263	finally
      //   111	117	263	finally
      //   117	236	263	finally
      //   236	239	263	finally
      //   247	260	263	finally
      //   276	302	263	finally
      //   302	325	263	finally
      //   359	369	263	finally
      //   374	402	263	finally
      //   402	490	263	finally
      //   493	505	263	finally
      //   510	534	263	finally
      //   325	359	508	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g
 * JD-Core Version:    0.7.0.1
 */