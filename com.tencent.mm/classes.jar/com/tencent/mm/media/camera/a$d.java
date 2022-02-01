package com.tencent.mm.media.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class a$d
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  a$d(Runnable paramRunnable, d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237083);
    paramObject = (d)new d(this.ntt, paramd);
    AppMethodBeat.o(237083);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237080);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237080);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.ntt;
    if (paramObject != null) {
      paramObject.run();
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(237080);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.camera.a.d
 * JD-Core Version:    0.7.0.1
 */