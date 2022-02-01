package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements q, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.b, c
{
  private t iOE;
  private u iOF;
  
  public final List<String> aAo()
  {
    AppMethodBeat.i(124102);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/", "bizcache/" });
    AppMethodBeat.o(124102);
    return localLinkedList;
  }
  
  public final t aSR()
  {
    return this.iOE;
  }
  
  public final u aSS()
  {
    return this.iOF;
  }
  
  public final String aTh()
  {
    AppMethodBeat.i(124101);
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = g.aAh().hqG + "brandicon/";
    AppMethodBeat.o(124101);
    return localObject;
  }
  
  public final String aZV()
  {
    AppMethodBeat.i(212174);
    Object localObject = new StringBuilder();
    g.aAi();
    localObject = g.aAh().hqG + "bizcache/";
    AppMethodBeat.o(212174);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(124103);
    paramc = ((l)g.af(l.class)).eiy();
    t localt = new t(paramc);
    this.iOE = localt;
    paramc.a(localt);
    this.iOF = new u(((l)g.af(l.class)).aST());
    AppMethodBeat.o(124103);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(124104);
    a.a(this, c.class).bI(g.ah(s.class));
    AppMethodBeat.o(124104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.m
 * JD-Core Version:    0.7.0.1
 */