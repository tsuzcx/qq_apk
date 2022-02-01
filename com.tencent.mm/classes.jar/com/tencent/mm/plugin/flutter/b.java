package com.tencent.mm.plugin.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.UUID;

public final class b
  implements com.tencent.mm.plugin.flutter.a.a
{
  public final void a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(148837);
    if (!((com.tencent.mm.plugin.flutter.a.b)g.ad(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
    {
      AppMethodBeat.o(148837);
      return;
    }
    String str = UUID.randomUUID().toString();
    paramc.rds = 2;
    paramc.rdr = new HashMap();
    paramc.rdr.put("fontScale", Float.valueOf(com.tencent.mm.cd.a.dT(aj.getContext())));
    paramc.rdr.put("layoutScale", Float.valueOf(com.tencent.mm.cd.a.hR(aj.getContext())));
    paramc.rdr.put("language", ac.eFu());
    paramc.rdr.put("sessionId", str);
    boolean bool = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().a(paramc, "mmNative");
    ad.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", new Object[] { Boolean.valueOf(bool) });
    paramc = new Intent(paramContext, MMFlutterActivity.class);
    paramc.putExtra("first_create", bool);
    if (!(paramContext instanceof Activity)) {
      paramc.addFlags(268435456);
    }
    paramc = new com.tencent.mm.hellhoundlib.b.a().bd(paramc);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramc.adn(), "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramc.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(148837);
  }
  
  public final <T> T aN(Class<T> paramClass)
  {
    AppMethodBeat.i(148838);
    paramClass = ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().aN(paramClass);
    AppMethodBeat.o(148838);
    return paramClass;
  }
  
  public final boolean cuJ()
  {
    AppMethodBeat.i(148839);
    com.tencent.mm.plugin.expansions.a.cbc();
    ad.i("MicroMsg.FlutterABTestLogic", "expansions is not yet installed, disabled flutter");
    AppMethodBeat.o(148839);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b
 * JD-Core Version:    0.7.0.1
 */