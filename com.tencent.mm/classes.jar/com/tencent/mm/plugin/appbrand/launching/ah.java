package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.platformtools.al;

public enum ah
{
  public static void Do(String paramString)
  {
    AppMethodBeat.i(131955);
    d.e("MicroMsg.AppBrand.PrepareQuickAccess", "toast: ".concat(String.valueOf(paramString)));
    al.d(new ah.1(paramString));
    AppMethodBeat.o(131955);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(131956);
    paramVarArgs = e.getMMString(paramInt, paramVarArgs);
    AppMethodBeat.o(131956);
    return paramVarArgs;
  }
  
  public static void oH(int paramInt)
  {
    AppMethodBeat.i(131954);
    Do(com.tencent.mm.sdk.platformtools.ah.getResources().getString(paramInt));
    AppMethodBeat.o(131954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah
 * JD-Core Version:    0.7.0.1
 */