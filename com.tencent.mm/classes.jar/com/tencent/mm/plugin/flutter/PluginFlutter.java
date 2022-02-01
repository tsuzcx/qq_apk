package com.tencent.mm.plugin.flutter;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import io.flutter.view.FlutterMain;
import java.util.Set;

public class PluginFlutter
  extends f
  implements c, com.tencent.mm.plugin.flutter.a.b
{
  private a tsZ;
  private com.tencent.mm.plugin.flutter.b.a tta;
  private boolean ttb;
  
  private void initFlutter()
  {
    AppMethodBeat.i(148844);
    try
    {
      if (isOpenFlutter())
      {
        long l1 = System.currentTimeMillis();
        FlutterMain.startInitialization(ak.getContext());
        FlutterMain.ensureInitializationComplete(ak.getContext(), new String[0]);
        long l2 = System.currentTimeMillis();
        this.ttb = true;
        ae.i("MicroMsg.Flutter", "initFlutterEngine useTime %d", new Object[] { Long.valueOf(l2 - l1) });
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
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.flutter.a.a.class, new b());
    }
    AppMethodBeat.o(148841);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.plugin.flutter.b.a getFlutterEngineMgr()
  {
    return this.tta;
  }
  
  public boolean isInitFlutter()
  {
    return this.ttb;
  }
  
  public boolean isOpenFlutter()
  {
    return false;
  }
  
  public String name()
  {
    return "plugin-flutter";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(148842);
    this.tta = new com.tencent.mm.plugin.flutter.b.a();
    this.tsZ = new a();
    com.tencent.mm.pluginsdk.cmd.b.a(this.tsZ, new String[] { "//flutter" });
    d.gtG.add(com.tencent.mm.plugin.flutter.b.a.a.class);
    h.MqF.q(new Runnable()
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
    if (this.tsZ != null)
    {
      com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//flutter" });
      this.tsZ = null;
    }
    if (this.tta != null)
    {
      this.tta.onDestroy();
      this.tta = null;
    }
    AppMethodBeat.o(148843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.PluginFlutter
 * JD-Core Version:    0.7.0.1
 */