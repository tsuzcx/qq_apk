package com.tencent.mm.plugin.expt.edge.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static c Lt(int paramInt)
  {
    AppMethodBeat.i(299663);
    Object localObject;
    if (paramInt == 1)
    {
      localObject = new com.tencent.mm.plugin.expt.edge.a.a.b();
      AppMethodBeat.o(299663);
      return localObject;
    }
    if (paramInt == 2)
    {
      localObject = new a();
      AppMethodBeat.o(299663);
      return localObject;
    }
    Log.e("EdgeComputingDataCacheFactory", "[EdgeComputingDataCacheFactory] create error type : ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(299663);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.a.b
 * JD-Core Version:    0.7.0.1
 */