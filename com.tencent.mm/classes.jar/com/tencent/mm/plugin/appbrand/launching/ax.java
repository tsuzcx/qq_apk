package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public enum ax
{
  public static void a(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(320707);
    a(MMApplicationContext.getResources().getString(paramInt), paramaa);
    AppMethodBeat.o(320707);
  }
  
  public static void a(String paramString, aa paramaa)
  {
    AppMethodBeat.i(320708);
    Log.e("MicroMsg.AppBrand.PrepareQuickAccess", "toast: %s, step:%s", new Object[] { paramString, paramaa.getClass().getName() });
    if (!paramaa.czJ())
    {
      AppMethodBeat.o(320708);
      return;
    }
    MMHandlerThread.postToMainThread(new ax..ExternalSyntheticLambda0(paramString));
    AppMethodBeat.o(320708);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(47318);
    paramVarArgs = l.getMMString(paramInt, paramVarArgs);
    AppMethodBeat.o(47318);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax
 * JD-Core Version:    0.7.0.1
 */