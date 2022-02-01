package com.tencent.mm.plugin.emoji.magicemoji;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.v;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

@Keep
public class PluginMagicEmoji
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emoji.magicemoji.a.b
{
  private static final String TAG = "MicroMsg.PluginMagicEmoji";
  
  public void dependency()
  {
    AppMethodBeat.i(245245);
    dependsOn(com.tencent.mm.plugin.appbrand.api.c.class);
    AppMethodBeat.o(245245);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(245244);
    alias(com.tencent.mm.plugin.emoji.magicemoji.a.b.class);
    AppMethodBeat.o(245244);
  }
  
  public String name()
  {
    return "plugin-magic-emoji";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(245249);
    Log.i("MicroMsg.PluginMagicEmoji", "hy: on account initialized");
    ((v)h.ae(v.class)).jY(0);
    h.b(com.tencent.mm.plugin.emoji.magicemoji.a.a.class, new com.tencent.mm.plugin.emoji.magicemoji.b.c());
    ((v)h.ae(v.class)).ZP();
    AppMethodBeat.o(245249);
  }
  
  public void onAccountRelease() {}
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(245251);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(h.ag(com.tencent.mm.plugin.appbrand.api.c.class));
    AppMethodBeat.o(245251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji
 * JD-Core Version:    0.7.0.1
 */