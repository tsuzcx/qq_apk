package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.s;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements q, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.b, c
{
  private com.tencent.mm.storage.r hQy;
  private s hQz;
  
  public final String aFN()
  {
    AppMethodBeat.i(207183);
    Object localObject = new StringBuilder();
    g.ajD();
    localObject = g.ajC().gBm + "bizcache/";
    AppMethodBeat.o(207183);
    return localObject;
  }
  
  public final List<String> ajJ()
  {
    AppMethodBeat.i(124102);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/", "bizcache/" });
    AppMethodBeat.o(124102);
    return localLinkedList;
  }
  
  public final String azJ()
  {
    AppMethodBeat.i(124101);
    Object localObject = new StringBuilder();
    g.ajD();
    localObject = g.ajC().gBm + "brandicon/";
    AppMethodBeat.o(124101);
    return localObject;
  }
  
  public final com.tencent.mm.storage.r azt()
  {
    return this.hQy;
  }
  
  public final s azu()
  {
    return this.hQz;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(124103);
    paramc = ((l)g.ab(l.class)).dlK();
    com.tencent.mm.storage.r localr = new com.tencent.mm.storage.r(paramc);
    this.hQy = localr;
    paramc.a(localr);
    this.hQz = new s(((l)g.ab(l.class)).azv());
    AppMethodBeat.o(124103);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(124104);
    a.a(this, c.class).bA(g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class));
    AppMethodBeat.o(124104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.m
 * JD-Core Version:    0.7.0.1
 */