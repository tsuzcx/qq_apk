package com.tencent.mm.plugin.gai;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class Plugin
  implements c
{
  public Plugin()
  {
    AppMethodBeat.i(21211);
    boolean bool = ah.getContext().getSharedPreferences(ah.dsP() + "_google_aid", h.Mp()).getBoolean("already_report_googleaid", false);
    ab.i("MicroMsg.Plugin.gai", "gai Plugin! %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ah.getContext());
      if ((i != 1) && (i != 9))
      {
        ah.getContext();
        new Plugin.1(this);
        d.post(new Plugin.2(this), "Advertisement-MAT-thread");
        AppMethodBeat.o(21211);
        return;
      }
      ab.w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
      ah.getContext().getSharedPreferences(ah.dsP() + "_google_aid", h.Mp()).edit().putBoolean("already_report_googleaid", true).commit();
    }
    AppMethodBeat.o(21211);
  }
  
  public o createApplication()
  {
    AppMethodBeat.i(21212);
    com.tencent.mm.plugin.gai.a.a locala = new com.tencent.mm.plugin.gai.a.a();
    AppMethodBeat.o(21212);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(21213);
    com.tencent.mm.plugin.gai.b.a locala = new com.tencent.mm.plugin.gai.b.a();
    AppMethodBeat.o(21213);
    return locala;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gai.Plugin
 * JD-Core Version:    0.7.0.1
 */