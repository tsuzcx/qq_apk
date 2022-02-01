package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public enum ax
{
  public static void a(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(227096);
    a(MMApplicationContext.getResources().getString(paramInt), paramaa);
    AppMethodBeat.o(227096);
  }
  
  public static void a(String paramString, aa paramaa)
  {
    AppMethodBeat.i(227097);
    Log.e("MicroMsg.AppBrand.PrepareQuickAccess", "toast: %s, step:%s", new Object[] { paramString, paramaa.getClass().getName() });
    if (!paramaa.bNh())
    {
      AppMethodBeat.o(227097);
      return;
    }
    MMHandlerThread.postToMainThread(new ax.1(paramString));
    AppMethodBeat.o(227097);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(47318);
    paramVarArgs = f.getMMString(paramInt, paramVarArgs);
    AppMethodBeat.o(47318);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ax
 * JD-Core Version:    0.7.0.1
 */