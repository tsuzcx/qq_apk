package com.tencent.mm.plugin.flutter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.r;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "Lio/flutter/embedding/engine/FlutterEngine;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class b$c
  extends k
  implements m<aq, d<? super r<? extends String, ? extends FlutterEngine>>, Object>
{
  int label;
  
  b$c(String paramString, boolean paramBoolean, kotlin.g.a.b<? super Map<String, Object>, ah> paramb, d<? super c> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(263134);
    paramObject = (d)new c(this.Hki, this.Hkj, this.Hkk, paramd);
    AppMethodBeat.o(263134);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(263125);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(263125);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = b.Hke;
      Object localObject = this.Hki;
      boolean bool = this.Hkj;
      kotlin.g.a.b localb = this.Hkk;
      d locald = (d)this;
      this.label = 1;
      localObject = paramObject.a((String)localObject, bool, localb, locald);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(263125);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    AppMethodBeat.o(263125);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.b.c
 * JD-Core Version:    0.7.0.1
 */