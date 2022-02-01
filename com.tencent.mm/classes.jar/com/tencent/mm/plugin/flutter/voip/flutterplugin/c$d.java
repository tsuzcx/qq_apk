package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import com.tencent.c.j.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.voip.c.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$d
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  c$d(j.g paramg, kotlin.d.d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(263431);
    paramObject = (kotlin.d.d)new d(this.Hnk, paramd);
    AppMethodBeat.o(263431);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(263423);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(263423);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
    }
    for (;;)
    {
      try
      {
        paramObject = this.Hnk.value;
        s.s(paramObject, "arg.value");
        Object localObject = (kotlin.d.d)this;
        this.label = 1;
        paramObject = com.tencent.mm.plugin.ringtone.c.a(paramObject, true, (kotlin.d.d)localObject);
        localObject = paramObject;
        if (paramObject == locala)
        {
          AppMethodBeat.o(263423);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          localObject = paramObject;
        }
        paramObject = (com.tencent.mm.plugin.ringtone.g.d)localObject;
        if (paramObject.ODB == com.tencent.mm.plugin.ringtone.g.c.ODq) {
          continue;
        }
        localObject = b.HnG;
        b.a(paramObject);
      }
      catch (Exception paramObject)
      {
        paramObject = b.HnG;
        b.a(null);
        continue;
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(263423);
      return paramObject;
      paramObject = b.HnG;
      b.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.c.d
 * JD-Core Version:    0.7.0.1
 */