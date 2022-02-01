package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static final String zTR;
  public static final String zTW;
  private com.tencent.mm.audio.b.c hvI;
  private com.tencent.mm.audio.b.c.a hwy;
  private com.tencent.mm.audio.e.a pfA;
  private com.tencent.mm.modelvoiceaddr.a.c pfQ;
  private com.tencent.mm.modelvoiceaddr.a.c.a pfR;
  private int pfu;
  private int pfv;
  private boolean pgr;
  b zTS;
  private boolean zTT;
  private String zTU;
  private final ArrayList<com.tencent.mm.audio.b.c.a> zTV;
  public com.tencent.mm.audio.b.c.a zTX;
  
  static
  {
    AppMethodBeat.i(103814);
    zTR = k.dOX() + "/fdv_v_";
    zTW = g.aPZ().getAbsolutePath() + "/temp_debug_raw.spx";
    AppMethodBeat.o(103814);
  }
  
  public a()
  {
    AppMethodBeat.i(103811);
    this.zTS = null;
    this.pgr = true;
    this.zTT = false;
    this.zTU = "";
    this.zTV = new ArrayList(5);
    this.pfv = 0;
    this.pfu = 0;
    this.zTX = new com.tencent.mm.audio.b.c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103803);
        synchronized (a.i(a.this))
        {
          Iterator localIterator = a.i(a.this).iterator();
          while (localIterator.hasNext())
          {
            com.tencent.mm.audio.b.c.a locala = (com.tencent.mm.audio.b.c.a)localIterator.next();
            if (locala != null) {
              locala.ds(paramAnonymousInt1, paramAnonymousInt2);
            }
          }
        }
        AppMethodBeat.o(103803);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(103802);
        synchronized (a.i(a.this))
        {
          Iterator localIterator = a.i(a.this).iterator();
          while (localIterator.hasNext())
          {
            com.tencent.mm.audio.b.c.a locala = (com.tencent.mm.audio.b.c.a)localIterator.next();
            if (locala != null) {
              locala.u(paramAnonymousArrayOfByte, paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(103802);
      }
    };
    this.hwy = new com.tencent.mm.audio.b.c.a()
    {
      short[] pfS;
      
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(103805);
        Log.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + paramAnonymousInt1 + " detailState = " + paramAnonymousInt2);
        a.this.clearDiskCache();
        if (a.e(a.this) != null) {
          a.e(a.this).oc(2);
        }
        AppMethodBeat.o(103805);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int j = 0;
        AppMethodBeat.i(103804);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
        a.a(a.this, this.pfS, paramAnonymousInt / 2);
        if (a.g(a.this) != null)
        {
          a.g(a.this).f(this.pfS, paramAnonymousInt / 2);
          if (a.d(a.this) == null) {
            break label270;
          }
        }
        label270:
        for (paramAnonymousInt = a.d(a.this).a(new g.a(paramAnonymousArrayOfByte, paramAnonymousInt));; paramAnonymousInt = -1)
        {
          if ((-1 == paramAnonymousInt) && (a.e(a.this) != null))
          {
            a.e(a.this).oc(3);
            a.this.clearDiskCache();
            Log.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
            AppMethodBeat.o(103804);
            return;
          }
          AppMethodBeat.o(103804);
          return;
          if (a.e(a.this) != null)
          {
            a.e(a.this).oc(1);
            a.this.clearDiskCache();
          }
          Log.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
          AppMethodBeat.o(103804);
          return;
        }
      }
    };
    this.pfR = new com.tencent.mm.modelvoiceaddr.a.c.a()
    {
      public final void aEN()
      {
        AppMethodBeat.i(103809);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
        if (a.e(a.this) != null) {
          a.e(a.this).oc(11);
        }
        AppMethodBeat.o(103809);
      }
      
      public final void bPB()
      {
        AppMethodBeat.i(103807);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        AppMethodBeat.o(103807);
      }
      
      public final void bPC()
      {
        AppMethodBeat.i(103808);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
        if (a.e(a.this) != null) {
          a.e(a.this).dPf();
        }
        AppMethodBeat.o(103808);
      }
      
      public final void c(short[] paramAnonymousArrayOfShort, int paramAnonymousInt)
      {
        AppMethodBeat.i(103806);
        Log.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[] { paramAnonymousArrayOfShort, Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(103806);
      }
    };
    AppMethodBeat.o(103811);
  }
  
  public final void a(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(103813);
    synchronized (this.zTV)
    {
      this.zTV.add(parama);
      AppMethodBeat.o(103813);
      return;
    }
  }
  
  public final void aC(Runnable paramRunnable)
  {
    AppMethodBeat.i(271892);
    Log.i("MicroMsg.FaceVoiceRecordLogic", "start record");
    ThreadPool.post(new a(paramRunnable, (byte)0), "FaceVoice_record", 10);
    AppMethodBeat.o(271892);
  }
  
  public final void b(com.tencent.mm.audio.b.c.a parama)
  {
    AppMethodBeat.i(271896);
    synchronized (this.zTV)
    {
      this.zTV.remove(parama);
      AppMethodBeat.o(271896);
      return;
    }
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(103812);
    y.deleteFile(this.zTU);
    AppMethodBeat.o(103812);
  }
  
  public final byte[] dPe()
  {
    AppMethodBeat.i(271894);
    byte[] arrayOfByte = y.bi(this.zTU, -1, -1);
    AppMethodBeat.o(271894);
    return arrayOfByte;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(271891);
    Log.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
    this.zTS = null;
    AppMethodBeat.o(271891);
  }
  
  /* Error */
  public final void stopRecord()
  {
    // Byte code:
    //   0: ldc 208
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 100	com/tencent/mm/plugin/facedetect/d/a:zTT	Z
    //   10: ldc 163
    //   12: ldc 210
    //   14: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 128	com/tencent/mm/plugin/facedetect/d/a:hvI	Lcom/tencent/mm/audio/b/c;
    //   23: ifnull +16 -> 39
    //   26: aload_0
    //   27: getfield 128	com/tencent/mm/plugin/facedetect/d/a:hvI	Lcom/tencent/mm/audio/b/c;
    //   30: invokevirtual 216	com/tencent/mm/audio/b/c:aGH	()Z
    //   33: pop
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 128	com/tencent/mm/plugin/facedetect/d/a:hvI	Lcom/tencent/mm/audio/b/c;
    //   39: aload_0
    //   40: getfield 131	com/tencent/mm/plugin/facedetect/d/a:pfA	Lcom/tencent/mm/audio/e/a;
    //   43: ifnull +17 -> 60
    //   46: aload_0
    //   47: getfield 131	com/tencent/mm/plugin/facedetect/d/a:pfA	Lcom/tencent/mm/audio/e/a;
    //   50: invokeinterface 221 1 0
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 131	com/tencent/mm/plugin/facedetect/d/a:pfA	Lcom/tencent/mm/audio/e/a;
    //   60: aload_0
    //   61: getfield 134	com/tencent/mm/plugin/facedetect/d/a:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +20 -> 86
    //   69: aload_0
    //   70: getfield 134	com/tencent/mm/plugin/facedetect/d/a:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   73: invokevirtual 226	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 134	com/tencent/mm/plugin/facedetect/d/a:pfQ	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 98	com/tencent/mm/plugin/facedetect/d/a:pgr	Z
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 112	com/tencent/mm/plugin/facedetect/d/a:pfv	I
    //   91: aload_0
    //   92: monitorexit
    //   93: ldc 208
    //   95: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: ldc 163
    //   102: aload_1
    //   103: ldc 228
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: goto -26 -> 86
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: ldc 208
    //   120: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	a
    //   64	2	1	localc	com.tencent.mm.modelvoiceaddr.a.c
    //   99	4	1	localException	java.lang.Exception
    //   115	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	86	99	java/lang/Exception
    //   19	39	115	finally
    //   39	60	115	finally
    //   60	65	115	finally
    //   69	86	115	finally
    //   86	93	115	finally
    //   100	112	115	finally
  }
  
  final class a
    implements Runnable
  {
    private Runnable zTZ = null;
    
    private a(Runnable paramRunnable)
    {
      this.zTZ = paramRunnable;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 30
      //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   9: astore_1
      //   10: aload_1
      //   11: monitorenter
      //   12: aload_0
      //   13: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   16: invokestatic 40	com/tencent/mm/plugin/facedetect/d/a:b	(Lcom/tencent/mm/plugin/facedetect/d/a;)Z
      //   19: ifne +553 -> 572
      //   22: ldc 42
      //   24: ldc 44
      //   26: invokestatic 49	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   29: aload_0
      //   30: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   33: new 51	java/lang/StringBuilder
      //   36: dup
      //   37: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   40: invokestatic 56	com/tencent/mm/plugin/facedetect/d/a:access$200	()Ljava/lang/String;
      //   43: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: invokestatic 66	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
      //   49: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   52: ldc 71
      //   54: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   60: invokestatic 77	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;Ljava/lang/String;)Ljava/lang/String;
      //   63: pop
      //   64: ldc 42
      //   66: ldc 79
      //   68: iconst_1
      //   69: anewarray 4	java/lang/Object
      //   72: dup
      //   73: iconst_0
      //   74: aload_0
      //   75: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   78: invokestatic 82	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;)Ljava/lang/String;
      //   81: aastore
      //   82: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   85: aload_0
      //   86: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   89: invokestatic 82	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;)Ljava/lang/String;
      //   92: invokestatic 91	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
      //   95: pop
      //   96: aload_0
      //   97: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   100: new 93	com/tencent/mm/audio/b/c
      //   103: dup
      //   104: sipush 16000
      //   107: iconst_1
      //   108: iconst_3
      //   109: invokespecial 96	com/tencent/mm/audio/b/c:<init>	(III)V
      //   112: invokestatic 99	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;Lcom/tencent/mm/audio/b/c;)Lcom/tencent/mm/audio/b/c;
      //   115: pop
      //   116: aload_0
      //   117: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   120: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   123: bipush 237
      //   125: putfield 107	com/tencent/mm/audio/b/c:hwn	I
      //   128: aload_0
      //   129: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   132: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   135: iconst_0
      //   136: invokevirtual 111	com/tencent/mm/audio/b/c:eo	(Z)V
      //   139: aload_0
      //   140: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   143: new 113	com/tencent/mm/audio/e/d
      //   146: dup
      //   147: invokespecial 114	com/tencent/mm/audio/e/d:<init>	()V
      //   150: invokestatic 117	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;Lcom/tencent/mm/audio/e/a;)Lcom/tencent/mm/audio/e/a;
      //   153: pop
      //   154: aload_0
      //   155: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   158: invokestatic 121	com/tencent/mm/plugin/facedetect/d/a:d	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/e/a;
      //   161: aload_0
      //   162: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   165: invokestatic 82	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;)Ljava/lang/String;
      //   168: invokeinterface 126 2 0
      //   173: ifne +88 -> 261
      //   176: ldc 42
      //   178: ldc 128
      //   180: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   183: aload_0
      //   184: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   187: invokestatic 121	com/tencent/mm/plugin/facedetect/d/a:d	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/e/a;
      //   190: invokeinterface 134 1 0
      //   195: aload_0
      //   196: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   199: aconst_null
      //   200: invokestatic 117	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;Lcom/tencent/mm/audio/e/a;)Lcom/tencent/mm/audio/e/a;
      //   203: pop
      //   204: aload_0
      //   205: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   208: invokestatic 137	com/tencent/mm/plugin/facedetect/d/a:e	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/plugin/facedetect/d/a$b;
      //   211: ifnull +16 -> 227
      //   214: aload_0
      //   215: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   218: invokestatic 137	com/tencent/mm/plugin/facedetect/d/a:e	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/plugin/facedetect/d/a$b;
      //   221: iconst_5
      //   222: invokeinterface 142 2 0
      //   227: aload_1
      //   228: monitorexit
      //   229: ldc 30
      //   231: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   234: return
      //   235: astore_2
      //   236: ldc 42
      //   238: aload_2
      //   239: ldc 147
      //   241: iconst_0
      //   242: anewarray 4	java/lang/Object
      //   245: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   248: goto -152 -> 96
      //   251: astore_2
      //   252: aload_1
      //   253: monitorexit
      //   254: ldc 30
      //   256: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   259: aload_2
      //   260: athrow
      //   261: getstatic 157	com/tencent/mm/compatible/deviceinfo/af:lYj	Lcom/tencent/mm/compatible/deviceinfo/k;
      //   264: getfield 162	com/tencent/mm/compatible/deviceinfo/k:lUg	I
      //   267: ifle +219 -> 486
      //   270: aload_0
      //   271: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   274: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   277: getstatic 157	com/tencent/mm/compatible/deviceinfo/af:lYj	Lcom/tencent/mm/compatible/deviceinfo/k;
      //   280: getfield 162	com/tencent/mm/compatible/deviceinfo/k:lUg	I
      //   283: iconst_1
      //   284: invokevirtual 166	com/tencent/mm/audio/b/c:O	(IZ)V
      //   287: aload_0
      //   288: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   291: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   294: bipush 50
      //   296: invokevirtual 169	com/tencent/mm/audio/b/c:ok	(I)V
      //   299: aload_0
      //   300: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   303: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   306: iconst_0
      //   307: invokevirtual 172	com/tencent/mm/audio/b/c:ep	(Z)V
      //   310: aload_0
      //   311: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   314: new 174	com/tencent/mm/modelvoiceaddr/a/c
      //   317: dup
      //   318: sipush 5000
      //   321: getstatic 178	com/tencent/mm/modelvoiceaddr/a/c:sp	Landroid/content/SharedPreferences;
      //   324: ldc 180
      //   326: sipush 200
      //   329: invokeinterface 186 3 0
      //   334: getstatic 178	com/tencent/mm/modelvoiceaddr/a/c:sp	Landroid/content/SharedPreferences;
      //   337: ldc 188
      //   339: ldc 189
      //   341: invokeinterface 193 3 0
      //   346: getstatic 178	com/tencent/mm/modelvoiceaddr/a/c:sp	Landroid/content/SharedPreferences;
      //   349: ldc 195
      //   351: bipush 50
      //   353: invokeinterface 186 3 0
      //   358: getstatic 178	com/tencent/mm/modelvoiceaddr/a/c:sp	Landroid/content/SharedPreferences;
      //   361: ldc 197
      //   363: bipush 35
      //   365: invokeinterface 186 3 0
      //   370: getstatic 178	com/tencent/mm/modelvoiceaddr/a/c:sp	Landroid/content/SharedPreferences;
      //   373: ldc 199
      //   375: bipush 20
      //   377: invokeinterface 186 3 0
      //   382: iconst_0
      //   383: iconst_0
      //   384: invokespecial 202	com/tencent/mm/modelvoiceaddr/a/c:<init>	(IIFIIIZZ)V
      //   387: invokestatic 205	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/plugin/facedetect/d/a;Lcom/tencent/mm/modelvoiceaddr/a/c;)Lcom/tencent/mm/modelvoiceaddr/a/c;
      //   390: pop
      //   391: aload_0
      //   392: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   395: invokestatic 209	com/tencent/mm/plugin/facedetect/d/a:g	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/modelvoiceaddr/a/c;
      //   398: aload_0
      //   399: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   402: invokestatic 213	com/tencent/mm/plugin/facedetect/d/a:f	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/modelvoiceaddr/a/c$a;
      //   405: putfield 217	com/tencent/mm/modelvoiceaddr/a/c:pgz	Lcom/tencent/mm/modelvoiceaddr/a/c$a;
      //   408: aload_0
      //   409: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   412: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   415: aload_0
      //   416: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   419: getfield 221	com/tencent/mm/plugin/facedetect/d/a:zTX	Lcom/tencent/mm/audio/b/c$a;
      //   422: putfield 224	com/tencent/mm/audio/b/c:hwy	Lcom/tencent/mm/audio/b/c$a;
      //   425: aload_0
      //   426: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   429: aload_0
      //   430: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   433: invokestatic 228	com/tencent/mm/plugin/facedetect/d/a:h	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c$a;
      //   436: invokevirtual 231	com/tencent/mm/plugin/facedetect/d/a:a	(Lcom/tencent/mm/audio/b/c$a;)V
      //   439: aload_0
      //   440: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   443: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   446: invokevirtual 235	com/tencent/mm/audio/b/c:aGR	()Z
      //   449: ifne +104 -> 553
      //   452: ldc 42
      //   454: ldc 237
      //   456: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   459: aload_0
      //   460: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   463: invokestatic 137	com/tencent/mm/plugin/facedetect/d/a:e	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/plugin/facedetect/d/a$b;
      //   466: ifnull -239 -> 227
      //   469: aload_0
      //   470: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   473: invokestatic 137	com/tencent/mm/plugin/facedetect/d/a:e	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/plugin/facedetect/d/a$b;
      //   476: bipush 7
      //   478: invokeinterface 142 2 0
      //   483: goto -256 -> 227
      //   486: aload_0
      //   487: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   490: invokestatic 103	com/tencent/mm/plugin/facedetect/d/a:c	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/audio/b/c;
      //   493: iconst_5
      //   494: iconst_0
      //   495: invokevirtual 166	com/tencent/mm/audio/b/c:O	(IZ)V
      //   498: goto -211 -> 287
      //   501: astore_2
      //   502: ldc 42
      //   504: new 51	java/lang/StringBuilder
      //   507: dup
      //   508: ldc 239
      //   510: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   513: aload_2
      //   514: invokevirtual 247	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   517: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   520: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   523: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   526: aload_0
      //   527: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   530: invokestatic 137	com/tencent/mm/plugin/facedetect/d/a:e	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/plugin/facedetect/d/a$b;
      //   533: ifnull -125 -> 408
      //   536: aload_0
      //   537: getfield 17	com/tencent/mm/plugin/facedetect/d/a$a:zTY	Lcom/tencent/mm/plugin/facedetect/d/a;
      //   540: invokestatic 137	com/tencent/mm/plugin/facedetect/d/a:e	(Lcom/tencent/mm/plugin/facedetect/d/a;)Lcom/tencent/mm/plugin/facedetect/d/a$b;
      //   543: bipush 6
      //   545: invokeinterface 142 2 0
      //   550: goto -142 -> 408
      //   553: aload_0
      //   554: getfield 22	com/tencent/mm/plugin/facedetect/d/a$a:zTZ	Ljava/lang/Runnable;
      //   557: ifnull -330 -> 227
      //   560: aload_0
      //   561: getfield 22	com/tencent/mm/plugin/facedetect/d/a$a:zTZ	Ljava/lang/Runnable;
      //   564: invokeinterface 249 1 0
      //   569: goto -342 -> 227
      //   572: ldc 42
      //   574: ldc 251
      //   576: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   579: goto -352 -> 227
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	582	0	this	a
      //   9	244	1	locala	a
      //   235	4	2	localException	java.lang.Exception
      //   251	9	2	localObject1	Object
      //   501	13	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   85	96	235	java/lang/Exception
      //   12	85	251	finally
      //   85	96	251	finally
      //   96	227	251	finally
      //   227	229	251	finally
      //   236	248	251	finally
      //   261	287	251	finally
      //   287	310	251	finally
      //   408	483	251	finally
      //   486	498	251	finally
      //   502	550	251	finally
      //   553	569	251	finally
      //   572	579	251	finally
      //   310	408	501	finally
    }
  }
  
  public static abstract interface b
  {
    public abstract void dPf();
    
    public abstract void oc(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.a
 * JD-Core Version:    0.7.0.1
 */