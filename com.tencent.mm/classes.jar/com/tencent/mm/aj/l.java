package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l
  implements o, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.b, c
{
  private com.tencent.mm.storage.o fwE;
  private com.tencent.mm.storage.p fwF;
  
  public final List<String> RR()
  {
    AppMethodBeat.i(11417);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/" });
    AppMethodBeat.o(11417);
    return localLinkedList;
  }
  
  public final com.tencent.mm.storage.o YD()
  {
    return this.fwE;
  }
  
  public final com.tencent.mm.storage.p YE()
  {
    return this.fwF;
  }
  
  public final String YT()
  {
    AppMethodBeat.i(11416);
    Object localObject = new StringBuilder();
    g.RM();
    localObject = g.RL().eHR + "brandicon/";
    AppMethodBeat.o(11416);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(11418);
    paramc = ((j)g.E(j.class)).bPQ();
    com.tencent.mm.storage.o localo = new com.tencent.mm.storage.o(paramc);
    this.fwE = localo;
    paramc.a(localo);
    this.fwF = new com.tencent.mm.storage.p(((j)g.E(j.class)).YF());
    AppMethodBeat.o(11418);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(11419);
    a.a(this, c.class).az(g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class));
    AppMethodBeat.o(11419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.l
 * JD-Core Version:    0.7.0.1
 */