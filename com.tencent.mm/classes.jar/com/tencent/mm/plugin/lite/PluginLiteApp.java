package com.tencent.mm.plugin.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginLiteApp
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.lite.a.b
{
  private a sNS;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146365);
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.lite.a.a.class, new c());
    }
    AppMethodBeat.o(146365);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public boolean isLiteAppOpen()
  {
    return false;
  }
  
  public String name()
  {
    return "plugin-liteapp";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(146366);
    ad.d("MicroMsg.AppLite.PluginLiteApp", "onAccountInitialized");
    this.sNS = new a();
    com.tencent.mm.pluginsdk.cmd.b.a(this.sNS, new String[] { "//liteapp" });
    AppMethodBeat.o(146366);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146367);
    ad.d("MicroMsg.AppLite.PluginLiteApp", "onAccountRelease");
    if (this.sNS != null) {
      com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//liteapp" });
    }
    AppMethodBeat.o(146367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.PluginLiteApp
 * JD-Core Version:    0.7.0.1
 */