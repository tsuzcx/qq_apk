package com.tencent.mm.plugin.appbrand.z;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public final class p
{
  public static <T extends a> String a(Context paramContext, String paramString, T paramT)
  {
    AppMethodBeat.i(140851);
    String str = "Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = " + bt.flS();
    boolean bool;
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue(str, bool);
      if (paramString != null) {
        break label193;
      }
      paramContext = paramT.DW();
      label48:
      paramContext = paramContext + paramT.version();
      paramString = ay.iR(aj.getContext());
      paramContext = paramContext + " NetType/" + paramString;
      paramContext = paramContext + " Language/" + ac.iM(aj.getContext());
      paramString = new StringBuilder().append(paramContext).append(" ABI/");
      if (!bBq()) {
        break label220;
      }
    }
    label193:
    label220:
    for (paramContext = "arm64";; paramContext = "arm32")
    {
      paramContext = paramContext;
      ad.i("Luggage.UserAgentUtil", "appendUserAgent, uaStr = ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(140851);
      return paramContext;
      bool = false;
      break;
      paramContext = paramString + paramT.DW();
      break label48;
    }
  }
  
  private static boolean bBq()
  {
    AppMethodBeat.i(140850);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(140850);
      return false;
    }
    String[] arrayOfString = Build.SUPPORTED_64_BIT_ABIS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if ("arm64-v8a".equalsIgnoreCase(arrayOfString[i]))
      {
        AppMethodBeat.o(140850);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(140850);
    return false;
  }
  
  public static abstract interface a
    extends b
  {
    public abstract String DW();
    
    public abstract String version();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.p
 * JD-Core Version:    0.7.0.1
 */