package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

public enum bc
{
  public static void Oq(String paramString)
  {
    AppMethodBeat.i(47317);
    ac.e("MicroMsg.AppBrand.PrepareQuickAccess", "toast: ".concat(String.valueOf(paramString)));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47313);
        Toast.makeText(ai.getContext(), this.fLm, 0).show();
        AppMethodBeat.o(47313);
      }
    });
    AppMethodBeat.o(47317);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(47318);
    paramVarArgs = e.getMMString(paramInt, paramVarArgs);
    AppMethodBeat.o(47318);
    return paramVarArgs;
  }
  
  public static void tG(int paramInt)
  {
    AppMethodBeat.i(47316);
    Oq(ai.getResources().getString(paramInt));
    AppMethodBeat.o(47316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bc
 * JD-Core Version:    0.7.0.1
 */