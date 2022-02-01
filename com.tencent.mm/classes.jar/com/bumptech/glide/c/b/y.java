package com.bumptech.glide.c.b;

import android.util.Log;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.c.n.a;
import com.bumptech.glide.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class y
  implements d.a<Object>, e, e.a
{
  private final f<?> aDl;
  private final e.a aDm;
  private volatile n.a<?> aDr;
  private int aFE;
  private b aFF;
  private Object aFG;
  private c aFH;
  
  y(f<?> paramf, e.a parama)
  {
    this.aDl = paramf;
    this.aDm = parama;
  }
  
  public final void P(Object paramObject)
  {
    AppMethodBeat.i(77061);
    i locali = this.aDl.aDD;
    if ((paramObject != null) && (locali.a(this.aDr.aHI.nL())))
    {
      this.aFG = paramObject;
      this.aDm.nQ();
      AppMethodBeat.o(77061);
      return;
    }
    this.aDm.a(this.aDr.aDo, paramObject, this.aDr.aHI, this.aDr.aHI.nL(), this.aFH);
    AppMethodBeat.o(77061);
  }
  
  public final void a(com.bumptech.glide.c.h paramh, Exception paramException, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77065);
    this.aDm.a(paramh, paramException, paramd, this.aDr.aHI.nL());
    AppMethodBeat.o(77065);
  }
  
  public final void a(com.bumptech.glide.c.h paramh1, Object paramObject, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama, com.bumptech.glide.c.h paramh2)
  {
    AppMethodBeat.i(77064);
    this.aDm.a(paramh1, paramObject, paramd, this.aDr.aHI.nL(), paramh1);
    AppMethodBeat.o(77064);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77060);
    n.a locala = this.aDr;
    if (locala != null) {
      locala.aHI.cancel();
    }
    AppMethodBeat.o(77060);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77062);
    this.aDm.a(this.aFH, paramException, this.aDr.aHI, this.aDr.aHI.nL());
    AppMethodBeat.o(77062);
  }
  
  public final boolean nO()
  {
    AppMethodBeat.i(77059);
    Object localObject1;
    long l;
    if (this.aFG != null)
    {
      localObject1 = this.aFG;
      this.aFG = null;
      l = com.bumptech.glide.h.e.pO();
    }
    try
    {
      com.bumptech.glide.c.d locald = this.aDl.azC.azD.aAh.t(localObject1.getClass());
      if (locald != null)
      {
        d locald1 = new d(locald, localObject1, this.aDl.aDv);
        this.aFH = new c(this.aDr.aDo, this.aDl.aDt);
        this.aDl.nR().a(this.aFH, locald1);
        if (Log.isLoggable("SourceGenerator", 2)) {
          new StringBuilder("Finished encoding source to cache, key: ").append(this.aFH).append(", data: ").append(localObject1).append(", encoder: ").append(locald).append(", duration: ").append(com.bumptech.glide.h.e.n(l));
        }
        this.aDr.aHI.cleanup();
        this.aFF = new b(Collections.singletonList(this.aDr.aDo), this.aDl, this);
        if ((this.aFF != null) && (this.aFF.nO()))
        {
          AppMethodBeat.o(77059);
          return true;
        }
      }
      else
      {
        localObject1 = new h.e(localObject1.getClass());
        AppMethodBeat.o(77059);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      this.aDr.aHI.cleanup();
      AppMethodBeat.o(77059);
    }
    this.aFF = null;
    this.aDr = null;
    boolean bool = false;
    if (!bool)
    {
      if (this.aFE < this.aDl.nS().size()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label446;
        }
        List localList = this.aDl.nS();
        i = this.aFE;
        this.aFE = (i + 1);
        this.aDr = ((n.a)localList.get(i));
        if ((this.aDr == null) || ((!this.aDl.aDD.a(this.aDr.aHI.nL())) && (!this.aDl.k(this.aDr.aHI.nK())))) {
          break;
        }
        this.aDr.aHI.a(this.aDl.aDC, this);
        bool = true;
        break;
      }
    }
    label446:
    AppMethodBeat.o(77059);
    return bool;
  }
  
  public final void nQ()
  {
    AppMethodBeat.i(77063);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(77063);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.y
 * JD-Core Version:    0.7.0.1
 */