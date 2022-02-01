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
  private final List<h> aFS;
  private final f<?> aFT;
  private final e.a aFU;
  private int aFV = -1;
  private h aFW;
  private List<n<File, ?>> aFX;
  private int aFY;
  private volatile n.a<?> aFZ;
  private File aGa;
  
  b(f<?> paramf, e.a parama)
  {
    this(paramf.ov(), paramf, parama);
    AppMethodBeat.i(76921);
    AppMethodBeat.o(76921);
  }
  
  b(List<h> paramList, f<?> paramf, e.a parama)
  {
    this.aFS = paramList;
    this.aFT = paramf;
    this.aFU = parama;
  }
  
  private boolean or()
  {
    AppMethodBeat.i(76923);
    if (this.aFY < this.aFX.size())
    {
      AppMethodBeat.o(76923);
      return true;
    }
    AppMethodBeat.o(76923);
    return false;
  }
  
  public final void S(Object paramObject)
  {
    AppMethodBeat.i(76925);
    this.aFU.a(this.aFW, paramObject, this.aFZ.aKp, com.bumptech.glide.c.a.aEI, this.aFW);
    AppMethodBeat.o(76925);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(76924);
    n.a locala = this.aFZ;
    if (locala != null) {
      locala.aKp.cancel();
    }
    AppMethodBeat.o(76924);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(76926);
    this.aFU.a(this.aFW, paramException, this.aFZ.aKp, com.bumptech.glide.c.a.aEI);
    AppMethodBeat.o(76926);
  }
  
  public final boolean oq()
  {
    boolean bool = false;
    AppMethodBeat.i(76922);
    Object localObject;
    while ((this.aFX == null) || (!or()))
    {
      this.aFV += 1;
      if (this.aFV >= this.aFS.size())
      {
        AppMethodBeat.o(76922);
        return false;
      }
      localObject = (h)this.aFS.get(this.aFV);
      c localc = new c((h)localObject, this.aFT.aGb);
      this.aGa = this.aFT.ot().a(localc);
      if (this.aGa != null)
      {
        this.aFW = ((h)localObject);
        this.aFX = this.aFT.t(this.aGa);
        this.aFY = 0;
      }
    }
    this.aFZ = null;
    if ((!bool) && (or()))
    {
      localObject = this.aFX;
      int i = this.aFY;
      this.aFY = (i + 1);
      this.aFZ = ((n)((List)localObject).get(i)).b(this.aGa, this.aFT.width, this.aFT.height, this.aFT.aGd);
      if ((this.aFZ == null) || (!this.aFT.k(this.aFZ.aKp.om()))) {
        break label279;
      }
      bool = true;
      this.aFZ.aKp.a(this.aFT.aGk, this);
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