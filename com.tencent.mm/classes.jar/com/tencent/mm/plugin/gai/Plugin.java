package com.tencent.mm.plugin.gai;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(25273);
    boolean bool = ai.getContext().getSharedPreferences(ai.eUX() + "_google_aid", g.YK()).getBoolean("already_report_googleaid", false);
    ac.i("MicroMsg.Plugin.gai", "gai Plugin! %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {
      try
      {
        i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ai.getContext());
        if ((i != 1) && (i != 9))
        {
          ai.getContext();
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
          ac.printErrStackTrace("MicroMsg.Plugin.gai", localException, "", new Object[0]);
          int i = 9;
        }
        ac.w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
        ai.getContext().getSharedPreferences(ai.eUX() + "_google_aid", g.YK()).edit().putBoolean("already_report_googleaid", true).commit();
      }
    }
    AppMethodBeat.o(25273);
  }
  
  public m createApplication()
  {
    AppMethodBeat.i(25274);
    com.tencent.mm.plugin.gai.a.a locala = new com.tencent.mm.plugin.gai.a.a();
    AppMethodBeat.o(25274);
    return locala;
  }
  
  public aw createSubCore()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gai.Plugin
 * JD-Core Version:    0.7.0.1
 */