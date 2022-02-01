package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  private static b raz;
  private String name = null;
  
  public static b crk()
  {
    AppMethodBeat.i(122358);
    if (raz == null) {
      raz = new b();
    }
    b localb = raz;
    AppMethodBeat.o(122358);
    return localb;
  }
  
  final ax Lv()
  {
    AppMethodBeat.i(122359);
    int i = a.aiN();
    if (i == 0)
    {
      AppMethodBeat.o(122359);
      return null;
    }
    Object localObject = i + "_WxPageFlow";
    if (!bt.lQ(this.name, (String)localObject))
    {
      ad.i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", new Object[] { this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = ax.aQz(this.name);
    AppMethodBeat.o(122359);
    return localObject;
  }
  
  public final String[] allKeys()
  {
    AppMethodBeat.i(122362);
    Object localObject = Lv();
    if (localObject == null)
    {
      AppMethodBeat.o(122362);
      return null;
    }
    localObject = ((ax)localObject).allKeys();
    AppMethodBeat.o(122362);
    return localObject;
  }
  
  public final String get(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122361);
    ax localax = Lv();
    if (localax == null)
    {
      AppMethodBeat.o(122361);
      return paramString2;
    }
    paramString1 = localax.getString(paramString1, paramString2);
    AppMethodBeat.o(122361);
    return paramString1;
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(122360);
    ax localax = Lv();
    if (localax == null)
    {
      AppMethodBeat.o(122360);
      return;
    }
    localax.remove(paramString);
    AppMethodBeat.o(122360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.g.b
 * JD-Core Version:    0.7.0.1
 */