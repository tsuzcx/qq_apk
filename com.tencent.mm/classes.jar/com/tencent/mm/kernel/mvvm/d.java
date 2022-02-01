package com.tencent.mm.kernel.mvvm;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/mvvm/MvvmWorkerPLC;", "Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "plugin", "Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;", "(Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;)V", "workerScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getWorkerScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "setWorkerScope", "(Lcom/tencent/mm/sdk/coroutines/LifecycleScope;)V", "onAccountInitBefore", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends e
{
  LifecycleScope mFA;
  
  public d(MvvmPlugin paramMvvmPlugin)
  {
    super(paramMvvmPlugin);
    AppMethodBeat.i(235279);
    AppMethodBeat.o(235279);
  }
  
  public final void bbx()
  {
    AppMethodBeat.i(235282);
    this.mFA = new LifecycleScope(s.X(bby().getClass().getSimpleName(), "_scope"), (q)bby(), 0, 4, null);
    AppMethodBeat.o(235282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.mvvm.d
 * JD-Core Version:    0.7.0.1
 */