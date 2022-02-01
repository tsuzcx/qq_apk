package com.tencent.mm.an;

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
  private t owA;
  private u owB;
  
  public final String bGV()
  {
    AppMethodBeat.i(239449);
    Object localObject = new StringBuilder();
    h.baF();
    localObject = h.baE().mCJ + "bizcache/";
    AppMethodBeat.o(239449);
    return localObject;
  }
  
  public final List<String> baM()
  {
    AppMethodBeat.i(124102);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/", "bizcache/" });
    AppMethodBeat.o(124102);
    return localLinkedList;
  }
  
  public final t bzE()
  {
    return this.owA;
  }
  
  public final u bzF()
  {
    return this.owB;
  }
  
  public final String bzU()
  {
    AppMethodBeat.i(124101);
    Object localObject = new StringBuilder();
    h.baF();
    localObject = h.baE().mCJ + "brandicon/";
    AppMethodBeat.o(124101);
    return localObject;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(124103);
    paramc = ((n)h.ax(n.class)).gaZ();
    t localt = new t(paramc);
    this.owA = localt;
    paramc.a(localt);
    this.owB = new u(((n)h.ax(n.class)).bzG());
    AppMethodBeat.o(124103);
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    AppMethodBeat.i(124104);
    a.a(this, c.class).db(h.az(v.class));
    AppMethodBeat.o(124104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.m
 * JD-Core Version:    0.7.0.1
 */