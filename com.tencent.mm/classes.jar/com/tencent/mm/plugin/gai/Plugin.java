package com.tencent.mm.plugin.gai;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(25273);
    boolean bool = aj.getContext().getSharedPreferences(aj.fkC() + "_google_aid", g.abm()).getBoolean("already_report_googleaid", false);
    ad.i("MicroMsg.Plugin.gai", "gai Plugin! %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {
      try
      {
        i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(aj.getContext());
        if ((i != 1) && (i != 9))
        {
          aj.getContext();
          new Object() {};
          b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(25272);
              AppMethodBeat.o(25272);
            }
          }, "Advertisement-MAT-thread");
          AppMethodBeat.o(25273);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Plugin.gai", localException, "", new Object[0]);
          int i = 9;
        }
        ad.w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
        aj.getContext().getSharedPreferences(aj.fkC() + "_google_aid", g.abm()).edit().putBoolean("already_report_googleaid", true).commit();
      }
    }
    AppMethodBeat.o(25273);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(25274);
    com.tencent.mm.plugin.gai.a.a locala = new com.tencent.mm.plugin.gai.a.a();
    AppMethodBeat.o(25274);
    return locala;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(25275);
    com.tencent.mm.plugin.gai.b.a locala = new com.tencent.mm.plugin.gai.b.a();
    AppMethodBeat.o(25275);
    return locala;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gai.Plugin
 * JD-Core Version:    0.7.0.1
 */