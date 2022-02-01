package com.tencent.mm.plugin.emoji.magicemoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.magicemoji.d.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginMagicEmoji
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emoji.magicemoji.a.f
{
  private static final String TAG = "MicroMsg.PluginMagicEmoji";
  
  public void dependency()
  {
    AppMethodBeat.i(269968);
    dependsOn(com.tencent.mm.plugin.appbrand.api.c.class);
    AppMethodBeat.o(269968);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(269962);
    alias(com.tencent.mm.plugin.emoji.magicemoji.a.f.class);
    AppMethodBeat.o(269962);
  }
  
  public String name()
  {
    return "plugin-magic-emoji";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(269981);
    if (MMApplicationContext.isMainProcess())
    {
      com.tencent.mm.plugin.emoji.magicemoji.d.a.dzh();
      Log.i("MicroMsg.PluginMagicEmoji", "stevecai: register magic emoji.");
      paramc = new com.tencent.mm.plugin.emoji.magicemoji.core.a(com.tencent.mm.plugin.emoji.magicemoji.d.a.xJZ);
      h.b(com.tencent.mm.plugin.emoji.magicemoji.a.b.class, paramc);
      paramc.Kl(0);
      Object localObject = new com.tencent.mm.plugin.emoji.magicemoji.monitor.c();
      h.b(com.tencent.mm.plugin.emoji.magicemoji.a.e.class, (com.tencent.mm.kernel.c.a)localObject);
      if (((com.tencent.mm.plugin.emoji.magicemoji.monitor.c)localObject).xJO)
      {
        localObject = ((com.tencent.mm.plugin.emoji.magicemoji.monitor.c)localObject).dyF();
        if (com.tencent.mm.plugin.emoji.magicemoji.d.a.a((a.c)localObject))
        {
          paramc = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
          com.tencent.mm.plugin.emoji.magicemoji.d.e.b((a.c)localObject);
          AppMethodBeat.o(269981);
          return;
        }
        paramc.dyC();
      }
    }
    AppMethodBeat.o(269981);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(269992);
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("MicroMsg.PluginMagicEmoji", "stevecai: unregister magic emoji.");
      ((com.tencent.mm.plugin.emoji.magicemoji.a.e)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.e.class)).stopMonitor();
      ((com.tencent.mm.plugin.emoji.magicemoji.a.b)h.ax(com.tencent.mm.plugin.emoji.magicemoji.a.b.class)).dyr();
    }
    AppMethodBeat.o(269992);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(269998);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).db(h.az(com.tencent.mm.plugin.appbrand.api.c.class));
    AppMethodBeat.o(269998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji
 * JD-Core Version:    0.7.0.1
 */