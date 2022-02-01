package com.tencent.mm.plugin.expt.pageflow;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  private static b zMh;
  private String name = null;
  
  public static b dMZ()
  {
    AppMethodBeat.i(122358);
    if (zMh == null) {
      zMh = new b();
    }
    b localb = zMh;
    AppMethodBeat.o(122358);
    return localb;
  }
  
  public final String O(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122361);
    MultiProcessMMKV localMultiProcessMMKV = aBP();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(122361);
      return paramString2;
    }
    paramString1 = localMultiProcessMMKV.getString(paramString1, paramString2);
    AppMethodBeat.o(122361);
    return paramString1;
  }
  
  final MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(122359);
    int i = com.tencent.mm.kernel.b.aZP();
    if (i == 0)
    {
      AppMethodBeat.o(122359);
      return null;
    }
    Object localObject = i + "_WxPageFlow";
    if (!Util.isEqual(this.name, (String)localObject))
    {
      Log.i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", new Object[] { this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.name);
    AppMethodBeat.o(122359);
    return localObject;
  }
  
  public final String[] allKeys()
  {
    AppMethodBeat.i(122362);
    Object localObject = aBP();
    if (localObject == null)
    {
      AppMethodBeat.o(122362);
      return null;
    }
    localObject = ((MultiProcessMMKV)localObject).allKeys();
    AppMethodBeat.o(122362);
    return localObject;
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(122360);
    MultiProcessMMKV localMultiProcessMMKV = aBP();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(122360);
      return;
    }
    localMultiProcessMMKV.remove(paramString);
    AppMethodBeat.o(122360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.pageflow.b
 * JD-Core Version:    0.7.0.1
 */