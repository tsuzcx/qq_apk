package com.tencent.mm.plugin.gai;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.GoogleApiAvailability;
import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public class Plugin
  implements c
{
  public Plugin()
  {
    boolean bool = ae.getContext().getSharedPreferences(ae.cqR() + "_google_aid", 4).getBoolean("already_report_googleaid", false);
    y.i("MicroMsg.Plugin.gai", "gai Plugin! %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ae.getContext());
      if ((i != 1) && (i != 9)) {
        e.post(new Plugin.2(this, ae.getContext(), new Plugin.1(this)), "Advertisement-MAT-thread");
      }
    }
    else
    {
      return;
    }
    y.w("MicroMsg.Plugin.gai", "gp service invalid, just ignore");
    ae.getContext().getSharedPreferences(ae.cqR() + "_google_aid", 4).edit().putBoolean("already_report_googleaid", true).commit();
  }
  
  public n createApplication()
  {
    return new com.tencent.mm.plugin.gai.a.a();
  }
  
  public ar createSubCore()
  {
    return new com.tencent.mm.plugin.gai.b.a();
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