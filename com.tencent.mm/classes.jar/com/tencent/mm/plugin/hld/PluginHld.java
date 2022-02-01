package com.tencent.mm.plugin.hld;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/hld/PluginHld;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "Companion", "plugin-hld_release"})
public final class PluginHld
  extends f
  implements c, d
{
  public static final a yjr;
  
  static
  {
    AppMethodBeat.i(192240);
    yjr = new a((byte)0);
    AppMethodBeat.o(192240);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(192237);
    Log.d("WxIme.WxImePlugin", "configure");
    AppMethodBeat.o(192237);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(192236);
    Log.d("WxIme.WxImePlugin", "execute");
    AppMethodBeat.o(192236);
  }
  
  public final String name()
  {
    return "plugin-hld";
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(192238);
    Log.d("WxIme.WxImePlugin", "onAccountInitialized");
    AppMethodBeat.o(192238);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(192239);
    Log.d("WxIme.WxImePlugin", "onAccountRelease");
    AppMethodBeat.o(192239);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/hld/PluginHld$Companion;", "", "()V", "CLASS", "", "TAG", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.PluginHld
 * JD-Core Version:    0.7.0.1
 */