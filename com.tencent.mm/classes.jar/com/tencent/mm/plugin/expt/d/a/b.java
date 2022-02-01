package com.tencent.mm.plugin.expt.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.a.a.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static c Db(int paramInt)
  {
    AppMethodBeat.i(195871);
    Object localObject;
    if (paramInt == 1)
    {
      localObject = new com.tencent.mm.plugin.expt.d.a.a.b();
      AppMethodBeat.o(195871);
      return localObject;
    }
    if (paramInt == 2)
    {
      localObject = new a();
      AppMethodBeat.o(195871);
      return localObject;
    }
    ae.e("EdgeComputingDataCacheFactory", "[EdgeComputingDataCacheFactory] createCache error type : ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(195871);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a.b
 * JD-Core Version:    0.7.0.1
 */