package com.tencent.mm.am.b;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.observer.MvvmTypeObserverOwner;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/observer/NetSceneObserverOwner;", "Lcom/tencent/mm/sdk/observer/MvvmTypeObserverOwner;", "Lcom/tencent/mm/modelbase/observer/INetSceneObserver;", "Lcom/tencent/mm/modelbase/observer/NetSceneEvent;", "", "()V", "getAllKey", "()Ljava/lang/Integer;", "getLogTag", "", "observe", "", "key", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "threadTag", "onRemoveObserver", "type", "Companion", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends MvvmTypeObserverOwner<a, c, Integer>
{
  public static final e.a ovE;
  
  static
  {
    AppMethodBeat.i(236822);
    ovE = new e.a((byte)0);
    AppMethodBeat.o(236822);
  }
  
  public final void a(int paramInt, q paramq, String paramString, a parama)
  {
    AppMethodBeat.i(236826);
    s.u(paramq, "lifecycleOwner");
    s.u(paramString, "threadTag");
    s.u(parama, "observer");
    super.observe(Integer.valueOf(paramInt), paramq, paramString, (IMvvmObserver)parama);
    ListenerInstanceMonitor.markInstanceRegistered(parama);
    AppMethodBeat.o(236826);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.NetSceneObserverOwner";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.b.e
 * JD-Core Version:    0.7.0.1
 */