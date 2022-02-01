package com.tencent.mm.plugin.expt.edge.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class b
{
  public o.a zys;
  
  public final boolean a(List<List<com.tencent.mm.plugin.expt.edge.e.b>> paramList, com.tencent.mm.plugin.expt.edge.e.a.b paramb)
  {
    AppMethodBeat.i(299622);
    if ((this.zys == null) || (paramList == null) || (paramList.size() <= 0) || (paramb == null))
    {
      AppMethodBeat.o(299622);
      return false;
    }
    com.tencent.mm.plugin.expt.edge.b.o("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult, configID : %s", new Object[] { paramb.zzS });
    paramb = new a(this.zys, paramb.zzS, paramb.zzY);
    if (!paramb.dIy())
    {
      Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult create table for isnot exist!");
      if (!paramb.dIz())
      {
        Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createTable fail!");
        AppMethodBeat.o(299622);
        return false;
      }
      if (!paramb.dIA()) {
        Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createIndex fail!");
      }
    }
    for (;;)
    {
      boolean bool = paramb.fq(paramList);
      AppMethodBeat.o(299622);
      return bool;
      paramb.dIB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.i.b
 * JD-Core Version:    0.7.0.1
 */