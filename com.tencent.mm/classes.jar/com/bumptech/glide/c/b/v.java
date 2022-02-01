package com.bumptech.glide.c.b;

import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.a.d.a;
import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.n.a;
import com.bumptech.glide.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.List;

final class v
  implements d.a<Object>, e
{
  private final f<?> aFT;
  private final e.a aFU;
  private int aFV;
  private com.bumptech.glide.c.h aFW;
  private List<n<File, ?>> aFX;
  private int aFY;
  private volatile n.a<?> aFZ;
  private File aGa;
  private int aIf = -1;
  private w aIg;
  
  v(f<?> paramf, e.a parama)
  {
    this.aFT = paramf;
    this.aFU = parama;
  }
  
  private boolean or()
  {
    AppMethodBeat.i(77047);
    if (this.aFY < this.aFX.size())
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
    this.aFU.a(this.aFW, paramObject, this.aFZ.aKp, com.bumptech.glide.c.a.aEJ, this.aIg);
    AppMethodBeat.o(77049);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77048);
    n.a locala = this.aFZ;
    if (locala != null) {
      locala.aKp.cancel();
    }
    AppMethodBeat.o(77048);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77050);
    this.aFU.a(this.aIg, paramException, this.aFZ.aKp, com.bumptech.glide.c.a.aEJ);
    AppMethodBeat.o(77050);
  }
  
  public final boolean oq()
  {
    AppMethodBeat.i(77046);
    List localList = this.aFT.ov();
    if (localList.isEmpty())
    {
      AppMethodBeat.o(77046);
      return false;
    }
    Object localObject = this.aFT;
    localObject = ((f)localObject).aCn.aCo.b(((f)localObject).aDg.getClass(), ((f)localObject).aGf, ((f)localObject).aDd);
    if ((((List)localObject).isEmpty()) && (File.class.equals(this.aFT.aDd)))
    {
      AppMethodBeat.o(77046);
      return false;
    }
    do
    {
      this.aIf = 0;
      do
      {
        com.bumptech.glide.c.h localh = (com.bumptech.glide.c.h)localList.get(this.aFV);
        Class localClass = (Class)((List)localObject).get(this.aIf);
        m localm = this.aFT.m(localClass);
        this.aIg = new w(this.aFT.aCn.aCp, localh, this.aFT.aGb, this.aFT.width, this.aFT.height, localm, localClass, this.aFT.aGd);
        this.aGa = this.aFT.ot().a(this.aIg);
        if (this.aGa != null)
        {
          this.aFW = localh;
          this.aFX = this.aFT.t(this.aGa);
          this.aFY = 0;
        }
        if ((this.aFX != null) && (or())) {
          break;
        }
        this.aIf += 1;
      } while (this.aIf < ((List)localObject).size());
      this.aFV += 1;
    } while (this.aFV < localList.size());
    AppMethodBeat.o(77046);
    return false;
    this.aFZ = null;
    boolean bool = false;
    if ((!bool) && (or()))
    {
      localList = this.aFX;
      int i = this.aFY;
      this.aFY = (i + 1);
      this.aFZ = ((n)localList.get(i)).b(this.aGa, this.aFT.width, this.aFT.height, this.aFT.aGd);
      if ((this.aFZ == null) || (!this.aFT.k(this.aFZ.aKp.om()))) {
        break label461;
      }
      bool = true;
      this.aFZ.aKp.a(this.aFT.aGk, this);
    }
    label461:
    for (;;)
    {
      break;
      AppMethodBeat.o(77046);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.v
 * JD-Core Version:    0.7.0.1
 */