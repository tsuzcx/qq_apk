package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements q, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.b, c
{
  private t lEU;
  private u lEV;
  
  public final List<String> aHP()
  {
    AppMethodBeat.i(124102);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/", "bizcache/" });
    AppMethodBeat.o(124102);
    return localLinkedList;
  }
  
  public final t bbP()
  {
    return this.lEU;
  }
  
  public final u bbQ()
  {
    return this.lEV;
  }
  
  public final String bcf()
  {
    AppMethodBeat.i(124101);
    Object localObject = new StringBuilder();
    h.aHH();
    localObject = h.aHG().kcB + "brandicon/";
    AppMethodBeat.o(124101);
    return localObject;
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(205888);
    Object localObject = new StringBuilder();
    h.aHH();
    localObject = h.aHG().kcB + "bizcache/";
    AppMethodBeat.o(205888);
    return localObject;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(124103);
    paramc = ((n)h.ae(n.class)).eSe();
    t localt = new t(paramc);
    this.lEU = localt;
    paramc.a(localt);
    this.lEV = new u(((n)h.ae(n.class)).bbR());
    AppMethodBeat.o(124103);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(124104);
    a.a(this, c.class).bI(h.ag(v.class));
    AppMethodBeat.o(124104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.m
 * JD-Core Version:    0.7.0.1
 */