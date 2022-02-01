package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.h.e;
import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.c.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class z
  implements d.a<Object>, f, f.a
{
  private final g<?> aFL;
  private final f.a aFM;
  private volatile n.a<?> aFR;
  private int aIf;
  private c aIg;
  private Object aIh;
  private d aIi;
  
  z(g<?> paramg, f.a parama)
  {
    this.aFL = paramg;
    this.aFM = parama;
  }
  
  public final void S(Object paramObject)
  {
    AppMethodBeat.i(77061);
    j localj = this.aFL.aGd;
    if ((paramObject != null) && (localj.a(this.aFR.aKh.ot())))
    {
      this.aIh = paramObject;
      this.aFM.oy();
      AppMethodBeat.o(77061);
      return;
    }
    this.aFM.a(this.aFR.aFO, paramObject, this.aFR.aKh, this.aFR.aKh.ot(), this.aIi);
    AppMethodBeat.o(77061);
  }
  
  public final void a(com.bumptech.glide.load.g paramg, Exception paramException, com.bumptech.glide.load.a.d<?> paramd, com.bumptech.glide.load.a parama)
  {
    AppMethodBeat.i(77065);
    this.aFM.a(paramg, paramException, paramd, this.aFR.aKh.ot());
    AppMethodBeat.o(77065);
  }
  
  public final void a(com.bumptech.glide.load.g paramg1, Object paramObject, com.bumptech.glide.load.a.d<?> paramd, com.bumptech.glide.load.a parama, com.bumptech.glide.load.g paramg2)
  {
    AppMethodBeat.i(77064);
    this.aFM.a(paramg1, paramObject, paramd, this.aFR.aKh.ot(), paramg1);
    AppMethodBeat.o(77064);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77060);
    n.a locala = this.aFR;
    if (locala != null) {
      locala.aKh.cancel();
    }
    AppMethodBeat.o(77060);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77062);
    this.aFM.a(this.aIi, paramException, this.aFR.aKh, this.aFR.aKh.ot());
    AppMethodBeat.o(77062);
  }
  
  public final boolean ow()
  {
    AppMethodBeat.i(77059);
    Object localObject1;
    long l;
    if (this.aIh != null)
    {
      localObject1 = this.aIh;
      this.aIh = null;
      l = com.bumptech.glide.g.f.qt();
    }
    try
    {
      com.bumptech.glide.load.d locald = this.aFL.aCm.aCn.aCS.v(localObject1.getClass());
      if (locald != null)
      {
        e locale = new e(locald, localObject1, this.aFL.aFV);
        this.aIi = new d(this.aFR.aFO, this.aFL.aFT);
        this.aFL.oz().a(this.aIi, locale);
        if (Log.isLoggable("SourceGenerator", 2)) {
          new StringBuilder("Finished encoding source to cache, key: ").append(this.aIi).append(", data: ").append(localObject1).append(", encoder: ").append(locald).append(", duration: ").append(com.bumptech.glide.g.f.p(l));
        }
        this.aFR.aKh.cleanup();
        this.aIg = new c(Collections.singletonList(this.aFR.aFO), this.aFL, this);
        if ((this.aIg != null) && (this.aIg.ow()))
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
      this.aFR.aKh.cleanup();
      AppMethodBeat.o(77059);
    }
    this.aIg = null;
    this.aFR = null;
    boolean bool = false;
    if (!bool)
    {
      if (this.aIf < this.aFL.oA().size()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label446;
        }
        List localList = this.aFL.oA();
        i = this.aIf;
        this.aIf = (i + 1);
        this.aFR = ((n.a)localList.get(i));
        if ((this.aFR == null) || ((!this.aFL.aGd.a(this.aFR.aKh.ot())) && (!this.aFL.l(this.aFR.aKh.os())))) {
          break;
        }
        this.aFR.aKh.a(this.aFL.aGc, this);
        bool = true;
        break;
      }
    }
    label446:
    AppMethodBeat.o(77059);
    return bool;
  }
  
  public final void oy()
  {
    AppMethodBeat.i(77063);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(77063);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.z
 * JD-Core Version:    0.7.0.1
 */