package com.tencent.mm.plugin.finder.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/fts/PluginFinderFts;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/finder/fts/IPluginFinderFts;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "Companion", "plugin-finder-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderFts
  extends f
  implements com.tencent.mm.kernel.api.c, h
{
  public static final PluginFinderFts.a Bup;
  
  static
  {
    AppMethodBeat.i(330918);
    Bup = new PluginFinderFts.a((byte)0);
    AppMethodBeat.o(330918);
  }
  
  public final void execute(g paramg) {}
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(330927);
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSTaskDaemon().a(-86016, (com.tencent.mm.plugin.fts.a.a.c)new PluginFinderFts.b());
    Log.i("Plugin.PluginFinderFts", "onAccountInitialized");
    AppMethodBeat.o(330927);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(330933);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterIndexStorage(1792);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterNativeLogic(13);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(133);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(8224);
    AppMethodBeat.o(330933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.PluginFinderFts
 * JD-Core Version:    0.7.0.1
 */