package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.b;
import com.bumptech.glide.e.d;
import com.bumptech.glide.e.f;
import com.bumptech.glide.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class i<TranscodeType>
  extends a<i<TranscodeType>>
  implements Cloneable
{
  protected static final f aDb;
  private final c aCg;
  private final e aCm;
  private final j aDc;
  private final Class<TranscodeType> aDd;
  private k<?, ? super TranscodeType> aDe;
  private Object aDf;
  private List<com.bumptech.glide.e.e<TranscodeType>> aDg;
  private i<TranscodeType> aDh;
  private i<TranscodeType> aDi;
  private Float aDj;
  private boolean aDk;
  private boolean aDl;
  private boolean aDm;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(76817);
    aDb = (f)((f)((f)new f().a(com.bumptech.glide.load.b.j.aHb)).b(g.aCP)).pX();
    AppMethodBeat.o(76817);
  }
  
  @SuppressLint({"CheckResult"})
  protected i(c paramc, j paramj, Class<TranscodeType> paramClass, Context paramContext)
  {
    AppMethodBeat.i(76807);
    this.aDk = true;
    this.aCg = paramc;
    this.aDc = paramj;
    this.aDd = paramClass;
    this.context = paramContext;
    this.aDe = paramj.k(paramClass);
    this.aCm = paramc.aCm;
    paramc = paramj.aDx.iterator();
    while (paramc.hasNext())
    {
      paramClass = (com.bumptech.glide.e.e)paramc.next();
      if (paramClass != null)
      {
        if (this.aDg == null) {
          this.aDg = new ArrayList();
        }
        this.aDg.add(paramClass);
      }
    }
    a(paramj.nU());
    AppMethodBeat.o(76807);
  }
  
  private com.bumptech.glide.e.c a(com.bumptech.glide.e.a.e<TranscodeType> parame, com.bumptech.glide.e.e<TranscodeType> parame1, a<?> parama, d paramd, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, Executor paramExecutor)
  {
    AppMethodBeat.i(204447);
    parame = h.a(this.context, this.aCm, this.aDf, this.aDd, parama, paramInt1, paramInt2, paramg, parame, parame1, this.aDg, paramd, this.aCm.aCi, paramk.aDA, paramExecutor);
    AppMethodBeat.o(204447);
    return parame;
  }
  
  private com.bumptech.glide.e.c a(com.bumptech.glide.e.a.e<TranscodeType> parame, com.bumptech.glide.e.e<TranscodeType> parame1, d paramd, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, a<?> parama, Executor paramExecutor)
  {
    AppMethodBeat.i(204445);
    Object localObject1;
    if (this.aDi != null) {
      localObject1 = new b(paramd);
    }
    Object localObject2;
    for (paramd = (d)localObject1;; paramd = localObject2)
    {
      paramk = b(parame, parame1, (d)localObject1, paramk, paramg, paramInt1, paramInt2, parama, paramExecutor);
      if (paramd == null)
      {
        AppMethodBeat.o(204445);
        return paramk;
      }
      int k = this.aDi.aNb;
      int m = this.aDi.aNa;
      int j = k;
      int i = m;
      if (com.bumptech.glide.g.k.aT(paramInt1, paramInt2))
      {
        j = k;
        i = m;
        if (!this.aDi.pZ())
        {
          j = parama.aNb;
          i = parama.aNa;
        }
      }
      paramd.a(paramk, this.aDi.a(parame, parame1, paramd, this.aDi.aDe, this.aDi.aGc, j, i, this.aDi, paramExecutor));
      AppMethodBeat.o(204445);
      return paramd;
      localObject2 = null;
      localObject1 = paramd;
    }
  }
  
  private g a(g paramg)
  {
    AppMethodBeat.i(76812);
    switch (1.aDn[paramg.ordinal()])
    {
    default: 
      paramg = new IllegalArgumentException("unknown priority: " + this.aGc);
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
  
  private com.bumptech.glide.e.c b(com.bumptech.glide.e.a.e<TranscodeType> parame, com.bumptech.glide.e.e<TranscodeType> parame1, d paramd, k<?, ? super TranscodeType> paramk, g paramg, int paramInt1, int paramInt2, a<?> parama, Executor paramExecutor)
  {
    AppMethodBeat.i(204446);
    Object localObject;
    if (this.aDh != null)
    {
      if (this.aDm)
      {
        parame = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        AppMethodBeat.o(204446);
        throw parame;
      }
      localObject = this.aDh.aDe;
      if (!this.aDh.aDk) {
        break label333;
      }
      localObject = paramk;
    }
    label330:
    label333:
    for (;;)
    {
      g localg;
      int j;
      int i;
      if (this.aDh.qa())
      {
        localg = this.aDh.aGc;
        j = this.aDh.aNb;
        i = this.aDh.aNa;
        if ((!com.bumptech.glide.g.k.aT(paramInt1, paramInt2)) || (this.aDh.pZ())) {
          break label330;
        }
        j = parama.aNb;
        i = parama.aNa;
      }
      for (;;)
      {
        paramd = new com.bumptech.glide.e.i(paramd);
        paramk = a(parame, parame1, parama, paramd, paramk, paramg, paramInt1, paramInt2, paramExecutor);
        this.aDm = true;
        parame = this.aDh.a(parame, parame1, paramd, (k)localObject, localg, j, i, this.aDh, paramExecutor);
        this.aDm = false;
        paramd.a(paramk, parame);
        AppMethodBeat.o(204446);
        return paramd;
        localg = a(paramg);
        break;
        if (this.aDj != null)
        {
          paramd = new com.bumptech.glide.e.i(paramd);
          paramd.a(a(parame, parame1, parama, paramd, paramk, paramg, paramInt1, paramInt2, paramExecutor), a(parame, parame1, parama.nQ().Q(this.aDj.floatValue()), paramd, paramk, a(paramg), paramInt1, paramInt2, paramExecutor));
          AppMethodBeat.o(204446);
          return paramd;
        }
        parame = a(parame, parame1, parama, paramd, paramk, paramg, paramInt1, paramInt2, paramExecutor);
        AppMethodBeat.o(204446);
        return parame;
      }
    }
  }
  
  private i<TranscodeType> nP()
  {
    AppMethodBeat.i(76810);
    i locali = (i)super.nQ();
    locali.aDe = locali.aDe.nV();
    AppMethodBeat.o(76810);
    return locali;
  }
  
  public final i<TranscodeType> Q(Object paramObject)
  {
    this.aDf = paramObject;
    this.aDl = true;
    return this;
  }
  
  public final i<TranscodeType> a(a<?> parama)
  {
    AppMethodBeat.i(204444);
    com.bumptech.glide.g.j.checkNotNull(parama, "Argument must not be null");
    parama = (i)super.b(parama);
    AppMethodBeat.o(204444);
    return parama;
  }
  
  public final <Y extends com.bumptech.glide.e.a.e<TranscodeType>> Y b(Y paramY)
  {
    AppMethodBeat.i(76811);
    Object localObject = com.bumptech.glide.g.e.qr();
    com.bumptech.glide.g.j.checkNotNull(paramY, "Argument must not be null");
    if (!this.aDl)
    {
      paramY = new IllegalArgumentException("You must call #load() before calling #into()");
      AppMethodBeat.o(76811);
      throw paramY;
    }
    localObject = a(paramY, null, null, this.aDe, this.aGc, this.aNb, this.aNa, this, (Executor)localObject);
    com.bumptech.glide.e.c localc = paramY.qn();
    if (((com.bumptech.glide.e.c)localObject).a(localc))
    {
      if ((!this.aFI) && (localc.isComplete())) {}
      for (int i = 1; i == 0; i = 0)
      {
        ((com.bumptech.glide.e.c)localObject).recycle();
        if (!((com.bumptech.glide.e.c)com.bumptech.glide.g.j.checkNotNull(localc, "Argument must not be null")).isRunning()) {
          localc.begin();
        }
        AppMethodBeat.o(76811);
        return paramY;
      }
    }
    this.aDc.c(paramY);
    paramY.h((com.bumptech.glide.e.c)localObject);
    this.aDc.a(paramY, (com.bumptech.glide.e.c)localObject);
    AppMethodBeat.o(76811);
    return paramY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.i
 * JD-Core Version:    0.7.0.1
 */