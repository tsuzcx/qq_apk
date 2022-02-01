package com.tencent.mm.plugin.expt.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static c GM(int paramInt)
  {
    AppMethodBeat.i(220293);
    Object localObject;
    if (paramInt == 1)
    {
      localObject = new com.tencent.mm.plugin.expt.d.a.a.b();
      AppMethodBeat.o(220293);
      return localObject;
    }
    if (paramInt == 2)
    {
      localObject = new a();
      AppMethodBeat.o(220293);
      return localObject;
    }
    Log.e("EdgeComputingDataCacheFactory", "[EdgeComputingDataCacheFactory] createCache error type : ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(220293);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a.b
 * JD-Core Version:    0.7.0.1
 */