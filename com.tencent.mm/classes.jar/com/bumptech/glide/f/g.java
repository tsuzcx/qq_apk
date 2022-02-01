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
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g<R>
  implements com.bumptech.glide.f.a.d, b, f, a.c
{
  private static final l.a<g<?>> aGl;
  private static final boolean aLE;
  private com.bumptech.glide.c.b.j aAs;
  private com.bumptech.glide.e aAw;
  private Class<R> aBm;
  private e aBn;
  private Object aBp;
  private d<R> aBq;
  private u<R> aEa;
  private com.bumptech.glide.g aEt;
  private final com.bumptech.glide.h.a.b aEz;
  private boolean aLD;
  private d<R> aLF;
  private c aLG;
  private com.bumptech.glide.f.a.e<R> aLH;
  private com.bumptech.glide.f.b.c<? super R> aLI;
  private j.d aLJ;
  private a aLK;
  private Drawable aLL;
  private Drawable aLt;
  private int aLv;
  private int aLw;
  private Drawable aLy;
  private Context context;
  private int height;
  private long startTime;
  private final String tag;
  private int width;
  
  static
  {
    AppMethodBeat.i(77686);
    aGl = com.bumptech.glide.h.a.a.a(new g.1());
    aLE = Log.isLoggable("Request", 2);
    AppMethodBeat.o(77686);
  }
  
  g()
  {
    AppMethodBeat.i(77661);
    if (aLE) {}
    for (String str = String.valueOf(super.hashCode());; str = null)
    {
      this.tag = str;
      this.aEz = new b.a();
      AppMethodBeat.o(77661);
      return;
    }
  }
  
  private void V(String paramString)
  {
    AppMethodBeat.i(77685);
    new StringBuilder().append(paramString).append(" this: ").append(this.tag);
    AppMethodBeat.o(77685);
  }
  
  public static <R> g<R> a(Context paramContext, com.bumptech.glide.e parame, Object paramObject, Class<R> paramClass, e parame1, int paramInt1, int paramInt2, com.bumptech.glide.g paramg, com.bumptech.glide.f.a.e<R> parame2, d<R> paramd1, d<R> paramd2, c paramc, com.bumptech.glide.c.b.j paramj, com.bumptech.glide.f.b.c<? super R> paramc1)
  {
    AppMethodBeat.i(77660);
    g localg2 = (g)aGl.acquire();
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = new g();
    }
    localg1.context = paramContext;
    localg1.aAw = parame;
    localg1.aBp = paramObject;
    localg1.aBm = paramClass;
    localg1.aBn = parame1;
    localg1.aLw = paramInt1;
    localg1.aLv = paramInt2;
    localg1.aEt = paramg;
    localg1.aLH = parame2;
    localg1.aLF = paramd1;
    localg1.aBq = paramd2;
    localg1.aLG = paramc;
    localg1.aAs = paramj;
    localg1.aLI = paramc1;
    localg1.aLK = a.aLM;
    AppMethodBeat.o(77660);
    return localg1;
  }
  
  private void a(p paramp, int paramInt)
  {
    AppMethodBeat.i(77683);
    this.aEz.qe();
    int i = this.aAw.aAI;
    if (i <= paramInt)
    {
      new StringBuilder("Load failed for ").append(this.aBp).append(" with size [").append(this.width).append("x").append(this.height).append("]");
      if (i <= 4) {
        paramp.oA();
      }
    }
    this.aLJ = null;
    this.aLK = a.aLQ;
    this.aLD = true;
    try
    {
      if (this.aBq != null)
      {
        paramp = this.aBq;
        pQ();
        if (paramp.pB()) {}
      }
      else if (this.aLF != null)
      {
        paramp = this.aLF;
        pQ();
        if (paramp.pB()) {}
      }
      else
      {
        pN();
      }
      this.aLD = false;
      pS();
      AppMethodBeat.o(77683);
      return;
    }
    finally
    {
      this.aLD = false;
      AppMethodBeat.o(77683);
    }
  }
  
  private void a(u<R> paramu, R paramR, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77681);
    pQ();
    this.aLK = a.aLP;
    this.aEa = paramu;
    if (this.aAw.aAI <= 3) {
      new StringBuilder("Finished loading ").append(paramR.getClass().getSimpleName()).append(" from ").append(parama).append(" for ").append(this.aBp).append(" with size [").append(this.width).append("x").append(this.height).append("] in ").append(com.bumptech.glide.h.e.p(this.startTime)).append(" ms");
    }
    this.aLD = true;
    try
    {
      if (((this.aBq == null) || (!this.aBq.pC())) && ((this.aLF == null) || (!this.aLF.pC())))
      {
        this.aLI.pW();
        this.aLH.Z(paramR);
      }
      this.aLD = false;
      pR();
      AppMethodBeat.o(77681);
      return;
    }
    finally
    {
      this.aLD = false;
      AppMethodBeat.o(77681);
    }
  }
  
  private Drawable du(int paramInt)
  {
    AppMethodBeat.i(77671);
    if (this.aBn.aLA != null) {}
    for (Object localObject = this.aBn.aLA;; localObject = this.context.getTheme())
    {
      localObject = com.bumptech.glide.c.d.c.a.a(this.aAw, paramInt, (Resources.Theme)localObject);
      AppMethodBeat.o(77671);
      return localObject;
    }
  }
  
  private void f(u<?> paramu)
  {
    AppMethodBeat.i(77667);
    com.bumptech.glide.c.b.j.b(paramu);
    this.aEa = null;
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
  
  private void pK()
  {
    AppMethodBeat.i(77664);
    if (this.aLD)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
      AppMethodBeat.o(77664);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(77664);
  }
  
  private Drawable pL()
  {
    AppMethodBeat.i(77669);
    if (this.aLt == null)
    {
      this.aLt = this.aBn.aLt;
      if ((this.aLt == null) && (this.aBn.aLu > 0)) {
        this.aLt = du(this.aBn.aLu);
      }
    }
    Drawable localDrawable = this.aLt;
    AppMethodBeat.o(77669);
    return localDrawable;
  }
  
  private Drawable pM()
  {
    AppMethodBeat.i(77670);
    if (this.aLy == null)
    {
      this.aLy = this.aBn.aLy;
      if ((this.aLy == null) && (this.aBn.aLz > 0)) {
        this.aLy = du(this.aBn.aLz);
      }
    }
    Drawable localDrawable = this.aLy;
    AppMethodBeat.o(77670);
    return localDrawable;
  }
  
  private void pN()
  {
    AppMethodBeat.i(77672);
    if (!pP())
    {
      AppMethodBeat.o(77672);
      return;
    }
    Drawable localDrawable1 = null;
    if (this.aBp == null) {
      localDrawable1 = pM();
    }
    Drawable localDrawable2 = localDrawable1;
    if (localDrawable1 == null)
    {
      if (this.aLL == null)
      {
        this.aLL = this.aBn.aLr;
        if ((this.aLL == null) && (this.aBn.aLs > 0)) {
          this.aLL = du(this.aBn.aLs);
        }
      }
      localDrawable2 = this.aLL;
    }
    if (localDrawable2 == null) {
      pL();
    }
    AppMethodBeat.o(77672);
  }
  
  private boolean pO()
  {
    AppMethodBeat.i(77675);
    if ((this.aLG == null) || (this.aLG.b(this)))
    {
      AppMethodBeat.o(77675);
      return true;
    }
    AppMethodBeat.o(77675);
    return false;
  }
  
  private boolean pP()
  {
    AppMethodBeat.i(77676);
    if ((this.aLG == null) || (this.aLG.c(this)))
    {
      AppMethodBeat.o(77676);
      return true;
    }
    AppMethodBeat.o(77676);
    return false;
  }
  
  private boolean pQ()
  {
    AppMethodBeat.i(77677);
    if ((this.aLG == null) || (!this.aLG.pA()))
    {
      AppMethodBeat.o(77677);
      return true;
    }
    AppMethodBeat.o(77677);
    return false;
  }
  
  private void pR()
  {
    AppMethodBeat.i(77678);
    if (this.aLG != null) {
      this.aLG.f(this);
    }
    AppMethodBeat.o(77678);
  }
  
  private void pS()
  {
    AppMethodBeat.i(77679);
    if (this.aLG != null) {
      this.aLG.g(this);
    }
    AppMethodBeat.o(77679);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(210280);
    a(paramp, 5);
    AppMethodBeat.o(210280);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77684);
    if ((paramb instanceof g))
    {
      paramb = (g)paramb;
      if ((this.aLw == paramb.aLw) && (this.aLv == paramb.aLv) && (com.bumptech.glide.h.j.f(this.aBp, paramb.aBp)) && (this.aBm.equals(paramb.aBm)) && (this.aBn.equals(paramb.aBn)) && (this.aEt == paramb.aEt)) {
        if (this.aBq != null)
        {
          if (paramb.aBq == null) {}
        }
        else {
          while (paramb.aBq == null)
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
    this.aEz.qe();
    if (aLE) {
      V("Got onSizeReady in " + com.bumptech.glide.h.e.p(this.startTime));
    }
    if (this.aLK != a.aLO)
    {
      AppMethodBeat.o(77673);
      return;
    }
    this.aLK = a.aLN;
    float f = this.aBn.aLq;
    this.width = g(paramInt1, f);
    this.height = g(paramInt2, f);
    if (aLE) {
      V("finished setup for calling load in " + com.bumptech.glide.h.e.p(this.startTime));
    }
    this.aLJ = this.aAs.a(this.aAw, this.aBp, this.aBn.aEk, this.width, this.height, this.aBn.aEo, this.aBm, this.aEt, this.aBn.aEu, this.aBn.aEq, this.aBn.aEv, this.aBn.aEw, this.aBn.aEm, this.aBn.aDZ, this.aBn.aLC, this.aBn.aFS, this.aBn.aEI, this);
    if (this.aLK != a.aLN) {
      this.aLJ = null;
    }
    if (aLE) {
      V("finished onSizeReady in " + com.bumptech.glide.h.e.p(this.startTime));
    }
    AppMethodBeat.o(77673);
  }
  
  public final void begin()
  {
    AppMethodBeat.i(77663);
    pK();
    this.aEz.qe();
    this.startTime = com.bumptech.glide.h.e.pY();
    if (this.aBp == null)
    {
      if (com.bumptech.glide.h.j.aY(this.aLw, this.aLv))
      {
        this.width = this.aLw;
        this.height = this.aLv;
      }
      if (pM() == null) {}
      for (int i = 5;; i = 3)
      {
        a(new p("Received null model"), i);
        AppMethodBeat.o(77663);
        return;
      }
    }
    if (this.aLK == a.aLN)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
      AppMethodBeat.o(77663);
      throw localIllegalArgumentException;
    }
    if (this.aLK == a.aLP)
    {
      c(this.aEa, com.bumptech.glide.c.a.aCT);
      AppMethodBeat.o(77663);
      return;
    }
    this.aLK = a.aLO;
    if (com.bumptech.glide.h.j.aY(this.aLw, this.aLv)) {
      aX(this.aLw, this.aLv);
    }
    for (;;)
    {
      if (((this.aLK == a.aLN) || (this.aLK == a.aLO)) && (pP())) {
        pL();
      }
      if (aLE) {
        V("finished run method in " + com.bumptech.glide.h.e.p(this.startTime));
      }
      AppMethodBeat.o(77663);
      return;
      this.aLH.a(this);
    }
  }
  
  public final void c(u<?> paramu, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77680);
    this.aEz.qe();
    this.aLJ = null;
    if (paramu == null)
    {
      a(new p("Expected to receive a Resource<R> with an object of " + this.aBm + " inside, but instead got null."), 5);
      AppMethodBeat.o(77680);
      return;
    }
    Object localObject = paramu.get();
    if ((localObject == null) || (!this.aBm.isAssignableFrom(localObject.getClass())))
    {
      f(paramu);
      StringBuilder localStringBuilder = new StringBuilder("Expected to receive an object of ").append(this.aBm).append(" but instead got ");
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
    if (!pO())
    {
      f(paramu);
      this.aLK = a.aLP;
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
    com.bumptech.glide.h.j.qa();
    pK();
    this.aEz.qe();
    if (this.aLK == a.aLS)
    {
      AppMethodBeat.o(77665);
      return;
    }
    pK();
    this.aEz.qe();
    this.aLK = a.aLR;
    Object localObject;
    k localk;
    if (this.aLJ != null)
    {
      localObject = this.aLJ;
      localk = ((j.d)localObject).aFL;
      localObject = ((j.d)localObject).aFM;
      com.bumptech.glide.h.j.qa();
      localk.aEz.qe();
      if ((localk.aFT) || (localk.aFV))
      {
        if (localk.aFW == null) {
          localk.aFW = new ArrayList(2);
        }
        if (!localk.aFW.contains(localObject)) {
          localk.aFW.add(localObject);
        }
        this.aLJ = null;
      }
    }
    else
    {
      if (this.aEa != null) {
        f(this.aEa);
      }
      i = j;
      if (this.aLG != null) {
        if (!this.aLG.d(this)) {
          break label317;
        }
      }
    }
    label317:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        pL();
      }
      this.aLK = a.aLS;
      AppMethodBeat.o(77665);
      return;
      localk.aFP.remove(localObject);
      if ((!localk.aFP.isEmpty()) || (localk.aFV) || (localk.aFT) || (localk.isCancelled)) {
        break;
      }
      localk.isCancelled = true;
      localObject = localk.aFY;
      ((com.bumptech.glide.c.b.g)localObject).isCancelled = true;
      localObject = ((com.bumptech.glide.c.b.g)localObject).aEP;
      if (localObject != null) {
        ((com.bumptech.glide.c.b.e)localObject).cancel();
      }
      localk.aFH.a(localk, localk.aDY);
      break;
    }
  }
  
  public final boolean isCancelled()
  {
    return (this.aLK == a.aLR) || (this.aLK == a.aLS);
  }
  
  public final boolean isComplete()
  {
    return this.aLK == a.aLP;
  }
  
  public final boolean isFailed()
  {
    return this.aLK == a.aLQ;
  }
  
  public final boolean isRunning()
  {
    return (this.aLK == a.aLN) || (this.aLK == a.aLO);
  }
  
  public final com.bumptech.glide.h.a.b om()
  {
    return this.aEz;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(77666);
    clear();
    this.aLK = a.aLT;
    AppMethodBeat.o(77666);
  }
  
  public final boolean pz()
  {
    AppMethodBeat.i(77668);
    boolean bool = isComplete();
    AppMethodBeat.o(77668);
    return bool;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77662);
    pK();
    this.context = null;
    this.aAw = null;
    this.aBp = null;
    this.aBm = null;
    this.aBn = null;
    this.aLw = -1;
    this.aLv = -1;
    this.aLH = null;
    this.aBq = null;
    this.aLF = null;
    this.aLG = null;
    this.aLI = null;
    this.aLJ = null;
    this.aLL = null;
    this.aLt = null;
    this.aLy = null;
    this.width = -1;
    this.height = -1;
    aGl.release(this);
    AppMethodBeat.o(77662);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(77659);
      aLM = new a("PENDING", 0);
      aLN = new a("RUNNING", 1);
      aLO = new a("WAITING_FOR_SIZE", 2);
      aLP = new a("COMPLETE", 3);
      aLQ = new a("FAILED", 4);
      aLR = new a("CANCELLED", 5);
      aLS = new a("CLEARED", 6);
      aLT = new a("PAUSED", 7);
      aLU = new a[] { aLM, aLN, aLO, aLP, aLQ, aLR, aLS, aLT };
      AppMethodBeat.o(77659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.g
 * JD-Core Version:    0.7.0.1
 */