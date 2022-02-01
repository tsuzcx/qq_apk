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
  protected static final com.bumptech.glide.f.e aBk;
  private final com.bumptech.glide.f.e aAJ;
  private final c aAq;
  private final e aAw;
  private final j aBl;
  private final Class<TranscodeType> aBm;
  protected com.bumptech.glide.f.e aBn;
  private k<?, ? super TranscodeType> aBo;
  private Object aBp;
  private d<TranscodeType> aBq;
  private i<TranscodeType> aBr;
  private i<TranscodeType> aBs;
  private Float aBt;
  private boolean aBu;
  private boolean aBv;
  private boolean aBw;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(76817);
    aBk = new com.bumptech.glide.f.e().b(com.bumptech.glide.c.b.i.aFs).b(g.aAY).pE();
    AppMethodBeat.o(76817);
  }
  
  protected i(c paramc, j paramj, Class<TranscodeType> paramClass, Context paramContext)
  {
    AppMethodBeat.i(76807);
    this.aBu = true;
    this.aAq = paramc;
    this.aBl = paramj;
    this.aBm = paramClass;
    this.aAJ = paramj.aBn;
    this.context = paramContext;
    this.aBo = paramj.j(paramClass);
    this.aBn = this.aAJ;
    this.aAw = paramc.aAw;
    AppMethodBeat.o(76807);
  }
  
  private b a(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, com.bumptech.glide.f.e parame1)
  {
    AppMethodBeat.i(76813);
    Object localObject1;
    if (this.aBs != null) {
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
      int k = this.aBs.aBn.aLw;
      int m = this.aBs.aBn.aLv;
      int j = k;
      int i = m;
      if (com.bumptech.glide.h.j.aY(paramInt1, paramInt2))
      {
        j = k;
        i = m;
        if (!this.aBs.aBn.pI())
        {
          j = parame1.aLw;
          i = parame1.aLv;
        }
      }
      paramc.a(paramk, this.aBs.a(parame, paramd, paramc, this.aBs.aBo, this.aBs.aBn.aEt, j, i, this.aBs.aBn));
      AppMethodBeat.o(76813);
      return paramc;
      localObject2 = null;
      localObject1 = paramc;
    }
  }
  
  private b a(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.e parame1, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76815);
    parame = com.bumptech.glide.f.g.a(this.context, this.aAw, this.aBp, this.aBm, parame1, paramInt1, paramInt2, paramg, parame, paramd, this.aBq, paramc, this.aAw.aAs, paramk.aBI);
    AppMethodBeat.o(76815);
    return parame;
  }
  
  private g a(g paramg)
  {
    AppMethodBeat.i(76812);
    switch (1.aBx[paramg.ordinal()])
    {
    default: 
      paramg = new IllegalArgumentException("unknown priority: " + this.aBn.aEt);
      AppMethodBeat.o(76812);
      throw paramg;
    case 1: 
      paramg = g.aAX;
      AppMethodBeat.o(76812);
      return paramg;
    case 2: 
      paramg = g.aAW;
      AppMethodBeat.o(76812);
      return paramg;
    }
    paramg = g.aAV;
    AppMethodBeat.o(76812);
    return paramg;
  }
  
  private b b(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, com.bumptech.glide.f.e parame1)
  {
    AppMethodBeat.i(76814);
    Object localObject;
    if (this.aBr != null)
    {
      if (this.aBw)
      {
        parame = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        AppMethodBeat.o(76814);
        throw parame;
      }
      localObject = this.aBr.aBo;
      if (!this.aBr.aBu) {
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
      if (this.aBr.aBn.pJ())
      {
        localg = this.aBr.aBn.aEt;
        j = this.aBr.aBn.aLw;
        i = this.aBr.aBn.aLv;
        if ((!com.bumptech.glide.h.j.aY(paramInt1, paramInt2)) || (this.aBr.aBn.pI())) {
          break label337;
        }
        j = parame1.aLw;
        i = parame1.aLv;
      }
      for (;;)
      {
        paramc = new h(paramc);
        paramk = a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2);
        this.aBw = true;
        parame = this.aBr.a(parame, paramd, paramc, (k)localObject, localg, j, i, this.aBr.aBn);
        this.aBw = false;
        paramc.a(paramk, parame);
        AppMethodBeat.o(76814);
        return paramc;
        localg = a(paramg);
        break;
        if (this.aBt != null)
        {
          paramc = new h(paramc);
          paramc.a(a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2), a(parame, paramd, parame1.pF().S(this.aBt.floatValue()), paramc, paramk, a(paramg), paramInt1, paramInt2));
          AppMethodBeat.o(76814);
          return paramc;
        }
        parame = a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2);
        AppMethodBeat.o(76814);
        return parame;
      }
    }
  }
  
  private com.bumptech.glide.f.e nu()
  {
    AppMethodBeat.i(76809);
    if (this.aAJ == this.aBn)
    {
      locale = this.aBn.pF();
      AppMethodBeat.o(76809);
      return locale;
    }
    com.bumptech.glide.f.e locale = this.aBn;
    AppMethodBeat.o(76809);
    return locale;
  }
  
  private i<TranscodeType> nv()
  {
    AppMethodBeat.i(76810);
    try
    {
      i locali = (i)super.clone();
      locali.aBn = locali.aBn.pF();
      locali.aBo = locali.aBo.nx();
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
  
  public final i<TranscodeType> P(Object paramObject)
  {
    this.aBp = paramObject;
    this.aBv = true;
    return this;
  }
  
  public final i<TranscodeType> a(com.bumptech.glide.f.e parame)
  {
    AppMethodBeat.i(76808);
    com.bumptech.glide.h.i.checkNotNull(parame, "Argument must not be null");
    for (com.bumptech.glide.f.e locale = nu(); locale.aLB; locale = locale.pF()) {}
    if (com.bumptech.glide.f.e.aV(parame.aLp, 2)) {
      locale.aLq = parame.aLq;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 262144)) {
      locale.aLC = parame.aLC;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 1048576)) {
      locale.aFS = parame.aFS;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 4)) {
      locale.aEu = parame.aEu;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 8)) {
      locale.aEt = parame.aEt;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 16)) {
      locale.aLr = parame.aLr;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 32)) {
      locale.aLs = parame.aLs;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 64)) {
      locale.aLt = parame.aLt;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 128)) {
      locale.aLu = parame.aLu;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 256)) {
      locale.aDZ = parame.aDZ;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 512))
    {
      locale.aLw = parame.aLw;
      locale.aLv = parame.aLv;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 1024)) {
      locale.aEk = parame.aEk;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 4096)) {
      locale.aEo = parame.aEo;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 8192)) {
      locale.aLy = parame.aLy;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 16384)) {
      locale.aLz = parame.aLz;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 32768)) {
      locale.aLA = parame.aLA;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 65536)) {
      locale.aLx = parame.aLx;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 131072)) {
      locale.aEv = parame.aEv;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 2048))
    {
      locale.aEq.putAll(parame.aEq);
      locale.aEw = parame.aEw;
    }
    if (com.bumptech.glide.f.e.aV(parame.aLp, 524288)) {
      locale.aEI = parame.aEI;
    }
    if (!locale.aLx)
    {
      locale.aEq.clear();
      locale.aLp &= 0xFFFFF7FF;
      locale.aEv = false;
      locale.aLp &= 0xFFFDFFFF;
      locale.aEw = true;
    }
    locale.aLp |= parame.aLp;
    locale.aEm.a(parame.aEm);
    this.aBn = locale.pH();
    AppMethodBeat.o(76808);
    return this;
  }
  
  public final <Y extends com.bumptech.glide.f.a.e<TranscodeType>> Y b(Y paramY)
  {
    AppMethodBeat.i(76811);
    Object localObject1 = nu();
    com.bumptech.glide.h.j.qa();
    com.bumptech.glide.h.i.checkNotNull(paramY, "Argument must not be null");
    if (!this.aBv)
    {
      paramY = new IllegalArgumentException("You must call #load() before calling #into()");
      AppMethodBeat.o(76811);
      throw paramY;
    }
    Object localObject2 = ((com.bumptech.glide.f.e)localObject1).pG();
    localObject1 = a(paramY, null, null, this.aBo, ((com.bumptech.glide.f.e)localObject2).aEt, ((com.bumptech.glide.f.e)localObject2).aLw, ((com.bumptech.glide.f.e)localObject2).aLv, (com.bumptech.glide.f.e)localObject2);
    b localb = paramY.pU();
    if (((b)localObject1).a(localb))
    {
      if ((!((com.bumptech.glide.f.e)localObject2).aDZ) && (localb.isComplete())) {}
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
    this.aBl.c(paramY);
    paramY.h((b)localObject1);
    localObject2 = this.aBl;
    ((j)localObject2).aBD.aLd.add(paramY);
    localObject2 = ((j)localObject2).aBB;
    ((n)localObject2).aKY.add(localObject1);
    if (!((n)localObject2).isPaused) {
      ((b)localObject1).begin();
    }
    for (;;)
    {
      AppMethodBeat.o(76811);
      return paramY;
      Log.isLoggable("RequestTracker", 2);
      ((n)localObject2).aKZ.add(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.i
 * JD-Core Version:    0.7.0.1
 */