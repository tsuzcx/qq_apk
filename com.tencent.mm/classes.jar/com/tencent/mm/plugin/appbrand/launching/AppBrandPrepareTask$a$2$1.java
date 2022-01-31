package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ah;

final class AppBrandPrepareTask$a$2$1
  implements Runnable
{
  AppBrandPrepareTask$a$2$1(AppBrandPrepareTask.a.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(131742);
    Toast.makeText(ah.getContext(), 2131296557, 0).show();
    try
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456).addFlags(67108864);
      d.f(ah.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
      AppMethodBeat.o(131742);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(131742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2.1
 * JD-Core Version:    0.7.0.1
 */