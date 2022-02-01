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
  com.bumptech.glide.e aCn;
  Object aDg;
  private Thread aGA;
  com.bumptech.glide.c.h aGB;
  private com.bumptech.glide.c.h aGC;
  private Object aGD;
  private com.bumptech.glide.c.a aGE;
  private com.bumptech.glide.c.a.d<?> aGF;
  public volatile e aGG;
  private volatile boolean aGH;
  com.bumptech.glide.c.h aGb;
  j aGd;
  final d aGg;
  com.bumptech.glide.g aGk;
  i aGl;
  final f<R> aGo;
  private final List<Throwable> aGp;
  private final com.bumptech.glide.h.a.b aGq;
  private final l.a<g<?>> aGr;
  final c<?> aGs;
  final e aGt;
  m aGu;
  a<R> aGv;
  private g aGw;
  f aGx;
  private long aGy;
  boolean aGz;
  int height;
  public volatile boolean isCancelled;
  int order;
  int width;
  
  g(d paramd, l.a<g<?>> parama)
  {
    AppMethodBeat.i(76953);
    this.aGo = new f();
    this.aGp = new ArrayList();
    this.aGq = new b.a();
    this.aGs = new c();
    this.aGt = new e();
    this.aGg = paramd;
    this.aGr = parama;
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
      long l = com.bumptech.glide.h.e.qq();
      paramData = a(paramData, parama, this.aGo.l(paramData.getClass()));
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
    Object localObject2 = this.aGd;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localObject1 = localObject2;
      if (((j)localObject2).a(com.bumptech.glide.c.d.a.h.aLn) == null) {
        if (parama != com.bumptech.glide.c.a.aEJ)
        {
          localObject1 = localObject2;
          if (!this.aGo.aGn) {}
        }
        else
        {
          localObject1 = new j();
          ((j)localObject1).a(this.aGd);
          localObject2 = com.bumptech.glide.c.d.a.h.aLn;
          Boolean localBoolean = Boolean.TRUE;
          ((j)localObject1).aFk.put(localObject2, localBoolean);
        }
      }
    }
    paramData = this.aCn.aCo.aCV.T(paramData);
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
    oC();
    this.aGv.c(paramu, parama);
    AppMethodBeat.o(76961);
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(76971);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append(" in ").append(com.bumptech.glide.h.e.p(paramLong)).append(", load key: ").append(this.aGu);
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
    if (this.aGs.oF())
    {
      localObject1 = t.d(paramu);
      paramu = (u<R>)localObject1;
      localObject2 = localObject1;
      localObject1 = paramu;
    }
    a((u)localObject2, parama);
    this.aGw = g.aGZ;
    try
    {
      if (this.aGs.oF()) {
        this.aGs.a(this.aGg, this.aGd);
      }
      if (localObject1 != null) {
        ((t)localObject1).unlock();
      }
      ow();
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
  
  private void oA()
  {
    AppMethodBeat.i(76959);
    this.aGA = Thread.currentThread();
    this.aGy = com.bumptech.glide.h.e.qq();
    boolean bool1 = false;
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (this.isCancelled) {
        break;
      }
      bool2 = bool1;
      if (this.aGG == null) {
        break;
      }
      bool1 = this.aGG.oq();
      bool2 = bool1;
      if (bool1) {
        break;
      }
      this.aGw = a(this.aGw);
      this.aGG = oz();
    } while (this.aGw != g.aGY);
    os();
    AppMethodBeat.o(76959);
    return;
    if (((this.aGw == g.aHa) || (this.isCancelled)) && (!bool2)) {
      oB();
    }
    AppMethodBeat.o(76959);
  }
  
  private void oB()
  {
    AppMethodBeat.i(76960);
    oC();
    p localp = new p("Failed to load resource", new ArrayList(this.aGp));
    this.aGv.a(localp);
    ox();
    AppMethodBeat.o(76960);
  }
  
  private void oC()
  {
    AppMethodBeat.i(76962);
    this.aGq.qw();
    if (this.aGH)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Already notified");
      AppMethodBeat.o(76962);
      throw localIllegalStateException;
    }
    this.aGH = true;
    AppMethodBeat.o(76962);
  }
  
  private void oD()
  {
    AppMethodBeat.i(76967);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Retrieved data", this.aGy, "data: " + this.aGD + ", cache key: " + this.aGB + ", fetcher: " + this.aGF);
    }
    try
    {
      u localu = a(this.aGF, this.aGD, this.aGE);
      if (localu != null)
      {
        b(localu, this.aGE);
        AppMethodBeat.o(76967);
        return;
      }
    }
    catch (p localp)
    {
      for (;;)
      {
        localp.a(this.aGC, this.aGE, null);
        this.aGp.add(localp);
        Object localObject = null;
      }
      oA();
      AppMethodBeat.o(76967);
    }
  }
  
  private void ow()
  {
    AppMethodBeat.i(76954);
    if (this.aGt.oH()) {
      oy();
    }
    AppMethodBeat.o(76954);
  }
  
  private void ox()
  {
    AppMethodBeat.i(76955);
    if (this.aGt.oI()) {
      oy();
    }
    AppMethodBeat.o(76955);
  }
  
  private e oz()
  {
    AppMethodBeat.i(76958);
    Object localObject;
    switch (1.aGJ[this.aGw.ordinal()])
    {
    default: 
      localObject = new IllegalStateException("Unrecognized stage: " + this.aGw);
      AppMethodBeat.o(76958);
      throw ((Throwable)localObject);
    case 1: 
      localObject = new v(this.aGo, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 2: 
      localObject = new b(this.aGo, this);
      AppMethodBeat.o(76958);
      return localObject;
    case 3: 
      localObject = new y(this.aGo, this);
      AppMethodBeat.o(76958);
      return localObject;
    }
    AppMethodBeat.o(76958);
    return null;
  }
  
  final g a(g paramg)
  {
    AppMethodBeat.i(76963);
    for (;;)
    {
      switch (1.aGJ[paramg.ordinal()])
      {
      default: 
        paramg = new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(paramg)));
        AppMethodBeat.o(76963);
        throw paramg;
      case 5: 
        if (this.aGl.oK())
        {
          paramg = g.aGW;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aGW;
        break;
      case 1: 
        if (this.aGl.oL())
        {
          paramg = g.aGX;
          AppMethodBeat.o(76963);
          return paramg;
        }
        paramg = g.aGX;
      }
    }
    if (this.aGz)
    {
      paramg = g.aHa;
      AppMethodBeat.o(76963);
      return paramg;
    }
    paramg = g.aGY;
    AppMethodBeat.o(76963);
    return paramg;
    paramg = g.aHa;
    AppMethodBeat.o(76963);
    return paramg;
  }
  
  public final void a(com.bumptech.glide.c.h paramh, Exception paramException, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(76966);
    paramd.cleanup();
    paramException = new p("Fetching data failed", paramException);
    paramException.a(paramh, parama, paramd.om());
    this.aGp.add(paramException);
    if (Thread.currentThread() != this.aGA)
    {
      this.aGx = f.aGS;
      this.aGv.a(this);
      AppMethodBeat.o(76966);
      return;
    }
    oA();
    AppMethodBeat.o(76966);
  }
  
  public final void a(com.bumptech.glide.c.h paramh1, Object paramObject, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama, com.bumptech.glide.c.h paramh2)
  {
    AppMethodBeat.i(76965);
    this.aGB = paramh1;
    this.aGD = paramObject;
    this.aGF = paramd;
    this.aGE = parama;
    this.aGC = paramh2;
    if (Thread.currentThread() != this.aGA)
    {
      this.aGx = f.aGT;
      this.aGv.a(this);
      AppMethodBeat.o(76965);
      return;
    }
    try
    {
      oD();
      return;
    }
    finally
    {
      AppMethodBeat.o(76965);
    }
  }
  
  public final com.bumptech.glide.h.a.b oE()
  {
    return this.aGq;
  }
  
  public final void os()
  {
    AppMethodBeat.i(76964);
    this.aGx = f.aGS;
    this.aGv.a(this);
    AppMethodBeat.o(76964);
  }
  
  final void oy()
  {
    AppMethodBeat.i(76956);
    this.aGt.reset();
    this.aGs.clear();
    this.aGo.clear();
    this.aGH = false;
    this.aCn = null;
    this.aGb = null;
    this.aGd = null;
    this.aGk = null;
    this.aGu = null;
    this.aGv = null;
    this.aGw = null;
    this.aGG = null;
    this.aGA = null;
    this.aGB = null;
    this.aGD = null;
    this.aGE = null;
    this.aGF = null;
    this.aGy = 0L;
    this.isCancelled = false;
    this.aDg = null;
    this.aGp.clear();
    this.aGr.release(this);
    AppMethodBeat.o(76956);
  }
  
  public final void run()
  {
    AppMethodBeat.i(76957);
    com.bumptech.glide.c.a.d locald = this.aGF;
    for (;;)
    {
      try
      {
        if (this.isCancelled)
        {
          oB();
          return;
        }
        switch (1.aGI[this.aGx.ordinal()])
        {
        case 1: 
          IllegalStateException localIllegalStateException = new IllegalStateException("Unrecognized run reason: " + this.aGx);
          AppMethodBeat.o(76957);
          throw localIllegalStateException;
        }
      }
      catch (Throwable localThrowable)
      {
        if (Log.isLoggable("DecodeJob", 3)) {
          new StringBuilder("DecodeJob threw unexpectedly, isCancelled: ").append(this.isCancelled).append(", stage: ").append(this.aGw);
        }
        if (this.aGw != g.aGZ)
        {
          this.aGp.add(localThrowable);
          oB();
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
      this.aGw = a(g.aGV);
      this.aGG = oz();
      oA();
      for (;;)
      {
        if (locald != null) {
          locald.cleanup();
        }
        AppMethodBeat.o(76957);
        return;
        oA();
        continue;
        oD();
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
    private final com.bumptech.glide.c.a aGL;
    
    b(com.bumptech.glide.c.a parama)
    {
      this.aGL = parama;
    }
    
    public final u<Z> a(u<Z> paramu)
    {
      AppMethodBeat.i(76942);
      g localg = g.this;
      com.bumptech.glide.c.a locala = this.aGL;
      Class localClass = paramu.get().getClass();
      Object localObject2 = null;
      if (locala != com.bumptech.glide.c.a.aEJ) {
        localObject2 = localg.aGo.m(localClass);
      }
      for (Object localObject1 = ((com.bumptech.glide.c.m)localObject2).a(localg.aCn, paramu, localg.width, localg.height);; localObject1 = paramu)
      {
        if (!paramu.equals(localObject1)) {
          paramu.recycle();
        }
        int i;
        com.bumptech.glide.c.c localc;
        label166:
        Object localObject3;
        if (localg.aGo.aCn.aCo.aCU.u(((u)localObject1).oQ()) != null)
        {
          i = 1;
          if (i == 0) {
            break label312;
          }
          paramu = localg.aGo.aCn.aCo.aCU.u(((u)localObject1).oQ());
          if (paramu == null) {
            break label290;
          }
          localc = paramu.b(localg.aGd);
          Object localObject4 = localg.aGo;
          localObject3 = localg.aGB;
          localObject4 = ((f)localObject4).ou();
          int j = ((List)localObject4).size();
          i = 0;
          label197:
          if (i >= j) {
            break label329;
          }
          if (!((n.a)((List)localObject4).get(i)).aFW.equals(localObject3)) {
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
          if (!localg.aGl.a(bool, locala, localc)) {
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
          paramu = new h.d(((u)localObject1).oQ());
          AppMethodBeat.o(76942);
          throw paramu;
          localc = com.bumptech.glide.c.c.aET;
          paramu = null;
          break label166;
          i += 1;
          break label197;
          i = 0;
          break label228;
        }
        label340:
        switch (g.1.aGK[localc.ordinal()])
        {
        default: 
          paramu = new IllegalArgumentException("Unknown strategy: ".concat(String.valueOf(localc)));
          AppMethodBeat.o(76942);
          throw paramu;
        }
        for (localObject2 = new c(localg.aGB, localg.aGb);; localObject2 = new w(localg.aGo.aCn.aCp, localg.aGB, localg.aGb, localg.width, localg.height, (com.bumptech.glide.c.m)localObject2, localClass, localg.aGd))
        {
          localObject3 = t.d((u)localObject1);
          localObject1 = localg.aGs;
          ((g.c)localObject1).aFP = ((com.bumptech.glide.c.h)localObject2);
          ((g.c)localObject1).aGN = paramu;
          ((g.c)localObject1).aGO = ((t)localObject3);
          label450:
          AppMethodBeat.o(76942);
          return localObject3;
        }
      }
    }
  }
  
  static final class c<Z>
  {
    com.bumptech.glide.c.h aFP;
    l<Z> aGN;
    t<Z> aGO;
    
    final void a(g.d paramd, j paramj)
    {
      AppMethodBeat.i(76943);
      try
      {
        paramd.ot().a(this.aFP, new d(this.aGN, this.aGO, paramj));
        return;
      }
      finally
      {
        this.aGO.unlock();
        AppMethodBeat.o(76943);
      }
    }
    
    final void clear()
    {
      this.aFP = null;
      this.aGN = null;
      this.aGO = null;
    }
    
    final boolean oF()
    {
      return this.aGO != null;
    }
  }
  
  static abstract interface d
  {
    public abstract com.bumptech.glide.c.b.b.a ot();
  }
  
  static final class e
  {
    private boolean aGP;
    private boolean aGQ;
    private boolean isReleased;
    
    private boolean oJ()
    {
      return ((this.aGQ) || (this.aGP)) && (this.isReleased);
    }
    
    final boolean oG()
    {
      try
      {
        AppMethodBeat.i(76944);
        this.isReleased = true;
        boolean bool = oJ();
        AppMethodBeat.o(76944);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean oH()
    {
      try
      {
        AppMethodBeat.i(76945);
        this.aGP = true;
        boolean bool = oJ();
        AppMethodBeat.o(76945);
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean oI()
    {
      try
      {
        AppMethodBeat.i(76946);
        this.aGQ = true;
        boolean bool = oJ();
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
        this.aGP = false;
        this.isReleased = false;
        this.aGQ = false;
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
      aGR = new f("INITIALIZE", 0);
      aGS = new f("SWITCH_TO_SOURCE_SERVICE", 1);
      aGT = new f("DECODE_DATA", 2);
      aGU = new f[] { aGR, aGS, aGT };
      AppMethodBeat.o(76949);
    }
    
    private f() {}
  }
  
  static enum g
  {
    static
    {
      AppMethodBeat.i(76952);
      aGV = new g("INITIALIZE", 0);
      aGW = new g("RESOURCE_CACHE", 1);
      aGX = new g("DATA_CACHE", 2);
      aGY = new g("SOURCE", 3);
      aGZ = new g("ENCODE", 4);
      aHa = new g("FINISHED", 5);
      aHb = new g[] { aGV, aGW, aGX, aGY, aGZ, aHa };
      AppMethodBeat.o(76952);
    }
    
    private g() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.g
 * JD-Core Version:    0.7.0.1
 */