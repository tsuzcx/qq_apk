package com.bumptech.glide.f;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.e.l.a;
import android.util.Log;
import com.bumptech.glide.c.b.j.d;
import com.bumptech.glide.c.b.k;
import com.bumptech.glide.c.b.l;
import com.bumptech.glide.c.b.p;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.a.a.a;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g<R>
  implements com.bumptech.glide.f.a.d, b, f, a.c
{
  private static final l.a<g<?>> aFv;
  private static final boolean aKO;
  private Class<R> aAs;
  private e aAt;
  private Object aAv;
  private d<R> aAw;
  private com.bumptech.glide.g aDC;
  private final com.bumptech.glide.h.a.b aDI;
  private u<R> aDj;
  private Drawable aKD;
  private int aKF;
  private int aKG;
  private Drawable aKI;
  private boolean aKN;
  private d<R> aKP;
  private c aKQ;
  private com.bumptech.glide.f.a.e<R> aKR;
  private com.bumptech.glide.f.b.c<? super R> aKS;
  private j.d aKT;
  private a aKU;
  private Drawable aKV;
  private com.bumptech.glide.e azC;
  private com.bumptech.glide.c.b.j azy;
  private Context context;
  private int height;
  private long startTime;
  private final String tag;
  private int width;
  
  static
  {
    AppMethodBeat.i(77686);
    aFv = com.bumptech.glide.h.a.a.a(new a.a() {});
    aKO = Log.isLoggable("Request", 2);
    AppMethodBeat.o(77686);
  }
  
  g()
  {
    AppMethodBeat.i(77661);
    if (aKO) {}
    for (String str = String.valueOf(super.hashCode());; str = null)
    {
      this.tag = str;
      this.aDI = new b.a();
      AppMethodBeat.o(77661);
      return;
    }
  }
  
  private void T(String paramString)
  {
    AppMethodBeat.i(77685);
    new StringBuilder().append(paramString).append(" this: ").append(this.tag);
    AppMethodBeat.o(77685);
  }
  
  public static <R> g<R> a(Context paramContext, com.bumptech.glide.e parame, Object paramObject, Class<R> paramClass, e parame1, int paramInt1, int paramInt2, com.bumptech.glide.g paramg, com.bumptech.glide.f.a.e<R> parame2, d<R> paramd1, d<R> paramd2, c paramc, com.bumptech.glide.c.b.j paramj, com.bumptech.glide.f.b.c<? super R> paramc1)
  {
    AppMethodBeat.i(77660);
    g localg2 = (g)aFv.acquire();
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = new g();
    }
    localg1.context = paramContext;
    localg1.azC = parame;
    localg1.aAv = paramObject;
    localg1.aAs = paramClass;
    localg1.aAt = parame1;
    localg1.aKG = paramInt1;
    localg1.aKF = paramInt2;
    localg1.aDC = paramg;
    localg1.aKR = parame2;
    localg1.aKP = paramd1;
    localg1.aAw = paramd2;
    localg1.aKQ = paramc;
    localg1.azy = paramj;
    localg1.aKS = paramc1;
    localg1.aKU = a.aKW;
    AppMethodBeat.o(77660);
    return localg1;
  }
  
  private void a(p paramp, int paramInt)
  {
    AppMethodBeat.i(77683);
    this.aDI.pU();
    int i = this.azC.azO;
    if (i <= paramInt)
    {
      new StringBuilder("Load failed for ").append(this.aAv).append(" with size [").append(this.width).append("x").append(this.height).append("]");
      if (i <= 4) {
        paramp.oq();
      }
    }
    this.aKT = null;
    this.aKU = a.aLa;
    this.aKN = true;
    try
    {
      if (this.aAw != null)
      {
        paramp = this.aAw;
        pG();
        if (paramp.pr()) {}
      }
      else if (this.aKP != null)
      {
        paramp = this.aKP;
        pG();
        if (paramp.pr()) {}
      }
      else
      {
        pD();
      }
      this.aKN = false;
      pI();
      AppMethodBeat.o(77683);
      return;
    }
    finally
    {
      this.aKN = false;
      AppMethodBeat.o(77683);
    }
  }
  
  private void a(u<R> paramu, R paramR, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77681);
    pG();
    this.aKU = a.aKZ;
    this.aDj = paramu;
    if (this.azC.azO <= 3) {
      new StringBuilder("Finished loading ").append(paramR.getClass().getSimpleName()).append(" from ").append(parama).append(" for ").append(this.aAv).append(" with size [").append(this.width).append("x").append(this.height).append("] in ").append(com.bumptech.glide.h.e.n(this.startTime)).append(" ms");
    }
    this.aKN = true;
    try
    {
      if (((this.aAw == null) || (!this.aAw.ps())) && ((this.aKP == null) || (!this.aKP.ps())))
      {
        this.aKS.pM();
        this.aKR.X(paramR);
      }
      this.aKN = false;
      pH();
      AppMethodBeat.o(77681);
      return;
    }
    finally
    {
      this.aKN = false;
      AppMethodBeat.o(77681);
    }
  }
  
  private Drawable dv(int paramInt)
  {
    AppMethodBeat.i(77671);
    if (this.aAt.aKK != null) {}
    for (Object localObject = this.aAt.aKK;; localObject = this.context.getTheme())
    {
      localObject = com.bumptech.glide.c.d.c.a.a(this.azC, paramInt, (Resources.Theme)localObject);
      AppMethodBeat.o(77671);
      return localObject;
    }
  }
  
  private void f(u<?> paramu)
  {
    AppMethodBeat.i(77667);
    com.bumptech.glide.c.b.j.b(paramu);
    this.aDj = null;
    AppMethodBeat.o(77667);
  }
  
  private static int g(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(77674);
    if (paramInt == -2147483648)
    {
      AppMethodBeat.o(77674);
      return paramInt;
    }
    paramInt = Math.round(paramInt * paramFloat);
    AppMethodBeat.o(77674);
    return paramInt;
  }
  
  private void pA()
  {
    AppMethodBeat.i(77664);
    if (this.aKN)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
      AppMethodBeat.o(77664);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(77664);
  }
  
  private Drawable pB()
  {
    AppMethodBeat.i(77669);
    if (this.aKD == null)
    {
      this.aKD = this.aAt.aKD;
      if ((this.aKD == null) && (this.aAt.aKE > 0)) {
        this.aKD = dv(this.aAt.aKE);
      }
    }
    Drawable localDrawable = this.aKD;
    AppMethodBeat.o(77669);
    return localDrawable;
  }
  
  private Drawable pC()
  {
    AppMethodBeat.i(77670);
    if (this.aKI == null)
    {
      this.aKI = this.aAt.aKI;
      if ((this.aKI == null) && (this.aAt.aKJ > 0)) {
        this.aKI = dv(this.aAt.aKJ);
      }
    }
    Drawable localDrawable = this.aKI;
    AppMethodBeat.o(77670);
    return localDrawable;
  }
  
  private void pD()
  {
    AppMethodBeat.i(77672);
    if (!pF())
    {
      AppMethodBeat.o(77672);
      return;
    }
    Drawable localDrawable1 = null;
    if (this.aAv == null) {
      localDrawable1 = pC();
    }
    Drawable localDrawable2 = localDrawable1;
    if (localDrawable1 == null)
    {
      if (this.aKV == null)
      {
        this.aKV = this.aAt.aKB;
        if ((this.aKV == null) && (this.aAt.aKC > 0)) {
          this.aKV = dv(this.aAt.aKC);
        }
      }
      localDrawable2 = this.aKV;
    }
    if (localDrawable2 == null) {
      pB();
    }
    AppMethodBeat.o(77672);
  }
  
  private boolean pE()
  {
    AppMethodBeat.i(77675);
    if ((this.aKQ == null) || (this.aKQ.b(this)))
    {
      AppMethodBeat.o(77675);
      return true;
    }
    AppMethodBeat.o(77675);
    return false;
  }
  
  private boolean pF()
  {
    AppMethodBeat.i(77676);
    if ((this.aKQ == null) || (this.aKQ.c(this)))
    {
      AppMethodBeat.o(77676);
      return true;
    }
    AppMethodBeat.o(77676);
    return false;
  }
  
  private boolean pG()
  {
    AppMethodBeat.i(77677);
    if ((this.aKQ == null) || (!this.aKQ.pq()))
    {
      AppMethodBeat.o(77677);
      return true;
    }
    AppMethodBeat.o(77677);
    return false;
  }
  
  private void pH()
  {
    AppMethodBeat.i(77678);
    if (this.aKQ != null) {
      this.aKQ.f(this);
    }
    AppMethodBeat.o(77678);
  }
  
  private void pI()
  {
    AppMethodBeat.i(77679);
    if (this.aKQ != null) {
      this.aKQ.g(this);
    }
    AppMethodBeat.o(77679);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(203582);
    a(paramp, 5);
    AppMethodBeat.o(203582);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77684);
    if ((paramb instanceof g))
    {
      paramb = (g)paramb;
      if ((this.aKG == paramb.aKG) && (this.aKF == paramb.aKF) && (com.bumptech.glide.h.j.f(this.aAv, paramb.aAv)) && (this.aAs.equals(paramb.aAs)) && (this.aAt.equals(paramb.aAt)) && (this.aDC == paramb.aDC)) {
        if (this.aAw != null)
        {
          if (paramb.aAw == null) {}
        }
        else {
          while (paramb.aAw == null)
          {
            AppMethodBeat.o(77684);
            return true;
          }
        }
      }
      AppMethodBeat.o(77684);
      return false;
    }
    AppMethodBeat.o(77684);
    return false;
  }
  
  public final void aX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77673);
    this.aDI.pU();
    if (aKO) {
      T("Got onSizeReady in " + com.bumptech.glide.h.e.n(this.startTime));
    }
    if (this.aKU != a.aKY)
    {
      AppMethodBeat.o(77673);
      return;
    }
    this.aKU = a.aKX;
    float f = this.aAt.aKA;
    this.width = g(paramInt1, f);
    this.height = g(paramInt2, f);
    if (aKO) {
      T("finished setup for calling load in " + com.bumptech.glide.h.e.n(this.startTime));
    }
    this.aKT = this.azy.a(this.azC, this.aAv, this.aAt.aDt, this.width, this.height, this.aAt.aDx, this.aAs, this.aDC, this.aAt.aDD, this.aAt.aDz, this.aAt.aDE, this.aAt.aDF, this.aAt.aDv, this.aAt.aDi, this.aAt.aKM, this.aAt.aFc, this.aAt.aDR, this);
    if (this.aKU != a.aKX) {
      this.aKT = null;
    }
    if (aKO) {
      T("finished onSizeReady in " + com.bumptech.glide.h.e.n(this.startTime));
    }
    AppMethodBeat.o(77673);
  }
  
  public final void begin()
  {
    AppMethodBeat.i(77663);
    pA();
    this.aDI.pU();
    this.startTime = com.bumptech.glide.h.e.pO();
    if (this.aAv == null)
    {
      if (com.bumptech.glide.h.j.aY(this.aKG, this.aKF))
      {
        this.width = this.aKG;
        this.height = this.aKF;
      }
      if (pC() == null) {}
      for (int i = 5;; i = 3)
      {
        a(new p("Received null model"), i);
        AppMethodBeat.o(77663);
        return;
      }
    }
    if (this.aKU == a.aKX)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
      AppMethodBeat.o(77663);
      throw localIllegalArgumentException;
    }
    if (this.aKU == a.aKZ)
    {
      c(this.aDj, com.bumptech.glide.c.a.aCb);
      AppMethodBeat.o(77663);
      return;
    }
    this.aKU = a.aKY;
    if (com.bumptech.glide.h.j.aY(this.aKG, this.aKF)) {
      aX(this.aKG, this.aKF);
    }
    for (;;)
    {
      if (((this.aKU == a.aKX) || (this.aKU == a.aKY)) && (pF())) {
        pB();
      }
      if (aKO) {
        T("finished run method in " + com.bumptech.glide.h.e.n(this.startTime));
      }
      AppMethodBeat.o(77663);
      return;
      this.aKR.a(this);
    }
  }
  
  public final void c(u<?> paramu, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77680);
    this.aDI.pU();
    this.aKT = null;
    if (paramu == null)
    {
      a(new p("Expected to receive a Resource<R> with an object of " + this.aAs + " inside, but instead got null."), 5);
      AppMethodBeat.o(77680);
      return;
    }
    Object localObject = paramu.get();
    if ((localObject == null) || (!this.aAs.isAssignableFrom(localObject.getClass())))
    {
      f(paramu);
      StringBuilder localStringBuilder = new StringBuilder("Expected to receive an object of ").append(this.aAs).append(" but instead got ");
      if (localObject != null)
      {
        parama = localObject.getClass();
        parama = localStringBuilder.append(parama).append("{").append(localObject).append("} inside Resource{").append(paramu).append("}.");
        if (localObject == null) {
          break label206;
        }
      }
      label206:
      for (paramu = "";; paramu = " To indicate failure return a null Resource object, rather than a Resource object containing null data.")
      {
        a(new p(paramu), 5);
        AppMethodBeat.o(77680);
        return;
        parama = "";
        break;
      }
    }
    if (!pE())
    {
      f(paramu);
      this.aKU = a.aKZ;
      AppMethodBeat.o(77680);
      return;
    }
    a(paramu, localObject, parama);
    AppMethodBeat.o(77680);
  }
  
  public final void clear()
  {
    int j = 1;
    AppMethodBeat.i(77665);
    com.bumptech.glide.h.j.pQ();
    pA();
    this.aDI.pU();
    if (this.aKU == a.aLc)
    {
      AppMethodBeat.o(77665);
      return;
    }
    pA();
    this.aDI.pU();
    this.aKU = a.aLb;
    Object localObject;
    k localk;
    if (this.aKT != null)
    {
      localObject = this.aKT;
      localk = ((j.d)localObject).aEV;
      localObject = ((j.d)localObject).aEW;
      com.bumptech.glide.h.j.pQ();
      localk.aDI.pU();
      if ((localk.aFd) || (localk.aFf))
      {
        if (localk.aFg == null) {
          localk.aFg = new ArrayList(2);
        }
        if (!localk.aFg.contains(localObject)) {
          localk.aFg.add(localObject);
        }
        this.aKT = null;
      }
    }
    else
    {
      if (this.aDj != null) {
        f(this.aDj);
      }
      i = j;
      if (this.aKQ != null) {
        if (!this.aKQ.d(this)) {
          break label317;
        }
      }
    }
    label317:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        pB();
      }
      this.aKU = a.aLc;
      AppMethodBeat.o(77665);
      return;
      localk.aEZ.remove(localObject);
      if ((!localk.aEZ.isEmpty()) || (localk.aFf) || (localk.aFd) || (localk.isCancelled)) {
        break;
      }
      localk.isCancelled = true;
      localObject = localk.aFi;
      ((com.bumptech.glide.c.b.g)localObject).isCancelled = true;
      localObject = ((com.bumptech.glide.c.b.g)localObject).aDY;
      if (localObject != null) {
        ((com.bumptech.glide.c.b.e)localObject).cancel();
      }
      localk.aER.a(localk, localk.aDh);
      break;
    }
  }
  
  public final boolean isCancelled()
  {
    return (this.aKU == a.aLb) || (this.aKU == a.aLc);
  }
  
  public final boolean isComplete()
  {
    return this.aKU == a.aKZ;
  }
  
  public final boolean isFailed()
  {
    return this.aKU == a.aLa;
  }
  
  public final boolean isRunning()
  {
    return (this.aKU == a.aKX) || (this.aKU == a.aKY);
  }
  
  public final com.bumptech.glide.h.a.b oc()
  {
    return this.aDI;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(77666);
    clear();
    this.aKU = a.aLd;
    AppMethodBeat.o(77666);
  }
  
  public final boolean pp()
  {
    AppMethodBeat.i(77668);
    boolean bool = isComplete();
    AppMethodBeat.o(77668);
    return bool;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77662);
    pA();
    this.context = null;
    this.azC = null;
    this.aAv = null;
    this.aAs = null;
    this.aAt = null;
    this.aKG = -1;
    this.aKF = -1;
    this.aKR = null;
    this.aAw = null;
    this.aKP = null;
    this.aKQ = null;
    this.aKS = null;
    this.aKT = null;
    this.aKV = null;
    this.aKD = null;
    this.aKI = null;
    this.width = -1;
    this.height = -1;
    aFv.release(this);
    AppMethodBeat.o(77662);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(77659);
      aKW = new a("PENDING", 0);
      aKX = new a("RUNNING", 1);
      aKY = new a("WAITING_FOR_SIZE", 2);
      aKZ = new a("COMPLETE", 3);
      aLa = new a("FAILED", 4);
      aLb = new a("CANCELLED", 5);
      aLc = new a("CLEARED", 6);
      aLd = new a("PAUSED", 7);
      aLe = new a[] { aKW, aKX, aKY, aKZ, aLa, aLb, aLc, aLd };
      AppMethodBeat.o(77659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.f.g
 * JD-Core Version:    0.7.0.1
 */