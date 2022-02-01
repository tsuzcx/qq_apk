package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Locale;

public final class b
{
  public static String Wp(String paramString)
  {
    AppMethodBeat.i(127558);
    paramString = ai.ee(String.format("%s#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString }));
    AppMethodBeat.o(127558);
    return paramString;
  }
  
  public static String Wq(String paramString)
  {
    AppMethodBeat.i(127560);
    paramString = ai.ee(String.format("%s", new Object[] { paramString }));
    AppMethodBeat.o(127560);
    return paramString;
  }
  
  public static String cp(String paramString, int paramInt)
  {
    AppMethodBeat.i(189772);
    paramString = String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(189772);
    return paramString;
  }
  
  public static String cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(127559);
    paramString = String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(127559);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.b
 * JD-Core Version:    0.7.0.1
 */