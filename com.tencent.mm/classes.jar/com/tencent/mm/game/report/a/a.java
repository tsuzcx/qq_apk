package com.tencent.mm.game.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;

public final class a
  implements b
{
  private static String Fg(String paramString)
  {
    AppMethodBeat.i(108270);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(108270);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(108270);
    }
    return paramString;
  }
  
  public final int a(b.a parama, int paramInt)
  {
    AppMethodBeat.i(108268);
    paramInt = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(parama, paramInt);
    com.tencent.mm.game.report.api.a.hhr.a(2, parama.name(), String.valueOf(paramInt), 0L);
    Log.i("MicroMsg.GameExptManager", "key: %s, result: %d", new Object[] { parama.name(), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108268);
    return paramInt;
  }
  
  public final String a(b.a parama, String paramString)
  {
    AppMethodBeat.i(108267);
    String str = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(parama, paramString);
    if (!str.equals(paramString)) {
      com.tencent.mm.game.report.api.a.hhr.a(2, parama.name(), Fg(str), 0L);
    }
    Log.i("MicroMsg.GameExptManager", "key: %s, result: %s", new Object[] { parama.name(), str });
    AppMethodBeat.o(108267);
    return str;
  }
  
  public final boolean a(b.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(190324);
    paramBoolean = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(parama, paramBoolean);
    com.tencent.mm.game.report.api.a.hhr.a(2, parama.name(), String.valueOf(paramBoolean), 0L);
    Log.i("MicroMsg.GameExptManager", "key: %s, result: %b", new Object[] { parama.name(), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(190324);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.a.a
 * JD-Core Version:    0.7.0.1
 */