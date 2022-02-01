package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/storage/Contact;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class FinderTeenModeLimitUI$b
  extends k
  implements m<aq, kotlin.d.d<? super au>, Object>
{
  int label;
  
  FinderTeenModeLimitUI$b(kotlin.d.d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(365016);
    paramObject = (kotlin.d.d)new b(paramd);
    AppMethodBeat.o(365016);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(365012);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(365012);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu();
    AppMethodBeat.o(365012);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTeenModeLimitUI.b
 * JD-Core Version:    0.7.0.1
 */