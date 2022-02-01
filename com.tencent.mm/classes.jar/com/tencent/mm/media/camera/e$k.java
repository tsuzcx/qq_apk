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
final class e$k
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  e$k(e parame, d<? super k> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237039);
    paramObject = (d)new k(this.ntJ, paramd);
    AppMethodBeat.o(237039);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237028);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237028);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    Log.i("MicroMsg.Camera.GLEnvBuilder", "pause");
    e.a(this.ntJ, true);
    paramObject = ah.aiuX;
    AppMethodBeat.o(237028);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.k
 * JD-Core Version:    0.7.0.1
 */