package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.sdk.platformtools.ap;

public final class c
  implements b<com.tencent.luggage.sdk.b.a.c>
{
  public static void a(d paramd, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147336);
    l.ak(paramString, paramBoolean);
    if (paramBoolean) {}
    for (paramString = paramd.getContext().getResources().getString(2131755372);; paramString = paramd.getContext().getResources().getString(2131755371))
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147335);
          Toast.makeText(this.kAk.getContext(), paramString, 0).show();
          this.kAk.getRuntime().finish();
          AppMethodBeat.o(147335);
        }
      });
      AppMethodBeat.o(147336);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.c
 * JD-Core Version:    0.7.0.1
 */