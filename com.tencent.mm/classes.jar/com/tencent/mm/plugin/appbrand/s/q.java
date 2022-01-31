package com.tencent.mm.plugin.appbrand.s;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class q
{
  public static <T extends q.a> String a(Context paramContext, String paramString, T paramT)
  {
    AppMethodBeat.i(91177);
    String str = "Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = " + bo.dtY();
    boolean bool;
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue(str, bool);
      if (paramString != null) {
        break label158;
      }
    }
    label158:
    for (paramContext = paramT.vV();; paramContext = paramString + paramT.vV())
    {
      paramContext = paramContext + paramT.version();
      paramString = at.gU(ah.getContext());
      paramContext = paramContext + " NetType/" + paramString;
      paramContext = paramContext + " Language/" + aa.gP(ah.getContext());
      ab.i("Luggage.UserAgentUtil", "appendUserAgent, uaStr = ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(91177);
      return paramContext;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.q
 * JD-Core Version:    0.7.0.1
 */