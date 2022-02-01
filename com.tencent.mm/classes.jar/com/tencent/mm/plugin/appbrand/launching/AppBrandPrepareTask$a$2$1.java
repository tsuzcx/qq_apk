package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.aj;

final class AppBrandPrepareTask$a$2$1
  implements Runnable
{
  AppBrandPrepareTask$a$2$1(AppBrandPrepareTask.a.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(47093);
    Toast.makeText(aj.getContext(), 2131755292, 0).show();
    try
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456).addFlags(67108864);
      d.e(aj.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
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