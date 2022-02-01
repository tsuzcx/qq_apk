package com.tencent.mm.plugin.expt.d.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class b
{
  public r.a wex;
  
  public final boolean a(List<List<com.tencent.mm.plugin.expt.d.f.b>> paramList, com.tencent.mm.plugin.expt.d.f.a.b paramb)
  {
    AppMethodBeat.i(253337);
    if ((this.wex == null) || (paramList == null) || (paramList.size() <= 0) || (paramb == null))
    {
      AppMethodBeat.o(253337);
      return false;
    }
    Log.d("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult, configID : %s", new Object[] { paramb.wdY });
    paramb = new a(this.wex, paramb.wdY, paramb.wee);
    if (!paramb.dbU())
    {
      Log.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult create table for isnot exist!");
      if (!paramb.dbV())
      {
        Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createTable fail!");
        AppMethodBeat.o(253337);
        return false;
      }
      if (!paramb.dbW()) {
        Log.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createIndex fail!");
      }
    }
    for (;;)
    {
      boolean bool = paramb.dv(paramList);
      AppMethodBeat.o(253337);
      return bool;
      paramb.dbX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.j.b
 * JD-Core Version:    0.7.0.1
 */