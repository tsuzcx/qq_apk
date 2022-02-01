package com.bumptech.glide.c.b;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.n.a;
import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

final class b
  implements d.a<Object>, e
{
  private final List<h> aEb;
  private final f<?> aEc;
  private final e.a aEd;
  private int aEe = -1;
  private h aEf;
  private List<n<File, ?>> aEg;
  private int aEh;
  private volatile n.a<?> aEi;
  private File aEj;
  
  b(f<?> paramf, e.a parama)
  {
    this(paramf.od(), paramf, parama);
    AppMethodBeat.i(76921);
    AppMethodBeat.o(76921);
  }
  
  b(List<h> paramList, f<?> paramf, e.a parama)
  {
    this.aEb = paramList;
    this.aEc = paramf;
    this.aEd = parama;
  }
  
  private boolean nZ()
  {
    AppMethodBeat.i(76923);
    if (this.aEh < this.aEg.size())
    {
      AppMethodBeat.o(76923);
      return true;
    }
    AppMethodBeat.o(76923);
    return false;
  }
  
  public final void R(Object paramObject)
  {
    AppMethodBeat.i(76925);
    this.aEd.a(this.aEf, paramObject, this.aEi.aIy, com.bumptech.glide.c.a.aCR, this.aEf);
    AppMethodBeat.o(76925);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(76924);
    n.a locala = this.aEi;
    if (locala != null) {
      locala.aIy.cancel();
    }
    AppMethodBeat.o(76924);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(76926);
    this.aEd.a(this.aEf, paramException, this.aEi.aIy, com.bumptech.glide.c.a.aCR);
    AppMethodBeat.o(76926);
  }
  
  public final boolean nY()
  {
    boolean bool = false;
    AppMethodBeat.i(76922);
    Object localObject;
    while ((this.aEg == null) || (!nZ()))
    {
      this.aEe += 1;
      if (this.aEe >= this.aEb.size())
      {
        AppMethodBeat.o(76922);
        return false;
      }
      localObject = (h)this.aEb.get(this.aEe);
      c localc = new c((h)localObject, this.aEc.aEk);
      this.aEj = this.aEc.ob().a(localc);
      if (this.aEj != null)
      {
        this.aEf = ((h)localObject);
        this.aEg = this.aEc.t(this.aEj);
        this.aEh = 0;
      }
    }
    this.aEi = null;
    if ((!bool) && (nZ()))
    {
      localObject = this.aEg;
      int i = this.aEh;
      this.aEh = (i + 1);
      this.aEi = ((n)((List)localObject).get(i)).b(this.aEj, this.aEc.width, this.aEc.height, this.aEc.aEm);
      if ((this.aEi == null) || (!this.aEc.k(this.aEi.aIy.nU()))) {
        break label279;
      }
      bool = true;
      this.aEi.aIy.a(this.aEc.aEt, this);
    }
    label279:
    for (;;)
    {
      break;
      AppMethodBeat.o(76922);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b
 * JD-Core Version:    0.7.0.1
 */