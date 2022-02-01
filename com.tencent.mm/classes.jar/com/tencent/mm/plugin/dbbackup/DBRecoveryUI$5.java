package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.dbbackup.a.a.d;
import com.tencent.mm.plugin.dbbackup.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class DBRecoveryUI$5
  implements a.d
{
  private Collection<String> phn;
  private int pho;
  
  DBRecoveryUI$5(DBRecoveryUI paramDBRecoveryUI)
  {
    AppMethodBeat.i(23057);
    com.tencent.mm.kernel.g.ajA();
    this.pho = a.getUin();
    AppMethodBeat.o(23057);
  }
  
  private void cbJ()
  {
    AppMethodBeat.i(23058);
    if (this.phn == null) {
      this.phn = b.cbZ();
    }
    AppMethodBeat.o(23058);
  }
  
  public final Collection<byte[]> cbK()
  {
    AppMethodBeat.i(23059);
    cbJ();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.phn.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.b.g.C((str + this.pho).getBytes()));
    }
    AppMethodBeat.o(23059);
    return localArrayList;
  }
  
  public final Collection<byte[]> cbL()
  {
    AppMethodBeat.i(23060);
    cbJ();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.phn.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.b.g.getMessageDigest((str + this.pho).getBytes()).substring(0, 7).getBytes());
    }
    AppMethodBeat.o(23060);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.5
 * JD-Core Version:    0.7.0.1
 */