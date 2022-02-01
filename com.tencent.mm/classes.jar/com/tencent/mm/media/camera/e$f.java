package com.tencent.mm.media.camera;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.f.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
public final class e$f
  extends k
  implements m<aq, d<? super Bitmap>, Object>
{
  int label;
  
  public e$f(e parame, d<? super f> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(237051);
    paramObject = (d)new f(this.ntJ, paramd);
    AppMethodBeat.o(237051);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(237044);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(237044);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = e.a(this.ntJ).bou();
    AppMethodBeat.o(237044);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.camera.e.f
 * JD-Core Version:    0.7.0.1
 */