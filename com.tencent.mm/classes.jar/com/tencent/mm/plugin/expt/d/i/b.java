package com.tencent.mm.plugin.expt.d.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class b
{
  public r.a syB;
  
  public final boolean a(List<List<com.tencent.mm.plugin.expt.d.e.b>> paramList, com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(220377);
    if ((this.syB == null) || (paramList == null) || (paramList.size() <= 0) || (paramb == null))
    {
      AppMethodBeat.o(220377);
      return false;
    }
    Log.d("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult, configID : %s", new Object[] { paramb.syg });
    paramb = new a(this.syB, paramb.syg, paramb.sym);
    if (!paramb.cNc())
    {
      Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult create table for isnot exist!");
      if (!paramb.cNd())
      {
        Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createTable fail!");
        AppMethodBeat.o(220377);
        return false;
      }
      if (!paramb.cNe()) {
        Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createIndex fail!");
      }
    }
    for (;;)
    {
      boolean bool = paramb.dp(paramList);
      AppMethodBeat.o(220377);
      return bool;
      paramb.cNf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.i.b
 * JD-Core Version:    0.7.0.1
 */