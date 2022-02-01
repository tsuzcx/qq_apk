package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.game.luggage.c.a.1;
import com.tencent.mm.plugin.game.luggage.i.a.7;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.webview.ui.tools.game.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ar;

public class PluginLuggageGame
  extends com.tencent.mm.kernel.b.f
  implements ApplicationLifeCycleBucket, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.luggage.a.b
{
  private p netChanged;
  
  public PluginLuggageGame()
  {
    AppMethodBeat.i(232124);
    this.netChanged = new p.a()
    {
      private final byte[] iPP;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(231979);
        synchronized (this.iPP)
        {
          if (com.tencent.mm.plugin.game.luggage.i.a.exd() != null)
          {
            com.tencent.mm.plugin.game.luggage.i.a locala = com.tencent.mm.plugin.game.luggage.i.a.exd();
            String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            locala.CDs.b(new a.7(locala, str));
            locala.CDt.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.networkType == 'undefined) {return;} SystemInfo.networkType=\"%s\"; console.log(SystemInfo.networkType);", new Object[] { str }), null);
          }
          AppMethodBeat.o(231979);
          return;
        }
      }
    };
    AppMethodBeat.o(232124);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(83013);
    if ((paramg.aIE()) || (paramg.MY(":tools")) || (paramg.MY(":toolsmp")) || (paramg.MY(":lite"))) {
      h.a(com.tencent.mm.plugin.game.luggage.a.a.class, new e(new d()));
    }
    AppMethodBeat.o(83013);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(83014);
    if (com.tencent.mm.plugin.webview.ui.tools.game.a.Qne == null) {
      com.tencent.mm.plugin.webview.ui.tools.game.a.Qne = new a.a((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.webview.ui.tools.game.a.Qne, paramc);
    h.aHF().a(this.netChanged);
    ((PluginMultiTask)h.ag(PluginMultiTask.class)).registerMultiTaskUIC(5, com.tencent.mm.plugin.webview.luggage.d.b.class);
    if (com.tencent.mm.plugin.game.luggage.c.a.CBs == null) {
      com.tencent.mm.plugin.game.luggage.c.a.CBs = new a.1();
    }
    com.tencent.mm.plugin.downloader.b.a.a(com.tencent.mm.plugin.game.luggage.c.a.CBs);
    AppMethodBeat.o(83014);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(83015);
    if (com.tencent.mm.plugin.webview.ui.tools.game.a.Qne != null) {
      MMApplicationContext.getContext().unregisterReceiver(com.tencent.mm.plugin.webview.ui.tools.game.a.Qne);
    }
    com.tencent.mm.plugin.webview.ui.tools.game.a.Qne = null;
    h.aHF().b(this.netChanged);
    com.tencent.mm.plugin.downloader.b.a.b(com.tencent.mm.plugin.game.luggage.c.a.CBs);
    com.tencent.mm.plugin.game.luggage.c.a.CBs = null;
    AppMethodBeat.o(83015);
  }
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(232138);
    if ((ar.aEk()) && (ar.aEf()))
    {
      paramConfiguration = com.tencent.mm.plugin.game.luggage.i.a.exd();
      if (paramConfiguration != null) {
        paramConfiguration.CDt.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.isDarkMode == 'undefined) {return;} SystemInfo.isDarkMode=%b; console.log(SystemInfo.isDarkMode);", new Object[] { Boolean.valueOf(ar.isDarkMode()) }), null);
      }
    }
    AppMethodBeat.o(232138);
  }
  
  public void onCreate() {}
  
  public void onLowMemory() {}
  
  public void onTerminate() {}
  
  public void onTrimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.PluginLuggageGame
 * JD-Core Version:    0.7.0.1
 */