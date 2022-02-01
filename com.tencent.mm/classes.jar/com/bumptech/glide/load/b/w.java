package com.bumptech.glide.load.b;

import com.bumptech.glide.e;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.n.a;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

final class w
  implements d.a<Object>, f
{
  private final g<?> aFL;
  private final f.a aFM;
  private int aFN;
  private com.bumptech.glide.load.g aFO;
  private List<n<File, ?>> aFP;
  private int aFQ;
  private volatile n.a<?> aFR;
  private File aFS;
  private int aHZ = -1;
  private x aIa;
  
  w(g<?> paramg, f.a parama)
  {
    this.aFL = paramg;
    this.aFM = parama;
  }
  
  private boolean ox()
  {
    AppMethodBeat.i(77047);
    if (this.aFQ < this.aFP.size())
    {
      AppMethodBeat.o(77047);
      return true;
    }
    AppMethodBeat.o(77047);
    return false;
  }
  
  public final void S(Object paramObject)
  {
    AppMethodBeat.i(77049);
    this.aFM.a(this.aFO, paramObject, this.aFR.aKh, com.bumptech.glide.load.a.aEJ, this.aIa);
    AppMethodBeat.o(77049);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77048);
    n.a locala = this.aFR;
    if (locala != null) {
      locala.aKh.cancel();
    }
    AppMethodBeat.o(77048);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77050);
    this.aFM.a(this.aIa, paramException, this.aFR.aKh, com.bumptech.glide.load.a.aEJ);
    AppMethodBeat.o(77050);
  }
  
  public final boolean ow()
  {
    AppMethodBeat.i(77046);
    Object localObject1 = this.aFL.oB();
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(77046);
      return false;
    }
    Object localObject2 = this.aFL;
    localObject2 = ((g)localObject2).aCm.aCn.b(((g)localObject2).aDf.getClass(), ((g)localObject2).aFX, ((g)localObject2).aDd);
    if (((List)localObject2).isEmpty())
    {
      if (File.class.equals(this.aFL.aDd))
      {
        AppMethodBeat.o(77046);
        return false;
      }
      localObject1 = new IllegalStateException("Failed to find any load path from " + this.aFL.aDf.getClass() + " to " + this.aFL.aDd);
      AppMethodBeat.o(77046);
      throw ((Throwable)localObject1);
    }
    do
    {
      this.aHZ = 0;
      do
      {
        com.bumptech.glide.load.g localg = (com.bumptech.glide.load.g)((List)localObject1).get(this.aFN);
        Class localClass = (Class)((List)localObject2).get(this.aHZ);
        l locall = this.aFL.n(localClass);
        this.aIa = new x(this.aFL.aCm.aCo, localg, this.aFL.aFT, this.aFL.width, this.aFL.height, locall, localClass, this.aFL.aFV);
        this.aFS = this.aFL.oz().c(this.aIa);
        if (this.aFS != null)
        {
          this.aFO = localg;
          this.aFP = this.aFL.t(this.aFS);
          this.aFQ = 0;
        }
        if ((this.aFP != null) && (ox())) {
          break;
        }
        this.aHZ += 1;
      } while (this.aHZ < ((List)localObject2).size());
      this.aFN += 1;
    } while (this.aFN < ((List)localObject1).size());
    AppMethodBeat.o(77046);
    return false;
    this.aFR = null;
    boolean bool = false;
    if ((!bool) && (ox()))
    {
      localObject1 = this.aFP;
      int i = this.aFQ;
      this.aFQ = (i + 1);
      this.aFR = ((n)((List)localObject1).get(i)).b(this.aFS, this.aFL.width, this.aFL.height, this.aFL.aFV);
      if ((this.aFR == null) || (!this.aFL.l(this.aFR.aKh.os()))) {
        break label516;
      }
      bool = true;
      this.aFR.aKh.a(this.aFL.aGc, this);
    }
    label516:
    for (;;)
    {
      break;
      AppMethodBeat.o(77046);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.w
 * JD-Core Version:    0.7.0.1
 */