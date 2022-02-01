package com.tencent.mm.media.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class e$i
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  e$i(e parame, d<? super ah> paramd, d<? super i> paramd1)
  {
    super(2, paramd1);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237043);
    paramObject = (d)new i(this.ntJ, this.ntL, paramd);
    AppMethodBeat.o(237043);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237036);
    Object localObject = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237036);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    e.b(this.ntJ, true);
    paramObject = this.ntL;
    localObject = ah.aiuX;
    Result.Companion localCompanion = Result.Companion;
    paramObject.resumeWith(Result.constructor-impl(localObject));
    paramObject = ah.aiuX;
    AppMethodBeat.o(237036);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.i
 * JD-Core Version:    0.7.0.1
 */