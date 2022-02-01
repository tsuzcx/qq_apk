package com.tencent.mm.an.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.observer.ILifecycleObserver;
import com.tencent.mm.sdk.observer.TypeLifecycleObserverOwner;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/observer/NetSceneObserverOwner;", "Lcom/tencent/mm/sdk/observer/TypeLifecycleObserverOwner;", "Lcom/tencent/mm/modelbase/observer/INetSceneObserver;", "Lcom/tencent/mm/modelbase/observer/NetSceneEvent;", "", "()V", "getAllKey", "()Ljava/lang/Integer;", "getDefaultThreadTag", "", "getLogTag", "observe", "", "key", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "threadTag", "onRemoveObserver", "type", "Companion", "mmkernel_release"})
public final class e
  extends TypeLifecycleObserverOwner<a, c, Integer>
{
  public static final e.a lDT;
  
  static
  {
    AppMethodBeat.i(195390);
    lDT = new e.a((byte)0);
    AppMethodBeat.o(195390);
  }
  
  public final void a(int paramInt, androidx.lifecycle.l paraml, String paramString, a parama)
  {
    AppMethodBeat.i(195376);
    p.k(paraml, "lifecycleOwner");
    p.k(paramString, "threadTag");
    p.k(parama, "observer");
    super.observe(Integer.valueOf(paramInt), paraml, paramString, (ILifecycleObserver)parama);
    ListenerInstanceMonitor.markInstanceRegistered(parama);
    AppMethodBeat.o(195376);
  }
  
  public final String getDefaultThreadTag()
  {
    return "Mvvm.NetSceneObserver";
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.NetSceneObserverOwnerHolder";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.an.b.e
 * JD-Core Version:    0.7.0.1
 */