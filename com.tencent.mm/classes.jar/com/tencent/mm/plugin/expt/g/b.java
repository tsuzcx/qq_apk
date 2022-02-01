package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  private static b riF;
  private String name = null;
  
  public static b csM()
  {
    AppMethodBeat.i(122358);
    if (riF == null) {
      riF = new b();
    }
    b localb = riF;
    AppMethodBeat.o(122358);
    return localb;
  }
  
  final ay LD()
  {
    AppMethodBeat.i(122359);
    int i = a.ajc();
    if (i == 0)
    {
      AppMethodBeat.o(122359);
      return null;
    }
    Object localObject = i + "_WxPageFlow";
    if (!bu.lX(this.name, (String)localObject))
    {
      ae.i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", new Object[] { this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = ay.aRW(this.name);
    AppMethodBeat.o(122359);
    return localObject;
  }
  
  public final String[] allKeys()
  {
    AppMethodBeat.i(122362);
    Object localObject = LD();
    if (localObject == null)
    {
      AppMethodBeat.o(122362);
      return null;
    }
    localObject = ((ay)localObject).allKeys();
    AppMethodBeat.o(122362);
    return localObject;
  }
  
  public final String get(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122361);
    ay localay = LD();
    if (localay == null)
    {
      AppMethodBeat.o(122361);
      return paramString2;
    }
    paramString1 = localay.getString(paramString1, paramString2);
    AppMethodBeat.o(122361);
    return paramString1;
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(122360);
    ay localay = LD();
    if (localay == null)
    {
      AppMethodBeat.o(122360);
      return;
    }
    localay.remove(paramString);
    AppMethodBeat.o(122360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.b
 * JD-Core Version:    0.7.0.1
 */