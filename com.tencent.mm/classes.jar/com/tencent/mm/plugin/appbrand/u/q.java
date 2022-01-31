package com.tencent.mm.plugin.appbrand.u;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class q
{
  public static <T extends q.a> String a(Context paramContext, String paramString, T paramT)
  {
    String str = "Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = " + bk.csb();
    boolean bool;
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue(str, bool);
      if (paramString != null) {
        break label212;
      }
      paramContext = paramT.pJ();
      label43:
      paramContext = paramContext + paramT.pK();
      paramString = aq.fH(ae.getContext());
      paramContext = paramContext + " NetType/" + paramString;
      paramContext = paramContext + " Language/" + x.fB(ae.getContext());
      paramString = new StringBuilder().append(paramContext).append(" Process/");
      paramContext = ae.getPackageName().trim().toLowerCase();
      paramT = ae.getProcessName().trim().toLowerCase();
      if (!paramT.equals(paramContext)) {
        break label239;
      }
      paramContext = "mm";
    }
    for (;;)
    {
      paramContext = paramContext;
      y.i("Luggage.UserAgentUtil", "appendUserAgent, uaStr = " + paramContext);
      return paramContext;
      bool = false;
      break;
      label212:
      paramContext = paramString + paramT.pJ();
      break label43;
      label239:
      if (paramT.startsWith(paramContext)) {
        paramContext = paramT.substring(paramContext.length() + 1);
      } else {
        paramContext = "unknown";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.q
 * JD-Core Version:    0.7.0.1
 */