package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.f.a;
import com.bumptech.glide.f.b;
import com.bumptech.glide.f.d;
import com.bumptech.glide.f.h;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.manager.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class i<TranscodeType>
  implements Cloneable
{
  protected static final com.bumptech.glide.f.e aAq;
  private boolean aAA;
  private boolean aAB;
  private boolean aAC;
  private final j aAr;
  private final Class<TranscodeType> aAs;
  protected com.bumptech.glide.f.e aAt;
  private k<?, ? super TranscodeType> aAu;
  private Object aAv;
  private d<TranscodeType> aAw;
  private i<TranscodeType> aAx;
  private i<TranscodeType> aAy;
  private Float aAz;
  private final e azC;
  private final com.bumptech.glide.f.e azP;
  private final c azw;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(76817);
    aAq = new com.bumptech.glide.f.e().b(com.bumptech.glide.c.b.i.aEC).b(g.aAe).pu();
    AppMethodBeat.o(76817);
  }
  
  protected i(c paramc, j paramj, Class<TranscodeType> paramClass, Context paramContext)
  {
    AppMethodBeat.i(76807);
    this.aAA = true;
    this.azw = paramc;
    this.aAr = paramj;
    this.aAs = paramClass;
    this.azP = paramj.aAt;
    this.context = paramContext;
    this.aAu = paramj.j(paramClass);
    this.aAt = this.azP;
    this.azC = paramc.azC;
    AppMethodBeat.o(76807);
  }
  
  private b a(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, com.bumptech.glide.f.e parame1)
  {
    AppMethodBeat.i(76813);
    Object localObject1;
    if (this.aAy != null) {
      localObject1 = new a(paramc);
    }
    Object localObject2;
    for (paramc = (com.bumptech.glide.f.c)localObject1;; paramc = localObject2)
    {
      paramk = b(parame, paramd, (com.bumptech.glide.f.c)localObject1, paramk, paramg, paramInt1, paramInt2, parame1);
      if (paramc == null)
      {
        AppMethodBeat.o(76813);
        return paramk;
      }
      int k = this.aAy.aAt.aKG;
      int m = this.aAy.aAt.aKF;
      int j = k;
      int i = m;
      if (com.bumptech.glide.h.j.aY(paramInt1, paramInt2))
      {
        j = k;
        i = m;
        if (!this.aAy.aAt.py())
        {
          j = parame1.aKG;
          i = parame1.aKF;
        }
      }
      paramc.a(paramk, this.aAy.a(parame, paramd, paramc, this.aAy.aAu, this.aAy.aAt.aDC, j, i, this.aAy.aAt));
      AppMethodBeat.o(76813);
      return paramc;
      localObject2 = null;
      localObject1 = paramc;
    }
  }
  
  private b a(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.e parame1, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76815);
    parame = com.bumptech.glide.f.g.a(this.context, this.azC, this.aAv, this.aAs, parame1, paramInt1, paramInt2, paramg, parame, paramd, this.aAw, paramc, this.azC.azy, paramk.aAO);
    AppMethodBeat.o(76815);
    return parame;
  }
  
  private g a(g paramg)
  {
    AppMethodBeat.i(76812);
    switch (1.aAD[paramg.ordinal()])
    {
    default: 
      paramg = new IllegalArgumentException("unknown priority: " + this.aAt.aDC);
      AppMethodBeat.o(76812);
      throw paramg;
    case 1: 
      paramg = g.aAd;
      AppMethodBeat.o(76812);
      return paramg;
    case 2: 
      paramg = g.aAc;
      AppMethodBeat.o(76812);
      return paramg;
    }
    paramg = g.aAb;
    AppMethodBeat.o(76812);
    return paramg;
  }
  
  private b b(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, com.bumptech.glide.f.e parame1)
  {
    AppMethodBeat.i(76814);
    Object localObject;
    if (this.aAx != null)
    {
      if (this.aAC)
      {
        parame = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        AppMethodBeat.o(76814);
        throw parame;
      }
      localObject = this.aAx.aAu;
      if (!this.aAx.aAA) {
        break label340;
      }
      localObject = paramk;
    }
    label337:
    label340:
    for (;;)
    {
      g localg;
      int j;
      int i;
      if (this.aAx.aAt.pz())
      {
        localg = this.aAx.aAt.aDC;
        j = this.aAx.aAt.aKG;
        i = this.aAx.aAt.aKF;
        if ((!com.bumptech.glide.h.j.aY(paramInt1, paramInt2)) || (this.aAx.aAt.py())) {
          break label337;
        }
        j = parame1.aKG;
        i = parame1.aKF;
      }
      for (;;)
      {
        paramc = new h(paramc);
        paramk = a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2);
        this.aAC = true;
        parame = this.aAx.a(parame, paramd, paramc, (k)localObject, localg, j, i, this.aAx.aAt);
        this.aAC = false;
        paramc.a(paramk, parame);
        AppMethodBeat.o(76814);
        return paramc;
        localg = a(paramg);
        break;
        if (this.aAz != null)
        {
          paramc = new h(paramc);
          paramc.a(a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2), a(parame, paramd, parame1.pv().O(this.aAz.floatValue()), paramc, paramk, a(paramg), paramInt1, paramInt2));
          AppMethodBeat.o(76814);
          return paramc;
        }
        parame = a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2);
        AppMethodBeat.o(76814);
        return parame;
      }
    }
  }
  
  private com.bumptech.glide.f.e nk()
  {
    AppMethodBeat.i(76809);
    if (this.azP == this.aAt)
    {
      locale = this.aAt.pv();
      AppMethodBeat.o(76809);
      return locale;
    }
    com.bumptech.glide.f.e locale = this.aAt;
    AppMethodBeat.o(76809);
    return locale;
  }
  
  private i<TranscodeType> nl()
  {
    AppMethodBeat.i(76810);
    try
    {
      i locali = (i)super.clone();
      locali.aAt = locali.aAt.pv();
      locali.aAu = locali.aAu.nn();
      AppMethodBeat.o(76810);
      return locali;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localCloneNotSupportedException);
      AppMethodBeat.o(76810);
      throw localRuntimeException;
    }
  }
  
  public final i<TranscodeType> N(Object paramObject)
  {
    this.aAv = paramObject;
    this.aAB = true;
    return this;
  }
  
  public final i<TranscodeType> a(com.bumptech.glide.f.e parame)
  {
    AppMethodBeat.i(76808);
    com.bumptech.glide.h.i.checkNotNull(parame, "Argument must not be null");
    for (com.bumptech.glide.f.e locale = nk(); locale.aKL; locale = locale.pv()) {}
    if (com.bumptech.glide.f.e.aV(parame.aKz, 2)) {
      locale.aKA = parame.aKA;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 262144)) {
      locale.aKM = parame.aKM;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 1048576)) {
      locale.aFc = parame.aFc;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 4)) {
      locale.aDD = parame.aDD;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 8)) {
      locale.aDC = parame.aDC;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 16)) {
      locale.aKB = parame.aKB;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 32)) {
      locale.aKC = parame.aKC;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 64)) {
      locale.aKD = parame.aKD;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 128)) {
      locale.aKE = parame.aKE;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 256)) {
      locale.aDi = parame.aDi;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 512))
    {
      locale.aKG = parame.aKG;
      locale.aKF = parame.aKF;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 1024)) {
      locale.aDt = parame.aDt;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 4096)) {
      locale.aDx = parame.aDx;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 8192)) {
      locale.aKI = parame.aKI;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 16384)) {
      locale.aKJ = parame.aKJ;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 32768)) {
      locale.aKK = parame.aKK;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 65536)) {
      locale.aKH = parame.aKH;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 131072)) {
      locale.aDE = parame.aDE;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 2048))
    {
      locale.aDz.putAll(parame.aDz);
      locale.aDF = parame.aDF;
    }
    if (com.bumptech.glide.f.e.aV(parame.aKz, 524288)) {
      locale.aDR = parame.aDR;
    }
    if (!locale.aKH)
    {
      locale.aDz.clear();
      locale.aKz &= 0xFFFFF7FF;
      locale.aDE = false;
      locale.aKz &= 0xFFFDFFFF;
      locale.aDF = true;
    }
    locale.aKz |= parame.aKz;
    locale.aDv.a(parame.aDv);
    this.aAt = locale.px();
    AppMethodBeat.o(76808);
    return this;
  }
  
  public final <Y extends com.bumptech.glide.f.a.e<TranscodeType>> Y b(Y paramY)
  {
    AppMethodBeat.i(76811);
    Object localObject1 = nk();
    com.bumptech.glide.h.j.pQ();
    com.bumptech.glide.h.i.checkNotNull(paramY, "Argument must not be null");
    if (!this.aAB)
    {
      paramY = new IllegalArgumentException("You must call #load() before calling #into()");
      AppMethodBeat.o(76811);
      throw paramY;
    }
    Object localObject2 = ((com.bumptech.glide.f.e)localObject1).pw();
    localObject1 = a(paramY, null, null, this.aAu, ((com.bumptech.glide.f.e)localObject2).aDC, ((com.bumptech.glide.f.e)localObject2).aKG, ((com.bumptech.glide.f.e)localObject2).aKF, (com.bumptech.glide.f.e)localObject2);
    b localb = paramY.pK();
    if (((b)localObject1).a(localb))
    {
      if ((!((com.bumptech.glide.f.e)localObject2).aDi) && (localb.isComplete())) {}
      for (int i = 1; i == 0; i = 0)
      {
        ((b)localObject1).recycle();
        if (!((b)com.bumptech.glide.h.i.checkNotNull(localb, "Argument must not be null")).isRunning()) {
          localb.begin();
        }
        AppMethodBeat.o(76811);
        return paramY;
      }
    }
    this.aAr.c(paramY);
    paramY.h((b)localObject1);
    localObject2 = this.aAr;
    ((j)localObject2).aAJ.aKn.add(paramY);
    localObject2 = ((j)localObject2).aAH;
    ((n)localObject2).aKi.add(localObject1);
    if (!((n)localObject2).isPaused) {
      ((b)localObject1).begin();
    }
    for (;;)
    {
      AppMethodBeat.o(76811);
      return paramY;
      Log.isLoggable("RequestTracker", 2);
      ((n)localObject2).aKj.add(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.i
 * JD-Core Version:    0.7.0.1
 */