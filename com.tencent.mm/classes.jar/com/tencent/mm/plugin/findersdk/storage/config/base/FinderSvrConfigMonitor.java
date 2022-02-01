package com.tencent.mm.plugin.findersdk.storage.config.base;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cx;
import com.tencent.mm.plugin.findersdk.storage.config.a.d;
import com.tencent.mm.sdk.event.IListener;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSvrConfigMonitor;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "()V", "TAG", "", "keyItemMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/IConfigItem;", "callback", "", "event", "register", "", "key", "item", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSvrConfigMonitor
  extends IListener<cx>
{
  public static final FinderSvrConfigMonitor HdJ;
  private static ConcurrentHashMap<String, WeakReference<d>> HdK;
  
  static
  {
    AppMethodBeat.i(273772);
    FinderSvrConfigMonitor localFinderSvrConfigMonitor = new FinderSvrConfigMonitor();
    HdJ = localFinderSvrConfigMonitor;
    localFinderSvrConfigMonitor.alive();
    HdK = new ConcurrentHashMap();
    AppMethodBeat.o(273772);
  }
  
  private FinderSvrConfigMonitor()
  {
    super((q)f.hfK);
    AppMethodBeat.i(273750);
    AppMethodBeat.o(273750);
  }
  
  public static void a(String paramString, d paramd)
  {
    AppMethodBeat.i(273764);
    s.u(paramString, "key");
    s.u(paramd, "item");
    if (!HdK.containsKey(paramString)) {
      ((Map)HdK).put(paramString, new WeakReference(paramd));
    }
    AppMethodBeat.o(273764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.base.FinderSvrConfigMonitor
 * JD-Core Version:    0.7.0.1
 */