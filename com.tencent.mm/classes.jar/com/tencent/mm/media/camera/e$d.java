package com.tencent.mm.media.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.h;
import com.tencent.mm.media.camera.d.i;
import com.tencent.mm.media.camera.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
public final class e$d
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  public e$d(e parame, byte[] paramArrayOfByte, d<? super ah> paramd, d<? super d> paramd1)
  {
    super(2, paramd1);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237063);
    paramObject = (d)new d(this.ntJ, this.ntK, this.ntL, paramd);
    AppMethodBeat.o(237063);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237060);
    Object localObject1 = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237060);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      Object localObject3 = e.e(this.ntJ).nvM;
      paramObject = e.a(this.ntJ);
      localObject2 = this.ntK;
      int i = ((h)localObject3).width;
      int j = ((h)localObject3).height;
      localObject3 = (d)this;
      this.label = 1;
      if (paramObject.a((byte[])localObject2, i, j, (d)localObject3) == localObject1)
      {
        AppMethodBeat.o(237060);
        return localObject1;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = this.ntL;
    localObject1 = ah.aiuX;
    Object localObject2 = Result.Companion;
    paramObject.resumeWith(Result.constructor-impl(localObject1));
    Log.v("MicroMsg.Camera.GLEnvBuilder", "render yuv finish");
    paramObject = ah.aiuX;
    AppMethodBeat.o(237060);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.d
 * JD-Core Version:    0.7.0.1
 */