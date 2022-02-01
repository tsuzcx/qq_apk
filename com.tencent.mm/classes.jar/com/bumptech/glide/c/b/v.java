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
  private final f<?> aDl;
  private final e.a aDm;
  private int aDn;
  private com.bumptech.glide.c.h aDo;
  private List<n<File, ?>> aDp;
  private int aDq;
  private volatile n.a<?> aDr;
  private File aDs;
  private int aFy = -1;
  private w aFz;
  
  v(f<?> paramf, e.a parama)
  {
    this.aDl = paramf;
    this.aDm = parama;
  }
  
  private boolean nP()
  {
    AppMethodBeat.i(77047);
    if (this.aDq < this.aDp.size())
    {
      AppMethodBeat.o(77047);
      return true;
    }
    AppMethodBeat.o(77047);
    return false;
  }
  
  public final void P(Object paramObject)
  {
    AppMethodBeat.i(77049);
    this.aDm.a(this.aDo, paramObject, this.aDr.aHI, com.bumptech.glide.c.a.aCa, this.aFz);
    AppMethodBeat.o(77049);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(77048);
    n.a locala = this.aDr;
    if (locala != null) {
      locala.aHI.cancel();
    }
    AppMethodBeat.o(77048);
  }
  
  public final void e(Exception paramException)
  {
    AppMethodBeat.i(77050);
    this.aDm.a(this.aFz, paramException, this.aDr.aHI, com.bumptech.glide.c.a.aCa);
    AppMethodBeat.o(77050);
  }
  
  public final boolean nO()
  {
    AppMethodBeat.i(77046);
    List localList = this.aDl.nT();
    if (localList.isEmpty())
    {
      AppMethodBeat.o(77046);
      return false;
    }
    Object localObject = this.aDl;
    localObject = ((f)localObject).azC.azD.b(((f)localObject).aAv.getClass(), ((f)localObject).aDx, ((f)localObject).aAs);
    if ((((List)localObject).isEmpty()) && (File.class.equals(this.aDl.aAs)))
    {
      AppMethodBeat.o(77046);
      return false;
    }
    do
    {
      this.aFy = 0;
      do
      {
        com.bumptech.glide.c.h localh = (com.bumptech.glide.c.h)localList.get(this.aDn);
        Class localClass = (Class)((List)localObject).get(this.aFy);
        m localm = this.aDl.m(localClass);
        this.aFz = new w(this.aDl.azC.azE, localh, this.aDl.aDt, this.aDl.width, this.aDl.height, localm, localClass, this.aDl.aDv);
        this.aDs = this.aDl.nR().a(this.aFz);
        if (this.aDs != null)
        {
          this.aDo = localh;
          this.aDp = this.aDl.t(this.aDs);
          this.aDq = 0;
        }
        if ((this.aDp != null) && (nP())) {
          break;
        }
        this.aFy += 1;
      } while (this.aFy < ((List)localObject).size());
      this.aDn += 1;
    } while (this.aDn < localList.size());
    AppMethodBeat.o(77046);
    return false;
    this.aDr = null;
    boolean bool = false;
    if ((!bool) && (nP()))
    {
      localList = this.aDp;
      int i = this.aDq;
      this.aDq = (i + 1);
      this.aDr = ((n)localList.get(i)).b(this.aDs, this.aDl.width, this.aDl.height, this.aDl.aDv);
      if ((this.aDr == null) || (!this.aDl.k(this.aDr.aHI.nK()))) {
        break label461;
      }
      bool = true;
      this.aDr.aHI.a(this.aDl.aDC, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.v
 * JD-Core Version:    0.7.0.1
 */