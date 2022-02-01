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
  protected static final com.bumptech.glide.f.e aDb;
  private final com.bumptech.glide.f.e aCA;
  private final c aCh;
  private final e aCn;
  private final j aDc;
  private final Class<TranscodeType> aDd;
  protected com.bumptech.glide.f.e aDe;
  private k<?, ? super TranscodeType> aDf;
  private Object aDg;
  private d<TranscodeType> aDh;
  private i<TranscodeType> aDi;
  private i<TranscodeType> aDj;
  private Float aDk;
  private boolean aDl;
  private boolean aDm;
  private boolean aDn;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(76817);
    aDb = new com.bumptech.glide.f.e().b(com.bumptech.glide.c.b.i.aHj).b(g.aCP).pW();
    AppMethodBeat.o(76817);
  }
  
  protected i(c paramc, j paramj, Class<TranscodeType> paramClass, Context paramContext)
  {
    AppMethodBeat.i(76807);
    this.aDl = true;
    this.aCh = paramc;
    this.aDc = paramj;
    this.aDd = paramClass;
    this.aCA = paramj.aDe;
    this.context = paramContext;
    this.aDf = paramj.j(paramClass);
    this.aDe = this.aCA;
    this.aCn = paramc.aCn;
    AppMethodBeat.o(76807);
  }
  
  private b a(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, com.bumptech.glide.f.e parame1)
  {
    AppMethodBeat.i(76813);
    Object localObject1;
    if (this.aDj != null) {
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
      int k = this.aDj.aDe.aNn;
      int m = this.aDj.aDe.aNm;
      int j = k;
      int i = m;
      if (com.bumptech.glide.h.j.aZ(paramInt1, paramInt2))
      {
        j = k;
        i = m;
        if (!this.aDj.aDe.qa())
        {
          j = parame1.aNn;
          i = parame1.aNm;
        }
      }
      paramc.a(paramk, this.aDj.a(parame, paramd, paramc, this.aDj.aDf, this.aDj.aDe.aGk, j, i, this.aDj.aDe));
      AppMethodBeat.o(76813);
      return paramc;
      localObject2 = null;
      localObject1 = paramc;
    }
  }
  
  private b a(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.e parame1, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76815);
    parame = com.bumptech.glide.f.g.a(this.context, this.aCn, this.aDg, this.aDd, parame1, paramInt1, paramInt2, paramg, parame, paramd, this.aDh, paramc, this.aCn.aCj, paramk.aDz);
    AppMethodBeat.o(76815);
    return parame;
  }
  
  private g a(g paramg)
  {
    AppMethodBeat.i(76812);
    switch (1.aDo[paramg.ordinal()])
    {
    default: 
      paramg = new IllegalArgumentException("unknown priority: " + this.aDe.aGk);
      AppMethodBeat.o(76812);
      throw paramg;
    case 1: 
      paramg = g.aCO;
      AppMethodBeat.o(76812);
      return paramg;
    case 2: 
      paramg = g.aCN;
      AppMethodBeat.o(76812);
      return paramg;
    }
    paramg = g.aCM;
    AppMethodBeat.o(76812);
    return paramg;
  }
  
  private b b(com.bumptech.glide.f.a.e<TranscodeType> parame, d<TranscodeType> paramd, com.bumptech.glide.f.c paramc, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, com.bumptech.glide.f.e parame1)
  {
    AppMethodBeat.i(76814);
    Object localObject;
    if (this.aDi != null)
    {
      if (this.aDn)
      {
        parame = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        AppMethodBeat.o(76814);
        throw parame;
      }
      localObject = this.aDi.aDf;
      if (!this.aDi.aDl) {
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
      if (this.aDi.aDe.qb())
      {
        localg = this.aDi.aDe.aGk;
        j = this.aDi.aDe.aNn;
        i = this.aDi.aDe.aNm;
        if ((!com.bumptech.glide.h.j.aZ(paramInt1, paramInt2)) || (this.aDi.aDe.qa())) {
          break label337;
        }
        j = parame1.aNn;
        i = parame1.aNm;
      }
      for (;;)
      {
        paramc = new h(paramc);
        paramk = a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2);
        this.aDn = true;
        parame = this.aDi.a(parame, paramd, paramc, (k)localObject, localg, j, i, this.aDi.aDe);
        this.aDn = false;
        paramc.a(paramk, parame);
        AppMethodBeat.o(76814);
        return paramc;
        localg = a(paramg);
        break;
        if (this.aDk != null)
        {
          paramc = new h(paramc);
          paramc.a(a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2), a(parame, paramd, parame1.pX().Q(this.aDk.floatValue()), paramc, paramk, a(paramg), paramInt1, paramInt2));
          AppMethodBeat.o(76814);
          return paramc;
        }
        parame = a(parame, paramd, parame1, paramc, paramk, paramg, paramInt1, paramInt2);
        AppMethodBeat.o(76814);
        return parame;
      }
    }
  }
  
  private com.bumptech.glide.f.e nM()
  {
    AppMethodBeat.i(76809);
    if (this.aCA == this.aDe)
    {
      locale = this.aDe.pX();
      AppMethodBeat.o(76809);
      return locale;
    }
    com.bumptech.glide.f.e locale = this.aDe;
    AppMethodBeat.o(76809);
    return locale;
  }
  
  private i<TranscodeType> nN()
  {
    AppMethodBeat.i(76810);
    try
    {
      i locali = (i)super.clone();
      locali.aDe = locali.aDe.pX();
      locali.aDf = locali.aDf.nP();
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
  
  public final i<TranscodeType> Q(Object paramObject)
  {
    this.aDg = paramObject;
    this.aDm = true;
    return this;
  }
  
  public final i<TranscodeType> a(com.bumptech.glide.f.e parame)
  {
    AppMethodBeat.i(76808);
    com.bumptech.glide.h.i.checkNotNull(parame, "Argument must not be null");
    for (com.bumptech.glide.f.e locale = nM(); locale.aNs; locale = locale.pX()) {}
    if (com.bumptech.glide.f.e.aW(parame.aNg, 2)) {
      locale.aNh = parame.aNh;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 262144)) {
      locale.aNt = parame.aNt;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 1048576)) {
      locale.aHJ = parame.aHJ;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 4)) {
      locale.aGl = parame.aGl;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 8)) {
      locale.aGk = parame.aGk;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 16)) {
      locale.aNi = parame.aNi;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 32)) {
      locale.aNj = parame.aNj;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 64)) {
      locale.aNk = parame.aNk;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 128)) {
      locale.aNl = parame.aNl;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 256)) {
      locale.aFQ = parame.aFQ;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 512))
    {
      locale.aNn = parame.aNn;
      locale.aNm = parame.aNm;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 1024)) {
      locale.aGb = parame.aGb;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 4096)) {
      locale.aGf = parame.aGf;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 8192)) {
      locale.aNp = parame.aNp;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 16384)) {
      locale.aNq = parame.aNq;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 32768)) {
      locale.aNr = parame.aNr;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 65536)) {
      locale.aNo = parame.aNo;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 131072)) {
      locale.aGm = parame.aGm;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 2048))
    {
      locale.aGh.putAll(parame.aGh);
      locale.aGn = parame.aGn;
    }
    if (com.bumptech.glide.f.e.aW(parame.aNg, 524288)) {
      locale.aGz = parame.aGz;
    }
    if (!locale.aNo)
    {
      locale.aGh.clear();
      locale.aNg &= 0xFFFFF7FF;
      locale.aGm = false;
      locale.aNg &= 0xFFFDFFFF;
      locale.aGn = true;
    }
    locale.aNg |= parame.aNg;
    locale.aGd.a(parame.aGd);
    this.aDe = locale.pZ();
    AppMethodBeat.o(76808);
    return this;
  }
  
  public final <Y extends com.bumptech.glide.f.a.e<TranscodeType>> Y b(Y paramY)
  {
    AppMethodBeat.i(76811);
    Object localObject1 = nM();
    com.bumptech.glide.h.j.qs();
    com.bumptech.glide.h.i.checkNotNull(paramY, "Argument must not be null");
    if (!this.aDm)
    {
      paramY = new IllegalArgumentException("You must call #load() before calling #into()");
      AppMethodBeat.o(76811);
      throw paramY;
    }
    Object localObject2 = ((com.bumptech.glide.f.e)localObject1).pY();
    localObject1 = a(paramY, null, null, this.aDf, ((com.bumptech.glide.f.e)localObject2).aGk, ((com.bumptech.glide.f.e)localObject2).aNn, ((com.bumptech.glide.f.e)localObject2).aNm, (com.bumptech.glide.f.e)localObject2);
    b localb = paramY.qm();
    if (((b)localObject1).a(localb))
    {
      if ((!((com.bumptech.glide.f.e)localObject2).aFQ) && (localb.isComplete())) {}
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
    this.aDc.c(paramY);
    paramY.h((b)localObject1);
    localObject2 = this.aDc;
    ((j)localObject2).aDu.aMU.add(paramY);
    localObject2 = ((j)localObject2).aDs;
    ((n)localObject2).aMP.add(localObject1);
    if (!((n)localObject2).isPaused) {
      ((b)localObject1).begin();
    }
    for (;;)
    {
      AppMethodBeat.o(76811);
      return paramY;
      Log.isLoggable("RequestTracker", 2);
      ((n)localObject2).aMQ.add(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.i
 * JD-Core Version:    0.7.0.1
 */