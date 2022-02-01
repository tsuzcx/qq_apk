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
  private static final l.a<g<?>> aIc;
  private static final boolean aNv;
  private com.bumptech.glide.c.b.j aCj;
  private com.bumptech.glide.e aCn;
  private Class<R> aDd;
  private e aDe;
  private Object aDg;
  private d<R> aDh;
  private u<R> aFR;
  private com.bumptech.glide.g aGk;
  private final com.bumptech.glide.h.a.b aGq;
  private j.d aNA;
  private a aNB;
  private Drawable aNC;
  private Drawable aNk;
  private int aNm;
  private int aNn;
  private Drawable aNp;
  private boolean aNu;
  private d<R> aNw;
  private c aNx;
  private com.bumptech.glide.f.a.e<R> aNy;
  private com.bumptech.glide.f.b.c<? super R> aNz;
  private Context context;
  private int height;
  private long startTime;
  private final String tag;
  private int width;
  
  static
  {
    AppMethodBeat.i(77686);
    aIc = com.bumptech.glide.h.a.a.a(new a.a() {});
    aNv = Log.isLoggable("Request", 2);
    AppMethodBeat.o(77686);
  }
  
  g()
  {
    AppMethodBeat.i(77661);
    if (aNv) {}
    for (String str = String.valueOf(super.hashCode());; str = null)
    {
      this.tag = str;
      this.aGq = new b.a();
      AppMethodBeat.o(77661);
      return;
    }
  }
  
  private void U(String paramString)
  {
    AppMethodBeat.i(77685);
    new StringBuilder().append(paramString).append(" this: ").append(this.tag);
    AppMethodBeat.o(77685);
  }
  
  public static <R> g<R> a(Context paramContext, com.bumptech.glide.e parame, Object paramObject, Class<R> paramClass, e parame1, int paramInt1, int paramInt2, com.bumptech.glide.g paramg, com.bumptech.glide.f.a.e<R> parame2, d<R> paramd1, d<R> paramd2, c paramc, com.bumptech.glide.c.b.j paramj, com.bumptech.glide.f.b.c<? super R> paramc1)
  {
    AppMethodBeat.i(77660);
    g localg2 = (g)aIc.acquire();
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = new g();
    }
    localg1.context = paramContext;
    localg1.aCn = parame;
    localg1.aDg = paramObject;
    localg1.aDd = paramClass;
    localg1.aDe = parame1;
    localg1.aNn = paramInt1;
    localg1.aNm = paramInt2;
    localg1.aGk = paramg;
    localg1.aNy = parame2;
    localg1.aNw = paramd1;
    localg1.aDh = paramd2;
    localg1.aNx = paramc;
    localg1.aCj = paramj;
    localg1.aNz = paramc1;
    localg1.aNB = a.aND;
    AppMethodBeat.o(77660);
    return localg1;
  }
  
  private void a(p paramp, int paramInt)
  {
    AppMethodBeat.i(77683);
    this.aGq.qw();
    int i = this.aCn.aCz;
    if (i <= paramInt)
    {
      new StringBuilder("Load failed for ").append(this.aDg).append(" with size [").append(this.width).append("x").append(this.height).append("]");
      if (i <= 4) {
        paramp.oS();
      }
    }
    this.aNA = null;
    this.aNB = a.aNH;
    this.aNu = true;
    try
    {
      if (this.aDh != null)
      {
        paramp = this.aDh;
        qi();
        if (paramp.pT()) {}
      }
      else if (this.aNw != null)
      {
        paramp = this.aNw;
        qi();
        if (paramp.pT()) {}
      }
      else
      {
        qf();
      }
      this.aNu = false;
      qk();
      AppMethodBeat.o(77683);
      return;
    }
    finally
    {
      this.aNu = false;
      AppMethodBeat.o(77683);
    }
  }
  
  private void a(u<R> paramu, R paramR, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77681);
    qi();
    this.aNB = a.aNG;
    this.aFR = paramu;
    if (this.aCn.aCz <= 3) {
      new StringBuilder("Finished loading ").append(paramR.getClass().getSimpleName()).append(" from ").append(parama).append(" for ").append(this.aDg).append(" with size [").append(this.width).append("x").append(this.height).append("] in ").append(com.bumptech.glide.h.e.p(this.startTime)).append(" ms");
    }
    this.aNu = true;
    try
    {
      if (((this.aDh == null) || (!this.aDh.pU())) && ((this.aNw == null) || (!this.aNw.pU())))
      {
        this.aNz.qo();
        this.aNy.aa(paramR);
      }
      this.aNu = false;
      qj();
      AppMethodBeat.o(77681);
      return;
    }
    finally
    {
      this.aNu = false;
      AppMethodBeat.o(77681);
    }
  }
  
  private Drawable du(int paramInt)
  {
    AppMethodBeat.i(77671);
    if (this.aDe.aNr != null) {}
    for (Object localObject = this.aDe.aNr;; localObject = this.context.getTheme())
    {
      localObject = com.bumptech.glide.c.d.c.a.a(this.aCn, paramInt, (Resources.Theme)localObject);
      AppMethodBeat.o(77671);
      return localObject;
    }
  }
  
  private void f(u<?> paramu)
  {
    AppMethodBeat.i(77667);
    com.bumptech.glide.c.b.j.b(paramu);
    this.aFR = null;
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
  
  private void qc()
  {
    AppMethodBeat.i(77664);
    if (this.aNu)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
      AppMethodBeat.o(77664);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(77664);
  }
  
  private Drawable qd()
  {
    AppMethodBeat.i(77669);
    if (this.aNk == null)
    {
      this.aNk = this.aDe.aNk;
      if ((this.aNk == null) && (this.aDe.aNl > 0)) {
        this.aNk = du(this.aDe.aNl);
      }
    }
    Drawable localDrawable = this.aNk;
    AppMethodBeat.o(77669);
    return localDrawable;
  }
  
  private Drawable qe()
  {
    AppMethodBeat.i(77670);
    if (this.aNp == null)
    {
      this.aNp = this.aDe.aNp;
      if ((this.aNp == null) && (this.aDe.aNq > 0)) {
        this.aNp = du(this.aDe.aNq);
      }
    }
    Drawable localDrawable = this.aNp;
    AppMethodBeat.o(77670);
    return localDrawable;
  }
  
  private void qf()
  {
    AppMethodBeat.i(77672);
    if (!qh())
    {
      AppMethodBeat.o(77672);
      return;
    }
    Drawable localDrawable1 = null;
    if (this.aDg == null) {
      localDrawable1 = qe();
    }
    Drawable localDrawable2 = localDrawable1;
    if (localDrawable1 == null)
    {
      if (this.aNC == null)
      {
        this.aNC = this.aDe.aNi;
        if ((this.aNC == null) && (this.aDe.aNj > 0)) {
          this.aNC = du(this.aDe.aNj);
        }
      }
      localDrawable2 = this.aNC;
    }
    if (localDrawable2 == null) {
      qd();
    }
    AppMethodBeat.o(77672);
  }
  
  private boolean qg()
  {
    AppMethodBeat.i(77675);
    if ((this.aNx == null) || (this.aNx.b(this)))
    {
      AppMethodBeat.o(77675);
      return true;
    }
    AppMethodBeat.o(77675);
    return false;
  }
  
  private boolean qh()
  {
    AppMethodBeat.i(77676);
    if ((this.aNx == null) || (this.aNx.c(this)))
    {
      AppMethodBeat.o(77676);
      return true;
    }
    AppMethodBeat.o(77676);
    return false;
  }
  
  private boolean qi()
  {
    AppMethodBeat.i(77677);
    if ((this.aNx == null) || (!this.aNx.pS()))
    {
      AppMethodBeat.o(77677);
      return true;
    }
    AppMethodBeat.o(77677);
    return false;
  }
  
  private void qj()
  {
    AppMethodBeat.i(77678);
    if (this.aNx != null) {
      this.aNx.f(this);
    }
    AppMethodBeat.o(77678);
  }
  
  private void qk()
  {
    AppMethodBeat.i(77679);
    if (this.aNx != null) {
      this.aNx.g(this);
    }
    AppMethodBeat.o(77679);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(224201);
    a(paramp, 5);
    AppMethodBeat.o(224201);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(77684);
    if ((paramb instanceof g))
    {
      paramb = (g)paramb;
      if ((this.aNn == paramb.aNn) && (this.aNm == paramb.aNm) && (com.bumptech.glide.h.j.h(this.aDg, paramb.aDg)) && (this.aDd.equals(paramb.aDd)) && (this.aDe.equals(paramb.aDe)) && (this.aGk == paramb.aGk)) {
        if (this.aDh != null)
        {
          if (paramb.aDh == null) {}
        }
        else {
          while (paramb.aDh == null)
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
  
  public final void aY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77673);
    this.aGq.qw();
    if (aNv) {
      U("Got onSizeReady in " + com.bumptech.glide.h.e.p(this.startTime));
    }
    if (this.aNB != a.aNF)
    {
      AppMethodBeat.o(77673);
      return;
    }
    this.aNB = a.aNE;
    float f = this.aDe.aNh;
    this.width = g(paramInt1, f);
    this.height = g(paramInt2, f);
    if (aNv) {
      U("finished setup for calling load in " + com.bumptech.glide.h.e.p(this.startTime));
    }
    this.aNA = this.aCj.a(this.aCn, this.aDg, this.aDe.aGb, this.width, this.height, this.aDe.aGf, this.aDd, this.aGk, this.aDe.aGl, this.aDe.aGh, this.aDe.aGm, this.aDe.aGn, this.aDe.aGd, this.aDe.aFQ, this.aDe.aNt, this.aDe.aHJ, this.aDe.aGz, this);
    if (this.aNB != a.aNE) {
      this.aNA = null;
    }
    if (aNv) {
      U("finished onSizeReady in " + com.bumptech.glide.h.e.p(this.startTime));
    }
    AppMethodBeat.o(77673);
  }
  
  public final void begin()
  {
    AppMethodBeat.i(77663);
    qc();
    this.aGq.qw();
    this.startTime = com.bumptech.glide.h.e.qq();
    if (this.aDg == null)
    {
      if (com.bumptech.glide.h.j.aZ(this.aNn, this.aNm))
      {
        this.width = this.aNn;
        this.height = this.aNm;
      }
      if (qe() == null) {}
      for (int i = 5;; i = 3)
      {
        a(new p("Received null model"), i);
        AppMethodBeat.o(77663);
        return;
      }
    }
    if (this.aNB == a.aNE)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
      AppMethodBeat.o(77663);
      throw localIllegalArgumentException;
    }
    if (this.aNB == a.aNG)
    {
      c(this.aFR, com.bumptech.glide.c.a.aEK);
      AppMethodBeat.o(77663);
      return;
    }
    this.aNB = a.aNF;
    if (com.bumptech.glide.h.j.aZ(this.aNn, this.aNm)) {
      aY(this.aNn, this.aNm);
    }
    for (;;)
    {
      if (((this.aNB == a.aNE) || (this.aNB == a.aNF)) && (qh())) {
        qd();
      }
      if (aNv) {
        U("finished run method in " + com.bumptech.glide.h.e.p(this.startTime));
      }
      AppMethodBeat.o(77663);
      return;
      this.aNy.a(this);
    }
  }
  
  public final void c(u<?> paramu, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77680);
    this.aGq.qw();
    this.aNA = null;
    if (paramu == null)
    {
      a(new p("Expected to receive a Resource<R> with an object of " + this.aDd + " inside, but instead got null."), 5);
      AppMethodBeat.o(77680);
      return;
    }
    Object localObject = paramu.get();
    if ((localObject == null) || (!this.aDd.isAssignableFrom(localObject.getClass())))
    {
      f(paramu);
      StringBuilder localStringBuilder = new StringBuilder("Expected to receive an object of ").append(this.aDd).append(" but instead got ");
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
    if (!qg())
    {
      f(paramu);
      this.aNB = a.aNG;
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
    com.bumptech.glide.h.j.qs();
    qc();
    this.aGq.qw();
    if (this.aNB == a.aNJ)
    {
      AppMethodBeat.o(77665);
      return;
    }
    qc();
    this.aGq.qw();
    this.aNB = a.aNI;
    Object localObject;
    k localk;
    if (this.aNA != null)
    {
      localObject = this.aNA;
      localk = ((j.d)localObject).aHC;
      localObject = ((j.d)localObject).aHD;
      com.bumptech.glide.h.j.qs();
      localk.aGq.qw();
      if ((localk.aHK) || (localk.aHM))
      {
        if (localk.aHN == null) {
          localk.aHN = new ArrayList(2);
        }
        if (!localk.aHN.contains(localObject)) {
          localk.aHN.add(localObject);
        }
        this.aNA = null;
      }
    }
    else
    {
      if (this.aFR != null) {
        f(this.aFR);
      }
      i = j;
      if (this.aNx != null) {
        if (!this.aNx.d(this)) {
          break label317;
        }
      }
    }
    label317:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        qd();
      }
      this.aNB = a.aNJ;
      AppMethodBeat.o(77665);
      return;
      localk.aHG.remove(localObject);
      if ((!localk.aHG.isEmpty()) || (localk.aHM) || (localk.aHK) || (localk.isCancelled)) {
        break;
      }
      localk.isCancelled = true;
      localObject = localk.aHP;
      ((com.bumptech.glide.c.b.g)localObject).isCancelled = true;
      localObject = ((com.bumptech.glide.c.b.g)localObject).aGG;
      if (localObject != null) {
        ((com.bumptech.glide.c.b.e)localObject).cancel();
      }
      localk.aHy.a(localk, localk.aFP);
      break;
    }
  }
  
  public final boolean isCancelled()
  {
    return (this.aNB == a.aNI) || (this.aNB == a.aNJ);
  }
  
  public final boolean isComplete()
  {
    return this.aNB == a.aNG;
  }
  
  public final boolean isFailed()
  {
    return this.aNB == a.aNH;
  }
  
  public final boolean isRunning()
  {
    return (this.aNB == a.aNE) || (this.aNB == a.aNF);
  }
  
  public final com.bumptech.glide.h.a.b oE()
  {
    return this.aGq;
  }
  
  public final boolean pR()
  {
    AppMethodBeat.i(77668);
    boolean bool = isComplete();
    AppMethodBeat.o(77668);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(77666);
    clear();
    this.aNB = a.aNK;
    AppMethodBeat.o(77666);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77662);
    qc();
    this.context = null;
    this.aCn = null;
    this.aDg = null;
    this.aDd = null;
    this.aDe = null;
    this.aNn = -1;
    this.aNm = -1;
    this.aNy = null;
    this.aDh = null;
    this.aNw = null;
    this.aNx = null;
    this.aNz = null;
    this.aNA = null;
    this.aNC = null;
    this.aNk = null;
    this.aNp = null;
    this.width = -1;
    this.height = -1;
    aIc.release(this);
    AppMethodBeat.o(77662);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(77659);
      aND = new a("PENDING", 0);
      aNE = new a("RUNNING", 1);
      aNF = new a("WAITING_FOR_SIZE", 2);
      aNG = new a("COMPLETE", 3);
      aNH = new a("FAILED", 4);
      aNI = new a("CANCELLED", 5);
      aNJ = new a("CLEARED", 6);
      aNK = new a("PAUSED", 7);
      aNL = new a[] { aND, aNE, aNF, aNG, aNH, aNI, aNJ, aNK };
      AppMethodBeat.o(77659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.f.g
 * JD-Core Version:    0.7.0.1
 */