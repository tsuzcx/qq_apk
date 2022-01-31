package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private static Map<String, Bundle> kef;
  
  static
  {
    AppMethodBeat.i(14424);
    kef = new HashMap();
    AppMethodBeat.o(14424);
  }
  
  public static Bundle Hj(String paramString)
  {
    AppMethodBeat.i(14421);
    paramString = Hk(paramString);
    if (kef.containsKey(paramString))
    {
      paramString = (Bundle)kef.get(paramString);
      AppMethodBeat.o(14421);
      return paramString;
    }
    AppMethodBeat.o(14421);
    return null;
  }
  
  private static String Hk(String paramString)
  {
    AppMethodBeat.i(14423);
    int i = paramString.indexOf("?");
    if (i < 0)
    {
      AppMethodBeat.o(14423);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(14423);
    return paramString;
  }
  
  public static void m(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(14422);
    if (paramString == null)
    {
      AppMethodBeat.o(14422);
      return;
    }
    kef.put(Hk(paramString), paramBundle);
    AppMethodBeat.o(14422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.d
 * JD-Core Version:    0.7.0.1
 */