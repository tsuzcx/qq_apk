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
import com.tencent.mm.plugin.game.luggage.h.a.7;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.webview.ui.tools.game.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.aw;

public class PluginLuggageGame
  extends com.tencent.mm.kernel.b.f
  implements ApplicationLifeCycleBucket, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.luggage.a.b
{
  private p ItW;
  
  public PluginLuggageGame()
  {
    AppMethodBeat.i(276955);
    this.ItW = new p.a()
    {
      private final byte[] lrK;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(276923);
        synchronized (this.lrK)
        {
          if (com.tencent.mm.plugin.game.luggage.h.a.fFa() != null)
          {
            com.tencent.mm.plugin.game.luggage.h.a locala = com.tencent.mm.plugin.game.luggage.h.a.fFa();
            String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            locala.Ixx.b(new a.7(locala, str));
            locala.Ixy.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.networkType == 'undefined) {return;} SystemInfo.networkType=\"%s\"; console.log(SystemInfo.networkType);", new Object[] { str }), null);
          }
          AppMethodBeat.o(276923);
          return;
        }
      }
    };
    AppMethodBeat.o(276955);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(83013);
    if ((paramg.bbA()) || (paramg.FH(":tools")) || (paramg.FH(":toolsmp")) || (paramg.FH(":lite"))) {
      h.a(com.tencent.mm.plugin.game.luggage.a.a.class, new e(new d()));
    }
    AppMethodBeat.o(83013);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(83014);
    if (com.tencent.mm.plugin.webview.ui.tools.game.a.Xfs == null) {
      com.tencent.mm.plugin.webview.ui.tools.game.a.Xfs = new a.a((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.webview.ui.tools.game.a.Xfs, paramc);
    h.baD().a(this.ItW);
    ((PluginMultiTask)h.az(PluginMultiTask.class)).registerMultiTaskUIC(5, com.tencent.mm.plugin.webview.luggage.d.b.class);
    if (com.tencent.mm.plugin.game.luggage.c.a.Ivi == null) {
      com.tencent.mm.plugin.game.luggage.c.a.Ivi = new a.1();
    }
    com.tencent.mm.plugin.downloader.event.a.a(com.tencent.mm.plugin.game.luggage.c.a.Ivi);
    AppMethodBeat.o(83014);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(83015);
    if (com.tencent.mm.plugin.webview.ui.tools.game.a.Xfs != null) {
      MMApplicationContext.getContext().unregisterReceiver(com.tencent.mm.plugin.webview.ui.tools.game.a.Xfs);
    }
    com.tencent.mm.plugin.webview.ui.tools.game.a.Xfs = null;
    h.baD().b(this.ItW);
    com.tencent.mm.plugin.downloader.event.a.b(com.tencent.mm.plugin.game.luggage.c.a.Ivi);
    com.tencent.mm.plugin.game.luggage.c.a.Ivi = null;
    AppMethodBeat.o(83015);
  }
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(276987);
    if ((aw.aXo()) && (aw.aXj()))
    {
      paramConfiguration = com.tencent.mm.plugin.game.luggage.h.a.fFa();
      if (paramConfiguration != null) {
        paramConfiguration.Ixy.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.isDarkMode == 'undefined) {return;} SystemInfo.isDarkMode=%b; console.log(SystemInfo.isDarkMode);", new Object[] { Boolean.valueOf(aw.isDarkMode()) }), null);
      }
    }
    AppMethodBeat.o(276987);
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