package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class AppBrandPrepareTask$a$2$1
  implements Runnable
{
  AppBrandPrepareTask$a$2$1(AppBrandPrepareTask.a.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(47093);
    Toast.makeText(MMApplicationContext.getContext(), ba.i.app_brand_account_release_error, 0).show();
    try
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456).addFlags(67108864);
      c.g(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
      AppMethodBeat.o(47093);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(47093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2.1
 * JD-Core Version:    0.7.0.1
 */