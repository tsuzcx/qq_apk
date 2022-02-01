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
  private final List<h> aDk;
  private final f<?> aDl;
  private final e.a aDm;
  private int aDn = -1;
  private h aDo;
  private List<n<File, ?>> aDp;
  private int aDq;
  private volatile n.a<?> aDr;
  private File aDs;
  
  b(f<?> paramf, e.a parama)
  {
    this(paramf.nT(), paramf, parama);
    AppMethodBeat.i(76921);
    AppMethodBeat.o(76921);
  }
  
  b(List<h> paramList, f<?> paramf, e.a parama)
  {
    this.aDk = paramList;
    this.aDl = paramf;
    this.aDm = parama;
  }
  
  private boolean nP()
  {
    AppMethodBeat.i(76923);
    if (this.aDq < this.aDp.size())
    {
      AppMethodBeat.o(76923);
      return true;
    }
    AppMethodBeat.o(76923);
    return false;
  }
  
  public final void P(Object paramObject)
  {
    AppMethodBeat.i(76925);
    this.aDm.a(this.aDo, paramObject, this.aDr.aHI, com.bumptech.glide.c.a.aBZ, this.aDo);
    AppMethodBeat.o(76925);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(76924);
    n.a locala = this.aDr;
    if (locala != null) {
      locala.aHI.cancel();
    }
    AppMethodBeat.o(76924);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(76926);
    this.aDm.a(this.aDo, paramException, this.aDr.aHI, com.bumptech.glide.c.a.aBZ);
    AppMethodBeat.o(76926);
  }
  
  public final boolean nO()
  {
    boolean bool = false;
    AppMethodBeat.i(76922);
    Object localObject;
    while ((this.aDp == null) || (!nP()))
    {
      this.aDn += 1;
      if (this.aDn >= this.aDk.size())
      {
        AppMethodBeat.o(76922);
        return false;
      }
      localObject = (h)this.aDk.get(this.aDn);
      c localc = new c((h)localObject, this.aDl.aDt);
      this.aDs = this.aDl.nR().a(localc);
      if (this.aDs != null)
      {
        this.aDo = ((h)localObject);
        this.aDp = this.aDl.t(this.aDs);
        this.aDq = 0;
      }
    }
    this.aDr = null;
    if ((!bool) && (nP()))
    {
      localObject = this.aDp;
      int i = this.aDq;
      this.aDq = (i + 1);
      this.aDr = ((n)((List)localObject).get(i)).b(this.aDs, this.aDl.width, this.aDl.height, this.aDl.aDv);
      if ((this.aDr == null) || (!this.aDl.k(this.aDr.aHI.nK()))) {
        break label279;
      }
      bool = true;
      this.aDr.aHI.a(this.aDl.aDC, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.b
 * JD-Core Version:    0.7.0.1
 */