package com.tencent.mm.plugin.expt.d.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public final class b
{
  public r.a qQu;
  
  public final boolean a(List<com.tencent.mm.plugin.expt.d.e.b> paramList, com.tencent.mm.plugin.expt.d.e.a.b paramb)
  {
    AppMethodBeat.i(210294);
    if ((this.qQu == null) || (paramList == null) || (paramList.size() <= 0) || (paramb == null))
    {
      AppMethodBeat.o(210294);
      return false;
    }
    ad.d("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult, configID : %s", new Object[] { paramb.qQf });
    paramb = new a(this.qQu, paramb.qQf, paramb.qQj);
    if (!paramb.cno())
    {
      ad.i("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult create table for isnot exist!");
      if (!paramb.cnp())
      {
        ad.e("EdgeComputingDataStorage", "[EdgeComputingDataStorage] saveResult createTable fail!");
        AppMethodBeat.o(210294);
        return false;
      }
    }
    else
    {
      paramb.cnq();
    }
    boolean bool = paramb.cY(paramList);
    AppMethodBeat.o(210294);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.i.b
 * JD-Core Version:    0.7.0.1
 */