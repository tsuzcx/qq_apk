package com.tencent.mm.openim.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;

public final class p
  implements com.tencent.mm.openim.a.a
{
  public final void al(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78941);
    ((j)g.E(j.class)).Yz().c(new k(paramString1, paramString2));
    AppMethodBeat.o(78941);
  }
  
  public final void pc(String paramString)
  {
    AppMethodBeat.i(78935);
    if (t.nK(paramString))
    {
      ((j)g.E(j.class)).Yz().c(new f(paramString, 1));
      AppMethodBeat.o(78935);
      return;
    }
    ((j)g.E(j.class)).Yz().c(new o(paramString, 1));
    AppMethodBeat.o(78935);
  }
  
  public final void pd(String paramString)
  {
    AppMethodBeat.i(78936);
    if (t.nK(paramString))
    {
      ((j)g.E(j.class)).Yz().c(new f(paramString, 2));
      AppMethodBeat.o(78936);
      return;
    }
    ((j)g.E(j.class)).Yz().c(new o(paramString, 2));
    AppMethodBeat.o(78936);
  }
  
  public final void pe(String paramString)
  {
    AppMethodBeat.i(78937);
    ((j)g.E(j.class)).Yz().c(new n(paramString, 1));
    AppMethodBeat.o(78937);
  }
  
  public final void pf(String paramString)
  {
    AppMethodBeat.i(78938);
    ((j)g.E(j.class)).Yz().c(new n(paramString, 2));
    AppMethodBeat.o(78938);
  }
  
  public final void pg(String paramString)
  {
    AppMethodBeat.i(78939);
    ((j)g.E(j.class)).Yz().c(new m(paramString, 1));
    AppMethodBeat.o(78939);
  }
  
  public final void ph(String paramString)
  {
    AppMethodBeat.i(78940);
    ((j)g.E(j.class)).Yz().c(new m(paramString, 2));
    AppMethodBeat.o(78940);
  }
  
  public final void pi(String paramString)
  {
    AppMethodBeat.i(78942);
    ((j)g.E(j.class)).Yz().c(new h(paramString, 1));
    AppMethodBeat.o(78942);
  }
  
  public final void pj(String paramString)
  {
    AppMethodBeat.i(78943);
    ((j)g.E(j.class)).Yz().c(new h(paramString, 2));
    AppMethodBeat.o(78943);
  }
  
  public final void wg(String paramString)
  {
    AppMethodBeat.i(78944);
    ((j)g.E(j.class)).Yz().c(new a(paramString));
    AppMethodBeat.o(78944);
  }
  
  public final void wh(String paramString)
  {
    AppMethodBeat.i(78945);
    ((j)g.E(j.class)).Yz().c(new l(paramString, 1));
    AppMethodBeat.o(78945);
  }
  
  public final void wi(String paramString)
  {
    AppMethodBeat.i(78946);
    ((j)g.E(j.class)).Yz().c(new l(paramString, 2));
    AppMethodBeat.o(78946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.d.p
 * JD-Core Version:    0.7.0.1
 */