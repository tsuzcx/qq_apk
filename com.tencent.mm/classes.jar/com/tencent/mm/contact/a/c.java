package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.x;
import com.tencent.mm.openim.d.a;
import com.tencent.mm.openim.d.f;
import com.tencent.mm.openim.d.h;
import com.tencent.mm.openim.d.k;
import com.tencent.mm.openim.d.m;
import com.tencent.mm.openim.d.n;
import com.tencent.mm.openim.d.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;

public final class c
  implements r
{
  public final void ak(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221704);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k(paramString1, paramString2));
    AppMethodBeat.o(221704);
  }
  
  public final void wj(String paramString)
  {
    AppMethodBeat.i(221698);
    if (x.zV(paramString))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new f(paramString, 1));
      AppMethodBeat.o(221698);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new o(paramString, 1));
    AppMethodBeat.o(221698);
  }
  
  public final void wk(String paramString)
  {
    AppMethodBeat.i(221699);
    if (x.zV(paramString))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new f(paramString, 2));
      AppMethodBeat.o(221699);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new o(paramString, 2));
    AppMethodBeat.o(221699);
  }
  
  public final am wl(String paramString)
  {
    AppMethodBeat.i(221700);
    b localb = new b(true);
    localb.a(new n(paramString, 1));
    AppMethodBeat.o(221700);
    return localb;
  }
  
  public final am wm(String paramString)
  {
    AppMethodBeat.i(221701);
    b localb = new b(true);
    localb.a(new n(paramString, 2));
    AppMethodBeat.o(221701);
    return localb;
  }
  
  public final void wn(String paramString)
  {
    AppMethodBeat.i(221702);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new m(paramString, 1));
    AppMethodBeat.o(221702);
  }
  
  public final void wo(String paramString)
  {
    AppMethodBeat.i(221703);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new m(paramString, 2));
    AppMethodBeat.o(221703);
  }
  
  public final void wp(String paramString)
  {
    AppMethodBeat.i(221705);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new h(paramString, 1));
    AppMethodBeat.o(221705);
  }
  
  public final void wq(String paramString)
  {
    AppMethodBeat.i(221706);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new h(paramString, 2));
    AppMethodBeat.o(221706);
  }
  
  public final void wr(String paramString)
  {
    AppMethodBeat.i(221707);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new a(paramString));
    AppMethodBeat.o(221707);
  }
  
  public final void ws(String paramString)
  {
    AppMethodBeat.i(221708);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.openim.d.l(paramString, 1));
    AppMethodBeat.o(221708);
  }
  
  public final void wt(String paramString)
  {
    AppMethodBeat.i(221709);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.openim.d.l(paramString, 2));
    AppMethodBeat.o(221709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.contact.a.c
 * JD-Core Version:    0.7.0.1
 */