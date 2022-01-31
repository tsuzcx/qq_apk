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
  private Collection<String> kTK;
  private int kTL;
  
  DBRecoveryUI$5(DBRecoveryUI paramDBRecoveryUI)
  {
    AppMethodBeat.i(18948);
    com.tencent.mm.kernel.g.RJ();
    this.kTL = a.getUin();
    AppMethodBeat.o(18948);
  }
  
  private void biM()
  {
    AppMethodBeat.i(18949);
    if (this.kTK == null) {
      this.kTK = b.bjb();
    }
    AppMethodBeat.o(18949);
  }
  
  public final Collection<byte[]> biN()
  {
    AppMethodBeat.i(18950);
    biM();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kTK.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.a.g.x((str + this.kTL).getBytes()));
    }
    AppMethodBeat.o(18950);
    return localArrayList;
  }
  
  public final Collection<byte[]> biO()
  {
    AppMethodBeat.i(18951);
    biM();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kTK.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(com.tencent.mm.a.g.w((str + this.kTL).getBytes()).substring(0, 7).getBytes());
    }
    AppMethodBeat.o(18951);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.5
 * JD-Core Version:    0.7.0.1
 */