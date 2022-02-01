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
  com.bumptech.glide.e aAw;
  Object aBp;
  private final l.a<g<?>> aEA;
  final c<?> aEB;
  final e aEC;
  m aED;
  a<R> aEE;
  private g aEF;
  f aEG;
  private long aEH;
  boolean aEI;
  private Thread aEJ;
  com.bumptech.glide.c.h aEK;
  private com.bumptech.glide.c.h aEL;
  private Object aEM;
  private com.bumptech.glide.c.a aEN;
  private com.bumptech.glide.c.a.d<?> aEO;
  public volatile e aEP;
  private volatile boolean aEQ;
  com.bumptech.glide.c.h aEk;
  j aEm;
  final d aEp;
  com.bumptech.glide.g aEt;
  i aEu;
  final f<R> aEx;
  private final List<Throwable> aEy;
  private final com.bumptech.glide.h.a.b aEz;
  int height;
  public volatile boolean isCancelled;
  int order;
  int width;
  
  g(d paramd, l.a<g<?>> parama)
  {
    AppMethodBeat.i(76953);
    this.aEx = new f();
    this.aEy = new ArrayList();
    this.aEz = new b.a();
    this.aEB = new c();
    this.aEC = new e();
    this.aEp = paramd;
    this.aEA = parama;
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
      long l = com.bumptech.glide.h.e.pY();
      paramData = a(paramData, parama, this.aEx.l(paramData.getClass()));
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
    Object localObject2 = this.aEm;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject1 = localObject2;
      if (((j)localObject2).a(com.bumptech.glide.c.d.a.h.aJw) == null) {
        if (parama != com.bumptech.glide.c.a.aCS)
        {
          localObject1 = localObject2;
          if (!this.aEx.aEw) {}
        }
        else
        {
          localObject1 = new j();
          ((j)localObject1).a(this.aEm);
          localObject2 = com.bumptech.glide.c.d.a.h.aJw;
          Boolean localBoolean = Boolean.TRUE;
          ((j)localObject1).aDt.put(localObject2, localBoolean);
        }
      }
    }
    paramData = this.aAw.aAx.aBe.S(paramData);
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
    ok();
    this.aEE.c(paramu, parama);
    AppMethodBeat.o(76961);
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(76971);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append(" in ").append(com.bumptech.glide.h.e.p(paramLong)).append(", load key: ").append(this.aED);
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
    if (this.aEB.on())
    {
      localObject1 = t.d(paramu);
      paramu = (u<R>)localObject1;
      localObject2 = localObject1;
      localObject1 = paramu;
    }
    a((u)localObject2, parama);
    this.aEF = g.aFi;
    try
    {
      if (this.aEB.on()) {
        this.aEB.a(this.aEp, this.aEm);
      }
      if (localObject1 != null) {
        ((t)localObject1).unlock();
      }
      oe();
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
  
  private void oe()
  {
    AppMethodBeat.i(76954);
    if (this.aEC.op()) {
      og();
    }
    AppMethodBeat.o(76954);
  }
  
  private void of()
  {
    AppMethodBeat.i(76955);
    if (this.aEC.oq()) {
      og();
    }
    AppMethodBeat.o(76955);
  }
  
  private e oh()
  {
    AppMethodBeat.i(76958);
    Object localObject;
    switch (1.aES[this.aEF.ordinal()])
    {
    default: 
      localObject = new IllegalStateException("Unrecognized stage: " + this.aEF);
      AppMethodBeat.o(76958);
      throw ((Throwable)localObject);
    case 1: 
      localObject = new v(this.aEx, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 2: 
      localObject = new b(this.aEx, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 3: 
      localObject = new y(this.aEx, this);
      AppMethodBeat.o(76958);
      return localObject;
    }
    AppMethodBeat.o(76958);
    return null;
  }
  
  private void oi()
  {
    AppMethodBeat.i(76959);
    this.aEJ = Thread.currentThread();
    this.aEH = com.bumptech.glide.h.e.pY();
    boolean bool1 = false;
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (this.isCancelled) {
        break;
      }
      bool2 = bool1;
      if (this.aEP == null) {
        break;
      }
      bool1 = this.aEP.nY();
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.aEF = a(this.aEF);
      this.aEP = oh();
    } while (this.aEF != g.aFh);
    oa();
    AppMethodBeat.o(76959);
    return;
    if (((this.aEF == g.aFj) || (this.isCancelled)) && (!bool2)) {
      oj();
    }
    AppMethodBeat.o(76959);
  }
  
  private void oj()
  {
    AppMethodBeat.i(76960);
    ok();
    p localp = new p("Failed to load resource", new ArrayList(this.aEy));
    this.aEE.a(localp);
    of();
    AppMethodBeat.o(76960);
  }
  
  private void ok()
  {
    AppMethodBeat.i(76962);
    this.aEz.qe();
    if (this.aEQ)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Already notified");
      AppMethodBeat.o(76962);
      throw localIllegalStateException;
    }
    this.aEQ = true;
    AppMethodBeat.o(76962);
  }
  
  private void ol()
  {
    AppMethodBeat.i(76967);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Retrieved data", this.aEH, "data: " + this.aEM + ", cache key: " + this.aEK + ", fetcher: " + this.aEO);
    }
    try
    {
      u localu = a(this.aEO, this.aEM, this.aEN);
      if (localu != null)
      {
        b(localu, this.aEN);
        AppMethodBeat.o(76967);
        return;
      }
    }
    catch (p localp)
    {
      for (;;)
      {
        localp.a(this.aEL, this.aEN, null);
        this.aEy.add(localp);
        Object localObject = null;
      }
      oi();
      AppMethodBeat.o(76967);
    }
  }
  
  final g a(g paramg)
  {
    AppMethodBeat.i(76963);
    for (;;)
    {
      switch (1.aES[paramg.ordinal()])
      {
      default: 
        paramg = new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(paramg)));
        AppMethodBeat.o(76963);
        throw paramg;
      case 5: 
        if (this.aEu.os())
        {
          paramg = g.aFf;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aFf;
        break;
      case 1: 
        if (this.aEu.ot())
        {
          paramg = g.aFg;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aFg;
      }
    }
    if (this.aEI)
    {
      paramg = g.aFj;
      AppMethodBeat.o(76963);
      return paramg;
    }
    paramg = g.aFh;
    AppMethodBeat.o(76963);
    return paramg;
    paramg = g.aFj;
    AppMethodBeat.o(76963);
    return paramg;
  }
  
  public final void a(com.bumptech.glide.c.h paramh, Exception paramException, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(76966);
    paramd.cleanup();
    paramException = new p("Fetching data failed", paramException);
    paramException.a(paramh, parama, paramd.nU());
    this.aEy.add(paramException);
    if (Thread.currentThread() != this.aEJ)
    {
      this.aEG = f.aFb;
      this.aEE.a(this);
      AppMethodBeat.o(76966);
      return;
    }
    oi();
    AppMethodBeat.o(76966);
  }
  
  public final void a(com.bumptech.glide.c.h paramh1, Object paramObject, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama, com.bumptech.glide.c.h paramh2)
  {
    AppMethodBeat.i(76965);
    this.aEK = paramh1;
    this.aEM = paramObject;
    this.aEO = paramd;
    this.aEN = parama;
    this.aEL = paramh2;
    if (Thread.currentThread() != this.aEJ)
    {
      this.aEG = f.aFc;
      this.aEE.a(this);
      AppMethodBeat.o(76965);
      return;
    }
    try
    {
      ol();
      return;
    }
    finally
    {
      AppMethodBeat.o(76965);
    }
  }
  
  public final void oa()
  {
    AppMethodBeat.i(76964);
    this.aEG = f.aFb;
    this.aEE.a(this);
    AppMethodBeat.o(76964);
  }
  
  final void og()
  {
    AppMethodBeat.i(76956);
    this.aEC.reset();
    this.aEB.clear();
    this.aEx.clear();
    this.aEQ = false;
    this.aAw = null;
    this.aEk = null;
    this.aEm = null;
    this.aEt = null;
    this.aED = null;
    this.aEE = null;
    this.aEF = null;
    this.aEP = null;
    this.aEJ = null;
    this.aEK = null;
    this.aEM = null;
    this.aEN = null;
    this.aEO = null;
    this.aEH = 0L;
    this.isCancelled = false;
    this.aBp = null;
    this.aEy.clear();
    this.aEA.release(this);
    AppMethodBeat.o(76956);
  }
  
  public final com.bumptech.glide.h.a.b om()
  {
    return this.aEz;
  }
  
  public final void run()
  {
    AppMethodBeat.i(76957);
    com.bumptech.glide.c.a.d locald = this.aEO;
    for (;;)
    {
      try
      {
        if (this.isCancelled)
        {
          oj();
          return;
        }
        switch (1.aER[this.aEG.ordinal()])
        {
        case 1: 
          IllegalStateException localIllegalStateException = new IllegalStateException("Unrecognized run reason: " + this.aEG);
          AppMethodBeat.o(76957);
          throw localIllegalStateException;
        }
      }
      catch (Throwable localThrowable)
      {
        if (Log.isLoggable("DecodeJob", 3)) {
          new StringBuilder("DecodeJob threw unexpectedly, isCancelled: ").append(this.isCancelled).append(", stage: ").append(this.aEF);
        }
        if (this.aEF != g.aFi)
        {
          this.aEy.add(localThrowable);
          oj();
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
      this.aEF = a(g.aFe);
      this.aEP = oh();
      oi();
      for (;;)
      {
        if (locald != null) {
          locald.cleanup();
        }
        AppMethodBeat.o(76957);
        return;
        oi();
        continue;
        ol();
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
    private final com.bumptech.glide.c.a aEU;
    
    b(com.bumptech.glide.c.a parama)
    {
      this.aEU = parama;
    }
    
    public final u<Z> a(u<Z> paramu)
    {
      AppMethodBeat.i(76942);
      g localg = g.this;
      com.bumptech.glide.c.a locala = this.aEU;
      Class localClass = paramu.get().getClass();
      Object localObject2 = null;
      if (locala != com.bumptech.glide.c.a.aCS) {
        localObject2 = localg.aEx.m(localClass);
      }
      for (Object localObject1 = ((com.bumptech.glide.c.m)localObject2).a(localg.aAw, paramu, localg.width, localg.height);; localObject1 = paramu)
      {
        if (!paramu.equals(localObject1)) {
          paramu.recycle();
        }
        int i;
        com.bumptech.glide.c.c localc;
        label166:
        Object localObject3;
        if (localg.aEx.aAw.aAx.aBd.u(((u)localObject1).oy()) != null)
        {
          i = 1;
          if (i == 0) {
            break label312;
          }
          paramu = localg.aEx.aAw.aAx.aBd.u(((u)localObject1).oy());
          if (paramu == null) {
            break label290;
          }
          localc = paramu.b(localg.aEm);
          Object localObject4 = localg.aEx;
          localObject3 = localg.aEK;
          localObject4 = ((f)localObject4).oc();
          int j = ((List)localObject4).size();
          i = 0;
          label197:
          if (i >= j) {
            break label329;
          }
          if (!((n.a)((List)localObject4).get(i)).aEf.equals(localObject3)) {
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
          if (!localg.aEu.a(bool, locala, localc)) {
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
          paramu = new h.d(((u)localObject1).oy());
          AppMethodBeat.o(76942);
          throw paramu;
          localc = com.bumptech.glide.c.c.aDc;
          paramu = null;
          break label166;
          i += 1;
          break label197;
          i = 0;
          break label228;
        }
        label340:
        switch (g.1.aET[localc.ordinal()])
        {
        default: 
          paramu = new IllegalArgumentException("Unknown strategy: ".concat(String.valueOf(localc)));
          AppMethodBeat.o(76942);
          throw paramu;
        }
        for (localObject2 = new c(localg.aEK, localg.aEk);; localObject2 = new w(localg.aEx.aAw.aAy, localg.aEK, localg.aEk, localg.width, localg.height, (com.bumptech.glide.c.m)localObject2, localClass, localg.aEm))
        {
          localObject3 = t.d((u)localObject1);
          localObject1 = localg.aEB;
          ((g.c)localObject1).aDY = ((com.bumptech.glide.c.h)localObject2);
          ((g.c)localObject1).aEW = paramu;
          ((g.c)localObject1).aEX = ((t)localObject3);
          label450:
          AppMethodBeat.o(76942);
          return localObject3;
        }
      }
    }
  }
  
  static final class c<Z>
  {
    com.bumptech.glide.c.h aDY;
    l<Z> aEW;
    t<Z> aEX;
    
    final void a(g.d paramd, j paramj)
    {
      AppMethodBeat.i(76943);
      try
      {
        paramd.ob().a(this.aDY, new d(this.aEW, this.aEX, paramj));
        return;
      }
      finally
      {
        this.aEX.unlock();
        AppMethodBeat.o(76943);
      }
    }
    
    final void clear()
    {
      this.aDY = null;
      this.aEW = null;
      this.aEX = null;
    }
    
    final boolean on()
    {
      return this.aEX != null;
    }
  }
  
  static abstract interface d
  {
    public abstract com.bumptech.glide.c.b.b.a ob();
  }
  
  static final class e
  {
    private boolean aEY;
    private boolean aEZ;
    private boolean isReleased;
    
    private boolean or()
    {
      return ((this.aEZ) || (this.aEY)) && (this.isReleased);
    }
    
    final boolean oo()
    {
      try
      {
        AppMethodBeat.i(76944);
        this.isReleased = true;
        boolean bool = or();
        AppMethodBeat.o(76944);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean op()
    {
      try
      {
        AppMethodBeat.i(76945);
        this.aEY = true;
        boolean bool = or();
        AppMethodBeat.o(76945);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean oq()
    {
      try
      {
        AppMethodBeat.i(76946);
        this.aEZ = true;
        boolean bool = or();
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
        this.aEY = false;
        this.isReleased = false;
        this.aEZ = false;
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
      aFa = new f("INITIALIZE", 0);
      aFb = new f("SWITCH_TO_SOURCE_SERVICE", 1);
      aFc = new f("DECODE_DATA", 2);
      aFd = new f[] { aFa, aFb, aFc };
      AppMethodBeat.o(76949);
    }
    
    private f() {}
  }
  
  static enum g
  {
    static
    {
      AppMethodBeat.i(76952);
      aFe = new g("INITIALIZE", 0);
      aFf = new g("RESOURCE_CACHE", 1);
      aFg = new g("DATA_CACHE", 2);
      aFh = new g("SOURCE", 3);
      aFi = new g("ENCODE", 4);
      aFj = new g("FINISHED", 5);
      aFk = new g[] { aFe, aFf, aFg, aFh, aFi, aFj };
      AppMethodBeat.o(76952);
    }
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.g
 * JD-Core Version:    0.7.0.1
 */