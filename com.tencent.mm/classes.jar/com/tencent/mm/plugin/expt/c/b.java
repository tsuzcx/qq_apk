package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  private static b mcc;
  private String name = null;
  
  public static b bsO()
  {
    AppMethodBeat.i(73524);
    if (mcc == null) {
      mcc = new b();
    }
    b localb = mcc;
    AppMethodBeat.o(73524);
    return localb;
  }
  
  final as aND()
  {
    AppMethodBeat.i(73525);
    int i = a.QW();
    if (i == 0)
    {
      AppMethodBeat.o(73525);
      return null;
    }
    Object localObject = i + "_WxPageFlow";
    if (!bo.isEqual(this.name, (String)localObject))
    {
      ab.i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", new Object[] { this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = as.apq(this.name);
    AppMethodBeat.o(73525);
    return localObject;
  }
  
  public final String[] allKeys()
  {
    AppMethodBeat.i(73528);
    Object localObject = aND();
    if (localObject == null)
    {
      AppMethodBeat.o(73528);
      return null;
    }
    localObject = ((as)localObject).allKeys();
    AppMethodBeat.o(73528);
    return localObject;
  }
  
  public final String get(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73527);
    as localas = aND();
    if (localas == null)
    {
      AppMethodBeat.o(73527);
      return paramString2;
    }
    paramString1 = localas.getString(paramString1, paramString2);
    AppMethodBeat.o(73527);
    return paramString1;
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(73526);
    as localas = aND();
    if (localas == null)
    {
      AppMethodBeat.o(73526);
      return;
    }
    localas.remove(paramString);
    AppMethodBeat.o(73526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.b
 * JD-Core Version:    0.7.0.1
 */