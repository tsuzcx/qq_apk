package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.game.luggage.c.a.1;
import com.tencent.mm.plugin.game.luggage.i.a.7;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.webview.luggage.webview_impl.LuggageWebMultiTaskUIC;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ao;

public class PluginLuggageGame
  extends com.tencent.mm.kernel.b.f
  implements ApplicationLifeCycleBucket, c, com.tencent.mm.plugin.game.luggage.a.b
{
  private p netChanged;
  
  public PluginLuggageGame()
  {
    AppMethodBeat.i(186843);
    this.netChanged = new p.a()
    {
      private final byte[] glH;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(186842);
        synchronized (this.glH)
        {
          if (com.tencent.mm.plugin.game.luggage.i.a.dTW() != null)
          {
            com.tencent.mm.plugin.game.luggage.i.a locala = com.tencent.mm.plugin.game.luggage.i.a.dTW();
            String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            locala.xzn.b(new a.7(locala, str));
            locala.xzo.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.networkType == 'undefined) {return;} SystemInfo.networkType=\"%s\"; console.log(SystemInfo.networkType);", new Object[] { str }), null);
          }
          AppMethodBeat.o(186842);
          return;
        }
      }
    };
    AppMethodBeat.o(186843);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(83013);
    if ((paramg.aBb()) || (paramg.FY(":tools")) || (paramg.FY(":toolsmp")) || (paramg.FY(":lite"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.luggage.a.a.class, new e(new d()));
    }
    AppMethodBeat.o(83013);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(83014);
    if (BatteryManager.JpJ == null) {
      BatteryManager.JpJ = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    MMApplicationContext.getContext().registerReceiver(BatteryManager.JpJ, paramc);
    com.tencent.mm.kernel.g.aAg().a(this.netChanged);
    ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).registerMultiTaskUIC(5, LuggageWebMultiTaskUIC.class);
    if (com.tencent.mm.plugin.game.luggage.c.a.xxj == null) {
      com.tencent.mm.plugin.game.luggage.c.a.xxj = new a.1();
    }
    com.tencent.mm.plugin.downloader.b.a.a(com.tencent.mm.plugin.game.luggage.c.a.xxj);
    AppMethodBeat.o(83014);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(83015);
    if (BatteryManager.JpJ != null) {
      MMApplicationContext.getContext().unregisterReceiver(BatteryManager.JpJ);
    }
    BatteryManager.JpJ = null;
    com.tencent.mm.kernel.g.aAg().b(this.netChanged);
    com.tencent.mm.plugin.downloader.b.a.b(com.tencent.mm.plugin.game.luggage.c.a.xxj);
    com.tencent.mm.plugin.game.luggage.c.a.xxj = null;
    AppMethodBeat.o(83015);
  }
  
  public void onBaseContextAttached(Context paramContext) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(186844);
    if ((ao.awS()) && (ao.awN()))
    {
      paramConfiguration = com.tencent.mm.plugin.game.luggage.i.a.dTW();
      if (paramConfiguration != null) {
        paramConfiguration.xzo.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.isDarkMode == 'undefined) {return;} SystemInfo.isDarkMode=%b; console.log(SystemInfo.isDarkMode);", new Object[] { Boolean.valueOf(ao.isDarkMode()) }), null);
      }
    }
    AppMethodBeat.o(186844);
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