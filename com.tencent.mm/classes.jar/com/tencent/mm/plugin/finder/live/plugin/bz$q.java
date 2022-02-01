package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class bz$q
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  bz$q(ah.f<w> paramf, bz parambz, d<? super q> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(354716);
    paramObject = (d)new q(this.AWR, this.DjJ, paramd);
    AppMethodBeat.o(354716);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(354708);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(354708);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (d)this;
      this.label = 1;
      if (bb.e(1000L, paramObject) == locala)
      {
        AppMethodBeat.o(354708);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    this.AWR.aqH = w.a(this.DjJ.mJe.getContext(), (CharSequence)this.DjJ.mJe.getContext().getString(p.h.loading_tips), false, 0, null);
    paramObject = ah.aiuX;
    AppMethodBeat.o(354708);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bz.q
 * JD-Core Version:    0.7.0.1
 */