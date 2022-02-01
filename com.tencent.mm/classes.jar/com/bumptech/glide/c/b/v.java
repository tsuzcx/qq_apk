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
  private final f<?> aEc;
  private final e.a aEd;
  private int aEe;
  private com.bumptech.glide.c.h aEf;
  private List<n<File, ?>> aEg;
  private int aEh;
  private volatile n.a<?> aEi;
  private File aEj;
  private int aGo = -1;
  private w aGp;
  
  v(f<?> paramf, e.a parama)
  {
    this.aEc = paramf;
    this.aEd = parama;
  }
  
  private boolean nZ()
  {
    AppMethodBeat.i(77047);
    if (this.aEh < this.aEg.size())
    {
      AppMethodBeat.o(77047);
      return true;
    }
    AppMethodBeat.o(77047);
    return false;
  }
  
  public final void R(Object paramObject)
  {
    AppMethodBeat.i(77049);
    this.aEd.a(this.aEf, paramObject, this.aEi.aIy, com.bumptech.glide.c.a.aCS, this.aGp);
    AppMethodBeat.o(77049);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77048);
    n.a locala = this.aEi;
    if (locala != null) {
      locala.aIy.cancel();
    }
    AppMethodBeat.o(77048);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77050);
    this.aEd.a(this.aGp, paramException, this.aEi.aIy, com.bumptech.glide.c.a.aCS);
    AppMethodBeat.o(77050);
  }
  
  public final boolean nY()
  {
    AppMethodBeat.i(77046);
    List localList = this.aEc.od();
    if (localList.isEmpty())
    {
      AppMethodBeat.o(77046);
      return false;
    }
    Object localObject = this.aEc;
    localObject = ((f)localObject).aAw.aAx.b(((f)localObject).aBp.getClass(), ((f)localObject).aEo, ((f)localObject).aBm);
    if ((((List)localObject).isEmpty()) && (File.class.equals(this.aEc.aBm)))
    {
      AppMethodBeat.o(77046);
      return false;
    }
    do
    {
      this.aGo = 0;
      do
      {
        com.bumptech.glide.c.h localh = (com.bumptech.glide.c.h)localList.get(this.aEe);
        Class localClass = (Class)((List)localObject).get(this.aGo);
        m localm = this.aEc.m(localClass);
        this.aGp = new w(this.aEc.aAw.aAy, localh, this.aEc.aEk, this.aEc.width, this.aEc.height, localm, localClass, this.aEc.aEm);
        this.aEj = this.aEc.ob().a(this.aGp);
        if (this.aEj != null)
        {
          this.aEf = localh;
          this.aEg = this.aEc.t(this.aEj);
          this.aEh = 0;
        }
        if ((this.aEg != null) && (nZ())) {
          break;
        }
        this.aGo += 1;
      } while (this.aGo < ((List)localObject).size());
      this.aEe += 1;
    } while (this.aEe < localList.size());
    AppMethodBeat.o(77046);
    return false;
    this.aEi = null;
    boolean bool = false;
    if ((!bool) && (nZ()))
    {
      localList = this.aEg;
      int i = this.aEh;
      this.aEh = (i + 1);
      this.aEi = ((n)localList.get(i)).b(this.aEj, this.aEc.width, this.aEc.height, this.aEc.aEm);
      if ((this.aEi == null) || (!this.aEc.k(this.aEi.aIy.nU()))) {
        break label461;
      }
      bool = true;
      this.aEi.aIy.a(this.aEc.aEt, this);
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