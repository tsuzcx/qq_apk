package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fpi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AppBrandProfileUI$c
{
  public final List<fpi> qXP;
  
  public AppBrandProfileUI$c(List<fpi> paramList)
  {
    this.qXP = paramList;
  }
  
  public final int size()
  {
    AppMethodBeat.i(276537);
    if ((this.qXP == null) || (this.qXP.isEmpty()))
    {
      AppMethodBeat.o(276537);
      return 0;
    }
    Iterator localIterator = this.qXP.iterator();
    label43:
    fpi localfpi;
    for (int i = 0; localIterator.hasNext(); i = localfpi.UNa.size() + i)
    {
      localfpi = (fpi)localIterator.next();
      if ((localfpi == null) || (localfpi.UNa == null) || (localfpi.UNa.isEmpty())) {
        break label43;
      }
    }
    AppMethodBeat.o(276537);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.c
 * JD-Core Version:    0.7.0.1
 */