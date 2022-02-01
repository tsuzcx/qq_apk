package com.tencent.mm.am;

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
  private com.tencent.mm.storage.p gXF;
  private com.tencent.mm.storage.q gXG;
  
  public final List<String> afI()
  {
    AppMethodBeat.i(124102);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/", "bizcache/" });
    AppMethodBeat.o(124102);
    return localLinkedList;
  }
  
  public final com.tencent.mm.storage.p apP()
  {
    return this.gXF;
  }
  
  public final com.tencent.mm.storage.q apQ()
  {
    return this.gXG;
  }
  
  public final String aqf()
  {
    AppMethodBeat.i(124101);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = g.afB().gcW + "brandicon/";
    AppMethodBeat.o(124101);
    return localObject;
  }
  
  public final String avS()
  {
    AppMethodBeat.i(191056);
    Object localObject = new StringBuilder();
    g.afC();
    localObject = g.afB().gcW + "bizcache/";
    AppMethodBeat.o(191056);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(124103);
    paramc = ((k)g.ab(k.class)).cOI();
    com.tencent.mm.storage.p localp = new com.tencent.mm.storage.p(paramc);
    this.gXF = localp;
    paramc.a(localp);
    this.gXG = new com.tencent.mm.storage.q(((k)g.ab(k.class)).apR());
    AppMethodBeat.o(124103);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(124104);
    a.a(this, c.class).bB(g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class));
    AppMethodBeat.o(124104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.l
 * JD-Core Version:    0.7.0.1
 */