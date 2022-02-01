package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l
  implements p, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.b, c
{
  private com.tencent.mm.storage.p hye;
  private com.tencent.mm.storage.q hyf;
  
  public final String aCK()
  {
    AppMethodBeat.i(209532);
    Object localObject = new StringBuilder();
    g.agS();
    localObject = g.agR().ghC + "bizcache/";
    AppMethodBeat.o(209532);
    return localObject;
  }
  
  public final List<String> agY()
  {
    AppMethodBeat.i(124102);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/", "bizcache/" });
    AppMethodBeat.o(124102);
    return localLinkedList;
  }
  
  public final com.tencent.mm.storage.p awE()
  {
    return this.hye;
  }
  
  public final com.tencent.mm.storage.q awF()
  {
    return this.hyf;
  }
  
  public final String awU()
  {
    AppMethodBeat.i(124101);
    Object localObject = new StringBuilder();
    g.agS();
    localObject = g.agR().ghC + "brandicon/";
    AppMethodBeat.o(124101);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(124103);
    paramc = ((k)g.ab(k.class)).dcr();
    com.tencent.mm.storage.p localp = new com.tencent.mm.storage.p(paramc);
    this.hye = localp;
    paramc.a(localp);
    this.hyf = new com.tencent.mm.storage.q(((k)g.ab(k.class)).awG());
    AppMethodBeat.o(124103);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(124104);
    a.a(this, c.class).by(g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class));
    AppMethodBeat.o(124104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.l
 * JD-Core Version:    0.7.0.1
 */