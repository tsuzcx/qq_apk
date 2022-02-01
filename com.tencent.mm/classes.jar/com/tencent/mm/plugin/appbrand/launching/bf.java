package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;

public enum bf
{
  public static void Sx(String paramString)
  {
    AppMethodBeat.i(47317);
    ae.e("MicroMsg.AppBrand.PrepareQuickAccess", "toast: ".concat(String.valueOf(paramString)));
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47313);
        Toast.makeText(ak.getContext(), this.val$text, 0).show();
        AppMethodBeat.o(47313);
      }
    });
    AppMethodBeat.o(47317);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(47318);
    paramVarArgs = f.getMMString(paramInt, paramVarArgs);
    AppMethodBeat.o(47318);
    return paramVarArgs;
  }
  
  public static void uq(int paramInt)
  {
    AppMethodBeat.i(47316);
    Sx(ak.getResources().getString(paramInt));
    AppMethodBeat.o(47316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bf
 * JD-Core Version:    0.7.0.1
 */