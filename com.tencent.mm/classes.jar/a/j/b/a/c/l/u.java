package a.j.b.a.c.l;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class u
  extends as
{
  public final ar[] CBt;
  public final ap[] CBu;
  private final boolean CBv;
  
  public u(List<? extends ar> paramList, List<? extends ap> paramList1)
  {
    this(paramList, (ap[])paramList1);
    AppMethodBeat.o(122597);
  }
  
  public u(ar[] paramArrayOfar, ap[] paramArrayOfap, boolean paramBoolean)
  {
    AppMethodBeat.i(122596);
    this.CBt = paramArrayOfar;
    this.CBu = paramArrayOfap;
    this.CBv = paramBoolean;
    if (this.CBt.length <= this.CBu.length) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramArrayOfar = (Throwable)new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.CBt.length + ", args=" + this.CBu.length);
      AppMethodBeat.o(122596);
      throw paramArrayOfar;
    }
    AppMethodBeat.o(122596);
  }
  
  public final ap O(w paramw)
  {
    AppMethodBeat.i(122595);
    j.q(paramw, "key");
    h localh = paramw.enU().ecR();
    paramw = localh;
    if (!(localh instanceof ar)) {
      paramw = null;
    }
    paramw = (ar)paramw;
    if (paramw == null)
    {
      AppMethodBeat.o(122595);
      return null;
    }
    int i = paramw.getIndex();
    if ((i < this.CBt.length) && (j.e(this.CBt[i].ecx(), paramw.ecx())))
    {
      paramw = this.CBu[i];
      AppMethodBeat.o(122595);
      return paramw;
    }
    AppMethodBeat.o(122595);
    return null;
  }
  
  public final boolean enV()
  {
    return this.CBv;
  }
  
  public final boolean isEmpty()
  {
    return this.CBu.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.l.u
 * JD-Core Version:    0.7.0.1
 */