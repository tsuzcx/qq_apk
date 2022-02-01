package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.Locale;

public final class b
{
  public static String ahX(String paramString)
  {
    AppMethodBeat.i(127558);
    paramString = MD5Util.getMD5String(String.format("%s#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString }));
    AppMethodBeat.o(127558);
    return paramString;
  }
  
  public static String ahY(String paramString)
  {
    AppMethodBeat.i(127560);
    paramString = MD5Util.getMD5String(String.format("%s", new Object[] { paramString }));
    AppMethodBeat.o(127560);
    return paramString;
  }
  
  public static String dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(288267);
    paramString = String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(288267);
    return paramString;
  }
  
  public static String dy(String paramString, int paramInt)
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