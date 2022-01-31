package com.tencent.mm.game.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URLEncoder;

public final class a
  implements b
{
  private static String lQ(String paramString)
  {
    AppMethodBeat.i(59594);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(59594);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(59594);
    }
    return paramString;
  }
  
  public final int a(a.a parama)
  {
    AppMethodBeat.i(140317);
    int i = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(parama, 5);
    com.tencent.mm.game.report.api.a.ezM.g(2, parama.name(), String.valueOf(i));
    ab.i("MicroMsg.GameExptManager", "key: %s, result: %d", new Object[] { parama.name(), Integer.valueOf(i) });
    AppMethodBeat.o(140317);
    return i;
  }
  
  public final String a(a.a parama, String paramString)
  {
    AppMethodBeat.i(59592);
    String str = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(parama, paramString);
    if (!str.equals(paramString)) {
      com.tencent.mm.game.report.api.a.ezM.g(2, parama.name(), lQ(str));
    }
    ab.i("MicroMsg.GameExptManager", "key: %s, result: %s", new Object[] { parama.name(), str });
    AppMethodBeat.o(59592);
    return str;
  }
  
  public final boolean b(a.a parama)
  {
    AppMethodBeat.i(59593);
    boolean bool = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(parama, false);
    com.tencent.mm.game.report.api.a.ezM.g(2, parama.name(), String.valueOf(bool));
    ab.i("MicroMsg.GameExptManager", "key: %s, result: %b", new Object[] { parama.name(), Boolean.valueOf(bool) });
    AppMethodBeat.o(59593);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.game.report.a.a
 * JD-Core Version:    0.7.0.1
 */