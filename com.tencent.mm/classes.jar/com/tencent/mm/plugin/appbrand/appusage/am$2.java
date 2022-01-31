package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.ccn;
import java.util.Iterator;
import java.util.LinkedList;

final class am$2
  implements Iterator<Object[]>
{
  final Object[] hcT;
  final Iterator<ccn> hcW;
  
  am$2(am paramam, apo paramapo)
  {
    AppMethodBeat.i(129726);
    this.hcT = new Object[3];
    this.hcW = this.hcX.xfp.iterator();
    AppMethodBeat.o(129726);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(129727);
    boolean bool = this.hcW.hasNext();
    AppMethodBeat.o(129727);
    return bool;
  }
  
  public final void remove() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am.2
 * JD-Core Version:    0.7.0.1
 */