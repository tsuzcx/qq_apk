package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gmi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AppBrandProfileUI$c
{
  public final List<gmi> udQ;
  
  public AppBrandProfileUI$c(List<gmi> paramList)
  {
    this.udQ = paramList;
  }
  
  public final int size()
  {
    AppMethodBeat.i(322069);
    if ((this.udQ == null) || (this.udQ.isEmpty()))
    {
      AppMethodBeat.o(322069);
      return 0;
    }
    Iterator localIterator = this.udQ.iterator();
    label43:
    gmi localgmi;
    for (int i = 0; localIterator.hasNext(); i = localgmi.achw.size() + i)
    {
      localgmi = (gmi)localIterator.next();
      if ((localgmi == null) || (localgmi.achw == null) || (localgmi.achw.isEmpty())) {
        break label43;
      }
    }
    AppMethodBeat.o(322069);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.c
 * JD-Core Version:    0.7.0.1
 */