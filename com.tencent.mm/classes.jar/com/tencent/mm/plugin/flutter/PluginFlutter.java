package com.tencent.mm.plugin.flutter;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.flutter.b.a.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import io.flutter.view.FlutterMain;

public class PluginFlutter
  extends f
  implements c, com.tencent.mm.plugin.flutter.a.b
{
  private a wIZ;
  private com.tencent.mm.plugin.flutter.b.a wJa;
  private boolean wJb;
  
  private void initFlutter()
  {
    AppMethodBeat.i(148844);
    try
    {
      if (isOpenFlutter())
      {
        long l1 = System.currentTimeMillis();
        FlutterMain.startInitialization(MMApplicationContext.getContext());
        FlutterMain.ensureInitializationComplete(MMApplicationContext.getContext(), new String[0]);
        long l2 = System.currentTimeMillis();
        this.wJb = true;
        Log.i("MicroMsg.Flutter", "initFlutterEngine useTime %d", new Object[] { Long.valueOf(l2 - l1) });
      }
      AppMethodBeat.o(148844);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(148844);
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(148841);
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.flutter.a.a.class, new b());
    }
    AppMethodBeat.o(148841);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.flutter.b.a getFlutterEngineMgr()
  {
    return this.wJa;
  }
  
  public boolean isInitFlutter()
  {
    return this.wJb;
  }
  
  public boolean isOpenFlutter()
  {
    AppMethodBeat.i(240927);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seX, false))
    {
      AppMethodBeat.o(240927);
      return true;
    }
    AppMethodBeat.o(240927);
    return false;
  }
  
  public String name()
  {
    return "plugin-flutter";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(148842);
    this.wJa = new com.tencent.mm.plugin.flutter.b.a();
    this.wIZ = new a();
    com.tencent.mm.pluginsdk.cmd.b.a(this.wIZ, new String[] { "//flutter" });
    h.RTc.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148840);
        PluginFlutter.access$000(PluginFlutter.this);
        AppMethodBeat.o(148840);
      }
    }, 500L);
    AppMethodBeat.o(148842);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148843);
    if (this.wIZ != null)
    {
      com.tencent.mm.pluginsdk.cmd.b.V(new String[] { "//flutter" });
      this.wIZ = null;
    }
    com.tencent.mm.plugin.flutter.b.a locala;
    if (this.wJa != null)
    {
      locala = this.wJa;
      if (!MMHandlerThread.isMainThread()) {
        break label62;
      }
      locala.onDestroy();
    }
    for (;;)
    {
      this.wJa = null;
      AppMethodBeat.o(148843);
      return;
      label62:
      MMHandlerThread.postToMainThread(new a.2(locala));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.PluginFlutter
 * JD-Core Version:    0.7.0.1
 */