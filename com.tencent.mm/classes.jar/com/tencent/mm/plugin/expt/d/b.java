package com.tencent.mm.plugin.expt.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
{
  private static b qrg;
  private String name = null;
  
  public static b clN()
  {
    AppMethodBeat.i(122358);
    if (qrg == null) {
      qrg = new b();
    }
    b localb = qrg;
    AppMethodBeat.o(122358);
    return localb;
  }
  
  final aw JW()
  {
    AppMethodBeat.i(122359);
    int i = a.agb();
    if (i == 0)
    {
      AppMethodBeat.o(122359);
      return null;
    }
    Object localObject = i + "_WxPageFlow";
    if (!bs.lr(this.name, (String)localObject))
    {
      ac.i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", new Object[] { this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = aw.aKT(this.name);
    AppMethodBeat.o(122359);
    return localObject;
  }
  
  public final String[] allKeys()
  {
    AppMethodBeat.i(122362);
    Object localObject = JW();
    if (localObject == null)
    {
      AppMethodBeat.o(122362);
      return null;
    }
    localObject = ((aw)localObject).allKeys();
    AppMethodBeat.o(122362);
    return localObject;
  }
  
  public final String get(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122361);
    aw localaw = JW();
    if (localaw == null)
    {
      AppMethodBeat.o(122361);
      return paramString2;
    }
    paramString1 = localaw.getString(paramString1, paramString2);
    AppMethodBeat.o(122361);
    return paramString1;
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(122360);
    aw localaw = JW();
    if (localaw == null)
    {
      AppMethodBeat.o(122360);
      return;
    }
    localaw.remove(paramString);
    AppMethodBeat.o(122360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.b
 * JD-Core Version:    0.7.0.1
 */