package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

final class c
  implements d.a<Object>, f
{
  private final List<com.bumptech.glide.load.g> aFK;
  private final g<?> aFL;
  private final f.a aFM;
  private int aFN = -1;
  private com.bumptech.glide.load.g aFO;
  private List<n<File, ?>> aFP;
  private int aFQ;
  private volatile n.a<?> aFR;
  private File aFS;
  
  c(g<?> paramg, f.a parama)
  {
    this(paramg.oB(), paramg, parama);
    AppMethodBeat.i(76921);
    AppMethodBeat.o(76921);
  }
  
  c(List<com.bumptech.glide.load.g> paramList, g<?> paramg, f.a parama)
  {
    this.aFK = paramList;
    this.aFL = paramg;
    this.aFM = parama;
  }
  
  private boolean ox()
  {
    AppMethodBeat.i(76923);
    if (this.aFQ < this.aFP.size())
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
    this.aFM.a(this.aFO, paramObject, this.aFR.aKh, com.bumptech.glide.load.a.aEI, this.aFO);
    AppMethodBeat.o(76925);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(76924);
    n.a locala = this.aFR;
    if (locala != null) {
      locala.aKh.cancel();
    }
    AppMethodBeat.o(76924);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(76926);
    this.aFM.a(this.aFO, paramException, this.aFR.aKh, com.bumptech.glide.load.a.aEI);
    AppMethodBeat.o(76926);
  }
  
  public final boolean ow()
  {
    boolean bool = false;
    AppMethodBeat.i(76922);
    Object localObject;
    while ((this.aFP == null) || (!ox()))
    {
      this.aFN += 1;
      if (this.aFN >= this.aFK.size())
      {
        AppMethodBeat.o(76922);
        return false;
      }
      localObject = (com.bumptech.glide.load.g)this.aFK.get(this.aFN);
      d locald = new d((com.bumptech.glide.load.g)localObject, this.aFL.aFT);
      this.aFS = this.aFL.oz().c(locald);
      if (this.aFS != null)
      {
        this.aFO = ((com.bumptech.glide.load.g)localObject);
        this.aFP = this.aFL.t(this.aFS);
        this.aFQ = 0;
      }
    }
    this.aFR = null;
    if ((!bool) && (ox()))
    {
      localObject = this.aFP;
      int i = this.aFQ;
      this.aFQ = (i + 1);
      this.aFR = ((n)((List)localObject).get(i)).b(this.aFS, this.aFL.width, this.aFL.height, this.aFL.aFV);
      if ((this.aFR == null) || (!this.aFL.l(this.aFR.aKh.os()))) {
        break label279;
      }
      bool = true;
      this.aFR.aKh.a(this.aFL.aGc, this);
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
 * Qualified Name:     com.bumptech.glide.load.b.c
 * JD-Core Version:    0.7.0.1
 */