package com.tencent.mm.plugin.gai;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;

public class Plugin
  implements d
{
  public Plugin()
  {
    AppMethodBeat.i(25273);
    boolean bool = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", g.aQe()).getBoolean("already_report_googleaid", false);
    Log.i("MicroMsg.Plugin.gai", "gai Plugin! %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {
      try
      {
        i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MMApplicationContext.getContext());
        if ((i != 1) && (i != 9))
        {
          MMApplicationContext.getContext();
          new Object() {};
          ThreadPool.post(new Runnable()
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
          Log.printErrStackTrace("MicroMsg.Plugin.gai", localException, "", new Object[0]);
          int i = 9;
        }
        Log.w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_google_aid", g.aQe()).edit().putBoolean("already_report_googleaid", true).commit();
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
  
  public be createSubCore()
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