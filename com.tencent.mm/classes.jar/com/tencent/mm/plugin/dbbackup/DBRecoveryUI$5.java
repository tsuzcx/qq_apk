package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.dbbackup.a.a.c;
import com.tencent.mm.plugin.dbbackup.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class DBRecoveryUI$5
  implements a.c
{
  private Collection<String> oao;
  private int oap;
  
  DBRecoveryUI$5(DBRecoveryUI paramDBRecoveryUI)
  {
    AppMethodBeat.i(23057);
    com.tencent.mm.kernel.g.afz();
    this.oap = a.getUin();
    AppMethodBeat.o(23057);
  }
  
  private void bPQ()
  {
    AppMethodBeat.i(23058);
    if (this.oao == null) {
      this.oao = b.bQf();
    }
    AppMethodBeat.o(23058);
  }
  
  public final Collection<byte[]> bPR()
  {
    AppMethodBeat.i(23059);
    bPQ();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.oao.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.b.g.E((str + this.oap).getBytes()));
    }
    AppMethodBeat.o(23059);
    return localArrayList;
  }
  
  public final Collection<byte[]> bPS()
  {
    AppMethodBeat.i(23060);
    bPQ();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.oao.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest((str + this.oap).getBytes()).substring(0, 7).getBytes());
    }
    AppMethodBeat.o(23060);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.5
 * JD-Core Version:    0.7.0.1
 */