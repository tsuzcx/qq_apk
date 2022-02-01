package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.b;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$d
  extends kotlin.d.b.a.k
  implements m<aq, d<? super Boolean>, Object>
{
  int label;
  
  c$d(ay<ah> paramay, c paramc, d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(360367);
    paramObject = (d)new d(this.CNv, this.CNu, paramd);
    AppMethodBeat.o(360367);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(360362);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(360362);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = com.tencent.mm.ui.component.k.aeZF;
    paramObject = (g)com.tencent.mm.ui.component.k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).cq(g.class);
    boolean bool2 = paramObject.dUi();
    if (bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("FinderLiveOlympicCardPl", s.X("checkLocation permissionOk: ", Boolean.valueOf(bool1)));
      if (bool2) {
        break;
      }
      paramObject = Boolean.FALSE;
      AppMethodBeat.o(360362);
      return paramObject;
    }
    long l1 = com.tencent.mm.model.cn.bDu();
    long l2 = paramObject.dUj();
    Log.i("FinderLiveOlympicCardPl", s.X("checkLocation currentTime: ", b.BF(l1 - l2)));
    paramObject = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    if (l1 - l2 < com.tencent.mm.plugin.finder.live.olympic.util.a.eop())
    {
      paramObject = Boolean.TRUE;
      AppMethodBeat.o(360362);
      return paramObject;
    }
    ((cb)this.CNv).a(null);
    this.CNu.showLoading(true);
    paramObject = v.GgU;
    bool1 = v.feW();
    AppMethodBeat.o(360362);
    return Boolean.valueOf(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.c.d
 * JD-Core Version:    0.7.0.1
 */