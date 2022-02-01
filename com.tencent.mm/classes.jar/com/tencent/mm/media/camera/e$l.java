package com.tencent.mm.media.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class e$l
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  e$l(e parame, d<? super l> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237032);
    paramObject = (d)new l(this.ntJ, paramd);
    AppMethodBeat.o(237032);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237025);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237025);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    Log.i("MicroMsg.Camera.GLEnvBuilder", "resume");
    e.a(this.ntJ, false);
    paramObject = ah.aiuX;
    AppMethodBeat.o(237025);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.l
 * JD-Core Version:    0.7.0.1
 */