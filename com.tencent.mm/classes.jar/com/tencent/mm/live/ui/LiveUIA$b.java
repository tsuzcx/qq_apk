package com.tencent.mm.live.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class LiveUIA$b
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  LiveUIA$b(LiveUIA paramLiveUIA, d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(246295);
    paramObject = (d)new b(this.nkV, paramd);
    AppMethodBeat.o(246295);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(246288);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(246288);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    b.a((Activity)this.nkV, null);
    this.nkV.getSwipeBackLayout().Nl(true);
    paramObject = ah.aiuX;
    AppMethodBeat.o(246288);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA.b
 * JD-Core Version:    0.7.0.1
 */