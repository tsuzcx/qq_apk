package com.tencent.mm.plugin.findersdk.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.co;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSvrConfigMonitor;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "()V", "TAG", "", "keyItemMap", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/IConfigItem;", "Lkotlin/collections/HashMap;", "callback", "", "event", "register", "", "key", "item", "finder-sdk_release"})
public final class d
  extends IListener<co>
{
  private static HashMap<String, WeakReference<com.tencent.mm.plugin.findersdk.d.a.b.d>> Bwy;
  public static final d Bwz;
  
  static
  {
    AppMethodBeat.i(210012);
    d locald = new d();
    Bwz = locald;
    locald.alive();
    Bwy = new HashMap();
    AppMethodBeat.o(210012);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.findersdk.d.a.b.d paramd)
  {
    AppMethodBeat.i(210007);
    p.k(paramString, "key");
    p.k(paramd, "item");
    if (!Bwy.containsKey(paramString)) {
      ((Map)Bwy).put(paramString, new WeakReference(paramd));
    }
    AppMethodBeat.o(210007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */