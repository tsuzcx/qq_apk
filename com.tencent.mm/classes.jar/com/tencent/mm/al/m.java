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
import com.tencent.mm.storage.r;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements q, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.b, c
{
  private r hTq;
  private com.tencent.mm.storage.s hTr;
  
  public final String aGd()
  {
    AppMethodBeat.i(188881);
    Object localObject = new StringBuilder();
    g.ajS();
    localObject = g.ajR().gDT + "bizcache/";
    AppMethodBeat.o(188881);
    return localObject;
  }
  
  public final List<String> ajY()
  {
    AppMethodBeat.i(124102);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/", "bizcache/" });
    AppMethodBeat.o(124102);
    return localLinkedList;
  }
  
  public final r azJ()
  {
    return this.hTq;
  }
  
  public final com.tencent.mm.storage.s azK()
  {
    return this.hTr;
  }
  
  public final String azZ()
  {
    AppMethodBeat.i(124101);
    Object localObject = new StringBuilder();
    g.ajS();
    localObject = g.ajR().gDT + "brandicon/";
    AppMethodBeat.o(124101);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(124103);
    paramc = ((l)g.ab(l.class)).doJ();
    r localr = new r(paramc);
    this.hTq = localr;
    paramc.a(localr);
    this.hTr = new com.tencent.mm.storage.s(((l)g.ab(l.class)).azL());
    AppMethodBeat.o(124103);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(124104);
    a.a(this, c.class).bA(g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class));
    AppMethodBeat.o(124104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.m
 * JD-Core Version:    0.7.0.1
 */