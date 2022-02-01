package com.tencent.mm.plugin.emoji.magicemoji;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.v;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.Log;

@Keep
public class PluginMagicEmoji
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emoji.magicemoji.a.b
{
  private static final String TAG = "MicroMsg.PluginMagicEmoji";
  
  public void dependency()
  {
    AppMethodBeat.i(199705);
    dependsOn(com.tencent.mm.plugin.appbrand.api.c.class);
    AppMethodBeat.o(199705);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(199704);
    alias(com.tencent.mm.plugin.emoji.magicemoji.a.b.class);
    AppMethodBeat.o(199704);
  }
  
  public String name()
  {
    return "plugin-magic-emoji";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(199706);
    Log.i("MicroMsg.PluginMagicEmoji", "hy: on account initialized");
    ((v)com.tencent.mm.kernel.g.af(v.class)).zX(0);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.emoji.magicemoji.a.a.class, new com.tencent.mm.plugin.emoji.magicemoji.b.c());
    ((v)com.tencent.mm.kernel.g.af(v.class)).Vw();
    AppMethodBeat.o(199706);
  }
  
  public void onAccountRelease() {}
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(199707);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.appbrand.api.c.class));
    AppMethodBeat.o(199707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji
 * JD-Core Version:    0.7.0.1
 */