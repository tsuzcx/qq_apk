package com.bumptech.glide.c.b;

import android.os.Build.VERSION;
import android.support.v4.e.l.a;
import android.util.Log;
import com.bumptech.glide.c.c.n.a;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.l;
import com.bumptech.glide.h.d;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g<R>
  implements e.a, a.c, Comparable<g<?>>, Runnable
{
  Object aAv;
  com.bumptech.glide.g aDC;
  i aDD;
  final f<R> aDG;
  private final List<Throwable> aDH;
  private final com.bumptech.glide.h.a.b aDI;
  private final l.a<g<?>> aDJ;
  final c<?> aDK;
  final e aDL;
  m aDM;
  a<R> aDN;
  private g aDO;
  f aDP;
  private long aDQ;
  boolean aDR;
  private Thread aDS;
  com.bumptech.glide.c.h aDT;
  private com.bumptech.glide.c.h aDU;
  private Object aDV;
  private com.bumptech.glide.c.a aDW;
  private com.bumptech.glide.c.a.d<?> aDX;
  public volatile e aDY;
  private volatile boolean aDZ;
  com.bumptech.glide.c.h aDt;
  j aDv;
  final d aDy;
  com.bumptech.glide.e azC;
  int height;
  public volatile boolean isCancelled;
  int order;
  int width;
  
  g(d paramd, l.a<g<?>> parama)
  {
    AppMethodBeat.i(76953);
    this.aDG = new f();
    this.aDH = new ArrayList();
    this.aDI = new b.a();
    this.aDK = new c();
    this.aDL = new e();
    this.aDy = paramd;
    this.aDJ = parama;
    AppMethodBeat.o(76953);
  }
  
  private <Data> u<R> a(com.bumptech.glide.c.a.d<?> paramd, Data paramData, com.bumptech.glide.c.a parama)
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
      long l = com.bumptech.glide.h.e.pO();
      paramData = a(paramData, parama, this.aDG.l(paramData.getClass()));
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
  
  private <Data, ResourceType> u<R> a(Data paramData, com.bumptech.glide.c.a parama, s<Data, ResourceType, R> params)
  {
    AppMethodBeat.i(76970);
    Object localObject2 = this.aDv;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject1 = localObject2;
      if (((j)localObject2).a(com.bumptech.glide.c.d.a.h.aIG) == null) {
        if (parama != com.bumptech.glide.c.a.aCa)
        {
          localObject1 = localObject2;
          if (!this.aDG.aDF) {}
        }
        else
        {
          localObject1 = new j();
          ((j)localObject1).a(this.aDv);
          localObject2 = com.bumptech.glide.c.d.a.h.aIG;
          Boolean localBoolean = Boolean.TRUE;
          ((j)localObject1).aCB.put(localObject2, localBoolean);
        }
      }
    }
    paramData = this.azC.azD.aAk.Q(paramData);
    try
    {
      parama = params.a(paramData, (j)localObject1, this.width, this.height, new b(parama));
      return parama;
    }
    finally
    {
      paramData.cleanup();
      AppMethodBeat.o(76970);
    }
  }
  
  private void a(u<R> paramu, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(76961);
    oa();
    this.aDN.c(paramu, parama);
    AppMethodBeat.o(76961);
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(76971);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append(" in ").append(com.bumptech.glide.h.e.n(paramLong)).append(", load key: ").append(this.aDM);
    if (paramString2 != null) {}
    for (paramString1 = ", ".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      localStringBuilder.append(paramString1).append(", thread: ").append(Thread.currentThread().getName());
      AppMethodBeat.o(76971);
      return;
    }
  }
  
  private void b(u<R> paramu, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(76968);
    if ((paramu instanceof q)) {
      ((q)paramu).initialize();
    }
    Object localObject1 = null;
    Object localObject2 = paramu;
    if (this.aDK.od())
    {
      localObject1 = t.d(paramu);
      paramu = (u<R>)localObject1;
      localObject2 = localObject1;
      localObject1 = paramu;
    }
    a((u)localObject2, parama);
    this.aDO = g.aEs;
    try
    {
      if (this.aDK.od()) {
        this.aDK.a(this.aDy, this.aDv);
      }
      if (localObject1 != null) {
        ((t)localObject1).unlock();
      }
      nU();
      AppMethodBeat.o(76968);
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((t)localObject1).unlock();
      }
      AppMethodBeat.o(76968);
    }
  }
  
  private void nU()
  {
    AppMethodBeat.i(76954);
    if (this.aDL.of()) {
      nW();
    }
    AppMethodBeat.o(76954);
  }
  
  private void nV()
  {
    AppMethodBeat.i(76955);
    if (this.aDL.og()) {
      nW();
    }
    AppMethodBeat.o(76955);
  }
  
  private e nX()
  {
    AppMethodBeat.i(76958);
    Object localObject;
    switch (1.aEb[this.aDO.ordinal()])
    {
    default: 
      localObject = new IllegalStateException("Unrecognized stage: " + this.aDO);
      AppMethodBeat.o(76958);
      throw ((Throwable)localObject);
    case 1: 
      localObject = new v(this.aDG, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 2: 
      localObject = new b(this.aDG, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 3: 
      localObject = new y(this.aDG, this);
      AppMethodBeat.o(76958);
      return localObject;
    }
    AppMethodBeat.o(76958);
    return null;
  }
  
  private void nY()
  {
    AppMethodBeat.i(76959);
    this.aDS = Thread.currentThread();
    this.aDQ = com.bumptech.glide.h.e.pO();
    boolean bool1 = false;
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (this.isCancelled) {
        break;
      }
      bool2 = bool1;
      if (this.aDY == null) {
        break;
      }
      bool1 = this.aDY.nO();
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.aDO = a(this.aDO);
      this.aDY = nX();
    } while (this.aDO != g.aEr);
    nQ();
    AppMethodBeat.o(76959);
    return;
    if (((this.aDO == g.aEt) || (this.isCancelled)) && (!bool2)) {
      nZ();
    }
    AppMethodBeat.o(76959);
  }
  
  private void nZ()
  {
    AppMethodBeat.i(76960);
    oa();
    p localp = new p("Failed to load resource", new ArrayList(this.aDH));
    this.aDN.a(localp);
    nV();
    AppMethodBeat.o(76960);
  }
  
  private void oa()
  {
    AppMethodBeat.i(76962);
    this.aDI.pU();
    if (this.aDZ)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Already notified");
      AppMethodBeat.o(76962);
      throw localIllegalStateException;
    }
    this.aDZ = true;
    AppMethodBeat.o(76962);
  }
  
  private void ob()
  {
    AppMethodBeat.i(76967);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Retrieved data", this.aDQ, "data: " + this.aDV + ", cache key: " + this.aDT + ", fetcher: " + this.aDX);
    }
    try
    {
      u localu = a(this.aDX, this.aDV, this.aDW);
      if (localu != null)
      {
        b(localu, this.aDW);
        AppMethodBeat.o(76967);
        return;
      }
    }
    catch (p localp)
    {
      for (;;)
      {
        localp.a(this.aDU, this.aDW, null);
        this.aDH.add(localp);
        Object localObject = null;
      }
      nY();
      AppMethodBeat.o(76967);
    }
  }
  
  final g a(g paramg)
  {
    AppMethodBeat.i(76963);
    for (;;)
    {
      switch (1.aEb[paramg.ordinal()])
      {
      default: 
        paramg = new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(paramg)));
        AppMethodBeat.o(76963);
        throw paramg;
      case 5: 
        if (this.aDD.oi())
        {
          paramg = g.aEp;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aEp;
        break;
      case 1: 
        if (this.aDD.oj())
        {
          paramg = g.aEq;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aEq;
      }
    }
    if (this.aDR)
    {
      paramg = g.aEt;
      AppMethodBeat.o(76963);
      return paramg;
    }
    paramg = g.aEr;
    AppMethodBeat.o(76963);
    return paramg;
    paramg = g.aEt;
    AppMethodBeat.o(76963);
    return paramg;
  }
  
  public final void a(com.bumptech.glide.c.h paramh, Exception paramException, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(76966);
    paramd.cleanup();
    paramException = new p("Fetching data failed", paramException);
    paramException.a(paramh, parama, paramd.nK());
    this.aDH.add(paramException);
    if (Thread.currentThread() != this.aDS)
    {
      this.aDP = f.aEl;
      this.aDN.a(this);
      AppMethodBeat.o(76966);
      return;
    }
    nY();
    AppMethodBeat.o(76966);
  }
  
  public final void a(com.bumptech.glide.c.h paramh1, Object paramObject, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama, com.bumptech.glide.c.h paramh2)
  {
    AppMethodBeat.i(76965);
    this.aDT = paramh1;
    this.aDV = paramObject;
    this.aDX = paramd;
    this.aDW = parama;
    this.aDU = paramh2;
    if (Thread.currentThread() != this.aDS)
    {
      this.aDP = f.aEm;
      this.aDN.a(this);
      AppMethodBeat.o(76965);
      return;
    }
    try
    {
      ob();
      return;
    }
    finally
    {
      AppMethodBeat.o(76965);
    }
  }
  
  public final void nQ()
  {
    AppMethodBeat.i(76964);
    this.aDP = f.aEl;
    this.aDN.a(this);
    AppMethodBeat.o(76964);
  }
  
  final void nW()
  {
    AppMethodBeat.i(76956);
    this.aDL.reset();
    this.aDK.clear();
    this.aDG.clear();
    this.aDZ = false;
    this.azC = null;
    this.aDt = null;
    this.aDv = null;
    this.aDC = null;
    this.aDM = null;
    this.aDN = null;
    this.aDO = null;
    this.aDY = null;
    this.aDS = null;
    this.aDT = null;
    this.aDV = null;
    this.aDW = null;
    this.aDX = null;
    this.aDQ = 0L;
    this.isCancelled = false;
    this.aAv = null;
    this.aDH.clear();
    this.aDJ.release(this);
    AppMethodBeat.o(76956);
  }
  
  public final com.bumptech.glide.h.a.b oc()
  {
    return this.aDI;
  }
  
  public final void run()
  {
    AppMethodBeat.i(76957);
    com.bumptech.glide.c.a.d locald = this.aDX;
    for (;;)
    {
      try
      {
        if (this.isCancelled)
        {
          nZ();
          return;
        }
        switch (1.aEa[this.aDP.ordinal()])
        {
        case 1: 
          IllegalStateException localIllegalStateException = new IllegalStateException("Unrecognized run reason: " + this.aDP);
          AppMethodBeat.o(76957);
          throw localIllegalStateException;
        }
      }
      catch (Throwable localThrowable)
      {
        if (Log.isLoggable("DecodeJob", 3)) {
          new StringBuilder("DecodeJob threw unexpectedly, isCancelled: ").append(this.isCancelled).append(", stage: ").append(this.aDO);
        }
        if (this.aDO != g.aEs)
        {
          this.aDH.add(localThrowable);
          nZ();
        }
        if (this.isCancelled) {
          break label266;
        }
        AppMethodBeat.o(76957);
        throw localThrowable;
      }
      finally
      {
        if (locald != null) {
          locald.cleanup();
        }
        AppMethodBeat.o(76957);
      }
      this.aDO = a(g.aEo);
      this.aDY = nX();
      nY();
      for (;;)
      {
        if (locald != null) {
          locald.cleanup();
        }
        AppMethodBeat.o(76957);
        return;
        nY();
        continue;
        ob();
      }
      label266:
      if (locald != null) {
        locald.cleanup();
      }
      AppMethodBeat.o(76957);
      return;
    }
  }
  
  static abstract interface a<R>
  {
    public abstract void a(g<?> paramg);
    
    public abstract void a(p paramp);
    
    public abstract void c(u<R> paramu, com.bumptech.glide.c.a parama);
  }
  
  final class b<Z>
    implements h.a<Z>
  {
    private final com.bumptech.glide.c.a aEd;
    
    b(com.bumptech.glide.c.a parama)
    {
      this.aEd = parama;
    }
    
    public final u<Z> a(u<Z> paramu)
    {
      AppMethodBeat.i(76942);
      g localg = g.this;
      com.bumptech.glide.c.a locala = this.aEd;
      Class localClass = paramu.get().getClass();
      Object localObject2 = null;
      if (locala != com.bumptech.glide.c.a.aCa) {
        localObject2 = localg.aDG.m(localClass);
      }
      for (Object localObject1 = ((com.bumptech.glide.c.m)localObject2).a(localg.azC, paramu, localg.width, localg.height);; localObject1 = paramu)
      {
        if (!paramu.equals(localObject1)) {
          paramu.recycle();
        }
        int i;
        com.bumptech.glide.c.c localc;
        label166:
        Object localObject3;
        if (localg.aDG.azC.azD.aAj.u(((u)localObject1).oo()) != null)
        {
          i = 1;
          if (i == 0) {
            break label312;
          }
          paramu = localg.aDG.azC.azD.aAj.u(((u)localObject1).oo());
          if (paramu == null) {
            break label290;
          }
          localc = paramu.b(localg.aDv);
          Object localObject4 = localg.aDG;
          localObject3 = localg.aDT;
          localObject4 = ((f)localObject4).nS();
          int j = ((List)localObject4).size();
          i = 0;
          label197:
          if (i >= j) {
            break label329;
          }
          if (!((n.a)((List)localObject4).get(i)).aDo.equals(localObject3)) {
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
          if (!localg.aDD.a(bool, locala, localc)) {
            break label450;
          }
          if (paramu != null) {
            break label340;
          }
          paramu = new h.d(((u)localObject1).get().getClass());
          AppMethodBeat.o(76942);
          throw paramu;
          i = 0;
          break;
          paramu = new h.d(((u)localObject1).oo());
          AppMethodBeat.o(76942);
          throw paramu;
          localc = com.bumptech.glide.c.c.aCk;
          paramu = null;
          break label166;
          i += 1;
          break label197;
          i = 0;
          break label228;
        }
        label340:
        switch (g.1.aEc[localc.ordinal()])
        {
        default: 
          paramu = new IllegalArgumentException("Unknown strategy: ".concat(String.valueOf(localc)));
          AppMethodBeat.o(76942);
          throw paramu;
        }
        for (localObject2 = new c(localg.aDT, localg.aDt);; localObject2 = new w(localg.aDG.azC.azE, localg.aDT, localg.aDt, localg.width, localg.height, (com.bumptech.glide.c.m)localObject2, localClass, localg.aDv))
        {
          localObject3 = t.d((u)localObject1);
          localObject1 = localg.aDK;
          ((g.c)localObject1).aDh = ((com.bumptech.glide.c.h)localObject2);
          ((g.c)localObject1).aEf = paramu;
          ((g.c)localObject1).aEg = ((t)localObject3);
          label450:
          AppMethodBeat.o(76942);
          return localObject3;
        }
      }
    }
  }
  
  static final class c<Z>
  {
    com.bumptech.glide.c.h aDh;
    l<Z> aEf;
    t<Z> aEg;
    
    final void a(g.d paramd, j paramj)
    {
      AppMethodBeat.i(76943);
      try
      {
        paramd.nR().a(this.aDh, new d(this.aEf, this.aEg, paramj));
        return;
      }
      finally
      {
        this.aEg.unlock();
        AppMethodBeat.o(76943);
      }
    }
    
    final void clear()
    {
      this.aDh = null;
      this.aEf = null;
      this.aEg = null;
    }
    
    final boolean od()
    {
      return this.aEg != null;
    }
  }
  
  static abstract interface d
  {
    public abstract com.bumptech.glide.c.b.b.a nR();
  }
  
  static final class e
  {
    private boolean aEi;
    private boolean aEj;
    private boolean isReleased;
    
    private boolean oh()
    {
      return ((this.aEj) || (this.aEi)) && (this.isReleased);
    }
    
    final boolean oe()
    {
      try
      {
        AppMethodBeat.i(76944);
        this.isReleased = true;
        boolean bool = oh();
        AppMethodBeat.o(76944);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean of()
    {
      try
      {
        AppMethodBeat.i(76945);
        this.aEi = true;
        boolean bool = oh();
        AppMethodBeat.o(76945);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean og()
    {
      try
      {
        AppMethodBeat.i(76946);
        this.aEj = true;
        boolean bool = oh();
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
        this.aEi = false;
        this.isReleased = false;
        this.aEj = false;
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
      aEk = new f("INITIALIZE", 0);
      aEl = new f("SWITCH_TO_SOURCE_SERVICE", 1);
      aEm = new f("DECODE_DATA", 2);
      aEn = new f[] { aEk, aEl, aEm };
      AppMethodBeat.o(76949);
    }
    
    private f() {}
  }
  
  static enum g
  {
    static
    {
      AppMethodBeat.i(76952);
      aEo = new g("INITIALIZE", 0);
      aEp = new g("RESOURCE_CACHE", 1);
      aEq = new g("DATA_CACHE", 2);
      aEr = new g("SOURCE", 3);
      aEs = new g("ENCODE", 4);
      aEt = new g("FINISHED", 5);
      aEu = new g[] { aEo, aEp, aEq, aEr, aEs, aEt };
      AppMethodBeat.o(76952);
    }
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.g
 * JD-Core Version:    0.7.0.1
 */