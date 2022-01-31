package com.tencent.mm.ai;

import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l
  implements o, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.b, c
{
  private com.tencent.mm.storage.o egA;
  private com.tencent.mm.storage.p egB;
  
  public final com.tencent.mm.storage.p FA()
  {
    return this.egB;
  }
  
  public final String FP()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "brandicon/";
  }
  
  public final com.tencent.mm.storage.o Fz()
  {
    return this.egA;
  }
  
  public final List<String> collectStoragePaths()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "brandicon/" });
    return localLinkedList;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    paramc = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO();
    com.tencent.mm.storage.o localo = new com.tencent.mm.storage.o(paramc);
    this.egA = localo;
    paramc.a(localo);
    this.egB = new com.tencent.mm.storage.p(((j)com.tencent.mm.kernel.g.r(j.class)).FB());
  }
  
  public final void onAccountRelease() {}
  
  public final void parallelsDependency()
  {
    a.a(this, c.class).ao(com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.l
 * JD-Core Version:    0.7.0.1
 */