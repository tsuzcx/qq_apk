package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.util.List;

public final class g
  implements f, b
{
  private static int ckX;
  public static int gbA;
  public static int gbB;
  public static int gbC;
  private static final String gbo;
  private com.tencent.mm.audio.b.c ciR;
  private com.tencent.mm.audio.b.c.a cjD;
  private boolean gbD;
  private g.b gbE;
  private com.tencent.mm.modelvoiceaddr.a.c gbF;
  private com.tencent.mm.modelvoiceaddr.a.c.a gbG;
  private int gbb;
  private int gbq;
  private int gbr;
  private boolean gbs;
  private com.tencent.mm.audio.e.a gbw;
  private a gby;
  private int scene;
  
  static
  {
    AppMethodBeat.i(116721);
    gbA = 1;
    gbB = 2;
    gbC = 4;
    gbo = ac.eQv + "voice_temp.silk";
    ckX = 5000;
    AppMethodBeat.o(116721);
  }
  
  public g()
  {
    AppMethodBeat.i(116712);
    this.gbq = 0;
    this.gbr = 0;
    this.gbs = false;
    this.gbD = false;
    this.scene = 0;
    this.gbb = gbA;
    this.gbE = null;
    this.gby = null;
    this.cjD = new g.1(this);
    this.gbG = new g.2(this);
    AppMethodBeat.o(116712);
  }
  
  public g(int paramInt1, int paramInt2, g.b paramb)
  {
    AppMethodBeat.i(116713);
    this.gbq = 0;
    this.gbr = 0;
    this.gbs = false;
    this.gbD = false;
    this.scene = 0;
    this.gbb = gbA;
    this.gbE = null;
    this.gby = null;
    this.cjD = new g.1(this);
    this.gbG = new g.2(this);
    this.gbb = paramInt1;
    this.gbE = paramb;
    this.scene = paramInt2;
    AppMethodBeat.o(116713);
  }
  
  /* Error */
  private void l(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 132
    //   7: ldc 170
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: iload_1
    //   16: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_2
    //   23: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: aastore
    //   27: invokestatic 177	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 93	com/tencent/mm/modelvoiceaddr/g:gbD	Z
    //   37: aload_0
    //   38: getfield 120	com/tencent/mm/modelvoiceaddr/g:ciR	Lcom/tencent/mm/audio/b/c;
    //   41: ifnull +16 -> 57
    //   44: aload_0
    //   45: getfield 120	com/tencent/mm/modelvoiceaddr/g:ciR	Lcom/tencent/mm/audio/b/c;
    //   48: invokevirtual 183	com/tencent/mm/audio/b/c:Et	()Z
    //   51: pop
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 120	com/tencent/mm/modelvoiceaddr/g:ciR	Lcom/tencent/mm/audio/b/c;
    //   57: aload_0
    //   58: getfield 124	com/tencent/mm/modelvoiceaddr/g:gbw	Lcom/tencent/mm/audio/e/a;
    //   61: ifnull +17 -> 78
    //   64: aload_0
    //   65: getfield 124	com/tencent/mm/modelvoiceaddr/g:gbw	Lcom/tencent/mm/audio/e/a;
    //   68: invokeinterface 188 1 0
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 124	com/tencent/mm/modelvoiceaddr/g:gbw	Lcom/tencent/mm/audio/e/a;
    //   78: aload_0
    //   79: getfield 127	com/tencent/mm/modelvoiceaddr/g:gbF	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   82: astore 4
    //   84: aload 4
    //   86: ifnull +15 -> 101
    //   89: aload_0
    //   90: getfield 127	com/tencent/mm/modelvoiceaddr/g:gbF	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   93: invokevirtual 193	com/tencent/mm/modelvoiceaddr/a/c:release	()V
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 127	com/tencent/mm/modelvoiceaddr/g:gbF	Lcom/tencent/mm/modelvoiceaddr/a/c;
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 89	com/tencent/mm/modelvoiceaddr/g:gbr	I
    //   106: aload_0
    //   107: getfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   110: ifnull +38 -> 148
    //   113: aload_0
    //   114: getfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   117: instanceof 195
    //   120: ifeq +28 -> 148
    //   123: aload_0
    //   124: getfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   127: invokevirtual 200	com/tencent/mm/modelvoiceaddr/a:amB	()V
    //   130: getstatic 77	com/tencent/mm/modelvoiceaddr/g:gbo	Ljava/lang/String;
    //   133: invokestatic 206	com/tencent/mm/a/e:cM	(Ljava/lang/String;)I
    //   136: istore_3
    //   137: aload_0
    //   138: getfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   141: checkcast 195	com/tencent/mm/modelvoiceaddr/c
    //   144: iload_3
    //   145: invokevirtual 209	com/tencent/mm/modelvoiceaddr/c:mt	(I)V
    //   148: iload_1
    //   149: ifne +10 -> 159
    //   152: aload_0
    //   153: getfield 91	com/tencent/mm/modelvoiceaddr/g:gbs	Z
    //   156: ifne +66 -> 222
    //   159: aload_0
    //   160: monitorexit
    //   161: ldc 168
    //   163: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: astore 4
    //   169: ldc 132
    //   171: aload 4
    //   173: ldc 211
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 215	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -81 -> 101
    //   185: astore 4
    //   187: aload_0
    //   188: monitorexit
    //   189: ldc 168
    //   191: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload 4
    //   196: athrow
    //   197: astore 4
    //   199: ldc 132
    //   201: aload 4
    //   203: ldc 217
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 215	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload_0
    //   213: bipush 6
    //   215: iconst_m1
    //   216: invokevirtual 221	com/tencent/mm/modelvoiceaddr/g:cL	(II)V
    //   219: goto -71 -> 148
    //   222: aload_0
    //   223: getfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   226: ifnull +55 -> 281
    //   229: aload_0
    //   230: getfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   233: instanceof 195
    //   236: ifeq +45 -> 281
    //   239: ldc 132
    //   241: ldc 223
    //   243: iconst_1
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: iload_2
    //   250: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   253: aastore
    //   254: invokestatic 177	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: iload_2
    //   258: ifeq +13 -> 271
    //   261: aload_0
    //   262: getfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   265: checkcast 195	com/tencent/mm/modelvoiceaddr/c
    //   268: invokevirtual 226	com/tencent/mm/modelvoiceaddr/c:amH	()V
    //   271: invokestatic 232	com/tencent/mm/kernel/g:Rc	()Lcom/tencent/mm/ai/p;
    //   274: sipush 235
    //   277: aload_0
    //   278: invokevirtual 237	com/tencent/mm/ai/p:b	(ILcom/tencent/mm/ai/f;)V
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 101	com/tencent/mm/modelvoiceaddr/g:gby	Lcom/tencent/mm/modelvoiceaddr/a;
    //   286: aload_0
    //   287: iconst_0
    //   288: putfield 91	com/tencent/mm/modelvoiceaddr/g:gbs	Z
    //   291: aload_0
    //   292: monitorexit
    //   293: ldc 168
    //   295: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	g
    //   0	299	1	paramBoolean1	boolean
    //   0	299	2	paramBoolean2	boolean
    //   136	9	3	i	int
    //   82	3	4	localc	com.tencent.mm.modelvoiceaddr.a.c
    //   167	5	4	localException1	java.lang.Exception
    //   185	10	4	localObject	Object
    //   197	5	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   89	101	167	java/lang/Exception
    //   32	57	185	finally
    //   57	78	185	finally
    //   78	84	185	finally
    //   89	101	185	finally
    //   101	137	185	finally
    //   137	148	185	finally
    //   152	159	185	finally
    //   159	161	185	finally
    //   169	182	185	finally
    //   187	189	185	finally
    //   199	219	185	finally
    //   222	257	185	finally
    //   261	271	185	finally
    //   271	281	185	finally
    //   281	293	185	finally
    //   137	148	197	java/lang/Exception
  }
  
  public final void cL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116716);
    ab.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(-1) });
    if (this.gbE != null) {
      this.gbE.c(paramInt1, paramInt2, -1, -1L);
    }
    l(false, true);
    AppMethodBeat.o(116716);
  }
  
  public final void cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(116718);
    ab.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gbE = null;
    l(false, paramBoolean);
    AppMethodBeat.o(116718);
  }
  
  public final int getMaxAmplitudeRate()
  {
    int i = this.gbq;
    this.gbq = 0;
    if (i > ckX) {
      ckX = i;
    }
    return i * 100 / ckX;
  }
  
  public final void init(int paramInt1, int paramInt2, g.b paramb)
  {
    this.gbb = paramInt1;
    this.gbE = paramb;
    this.scene = paramInt2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(116715);
    String[] arrayOfString = ((a)paramm).amC();
    List localList = ((a)paramm).amF();
    long l = System.currentTimeMillis();
    int i;
    int k;
    if (arrayOfString == null)
    {
      i = -1;
      k = paramm.hashCode();
      if (this.gby != null) {
        break label160;
      }
    }
    label160:
    for (int j = -1;; j = this.gby.hashCode())
    {
      ab.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      if ((this.gby != null) && (paramm.hashCode() == this.gby.hashCode())) {
        break label172;
      }
      ab.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
      AppMethodBeat.o(116715);
      return;
      i = arrayOfString.length;
      break;
    }
    label172:
    if (this.gbE != null)
    {
      if ((paramInt2 != 0) || (paramInt1 != 0))
      {
        if ((paramString != null) && (paramString.equalsIgnoreCase("SecurityCheckError"))) {
          this.gbE.c(13, 132, -1, -1L);
        }
        for (;;)
        {
          cancel(false);
          AppMethodBeat.o(116715);
          return;
          if ((paramString != null) && (paramString.equalsIgnoreCase("ReadFileLengthError"))) {
            this.gbE.c(13, 133, -1, -1L);
          } else {
            this.gbE.c(11, paramInt1, paramInt2, ((a)paramm).amE());
          }
        }
      }
      this.gbE.b(arrayOfString, localList);
      if (((paramm instanceof c)) && (this.gbr == 0) && (((c)paramm).gaW.amQ()))
      {
        this.gbE.amO();
        cancel(false);
      }
    }
    AppMethodBeat.o(116715);
  }
  
  public final void start()
  {
    AppMethodBeat.i(116714);
    ab.i("MicroMsg.SceneVoiceInputAddr", "start record");
    d.f(new g.a(this, (byte)0), "SceneVoiceInputAddr_record");
    AppMethodBeat.o(116714);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(116717);
    ab.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (this.gbE != null)) {
      this.gbE.amK();
    }
    l(true, true);
    AppMethodBeat.o(116717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.g
 * JD-Core Version:    0.7.0.1
 */