package com.tencent.mm.plugin.finder.storage.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/FinderSvrConfigMonitor;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "()V", "TAG", "", "keyItemMap", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/storage/config/item/IConfigItem;", "Lkotlin/collections/HashMap;", "callback", "", "event", "register", "", "key", "item", "plugin-finder_release"})
public final class d
  extends IListener<ck>
{
  private static HashMap<String, WeakReference<com.tencent.mm.plugin.finder.storage.config.item.d>> vFG;
  public static final d vFH;
  
  static
  {
    AppMethodBeat.i(251927);
    d locald = new d();
    vFH = locald;
    locald.alive();
    vFG = new HashMap();
    AppMethodBeat.o(251927);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.storage.config.item.d paramd)
  {
    AppMethodBeat.i(251925);
    p.h(paramString, "key");
    p.h(paramd, "item");
    if (!vFG.containsKey(paramString)) {
      ((Map)vFG).put(paramString, new WeakReference(paramd));
    }
    AppMethodBeat.o(251925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.d
 * JD-Core Version:    0.7.0.1
 */