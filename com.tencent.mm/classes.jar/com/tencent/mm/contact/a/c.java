package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.a.a.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.as;
import com.tencent.mm.openim.c.a;
import com.tencent.mm.openim.c.i;
import com.tencent.mm.openim.c.k;
import com.tencent.mm.openim.c.o;
import com.tencent.mm.openim.c.p;
import com.tencent.mm.openim.c.q;
import com.tencent.mm.openim.c.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.storage.au;

public final class c
  implements u
{
  public final void DY(String paramString)
  {
    AppMethodBeat.i(233774);
    if (au.bwF(paramString))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new i(paramString, 1));
      AppMethodBeat.o(233774);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new r(paramString, 1));
    AppMethodBeat.o(233774);
  }
  
  public final void DZ(String paramString)
  {
    AppMethodBeat.i(233780);
    if (au.bwF(paramString))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new i(paramString, 2));
      AppMethodBeat.o(233780);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new r(paramString, 2));
    AppMethodBeat.o(233780);
  }
  
  public final as Ea(String paramString)
  {
    AppMethodBeat.i(233784);
    b localb = new b(true);
    localb.a(new q(paramString, 1));
    AppMethodBeat.o(233784);
    return localb;
  }
  
  public final as Eb(String paramString)
  {
    AppMethodBeat.i(233789);
    b localb = new b(true);
    localb.a(new q(paramString, 2));
    AppMethodBeat.o(233789);
    return localb;
  }
  
  public final void Ec(String paramString)
  {
    AppMethodBeat.i(233793);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new p(paramString, 1));
    AppMethodBeat.o(233793);
  }
  
  public final void Ed(String paramString)
  {
    AppMethodBeat.i(233795);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new p(paramString, 2));
    AppMethodBeat.o(233795);
  }
  
  public final void Ee(String paramString)
  {
    AppMethodBeat.i(233798);
    if (au.bwO(paramString))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new k(paramString, 1));
      AppMethodBeat.o(233798);
      return;
    }
    if (au.bwQ(paramString)) {
      ((com.tencent.mm.openim.api.c)h.ax(com.tencent.mm.openim.api.c.class)).Ee(paramString);
    }
    AppMethodBeat.o(233798);
  }
  
  public final void Ef(String paramString)
  {
    AppMethodBeat.i(233800);
    if (au.bwO(paramString))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new k(paramString, 2));
      AppMethodBeat.o(233800);
      return;
    }
    if (au.bwQ(paramString)) {
      ((com.tencent.mm.openim.api.c)h.ax(com.tencent.mm.openim.api.c.class)).Ef(paramString);
    }
    AppMethodBeat.o(233800);
  }
  
  public final void Eg(String paramString)
  {
    AppMethodBeat.i(233801);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new a(paramString));
    AppMethodBeat.o(233801);
  }
  
  public final void Eh(String paramString)
  {
    AppMethodBeat.i(233802);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new o(paramString, 1));
    AppMethodBeat.o(233802);
  }
  
  public final void Ei(String paramString)
  {
    AppMethodBeat.i(233803);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new o(paramString, 2));
    AppMethodBeat.o(233803);
  }
  
  public final void aw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(233796);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new com.tencent.mm.openim.c.n(paramString1, paramString2));
    AppMethodBeat.o(233796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.contact.a.c
 * JD-Core Version:    0.7.0.1
 */