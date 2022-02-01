package com.tencent.mm.plugin.expt.d.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

public final class b
{
  public r.a qYs;
  
  public final boolean a(List<List<com.tencent.mm.plugin.expt.d.e.b>> paramList, com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(195954);
    if ((this.qYs == null) || (paramList == null) || (paramList.size() <= 0) || (paramb == null))
    {
      AppMethodBeat.o(195954);
      return false;
    }
    ae.d("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult, configID : %s", new Object[] { paramb.qXW });
    paramb = new a(this.qYs, paramb.qXW, paramb.qYc);
    if (!paramb.coP())
    {
      ae.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult create table for isnot exist!");
      if (!paramb.coQ())
      {
        ae.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createTable fail!");
        AppMethodBeat.o(195954);
        return false;
      }
      if (!paramb.coR()) {
        ae.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createIndex fail!");
      }
    }
    for (;;)
    {
      boolean bool = paramb.db(paramList);
      AppMethodBeat.o(195954);
      return bool;
      paramb.coS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.i.b
 * JD-Core Version:    0.7.0.1
 */