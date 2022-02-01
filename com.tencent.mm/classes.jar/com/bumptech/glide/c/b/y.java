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
  private final f<?> aFT;
  private final e.a aFU;
  private volatile n.a<?> aFZ;
  private int aIl;
  private b aIm;
  private Object aIn;
  private c aIo;
  
  y(f<?> paramf, e.a parama)
  {
    this.aFT = paramf;
    this.aFU = parama;
  }
  
  public final void S(Object paramObject)
  {
    AppMethodBeat.i(77061);
    i locali = this.aFT.aGl;
    if ((paramObject != null) && (locali.a(this.aFZ.aKp.on())))
    {
      this.aIn = paramObject;
      this.aFU.os();
      AppMethodBeat.o(77061);
      return;
    }
    this.aFU.a(this.aFZ.aFW, paramObject, this.aFZ.aKp, this.aFZ.aKp.on(), this.aIo);
    AppMethodBeat.o(77061);
  }
  
  public final void a(com.bumptech.glide.c.h paramh, Exception paramException, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama)
  {
    AppMethodBeat.i(77065);
    this.aFU.a(paramh, paramException, paramd, this.aFZ.aKp.on());
    AppMethodBeat.o(77065);
  }
  
  public final void a(com.bumptech.glide.c.h paramh1, Object paramObject, com.bumptech.glide.c.a.d<?> paramd, com.bumptech.glide.c.a parama, com.bumptech.glide.c.h paramh2)
  {
    AppMethodBeat.i(77064);
    this.aFU.a(paramh1, paramObject, paramd, this.aFZ.aKp.on(), paramh1);
    AppMethodBeat.o(77064);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77060);
    n.a locala = this.aFZ;
    if (locala != null) {
      locala.aKp.cancel();
    }
    AppMethodBeat.o(77060);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77062);
    this.aFU.a(this.aIo, paramException, this.aFZ.aKp, this.aFZ.aKp.on());
    AppMethodBeat.o(77062);
  }
  
  public final boolean oq()
  {
    AppMethodBeat.i(77059);
    Object localObject1;
    long l;
    if (this.aIn != null)
    {
      localObject1 = this.aIn;
      this.aIn = null;
      l = com.bumptech.glide.h.e.qq();
    }
    try
    {
      com.bumptech.glide.c.d locald = this.aFT.aCn.aCo.aCS.t(localObject1.getClass());
      if (locald != null)
      {
        d locald1 = new d(locald, localObject1, this.aFT.aGd);
        this.aIo = new c(this.aFZ.aFW, this.aFT.aGb);
        this.aFT.ot().a(this.aIo, locald1);
        if (Log.isLoggable("SourceGenerator", 2)) {
          new StringBuilder("Finished encoding source to cache, key: ").append(this.aIo).append(", data: ").append(localObject1).append(", encoder: ").append(locald).append(", duration: ").append(com.bumptech.glide.h.e.p(l));
        }
        this.aFZ.aKp.cleanup();
        this.aIm = new b(Collections.singletonList(this.aFZ.aFW), this.aFT, this);
        if ((this.aIm != null) && (this.aIm.oq()))
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
      this.aFZ.aKp.cleanup();
      AppMethodBeat.o(77059);
    }
    this.aIm = null;
    this.aFZ = null;
    boolean bool = false;
    if (!bool)
    {
      if (this.aIl < this.aFT.ou().size()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label446;
        }
        List localList = this.aFT.ou();
        i = this.aIl;
        this.aIl = (i + 1);
        this.aFZ = ((n.a)localList.get(i));
        if ((this.aFZ == null) || ((!this.aFT.aGl.a(this.aFZ.aKp.on())) && (!this.aFT.k(this.aFZ.aKp.om())))) {
          break;
        }
        this.aFZ.aKp.a(this.aFT.aGk, this);
        bool = true;
        break;
      }
    }
    label446:
    AppMethodBeat.o(77059);
    return bool;
  }
  
  public final void os()
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