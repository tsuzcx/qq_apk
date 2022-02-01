package com.tencent.mm.game.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;

public final class a
  implements b
{
  private static String EL(String paramString)
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
  
  public final int a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(108268);
    paramInt = ((c)h.ax(c.class)).a(parama, paramInt);
    com.tencent.mm.game.report.api.a.mtH.a(2, parama.name(), String.valueOf(paramInt), 0L);
    Log.i("MicroMsg.GameExptManager", "key: %s, result: %d", new Object[] { parama.name(), Integer.valueOf(paramInt) });
    AppMethodBeat.o(108268);
    return paramInt;
  }
  
  public final String a(c.a parama, String paramString)
  {
    AppMethodBeat.i(108267);
    String str = ((c)h.ax(c.class)).a(parama, paramString);
    if (!str.equals(paramString)) {
      com.tencent.mm.game.report.api.a.mtH.a(2, parama.name(), EL(str), 0L);
    }
    Log.i("MicroMsg.GameExptManager", "key: %s, result: %s", new Object[] { parama.name(), str });
    AppMethodBeat.o(108267);
    return str;
  }
  
  public final boolean a(c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(240733);
    paramBoolean = ((c)h.ax(c.class)).a(parama, paramBoolean);
    com.tencent.mm.game.report.api.a.mtH.a(2, parama.name(), String.valueOf(paramBoolean), 0L);
    Log.i("MicroMsg.GameExptManager", "key: %s, result: %b", new Object[] { parama.name(), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(240733);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.a.a
 * JD-Core Version:    0.7.0.1
 */