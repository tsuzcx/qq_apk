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
  private final f<?> aEc;
  private final e.a aEd;
  private volatile n.a<?> aEi;
  private int aGu;
  private b aGv;
  private Object aGw;
  private c aGx;
  
  y(f<?> paramf, e.a parama)
  {
    this.aEc = paramf;
    this.aEd = parama;
  }
  
  public final void R(Object paramObject)
  {
    AppMethodBeat.i(77061);
    i locali = this.aEc.aEu;
    if ((paramObject != null) && (locali.a(this.aEi.aIy.nV())))
    {
      this.aGw = paramObject;
      this.aEd.oa();
      AppMethodBeat.o(77061);
      return;
    }
    this.aEd.a(this.aEi.aEf, paramObject, this.aEi.aIy, this.aEi.aIy.nV(), this.aGx);
    AppMethodBeat.o(77061);
  }
  
  public final void a(com.bumptech.glide.c.h paramh, Exception paramException, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77065);
    this.aEd.a(paramh, paramException, paramd, this.aEi.aIy.nV());
    AppMethodBeat.o(77065);
  }
  
  public final void a(com.bumptech.glide.c.h paramh1, Object paramObject, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama, com.bumptech.glide.c.h paramh2)
  {
    AppMethodBeat.i(77064);
    this.aEd.a(paramh1, paramObject, paramd, this.aEi.aIy.nV(), paramh1);
    AppMethodBeat.o(77064);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77060);
    n.a locala = this.aEi;
    if (locala != null) {
      locala.aIy.cancel();
    }
    AppMethodBeat.o(77060);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77062);
    this.aEd.a(this.aGx, paramException, this.aEi.aIy, this.aEi.aIy.nV());
    AppMethodBeat.o(77062);
  }
  
  public final boolean nY()
  {
    AppMethodBeat.i(77059);
    Object localObject1;
    long l;
    if (this.aGw != null)
    {
      localObject1 = this.aGw;
      this.aGw = null;
      l = com.bumptech.glide.h.e.pY();
    }
    try
    {
      com.bumptech.glide.c.d locald = this.aEc.aAw.aAx.aBb.t(localObject1.getClass());
      if (locald != null)
      {
        d locald1 = new d(locald, localObject1, this.aEc.aEm);
        this.aGx = new c(this.aEi.aEf, this.aEc.aEk);
        this.aEc.ob().a(this.aGx, locald1);
        if (Log.isLoggable("SourceGenerator", 2)) {
          new StringBuilder("Finished encoding source to cache, key: ").append(this.aGx).append(", data: ").append(localObject1).append(", encoder: ").append(locald).append(", duration: ").append(com.bumptech.glide.h.e.p(l));
        }
        this.aEi.aIy.cleanup();
        this.aGv = new b(Collections.singletonList(this.aEi.aEf), this.aEc, this);
        if ((this.aGv != null) && (this.aGv.nY()))
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
      this.aEi.aIy.cleanup();
      AppMethodBeat.o(77059);
    }
    this.aGv = null;
    this.aEi = null;
    boolean bool = false;
    if (!bool)
    {
      if (this.aGu < this.aEc.oc().size()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label446;
        }
        List localList = this.aEc.oc();
        i = this.aGu;
        this.aGu = (i + 1);
        this.aEi = ((n.a)localList.get(i));
        if ((this.aEi == null) || ((!this.aEc.aEu.a(this.aEi.aIy.nV())) && (!this.aEc.k(this.aEi.aIy.nU())))) {
          break;
        }
        this.aEi.aIy.a(this.aEc.aEt, this);
        bool = true;
        break;
      }
    }
    label446:
    AppMethodBeat.o(77059);
    return bool;
  }
  
  public final void oa()
  {
    AppMethodBeat.i(77063);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(77063);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.y
 * JD-Core Version:    0.7.0.1
 */