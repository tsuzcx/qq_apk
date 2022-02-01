package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class bf$d
  extends k
  implements m<kotlinx.coroutines.aq, d<? super ah>, Object>
{
  int label;
  
  bf$d(int paramInt1, int paramInt2, d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(337648);
    paramObject = (d)new d(this.xIY, this.GWn, paramd);
    AppMethodBeat.o(337648);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(337642);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(337642);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    int i = ((com.tencent.mm.plugin.misc.a.a)h.ax(com.tencent.mm.plugin.misc.a.a.class)).gbv();
    if (this.xIY == 3) {
      h.baE().ban().set(at.a.adeF, Integer.valueOf(i));
    }
    Log.d("FinderWifiHintUIC", "[onSIMCardChange] simType:" + this.GWn + " reason:" + this.xIY + " wkType:" + i + ' ' + Thread.currentThread().getName());
    paramObject = ah.aiuX;
    AppMethodBeat.o(337642);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bf.d
 * JD-Core Version:    0.7.0.1
 */