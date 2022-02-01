package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public enum av
{
  public static void a(int paramInt, y paramy)
  {
    AppMethodBeat.i(283135);
    a(MMApplicationContext.getResources().getString(paramInt), paramy);
    AppMethodBeat.o(283135);
  }
  
  public static void a(String paramString, y paramy)
  {
    AppMethodBeat.i(283138);
    Log.e("MicroMsg.AppBrand.PrepareQuickAccess", "toast: %s, step:%s", new Object[] { paramString, paramy.getClass().getName() });
    if (!paramy.bZy())
    {
      AppMethodBeat.o(283138);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47313);
        Toast.makeText(MMApplicationContext.getContext(), this.val$text, 0).show();
        AppMethodBeat.o(47313);
      }
    });
    AppMethodBeat.o(283138);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(47318);
    paramVarArgs = h.getMMString(paramInt, paramVarArgs);
    AppMethodBeat.o(47318);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.av
 * JD-Core Version:    0.7.0.1
 */