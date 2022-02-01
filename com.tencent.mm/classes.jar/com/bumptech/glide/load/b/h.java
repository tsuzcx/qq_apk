package com.bumptech.glide.load.b;

import android.os.Build.VERSION;
import android.support.v4.e.l.a;
import android.util.Log;
import com.bumptech.glide.g.a.a.c;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.a.b.a;
import com.bumptech.glide.load.c.n.a;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class h<R>
  implements a.c, f.a, Comparable<h<?>>, Runnable
{
  com.bumptech.glide.e aCm;
  Object aDf;
  com.bumptech.glide.load.g aFT;
  i aFV;
  final d aFY;
  com.bumptech.glide.g aGc;
  j aGd;
  final g<R> aGg;
  private final List<Throwable> aGh;
  private final b aGi;
  private final l.a<h<?>> aGj;
  final c<?> aGk;
  final e aGl;
  n aGm;
  a<R> aGn;
  private g aGo;
  f aGp;
  private long aGq;
  boolean aGr;
  private Thread aGs;
  com.bumptech.glide.load.g aGt;
  private com.bumptech.glide.load.g aGu;
  private Object aGv;
  private com.bumptech.glide.load.a aGw;
  private com.bumptech.glide.load.a.d<?> aGx;
  volatile f aGy;
  private volatile boolean aGz;
  int height;
  volatile boolean isCancelled;
  int order;
  int width;
  
  h(d paramd, l.a<h<?>> parama)
  {
    AppMethodBeat.i(76953);
    this.aGg = new g();
    this.aGh = new ArrayList();
    this.aGi = new b.a();
    this.aGk = new c();
    this.aGl = new e();
    this.aFY = paramd;
    this.aGj = parama;
    AppMethodBeat.o(76953);
  }
  
  private <Data> v<R> a(com.bumptech.glide.load.a.d<?> paramd, Data paramData, com.bumptech.glide.load.a parama)
  {
    AppMethodBeat.i(76969);
    if (paramData == null)
    {
      paramd.cleanup();
      AppMethodBeat.o(76969);
      return null;
    }
    try
    {
      long l = com.bumptech.glide.g.f.qt();
      paramData = a(paramData, parama, this.aGg.m(paramData.getClass()));
      if (Log.isLoggable("DecodeJob", 2)) {
        a("Decoded result ".concat(String.valueOf(paramData)), l, null);
      }
      return paramData;
    }
    finally
    {
      paramd.cleanup();
      AppMethodBeat.o(76969);
    }
  }
  
  private <Data, ResourceType> v<R> a(Data paramData, com.bumptech.glide.load.a parama, t<Data, ResourceType, R> paramt)
  {
    AppMethodBeat.i(76970);
    Object localObject2 = this.aFV;
    Object localObject1;
    if (Build.VERSION.SDK_INT < 26)
    {
      localObject1 = localObject2;
      paramData = this.aCm.aCn.aCV.T(paramData);
    }
    try
    {
      parama = paramt.a(paramData, (i)localObject1, this.width, this.height, new b(parama));
      return parama;
    }
    finally
    {
      boolean bool;
      paramData.cleanup();
      AppMethodBeat.o(76970);
    }
    if ((parama == com.bumptech.glide.load.a.aEJ) || (this.aGg.aGf)) {}
    for (bool = true;; bool = false)
    {
      Boolean localBoolean = (Boolean)((i)localObject2).a(com.bumptech.glide.load.d.a.h.aLf);
      if (localBoolean != null)
      {
        localObject1 = localObject2;
        if (!localBoolean.booleanValue()) {
          break;
        }
        localObject1 = localObject2;
        if (bool) {
          break;
        }
      }
      localObject1 = new i();
      ((i)localObject1).a(this.aFV);
      localObject2 = com.bumptech.glide.load.d.a.h.aLf;
      ((i)localObject1).aFa.put(localObject2, Boolean.valueOf(bool));
      break;
    }
  }
  
  private void a(v<R> paramv, com.bumptech.glide.load.a parama)
  {
    AppMethodBeat.i(76961);
    oI();
    this.aGn.c(paramv, parama);
    AppMethodBeat.o(76961);
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(76971);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append(" in ").append(com.bumptech.glide.g.f.p(paramLong)).append(", load key: ").append(this.aGm);
    if (paramString2 != null) {}
    for (paramString1 = ", ".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      localStringBuilder.append(paramString1).append(", thread: ").append(Thread.currentThread().getName());
      AppMethodBeat.o(76971);
      return;
    }
  }
  
  private void b(v<R> paramv, com.bumptech.glide.load.a parama)
  {
    AppMethodBeat.i(76968);
    if ((paramv instanceof r)) {
      ((r)paramv).initialize();
    }
    Object localObject1 = null;
    Object localObject2 = paramv;
    if (this.aGk.oL())
    {
      localObject1 = u.d(paramv);
      paramv = (v<R>)localObject1;
      localObject2 = localObject1;
      localObject1 = paramv;
    }
    a((v)localObject2, parama);
    this.aGo = g.aGR;
    try
    {
      if (this.aGk.oL()) {
        this.aGk.a(this.aFY, this.aFV);
      }
      if (localObject1 != null) {
        ((u)localObject1).unlock();
      }
      oC();
      AppMethodBeat.o(76968);
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((u)localObject1).unlock();
      }
      AppMethodBeat.o(76968);
    }
  }
  
  private void oC()
  {
    AppMethodBeat.i(76954);
    if (this.aGl.oN()) {
      oE();
    }
    AppMethodBeat.o(76954);
  }
  
  private void oD()
  {
    AppMethodBeat.i(76955);
    if (this.aGl.oO()) {
      oE();
    }
    AppMethodBeat.o(76955);
  }
  
  private f oF()
  {
    AppMethodBeat.i(76958);
    Object localObject;
    switch (1.aGB[this.aGo.ordinal()])
    {
    default: 
      localObject = new IllegalStateException("Unrecognized stage: " + this.aGo);
      AppMethodBeat.o(76958);
      throw ((Throwable)localObject);
    case 1: 
      localObject = new w(this.aGg, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 2: 
      localObject = new c(this.aGg, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 3: 
      localObject = new z(this.aGg, this);
      AppMethodBeat.o(76958);
      return localObject;
    }
    AppMethodBeat.o(76958);
    return null;
  }
  
  private void oG()
  {
    AppMethodBeat.i(76959);
    this.aGs = Thread.currentThread();
    this.aGq = com.bumptech.glide.g.f.qt();
    boolean bool1 = false;
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (this.isCancelled) {
        break;
      }
      bool2 = bool1;
      if (this.aGy == null) {
        break;
      }
      bool1 = this.aGy.ow();
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.aGo = a(this.aGo);
      this.aGy = oF();
    } while (this.aGo != g.aGQ);
    oy();
    AppMethodBeat.o(76959);
    return;
    if (((this.aGo == g.aGS) || (this.isCancelled)) && (!bool2)) {
      oH();
    }
    AppMethodBeat.o(76959);
  }
  
  private void oH()
  {
    AppMethodBeat.i(76960);
    oI();
    q localq = new q("Failed to load resource", new ArrayList(this.aGh));
    this.aGn.a(localq);
    oD();
    AppMethodBeat.o(76960);
  }
  
  private void oI()
  {
    AppMethodBeat.i(76962);
    this.aGi.qz();
    if (this.aGz)
    {
      if (this.aGh.isEmpty()) {}
      for (Object localObject = null;; localObject = (Throwable)this.aGh.get(this.aGh.size() - 1))
      {
        localObject = new IllegalStateException("Already notified", (Throwable)localObject);
        AppMethodBeat.o(76962);
        throw ((Throwable)localObject);
      }
    }
    this.aGz = true;
    AppMethodBeat.o(76962);
  }
  
  private void oJ()
  {
    AppMethodBeat.i(76967);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Retrieved data", this.aGq, "data: " + this.aGv + ", cache key: " + this.aGt + ", fetcher: " + this.aGx);
    }
    try
    {
      v localv = a(this.aGx, this.aGv, this.aGw);
      if (localv != null)
      {
        b(localv, this.aGw);
        AppMethodBeat.o(76967);
        return;
      }
    }
    catch (q localq)
    {
      for (;;)
      {
        localq.a(this.aGu, this.aGw, null);
        this.aGh.add(localq);
        Object localObject = null;
      }
      oG();
      AppMethodBeat.o(76967);
    }
  }
  
  final g a(g paramg)
  {
    AppMethodBeat.i(76963);
    for (;;)
    {
      switch (1.aGB[paramg.ordinal()])
      {
      default: 
        paramg = new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(paramg)));
        AppMethodBeat.o(76963);
        throw paramg;
      case 5: 
        if (this.aGd.oP())
        {
          paramg = g.aGO;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aGO;
        break;
      case 1: 
        if (this.aGd.oQ())
        {
          paramg = g.aGP;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aGP;
      }
    }
    if (this.aGr)
    {
      paramg = g.aGS;
      AppMethodBeat.o(76963);
      return paramg;
    }
    paramg = g.aGQ;
    AppMethodBeat.o(76963);
    return paramg;
    paramg = g.aGS;
    AppMethodBeat.o(76963);
    return paramg;
  }
  
  public final void a(com.bumptech.glide.load.g paramg, Exception paramException, com.bumptech.glide.load.a.d<?> paramd, com.bumptech.glide.load.a parama)
  {
    AppMethodBeat.i(76966);
    paramd.cleanup();
    paramException = new q("Fetching data failed", paramException);
    paramException.a(paramg, parama, paramd.os());
    this.aGh.add(paramException);
    if (Thread.currentThread() != this.aGs)
    {
      this.aGp = f.aGK;
      this.aGn.a(this);
      AppMethodBeat.o(76966);
      return;
    }
    oG();
    AppMethodBeat.o(76966);
  }
  
  public final void a(com.bumptech.glide.load.g paramg1, Object paramObject, com.bumptech.glide.load.a.d<?> paramd, com.bumptech.glide.load.a parama, com.bumptech.glide.load.g paramg2)
  {
    AppMethodBeat.i(76965);
    this.aGt = paramg1;
    this.aGv = paramObject;
    this.aGx = paramd;
    this.aGw = parama;
    this.aGu = paramg2;
    if (Thread.currentThread() != this.aGs)
    {
      this.aGp = f.aGL;
      this.aGn.a(this);
      AppMethodBeat.o(76965);
      return;
    }
    try
    {
      oJ();
      return;
    }
    finally
    {
      AppMethodBeat.o(76965);
    }
  }
  
  final void oE()
  {
    AppMethodBeat.i(76956);
    this.aGl.reset();
    this.aGk.clear();
    this.aGg.clear();
    this.aGz = false;
    this.aCm = null;
    this.aFT = null;
    this.aFV = null;
    this.aGc = null;
    this.aGm = null;
    this.aGn = null;
    this.aGo = null;
    this.aGy = null;
    this.aGs = null;
    this.aGt = null;
    this.aGv = null;
    this.aGw = null;
    this.aGx = null;
    this.aGq = 0L;
    this.isCancelled = false;
    this.aDf = null;
    this.aGh.clear();
    this.aGj.release(this);
    AppMethodBeat.o(76956);
  }
  
  public final b oK()
  {
    return this.aGi;
  }
  
  public final void oy()
  {
    AppMethodBeat.i(76964);
    this.aGp = f.aGK;
    this.aGn.a(this);
    AppMethodBeat.o(76964);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 589
    //   3: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 490	com/bumptech/glide/load/b/h:aGx	Lcom/bumptech/glide/load/a/d;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 407	com/bumptech/glide/load/b/h:isCancelled	Z
    //   15: ifeq +24 -> 39
    //   18: aload_0
    //   19: invokespecial 431	com/bumptech/glide/load/b/h:oH	()V
    //   22: aload_1
    //   23: ifnull +9 -> 32
    //   26: aload_1
    //   27: invokeinterface 147 1 0
    //   32: ldc_w 589
    //   35: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: getstatic 592	com/bumptech/glide/load/b/h$1:aGA	[I
    //   42: aload_0
    //   43: getfield 542	com/bumptech/glide/load/b/h:aGp	Lcom/bumptech/glide/load/b/h$f;
    //   46: invokevirtual 593	com/bumptech/glide/load/b/h$f:ordinal	()I
    //   49: iaload
    //   50: tableswitch	default:+233 -> 283, 1:+90->140, 2:+130->180, 3:+218->268
    //   77: aconst_null
    //   78: lshr
    //   79: dup
    //   80: new 287	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 595
    //   87: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 542	com/bumptech/glide/load/b/h:aGp	Lcom/bumptech/glide/load/b/h$f;
    //   94: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 388	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   103: astore_2
    //   104: ldc_w 589
    //   107: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_2
    //   111: athrow
    //   112: astore_2
    //   113: ldc_w 589
    //   116: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: aload_1
    //   123: ifnull +9 -> 132
    //   126: aload_1
    //   127: invokeinterface 147 1 0
    //   132: ldc_w 589
    //   135: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_2
    //   139: athrow
    //   140: aload_0
    //   141: aload_0
    //   142: getstatic 598	com/bumptech/glide/load/b/h$g:aGN	Lcom/bumptech/glide/load/b/h$g;
    //   145: invokevirtual 417	com/bumptech/glide/load/b/h:a	(Lcom/bumptech/glide/load/b/h$g;)Lcom/bumptech/glide/load/b/h$g;
    //   148: putfield 345	com/bumptech/glide/load/b/h:aGo	Lcom/bumptech/glide/load/b/h$g;
    //   151: aload_0
    //   152: aload_0
    //   153: invokespecial 419	com/bumptech/glide/load/b/h:oF	()Lcom/bumptech/glide/load/b/f;
    //   156: putfield 409	com/bumptech/glide/load/b/h:aGy	Lcom/bumptech/glide/load/b/f;
    //   159: aload_0
    //   160: invokespecial 507	com/bumptech/glide/load/b/h:oG	()V
    //   163: aload_1
    //   164: ifnull +9 -> 173
    //   167: aload_1
    //   168: invokeinterface 147 1 0
    //   173: ldc_w 589
    //   176: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: aload_0
    //   181: invokespecial 507	com/bumptech/glide/load/b/h:oG	()V
    //   184: goto -21 -> 163
    //   187: astore_2
    //   188: ldc 166
    //   190: iconst_3
    //   191: invokestatic 172	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   194: ifeq +34 -> 228
    //   197: new 287	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 600
    //   204: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: aload_0
    //   208: getfield 407	com/bumptech/glide/load/b/h:isCancelled	Z
    //   211: invokevirtual 603	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   214: ldc_w 605
    //   217: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 345	com/bumptech/glide/load/b/h:aGo	Lcom/bumptech/glide/load/b/h$g;
    //   224: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_0
    //   229: getfield 345	com/bumptech/glide/load/b/h:aGo	Lcom/bumptech/glide/load/b/h$g;
    //   232: getstatic 343	com/bumptech/glide/load/b/h$g:aGR	Lcom/bumptech/glide/load/b/h$g;
    //   235: if_acmpeq +18 -> 253
    //   238: aload_0
    //   239: getfield 119	com/bumptech/glide/load/b/h:aGh	Ljava/util/List;
    //   242: aload_2
    //   243: invokeinterface 505 2 0
    //   248: pop
    //   249: aload_0
    //   250: invokespecial 431	com/bumptech/glide/load/b/h:oH	()V
    //   253: aload_0
    //   254: getfield 407	com/bumptech/glide/load/b/h:isCancelled	Z
    //   257: ifne +18 -> 275
    //   260: ldc_w 589
    //   263: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_2
    //   267: athrow
    //   268: aload_0
    //   269: invokespecial 553	com/bumptech/glide/load/b/h:oJ	()V
    //   272: goto -109 -> 163
    //   275: ldc_w 589
    //   278: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload_2
    //   282: athrow
    //   283: goto -207 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	h
    //   10	158	1	locald	com.bumptech.glide.load.a.d
    //   103	8	2	localIllegalStateException	IllegalStateException
    //   112	8	2	localb	b
    //   121	18	2	localObject	Object
    //   187	95	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	22	112	com/bumptech/glide/load/b/b
    //   39	76	112	com/bumptech/glide/load/b/b
    //   76	112	112	com/bumptech/glide/load/b/b
    //   140	163	112	com/bumptech/glide/load/b/b
    //   180	184	112	com/bumptech/glide/load/b/b
    //   268	272	112	com/bumptech/glide/load/b/b
    //   11	22	121	finally
    //   39	76	121	finally
    //   76	112	121	finally
    //   113	121	121	finally
    //   140	163	121	finally
    //   180	184	121	finally
    //   188	228	121	finally
    //   228	253	121	finally
    //   253	268	121	finally
    //   268	272	121	finally
    //   275	283	121	finally
    //   11	22	187	java/lang/Throwable
    //   39	76	187	java/lang/Throwable
    //   76	112	187	java/lang/Throwable
    //   140	163	187	java/lang/Throwable
    //   180	184	187	java/lang/Throwable
    //   268	272	187	java/lang/Throwable
  }
  
  static abstract interface a<R>
  {
    public abstract void a(h<?> paramh);
    
    public abstract void a(q paramq);
    
    public abstract void c(v<R> paramv, com.bumptech.glide.load.a parama);
  }
  
  final class b<Z>
    implements i.a<Z>
  {
    private final com.bumptech.glide.load.a aGD;
    
    b(com.bumptech.glide.load.a parama)
    {
      this.aGD = parama;
    }
    
    public final v<Z> a(v<Z> paramv)
    {
      AppMethodBeat.i(76942);
      h localh = h.this;
      com.bumptech.glide.load.a locala = this.aGD;
      Class localClass = paramv.get().getClass();
      Object localObject2 = null;
      if (locala != com.bumptech.glide.load.a.aEJ) {
        localObject2 = localh.aGg.n(localClass);
      }
      for (Object localObject1 = ((l)localObject2).a(localh.aCm, paramv, localh.width, localh.height);; localObject1 = paramv)
      {
        if (!paramv.equals(localObject1)) {
          paramv.recycle();
        }
        int i;
        com.bumptech.glide.load.c localc;
        label166:
        Object localObject3;
        if (localh.aGg.aCm.aCn.aCU.w(((v)localObject1).oV()) != null)
        {
          i = 1;
          if (i == 0) {
            break label312;
          }
          paramv = localh.aGg.aCm.aCn.aCU.w(((v)localObject1).oV());
          if (paramv == null) {
            break label290;
          }
          localc = paramv.b(localh.aFV);
          Object localObject4 = localh.aGg;
          localObject3 = localh.aGt;
          localObject4 = ((g)localObject4).oA();
          int j = ((List)localObject4).size();
          i = 0;
          label197:
          if (i >= j) {
            break label329;
          }
          if (!((n.a)((List)localObject4).get(i)).aFO.equals(localObject3)) {
            break label322;
          }
          i = 1;
          label228:
          if (i != 0) {
            break label334;
          }
        }
        label290:
        label312:
        label322:
        label329:
        label334:
        for (boolean bool = true;; bool = false)
        {
          localObject3 = localObject1;
          if (!localh.aGd.a(bool, locala, localc)) {
            break label450;
          }
          if (paramv != null) {
            break label340;
          }
          paramv = new com.bumptech.glide.h.d(((v)localObject1).get().getClass());
          AppMethodBeat.o(76942);
          throw paramv;
          i = 0;
          break;
          paramv = new com.bumptech.glide.h.d(((v)localObject1).oV());
          AppMethodBeat.o(76942);
          throw paramv;
          localc = com.bumptech.glide.load.c.aES;
          paramv = null;
          break label166;
          i += 1;
          break label197;
          i = 0;
          break label228;
        }
        label340:
        switch (h.1.aGC[localc.ordinal()])
        {
        default: 
          paramv = new IllegalArgumentException("Unknown strategy: ".concat(String.valueOf(localc)));
          AppMethodBeat.o(76942);
          throw paramv;
        }
        for (localObject2 = new d(localh.aGt, localh.aFT);; localObject2 = new x(localh.aGg.aCm.aCo, localh.aGt, localh.aFT, localh.width, localh.height, (l)localObject2, localClass, localh.aFV))
        {
          localObject3 = u.d((v)localObject1);
          localObject1 = localh.aGk;
          ((h.c)localObject1).aFH = ((com.bumptech.glide.load.g)localObject2);
          ((h.c)localObject1).aGF = paramv;
          ((h.c)localObject1).aGG = ((u)localObject3);
          label450:
          AppMethodBeat.o(76942);
          return localObject3;
        }
      }
    }
  }
  
  static final class c<Z>
  {
    com.bumptech.glide.load.g aFH;
    k<Z> aGF;
    u<Z> aGG;
    
    final void a(h.d paramd, i parami)
    {
      AppMethodBeat.i(76943);
      try
      {
        paramd.oz().a(this.aFH, new e(this.aGF, this.aGG, parami));
        return;
      }
      finally
      {
        this.aGG.unlock();
        AppMethodBeat.o(76943);
      }
    }
    
    final void clear()
    {
      this.aFH = null;
      this.aGF = null;
      this.aGG = null;
    }
    
    final boolean oL()
    {
      return this.aGG != null;
    }
  }
  
  static abstract interface d
  {
    public abstract com.bumptech.glide.load.b.b.a oz();
  }
  
  static final class e
  {
    private boolean aGH;
    private boolean aGI;
    private boolean isReleased;
    
    private boolean aF(boolean paramBoolean)
    {
      return ((this.aGI) || (this.aGH)) && (this.isReleased);
    }
    
    final boolean oM()
    {
      try
      {
        AppMethodBeat.i(76944);
        this.isReleased = true;
        boolean bool = aF(false);
        AppMethodBeat.o(76944);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean oN()
    {
      try
      {
        AppMethodBeat.i(76945);
        this.aGH = true;
        boolean bool = aF(false);
        AppMethodBeat.o(76945);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean oO()
    {
      try
      {
        AppMethodBeat.i(76946);
        this.aGI = true;
        boolean bool = aF(false);
        AppMethodBeat.o(76946);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void reset()
    {
      try
      {
        this.aGH = false;
        this.isReleased = false;
        this.aGI = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static enum f
  {
    static
    {
      AppMethodBeat.i(76949);
      aGJ = new f("INITIALIZE", 0);
      aGK = new f("SWITCH_TO_SOURCE_SERVICE", 1);
      aGL = new f("DECODE_DATA", 2);
      aGM = new f[] { aGJ, aGK, aGL };
      AppMethodBeat.o(76949);
    }
    
    private f() {}
  }
  
  static enum g
  {
    static
    {
      AppMethodBeat.i(76952);
      aGN = new g("INITIALIZE", 0);
      aGO = new g("RESOURCE_CACHE", 1);
      aGP = new g("DATA_CACHE", 2);
      aGQ = new g("SOURCE", 3);
      aGR = new g("ENCODE", 4);
      aGS = new g("FINISHED", 5);
      aGT = new g[] { aGN, aGO, aGP, aGQ, aGR, aGS };
      AppMethodBeat.o(76952);
    }
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.h
 * JD-Core Version:    0.7.0.1
 */