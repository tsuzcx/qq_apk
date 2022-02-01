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
  private Collection<String> oDN;
  private int oDO;
  
  DBRecoveryUI$5(DBRecoveryUI paramDBRecoveryUI)
  {
    AppMethodBeat.i(23057);
    com.tencent.mm.kernel.g.agP();
    this.oDO = a.getUin();
    AppMethodBeat.o(23057);
  }
  
  private void bXg()
  {
    AppMethodBeat.i(23058);
    if (this.oDN == null) {
      this.oDN = b.bXw();
    }
    AppMethodBeat.o(23058);
  }
  
  public final Collection<byte[]> bXh()
  {
    AppMethodBeat.i(23059);
    bXg();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.oDN.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.b.g.C((str + this.oDO).getBytes()));
    }
    AppMethodBeat.o(23059);
    return localArrayList;
  }
  
  public final Collection<byte[]> bXi()
  {
    AppMethodBeat.i(23060);
    bXg();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.oDN.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest((str + this.oDO).getBytes()).substring(0, 7).getBytes());
    }
    AppMethodBeat.o(23060);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.5
 * JD-Core Version:    0.7.0.1
 */