package com.tencent.mm.media.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.i;
import com.tencent.mm.sdk.platformtools.Log;
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
final class e$s
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  e$s(int paramInt1, int paramInt2, e parame, d<? super s> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237276);
    paramObject = (d)new s(this.aMP, this.aMQ, this.ntJ, paramd);
    AppMethodBeat.o(237276);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237271);
    Object localObject = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237271);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    Log.i("MicroMsg.Camera.GLEnvBuilder", "setPreviewSize:[" + this.aMP + ' ' + this.aMQ + ']');
    e.e(this.ntJ).eq(this.aMP, this.aMQ);
    paramObject = e.c(this.ntJ);
    if (paramObject != null)
    {
      localObject = ah.aiuX;
      Result.Companion localCompanion = Result.Companion;
      paramObject.resumeWith(Result.constructor-impl(localObject));
    }
    e.d(this.ntJ);
    paramObject = ah.aiuX;
    AppMethodBeat.o(237271);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.s
 * JD-Core Version:    0.7.0.1
 */