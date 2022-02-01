package com.tencent.mm.plugin.flutter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.flutter.b.c.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;

public class PluginFlutter
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.flutter.a.b
{
  private a HjW;
  private com.tencent.mm.plugin.flutter.b.c HjX;
  private boolean HjY;
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(148841);
    if (paramg.bbA()) {
      h.b(com.tencent.mm.plugin.flutter.a.a.class, new b());
    }
    AppMethodBeat.o(148841);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(262977);
    boolean bool;
    if (paramg.bbA())
    {
      paramg = i.agtt;
      int i = i.a(b.a.agqL, 0);
      if (i == 0) {
        break label74;
      }
      if (i != 1) {
        break label69;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.PluginFlutter", "need warmup flutter engine:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        com.tencent.mm.plugin.flutter.b.b.Hke.fuX();
      }
      AppMethodBeat.o(262977);
      return;
      label69:
      bool = false;
      continue;
      label74:
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zxq, 1) == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public com.tencent.mm.plugin.flutter.b.c getFlutterEngineMgr()
  {
    return this.HjX;
  }
  
  public void initFlutter()
  {
    AppMethodBeat.i(148844);
    if (this.HjY)
    {
      AppMethodBeat.o(148844);
      return;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      Context localContext = MMApplicationContext.getContext();
      FlutterLoader localFlutterLoader = FlutterInjector.instance().flutterLoader();
      localFlutterLoader.startInitialization(localContext);
      localFlutterLoader.ensureInitializationComplete(localContext, new String[0]);
      long l2 = System.currentTimeMillis();
      this.HjY = true;
      Log.i("MicroMsg.PluginFlutter", "initFlutterEngine useTime %d", new Object[] { Long.valueOf(l2 - l1) });
      AppMethodBeat.o(148844);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.PluginFlutter", localException, "failed to initFlutter", new Object[0]);
      AppMethodBeat.o(148844);
    }
  }
  
  public void initFlutterAsync(Runnable paramRunnable)
  {
    AppMethodBeat.i(263019);
    if (this.HjY)
    {
      paramRunnable.run();
      AppMethodBeat.o(263019);
      return;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      Context localContext = MMApplicationContext.getContext();
      FlutterLoader localFlutterLoader = FlutterInjector.instance().flutterLoader();
      localFlutterLoader.startInitializationAsync(localContext);
      Handler localHandler = new Handler(Looper.getMainLooper());
      localFlutterLoader.ensureInitializationCompleteAsync(localContext, new String[0], localHandler, paramRunnable);
      long l2 = System.currentTimeMillis();
      this.HjY = true;
      Log.i("MicroMsg.PluginFlutter", "initFlutterEngine useTime %d", new Object[] { Long.valueOf(l2 - l1) });
      AppMethodBeat.o(263019);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.PluginFlutter", localException, "failed to initFlutter", new Object[0]);
      paramRunnable.run();
      AppMethodBeat.o(263019);
    }
  }
  
  public boolean isInitFlutter()
  {
    return this.HjY;
  }
  
  public String name()
  {
    return "plugin-flutter";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(148842);
    this.HjX = new com.tencent.mm.plugin.flutter.b.c();
    this.HjW = new a();
    com.tencent.mm.pluginsdk.cmd.b.a(this.HjW, new String[] { "//flutter" });
    AppMethodBeat.o(148842);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148843);
    if (this.HjW != null)
    {
      com.tencent.mm.pluginsdk.cmd.b.X(new String[] { "//flutter" });
      this.HjW = null;
    }
    com.tencent.mm.plugin.flutter.b.c localc;
    if (this.HjX != null)
    {
      localc = this.HjX;
      if (!MMHandlerThread.isMainThread()) {
        break label62;
      }
      localc.onDestroy();
    }
    for (;;)
    {
      this.HjX = null;
      AppMethodBeat.o(148843);
      return;
      label62:
      MMHandlerThread.postToMainThread(new c.2(localc));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.PluginFlutter
 * JD-Core Version:    0.7.0.1
 */